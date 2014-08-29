<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  

  
<link rel="stylesheet" href="${ctx}/css/style.css">   
  
  
<style>
 #tooltip {
	position: absolute;
	z-index: 3000;
	border: 1px solid #111;
	background-color: #eee;
	padding: 5px;
	opacity: 0.85;
}
#tooltip h3, #tooltip div { margin: 0; }

#tooltip.tipEstamEvnt {
	font-family: Arial;
	border: none;
	width: 180px;
	padding:10px;
	height: 30px;
	opacity: 0.8; 
	background: white;
}
#tooltip.tipEstamEvnt h3 {
	margin-bottom: 0.75em;
	font-size: 12pt;
	width: 180px;
	text-align: center;
}
#tooltip.tipEstamEvnt div { width: 180px; text-align: left; }
  
    </style>   
<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script>  
 <script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script> 
<script src="${ctx}/js/jquery/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${ctx}/js/jquery/jquery.dimensions.js" type="text/javascript"></script>   
 <script type="text/javascript" src="${ctx}/js/jquery/jquery-syaku.rolling.js"></script> 
 <script type="text/javascript" src="${ctx}/js/jquery/jquery.tooltip.min.js"></script>   
 
 
<script type="text/javascript">
var evntdata = [ ]; 
 
 
     function fnEvntSroll(auto)  {
    
    	  jQuery("#estamEventInfo").srolling({
    	      data : evntdata, // 노출될 아이템
    	      auto : auto, //자동 롤링
    	      width : 350, // 노출될 아이템 크기
    	      height : 105, // 노출될 아이템 크기
    	      item_count : 1, // 이동 될 아이템 수
    	      cache_count : 10, // 노출 아이템 수
    	      delay : 10000, // 이동 아이템 딜레이
    	      move : 'top' ,// 이동 방향
	      prev : '', // 이동 버튼
              next : '' // 이동 버튼
    	    });
	    
     }
     
   function eventExec() {
	   
	    var eventForm = { flag:"PGA" }; 
	   
	  	$.ajax({
	  	      url: "${ctx}/main/EventInfoJson.do",
	  	      dataType: 'json',
	          type : 'POST',
	          contentType: "application/json; charset=UTF-8",
	          async: false,  
	  	      data: JSON.stringify(eventForm),
	  	      success: function(data) { 
	  	    	 
	  	    	var pData = JSON.parse(data); 
	  	    	//$("#aaaaa").text(pData.mainEventSens[0].fctyTotCnt); 
	  	    	$("#estamEventInfo").empty();
	  	    	evntdata = [];
	  	    	var tmpData  = new Array("1","2","3","4","5","6","7","8","9","10");
	  	    	 for (var idx = 0; idx < Object.keys(pData.mainEventSens).length;idx++) {   
	  	    		 
	  	    		tmpData[idx] =  ("<div><ul ><li class='graph_title01'>이상진동 감지  -  " + pData.mainEventSens[idx].evntSensCnt + "/" + pData.mainEventSens[idx].fctyTotCnt + "개소</li>");
	  	    		tmpData[idx] =  tmpData[idx] + ("<li class='graph_txt'>시각 : " + pData.mainEventSens[idx].currDateTime + "</li>"); 
	  	    		tmpData[idx] =  tmpData[idx] + ("<li class='graph_txt'>위치 : " + pData.mainEventSens[idx].fctyNm + "&nbsp;&nbsp;&nbsp;&nbsp;연락처 (" + pData.mainEventSens[idx].fctyUsrTel + ")</li>");
	  	    		tmpData[idx] =  tmpData[idx] + ("<li class='graph_txt'>계측 PGA : " + pData.mainEventSens[idx].evntSensPga + " gal</li></ul></div>");
	  	    	      
			        evntdata.push(tmpData[idx]);
				
			     }
			 
				 if (Object.keys(pData.mainEventSens).length > 0) {
				     fnEvntSroll(true); 
				 }
			 
	  	    	 
	  	      }
	  	  }); 
  } 
  
  $(document).ready(function () {   
	   function event_update() {
	    	  
		 fnEvntSroll(false);  
		 eventExec(); 
	         setTimeout(event_update, 100000);
	   }
	   
	   event_update();
	   
	   
	   $('#tipEstamEvnt').tooltip({
			track: true,
			delay: 0,
			showURL: false,
			showBody: " - ",
			extraClass: "tipEstamEvnt",
			fixPNG: false,
			left: -120
		});
	    
	     
  });
  
  

  

</script> 
 
				<div class="data_step">
					<img src="${ctx}/img/common/data_step.jpg" title="" />
				</div>
				<ul  id="tipEstamEvnt" title="PGA ${fctyStatScnGal} gal 이상">
				 <li >
				    <div id="estamEventInfo" style="position: relative;overflow:hidden;width:350px;height:105px;">
				    <ul>
					<li class="graph_title01">이상진동 감지  -  없음/0개소</li>
					<li class="graph_txt">시각 : </li> 
					<li class="graph_txt">위치 :  &nbsp;&nbsp;&nbsp;&nbsp;연락처 ( )</li>
					<li class="graph_txt">계측 PGA :  0 gal</li>
				   </ul>	
				    </div>
				 </li>
				</ul>	
			 
 		