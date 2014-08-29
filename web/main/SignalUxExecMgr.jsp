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
		<div class="content_title"><h2>지진데이타분석</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">시설물 상세정보</a></li>
				<li class="last">지진데이타분석</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
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
				<div class="widget_header3" style="height:165px;overflow-y:scroll;">           
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
							<td>서울특별시청사</td>
							<td><font class="add">
							서울 중구 태평로 1가 31</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>서울특별시청사</td>
							<td><font class="add">
							서울 중구 태평로 1가 31</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>서울특별시청사</td>
							<td><font class="add">
							서울 중구 태평로 1가 31</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>서울특별시청사</td>
							<td><font class="add">
							서울 중구 태평로 1가 31</font></td>
							<td class="st_no">부적합</td>
						</tr>
					</table>
				</div>

				<br>
				<div class="content_title2"><ul><li>지진목록</li></ul></div>
				<div style="height:165px;overflow-y:scroll;">
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
							<tr>
								<td>2013.00.00</td>
								<td>전북군산시 어청도 동북동 20km</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
							<tr>
								<td>2013.00.00</td>
								<td>전북군산시 어청도 동북동 20km</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
							<tr>
								<td>2013.00.00</td>
								<td>전북군산시 어청도 동북동 20km</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
							<tr>
								<td>2013.00.00</td>
								<td>전북군산시 어청도 동북동 20km</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
							<tr>
								<td>2013.00.00</td>
								<td>전북군산시 어청도 동북동 20km</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
						</tbody>
					</table>
					</div>
					
					<br/>
					<div class="sy_tab">
						<ul>							
							<li class="sy_btn"><a href="#">분석실행</a></li>
							<!-- <li class="sy_btn"><span class="sy_btn_on"><a href="#">분석실행</a></span></li> 
							버튼 선택시 
							-->
						</ul>
					</div>
					
				</div>

				<div class="a_data_center3" style="height:788px;">
					<div class="sy_box">
						진행중
					</div>
					
					<!-- <div class="sy_box2">
						완료
					</div> -->
				</div>
							

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
