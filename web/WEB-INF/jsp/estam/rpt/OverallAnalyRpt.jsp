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
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="${ctx}/js/chart/real/excanvas.min.js"></script><![endif]-->
  
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>    
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.stack.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.axislabels.js"></script>


<script type="text/javascript">
<!--
window.onload = function() {
	//시설물 테이블 마우스오버 옵션
	var tblList = document.getElementById("rsltTable").getElementsByTagName("tr");
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
	$('tr[id^=analyRslt]').bind('click', function(event){ 
	     fnPageView(this.id);     
	});
	var fnPageView = function(pageParam){
	     var arr = pageParam.split(':');
	     $("#ehqkReqId").val(arr[1]);
	     $("#ehqkTranGbcd").val(arr[2]);
	     $("#iddlAassNo").val(arr[3]);
	     //overallAnalyRptView();
	};
	
	fnPageView('${analyRsltSearch}');
	
	
});   

function overallAnalyRptView() { 
    $.ajax({
        type : "POST" //"POST", "GET"
        , async : false //true, false
        , url : "${ctx}/rpt/OverallAnalyRptPrint.do" 
        , cache : false  //true, false
        , data : $("#inputForm").serialize() 
        , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
        , error : function(request, status, error) {
        	alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
        }
        , success : function(response, status, request) {
         	$('#report').html(response);   
        }
    });
}

function fn_egov_print() {
	
	var ehqkReqId = $('#ehqkReqId').val();
    if(ehqkReqId==""){
       alert("분석결과 목록을 하나 선택하세요.");
       return false;
    }
	
    
	var chkRultCnt = 0;
	var chkRult = "";
	$(".chkRult:checkbox:checked").each(function( index ) {
		chkRultCnt = index + 1;
		chkRult = chkRult + $( this ).val() + ",";
	});
	if(chkRultCnt>0) {
		chkRult = chkRult.substring(0, chkRult.length-1);
		$("#chkRult").val(chkRult);
	} else {
		alert("분석결과요약에 체크된 항목이 없습니다.");
	    return false;
	}

	var fctyListCnt = 0;
	var fctyList = "";
	$(".fctyList:checkbox:checked").each(function( index ) {
		fctyListCnt = index + 1;
		fctyList = fctyList + $( this ).val() + ",";
	});
	if(fctyListCnt>0) {
		fctyList = fctyList.substring(0, fctyList.length-1);
		$("#fctyList").val(fctyList);
	} else {
		alert("시설물 목록에 체크된 항목이 없습니다.");
	    return false;
	}
	
	var dataListCnt = 0;
	var dataList = "";
	$(".dataList:checkbox:checked").each(function( index ) {
		dataListCnt = index + 1;
		dataList = dataList + $( this ).val() + ",";
	});
	if(dataListCnt>0) {
		dataList = dataList.substring(0, dataList.length-1);
		$("#dataList").val(dataList);
	} else {
		alert("관측소별 자료목록에 체크된 항목이 없습니다.");
	    return false;
	}

	overallAnalyRptView();
}
 
function fn_reset() {
	$(".chkRult:checkbox").each(function( index ) {
		$( this ).prop("checked",true);
	});
	$(".fctyList:checkbox").each(function( index ) {
		$( this ).prop("checked",false);
	});
	$(".dataList:checkbox").each(function( index ) {
		$( this ).prop("checked",true);
	});
}
//-->
</script>
</head>

<BODY>

<!-- STR:top_menu -->
<div id="top_wrap">
	 <c:import url="/main/EstamIncHeader.do?flag=MAIN" /> 
</div>
<!-- END:top_menu -->
<form:form commandName="searchVO" id="inputForm" name="inputForm" method="post">  
    <form:hidden  id="ehqkReqId" path="ehqkReqId" />
    <form:hidden  id="ehqkTranGbcd" path="ehqkTranGbcd" />
    <form:hidden  id="iddlAassNo" path="iddlAassNo" />
    <form:hidden  id="chkRult" path="chkRult" />
    <form:hidden  id="fctyList" path="fctyList" />
    <form:hidden  id="dataList" path="dataList" />
</form:form>

