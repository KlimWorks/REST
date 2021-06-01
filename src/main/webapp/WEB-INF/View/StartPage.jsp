
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Записи сделок</h1>
        
        <c:forEach var = "deal" items = "${requestScope.deals}">
            
            <ul>
                Идентификатор сделки:  <c:out value="${deal.id}"/>
                
            </ul>
            
        </c:forEach>
        
        
        <h1>Получить информацию о сделке в json-формате</h1>
        
        <form method="GET" action="<c:url value='/getjson'/>">
            
            <label> ID сделки <input type="number" name="id"></label><br>
            <br>
            <input type="submit""><br>
                                 
        </form>
 
    </body>
</html>
