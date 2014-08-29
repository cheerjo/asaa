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
  <div class="content_title2"><ul><li>지진계측센서</li></ul></div>
           <div style="height:890px;overflow-y:scroll;">
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
							<td class="tlt2">기록계 고유번호</td>
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
	 </div>