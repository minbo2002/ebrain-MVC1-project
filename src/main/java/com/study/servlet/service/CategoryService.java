package com.study.servlet.service;

import com.study.servlet.dto.response.CategoryListDto;

import java.util.List;

public interface CategoryService {

    List<CategoryListDto> getCategory();
}
