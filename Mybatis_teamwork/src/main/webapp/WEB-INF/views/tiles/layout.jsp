<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>index</title>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row">
	<!-- Header  영역  -->
	<tiles:insertAttribute name="header" />
	</div>
	
	<div class="row">
 	<div class="col-md-2"></div>
  	<div class="col-md-8">
		<!-- Main 영역 -->
		<div id="main">
				<div class="top-wrapper clear">
					<!-- Content  -->
					<tiles:insertAttribute name="content" />
				</div>	
		</div>
  	</div>
  	<div class="col-md-2"></div>
  	</div>
  	
  	<div class="row">
  	<div class="col-md-4"></div>
  	<div class="col-md-4">
		<!-- Footer  영역 -->
		<tiles:insertAttribute name="footer" />
  	</div>
  	<div class="col-md-4"></div>
  	</div>	
</body>
</html>