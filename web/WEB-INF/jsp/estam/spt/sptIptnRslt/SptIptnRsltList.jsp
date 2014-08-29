<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : SptIptnRsltList.jsp
  * @Description : SptIptnRslt List 화면
  * @Modification Information
  * 
  * @author atres
  * @since 2013.10.17
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


function fn_egov_select(fctyCd, sptIptnDt) {
	document.getElementById("listForm").fctyCd.value = fctyCd;
	document.getElementById("listForm").sptIptnDt.value = sptIptnDt;
   	document.getElementById("listForm").action = "<c:url value='/sptIptnRslt/updateSptIptnRsltView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/sptIptnRslt/addSptIptnRsltView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/sptIptnRslt/SptIptnRsltList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="fctyCd" />
	<input type="hidden" name="sptIptnDt" />
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
								<col/>				
								<col/>				
							</colgroup>		  
			<tr>
								<th align="center">FctyCd</th>
								<th align="center">SptIptnDt</th>
								<th align="center">SptIptnOtn</th>
								<th align="center">SptIptnReqtDt</th>
								<th align="center">SptIptnRsltDt</th>
								<th align="center">SptIptnNm</th>
								<th align="center">SptIptnDept</th>
								<th align="center">SptIptnPotn</th>
								<th align="center">SptIptnTel</th>
								<th align="center">EhqkScnCnt</th>
								<th align="center">RccCnt</th>
								<th align="center">SptIptnRsltYn</th>
								<th align="center">FctyTotCtnt</th>
								<th align="center">InptUsrId</th>
								<th align="center">InptDt</th>
								<th align="center">UpdtUsrId</th>
								<th align="center">UpdtDt</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
																			<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.fctyCd}"/>', '<c:out value="${result.sptIptnDt}"/>')"><c:out value="${result.fctyCd}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.fctyCd}"/>', '<c:out value="${result.sptIptnDt}"/>')"><c:out value="${result.sptIptnDt}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sptIptnOtn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sptIptnReqtDt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sptIptnRsltDt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sptIptnNm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sptIptnDept}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sptIptnPotn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sptIptnTel}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkScnCnt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rccCnt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sptIptnRsltYn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyTotCtnt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.inptUsrId}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.inptDt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.updtUsrId}"/>&nbsp;</td>
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
