<%@ page import="com.study.web.board.dao.BoardDao" %>
<%@ page import="com.study.web.board.entity.Board" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
  <h1><%= "게시판 목록" %></h1>
  <style type="text/css">
    a, a:hover {
      color: #000000;
      text-decoration: none;
    }
  </style>
<br/>

  <%
    int pageNumber = 1;  // 기본페이지
    if(request.getParameter("pageNumber") != null) {
      pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
    }
  %>

  <div class="container">
    <div class="row">
      <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
        <thead>
          <tr>
            <th style="background-color: #eeeeee; text-align: center">카테고리</th>
            <th style="background-color: #eeeeee; text-align: center">제목</th>
            <th style="background-color: #eeeeee; text-align: center">작성자</th>
            <th style="background-color: #eeeeee; text-align: center">조회수</th>
            <th style="background-color: #eeeeee; text-align: center">등록 일시</th>
            <th style="background-color: #eeeeee; text-align: center">수정 일시</th>
          </tr>
        </thead>
        <tbody>
          <%
            BoardDao boardDao = new BoardDao();
            ArrayList<Board> boardList = boardDao.getList(pageNumber);
            for (Board board : boardList) {
          %>
            <tr>
                <td><%= board.getCategory_name() %></td>
                <td><a href="boardDetail.jsp?boardId=<%= board.getBoardId() %>"><%= board.getTitle() %></a></td>
                <td><%= board.getWriter() %></td>
                <td><%= board.getCount() %></td>
                <td><%= board.getCreatedAt().substring(0, 11) + board.getCreatedAt().substring(11, 13) + "시 " + board.getCreatedAt().substring(14, 16) + "분" %></td>
                <td><%= board.getModifiedAt().substring(0, 11) + board.getModifiedAt().substring(11, 13) + "시 " + board.getModifiedAt().substring(14, 16) + "분" %></td>
            </tr>
          <%
            }
          %>
        </tbody>
      </table>
          <%
            if (pageNumber != 1) {
          %>
            <a href="boardList.jsp?pageNumber=<%= pageNumber - 1 %>">이전</a>
          <%
            } if (boardDao.nextPage(pageNumber + 1)) {
          %>
            <a href="boardList.jsp?pageNumber=<%= pageNumber + 1 %>">다음</a>
          <%
            }
          %>

      <a href="boardWrite.jsp" class="btn btn-primary pull-right">등록</a>

    </div>
  </div>

</body>
</html>

