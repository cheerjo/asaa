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
<link href="${ctx}/js/chart/flot/examples.css" rel="stylesheet" type="text/css">  

 <script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script> 
 <script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script> 
     
</head>

<body>
 <form name="mapLeftForm"  method="post">
	<input type="hidden" id="flag" name="flag" value="" />
	<input type="hidden" id="maplink" name="link" value="" />		
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
			<div class="map_left">
				<c:import url="/EgovPageLink.do?vlink=estam/main/inc/EstamIncMapLeft" /> 
			</div> 
			<div class="map_right">
				  <c:import url="/arcgis/ArcGisMapView.do?flag=PGA" />  
			</div> 
		</div>
		<!-- END:지도 -->
		
		<!-- STR:우측 그래프 -->
		<div class="graph">  

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
