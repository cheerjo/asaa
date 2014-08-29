<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : IddlAassInfoList.jsp
  * @Description : IddlAassInfo List 화면
  * @Modification Information
  * 
  * @author atres
  * @since 2013.10.16
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


function fn_egov_select(fctyCd, iddlAassNo) {
	document.getElementById("listForm").fctyCd.value = fctyCd;
	document.getElementById("listForm").iddlAassNo.value = iddlAassNo;
   	document.getElementById("listForm").action = "<c:url value='/iddlAassInfo/updateIddlAassInfoView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/iddlAassInfo/addIddlAassInfoView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/iddlAassInfo/IddlAassInfoList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="fctyCd" />
	<input type="hidden" name="iddlAassNo" />
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
								<th align="center">IddlAassNo</th>
								<th align="center">IddlAassDt</th>
								<th align="center">EhqkOtn</th>
								<th align="center">WvScnExtFlsv</th>
								<th align="center">WvScnExtFlnm</th>
								<th align="center">WvScnExtFldt</th>
								<th align="center">MoniFreeNrfy</th>
								<th align="center">MoniMjNrfy</th>
								<th align="center">MoniShotNrfy</th>
								<th align="center">EhqkReqId</th>
								<th align="center">WvScnRsltFlsv</th>
								<th align="center">InptUsrId</th>
								<th align="center">InptDt</th>
								<th align="center">UpdtUsrId</th>
								<th align="center">UpdtDt</th>
								<th align="center">EhqkTranGbcd</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
																			<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.fctyCd}"/>', '<c:out value="${result.iddlAassNo}"/>')"><c:out value="${result.fctyCd}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.fctyCd}"/>', '<c:out value="${result.iddlAassNo}"/>')"><c:out value="${result.iddlAassNo}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.iddlAassDt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkOtn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.wvScnExtFlsv}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.wvScnExtFlnm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.wvScnExtFldt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.moniFreeNrfy}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.moniMjNrfy}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.moniShotNrfy}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkReqId}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.wvScnRsltFlsv}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.inptUsrId}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.inptDt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.updtUsrId}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.updtDt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkTranGbcd}"/>&nbsp;</td>
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
