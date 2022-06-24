package com.example.blog_board.controller;

import com.example.blog_board.domain.Board;
import com.example.blog_board.domain.Pagination;
import com.example.blog_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/hello")
    public String Hello() {
        return "/boards/hello";
    }

    @GetMapping("/write")
    public String write() {
        return "/boards/write";
    }

    @GetMapping("/login")
    public String test(Model model) {
        model.addAttribute("cnt", service.boardCount());
        model.addAttribute("test", service.boardList());
        return "/boards/login";
    }

    @GetMapping("/main")
    public String main(Model model, @RequestParam(defaultValue = "1") int page) {

        //총 게시물 수
        int totalListCnt = service.getCount();

        // 생성인자로 총 게시물 수, 현재 페이지를 전달
        Pagination pagination = new Pagination(totalListCnt, page);

        // DB select start index
        int startIndex = pagination.getStartIndex();
        // 페이지 당 보여지는 게시글의 최대 개수
        int pageSize = pagination.getPageSize();

        //게시판 리스트 불러오기기
        List<Board> boardList = service.boardListPaging(startIndex, pageSize);

        model.addAttribute("list", boardList);
        model.addAttribute("pagination", pagination);

        return "/boards/main";
    }

    @GetMapping("/view")
    public String viewBoard(Model model, int boardId) {
        //조회수 증가
        service.increasementCount(boardId);
        model.addAttribute("view", service.getBoard(boardId));
        model.addAttribute("contents", service.getComment(boardId));
        return "/boards/view";
    }

    @GetMapping("/upload")
    public String uploadBoardForm(){
        return "/boards/upload";
    }

    @PostMapping("/upload")
    public String uploadBoard(Board board){
        service.uploadBoard(board);
        return "redirect:/board/main";
    }

    @PostMapping("/write")
    public String writeBoard(Board board){
        service.writeBoard(board);
        return "redirect:/board/main";
    }

    @PutMapping("/update")
    public String updateBoard(Board board){
        service.updateBoard(board);
        return "redirect:/board/main";
    }

    @DeleteMapping("/delete")
    public String deleteBoard(int boardId){
        service.deleteBoard(boardId);
        return "redirect:/board/main";
    }

    @ResponseBody
    @RequestMapping(value="/comment", method={RequestMethod.POST})
    @Transactional(readOnly = false)
    public int writeComment(@RequestParam("comment") String comment, @RequestParam("boardId") String boardId){
        int answer = service.writeComment(comment, boardId);
        return answer;
    }
}
