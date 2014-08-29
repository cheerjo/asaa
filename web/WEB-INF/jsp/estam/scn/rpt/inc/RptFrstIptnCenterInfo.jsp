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
					<caption></caption>
					<thead>
						<tr>
							<th>관리항목</th>							
							<th colspan="5">내용</th>									
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="tlt">점검일자</td>
							<td colspan="5">${rptFirstIptn.iptDt}</td>																		
						</tr>	
						<tr>
							<td class="tlt">기관코드</td>
							<td colspan="5" class="line_bg">${rptFirstIptn.fctyCd}</td>																		
						</tr>
						<tr>
							<td class="tlt">계측소코드</td>
							<td colspan="5">${rptFirstIptn.gvmtCd}</td>																		
						</tr>
					</tbody>
				</table>
				<br>
				
				<div>
					<div style="float:left;width:40%;margin:0 30px 0 0;">
						<table class="auth_group display2">
							<caption>기록계 목록</caption>					
							<tbody>
								<tr>
									<td class="tlt">시설물 지진가속도계 개수</td>
									<td>${rptFirstIptn.ehqkScnCnt}개</td>																		
								</tr>	
							</tbody>
						</table>
					</div>
					<div style="float:left;width:40%;">
						<table class="auth_group display2">
							<caption>기록계 목록</caption>					
							<tbody>
								<tr>
									<td class="tlt">기록계 개수</td>
									<td>${rptFirstIptn.rccCnt}개</td>																		
								</tr>	
							</tbody>
						</table>
					</div>
					<br class="clear">
				</div>
				
				<br>
				<div class="content_title2"><ul><li>기본점검항목</li></ul></div>
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
							<td class="num3" rowspan="7">지진<br>가속도계<br>설치위치</td>
							<td class="txt_left">기록의 회수, 점검 및 교체가 용이하여 접근성이 좋을 것</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst91yn == 'Y'}">checked</c:if> ><label for="">적합</label> 
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst91yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr> 
						<tr>
							<td class="line_bg txt_left">지진발생시 낙하물에 의한 손상 우려가 없는 안전한 장소</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst92yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst92yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">실외에 설치되었을 경우 계측기의 정상 작동 온도 범위 유지</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst93yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst93yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="line_bg txt_left">실내에 설치되었을 경우 진동이 크게 발생하는 지역 회피</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst94yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst94yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">방폭 지역 및 강한 전자장 발생지역 회피</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst95yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst95yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="line_bg txt_left">큰 전류가 발생하는 장소의 경우 실드케이블 사용</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst96yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst96yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">주변 시설물들과의 상호작용에 의한 영향이 없어야 함</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst97yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst97yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>			
						</tr>

						<tr>
							<td class="num3" rowspan="4">설치<br>상태</td>
							<td class="line_bg txt_left">지반 또는 시설물의 바닥에 견고히 고정</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst101yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst101yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">기후변화, 전자기 및 낙뢰 영향 방지 등의 보호장치</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst102yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst102yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="line_bg txt_left">자유장 지진가속도계의 수평방향은 동서 방향과 남북 방향이 되도록 설치</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst103yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst103yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">모든 시설물 지진가속도계가 동일한 좌표축을 유지</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst104yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst104yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>

						<tr>
							<td class="num3" rowspan="4">전원부</td>
							<td class="line_bg txt_left">접지 루프가 형성되지 않도록 지진가속도계측기를 접지</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst111yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst111yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">외부입력 전선에 서지보호장치(surge protector) 설치</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst112yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst112yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="line_bg txt_left">연결상태 및 전원공급 정상 상태 확인</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst113yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst113yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">비상전원공급장치 설치</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst114yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst114yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>

						<tr>
							<td class="num3" rowspan="2">계측<br>데이터</td>
							<td class="line_bg txt_left">소방방재청의 지진가속도계측자료 통합관리시스템과 연계구동</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst121yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst121yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">소방방재청의 지진가속도계측자료 통합관리시스템의 데이터베이스에 정상적으로 등록</td>	
							<td>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst122yn == 'Y'}">checked</c:if> ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" disabled <c:if test="${rptFrstItemIptn.itemQst122yn == 'N'}">checked</c:if> ><label for="">부적합</label>
							</td>
						</tr>

						<tr>
							<td class="num3">점검<br>결과</td>
							<td class="line_bg" colspan="3">${rptFirstIptn.frstIptnRsltCtnt}<br>부적합 사항 조치내용 및 조치계획 (256byte)</td>
						</tr>

						<tr>
							<td class="num3">처리<br>결과</td>
							<td colspan="3">${rptFirstIptn.frstIptnMngeCtnt}</td>
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
							<td>${rptFirstIptn.frstIptnUsrDept}</td>
							<td>${rptFirstIptn.frstIptnUsrDuty}</td>
							<td>${rptFirstIptn.frstIptnUsrNm}</td>
							<td>${rptFirstIptn.frstIptnUsrTel}</td>
						</tr>
					</tbody>
				</table>	