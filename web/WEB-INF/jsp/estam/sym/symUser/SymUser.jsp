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
  
$(document).ready(function () {  

   	var fncIframePageLoding = function(){ 
   		 
   		$("#iframe01")[0].src = "${ctx}/xrf/sym/usr/UserMgr.xrf";
   	};
   	
   	fncIframePageLoding();
 
});
    	
</script>
</head>

<BODY>
<form name="mapLeftForm" id="mapLeftForm"  method="post">
    <input type="hidden" id="menuNo" name="menuNo" value=""/> 
	<input type="hidden" id="flag" name="flag" value="" />
	<input type="hidden" id="maplink" name="vlink" value="" />	
</form>		        
<!-- STR:top_menu -->
<div id="top_wrap">
    <c:import url="/main/EstamIncHeader.do?flag=MAIN" /> 
</div> 
<!-- END:top_menu -->  

<!-- STR:컨텐츠 -->	
<div id="contents_wrap">
	<div id="contents">

		<br>
		<div class="content_title"><h2>사용자관리</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">시스템설정</a></li>
				<li class="last">사용자관리</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div> 
		<div>
       		 <iframe id="iframe01" src="" width="100%" height="735px"/>  
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
