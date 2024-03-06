<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메뉴 정보</title>
</head>
<body>
    <h1>${ param.menuName }번 메뉴의 정보</h1>
    <h4>메뉴명 : ${ selectedMenu.menuName }</h4>
    <h4>메뉴 코드 : ${ selectedMenu.menuCode}</h4>
    <h4>메뉴 가격 : ${ selectedMenu.menuPrice }</h4>
</body>
</html>
