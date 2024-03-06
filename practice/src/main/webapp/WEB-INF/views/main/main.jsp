<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>

    <h1>menu_name 이용하여 메뉴 정보 조회해오기</h1>
    <form action="${pageContext.servletContext.contextPath}/menu/select">
        <label>조회할 메뉴명 : </label>
        <input type="text" name="menuName" id="menuName">
        <button>조회하기</button>
    </form>

    <h1>메뉴 정보 조회</h1>
    <button onclick="location.href='${pageContext.servletContext.contextPath}/menu/list'">
        메뉴 정보 전체 조회하기
    </button>

    <h1> 신규 메뉴 정보 추가</h1>
    <form action="${ pageContext.servletContext.contextPath }/menu/insert" method="post">
        메뉴코드 : <input type="text" name="menuCode"><br>
        메뉴 명 : <input type="text" name="menuName"><br>
        메뉴 가격 : <input type="text" name="menuPrice"><br>


        <button type="submit">등록하기</button>
    </form>

    <h1>메뉴명 수정</h1>
    <form action="${ pageContext.servletContext.contextPath }/menu/update" method="post">
        변경할 메뉴코드 : <input type="text" name="menuCode"/>
       변경할 메뉴 명 : <input type="text" name="menuName"/>
        변경할 메뉴 가격 : <input type="text" name="menuPrice"/>


        <button type="submit">메뉴 변경</button>
    </form>

    <h1>메뉴 정보 삭제</h1>
    <form action="${ pageContext.servletContext.contextPath }/menu/delete" method="post">
        메뉴 명 : <input type="text" name="menuName"/>
        <button type="submit">메뉴 정보 삭제</button>
    </form>

</body>
</html>
