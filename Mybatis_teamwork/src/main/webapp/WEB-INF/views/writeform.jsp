<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1 style="text-align: center">사원 등록</h1>
<a href="list.htm">사원 리스트</a><br>
<form name = "writeform" action="write.htm" method="post">

<table>
	<tr>
		<div class="form-group">
		<th>사원번호</th>
		<td>
			<input type="text" class="form-control" name="empno" style="width:200px" />
		</td>
  		</div>
	</tr>
	<tr>
		<div class="form-group">
		<th>이름</th>
		<td>
			<input type="text" class="form-control" name="ename" style="width:200px" />
		</td>
		</div>
	</tr>
	<tr>
		<div class="form-group">
		<th>직종</th>
		<td>
			<input type="text" class="form-control" name="job" style="width:200px" />
		</td>
		</div>
	</tr>
	
	
	<tr>
		<div class="form-group">
		<th>매니저</th>
		<td>
			<input type="text" class="form-control" name="mgr" style="width:200px" />
		</td>
		</div>
	</tr>

	<tr>
		<div class="form-group">
		<th>월급</th>
		<td>
			<input type="text" class="form-control" name="sal" style="width:200px" />
		</td>
		</div>
	</tr>
	<tr>
		<div class="form-group">
		<th>추가수당</th>
		<td>
			<input type="text" class="form-control" name="comm" style="width:200px" />
		</td>
		</div>
	</tr>
	<tr>
		<div class="form-group">
		<th>부서번호</th>
		<td>
			<input type="text" class="form-control" name="deptno" style="width:200px" />
		</td>
		</div>
	</tr>
	<tr>
		
		<td colspan="2">
			<input type="submit" class="btn btn-default" value="저장"/>
			<input type="reset"  class="btn btn-default" value="취소" />
		</td>
	</tr>
	

</table>


</form>