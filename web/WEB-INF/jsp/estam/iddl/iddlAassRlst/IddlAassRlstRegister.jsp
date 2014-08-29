<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : IddlAassRlstRegister.jsp
  * @Description : IddlAassRlst Register 화면
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

<c:set var="registerFlag" value="${empty iddlAassRlstVO.fctyCd ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="iddlAassRlstVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/iddlAassRlst/IddlAassRlstList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/iddlAassRlst/deleteIddlAassRlst.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/iddlAassRlst/addIddlAassRlst.do' : '/iddlAassRlst/updateIddlAassRlst.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="iddlAassRlstVO" name="detailForm" id="detailForm" >
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
			<th>RSLT_MAX_IDR_X</th>
			<td>
				<form:input path="rsltMaxIdrX" cssClass="txt"/>
				&nbsp;<form:errors path="rsltMaxIdrX" />
			</td>
		</tr>	
		<tr>
			<th>RSLT_MAX_IDR_Y</th>
			<td>
				<form:input path="rsltMaxIdrY" cssClass="txt"/>
				&nbsp;<form:errors path="rsltMaxIdrY" />
			</td>
		</tr>	
		<tr>
			<th>RSLT_OVR_ACC_X</th>
			<td>
				<form:input path="rsltOvrAccX" cssClass="txt"/>
				&nbsp;<form:errors path="rsltOvrAccX" />
			</td>
		</tr>	
		<tr>
			<th>RSLT_OVR_ACC_Y</th>
			<td>
				<form:input path="rsltOvrAccY" cssClass="txt"/>
				&nbsp;<form:errors path="rsltOvrAccY" />
			</td>
		</tr>	
		<tr>
			<th>RSLT_NAT_FRQ_MV_X</th>
			<td>
				<form:input path="rsltNatFrqMvX" cssClass="txt"/>
				&nbsp;<form:errors path="rsltNatFrqMvX" />
			</td>
		</tr>	
		<tr>
			<th>RSLT_NAT_FRQ_MV_Y</th>
			<td>
				<form:input path="rsltNatFrqMvY" cssClass="txt"/>
				&nbsp;<form:errors path="rsltNatFrqMvY" />
			</td>
		</tr>	
		<tr>
			<th>RSLT_STR_FREE_NAT_FRQ_X</th>
			<td>
				<form:input path="rsltStrFreeNatFrqX" cssClass="txt"/>
				&nbsp;<form:errors path="rsltStrFreeNatFrqX" />
			</td>
		</tr>	
		<tr>
			<th>RSLT_STR_FREE_NAT_FRQ_Y</th>
			<td>
				<form:input path="rsltStrFreeNatFrqY" cssClass="txt"/>
				&nbsp;<form:errors path="rsltStrFreeNatFrqY" />
			</td>
		</tr>	
		<tr>
			<th>SF_CHK_MAX_IDR_X_RSLT</th>
			<td>
				<form:input path="sfChkMaxIdrXRslt" cssClass="txt"/>
				&nbsp;<form:errors path="sfChkMaxIdrXRslt" />
			</td>
		</tr>	
		<tr>
			<th>SF_CHK_MAX_IDR_Y_RSLT</th>
			<td>
				<form:input path="sfChkMaxIdrYRslt" cssClass="txt"/>
				&nbsp;<form:errors path="sfChkMaxIdrYRslt" />
			</td>
		</tr>	
		<tr>
			<th>SF_CHK_NAT_FRQ_MV_X_RSLT</th>
			<td>
				<form:input path="sfChkNatFrqMvXRslt" cssClass="txt"/>
				&nbsp;<form:errors path="sfChkNatFrqMvXRslt" />
			</td>
		</tr>	
		<tr>
			<th>SF_CHK_NAT_FRQ_MV_Y_RSLT</th>
			<td>
				<form:input path="sfChkNatFrqMvYRslt" cssClass="txt"/>
				&nbsp;<form:errors path="sfChkNatFrqMvYRslt" />
			</td>
		</tr>	
		<tr>
			<th>SF_CHK_STR_FREE_NAT_FRQ_X</th>
			<td>
				<form:input path="sfChkStrFreeNatFrqX" cssClass="txt"/>
				&nbsp;<form:errors path="sfChkStrFreeNatFrqX" />
			</td>
		</tr>	
		<tr>
			<th>SF_CHK_STR_FREE_NAT_FRQ_Y</th>
			<td>
				<form:input path="sfChkStrFreeNatFrqY" cssClass="txt"/>
				&nbsp;<form:errors path="sfChkStrFreeNatFrqY" />
			</td>
		</tr>	
		<tr>
			<th>SF_CHK_OVR_ACC_X_RSLT</th>
			<td>
				<form:input path="sfChkOvrAccXRslt" cssClass="txt"/>
				&nbsp;<form:errors path="sfChkOvrAccXRslt" />
			</td>
		</tr>	
		<tr>
			<th>SF_CHK_OVR_ACC_Y_RSLT</th>
			<td>
				<form:input path="sfChkOvrAccYRslt" cssClass="txt"/>
				&nbsp;<form:errors path="sfChkOvrAccYRslt" />
			</td>
		</tr>	
		<tr>
			<th>DATA_FREE_MAX_DISP_X</th>
			<td>
				<form:input path="dataFreeMaxDispX" cssClass="txt"/>
				&nbsp;<form:errors path="dataFreeMaxDispX" />
			</td>
		</tr>	
		<tr>
			<th>DATA_FREE_MAX_DISP_Y</th>
			<td>
				<form:input path="dataFreeMaxDispY" cssClass="txt"/>
				&nbsp;<form:errors path="dataFreeMaxDispY" />
			</td>
		</tr>	
		<tr>
			<th>DATA_TOP_REL_MAX_SPED_X</th>
			<td>
				<form:input path="dataTopRelMaxSpedX" cssClass="txt"/>
				&nbsp;<form:errors path="dataTopRelMaxSpedX" />
			</td>
		</tr>	
		<tr>
			<th>DATA_TOP_REL_MAX_SPED_Y</th>
			<td>
				<form:input path="dataTopRelMaxSpedY" cssClass="txt"/>
				&nbsp;<form:errors path="dataTopRelMaxSpedY" />
			</td>
		</tr>	
		<tr>
			<th>DATA_TOP_REL_MAX_DISP_X</th>
			<td>
				<form:input path="dataTopRelMaxDispX" cssClass="txt"/>
				&nbsp;<form:errors path="dataTopRelMaxDispX" />
			</td>
		</tr>	
		<tr>
			<th>DATA_TOP_REL_MAX_DISP_Y</th>
			<td>
				<form:input path="dataTopRelMaxDispY" cssClass="txt"/>
				&nbsp;<form:errors path="dataTopRelMaxDispY" />
			</td>
		</tr>	
		<tr>
			<th>DATA_FREE_ACC_X</th>
			<td>
				<form:input path="dataFreeAccX" cssClass="txt"/>
				&nbsp;<form:errors path="dataFreeAccX" />
			</td>
		</tr>	
		<tr>
			<th>DATA_FREE_ACC_Y</th>
			<td>
				<form:input path="dataFreeAccY" cssClass="txt"/>
				&nbsp;<form:errors path="dataFreeAccY" />
			</td>
		</tr>	
		<tr>
			<th>DATA_FREE_ACC_Z</th>
			<td>
				<form:input path="dataFreeAccZ" cssClass="txt"/>
				&nbsp;<form:errors path="dataFreeAccZ" />
			</td>
		</tr>	
		<tr>
			<th>DATA_STR_BOT_ACC_X</th>
			<td>
				<form:input path="dataStrBotAccX" cssClass="txt"/>
				&nbsp;<form:errors path="dataStrBotAccX" />
			</td>
		</tr>	
		<tr>
			<th>DATA_STR_BOT_ACC_Y</th>
			<td>
				<form:input path="dataStrBotAccY" cssClass="txt"/>
				&nbsp;<form:errors path="dataStrBotAccY" />
			</td>
		</tr>	
		<tr>
			<th>DATA_STR_BOT_ACC_Z</th>
			<td>
				<form:input path="dataStrBotAccZ" cssClass="txt"/>
				&nbsp;<form:errors path="dataStrBotAccZ" />
			</td>
		</tr>	
		<tr>
			<th>DATA_STR_MID_ACC_X</th>
			<td>
				<form:input path="dataStrMidAccX" cssClass="txt"/>
				&nbsp;<form:errors path="dataStrMidAccX" />
			</td>
		</tr>	
		<tr>
			<th>DATA_STR_MID_ACC_Y1</th>
			<td>
				<form:input path="dataStrMidAccY1" cssClass="txt"/>
				&nbsp;<form:errors path="dataStrMidAccY1" />
			</td>
		</tr>	
		<tr>
			<th>DATA_STR_MID_ACC_Y2</th>
			<td>
				<form:input path="dataStrMidAccY2" cssClass="txt"/>
				&nbsp;<form:errors path="dataStrMidAccY2" />
			</td>
		</tr>	
		<tr>
			<th>DATA_STR_TOP_ACC_X</th>
			<td>
				<form:input path="dataStrTopAccX" cssClass="txt"/>
				&nbsp;<form:errors path="dataStrTopAccX" />
			</td>
		</tr>	
		<tr>
			<th>DATA_STR_TOP_ACC_Y1</th>
			<td>
				<form:input path="dataStrTopAccY1" cssClass="txt"/>
				&nbsp;<form:errors path="dataStrTopAccY1" />
			</td>
		</tr>	
		<tr>
			<th>DATA_STR_TOP_ACC_Y2</th>
			<td>
				<form:input path="dataStrTopAccY2" cssClass="txt"/>
				&nbsp;<form:errors path="dataStrTopAccY2" />
			</td>
		</tr>	
		<tr>
			<th>DATA_STR_FRQ_X</th>
			<td>
				<form:input path="dataStrFrqX" cssClass="txt"/>
				&nbsp;<form:errors path="dataStrFrqX" />
			</td>
		</tr>	
		<tr>
			<th>DATA_STR_FRQ_Y</th>
			<td>
				<form:input path="dataStrFrqY" cssClass="txt"/>
				&nbsp;<form:errors path="dataStrFrqY" />
			</td>
		</tr>	
		<tr>
			<th>DATA_FREE_FRQ</th>
			<td>
				<form:input path="dataFreeFrq" cssClass="txt"/>
				&nbsp;<form:errors path="dataFreeFrq" />
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

