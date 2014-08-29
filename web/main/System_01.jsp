<!DOCTYPE html>
<html lang="ko">
<head>
<title>국립재난안전연구원 지진가속도 응답신호 종합분석 시스템</title>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석 시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석">

<link rel="stylesheet" href="/css/style.css"> 
<script src="/js/ahn_common.js"></script>

<script type="text/javascript">
 <!--
  window.onload = function() {
   var tblList = document.getElementById("chTable").getElementsByTagName("tr");
   for (i=0; i<tblList.length; i++) {
    tblList[i].onmouseover = function() {
     this.style.backgroundColor = '#f7f9db';
    }
    tblList[i].onmouseout = function() {
     this.style.backgroundColor = '#fff';
    }
   }
  }
 //-->
 </script>
</head>

<BODY>

<!-- STR:top_menu -->
<div id="top_wrap">
	<div id="wrap">

		<div id="top_menu">
			<div class="btn_logo">
				<a href="#"><img src="/img/common/logo.png" title="홈으로"/></a>
			</div>

			<div class="member_info">
				<ul>
					<li class="txt"><b>국립재난안전연구원 홍길동님</b> 반갑습니다. </li>
					<li><a href="#"><img src="/img/common/btn_logout.png" title="로그아웃"/></a> </li>
				</ul>
			</div>

			<div id="header">
				<div id="inner-header">		
					<div class="gnb">
						<ul id="gnb">
							<li class="gnb_menu"><a href="#"><img src="/img/common/gnb01.png" title="지진가속도계측현황" /></a>
							</li>
							<li class="gnb_menu"><a href="#"><img src="/img/common/gnb02.png" title="지진가속도계측자료분석" /></a>
								
							</li>
							<li class="gnb_menu"><a href="#"><img src="/img/common/gnb03.png" title="지진가속도계측기관리" /></a>
								<ul class="sub3">
									<li><a href="#"><img src="/img/common/submenu0301.png" title="계측기통합정보" /></a></li>
									<li><a href="#"><img src="/img/common/submenu0302.png" title="계측기관리대장" /></a></li>
									<li><a href="#"><img src="/img/common/submenu0303.png" title="초기점검보고서" /></a></li>
									<li><a href="#"><img src="/img/common/submenu0304.png" title="정기점검보고서" /></a></li>
									<li><a href="#"><img src="/img/common/submenu0305.png" title="현장점검보고서" /></a></li>
									<li><a href="#"><img src="/img/common/submenu0306.png" title="계측기신호점검" /></a></li>
								</ul>
							</li>
							<li class="gnb_menu"><a href="/kor/resistration/info.asp"><img src="/img/common/gnb04.png" title="시설물상세정보" /></a>
								
							</li>
							<li class="gnb_menu"><a href="/kor/community/diary.asp"><img src="/img/common/gnb05.png" title="보고서작성" /></a>
								
							</li>
							<li class="gnb_menu"><a href="/kor/community/diary.asp"><img src="/img/common/gnb06.png" title="시스템설정" /></a>
								
							</li>
						</ul>
						<script type="text/javascript">
							gnbNavi();
						</script>
					</div>
				</div>
			</div>		
		
	</div>
</div>
<!-- END:top_menu -->


