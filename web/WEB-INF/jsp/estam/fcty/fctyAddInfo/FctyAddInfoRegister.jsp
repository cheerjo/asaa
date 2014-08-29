<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : FctyAddInfoRegister.jsp
  * @Description : FctyAddInfo Register 화면
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

<c:set var="registerFlag" value="${empty fctyAddInfoVO.fctyCd ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="fctyAddInfoVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/fctyAddInfo/FctyAddInfoList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/fctyAddInfo/deleteFctyAddInfo.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/fctyAddInfo/addFctyAddInfo.do' : '/fctyAddInfo/updateFctyAddInfo.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="fctyAddInfoVO" name="detailForm" id="detailForm" >
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
			<th>FCTY_STBL_DT</th>
			<td>
				<form:input path="fctyStblDt" cssClass="txt"/>
				&nbsp;<form:errors path="fctyStblDt" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_CTAT_DT</th>
			<td>
				<form:input path="fctyCtatDt" cssClass="txt"/>
				&nbsp;<form:errors path="fctyCtatDt" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_CPLN_DT</th>
			<td>
				<form:input path="fctyCplnDt" cssClass="txt"/>
				&nbsp;<form:errors path="fctyCplnDt" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_GBN_CD</th>
			<td>
				<form:input path="fctyGbnCd" cssClass="txt"/>
				&nbsp;<form:errors path="fctyGbnCd" />
			</td>
		</tr>	
		<tr>
			<th>EHQK_AREA_CD</th>
			<td>
				<form:input path="ehqkAreaCd" cssClass="txt"/>
				&nbsp;<form:errors path="ehqkAreaCd" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_STR_TYCD</th>
			<td>
				<form:input path="fctyStrTycd" cssClass="txt"/>
				&nbsp;<form:errors path="fctyStrTycd" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_LVCS_CD</th>
			<td>
				<form:input path="fctyLvcsCd" cssClass="txt"/>
				&nbsp;<form:errors path="fctyLvcsCd" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_BOT_AREA</th>
			<td>
				<form:input path="fctyBotArea" cssClass="txt"/>
				&nbsp;<form:errors path="fctyBotArea" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_FLOR_SCL</th>
			<td>
				<form:input path="fctyFlorScl" cssClass="txt"/>
				&nbsp;<form:errors path="fctyFlorScl" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_ROF_HT</th>
			<td>
				<form:input path="fctyRofHt" cssClass="txt"/>
				&nbsp;<form:errors path="fctyRofHt" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_DSGN_CTRA_CD</th>
			<td>
				<form:input path="fctyDsgnCtraCd" cssClass="txt"/>
				&nbsp;<form:errors path="fctyDsgnCtraCd" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_HT</th>
			<td>
				<form:input path="fctyHt" cssClass="txt"/>
				&nbsp;<form:errors path="fctyHt" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_USR_DEPT</th>
			<td>
				<form:input path="fctyUsrDept" cssClass="txt"/>
				&nbsp;<form:errors path="fctyUsrDept" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_USR_NM</th>
			<td>
				<form:input path="fctyUsrNm" cssClass="txt"/>
				&nbsp;<form:errors path="fctyUsrNm" />
			</td>
		</tr>	
		<tr>
			<th>FACTY_USR_TEL</th>
			<td>
				<form:input path="factyUsrTel" cssClass="txt"/>
				&nbsp;<form:errors path="factyUsrTel" />
			</td>
		</tr>	
		<tr>
			<th>FCTY_USR_EMAIL</th>
			<td>
				<form:input path="fctyUsrEmail" cssClass="txt"/>
				&nbsp;<form:errors path="fctyUsrEmail" />
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

