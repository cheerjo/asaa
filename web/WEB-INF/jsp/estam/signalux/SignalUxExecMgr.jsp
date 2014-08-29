<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
<%@ page import ="egovframework.com.cmm.LoginVO" %>
 <!DOCTYPE html>
<html lang="ko">
<head>
<title>국립재난안전연구원 지진가속도 응답신호 종합분석시스템</title>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=7, IE=9, IE=10">
<meta name="viewport" content="initial-scale=1, maximum-scale=1,user-scalable=no">


<link rel="stylesheet" href="${ctx}/css/style.css">   

<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script> 
<script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script> 
<script src="${ctx}/js/estam_common.js"></script>  
 
<link href="/js/chart/flot/examples.css" rel="stylesheet" type="text/css">   
 
<script type="text/javascript">
var vReturn = null;

//page onLoad
$(document).ready( function() {  

	$('tr[id^=ehqkList]').bind('click', function(event){ 
	     fnPageView(this.id);
	     $('#chTable').find('tr').removeClass('on').addClass('off');
	     $(this).addClass('on');   
	});
	var fnPageView = function(pageFctyCd){
		
	     var arrFcty = pageFctyCd.split(':');
	     $('#ehqkReqId').val(arrFcty[1]);
	     $('#ehqkTranGbcd').val(arrFcty[2]);
	     var msg = arrFcty[4]+"에서 "+arrFcty[5]+"시에 발생한 진도 "+arrFcty[3];
	     $('#mode').val(msg);
	  //   iddFctyStttRlstView();
	};
	//fnPageView('${returnVal}');
	//iddFctyStttRlstView();
});   

function iddFctyStttRlstView() { 
    $.ajax({
        type : "POST" //"POST", "GET"
        , async : false //true, false
        , url : "${ctx}/signalux/SignalUxExecMain.do" //Request URL
        , dataType : "html" 
        , cache : false  //true, false
        , data : $("#leftFctyForm").serialize() 
        , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
        , error : function(request, status, error) {
        	alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
        }
        , success : function(response, status, request) {
        	$('#mainRslt').html(response);   
        }
    });
}
function signalUxEecRlstView() {

	if($('#ehqkReqId').val()=="") {
		alert("분석할 지진데이터를 선택해 주세요.");
		return;
	}
	var msg =  $('#mode').val() + " 규모의 지진을 분석하시겠습니까?";
	if (confirm(msg)){
		//progress();
		
	    var scWidth = screen.availWidth/2-250;
	    var scHeight = screen.availHeight/2-50;
	    var closeYnCheck = "N";
	    vReturn = window.open(
	             "<c:url value='/cmmnl/progressMgrPopup.do?closeYnCheck="+ closeYnCheck + "'/>"
	                     , "egovProgress"
	                     , 'top='+scHeight+',left='+scWidth+',width=450, height=100, location=no,scrollbars=no,resizable=yes,status=no,center=yes');
	    
	    $.ajax({
	        type : "POST" //"POST", "GET"
	        , async : false //true, false
	        , url : "${ctx}/signalUxExec/addSignalUxRsltExec.do" //Request URL
	        , dataType : "json" 
	        , cache : false  //true, false
	        , data : $("#leftFctyForm").serialize() 
	        , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
	        , error : function(request, status, error) {
	        	alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
	        }
	        , success : function(data, status, request) {
	        	
	        	var result = JSON.parse(data);
	        	
	        	if(result.result == false) {
	        		alert('필수 파일이 누락되어 분석할 수 없습니다.');
	        	}
	        	
	            if(vReturn != null){
	                vReturn.close();
	            }  
	        	navIddlSearch();
	        	//$('#mainRslt').html(response);   
	        }
	    });
    	

	}else{
		 alert("취소되었습니다.");
		}

}
function progress() {
	
	var scWidth = screen.availWidth/2-250;
	var scHeight = screen.availHeight/2-50;
	var closeYnCheck = "N";
	
	vReturn = window.open(
//	vReturn = window.showModalDialog(	 	
			"<c:url value='/cmmnl/progressMgrPopup.do?closeYnCheck="+ closeYnCheck + "'/>"
					, "egovProgress"
					, 'top='+scHeight+',left='+scWidth+',width=450, height=100, location=no,scrollbars=no,resizable=yes,status=no,center=yes');	
	
	//var timer = self.setInterval("winClose()", 3000);
	//signalUxEecRlstView();
	//setTimeout("winClose()", 30000);
}
function signalUxEecRlstDel() {

	if($('#ehqkReqId').val()=="") {
		alert("삭제할 지진데이터를 선택해 주세요.");
		return;
	}
	var msg =  $('#mode').val() + " 규모의 지진을 삭제하시겠습니까?";
	if (confirm(msg)){
	    $.ajax({
	        type : "POST" //"POST", "GET"
	        , beforeSend : function() {
	        	 
	    	    var scWidth = screen.availWidth/2-250;
	    	    var scHeight = screen.availHeight/2-50;
	    	    var closeYnCheck = "N";
	    	    vReturn = window.open(
	    	             "<c:url value='/cmmnl/progressMgrPopup.do?closeYnCheck="+ closeYnCheck + "'/>"
	    	                     , "egovProgress"
	    	                     , 'top='+scHeight+',left='+scWidth+',width=450, height=100, location=no,scrollbars=no,resizable=yes,status=no,center=yes');
	        		        	
	        }
	        , async : false //true, false
	        , url : "${ctx}/signalUxExec/addSignalUxRsltExecDel.do" //Request URL
	        , dataType : "html" 
	        , cache : false  //true, false
	        , data : $("#leftFctyForm").serialize() 
	        , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
	        , error : function(request, status, error) {
	        	alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
	        }
	        , success : function(response, status, request) {
	            if(vReturn != null){
	                vReturn.close();
	            }  
	        	navIddlSearch();
	        	//$('#mainRslt').html(response);   
	        }
	    });
	    
	}else{
		 alert("취소되었습니다.");
		}

}
 
