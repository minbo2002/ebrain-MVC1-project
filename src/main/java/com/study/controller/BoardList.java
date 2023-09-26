package com.study.controller;

import com.study.dto.BoardPage;
import com.study.service.BoardService;
import com.study.service.BoardServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/board/list.do")
public class BoardList extends HttpServlet {

    private final BoardService boardService = new BoardServiceImpl();

    static final Logger log = LoggerFactory.getLogger(BoardList.class);

    public BoardList() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // pageNo : 보고싶은 페이지
        String strPageNo = request.getParameter("pageNo");
        int pageNo = 1;
//        if(strPageNo!=null) {
//            pageNo = Integer.parseInt(strPageNo);
//        }
        if (strPageNo != null && !strPageNo.isEmpty()) {
            try {
                pageNo = Integer.parseInt(strPageNo);
                if (pageNo <= 0) {
                    pageNo = 1;
                }

            } catch (NumberFormatException e) {
                // rowSize가 정수로 변환할 수 없는 경우에 대한 처리
                log.error("pageNo를 정수로 변환할 수 없습니다. 기본값 1을 사용합니다.");
            }
        }

        String strRowSize = request.getParameter("rowSize");
        int rowSize = 10;  // 기본값을 10으로 설정
        if (strRowSize != null && !strRowSize.isEmpty()) {
            try {
                rowSize = Integer.parseInt(strRowSize);
                if (rowSize <= 0) {
                    rowSize = 10;
                }

            } catch (NumberFormatException e) {
                // rowSize가 정수로 변환할 수 없는 경우에 대한 처리
                log.error("rowSize를 정수로 변환할 수 없습니다. 기본값 10을 사용합니다.");
            }
        }

        // 조회조건
        String searchOption = request.getParameter("searchOption");
        if(searchOption==null) {
            searchOption="";
        }

        // 검색어
        String searchWord = request.getParameter("searchWord");
        if(searchWord==null) {
            searchWord="";
        }

        log.info("조회 조건 = "+searchOption);
        log.info("검색어 = "+searchWord);
        log.info("보고싶은 페이지 = "+pageNo);
        log.info("한페이지당 게시물 개수 = "+rowSize);

        BoardPage boardPage = boardService.getBoard(pageNo, rowSize, searchOption, searchWord);

        // 3. Model
        request.setAttribute("boardPage", boardPage);
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("rowSize", rowSize);
        request.setAttribute("searchOption", searchOption);
        request.setAttribute("searchWord", searchWord);

        request.getRequestDispatcher("/view/boardList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
