<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : IddlAassOpinVList.jsp
  * @Description : IddlAassOpinV List 화면
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
   	document.getElementById("listForm").action = "<c:url value='/iddlAassOpinV/updateIddlAassOpinVView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/iddlAassOpinV/addIddlAassOpinVView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/iddlAassOpinV/IddlAassOpinVList.do'/>";
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
								<th align="center">ScnFitrFreeX</th>
								<th align="center">ScnFitrFreeY</th>
								<th align="center">ScnFitrFreeZ</th>
								<th align="center">ScnFitrBotX</th>
								<th align="center">ScnFitrBotY</th>
								<th align="center">ScnFitrBotZ</th>
								<th align="center">ScnFitrMidX</th>
								<th align="center">ScnFitrMidY1</th>
								<th align="center">ScnFitrMidY2</th>
								<th align="center">ScnFitrTopX</th>
								<th align="center">ScnFitrTopY1</th>
								<th align="center">ScnFitrTopY2</th>
								<th align="center">AnaOpinIdrAmp</th>
								<th align="center">AnaOpinSimcArea</th>
								<th align="center">AnaOpinStrHei</th>
								<th align="center">AnaOpinStrTycd</th>
								<th align="center">AnaOpinStrNm</th>
								<th align="center">AnaOpinStrFrqWinMjL</th>
								<th align="center">AnaOpinStrFrqWinMjH</th>
								<th align="center">AnaOpinStrFrqWinShotL</th>
								<th align="center">AnaOpinStrFrqWinShotH</th>
								<th align="center">AnaOpinLimiStatMenSlit</th>
								<th align="center">AnaOpinLimiStatMenNor</th>
								<th align="center">AnaOpinLimiStatMenHsh</th>
								<th align="center">AnaOpinLimiStatSlit</th>
								<th align="center">AnaOpinLimiStatNor</th>
								<th align="center">AnaOpinLimiStatHsh</th>
								<th align="center">AnaOpinFrqPrvX</th>
								<th align="center">AnaOpinFrqPrvY</th>
								<th align="center">SfIdrRngSmfSf</th>
								<th align="center">SfIdrRngSmfChk</th>
								<th align="center">SfIdrRngSmfHsh</th>
								<th align="center">SfIdrRngSmfShr</th>
								<th align="center">SfIdrRngSefSf</th>
								<th align="center">SfIdrRngSefChk</th>
								<th align="center">SfIdrRngSefHsh</th>
								<th align="center">SfIdrRngSefShr</th>
								<th align="center">SfIdrRngRcfSf</th>
								<th align="center">SfIdrRngRcfChk</th>
								<th align="center">SfIdrRngRcfHsh</th>
								<th align="center">SfIdrRngRcfShr</th>
								<th align="center">SfIdrRngRcswSf</th>
								<th align="center">SfIdrRngRcswChk</th>
								<th align="center">SfIdrRngRcswHsh</th>
								<th align="center">SfIdrRngRcswShr</th>
								<th align="center">SfNatFrqRng</th>
								<th align="center">SfStrFreeNatFrqRng</th>
								<th align="center">SfOvrAccRng</th>
								<th align="center">InptUsrId</th>
								<th align="center">InptDt</th>
								<th align="center">UpdtUsrId</th>
								<th align="center">UpdtDt</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
																			<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.fctyCd}"/>', '<c:out value="${result.iddlAassNo}"/>')"><c:out value="${result.fctyCd}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.fctyCd}"/>', '<c:out value="${result.iddlAassNo}"/>')"><c:out value="${result.iddlAassNo}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.scnFitrFreeX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.scnFitrFreeY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.scnFitrFreeZ}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.scnFitrBotX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.scnFitrBotY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.scnFitrBotZ}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.scnFitrMidX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.scnFitrMidY1}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.scnFitrMidY2}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.scnFitrTopX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.scnFitrTopY1}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.scnFitrTopY2}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinIdrAmp}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinSimcArea}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinStrHei}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinStrTycd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinStrNm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinStrFrqWinMjL}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinStrFrqWinMjH}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinStrFrqWinShotL}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinStrFrqWinShotH}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinLimiStatMenSlit}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinLimiStatMenNor}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinLimiStatMenHsh}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinLimiStatSlit}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinLimiStatNor}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinLimiStatHsh}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinFrqPrvX}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.anaOpinFrqPrvY}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngSmfSf}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngSmfChk}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngSmfHsh}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngSmfShr}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngSefSf}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngSefChk}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngSefHsh}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngSefShr}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngRcfSf}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngRcfChk}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngRcfHsh}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngRcfShr}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngRcswSf}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngRcswChk}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngRcswHsh}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfIdrRngRcswShr}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfNatFrqRng}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfStrFreeNatFrqRng}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.sfOvrAccRng}"/>&nbsp;</td>
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
