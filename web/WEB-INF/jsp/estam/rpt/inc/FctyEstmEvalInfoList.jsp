<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
<%
 /**
  * @Class Name :  
  * @Description : 시설물 상세정보 - 속도 그래프.
  * @Modification Information
  * 
  * @author atres
  * @since 2013.12.07
  * @version 1.0
  * @see
  *  
  * Copyright (C) All right reserved.
  */
%>
<%@ page import ="egovframework.com.cmm.LoginVO" %>
    <c:choose>
	    <c:when test="${empty ehqkOcurInfoList}">
	       <tr><td colspan="4" align="center">자료가 존재하지 않습니다.</td></tr>
	    </c:when>
    <c:otherwise>
		<c:forEach var="ehqkOcurInfoList" items="${ehqkOcurInfoList}" varStatus="status">
		    <tr onmouseover="this.style.backgroundColor='#f7f9db'" onmouseout="this.style.backgroundColor='#fff'"
		    	onClick="ehqkOcurInfoList('fctycdInfo:${ehqkOcurInfoList.fctyCd}:${ehqkOcurInfoList.gvmtCd}:${ehqkOcurInfoList.iddlAassNo}:${ehqkOcurInfoList.ehqkReqId}');"
		    	id="${ehqkOcurInfoList.fctyCd}_${ehqkOcurInfoList.gvmtCd}_${ehqkOcurInfoList.iddlAassNo}"
		    	 style="cursor:pointer;">
		        <td>${ehqkOcurInfoList.iddlAassDt}</td>
		        <td>${ehqkOcurInfoList.ehqkScal}</td> 
		        <td>${ehqkOcurInfoList.ehqkOrgArea}</td>
		        <td>${ehqkOcurInfoList.ehqkSttm}</td>
		    </tr>  
		</c:forEach>
	</c:otherwise>
    </c:choose>		