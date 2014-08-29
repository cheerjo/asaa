<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : RptMgrRegister.jsp
  * @Description : RptMgr Register 화면
  * @Modification Information
  * 
  * @author atres
  * @since 2013.1016
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

<c:set var="registerFlag" value="${empty rptMgrVO.iptDt ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="rptMgrVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/rptMgr/RptMgrList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/rptMgr/deleteRptMgr.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/rptMgr/addRptMgr.do' : '/rptMgr/updateRptMgr.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="rptMgrVO" name="detailForm" id="detailForm" >
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
			<th>OBS_NAME</th>
			<td>
				<form:input path="obsName" cssClass="txt"/>
				&nbsp;<form:errors path="obsName" />
			</td>
		</tr>	
		<tr>
			<th>OPEN_DATE</th>
			<td>
				<form:input path="openDate" cssClass="txt"/>
				&nbsp;<form:errors path="openDate" />
			</td>
		</tr>	
		<tr>
			<th>OFF_DATE</th>
			<td>
				<form:input path="offDate" cssClass="txt"/>
				&nbsp;<form:errors path="offDate" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_AREA_CD</th>
			<td>
				<form:input path="fctyAreaCd" cssClass="txt"/>
				&nbsp;<form:errors path="fctyAreaCd" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_ADDR</th>
			<td>
				<form:input path="fctyAddr" cssClass="txt"/>
				&nbsp;<form:errors path="fctyAddr" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_KND_CD</th>
			<td>
				<form:input path="fctyKndCd" cssClass="txt"/>
				&nbsp;<form:errors path="fctyKndCd" />
			</td>
		</tr>	
		<tr>
			<th>MECH_POTN</th>
			<td>
				<form:input path="mechPotn" cssClass="txt"/>
				&nbsp;<form:errors path="mechPotn" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_LON</th>
			<td>
				<form:input path="fctyLon" cssClass="txt"/>
				&nbsp;<form:errors path="fctyLon" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_LAT</th>
			<td>
				<form:input path="fctyLat" cssClass="txt"/>
				&nbsp;<form:errors path="fctyLat" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_ATTC</th>
			<td>
				<form:input path="fctyAttc" cssClass="txt"/>
				&nbsp;<form:errors path="fctyAttc" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_GRND_HT</th>
			<td>
				<form:input path="fctyGrndHt" cssClass="txt"/>
				&nbsp;<form:errors path="fctyGrndHt" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_UGRD_HT</th>
			<td>
				<form:input path="fctyUgrdHt" cssClass="txt"/>
				&nbsp;<form:errors path="fctyUgrdHt" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_BASC</th>
			<td>
				<form:input path="fctyBasc" cssClass="txt"/>
				&nbsp;<form:errors path="fctyBasc" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCN_CNT</th>
			<td>
				<form:input path="ehqkScnCnt" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScnCnt" />
			</td>
		</tr>	
		<tr>
			<th>RCC_CNT</th>
			<td>
				<form:input path="rccCnt" cssClass="txt"/>
				&nbsp;<form:errors path="rccCnt" />
			</td>
		</tr>	
		<tr>
			<th>STRC_FRM_CD</th>
			<td>
				<form:input path="strcFrmCd" cssClass="txt"/>
				&nbsp;<form:errors path="strcFrmCd" />
			</td>
		</tr>	
		<tr>
			<th>SEIS_CD</th>
			<td>
				<form:input path="seisCd" cssClass="txt"/>
				&nbsp;<form:errors path="seisCd" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_GRND_CD</th>
			<td>
				<form:input path="fctyGrndCd" cssClass="txt"/>
				&nbsp;<form:errors path="fctyGrndCd" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_HOLC_YN</th>
			<td>
				<form:input path="fctyHolcYn" cssClass="txt"/>
				&nbsp;<form:errors path="fctyHolcYn" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_CHGE_NM</th>
			<td>
				<form:input path="fctyChgeNm" cssClass="txt"/>
				&nbsp;<form:errors path="fctyChgeNm" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_COTT_TEL</th>
			<td>
				<form:input path="fctyCottTel" cssClass="txt"/>
				&nbsp;<form:errors path="fctyCottTel" />
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

