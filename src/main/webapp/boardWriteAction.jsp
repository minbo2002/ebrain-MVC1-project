<%@ page import="com.study.web.board.dao.BoardDao" %>
<%@ page import="com.study.web.board.entity.Board" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="java.time.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<jsp:useBean id="board" class="com.study.web.board.entity.Board" scope="page" />
<jsp:setProperty name="board" property="*" />

<%--
<jsp:setProperty name="board" property="categoryName" />
<jsp:setProperty name="board" property="writer" />
<jsp:setProperty name="board" property="boardPw" />
<jsp:setProperty name="board" property="boardRePw" />
<jsp:setProperty name="board" property="title" />
<jsp:setProperty name="board" property="content" />
<jsp:setProperty name="board" property="createdAt" />
<jsp:setProperty name="board" property="modifiedAt" />
<jsp:setProperty name="board" property="boardFile" />
--%>
<!DOCTYPE html>
<html>
<head>
    <title>boardWriteAction.jsp</title>
</head>
<body>
    <%
      if(board.getCategoryName() == null || board.getWriter() == null || board.getTitle() == null || board.getContent() == null || board.getBoardPw() == null || board.getBoardRePw() == null) {

          PrintWriter script = response.getWriter();
          script.println("<script>");
          script.println("alert('입력되지 않은 값이 있습니다.')");
          script.println("history.back()");
          script.println("</script>");

      } else {

          PrintWriter scripts = response.getWriter();
          scripts.println("<script>");
          scripts.println("alert('문제발생')");
          scripts.println("history.back()");
          scripts.println("</script>");

          System.out.println("categoryName : " + board.getCategoryName());
          System.out.println("categoryName -> categoryId : " + Long.parseLong(board.getCategoryName()));
          System.out.println("writer : " + board.getWriter());
          System.out.println("title : " + board.getTitle());
          System.out.println("content : " + board.getContent());
          System.out.println("boardPw : " + board.getBoardPw());
          System.out.println("boardRePw : " + board.getBoardRePw());

          System.out.println("boardCount : " + board.getCount());
          System.out.println("createdAt : " + String.valueOf(board.getCreatedAt()));
          System.out.println("modifiedAt : " + String.valueOf(board.getModifiedAt()));

          BoardDao boardDao = new BoardDao();

          int result = boardDao.write(Long.parseLong(board.getCategoryName()),
                                      board.getWriter(),
                                      board.getTitle(),
                                      board.getContent(),
                                      board.getCount(),
                                      board.getBoardPw(),
                                      board.getBoardRePw(),
                                      String.valueOf(board.getCreatedAt()),
                                      String.valueOf(board.getModifiedAt()));

          if(result == -1) {
              PrintWriter script = response.getWriter();
              script.println("<script>");
              script.println("alert('게시판 생성에 실패 했습니다..');");
              script.println("history.back();");
              script.println("</script>");

          }else {
              PrintWriter script = response.getWriter();
              script.println("<script>");
              script.println("location.href = 'boardList.jsp';");
              script.println("</script>");
          }

      }
    %>
</body>
</html>

