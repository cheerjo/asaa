<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  

<%@ page import ="egovframework.com.cmm.LoginVO" %>
 <!DOCTYPE html>
<html lang="ko">
<head>
<title>국립재난안전연구원 지진가속도 응답신호 종합분석 시스템</title>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석 시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=7, IE=9, IE=10">
<meta name="viewport" content="initial-scale=1, maximum-scale=1,user-scalable=no">


<link rel="stylesheet" href="${ctx}/css/style.css">   

 <script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script> 
 <script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script> 
 <script src="${ctx}/js/estam_common.js"></script>  

 

<script type="text/javascript">
 <!--

//page onLoad
$(document).ready( function() {     

});   
 //-->
 </script>
</head>

<BODY>

<!-- STR:top_menu -->
<div id="top_wrap">
	 <c:import url="/main/EstamIncHeader.do?flag=MAIN" /> 
</div>
<!-- END:top_menu -->


<!-- STR:컨텐츠 -->	
<div id="contents_wrap">
	<div id="contents">
		
		<br>
		<div class="content_title"><h2>분석결과 상관관계</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">시설물 상세정보</a></li>
				<li class="last">분석결과 상관관계</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>

		<div class="a_data_total">
			
			<div class="a_data_center5">
				<div class="content_title2"><ul><li>높이-진동수 상관관계</li></ul></div>

				<div style="width:100%;"> 
					<div style="float:left;width:48%;height:400px;margin:0 10px 10px 0;">
						<div class="content_title4"><ul><li>철근콘크리트모멘트 골조</li></ul></div>
						<div style="width:100%;height:100%;">
							<img src="${ctx}/img/acc/arcc01.png" title=""  />
						</div>
					</div>
					<div style="float:left;width:48%;height:400px;margin:0 0 10px 0;">
						<div class="content_title4"><ul><li>철근콘크리트 전단벽</li></ul></div>
						<div style="width:100%;height:100%;">
							<img src="${ctx}/img/acc/arcc02.png" title=""  />
						</div>
					</div>
					<div style="float:left;width:48%;height:400px;margin:0 10px 0 0;">
						<div class="content_title4"><ul><li>철골모멘트 골조</li></ul></div>
						<div style="width:100%;height:100%;">
							<img src="${ctx}/img/acc/arcc03.png" title=""  />
						</div>
					</div>
					<div style="float:left;width:48%;height:400px;">
						<div class="content_title4"><ul><li>철골 편심가새 골조</li></ul></div>
						<div style="width:100%;height:100%;">
							<img src="${ctx}/img/acc/arcc04.png" title=""  />
						</div>
					</div>
					<br class="clear">
				</div>

			</div>	
			
			<div class="a_data_right3" style="height:845px;">
				<div class="content_title2"><ul><li>지반종류-진동수 상관관계</li></ul></div>
				<div style="width:100%;height:450px;">
					<img src="${ctx}/img/acc/arcc05.png" title=""  />
				</div>

				<br/>
				<div class="content_title4"><ul><li>지반 종류-전단파속도-진동수 관계 참고자료</li></ul></div>
				<table class="auth_group display3" style="background-color: #fff;font-size:11px;">
					<caption></caption>
					<thead>
						<tr>
							<th>제한조건(분류)</th>							
							<th>전단파속도 (Vs30)(m/sec)</th>	
							<th>진동수 (Hz)</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>보통암(S<sub>B</sub>)</td>
							<td>760~1500</td>	
							<td>16.67이상</td>	
						</tr>
						<tr>
							<td>매우 조밀한 토사/연암(S<sub>C</sub>)</td>
							<td>360~760</td>	
							<td>3.45이상~16.67미만</td>	
						</tr>
						<tr>
							<td>단단한 토사(S<sub>D</sub>)</td>
							<td>180~360</td>	
							<td>1.61이상~3.45미만</td>	
						</tr>
						<tr>
							<td>연약한 토사(S<sub>E</sub>)</td>
							<td>180미만</td>	
							<td>1.61이하</td>	
						</tr>
					</tbody>
				</table>
			</div>
			
			<br class="clear">
		</div>
	</div>	
</div>
<!-- END:컨텐츠 -->	


<!-- STR:footer -->
<div id="footer">
    <c:import url="/EgovPageLink.do?vlink=estam/main/inc/EstamIncFooter" /> 
</div>
<!-- END:footer -->

</BODY>
</HTML>

 