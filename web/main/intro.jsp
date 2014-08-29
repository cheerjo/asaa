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




<!-- STR:컨텐츠 -->	
<div id="contents_wrap2">
	<div id="contents2">

		<!-- STR:지도 -->		
		<div class="map">
			<div class="map_left">
				
				<!-- STR:지도 왼쪽 버튼 -->
				<div class="map_btn">
					<ul>
						<li class="btn_map01"><a href="#" title="PGA">PGA</a></li>	
						<li class="btn_map02"><a href="#" title="진도(MMI)">진도(MMI)</a></li>	
						<li class="btn_map03"><a href="#" title="계측소">계측소</a></li>	
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
							<td>무감</td> <!-- #ffffff -->
						</tr>
						<tr>
							<td class="step">Ⅱ-Ⅲ</td>
							<td>약한진동</td> <!-- #83ebee -->
						</tr>
						<tr>
							<td class="step">Ⅳ</td>
							<td>가벼운진동</td> <!-- #96d28c -->
						</tr>
						<tr>
							<td class="step">Ⅴ</td>
							<td>보통진동</td> <!-- #fafc6a -->
						</tr>
						<tr>
							<td class="step">Ⅵ</td>
							<td>강한진동</td> <!-- #dfab00 -->
						</tr>
						<tr>
							<td class="step">Ⅶ</td>
							<td>매우강한진동</td> <!-- #fe9900 -->
						</tr>
						<tr>
							<td class="step">Ⅷ</td>
							<td>심한진동</td> <!-- #c34a01 -->
						</tr>
						<tr>
							<td class="step">Ⅸ</td>
							<td>격렬한진동</td> <!-- #f01501 -->
						</tr>
						<tr>
							<td class="step">Ⅹ+</td>
							<td>극한진동</td> <!-- #6c0000 -->
						</tr>
					</table>
				</div>
				<!-- END:지도 왼쪽 테이블 -->

				<!-- STR:지도 왼쪽 아이콘 -->
				<div class="map_tb_ico">
					<table>
						<tr>
							<td><img src="/img/common/ico_map01_r.png" title="" /></td><!-- _r을 붙이면 빨간색 아이콘 -->
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
							<td><img src="/img/common/ico_map06_r.png" title="" /></td>
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

			<div class="map_right2">		
				
			</div>
		
		</div>
		<!-- END:지도 -->
		
		<!-- STR:우측 그래프 -->
		<div class="graph2">

			<img src="/img/common/logo3.jpg" title="" />

			<!-- STR:이상진동 감지 -->
			<div class="data01">
				<div class="data_step">
					<img src="/img/common/data_step.jpg" title="" />
				</div>
				<ul>
					<li class="graph_title01">이상진동 감지  -  (없음)/00개소</li>
					<li class="graph_txt">시각 : 2013. 07.19.  17:27:12</li> 
					<li class="graph_txt">위치 : 대구시청&nbsp;&nbsp;&nbsp;&nbsp;연락처 (000-000-0000)</li>
					<li class="graph_txt">계측 PGA : 15 gal</li>
				</ul>				
			</div>
			<!-- END:이상진동감지 -->
			
			<!-- STR:계측신호 오류 감지 -->
			<div class="data01" style="margin:10px 0 0 10px;">
				<ul>
					<li class="graph_title01">계측신호 오류 감지  -  (없음)/00개소</li>
					<li class="graph_txt">[건축물] 인천광역시 소방안전본부</li> 
					<li class="graph_txt">건축물] 전남대학교</li>
					<li class="graph_txt">[교량] 광안대교</li>
				</ul>
			</div>
			<!-- END:계측신호 오류감지 -->		
			
			<div class="sy_tab">
				<ul>							
					<li class="sy_btn"><a href="#">행정구역별 실시간 지진가속도 계측 최대값</a></li>
					<!-- <li class="sy_btn"><span class="sy_btn_on"><a href="#">계측자료 누적기록</a></span></li> 
					버튼 선택시 
					-->
				</ul>
				<ul>							
					<li class="sy_btn"><a href="#">행정구역별 안전성분석결과</a></li>
					<!-- <li class="sy_btn"><span class="sy_btn_on"><a href="#">계측자료 누적기록</a></span></li> 
					버튼 선택시 
					-->
				</ul>
			</div>

			<div style="width:360px;margin:0 0 0 10px;">
				<img src="/img/common/kit.jpg" title="" />
			</div>
			<div style="width:360px;margin:0 0 0 10px;">
				<img src="/img/common/titlekit.jpg" width=360px height=200px title="" />
			</div>
			<div class="sy_tab">
				<ul>							
					<li class="sy_btn"><a href="#">지진피해 시뮬레이션</a></li>
					<!-- <li class="sy_btn"><span class="sy_btn_on"><a href="#">지진피해 시뮬레이션</a></span></li> 
					버튼 선택시 
					-->
				</ul>
				<ul>							
					<li class="sy_btn"><a href="#">지진피해추정</a></li>
					<!-- <li class="sy_btn"><span class="sy_btn_on"><a href="#">지진피해추정</a></span></li> 
					버튼 선택시 
					-->
				</ul>
				<ul>							
					<li class="sy_btn"><a href="#">지반액상화</a></li>
					<!-- <li class="sy_btn"><span class="sy_btn_on"><a href="#">지반액상화</a></span></li> 
					버튼 선택시 
					-->
				</ul>
				<ul>							
					<li class="sy_btn"><a href="#">지진정보관리</a></li>
					<!-- <li class="sy_btn"><span class="sy_btn_on"><a href="#">지진정보관리</a></span></li> 
					버튼 선택시 
					-->
				</ul>
				<ul>							
					<li class="sy_btn"><a href="#">긴급대응 체계</a></li>
					<!-- <li class="sy_btn"><span class="sy_btn_on"><a href="#">긴급대응 체계</a></span></li> 
					버튼 선택시 
					-->
				</ul>
				<ul>							
					<li class="sy_btn"><a href="#">피해추정 기초데이터</a></li>
					<!-- <li class="sy_btn"><span class="sy_btn_on"><a href="#">피해추정 기초데이터</a></span></li> 
					버튼 선택시 
					-->
				</ul>
			</div>

			
		</div>
		<!-- END:우측 그래프 -->
		<br class="clear">
	</div>	
</div>
<!-- END:컨텐츠 -->	




</BODY>
</HTML>
