<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Kosta 129th Emp Finder</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<button id="btn" class="btn btn-default" style="margin-top: 8px">사원등록</button>
				<script>
				window.onload=function(){
					document.getElementById("btn").onclick=function(){
						location.href="writeform.htm";
					}
				}
				</script>
				<form name="search" class="navbar-form navbar-right" role="search" action="search.htm">
				
					<div class="form-group">
					<!-- 드롭다운 -->
						<select id="select" name="select" class="form-control">
							<option value="">검색조건</option>
							<option value="empno">사원번호</option>
							<option value="ename">이름</option>
							<option value="job">직종</option>
						</select>
						<input type="text" class="form-control" name="searchbox" placeholder="찾을 내용 입력">
					</div>
					
					
					
					<button type="submit" class="btn btn-default">찾기</button>
				</form>
				
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</header>