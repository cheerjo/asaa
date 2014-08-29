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
 <script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script> 
 <script src="${ctx}/js/estam_common.js"></script>  
 <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="${ctx}/js/chart/real/excanvas.min.js"></script><![endif]-->
  
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.stack.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script> 
 
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
 
 function fcFctyMgrView() { 
	    $.ajax({
	        type : "POST" //"POST", "GET"
	        , async : false   
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
function assRlstMgrView() { 
  $.ajax({
      type : "POST" //"POST", "GET"
      , async : false //true, false
      , url : "${ctx}/iddl/IddlAassInfoList.do" //Request URL
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
       $('#iddAassRlstInfo').html(response);   
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
function assRlstCenter() { 
	  //var url = "/iddl/ReadIddlAassRlst.do";
   $.ajax({
       type : "POST" //"POST", "GET"
       , async : false //true, false
       , url : "${ctx}/iddl/ReadIddlAassRlstData.do" //Request URL
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
        $('#leftDataLink').html(response);   
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
function assRlstCharts() { 
  //var url = "/iddl/ReadIddlAassRlst.do";
  $.ajax({
      type : "POST" //"POST", "GET"
      , async : false //true, false
      , url : "${ctx}/iddl/ReadIddlAassRlst.do" //Request URL
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
       $('#leftGraphLink').html(response);   
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
function goLeftSearch(){ 
  $('#iddlAassNo').val("");
  $('#ehqkReqId').val("");
  document.leftFctyForm.action = "<c:url value='/iddl/IddlFctyRlstMgr.do'/>"; 
  document.leftFctyForm.submit();
}	 
	
function iddlAassInfoList(pageFctyCd){
	 var arrFcty = pageFctyCd.split(':');
  $('#fctyCd').val(arrFcty[1]);
  $('#gvmtCd').val(arrFcty[2]);
  $('#iddlAassNo').val(arrFcty[3]);
  $('#ehqkReqId').val(arrFcty[4]);
  
  iddlLeftAclnInfo('10','${ctx}/iddl/ReadIddlAassRlst.do');
}   
function iddlLeftAclnInfo(mode, url){
  var iddlAassNo = $('#iddlAassNo').val();
  if(iddlAassNo==""){
    alert("최근분석결과 목록을 하나 선택하세요.");
    return false;
  }
  $('#modes').val(mode);
	 
	 assRlstCharts();
	  
  $('.sy_tab').find('li').each(function(i){
 	   $(this).removeClass('sy_on').addClass('sy_off');
        $('#tab_'+mode).removeClass('sy_off').addClass('sy_on');
  }); 

} 
	//page onLoad
 $(document).ready( function() {     
      $('tr[id^=fctycd]').bind('click', function(event){ 
          fnPageView(this.id);     
      }); 
      var fnPageView = function(pageFctyCd){ 
          var arrFcty = pageFctyCd.split(':');
          $('#fctyCd').val(arrFcty[1]);
          $('#gvmtCd').val(arrFcty[2]);
          
          fcFctyMgrView();
          assRlstMgrView();
     };
     //var url = "/iddl/ReadIddlAassRlst.do";
     fnPageView('${fctycdSearch}');
     
     fcFctyMgrView();      
     assRlstCharts();
 
 });    

 
 
  //-->
 </script>
 
</head>

<BODY>

<!-- STR:top_menu -->
<div id="top_wrap">
	 <c:import url="${ctx}/main/EstamIncHeader.do?flag=MAIN" /> 
</div>
<!-- END:top_menu -->

<form:form commandName="searchVO" id="inputForm" name="inputForm" method="post">  
    <form:hidden  id="fctyCd" path="fctyCd" /> 
    <form:hidden  id="gvmtCd" path="gvmtCd" />
    <form:hidden  id="iddlAassNo" path="iddlAassNo" />
    <form:hidden  id="ehqkReqId" path="ehqkReqId" />
    <form:hidden  id="modes" path="modes" />
</form:form>
<!-- STR:컨텐츠 -->	
<div id="contents_wrap">
	<div id="contents">
		
		<br>
		<div class="content_title"><h2>계측 및 평가결과</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">시설물 상세정보</a></li>
				<li class="last">계측 및 평가결과</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>

		<div class="a_data_total">
			<div class="a_data_left2">
			<!-- 
				<ul class="comm">
					<li class="title">서울특별시청사</li>
					<li><img src="<c:url value='/img/etc/no_img.jpg'/>" title="" /></li>
				</ul>
            -->				
                <ul  id="imgDisplay"  class="comm"> 
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
						<tr id="fctycd:${fctyMgrList.fctyCd}:${fctyMgrList.gvmtCd}">						
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
				<div class="content_title2"><ul><li>분석결과 목록</li></ul></div>
				<div style="height:145px;overflow-y:scroll;">
					<table id="chTabl2e" class="auth_group display3" style="background-color: #fff;font-size:11px;" >
						<caption></caption>
						<thead>
							<tr>
								<th>분석일</th>							
								<th>규모</th>	
								<th>진앙</th>
								<th>진원시</th>
							</tr>
						</thead>
						<tbody  id="iddAassRlstInfo"></tbody>
					</table>
					</div>

					<br>
					<div class="sy_tab">
						<div class="sy_left">
							<ul>
								<li class="sy_title">자유장</li>
								<li id="tab_10" class="sy_on"><a href="#"  id="estam/iddl/inc/iddlLeftAclnInfo" onClick="iddlLeftAclnInfo('10','${ctx}/iddl/ReadIddlAassRlst.do');" style="cursor: pointer;">가속도</a></li><!-- 버튼 선택시 -->
								<li id="tab_20" class="sy_off"><a href="#" id="estam/iddl/inc/iddlLeftVltyInfo" onClick="iddlLeftAclnInfo('20','${ctx}/iddl/ReadIddlAassRlst.do');" style="cursor: pointer;">속도</a></li>
								<li id="tab_30" class="sy_off"><a href="#" id="estam/iddl/inc/iddlLeftDsltInfo" onClick="iddlLeftAclnInfo('30','${ctx}/iddl/ReadIddlAassRlst.do');" style="cursor: pointer;">변위</a></li>
								<li id="tab_40" class="sy_off"><a href="#" id="estam/iddl/inc/iddlLeftSptmInfo" onClick="iddlLeftAclnInfo('40','${ctx}/iddl/ReadIddlAassRlst.do');" style="cursor: pointer;">응답스펙트럼</a></li>
							</ul>
						</div>
						<div class="sy_right">
							<ul>
								<li class="sy_title">시설물</li>
								<li id="tab_50" class="sy_off"><a href="#" id="estam/iddl/inc/iddlLeftTopAclnInfo" onClick="iddlLeftAclnInfo('50','${ctx}/iddl/ReadIddlAassRlst.do');"  style="cursor: pointer;">최상층가속도</a></li>
								<li id="tab_60" class="sy_off"><a href="#" id="estam/iddl/inc/iddlLeftTopVltyInfo" onClick="iddlLeftAclnInfo('60','${ctx}/iddl/ReadIddlAassRlst.do');"   style="cursor: pointer;">최상층속도</a></li>
								<li id="tab_70" class="sy_off"><a href="#" id="estam/iddl/inc/iddlLeftTopDsltInfo" onClick="iddlLeftAclnInfo('70','${ctx}/iddl/ReadIddlAassRlst.do');"  style="cursor: pointer;">최상층변위</a></li>
								<li id="tab_80" class="sy_off"><a href="#" id="estam/iddl/inc/iddlLeftStabEvalInfo"  onClick="iddlLeftAclnInfo('80','${ctx}/iddl/ReadIddlAassRlst.do');"   style="cursor: pointer;">안전성평가결과</a></li>
							</ul>
						</div>
						<br class="clear">
					</div>
                      
					<div class="sy_tab">
						<ul>							
							<li class="sy_btn"><span class="sy_btn_on"><a href="#" id="estam/iddl/inc/iddlLeftCmlvEfftInfo" onClick="iddlLeftAclnInfo('100','${ctx}/iddl/ReadIddlAassRlst.do');"  style="cursor: pointer;">계측자료 누적기록</a></span></li>
						</ul>
					</div>

				</div>

                <div id="leftDataLink" class="a_data_center3" >                                    
                </div>
			 	<div id="leftGraphLink" class="a_data_center3" >								    
			    </div>
			
			
			<br class="clear">
		</div>
	</div>	
</div>
<!-- END:컨텐츠 -->	


<!-- STR:footer -->
<div id="footer">
    <c:import url="${ctx}/EgovPageLink.do?vlink=estam/main/inc/EstamIncFooter" /> 
</div>
<!-- END:footer -->

</BODY>
</HTML>

