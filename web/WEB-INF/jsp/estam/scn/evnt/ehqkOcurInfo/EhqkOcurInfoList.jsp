<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : EhqkOcurInfoList.jsp
  * @Description : EhqkOcurInfo List 화면
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


function fn_egov_select(ehqkReqId, ehqkTranGbcd) {
	document.getElementById("listForm").ehqkReqId.value = ehqkReqId;
	document.getElementById("listForm").ehqkTranGbcd.value = ehqkTranGbcd;
   	document.getElementById("listForm").action = "<c:url value='/ehqkOcurInfo/updateEhqkOcurInfoView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/ehqkOcurInfo/addEhqkOcurInfoView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/ehqkOcurInfo/EhqkOcurInfoList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="ehqkReqId" />
	<input type="hidden" name="ehqkTranGbcd" />
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
							</colgroup>		  
			<tr>
								<th align="center">EhqkReqId</th>
								<th align="center">EhqkTranGbcd</th>
								<th align="center">FctyCd</th>
								<th align="center">EhqkDocTpcd</th>
								<th align="center">EhqkOrgTm</th>
								<th align="center">EhqkLon</th>
								<th align="center">EhqkLat</th>
								<th align="center">EhqkScal</th>
								<th align="center">EhqkOrgArea</th>
								<th align="center">EhqkEvntSttm</th>
								<th align="center">EhqkEvntEdtm</th>
								<th align="center">EhqkEvntYn</th>
								<th align="center">EhqkStatOtr</th>
								<th align="center">EhqkStatUp</th>
								<th align="center">GvmtCd</th>
								<th align="center">InptUsrId</th>
								<th align="center">InptDt</th>
								<th align="center">UpdtUsrId</th>
								<th align="center">UpdtDt</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
																			<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.ehqkReqId}"/>', '<c:out value="${result.ehqkTranGbcd}"/>')"><c:out value="${result.ehqkReqId}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.ehqkReqId}"/>', '<c:out value="${result.ehqkTranGbcd}"/>')"><c:out value="${result.ehqkTranGbcd}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkDocTpcd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkOrgTm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkLon}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkLat}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkScal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkOrgArea}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkEvntSttm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkEvntEdtm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkEvntYn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkStatOtr}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkStatUp}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.gvmtCd}"/>&nbsp;</td>
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
