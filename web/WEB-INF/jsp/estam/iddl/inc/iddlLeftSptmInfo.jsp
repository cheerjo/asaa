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

             <div style="float:left;width:100%;">
                    <div style="float:left;width:68%;margin:0 20px 0 0;">
                        <div class="content_title2"><ul><li>계측 최대값</li></ul></div>  
                        <table class="auth_group display2">
                            <caption></caption>
                            <thead>
                                <tr>
                                    <th colspan="4">자유장</th>    
                                    <th colspan="4">시설물중간층</th>
                                </tr>
                            </thead>                
                            <tbody>
                                <tr>
                                    <td class="num3">계측방향</td>
                                    <td class="line_bg">가속도(gal)</td>
                                    <td class="line_bg">속도(mm/sec)</td>
                                    <td class="line_bg">변위(mm)</td>
                                    <td class="num3">계측방향</td>
                                    <td class="line_bg">가속도(gal)</td>
                                    <td class="line_bg">속도(mm/sec)</td>
                                    <td class="line_bg">변위(mm)</td>
                                </tr>
                                <tr>
                                    <td class="num3">동서(E-W)</td>
                                    <!--<td>${readIddlAssRlst.dataFreeAccX}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataFreeAccX}&nbsp;</td>
                                    <td>${readIddlAssRlst.dataFreeAccSpedX}&nbsp;</td>
                                    <!--<td>${readIddlAssRlst.dataFreeMaxDispX}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataFreeAccDispX}&nbsp;</td>
                                    <td class="num3">동서(E-W)</td>
                                    <!--<td>${readIddlAssRlst.dataStrMidAccX}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataStrMidAccX}&nbsp;</td>
                                    <td>${readIddlAssRlst.dataStrMidSpedX}&nbsp;</td>
                                    <td>${readIddlAssRlst.dataStrMidDispX}&nbsp;</td>
                                </tr>
                                <tr>
                                    <td class="num3">남북(N-S)</td>
                                    <!--<td>${readIddlAssRlst.dataFreeAccY}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataFreeAccY}&nbsp;</td>
                                    <td>${readIddlAssRlst.dataFreeAccSpedY}&nbsp;</td>
                                    <!--<td>${readIddlAssRlst.dataFreeMaxDispY}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataFreeAccDispY}&nbsp;</td>
                                    <td class="num3">남북(N-S)</td>
                                    <!--<td>${readIddlAssRlst.dataStrMidAccY1}&nbsp;</td>-->
                                    <td><c:choose><c:when test="${readIddlAssRlst.dataStrMidAccY1 >= readIddlAssRlst.dataStrMidAccY1}">${readIddlAssRlst.dataStrMidAccY1}</c:when><c:otherwise>${readIddlAssRlst.dataStrMidAccY2}</c:otherwise></c:choose>&nbsp;</td>
                                    <td>${readIddlAssRlst.dataStrMidSpedY}&nbsp;</td>
                                    <td>${readIddlAssRlst.dataStrMidDispY}&nbsp;</td>
                                </tr>
                                <tr>
                                    <td class="num3" style="width:80px">수평성분합성(H)</td>
                                    <td>${readIddlAssRlst.dataFreeAccHorz}&nbsp;</td>
                                    <td>${readIddlAssRlst.dataFreeAccSpedHorz}&nbsp;</td>
                                    <td>${readIddlAssRlst.dataFreeAccDispHorz}&nbsp;</td>
                                    <td colspan="4"></td>
                                </tr>
                                <tr>
                                    <td class="num3">연직(V)</td>
                                    <!--<td>${readIddlAssRlst.dataFreeAccZ}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataFreeAccZ}&nbsp;</td>
                                    <td>${readIddlAssRlst.dataFreeAccSpedZ}&nbsp;</td>
                                    <td>${readIddlAssRlst.dataFreeAccDispZ}&nbsp;</td>
                                    <td colspan="4"></td>
                                </tr>
                            </tbody>
                        </table> 
                        <br >
                        <table class="auth_group display2">
                            <caption></caption>
                            <thead>
                                <tr>
                                    <th colspan="4">시설물최상층</th> 
                                    <th colspan="4">시설물최하층</th>
                                </tr>
                            </thead>                
                            <tbody>
                                <tr>
                                    <td class="num3">계측방향</td>
                                    <td class="line_bg">가속도(gal)</td>
                                    <td class="line_bg">속도(mm/sec)</td>
                                    <td class="line_bg">변위(mm)</td>
                                    <td class="num3">계측방향</td>
                                    <td class="line_bg">가속도(gal)</td>
                                    <td class="line_bg">속도(mm/sec)</td>
                                    <td class="line_bg">변위(mm)</td>
                                </tr>
                                <tr>
                                    <td class="num3">동서(E-W)</td>
                                    <!--<td>${readIddlAssRlst.dataStrTopAccX}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataStrTopAccX}&nbsp;</td>
                                    <!--<td>${readIddlAssRlst.dataTopRelMaxSpedX}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataStrTopSpedX}&nbsp;</td>
                                    <!--<td>${readIddlAssRlst.dataTopRelMaxDispX}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataStrTopDispX}&nbsp;</td>
                                    <td class="num3">동서(E-W)</td>
                                    <!--<td>${readIddlAssRlst.dataStrBotAccX}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataStrBotAccX}&nbsp;</td>
                                    <td>${readIddlAssRlst.dataStrBotSpedX}&nbsp;</td>
                                    <td>${readIddlAssRlst.dataStrBotDispX}&nbsp;</td>
                                </tr>
                                <tr>
                                    <td class="num3">남북(N-S)</td>
                                    <!--<td>${readIddlAssRlst.dataStrTopAccY1}&nbsp;</td>-->
                                    <td><c:choose><c:when test="${readIddlAssRlst.dataStrTopAccY1 >= readIddlAssRlst.dataStrTopAccY2}">${readIddlAssRlst.dataStrTopAccY1}</c:when><c:otherwise>${readIddlAssRlst.dataStrTopAccY2}</c:otherwise></c:choose>&nbsp;</td>
                                    <!--<td>${readIddlAssRlst.dataTopRelMaxSpedY}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataStrTopSpedY}&nbsp;</td>
                                    <!--<td>${readIddlAssRlst.dataTopRelMaxDispY}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataStrTopDispY}&nbsp;</td>
                                    <td class="num3">남북(N-S)</td>
                                    <!--<td>${readIddlAssRlst.dataStrBotAccY}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataStrBotAccY}&nbsp;</td>
                                    <td>${readIddlAssRlst.dataStrBotSpedY}&nbsp;</td>
                                    <td>${readIddlAssRlst.dataStrBotDispY}&nbsp;</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div style="float:left;width:30%;">
                        <div class="content_title2"><ul><li>설계지반가속도 초과율</li></ul></div> 
                        <table class="auth_group display2" style="height:132px;">
                            <caption></caption>                 
                            <tbody>
                                <tr>
                                    <td class="line_bg"> 설계지반가속도(gal)</td>
                                    <td class="line_bg"> 최대지반가속도(gal)</td>
                                    <td class="line_bg"> 초과율(%)</td>
                                </tr>
                                <tr>
                                    <td>${readIddlAssRlst.rsltOvrAccVal}&nbsp;</td>
                                    <!--<td>${readIddlAssRlst.dataFreeAccX}&nbsp;</td>-->
                                    <td><c:choose><c:when test="${readIddlAssRlst.dataFreeAccX >= readIddlAssRlst.dataFreeAccY}">${readIddlAssRlst.dataFreeAccX}</c:when><c:otherwise>${readIddlAssRlst.dataFreeAccY}</c:otherwise></c:choose>&nbsp;</td>
                                    <!--<td>${readIddlAssRlst.rsltOvrAccX}&nbsp;</td>-->
                                    <td><c:choose><c:when test="${readIddlAssRlst.rsltOvrAccX >= readIddlAssRlst.rsltOvrAccY}">${readIddlAssRlst.rsltOvrAccX}</c:when><c:otherwise>${readIddlAssRlst.rsltOvrAccY}</c:otherwise></c:choose>&nbsp;</td>
                                </tr>
                            </tbody>
                        </table>
                        <br>
                        <div class="content_title2"><ul><li>고유진동수(Hz)</li></ul></div>
                        <table class="auth_group display2" style="height:112px;">
                            <caption></caption>                 
                            <tbody>
                                <tr>
                                    <td class="line_bg"> 자유장</td>
                                    <td class="line_bg"> 시설물(E-W)</td>
                                    <td class="line_bg"> 시설물(N-S)</td>
                                </tr>
                                <tr>
                                    <!--<td>${readIddlAssRlst.dataFreeFrq}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataFreeFrq}&nbsp;</td>
                                    <!--<td>${readIddlAssRlst.dataStrFrqX}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataStrFrqX}&nbsp;</td>
                                    <!--<td>${readIddlAssRlst.dataStrFrqY}&nbsp;</td>-->
                                    <td>${readIddlAssRlst.dataStrFrqY}&nbsp;</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <br class="clear"/>
                </div>
                    <br class="clear"/>
                    <br/>
 <script>
 
 $(document).ready(function() { 
	 
	 	$("#flot_wave_content01").css("width",600);   
		$("#flot_wave_content01").css("height",150); 
		
	    $("#flot_wave_content02").css("width",600);   
		$("#flot_wave_content02").css("height",150); 
		
		$("#flot_wave_content03").css("width",600);   
		$("#flot_wave_content03").css("height",150);
		
		$("#flot_wave_content04").css("width",600);   
		$("#flot_wave_content04").css("height",450); 
		  
		// We use an inline data source in the example, usually data would
		// be fetched from a server 
		 var form = {
			GVMT: "SL"  
	     };
		
		var data = [],
			totalPoints = 100;
 
        function getRandomData() {
            var res = [];
            <c:forEach var="data2" items="${data2}" varStatus="status">
             res.push([${data2.rsltTimeX}, ${data2.rsltValueY2}]); 
            </c:forEach> 
            data  = {label:'E-W', data: res, color:'#afd8f8'};
            return data;
        }
        function getRandomData3() {
            var res = [];
            <c:forEach var="data2" items="${data2}" varStatus="status">
             res.push([${data2.rsltTimeX}, ${data2.rsltValueY3}]); 
            </c:forEach> 
            data  = {label:'N-S', data: res};
            return data;
        }
        function getRandomData4() {
            var res = [];
            <c:forEach var="data2" items="${data2}" varStatus="status">
             res.push([${data2.rsltTimeX}, ${data2.rsltValueY4}]); 
            </c:forEach> 
            data  = {label:'E-W', data: res, color:'#afd8f8'};
            return data;
        }
        function getRandomData5() {
            var res = [];
            <c:forEach var="data2" items="${data2}" varStatus="status">
             res.push([${data2.rsltTimeX}, ${data2.rsltValueY5}]); 
            </c:forEach> 
            data  = {label:'N-S', data: res};
            return data;
        }
        function getRandomData6() {
            var res = [];
            <c:forEach var="data2" items="${data2}" varStatus="status">
             res.push([${data2.rsltTimeX}, ${data2.rsltValueY6}]); 
            </c:forEach> 
            data  = {label:'E-W', data: res, color:'#afd8f8'};
            return data;
        }
        function getRandomData7() {
            var res = [];
            <c:forEach var="data2" items="${data2}" varStatus="status">
             res.push([${data2.rsltTimeX}, ${data2.rsltValueY7}]); 
            </c:forEach> 
            data  = {label:'N-S', data: res};
            return data;
        }
        function getRandomData22() {
            var res = [];
            <c:forEach var="data" items="${data}" varStatus="status">
             res.push([${data.rsltTimeX}, ${data.rsltValueY2}]); 
            </c:forEach> 
            data  = {data: res, color:'#afd8f8'};
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
                legend: {
                    noColumns: 0,
                   // labelBoxBorderColor: "#afd8f8",
                    position: "ne"
                }, 
                grid: {
                    hoverable: true,
                    borderWidth: 1
                //   backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
                } 
        };
        var options2={
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
                legend: {
                    noColumns: 0,
                   // labelBoxBorderColor: "#afd8f8",
                    position: "ne"
                }, 
                grid: {
                    hoverable: true,
                    borderWidth: 1
                //   backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
                } 
        };		

        var options3={
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
                legend: {
                    noColumns: 0,
                   // labelBoxBorderColor: "#afd8f8",
                    position: "ne"
                }, 
                grid: {
                    hoverable: true,
                    borderWidth: 1
                //   backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
                } 
        };
        var options4={
                series: {
                    shadowSize: 0   // Drawing is faster without shadows
                },
                yaxis: { 
                      axisLabel: "H/V ratio",
                      axisLabelUseCanvas: true,
                      axisLabelFontSizePixels: 12,
                      axisLabelFontFamily: 'Verdana, Arial',
                      axisLabelPadding: 6
                },
                xaxis: {
                	 min: 0,
                     max: 50,
                     show: true,
                     axisLabel: "진동수 (Hz)",
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
                //   backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
               } 
        };        
		var plot01 = $.plot("#waveplaceholder01", [ getRandomData(), getRandomData3() ], options);
		var plot02 = $.plot("#waveplaceholder02", [ getRandomData4(), getRandomData5() ], options2);
		var plot03 = $.plot("#waveplaceholder03", [ getRandomData6(), getRandomData7() ], options3);
		var plot04 = $.plot("#waveplaceholder04", [ getRandomData22() ], options4);

		function update() { 

			plot01.setData([getRandomData(),getRandomData3() ]);  
			plot01.draw();
			plot02.setData([getRandomData4(), getRandomData5()]); 
			plot02.draw();
			plot03.setData([getRandomData6(), getRandomData7()]); 
			plot03.draw();
			plot04.setData([getRandomData22()]); 
			plot04.draw();
			//setTimeout(update, updateInterval);
		}

		update();

		 
	});
 
</script>					
					<div style="float:left;width:100%;">
						<div style="float:left;width:49%;margin:0 20px 0 0;">
							<div style="width:100%;height:280px;background-color: #fff;">
								<div>
								        <div class="content_title2"><ul><li>가속도 응답스펙트럼</li></ul></div>
										<div id="flot_wave_content01" class="wave-event-container">
											<div id="waveplaceholder01" class="wave-placeholder"></div> 
										</div>   
										<div class="content_title2"><ul><li>속도응답스텍트럼</li></ul></div>
										<div id="flot_wave_content02" class="wave-event-container">
											<div id="waveplaceholder02" class="wave-placeholder"></div> 
										</div> 
										<div class="content_title2"><ul><li>변위응답스펙트럼</li></ul></div>  
										<div id="flot_wave_content03" class="wave-event-container">
											<div id="waveplaceholder03" class="wave-placeholder"></div> 
										</div>   
								</div>
							</div>
						</div>
						<div style="float:left;width:49%;">
							<div style="width:100%;height:280px;background-color: #fff;">
								<div>
									<div id="flot_wave_content04" class="wave-event-container">
										<div id="waveplaceholder04" class="wave-placeholder"></div> 
									</div> 
								</div>	
							</div>
						</div>
					</div>
						