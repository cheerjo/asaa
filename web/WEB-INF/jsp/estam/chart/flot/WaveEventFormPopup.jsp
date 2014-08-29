<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
<%
 /**
  * @Class Name :  
  * @Description : 하단 파형 그리기. - 팝업
  * @Modification Information
  * 
  * @author 
  * @since 2014.01.03
  * @version 1.0
  * @see
  *  
  * Copyright (C) All right reserved.
  */
%>   
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

<script type="text/javascript" src="${ctx}/js/chart/real/excanvas.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.stack.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.axislabels.js"></script>  
   
<script>

 $(document).ready(function() { 
	 
		$("#flot_wave_content01").css("width",980);   
		$("#flot_wave_content01").css("height",200); 
		
 	    $("#flot_wave_content02").css("width",980);   
		$("#flot_wave_content02").css("height",200); 
		
		$("#flot_wave_content03").css("width",980);   
		$("#flot_wave_content03").css("height",200);  
		   
		var data = [],
			totalPoints = 100;
 
        function getRandomData() {
            var res = [];
            <c:forEach var="data" items="${data}" varStatus="status">
             res.push([${data.rsltTimeX}, ${data.rsltValueY2}]); 
            </c:forEach>
            data  = { data: res, color:'#afd8f8'};
            return data;
              
        }
        function getRandomData3() {
            var res = [];
            <c:forEach var="data" items="${data}" varStatus="status">
             res.push([${data.rsltTimeX}, ${data.rsltValueY3}]); 
            </c:forEach> 
            data  = {color:'#afd8f8', data: res};
            return data;
        }
        function getRandomData4() {
            var res = [];
            <c:forEach var="data" items="${data}" varStatus="status">
             res.push([${data.rsltTimeX}, ${data.rsltValueY4}]); 
            </c:forEach>
            data  = {color:'#afd8f8', data: res};
            return data;
        }

		// Set up the control widget 
		var updateInterval = 30;
	/* 	$("#updateInterval").val(updateInterval).change(function () {
			var v = $(this).val();
			if (v && !isNaN(+v)) {
				updateInterval = +v;
				if (updateInterval < 1) {
					updateInterval = 1;
				} else if (updateInterval > 1000) {
					updateInterval = 1000;
				}
				$(this).val("" + updateInterval);
			}
		});  */
		
		var options={
				series: {
					shadowSize: 0	// Drawing is faster without shadows
				},
				yaxis: {
					//min: -0.5,
					//max: 1
				 axisLabel: "가속도 (gal)",
			        axisLabelUseCanvas: true,
			        axisLabelFontSizePixels: 12,
			        axisLabelFontFamily: 'Verdana, Arial',
			        axisLabelPadding: 10
				},
				xaxis: {
					show: true,
					axisLabel: "Time",
			        axisLabelUseCanvas: true,
			        axisLabelFontSizePixels: 12,
			        axisLabelFontFamily: 'Verdana, Arial',
			        axisLabelPadding: 2
				},
		        grid: {
	                    hoverable: true,
	                    borderWidth: 1
	            //   backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
	                } 
		};

		var plot01 = $.plot("#waveplaceholder01", [ getRandomData() ], options);
		var plot02 = $.plot("#waveplaceholder02", [ getRandomData3() ], options);
		var plot03 = $.plot("#waveplaceholder03", [ getRandomData4() ], options);

		function update() {

			plot01.setData([getRandomData()]); 
			plot01.draw();
			plot02.setData([getRandomData3()]); 
			plot02.draw();
			plot03.setData([getRandomData4()]); 
			plot03.draw();  
			//setTimeout(update, updateInterval);
		} 
		
		update();

		 
	});
 
</script>
<BODY> 
	<ul>
        <li><strong>&nbsp;&nbsp;${mapWvEvFr.fctyNm}&nbsp;자유장 가속도</strong></li>
        <li>&nbsp;</li>
        <li>&nbsp;수평(E-W)</li>
        <li>
		<div id="flot_wave_content01" class="wave-event-container">
			<div id="waveplaceholder01" class="wave-placeholder"></div> 
		</div>
		</li>
		<li>&nbsp;수평(N-S)</li>
		<li>   
		<div id="flot_wave_content02" class="wave-event-container">
			<div id="waveplaceholder02" class="wave-placeholder"></div> 
		</div>
		</li>
		<li>&nbsp;수직(V)</li>
		<li>   
		<div id="flot_wave_content03" class="wave-event-container">
			<div id="waveplaceholder03" class="wave-placeholder"></div> 
		</div> 
		</li>
	</ul>  
</BODY>
</HTML> 