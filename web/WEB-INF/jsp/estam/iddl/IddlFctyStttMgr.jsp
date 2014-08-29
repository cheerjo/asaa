<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
<%@ page import ="egovframework.com.cmm.LoginVO" %>
 <!DOCTYPE html>
<html lang="ko">
<head>
<title>국립재난안전연구원 지진가속도 응답신호 종합분석 시스템</title>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석 시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=7, IE=9, IE=10">
<meta name="viewport" content="initial-scale=1, maximum-scale=1,user-scalable=no">


<link rel="stylesheet" href="${ctx}/css/style.css">   

<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script>  
<script src="${ctx}/js/estam_common.js"></script>  
 
<link href="/js/chart/flot/examples.css" rel="stylesheet" type="text/css">   
 
<script type="text/javascript">

window.onload = function() {
	//시설물 테이블 마우스오버 옵션
	var tblList = document.getElementById("chTable").getElementsByTagName("tr");
	for (i=1; i<tblList.length; i++) {
		tblList[i].onmouseover = function() {
			this.style.backgroundColor ='#f7f9db';
		}
		tblList[i].onmouseout = function() {
			this.style.backgroundColor = '#fff';
		}
	}
}

//page onLoad
$(document).ready( function() {  

	$('tr[id^=ehqkList]').bind('click', function(event){ 
	     fnPageView(this.id);     
	});
	var fnPageView = function(pageFctyCd){
	     var arrFcty = pageFctyCd.split(':');
	     $('#iddlAassDt').val(arrFcty[1]);
	     $('#ehqkOrgTm').val(arrFcty[2]);
	     iddFctyStttRlstView();
	};
	fnPageView('${returnVal}');
	
});   

function iddFctyStttRlstView() { 
    $.ajax({
        type : "POST" //"POST", "GET"
        , async : false //true, false
        , url : "${ctx}/iddl/IddlFctyStttRslt.do" //Request URL
        , dataType : "html" 
        , cache : false  //true, false
        , data : $("#leftFctyForm").serialize() 
        , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
        , error : function(request, status, error) {
        	alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
        }
        , success : function(response, status, request) {
        	$('#mainRslt').html(response);   
        }
    });
}


</script>
 
<script type="text/javascript">
 <!--
 
  //소트오더
  function navIddlSort(sortOrder) {
	 document.getElementById("leftFctyForm").fctyAreaCd.value = '${searchVO.fctyAreaCd}';
	 document.getElementById("leftFctyForm").searchKeyword.value = '${searchVO.searchKeyword.replace(",", "")}';
	 document.getElementById("leftFctyForm").searchCondition.value = sortOrder;
	 document.getElementById("leftFctyForm").action = "${ctx}/iddl/IddlFctyStttMgr.do";
	 document.getElementById("leftFctyForm").submit();
 }

  //검색(소트오더는 Reset)
  function navIddlSearch() {
	 document.getElementById("leftFctyForm").fctyAreaCd.value = '${searchVO.fctyAreaCd}';
	 document.getElementById("leftFctyForm").searchKeyword.value = document.getElementById("leftFctyForm").searchKeyword_m.value;
	 document.getElementById("leftFctyForm").action = "${ctx}/iddl/IddlFctyStttMgr.do";
	 document.getElementById("leftFctyForm").submit();
 }  
 
 function naviIddlFctyStats(code) {
	 document.getElementById("leftFctyForm").fctyAreaCd.value = code;
	 document.getElementById("leftFctyForm").action = "${ctx}/iddl/IddlFctyStttMgr.do";
	 document.getElementById("leftFctyForm").submit();
 }
 
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
 //--> 
</script>

<script type="text/javascript" src="${ctx}/js/chart/real/excanvas.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.stack.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.valuelabels.js"></script>
<script type="text/javascript" src="/js/chart/flot/jquery.flot.pie.js"></script>  
 

</head>

<BODY>

<!-- STR:top_menu -->
<div id="top_wrap">
	 <c:import url="/main/EstamIncHeader.do?flag=MAIN" /> 
</div>
<!-- END:top_menu -->
 
<!-- STR:컨텐츠 -->	
<div id="contents_wrap">
	<div id="contents">
		
		<br>
		<div class="content_title"><h2>평가결과통계자료</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">시설물 상세정보</a></li>
				<li class="last">평가결과통계자료</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>
		
		<div class="a_data_total">
			<div class="a_data_left2">
			<!-- 
				<ul class="comm">
					<li class="title">서울특별시청사</li>
					<li><img src="/img/etc/no_img.jpg" title="" /></li>
				</ul>
-->
 				<div class="widget_header2">                        
					<ul class="last">
					  <form:form commandName="searchVO" id="leftFctyForm" name="leftFctyForm" method="post">
					      <!-- form:hidden  id="conDaGbcd" path="conDaGbcd" value="02"/> --> 
					      <input type="hidden" id="fctyAreaCd" name="fctyAreaCd" value="${fctyAreaCd}" />
					      <input type="hidden" id="searchCondition" name="searchCondition" />
					      <input type="hidden" id="searchKeyword" name="searchKeyword" />
					      <input type="hidden" id="iddlAassDt" name="iddlAassDt" />
					      <input type="hidden" id="ehqkOrgTm" name="ehqkOrgTm" />
							<!-- 
							<li align=center valign=middle>
								<fieldset class="inline">
									<label>지역</label>
									<form:select path="fctyAreaCd" multiple="false">
									    <form:option value="" label="전국" /> 
                    					 <form:options items="${fctyAreaList}" itemValue="commDtlCd" itemLabel="commDtlNm" />
                					</form:select> 
								</fieldset> 
								<fieldset class="inline">
									<label>시설분류</label>
									<form:select path="fctyKndCd" multiple="false"> 
									    <form:option value="" label="전체" />
									    <form:options items="${fctyKndList}" itemValue="commDtlCd" itemLabel="commDtlNm" /> 
                					</form:select>  
								</fieldset> 
								<fieldset class="inline">
									<label>상태</label>
									<form:select path="fctyUseYn" multiple="false"> 
									    <form:option value="Y" label="적합" /> 
									    <form:option value="N" label="부적합" /> 
                					</form:select>   
								</fieldset>
								
							</li>
								-->
							<div align="center" style="margin:0 0 4px 10px;">
								검색어&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="searchKeyword_m"><a href="javascript:navIddlSearch();" class="css_button blue"><span>검색</span></a>
							</div>
					   </form:form>
					</ul>
				</div>
