<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : RptStabRatgList.jsp
  * @Description : RptStabRatg List 화면
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


function fn_egov_select(iptDt, ehqkEvntCd, ehqkEvntId) {
	document.getElementById("listForm").iptDt.value = iptDt;
	document.getElementById("listForm").ehqkEvntCd.value = ehqkEvntCd;
	document.getElementById("listForm").ehqkEvntId.value = ehqkEvntId;
   	document.getElementById("listForm").action = "<c:url value='/rptStabRatg/updateRptStabRatgView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/rptStabRatg/addRptStabRatgView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/rptStabRatg/RptStabRatgList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="iptDt" />
	<input type="hidden" name="ehqkEvntCd" />
	<input type="hidden" name="ehqkEvntId" />
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
							</colgroup>		  
			<tr>
								<th align="center">IptDt</th>
								<th align="center">EhqkEvntCd</th>
								<th align="center">EhqkEvntId</th>
								<th align="center">GvmtCd</th>
								<th align="center">FctyCd</th>
								<th align="center">ConDaGbcd</th>
								<th align="center">IdrRngMj</th>
								<th align="center">IdrRngShot</th>
								<th align="center">StrFrqMj</th>
								<th align="center">StrFrqShot</th>
								<th align="center">GrdRsnnPsbyMj</th>
								<th align="center">GrdRsnnPsbyShot</th>
								<th align="center">MaxScnMj</th>
								<th align="center">MaxScnShot</th>
								<th align="center">SfTot</th>
								<th align="center">SfUsrDept</th>
								<th align="center">SfUsrDuty</th>
								<th align="center">SfUsrNm</th>
								<th align="center">SfUsrTel</th>
								<th align="center">InptUsrId</th>
								<th align="center">InptDt</th>
								<th align="center">UpdtUsrId</th>
								<th align="center">UpdtDt</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
																									<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.iptDt}"/>', '<c:out value="${result.ehqkEvntCd}"/>', '<c:out value="${result.ehqkEvntId}"/>')"><c:out value="${result.iptDt}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.iptDt}"/>', '<c:out value="${result.ehqkEvntCd}"/>', '<c:out value="${result.ehqkEvntId}"/>')"><c:out value="${result.ehqkEvntCd}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.iptDt}"/>', '<c:out value="${result.ehqkEvntCd}"/>', '<c:out value="${result.ehqkEvntId}"/>')"><c:out value="${result.ehqkEvntId}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.gvmtCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.conDaGbcd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.idrRngMj}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.idrRngShot}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.strFrqMj}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.strFrqShot}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.grdRsnnPsbyMj}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.grdRsnnPsbyShot}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.maxScnMj}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.maxScnShot}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfTot}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfUsrDept}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfUsrDuty}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfUsrNm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfUsrTel}"/>&nbsp;</td>
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
