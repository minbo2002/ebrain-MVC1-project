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
<h1><%= "게시판 작성" %></h1>

<br/>

<div class="container">
    <div class="row">
        <form method="post" action="writeAction.jsp">
            <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
                <thead>
                <tr>
                    <th colspan="3" style="background-color: #eeeeee; text-align: center">게시판 등록</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>카테고리</td>
                    <td><input type="text" class="form-control" placeholder="카테고리" name="boardCategory"></td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td><input type="text" class="form-control" placeholder="작성자" name="writer" minlength="3" maxlength="5"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" class="form-control" placeholder="비밀번호" name="boardPassword" minlength="4" maxlength="16"></td>
                    <td><input type="password" class="form-control" placeholder="비밀번호 확인" name="boardRePassword" minlength="4" maxlength="16"></td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td><input type="text" class="form-control" placeholder="카테고리" name="boardTitle" minlength="4" maxlength="100"></td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td><textarea type="text" class="form-control" placeholder="카테고리" name="boarcContent" minlength="4" style="height: 350px;"></textarea></td>
                </tr>
                <tr>
                    <td>파일첨부</td>
                    <td><input type="file" class="form-control" name="boardFile"></td>
                </tr>
                </tbody>
            </table>
            <a href="boardList.jsp">취소</a>
            <input type="submit" value="저장">
        </form>
    </div>
</div>


</body>
</html>

