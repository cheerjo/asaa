<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
<%
 /**
  * @Class Name :  
  * @Description : 시설물 상세정보 - 가속도 그래프.
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
<%@ page import ="egovframework.com.cmm.LoginVO" %>

             <div style="float:left;width:100%;">
					<div style="float:left;width:68%;margin:0 20px 0 0;">
						<div class="content_title2"><ul><li>계측 최대값</li></ul></div>	
						<table class="auth_group display2">
							<caption></caption>
							<thead>
								<tr>
									<th colspan="4">자유장</th>	
									<th colspan="4">시설물중간층</th>
								</tr>
							</thead>				
							<tbody>
								<tr>
									<td class="num3">계측방향</td>
									<td class="line_bg">가속도(gal)</td>
									<td class="line_bg">속도(mm/sec)</td>
									<td class="line_bg">변위(mm)</td>
									<td class="num3">계측방향</td>
									<td class="line_bg">가속도(gal)</td>
									<td class="line_bg">속도(mm/sec)</td>
									<td class="line_bg">변위(mm)</td>
								</tr>
								<tr>
									<td class="num3">동서(E-W)</td>
									<!--<td>${readIddlAssRlst.dataFreeAccX}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataFreeAccX}&nbsp;</td>
									<td>${readIddlAssRlst.dataFreeAccSpedX}&nbsp;</td>
									<!--<td>${readIddlAssRlst.dataFreeMaxDispX}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataFreeAccDispX}&nbsp;</td>
									<td class="num3">동서(E-W)</td>
									<!--<td>${readIddlAssRlst.dataStrMidAccX}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataStrMidAccX}&nbsp;</td>
									<td>${readIddlAssRlst.dataStrMidSpedX}&nbsp;</td>
									<td>${readIddlAssRlst.dataStrMidDispX}&nbsp;</td>
								</tr>
								<tr>
									<td class="num3">남북(N-S)</td>
									<!--<td>${readIddlAssRlst.dataFreeAccY}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataFreeAccY}&nbsp;</td>
									<td>${readIddlAssRlst.dataFreeAccSpedY}&nbsp;</td>
									<!--<td>${readIddlAssRlst.dataFreeMaxDispY}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataFreeAccDispY}&nbsp;</td>
									<td class="num3">남북(N-S)</td>
									<!--<td>${readIddlAssRlst.dataStrMidAccY1}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataStrMidAccY1}&nbsp;</td>
									<td>${readIddlAssRlst.dataStrMidSpedY}&nbsp;</td>
									<td>${readIddlAssRlst.dataStrMidDispY}&nbsp;</td>
								</tr>
								<tr>
									<td class="num3" style="width:80px">수평성분합성(H)</td>
									<td>${readIddlAssRlst.dataFreeAccHorz}&nbsp;</td>
									<td>${readIddlAssRlst.dataFreeAccSpedHorz}&nbsp;</td>
									<td>${readIddlAssRlst.dataFreeAccDispHorz}&nbsp;</td>
									<td colspan="4"></td>
								</tr>
								<tr>
									<td class="num3">연직(V)</td>
									<!--<td>${readIddlAssRlst.dataFreeAccZ}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataFreeAccZ}&nbsp;</td>
									<td>${readIddlAssRlst.dataFreeAccSpedZ}&nbsp;</td>
									<td>${readIddlAssRlst.dataFreeAccDispZ}&nbsp;</td>
									<td colspan="4"></td>
								</tr>
							</tbody>
						</table> 
						<br >
						<table class="auth_group display2">
							<caption></caption>
							<thead>
								<tr>
									<th colspan="4">시설물최상층</th>	
									<th colspan="4">시설물최하층</th>
								</tr>
							</thead>				
							<tbody>
								<tr>
									<td class="num3">계측방향</td>
									<td class="line_bg">가속도(gal)</td>
									<td class="line_bg">속도(mm/sec)</td>
									<td class="line_bg">변위(mm)</td>
									<td class="num3">계측방향</td>
									<td class="line_bg">가속도(gal)</td>
									<td class="line_bg">속도(mm/sec)</td>
									<td class="line_bg">변위(mm)</td>
								</tr>
								<tr>
									<td class="num3">동서(E-W)</td>
									<!--<td>${readIddlAssRlst.dataStrTopAccX}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataStrTopAccX}&nbsp;</td>
									<!--<td>${readIddlAssRlst.dataTopRelMaxSpedX}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataStrTopSpedX}&nbsp;</td>
									<!--<td>${readIddlAssRlst.dataTopRelMaxDispX}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataStrTopDispX}&nbsp;</td>
									<td class="num3">동서(E-W)</td>
									<!--<td>${readIddlAssRlst.dataStrBotAccX}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataStrBotAccX}&nbsp;</td>
									<td>${readIddlAssRlst.dataStrBotSpedX}&nbsp;</td>
									<td>${readIddlAssRlst.dataStrBotDispX}&nbsp;</td>
								</tr>
								<tr>
									<td class="num3">남북(N-S)</td>
									<!--<td>${readIddlAssRlst.dataStrTopAccY1}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataStrTopAccY1}&nbsp;</td>
									<!--<td>${readIddlAssRlst.dataTopRelMaxSpedY}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataStrTopSpedY}&nbsp;</td>
									<!--<td>${readIddlAssRlst.dataTopRelMaxDispY}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataStrTopDispY}&nbsp;</td>
									<td class="num3">남북(N-S)</td>
									<!--<td>${readIddlAssRlst.dataStrBotAccY}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataStrBotAccY}&nbsp;</td>
									<td>${readIddlAssRlst.dataStrBotSpedY}&nbsp;</td>
									<td>${readIddlAssRlst.dataStrBotDispY}&nbsp;</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div style="float:left;width:30%;">
						<div class="content_title2"><ul><li>설계지반가속도 초과율</li></ul></div>	
						<table class="auth_group display2" style="height:132px;">
							<caption></caption>					
							<tbody>
								<tr>
									<td class="line_bg"> 설계지반가속도(gal)</td>
									<td class="line_bg"> 최대지반가속도(gal)</td>
									<td class="line_bg"> 초과율(%)</td>
								</tr>
								<tr>
									<td>${readIddlAssRlst.rsltOvrAccVal}&nbsp;</td>
									<!--<td>${readIddlAssRlst.dataFreeAccX}&nbsp;</td>-->
									<td>&nbsp;</td>
									<!--<td>${readIddlAssRlst.rsltOvrAccX}&nbsp;</td>-->
									<td>${readIddlAssRlst.rsltOvrAccX}&nbsp;</td>
								</tr>
							</tbody>
						</table>
						<br>
						<div class="content_title2"><ul><li>고유주기(초)</li></ul></div>
						<table class="auth_group display2" style="height:112px;">
							<caption></caption>					
							<tbody>
								<tr>
									<td class="line_bg"> 자유장</td>
									<td class="line_bg"> 시설물(E-W)</td>
									<td class="line_bg"> 시설물(N-S)</td>
								</tr>
								<tr>
									<!--<td>${readIddlAssRlst.dataFreeFrq}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataFreeFrq}&nbsp;</td>
									<!--<td>${readIddlAssRlst.dataStrFrqX}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataStrFrqX}&nbsp;</td>
									<!--<td>${readIddlAssRlst.dataStrFrqY}&nbsp;</td>-->
									<td>${readIddlAssRlst.dataStrFrqX}&nbsp;</td>
								</tr>
							</tbody>
						</table>
					</div>
					<br class="clear"/>
				</div>
					<br class="clear"/>
					<br/>
               