<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : FctyMgrList.jsp
  * @Description : FctyMgr List 화면
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


function fn_egov_select(fctyCd) {
	document.getElementById("listForm").fctyCd.value = fctyCd;
   	document.getElementById("listForm").action = "<c:url value='/fctyMgr/updateFctyMgrView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/fctyMgr/addFctyMgrView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/fctyMgr/FctyMgrList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="fctyCd" />
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
							</colgroup>		  
			<tr>
								<th align="center">FctyCd</th>
								<th align="center">GvmtCd</th>
								<th align="center">FctyNm</th>
								<th align="center">FctyEsmtStdt</th>
								<th align="center">FctyEsmtEddt</th>
								<th align="center">FctyAreaCd</th>
								<th align="center">FctyStAddr</th>
								<th align="center">FctyEdAddr</th>
								<th align="center">FctyKndCd</th>
								<th align="center">FctyLon</th>
								<th align="center">FctyLat</th>
								<th align="center">FctyAttc</th>
								<th align="center">FctyGrndHt</th>
								<th align="center">FctyUgrdHt</th>
								<th align="center">FctyBasc</th>
								<th align="center">FctyGrndCd</th>
								<th align="center">FctyHolcYn</th>
								<th align="center">InptUsrId</th>
								<th align="center">InptDt</th>
								<th align="center">UpdtUsrId</th>
								<th align="center">UpdtDt</th>
								<th align="center">SeisCd</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
													<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.fctyCd}"/>')"><c:out value="${result.fctyCd}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.gvmtCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyNm}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyEsmtStdt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyEsmtEddt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyAreaCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyStAddr}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyEdAddr}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyKndCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyLon}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyLat}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyAttc}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyGrndHt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyUgrdHt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyBasc}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyGrndCd}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.fctyHolcYn}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.inptUsrId}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.inptDt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.updtUsrId}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.updtDt}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.seisCd}"/>&nbsp;</td>
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
