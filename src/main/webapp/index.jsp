<%@ page import="com.study.connection.ConnectionTest" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "메인 화면" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>


<%

    ConnectionTest t = new ConnectionTest();
    out.println(t.getConnection());

%>

    <div>
        <ul>
            <li><a href="boardList.jsp">게시판 목록</a></li>
            <li><a href="boardDetail.jsp">게시판 상세보기</a></li>
            <li><a href="boardWrite.jsp">게시판 등록</a></li>
            <li><a href="boardModify.jsp">게시판 수정</a></li>
        </ul>
    </div>

</body>
</html>
