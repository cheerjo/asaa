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
 <script src="${ctx}/js/estam_common.js"></script>  
 
</head>

<BODY>

<!-- STR:컨텐츠 -->	
<div id="contents_popup">	
		<div class="content_title">
			<ul><li>계측기 정보</li></ul></div>        
		</div>
		<div class="a_data_total"  style="height:730px;overflow-y:scroll;width:1260px;">
		<div id="fctyleft" class="a_data_center6">
		<div class="content_title6">기본정보</div>		
				<table class="auth_group display2">
					<caption>계측기 정보</caption>
					<thead>
						<tr>
							<th>관리항목</th>							
							<th colspan="5">내용</th>									
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="tlt">점검일자</td>
							<td colspan="5">
							<c:if test="${!empty rptFctyMgr.iptDt}">
								<fmt:parseDate value='${rptFctyMgr.iptDt}'  var='iptDt' type='date' dateStyle='short' pattern='yyyyMMdd'/>
								<fmt:formatDate value="${iptDt}" pattern="yyyy-MM-dd"/> 
							</c:if>
							
							&nbsp;</td>																		
						</tr>	
						<tr>
							<td class="tlt">기관코드</td>
							<td colspan="5" class="line_bg">${rptFctyMgr.gvmtCd}&nbsp;</td>																		
						</tr>
						<tr>
							<td class="tlt">계측소코드</td>
							<td colspan="5">${rptFctyMgr.fctyCd}&nbsp;</td>																		
						</tr>
						<tr>
							<td class="tlt">계측소명</td>
							<td colspan="5" class="line_bg">${rptFctyMgr.obsName}&nbsp;</td>																		
						</tr>
						<tr>
							<td class="tlt">계측시작일자</td>
							<td colspan="5"> 
							<c:if test="${!empty rptFctyMgr.openDate}">
								<fmt:parseDate value='${rptFctyMgr.openDate}' var='openDate' type='date' dateStyle='short' pattern='yyyyMMdd'/>
								<fmt:formatDate value="${openDate}" pattern="yyyy-MM-dd"/> 
							</c:if>
							&nbsp;</td>																		
						</tr>
						<tr>
							<td class="tlt">계측종료일자</td>
							<td colspan="5" class="line_bg">
							<c:if test="${!empty rptFctyMgr.offDate}">
								<fmt:parseDate value='${rptFctyMgr.offDate}' var='offDate' type='date' dateStyle='short' pattern='yyyyMMdd'/>
								<fmt:formatDate value="${offDate}" pattern="yyyy-MM-dd"/> 
							</c:if>
							&nbsp;</td>																		
						</tr> 
						<tr>
							<td class="tlt">시설물행정구역코드</td>
							<td colspan="5" class="line_bg">${rptFctyMgr.fctyAreaCd}&nbsp;</td>																		
						</tr>
						<tr>
							<td class="tlt">시설물 위치</td>
							<td colspan="5">${rptFctyMgr.fctyAddr}&nbsp;</td>																		
						</tr>
						<tr>
							<td class="tlt">시설물 종류</td>
							<td colspan="5" class="line_bg">${rptFctyMgr.fctyKndCd}&nbsp;</td>																		
						</tr>
						<tr>
							<td class="tlt">계측기 위치</td>
							<td colspan="5">${rptFctyMgr.mechPotn}&nbsp;</td>																		
						</tr>
						<tr>
							<td class="tlt">지진가속도계 개수</td>
							<td colspan="5" class="line_bg">${rptFctyMgr.ehqkScnCnt}/${rptFctyMgr.rccCnt}&nbsp;</td>																		
						</tr>
						<tr>
							<td class="tlt" rowspan="2">위치 및 지형 정보</td>
							<td>경도</td>	
							<td>위도</td>		
							<td>표고</td>		
							<td>지상높이</td>		
							<td>지하깊이</td>		
						</tr>
						<tr>
							<td>&nbsp;${rptFctyMgr.fctyLon}&nbsp;</td>	
							<td>&nbsp;${rptFctyMgr.fctyLat}&nbsp;</td>		
							<td>&nbsp;${rptFctyMgr.fctyAttc}&nbsp;</td>		
							<td>&nbsp;${rptFctyMgr.fctyGrndHt}&nbsp;</td>		
							<td>&nbsp;${rptFctyMgr.fctyUgrdHt}&nbsp;</td>		
						</tr>
						<tr>
							<td class="tlt" rowspan="2">지반정보</td>
							<td class="line_bg">기초형식</td>	
							<td class="line_bg">설계기준</td>		
							<td class="line_bg">지반분류</td>		
							<td colspan="5" class="line_bg">주상도이미지</td>		
						</tr>
						<tr>
							<td class="line_bg">&nbsp;${rptFctyMgr.strcFrmCd}&nbsp;</td>	
							<td class="line_bg">&nbsp;${rptFctyMgr.seisCd}&nbsp;</td>		
							<td class="line_bg">&nbsp;${rptFctyMgr.fctyGrndCd}&nbsp;</td>		
							<td colspan="5" class="line_bg">&nbsp;&nbsp;</td>	
						</tr>
						<tr>
							<td class="tlt">설치업체명</td>
							<td colspan="5">&nbsp;${rptFctyMgr.fctyChgeNm}&nbsp;</td>																		
						</tr>
						<tr>
							<td class="tlt">설치업체 연락처</td>
							<td colspan="5" class="line_bg">&nbsp;${rptFctyMgr.fctyCottTel}&nbsp;</td>																		
						</tr>
					</tbody>
				</table>
				
				<br>
				<div class="content_title6"><ul><li>지진가속도계</li></ul></div>
				<table class="auth_group display2">
					<caption>지진가속도계 목록</caption>
					<thead>
						<tr>
							<th>번호</th>							
							<th>설치위치</th>	
							<th>계측성분</th>	
							<th>고유번호</th>
							<th>최종점검일</th>
							<th colspan="2">점검내역</th>
							<th>점검결과</th>
						</tr>
					</thead>
					<tbody>
					
					 <c:set var="iSCnt" value="1"/>
					  <c:forEach var="rptScnList" items="${rptFctyMgrTotScnList}" varStatus="status"> 	
						<tr>
							<td class="num">S${iSCnt}</td>
							<td>${rptScnList.ehqkScnPstn}</td>	
							<td>${rptScnList.ehqkScnChlVal}</td>	
							<td>${rptScnList.ehqkScnId}</td>	
							<td>${rptScnList.iptDt}</td>	
							<td>
							<c:if test="${rptScnList.rptFrstYn == 'Y'}">
								<input type="checkbox" name="rptScnFrstYn" title="" value="${rptScnList.rptFrstYn}" checked=checked  disabled>
							</c:if>	
							<c:if test="${rptScnList.rptFrstYn != 'Y'}">
								<input type="checkbox" name="rptScnFrstYn" title="" value="${rptScnList.rptFrstYn}"  disabled>
							</c:if>	
							<label for="">초기</label></td>	
							<td>
							<c:if test="${rptScnList.rptFglrYn == 'Y'}">
								<input type="checkbox" name="rptScnFglrYn" title="" value="${rptScnList.rptFglrYn}"  checked=checked  disabled>
							</c:if>	
							<c:if test="${rptScnList.rptFglrYn != 'Y'}">
								<input type="checkbox" name="rptScnFglrYn" title="" value="${rptScnList.rptFglrYn}"  disabled>
							</c:if>	 
							<label for="">정기</label></td>	
							<td>${rptScnList.rptIptnRslt}</td>	
						</tr> 
						<c:set var="iSCnt" value="${iSCnt+1}"/>
					</c:forEach>	
					</tbody>
				</table>
   
				<br>
				<div class="content_title6"><ul><li>지진가속도기록계</li></ul></div>
				<table class="auth_group display2">
					<caption>지진가속도기록계 목록</caption>
					<thead>
						<tr>
							<th>번호</th>							
							<th>설치위치</th>	
							<th>고유번호</th>	
							<th>계측센서<br>연결상태</th>
							<th>최종점검일</th>
							<th colspan="2">점검내역</th>
							<th>점검결과</th>
						</tr>
					</thead>
					<tbody>
					 <c:set var="iSCnt" value="1"/>
					  <c:forEach var="rptRccList" items="${rptFctyMgrTotRccList}" varStatus="status"> 	
						<tr>
							<td class="num">R${iSCnt}</td>
							<td>${rptRccList.mechPotn}</td>	
							<td>${rptRccList.rccId}</td>	
							<td>${rptRccList.ehqkScnIds}</td>	
							<td>${rptRccList.iptDt}</td>	
						<td>
							<c:if test="${rptRccList.rptFrstYn == 'Y'}">
								<input type="checkbox" name="rptRccFrstYn" title="" value="${rptRccList.rptFrstYn}" checked=checked  disabled>
							</c:if>	
							<c:if test="${rptRccList.rptFrstYn != 'Y'}">
								<input type="checkbox" name="rptRccFrstYn" title="" value="${rptRccList.rptFrstYn}"  disabled>
							</c:if>	
							<label for="">초기</label></td>	
							<td>
							<c:if test="${rptRccList.rptFrstYn == 'Y'}">
								<input type="checkbox" name="rptRccFglrYn" title="" value="${rptRccList.rptFglrYn}"  checked=checked  disabled>
							</c:if>	
							<c:if test="${rptRccList.rptFrstYn != 'Y'}">
								<input type="checkbox" name="rptRccFglrYn" title="" value="${rptRccList.rptFglrYn}"  disabled>
							</c:if>	
							
							<label for="">정기</label></td>	
							<td>${rptRccList.rptIptnRslt}</td>	
						</tr>
					 <c:set var="iSCnt" value="${iSCnt+1}"/>
					 </c:forEach>	
					</tbody>
				</table>
		</div>
		<div id="fctyRight"  class="a_data_right2">
			    <div class="content_title6"><ul><li>지진계측센서</li></ul></div>
        <!--   <div style="height:890px;overflow-y:scroll;"> -->
              <c:set var="iRSCnt" value="1"/>
              <c:if test="${empty rptMgrEhqkScnList}">
                <table class="auth_group display3">
                    <caption>S${iRSCnt}</caption> 
                    <thead>
                        <tr>
                            <th>번호</th>                         
                            <th>S${iRSCnt}</th> 
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="tlt2">지진가속도계 고유번호</td>
                            <td></td> 
                        </tr>
                        <tr>
                            <td class="tlt2">제작사</td>
                            <td></td>   
                        </tr>
                        <tr>
                            <td class="tlt2">모델명</td>
                            <td></td>    
                        </tr>
                        <tr>
                            <td class="tlt2">일련번호</td>
                            <td></td>  
                        </tr>
                        <tr>
                            <td class="tlt2">가속도계분류</td>
                            <td></td>  
                        </tr>
                        <tr>
                            <td class="tlt2">계측용도구분</td>
                            <td></td>  
                        </tr>
                        <tr>
                            <td class="tlt2">설치층수</td>
                            <td></td>   
                        </tr>
                        <tr>
                            <td class="tlt2">계측채널 성분(ZNE)</td>
                            <td></td> 
                        </tr>
                        <tr>
                            <td class="tlt2">기록계 고유번호</td>
                            <td></td>  
                        </tr>
                    </tbody>
                </table> 
              </c:if>
			  <c:forEach var="rptMgrEhqkScnList" items="${rptMgrEhqkScnList}" varStatus="status"> 	
				<table class="auth_group display3">
					<caption>S${iRSCnt}</caption> 
					<thead>
						<tr>
							<th>번호</th>							
							<th>S${iRSCnt}</th>	
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="tlt2">지진가속도계 고유번호</td>
							<td>${rptMgrEhqkScnList.ehqkScnId}</td>	
						</tr>
						<tr>
							<td class="tlt2">제작사</td>
							<td>${rptMgrEhqkScnList.ehqkScnCmpy}</td>	
						</tr>
						<tr>
							<td class="tlt2">모델명</td>
							<td>${rptMgrEhqkScnList.ehqkScnMdl}</td>	
						</tr>
						<tr>
							<td class="tlt2">일련번호</td>
							<td>${rptMgrEhqkScnList.ehqkScnSrlNo}</td>	
						</tr>
						<tr>
							<td class="tlt2">가속도계분류</td>
							<td>${rptMgrEhqkScnList.ehqkScnKndCd}</td>	
						</tr>
						<tr>
							<td class="tlt2">계측용도구분</td>
							<td>${rptMgrEhqkScnList.ehqkScnGbnCd}</td>	
						</tr>
						<tr>
							<td class="tlt2">설치층수</td>
							<td>${rptMgrEhqkScnList.ehqkScnPstn}</td>	
						</tr>
						<tr>
							<td class="tlt2">계측채널 성분(ZNE)</td>
							<td>${rptMgrEhqkScnList.ehqkScnChlVal}</td>	
						</tr>
						<tr>
							<td class="tlt2">기록계 고유번호</td>
							<td>${rptMgrEhqkScnList.conRccId}</td>	
						</tr>
					</tbody>
				</table> 
				<br>
				 <c:set var="iRSCnt" value="${iRSCnt+1}"/>
				</c:forEach>  
				
				<c:set var="iRRCnt" value="1"/>
			   <c:forEach var="rptMgrRccList" items="${rptMgrRccList}" varStatus="status"> 
				<table class="auth_group display3">
					<caption>R${iRRCnt}</caption>
					<thead>
						<tr>
							<th>번호</th>							
							<th>R${iRRCnt}</th>	
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="tlt2">지진가속도계 고유번호</td>
							<td>${rptMgrRccList.rccId}</td>	
						</tr>
						<tr>
							<td class="tlt2">제작사</td>
							<td>${rptMgrRccList.rcCmpy}</td>	
						</tr>
						<tr>
							<td class="tlt2">모델명</td>
							<td>${rptMgrRccList.rccMdl}</td>	
						</tr>
						<tr>
							<td class="tlt2">일련번호</td>
							<td>${rptMgrRccList.rccSrlNo}</td>	
						</tr>
						<tr>
							<td class="tlt2">기록계 품질 보증기간</td>
							<td>${rptMgrRccList.rccWrry}</td>	
						</tr>
						<tr>
							<td class="tlt2">기록저장방식</td>
							<td>${rptMgrRccList.rccWfmt}</td>	
						</tr>
						<tr>
							<td class="tlt2">전송방식</td>
							<td>${rptMgrRccList.rccPotl}</td>	
						</tr>
					</tbody>
				</table>
				<br>
				 <c:set var="iRRCnt" value="${iRRCnt+1}"/>
				</c:forEach> 
	<!-- </div> -->
			</div>
	</div>
<!-- END:컨텐츠 -->	


</BODY>
</HTML>