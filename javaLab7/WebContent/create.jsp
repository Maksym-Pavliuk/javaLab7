<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create</title>
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
			p{
				display: inline;
			}
		</style>
		<script type="text/javascript">
			function toggleSet(radio) {
				var list = document.getElementsByClassName("item");
				for (var i = 0; i < list.length; i++) 
					list[i].style.display = list[i].className.indexOf(radio.value) != -1 ? 'inline' : '';
			}
		</script>
	</head>
	<body>
		<div class="navbar">
			<a href='<c:url value="/"/>'>Lists</a>
			<a class="active" href="#" >Create</a>
		</div>
		<br>
		<form method = "post">	
			<input name="type" value="animal" type="radio" onclick="toggleSet(this)" checked>
				<p>Animal</p>
			<input name="type" value="cat" type="radio" onclick="toggleSet(this)">
				<p>Cat</p>
			<input name="type" value="tiger" type="radio" onclick="toggleSet(this)">
				<p>Tiger</p>
			<br>
			<div class="container">
				<div class = "field">
					<label>Name</label>
					<input name="name"/>
				</div>
				
				<div class = "field">
					<label>Age</label>
					<input name="age" type="number" min="1" />
				</div>
				
				<div class = "field">
					<label>Weight</label>
					<input name="weight" type="number" min="0.01" step = "0.01" />
				</div>
				
				<div class = "field">
					<div class="item cat tiger">
						<label>Color</label>
						<input name="color" type="color" list="colors" />
						<datalist id="colors">
							<option value="#ff0000" label="red">
							<option value="#008000" label="green">
						    <option value="#0000FF" label="blue">			    
						</datalist>
						<br>
						<label>Category</label>
						<select name="category">
							<option disabled>Choose category</option>
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
						<input name="numOfEatenEmployees" type="number" min="0"/>
					</div>
				</div>
				
				<br/>	
				<input type="submit" value="Send" />
			</div>
		</form>
	</body>
</html>