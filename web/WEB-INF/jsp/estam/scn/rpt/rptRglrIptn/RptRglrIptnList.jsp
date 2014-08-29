<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : RptRglrIptnList.jsp
  * @Description : RptRglrIptn List 화면
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


function fn_egov_select(iptDt, fctyCd, conDaGbcd) {
	document.getElementById("listForm").iptDt.value = iptDt;
	document.getElementById("listForm").fctyCd.value = fctyCd;
	document.getElementById("listForm").conDaGbcd.value = conDaGbcd;
   	document.getElementById("listForm").action = "<c:url value='/rptRglrIptn/updateRptRglrIptnView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/rptRglrIptn/addRptRglrIptnView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/rptRglrIptn/RptRglrIptnList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="iptDt" />
	<input type="hidden" name="fctyCd" />
	<input type="hidden" name="conDaGbcd" />
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
								<th align="center">IptDt</th>
								<th align="center">FctyCd</th>
								<th align="center">ConDaGbcd</th>
								<th align="center">GvmtCd</th>
								<th align="center">RglrQst11yn</th>
								<th align="center">RglrQst12yn</th>
								<th align="center">RglrQst13yn</th>
								<th align="center">RglrQst14yn</th>
								<th align="center">RglrQst21yn</th>
								<th align="center">RglrQst22yn</th>
								<th align="center">RglrQst23yn</th>
								<th align="center">RglrQst24yn</th>
								<th align="center">RglrQst31yn</th>
								<th align="center">RglrQst32yn</th>
								<th align="center">RglrQst41yn</th>
								<th align="center">RglrQst42yn</th>
								<th align="center">RglrQst43yn</th>
								<th align="center">RglrRsltCtnt</th>
								<th align="center">RglrMngeCtnt</th>
								<th align="center">RglrUsrDept</th>
								<th align="center">RglrUsrDuty</th>
								<th align="center">RglrUsrNm</th>
								<th align="center">RglrUsrTel</th>
								<th align="center">InptUsrId</th>
								<th align="center">InptDt</th>
								<th align="center">UpdtUsrId</th>
								<th align="center">UpdtDt</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
																									<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.iptDt}"/>', '<c:out value="${result.fctyCd}"/>', '<c:out value="${result.conDaGbcd}"/>')"><c:out value="${result.iptDt}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.iptDt}"/>', '<c:out value="${result.fctyCd}"/>', '<c:out value="${result.conDaGbcd}"/>')"><c:out value="${result.fctyCd}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.iptDt}"/>', '<c:out value="${result.fctyCd}"/>', '<c:out value="${result.conDaGbcd}"/>')"><c:out value="${result.conDaGbcd}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.gvmtCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrQst11yn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrQst12yn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrQst13yn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrQst14yn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrQst21yn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrQst22yn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrQst23yn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrQst24yn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrQst31yn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrQst32yn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrQst41yn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrQst42yn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrQst43yn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrRsltCtnt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrMngeCtnt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrUsrDept}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrUsrDuty}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrUsrNm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rglrUsrTel}"/>&nbsp;</td>
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
