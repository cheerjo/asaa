<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>진행상태</title>
<style>
	body{
		font-family:'돋움'; padding:0; margin:0; border:2px solid #0969B3; 
	}
	
	.msg
	{
		font-size:9pt;
		font-family:굴림;
		color:#25407B;
	}
	
	.neon
	{
		font-size:9pt;
		font-family:굴림;
	}	
</style>

<script type="text/javascript">


window.onload = loading;

function loading() 
{ 	

//	opener.reload();
	document.getElementById("progress").style.display = "block";
	
//	if(opener.document.getElementById("clickDownload").value>0) {
//		document.getElementById("progress").style.display = "none";
//		opener.document.getElementById("clickDownload").value = 0;
//	}

}



// 태용추가 - 20130705
var message="■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■";
var neonbasecolor="#4264AD";
var neontextcolor="#529CFF";
var flashspeed=200;
var n=0;


function neon()
{
	if (n==0)
    {
		for (var m=0;m<message.length;m++)
			tempref[m].style.color=neonbasecolor;
	}
	
	tempref[n].style.color=neontextcolor;
	
	if (n<tempref.length-1)
		n++;
	else
    {
		n=0;
		clearInterval(flashing);
		setTimeout("beginneon()",500);
		return;
	}
}

function beginneon()
{
	if(document.all)
	  flashing=setInterval("neon()",flashspeed);
}   


//프로그래스 윈도우에서 커서를 모래시계로 바꾼다.
//window.onload = loading;

//function loading() 
//{ 	 
//  	waitBody.style.cursor ="wait"; 
//}


//창이 비정상적으로 닫힐때의 기본 값
var retry = "AGAIN";		

//창이 비정상적으로 닫히면..자신을 다시 열기위해
//메인 윈도우의 함수를 호출한다.
window.onunload = exitPopupWin;	

function exitPopupWin() 
{ 		  
  if( retry == "AGAIN" ) 
  { 
  	try{
    	//자신을 열기위한 함수 호출 
    	dialogArguments.progress_viewMessage();	  	    	  	  	     
    }catch(e){}
  }    
}		

//정상적인 닫기 
function selfClose()
{
    retry = "CLOSE";  
    window.close(); 
     
}

</script>


</head>
<body id="waitBody" style="display:block">
<!-- 
<div align="center" style=" background:#0969B3; font-size:14px; font-weight:bold; padding:10px 0 10px 10px;">
<span><font color="white">프로그레스바</font></span>
</div>
 -->
 
<div align="center" >
	
	<div style="border-top:1px solid #ccc; background:#f4f4f5; padding:23px 0;">

	
	<div id="progress" style=display:none >
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center">   

			<span class="msg">작업 중 입니다. 잠시만 기다려 주십시요.</span><br>
		
				<script>			
						                
			//	alert("1:" + document.all);
						if (document.all) {
							document.write('<font color="'+neonbasecolor+'">');
							
							for (var m=0;m<message.length;m++) {
								document.write('<span class="neon" id="neonlight">'+message.charAt(m)+'</span>');
							}
							
							document.write('</font>');
							
							var tempref = document.all.neonlight;
						} else {
							document.write(message);
						}
						
			            beginneon();
				</script> 
    		<br> 
    

		</td>				
      </tr>	           
	</table>
	</div>
	
	</div>
</div>
</body>
</html>


