package com.study.servlet.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Category {

    private Long categoryId;
    private String categoryName;

    @Builder
    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}
