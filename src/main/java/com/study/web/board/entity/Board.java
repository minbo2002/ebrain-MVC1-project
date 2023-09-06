package com.study.web.board.entity;

import com.study.web.category.entity.Category;

public class Board {

    private Long boardId;
    private String category_name;
    private String writer;
    private String title;
    private String content;
    private int count;
    private String boardPw;
    private String createdAt;
    private String modifiedAt;

    public Board() {

    }

    public Board(Long boardId, String category_name, String writer, String title, String content, int count, String boardPw, String createdAt, String modifiedAt) {
        this.boardId = boardId;
        this.category_name = category_name;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.count = count;
        this.boardPw = boardPw;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Long getBoardId() {
        return boardId;
    }
    public void setBoardId(Long boardId) {
        this.boardId = boardId;
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

    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }
    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCategory_name() {
        return category_name;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", category_name='" + category_name + '\'' +
                ", writer='" + writer + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", count=" + count +
                ", boardPw='" + boardPw + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", modifiedAt='" + modifiedAt + '\'' +
                '}';
    }
}
