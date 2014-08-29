<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript" src="${pageContext.request.contextPath}/js/jquery-1.9.0.js"></script>
<script type="text/javascript">

//var jspVoPage =window.parent.page;
//jspVoPage = jspVoPage.searchPage("main");

//var jspVoInstance = jspVoPage.getInstance("reqInstance");
//var jspVoDataSet = jspVoPage.getDataSet("dstMain");


jQuery( function() {
    (function($) {

    	var fncIframePageLoding = function(pageID){
    		 
    		  if(!!pageID)
    			  $("#iframe01")[0].src = "${pageContext.request.contextPath}/xrf/"+ sym/usr/UserMgr + ".xrf";
    	};
    	
    	//page onLoad
        $(document).ready( function() {        	
        	$('a[id^=sym]').bind('click', function(event){
        		if((this.title*1) >= 4){
	        		alert('없음');
	        	}else{
	        		fncIframePageLoding(this.id);	
	        	}
        	});
        	$('a[id^=signalux]').bind('click', function(event){
        		if((this.title*1) >= 4){
	        		alert('없음');
	        	}else{
	        		fncIframePageLoding(this.id);	
	        	}
        	});
        	$('a[id^=map]').bind('click', function(event){
        		if((this.title*1) >= 4){
	        		alert('없음');
	        	}else{
	        		fncIframePageLoding(this.id);	
	        	}
        	});
        	$('a[id^=chart]').bind('click', function(event){
        		if((this.title*1) >= 4){
	        		alert('없음');
	        	}else{
	        		fncIframePageLoding(this.id);	
	        	}
        	});
        	$('a[id^=test]').bind('click', function(event){
        		if((this.title*1) >= 4){
	        		alert('없음');
	        	}else{
	        		fncIframePageLoding(this.id);	
	        	}
        	});
          //fncParTreeLoding(1);
          
        });    	
    })(jQuery);
});
    	
</script>
 
<style type="text/css"> 
	/*style the main menu*/
	.myMenu {
		margin:0;
		padding:0;
	}
	
	.myMenu li {
		list-style:none;
		float:left;
		font:12px Arial, Helvetica, sans-serif #111;
	}
	
	.myMenu li a:link, .myMenu li a:visited {
		display:block;
		text-decoration:none;
		background-color:#09F;
		padding: 0.5em 2em;
		margin:0;
		border-right: 1px solid #fff;
		color:#111;
	}
	
	.myMenu li a:hover {
		background-color:#0CF;	
	}
	
	/*style the sub menu*/
	.myMenu li ul {
		position:absolute;
		visibility:hidden;
		border-top:1px solid #fff;
		margin:0;
		padding:0;
	}
	
	.myMenu li ul li {
		display:inline;
		float:none;
	}
	
	.myMenu li ul li a:link, .myMenu li ul li a:visited {
		background-color:#09F;
		width:auto;
	}
	
	.myMenu li ul li a:hover {
		background-color:#0CF;	
	}

</style>

<script type="text/javascript">
	$(document).ready(function() {
		$('.myMenu > li').bind('mouseover', openSubMenu);
		$('.myMenu > li').bind('mouseout', closeSubMenu);
		
		function openSubMenu() {
			$(this).find('ul').css('visibility', 'visible');	
		};
		
		function closeSubMenu() {
			$(this).find('ul').css('visibility', 'hidden');	
		};
				   
	});
</script>

</head>
<body>
<div>

<ul class="myMenu">
	<li><a href="#">menu item 1</a></li>
    <li><a href="#">차트</a>
    	<ul>
        	<li><a href="#" id="chart/charts/rainfall" style="cursor: pointer;" title="막대그래프">막대그래프-PGA</a></li>
            <li><a href="#" id="chart/flot/necis" style="cursor: pointer;" title="파형그래프">파형그래프</a></li>
            <li><a href="#" id="test/mainTest" style="cursor: pointer;" title="main">mainTest</a></li>
            <li><a href="#" id="test/evntMainTest" style="cursor: pointer;" title="eventMain">eventMainTest</a></li>
        </ul>
    </li>
    <li><a href="#"  id="map/ArcGis" style="cursor: pointer;" title="ArcGisTest">ArcGisTest</a></li> 
    <li><a href="#">SignalUx</a>
        <ul>
        	<li><a href="#"  id="signalux/SignalUxCfg" style="cursor: pointer;" title="SignalUx설정">SignalUx설정</a></li>
            <li><a href="#"  id="signalux/SignalUxExec" style="cursor: pointer;" title="SignalUx실행">SignalUx실행</a></li>
            <li><a href="#">sub menu item 3</a></li>
            <li><a href="#">sub menu item 4</a></li>
        </ul>
    </li>     
    <li><a href="#">시스템설정</a>
    	<ul>
        	<li><a href="#"  id="sym/usr/UserMgr" style="cursor: pointer;" title="사용자관리">사용자관리</a></li>
            <li><a href="#"  id="sym/mnu/MenuMgr" style="cursor: pointer;" title="메뉴관리">메뉴관리</a></li>
            <li><a href="#"  id="sym/grp/GroupMgr" style="cursor: pointer;" title="권한그룹관리">권한그룹관리</a></li>
            <li><a href="#"  id="sym/mgp/MenuGroupMgr" style="cursor: pointer;" title="메뉴권한그룹관리">메뉴권한그룹관리</a></li>
            <li><a href="#"  id="sym/cmm/ComCdMgr" style="cursor: pointer;" title="공통코드관리">공통코드관리</a></li>
            <li><a href="#"  id="sym/cmm/ComCdDtlMgr" style="cursor: pointer;" title="공통코드상세관리">공통코드상세관리</a></li>
        </ul>
    </li>
    <li><a href="<c:url value='/login/actionLogout.do'/>">로그아웃</a></li>
</ul>
    	 
	<!-- <table>
		 <tbody><tr><th id="menu_1" style="cursor: pointer;" title="1">menu1</th>
		 <th id="menu_2" style="cursor: pointer;" title="2">menu2</th>
		 <th id="menu_3" style="cursor: pointer;" title="3">menu3</th>
		 <th id="menu_4" style="cursor: pointer;" title="4">menu4</th>
		 <th id="menu_5" style="cursor: pointer;" title="5">menu5</th>
		 <th id="menu_6" style="cursor: pointer;" title="6">menu6</th>
		 <th id="menu_7" style="cursor: pointer;" title="7">menu7</th>
		 <th id="menu_8" style="cursor: pointer;" title="8">menu8</th>
		 <th id="menu_9" style="cursor: pointer;" title="9">menu9</th>
		 <th id="menu_10" style="cursor: pointer;" title="10">menu10</th>
		 </tr></tbody>
	</table> -->
</div>
<div>
	<iframe id="iframe01" src="" width="100%" height="100%"> 
</div>
</body>
</html>