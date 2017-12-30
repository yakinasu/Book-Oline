<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="common.css">
<% String errorMessage = (String)request.getAttribute( "message" ); %>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<script type="text/javascript" src="/bookOnline/js/bookCheck.js"></script>
			<title>Add_book</title>
		</head>
		<body>
			<div id="head">本情報を登録します</div>
			<p class="info">必要事項を記入して
			<span style ="background-color: #0099FF">追加</span>
			を押してください。</p>
			<%if (errorMessage != null) {%>
				<%=errorMessage%>
			<%} %>
				<form method="get" name = "checkBlank" action ="/bookOnline/BookAddController" onSubmit="return CheckBlank()">
					<table border = "1">
						<tr>
							<th>ISBN</th>
							<td><input type="text" class="stringwidth" name="tytle" id="title"></td>
						</tr>
						<tr>
							<th>BookTitle</th>
							<td><input type="text" class="stringwidth" name="isbn" id="isbn"></td>
						</tr>
						<tr>
						<th>Page</th>
							<td><input type="text" class="stringwidth" name="page" id="page"></td>
						</tr>
						<tr>
							<th>Author</th>
							<td><input type="text" class="stringwidth" name="author" id="author"></td>
						</tr>
					</table>
					<div id="errorMSG"> </div>
					<input type = "submit"  class = "button" value = "追加する" >
				</form>
		</body>
</html>