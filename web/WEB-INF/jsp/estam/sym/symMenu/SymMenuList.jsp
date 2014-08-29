<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : SymMenuList.jsp
  * @Description : SymMenu List 화면
  * @Modification Information
  * 
  * @author ATRES
  * @since 20130703
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


function fn_egov_select(menuCd) {
	document.getElementById("listForm").menuCd.value = menuCd;
   	document.getElementById("listForm").action = "<c:url value='/symMenu/updateSymMenuView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/symMenu/addSymMenuView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/symMenu/SymMenuList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="menuCd" />
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
							</colgroup>		  
			<tr>
								<th align="center">MenuCd</th>
								<th align="center">UpMenuCd</th>
								<th align="center">SiteGbcd</th>
								<th align="center">MenuNm</th>
								<th align="center">MenuDesc</th>
								<th align="center">ReMark</th>
								<th align="center">LinkUrl</th>
								<th align="center">DplyNo</th>
								<th align="center">UseYn</th>
								<th align="center">InptUsrId</th>
								<th align="center">UpdtUsrId</th>
								<th align="center">InptDt</th>
								<th align="center">UpdtDt</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
													<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.menuCd}"/>')"><c:out value="${result.menuCd}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.upMenuCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.siteGbcd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.menuNm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.menuDesc}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.reMark}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.linkUrl}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dplyNo}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.useYn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.inptUsrId}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.updtUsrId}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.inptDt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.updtDt}"/>&nbsp;</td>
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
