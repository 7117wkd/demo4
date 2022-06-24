package com.example.blog_board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int boardId ;
    private String title;
    private String content;
    private String name;
    private LocalDateTime createDate;
    private String comment;
    private int count;
    private Long memberId;
    private int start;
    private int finish;
    private Timestamp time;
}
