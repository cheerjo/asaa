<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  

<%@ page import ="egovframework.com.cmm.LoginVO" %>

<!DOCTYPE html>
<html>
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
 
 
  function fctyExec(leftMapGubun,fctyCd,gvmtCd) {
	  
   	   var fctyForm = {
   				  fctyFlag:leftMapGubun,
   				  fctyCd:fctyCd,
   				  gvmtCd:gvmtCd};   
   	   
   	  	$.ajax({
   	  	      url: "${ctx}/main/FctyInfoJson.do",
   	  	   	  dataType: 'json',
   	          type : 'POST',
   	          contentType: "application/json; charset=UTF-8",
   	          async: false, 
   	  	      data:  JSON.stringify(fctyForm) ,
   	  	      success: function(data) { 
   	  	    	//  alert(data);
   	  	    	var pData = JSON.parse(data); 
   	  	 
   	  	    	$("#estamFctyInfo").empty();  
   	  	    /*	if (pData.vFctyMgrInfoVo.fctyImgUrl == undefined) { 
   			  		
   	  	    	} else {
   	  	    		alert(pData.vFctyMgrInfoVo.fctyImgUrl);
   	  	   			
   	  	    	} */
   	  	   	    if (pData.vFctyMgrInfoVo.fctyNm == null) {
   	  	          	 $("#estamFctyInfo").append("<li><img src='${ctx}/img/etc/no_img.jpg' title='' style='width:235px;height:120px'/></li>");
		   	 	   	 $("#estamFctyInfo").append("<li class='title'> </li>");
			 		 $("#estamFctyInfo").append("<li>위치 : </li>");
					  /*$("#estamFctyInfo").append("<li>안전성 점검결과 : " + "안전" + "</li>"); */
   	  	    	 } else  {
   	  	    	   //$("#imgdata").text(pData.vFctyMgrInfoVo.fctyImgUrl);
   	  	      	    $("#estamFctyInfo").append("<li><img src='" + pData.vFctyMgrInfoVo.fctyImgUrl  + "' title='' style='width:235px;height:120px'/></li>");
	   	  	   		$("#estamFctyInfo").append("<li class='title'>" + pData.vFctyMgrInfoVo.fctyNm + "</li>");
				  	$("#estamFctyInfo").append("<li>위치 : " + pData.vFctyMgrInfoVo.fctyStAddr + pData.vFctyMgrInfoVo.fctyEdAddr + "</li>");
				  	/*$("#estamFctyInfo").append("<li>안전성 점검결과 : " + "안전" + "</li>"); */
   	  	    	
   	  	    	 }
   			  
   	  	      }
   	  	  }); 
      }
  

  $(document).ready(function () {
        
  });
      
</script> 

</head>

<body> 
<div id="imgdata"></div>       
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
			<div id="map_left"  class="map_left">
				 <c:import url="/main/EstamIncMapLeft.do" />  
			</div> 
			<div id="map_rightview" class="map_right">
				<c:import url="/arcgis/ArcGisMapView.do?flag=${leftMapGubun}" />
			</div> 
		</div>
		<!-- END:지도 -->
		
		<!-- STR:우측 그래프 -->
		<div id="graph" class="graph"> 
			<!-- STR:이상진동 감지 -->
			<div class="data01">
			    <c:import url="/EgovPageLink.do?vlink=estam/main/inc/EstamIncEventInfo" /> 
			</div>
			<!-- END:이상진동감지 -->
			
			<!-- STR:계측신호 오류 감지 -->
			<div class="data01">
				<c:import url="/EgovPageLink.do?vlink=estam/main/inc/EstamIncScnErrInfo" /> 
			</div>
			<!-- END:계측신호 오류감지 -->

			<!-- STR:지진가속도 계측 최대값 -->
			<div class="data02_1">
				<ul>
					<li class="graph_title02">행정구역별 실시간 지진가속도 계측 최대값</li>
				</ul>
				<div class="data02_down">
					 <c:import url="/flot/PgrBarForm.do" /> 
				</div>
			</div>
			<!-- END:지진가속도 계측 최대값 -->
			
			<!-- STR:지진가속도 계측 최대값 하단 결과값 -->
			<div class="data03">				
				<div class="graph_bott">
					<ul id="pga_graph_title">
						<li id="waveTitle" class="graph_title03"></li>
					</ul>
					<div id="waveForm" class="graph_bott_down"> 
						<c:import url="/flot/WaveForm.do" />   
					</div>
				</div> 
				<div id="fctyInfo" class="graph_bott_right">
					<c:import url="/EgovPageLink.do?vlink=estam/main/inc/EstamIncFctyInfo" />  
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

</body>
</html>
 