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

    <div>
        <ul>
<%--            <li><a href="view/boardList.jsp">게시판 목록이동</a></li>--%>
            <li><a href="<%=request.getContextPath()%>/api/board/list.do">게시판 목록이동</a></li>
        </ul>
    </div>

</body>
</html>
