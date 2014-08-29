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
 <script type="text/javascript" src="${ctx}/js/jquery/jquery.form.min.js"></script>  
 <script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script> 
 <script src="${ctx}/js/estam_common.js"></script>  

<script type="text/javaScript" language="javascript" defer="defer">
<!--

/* 센서정보  팝업  */
function fn_scn_popup() {
    window.open("<c:url value='/sptIptnRslt/sptIptnScnSearchList.do' />","scn_popup",'width=540,height=400,scrollbars=yes,resizable=no,status=no,center:yes');
}

/* 기록계정보  팝업 */
function fn_rcc_popup() {
    window.open("<c:url value='/sptIptnRslt/sptIptnRccSearchList.do' />","rcc_popup",'width=540,height=400,scrollbars=yes,resizable=no,status=no,center:yes');
}

function imgFileUpload() {
	
	imgFile = $("#imgFile").val();
	if(imgFile=="") {
		alert("도면이미지 파일을 선택하세요");
		return false;
	}
	
	posExt = imgFile.substring(imgFile.lastIndexOf(".")+1, imgFile.length);
	if(posExt=="jpg" || posExt=="gif" || posExt=="png") {
		$("#imgFileUploadForm").ajaxForm();
		  
		$("#imgFileUploadForm").ajaxSubmit({
			statusCode: {   
				400: function() {
					alert("파일 내용이 잘못되었습니다.");
				},   
				500: function() {
					alert("파일을 업로드할 수 없습니다.");
				}
			},      
			success: function(data) {
				alert("업로드 되었습니다. 페이지를 다시 읽습니다.");
				window.location.reload(true);
			}
		});
	} else {
		alert("이미지 파일이 아닙니다. \n※*.jpg, *.gif, *.png파일만 업로드가 가능합니다.");
	}
}

function imgFileDownload(fileLc,orginlFileNm) {	
	$("#fileLc").val(fileLc);
	$("#orginlFileNm").val(orginlFileNm);
	var form = document.forms['downloadForm'];
	form.action = "${ctx}/sptIptnRslt/imgFileDown.do";
	form.target = "downloadFrame";
	form.submit();
}

function imgFileDelete(seq) {	
	
	if(!confirm("파일을 삭제하시겠습니까?")) {
		return false;
	}
	
	$("#sptIptnFlorSeq").val(seq);
	
	$.ajax({
        type : "POST" //"POST", "GET"
        , async : false //true, false
        , url : "${ctx}/sptIptnRslt/imgFileDelete.do" 
        , cache : false  //true, false
        , data : $("#imgFileUploadForm").serialize() 
        , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
        , error : function(request, status, error) {
        	alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
        }
        , success : function(response, status, request) {
        	alert("삭제 되었습니다. 페이지를 다시 읽습니다.");
			window.location.reload(true);
        }
    });
}

function etcFileUpload() {
	
	etcFile = $("#etcFile").val();
	if(etcFile=="") {
		alert("기타정보 파일을 선택하세요");
		return false;
	}
	
	$("#etcFileUploadForm").ajaxForm();
	  
	$("#etcFileUploadForm").ajaxSubmit({
		statusCode: {   
			400: function() {
				alert("파일 내용이 잘못되었습니다.");
			},   
			500: function() {
				alert("파일을 업로드할 수 없습니다.");
			}
		},      
		success: function(data) {
			alert("업로드 되었습니다. 페이지를 다시 읽습니다.");
			window.location.reload(true);
		}
	});
}

function etcFileDownload(fileLc,orginlFileNm) {
	$("#fileLc").val(fileLc);
	$("#orginlFileNm").val(orginlFileNm);
	var form = document.forms['downloadForm'];
	form.action = "${ctx}/sptIptnRslt/etcFileDown.do";
	form.target = "downloadFrame";
	form.submit();
}

