package com.example.blog_board.service;

import com.example.blog_board.domain.Board;
import com.example.blog_board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardMapper boardMapper;

    public int boardCount() {
        return boardMapper.boardCount();
    }

    public List<Board> boardList() {
        return boardMapper.getList();
    }

    public Board getBoard(int boardId) {
        return boardMapper.getBoard(boardId);
    }

    @Transactional
    public void uploadBoard(Board board) {
        boardMapper.uploadBoard(board);
    }

    @Transactional
    public void updateBoard(Board board){boardMapper.updateBoard(board);}

    @Transactional
    public void deleteBoard(int boardId){boardMapper.deleteBoard(boardId);}
    @Transactional
    public void increasementCount(int boardId) {
        boardMapper.increasementCount(boardId);
    }
    @Transactional
    public void writeBoard(Board board) {
        boardMapper.writeBoard(board);
    }

    public int getCount() {
        return boardMapper.getCount();
    }

    public List<Board> boardListPaging(int startIndex, int pageSize) {
        return boardMapper.getBoardList(startIndex, pageSize);
    }

    public int writeComment(String comment, String boardId) {
        return boardMapper.writeComment(comment, boardId);
    }

    public List<Board> getComment(int boardId) {
        return boardMapper.getComment(boardId);
    }
}
