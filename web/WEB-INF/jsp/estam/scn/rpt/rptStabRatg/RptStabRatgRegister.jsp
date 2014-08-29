<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : RptStabRatgRegister.jsp
  * @Description : RptStabRatg Register 화면
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

<c:set var="registerFlag" value="${empty rptStabRatgVO.iptDt ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="rptStabRatgVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/rptStabRatg/RptStabRatgList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/rptStabRatg/deleteRptStabRatg.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/rptStabRatg/addRptStabRatg.do' : '/rptStabRatg/updateRptStabRatg.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="rptStabRatgVO" name="detailForm" id="detailForm" >
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
			<th>IDR_RNG_MJ</th>
			<td>
				<form:input path="idrRngMj" cssClass="txt"/>
				&nbsp;<form:errors path="idrRngMj" />
			</td>
		</tr>	
		<tr>
			<th>IDR_RNG_SHOT</th>
			<td>
				<form:input path="idrRngShot" cssClass="txt"/>
				&nbsp;<form:errors path="idrRngShot" />
			</td>
		</tr>	
		<tr>
			<th>STR_FRQ_MJ</th>
			<td>
				<form:input path="strFrqMj" cssClass="txt"/>
				&nbsp;<form:errors path="strFrqMj" />
			</td>
		</tr>	
		<tr>
			<th>STR_FRQ_SHOT</th>
			<td>
				<form:input path="strFrqShot" cssClass="txt"/>
				&nbsp;<form:errors path="strFrqShot" />
			</td>
		</tr>	
		<tr>
			<th>GRD_RSNN_PSBY_MJ</th>
			<td>
				<form:input path="grdRsnnPsbyMj" cssClass="txt"/>
				&nbsp;<form:errors path="grdRsnnPsbyMj" />
			</td>
		</tr>	
		<tr>
			<th>GRD_RSNN_PSBY_SHOT</th>
			<td>
				<form:input path="grdRsnnPsbyShot" cssClass="txt"/>
				&nbsp;<form:errors path="grdRsnnPsbyShot" />
			</td>
		</tr>	
		<tr>
			<th>MAX_SCN_MJ</th>
			<td>
				<form:input path="maxScnMj" cssClass="txt"/>
				&nbsp;<form:errors path="maxScnMj" />
			</td>
		</tr>	
		<tr>
			<th>MAX_SCN_SHOT</th>
			<td>
				<form:input path="maxScnShot" cssClass="txt"/>
				&nbsp;<form:errors path="maxScnShot" />
			</td>
		</tr>	
		<tr>
			<th>SF_TOT</th>
			<td>
				<form:input path="sfTot" cssClass="txt"/>
				&nbsp;<form:errors path="sfTot" />
			</td>
		</tr>	
		<tr>
			<th>SF_USR_DEPT</th>
			<td>
				<form:input path="sfUsrDept" cssClass="txt"/>
				&nbsp;<form:errors path="sfUsrDept" />
			</td>
		</tr>	
		<tr>
			<th>SF_USR_DUTY</th>
			<td>
				<form:input path="sfUsrDuty" cssClass="txt"/>
				&nbsp;<form:errors path="sfUsrDuty" />
			</td>
		</tr>	
		<tr>
			<th>SF_USR_NM</th>
			<td>
				<form:input path="sfUsrNm" cssClass="txt"/>
				&nbsp;<form:errors path="sfUsrNm" />
			</td>
		</tr>	
		<tr>
			<th>SF_USR_TEL</th>
			<td>
				<form:input path="sfUsrTel" cssClass="txt"/>
				&nbsp;<form:errors path="sfUsrTel" />
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