function etcFileDelete(seq) {	
	
	if(!confirm("파일을 삭제하시겠습니까?")) {
		return false;
	}
	
	$("#sptIptnEtcSeq").val(seq);
	
	$.ajax({
        type : "POST" //"POST", "GET"
        , async : false //true, false
        , url : "${ctx}/sptIptnRslt/etcFileDelete.do" 
        , cache : false  //true, false
        , data : $("#etcFileUploadForm").serialize() 
        , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
        , error : function(request, status, error) {
        	alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
        }
        , success : function(response, status, request) {
        	alert("삭제 되었습니다. 페이지를 다시 읽습니다.");
			window.location.reload(true);
        }
    });
}
//-->
</script> 
</head>

<BODY>

<!-- STR:컨텐츠 -->	
<div id="contents_popup">
			
		<div class="content_title"><ul><li>시설물 개요</li></ul></div>
        <div class="widget_header3" id="FctyLeftScl"  style="height:650px;overflow-y:scroll;"> 
        <table id="chTable" class="buil_list_tb auth_group display dataTable"> 
		<table class="auth_group display3">
			<caption></caption>
			<tbody>
				<tr>
					<td class="tlt3" rowspan="2">점검대상</td>									
					<td rowspan="2">${sptIptnRslt.fctyNm}</td>									
					<td class="tlt3">건물규모</td>
					<td>건물규모:${sptIptnRslt.fctyFlorScl}/지붕높이 :${sptIptnRslt.fctyRofHt}</td>
					<td class="tlt3">공고일</td>
					<td>${sptIptnRslt.fctyStblDt}</td>
				</tr>
				<tr>
					<td class="tlt3">건물높이</td>									
					<td>${sptIptnRslt.fctyHt}</td>									
					<td class="tlt3">계약일</td>
					<td>${sptIptnRslt.fctyCtatDt}</td>
				</tr>
				<tr>
					<td class="tlt3">주소</td>									
					<td colspan="3"><div style="text-align:left;padding-left:20px;">${sptIptnRslt.fctyStAddr} ${sptIptnRslt.fctyEdAddr}</div></td>									
					<td class="tlt3">준공(예정)일</td>
					<td>${sptIptnRslt.fctyCplnDt}</td>
				</tr>
			</tbody>
		</table>		

		<br/>

		<div class="content_title"><ul><li>관리자 개요</li></ul></div>
		<table class="auth_group display4">
			<caption></caption>
			<thead>
				<tr>
					<th></th>	
					<th>담당자</th>	
					<th>소속</th>
					<th>직책</th>
					<th>연락처</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="num5">담당부서</td>
					<td>${sptIptnRslt.mgrSlfUsrNm}</td>
					<td>${sptIptnRslt.mgrSlfDept}</td>
					<td></td>
					<td>${sptIptnRslt.mgrUsrTel}</td>
				</tr>
				<tr>
					<td class="num5">설치기관</td>
					<td>${sptIptnRslt.istlUsrNm}</td>
					<td>${sptIptnRslt.istlDept}</td>
					<td></td>
					<td>${sptIptnRslt.istlUsrTel}</td>
				</tr>
				<tr>
					<td class="num5">계측기 공급기관</td>
					<td>${sptIptnRslt.spprUsrNm}</td>
					<td>${sptIptnRslt.spprDept}</td>
					<td></td>
					<td>${sptIptnRslt.spprUsrTel}</td>
				</tr>
			</tbody>
		</table>

		<br/>

		<div class="content_title"><ul><li>현장점검 개요</li></ul></div>
		<table class="auth_group display4">
			<caption></caption>
			<thead>
				<tr>
					<th>현장점검<br>요청일</th>	
					<th>현장점검<br>실시일</th>	
					<th>현장점검<br>결과보고일</th>
					<th>현장점검<br>결과</th>
					<th>현장점검<br>결과보고서 파일</th>
				</tr>
			</thead>
			<tbody>
                <c:forEach var="sptIptnRsltFlList" items="${sptIptnRsltFlList}" varStatus="status">			
				<tr>
					<td>${sptIptnRsltFlList.sptIptnReqtDt}</td>
					<td>${sptIptnRsltFlList.sptIptnDt}</td>
					<td>${sptIptnRsltFlList.sptIptnRsltDt}</td>
					<td>${sptIptnRsltFlList.sptIptnRsltYn}</td>
					<td><a href="#" class="css_button" onclick=""><span>파일명 : ${sptIptnRsltFlList.sptIptnFlnm} </span></a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

		<br/>

		<div class="content_title">
			<ul><li>센서 정보</li></ul>
		<!-- 	<div class="btn"><a href="#" class="css_button blue" onclick="fn_scn_popup();"><span>추가</span></a></div>  -->			
		</div>
		<table class="auth_group display4">
			<caption></caption>
			<thead>
				<tr>
					<th>순번</th>
					<th>설치위치</th>
					<th>성분</th>	
					<th>모델명/일련번호</th>
					<th>제작자</th>
					<th>인증기관</th>
					<th>인증일</th>
					<th>설치일</th>
				</tr>
			</thead>
			<tbody>
			    <c:set var="iCnt" value="1"/>
			    <c:forEach var="sptIptnScnList" items="${sptIptnScnList}" varStatus="status">
				<tr>
					<td>${iCnt}</td>
					<td>${sptIptnScnList.ehqkScnIstlPos}</td>
					<td>${sptIptnScnList.ehqkScnChl}</td>
					<td>${sptIptnScnList.ehqkScnMdl}/${sptIptnScnList.ehqkScnId}</td>					
					<td>${sptIptnScnList.ehqkScnCmpy}</td>
					<td>${sptIptnScnList.ehqkScnAuthIntt}</td>
					<td>${sptIptnScnList.ehqkScnAuthDt}</td>
					<td></td>				
				</tr>
				<c:set var="iCnt" value="${iCnt+1}"/>
				</c:forEach>
			</tbody>
		</table>


		<br/>

		<div class="content_title">
			<ul><li>기록계 정보</li></ul>
			<!-- <div class="btn"><a href="#" class="css_button blue" onclick="fn_rcc_popup();"><span>추가</span></a></div>  -->
		</div>
		<table class="auth_group display4">
			<caption></caption>
			<thead>
				<tr>
					<th>순번</th>
					<th>설치위치</th>
    				<th>모델명/일련번호</th>
					<th>제작자</th>
					<th>인증기관</th>
					<th>인증일</th>
					<th>설치일</th>
				</tr>
			</thead>
			<tbody>
                <c:set var="iCnt" value="1"/>
                <c:forEach var="sptIptnRccList" items="${sptIptnRccList}" varStatus="status">			
				<tr>
                    <td>${iCnt}</td>
                    <td>${sptIptnRccList.rccIstlPos}</td>
					<td>${sptIptnRccList.rccMdl}/${sptIptnRccList.rccId}</td>					
					<td>${sptIptnRccList.rccCmpy}</td>
					<td>${sptIptnRccList.rccAuthIntt}</td>
					<td>${sptIptnRccList.ehqkRccAuthDt}</td>
					<td></td>				
				</tr>
                <c:set var="iCnt" value="${iCnt+1}"/>
                </c:forEach>				
			</tbody>
		</table>


		<br/>
		<div class="widget table_container">	
			<div class="content_title"><ul><li>도면 정보</li></ul></div>
				<div class="member_view" style="padding:5px 0 7px 30px;">	
					<form method="post" name="imgFileUploadForm" id="imgFileUploadForm" action="${ctx}/sptIptnRslt/imgFileUpload.do" enctype="multipart/form-data">	
					
						<!-- <input type="text" name="" title="" value="" style="width:780px;" onkeypress="" maxlength="" > -->
						<input type="file" name="imgFile" id="imgFile" style="width:750px;" >
						<a class="css_button blue" onclick="javascript:imgFileUpload();" href="#"><span>도면정보 업로드</span></a>	
						<br>
						<input type="hidden" name="fctyCd" id="fctyCd" value="${searchVO.fctyCd}">
						<input type="hidden" name="gvmtCd" id="gvmtCd" value="${searchVO.gvmtCd}">
						<input type="hidden" name="sptIptnDt" id="sptIptnDt" value="${searchVO.sptInptDt}">
						<input type="hidden" name="seq" id="sptIptnFlorSeq">		
						<br>							

						<img width="900px" border="1" src="<c:url value='${lastSptIptnFlorVO.sptIptnFlorFlsv}${lastSptIptnFlorVO.sptIptnFlorFlnm}'/>"/>
						<div>
						<c:forEach var="sptIptnFlorList" items="${sptIptnFlorList}" varStatus="status">
							<a href="#" class="css_button" onclick="javascript:imgFileDownload('${sptIptnFlorList.sptIptnFlorFlsv}','${sptIptnFlorList.sptIptnFlorFlnm}')"><span>${sptIptnFlorList.sptIptnFlorFlnm} 다운로드</span></a>
							<a href="#" class="css_button red" onclick="javascript:imgFileDelete('${sptIptnFlorList.sptIptnFlorSeq}')"><span>삭제</span></a>
							<br/>
						<!-- 
						<div class="btn_group" style="padding:5px 0 0 0;">
							<a href="#" class="css_button blue" onclick=""><span>${sptIptnFlorList.sptIptnFlorFlnm} 다운로드</span></a>
						</div>
						-->
						</c:forEach>
						</div>
					</form> 
				</div> 
		</div>
		
		
		
		<div class="widget table_container">	
			<div class="content_title"><ul><li>기타 정보</li></ul></div>
				<div class="member_view" style="padding:5px 0 7px 30px;">	
					<form method="post" name="etcFileUploadForm" id="etcFileUploadForm" action="/sptIptnRslt/etcFileUpload.do" enctype="multipart/form-data">	
					<input type="file" name="etcFile" id="etcFile" style="width:700px;" >
					<a class="css_button blue" onclick="javascript:etcFileUpload();" href="#"><span>기타정보 업로드</span></a>	
					<br>
					<input type="hidden" name="fctyCd" id="fctyCd" value="${searchVO.fctyCd}">
					<input type="hidden" name="gvmtCd" id="gvmtCd" value="${searchVO.gvmtCd}">
					<input type="hidden" name="sptIptnDt" id="sptIptnDt" value="${searchVO.sptInptDt}">
					<input type="hidden" name="seq" id="sptIptnEtcSeq">
					<br>
					<ul>
					<c:forEach var="sptIptnEtcList" items="${sptIptnEtcList}" varStatus="status">
						<li><a href="#" class="css_button" onclick="javascript:etcFileDownload('${sptIptnEtcList.sptIptnEtcFlsv}${sptIptnEtcList.sptIptnEtcFlnm}','${sptIptnEtcList.sptIptnEtcTitl}')"><span>'${sptIptnEtcList.sptIptnEtcTitl}' 다운로드</span></a>
							<a href="#" class="css_button red" onclick="javascript:etcFileDelete('${sptIptnEtcList.sptIptnEtcSeq}')"><span>삭제</span></a>
						<br/></li>
					</c:forEach>
					</ul>
					</form> 
				</div> 
			</div>
		</table>
		</div> 
</div>
<form id="downloadForm" name="downloadForm">
	<input type="hidden" name="fileLc" id="fileLc">
	<input type="hidden" name="orginlFileNm" id="orginlFileNm">
</form>	
<iframe id="downloadFrame" name="downloadFrame" style="display:none;" width=0 height=0></iframe>
<!-- END:컨텐츠 -->	


</BODY>
</HTML> 