<!-- 					       

				<div class="widget_header3" style="height:215px;overflow-y:scroll;">           
					<table class="buil_list_tb" id="chTable">
						<caption>시설물 목록</caption>
					  <c:set var="iCnt" value="1"/>
					  <c:forEach var="fctyMgrList" items="${fctyMgrList}" varStatus="status"> 	
						<tr id="fctycd:${fctyMgrList.fctyCd}">
							<td class="num2">${iCnt}</td>
							<td>${fctyMgrList.fctyNm}
								<br>
								<font class="add">${fctyMgrList.fctyAreaNm}&nbsp;${fctyMgrList.fctyEdAddr}</font></td>
								<c:if test="${fctyMgrList.fctyUseYn == 'Y'}">
							   		<td class="st">적합</td>
							    </c:if>
							   <c:if test="${fctyMgrList.fctyUseYn != 'Y'}">
							   		 <td class="st_no">부적합</td>
							   </c:if>
						</tr>
						<c:set var="iCnt" value="${iCnt+1}"/>
					  </c:forEach> 
					 <c:if  test="${fctyMgrCnt == 0}"> 
					  <tr >
							<td class="num2"></td>
							<td> 
								   <font class="add"> </font></td> 
							<td class="st"> </td> 
						</tr>
					 </c:if>   
					</table>
				</div>
				<br>

-->

				<div class="content_title2"><ul><li>분석결과 목록</li></ul></div>
				<div style="height:760px;overflow-y:scroll;">
					<table class="auth_group display3" style="background-color: #fff;font-size:10px;" id="chTable">
						<caption></caption>
						<thead>
							<tr>
							    <th><a href="JavaScript:navIddlSort('IDDL_AASS_DT')">분석일</a></th>	
								<th><a href="JavaScript:navIddlSort('EHQK_SCAL')">규모</a></th>							
								<th><a href="JavaScript:navIddlSort('EHQK_ORG_AREA')">진앙</a></th>	
								<th><a href="JavaScript:navIddlSort('EHQK_ORG_TM')">진원시</a></th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty ehqkOcurInfoList}">
									<tr><td colspan="4" align="center">자료가 존재하지 않습니다.</td></tr>
									<script>
										$("#iddlAassDt").val("");
										$("#ehqkOrgTm").val("");
									</script>
							    </c:when>
						    	<c:otherwise>						
									<c:forEach var="ehqkOcurInfoList" items="${ehqkOcurInfoList}" varStatus="status">
									  <tr id="ehqkList:${ehqkOcurInfoList.iddlAassDt}:${ehqkOcurInfoList.ehqkOrgTm}">
									    <td>${ehqkOcurInfoList.iddlAassDt}</td>
									    <td>${ehqkOcurInfoList.ehqkScal}</td>
									    <td>${ehqkOcurInfoList.ehqkOrgArea}</td>
									    <td>${ehqkOcurInfoList.ehqkOrgTm}</td>
									  </tr>
									</c:forEach>
								</c:otherwise>
							</c:choose> 	
						</tbody>
					</table>
					</div>

					
				</div>

				<div class="a_data_center3" >
						
				<div class="map_tab">
					<ul>
					<c:choose>
					  <c:when  test="${empty fctyAreaCd}">
					    <li class="on"><a href="javascript:naviIddlFctyStats('');">전국</a></li>
					  </c:when>					  
					  <c:otherwise>
					    <li><a href="javascript:naviIddlFctyStats('');">전국</a></li>
					  </c:otherwise>
					</c:choose>
					<c:forEach var="fctyAreaList" items="${fctyAreaList}" varStatus="status">
					  <c:choose>
					    <c:when  test="${fctyAreaCd == fctyAreaList.commDtlCd}">
					      <li class="on"><a href="javascript:naviIddlFctyStats('${fctyAreaList.commDtlCd}');">${fctyAreaList.commDtlNm}</a></li>
					    </c:when>
					    <c:otherwise>
					      <li><a href="javascript:naviIddlFctyStats('${fctyAreaList.commDtlCd}');">${fctyAreaList.commDtlNm}</a></li>
					    </c:otherwise>
					  </c:choose>
					</c:forEach>
					</ul>
				</div>

				<div style="width:100%;flaot:left;" id="mainRslt">
					<%-- 
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
					--%>
				</div>						
			</div>		
			<br class="clear">
		</div>
	</div>	
</div>
<!-- END:컨텐츠 -->	


<!-- 팝업 -->
<%--
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
--%>			
			
<!-- STR:footer -->
<div id="footer">
    <c:import url="/EgovPageLink.do?vlink=estam/main/inc/EstamIncFooter" /> 
</div>
<!-- END:footer -->

</BODY>
</HTML>
 