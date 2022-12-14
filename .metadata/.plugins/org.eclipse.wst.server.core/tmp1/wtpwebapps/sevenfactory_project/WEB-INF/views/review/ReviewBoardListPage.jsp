<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/views/template/header.jsp">
   <jsp:param value="게시판" name="title" />
</jsp:include>

<style type="text/css">
   .ReviewBoard-list-box {width: 1100px; margin-bottom: 50px; margin: 50px auto; text-align: center;}
   .ReviewBoard-list-box table{margin:auto; border-collapse: collapse;width: 1100px;}
   .ReviewBoard-list-box thead td {background: #FEE3EC;}
   .ReviewBoard-list-box td {text-align: center; padding:10px;border-bottom: 1px solid lightgray;}
   .ReviewBoard-list-box tr td:nth-of-type(1) {width: 100px;}
   .ReviewBoard-list-box tr td:nth-of-type(2) {width: 500px;}
   .ReviewBoard-list-box tr td:nth-of-type(3) {width: 150px;}
   .ReviewBoard-list-box tr td:nth-of-type(4) {width: 150px;}
   .ReviewBoard-list-box tr td:nth-of-type(5) {width: 100px;}
   .review_backimg 
   {
      width: 100%; 
      height: 750px; 
      background-size: cover;
      background-image: url("resources/3dog.jpg"); 
      text-align: center; 
      color: white; 
      padding-top: 180px;
   }
   .ReviewBoard-list-box .reviewInsertBtn {float: right; margin-bottom: 10px; text-decoration: none;}
   .review_backimg  #pagetitle {font-size: 85px;}
   .review_backimg  #explain {font-weight: bold;}
   .review_backimg  #explain {font-size: 15px;}
   #review_name {width: 200px;}
   a {
      text-decoration: none;
   }
</style>


<div class="review_backimg">
   <h1 id="pagetitle">Community</h1>
   <p id="explain">투개더에서 보낸 이용후기</p>
</div>

<div class="ReviewBoard-list-box">
   <img id="review_name" alt="notice_name" src="resources/assets/name_img/review_name2.png"/><br/> 
   <br/><br/>
   
   <table>
      <thead>
         <tr>
            <td>ID</td>
            <td>제목</td>
            <td>작성일</td>
            <td>호실</td>
            <td>평점</td>
         </tr>
      </thead>
      <tbody>
         <c:if test="${empty list}">
            <tr>
               <td style="text-align:center;" colspan="5">작성된 게시글이 없습니다.</td>
            </tr>
         </c:if>
         <c:if test="${not empty list}">
            <c:forEach var="hDTO" items="${list}">
               <tr>
                  <td>${hDTO.mId}</td>
                  <td><a href="ReviewBoardViewPage?rNo=${hDTO.rNo}&mId=${hDTO.mId}">${hDTO.rTitle }</a></td>
                  <td>${hDTO.rRegDate}</td>
                  <td>${hDTO.gName }</td>
                  <td>${hDTO.rRating } / 5.0</td>
               </tr>
            </c:forEach>
         </c:if>
      </tbody>
      <tfoot>
      <tr>
               <td colspan="5">${pageView}</td> 
      </tr>
      </tfoot>
   </table>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>