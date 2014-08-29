<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : EhqkScnRegister.jsp
  * @Description : EhqkScn Register 화면
  * @Modification Information
  * 
  * @author atres
  * @since 2013.10.23
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

<c:set var="registerFlag" value="${empty ehqkScnVO.ehqkScnId ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="ehqkScnVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/ehqkScn/EhqkScnList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/ehqkScn/deleteEhqkScn.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/ehqkScn/addEhqkScn.do' : '/ehqkScn/updateEhqkScn.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="ehqkScnVO" name="detailForm" id="detailForm" >
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
			<th>EHQK_SCN_NO</th>
			<td>
				<form:input path="ehqkScnNo" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnNo" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_CMPY</th>
			<td>
				<form:input path="ehqkScnCmpy" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnCmpy" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_MDL</th>
			<td>
				<form:input path="ehqkScnMdl" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnMdl" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_KND_CD</th>
			<td>
				<form:input path="ehqkScnKndCd" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnKndCd" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_MEAS_CD</th>
			<td>
				<form:input path="ehqkScnMeasCd" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnMeasCd" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_PSTN</th>
			<td>
				<form:input path="ehqkScnPstn" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnPstn" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_CHL_VAL</th>
			<td>
				<form:input path="ehqkScnChlVal" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnChlVal" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_LON</th>
			<td>
				<form:input path="ehqkScnLon" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnLon" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_LAT</th>
			<td>
				<form:input path="ehqkScnLat" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnLat" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_Z_RES</th>
			<td>
				<form:input path="ehqkScnZRes" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnZRes" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_N_RES</th>
			<td>
				<form:input path="ehqkScnNRes" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnNRes" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_E_RES</th>
			<td>
				<form:input path="ehqkScnERes" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnERes" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_YN</th>
			<td>
				<form:input path="ehqkScnYn" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnYn" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_MAX_VAL</th>
			<td>
				<form:input path="ehqkScnMaxVal" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnMaxVal" />
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
		<tr>
			<th>RCC_ID</th>
			<td>
				<form:input path="rccId" cssClass="txt"/>
				&nbsp;<form:errors path="rccId" />
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

