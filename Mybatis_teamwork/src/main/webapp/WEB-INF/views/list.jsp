<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="content">
<h1 style="text-align: center">사원 리스트</h1>

<table class="table table-hover">
	<tr>
		<th>사원번호</th>
		<th>이름</th>
		<th>직종</th>
		<th>매니저</th>
		<th>고용일</th>
		<th>월급</th>
		<th>추가수당</th>
		<th>부서번호</th>				
	</tr>	

<c:forEach var="b" items="${list}">


	<tr>
		<td>${b.empno}</td>
		<td><a href="read.htm?num=${b.empno}">${b.ename}</a></td>
		<td>${b.job}</td>
		<td>${b.mgr}</td>
		<td><fmt:formatDate value="${b.hiredate}" pattern="yyyy-MM-dd"/></td>
		<td>${b.sal}</td>
		<td>${b.comm}</td>
		<td>${b.deptno}</td>
	</tr>
</c:forEach>

</table>

</div>
