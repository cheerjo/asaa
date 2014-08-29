<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  

<%@ page import ="egovframework.com.cmm.LoginVO" %> 

<!DOCTYPE html>
<html >
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
var inptFrm = {};
var jsonObjList = "";
var firstChk = "Y";

/*
 * 지진안전성 분석결과 목록 조회(Ajax호출)
 */
function sfExec() {
 	$.ajax({
		url: "${ctx}/main/SfResultInfoJson.do",
		dataType: 'json',
		type : 'POST',
		contentType: "application/json",
		async: false,  
		data: JSON.stringify(inptFrm),
		beforeSend: function(){
			$("#sfResultInfo").empty();
			$("#sfResultInfo").append("<div id='load' style='height:100px; vertical-align:middle;' align='center'><img src='${ctx}/images/theme/ajax-loader.gif' /></div>");
 	    },
		complete: function(){
			//alert('complet');
		},
		success: function(data) { 
		   	//alert(data);
		   	jsonObjList = data;
		   	var pData = JSON.parse(data); 
		   	$("#sfResultInfo").empty();
		   	
		   	var innerHtml = "";
		   	/* A.FCTY_CD, A.GVMT_CD, A.IDDL_AASS_NO, A.EHQK_STTM, A.EHQK_ORG_AREA, 
		   	A.EHQK_REQ_ID, A.EHQK_TRAN_GBCD, A.EHQK_SCAL, A.IDDL_AASS_DT */
		   	for (var idx = 0; idx < Object.keys(pData.sfResultInfoList).length;idx++) {
		   		innerHtml = 
		   			"<li class='graph_txt2' style='cursor:pointer; padding: 1px 4px 3px 4px; border-bottom:1px dashed #aaa' "
		   			+ "onclick=\"javascript:onSfRsltExec('" 
		   				+ pData.sfResultInfoList[idx].ehqkReqId + "','"
		   				+ pData.sfResultInfoList[idx].ehqkTranGbcd + "','" 
		   				+ idx + "');\">[" 
				+ pData.sfResultInfoList[idx].ehqkDt + "] " 
				+ pData.sfResultInfoList[idx].ehqkOrgArea + "</li>";
		   		
		   		$("#sfResultInfo").append(innerHtml);
			} 
		   	
		   	if(firstChk=="Y") {
		   		onSfRsltExec(pData.sfResultInfoList[0].ehqkReqId, pData.sfResultInfoList[0].ehqkTranGbcd, 0);
		   		firstChk = 'N';
		   	}
	    }
	}); 
}

/*
 * 지진정보 -  지진안전성 분석결과 목록클릭후 정보를 가져옴
 */
function ehqkExec(idx) {
	var jsonObj = eval("("+jsonObjList+")").sfResultInfoList[idx];
	
	$("#ehqkInfoData").empty();  
	var tmpData = ""; 
	tmpData =  tmpData + ("<li class='graph_txt'>규모 : " + jsonObj.ehqkScal + "</li>"); 
	tmpData =  tmpData + ("<li class='graph_txt'>진앙 : " + jsonObj.ehqkOrgArea + "</li>");
	tmpData =  tmpData + ("<li class='graph_txt'>진원시 : " + timeFormat(jsonObj.ehqkSttm) + "</li></ul>");
	$("#ehqkInfoData").append(tmpData);  
}


/*
 * 점검필요 시설물 목록 
 */
function iptnExec() {
	
	$.ajax({
		url: "${ctx}/main/IptnInfoJson.do",
		dataType: 'json',
		type : 'POST',
		contentType: "application/json",
		async: false,  
		data: JSON.stringify(inptFrm),
		beforeSend: function(){
			$("#chkIptnList").empty();
			$("#chkIptnList").append("<div id='load' style='height:100px; vertical-align:middle;' align='center'><img src='${ctx}/images/theme/ajax-loader.gif' /></div>");
 	    },
		complete: function(){
			//alert('complet');
		},
		success: function(data) { 
			var pData = JSON.parse(data); 
			$("#chkIptn").text("시설물점검정보 - " + pData.iddlFctyChkCnt  + "/" + pData.fctyTotCnt + "개소"); 
			$("#chkIptnList").empty();
			for (var idx = 0; idx < Object.keys(pData.iptnInfoList).length;idx++) {   
				$("#chkIptnList").append("<li style='padding: 1px 4px 3px 4px; border-bottom:1px dashed #aaa'>[" + pData.iptnInfoList[idx].fctyKndNm + "]" + pData.iptnInfoList[idx].fctyNm + "</li>");
			}

		}
	}); 
}

