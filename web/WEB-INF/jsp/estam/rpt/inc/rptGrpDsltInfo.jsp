<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
<%
 /**
  * @Class Name :  
  * @Description : 시설물 상세정보 - 변위 그래프.
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
	 
	 	$("#flot_wave_content30_01").css("width",583);   
		$("#flot_wave_content30_01").css("height",200); 
		
	    $("#flot_wave_content30_02").css("width",583);   
		$("#flot_wave_content30_02").css("height",200); 

		$("#flot_wave_content30_03").css("width",583);   
		$("#flot_wave_content30_03").css("height",200);  
		
		var data = [],
			totalPoints = 100;
 
        function getRandomData30_01() {
            var res = [];
            <c:forEach var="data" items="${data}" varStatus="status">
             res.push([${data.rsltTimeX}, ${data.rsltValueY2}]); 
            </c:forEach> 
            return res;
        }
        function getRandomData30_02() {
            var res = [];
            <c:forEach var="data" items="${data}" varStatus="status">
             res.push([${data.rsltTimeX}, ${data.rsltValueY3}]); 
            </c:forEach> 
            return res;
        }
        function getRandomData30_03() {
            var res = [];
            <c:forEach var="data" items="${data}" varStatus="status">
             res.push([${data.rsltTimeX}, ${data.rsltValueY4}]); 
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
		
		var options={
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
                    axisLabel: "Time (초)",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 10
                },
                grid: {
                    hoverable: true,
                    borderWidth: 1
            		//backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
                } 
        };

		var plot30_01 = $.plot("#waveplaceholder30_01", [ getRandomData30_01() ], options);
		var plot30_02 = $.plot("#waveplaceholder30_02", [ getRandomData30_02() ], options);
		var plot30_03 = $.plot("#waveplaceholder30_03", [ getRandomData30_03() ], options);

		function update30() {

			plot30_01.setData([getRandomData30_01()]); 
			plot30_01.draw();
			plot30_02.setData([getRandomData30_02()]); 
			plot30_02.draw();
			plot30_03.setData([getRandomData30_03()]); 
			plot30_03.draw();  
			//setTimeout(update, updateInterval);
		}

		update30();

		 
	});
 
</script>					
					<div style="float:left;width:100%;">
							<div class="content_title2"><ul><li>변위(E-W)</li></ul></div>
							<div id="flot_wave_content30_01" class="wave-event-container">
								<div id="waveplaceholder30_01" class="wave-placeholder"></div> 
							</div>   
							<div class="content_title2"><ul><li>변위(N-S)</li></ul></div>
							<div id="flot_wave_content30_02" class="wave-event-container">
								<div id="waveplaceholder30_02" class="wave-placeholder"></div> 
							</div>  
							<div class="content_title2"><ul><li>변위(V)</li></ul></div>
							<div id="flot_wave_content30_03" class="wave-event-container">
								<div id="waveplaceholder30_03" class="wave-placeholder"></div> 
							</div>
							
					</div>	
				