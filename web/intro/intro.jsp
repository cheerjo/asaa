<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  

<!DOCTYPE html>
<html lang="ko">
<head>
<title>국립재난안전연구원 지진가속도 응답신호 종합분석 시스템</title>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석 시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석">

<link rel="stylesheet" href="${ctx}/css/style.css"> 

<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script>   
<script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script>  

<script src="${ctx}/js/estam_common.js"></script>
<script type="text/javascript"> 
    function goLeftMapPage(mapFlag,linkUrl){
     
	    if (mapFlag == 'PGA') {	
   	    	setLocProcess(mapFlag);	
    	} else if (mapFlag == 'MM') {	  
	    	setLocProcess(mapFlag);
        } else if (mapFlag == 'GVMT') {	  
            setLocProcess(mapFlag);
        }  
    }
    
    function mapfctyKndExec(src01, src02) {
        mapfctyKndExec(src01, src02);
    }
      

    function introFctyExec(mode, url){ 
    		  
    	 if (mode == "01") {   
  	       $('#tab_02').removeClass('tab02_on').addClass('tab02'); 
  	       $('#tab_01').removeClass('tab01').addClass('tab01_on');
  	   
		 } else {
		       $('#tab_01').removeClass('tab01_on').addClass('tab01'); 
	  	       $('#tab_02').removeClass('tab02').addClass('tab02_on');
		 }

    	} 
    
  
    function onExecUrl(execUrl) {
    	 
          var frm = document.getElementById("execurl"); 
          frm.action = execUrl; 
          frm.submit();
    }
    
</script>
</head>

<BODY>
 <form name="execurl" id="execurl"  method="post"> 
</form>	
<!-- STR:컨텐츠 -->	
<div id="contents_wrap2">
	<div id="contents2">

		<!-- STR:지도 -->		
		<div class="map3">
		<div class="intro_tab">
			<ul>
				<li id="tab_01" class="tab01_on" onClick="introFctyExec('01','');" style="cursor: pointer;"><a herf="#">지진가속도 응답신호 종합분석 시스템</a></li><!-- _on 을 붙이면 선택 -->
				<li id="tab_02" class="tab02" onClick="introFctyExec('02','');" style="cursor: pointer;"><a herf="#">지진재해 위험성 평가 시스템</a></li>
			</ul>
		</div>

		<div class="map_out_top"><img src="/img/bg/bg_introbox_top.png"/></div>
		<div class="map_out_left"><img src="/img/bg/bg_introbox_left.png"/></div>
		<div class="map_out_bottom"><img src="/img/bg/bg_introbox_bottom.png"/></div>
		<div class="map_out_right"><img src="/img/bg/bg_introbox_right.png"/></div>

			<div class="map_left2">
				 			
				<!-- STR:지도 왼쪽 버튼 -->
				<div class="map_btn" style="margin:60px 0 0 20px;height:100px;">
					<ul>
						<li class="btn_map01_01"><a href="#"  onclick="javascript:goLeftMapPage('PGA','<c:out value="${curLinkUrl}"/>')" title="PGA">PGA</a></li>	
						<li class="btn_map02_01"><a href="#" onclick="javascript:goLeftMapPage('MM','<c:out value="${curLinkUrl}"/>')"  title="진도(MMI)">진도(MMI)</a></li>	
					</ul>
				</div>
				<!-- END:지도 왼쪽 버튼 -->
				
				<!-- STR:지도 왼쪽 테이블 -->
				<div class="map_tb2">
					<table>
						<tr>
							<th>진도<br>(MMI)</th>
							<th>진동감지</th>
						</tr>
						<tr>
							<td class="step">Ⅰ</td>
							<td>무감</td> <!-- #ffffff -->
						</tr>
						<tr>
							<td class="step">Ⅱ-Ⅲ</td>
							<td>약한진동</td> <!-- #83ebee -->
						</tr>
						<tr>
							<td class="step">Ⅳ</td>
							<td>가벼운진동</td> <!-- #96d28c -->
						</tr>
						<tr>
							<td class="step">Ⅴ</td>
							<td>보통진동</td> <!-- #fafc6a -->
						</tr>
						<tr>
							<td class="step">Ⅵ</td>
							<td>강한진동</td> <!-- #dfab00 -->
						</tr>
						<tr>
							<td class="step">Ⅶ</td>
							<td>매우강한진동</td> <!-- #fe9900 -->
						</tr>
						<tr>
							<td class="step">Ⅷ</td>
							<td>심한진동</td> <!-- #c34a01 -->
						</tr>
						<tr>
							<td class="step">Ⅸ</td>
							<td>격렬한진동</td> <!-- #f01501 -->
						</tr>
						<tr>
							<td class="step">Ⅹ+</td>
							<td>극한진동</td> <!-- #6c0000 -->
						</tr>
					</table>
				</div>
				<!-- END:지도 왼쪽 테이블 -->

				<!-- STR:지도 왼쪽 아이콘 -->
				<div class="map_tb2_ico">
					<div class="map_tb2_ico_title">계측소</div>
					<table>						
						<tr>
							<td><img src="/img/common/ico_map01.png" title="" /></td><!-- _r을 붙이면 빨간색 아이콘 -->
							<td>중앙행정기관(청사)(55)</td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map02.png" title="" /></td>
							<td>국립대학교(12) </td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map04.png" title="" /></td>
							<td>공항시설(17) </td>
						</tr>
					</table>
					<table>
						<tr>
							<td width="24"><img src="/img/common/ico_map05.png" title="" /></td>
							<td>댐,저수지(1)</td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map06.png" title="" /></td>
							<td>현수교(사장교)(1)  </td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map07.png" title="" /></td>
							<td>가스시설(43) </td>
						</tr>
					</table>
					<table>
						<tr>
							<td><img src="/img/common/ico_map08.png" title="" /></td>
							<td>고속철도(0)</td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map09.png" title="" /></td>
							<td>원자력(5)</td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map10.png" title="" /></td>
							<td>변전소(0)</td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map11.png" title="" /></td>
							<td>화력,수력발전설비(23)</td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map12.png" title="" /></td>
							<td>기타(1)</td>
						</tr>
					</table>
				</div>
				<!-- END:지도 왼쪽 아이콘 -->

			</div>

			<div class="map_right2">		
				<c:import url="/intro/IntroGisView.do?flag=PGA" />
			</div>
		
		</div>
		<!-- END:지도 -->
		
		<!-- STR:우측 그래프 -->
		<div class="graph2">

			<div class="btn_intro_right01"><a href="#" onClick="onExecUrl('http://10.32.28.204:8001');" style="cursor: pointer;">지진가속도 응답신호 종합분석 시스템</a></div>
			<div class="btn_intro_right02"><a href="#" onClick="onExecUrl('http://10.32.28.206');" style="cursor: pointer;">지진재해 위험성 평가 시스템</a></div>
			
		</div>
		<!-- END:우측 그래프 -->
		<br class="clear">
	</div>	
</div>
<!-- END:컨텐츠 -->	




</BODY>
</HTML>
