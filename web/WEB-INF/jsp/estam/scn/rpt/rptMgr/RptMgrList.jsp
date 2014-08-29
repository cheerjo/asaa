<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : RptMgrList.jsp
  * @Description : RptMgr List 화면
  * @Modification Information
  * 
  * @author atres
  * @since 2013.1016
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
   	document.getElementById("listForm").action = "<c:url value='/rptMgr/updateRptMgrView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/rptMgr/addRptMgrView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/rptMgr/RptMgrList.do'/>";
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
								<col/>				
								<col/>				
							</colgroup>		  
			<tr>
								<th align="center">IptDt</th>
								<th align="center">FctyCd</th>
								<th align="center">ConDaGbcd</th>
								<th align="center">GvmtCd</th>
								<th align="center">ObsName</th>
								<th align="center">OpenDate</th>
								<th align="center">OffDate</th>
								<th align="center">FctyAreaCd</th>
								<th align="center">FctyAddr</th>
								<th align="center">FctyKndCd</th>
								<th align="center">MechPotn</th>
								<th align="center">FctyLon</th>
								<th align="center">FctyLat</th>
								<th align="center">FctyAttc</th>
								<th align="center">FctyGrndHt</th>
								<th align="center">FctyUgrdHt</th>
								<th align="center">FctyBasc</th>
								<th align="center">EhqkScnCnt</th>
								<th align="center">RccCnt</th>
								<th align="center">StrcFrmCd</th>
								<th align="center">SeisCd</th>
								<th align="center">FctyGrndCd</th>
								<th align="center">FctyHolcYn</th>
								<th align="center">FctyChgeNm</th>
								<th align="center">FctyCottTel</th>
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
						<td align="center" class="listtd"><c:out value="${result.obsName}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.openDate}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.offDate}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyAreaCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyAddr}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyKndCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mechPotn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyLon}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyLat}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyAttc}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyGrndHt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyUgrdHt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyBasc}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ehqkScnCnt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rccCnt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.strcFrmCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.seisCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyGrndCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyHolcYn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyChgeNm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyCottTel}"/>&nbsp;</td>
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
