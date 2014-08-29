<%@ include file="/inc/taglibs.jsp"%> 
<!DOCTYPE HTML>

<html>

<head>
<link href="${ctx}/js/chart/flot/examples.css" rel="stylesheet" type="text/css">  	
<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="${ctx}/js/chart/real/excanvas.min.js"></script><![endif]-->
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.axislabels.js"></script>
 
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
            lineWidth: 1.2,
            fill: true
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
        },
        axisLabel: "Time",
        axisLabelUseCanvas: true,
        axisLabelFontSizePixels: 12,
        axisLabelFontFamily: 'Verdana, Arial',
        axisLabelPadding: 10
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
        axisLabel: "PGA loading",
        axisLabelUseCanvas: true,
        axisLabelFontSizePixels: 12,
        axisLabelFontFamily: 'Verdana, Arial',
        axisLabelPadding: 6
    },
    legend: {        
        labelBoxBorderColor: "#fff"
    },
    grid: {                
        backgroundColor: "#000000",
        tickColor: "#008040"
    }
};

$(document).ready(function () {
    GetData(0);

   $("#flot_content").css("width",440);   
   $("#flot_content").css("height",150); 

    dataset = [
        { label: "PGA(gal)", data: data, color: "#00FF00" }
    ];

    $.plot($("#waveplaceholder"), dataset, options);

    function update(waveData) {
        GetData(waveData);

        $.plot($("#waveplaceholder"), dataset, options)
//        setTimeout(update, updateInterval);
    }

//    update();

    	 $.atmosphere.subscribe(
    		        "/waveFormRev.do",
    		        callback,
    		        $.atmosphere.request = { transport:"websocket" ,  method:"POST" });
    		
    		//Function to be invoked when there is a response from the server
    		function callback(response) {
    		    //$.atmosphere.log("info", ["response.state: " + response.state]);
    		    //$.atmosphere.log("info", ["response.transport: " + response.transport]);
    		    //$.atmosphere.log("info", ["response.status: " + response.status]);
    		  
    		    
    		    //$("#transport").text("Transport used: " + response.transport);
    		    
    		    if(response.state=='messageReceived'){
    		    	if(response.status == 200){
    		    		var wavedata = response.responseBody;
    		    		if(wavedata){   
    		    			
    		    			 update(wavedata);
    		    		 
    		    		 $("#time").text(wavedata);
    		    		 $("#flot-placeholder1").text(data);
    		    	   }
    		    	}	
    		    } else {
    		    	//alert(response.state);
    		    }    
    		}   
	
});
  
 
</script>



 
	</head>
	
	<body>
		<h1>Spring MVC and Atmosphere</h1>
		<h2>The Time pushed from the Server is:</h2>
		
		<p id="transport"></p>
		<p id="time"></p>
		
		<div id="flot_content" class="demo-container">
			<div id="waveplaceholder" class="demo-placeholder"></div> 
		</div>  
     
<!-- HTML -->
<div id="flot-placeholder1" style="width:550px;height:300px;margin:0 auto"></div>
     
     
	</body>

</html>

 