<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
<%
 /**
  * @Class Name :  
  * @Description : 최근 분석결과 목록.
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
	
	function fcFctyMgrRight() { 
		 $.ajax({
		     type : "POST" //"POST", "GET"
		     , async : false //true, false
		     , url : "${ctx}/fcty/FctyIddlManager.do" //Request URL
		     , dataType : "html" //전송받을 데이터의 타입
		                                //"xml", "html", "script", "json" 등 지정 가능
		                                //미지정시 자동 판단
		     //, timeout : 30000 //제한시간 지정
		     , cache : false  //true, false
		     , data : $("#inputForm").serialize() //서버에 보낼 파라메터
		                      //form에 serialize() 실행시 a=b&c=d 형태로 생성되며 한글은 UTF-8 방식으로 인코딩
		                      //"a=b&c=d" 문자열로 직접 입력 가능
		                      //{a:b, c:d} json 형식 입력 가능
		     , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
		     , error : function(request, status, error) {
		      //통신 에러 발생시 처리
		      alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
		     }
		     , success : function(response, status, request) {
		      //통신 성공시 처리 
		      $('#fctyRight').html(response);   
		     }
		    // , beforeSend: function() {
		      //통신을 시작할때 처리
		     // $('#ajax_indicator').show().fadeIn('fast');
		    // }
		    // , complete: function() {
		      //통신이 완료된 후 처리
		   //   $('#ajax_indicator').fadeOut();
		    // }
		 });
	}
	
	var fncRightPageLink = function(pageID){
		 // if(!!pageID) {
			 $("#RightGraphLink").empty();   //서브데이터를 삭제   			
			  
		   	 $.ajax({
			     type : "POST" //"POST", "GET"
			     , async : false //true, false
			     , url : "${ctx}/EgovPageLink.do?link=" + pageID//Request URL
			     , dataType : "html"        //전송받을 데이터의 타입
			                                //"xml", "html", "script", "json" 등 지정 가능
			                                //미지정시 자동 판단
			     //, timeout : 30000 //제한시간 지정
			     , cache : false  //true, false
			     //, data : $("#inputForm").serialize() //서버에 보낼 파라메터
			                      //form에 serialize() 실행시 a=b&c=d 형태로 생성되며 한글은 UTF-8 방식으로 인코딩
			                      //"a=b&c=d" 문자열로 직접 입력 가능
			                      //{a:b, c:d} json 형식 입력 가능
			     , contentType: "application/x-www-form-urlencoded; charset=UTF-8"	    			     
			     , error : function(request, status, error) {  //통신 에러 발생시 처리    			    	 
			         alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
			       }
			     , success : function(response, status, request) {
			      //통신 성공시 처리 
			      $('#RightGraphLink').html(response);   
			     } 
			 });
			  
		 // }
			 
	};
	/*$('tr[id^=lbfctycd]').bind('click', function(event){ 
       		fnPageView(this.id);	 
   	});
   	
   	var fnPageView = function(pageFctyCd){
		
		var arrFcty = pageFctyCd.split(':');

		$('#fctyCd').val(arrFcty[1]);
		$('#gvmtCd').val(arrFcty[2]);
		$('#iddlAassNo').val(arrFcty[3]);
 			
		if ($('#iddlAassNo').val().length > 0 ){
		//	alert($('#gvmtCd').val() );
	    //		alert($('#iddlAassNo').val() );
		    
 			fcFctyMgrRight(); 
 			fncRightPageLink();
		}
 	}; */
});  //read
</script>
<table class="auth_group display3" style="background-color: #fff;font-size:11px;">
	<caption></caption>
	<thead>
		<tr>
			<th>날짜</th>							
			<th>행정구역</th>	
			<th>점검필요</th>
			<th>안전</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty fctyIddlAassList}">
				<tr><td colspan="4" align="center">자료가 존재하지 않습니다.</td></tr>
		    </c:when>
	    	<c:otherwise>
				<c:forEach var="fctyIddlAassList" items="${fctyIddlAassList}" varStatus="status"> 	
					<tr id="lbfctycd:${fctyIddlAassList.fctyCd}:${fctyIddlAassList.gvmtCd}:${fctyIddlAassList.iddlAassNo}">
						<td class="num2">${fctyIddlAassList.iddlAassDt}</td>
						<td class="num2">${fctyIddlAassList.ehqkOrgArea}</td>
						<td class="num2">${fctyIddlAassList.nokPcnt}%</td>	
						<td class="num2">${fctyIddlAassList.okPcnt}%</td>
					</tr>
					<c:set var="iCnt" value="${iCnt+1}"/>
					<c:if  test="${fctyIddlAassICnt == 0}"> 
					  	<tr>
							<td class="num2"> </td>
							<td class="num2"> </td>
							<td class="num2"> </td>
							<td class="num2"> </td>
						</tr>
					</c:if> 
				 </c:forEach>
			</c:otherwise>
		</c:choose> 	
	</tbody>
</table>