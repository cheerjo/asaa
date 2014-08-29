<!DOCTYPE html>
<html lang="ko">
<head>
<title>국립재난안전연구원 지진가속도 응답신호 종합분석 시스템</title>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석 시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석">

<link rel="stylesheet" href="/css/style.css"> 
<script src="/js/ahn_common.js"></script>
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

		<!-- STR:지도 -->		
		<div class="map">
			<div class="map_left">
				
				<!-- STR:지도 왼쪽 버튼 -->
				<div class="map_btn">
					<ul>
						<li class="btn_map01"><a href="#" title="PGA">PGA</a></li>	
						<li class="btn_map02"><a href="#" title="진도(MMI)">진도(MMI)</a></li>	
						<li class="btn_map03"><a href="#" title="계측소">계측소</a></li>	
						<li class="btn_map04"><a href="#" title="지반분류">지반분류</a></li>	
						<li class="btn_map05"><a href="#" title="이상진동감지">이상진동감지</a></li>	
					</ul>
				</div>
				<!-- END:지도 왼쪽 버튼 -->
				
				<!-- STR:지도 왼쪽 테이블 -->
				<div class="map_tb">
					<table>
						<tr>
							<th>진도<br>(MMI)</th>
							<th>진동감지</th>
						</tr>
						<tr>
							<td class="step">Ⅰ</td>
							<td>무감</td>
						</tr>
						<tr>
							<td class="step">Ⅱ-Ⅲ</td>
							<td>약한진동</td>
						</tr>
						<tr>
							<td class="step">Ⅳ</td>
							<td>가벼운진동</td>
						</tr>
						<tr>
							<td class="step">Ⅴ</td>
							<td>보통진동</td>
						</tr>
						<tr>
							<td class="step">Ⅵ</td>
							<td>강한진동</td>
						</tr>
						<tr>
							<td class="step">Ⅶ</td>
							<td>매우강한진동</td>
						</tr>
						<tr>
							<td class="step">Ⅷ</td>
							<td>심한진동</td>
						</tr>
						<tr>
							<td class="step">Ⅸ</td>
							<td>격렬한진동</td>
						</tr>
						<tr>
							<td class="step">Ⅹ+</td>
							<td>극한진동</td>
						</tr>
					</table>
				</div>
				<!-- END:지도 왼쪽 테이블 -->

				<!-- STR:지도 왼쪽 아이콘 -->
				<div class="map_tb_ico">
					<table>
						<tr>
							<td><img src="/img/common/ico_map01.png" title="" /></td>
							<td>건축물 (123/600 - 2)</td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map02.png" title="" /></td>
							<td>교량 (80/80 - 1) </td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map03.png" title="" /></td>
							<td>댐, 저수지 (22/38 - 0) </td>
						</tr>
					</table>
					<table>
						<tr>
							<td><img src="/img/common/ico_map04.png" title="" /></td>
							<td>공항시설 (15/15 - 2)</td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map05.png" title="" /></td>
							<td>가스시설 (32/32 - 1)  </td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map06.png" title="" /></td>
							<td>고속철도 (50/50 - 0) </td>
						</tr>
					</table>
					<table>
						<tr>
							<td><img src="/img/common/ico_map07.png" title="" /></td>
							<td>원자력 시설 (6/6 - 0)</td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map08.png" title="" /></td>
							<td>발전용 수력, 화력설비<br> (82/82 - 1)  </td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map03.png" title="" /></td>
							<td>변전소 (50/112 - 2) </td>
						</tr>
					</table>
				</div>
				<!-- END:지도 왼쪽 아이콘 -->

			</div>

			<div class="map_right">		
				지도
			</div>
		
		</div>
		<!-- END:지도 -->
		
		<!-- STR:우측 그래프 -->
		<div class="graph">

			<!-- STR:지진정보 -->
			<div class="data01">
				<ul>
					<li class="graph_title01">지진정보</li>
					<li class="graph_txt">규모: 3.0 </li> 
					<li class="graph_txt">진앙: 김포시 …… (26.2N  126.14E)</li>
					<li class="graph_txt">진원시: 2013. 07.19.  17:27:12</li>
				</ul>				
			</div>
			<!-- END:지진정보 -->
			
			<!-- STR:지진안전성분석결과 목록 -->
			<div class="data01">
				<ul>
					<li class="graph_title01">지진안전성분석결과 목록</li>
				</ul>
				<ul class="graph_txt2_list">
					<li class="graph_txt2"><a href="#">2013.6.29  전북 군산시 동북쪽 20km</a></li> 
					<li class="graph_txt2"><a href="#">2013.6.29  전북 군산시 동북쪽 20km</a></li> 
					<li class="graph_txt2"><a href="#">2013.6.29  전북 군산시 동북쪽 20km</a></li> 
				</ul>
			</div>
			<!-- END:지진안전성분석결과 목록 -->

			<!-- STR:지진가속도 계측 최대값 -->
			<div class="data02">
				<ul>
					<li class="graph_title02">행정구역별 실시간 지진가속도 계측 최대값</li>
				</ul>
				<div class="data02_down">
					그래프
				</div>
			</div>
			<!-- END:지진가속도 계측 최대값 -->
			
			<!-- STR:지진가속도 계측 최대값 하단 결과값 -->
			<div class="data04">				
				<div class="graph_bott02">
					<ul>
						<li class="graph_title04">점검필요 시설물 목록</li>
						<li class="txt2">-  (없음)/000개소</li>
					</ul>
					<ul class="txt3">
						<li>[건축물] 양천구청사 </li>
						<li>[건축물] 양천구청사 </li>
						<li>[건축물] 양천구청사 </li>
						<li>[건축물] 양천구청사 </li>
					</ul>
				</div>

				<div class="graph_bott03">
					그래프
				</div>

				<div class="graph_bott04">
					<ul>
						<li class="graph_title03">분석결과 요약</li>
					</ul>
					<ul class="txt">
						<li>지반가속도 최대값 계측지역 </li>
						<li>주요진동 지속시간 </li>
						<li>설계지반가속도 초과 지역</li>
						<li>최대 층간변위비 건축물</li>
					</ul>
					<ul>
						<li class="graph_title03">비전문가, 뉴스 기사를 위한 주요 요약 내용으로 보완 중</li>
					</ul>
				</div>

			</div>
			<!-- END:지진가속도 계측 최대값 하단 결과값-->

		</div>
		<!-- END:우측 그래프 -->

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
