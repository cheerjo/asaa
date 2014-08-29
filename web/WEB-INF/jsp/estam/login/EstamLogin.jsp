<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  

<%
 /**
  * @Class Name : EstamLogin.jsp
  * @Description : Login  화면
  * @Modification Information
  * @
  * @  수정일         수정자                   수정내용
  * @ -------    --------    ---------------------------
  * @ 2013.07.06    atres     최초 생성 
  *  @author atres
  *  @since 2013.07.06
  *  @version 1.0
  *  @see
  *
  *  Copyright (C) 2013 by ESTAM  All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석 시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석">

<link rel="stylesheet" href="${ctx}/css/style.css">
	<title>ASAA 로그인</title>
 <script src="${ctx}/js/estam_common.js"></script> 
<script type="text/javaScript" language="javascript">
 
function actionLogin() {

    if (document.loginForm.userId.value =="") {
        alert("아이디를 입력하세요");
    } else if (document.loginForm.usrPswd.value =="") {
        alert("비밀번호를 입력하세요");
    } else {
        document.loginForm.action="<c:url value='/login/actionLogin.do'/>";
        //document.loginForm.j_username.value = document.loginForm.orgYn.value + document.loginForm.username.value;
        //document.loginForm.action="<c:url value='/j_spring_security_check'/>";
        document.loginForm.submit();
    }
}
    
function setCookie (name, value, expires) {
    document.cookie = name + "=" + escape (value) + "; path=/; expires=" + expires.toGMTString();
}

function getCookie(Name) {
    var search = Name + "=";
    if (document.cookie.length > 0) { // 쿠키가 설정되어 있다면
        offset = document.cookie.indexOf(search);
        if (offset != -1) { // 쿠키가 존재하면
            offset += search.length;
            // set index of beginning of value
            end = document.cookie.indexOf(";", offset);
            // 쿠키 값의 마지막 위치 인덱스 번호 설정
            if (end == -1)
                end = document.cookie.length;
            return unescape(document.cookie.substring(offset, end));
        }
    }
    return "";
}

function saveid(form) {
    var expdate = new Date();
    // 기본적으로 30일동안 기억하게 함. 일수를 조절하려면 * 30에서 숫자를 조절하면 됨
    if (form.checkId.checked)
        expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 30); // 30일
    else
        expdate.setTime(expdate.getTime() - 1); // 쿠키 삭제조건
    setCookie("saveid", form.userId.value, expdate);
}

function getid(form) {
    form.checkId.checked = ((form.userId.value = getCookie("saveid")) != "");
}

function fnInit() {
    var message = document.loginForm.message.value;
    if (message != "") {
        alert(message);
    }

    getid(document.loginForm);
    // 포커스
    document.loginForm.userId.focus();
}
  
function f_enter(){
	if(event.keyCode == 13){
		actionLogin();
	}
}
</script>
</head>

<BODY onLoad="fnInit();"  topmargin=0 leftmargin=0 marginheight=0 marginwidth=0 style="background-color: #587499;">

<!-- STR:top_menu -->
<div id="login_wrap">
	<div id="login_wrap_in">
		<div id="login_box">
		 <form name="loginForm" action ="<c:url value='/login/actionLogin.do'/>" method="post">
		    <div style="visibility:hidden;display:none;">
			<input name="iptSubmit1" type="submit" value="전송" title="전송">
			</div>
            <input type="hidden" name="message" value="${message}">	
			<div class="idpw">
				<ul>
					<li><input type="text" name="userId" id="userId" class="in_txt" onKeypress="" /></li>
					<li><input type="password" name="usrPswd" id="usrPswd" class="in_txt" onKeydown="javascript:f_enter();" onKeypress="" /></li>
				<!--	
					<li><input type="checkbox" name="" id="" onKeypress="" /></li>
				-->	
					<li><input name="checkId"  type="checkbox"  class="check2" onClick="javascript:saveid(document.loginForm);" id="checkId" class="dl" id="checkbox" value=""> </li>
						
				</ul>
			</div>

			<div class="btn_login">
				<a href="javascript:actionLogin();"/><img src="/img/btn/btn_login.png" alt="로그인"/></a>
			</div>
			 <input name="orgYn" type="hidden" value="G"/>
            <input name="j_username" type="hidden"/>
            <input name="j_username1111" type="hidden"/>
		</form>
		</div>
	</div>
	
</div>
<!-- END:footer -->

</BODY>
</HTML>
