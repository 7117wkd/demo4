package com.example.blog_board.mapper;

import com.example.blog_board.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    int boardCount();

    List<Board> getList();

    Board getBoard(int boardId);

    void uploadBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(int boardId);

    void increasementCount(int boardId);

    void writeBoard(Board board);

    int getCount();

    List<Board> getBoardList(int startIndex, int pageSize);

    int writeComment(String comment, String boardId);

    List<Board> getComment(int boardId);
}
