<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : ConMmaDataRegister.jsp
  * @Description : ConMmaData Register 화면
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

<c:set var="registerFlag" value="${empty conMmaDataVO.mmaGvmtCd ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="conMmaDataVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/conMmaData/ConMmaDataList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/conMmaData/deleteConMmaData.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/conMmaData/addConMmaData.do' : '/conMmaData/updateConMmaData.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="conMmaDataVO" name="detailForm" id="detailForm" >
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
			<th>MMA_DATETIME</th>
			<td>
				<form:input path="mmaDatetime" cssClass="txt"/>
				&nbsp;<form:errors path="mmaDatetime" />
			</td>
		</tr>	
		<tr>
			<th>MMA_CRC</th>
			<td>
				<form:input path="mmaCrc" cssClass="txt"/>
				&nbsp;<form:errors path="mmaCrc" />
			</td>
		</tr>	
		<tr>
			<th>MMA_QUTY_FLG</th>
			<td>
				<form:input path="mmaQutyFlg" cssClass="txt"/>
				&nbsp;<form:errors path="mmaQutyFlg" />
			</td>
		</tr>	
		<tr>
			<th>MMA_DATA_TYPE</th>
			<td>
				<form:input path="mmaDataType" cssClass="txt"/>
				&nbsp;<form:errors path="mmaDataType" />
			</td>
		</tr>	
		<tr>
			<th>MMA_UD_WND_MIN_VAL</th>
			<td>
				<form:input path="mmaUdWndMinVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaUdWndMinVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_UD_WND_MAX_VAL</th>
			<td>
				<form:input path="mmaUdWndMaxVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaUdWndMaxVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_UD_WND_AVG_VAL</th>
			<td>
				<form:input path="mmaUdWndAvgVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaUdWndAvgVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_NS_WND_MIN_VAL</th>
			<td>
				<form:input path="mmaNsWndMinVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaNsWndMinVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_NS_WND_MAX_VAL</th>
			<td>
				<form:input path="mmaNsWndMaxVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaNsWndMaxVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_NS_WND_AVG_VAL</th>
			<td>
				<form:input path="mmaNsWndAvgVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaNsWndAvgVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_EW_WND_MIN_VAL</th>
			<td>
				<form:input path="mmaEwWndMinVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaEwWndMinVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_EW_WND_MAX_VAL</th>
			<td>
				<form:input path="mmaEwWndMaxVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaEwWndMaxVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_EW_WND_AVG_VAL</th>
			<td>
				<form:input path="mmaEwWndAvgVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaEwWndAvgVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_UD_TRU_MIN_VAL</th>
			<td>
				<form:input path="mmaUdTruMinVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaUdTruMinVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_UD_TRU_MAX_VAL</th>
			<td>
				<form:input path="mmaUdTruMaxVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaUdTruMaxVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_NS_TRU_MIN_VAL</th>
			<td>
				<form:input path="mmaNsTruMinVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaNsTruMinVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_NS_TRU_MAX_VAL</th>
			<td>
				<form:input path="mmaNsTruMaxVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaNsTruMaxVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_EW_TRU_MIN_VAL</th>
			<td>
				<form:input path="mmaEwTruMinVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaEwTruMinVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_EW_TRU_MAX_VAL</th>
			<td>
				<form:input path="mmaEwTruMaxVal" cssClass="txt"/>
				&nbsp;<form:errors path="mmaEwTruMaxVal" />
			</td>
		</tr>	
		<tr>
			<th>MMA_UD_MAX</th>
			<td>
				<form:input path="mmaUdMax" cssClass="txt"/>
				&nbsp;<form:errors path="mmaUdMax" />
			</td>
		</tr>	
		<tr>
			<th>MMA_NS_MAX</th>
			<td>
				<form:input path="mmaNsMax" cssClass="txt"/>
				&nbsp;<form:errors path="mmaNsMax" />
			</td>
		</tr>	
		<tr>
			<th>MMA_EW_MAX</th>
			<td>
				<form:input path="mmaEwMax" cssClass="txt"/>
				&nbsp;<form:errors path="mmaEwMax" />
			</td>
		</tr>	
		<tr>
			<th>MMA_HRTL_PGA</th>
			<td>
				<form:input path="mmaHrtlPga" cssClass="txt"/>
				&nbsp;<form:errors path="mmaHrtlPga" />
			</td>
		</tr>	
		<tr>
			<th>MMA_TOT_PGA</th>
			<td>
				<form:input path="mmaTotPga" cssClass="txt"/>
				&nbsp;<form:errors path="mmaTotPga" />
			</td>
		</tr>	
		<tr>
			<th>MMA_32B_UD_SI</th>
			<td>
				<form:input path="mma32bUdSi" cssClass="txt"/>
				&nbsp;<form:errors path="mma32bUdSi" />
			</td>
		</tr>	
		<tr>
			<th>MMA_32B_NS_SI</th>
			<td>
				<form:input path="mma32bNsSi" cssClass="txt"/>
				&nbsp;<form:errors path="mma32bNsSi" />
			</td>
		</tr>	
		<tr>
			<th>MMA_32B_EW_SI</th>
			<td>
				<form:input path="mma32bEwSi" cssClass="txt"/>
				&nbsp;<form:errors path="mma32bEwSi" />
			</td>
		</tr>	
		<tr>
			<th>MMA_HRTL_SI</th>
			<td>
				<form:input path="mmaHrtlSi" cssClass="txt"/>
				&nbsp;<form:errors path="mmaHrtlSi" />
			</td>
		</tr>	
		<tr>
			<th>MMA_CRRN</th>
			<td>
				<form:input path="mmaCrrn" cssClass="txt"/>
				&nbsp;<form:errors path="mmaCrrn" />
			</td>
		</tr>	
		<tr>
			<th>MMA_LOC_CD</th>
			<td>
				<form:input path="mmaLocCd" cssClass="txt"/>
				&nbsp;<form:errors path="mmaLocCd" />
			</td>
		</tr>	
		<tr>
			<th>MMA_DA_PORT</th>
			<td>
				<form:input path="mmaDaPort" cssClass="txt"/>
				&nbsp;<form:errors path="mmaDaPort" />
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

