<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  

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
 <script src="${ctx}/js/estam_common.js"></script> 
 
 
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="${ctx}/js/chart/real/excanvas.min.js"></script><![endif]-->
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script> 

<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.axislabels.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.orderBars.js"></script> 
  
 
<script type="text/javascript" src="${ctx}/js/jquery/jquery.atmosphere.js"></script> 
   
 <script> 

	var barData01 = [    
	    [0, 10], 
	    [1, 6], 
	    [2, 2], 
	    [3, 4], 
	    [4, 2], 
	    [5, 5],  
	    [6, 3],
	    [7, 3],
	    [8, 3] 
	    
	];
	var barData02 = [  
                       [0, 3],
	               [1, 5],  
	               [2, 1],  
	               [3, 2],  
	               [4, 2], 
	               [5, 2], 
	               [6, 2],  
	               [7, 2], 
	               [8, 2]  
	];

	var barDataset01 = [
		          	    { label: "10분간 PGA", data: barData01, color: "#ffc000" },
		          	    { label: "실시간 3초간 PGA", data: barData02, color: "#8eb4e3" }
		          	];
	
	var barData03 = [    
	         	    [0, 10], 
	         	    [1, 6], 
	         	    [2, 2], 
	         	    [3, 4], 
	         	    [4, 2], 
	         	    [5, 5],  
	         	    [6, 3],
	         	    [7, 3],
	         	    [8, 3] 
	         	    
	         	];
   var barData04 = [  
                       [0, 3],
       	               [1, 5],  
       	               [2, 1],  
       	               [3, 2],  
       	               [4, 2], 
       	               [5, 2], 
       	               [6, 2],  
       	               [7, 2], 
       	               [8, 2]  
       	];

   var barDataset02 = [
       		          	    { label: "10분간 PGA", data: barData03, color: "#ffc000" },
       		          	    { label: "실시간 1초간 PGA", data: barData04, color: "#8eb4e3" }
       		          	];
	
	var barTicks01 = [
	    [0, "전국"], [1, "서울특별시<br>(서울시청)"], [2, "인천광역시<br>(인천시청)"], [3, "대구광역시<br>(대구시청)"],
	    [4, "대전광역시<br>(대전시청)"], [5, "부산광역시<br>(부산시청)"], [6, "울산광역시<br>(울산시청)"], [7, "광주광광역시<br>(광주시청)"], [8, "세종시<br>(세종시청)"]
	]; 

	var barTicks02 = [
	               [0, "경기도<br>(경기도청)"],[1, "강원도<br>(강원도청)"], [2, "경상남도<br>(경남도청)"], [3, "경상북도<br>(경북도청)"], [4, "전라남도<br>(전남도청)"],
	                [5, "전라남도<br>(전남도청)"], [6, "충청남도<br>(충남도청)"], [7, "충청북도<br>(충북도청)"], [8, "제주특별자치도<br>(제주도청)"] 
	            ]; 


	var barOptions01 = {
		 series: {
		        bars: {
		            show: true,
		            order: 1
		        }
		    } ,
		    //valueLabels: {
		    //    show: true
		    //},
		    bars: {
		        align: "left",
		        barWidth: 0.3
		    }, 
	    xaxis: {
	       // axisLabel: "World Cities",
	        axisLabelUseCanvas: true,
	        axisLabelFontSizePixels: 12,
	        axisLabelFontFamily: 'Verdana, Arial',
	        axisLabelPadding: 10,
	        ticks: barTicks01
	        
	    },
	    yaxis: {
	        axisLabel: "PGA (gal)",
	        axisLabelUseCanvas: true,
	        axisLabelFontSizePixels: 12,
	        axisLabelFontFamily: 'Verdana, Arial',
	        axisLabelPadding: 1,
	        tickFormatter: function (v, axis) {
	            return v ;
	        }
	    },
	    legend: {
	        noColumns: 0,
	     //   labelBoxBorderColor: "#000000",
	        position: "ne"
	    },
	    grid: {
	        hoverable: true,
	        borderWidth: 0   
	       // backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
	    }
	}; 

	var barOptions02 = {
		 series: {
		        bars: {
		            show: true,
		            order: 1
		        }
		    } ,
		    //valueLabels: {
		    //    show: true
		    //},
		    bars: {
		        align: "left",
		        barWidth: 0.25
		    }, 
	    xaxis: {
	       // axisLabel: "World Cities",
	        axisLabelUseCanvas: true,
	        axisLabelFontSizePixels: 12,
	        axisLabelFontFamily: 'Verdana, Arial',
	        axisLabelPadding: 10,
	        ticks: barTicks02
	        
	    },
	    yaxis: {
	        axisLabel: "PGA(gal)",
	        axisLabelUseCanvas: true,
	        axisLabelFontSizePixels: 12,
	        axisLabelFontFamily: 'Verdana, Arial',
	        axisLabelPadding: 3,
	        tickFormatter: function (v, axis) {
	            return v ;
	        }
	    },
	    legend: {
	        noColumns: 0,
	      //  labelBoxBorderColor: "#000000",
	        position: "ne"
	    },
	    grid: {
	        hoverable: true,
	        borderWidth: 0 //,        
	       // backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
	    }
	};

