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
		<div class="content_title"><h2>계측 및 평가결과</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">시설물 상세정보</a></li>
				<li class="last">계측 및 평가결과</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>

		<div class="a_data_total">
			<div class="a_data_left2">
				<ul class="comm">
					<li class="title">서울특별시청사</li>
					<li><img src="/img/etc/no_img.jpg" title="" /></li>
				</ul>

				<div class="widget_header2">                        
					<ul class="last">
						<li>
							<fieldset class="inline">
								<label>지역</label>
								 <select title="" name="">
									<option value="">전국</option>
								</select>	
							</fieldset> 
							<fieldset class="inline">
								<label>시설분류</label>
								 <select title="" name="">
									<option value="">관공서</option>
								</select>	
							</fieldset> 
							<fieldset class="inline">
								<label>상태</label>
								 <select title="" name="">
									<option value="">적합</option>
								</select>	
							</fieldset> 
							<div class="btn"><a href="#" class="css_button blue" onclick=""><span>정렬</span></a></div>
						</li>                        
					</ul>
					
				</div>
				<div class="widget_header3" style="height:180px;overflow-y:scroll;">           
					<table class="buil_list_tb" id="chTable">
						<caption>시설물 목록</caption>
							<tr>
							<td class="num2">1</td>
							<td>서울특별시청사</td>
							<td><font class="add">
							서울 중구 태평로 1가 31</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북도청</td>
							<td><font class="add">
							전라북도 완주군..</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>화성시청</td>
							<td><font class="add">
							화성시 병점동</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>군포시청</td>
							<td><font class="add">
							군포시 당정동..</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>수원시청</td>
							<td><font class="add">
							수원시 매탄동 1가 31</font></td>
							<td class="st_no">부적합</td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>수원시청</td>
							<td><font class="add">
							수원시 매탄동 1가 31</font></td>
							<td class="st_no">부적합</td>
						</tr>
					</table>
				</div>

				<br>
				<div class="content_title2"><ul><li>최근 분석결과 목록</li></ul></div>
				<div style="height:235px;overflow-y:scroll;">
					<table class="auth_group display3" style="background-color: #fff;font-size:11px;">
						<caption></caption>
						<thead>
							<tr>
								<th class="num4">날짜</th>							
								<th>행정구역</th>	
								<th>점검<br/>필요</th>
								<th>안전</th>
							</tr>
						</thead>
						<tbody>
								<tr>
								<td>2013.01.11</td>
								<td>전북군산시 어청도 동북동 20km</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
							<tr>
								<td>2013.01.14</td>
								<td>평안북도 철산 남남서쪽 84km 해역</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
							<tr>
								<td>2013.05.02</td>
								<td>경북 상주시 북서쪽 32km 지역</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
							<tr>
								<td>2013.04.02</td>
								<td>충남 홍성군 동쪽 3km 지역</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
							<tr>
								<td>2013.05.11</td>
								<td>황해남도 안악 남동쪽 15km 지역</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
													<tr>
								<td>2013.07.11</td>
								<td>강원 정선군 북동쪽 4km 지역</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
													<tr>
								<td>2013.08.11</td>
								<td>전북 부안군 위도 북쪽 33km 해역</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
													<tr>
								<td>2013.03.02</td>
								<td>충남 홍성군 동쪽 3km 지역</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
													<tr>
								<td>2013.08.10</td>
								<td>전북 부안군 위도 서북서쪽 29km 해역</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr> 
						</tbody>
					</table>
				</div>
				<br/>
				<div class="sy_tab">
					<div class="sy_left">
						<ul>
							<li class="sy_title">자유장</li>
							<li class="sy_on"><a href="#">가속도</a></li><!-- 버튼 선택시 -->
							<li><a href="#">속도</a></li>
							<li><a href="#">범위</a></li>
							<li><a href="#">응답스펙트럼</a></li>
						</ul>
					</div>
					<div class="sy_right">
						<ul>
							<li class="sy_title">시설물</li>
							<li><a href="#">최상층가속도</a></li>
							<li><a href="#">최상층속도</a></li>
							<li><a href="#">최상층범위</a></li>
							<li><a href="#">안전성평가결과</a></li>
						</ul>
					</div>
					<br class="clear">
				</div>

				<div class="sy_tab">
					<ul>							
						<li class="sy_btn"><a href="#">계측자료 누적기록</a></li>
						<!-- <li class="sy_btn"><span class="sy_btn_on"><a href="#">계측자료 누적기록</a></span></li> 
						버튼 선택시 
						-->
					</ul>
				</div>

			</div>

			<div class="a_data_center3">
					<div style="float:left;width:100%;">
						<div style="float:left;width:68%;margin:0 20px 0 0;">
							<div class="content_title2"><ul><li>계측 최대값</li></ul></div>	
							<table class="auth_group display2">
								<caption></caption>
								<thead>
									<tr>
										<th colspan="4">자유장</th>	
										<th colspan="4">시설물중간층</th>
									</tr>
								</thead>				
								<tbody>
									<tr>
										<td class="num3">계측방향</td>
										<td class="line_bg">가속도(gal)</td>
										<td class="line_bg">속도(cm/sec2)</td>
										<td class="line_bg">변위(cm)</td>
										<td class="num3">계측방향</td>
										<td class="line_bg">가속도(gal)</td>
										<td class="line_bg">속도(cm/sec2)</td>
										<td class="line_bg">변위(cm)</td>
									</tr>
									<tr>
										<td class="num3">동서</td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td class="num3">동서</td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td>000.0 </td>
									</tr>
									<tr>
										<td class="num3">남북</td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td class="num3">남북</td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td>000.0 </td>
									</tr>
									<tr>
										<td class="num3" style="width:80px">수평성분합성</td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td colspan="4"></td>
									</tr>
									<tr>
										<td class="num3">면적</td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td colspan="4"></td>
									</tr>
								</tbody>
							</table> 
							<br >
							<table class="auth_group display2">
								<caption></caption>
								<thead>
									<tr>
										<th colspan="4">시설물최상층</th>	
										<th colspan="4">시설물최하층</th>
									</tr>
								</thead>				
								<tbody>
									<tr>
										<td class="num3">계측방향</td>
										<td class="line_bg">가속도(gal)</td>
										<td class="line_bg">속도(cm/sec2)</td>
										<td class="line_bg">변위(cm)</td>
										<td class="num3">계측방향</td>
										<td class="line_bg">가속도(gal)</td>
										<td class="line_bg">속도(cm/sec2)</td>
										<td class="line_bg">변위(cm)</td>
									</tr>
									<tr>
										<td class="num3">동서</td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td class="num3">동서</td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td>000.0 </td>
									</tr>
									<tr>
										<td class="num3">남북</td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td class="num3">남북</td>
										<td>000.0 </td>
										<td>000.0 </td>
										<td>000.0 </td>
									</tr>
								</tbody>
							</table>
						</div>
						<div style="float:left;width:30%;">
							<div class="content_title2"><ul><li>설계지반가속도 초과율</li></ul></div>	
							<table class="auth_group display2" style="height:132px;">
								<caption></caption>					
								<tbody>
									<tr>
										<td class="line_bg"> 설계지반가속도</td>
										<td class="line_bg"> 최대지반가속도</td>
										<td class="line_bg"> 초과율</td>
									</tr>
									<tr>
										<td>000.0 </td>
										<td> 000.0</td>
										<td>000.0</td>
									</tr>
								</tbody>
							</table>
							<br>
							<div class="content_title2"><ul><li>고유주기</li></ul></div>
							<table class="auth_group display2" style="height:112px;">
								<caption></caption>					
								<tbody>
									<tr>
										<td class="line_bg"> 자유장</td>
										<td class="line_bg"> 시설물(동서)</td>
										<td class="line_bg"> 시설물(남북</td>
									</tr>
									<tr>
										<td>000.0</td>
										<td>000.0</td>
										<td>000.0</td>
									</tr>
								</tbody>
							</table>
						</div>
						<br class="clear"/>
					</div>

					<br class="clear"/>
					<br/>
					<div class="content_title2"><ul><li>타이틀</li></ul></div>
					<!-- 그래프 3개짜리 -->
					<div style="background-color: #fff;width:100%;height:666px;"> 
						<div style="width:100%;height:215px;margin:0 0 10px 0;">
						그래프영역1
						</div>
						<div style="width:100%;height:215px;margin:0 0 10px 0;">
						그래프영역2
						</div>
						<div style="width:100%;height:215px;">
						그래프영역3
						</div>
					</div>
					
					<!-- 그래프 4개짜리 -->
					<!-- <div style="background-color: #fff;width:100%;height:666px;">
						<div style="float:left;width:50%;">
							<div style="width:100%;height:215px;margin:0 0 10px 0;">
							그래프영역1
							</div>
							<div style="width:100%;height:215px;margin:0 0 10px 0;">
							그래프영역2
							</div>
							<div style="width:100%;height:215px;">
							그래프영역3
							</div>
						</div>
						<div style="float:right;width:49%;height:665px;">
						그래프영역4
						</div>
					</div> -->

			</div>		
			
			<br class="clear">
		</div>
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