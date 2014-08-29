<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  

<%@ page import ="egovframework.com.cmm.LoginVO" %>
 <!DOCTYPE html>
<html lang="ko">
<head>
<title>국립재난안전연구원 지진가속도 응답신호 종합분석 시스템</title>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석 시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=7, IE=9, IE=10">
<meta name="viewport" content="initial-scale=1, maximum-scale=1,user-scalable=no">


<link rel="stylesheet" href="${ctx}/css/style.css">   

 <script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script> 
 <script src="${ctx}/js/estam_common.js"></script>  

 

<script type="text/javascript">
 <!--
window.onload = function() {
	//시설물 테이블 마우스오버 옵션
	var tblList = document.getElementById("chTable").getElementsByTagName("tr");
	for (i=0; i<tblList.length; i++) {
		tblList[i].onmouseover = function() {
			this.style.backgroundColor ='#f7f9db';
		}
		tblList[i].onmouseout = function() {
			this.style.backgroundColor = '#fff';
		}
	}
}
 
 
//page onLoad
$(document).ready( function() {     
	$('tr[id^=fctycd]').bind('click', function(event){ 
	     fnPageView(this.id);     
	});
	var fnPageView = function(pageFctyCd){
	     var arrFcty = pageFctyCd.split(':');
	};

});   
 

 //-->
 </script>
</head>

<BODY>

<!-- STR:top_menu -->
<div id="top_wrap">
	 <c:import url="/main/EstamIncHeader.do?flag=MAIN" /> 
</div>
<!-- END:top_menu -->
<!--
<form name="detailForm" id="detailForm" method="post">
	<input type="hidden" name="fctyCd" value="YY" />
	<input type="hidden" name="iddlAassNo" value="1" />
	<input type="hidden" name="gvmtCd" value="KA" />
</form>
-->
<form:form commandName="searchVO" id="inputForm" name="inputForm" method="post">  
    <form:hidden  id="ehqkReqId" path="ehqkReqId" />
    <form:hidden  id="ehqkTranGbcd" path="ehqkTranGbcd" />
</form:form>

<!-- STR:컨텐츠  -->	
<div id="contents_wrap">
	<div id="contents">
		
		<br>
		<div class="content_title"><h2>지진발생자료 종합분석 보고서</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">보고서작성</a></li>
				<li class="last">지진발생자료 종합분석 보고서</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>

		<div class="a_data_total" style="height:3000px;">

			<div class="a_data_left2">
				<%-- 
				<ul id="imgDisplay" class="comm"> 
				</ul>

				<div class="widget_header2">                        
					<ul class="last">
					  <form:form commandName="searchVO" name="leftFctyForm" method="post"> 
					       <!-- form:hidden  id="conDaGbcd" path="conDaGbcd" value="02"/> -->  
							<li>
								<fieldset class="inline">
									<label>지역</label>
									<form:select path="fctyAreaCd" multiple="false">
									    <form:option value="" label="전국" /> 
                    					 <form:options items="${fctyAreaList}" itemValue="commDtlCd" itemLabel="commDtlNm" />
                					</form:select> 
								</fieldset> 
								<fieldset class="inline">
									<label>시설분류</label>
									<form:select path="fctyKndCd" multiple="false"> 
									    <form:option value="" label="전체" />
									    <form:options items="${fctyKndList}" itemValue="commDtlCd" itemLabel="commDtlNm" /> 
                					</form:select>  
								</fieldset> 
								<fieldset class="inline">
									<label>상태</label>
									<form:select path="fctyUseYn" multiple="false"> 
									    <form:option value="Y" label="적합" /> 
									    <form:option value="N" label="부적합" /> 
                					</form:select>   
								</fieldset> 
								<div class="btn"><a href="#" class="css_button blue" onclick="javascript:goLeftSearch();"><span>정렬</span></a></div>
							</li>                        
					   </form:form>    
					</ul>
					
				</div>
				<div class="widget_header3" style="height:145px;overflow-y:scroll;">           
					<table class="buil_list_tb" id="chTable">
						<caption>시설물 목록</caption>
					  <c:set var="iCnt" value="1"/>
					  <c:forEach var="fctyMgrList" items="${fctyMgrList}" varStatus="status"> 	
						<tr id="fctycd:${fctyMgrList.fctyCd}:${fctyMgrList.gvmtCd}" style="cursor:pointer;">						
							<td class="num2">${iCnt}</td>
							<td>${fctyMgrList.fctyNm}
								<br>
								<font class="add">${fctyMgrList.fctyAreaNm}&nbsp;${fctyMgrList.fctyEdAddr}</font></td>
								<c:if test="${fctyMgrList.fctyUseYn == 'Y'}">
							   		<td class="st">적합</td>
							    </c:if>
							   <c:if test="${fctyMgrList.fctyUseYn != 'Y'}">
							   		 <td class="st_no">부적합</td>
							   </c:if>
						</tr>
						<c:set var="iCnt" value="${iCnt+1}"/>
					  </c:forEach> 
					 <c:if  test="${fctyMgrCnt == 0}"> 
					  <tr >
							<td class="num2"></td>
							<td> 
								   <font class="add"> </font></td> 
							<td class="st"> </td> 
						</tr>
					 </c:if>   
					</table>
				</div>
				<br>
				--%>
				<div class="content_title2"><ul><li>분석결과 목록</li></ul></div>
				<div style="height:788px;overflow-y:scroll;">
				
					<table class="auth_group display3" style="background-color: #fff;font-size:11px;" id="rptTable" >
						<caption></caption>
						<thead>
							<tr>
								<th>발생일시</th>							
								<th>진앙</th>	
								<th>규모</th>
								<th>분석일시</th>
							</tr>
						</thead>
						<tbody  id="analyRstList"></tbody>

						<tbody>
						<c:forEach var="analyRstList" items="${analyRstList}" varStatus="status">
						  <tr>
						    <td>YYYY/MM/DD - HH:MM:SS</td>
						    <td>Addr</td>
						    <td>2.1</td>
						    <td>YYYY/MM/DD - HH:MM:SS</td>
						  </tr>
						</c:forEach>
						
					</table>
					
				</div>

				<br/>
					
				</div>

				<div class="a_data_center3" style="height:788px;">
					<div style="height:730px;overflow-y:scroll;" id="report">
						<%//<c:import url="/rpt/FctyEstmEvalPrint.do" />%> 
					</div>	
				</div>
							

			</div>		
			
			<br class="clear">
		</div>
	</div>	
</div>
<!-- END:컨텐츠 -->	


<!-- STR:footer -->
<div id="footer">
    <c:import url="/EgovPageLink.do?vlink=estam/main/inc/EstamIncFooter" /> 
</div>
<!-- END:footer -->

</BODY>
</HTML>

 