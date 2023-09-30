package com.study.servlet.service;

import com.study.common.SessionTemplate;
import com.study.servlet.dao.BoardDao;
import com.study.servlet.dao.CategoryDao;
import com.study.servlet.dto.response.BoardListDto;
import com.study.servlet.dto.response.BoardPage;
import com.study.servlet.dto.response.CategoryListDto;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{

    private final CategoryDao categoryDao = new CategoryDao();
    static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Override
    public List<CategoryListDto> getCategory() {

        SqlSession session = null;
        List<CategoryListDto> categoryList;

        try {
            session = SessionTemplate.getSession();

            categoryList = categoryDao.categoryList(session);
            log.info("카테고리 리스트 : {}", categoryList);

        }finally {
            if(session!=null) {
                session.close();
            }
        }

        return categoryList;
    }
}
