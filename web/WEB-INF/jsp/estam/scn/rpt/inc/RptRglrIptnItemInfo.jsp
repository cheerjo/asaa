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
				<div class="content_title2"><ul><li>정기점검항목</li></ul>
				<p>점검일자 : ${rptRglrIptn.iptDt}</p>
				</div>
				<table class="auth_group display2">
					<caption></caption>
					<thead>
						<tr>
							<th colspan="2">항목</th>	
							<th>내용</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="num3" rowspan="4">설치<br>상태</td>
							<td class="txt_left">지반 또는 시설물의 바닥에 견고히 고정</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst11yn == 'Y'}">checked</c:if> ><label for="">적합</label> 
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst11yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="line_bg txt_left">기후변화, 전자기 및 낙뢰 영향방지 등의 보호장치 작동 여부</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst12yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst12yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">자유장 지진가속도계의 수평방향이 동서방향과 남북방향 유지 여부</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst13yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst13yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="line_bg txt_left">모든 지진가속도계의 동일한 좌표축 유지 여부</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst14yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst14yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="num3" rowspan="4">전원부</td>
							<td class="line_bg txt_left">지진가속도 계측기 접지 여부</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst21yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst21yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">외부입력 전기/전화선에 서지보호장치(surge protector) 작동 여부</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst22yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst22yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="line_bg txt_left">연결상태 및 전원공급 정상 상태 확인</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst23yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst23yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">비상전원공급장치 작동 여부</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst24yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst24yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>

						<tr>
							<td class="num3" rowspan="2">가속도계<br>기록계</td>
							<td class="line_bg txt_left">연결부와 고리부분 등 외관의 피해 및 손상 여부 확인</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst31yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst31yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">구성품 손/망실여부 확인</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst32yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst32yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="num3" rowspan="3">현장<br>점검</td>
							<td class="line_bg txt_left">지진가속도계 및 기록계 설치 장소 이상 유무</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst41yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst41yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">전원장치 이상유무 확인</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst42yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst42yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
                        <tr>
                            <td class="txt_left">통신선 이상유무 확인</td>  
                            <td>
                                <input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst43yn == 'Y'}">checked</c:if> ><label for="">적합</label>
                                <input type="checkbox" name="" title="" value="" disabled <c:if test="${rptRglrIptn.rglrQst43yn == 'N'}">checked</c:if> ><label for="">부적합</label>
                            </td>
                        </tr>						
 
						<tr>
							<td class="num3">점검<br>결과</td>
							<td class="line_bg" colspan="3">${rptRglrIptn.rglrRsltCtnt}<br>부적합 사항 조치내용 및 조치계획 (256byte)</td>
						</tr>

						<tr>
							<td class="num3">처리<br>결과</td>
							<td colspan="3">${rptRglrIptn.rglrMngeCtnt}</td>
						</tr>
					</tbody>
				</table>
				<table class="auth_group display2">
					<caption></caption>
					<thead>
						<tr>
							<th>담당부서</th>	
							<th>직책</th>
							<th>담당자 이름</th>	
							<th>담당자 연락처</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${rptRglrIptn.rglrUsrDept}</td>
							<td>${rptRglrIptn.rglrUsrDuty}</td>
							<td>${rptRglrIptn.rglrUsrNm}</td>
							<td>${rptRglrIptn.rglrUsrTel}</td>
						</tr>
					</tbody>
				</table>				
 
				 