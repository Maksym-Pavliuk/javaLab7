<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit</title>
		<style>
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
			.item{
				display: none; 
			}
			.field {
				clear: both;
				text-align: right;
				line-height:25px;
			}
			.field input{
				width: 150px;
			}
			.container{
				float:left;
			}	
			label {
				float: left;
				padding-right:10px;
			}
		</style>
		<script type="text/javascript">
			function toggleSet(radio) {
				var list = document.getElementsByClassName("item");
				for (var i = 0; i < list.length; i++) 
					list[i].style.display = list[i].className.indexOf(radio) != -1 ? 'inline' : '';
			}
		</script>
	</head>
	<body onload="toggleSet('${type}');">
		<div class="navbar">
			<a href='<c:url value="/"/>'>Lists</a>
			<a href='<c:url value="/create"/>'>Create</a>
			<a class="active" href="#" >Edit</a>
		</div>
		<br>
		<form method="post">
			<div class="container">
				<input name="id" value="${animal.id}" type="hidden"/>
				
				<div class = "field">
					<label>Name</label>
					<input name="name" value="${animal.name}"/>
				</div>
				
				<div class = "field">
					<label>Age</label>
					<input name="age" value="${animal.age}" type="number" min="1"/>
				</div>
				
				<div class = "field">
					<label>Weight</label>
					<input name="weight" value="${animal.weight}" type="number" step = "0.01"/>
				</div>
				
				<div class = "field">
					<div class="item cat tiger">
						<label>Color</label>
						<input name="color" value="${(type == 'cat' || type == 'tiger') ? animal.color : ''}" type="color" list="colors"/>
						<datalist id="colors">
							<option value="#ff0000" label="red">
							<option value="#008000" label="green">
						    <option value="#0000FF" label="blue">			    
						</datalist>
						<br>
						<label>Category</label>
						<select name="category">
							    <option value = "${(type == 'cat' || type == 'tiger') ? animal.category : ''}">Choose category</option>
							    <option value="longHaired">Long Haired</option>
							    <option value="semilongHaired">Semi-Long Haired</option>
							    <option value="shortHaired">Short Haired</option>
							    <option value="siamoorientalHaired">Siamo-Oriental Haired</option>
							    <option value="unknown">Unknown</option>
						</select>	
					</div>
				</div>
				
				<div class = "field">
					<div class="item tiger">
						<label>Eaten Employees</label>
						<input name="numOfEatenEmployees" value="${type == 'tiger' ? animal.numOfEatenEmployees : ''}" type="number"/>
					</div>
				</div>
				<br>
				<input type="submit" value="Send" />
			</div>
		</form>
	</body>
</html>