</script>
 
<script type="text/javascript">
 <!--
 
  //소트오더
  function navIddlSort(sortOrder) {
	// document.getElementById("leftFctyForm").fctyAreaCd.value = '${searchVO.fctyAreaCd}';
	 document.getElementById("leftFctyForm").searchKeyword.value = '${searchVO.searchKeyword.replace(",", "")}';
	 document.getElementById("leftFctyForm").searchCondition.value = sortOrder;
	 document.getElementById("leftFctyForm").action = "${ctx}/signalux/SignalUxExecMgr.do";
	 document.getElementById("leftFctyForm").submit();
 }

  //검색(소트오더는 Reset)
  function navIddlSearch() {
	 document.getElementById("leftFctyForm").fctyAreaCd.value = '${searchVO.fctyAreaCd}';
	 document.getElementById("leftFctyForm").searchKeyword.value = document.getElementById("leftFctyForm").searchKeyword_m.value;
	 document.getElementById("leftFctyForm").action = "${ctx}/signalux/SignalUxExecMgr.do";
	 document.getElementById("leftFctyForm").submit();
 }  
 
 function naviIddlFctyStats(code) {
	// document.getElementById("leftFctyForm").fctyAreaCd.value = code;
	 document.getElementById("leftFctyForm").action = "${ctx}/signalux/SignalUxExecMgr.do";
	 document.getElementById("leftFctyForm").submit();
 }
 
 //--> 
</script>
</head>

<BODY>

<!-- STR:top_menu -->
<div id="top_wrap">
	 <jsp:include page="/main/EstamIncHeader.do?flag=MAIN" /> 
</div>
<!-- END:top_menu -->
 
<!-- STR:컨텐츠 -->	
<div id="contents_wrap">
	<div id="contents">
		
		<br>
		<div class="content_title"><h2>지진데이터분석</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">시설물 상세정보</a></li>
				<li class="last">지진데이터분석</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>
		
		<div class="a_data_total">
			<div class="a_data_left2">
 
 				<div class="widget_header2" style="padding:10px 0 10px 0;">                        
					<ul class="last" >
					  <form:form commandName="searchVO" id="leftFctyForm" name="leftFctyForm" method="post">
					      <!-- form:hidden  id="conDaGbcd" path="conDaGbcd" value="02"/> --> 
					      <input type="hidden" id="fctyAreaCd" name="fctyAreaCd" value="${fctyAreaCd}" />
					      <input type="hidden" id="searchCondition" name="searchCondition" />
					      <input type="hidden" id="searchKeyword" name="searchKeyword" />
					      <input type="hidden" id="ehqkReqId" name="ehqkReqId" />
					      <input type="hidden" id="ehqkTranGbcd" name="ehqkTranGbcd" />
						  <input type="hidden" id="mode" name="mode" />
						 <li align="center" valign="middle" >
							<fieldset class="inline">
								<label style="margin:5px 0 0 0;">검색어</label>
								<input type="text" name="searchKeyword_m">
								<a href="javascript:navIddlSearch();" class="css_button blue"><span>검색</span></a>
							</fieldset>
						</li>
						
					   </form:form>
					</ul>
				</div>





				<div class="content_title2"><ul><li>분석결과 목록</li></ul></div>
				<div style="height:760px;overflow-y:scroll;">
					<table class="auth_group display3" style="background-color: #fff;font-size:10px;" id="chTable">
						<caption></caption>
						<thead>
							<tr>
								<th>분석결과</th>	
							    <th><a href="JavaScript:navIddlSort('IDDL_AASS_DT')">분석일</a></th>	
								<th><a href="JavaScript:navIddlSort('EHQK_SCAL')">규모</a></th>							
								<th><a href="JavaScript:navIddlSort('EHQK_ORG_AREA')">진앙</a></th>	
