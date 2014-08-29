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
				<li><img src="${ctx}${fctyImgUrl.fctyImgFlsv}/${fctyImgUrl.fctyImgFlnm}" title="" /></li>
			</c:if>
			
			 
		 