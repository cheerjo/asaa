<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
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
<%@ page import ="egovframework.com.cmm.LoginVO" %>
 
			<c:if test="${empty fctyImgUrl.fctyImgFlsv}">
				<li><img src="${ctx}/img/etc/no_img.jpg" title="" /></li>
			</c:if>	
			<c:if test="${!empty fctyImgUrl.fctyImgFlsv}">
			 <li><img src="${ctx}${fctyImgUrl.fctyImgFlsv}/${fctyImgUrl.fctyImgFlnm}" width="375" height="185" title="" /></li>
			</c:if>
			<c:if test="${empty fctyAddRsltMgr.fctyNm}"> 
				<li><b>[시설물개요]</b></li>
				<li><b>내진등급 : 특등급 </b>  / <b>지진구역 : I </b>  / <b>건물유형</b>   </li>
	    	<!-- <li><b>PGA :</b> 0g / <b>PGV :</b> 0 / <b>Sa :</b>  0g </li> --> 
			</c:if>	
			<c:if test="${!empty fctyAddRsltMgr.fctyNm}"> 
			    <li><b>[시설물개요] </b>${fctyAddRsltMgr.fctyNm}</li>  
                <li><b>내진등급 :</b> <c:choose><c:when test="${fctyAddRsltMgr.fctyLvcsCd == null}">특등급</c:when><c:otherwise>${fctyAddRsltMgr.fctyLvcsCd}</c:otherwise></c:choose> / <b>지진구역 :</b> <c:choose><c:when test="${fctyAddRsltMgr.ehqkAreaCd == 2}">II</c:when><c:otherwise>I</c:otherwise></c:choose> / <b> ${fctyAddRsltMgr.fctyKndCd}</b></li> 
               <!--  <li><b>PGA :</b>  / <b>PGV :</b>   / <b>Sa :</b>   </li> --> 
			</c:if>
			 
		 