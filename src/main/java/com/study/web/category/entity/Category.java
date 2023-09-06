package com.study.web.category.entity;

public class Category {

    private Long categoryId;
    private String category_name;

    public Category() {

    }

    public Category(String category_name) {
        this.category_name = category_name;
    }

    public Category(Long categoryId, String category_name) {
        this.categoryId = categoryId;
        this.category_name = category_name;
    }

    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory_name() {
        return category_name;
    }
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
