<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : AnysIdxCoffCfgRegister.jsp
  * @Description : AnysIdxCoffCfg Register 화면
  * @Modification Information
  * 
  * @author atres
  * @since 2013.11.30
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

<c:set var="registerFlag" value="${empty anysIdxCoffCfgVO.anysIdxCoffNo ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="anysIdxCoffCfgVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/anysIdxCoffCfg/AnysIdxCoffCfgList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/anysIdxCoffCfg/deleteAnysIdxCoffCfg.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/anysIdxCoffCfg/addAnysIdxCoffCfg.do' : '/anysIdxCoffCfg/updateAnysIdxCoffCfg.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="anysIdxCoffCfgVO" name="detailForm" id="detailForm" >
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
			<th>SMF_SF</th>
			<td>
				<form:input path="smfSf" cssClass="txt"/>
				&nbsp;<form:errors path="smfSf" />
			</td>
		</tr>	
		<tr>
			<th>SMF_CHK</th>
			<td>
				<form:input path="smfChk" cssClass="txt"/>
				&nbsp;<form:errors path="smfChk" />
			</td>
		</tr>	
		<tr>
			<th>SEF_SF</th>
			<td>
				<form:input path="sefSf" cssClass="txt"/>
				&nbsp;<form:errors path="sefSf" />
			</td>
		</tr>	
		<tr>
			<th>SEF_CHK</th>
			<td>
				<form:input path="sefChk" cssClass="txt"/>
				&nbsp;<form:errors path="sefChk" />
			</td>
		</tr>	
		<tr>
			<th>RCF_SF</th>
			<td>
				<form:input path="rcfSf" cssClass="txt"/>
				&nbsp;<form:errors path="rcfSf" />
			</td>
		</tr>	
		<tr>
			<th>RCF_CHK</th>
			<td>
				<form:input path="rcfChk" cssClass="txt"/>
				&nbsp;<form:errors path="rcfChk" />
			</td>
		</tr>	
		<tr>
			<th>RCSW_SF</th>
			<td>
				<form:input path="rcswSf" cssClass="txt"/>
				&nbsp;<form:errors path="rcswSf" />
			</td>
		</tr>	
		<tr>
			<th>RCSW_CHK</th>
			<td>
				<form:input path="rcswChk" cssClass="txt"/>
				&nbsp;<form:errors path="rcswChk" />
			</td>
		</tr>	
		<tr>
			<th>NAT_FRQ_RNG</th>
			<td>
				<form:input path="natFrqRng" cssClass="txt"/>
				&nbsp;<form:errors path="natFrqRng" />
			</td>
		</tr>	
		<tr>
			<th>STR_FREE_NAT_FRQ_RNG</th>
			<td>
				<form:input path="strFreeNatFrqRng" cssClass="txt"/>
				&nbsp;<form:errors path="strFreeNatFrqRng" />
			</td>
		</tr>	
		<tr>
			<th>OVR_ACC_RNG</th>
			<td>
				<form:input path="ovrAccRng" cssClass="txt"/>
				&nbsp;<form:errors path="ovrAccRng" />
			</td>
		</tr>	
		<tr>
			<th>STR_FRQ_WIN_MJ_H</th>
			<td>
				<form:input path="strFrqWinMjH" cssClass="txt"/>
				&nbsp;<form:errors path="strFrqWinMjH" />
			</td>
		</tr>	
		<tr>
			<th>STR_FRQ_WIN_MJ_L</th>
			<td>
				<form:input path="strFrqWinMjL" cssClass="txt"/>
				&nbsp;<form:errors path="strFrqWinMjL" />
			</td>
		</tr>	
		<tr>
			<th>STR_FRQ_WIN_SHOT_H</th>
			<td>
				<form:input path="strFrqWinShotH" cssClass="txt"/>
				&nbsp;<form:errors path="strFrqWinShotH" />
			</td>
		</tr>	
		<tr>
			<th>STR_FRQ_WIN_SHOT_L</th>
			<td>
				<form:input path="strFrqWinShotL" cssClass="txt"/>
				&nbsp;<form:errors path="strFrqWinShotL" />
			</td>
		</tr>	
		<tr>
			<th>FRQ_WIN_LENT</th>
			<td>
				<form:input path="frqWinLent" cssClass="txt"/>
				&nbsp;<form:errors path="frqWinLent" />
			</td>
		</tr>	
		<tr>
			<th>MOV_TRM_LENT</th>
			<td>
				<form:input path="movTrmLent" cssClass="txt"/>
				&nbsp;<form:errors path="movTrmLent" />
			</td>
		</tr>	
		<tr>
			<th>IDR_AMP</th>
			<td>
				<form:input path="idrAmp" cssClass="txt"/>
				&nbsp;<form:errors path="idrAmp" />
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

