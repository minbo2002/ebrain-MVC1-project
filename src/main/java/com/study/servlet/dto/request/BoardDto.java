package com.study.servlet.dto.request;

import com.study.servlet.vo.BoardFile;
import lombok.*;

import java.util.Map;

@Getter
@ToString
@NoArgsConstructor
public class BoardDto {

    private Long categoryId;
    private String writer;
    private String title;
    private String content;
    private String boardPw;
    private String boardRePw;
    private BoardFile boardFile;

    @Builder
    public BoardDto(Long categoryId, String writer, String title, String content, String boardPw, String boardRePw, BoardFile boardFile) {
        this.categoryId = categoryId;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.boardPw = boardPw;
        this.boardRePw = boardRePw;
        this.boardFile = boardFile;
    }

    // 유효성검사 - 필수입력체크
    public void validate(Map<String, Boolean> errors) {
        if( categoryId==null) {
            errors.put("categoryId", Boolean.TRUE);
        }
        if( writer==null || writer.isEmpty() || writer.length() < 3 || writer.length() >= 5 ) {
            errors.put("writer", Boolean.TRUE);
        }
        if(title==null || title.isEmpty() || title.length() < 4 || title.length() >= 100) {
            errors.put("title", Boolean.TRUE);
        }
        if( content==null || content.isEmpty() || content.length() < 4 || content.length() >= 200) {
            errors.put("content", Boolean.TRUE);
        }
        if( boardPw==null || boardPw.isEmpty() || boardPw.length() < 4 || boardPw.length() >= 16) {
            errors.put("boardPw", Boolean.TRUE);
        }
        if( boardRePw==null || boardRePw.isEmpty() || boardRePw.length() < 4 || boardRePw.length() >= 16) {
            errors.put("boardRePw", Boolean.TRUE);
        }
    }

}
