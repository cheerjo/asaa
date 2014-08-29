<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : AnysIdxCoffCfgList.jsp
  * @Description : AnysIdxCoffCfg List 화면
  * @Modification Information
  * 
  * @author atres
  * @since 2013.11.30
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


function fn_egov_select(anysIdxCoffNo) {
	document.getElementById("listForm").anysIdxCoffNo.value = anysIdxCoffNo;
   	document.getElementById("listForm").action = "<c:url value='/anysIdxCoffCfg/updateAnysIdxCoffCfgView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/anysIdxCoffCfg/addAnysIdxCoffCfgView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/anysIdxCoffCfg/AnysIdxCoffCfgList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="anysIdxCoffNo" />
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
								<th align="center">AnysIdxCoffNo</th>
								<th align="center">SmfSf</th>
								<th align="center">SmfChk</th>
								<th align="center">SefSf</th>
								<th align="center">SefChk</th>
								<th align="center">RcfSf</th>
								<th align="center">RcfChk</th>
								<th align="center">RcswSf</th>
								<th align="center">RcswChk</th>
								<th align="center">NatFrqRng</th>
								<th align="center">StrFreeNatFrqRng</th>
								<th align="center">OvrAccRng</th>
								<th align="center">StrFrqWinMjH</th>
								<th align="center">StrFrqWinMjL</th>
								<th align="center">StrFrqWinShotH</th>
								<th align="center">StrFrqWinShotL</th>
								<th align="center">FrqWinLent</th>
								<th align="center">MovTrmLent</th>
								<th align="center">IdrAmp</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
													<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.anysIdxCoffNo}"/>')"><c:out value="${result.anysIdxCoffNo}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.smfSf}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.smfChk}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sefSf}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sefChk}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rcfSf}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rcfChk}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rcswSf}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.rcswChk}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.natFrqRng}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.strFreeNatFrqRng}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.ovrAccRng}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.strFrqWinMjH}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.strFrqWinMjL}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.strFrqWinShotH}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.strFrqWinShotL}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.frqWinLent}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.movTrmLent}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.idrAmp}"/>&nbsp;</td>
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
