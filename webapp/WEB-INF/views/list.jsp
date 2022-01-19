<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- table1 입력 폼 -->
	<form action="/guestbook4/guest/addList" method="get"> 
		<table border="1" width="500px"> 
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td> <!-- name=" " 컨트롤러의 add에서 받을 파라미터값의 이름 -->
				<td>비밀번호</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea name="content" cols="66" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<button type="submit">글작성</button><!-- 글작성 누르면 addList타게끔 -->
				</td>
			</tr>
		</table>
	</form>
	
	
	 <!-- table2 리스트 목록 -->
	<form action="/guestbook4/guest/deleteForm" method="get">
		<table border="1" width="500px"> 
			
			<c:forEach items="${gbList}" var="gbVo">
				<tr>
					<td>${gbVo.no}</td>
					<td>${gbVo.name}</td>
					<td>${gbVo.regDate}</td>
					<td><a href="/guestbook4/guest/deleteForm?no=${gbVo.no}">삭제</a></td>
				</tr>
				<tr>
					<td colspan="4">
						${gbVo.content}
					</td>
				</tr>
			</c:forEach>
		
		</table>
	</form>
	
</body>
</html>