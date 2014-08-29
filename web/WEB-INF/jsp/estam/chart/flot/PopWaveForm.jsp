<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>
<%
 /**
  * @Class Name :  
  * @Description : 시설물 상세정보 - 가속도 그래프.
  * @Modification Information
  * 
  * @author atres
  * @since 2013.10.16
  * @version 1.0
  * @see
  *  
  * Copyright (C) All right reserved.
  */
%>
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
   
<script type="text/javascript" src="${ctx}/js/chart/real/excanvas.min.js"></script>   
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.stack.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script> 
 
<script>
 
 $(document).ready(function() { 
        $("#flot_wave_content01").css("width",1200);
        $("#flot_wave_content01").css("height",200);
        $("#flot_wave_content02").css("width",1200);
        $("#flot_wave_content02").css("height",200);
        $("#flot_wave_content03").css("width",1200);
        $("#flot_wave_content03").css("height",200);
          
        // We use an inline data source in the example, usually data would
        // be fetched from a server 
         var form = {
            GVMT: "SL"
         };
        
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
        
        var options={
                series: {
                    shadowSize: 0   // Drawing is faster without shadows
                },
                yaxis: {
                    //min: -0.5,
                    //max: 0.5
                	  axisLabel: "가속도1 (gal)",
                      axisLabelUseCanvas: true,
                      axisLabelFontSizePixels: 12,
                      axisLabelFontFamily: 'Verdana, Arial',
                      axisLabelPadding: 6
                },
                xaxis: {
                	 show: true,
                	 axisLabel: "Time (초)",
                     axisLabelUseCanvas: true,
                     axisLabelFontSizePixels: 12,
                     axisLabelFontFamily: 'Verdana, Arial',
                     axisLabelPadding: 10
                },
                legend: {
                    noColumns: 0,
                   // labelBoxBorderColor: "#afd8f8",
                    position: "ne"
                },
                grid: {
                     hoverable: true,
                     borderWidth: 1
                 //  backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
                } 
        }; 

        var plot01 = $.plot("#waveplaceholder01", [getRandomData()], options);
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

</head>

<body> 
                      <div>
		           <div  ><ul><li>${mapWvEvFr.fctyNm}&nbsp;자유장 가속도<br><br></li></ul></div> 
                            <div class="content_title2"><ul><li>가속도(E-W)</li></ul></div>
                            <div id="flot_wave_content01" class="wave-event-container">
                                <div id="waveplaceholder01" class="wave-placeholder"></div> 
                            </div>
                            <div class="content_title2"><ul><li>가속도(N-S)</li></ul></div>
                            <div id="flot_wave_content02" class="wave-event-container">
                                <div id="waveplaceholder02" class="wave-placeholder"></div> 
                            </div>
                            <div class="content_title2"><ul><li>가속도(V)</li></ul></div>
                            <div id="flot_wave_content03" class="wave-event-container">
                                <div id="waveplaceholder03" class="wave-placeholder"></div> 
                            </div>
                    </div>
 
 
</body>
</html>