package com.study.servlet.dao;

import com.study.servlet.dto.response.CategoryListDto;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CategoryDao {

    static final Logger log = LoggerFactory.getLogger(CategoryDao.class);

    public List<CategoryListDto> categoryList(SqlSession session) {

        return session.selectList("category.list");
    }
}
