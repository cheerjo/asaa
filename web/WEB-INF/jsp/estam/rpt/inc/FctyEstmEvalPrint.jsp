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

<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="${ctx}/js/chart/real/excanvas.min.js"></script><![endif]-->
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.stack.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.axislabels.js"></script>

<script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script> 
     
<script type="text/javascript">
 <!--
//page onLoad
 $(document).ready( function() {

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
	}
	 
 );  
     
     
//-->
</script>
     
</head>

<BODY>

<form:form commandName="searchVO" id="inputForm" name="inputForm" method="post">  
    <form:hidden  id="fctyCd" path="fctyCd" /> 
    <form:hidden  id="gvmtCd" path="gvmtCd" />
    <form:hidden  id="iddlAassNo" path="iddlAassNo" />
    <form:hidden  id="ehqkReqId" path="ehqkReqId" />
    <form:hidden  id="modes" path="modes" />
</form:form>

<!-- STR:top_menu -->
<div id="print_wrap" >
	<div class="pt_title">********** 긴급 안정성평가 결과 보고</div>

	<div class="pt_title01">
		<ul>
			<li><img src="/img/bg/heading2_bg_pt.jpg" /></li>
			<li>********** 긴급 안정성평가 결과</li>
		</ul>
	</div>
	<table>
		<thead>
		<tr>
			<td rowspan="2">평가지표</td>
			<td colspan="2">분석결과 <sup>※</sup> (%)</td>
			<td colspan="2">평가결과</td>
			<td rowspan="2">안전관리기준</td>
		</tr>
		<tr>			
			<td>장축</td>
			<td>단축</td>
			<td>장축</td>
			<td>단축</td>
		</tr>
		</thead>
		<tr>
			<td>최대층간변위비 <sup>1)</sup></td>
			<td>${readIddlAssRlst.rsltMaxIdrX}</td>
			<td>${readIddlAssRlst.rsltMaxIdrY}</td>
			<td class="pt_gray">${readIddlAssRlst.sfChkMaxIdrXRslt}</td>
			<td class="pt_gray">${readIddlAssRlst.sfChkMaxIdrYRslt}</td>
			<td><fmt:formatNumber value="${readIddlAssRlst.iddlAassInfoSf}" pattern="#,##0.0#"/>% 이하
			</td>
		</tr>
		<tr>
			<td>고유진동수 변화율 <sup>2)</sup></td>
			<td>${readIddlAssRlst.rsltNatFrqMvX}</td>
			<td>${readIddlAssRlst.rsltNatFrqMvY}</td>
			<td class="pt_gray">${readIddlAssRlst.sfChkNatFrqMvXRslt}</td>
			<td class="pt_gray">${readIddlAssRlst.sfChkNatFrqMvYRslt}</td>
			<td>${readIddlAssRlst.natFrqRng}% 이하</td>
		</tr>
		<tr>
			<td>건축물과 자유장<br> 고유진동수비 <sup>3)</sup></td>
			<td>${readIddlAssRlst.rsltStrFreeNatFrqX}</td>
			<td>${readIddlAssRlst.rsltStrFreeNatFrqY}</td>
			<td class="pt_gray">${readIddlAssRlst.sfChkStrFreeNatFrqX}</td>
			<td class="pt_gray">${readIddlAssRlst.sfChkStrFreeNatFrqY}</td>
			<td>${readIddlAssRlst.strFreeNatFrqRng}% 이하</td>
		</tr>
		<tr>
			<td>설계가속도 초과율 <sup>4)</sup></td>
			<td>${readIddlAssRlst.rsltOvrAccX}</td>
			<td>${readIddlAssRlst.rsltOvrAccY}</td>
			<td class="pt_gray">${readIddlAssRlst.sfChkOvrAccXRslt}</td>
			<td class="pt_gray">${readIddlAssRlst.sfChkOvrAccYRslt}</td>
			<td>${readIddlAssRlst.ovrAccRng}% 이하</td>
		</tr>
	</table>

	<ul class="pt_comment">
		<li>∴ 평가결과는 [안전] 또는 [점검필요] 로 표현되며 '건축물과 자유장 고유주기비'는 참고자료로써 활용</li>
		<li>※ 건물마다 다른 변동수준을 관리하기 위해서 분석결과는 무차원화하여 비율로 나타냄 (단위 없음)</li>
		<li style="float:left;">주</li>
			<ul style="float:left;margin:0 0 0 5px;">
				<li><sup>1)</sup>최대층간변위비 = a*(최상층최대변위/건물높이)*100    ※a: 모드보정계수 </li>
				<li><sup>2)</sup>고유진동수 변화율 = [(상시 고유진동수-지진발생후 고유진동수)/상시 교유진동수]*100 </li>
				<li><sup>3)</sup>건축물/자유장 고유진동수비 = (건축물 고유진동수/자유장 고유진동수)*100 </li>
				<li><sup>4)</sup>설계가속도 초과율 = [(자유장 수평방향 최대가속도-설계지반가속도)/설계지반가속도]*100</li>
			</ul>
	</ul>
	<br class="clear">

	<div class="pt_title01">
		<ul>
			<li><img src="/img/bg/heading2_bg_pt.jpg" /></li>
			<li>데이터 정보</li>
		</ul>
	</div>
	<div class="pt_title02">
		<ul>
			<li><img src="/img/bg/bullet_green_pt.jpg" /></li>
			<li>최대가속도(gal)</li>
		</ul>
	</div>
	<div style="width:100%;">
		<div style="float:left;width:30%;">
			<table>
			<thead>
				<tr>
					<td colspan="2">자유장</td>
				</tr>
				<tr>
					<td>계측방향</td>
					<td>계측값</td>
				</tr>
				</thead>
				<tr>
					<td>동서</td>
					<td>${readIddlAssRlst.dataFreeAccX}</td>
				</tr>
				<tr>
					<td>남북</td>
					<td>${readIddlAssRlst.dataFreeAccY}</td>
				</tr>
				<tr>
					<td>수평성분합성</td>
					<td>-</td>
				</tr>
				<tr>
					<td>연직</td>
					<td>${readIddlAssRlst.dataFreeAccZ}</td>
				</tr>
			</table>
		</div>
		<div style="float:right;width:68%;">
			<table>
				<thead>
				<tr>
					<td colspan="4">건축물</td>
				</tr>
				<tr>
					<td>계측방향</td>
					<td>최하층</td>
					<td>중간층</td>
					<td>최상층</td>
				</tr>
				</thead>
				<tr>
					<td>장축1</td>
					<td>${readIddlAssRlst.dataStrBotAccX}</td>
					<td>-</td>
					<td>${readIddlAssRlst.dataStrTopAccX}</td>
				</tr>
				<tr>
					<td>단축1</td>
					<td>${readIddlAssRlst.dataStrBotAccY}</td>
					<td>-</td>
					<td>${readIddlAssRlst.dataStrTopAccY1}</td>
				</tr>
				<tr>
					<td>단축2</td>
					<td>-</td>
					<td>-</td>
					<td>${readIddlAssRlst.dataStrTopAccY2}</td>
				</tr>
				<tr>
					<td>연직</td>
					<td>${readIddlAssRlst.dataStrBotAccZ}</td>
					<td>-</td>
					<td>-</td>
				</tr>
			</table>
		</div>
		<br class="clear">
	</div>
	
	<br/>
	<div class="pt_title02">
		<ul>
			<li><img src="/img/bg/bullet_green_pt.jpg" /></li>
			<li>보조자료</li>
		</ul>
	</div>
	<div style="width:100%;">
		<div style="float:left;width:68%;">
			<table>
				<thead>
				<tr>
					<td rowspan="2" colspan="2"></td>
					<td rowspan="2">최대변위<br/>(mm)</td>
					<td colspan="2">고유진동수</td>
				</tr>
				<tr>
					<td>상시 계측값</td>
					<td>현재 계측값</td>
				</tr>
				</thead>
				<tr>
					<td colspan="2">자유장</td>
					<td>${readIddlAssRlst.dataFreeAccDisp}<!--DATA_FREE_ACC_DISP_X,DATA_FREE_ACC_DISP_Y,DATA_FREE_ACC_DISP_Z 중에 가장 큰값--></td>
					<td>${readIddlAssRlst.moniFreeNrfy}</td>
					<td>${readIddlAssRlst.dataFreeFrq}</td>
				</tr>
				<tr>
					<td rowspan="2">건축물<br/>(최상층)</td>
					<td>장축</td>
					<td>${readIddlAssRlst.dataStrTopDispX}</td>
					<td>${readIddlAssRlst.moniMjNrfy}</td>
					<td>${readIddlAssRlst.dataStrFrqX}</td>
				</tr>
				<tr>
					<td>단축</td>
					<td>${readIddlAssRlst.dataStrTopDispY}</td>
					<td>${readIddlAssRlst.moniShotNrfy}</td>
					<td>${readIddlAssRlst.dataStrFrqY}</td>
				</tr>
			</table>
		</div>

		<div style="float:right;width:30%;">
			<table>
				<thead>
				<tr>
					<td>건축물 <br/> 높이(m)</td>
					<td>설계지반 <br/> 가속도 <br/> (gal)</td>
				</tr>
				</thead>
				<tr>
					<td style="height:60px;">${readIddlAssRlst.fctyHt}</td>
					<td>${readIddlAssRlst.rsltOvrAccVal}</td>
				</tr>
			</table>
		</div>
		<br class="clear">
	</div>

	<div class="pt_title01">
		<ul>
			<li><img src="/img/bg/heading2_bg_pt.jpg" /></li>
			<li>검토결과</li>
		</ul>
	</div>
	<table>
		<tr>
			<td class="pt_gray" style="width:100px;"><b>붙임 1</b></td>
			<td style="text-align:left;">계측값 상세</td>
		</tr>
	</table>

	<div class="pt_title01">
		<ul>
			<li><img src="/img/bg/heading2_bg_pt.jpg" /></li>
			<li>자유장 계측값</li>
		</ul>
	</div>
	<table>
		<thead>
		<tr>
			<td style="width:150px;"></td>
			<td>동서</td>
			<td>남북</td>
			<td>연직</td>
		</tr>
		</thead>
		<tr>
			<td>최대지반가속도<br/>(gal (cm/sec<sup>2</sup>))</td>
			<td>${readIddlAssRlst.dataFreeAccX}</td>
			<td>${readIddlAssRlst.dataFreeAccY}</td>
			<td>${readIddlAssRlst.dataFreeAccZ}</td>
		</tr>
		<tr>		
			<td>최대지반속도<br/>(mm/sec)</td>
			<td>${readIddlAssRlst.dataFreeAccSpedX}</td>
			<td>${readIddlAssRlst.dataFreeAccSpedX}</td>
			<td>${readIddlAssRlst.dataFreeAccSpedZ}</td>
		</tr>
		<tr>
			<td>최대지반변위 (mm)</td>
			<td>${readIddlAssRlst.dataFreeAccDispX}</td>
			<td>${readIddlAssRlst.dataFreeAccDispY}</td>
			<td>${readIddlAssRlst.dataFreeAccDispZ}</td>
		</tr>
		<tr>
			<td>지반진동수 (Hz)</td>
			<td colspan="3">${readIddlAssRlst.dataFreeFrq}</td>
		</tr>
		<tr>
			<td>누적절대속도 <br/>(mm/sec)</td>
			<td>-</td>
			<td>-</td>
			<td>-</td>
		</tr>
		<tr>
			<td colspan="4"><b>자유장 가속도 응답 스펙트럼</b></td>
		</tr>
		<tr>
			<td colspan="4">
				<div id="grpAclnInfo"></div>
			</td>
		</tr>
	</table>

	
	<div class="pt_title01">
		<ul>
			<li><img src="/img/bg/heading2_bg_pt.jpg" /></li>
			<li>건축물 계측값</li>
		</ul>
	</div>
	<table>
		<thead>
		<tr>
			<td style="width:150px;"></td>
			<td>장축</td>
			<td>단축</td>
		</tr>
		</thead>
		<tr>
			<td>최대층간변위비 (%)</td>
			<td>${readIddlAssRlst.rsltMaxIdrX}</td>
			<td>${readIddlAssRlst.rsltMaxIdrY}</td>
		</tr>
		<tr>
			<td>최대층최대변위 (mm)</td>
			<td>${readIddlAssRlst.rsltMaxIdrX}</td>
			<td>${readIddlAssRlst.rsltMaxIdrX}</td>
		</tr>
		<tr>
			<td>최대층 최대가속도<br/>(gal (cm/sec<sup>2</sup>))</td>
			<td>${readIddlAssRlst.dataStrTopAccX}</td>
			<td>
			<c:choose>
			<c:when test="${readIddlAssRlst.dataStrTopAccY1 > readIddlAssRlst.dataStrTopAccY2}">${readIddlAssRlst.dataStrTopAccY1}</c:when>
			<c:otherwise>${readIddlAssRlst.dataStrTopAccY2}</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<td>고유진동수 (Hz)</td>
			<td>${readIddlAssRlst.dataStrFrqX}</td>
			<td>${readIddlAssRlst.dataStrFrqY}</td>
		</tr>
		<tr>
			<td colspan="3"><b>최상층 상대변위</b></td>
		</tr>
		<tr>
			<td colspan="3">
				<div id="grpDsltInfo"></div>
			</td>
		</tr>
	</table>
	
</div>
<!-- END:footer -->

</BODY>
</HTML>
