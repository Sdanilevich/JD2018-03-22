 <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <%@ include file="include/menuOrder.htm" %>
    <p style = "color:#800000">Пользователь: ${user.name} Права:${userRole}</p>
        <h2>Список заказов всех пользователей</h2>

    <%@ include file="listordershort.jsp" %>
</div>
</div>
</body>
</html>
