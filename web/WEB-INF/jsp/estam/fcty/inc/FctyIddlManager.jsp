<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
<%
 /**
  * @Class Name :  
  * @Description : 시설물 상세정보.
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
<script type="text/javascript">
$(document).ready(function(){       //도큐먼트 로딩 완료시 
	$('tr[id^=fctycd]').bind('click', function(event){ 
       		fnPageView(this.id);	 
   	});
   	
   	var fnPageView = function(pageFctyCd){
		
		var arrFcty = pageFctyCd.split(':');

		$('#fctyCd').val(arrFcty[1]);
		$('#gvmtCd').val(arrFcty[2]);
		$('#iddlAassNo').val(arrFcty[3]);
 			
		if ($('#iddlAassNo').val().length > 0 ){
		    
 			//fcFctyMgrRight(); 
		}
 	};
});  //read
</script>
          <div style="float:left;width:100%;">
	<div style="float:left;width:49%;margin:0 20px 0 0;">
			<div class="content_title2"><ul><li>시설물정보</li></ul></div>	
				<table class="auth_group display2">
				<caption></caption>										
				<tbody>						
				<tr>
					<td class="tlt">계측소명</td>
					<td colspan="4" class="line_bg">${fctyRsltMgr.fctyNm}&nbsp;</td>
				</tr>
				<tr>
					<td class="tlt">시설물 위치</td>
					<td colspan="4">${fctyRsltMgr.fctyStAddr} ${fctyRsltMgr.fctyEdAddr}&nbsp;</td>																		
				</tr>
						<tr>
					<td class="tlt" rowspan="2">시설물 코드</td>
					<td class="line_bg">기관코드</td>	
					<td class="line_bg">계측소 코드</td>		
					<td class="line_bg">시설물 종류</td>		
					<td class="line_bg">행정구역 코드</td>		
				</tr>
				<tr>
					<td>${fctyRsltMgr.gvmtCd}</td>	
					<td>${fctyRsltMgr.fctyCd}</td>	
					<td>${fctyRsltMgr.fctyKndCd}</td>	
					<td>${fctyRsltMgr.fctyAreaCd}</td>	
				</tr>
				<tr>	
					<td class="tlt" rowspan="2">건물개요</td>
					<td class="line_bg">준공연도</td>	
					<td class="line_bg">증개축연도</td>		
					<td class="line_bg">용도</td>		
					<td class="line_bg">거주등급</td>		
				</tr>
				<tr>
					<td>${fctyAddRsltMgr.fctyCplnDt}</td>	
					<td>&nbsp;</td>	
					<td>${fctyAddRsltMgr.fctyGbnCd}</td>	
					<td>${fctyAddRsltMgr.fctyLvcsCd}</td>	
				</tr>
				<tr>
					<td class="tlt" rowspan="2">규모</td>
					<td class="line_bg">대표층면적()</td>	
					<td class="line_bg">지상층수</td>		
					<td class="line_bg">지붕높이()</td>		
					<td class="line_bg"> </td>		
				</tr>
				<tr>
					<td>${fctyAddRsltMgr.fctyBotArea}</td>	
					<td>&nbsp;</td>	
					<td>${fctyAddRsltMgr.fctyRofHt}</td>	
					<td> </td>	
				</tr>
				<tr>
					<td class="tlt" rowspan="2">구조</td>
					<td class="line_bg" colspan="2">구조형식</td>	
					<td class="line_bg">설계기준</td>
					<td class="line_bg">지진구역</td>		
				</tr>
				<tr>
					<td colspan="2">${fctyAddRsltMgr.fctyStrTycd}</td>	
					<td>${fctyRsltMgr.seisCd}</td>	
					<td>${fctyAddRsltMgr.ehqkAreaCd}</td>	
				</tr>
			</tbody>
			</table>
		</div>

		<div style="float:left;width:49%;">
			<div class="content_title2"><ul><li>지반분류</li></ul></div>	
			<table class="auth_group display2" style="height:270px;">
				<caption></caption>
				<thead>
					<tr>
						<th rowspan="2" colspan="3">지반분류</th>	
						<th colspan="3">상부 30m에 대한 평균 지반 특성</th>
					</tr>
					<tr>
						<td class="line_bg">전단파속도<br/>(m/s)</td>
						<td class="line_bg">표준관입시험<br/>(타격횟수/300mm)</td>
						<td class="line_bg">비배수전단강도<br/>(ⅹ10-3N/mm2)</td>
					</tr>
				</thead>				
				<tbody>									
					<tr>
						<c:if test="${fctyRsltMgr.fctyGrndCd == 'SA'}">
							<td class="num3">●</td>
						</c:if>
						<c:if test="${fctyRsltMgr.fctyGrndCd != 'SA'}">
							<td class="num3">○</td>
						</c:if>
						<td>SA</td>
						<td>경암 지반</td>
						<td>1500 초과</td>
						<td>-</td>
						<td>-</td>
					</tr>
					<tr>
						<c:if test="${fctyRsltMgr.fctyGrndCd == 'SB'}">
							<td class="num3">●</td>
						</c:if>
						<c:if test="${fctyRsltMgr.fctyGrndCd != 'SB'}">
							<td class="num3">○</td>
						</c:if>
						<td>SB</td>
						<td>보통암 지반</td>
						<td>760~1500</td>
						<td>>50</td>
						<td>>100</td>
					</tr>
					<tr>
						<c:if test="${fctyRsltMgr.fctyGrndCd == 'SC'}">
							<td class="num3">●</td>
						</c:if>
						<c:if test="${fctyRsltMgr.fctyGrndCd != 'SC'}">
							<td class="num3">○</td>
						</c:if>
						<td>SC</td>
						<td>연암지반</td>
						<td>360~760</td>
						<td>>50</td>
						<td>>100</td>
					</tr>
					<tr>
						<c:if test="${fctyRsltMgr.fctyGrndCd == 'SD'}">
							<td class="num3">●</td>
						</c:if>
						<c:if test="${fctyRsltMgr.fctyGrndCd != 'SD'}">
							<td class="num3">○</td>
						</c:if>
						<td>SD</td>
						<td>단단한 토사지반</td>
						<td>180~360</td>
						<td>15~50</td>
						<td>50~100</td>
					</tr>
					<tr>
						<c:if test="${fctyRsltMgr.fctyGrndCd == 'SE'}">
							<td class="num3">●</td>
						</c:if>
						<c:if test="${fctyRsltMgr.fctyGrndCd != 'SE'}">
							<td class="num3">○</td>
						</c:if>
						<td>SE</td>
						<td>연약한 토사지반</td>
						<td>180미만</td>
						<td><15</td>
						<td><50</td>
					</tr>
				</tbody>
			</table>
		</div>
		<br class="clear">
	</div>	
	<br class="clear"/>

	<br/>
	<div class="content_title2"><ul><li>시설물 구조 및 이미지</li></ul></div>
	<div style="width:100%;height:570px;background-color: #fff;">				
	 	<td>
	 		<!-- 시설물 구조 및 이미지가 확보된 후 아래 주석을 풀어주시기 바랍니다 -->
	 		<!--  <img src="<c:url value='${fctyHolcImg.fctyHolcMapSvch}${fctyHolcImg.fctyHolcMap}'/>"/> --> 
	 		<img width="570px" border="1" src="<c:url value='/up_file/AC/SL/AC_SL_20131125.png'/>"/>	 	
	 	</td>
	</div>

	<br class="clear"/>
	<br/>
