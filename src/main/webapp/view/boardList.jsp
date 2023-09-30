<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

    <style>
        #searchDiv, #tableDiv, #homeDiv {
            text-align: center;
        }
        table {
            border-collapse: separate;
            border-spacing: 0;
            width: 100%;
            margin: auto;
        }
    </style>

    <script>
        $(function() {
            $("#btnMain").click(function() {
                location.href="<%=request.getContextPath()%>/index.jsp";
            });
            $("#btnWrite").click(function() {
                location.href="<%=request.getContextPath()%>/api/board/createPage.do?rowSize=${rowSize}";
            });
        });
    </script>
</head>
<body>

<h2 style="text-align: center">게시판 목록</h2>

<br/>
<div id="searchDiv">
    <form name="frm" method="get" action="<%=request.getContextPath()%>/api/board/list.do">
        조회조건 :
        <select name="searchOption">
            <option value="">-----</option>
            <option value="category">카테고리</option>
            <option value="title">제목</option>
            <option value="content">내용</option>
        </select> <br/>

        페이지당 게시물 개수 :
        <select name="rowSize" id="rowSize">
            <option value="10">선택</option>
            <option value="3">3</option>
            <option value="5">5</option>
            <option value="10">10</option>
        </select> <br/>

        <input type="text" name="searchWord" value="" placeholder="특수문자는 사용 불가능">
        <button type="submit">검색</button>
    </form>
</div>

<br/><br/>
<div id="homeDiv">
    <input type="button" value="등록" id="btnWrite">
</div>


<div id="tableDiv">
    <table border="1" style="width: 1200px;">
        <thead>
        <tr>
            <th>글 번호</th>
            <th>카테고리</th>
            <th>작성자</th>
            <th>제목</th>
            <th>내용</th>
            <th>조회수</th>
            <th>작성일</th>
            <th>수정일</th>
        </tr>
        </thead>
        <tbody>
        <%-- 게시글이 없는 경우 --%>
        <c:if test="${boardPage.hasNoBoards()}">
            <tr>
                <td colspan="6" style="text-align: center;">게시글이 없습니다</td>
            </tr>
        </c:if>

        <%-- 게시글이 있는 경우 --%>
        <c:if test="${boardPage.hasBoards()}">
            <c:forEach var="board" items="${boardPage.list}">
                <tr>
                    <td>${board.boardId}</td>
                    <td>${board.categoryName}</td>
                    <td>${board.writer}</td>
                    <td><a href="">${board.title}</a></td>
                    <td>${board.content}</td>
                    <td>${board.count}</td>
                    <td>
                        <fmt:parseDate value="${board.createdAt}"
                                       pattern="yyyy-MM-dd'T'HH:mm" var="createdAt" type="both" />
                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${createdAt}" />
                    </td>
                    <td>
                        <fmt:parseDate value="${board.modifiedAt}"
                                       pattern="yyyy-MM-dd'T'HH:mm" var="modifiedAt" type="both" />
                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${modifiedAt}" />
                    </td>
                </tr>
            </c:forEach>
        </c:if>

        <%-- paging 처리 --%>
        <tr>
            <td colspan="8" style="text-align: center;">
                <%-- JSTL if조건문 : 이전출력 --%>
                <c:if test="${boardPage.startPage > 5}">
                    <a href="/api/board/list.do?pageNo=${boardPage.startPage-5}&rowSize=${rowSize}">prev</a>
                </c:if>

                <%-- JSTL forEach조건문 : 페이지번호출력 --%>
                <c:forEach var="pageNo" begin="${boardPage.startPage}" end="${boardPage.endPage}">
                    <a href="/api/board/list.do?pageNo=${pageNo}&rowSize=${rowSize}">${pageNo}</a>
                </c:forEach>

                <%-- JSTL if조건문 : 다음출력 --%>
                <c:if test="${boardPage.endPage < boardPage.totalPages}">
                    <a href="/api/board/list.do?pageNo=${boardPage.startPage+5}&rowSize=${rowSize}">next</a>
                </c:if>
            </td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>