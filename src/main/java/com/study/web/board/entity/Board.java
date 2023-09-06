package com.study.web.board.entity;

import java.time.LocalDateTime;

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

    public Board() {

    }

    public Board(Long boardId, String categoryName, String writer, String title, String content, int count, String boardPw, String boardRePw, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.boardId = boardId;
        this.categoryName = categoryName;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.count = count;
        this.boardPw = boardPw;
        this.boardRePw = boardRePw;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Long getBoardId() {
        return boardId;
    }
    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public String getBoardPw() {
        return boardPw;
    }
    public void setBoardPw(String boardPw) {
        this.boardPw = boardPw;
    }

    public String getBoardRePw() {
        return boardRePw;
    }
    public void setBoardRePw(String boardRePw) {
        this.boardRePw = boardRePw;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }
    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", categoryName='" + categoryName + '\'' +
                ", writer='" + writer + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", count=" + count +
                ", boardPw='" + boardPw + '\'' +
                ", boardRePw='" + boardRePw + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", modifiedAt='" + modifiedAt + '\'' +
                '}';
    }
}
