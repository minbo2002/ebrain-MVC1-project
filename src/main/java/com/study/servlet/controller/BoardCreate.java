package com.study.servlet.controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.study.servlet.dto.request.BoardDto;
import com.study.servlet.service.BoardService;
import com.study.servlet.service.BoardServiceImpl;
import com.study.servlet.vo.BoardFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/board/create.do")
public class BoardCreate extends HttpServlet {

    private final BoardService boardService = new BoardServiceImpl();
    static final Logger log = LoggerFactory.getLogger(BoardCreate.class);

    public BoardCreate() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 현재 프로젝트의 루트디렉토리 가져오기
        String uploadPath = System.getProperty("user.dir") + "/uploadImage";

//        String uploadPath = this.getClass().getResource("").getPath();
//        uploadPath = uploadPath.substring(1, uploadPath.indexOf(".metadata")) +
//                ".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\project\\uploadImage";

        log.info("uploadPath = {}", uploadPath);  // 저장경로에 이미지 저장됨

        int maxSize = 1024 * 1024 * 100;
        String encoding = "UTF-8";

        MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath, maxSize, encoding, new DefaultFileRenamePolicy());

//        int pageNo = 1;
//        int rowSize = 10;  // 기본값을 10으로 설정
//        String strPageNo = multipartRequest.getParameter("pageNo");
//        String strRowSize = multipartRequest.getParameter("rowSize");

        String strCategoryId = multipartRequest.getParameter("categoryId");
        Long categoryId = null;
        if (strCategoryId != null && !strCategoryId.isEmpty()) {
            try {
                categoryId = Long.parseLong(strCategoryId);
            } catch (NumberFormatException e) {
                // strCategoryId Long으로 변환할 수 없는 경우 예외 처리
                // 이때 categoryId는 여전히 null로 설정됨
            }
        }

        String writer = multipartRequest.getParameter("writer");
        String title = multipartRequest.getParameter("title");
        String content = multipartRequest.getParameter("content");
        String boardPw = multipartRequest.getParameter("boardPw");
        String boardRePw = multipartRequest.getParameter("boardRePw");
        String fileOriName = multipartRequest.getOriginalFileName("filename");   // finename : 사용자가 올린 파일 이름
        String fileName = multipartRequest.getFilesystemName("filename"); // fileRealName : DB에 저장되는 이름 (중복방지)

//        pageNo = getPageNo(strPageNo, pageNo);
//        rowSize = getRowSize(rowSize, strRowSize);
//
//        BoardPage boardPage = boardService.getBoard( pageNo, rowSize, "", "");

        //유효성검사를 위한 errors 객체 생성
        Map<String, Boolean> errors = new HashMap<String, Boolean>();

        BoardDto boardDto = BoardDto.builder()
                                .categoryId(categoryId)
                                .writer(writer)
                                .title(title)
                                .content(content)
                                .boardPw(boardPw)
                                .boardRePw(boardRePw)
                                .boardFile(BoardFile.builder()
                                                    .fileOriName(fileOriName)
                                                    .fileName(fileName)
                                                    .build())
                                .build();

        boardDto.validate(errors);
        request.setAttribute("errors", errors);

        if(!errors.isEmpty()) {
//            request.setAttribute("rowSize", rowSize);
            request.getRequestDispatcher("/view/createBoardForm.jsp").forward(request, response);
        }

        // 2. 비지니스 로직 수행 <-> Serivce <-> DAO <-> DB
        int cnt = boardService.createBoard(boardDto);
        log.info("생성된 게시판 개수 = {}", cnt);

        // 3. Model
//        request.setAttribute("boardPage", boardPage);
//        request.setAttribute("rowSize", rowSize);
//        request.setAttribute("uploadPath", uploadPath);

        // 4. View
        response.sendRedirect(request.getContextPath()+"/api/board/list.do");
    }


//    private int getPageNo(String strPageNo, int pageNo) {
//        if (strPageNo != null && !strPageNo.isEmpty()) {
//            try {
//                pageNo = Integer.parseInt(strPageNo);
//
//            } catch (NumberFormatException e) {
//                // rowSize가 정수로 변환할 수 없는 경우에 대한 처리
//                log.error("pageNo를 정수로 변환할 수 없습니다. 기본값 1을 사용합니다.");
//            }
//        }
//        return pageNo;
//    }
//
//    private int getRowSize(int rowSize, String strRowSize) {
//        if (strRowSize != null && !strRowSize.isEmpty()) {
//            try {
//                rowSize = Integer.parseInt(strRowSize);
//
//            } catch (NumberFormatException e) {
//                // rowSize가 정수로 변환할 수 없는 경우에 대한 처리
//                log.error("rowSize를 정수로 변환할 수 없습니다. 기본값 10을 사용합니다.");
//            }
//        }
//        return rowSize;
//    }
}
