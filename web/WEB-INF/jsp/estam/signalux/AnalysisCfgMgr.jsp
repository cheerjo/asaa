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
 

<script type="text/javaScript" language="javascript" defer="defer">
 <!--

//저장여부를 확인하여 저장이 완료되면 해당 화면을 띄워준다. 
if("${searchVO.searchUseYn}" == "Y")
{
	alert("저장이 완료되었습니다.");
}
 
 
 /*
 fn_egov_selectList();
 
 // 글 목록 화면 function
 function fn_egov_selectList() {
    	//document.getElementById("detailForm").action = "<c:url value='/anysIdxCoffCfg/AnysIdxCoffCfgList.do'/>";
    	document.getElementById("detailForm").action = "<c:url value='/anysIdxCoffCfg/selectAnysIdxCoffCfg.do'/>";
    	document.getElementById("detailForm").submit();		
 }

 */
 
 /* 글 등록 function */
 function fn_egov_save() {	
	 
	 frm = document.getElementById("detailForm");
	 //Validation
	 if(frm.smfSf.value == "" || 
			frm.smfChk.value == "" ||
			frm.sefSf.value == "" ||
			frm.sefChk.value == "" ||
			frm.rcfSf.value == "" ||
			frm.rcfChk.value == "" ||
			frm.rcswSf.value == "" ||
			frm.rcswChk.value == "" ||
			frm.natFrqRng.value == "" ||
			frm.strFreeNatFrqRng.value == "" ||
			frm.ovrAccRng.value == "" ||
			frm.idrAmp.value == "")
 	{
		alert("하나 이상의 값이 비어있습니다.");
		return;
 	}
		
	if(!confirm("저장하시겠습니까?"))
	{
		return;
	}
 	
 	frm.action = "<c:url value='/signalux/updateAnalysisCfg.do'/>";
    
 	frm.submit();
 }
 
 function fn_egov_refresh() {	
	document.location.href = "/signalux/AnalysisCfg.do";
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

<form name="detailForm" id="detailForm" method="post">
<input type="hidden" name="anysIdxCoffNo" value="1" />

<!-- STR:컨텐츠 -->	
<div id="contents_wrap">
	<div id="contents">
		<br>
		<div class="content_title"><h2>분석지표 계수설정</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">시스템 설정</a></li>
				<li class="last">분석지표 계수설정</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>
		<div class="content_title2" style=""><ul><li>안전 관리 기준</li></ul></div>

		<div class="a_data_total">
			<div style="float:left;width:50%;">
				<div style="width:700px;margin:0 auto;">
					<div class="content_title4"><ul><li> 최대층간변위비</li></ul></div>	
					<table class="auth_group display2">
						<caption></caption>
						<thead>
							<tr>
								<th rowspan="2">구조형식</th>	
								<th colspan="2">안전</th>
								<th colspan="2">점검필요</th>
							</tr>
							<tr>
								<td colspan="2">No damage</td>
								<td colspan="2">Immediate<br/>Occupancy</td>
							</tr>
						</thead>				
						<tbody>
							<tr>
								<td class="tlt">철골 모멘트 골조</td>
								<td><input type="text" name="smfSf" value="${anysIdxCoffCfgVO.smfSf}"/></td>
								<td>% 이하</td>
								<td><input type="text" name="smfChk" value="${anysIdxCoffCfgVO.smfChk}"/></td>
								<td>% 초과</td>
							</tr>
							<tr>
								<td class="tlt">철골 편심가새 골조</td>
								<td><input type="text" name="sefSf" value="${anysIdxCoffCfgVO.sefSf}"/></td>
								<td>% 이하</td>
								<td><input type="text" name="sefChk" value="${anysIdxCoffCfgVO.sefChk}"/></td>
								<td>% 초과</td>
							</tr>
							<tr>
								<td class="tlt">철근콘크리트 모멘트 골조</td>
								<td><input type="text" name="rcfSf" value="${anysIdxCoffCfgVO.rcfSf}"/></td>
								<td>% 이하</td>
								<td><input type="text" name="rcfChk" value="${anysIdxCoffCfgVO.rcfChk}"/></td>
								<td>% 초과</td>
							</tr>
							<tr>
								<td class="tlt">철골콘크리트 전단벽</td>
								<td><input type="text" name="rcswSf" value="${anysIdxCoffCfgVO.rcswSf}"/></td>
								<td>% 이하</td>
								<td><input type="text" name="rcswChk" value="${anysIdxCoffCfgVO.rcswChk}"/></td>
								<td>% 초과</td>
							</tr>
						</tbody>
					</table> 
					
					<br/>
					<div class="content_title5">
						<ul>
							<li class="title5"> 고유진동수 변화율</li>
							<li> 						
								<table class="auth_group display2">
								<caption></caption>
									</tbody>
										<tr>
											<td class="line_bg"><input type="text" name="natFrqRng" value="${anysIdxCoffCfgVO.natFrqRng}"/></td>		
											<td class="line_bg">% 이하</td>		
										</tr>
									<tbody>
								</table> 
							</li>
						</ul>
					</div>
					<br class="clear"/>
					<div class="content_title5">
						<ul>
							<li class="title5"> 건축물과 자유장 고유진동수비</li>
							<li> 						
								<table class="auth_group display2">
								<caption></caption>
									</tbody>
										<tr>
											<td class="line_bg" width=160px>100            ±</td>
											<td class="line_bg"><input type="text" name="strFreeNatFrqRng" value="${anysIdxCoffCfgVO.strFreeNatFrqRng}"/></td>		
											<td class="line_bg">% 이외</td>		
										</tr>
									<tbody>
								</table> 
							</li>
						</ul>
					</div>
					<br class="clear"/>
					<div class="content_title5">
						<ul>
							<li class="title5"> 설계가속도 초과율</li>
							<li> 						
								<table class="auth_group display2">
								<caption></caption>
									</tbody>
										<tr>
											<td class="line_bg"><input type="text" name="ovrAccRng" value="${anysIdxCoffCfgVO.ovrAccRng}"/></td>		
											<td class="line_bg">% 이하</td>		
										</tr>
									<tbody>
								</table> 
							</li>
						</ul>
					</div>
					<br class="clear"/>
						
					<br class="clear"/>
				</div>

			</div>


			<div style="float:left;width:50%;" >
				<div style="width:600px;margin:0 auto;">
					<div class="content_title5">
						<ul>
							<li class="title5"> 층간변위 증폭계수</li>
							<li> 						
								<table class="auth_group display2">
								<caption></caption>
									</tbody>
										<tr>
											<td class="line_bg"><input type="text" name="idrAmp" value="${anysIdxCoffCfgVO.idrAmp}"/></td>		
										</tr>
									<tbody>
								</table> 
							</li>
						</ul>
					</div>				
				</div>
			</div>



			<div style="float:left;width:50%;display:none;" >
				<div style="width:600px;margin:0 auto;">
					<div class="content_title2"><ul><li>고유진동수 측정 감시 영역 / 감시영역길이 & 이동간격길이</li></ul></div>
						<div class="content_title4"><ul><li> 고유진동수 측정 감시 영역</li></ul></div>	
						<table class="auth_group display2">
							<caption></caption>										
							<tbody>
								<tr>
									<td class="num">장축 </td>
									<td><input type="text" name="strFrqWinMjH" value="${anysIdxCoffCfgVO.strFrqWinMjH}"/></td>
									<td>% 이상</td>
									<td><input type="text" name="strFrqWinMjL" value="${anysIdxCoffCfgVO.strFrqWinMjL}"/></td>
									<td>% 이하</td>
								</tr>
								<tr>
									<td class="num">단축 </td>
									<td><input type="text" name="strFrqWinShotH" value="${anysIdxCoffCfgVO.strFrqWinShotH}"/></td>
									<td>% 이상</td>
									<td><input type="text" name="strFrqWinShotL" value="${anysIdxCoffCfgVO.strFrqWinShotL}"/></td>
									<td>% 이하</td>
								</tr>
							</tbody>
						</table> 

						<br/>
						<div class="content_title4"><ul><li> 감시영역길이 / 이동간격길이</li></ul></div>	
						<table class="auth_group display2">
							<caption></caption>										
							<tbody>
								<tr>
									<td class="tlt4">감시영역 </td>
									<td><input type="text" name="frqWinLent" value="${anysIdxCoffCfgVO.frqWinLent}"/></td>
									<td>sec</td>
								</tr>
								<tr>
									<td class="tlt4">이동간격</td>
									<td><input type="text" name="movTrmLent" value="${anysIdxCoffCfgVO.movTrmLent}"/></td>
									<td>sec</td>
								</tr>
							</tbody>
						</table>
						
						<br/>

						<br class="clear"/>
				</div>
			</div>
			<br class="clear"/>
		</div>

		<!-- btn_group -->
		<div class="btn_group" style="float:left;width:100%;border-top:1px solid #ffcdcd;padding:10px 0 0 0;">
			<a href="#" class="css_button red" onclick="fn_egov_refresh()"><span>새로고침</span></a><a href="#" class="css_button red" onclick="fn_egov_save()"><span>저장</span></a>
		</div>
		<!-- //btn_group -->
	</div>	
</div>
<!-- END:컨텐츠 -->	
</form>

<!-- STR:footer -->
<div id="footer">
    <c:import url="/EgovPageLink.do?vlink=estam/main/inc/EstamIncFooter" /> 
</div>
<!-- END:footer -->

</BODY>
</HTML>
