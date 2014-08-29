<%@ page language="java"	contentType="text/html; charset=UTF-8"%>
<%@ include file="/inc/taglibs.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<title>국립재난안전연구원 지진가속도 응답신호 종합분석 시스템</title>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석 시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석">

<link rel="stylesheet" href="${ctx}/css/style.css">   

 <script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script> 
 <script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script> 
 <script src="${ctx}/js/estam_common.js"></script> 
     
<script type="text/javascript">
<!--
//page onLoad
$(document).ready( function() {
	
	//winOpen();

});  
 
var vReturn = null;

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
	


function winClose() {
	
	if(vReturn != null){
		vReturn.close();
		
		alert("27개 시설물의 안정성평가를 완료하였습니다.");
	}
	//clearInterval();
}
    

     
//-->
</script>
     
</head>

<BODY>



<!-- STR:top_menu -->

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
<!-- END:footer -->

</BODY>
</HTML>
