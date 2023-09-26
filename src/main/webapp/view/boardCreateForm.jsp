<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ko">
<html>
<head>
    <title>Title</title>

    <style>
        #btnWrite, #btnList {
            width: 80px;
            height: 30px;
        }
    </style>

    <script>
        $(function() {
            $("#btnList").click(function() {
                location.href="<%=request.getContextPath()%>/api/board/list.do?rowSize=${rowSize}";
            });
        });
    </script>
</head>

<body>

    <h2 align="center">추천 게시판 글쓰기</h2>
    <br/><br/>

    <div id="homeDiv">
    </div>

    <form name="writeFrm" id="writeFrm" method="post" action="<%=request.getContextPath()%>/api/board/create.do" enctype="multipart/form-data">

        <input type="hidden" name="rowSize" id="rowSize" value="${rowSize}"/>

        <table border="1" style="width: 900px; margin-left: auto; margin-right: auto;">
            <tr>
                <th>카테고리</th>
                <td>
                    <input type="text" name="bookTitle" id="bookTitle" required="required"/>
                    <span class="error"><c:if test="${errors.title}">책 제목을 입력하세요</c:if></span>
                </td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>
                    <input type="text" name="author" id="author" required="required"/>
                    <span class="error"><c:if test="${errors.title}">저자를 입력하세요</c:if></span>
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" name="publisher" id="publisher" required="required"/>
                    <span class="error"><c:if test="${errors.title}">출판사 입력하세요</c:if></span>
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                        <textarea name="rContent" id="rContent" rows="7" cols="100"
                                  style="width: 600px; height: 200px"
                                  placeholder="타인을 배려하는 마음으로 작성하세요. &#10;이용약관 및 법률에 따라 처벌 받을 수 있습니다." required="required"></textarea>
                    <span class="error"><c:if test="${errors.content}">내용을 입력하세요</c:if></span>
                </td>
            </tr>
            <tr>
                <th>책이미지 첨부</th>
                <td>
                    <input type="file" name="filename" id="filename" style="display: none"/>
                    <label for="filename" class="fileButton">업로드</label>
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" name="rTitle" id="rTitle" required="required"/>
                    <span class="error"><c:if test="${errors.title}">제목을 입력하세요</c:if></span>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;">
                    <input type="submit" value="글쓰기" id="btnWrite">
                    <input type="button" value="목록 이동" id="btnList">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
