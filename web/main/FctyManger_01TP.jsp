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
				<div class="widget_header3" style="height:230px;overflow-y:scroll;">           
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
					</table>
				</div>

				<br>
				<div class="content_title2"><ul><li>최근 분석결과 목록</li></ul></div>
				<div style="height:305px;overflow-y:scroll;">
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
								<td>2013.05.11</td>
								<td>황해남도 안악 남동쪽 15km 지역</td>	
								<td>0.2%</td>	
								<td>99.8%</td>	
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<div class="a_data_center3">
				<div class="content_title2"><ul><li>타이틀</li></ul></div>		
				<table class="auth_group display2">
					<caption></caption>
					<thead>
						<tr>
							<th>관리항목</th>							
							<th colspan="5">내용</th>									
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="tlt">점검일자</td>
							<td colspan="5">YYYY-MM-DD</td>																		
						</tr>	
						<tr>
							<td class="tlt">기관코드</td>
							<td colspan="5" class="line_bg">영문 2자리</td>																		
						</tr>
						<tr>
							<td class="tlt">계측소코드</td>
							<td colspan="5">영문 2자리</td>																		
						</tr>
					</tbody>
				</table>
				<br>
				
				<div>
					<div style="float:left;width:40%;margin:0 30px 0 0;">
						<table class="auth_group display2">
							<caption>기록계 목록</caption>					
							<tbody>
								<tr>
									<td class="tlt">시설물 지진가속도계 개수</td>
									<td>5개</td>																		
								</tr>	
							</tbody>
						</table>
					</div>
					<div style="float:left;width:40%;">
						<table class="auth_group display2">
							<caption>기록계 목록</caption>					
							<tbody>
								<tr>
									<td class="tlt">기록계 개수</td>
									<td>5개</td>																		
								</tr>	
							</tbody>
						</table>
					</div>
					<br class="clear">
				</div>
				
				<br>
				<div class="content_title2"><ul><li>타이틀</li></ul></div>
				<table class="auth_group display2">
					<caption></caption>
					<thead>
						<tr>
							<th colspan="2">항목</th>	
							<th>내용</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="num3" rowspan="7">지진<br>가속도계<br>설치위치</td>
							<td class="txt_left">기록의 회수, 점검 및 교체가 용이하여 접근성이 좋을 것</td>	
							<td>
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label> 
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="line_bg txt_left">지진발생시 낙하물에 의한 손상 우려가 없는 안전한 장소</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">실외에 설치되었을 경우 계측기의 정상 작동 온도 범위 유지</td>	
							<td>
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="line_bg txt_left">실내에 설치되었을 경우 진동이 크게 발생하는 지역 회피</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">방폭 지역 및 강한 전자장 발생지역 회피</td>	
							<td>
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="line_bg txt_left">큰 전류가 발생하는 장소의 경우 실드케이블 사용</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">주변 시설물들과의 상호작용에 의한 영향이 없어야 함</td>	
							<td>
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>			
						</tr>

						<tr>
							<td class="num3" rowspan="4">설치<br>상태</td>
							<td class="line_bg txt_left">지반 또는 시설물의 바닥에 견고히 고정</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">기후변화, 전자기 및 낙뢰 영향 방지 등의 보호장치</td>	
							<td>
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="line_bg txt_left">자유장 지진가속도계의 수평방향은 동서 방향과 남북 방향이 되도록 설치</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value자"" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">모든 시설물 지진가속도계가 동일한 좌표축을 유지</td>	
							<td>
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>

						<tr>
							<td class="num3" rowspan="4">전원부</td>
							<td class="line_bg txt_left">접지 루프가 형성되지 않도록 지진가속도계측기를 접지</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">외부입력 전선에 서지보호장치(surge protector) 설치</td>	
							<td>
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="line_bg txt_left">연결상태 및 전원공급 정상 상태 확인</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">비상전원공급장치 설치</td>	
							<td>
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>

						<tr>
							<td class="num3" rowspan="2">계측<br>데이터</td>
							<td class="line_bg txt_left">소방방재청의 지진가속도계측자료 통합관리시스템과 연계구동</td>	
							<td class="line_bg">
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>
						<tr>
							<td class="txt_left">소방방재청의 지진가속도계측자료 통합관리시스템의 데이터베이스에 정상적으로 등록</td>	
							<td>
								<input type="checkbox" name="" title="" value="" ><label for="">적합</label>
								<input type="checkbox" name="" title="" value="" ><label for="">부적합</label>
							</td>
						</tr>

						<tr>
							<td class="num3">점검<br>결과</td>
							<td class="line_bg" colspan="3">부적합 사항 조치내용 및 조치계획 (256byte)</td>
						</tr>

						<tr>
							<td class="num3">처리<br>결과</td>
							<td colspan="3">(256byte)</td>
						</tr>
					</tbody>
				</table>
				<table class="auth_group display2">
					<caption></caption>
					<thead>
						<tr>
							<th>담당부서</th>	
							<th>직책</th>
							<th>담당자 이름</th>	
							<th>담당자 연락처</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td>010-0000-0000</td>
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