$(document).ready(function () {
	
	
	$("#bar_content01").css("width",690);   
	$("#bar_content01").css("height",205);  
	
	$("#bar_content02").css("width",690);   
	$("#bar_content02").css("height",205); 
	
 function barUpdate(wavedata) { 
		
	/*   var barRevData = wavedata.barRevData;
	  var iCnt =  0;
	  
	  for (var idx = 0;idx < Object.keys(barRevData).length;idx++) {
		  
		  if (barRevData[idx].fctyNo < 9) {  
			  
			  barData01[iCnt] = "[" + barRevData[idx].fctyNo + "," + barRevData[idx].fctyPga10 + "]";
			  barTicks01[iCnt] =  "[" + barRevData[idx].fctyNo + "," + barRevData[idx].fctyPga + "]";
			  iCnt = iCnt + 1; 
		  } 
		
	  } */ 
 
}  
 

$.plot($("#barplaceholder01"), barDataset01, barOptions01);    
//  $("#barplaceholder01").UseTooltip();

$.plot($("#barplaceholder02"), barDataset02, barOptions02);   
 //  $("#barplaceholder02").UseTooltip();
 
 	$.atmosphere.subscribe(
 		    	"/atmosphere/waveFormRev.do?flag=PGA&fctyCd=SL&gvmtCd=SL",
		        barCallback,
   		        $.atmosphere.request = { transport:"websocket" , contentType : "application/json",
                        dataType: 'json',type : 'GET'});   // ,fallbackTransport: "long-polling"
		
		//Function to be invoked when there is a response from the server
		function barCallback(response) {
		    $.atmosphere.log("info", ["response.state: " + response.state]);
		    $.atmosphere.log("info", ["response.transport: " + response.transport]);
		    $.atmosphere.log("info", ["response.status: " + response.status]); 
		    
		    $("#transport").text("Transport used: " + response.transport);
		    
		    if(response.state=='messageReceived'){
		    	if(response.status == 200){
		    		var wavedata = response.responseBody;
		    		if(wavedata){    
		    			//barUpdate(wavedata);
		    			 $("#time").text(wavedata);
		    	   }
		    	}	
		    } else {
		    	alert(response.state);
		    }    
		}    
		
});
 

function gd(year, month, day) {
    return new Date(year, month, day).getTime();
}

var previousPoint = null, previousLabel = null;

$.fn.UseTooltip = function () {
    $(this).bind("plothover", function (event, pos, item) {
        if (item) {
            if ((previousLabel != item.series.label) || (previousPoint != item.dataIndex)) {
                previousPoint = item.dataIndex;
                previousLabel = item.series.label;
                $("#tooltip").remove();

                var x = item.datapoint[0];
                var y = item.datapoint[1];

                var color = item.series.color;

                //console.log(item.series.xaxis.ticks[x].label);                
                
                showTooltip(item.pageX,
                        item.pageY,
                        color,
                        "<strong>" + item.series.label + "</strong><br>" + item.series.xaxis.ticks[x].label + " : <strong>" + y + "</strong>");                
            }
        } else {
            $("#tooltip").remove();
            previousPoint = null;
        }
    });
};

function showTooltip(x, y, color, contents) {
    $('<div id="tooltip">' + contents + '</div>').css({
        position: 'absolute',
        display: 'none',
        top: y - 40,
        left: x - 120,
        border: '2px solid ' + color,
        padding: '3px',
        'font-size': '9px',
        'border-radius': '5px',
        'background-color': '#fff',
        'font-family': 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
        opacity: 0.9
    }).appendTo("body").fadeIn(200);
} 

</script> 
	

</head>

<body> 
  	    
  	 <div id="bar_content01" class="bar-container">
		<div id="barplaceholder01" class="bar-placeholder"></div>
	</div>  
	<div id="bar_content02" class="bar-container">
		<div id="barplaceholder02" class="bar-placeholder"></div>
	</div> 
 
 
</body>
</html>
