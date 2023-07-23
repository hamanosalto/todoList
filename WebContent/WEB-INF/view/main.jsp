<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.TextBeen,java.util.ArrayList" %>
<%@ page import="model.flagBeen" %>
<% ArrayList<TextBeen> textList = (ArrayList<TextBeen>) request.getAttribute("list"); %>
<%flagBeen f = (flagBeen) request.getAttribute("flag");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todo</title>
<body>
<h1>メインページ</h1>
<h1>todoリスト</h1>
<form action="/todo/Text" method="post">
	入力してね：<input type="text" name="text"><br>
	<input type="submit" value="送信">
</form>
	<%if(f.getFlag() == 1){%>
		<%for(TextBeen t : textList){%>
			：<%=t.getText()%><br>
		<%} %>
	<%} %>
</body>
</html>