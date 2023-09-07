<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
    <title>boardWrite.jsp</title>
    <style>
        tr, th, td {
            text-align: center;
            background: #fff;
            border: blue;
        }
    </style>
</head>
<body>
<h1><%= "게시판 작성" %></h1>

<br/>

    <%!
        public LocalDateTime getCurrentLocalDateTime() {
            return LocalDateTime.now();
        }

        public Timestamp getCurrentTimestamp() {
            return Timestamp.valueOf(getCurrentLocalDateTime());
        }

        LocalDateTime currentLocalDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
    %>

    <div class="container">
        <div class="row">
            <form method="post" action="boardWriteAction.jsp">

                <input type="hidden" name="createdAt" value="<%= formattedDateTime %>">
                <input type="hidden" name="modifiedAt" value="<%= formattedDateTime %>">

                <input type="hidden" name="count" value="0">

                <table style="text-align: center; border: 1px solid #dddddd;">
                    <thead>
                    <tr>
                        <th colspan="3" style="background-color: #eeeeee; text-align: center">게시판 등록</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <%--<td>카테고리</td>
                        <td><input type="text" class="form-control" placeholder="카테고리" name="categoryName"></td>--%>
                        <td>카테고리</td>
                        <td>
                            <input type="radio" name="categoryName" id="category1" value="1" required="required"> <label for="category1">패션</label>
                            <input type="radio" name="categoryName" id="category2" value="2" required="required"><label for="category2">식품</label>
                            <input type="radio" name="categoryName" id="category3" value="3" required="required"> <label for="category3">가전</label>
                            <input type="radio" name="categoryName" id="category4" value="4" required="required"><label for="category4">스포츠</label>
                        </td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td><input type="text" placeholder="작성자" name="writer" minlength="3" maxlength="5"></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input type="password" placeholder="비밀번호" name="boardPw" minlength="4" maxlength="16"></td>
                        <td><input type="password" placeholder="비밀번호 확인" name="boardRePw" minlength="4" maxlength="16"></td>
                    </tr>
                    <tr>
                        <td>제목</td>
                        <td><input type="text" placeholder="카테고리" name="title" minlength="4" maxlength="100"></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td><textarea type="text" placeholder="카테고리" name="content" minlength="4" style="height: 350px;"></textarea></td>
                    </tr>
                    <tr>
                        <td>파일첨부</td>
                        <td><input type="file" name="boardFile"></td>
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

