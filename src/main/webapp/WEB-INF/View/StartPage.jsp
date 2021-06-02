
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Информация о сделках</h2>
        
        <c:forEach var = "deal" items = "${requestScope.deals}">
            
            <ul>
                 
                Имя агента: <c:out value="${deal.name}"/>,
                Дата: <c:out value="${deal.date}"/>,
                Номер сделки: <c:out value="${deal.id}"/>
                
            </ul>
            
        </c:forEach>
        
        
        <h2>Получить список сделок в json-формате</h2>
        
        <form method="GET" action="<c:url value='/getjson'/>">
            
            <label> Имя агента <input type="text" name="name"></label><br>
            <br>
            <label> Начало периода <input type="date" name="start_date"></label><br>
            <br>
            <label> Конец периода <input type="date" name="end_date"></label><br>
            <br>
            <input type="submit""><br>
                                 
        </form>
 
    </body>
</html>
