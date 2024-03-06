<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>메뉴 목록 전체 조회</title>
</head>
<body>
    <h1>메뉴 목록 전체 조회</h1>
    <table>
        <tr>
            <th>메뉴코</th>
            <th>메뉴명</th>
            <th>메뉴가격</th>

        </tr>
        <c:forEach items="${ menuList }" var="menu">
            <tr>
                <td>${ menu.menuCode}</td>
                <td>${ menu.menuName }</td>
                <td>${ menu.menuPrice}</td>

            </tr>
        </c:forEach>
    </table>
</body>
</html>
