<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : SymUserList.jsp
  * @Description : SymUser List 화면
  * @Modification Information
  * 
  * @author ATRES
  * @since 2013.07.03
  * @version 1.0
  * @see
  *  
  * Copyright (C) All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>목록</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 수정 화면 function */


function fn_egov_select(userId) {
	document.getElementById("listForm").userId.value = userId;
   	document.getElementById("listForm").action = "<c:url value='/sym/symUser/updateSymUserView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/sym/symUser/addSymUserView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/sym/symUser/SymUserList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="userId" />
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>" alt="title" /> List </li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup>
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
							</colgroup>		  
			<tr>
								<th align="center">PrivGrpNo</th>
								<th align="center">UserId</th>
								<th align="center">OrgYn</th>
								<th align="center">OrgNm</th>
								<th align="center">UserNm</th>
								<th align="center">UsrPswd</th>
								<th align="center">UsrEmail</th>
								<th align="center">TelNo</th>
								<th align="center">MblNo</th>
								<th align="center">UseObjt</th>
								<th align="center">InptUsrId</th>
								<th align="center">InptDt</th>
								<th align="center">UpdtUsrId</th>
								<th align="center">UpdtDt</th>
								<th align="center">DelDt</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
													<td align="center" class="listtd"><c:out value="${result.privGrpNo}"/>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.userId}"/>')"><c:out value="${result.userId}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.orgYn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.orgNm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.userNm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.usrPswd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.usrEmail}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.telNo}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mblNo}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.useObjt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.inptUsrId}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.inptDt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.updtUsrId}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.updtDt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.delDt}"/>&nbsp;</td>
				    			</tr>
			</c:forEach>
		</table>
	</div>
	<!-- /List -->
	<div id="paging">
		<ui:pagination paginationInfo = "${paginationInfo}"
				   type="image"
				   jsFunction="fn_egov_link_page"
				   />
		<form:hidden path="pageIndex" />
	</div>
	<div id="sysbtn1">
		<ul>
			<li>
				<div id="sysbtn">
					<span class="btn_blue_l"><a href="javascript:fn_egov_addView();">등록</a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" alt="" />
					</span>
				</div>
			</li>
		</ul>
	</div>
</div>
</form:form>
</body>
</html>
