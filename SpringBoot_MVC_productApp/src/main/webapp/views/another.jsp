<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Data get here By Id</h1>

<c:if test="${result==null}">
<h3>No Data Found</h3>
</c:if>

<c:if test="${result!=null}">
<p><c:out value="${result.pid}"></c:out></p> <br>
<c:out value="${result.pprice}"></c:out> <br>
<c:out value="${result.pname}"></c:out> <br>
<c:out value="${result.pid}"></c:out> <br>
</c:if>

   

   


</body>
</html>