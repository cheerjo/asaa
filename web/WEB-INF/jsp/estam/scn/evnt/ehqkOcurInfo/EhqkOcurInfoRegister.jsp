<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : EhqkOcurInfoRegister.jsp
  * @Description : EhqkOcurInfo Register 화면
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

<c:set var="registerFlag" value="${empty ehqkOcurInfoVO.ehqkReqId ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="ehqkOcurInfoVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/ehqkOcurInfo/EhqkOcurInfoList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/ehqkOcurInfo/deleteEhqkOcurInfo.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/ehqkOcurInfo/addEhqkOcurInfo.do' : '/ehqkOcurInfo/updateEhqkOcurInfo.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="ehqkOcurInfoVO" name="detailForm" id="detailForm" >
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
			<th>EHQK_DOC_TPCD</th>
			<td>
				<form:input path="ehqkDocTpcd" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkDocTpcd" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_ORG_TM</th>
			<td>
				<form:input path="ehqkOrgTm" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkOrgTm" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_LON</th>
			<td>
				<form:input path="ehqkLon" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkLon" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_LAT</th>
			<td>
				<form:input path="ehqkLat" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkLat" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_SCAL</th>
			<td>
				<form:input path="ehqkScal" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkScal" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_ORG_AREA</th>
			<td>
				<form:input path="ehqkOrgArea" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkOrgArea" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_EVNT_STTM</th>
			<td>
				<form:input path="ehqkEvntSttm" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkEvntSttm" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_EVNT_EDTM</th>
			<td>
				<form:input path="ehqkEvntEdtm" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkEvntEdtm" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_EVNT_YN</th>
			<td>
				<form:input path="ehqkEvntYn" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkEvntYn" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_STAT_OTR</th>
			<td>
				<form:input path="ehqkStatOtr" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkStatOtr" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_STAT_UP</th>
			<td>
				<form:input path="ehqkStatUp" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkStatUp" />
			</td>
		</tr>	
		<tr>
			<th>GVMT_CD</th>
			<td>
				<form:input path="gvmtCd" cssClass="txt"/>
				&nbsp;<form:errors path="gvmtCd" />
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

