<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>   
   
<link rel="stylesheet" href="${ctx}/css/style.css">   

    
<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script>   
<script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script>  
  
<script type="text/javascript" src="${ctx}/js/chart/real/excanvas.min.js"></script> 
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script> 

<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.axislabels.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.orderBars.js"></script> 
   

   
 <script> 
 
var data = [];
var dataset;
var totalPoints = 100;
var updateInterval = 1000;
var now = new Date().getTime();
var eventBarForm = {};
var m_FctyCd = "";
var m_GvmtCd = "";

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
            lineWidth: 0.8 
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
       // min: -1,
      //  max: 2,        
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

dataset = [
           { label: "PGA (gal)", data: data, color: "#00FF00" }
       ];



function update(waveData) {
    GetData(waveData);

    $.plot($("#waveplaceholder"), dataset, options)
   
}

function eventWvUpdate() {

	  eventBarForm = {
			flag : "PGA",
			fctyCd : m_FctyCd,
			gvmtCd : m_GvmtCd
		};
       
		$.ajax({
			url : "${ctx}/atmosphere/waveFormRev.do",
			dataType : 'json',
			type : 'POST',
			contentType : "application/json; charset=UTF-8",
			async : false,
			data : JSON.stringify(eventBarForm),
			success : function(data) {
                              // alert(data);
				var pData = JSON.parse(data);
				update(pData.pgaTotal); 

			}
		}); 
		 
	   setTimeout(eventWvUpdate, updateInterval);
}

function WaveMainForm(flag,fctyCd,gvmtCd) { 
	
	// clearTimeout(eventWvUpdate);
	 m_FctyCd = fctyCd;
	 m_GvmtCd = gvmtCd;
	 eventWvUpdate();
	 
 }    


$(document).ready(function () {
   GetData(0);

   $("#flot_wave_content").css("width",440);   
   $("#flot_wave_content").css("height",150);  
  
   $.plot($("#waveplaceholder"), dataset, options); 
   
 //지도 계측소 클릭시 호출되는 함수.
   function mapClickEvent(wvName,wvFctyCd,wvGvmtCd) { 
  	  
  	    if (wvName == "") {
  	    	$("#waveTitle").text("과기대 - 자유장 실시간 PGA계측값이력");
  	    	 fctyExec('PGA','SL','AC'); 
  	    	 
  	    	 WaveMainForm('PGA','SL','AC') ;
  		 
  	    } else {
  	    	$("#waveTitle").text(wvName + " - 자유장 실시간 PGA계측값이력"); 
  			fctyExec('PGA',wvFctyCd,wvGvmtCd);   
  			WaveMainForm('PGA',wvFctyCd,wvGvmtCd) ;
  	    }  
  		
   } 
   
   mapClickEvent('','','');
 
});


</script>
   
<div id="flot_wave_content" class="wave-container">
	<div id="waveplaceholder" class="wave-placeholder"></div> 
</div>   
 