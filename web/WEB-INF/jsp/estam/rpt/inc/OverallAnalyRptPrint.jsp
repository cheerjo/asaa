<%@ page language="java"	contentType="text/html; charset=UTF-8"%>
<%@ include file="/inc/taglibs.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<title>국립재난안전연구원 지진가속도 응답신호 종합분석 시스템</title>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석 시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석">

<link rel="stylesheet" href="${ctx}/css/style.css">   

<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script> 
<script src="${ctx}/js/estam_common.js"></script> 
 
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.stack.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.axislabels.js"></script>
     
<script type="text/javascript">
 <!--
//page onLoad
 $(document).ready( function() {

/*
		//가속도 응답 스펙트럼
		$("#modes").val('40');
		$.ajax({
			type : "POST" //"POST", "GET"
             , async : false //true, false
             , url : "${ctx}/rpt/FctyEstmEvalPrintGrp.do" //Request URL
             , dataType : "html"
             , cache : false  //true, false
             , data :	$("#inputForm").serialize() 
             , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
             , error : function(request, status, error) {
             	alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
             }
             , success : function(response, status, request) {
             	$('#grpAclnInfo').html(response);   
             }
		});	 
		
		//상대변위 그래프
		$("#modes").val('30');
		$.ajax({
			type : "POST" //"POST", "GET"
             , async : false //true, false
             , url : "${ctx}/rpt/FctyEstmEvalPrintGrp.do" //Request URL
             , dataType : "html"
             , cache : false  //true, false
             , data :	$("#inputForm").serialize() 
             , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
             , error : function(request, status, error) {
             	alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
             }
             , success : function(response, status, request) {
             	$('#grpDsltInfo').html(response);   
             }
		});	

*/	 
});  
     
     
//-->
</script>
     
</head>

<BODY>

<form:form commandName="searchVO" id="inputForm" name="inputForm" method="post">  
    <form:hidden  id="fctyCd" path="fctyCd" />
    <form:hidden  id="gvmtCd" path="gvmtCd" />
    <form:hidden  id="iddlAassNo" path="iddlAassNo" />
    <form:hidden  id="ehqkReqId" path="ehqkReqId" />
    <form:hidden  id="ehqkTranGbcd" path="ehqkTranGbcd" />
    <form:hidden  id="modes" path="modes" />
