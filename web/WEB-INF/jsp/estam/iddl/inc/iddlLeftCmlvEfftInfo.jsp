<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
<%
 /**
  * @Class Name :  
  * @Description : 시설물 상세정보 - 계측자료 누적기록  
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
<link rel="stylesheet" href="${ctx}/css/style.css">   

 <script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script> 
 <script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script> 
 <script src="${ctx}/js/estam_common.js"></script>  
 <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="${ctx}/js/chart/real/excanvas.min.js"></script><![endif]-->
  
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.stack.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script> 

				<div class="syright_tab_total">
					<div class="syright_tab">
						<ul>
							<li class="on"><a href="#" title="최근 5년">최근 5년</a></li><!-- 선택시 -->
							<li ><a href="#" title="최근 1년">최근 1년</a></li>	
							<li><a href="#" title="최근 6개월">최근 6개월</a></li>
							<li><a href="#" title="최근 1개월">최근 1개월</a></li>
						</ul>
					</div>
				</div>
 <script>
 
 $(document).ready(function() { 
	 
		$("#flot_wave_content01").css("width",1100);   
		$("#flot_wave_content01").css("height",200); 
		
 	    $("#flot_wave_content02").css("width",1100);   
		$("#flot_wave_content02").css("height",200); 
		
		$("#flot_wave_content03").css("width",1100);   
		$("#flot_wave_content03").css("height",200);  
		  
		// We use an inline data source in the example, usually data would
		// be fetched from a server 
		 var form = {
			GVMT: "SL" 
	     };
		
		var data = [],
			totalPoints = 100;
 
		function getRandomData() {

			if (data.length > 0)
				data = data.slice(1);

			// Do a random walk

			 while (data.length < totalPoints) {

				//var prev = data.length > 0 ? data[data.length - 1] : 50,
					y = Math.random(); // prev + Math.random() * 10 - 5;

				//if (y < 0) {
				//	y = 0;
				//} else if (y > 1) {
				//	y = 2;
				//}

				data.push(y);
			}  
			
			// Zip the generated y values with the x values

			var res = [];
			for (var i = 0; i < data.length; ++i) {
				res.push([i, data[i]]);
			}

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
					shadowSize: 0	// Drawing is faster without shadows
				},
				yaxis: {
					//min: -0.5,
					//max: 1
				},
				xaxis: {
					show: true
				},
			        grid: {
		                    hoverable: true,
		                    borderWidth: 1
		            //   backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
		                } 
		};

		var plot01 = $.plot("#waveplaceholder01", [ getRandomData() ], options);
		var plot02 = $.plot("#waveplaceholder02", [ getRandomData() ], options);
		var plot03 = $.plot("#waveplaceholder03", [ getRandomData() ], options);

		function update() {

			plot01.setData([getRandomData()]); 
			plot01.draw();
			plot02.setData([getRandomData()]); 
			plot02.draw();
			plot03.setData([getRandomData()]); 
			plot03.draw();  
			//setTimeout(update, updateInterval);
		}

		update();

		 
	});
 
</script>					
				<div style="background-color: #fff;width:100%;height:885px;">	
					<div>
							<div id="flot_wave_content01" class="wave-event-container">
								<div id="waveplaceholder01" class="wave-placeholder"></div> 
							</div>   
							<div id="flot_wave_content02" class="wave-event-container">
								<div id="waveplaceholder02" class="wave-placeholder"></div> 
							</div>   
							<div id="flot_wave_content03" class="wave-event-container">
								<div id="waveplaceholder03" class="wave-placeholder"></div> 
							</div>   
					</div>
				</div>