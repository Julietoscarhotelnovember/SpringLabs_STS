<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function board_update(){
		//alert("쓰기")	;
		if(document.writeform.name.value==""){
			alert("이름을 입력해주세요");
		}else if(document.writeform.pwd.value==""){
			alert("비밀번호을 입력해주세요");
			document.writeform.pwd.focus();
		}else if(document.writeform.email.value==""){
			alert("이메일을 입력해주세요");
			document.writeform.email.focus();
		}else if(document.writeform.subject.value==""){
			alert("제목을 입력해주세요");
			document.writeform.subject.focus();
		}else if(document.writeform.content.value==""){
			alert("내용을 입력해주세요");
			document.writeform.content.focus();
		}else{
			document.writeform.submit(); //전송
		}
	}
</script>


<h1 style="text-align: center">사원 정보 수정</h1>
<a href="list.htm">사원 리스트</a>

<form name = "updateform" action="update.htm" method="post">

<%-- 	사원번호<input type="text" name="empno" readonly="readonly" value="${b.empno}"><br>
	이름<input type="text" name="ename" value="${b.ename}"><br>
	직종<input type="text" name="job" value="${b.job}"><br>
	매니저<input type="text" name="mgr" value="${b.mgr}"><br>
	고용일<input type="text" name="hiredate" readonly="readonly" value="${b.hiredate}"><br>
	월급<input type="text" name="sal" value="${b.sal}"><br>
	추가수당<input type="text" name="comm" value="${b.comm}"><br>
	부서번호<input type="text" name="deptno" value="${b.deptno}"><br> --%>

<table>
	<tr>
		<div class="form-group">
		<th>사원번호</th>
		<td>
			<input type="text" class="form-control" name="empno" readonly="readonly" value="${b.empno}" style="width:200px" />
		</td>
  		</div>
	</tr>
	<tr>
		<div class="form-group">
		<th>이름</th>
		<td>
			<input type="text" class="form-control" name="ename" value="${b.ename}" style="width:200px" />
		</td>
		</div>
	</tr>
	<tr>
		<div class="form-group">
		<th>직종</th>
		<td>
			<input type="text" class="form-control" name="job" value="${b.job}" style="width:200px" />
		</td>
		</div>
	</tr>
	
	
	<tr>
		<div class="form-group">
		<th>매니저</th>
		<td>
			<input type="text" class="form-control" name="mgr" value="${b.mgr}" style="width:200px" />
		</td>
		</div>
	</tr>
	
	<%-- <tr>
		<div class="form-group">
		<th>고용일</th>
		<td>
			<input type="text" class="form-control" name="hiredate" readonly="readonly" value="${b.hiredate}" style="width:200px" />
		</td>
		</div>
	</tr> --%>
	

	<tr>
		<div class="form-group">
		<th>월급</th>
		<td>
			<input type="text" class="form-control" name="sal" value="${b.sal}" style="width:200px" />
		</td>
		</div>
	</tr>
	<tr>
		<div class="form-group">
		<th>추가수당</th>
		<td>
			<input type="text" class="form-control" name="comm" value="${b.comm}" style="width:200px" />
		</td>
		</div>
	</tr>
	<tr>
		<div class="form-group">
		<th>부서번호</th>
		<td>
			<input type="text" class="form-control" name="deptno" value="${b.deptno}" style="width:200px" />
		</td>
		</div>
	</tr>
	<tr>
		
		<td colspan="2">
			<input type="submit" class="btn btn-default" value="수정" />
			<input type="reset"  class="btn btn-default" value="취소" />
		</td>
	</tr>
	
</table>
	
	
</form>
