<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  

<%@ page import ="egovframework.com.cmm.LoginVO" %>
 <!DOCTYPE html>
<html lang="ko">
<head>
<title>지진가속도 응답신호 종합분석 시스템</title>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석 시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=7, IE=9, IE=10">
<meta name="viewport" content="initial-scale=1, maximum-scale=1,user-scalable=no">

  
<link rel="stylesheet" href="${ctx}/css/style.css">   

 <script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script> 
 <script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script> 
<script src="${ctx}/js/estam_common.js"></script>

<script type="text/javascript">
 <!--
 window.onload = function() {
	   var tblList = document.getElementById("chTable").getElementsByTagName("tr");
	   for (i=0; i<tblList.length; i++) {
	    tblList[i].onmouseover = function() {
	     this.style.backgroundColor = '#f7f9db';
	    }
	    tblList[i].onmouseout = function() {
	     this.style.backgroundColor = '#fff';
	    }
	   }
	   
  }
  
  $(document).ready(function(){       //도큐먼트 로딩 완료시 
		$('tr[id^=fctycd]').bind('click', function(event){ 
     		fnPageView(this.id);	 
     	});
		
		var fnPageView = function(pageFctyCd){
			var arrFcty = pageFctyCd.split(':');
			$('#iptDt').val(arrFcty[1]);
			$('#fctyCd').val(arrFcty[2]);
			$('#conDaGbcd').val(arrFcty[3]);
			$('#gvmtCd').val(arrFcty[4]);
	            
		 	fcFctyMgrView();
			fcFrstIptnCenter();
			fcFrstIptnRight(); 
	   }; 
   //scroll		
	  $( "#FctyLeftScl" ).scroll();
	  fcFctyMgrView(); 
	  fnPageView('${fctycdSearch}');
	  fcFrstIptnCenter();
	  fcFrstIptnRight(); 
});  //read

function goLeftSearch(){ 
    document.leftFctyForm.action = "<c:url value='/scn/FirstIptnReport.do'/>"; 
    document.leftFctyForm.submit();
}


function fcFctyMgrView() { 
    $.ajax({
        type : "POST" //"POST", "GET"
        , async : false //true, false
        , url : "${ctx}/scn/rptFctyMgrTopInfo.do" //Request URL
        , dataType : "html" //전송받을 데이터의 타입
                                   //"xml", "html", "script", "json" 등 지정 가능
                                   //미지정시 자동 판단
        //, timeout : 30000 //제한시간 지정
        , cache : false  //true, false
        , data : $("#inputForm").serialize() //서버에 보낼 파라메터
                         //form에 serialize() 실행시 a=b&c=d 형태로 생성되며 한글은 UTF-8 방식으로 인코딩
                         //"a=b&c=d" 문자열로 직접 입력 가능
                         //{a:b, c:d} json 형식 입력 가능
        , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
        , error : function(request, status, error) {
         //통신 에러 발생시 처리
         alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
        }
        , success : function(response, status, request) {
         //통신 성공시 처리 
        // $('#imgDisplay').remove();
         $('#imgDisplay').html(response);   
        }
       // , beforeSend: function() {
         //통신을 시작할때 처리
        // $('#ajax_indicator').show().fadeIn('fast');
       // }
       // , complete: function() {
         //통신이 완료된 후 처리
      //   $('#ajax_indicator').fadeOut();
       // }
    });
}

function fcFrstIptnCenter() { 
    $.ajax({
        type : "POST" //"POST", "GET"
        , async : false //true, false
        , url : "${ctx}/scn/RptFrstIptnCenterInfo.do" //Request URL
        , dataType : "html" //전송받을 데이터의 타입
                                   //"xml", "html", "script", "json" 등 지정 가능
                                   //미지정시 자동 판단
        //, timeout : 30000 //제한시간 지정
        , cache : false  //true, false
        , data : $("#inputForm").serialize() //서버에 보낼 파라메터
                         //form에 serialize() 실행시 a=b&c=d 형태로 생성되며 한글은 UTF-8 방식으로 인코딩
                         //"a=b&c=d" 문자열로 직접 입력 가능
                         //{a:b, c:d} json 형식 입력 가능
        , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
        , error : function(request, status, error) {
         //통신 에러 발생시 처리
         alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
        }
        , success : function(response, status, request) {
         //통신 성공시 처리 
         $('#fctyCenter').html(response);   
        }
       // , beforeSend: function() {
         //통신을 시작할때 처리
        // $('#ajax_indicator').show().fadeIn('fast');
       // }
       // , complete: function() {
         //통신이 완료된 후 처리
      //   $('#ajax_indicator').fadeOut();
       // }
    });
}
 
