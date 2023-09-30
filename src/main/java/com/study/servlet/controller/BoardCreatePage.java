package com.study.servlet.controller;

import com.study.servlet.dto.response.CategoryListDto;
import com.study.servlet.service.BoardService;
import com.study.servlet.service.BoardServiceImpl;
import com.study.servlet.service.CategoryService;
import com.study.servlet.service.CategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/board/createPage.do")
public class BoardCreatePage extends HttpServlet {

    private final CategoryService categoryService = new CategoryServiceImpl();
    static final Logger log = LoggerFactory.getLogger(BoardCreatePage.class);

    public BoardCreatePage() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("BoardCreatePage doGet() 실행");

        List<CategoryListDto> category = categoryService.getCategory();

        request.setAttribute("category", category);

        request.getRequestDispatcher("/view/boardCreateForm.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
