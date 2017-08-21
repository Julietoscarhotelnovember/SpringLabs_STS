<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<script type="text/javascript">
function board_update(){
	//alert("수정");
	location.href="updateform.htm?num=${b.empno}";
	
}
function board_delete(){
	//alert("삭제");
	location.href="delete.htm?num=${b.empno}";
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<h1 style="text-align:center">사원 상세 정보</h1>

<a href="list.htm">사원 리스트</a><br>
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
			<input type="text" class="form-control" name="ename" readonly="readonly" value="${b.ename}" style="width:200px" />
		</td>
		</div>
	</tr>
	<tr>
		<div class="form-group">
		<th>직종</th>
		<td>
			<input type="text" class="form-control" name="job" readonly="readonly" value="${b.job}" style="width:200px" />
		</td>
		</div>
	</tr>
	
	
	<tr>
		<div class="form-group">
		<th>매니저</th>
		<td>
			<input type="text" class="form-control" name="mgr" readonly="readonly" value="${b.mgr}" style="width:200px" />
		</td>
		</div>
	</tr>

	<tr>
		<div class="form-group">
		<th>고용일</th>
		<td>
			<input type="text" class="form-control" name="hiredate" readonly="readonly" value="${b.hiredate}" style="width:200px" />
		</td>
		</div>
	</tr>

	<tr>
		<div class="form-group">
		<th>월급</th>
		<td>
			<input type="text" class="form-control" name="sal" readonly="readonly" value="${b.sal}" style="width:200px" />
		</td>
		</div>
	</tr>
	<tr>
		<div class="form-group">
		<th>추가수당</th>
		<td>
			<input type="text" class="form-control" name="comm" readonly="readonly" value="${b.comm}" style="width:200px" />
		</td>
		</div>
	</tr>
	<tr>
		<div class="form-group">
		<th>부서번호</th>
		<td>
			<input type="text" class="form-control" name="deptno" readonly="readonly" value="${b.deptno}" style="width:200px" />
		</td>
		</div>
	</tr>
	<tr>
		
		<td colspan="2">
<input type="button" class="btn btn-default" value="수정" onclick="board_update()"/>
<input type="button" class="btn btn-default" value="삭제" onclick="board_delete()"/>
		</td>
	</tr>
	
</table>

