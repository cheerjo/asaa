<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : RptRglrIptnRegister.jsp
  * @Description : RptRglrIptn Register 화면
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

<c:set var="registerFlag" value="${empty rptRglrIptnVO.iptDt ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="rptRglrIptnVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/rptRglrIptn/RptRglrIptnList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/rptRglrIptn/deleteRptRglrIptn.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/rptRglrIptn/addRptRglrIptn.do' : '/rptRglrIptn/updateRptRglrIptn.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="rptRglrIptnVO" name="detailForm" id="detailForm" >
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>" alt="" /><c:out value="${registerFlag}"/></li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<div id="table">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" >
		<colgroup>
			<col width="150"/>
			<col width=""/>
		</colgroup>
			
		<c:if test="${registerFlag == '수정'}">
	   <tr>
			<th>${model.attribute.get(0).name} *</th>
			<td>
				<form:input path="${model.attribute.get(0).ccName}" cssClass="essentiality" readonly="true" />
			</td>			
		</tr>	
		</c:if>
		<c:if test="${registerFlag == '등록'}">
	   <tr>
			<th>${model.attribute.get(0).name} *</th>
			<td>
				<form:input path="${model.attribute.get(0).ccName}" cssClass="txt" readonly="false" />
			</td>			
		</tr>	
		</c:if>		
		<tr>
			<th>GVMT_CD</th>
			<td>
				<form:input path="gvmtCd" cssClass="txt"/>
				&nbsp;<form:errors path="gvmtCd" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_QST1_1YN</th>
			<td>
				<form:input path="rglrQst11yn" cssClass="txt"/>
				&nbsp;<form:errors path="rglrQst11yn" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_QST1_2YN</th>
			<td>
				<form:input path="rglrQst12yn" cssClass="txt"/>
				&nbsp;<form:errors path="rglrQst12yn" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_QST1_3YN</th>
			<td>
				<form:input path="rglrQst13yn" cssClass="txt"/>
				&nbsp;<form:errors path="rglrQst13yn" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_QST1_4YN</th>
			<td>
				<form:input path="rglrQst14yn" cssClass="txt"/>
				&nbsp;<form:errors path="rglrQst14yn" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_QST2_1YN</th>
			<td>
				<form:input path="rglrQst21yn" cssClass="txt"/>
				&nbsp;<form:errors path="rglrQst21yn" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_QST2_2YN</th>
			<td>
				<form:input path="rglrQst22yn" cssClass="txt"/>
				&nbsp;<form:errors path="rglrQst22yn" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_QST2_3YN</th>
			<td>
				<form:input path="rglrQst23yn" cssClass="txt"/>
				&nbsp;<form:errors path="rglrQst23yn" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_QST2_4YN</th>
			<td>
				<form:input path="rglrQst24yn" cssClass="txt"/>
				&nbsp;<form:errors path="rglrQst24yn" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_QST3_1YN</th>
			<td>
				<form:input path="rglrQst31yn" cssClass="txt"/>
				&nbsp;<form:errors path="rglrQst31yn" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_QST3_2YN</th>
			<td>
				<form:input path="rglrQst32yn" cssClass="txt"/>
				&nbsp;<form:errors path="rglrQst32yn" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_QST4_1YN</th>
			<td>
				<form:input path="rglrQst41yn" cssClass="txt"/>
				&nbsp;<form:errors path="rglrQst41yn" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_QST4_2YN</th>
			<td>
				<form:input path="rglrQst42yn" cssClass="txt"/>
				&nbsp;<form:errors path="rglrQst42yn" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_QST4_3YN</th>
			<td>
				<form:input path="rglrQst43yn" cssClass="txt"/>
				&nbsp;<form:errors path="rglrQst43yn" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_RSLT_CTNT</th>
			<td>
				<form:input path="rglrRsltCtnt" cssClass="txt"/>
				&nbsp;<form:errors path="rglrRsltCtnt" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_MNGE_CTNT</th>
			<td>
				<form:input path="rglrMngeCtnt" cssClass="txt"/>
				&nbsp;<form:errors path="rglrMngeCtnt" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_USR_DEPT</th>
			<td>
				<form:input path="rglrUsrDept" cssClass="txt"/>
				&nbsp;<form:errors path="rglrUsrDept" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_USR_DUTY</th>
			<td>
				<form:input path="rglrUsrDuty" cssClass="txt"/>
				&nbsp;<form:errors path="rglrUsrDuty" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_USR_NM</th>
			<td>
				<form:input path="rglrUsrNm" cssClass="txt"/>
				&nbsp;<form:errors path="rglrUsrNm" />
			</td>
		</tr>	
		<tr>
			<th>RGLR_USR_TEL</th>
			<td>
				<form:input path="rglrUsrTel" cssClass="txt"/>
				&nbsp;<form:errors path="rglrUsrTel" />
			</td>
		</tr>	
		<tr>
			<th>INPT_USR_ID</th>
			<td>
				<form:input path="inptUsrId" cssClass="txt"/>
				&nbsp;<form:errors path="inptUsrId" />
			</td>
		</tr>	
		<tr>
			<th>INPT_DT</th>
			<td>
				<form:input path="inptDt" cssClass="txt"/>
				&nbsp;<form:errors path="inptDt" />
			</td>
		</tr>	
		<tr>
			<th>UPDT_USR_ID</th>
			<td>
				<form:input path="updtUsrId" cssClass="txt"/>
				&nbsp;<form:errors path="updtUsrId" />
			</td>
		</tr>	
		<tr>
			<th>UPDT_DT</th>
			<td>
				<form:input path="updtDt" cssClass="txt"/>
				&nbsp;<form:errors path="updtDt" />
			</td>
		</tr>	
	</table>
  </div>
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();">List</a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" alt="" /></span></li>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_save();"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" alt="" /></span></li>
			<c:if test="${registerFlag == '수정'}">
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();">삭제</a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" alt="" /></span></li>
			</c:if>
			<li><span class="btn_blue_l"><a href="javascript:document.getElementById("detailForm").reset();">Reset</a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" alt="" /></span></li></ul>
	</div>
</div>
<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
</form:form>
</body>
</html>

