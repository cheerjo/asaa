<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
<%
 /**
  * @Class Name :  
  * @Description : 시설물 상세정보 - 응답스펙트럼  그래프.
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

 <script>
 $(document).ready(function() { 
	 
	 	$("#flot_wave_content40_01").css("width",583);   
		$("#flot_wave_content40_01").css("height",300); 
		
	    //$("#flot_wave_content40_02").css("width",583);   
		//$("#flot_wave_content40_02").css("height",150); 
		
		//$("#flot_wave_content40_03").css("width",583);   
		//$("#flot_wave_content40_03").css("height",150);

		//$("#flot_wave_content40_04").css("width",583);   
		//$("#flot_wave_content40_04").css("height",450); 
		
		var data = [],
			totalPoints = 100;
 
        function getRandomData40_01() {
            var res = [];
            <c:forEach var="data2" items="${data2}" varStatus="status">
             res.push([${data2.rsltTimeX}, ${data2.rsltValueY2}]); 
            </c:forEach> 
            return res;
        }
        function getRandomData40_02() {
            var res = [];
            <c:forEach var="data" items="${data}" varStatus="status">
             res.push([${data.rsltTimeX}, ${data.rsltValueY2}]); 
            </c:forEach> 
            return res;
        }  
        function getRandomData40_03() {
            var res = [];
            <c:forEach var="data2" items="${data2}" varStatus="status">
             res.push([${data2.rsltTimeX}, ${data2.rsltValueY3}]); 
            </c:forEach> 
            return res;
        }
        function getRandomData40_04() {
            var res = [];
            <c:forEach var="data2" items="${data2}" varStatus="status">
             res.push([${data2.rsltTimeX}, ${data2.rsltValueY4}]); 
            </c:forEach> 
            return res;
        }
        function getRandomData40_05() {
            var res = [];
            <c:forEach var="data2" items="${data2}" varStatus="status">
             res.push([${data2.rsltTimeX}, ${data2.rsltValueY5}]); 
            </c:forEach> 
            return res;
        }
        function getRandomData40_06() {
            var res = [];
            <c:forEach var="data2" items="${data2}" varStatus="status">
             res.push([${data2.rsltTimeX}, ${data2.rsltValueY6}]); 
            </c:forEach> 
            return res;
        }
        function getRandomData40_07() {
            var res = [];
            <c:forEach var="data2" items="${data2}" varStatus="status">
             res.push([${data2.rsltTimeX}, ${data2.rsltValueY7}]); 
            </c:forEach> 
            return res;
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
		var options04_01={
                series: {
                    shadowSize: 0   // Drawing is faster without shadows
                },
                yaxis: {
                    //min: -0.5,
                    //max: 0.5
                      axisLabel: "가속도 (gal)",
                      axisLabelUseCanvas: true,
                      axisLabelFontSizePixels: 12,
                      axisLabelFontFamily: 'Verdana, Arial',
                      axisLabelPadding: 6
                },
                xaxis: {
                    
                     show: true,
                     axisLabel: "주기 (초)",
                     axisLabelUseCanvas: true,
                     axisLabelFontSizePixels: 12,
                     axisLabelFontFamily: 'Verdana, Arial',
                     axisLabelPadding: 10
                },
                    grid: {
                            hoverable: true,
                            borderWidth: 1
                    //   backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
                        } 
        };
        var options04_02={
                series: {
                    shadowSize: 0   // Drawing is faster without shadows
                },
                yaxis: {
                    //min: -0.5,
                    //max: 0.5
                      axisLabel: "속도 (mm/sec)",
                      axisLabelUseCanvas: true,
                      axisLabelFontSizePixels: 12,
                      axisLabelFontFamily: 'Verdana, Arial',
                      axisLabelPadding: 6
                },
                xaxis: {
                    
                     show: true,
                     axisLabel: "주기 (초)",
                     axisLabelUseCanvas: true,
                     axisLabelFontSizePixels: 12,
                     axisLabelFontFamily: 'Verdana, Arial',
                     axisLabelPadding: 10
                },
                    grid: {
                            hoverable: true,
                            borderWidth: 1
                    //   backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
                        } 
        };		

        var options04_03={
                series: {
                    shadowSize: 0   // Drawing is faster without shadows
                },
                yaxis: {
                    //min: -0.5,
                    //max: 0.5
                      axisLabel: "변위 (mm)",
                      axisLabelUseCanvas: true,
                      axisLabelFontSizePixels: 12,
                      axisLabelFontFamily: 'Verdana, Arial',
                      axisLabelPadding: 6
                },
                xaxis: {
                    
                     show: true,
                     axisLabel: "주기 (초)",
                     axisLabelUseCanvas: true,
                     axisLabelFontSizePixels: 12,
                     axisLabelFontFamily: 'Verdana, Arial',
                     axisLabelPadding: 10
                },
                    grid: {
                            hoverable: true,
                            borderWidth: 1
                    //   backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
                        } 
        };
        var options04_04={
                series: {
                    shadowSize: 0   // Drawing is faster without shadows
                },
                yaxis: {
                    //min: -0.5,
                    //max: 0.5
                      axisLabel: "H/V ratio",
                      axisLabelUseCanvas: true,
                      axisLabelFontSizePixels: 12,
                      axisLabelFontFamily: 'Verdana, Arial',
                      axisLabelPadding: 6
                },
                xaxis: {
                    
                     show: true,
                     axisLabel: "진동수 (Hz)",
                     axisLabelUseCanvas: true,
                     axisLabelFontSizePixels: 12,
                     axisLabelFontFamily: 'Verdana, Arial',
                     axisLabelPadding: 10
                },
                    grid: {
                            hoverable: true,
                            borderWidth: 1
                    //   backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
                        } 
        };

		var plot40_01 = $.plot("#waveplaceholder40_01", [ getRandomData40_01(), getRandomData40_03() ], options04_01);
		//var plot40_02 = $.plot("#waveplaceholder40_02", [ getRandomData40_04(), getRandomData40_05() ], options04_02);
		//var plot40_03 = $.plot("#waveplaceholder40_03", [ getRandomData40_06(), getRandomData40_07() ], options04_03);
		//var plot40_04 = $.plot("#waveplaceholder40_04", [ getRandomData40_02() ], options04_04);


		function update() {

			plot40_01.setData([getRandomData40_01(),getRandomData40_03() ]);  
			plot40_01.draw();
			//plot40_02.setData([getRandomData40_04(),getRandomData40_05()]); 
			//plot40_02.draw();
			//plot40_03.setData([getRandomData40_06(),getRandomData40_07()]); 
			//plot40_03.draw();
			//plot40_04.setData([getRandomData40_02()]); 
			//plot40_04.draw();
			//setTimeout(update, updateInterval);

		}

		update();

		 
	});
 
</script>			
 
					<div id="flot_wave_content40_01" class="wave-event-container">
						<div id="waveplaceholder40_01" class="wave-placeholder"></div> 
					</div>   
<!--
					<div id="flot_wave_content40_02" class="wave-event-container">
						<div id="waveplaceholder40_02" class="wave-placeholder"></div> 
					</div>   
					<div id="flot_wave_content40_03" class="wave-event-container">
						<div id="waveplaceholder40_03" class="wave-placeholder"></div> 
					</div>   
		
					<div id="flot_wave_content40_04" class="wave-event-container">
						<div id="waveplaceholder40_04" class="wave-placeholder"></div> 
					</div>  
 --> 