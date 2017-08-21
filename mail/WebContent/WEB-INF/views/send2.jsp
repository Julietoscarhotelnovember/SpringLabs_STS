<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//cdn.ckeditor.com/4.5.11/standard/ckeditor.js"></script>
<script type="text/javascript">
	$(function(){
		$("#submit").click(function(){
			alert("메일전송 완료");
		});
	});
	


</script>

</head>
<body>

<jsp:include page="/sidebar/header.jsp"></jsp:include>

<form action="send2.htm" method="post" enctype = "multipart/form-data">
	<div class="col-sm-3"></div>
	<div class="col-sm-6">	  
	<h2>E-Mail Form</h2><br><br>	
		<div class="form-group">
			
			<div>
				<label>받는사람</label>
				<input type="text" name="to" class="form-control">
			</div>
		</div>
		<br>
		<div>
			<label>제목</label>
			<input type="text" name="subject" class="form-control"> 
		 </div>
	 	<br>
		 <div>
			<label> 파일첨부</label>
			<input type="file" name="filename" class="form-control">
		 </div>
	 	<br>
		 <div>
			 <label>내용</label>
			 <textarea rows="4" cols="50" class="form-control" name = "content" id="editor1"></textarea>
			 <script>
                
                CKEDITOR.replace( 'editor1' );
            </script>
		 </div>
	 </div>
	
	 <div class="col-sm-4"></div>
	 <div  class="col-sm-5" style="text-align: right"><br>
	 	<input type="submit" id ="submit" class="btn btn-default" value="전송">
	 	<a href="javascript:history.go(-1)" class="btn btn-default">뒤로</a>
	 </div>
</form>

</body>
</html>