<!-- STR:컨텐츠 -->	
<div id="contents_wrap">
	<div id="contents">
		
		<br>
		<div class="content_title"><h2>분석지표 계수 설정</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">시스템 설정</a></li>
				<li class="last">분석지표 계수 설정</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>

		<div class="a_data_total">
			<div style="float:left;width:50%;">
				<div style="width:600px;margin:0 auto;">
					<div class="content_title4"><ul><li> 최대층간변위비</li></ul></div>	
					<table class="auth_group display2">
						<caption></caption>
						<thead>
							<tr>
								<th rowspan="2">구조형식</th>	
								<th colspan="2">안전</th>
								<th colspan="2">점검필요</th>
							</tr>
							<tr>
								<td colspan="2">No damage</td>
								<td colspan="2">Immediate<br/>Occupancy</td>
							</tr>
						</thead>				
						<tbody>
							<tr>
								<td class="tlt">철골 모멘트 골조</td>
								<td>0.44</td>
								<td>% 이하</td>
								<td>0.70</td>
								<td>% 이하</td>
							</tr>
							<tr>
								<td class="tlt">철골 모멘트 골조</td>
								<td>0.44</td>
								<td>% 이하</td>
								<td>0.70</td>
								<td>% 이하</td>
							</tr>
							<tr>
								<td class="tlt">철근콘크리트 모멘트 골조</td>
								<td>0.44</td>
								<td>% 이하</td>
								<td>0.70</td>
								<td>% 이하</td>
							</tr>
							<tr>
								<td class="tlt">철골 모멘트 골조</td>
								<td>0.44</td>
								<td>% 이하</td>
								<td>0.70</td>
								<td>% 이하</td>
							</tr>
						</tbody>
					</table> 
					
					<br/>
					<div class="content_title5">
						<ul>
							<li class="title5"> 고유진동수 변화율</li>
							<li> 						
								<table class="auth_group display2">
								<caption></caption>
									</tbody>
										<tr>
											<td class="line_bg">20</td>		
											<td class="line_bg">% 이하</td>		
										</tr>
									<tbody>
								</table> 
							</li>
						</ul>
					</div>
					<br class="clear"/>
					<div class="content_title5">
						<ul>
							<li class="title5"> 건축물과 자유장 고유진동수비</li>
							<li> 						
								<table class="auth_group display2">
								<caption></caption>
									</tbody>
										<tr>
											<td class="line_bg">100</td>
											<td class="line_bg">20</td>		
											<td class="line_bg">% 이하</td>		
										</tr>
									<tbody>
								</table> 
							</li>
						</ul>
					</div>
					<br class="clear"/>
					<div class="content_title5">
						<ul>
							<li class="title5"> 설계가속도 초과율</li>
							<li> 						
								<table class="auth_group display2">
								<caption></caption>
									</tbody>
										<tr>
											<td class="line_bg">0</td>		
											<td class="line_bg">% 이하</td>		
										</tr>
									<tbody>
								</table> 
							</li>
						</ul>
					</div>						
				</div>
	
			</div>

			<div style="float:left;width:50%;">
				<div style="width:600px;margin:0 auto;">
					<div class="content_title2"><ul><li>고유진동수 측정 감시 영역 / 감시영역길이 & 이동간격길이</li></ul></div>
						<div class="content_title4"><ul><li> 고유진동수 측정 감시 영역</li></ul></div>	
						<table class="auth_group display2">
							<caption></caption>										
							<tbody>
								<tr>
									<td class="num">장축 </td>
									<td>0.44</td>
									<td>% 이하</td>
									<td>0.70</td>
									<td>% 이하</td>
									<td>% 이하</td>
								</tr>
								<tr>
									<td class="num">단축 </td>
									<td>0.44</td>
									<td>% 이하</td>
									<td>0.70</td>
									<td>% 이하</td>
									<td>% 이하</td>
								</tr>
							</tbody>
						</table> 

						<br/>
						<div class="content_title4"><ul><li> 감시영역길이 / 이동간격길이</li></ul></div>	
						<table class="auth_group display2">
							<caption></caption>										
							<tbody>
								<tr>
									<td class="tlt4">감시영역 </td>
									<td>0.44</td>
									<td>% 이하</td>
								</tr>
								<tr>
									<td class="tlt4">이동간격</td>
									<td>0.44</td>
									<td>% 이하</td>
								</tr>
							</tbody>
						</table>
						
						<br/>
						<div style="float:left;margin:0 10px 0 0;">
							<div class="content_title2"><ul><li>층간변위 증폭계수</li></ul></div>
						</div>
						<div style="float:left;">
							<table class="auth_group display2">
							<caption></caption>
								</tbody>
									<tr>
										<td class="line_bg">0</td>			
									</tr>
								<tbody>
							</table> 
						</div>
						<br class="clear"/>
				</div>
			</div>
			<br class="clear"/>
		</div>

		<!-- btn_group -->
		<div class="btn_group" style="border-top:1px solid #ffcdcd;padding:10px 0 0 0;">
			<a href="#" class="css_button red" onclick=""><span>저장</span></a>
		</div>
		<!-- //btn_group -->
	</div>	
</div>
<!-- END:컨텐츠 -->	


<!-- STR:footer -->
<div id="footer">
	<div id="footer_wrap">

		<ul class="footer_btn">
			<li><a href=""><img src="/img/btn/btn_footer01.png" title="개인정보 보호정책" /></a></li>
			<li><a href=""><img src="/img/btn/btn_footer02.png" title="뷰어프로그램 다운로드" /></a></li>
			<li><a href=""><img src="/img/btn/btn_footer03.png" title="이메일주소 무단수집거부" /></a></li>
			<li><a href=""><img src="/img/btn/btn_footer04.png" title="사이트맵" /></a></li>
		</ul>

		<!-- STR:지도 왼쪽 버튼 -->
		<div class="quick_btn">
			<ul>
				<li class="quick_btn01"><a href="#" title="가속도계측기관리대장">가속도계측기관리대장</a></li>	
				<li class="quick_btn02"><a href="#" title="가속도계측기현장점검보고서">가속도계측기현장점검보고서</a></li>	
				<li class="quick_btn03"><a href="#" title="종합분석보고서작성">종합분석보고서작성</a></li>
			</ul>
		</div>
		<!-- END:지도 왼쪽 버튼 -->

	</div>
</div>
<!-- END:footer -->

</BODY>
</HTML>
