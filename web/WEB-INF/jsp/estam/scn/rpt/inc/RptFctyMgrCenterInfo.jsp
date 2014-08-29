<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  

<%@ page import ="egovframework.com.cmm.LoginVO" %>
<%
 /**
  * @Class Name : ScnRccManager.jsp
  * @Description : 계측기관리대장 화면 
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
  
	<div class="content_title2"><ul><li>기본정보</li></ul></div>		
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
				<div class="content_title2"><ul><li>지진가속도계</li></ul></div>
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
				<div class="content_title2"><ul><li>지진가속도기록계</li></ul></div>
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
    <!-- 
				<div style="width:350px;">
					<table class="auth_group display2">
					<caption>지진가속도기록계 목록</caption>
					<thead>
						<tr>
							<th>자유장</th>							
							<th>최하층</th>	
							<th colspan="2">최상층</th>	
							<th colspan="2">중간층</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" name="" title="" value="" ><label for="">3축</label></td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">3축</label></td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">2축</label></td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">1축</label></td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">2축</label></td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">1축</label></td>		
						</tr>
					</tbody>
				</table>
				</div>
				-->