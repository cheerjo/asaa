<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : SymUserRegister.jsp
  * @Description : SymUser Register 화면
  * @Modification Information
  * 
  * @author ATRES
  * @since 2013.07.03
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

<c:set var="registerFlag" value="${empty symUserVO.userId ? '등록' : '수정'}"/>

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="symUserVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/sym/symUser/SymUserList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/sym/symUser/deleteSymUser.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/sym/symUser/addSymUser.do' : '/sym/symUser/updateSymUser.do'}"/>";
    frm.submit();

}

// -->
</script>
</head>
<body>

<form:form commandName="symUserVO" name="detailForm" id="detailForm" >
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
			<th> id *</th>
			<td>
				<form:input path="userId" cssClass="essentiality" readonly="true" />
			</td>			
		</tr>	
		</c:if>
		<c:if test="${registerFlag == '등록'}">
	   <tr>
			<th>id *</th>
			<td>
				<form:input path="userId" cssClass="txt" readonly="false" />
			</td>			
		</tr>	
		</c:if>		
		<tr>
			<th>PRIV_GRP_NO</th>
			<td>
				<form:input path="privGrpNo" cssClass="txt"/>
				&nbsp;<form:errors path="privGrpNo" />
			</td>
		</tr>	
		<tr>
			<th>ORG_YN</th>
			<td>
				<form:input path="orgYn" cssClass="txt"/>
				&nbsp;<form:errors path="orgYn" />
			</td>
		</tr>	
		<tr>
			<th>ORG_NM</th>
			<td>
				<form:input path="orgNm" cssClass="txt"/>
				&nbsp;<form:errors path="orgNm" />
			</td>
		</tr>	
		<tr>
			<th>USER_NM</th>
			<td>
				<form:input path="userNm" cssClass="txt"/>
				&nbsp;<form:errors path="userNm" />
			</td>
		</tr>	
		<tr>
			<th>USR_PSWD</th>
			<td>
				<form:input path="usrPswd" cssClass="txt"/>
				&nbsp;<form:errors path="usrPswd" />
			</td>
		</tr>	
		<tr>
			<th>USR_EMAIL</th>
			<td>
				<form:input path="usrEmail" cssClass="txt"/>
				&nbsp;<form:errors path="usrEmail" />
			</td>
		</tr>	
		<tr>
			<th>TEL_NO</th>
			<td>
				<form:input path="telNo" cssClass="txt"/>
				&nbsp;<form:errors path="telNo" />
			</td>
		</tr>	
		<tr>
			<th>MBL_NO</th>
			<td>
				<form:input path="mblNo" cssClass="txt"/>
				&nbsp;<form:errors path="mblNo" />
			</td>
		</tr>	
		<tr>
			<th>USE_OBJT</th>
			<td>
				<form:input path="useObjt" cssClass="txt"/>
				&nbsp;<form:errors path="useObjt" />
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
			<th>DEL_DT</th>
			<td>
				<form:input path="delDt" cssClass="txt"/>
				&nbsp;<form:errors path="delDt" />
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

