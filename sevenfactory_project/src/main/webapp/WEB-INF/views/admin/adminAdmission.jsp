<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 동적인 페이지 포함 -->
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="관리자용" name="title" />
</jsp:include>
<jsp:include page="/WEB-INF/views/template/adminSide.jsp" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<style type="text/css">
.container {
	width: 70%;
	height: 700px;
	display: fiexd;
	/*       margin-left:100px; */
}

tr, th {
	text-align: center;
}

select {
	width: 140px;
	padding: .6em .3em;
	font-family: inherit;
	background:
		url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg)
		no-repeat 95% 50%;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	border: 1px solid #999;
	border-radius: 0px;
}

select::-ms-expand {
	/* for IE 11 */
	display: none;
}

.Btn { /* 버튼 : 회원추가, 전체회원 리스트 */
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 10px 24px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	transition-duration: 0.4s;
	cursor: pointer;
}

.btnAdd, .btnTotalList {
	background-color: white;
	color: black;
	border: 2px solid #4CAF50;
}

.btnAdd:hover, .btnTotalList:hover {
	background-color: #4CAF50;
	color: white;
}
</style>
<script>
function agree(i){
	         var url = 'blackagree?bNo='+i;
	         location.href= url;
	         alert("블랙리스트 등록이 완료됐습니다.");
	   
}
function disagree(i){
	var url = 'blackdisagree?bNo='+i;
    location.href= url;
    alert("블랙리스트 등록이 거절됐습니다.");
}
</script>
<div class="container">
	<h3 class="text-center">블랙리스트 요청목록</h3>
	<br>
	<br>
	<table class="table table-hover">
		<thead>
			<tr class="text-center">
				<th>번호</th>
				<th>아이디</th>
				<th>블랙리스트 사유</th>
				<th>승인</th>
				<th>거절</th>
			</tr>
		</thead>
		<tbody class="search row">

			<c:choose>

				<c:when test="${empty list }">
					<tr>
						<td colspan="8">블랙리스트 등록요청이 없습니다.</td>
					</tr>
				</c:when>

				<c:when test="${not empty list }">
					<c:forEach var="bDTO" items="${list }">
						<tr>
							<td>${bDTO.bNo }</td>
							<td>${bDTO.mId }</td>
							<td>${bDTO.bReason }</td>
							<td><input type="button" value="승인" onclick="agree(${bDTO.bNo })"></td>
							<td><input type="button" value="거절" onclick="disagree(${bDTO.bNo })"></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</tbody>
	</table>
</div>

<!-- 관리자가 로그인하면 "관리자메뉴"를 표시한다. -->

<!-- 정적인 페이지 포함 -->
<%@ include file="/WEB-INF/views/template/footer.jsp"%>