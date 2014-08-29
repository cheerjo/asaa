<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : IddlAassRlstList.jsp
  * @Description : IddlAassRlst List 화면
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
   	document.getElementById("listForm").action = "<c:url value='/iddlAassRlst/updateIddlAassRlstView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/iddlAassRlst/addIddlAassRlstView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/iddlAassRlst/IddlAassRlstList.do'/>";
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
								<th align="center">FctyCd</th>
								<th align="center">IddlAassNo</th>
								<th align="center">RsltMaxIdrX</th>
								<th align="center">RsltMaxIdrY</th>
								<th align="center">RsltOvrAccX</th>
								<th align="center">RsltOvrAccY</th>
								<th align="center">RsltNatFrqMvX</th>
								<th align="center">RsltNatFrqMvY</th>
								<th align="center">RsltStrFreeNatFrqX</th>
								<th align="center">RsltStrFreeNatFrqY</th>
								<th align="center">SfChkMaxIdrXRslt</th>
								<th align="center">SfChkMaxIdrYRslt</th>
								<th align="center">SfChkNatFrqMvXRslt</th>
								<th align="center">SfChkNatFrqMvYRslt</th>
								<th align="center">SfChkStrFreeNatFrqX</th>
								<th align="center">SfChkStrFreeNatFrqY</th>
								<th align="center">SfChkOvrAccXRslt</th>
								<th align="center">SfChkOvrAccYRslt</th>
								<th align="center">DataFreeMaxDispX</th>
								<th align="center">DataFreeMaxDispY</th>
								<th align="center">DataTopRelMaxSpedX</th>
								<th align="center">DataTopRelMaxSpedY</th>
								<th align="center">DataTopRelMaxDispX</th>
								<th align="center">DataTopRelMaxDispY</th>
								<th align="center">DataFreeAccX</th>
								<th align="center">DataFreeAccY</th>
								<th align="center">DataFreeAccZ</th>
								<th align="center">DataStrBotAccX</th>
								<th align="center">DataStrBotAccY</th>
								<th align="center">DataStrBotAccZ</th>
								<th align="center">DataStrMidAccX</th>
								<th align="center">DataStrMidAccY1</th>
								<th align="center">DataStrMidAccY2</th>
								<th align="center">DataStrTopAccX</th>
								<th align="center">DataStrTopAccY1</th>
								<th align="center">DataStrTopAccY2</th>
								<th align="center">DataStrFrqX</th>
								<th align="center">DataStrFrqY</th>
								<th align="center">DataFreeFrq</th>
								<th align="center">InptUsrId</th>
								<th align="center">InptDt</th>
								<th align="center">UpdtUsrId</th>
								<th align="center">UpdtDt</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
																			<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.fctyCd}"/>', '<c:out value="${result.iddlAassNo}"/>')"><c:out value="${result.fctyCd}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.fctyCd}"/>', '<c:out value="${result.iddlAassNo}"/>')"><c:out value="${result.iddlAassNo}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rsltMaxIdrX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rsltMaxIdrY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rsltOvrAccX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rsltOvrAccY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rsltNatFrqMvX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rsltNatFrqMvY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rsltStrFreeNatFrqX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rsltStrFreeNatFrqY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfChkMaxIdrXRslt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfChkMaxIdrYRslt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfChkNatFrqMvXRslt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfChkNatFrqMvYRslt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfChkStrFreeNatFrqX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfChkStrFreeNatFrqY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfChkOvrAccXRslt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfChkOvrAccYRslt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataFreeMaxDispX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataFreeMaxDispY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataTopRelMaxSpedX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataTopRelMaxSpedY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataTopRelMaxDispX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataTopRelMaxDispY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataFreeAccX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataFreeAccY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataFreeAccZ}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataStrBotAccX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataStrBotAccY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataStrBotAccZ}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataStrMidAccX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataStrMidAccY1}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataStrMidAccY2}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataStrTopAccX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataStrTopAccY1}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataStrTopAccY2}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataStrFrqX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataStrFrqY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.dataFreeFrq}"/>&nbsp;</td>
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