<!-- 								<th><a href="JavaScript:navIddlSort('EHQK_ORG_TM')">진원시</a></th> -->
								<th><a href="JavaScript:navIddlSort('EHQK_REQ_ID')">지진번호</a></th>	
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty ehqkOcurInfoList}">
									<tr><td colspan="4" align="center">자료가 존재하지 않습니다.</td></tr>
									<script>
										$("#iddlAassDt").val("");
										$("#ehqkOrgTm").val("");
									</script>
							    </c:when>
						    	<c:otherwise>					
									<c:forEach var="ehqkOcurInfoList" items="${ehqkOcurInfoList}" varStatus="status">
									  <tr id="ehqkList:${ehqkOcurInfoList.ehqkReqId}:${ehqkOcurInfoList.ehqkTranGbcd}:${ehqkOcurInfoList.ehqkScal}:${ehqkOcurInfoList.ehqkOrgArea}:${ehqkOcurInfoList.ehqkOrgTm}" >
									  	<td><c:choose><c:when test="${ehqkOcurInfoList.iddlAassDt eq null}">미분석</c:when><c:otherwise>분석완료</c:otherwise></c:choose></td>
									    <td>${ehqkOcurInfoList.iddlAassDt}</td>
									    <td>${ehqkOcurInfoList.ehqkScal}</td>
									    <td>${ehqkOcurInfoList.ehqkOrgArea}</td>
<%-- 									    <td>${ehqkOcurInfoList.ehqkOrgTm}</td> --%>
									    <td>${ehqkOcurInfoList.ehqkReqId}</td>
									  </tr>
									</c:forEach>
								</c:otherwise>
							</c:choose> 	
						</tbody>
					</table>
					</div>

					
				</div>

			
				<div class="a_data_center3">
					<div class="state"> 
						<div class="btn_start"><a href="javascript:signalUxEecRlstView();">시작</a></div>
						<div class="btn_stop"><a href="javascript:signalUxEecRlstDel();">중지</a></div>
	
						<div class="btn_small">
							<ul>
								<li class="btn_small01"><a href="javascript:goMenuPage('EstamEventMain','${ctx}/main/EstamEventMain.do')">지진가속도 계측자료 분석</a></li>
								<li class="btn_small02"><a href="javascript:goMenuPage('IddlFctyRlstMgr','${ctx}/iddl/IddlFctyRlstMgr.do')">계측 및 평가결과</a></li>
								<li class="btn_small03"><a href="javascript:goMenuPage('IddlFctyStttMgr','${ctx}/iddl/IddlFctyStttMgr.do')">평가결과 통계자료</a></li>
							</ul>
						</div>
					</div>
				</div>	
			
				<!-- 
 
				<div class="a_data_center3" style="height:840px;">
					<div style="width:100%;flaot:left;">
						<div id="print_wrap" >
							<a href="javascript:signalUxEecRlstView();"><img src="${ctx}/img/btn/btn_start.png"></a>
							<a href="javascript:winClose();"><img src="${ctx}/img/btn/btn_stop.png"></a>
						</div>
					</div>	
					<div style="width:100%;flaot:left;" id="mainRslt">
					</div>
					<div style="background-color: #fff;font-size:12px;" ><br><br>
					    본 분석의 결과는 지진가속도계측자료분석 메뉴와 시설물 상세정보 > 계측및평가결과 및 통계자료에 반영됩니다.<br><br>
					   <a herf="#" onClick="javascript:goMenuPage('EstamEventMain','${ctx}/main/EstamEventMain.do')">지진가속도계측자료분석</a>
					   &nbsp;&nbsp;&nbsp;<a herf="#" onClick="javascript:goMenuPage('IddlFctyRlstMgr','${ctx}/iddl/IddlFctyRlstMgr.do')">계측및평가결과</a>
					   &nbsp;&nbsp;&nbsp;<a herf="#" onClick="javascript:goMenuPage('IddlFctyStttMgr','${ctx}/iddl/IddlFctyStttMgr.do')">평가결과통계자료</a>
					</div>	
				</div>	
				-->
			<br class="clear">
		</div>
	</div>	
</div>
<!-- END:컨텐츠 -->	
	
<!-- STR:footer -->
<div id="footer">
    <jsp:include page="/EgovPageLink.do?vlink=estam/main/inc/EstamIncFooter" /> 
</div>
<!-- END:footer -->

</BODY>
</HTML>
 