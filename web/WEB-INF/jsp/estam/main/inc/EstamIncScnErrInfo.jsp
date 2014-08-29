<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  

<link rel="stylesheet" href="${ctx}/css/style.css">   
    
<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script>  
 <script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script> 
<script src="${ctx}/js/jquery/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${ctx}/js/jquery/jquery.dimensions.js" type="text/javascript"></script>   
 <script type="text/javascript" src="${ctx}/js/jquery/jquery.tooltip.min.js"></script>   

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
 
#tooltip.tipScnErr {
	font-family: Arial;
	border: none;
	width: 320px;
	padding:10px;
	height: 30px;
	opacity: 0.8; 
	background: white;
}
#tooltip.tipScnErr h3 {
	margin-bottom: 0.75em;
	font-size: 12pt;
	width: 320px;
	text-align: center;
}
#tooltip.tipScnErr div { width: 320px; text-align: left; }
  
      }
    </style> 
<script type="text/javascript">
 
   function scnerrExec() {
	   
	   var scnForm = { flag:"PGA" }; 
	   
	  	$.ajax({
	  	      url: "${ctx}/main/ScnErrInfoJson.do",
	  	      dataType: 'json',
	          type : 'POST',
	          contentType: "application/json; charset=UTF-8",
	          async: false,  
	  	      data: JSON.stringify(scnForm),
	  	      success: function(data) {  
	  	    	  
	  	    	var pData = JSON.parse(data); 
	  	    	
	  	    	//$("#scnerr_title").text(pData.scnerr_title); 
	  	    	$("#estamScnErrInfo").empty();
	  	    	$("#estamScnErrTitle").text("계측신호 오류 감지  -  " + pData.mainScnErSens[0].evntErSensCnt + "/" + pData.mainScnErSens[0].fctyTotCnt + "개소");
	  	    	
	  	    	 for (var idx = 0; idx < Object.keys(pData.mainScnErSens).length;idx++) {   
	  	    		  
	  	    		$("#estamScnErrInfo").append("<li class='graph_txt'>" + pData.mainScnErSens[idx].fctyKndNm + " " + pData.mainScnErSens[idx].fctyNm + "</li></ul>");
	  	    	  
			     } 
	  	     
	  	      }
	  	  }); 
  } 
  
  $(document).ready(function () {   
	   function scn_update() {
	   
	    
		   scnerrExec(); 
	   
	       setTimeout(scn_update, 100000);
	   }
	   
	   scn_update() ; 

	   $('#tipScnErr').tooltip({
			track: true,
			delay: 0,
			showURL: false,
			showBody: " - ",
			extraClass: "tipScnErr",
			fixPNG: false,
			left: -120
		}); 
	 
  });
   
</script> 
				 
				<ul>
				 <li > 
				   <div  style="position: relative;overflow:hidden;width:350px;height:105px;">
				    <ul id="tipScnErr" title="PGA ${fctyStatScnErr02} gal 이상 ${fctyStatScnErr01}분간 수신데이타 없음"  >
						<li id="estamScnErrTitle" class="graph_title01">계측신호 오류 감지  -  없음/0개소</li>
						<li>
						  <ul  id="estamScnErrInfo"  style="height:75px;overflow-y: scroll;"> 
							<li class="graph_txt">&nbsp;</li>
						    <li class="graph_txt">&nbsp;</li>
						 </ul> 
						</li>  
				   </ul>   
				    </div>
				 </li>
				</ul>	
			  
 							