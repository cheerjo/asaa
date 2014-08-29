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
 		<div class="content_title2"><ul><li>센서점검항목</li></ul></div>
				<div style="height:890px;overflow-y:scroll;">
				<table class="auth_group display3">
					<caption></caption>
					<thead>
						<tr>
							<th>자유장지진가속도계</th>							
							<th colspan="2">S1</th>	
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="tlt2">지진가속도계 고유번호</td>
							<td colspan="2">${rptFrstFree.freScnId}</td>	
						</tr>						
						<tr>
							<td class="tlt2">가속도계 성분</td>
							<td>연직 1성분, 수평  2성분</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstFree.freeQst1Yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstFree.freeQst1Yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td class="tlt2" rowspan="2">주파수 영역</td>
							<td>주파수 영역1</td>
							<td>
                                <input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstFree.freeQst21yn == 'Y'}">checked</c:if> ><label for="">적합</label>
                                <input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstFree.freeQst21yn == 'N'}">checked</c:if> ><label for="">부적합</label>

							</td>	
						</tr>
						<tr>
							<td>주파수 영역2</td>
							<td>
                                <input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstFree.freeQst22yn == 'Y'}">checked</c:if> ><label for="">적합</label>
                                <input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstFree.freeQst22yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td class="tlt2" rowspan="2">동적범위</td>
							<td>기존설치</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstFree.freeQst31yn == 'Y'}">checked</c:if>><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstFree.freeQst31yn == 'N'}">checked</c:if>><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td>신규설치</td>
							<td>
                                <input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstFree.freeQst32yn == 'Y'}">checked</c:if> ><label for="">적합</label>
                                <input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstFree.freeQst32yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
					</tbody>
				</table>

				<br/>
				<c:set var="rptFrstScnListCnt" value="1"/>
				<c:forEach var="rptFrstScnList" items="${rptFrstScnList}" varStatus="status">     
				<table class="auth_group display3">
					<caption></caption>
					<thead>
						<tr>
							<th>시설물지진가속도계 ${rptFrstScnListCnt}</th>							
							<th colspan="2">S2</th>	
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="tlt2">지진가속도계 고유번호</td>
							<td colspan="2">${rptFrstScnList.ehqkScnId}</td>	
						</tr>						
						<tr>
							<td class="tlt2" rowspan="3">가속도계 성분</td>
							<td>수평 1성분</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst11yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst11yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td>수평 2성분</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst12yn == 'Y'}">checked</c:if>><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst12yn == 'N'}">checked</c:if>><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td>연직 1성분, 수평  2성분</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst13yn == 'Y'}">checked</c:if>><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst13yn == 'N'}">checked</c:if>><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td class="tlt2" rowspan="2">주파수 영역</td>
							<td>주파수 영역1</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst21yn == 'Y'}">checked</c:if>><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst21yn == 'N'}">checked</c:if>><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td>주파수 영역2</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst22yn == 'Y'}">checked</c:if>><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst22yn == 'N'}">checked</c:if>><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td class="tlt2" rowspan="2">동적범위</td>
							<td>기존설치</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst31yn == 'Y'}">checked</c:if>><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst31yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td>신규설치</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst32yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstScnList.scnQst32yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
					</tbody>
				</table>
				<br/>
				<c:set var="rptFrstScnListCnt" value="${rptFrstScnListCnt+1}"/>
				</c:forEach>
				
				<c:set var="rptFrstRccListCnt" value="1"/>
                <c:forEach var="rptFrstRccList" items="${rptFrstRccList}" varStatus="status">    
				<table class="auth_group display3">
					<caption></caption>
					<thead>
						<tr>
							<th>기록계 ${rptFrstRccListCnt}</th>							
							<th colspan="2">R1</th>	
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="tlt2" rowspan="2">동적범위</td>
							<td>기존설치</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst11yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst11yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td>신규설치</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst12yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst12yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>

						<tr>
							<td class="tlt2" rowspan="2">채널수</td>
							<td>자유장 용</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst21yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst21yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td>시설물 용</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst22yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst22yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>

						<tr>
							<td class="tlt2" rowspan="2">트리거 방법</td>
							<td>STA/LTA 또는 threshold 이용</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst31yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst31yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td>트리거수준 변경기능 확인</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst32yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst32yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>

						<tr>
							<td class="tlt2" rowspan="3">자료취득횟수</td>
							<td>100회/초</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst41yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst41yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td>20회/초</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst42yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst42yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td>MMA/S</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst43yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst43yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>

						<tr>
							<td class="tlt2" rowspan="3">기록형식 및 저장</td>
							<td>100회/초</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst51yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst51yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td>20회/초</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst52yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst52yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td>MMA/S</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst53yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst53yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>

						<tr>
							<td class="tlt2" rowspan="2">자료기록</td>
							<td>트리거 전 30초</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst61yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst61yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td>트리거 후 60초</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst62yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst62yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>

						<tr>
							<td class="tlt2">최대시각 오차</td>
							<td>0.005초 이내</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst7Yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst7Yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>
						<tr>
							<td class="tlt2">자료전송방법</td>
							<td>TCP/IP 통신</td>
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst8Yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstRccList.rccQst8Yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>	
						</tr>						
					</tbody>
				</table>			
                <c:set var="rptFrstRccListCnt" value="${rptFrstRccListCnt+1}"/>
                </c:forEach>
				</div>