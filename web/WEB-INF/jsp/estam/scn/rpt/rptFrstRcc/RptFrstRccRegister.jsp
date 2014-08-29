<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : RptFrstRccRegister.jsp
  * @Description : RptFrstRcc Register 화면
  * @Modification Information
  * 
  * @author atres
  * @since 2013.10.17
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

<c:set var="registerFlag" value="${empty rptFrstRccVO.iptDt ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="rptFrstRccVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/rptFrstRcc/RptFrstRccList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/rptFrstRcc/deleteRptFrstRcc.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/rptFrstRcc/addRptFrstRcc.do' : '/rptFrstRcc/updateRptFrstRcc.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="rptFrstRccVO" name="detailForm" id="detailForm" >
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
			<th>FCTY_CD</th>
			<td>
				<form:input path="fctyCd" cssClass="txt"/>
				&nbsp;<form:errors path="fctyCd" />
			</td>
		</tr>	
		<tr>
			<th>CON_DA_GBCD</th>
			<td>
				<form:input path="conDaGbcd" cssClass="txt"/>
				&nbsp;<form:errors path="conDaGbcd" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST1_1YN</th>
			<td>
				<form:input path="rccQst11yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst11yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST1_2YN</th>
			<td>
				<form:input path="rccQst12yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst12yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST2_1YN</th>
			<td>
				<form:input path="rccQst21yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst21yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST2_2YN</th>
			<td>
				<form:input path="rccQst22yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst22yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST3_1YN</th>
			<td>
				<form:input path="rccQst31yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst31yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST3_2YN</th>
			<td>
				<form:input path="rccQst32yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst32yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST4_1YN</th>
			<td>
				<form:input path="rccQst41yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst41yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST4_2YN</th>
			<td>
				<form:input path="rccQst42yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst42yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST4_3YN</th>
			<td>
				<form:input path="rccQst43yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst43yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST5_1YN</th>
			<td>
				<form:input path="rccQst51yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst51yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST5_2YN</th>
			<td>
				<form:input path="rccQst52yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst52yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST5_3YN</th>
			<td>
				<form:input path="rccQst53yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst53yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST6_1YN</th>
			<td>
				<form:input path="rccQst61yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst61yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST6_2YN</th>
			<td>
				<form:input path="rccQst62yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst62yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST7_YN</th>
			<td>
				<form:input path="rccQst7Yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst7Yn" />
			</td>
		</tr>	
		<tr>
			<th>RCC_QST8_YN</th>
			<td>
				<form:input path="rccQst8Yn" cssClass="txt"/>
				&nbsp;<form:errors path="rccQst8Yn" />
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