<!-- STR:컨텐츠  -->	
<div id="contents_wrap">
	<div id="contents">
		
		<br>
		<div class="content_title"><h2>종합 분석보고서</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">보고서작성</a></li>
				<li class="last">종합 분석보고서</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>

		<div class="a_data_total" style="height:2000px;">
			<div class="a_data_left3">
				<div class="content_title2"><ul><li>분석결과 목록</li></ul></div>
				<div style="overflow-y: scroll;height:700px;">
				
					<table class="auth_group display3" style="background-color: #fff;font-size:11px;" id="rsltTable" >
						<caption></caption>
						<thead>
							<tr>
								<th>분석일</th>							
								<th>규모</th>	
								<th>진앙</th>
								<th>진앙일시</th>
							</tr>
						</thead>
						<tbody id="analyRsltList">
						<c:set var="iCnt" value="1"/>
						<c:forEach var="analyRsltList" items="${analyRsltList}" varStatus="status">	
							<tr id="analyRslt:${analyRsltList.ehqkReqId}:${analyRsltList.ehqkTranGbcd}:${analyRsltList.iddlAassNo}" 
								style="cursor:pointer;">						
								<td>${analyRsltList.iddlAassDt}</td>
							    <td>${analyRsltList.ehqkScal}</td>
							    <td>${analyRsltList.ehqkOrgArea}</td>
							    <td>${analyRsltList.ehqkSttm}</td>
							</tr>
							<c:set var="iCnt" value="${iCnt+1}"/>
						</c:forEach> 
							<c:if  test="${analyRsltCnt == 0}"> 
							<tr >
								<tr><td colspan="4" align="center">자료가 존재하지 않습니다.</td></tr>
							</tr>
						</c:if> 
						</tbody>  
				
					</table>
				</div>

				<br/>
					
				</div>

				<div class="a_data_center4">
					<div style="float:left;width:32%;margin:0 20px 0 0;">
						<div class="content_title2"><ul><li>지진자료분석보고서 항목</li></ul></div>	
						<table class="auth_group display2">
							<caption></caption>
							<thead>
								<tr>
									<th colspan="2" style="text-align:left;">분석결과 요약</th>	
								</tr>
							</thead>				
							<tbody>
								<tr>
									<td class="line_bg" style="text-align:left;"><span style="margin-left:15px;">최대지반가속도계측 관측소</span></td>
									<td class="line_bg"><input type="checkbox" class="chkRult" name="chkRult1" title="" value="chkRult1" checked></td>
								</tr>
								<tr>
									<td style="text-align:left;"><span style="margin-left:15px;">설계지반가속도 초과지역</span></td>
									<td><input type="checkbox" class="chkRult" name="chkRult2" title="" value="chkRult2" checked></td>
								</tr>
								<tr>
									<td class="line_bg" style="text-align:left;"><span style="margin-left:15px;">점검필요 시설물 목록</span></td>
									<td class="line_bg"><input type="checkbox" class="chkRult" name="chkRult3" title="" value="chkRult3" checked></td>
								</tr>
								<!-- 
								<tr>
									<td style="text-align:left;"><span style="margin-left:15px;">지반진동세기 분포도</span></td>
									<td><input type="checkbox" class="chkRult" name="chkRult4" title="" value="chkRult4" checked></td>
								</tr>
								-->
						</table>
	
						<br>
						<table class="auth_group display2">
							<caption></caption>
							<thead>
								<tr>
									<th colspan="2" style="text-align:left;">시설물 목록</th>	
								</tr>
							</thead>
						</table>
						<div style="overflow-y: scroll;height:311px;">
							<table class="auth_group display2" style="border-top:none;" id="fctyAreaTable">						
								<tbody>
								<c:set var="iCnt" value="1"/>
								<c:forEach var="fctyList" items="${fctyList}" varStatus="status">
									<c:choose>
										<c:when  test="${iCnt==1}">
											<tr class="line_bg">
										</c:when>
										<c:otherwise>
											<tr>
										</c:otherwise>
									</c:choose>	
										<td style="text-align:left;"><span style="margin-left:15px;">${fctyList.fctyNm}</span></td>
										<td><input type="checkbox" class="fctyList" name="fctyList" title="" value="${fctyList.fctyCd}|${fctyList.gvmtCd}"></td>
									</tr>
									<c:choose>
										<c:when  test="${iCnt==1}">
											<c:set var="iCnt" value="0"/>
										</c:when>
										<c:otherwise>
											<c:set var="iCnt" value="1"/>
										</c:otherwise>
									</c:choose>	
									
					  			</c:forEach>
					  			<!--   -->
							</table>
						</div>
	
						<br/>
						<table class="auth_group display2">
							<caption></caption>
							<thead>
								<tr>
									<th colspan="2" style="text-align:left;">관측소별 자료목록</th>	
								</tr>
							</thead>				
							<tbody>
								<tr>
									<td class="line_bg" style="text-align:left;"><span style="margin-left:15px;">자유장 가속도 시간이력</span></td>
									<td class="line_bg"><input type="checkbox" class="dataList" name="dataList1" title="" value="dataList1" checked></td>
								</tr>
								<tr>
									<td style="text-align:left;"><span style="margin-left:15px;">가속도 응답 스펙트럼</span></td>
									<td><input type="checkbox" class="dataList" name="dataList2" title="" value="dataList2" checked></td>
								</tr>
								<tr>
									<td class="line_bg" style="text-align:left;"><span style="margin-left:15px;">속도 응답 스펙트럼</span></td>
									<td class="line_bg"><input type="checkbox" class="dataList" name="dataList3" title="" value="dataList3" checked></td>
								</tr>
						</table>
						
						<br/>
						<div class="sy_tab" style="padding:0 0 0 0;">
							<ul>	
								<li class="sy_btn" onclick="fn_reset()"><a href="#">초기화</a></li>						
								<li class="sy_btn" onclick="fn_egov_print()"><a href="#">출력</a></li>	
							</ul>
						</div>
	
					</div>
					<div style="float:left;width:65%;">
						<div id="report">

						</div>
					</div>
					<br class="clear">

				</div>
							

			</div>		
			
			<br class="clear">
		</div>
	</div>	
</div>
<!-- END:컨텐츠 -->	


<!-- STR:footer -->
<div id="footer">
    <c:import url="/EgovPageLink.do?vlink=estam/main/inc/EstamIncFooter" /> 
</div>
<!-- END:footer -->

</BODY>
</HTML>

 