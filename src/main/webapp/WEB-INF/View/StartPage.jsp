
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Записи сделок</h2>
        
        <c:forEach var = "deal" items = "${requestScope.deals}">
            
            <ul>
                Идентификатор сделки:  <c:out value="${deal.id}"/>
                
            </ul>
            
        </c:forEach>
        
        
        <h2>Получить информацию о сделке в json-формате</h2>
        
        <form method="GET" action="<c:url value='/getjson'/>">
            
            <label> ID сделки <input type="number" name="id"></label><br>
            <br>
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