function fcFrstIptnRight() { 
    $.ajax({
        type : "POST" //"POST", "GET"
        , async : false //true, false
        , url : "${ctx}/scn/RptFrstIptnRightInfo.do" //Request URL
        , dataType : "html" //전송받을 데이터의 타입
                                   //"xml", "html", "script", "json" 등 지정 가능
                                   //미지정시 자동 판단
        //, timeout : 30000 //제한시간 지정
        , cache : false  //true, false
        , data : $("#inputForm").serialize() //서버에 보낼 파라메터
                         //form에 serialize() 실행시 a=b&c=d 형태로 생성되며 한글은 UTF-8 방식으로 인코딩
                         //"a=b&c=d" 문자열로 직접 입력 가능
                         //{a:b, c:d} json 형식 입력 가능
        , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
        , error : function(request, status, error) {
         //통신 에러 발생시 처리
         alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
        }
        , success : function(response, status, request) {
         //통신 성공시 처리 
         $('#fctyRight').html(response);   
        }
       // , beforeSend: function() {
         //통신을 시작할때 처리
        // $('#ajax_indicator').show().fadeIn('fast');
       // }
       // , complete: function() {
         //통신이 완료된 후 처리
      //   $('#ajax_indicator').fadeOut();
       // }
    });
}
 //-->
 </script> 
</head>

<BODY>
<form:form commandName="searchVO" id="inputForm" name="inputForm" method="post">  
	<form:hidden  id="fctyCd" path="fctyCd" /> 
	<form:hidden  id="iptDt" path="iptDt" />  
	<form:hidden  id="conDaGbcd" path="conDaGbcd" />  
	<form:hidden  id="gvmtCd" path="gvmtCd" />
</form:form>
<!-- STR:top_menu -->
<div id="top_wrap">
    <c:import url="/main/EstamIncHeader.do?flag=MAIN" /> 
</div>
<!-- END:top_menu -->


<!-- STR:컨텐츠 -->	
<div id="contents_wrap">
	<div id="contents">
		
		<br>
		<div class="content_title"><h2>초기점검보고서</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">지진가속도계측기관리</a></li>
				<li class="last">초기점검보고서</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>

		<div class="a_data_total">
			<div class="a_data_left2">
				<ul id="imgDisplay"  class="comm"> 
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
				<div class="widget_header3" id="FctyLeftScl"  style="height:550px;overflow-y:scroll;">           
					<table class="buil_list_tb" id="chTable">
						<caption>시설물 목록</caption>
					  <c:set var="iCnt" value="1"/>
					  <c:forEach var="rptmgrList" items="${rptMgrList}" varStatus="status"> 	
						<tr id="fctycd:${rptmgrList.iptDt}:${rptmgrList.fctyCd}:03:${rptmgrList.gvmtCd}">
							<td class="num2">${iCnt}</td>
							<td>${rptmgrList.obsName}
								<br>
								<font class="add">${rptmgrList.fctyAreaNm}&nbsp;${rptmgrList.fctyAddr}</font></td>
								<c:if test="${rptmgrList.fctyUseYn == 'Y'}">
							   		<td class="st">적합</td>
							    </c:if>
							   <c:if test="${rptmgrList.fctyUseYn != 'Y'}">
							   		 <td class="st_no">부적합</td>
							   </c:if>
						</tr>
						<c:set var="iCnt" value="${iCnt+1}"/>
					  </c:forEach> 
					 <c:if  test="${rptMgrCnt == 0}"> 
					  <tr >
							<td class="num2"></td>
							<td> 
								   <font class="add"> </font></td> 
							<td class="st"> </td> 
						</tr>
					 </c:if>  
					</table>
				</div>

			</div>

			<div id="fctyCenter"  class="a_data_center2"> 

			</div>
			
			<div  id="fctyRight"   class="a_data_right2">		 
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

