<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lists</title>
		<style type="text/css">
			.navbar {
			 	width: 100%;
			 	background-color: #555;
			  	overflow: auto;
			}
			.navbar a {
			  	float: left;
			  	padding: 12px;
			  	color: white;
			  	text-decoration: none;
			  	font-size: 17px;
			  	width: 25%;
			  	text-align: center;
			}
			.navbar a:hover {
			  	background-color: #000;
			}
			.navbar a.active {
			  	background-color: #4CAF50;
			}
			
   			TABLE {
    			width: 400px; 
    			border-collapse: collapse; 
    			display: inline;
    			margin-right: 50px;
    			margin-left: 50px;
  		 	}
   			TD, TH {
    			padding: 3px; 
    			border: 1px solid black; 
    			text-align: center; 
   			}
   			TH {
    			background: #4CAF50; 
   			}
   			
   			input[type=submit]{
   				background: white;
			    border: none;
			    text-align: center;
			    text-decoration: none;
			    font-size: 20px;
			    cursor: pointer;
   			}
   			
			a {
				color: #013220;
				font-size: 20px;
				text-decoration: none;
				cursor: pointer;
			}
  		</style>
	</head>
	<body>
		<div class="navbar">
			<a class="active" href="#">Lists</a>
			<a href='<c:url value="/create" />'>Create</a>
		</div>
		<br>
		<table>
			<caption>Animals</caption>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Weight</th>
				<th>Options</th>
			</tr>
		
			<c:forEach var="animal" items="${animals}">
				<tr>
					<td>${animal.name}</td>
					<td>${animal.age}</td>
					<td>${animal.weight}</td>
					<td>
						<a href='<c:url value="/edit?type=animal&id=${animal.id}"/>'>Edit</a>
						<form method="post" action='<c:url value="/delete?type=animal"/>' style="display:inline;">
							<input name="id" value="${animal.id}" type="hidden">
							<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>

		<table>
			<caption>Cats</caption>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Weight</th>
				<th>Color</th>
				<th>Category</th>
				<th>Options</th>
			</tr>
		
			<c:forEach var="cat" items="${cats}">
				<tr>
					<td>${cat.name}</td>
					<td>${cat.age}</td>
					<td>${cat.weight}</td>
					<td style="background: ${cat.color}"></td>
					<td>${cat.category}</td>
					<td>
						<a href='<c:url value="/edit?type=cat&id=${cat.id}"/>'>Edit</a>
						<form method="post" action='<c:url value="/delete?type=cat"/>' style="display:inline;">
							<input name="id" value="${cat.id}" type="hidden">
							<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<table>
			<caption>Tigers</caption>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Weight</th>
				<th>Color</th>
				<th>Category</th>
				<th>Eaten Employees</th>
				<th>Options</th>
			</tr>
		
			<c:forEach var="tiger" items="${tigers}">
				<tr>
					<td>${tiger.name}</td>
					<td>${tiger.age}</td>
					<td>${tiger.weight}</td>
					<td style="background: ${tiger.color}"></td>
					<td>${tiger.category}</td>
					<td>${tiger.numOfEatenEmployees}</td>
					<td>
						<a href='<c:url value="/edit?type=tiger&id=${tiger.id}"/>'>Edit</a>
						<form method="post" action='<c:url value="/delete?type=tiger"/>' style="display:inline;">
							<input name="id" value="${tiger.id}" type="hidden">
							<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>