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
 
var data = [];
var dataset;
var totalPoints = 100;
var updateInterval = 1000;
var now = new Date().getTime();


function GetData(waveData) {
    data.shift(); 
   
    while (data.length < totalPoints) {  
    
		var y  = waveData;
	    //var y = Math.random() * 100;
	    var temp = [now += updateInterval, y];
	    data.push(temp);
    
    }   
} 

var options = {
    series: {
        lines: {
            show: true,
            lineWidth: 1.2
           // fill: true
        }
    },
    xaxis: {
        mode: "time",
        tickSize: [2, "second"],
        tickFormatter: function (v, axis) {
            var date = new Date(v);

            if (date.getSeconds() % 20 == 0) {
                var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
                var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
                var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

                return hours + ":" + minutes + ":" + seconds;
            } else {
                return "";
            }
        } ,
        axisLabel: "Time(시:분:초)",
        axisLabelUseCanvas: true,
        axisLabelFontSizePixels: 12,
        axisLabelFontFamily: 'Verdana, Arial',
        axisLabelPadding: 6
    },
    yaxis: {
        min: -1,
        max: 2,        
        //tickSize: 5,
        //tickFormatter: function (v, axis) {
            //if (v % 10 == 0) {
            //    return v + "%";
            //} else {
           //     return v;
           // }
        //},
        axisLabel: "PGA (gal)",
        axisLabelUseCanvas: true,
        axisLabelFontSizePixels: 12,
        axisLabelFontFamily: 'Verdana, Arial',
        axisLabelPadding: 6
    },
    legend: {        
        labelBoxBorderColor: "#fff"
    },
    grid: {                
      //  backgroundColor: "#000000",
      //  tickColor: "#008040"
    }
};


$(document).ready(function () {
    GetData(0);

   $("#flot_wave_content").css("width",440);   
   $("#flot_wave_content").css("height",150); 

    dataset = [
        { label: "PGA (gal)", data: data, color: "#00FF00" }
    ];

    $.plot($("#waveplaceholder"), dataset, options);

    function update(waveData) {
        GetData(waveData);

        $.plot($("#waveplaceholder"), dataset, options)
        //setTimeout(update, 10);
    }

    
 /*    function WaveMainForm(flag,fctyCd,gvmtCd) {  
    	
    	  var fctyForm = {
   				  fctyFlag:flag,
   				  fctyCd:fctyCd,
   				  gvmtCd:gvmtCd };   
    	
    	  $.ajax({
	  	      url: "${ctx}/wave/waveFormRev.do",
	  	   	  dataType: 'json',
	          type : 'POST',
	          contentType: "application/json; charset=UTF-8",
	          async: false, 
	  	      data:  JSON.stringify(fctyForm) ,
	  	      success: function(data) { 
	  	     
	  	    	var pData = JSON.parse(data); 
	  	    	 $("#time").text(pData);
	  	    	// update(wavedata);
	  	      } 
	  	  });  
    	  
    	//  setTimeout(WaveMainForm(flag,fctyCd,gvmtCd), 5000);
  	
    }   
   
    WaveMainForm("PGA","SL","SL");  */ 

    $.atmosphere.subscribe(
		        "/atmosphere/waveFormRev.do?flag=PGA&fctyCd=SL&gvmtCd=SL" ,
		        callback, 
		        $.atmosphere.request = { transport:"websocket" , contentType : "application/json; charset=UTF-8",
		                                 dataType: 'json',type : 'GET'});  
		
		//Function to be invoked when there is a response from the server
		function callback(response) {
		    $.atmosphere.log("info", ["response.state: " + response.state]);
		   $.atmosphere.log("info", ["response.transport: " + response.transport]);
		    $.atmosphere.log("info", ["response.status: " + response.status]); 
		    
		    $("#transport").text("Transport used: " + response.transport);
		    
		    if(response.state=='messageReceived'){
		    	if(response.status == 200){
		    		var wavedata = response.responseBody;
		    		if(wavedata){   
		    			 
		    			// var arrWaveData =  wavedata.split(":")
		    			// if (arrWaveData[0] == TRUE) {  
		    				 update(wavedata);
		    			// }
		    		// $("#time").text(wavedata);
		    		// $("#flot-placeholder1").text(data);
		    	   }
		    	}	
		    } else {
		    	alert(response.state);
		    }    
		}      
		
		

  
});


 
</script>
</head>

<body> 
  	  
  	  <div id="time" ></div> 
  	  <p id="transport"></p>
	<div id="flot_wave_content" class="wave-container">
		<div id="waveplaceholder" class="wave-placeholder"></div> 
	</div>   
 
</body>
</html>
