<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ko">
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

    <style>
        #btnWrite, #btnList {
            width: 80px;
            height: 30px;
        }
    </style>

    <script>
        $(function() {
            $("#btnList").click(function() {
                location.href="<%=request.getContextPath()%>/api/board/list.do";
            });
        });

        function validatePassword() {
            const password = document.getElementsByName("boardPw")[0].value;
            const confirmPassword = document.getElementsByName("boardRePw")[0].value;

            if (password !== confirmPassword) {
                alert("1차 비밀번호와 2차 비밀번호가 일치하지 않습니다.");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>

    <h2 align="center">게시판 글쓰기 폼</h2>
    <br/><br/>

    <div id="homeDiv">
    </div>

    <form onsubmit="return validatePassword();" name="writeFrm" id="writeFrm" method="post"
          action="<%=request.getContextPath()%>/api/board/create.do" enctype="multipart/form-data">

        <input type="hidden" name="rowSize" id="rowSize" value="${rowSize}"/>

        <table border="1" style="width: 900px; margin-left: auto; margin-right: auto;">
            <tr>
                <th>카테고리</th>
                <td>
                    <select name="categoryId">
                        <c:forEach var="category" items="${category}">
                            <option value="${category.categoryId}">${category.categoryName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>
                    <input type="text" name="author" id="author" minlength="3" maxlength="4" required="required"/>
                    <span class="error"><c:if test="${errors.title}">작성자를 입력하세요</c:if></span>
                </td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td>
                    1차:<input type="password" name="boardPw" minlength="4" maxlength="16" pattern="^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{4,16}$" required="required"/>
                    2차:<input type="password" name="boardRePw" minlength="4" maxlength="16" pattern="^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{4,16}$" required="required"/>
                    <span class="error"><c:if test="${errors.title}">비밀번호를 입력하세요</c:if></span>
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" name="publisher" id="publisher" required="required"/>
                    <span class="error"><c:if test="${errors.title}">제목을 입력하세요</c:if></span>
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                        <textarea name="rContent" id="rContent" rows="7" cols="100" minlength="4" maxlength="100"
                                  style="width: 600px; height: 200px"
                                  placeholder="타인을 배려하는 마음으로 작성하세요. &#10;이용약관 및 법률에 따라 처벌 받을 수 있습니다." required="required"></textarea>
                    <span class="error"><c:if test="${errors.content}">내용을 입력하세요</c:if></span>
                </td>
            </tr>
            <tr>
                <th>이미지 첨부</th>
                <td>
                    <input type="file" name="filename" id="filename" />
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
                <td colspan="3" style="text-align:center;">
                    <input type="submit" value="글쓰기" id="btnWrite">
                    <input type="button" value="목록 이동" id="btnList">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
