<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
<%
 /**
  * @Class Name :  
  * @Description : 지진발생자료 종합분석 보고서 - 그래프.
  * @Modification Information
  * 
  * @author 
  * @since 2013.12.10
  * @version 1.0
  * @see
  *  
  * Copyright (C) All right reserved.
  */
%>
<%@ page import ="egovframework.com.cmm.LoginVO" %>
			 	 
<script>
 
	$(document).ready(function() { 
        $("#flot_wave_content01_${rCnt}").css("width" ,630);   
        $("#flot_wave_content01_${rCnt}").css("height",150); 
        $("#flot_wave_content02_${rCnt}").css("width" ,630);   
        $("#flot_wave_content02_${rCnt}").css("height",150); 
        $("#flot_wave_content03_${rCnt}").css("width" ,630);   
        $("#flot_wave_content03_${rCnt}").css("height",150);   
        $("#flot_wave_content04_${rCnt}").css("width" ,630);   
        $("#flot_wave_content04_${rCnt}").css("height",250);
        $("#flot_wave_content05_${rCnt}").css("width" ,630);   
        $("#flot_wave_content05_${rCnt}").css("height",250);
        
        var data = [],
            totalPoints = 100;
 
        function getRandomData1_${rCnt}() {
            var res = [];
            <c:forEach var="data1" items="${data1}" varStatus="status">
             res.push([${data1.rsltTimeX}, ${data1.rsltValueY2}]); 
            </c:forEach>
            // data  = [{color:'#afd8f8', lable:'ddddd', data: res}];
            return res;
              
        }
        function getRandomData2_${rCnt}() {
            var res = [];
            <c:forEach var="data1" items="${data1}" varStatus="status">
             res.push([${data1.rsltTimeX}, ${data1.rsltValueY3}]); 
            </c:forEach> 
            return res;
        }
        function getRandomData3_${rCnt}() {
            var res = [];
            <c:forEach var="data1" items="${data1}" varStatus="status">
             res.push([${data1.rsltTimeX}, ${data1.rsltValueY4}]); 
            </c:forEach> 
            return res;
        }

        function getRandomData4_${rCnt}() {
            var res = [];
            <c:forEach var="data3" items="${data3}" varStatus="status">
             res.push([${data3.rsltTimeX}, ${data3.rsltValueY2}]); 
            </c:forEach> 
            return res;
        }
        function getRandomData5_${rCnt}() {
            var res = [];
            <c:forEach var="data3" items="${data3}" varStatus="status">
             res.push([${data3.rsltTimeX}, ${data3.rsltValueY3}]); 
            </c:forEach> 
            return res;
        }
        function getRandomData6_${rCnt}() {
            var res = [];
            <c:forEach var="data3" items="${data3}" varStatus="status">
             res.push([${data3.rsltTimeX}, ${data3.rsltValueY4}]); 
            </c:forEach> 
            return res;
        }
        function getRandomData7_${rCnt}() {
            var res = [];
            <c:forEach var="data3" items="${data3}" varStatus="status">
             res.push([${data3.rsltTimeX}, ${data3.rsltValueY5}]); 
            </c:forEach> 
            return res;
        }
        // Set up the control widget
        var updateInterval = 30;
        
        var options1_${rCnt}={
        	    title : 'CheongYang Magnetc Fileld',    
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
                	 axisLabel: "Time (초)",
                     axisLabelUseCanvas: true,
                     axisLabelFontSizePixels: 12,
                     axisLabelFontFamily: 'Verdana, Arial',
                     axisLabelPadding: 10
                },
                label: {
                    show: true,
                    radius: 1, 
                    formatter: function(label, series){
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'+label+'<br/>'+Math.round(series.percent)+'%</div>';
                    },
                    background: { opacity: 0.8 }
                },
                legend : {
                	show:true,
                	noColumns: 0,
                    position : 'se',            // Position the legend 'south-east'.
                    labelFormatter : 'dadfasdfasd',   // Format the labels.
                    backgroundColor : '#D2E8FF' // A light blue background color.
                  },
                grid: {
                     hoverable: true,
                     borderWidth: 1
                //   backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
                } 
        }; 
        
        var options4_${rCnt}={
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
        var options5_${rCnt}={
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

        var plot01_${rCnt} = $.plot("#waveplaceholder01_${rCnt}", [ getRandomData1_${rCnt}() ], options1_${rCnt});
        var plot02_${rCnt} = $.plot("#waveplaceholder02_${rCnt}", [ getRandomData2_${rCnt}() ], options1_${rCnt});
        var plot03_${rCnt} = $.plot("#waveplaceholder03_${rCnt}", [ getRandomData3_${rCnt}() ], options1_${rCnt});
        var plot04_${rCnt} = $.plot("#waveplaceholder04_${rCnt}", [ getRandomData4_${rCnt}(), getRandomData5_${rCnt}() ], options4_${rCnt});
		var plot05_${rCnt} = $.plot("#waveplaceholder05_${rCnt}", [ getRandomData6_${rCnt}(), getRandomData7_${rCnt}() ], options5_${rCnt});

        function update() {
            plot01_${rCnt}.setData([getRandomData1_${rCnt}()]); 
            plot01_${rCnt}.draw();
            plot02_${rCnt}.setData([getRandomData2_${rCnt}()]); 
            plot02_${rCnt}.draw();
            plot03_${rCnt}.setData([getRandomData3_${rCnt}()]); 
            plot03_${rCnt}.draw();  
            plot04_${rCnt}.setData([getRandomData4_${rCnt}(),getRandomData5_${rCnt}()]);  
			plot04_${rCnt}.draw();
			plot05_${rCnt}.setData([getRandomData6_${rCnt}(),getRandomData7_${rCnt}()]); 
			plot05_${rCnt}.draw();
        }

        //update();
        
	    $("#dataList1View").attr("style", "display:${dataList1View}");
	    $("#dataList2View").attr("style", "display:${dataList2View}");
	    $("#dataList3View").attr("style", "display:${dataList3View}");
         
    });
 
</script> 
<!--                  
<table>
<tr>
	<td colspan="2">
		<div class="content_title2"><ul><li>가속도(E-W)</li></ul></div>
        <div id="flot_wave_content01_${rCnt}" class="wave-event-container">
            <div id="waveplaceholder01_${rCnt}" class="wave-placeholder"></div> 
        </div> 
	</td>
</tr>
<tr>
	<td colspan="2">
		<div class="content_title2"><ul><li>가속도(N-S)</li></ul></div>                            
		<div id="flot_wave_content02_${rCnt}" class="wave-event-container">
			<div id="waveplaceholder02_${rCnt}" class="wave-placeholder"></div> 
		</div>   
	</td>
</tr>
<tr>
	<td colspan="2">
		<div class="content_title2"><ul><li>가속도(V)</li></ul></div>
		<div id="flot_wave_content03_${rCnt}" class="wave-event-container">
			<div id="waveplaceholder03_${rCnt}" class="wave-placeholder"></div> 
		</div>
	</td>
</tr>
<tr>
	<td>
		<div class="content_title2"><ul><li>가속도응답스펙트럼</li></ul></div>
		<div id="flot_wave_content04_${rCnt}" class="wave-event-container">
			<div id="waveplaceholder04_${rCnt}" class="wave-placeholder"></div> 
		</div>
		</div>
	</td>
	<td>
		<div class="content_title2"><ul><li>속도응답스펙트럼</li></ul></div>
		<div id="flot_wave_content05_${rCnt}" class="wave-event-container">
			<div id="waveplaceholder05_${rCnt}" class="wave-placeholder"></div> 
		</div>
	</td>
</tr>
</table>
 -->   
<div style="float:left;width:100%;">
	<div id="dataList1View">	
		<div class="content_title2"><ul><li>가속도(E-W)</li></ul></div>
		<div id="flot_wave_content01_${rCnt}" class="wave-event-container">
		    <div id="waveplaceholder01_${rCnt}" class="wave-placeholder"></div> 
		</div>   
		<div class="content_title2"><ul><li>가속도(N-S)</li></ul></div>                            
		<div id="flot_wave_content02_${rCnt}" class="wave-event-container">
		    <div id="waveplaceholder02_${rCnt}" class="wave-placeholder"></div> 
		</div>   
		<div class="content_title2"><ul><li>가속도(V)</li></ul></div>
		<div id="flot_wave_content03_${rCnt}" class="wave-event-container">
		    <div id="waveplaceholder03_${rCnt}" class="wave-placeholder"></div> 
		</div>
	</div>
	<div id="dataList2View">
		<div class="content_title2"><ul><li>가속도응답스펙트럼</li></ul></div>
		<div id="flot_wave_content04_${rCnt}" class="wave-event-container">
		    <div id="waveplaceholder04_${rCnt}" class="wave-placeholder"></div> 
		</div>
	</div>
	<div id="dataList3View">
		<div class="content_title2"><ul><li>속도응답스펙트럼</li></ul></div>
		<div id="flot_wave_content05_${rCnt}" class="wave-event-container">
		    <div id="waveplaceholder05_${rCnt}" class="wave-placeholder"></div> 
		</div> 
	</div>                           
</div>    
                               