</form:form>
<!-- STR:top_menu -->
<div id="print_wrap" style="width:680px;">
	<!-- <div class="pt_title">${readIddlAssRlst.fctyNm} 긴급 건전성평가 결과 보고</div> -->

	<div class="pt_title01">
		<ul>
			<li><img src="/img/bg/heading2_bg_pt.jpg" /></li>
			<li>종합분석 보고서</li>
		</ul>
	</div>
	<table>
		<thead>
		<tr>
			<td colspan="6" class="pt_gray">지진개요(기상청)</td>
		<tr style="background-color: #efefef">
			<td>발생시간</td>
			<td>발생지역</td>
			<td>진앙위도(º)</td>
			<td>진앙경도(º)</td>
			<td>진원깊이(Km)</td>
			<td>규모</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="ehqkOcurInfo" items="${ehqkOcurInfo}" varStatus="status">	
		<tr>
			<td>${ehqkOcurInfo.ehqkOrgTm}</td>
			<td>${ehqkOcurInfo.ehqkOrgArea}</td>
			<td>${ehqkOcurInfo.ehqkLon} N</td>
			<td>${ehqkOcurInfo.ehqkLat} E</td>
			<td>-</td>
			<td>${ehqkOcurInfo.ehqkScal}</td>
		</tr>
		</c:forEach> 
		</tbody>
	</table>
	<br class="clear">
	<br class="clear">
	
	<div class="pt_title01">
		<ul>
			<li><img src="/img/bg/heading2_bg_pt.jpg" /></li>
			<li>분석결과 요약</li>
		</ul>
	</div>
	<!-- 나중에 정상적인 DB설계가 되면 그때 제대로 수정이 필요함 현재는 하나의 시설에 대하여만 나오게 되어 있음 2013.12.10 -->
	<ul class="pt_comment">
		<c:if test="${chkRult1View=='view'}">	
			<li>- 최대지반가속도 계측 관측소</li>
			<c:if  test="${empty chkRult1}">
		    	<ul style="margin: 0px 0px 0px 30px; float: left;">
					<li>없음.</li>
				</ul>
			</c:if>
			<c:forEach var="chkRult1" items="${chkRult1}" varStatus="status">
			<ul style="margin: 0px 0px 0px 30px; float: left;">
				<li><strong>${chkRult1.fctyNm}</strong> , 진도: IV. 수평성분합성 최대가속도 (cm/s2): <fmt:formatNumber value="${chkRult1.dataFreeAccHorz}" pattern="#,##0.0#"/></li>
				<li>&nbsp;&nbsp;&nbsp;${chkRult1.fctyStAddr} ${chkRult1.fctyEdAddr} 
					(위도: <fmt:formatNumber value="${chkRult1.fctyLon}" pattern="#,##0.0###"/>, 
					 경도: <fmt:formatNumber value="${chkRult1.fctyLat}" pattern="#,##0.0###"/>)</li>
			</ul>
			<br class="clear">
			</c:forEach>
			<br class="clear">
		</c:if>

		<c:if test="${chkRult2View=='view'}">
			<li>- 설계지반가속도 초과지역</li>
			<c:if  test="${empty chkRult1}">
		    	<ul style="margin: 0px 0px 0px 30px; float: left;">
					<li>없음.</li>
				</ul>
			</c:if>
			<c:forEach var="chkRult2" items="${chkRult2}" varStatus="status">
			<ul style="margin: 0px 0px 0px 30px; float: left;">
				<li><strong>${chkRult2.fctyNm}</strong> , 설계지반 가속도값 : <fmt:formatNumber value="${chkRult2.rsltOvrAccVal}" pattern="#,##0.0#"/>, 
				X방향 설계 가속도 초과율 : <fmt:formatNumber value="${chkRult2.rsltOvrAccX}" pattern="#,##0.0#"/>,
				X방향 설계 가속도 초과율 : <fmt:formatNumber value="${chkRult2.rsltOvrAccY}" pattern="#,##0.0#"/>
				</li>
				<li>&nbsp;&nbsp;&nbsp;${chkRult2.fctyStAddr} ${chkRult2.fctyEdAddr} 
					(위도: <fmt:formatNumber value="${chkRult2.fctyLon}" pattern="#,##0.0###"/>, 
					 경도: <fmt:formatNumber value="${chkRult2.fctyLat}" pattern="#,##0.0###"/>)</li>
			</ul>
			<br class="clear">
			</c:forEach>
			<br class="clear">
		</c:if>

		<c:if test="${chkRult3View=='view'}">
			<li>- 점검필요 시설물 목록</li>
			<ul style="margin: 0px 0px 0px 30px; float: left;">
				<c:set var="cCnt" value="0"/>
				<c:forEach var="analyRsltInfo" items="${analyRsltInfo}" varStatus="status">
					<c:if test="${analyRsltInfo.chkYn=='N'}">
						<li><strong>${analyRsltInfo.fctyNm}</strong> (${analyRsltInfo.fctyStAddr} ${analyRsltInfo.fctyEdAddr})</li>
						<c:set var="cCnt" value="${iCnt+1}"/>
					</c:if>
				</c:forEach>
				<c:if test="${cCnt == 0}"> 
				<li>없음.</li>
				</c:if>
			</ul>
		</c:if>
	</ul>
	
	<br class="clear">
	<br>
	<!-- 추가 개발 필요함
	<table>
		<tr>
			<td>지도가 들어가야 할 영역(개발필요)</td>
		</tr>
	</table>
	
	<br class="clear">
	<br class="clear">
	-->
	
	<div class="pt_title01">
		<ul>
			<li><img src="/img/bg/heading2_bg_pt.jpg" /></li>
			<li>시설물 목록</li>
		</ul>
	</div>
	<table>
		<thead>
		<tr>
			<td colspan="3" class="pt_gray">관측소 개요</td>
			<td colspan="4" class="pt_gray">계측기록개요</td>
		<tr style="background-color: #efefef">
			<td>시설물정보</td>
			<td>시설물명</td>
			<td>기록장소</td>
			<td>기록시작시간</td>
			<td>계측시간</td>
			<td>진도(MMI)</td>
			<td>수평성분합성<br>최대가속도(㎝/s<sup>2</sup>)</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="analyRsltInfo" items="${analyRsltInfo}" varStatus="status">	
		<tr>
			<td>${analyRsltInfo.fctyCd}</td>
			<td>${analyRsltInfo.fctyNm}</td>
			<td>자유장 ???</td>
			<td>${analyRsltInfo.fctyEvntSttm}</td>
			<td>0 ???</td>
			<td>IV ???</td>
			<td><fmt:formatNumber value="${analyRsltInfo.dataFreeAccHorz}" pattern="#,##0.0#"/></td>
		</tr>
		</c:forEach> 
		</tbody>
	</table>
	<br class="clear">
	<br class="clear">
	 

	<c:set var="rCnt" value="1"/>
	<c:forEach var="analyRsltInfo" items="${analyRsltInfo}" varStatus="status">	
	<table>
		<thead>
		<tr>
			<td colspan="3" class="pt_gray">관측소 개요</td>
			<td colspan="4" class="pt_gray">계측기록개요</td>
		<tr style="background-color: #efefef">
			<td>시설물정보</td>
			<td>시설물명</td>
			<td>기록장소</td>
			<td>기록시작시간</td>
			<td>계측시간</td>
			<td>진도(MMI)</td>
			<td>수평성분합성<br>최대가속도(㎝/s<sup>2</sup>)</td>
		</tr>
		</thead>
		<tbody>
		
		<tr>
			<td>${analyRsltInfo.fctyCd}</td>
			<td>${analyRsltInfo.fctyNm}</td>
			<td>자유장</td>
			<td>${analyRsltInfo.fctyEvntSttm}</td>
			<td>0</td>
			<td>IV</td>
			<td><fmt:formatNumber value="${analyRsltInfo.dataFreeAccHorz}" pattern="#,##0.0#"/></td>
		</tr>
		
		</tbody>
	</table>
	<br class="clear">
	<br class="clear">
	
	<script>
	//$("#modes").val('${rCnt}');
	var param = $("#inputForm").serialize() + "&modes=${rCnt}&fctyCd=${analyRsltInfo.fctyCd}&gvmtCd=${analyRsltInfo.gvmtCd}" ;
	//alert(param);
	$.ajax({
		type : "POST" //"POST", "GET"
         , async : false //true, false
         , url : "${ctx}/rpt/OverallAnalyRptPrintGrp.do" //Request URL
         , dataType : "html"
         , cache : false  //true, false
         , data :	param
         , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
         , error : function(request, status, error) {
         	alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
         }
         , success : function(response, status, request) {
         	$('#graph_${rCnt}').html(response);   
         }
	});
	</script>
	
	<div id="graph_${rCnt}"></div>
	
	
	
	<br class="clear">
	<br class="clear">
	<br class="clear">
	<br class="clear">
	<c:set var="rCnt" value="${rCnt+1}"/>
	</c:forEach> 
	
</div>
<!-- END:footer -->

</BODY>
</HTML>