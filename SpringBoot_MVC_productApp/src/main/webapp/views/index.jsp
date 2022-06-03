<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product App</title>
</head>
<body>
	<h1>Satya Product App</h1>
	<a href="getAllProducts">GetAllProducts</a> &nbsp; &nbsp;
	<a href="another">Get Product By ID</a>
	<hr>

	<c:if test="${result=='sucess'}">
		<h3 style="color: green;">Product Added Successfully!</h3>
	</c:if>

	<c:if test="${result=='failed'}">
		<h3 style="color: red;">Product already exists!</h3>
	</c:if>
	<form action="addProduct" method="post" enctype="multipart/form-data">
	
		Product Id : <input type="number" name="pid" placeholder="Product Id"
			required /> <br> <br> Product Price : <input type="number"
			name="pprice" placeholder="Product Price" required /> <br> <br>
		Product Name : <input type="text" name="pname"
			placeholder="Product Name" required /> <br> <br> Product
		Review : <input type="text" name="review" placeholder="Product Review"
			required /> <br> <br>
			
	  Image: <input type="file" name="image"  />	 <br> <br>	

		<button>Add</button>
	</form>


	<form action="getproductbyid">
		Id : <input type="number" name="pid" required />
		<button>submit</button>

		<br> <br>
		<hr>
		<h3>Search Product Like</h3>
	</form>

	<form action="getproductlikeName">
		Like Name : <input type="text" name="pname" required />
		<button>submit</button>
	</form>


	<hr>
	<hr>

	<c:if test="${result=='sucess'}">
		<h2 style=" color: green;">Product Uda ree!</h2>
	</c:if>

	<c:if test="${result=='failed'}">
		<h2 style=" color: red;">Product Nhi Mila Re !</h2>
	</c:if>


	<h3>Delete the Product</h3>
	<br>
	<form action="delete">
		delete : <input type="number" name="pid" required />
		<button>delete</button>
	</form>
    <hr><br><br>
	<hr>
	
	
	<c:if test="${result=='sucess'}">
		<h2>updated Successfully</h2>
	</c:if>

	<c:if test="${result=='failed'}">
		<h2>Failed to Update !</h2>
	</c:if>
	

	<h2>Product Id's</h2>
	
	<c:if test="${update=='sucess'}">
		<p style="color: green;">Book Updated Successfully!</p>
		</c:if>
		
		<c:if test="${update=='failed'}">
		<p style="color: red;">Book Failed To Updated!</p>
		</c:if>
	
	
	<form action="updateBook">
	
	Name : <select name="id">

			<c:forEach items="${idk}" var="ak">

				<option>${ak}</option>

			</c:forEach>
         
		</select> <br>

		<h2>Update Product</h2>
		
		Product Id : <input type="number" name="pid" placeholder="Product Id"
			required /> <br> <br> Product Price : <input type="number"
			name="pprice" placeholder="Product Price" required /> <br> <br>
		Product Name : <input type="text" name="pname"
			placeholder="Product Name" required /> <br> <br> Product
		Review : <input type="text" name="review" placeholder="Product Review"
			required /> <br> <br>


		<button>Updated</button>

	</form>
















</body>
</html>