/*
 * 분석결과 요약
 */
function otnExec() {
   
	$.ajax({
		url: "${ctx}/main/EhqkOtnInfoJson.do",
		dataType: 'json',
		type : 'POST',
		contentType: "application/json",
		async: false,  
		data: JSON.stringify(inptFrm),
		beforeSend: function(){
			$("#ehqkOtnInfo").empty();
			$("#ehqkOtnInfo").append("<div id='load' style='height:100px; vertical-align:middle;' align='center'><img src='${ctx}/images/theme/ajax-loader.gif' /></div>");
 	    },
		complete: function(){
			//alert('complet');
		},
		success: function(data) { 
			var pData = JSON.parse(data); 
			$("#ehqkOtnInfo").empty();
			/*FCTY_DATA_01 */
			if(Object.keys(pData.ehqkOtnInfoList).length==0) {
				$("#ehqkOtnInfo").append("<li>지반가속도 최대값 계측 지역</li>");
				$("#ehqkOtnInfo").append("<li>설계지반가속도 초과 지역</li>");
				$("#ehqkOtnInfo").append("<li>최대 층간변위비 건축물</li>");	
			} else {
				idx = 0;
				$("#ehqkOtnInfo").append("<li>지반가속도 최대값 계측 지역<br>[" + pData.ehqkOtnInfoList[idx].fctyData01  + "]</li>");
				$("#ehqkOtnInfo").append("<li>설계지반가속도 초과 지역<br>[" + pData.ehqkOtnInfoList[idx].fctyData02  + "]</li>");
				$("#ehqkOtnInfo").append("<li>최대 층간변위비 건축물<br>[" + pData.ehqkOtnInfoList[idx].fctyData03  + "]</li>");	
			}
		}
	}); 
}

/*
 * 자기장 가속도 Chart 영역
 */
function evntCharts() { 
	
    $.ajax({
        type : "POST" 
        , async : false 
        , url : "${ctx}/flot/WaveEvntFrm.do" 
        , dataType : "html" 
        , cache : false  
        , data : $("#inptForm").serialize()
        , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
        , error : function(request, status, error) {
			alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
        }
	    , beforeSend: function(){
			$("#wvEvntFrm").empty();
			$("#wvEvntFrm").append("<div id='load' style='height:100px; vertical-align:middle;' align='center'><img src='${ctx}/images/theme/ajax-loader.gif' /></div>");
		}
		, complete: function(){
			//alert('complet');
		}
        , success : function(response, status, request) {
         	$('#wvEvntFrm').html(response);   
        }
       
    });
} 

 
//선택된 항목에 대한 값 변경
function onSfRsltExec(ehqkReqId,ehqkTranGbcd, idx) {
	 
	inptFrm = { 
		flag:"PGA",
		ehqkReqId:ehqkReqId,
		ehqkTranGbcd:ehqkTranGbcd 
	};
	//alert(ehqkReqId+"/"+ehqkTranGbcd);
	$("#ehqkReqId").val(ehqkReqId);
	$("#ehqkTranGbcd").val(ehqkTranGbcd);
	
	ehqkExec(idx);  //지진정보 
	iptnExec();   //점검필요 시설물 목록 
	otnExec();    //분석결과요약
	evntCharts(); //챠트 
		
	$("#bar_content01").css("width",690);   
	$("#bar_content01").css("height",170);   
	
	$("#bar_content02").css("width",690);   
	$("#bar_content02").css("height",170); 
	
	eventBarExec(); 	
		 
}

 
function timeFormat(time) {
	var tmp = "";
	if(time!="") {
		tmp = time.substring(0,4) + "/" + time.substring(4,6) + "/" + time.substring(6,8) + " ";
		tmp = tmp + time.substring(8,10) + ":" + time.substring(10,12) + ":" + time.substring(12,14);
	}
	return tmp;
}

//지진안전성분석결과 목록을 100초 마다 갱신함
function sf_update() {
    sfExec();

    //setTimeout(sf_update, 100000);
}

$(document).ready(function () {  
	sf_update();  
	//evntCharts();
});
  //-->
 </script>
</head>

<BODY>  

