<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int principle = Integer.parseInt(request.getParameter("uamount"));
int time = Integer.parseInt(request.getParameter("umonth"));
int rate = Integer.parseInt(request.getParameter("urate"));
int total = ((principle*rate*time)/100);
int emi=(principle*rate)/100;

%>
<h3>Total amount: <%= total %></h3>
<h3>EMI: <%= emi %></h3>

</body>
</html>