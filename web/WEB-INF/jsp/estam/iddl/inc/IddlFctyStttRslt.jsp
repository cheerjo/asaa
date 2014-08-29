<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
<%
 /**
  * @Class Name :  
  * @Description : 시설물 상세정보 - 속도 그래프.
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
 
<script type="text/javascript">
function fcFctyMgrRight(fctyCd, gvmtCd) {
	
	if(fctyCd=="" || gvmtCd=="")
	{
		return;
	}
	 $.ajax({
	     type : "POST" //"POST", "GET"
	     , async : false //true, false
	     , url : "${ctx}/fcty/FctyIddlManager.do" //Request URL
	     , dataType : "html" //전송받을 데이터의 타입
	                         //"xml", "html", "script", "json" 등 지정 가능
	                         //미지정시 자동 판단
	     //, timeout : 30000 //제한시간 지정
	     , cache : false  //true, false
	     , data : "fctyCd=" + fctyCd + "&gvmtCd=" + gvmtCd//$("#inputForm").serialize() //서버에 보낼 파라메터
	                      //form에 serialize() 실행시 a=b&c=d 형태로 생성되며 한글은 UTF-8 방식으로 인코딩
	                      //"a=b&c=d" 문자열로 직접 입력 가능
	                      //{a:b, c:d} json 형식 입력 가능
	     , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
	     , error : function(request, status, error) {
	      //통신 에러 발생시 처리
	      alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
	     }
	     , success : function(response, status, request) {
	      //통신 성공시 처리 
	     $('#fctyRight').html(response);   
		   	 layer_open('layer2');
	     }
	 });
}	
</script>

<script type="text/javascript" src="${ctx}/js/chart/real/excanvas.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.stack.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.valuelabels.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/flot/jquery.flot.pie.js"></script>  
 
<c:set var="iCnt" value="1"/>
<c:set var="typeCnt" value="0"/>  <!-- 구조형식 -->
<c:set var="florCnt" value="0"/>  <!-- 지상층수 -->
<c:set var="periCnt" value="0"/>  <!-- 준공연도 -->

<script type="text/javascript">
<!--


function dispStatsChart(val) {
	 if (val == "tycd") {
		 document.getElementById("tycd_chart").style.display = "";
		 document.getElementById("flor_chart").style.display = "none";
		 document.getElementById("peri_chart").style.display = "none";
	 }
	 else if (val == "flor") {
		 document.getElementById("tycd_chart").style.display = "none";
		 document.getElementById("flor_chart").style.display = "";
		 document.getElementById("peri_chart").style.display = "none";
		 dispFlorBar();
	 }
	 else if (val == "peri") {
		 document.getElementById("tycd_chart").style.display = "none";
		 document.getElementById("flor_chart").style.display = "none";
		 document.getElementById("peri_chart").style.display = "";
		 dispPeriBar();
	 }

	 return;
}

var tycd_chart_oks = [];
var tycd_chart_chk = [];

var flor_chart_oks = [];
var flor_chart_chk = [];

var peri_chart_oks = [];
var peri_chart_chk = [];

	var barData01 = [];
	var barData02 = [];
	var barTicks01 = [];

	var barData03 = [];
	var barData04 = [];
	var barTicks02 = [];
	
	var barData05 = [];
	var barData06 = [];
	var barTicks03 = [];
	 	

	
	<c:forEach var="iddlAassRlstStatsList" items="${iddlAassRlstStatsList}" varStatus="status"> 
	  <c:if  test="${iCnt == 1}"> //전체 - 파이차트
	    var pie_data = [
	                    { label: "안전", data: ${iddlAassRlstStatsList.oksRate}},
	                    { label: "점검필요", data: ${iddlAassRlstStatsList.chkRate}}
	                   ];	    
	  </c:if>
	  <c:if  test="${iCnt != 1}"> 
	    <c:if test="${iddlAassRlstStatsList.lrgGb == '구조형식'}"> //구조형식
			barData01.push([${typeCnt}, ${iddlAassRlstStatsList.oksCnt}]);
			barData02.push([${typeCnt}, ${iddlAassRlstStatsList.chkCnt}]);
			barTicks01.push([${typeCnt}, "${iddlAassRlstStatsList.midGb}"]);	    
	      	<c:set var="typeCnt" value="${typeCnt+1}"/>	
	  	 </c:if>
	  	 
		 <c:if test="${iddlAassRlstStatsList.lrgGb == '지상층수'}"> //지상층수
			barData03.push([${florCnt}, ${iddlAassRlstStatsList.oksCnt}]);
			barData04.push([${florCnt}, ${iddlAassRlstStatsList.chkCnt}]);
			barTicks02.push([${florCnt}, "${iddlAassRlstStatsList.midGb}"]);	    
	      	<c:set var="florCnt" value="${florCnt+1}"/>			 
		 </c:if>
		
		 <c:if test="${iddlAassRlstStatsList.lrgGb == '준공(내진보강)연도'}"> //준공(내진보강)연도
			barData05.push([${periCnt}, ${iddlAassRlstStatsList.oksCnt}]);
			barData06.push([${periCnt}, ${iddlAassRlstStatsList.chkCnt}]);
			barTicks03.push([${periCnt}, "${iddlAassRlstStatsList.midGb}"]);	    
	      	<c:set var="periCnt" value="${periCnt+1}"/>			 
		 </c:if>
	  </c:if>
	  
	  <c:set var="iCnt" value="${iCnt+1}"/>
	</c:forEach>

//-->	
</script>

<script type="text/javascript">
      
var barDataset = [
                 { label: "안전", data: barData01, color: "#00FF00" },
                 { label: "점검필요", data: barData02, color: "#FF0000" }
             ];

var barDataset2 = [
                  { label: "안전", data: barData03, color: "#00FF00" },
                  { label: "점검필요", data: barData04, color: "#FF0000" }
              ];
var barDataset3 = [
                  { label: "안전", data: barData05, color: "#00FF00" },
                  { label: "점검필요", data: barData06, color: "#FF0000" }
              ];

var barOptions01 = {
		 series: {
		        bars: {
		            show: true,
		            order: 1
		        }
		    } ,
		    bars: {
		        align: "center",
		        barWidth: 0.2
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
	        labelBoxBorderColor: "#000000",
	        position: "ne"
	    },
	    grid: {
	        hoverable: true,
	        borderWidth: 1,        
	        backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
	    }
	};
	
var barOptions02 = {
		 series: {
		        bars: {
		            show: true,
		            order: 1
		        }
		    } ,
		    bars: {
		        align: "center",
		        barWidth: 0.2
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
	        labelBoxBorderColor: "#000000",
	        position: "ne"
	    },
	    grid: {
	        hoverable: true,
	        borderWidth: 1,        
	        backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
	    }
	};

var barOptions03 = {
		 series: {
		        bars: {
		            show: true,
		            order: 1
		        }
		    } ,
		    bars: {
		        align: "center",
		        barWidth: 0.2
		    },
	    xaxis: {
	       // axisLabel: "World Cities",
	        axisLabelUseCanvas: true,
	        axisLabelFontSizePixels: 12,
	        axisLabelFontFamily: 'Verdana, Arial',
	        axisLabelPadding: 10,
	        ticks: barTicks03
	        
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
	        labelBoxBorderColor: "#000000",
	        position: "ne"
	    },
	    grid: {
	        hoverable: true,
	        borderWidth: 1,        
	        backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
	    }
	};
 

$(document).ready(function () {
	
	$("#pie_content01").css("width",600);   
	$("#pie_content01").css("height",205);  
		
	$("#pieplaceholder01").unbind();
	
	$.plot($("#pieplaceholder01"), pie_data, {
		series: {
			pie: { 
				show: true
			}
		}
	});	
	
	$("#bar_content01").css("width",600);   
	$("#bar_content01").css("height",205);  		

	$.plot($("#barplaceholder01"), barDataset, barOptions01);  	
});

function dispFlorBar() {
	
    $("#bar_content02").css("width",600);   
	$("#bar_content02").css("height",205);       
    
    $.plot($("#barplaceholder02"), barDataset2, barOptions02);	
}


function dispPeriBar() {
	
    $("#bar_content03").css("width",600);   
	$("#bar_content03").css("height",205);       
    
    $.plot($("#barplaceholder03"), barDataset3, barOptions03);	
}

</script>

					<div style="float:left;width:49%;margin:0 15px 0 0;">
					    <!-- 
						<div class="content_title2"><ul><li>타이틀</li></ul></div>	
						-->
						<table class="auth_group display2">
							<caption></caption>
							<thead>
								<tr>
									<th colspan="2">분류</th>	
									<th>안전</th>
									<th>점검필요</th>
								</tr>
							</thead>				
							<tbody>
							<c:set var="tSelCnt" value="0"/>
							<c:forEach var="iddlAassRlstStatsList" items="${iddlAassRlstStatsList}" varStatus="status">
							  <c:if test="${iddlAassRlstStatsList.lrgGb == '구조형식'}">
							    <c:set var="tSelCnt" value="${tSelCnt+1}"/>
							  </c:if>
							</c:forEach>
							
							<c:set var="iCnt" value="1"/>
							<c:set var="typeCnt" value="0"/>  <!-- 구조형식 -->
							<c:set var="florCnt" value="0"/>  <!-- 지상층수 -->
							<c:set var="periCnt" value="0"/>  <!-- 준공연도 -->
					 		<c:forEach var="iddlAassRlstStatsList" items="${iddlAassRlstStatsList}" varStatus="status"> 
					 		  <tr>
					 		  <c:if  test="${iCnt == 1}"> 
					 		    <td colspan="2" class="num3">전체</td>
					 		    <td>${iddlAassRlstStatsList.oksRate}% (${iddlAassRlstStatsList.oksCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		    <td>${iddlAassRlstStatsList.chkRate}% (${iddlAassRlstStatsList.chkCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		  </c:if>
					 		  <c:if  test="${iCnt != 1}"> 
					 		    <c:if test="${iddlAassRlstStatsList.lrgGb == '구조형식'}">
					 		      <c:if test="${typeCnt == 0}">
					 		        <td class="tlt4" rowspan="${tSelCnt}">${iddlAassRlstStatsList.lrgGb}</td>
					 		        <td class="line_bg">${iddlAassRlstStatsList.midGb}</td>
					 		        <td>${iddlAassRlstStatsList.oksRate}% (${iddlAassRlstStatsList.oksCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		        <td>${iddlAassRlstStatsList.chkRate}% (${iddlAassRlstStatsList.chkCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		      </c:if>
					 		      <c:if test="${typeCnt != 0}">
					 		        <td class="line_bg">${iddlAassRlstStatsList.midGb}</td>
					 		        <td>${iddlAassRlstStatsList.oksRate}% (${iddlAassRlstStatsList.oksCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		        <td>${iddlAassRlstStatsList.chkRate}% (${iddlAassRlstStatsList.chkCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		      </c:if>
					 		      <c:set var="typeCnt" value="${typeCnt+1}"/>					 		      
					 		    </c:if>
					 		    <c:if test="${iddlAassRlstStatsList.lrgGb == '지상층수'}">
					 		      <c:if test="${florCnt == 0}">
					 		        <td class="tlt4" rowspan="6">${iddlAassRlstStatsList.lrgGb}</td>
					 		        <td class="line_bg">${iddlAassRlstStatsList.midGb}</td>
					 		        <td>${iddlAassRlstStatsList.oksRate}% (${iddlAassRlstStatsList.oksCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		        <td>${iddlAassRlstStatsList.chkRate}% (${iddlAassRlstStatsList.chkCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		      </c:if>
					 		      <c:if test="${florCnt != 0}">
					 		        <td class="line_bg">${iddlAassRlstStatsList.midGb}</td>
					 		        <td>${iddlAassRlstStatsList.oksRate}% (${iddlAassRlstStatsList.oksCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		        <td>${iddlAassRlstStatsList.chkRate}% (${iddlAassRlstStatsList.chkCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		      </c:if>
					 		      <c:set var="florCnt" value="${florCnt+1}"/>
					 		    </c:if>
					 		    <c:if test="${iddlAassRlstStatsList.lrgGb == '준공(내진보강)연도'}">
					 		      <c:if test="${periCnt == 0}">
					 		        <td class="tlt4" rowspan="4">${iddlAassRlstStatsList.lrgGb}</td>
					 		        <td class="line_bg">${iddlAassRlstStatsList.midGb}</td>
					 		        <td>${iddlAassRlstStatsList.oksRate}% (${iddlAassRlstStatsList.oksCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		        <td>${iddlAassRlstStatsList.chkRate}% (${iddlAassRlstStatsList.chkCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		      </c:if>
					 		      <c:if test="${periCnt != 0}">
					 		        <td class="line_bg">${iddlAassRlstStatsList.midGb}</td>
					 		        <td>${iddlAassRlstStatsList.oksRate}% (${iddlAassRlstStatsList.oksCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		        <td>${iddlAassRlstStatsList.chkRate}% (${iddlAassRlstStatsList.chkCnt}/${iddlAassRlstStatsList.totCnt})</td>
					 		      </c:if>
					 		      <c:set var="periCnt" value="${periCnt+1}"/>
					 		    </c:if>					 		    
					 		  </c:if>
					 		  </tr>
					 		<c:set var="iCnt" value="${iCnt+1}"/>
					 		</c:forEach>	

							</tbody>
						</table> 

						<br/>
						<div class="content_title2"><ul><li>점검필요 시설물 목록</li></ul></div>	
						<table class="auth_group display2">
							<caption></caption>
							<thead>
								<tr>
									<th>구분</th>	
									<th>시설물명</th>
									<th>상세정보확인</th>
								</tr>
							</thead>
							<tbody>
							
							<c:choose>
								<c:when test="${empty fctyListInspList}">
									<tr><td colspan="4" align="center">자료가 존재하지 않습니다.</td></tr>
							    </c:when>
						    	<c:otherwise>	
									<c:forEach var="fctyListInspList" items="${fctyListInspList}" varStatus="status">
							   	      <tr>
							 	        <td>${fctyListInspList.commDtlNm}</td>
								        <td>${fctyListInspList.fctyNm}</td>
								        <td><a href="#" class="css_button" onclick="fcFctyMgrRight('${fctyListInspList.fctyCd}', '${fctyListInspList.gvmtCd}');return false;"><span>확인</span></a></td>
								      </tr>
								    </c:forEach>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table> 
					</div>
					<div style="float:left;width:49%;">
						<div class="syright_tab_total">
							<div class="syright_tab">
								<ul>
									<li><a href="javascript:dispStatsChart('tycd');" title="구조형식">구조형식</a></li>
									<li><a href="javascript:dispStatsChart('flor');" title="지상층수">지상층수</a></li>	
									<li><a href="javascript:dispStatsChart('peri');" title="준공연도">준공연도</a></li>
								</ul>
							</div>							
						</div>
						
						<div id="tycd_chart">
						  <div id="bar_content01" class="demo-container">
		                    <div id="barplaceholder01" class="demo-placeholder"></div>
	                      </div>  
						</div>
						<div id="flor_chart" style="display:none">
						  <div id="bar_content02" class="demo-container">
		                    <div id="barplaceholder02" class="demo-placeholder"></div>
	                      </div> 
						</div>
						<div id="peri_chart" style="display:none">
						  <div id="bar_content03" class="demo-container">
		                    <div id="barplaceholder03" class="demo-placeholder"></div>
	                      </div> 
						</div>

						<div>
						  <div id="pie_content01" class="demo-container">
		                    <div id="pieplaceholder01" class="demo-placeholder"></div>
	                      </div> 
						</div>
					</div>
					<br class="clear"/>
					

<!-- 팝업 -->

<style type="text/css">
	.layer {display:none; position:fixed; _position:absolute; top:0; left:0; width:100%; height:100%; z-index:100;}
		.layer .bg {position:absolute; top:0; left:0; width:100%; height:100%; background:#000; opacity:.5; filter:alpha(opacity=50);}
		.layer .pop-layer {display:block;}

	.pop-layer {display:none; position: absolute; top: 50%; left: 50%; width: 1250px; height:auto;  background-color:#fff; border: 5px solid #3571B5; z-index: 10;}	
	.pop-layer .pop-container {padding: 20px 25px;}
	.pop-layer p.ctxt {color: #666; line-height: 25px;}
	.pop-layer .btn-r {width: 100%; margin:10px 0 20px; padding-top: 10px; border-top: 1px solid #DDD; text-align:right;}

	a.cbtn {display:inline-block; height:25px; padding:0 14px 0; border:1px solid #304a8a; background-color:#3f5a9d; font-size:13px; color:#fff; line-height:25px;}	
	a.cbtn:hover {border: 1px solid #091940; background-color:#1f326a; color:#fff;}
</style>

<script type="text/javascript">
	function layer_open(el)
	{

		var temp = $('#' + el);
		var bg = temp.prev().hasClass('bg');	//dimmed 레이어를 감지하기 위한 boolean 변수

		if(bg){
			$('.layer').fadeIn();	//'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다. 
		}else{
			temp.fadeIn();
		}

		// 화면의 중앙에 레이어를 띄운다.
		if (temp.outerHeight() < $(document).height() ) temp.css('margin-top', '-'+temp.outerHeight()/2+'px');
		else temp.css('top', '0px');
		if (temp.outerWidth() < $(document).width() ) temp.css('margin-left', '-'+temp.outerWidth()/2+'px');
		else temp.css('left', '0px');

		temp.find('a.cbtn').click(function(e){
			if(bg){
				$('.layer').fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다. 
			}else{
				temp.fadeOut();
			}
			e.preventDefault();
		});

		$('.layer .bg').click(function(e){	//배경을 클릭하면 레이어를 사라지게 하는 이벤트 핸들러
			$('.layer').fadeOut();
			e.preventDefault();
		});

	}				
</script>

<div class="layer">
	<div class="bg"></div>
	<div id="layer2" class="pop-layer">
		<div class="pop-container">
			<div class="pop-conts">
				<div id="fctyRight" class="a_data_center3"></div>
			</div>
		</div>
	</div>
</div>
			