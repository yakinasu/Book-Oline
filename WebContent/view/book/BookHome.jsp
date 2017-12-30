<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import= "logic.*, java.util.*" %>
<!--  JSPの勉強のため、Logicクラスを直接呼出し-->
<%
BookHomeLogic bookHomeLogic = new BookHomeLogic();
ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
list = bookHomeLogic.searchBookdb();
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>読書管理ページ</title>
	</head>
	<body>
		<form method="get" action ="/bookOnline/BookHomeController">
			新規で追加する場合はここをクリックv
			<input type = "submit" name = "add" value = "追加する">
			<input type="submit" name =  "search" value="検索">
			<input type = "submit" name ="upload" value = "編集する">

			<br>
			<table border ="1">
				<tr>
					<th>ISBN</th>
					<th>BookTitle</th>
					<th>Page</th>
					<th>Author</th>
				</tr>
				<% for (HashMap<String, String> search : list) { %>
				<tr>
					<td><%= search.get("isbn") %></td>
					<td><%= search.get("tytle") %></td>
					<td><%= search.get("page") %></td>
					<td><%= search.get("author") %></td>
					<td><input type = "submit" name ="comment" value = "コメントを追加する"></td>
					<%} %>
				</tr>
				</table>
		</form>
	</body>
</html>