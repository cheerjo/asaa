<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : ConMmaDataList.jsp
  * @Description : ConMmaData List 화면
  * @Modification Information
  * 
  * @author atres
  * @since 2013.10.04
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


function fn_egov_select(mmaGvmtCd, mmaFctyLocVal, mmaMsrdDt, mmaMsrdSeq) {
	document.getElementById("listForm").mmaGvmtCd.value = mmaGvmtCd;
	document.getElementById("listForm").mmaFctyLocVal.value = mmaFctyLocVal;
	document.getElementById("listForm").mmaMsrdDt.value = mmaMsrdDt;
	document.getElementById("listForm").mmaMsrdSeq.value = mmaMsrdSeq;
   	document.getElementById("listForm").action = "<c:url value='/conMmaData/updateConMmaDataView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/conMmaData/addConMmaDataView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/conMmaData/ConMmaDataList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="mmaGvmtCd" />
	<input type="hidden" name="mmaFctyLocVal" />
	<input type="hidden" name="mmaMsrdDt" />
	<input type="hidden" name="mmaMsrdSeq" />
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
								<th align="center">MmaGvmtCd</th>
								<th align="center">MmaFctyLocVal</th>
								<th align="center">MmaMsrdDt</th>
								<th align="center">MmaMsrdSeq</th>
								<th align="center">MmaDatetime</th>
								<th align="center">MmaCrc</th>
								<th align="center">MmaQutyFlg</th>
								<th align="center">MmaDataType</th>
								<th align="center">MmaUdWndMinVal</th>
								<th align="center">MmaUdWndMaxVal</th>
								<th align="center">MmaUdWndAvgVal</th>
								<th align="center">MmaNsWndMinVal</th>
								<th align="center">MmaNsWndMaxVal</th>
								<th align="center">MmaNsWndAvgVal</th>
								<th align="center">MmaEwWndMinVal</th>
								<th align="center">MmaEwWndMaxVal</th>
								<th align="center">MmaEwWndAvgVal</th>
								<th align="center">MmaUdTruMinVal</th>
								<th align="center">MmaUdTruMaxVal</th>
								<th align="center">MmaNsTruMinVal</th>
								<th align="center">MmaNsTruMaxVal</th>
								<th align="center">MmaEwTruMinVal</th>
								<th align="center">MmaEwTruMaxVal</th>
								<th align="center">MmaUdMax</th>
								<th align="center">MmaNsMax</th>
								<th align="center">MmaEwMax</th>
								<th align="center">MmaHrtlPga</th>
								<th align="center">MmaTotPga</th>
								<th align="center">Mma32bUdSi</th>
								<th align="center">Mma32bNsSi</th>
								<th align="center">Mma32bEwSi</th>
								<th align="center">MmaHrtlSi</th>
								<th align="center">MmaCrrn</th>
								<th align="center">MmaLocCd</th>
								<th align="center">MmaDaPort</th>
								<th align="center">InptUsrId</th>
								<th align="center">InptDt</th>
								<th align="center">UpdtUsrId</th>
								<th align="center">UpdtDt</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
																															<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.mmaGvmtCd}"/>', '<c:out value="${result.mmaFctyLocVal}"/>', '<c:out value="${result.mmaMsrdDt}"/>', '<c:out value="${result.mmaMsrdSeq}"/>')"><c:out value="${result.mmaGvmtCd}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.mmaGvmtCd}"/>', '<c:out value="${result.mmaFctyLocVal}"/>', '<c:out value="${result.mmaMsrdDt}"/>', '<c:out value="${result.mmaMsrdSeq}"/>')"><c:out value="${result.mmaFctyLocVal}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.mmaGvmtCd}"/>', '<c:out value="${result.mmaFctyLocVal}"/>', '<c:out value="${result.mmaMsrdDt}"/>', '<c:out value="${result.mmaMsrdSeq}"/>')"><c:out value="${result.mmaMsrdDt}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.mmaGvmtCd}"/>', '<c:out value="${result.mmaFctyLocVal}"/>', '<c:out value="${result.mmaMsrdDt}"/>', '<c:out value="${result.mmaMsrdSeq}"/>')"><c:out value="${result.mmaMsrdSeq}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaDatetime}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaCrc}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaQutyFlg}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaDataType}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaUdWndMinVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaUdWndMaxVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaUdWndAvgVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaNsWndMinVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaNsWndMaxVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaNsWndAvgVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaEwWndMinVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaEwWndMaxVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaEwWndAvgVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaUdTruMinVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaUdTruMaxVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaNsTruMinVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaNsTruMaxVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaEwTruMinVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaEwTruMaxVal}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaUdMax}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaNsMax}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaEwMax}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaHrtlPga}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaTotPga}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mma32bUdSi}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mma32bNsSi}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mma32bEwSi}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaHrtlSi}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaCrrn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaLocCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.mmaDaPort}"/>&nbsp;</td>
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
