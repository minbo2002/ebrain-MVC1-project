package com.study.servlet.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardFile {

    private Long fileId;		// 파일번호(PK)
    private String fileOriName;	// 원본 파일명
    private String fileName;	// 서버에 저장되는 파일명
    private Long boardId;		// 게시판번호(FK)

    @Builder
    public BoardFile(Long fileId, String fileOriName, String fileName, Long boardId) {
        this.fileId = fileId;
        this.fileOriName = fileOriName;
        this.fileName = fileName;
        this.boardId = boardId;
    }

    @Builder
    public BoardFile(String fileOriName, String fileName, Long boardId) {
        this.fileOriName = fileOriName;
        this.fileName = fileName;
        this.boardId = boardId;
    }

    @Builder
    public BoardFile(String fileOriName, String fileName) {
        this.fileOriName = fileOriName;
        this.fileName = fileName;
    }
}
