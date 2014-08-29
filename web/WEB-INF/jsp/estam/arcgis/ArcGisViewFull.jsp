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
   
</head>

<body> 
    
<!-- STR:컨텐츠 -->	
<div id="contents_wrap">
	<div id="contents"> 

		<!-- STR:지도 -->		
		<div class="map">
			<div id="map_left"  class="map_left">
				 <c:import url="/main/EstamIncMapLeft.do" />  
			</div> 
			<div id="map_rightview" class="map_right">
				<c:import url="/arcgis/ArcGisMapViewFull.do?flag=${leftMapGubun}" />
			</div> 
		</div> 
	</div>	
</div> 

</body>
</html>
 