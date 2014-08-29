<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : IddlAassOpinVRegister.jsp
  * @Description : IddlAassOpinV Register 화면
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

<c:set var="registerFlag" value="${empty iddlAassOpinVVO.fctyCd ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="iddlAassOpinVVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/iddlAassOpinV/IddlAassOpinVList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/iddlAassOpinV/deleteIddlAassOpinV.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/iddlAassOpinV/addIddlAassOpinV.do' : '/iddlAassOpinV/updateIddlAassOpinV.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="iddlAassOpinVVO" name="detailForm" id="detailForm" >
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
			<th>SCN_FITR_FREE_X</th>
			<td>
				<form:input path="scnFitrFreeX" cssClass="txt"/>
				&nbsp;<form:errors path="scnFitrFreeX" />
			</td>
		</tr>	
		<tr>
			<th>SCN_FITR_FREE_Y</th>
			<td>
				<form:input path="scnFitrFreeY" cssClass="txt"/>
				&nbsp;<form:errors path="scnFitrFreeY" />
			</td>
		</tr>	
		<tr>
			<th>SCN_FITR_FREE_Z</th>
			<td>
				<form:input path="scnFitrFreeZ" cssClass="txt"/>
				&nbsp;<form:errors path="scnFitrFreeZ" />
			</td>
		</tr>	
		<tr>
			<th>SCN_FITR_BOT_X</th>
			<td>
				<form:input path="scnFitrBotX" cssClass="txt"/>
				&nbsp;<form:errors path="scnFitrBotX" />
			</td>
		</tr>	
		<tr>
			<th>SCN_FITR_BOT_Y</th>
			<td>
				<form:input path="scnFitrBotY" cssClass="txt"/>
				&nbsp;<form:errors path="scnFitrBotY" />
			</td>
		</tr>	
		<tr>
			<th>SCN_FITR_BOT_Z</th>
			<td>
				<form:input path="scnFitrBotZ" cssClass="txt"/>
				&nbsp;<form:errors path="scnFitrBotZ" />
			</td>
		</tr>	
		<tr>
			<th>SCN_FITR_MID_X</th>
			<td>
				<form:input path="scnFitrMidX" cssClass="txt"/>
				&nbsp;<form:errors path="scnFitrMidX" />
			</td>
		</tr>	
		<tr>
			<th>SCN_FITR_MID_Y1</th>
			<td>
				<form:input path="scnFitrMidY1" cssClass="txt"/>
				&nbsp;<form:errors path="scnFitrMidY1" />
			</td>
		</tr>	
		<tr>
			<th>SCN_FITR_MID_Y2</th>
			<td>
				<form:input path="scnFitrMidY2" cssClass="txt"/>
				&nbsp;<form:errors path="scnFitrMidY2" />
			</td>
		</tr>	
		<tr>
			<th>SCN_FITR_TOP_X</th>
			<td>
				<form:input path="scnFitrTopX" cssClass="txt"/>
				&nbsp;<form:errors path="scnFitrTopX" />
			</td>
		</tr>	
		<tr>
			<th>SCN_FITR_TOP_Y1</th>
			<td>
				<form:input path="scnFitrTopY1" cssClass="txt"/>
				&nbsp;<form:errors path="scnFitrTopY1" />
			</td>
		</tr>	
		<tr>
			<th>SCN_FITR_TOP_Y2</th>
			<td>
				<form:input path="scnFitrTopY2" cssClass="txt"/>
				&nbsp;<form:errors path="scnFitrTopY2" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_IDR_AMP</th>
			<td>
				<form:input path="anaOpinIdrAmp" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinIdrAmp" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_SIMC_AREA</th>
			<td>
				<form:input path="anaOpinSimcArea" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinSimcArea" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_STR_HEI</th>
			<td>
				<form:input path="anaOpinStrHei" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinStrHei" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_STR_TYCD</th>
			<td>
				<form:input path="anaOpinStrTycd" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinStrTycd" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_STR_NM</th>
			<td>
				<form:input path="anaOpinStrNm" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinStrNm" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_STR_FRQ_WIN_MJ_L</th>
			<td>
				<form:input path="anaOpinStrFrqWinMjL" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinStrFrqWinMjL" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_STR_FRQ_WIN_MJ_H</th>
			<td>
				<form:input path="anaOpinStrFrqWinMjH" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinStrFrqWinMjH" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_STR_FRQ_WIN_SHOT_L</th>
			<td>
				<form:input path="anaOpinStrFrqWinShotL" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinStrFrqWinShotL" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_STR_FRQ_WIN_SHOT_H</th>
			<td>
				<form:input path="anaOpinStrFrqWinShotH" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinStrFrqWinShotH" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_LIMI_STAT_MEN_SLIT</th>
			<td>
				<form:input path="anaOpinLimiStatMenSlit" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinLimiStatMenSlit" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_LIMI_STAT_MEN_NOR</th>
			<td>
				<form:input path="anaOpinLimiStatMenNor" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinLimiStatMenNor" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_LIMI_STAT_MEN_HSH</th>
			<td>
				<form:input path="anaOpinLimiStatMenHsh" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinLimiStatMenHsh" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_LIMI_STAT_SLIT</th>
			<td>
				<form:input path="anaOpinLimiStatSlit" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinLimiStatSlit" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_LIMI_STAT_NOR</th>
			<td>
				<form:input path="anaOpinLimiStatNor" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinLimiStatNor" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_LIMI_STAT_HSH</th>
			<td>
				<form:input path="anaOpinLimiStatHsh" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinLimiStatHsh" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_FRQ_PRV_X</th>
			<td>
				<form:input path="anaOpinFrqPrvX" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinFrqPrvX" />
			</td>
		</tr>	
		<tr>
			<th>ANA_OPIN_FRQ_PRV_Y</th>
			<td>
				<form:input path="anaOpinFrqPrvY" cssClass="txt"/>
				&nbsp;<form:errors path="anaOpinFrqPrvY" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_SMF_SF</th>
			<td>
				<form:input path="sfIdrRngSmfSf" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngSmfSf" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_SMF_CHK</th>
			<td>
				<form:input path="sfIdrRngSmfChk" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngSmfChk" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_SMF_HSH</th>
			<td>
				<form:input path="sfIdrRngSmfHsh" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngSmfHsh" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_SMF_SHR</th>
			<td>
				<form:input path="sfIdrRngSmfShr" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngSmfShr" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_SEF_SF</th>
			<td>
				<form:input path="sfIdrRngSefSf" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngSefSf" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_SEF_CHK</th>
			<td>
				<form:input path="sfIdrRngSefChk" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngSefChk" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_SEF_HSH</th>
			<td>
				<form:input path="sfIdrRngSefHsh" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngSefHsh" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_SEF_SHR</th>
			<td>
				<form:input path="sfIdrRngSefShr" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngSefShr" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_RCF_SF</th>
			<td>
				<form:input path="sfIdrRngRcfSf" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngRcfSf" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_RCF_CHK</th>
			<td>
				<form:input path="sfIdrRngRcfChk" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngRcfChk" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_RCF_HSH</th>
			<td>
				<form:input path="sfIdrRngRcfHsh" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngRcfHsh" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_RCF_SHR</th>
			<td>
				<form:input path="sfIdrRngRcfShr" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngRcfShr" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_RCSW_SF</th>
			<td>
				<form:input path="sfIdrRngRcswSf" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngRcswSf" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_RCSW_CHK</th>
			<td>
				<form:input path="sfIdrRngRcswChk" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngRcswChk" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_RCSW_HSH</th>
			<td>
				<form:input path="sfIdrRngRcswHsh" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngRcswHsh" />
			</td>
		</tr>	
		<tr>
			<th>SF_IDR_RNG_RCSW_SHR</th>
			<td>
				<form:input path="sfIdrRngRcswShr" cssClass="txt"/>
				&nbsp;<form:errors path="sfIdrRngRcswShr" />
			</td>
		</tr>	
		<tr>
			<th>SF_NAT_FRQ_RNG</th>
			<td>
				<form:input path="sfNatFrqRng" cssClass="txt"/>
				&nbsp;<form:errors path="sfNatFrqRng" />
			</td>
		</tr>	
		<tr>
			<th>SF_STR_FREE_NAT_FRQ_RNG</th>
			<td>
				<form:input path="sfStrFreeNatFrqRng" cssClass="txt"/>
				&nbsp;<form:errors path="sfStrFreeNatFrqRng" />
			</td>
		</tr>	
		<tr>
			<th>SF_OVR_ACC_RNG</th>
			<td>
				<form:input path="sfOvrAccRng" cssClass="txt"/>
				&nbsp;<form:errors path="sfOvrAccRng" />
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