<form   id="inptForm" name="inptForm" method="post">  
	<input type="hidden"  id="flag" name="flag"  value="PGA" />
	<input type="hidden"  id="fctyCd" name="fctyCd" />
	<input type="hidden"  id="gvmtCd" name="gvmtCd" />
	<input type="hidden"  id="iddlAassNo" name="iddlAassNo" />
	<input type="hidden"  id="ehqkReqId" name="ehqkReqId" />  
	<input type="hidden"  id="ehqkTranGbcd" name="ehqkTranGbcd" />  
</form>
<!-- STR:top_menu -->
<div id="top_wrap">
	 <c:import url="/main/EstamIncHeader.do?flag=MAIN" /> 
</div>
<!-- END:top_menu -->

<!-- STR:컨텐츠 -->	
<div id="contents_wrap">
	<div id="contents">

		<!-- STR:지도 -->		
		<div class="map">
			<div id="map_left" class="map_left"> 
				 <c:import url="/main/EstamIncEvntMapLeft.do" />  
			</div>

			<div class="map_right">		
				 <c:import url="/arcgis/ArcGisEvntMapView.do?flag=PGA" /> 
				  
			</div>
		
		</div>
		<!-- END:지도 -->
		
		<!-- STR:우측 그래프 -->
		<div id="graph" class="graph">

			<!-- STR:지진정보 -->
			<div class="data01">
				<%-- <c:import url="/EgovPageLink.do?vlink=estam/emain/inc/EstamIncEhqkInfo" /> --%>
				<ul>
					<li class="graph_title01">지진정보</li>
				</ul>
				<ul id="ehqkInfoData" style="position: relative;overflow:hidden;width:350px;height:70px;">  
					<li class="graph_txt" >규모:</li> 
					<li class="graph_txt">진앙:</li>
					<li class="graph_txt">진원시:</li>
				</ul> 
			</div>
			<!-- END:지진정보 -->
			
			<!-- STR:지진안전성분석결과 목록 -->
			<div class="data01" >
				<%-- <c:import url="/EgovPageLink.do?vlink=estam/emain/inc/EstamIncSfResultInfo" /> --%>
				<ul>
					<li class="graph_title01">지진안전성분석결과 목록</li>
				</ul>
				<ul class="graph_txt2_list" id="sfResultInfo" style="height:70px;overflow-y: scroll;">  
					<li class="graph_txt2" ></li>
				</ul>  
			</div>
			<!-- END:지진안전성분석결과 목록 -->

			<!-- STR:지진가속도 계측 최대값 -->
			<div class="data02">
				<ul>
					<li class="graph_title02">행정구역별 안전성분석결과</li>
				</ul>
				<div class="data02_down">
					<c:import url="/flot/PgrEventBarForm.do?flag=EVENTBAR" /> 
				</div>
			</div>
			<!-- END:지진가속도 계측 최대값 -->
			
	       <!-- STR:지진가속도 계측 최대값 하단 결과값 -->
			<div class="data04">	
				<div style="float:left;">
					<div class="graph_bott02">
						<div>
							<%-- <c:import url="/EgovPageLink.do?vlink=estam/emain/inc/EstamIncIptnInfo" />--%> 
							<ul>
								<li class="graph_title04">점검필요 시설물 목록</li>
								<li class="txt2" style='border-bottom:1px solid #f7c911' id="chkIptn"></li>
							</ul>
							<ul class="txt3" id="chkIptnList" style="height:83px;overflow-y: scroll;">
								<li></li>
								<li></li>
								<li></li>
								<li></li>
							</ul>
						</div>
					</div>
					<div class="graph_bott04">
						<div>
							<!--<c:import url="/EgovPageLink.do?vlink=estam/emain/inc/EstamIncEhqkOtnInfo" />--> 
							<ul>
								<li class="graph_title03">분석결과 요약</li>
							</ul>
							<ul id="ehqkOtnInfo" class="txt" style="height:103px;overflow-y: scroll;">
								<li>지반가속도 최대값 계측 지역 </li> 
								<li>설계지반가속도 초과 지역</li>
								<li>최대 층간변위비 건축물</li>
							</ul>
							<ul>
								<li class="graph_title03"></li>
							</ul>
						</div>
 					</div>
				</div>
				<div id="wvEvntFrm" class="graph_bott03">
					 
				</div>
			</div>
			<!-- END:지진가속도 계측 최대값 하단 결과값-->

		</div>
		<!-- END:우측 그래프 -->

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