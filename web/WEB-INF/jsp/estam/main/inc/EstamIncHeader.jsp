<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
<%@ page import ="egovframework.com.cmm.LoginVO" %>    

<script type="text/javascript">
    /* function getLastLink(menuNo){
        var tNode = new Array;
        for (var i = 0; i < document.menuListForm.tmp_menuNm.length; i++) {
            tNode[i] = document.menuListForm.tmp_menuNm[i].value;
            var nValue = tNode[i].split("|");
            //선택된 메뉴(menuNo)의 하위 메뉴중 첫번재 메뉴의 링크정보를 리턴한다.
            if (nValue[1]==menuNo) {
                if(nValue[5]!="dir" && nValue[5]!="" && nValue[5]!="/"){
                    //링크정보가 있으면 링크정보를 리턴한다.
                    return nValue[5];
                }else{
                    //링크정보가 없으면 하위 메뉴중 첫번째 메뉴의 링크정보를 리턴한다.
                    return getLastLink(nValue[0]);
                }
            }
        }
    } */
    function goMenuPage(menuNo,linkUrl){
		
    	
        document.getElementById("menuNo").value=menuNo;
        document.getElementById("maplink").value="redirect:" +linkUrl;   //"forward:"+getLastLink(menuNo);
        
        var frm = document.getElementById("mapLeftForm");
        //alert(document.getElementById("menuNo").value);
        frm.action = "<c:url value='/EgovPageLink.do'/>";
        //document.selectOne.action = "<c:url value='/sym/mms/EgovMainMenuLeft.do'/>";
        //document.selectOne.target = "main_left";
        //document.selectOne.submit();
        //document.selectOne.action = "<c:url value='/sym/mms/EgovMainMenuRight.do'/>";
        //document.selectOne.target = "main_right";
        frm.submit();
    }
   /* function actionLogout()
    {
        document.selectOne.action = "<c:url value='/uat/uia/actionLogout.do'/>";
        //document.selectOne.target = "_top";
        document.selectOne.submit();
        //top.document.location.href = "<c:url value='/j_spring_security_logout'/>";
    } */
$(document).ready(function () {   
	
    function fctyEvntChk() {
  	  
    	   var fctyForm = {
    				  		flag:'PGA'
    				      };   
    	   
    	  	$.ajax({
    	  	      url: "${ctx}/evnt/FctyStatScnGal.do",
    	  	   	  dataType: 'json',
    	          type : 'POST',
    	          contentType: "application/json; charset=UTF-8",
    	          async: false, 
    	  	      data:  JSON.stringify(fctyForm) ,
    	  	      success: function(data) { 
    	  	    	//  alert(data);
    	  	    	var pData = JSON.parse(data); 
    	  	    	if (pData.chkEvnt == "EVENT") {
    	  	    		
    	  	    	} else {
	    	  	    	if (pData.chkEvnt == "SCNPGA") {
			    				alert("이상진동이 감지되었습니다.");
			    		}
    	  	    	}
    	  	      }
    	  	  }); 
       } 

	function execfctyEvntChk() {
		fctyEvntChk();
		//setTimeout(execfctyEvntChk, 5000);
	}

	execfctyEvntChk();
	
});
</script>
<form name="mapLeftForm" id="mapLeftForm"  method="post">
    <input type="hidden" id="menuNo" name="menuNo" value=""/> 
	<input type="hidden" id="flag" name="flag" value="" />
	<input type="hidden" id="maplink" name="vlink" value="" />	
</form>		
	<div id="wrap"> 
		<div id="top_menu">
			<div class="btn_logo">
				<a href="<c:url value='/main/MainPage.do'/>"><img src="${ctx}/img/common/logo.png" title="홈으로"/></a>
			</div> 
			<div class="member_info">
				<%
		           LoginVO loginVO = (LoginVO)session.getAttribute("loginVO"); 
		           if(loginVO == null){ 
		        %>
				<ul>
				   <li class="txt"><b>GUEST 님</b> 반갑습니다.111111</li> 
		           <li>
		           <a href="<c:url value='/login/EstamLogin.do'/>"><img src="${ctx}/img/common/btn_login.png" title="로그인"/></a>
		           </li>
		        </ul>
		        <% }else{ %>
		        <c:set var="loginName" value="<%= loginVO.getUserNm()%>"/>
		        <ul>
		            <li class="txt"><b>국립재난안전연구원 &nbsp;<c:out value="${loginName}"/> 님</b> 반갑습니다.</li> 
		            <li><a href="<c:url value='/login/actionLogout.do'/>"><img src="${ctx}/img/common/btn_logout.png" title="로그아웃"/></a> 
		            </li>
		        </ul>        
		        <% } %>  
			</div>  
			<div id="header">  
						<div id="inner-header">		
							<div class="gnb">
								<ul id="gnb"> 

						  	    <c:forEach var="result" items="${list_headmenu}" varStatus="status"> 
							        <c:set var="iCnt" value="0"/>
							        <c:if test="${result.displayLvl==1}"> 
		    							<li class="gnb_menu"><a href="#LINK" onclick="javascript:goMenuPage('<c:out value="${result.menuCd}"/>','<c:out value="${result.linkUrl}"/>')"><img src="${ctx}<c:out value="${result.linkUrlImg}"/>" title="<c:out value="${result.menuNm}"/>" /></a> 
		    							<c:set var="upMenu" value="${result.menuCd}"/>   
		    							<c:forEach var="resultsub" items="${list_headmenu}" varStatus="status">
		    								<c:if test="${upMenu==resultsub.upMenuCd && result.privGrpNo != 0}">
			    								<c:if test="${iCnt==0}">
			    									<c:choose>
														<c:when test="${result.menuCd== 'SCN04000'}"><ul class="sub4"></c:when>
														<c:when test="${result.menuCd== 'SYM00000'}"><ul class="sub5"></c:when>
														<c:otherwise> <ul class="sub3"></c:otherwise>
													</c:choose>
			    								 </c:if>
												<li><a href="#LINK" onclick="javascript:goMenuPage('<c:out value="${resultsub.menuCd}"/>','<c:out value="${resultsub.linkUrl}"/>')"><img src="${ctx}<c:out value="${resultsub.linkUrlImg}"/>" title="<c:out value="${resultsub.menuNm}"/>" /></a></li> 
		    									<c:set var="iCnt" value="${iCnt+1}"/>
		    								</c:if>
		    							</c:forEach>
		    							<c:if test="${iCnt>0}"> 
		    								</ul>
		    							</c:if> 
		    							</li>
	    							</c:if> 
	    						</c:forEach>  

								</ul> 
								<script type="text/javascript">
									gnbNavi();
								</script>
							</div>
						</div> 
			</div>		
		 </div>
	</div>