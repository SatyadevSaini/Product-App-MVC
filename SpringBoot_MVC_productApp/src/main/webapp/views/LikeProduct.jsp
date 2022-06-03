<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All product Print </h1>

 <c:forEach items="${Data1}" var="b">
   
  <div style="border:3px solid blue;width:max-content;">
   <p>Product Id : <c:out value="${b.pid}"></c:out></p>
   <p>Product Price:  <c:out value="${b.pprice}"></c:out></p>
   <p>Product Name : <c:out value="${b.pname}"></c:out></p>
   <p>Product Review :<c:out value="${b.review}"></c:out></p>
   </div>
   
   </c:forEach>


</body>
</html>