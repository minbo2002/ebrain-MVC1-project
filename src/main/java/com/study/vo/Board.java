package com.study.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Board {

    private Long boardId;
    private String categoryName;
    private String writer;
    private String title;
    private String content;
    private int count;
    private String boardPw;
    private String boardRePw;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
