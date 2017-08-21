<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"
	language="java"%>
<html>
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>페이지 제목</title>
	
</head>
<body>
<jsp:include page="/sidebar/header.jsp"></jsp:include>

	<c:set var="d" value="${body}"></c:set>
	<script type="text/javascript">
		console.log(${d});
	</script>
	<div class="container">
	<c:forEach var="a" items="${d.channel.item}">	
	<div class="col-sm-3">			
		<div class="page_item" style="align:left; height:200px; width:270px;">
		<img src="${a.image}" style="height:150px; width:270px;"/>
		<a href="${a.link}" title="About Us">${a.title}</a>
		<div>${a.description}</div>
		</div>	
		</div>			
	</c:forEach>
	</div>
</body>
</html>
