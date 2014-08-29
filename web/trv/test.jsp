<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<title>지진가속도 응답신호 종합분석 시스템</title>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석 시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=7, IE=9, IE=10">
<meta name="viewport" content="initial-scale=1, maximum-scale=1,user-scalable=no">
 
<script type="text/javascript" src="<c:url value='/'/>js/jquery/jquery-1.9.0.js"></script> 
<script type="text/javascript">
    
    
 /**   var form = {
  	      id: "123",
  	      name: "123",
  	      testTags: [{id: "1111", tag: "2222"}]
  	  };
    
     
  	  $.ajax({
  	      url: "/main/test.do",
  	      method: "GET",
  	      type: "json",
  	      contentType: "application/json",
  	      data: JSON.stringify(form),
  	      success: function(data) {
  	         $("#dvvv").append(data);
  	      }
  	  });   */
  	  
  	 var form = {
  			GVMT: "SL" 
    	     };
  		
  	 
  		  $.ajax({
  	  	      url: "${pageContext.request.contextPath}/flot/WaveFormJson.do",
  	  	      method: "POST",
  	  	      type: "json",
  	  	      contentType: "application/json",
  	  	      data: JSON.stringify(form),
  	  	      success: function(data) {
  	  	    	 $("#dvvv").append(data); 
  	  	    	//data.push(data.totpga);  
  	  	      }
  	  	  });  
  			
</script>
</head>

<BODY>
 <div id="dvvv"></div>
</BODY>
</HTML>
