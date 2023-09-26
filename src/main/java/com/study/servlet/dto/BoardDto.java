package com.study.servlet.dto;

import com.study.servlet.vo.BoardFile;
import lombok.*;

import java.util.Map;

@Getter
@ToString
@NoArgsConstructor
public class BoardDto {

    private String categoryName;
    private String writer;
    private String title;
    private String content;
    private String boardPw;
    private String boardRePw;
    private BoardFile boardFile;

    @Builder
    public BoardDto(String categoryName, String writer, String title, String content, String boardPw, String boardRePw, BoardFile boardFile) {
        this.categoryName = categoryName;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.boardPw = boardPw;
        this.boardRePw = boardRePw;
        this.boardFile = boardFile;
    }

    // 유효성검사 - 필수입력체크

    public void validate(Map<String, Boolean> errors) {
        if( categoryName==null || categoryName.isEmpty() ) {
            errors.put("categoryName", Boolean.TRUE);
        }
        if( writer==null || writer.isEmpty()) {
            errors.put("writer", Boolean.TRUE);
        }
        if( title==null || title.isEmpty()) {
            errors.put("title", Boolean.TRUE);
        }
        if( content==null || content.isEmpty()) {
            errors.put("content", Boolean.TRUE);
        }
        if( boardPw==null || boardPw.isEmpty()) {
            errors.put("boardPw", Boolean.TRUE);
        }
        if( boardRePw==null || boardRePw.isEmpty()) {
            errors.put("boardRePw", Boolean.TRUE);
        }
    }

}
