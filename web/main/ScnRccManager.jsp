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
		<div class="content_title"><h2>계측기관리대장</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">지진가속도계측기관리</a></li>
				<li class="last">계측기관리대장</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>

		<div class="a_data_total">
			<div class="a_data_left">
				<ul class="comm">
					<li><img src="/img/etc/photo2.jpg" title="" /></li>
					<li><b>[시설물개요]</b></li>
					<li><b>내진등급 :</b> 특급 / <b>지진구역 :</b> 0 / <b>건물층수 :</b> 10층 </li>
					<li><b>PGA :</b> 0000g / <b>PGV :</b> 000 / <b>Sa :</b> 000g </li>
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
				<div class="widget_header3">           
					<table class="buil_list_tb" id="chTable">
						<caption>시설물 목록</caption>
						<tr>
							<td class="num2">1</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">2</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">3</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">4</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st_no">부적합</td><!-- 부적합 시 -->
						</tr>
						<tr>
							<td class="num2">4</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st_no">부적합</td><!-- 부적합 시 -->
						</tr>
						<tr>
							<td class="num2">4</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st_no">부적합</td><!-- 부적합 시 -->
						</tr>
						<tr>
							<td class="num2">2</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">3</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">4</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st_no">부적합</td><!-- 부적합 시 -->
						</tr>
						<tr>
							<td class="num2">4</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st_no">부적합</td><!-- 부적합 시 -->
						</tr>
						<tr>
							<td class="num2">2</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">3</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">3</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st">적합</td>
						</tr>
						<tr>
							<td class="num2">2</td>
							<td>서울특별시청사<br><font class="add">서울 중구 태평로 1가 31</font></td>
							<td class="st">적합</td>
						</tr>
					</table>
				</div>

			</div>

			<div class="a_data_center">
				<div class="content_title2"><ul><li>관리항목</li></ul></div>		
				<table class="auth_group display2">
					<caption>기록계 목록</caption>
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
						<tr>
							<td class="tlt">계측소명</td>
							<td colspan="5" class="line_bg">30 Byte 이내 문자</td>																		
						</tr>
						<tr>
							<td class="tlt">계측시작일자</td>
							<td colspan="5">YYYY-MM-DD</td>																		
						</tr>
						<tr>
							<td class="tlt">계측종료일자</td>
							<td colspan="5" class="line_bg">YYYY-MM-DD</td>																		
						</tr>
						<tr>
							<td class="tlt">계측종료일자</td>
							<td colspan="5">YYYY-MM-DD</td>																		
						</tr>
						<tr>
							<td class="tlt">시설물행정구역코드</td>
							<td colspan="5" class="line_bg">시군구코드 5자리</td>																		
						</tr>
						<tr>
							<td class="tlt">시설물 위치</td>
							<td colspan="5">번지 및 기타 주소</td>																		
						</tr>
						<tr>
							<td class="tlt">시설물 종류</td>
							<td colspan="5" class="line_bg">영문 2자리 코드</td>																		
						</tr>
						<tr>
							<td class="tlt">계측기 위치</td>
							<td colspan="5">100 Byte 이내 문자</td>																		
						</tr>
						<tr>
							<td class="tlt">지진가속도계 개수</td>
							<td colspan="5" class="line_bg">숫자 2자리</td>																		
						</tr>
						<tr>
							<td class="tlt" rowspan="2">위치 및 지형 정보</td>
							<td>경도</td>	
							<td>위도</td>		
							<td>표고</td>		
							<td>지상높이</td>		
							<td>지하깊이</td>		
						</tr>
						<tr>
							<td>10 Byte 숫자</td>	
							<td>10 Byte 숫자</td>		
							<td>10 Byte 숫자</td>		
							<td>10 Byte 숫자</td>		
							<td>10 Byte 숫자</td>		
						</tr>
						<tr>
							<td class="tlt" rowspan="2">지반정보</td>
							<td class="line_bg">기초형식</td>	
							<td class="line_bg">지반분류</td>		
							<td class="line_bg">주상도여부</td>		
							<td colspan="5" class="line_bg">주상도 이미지명</td>		
						</tr>
						<tr>
							<td class="line_bg">영문 2자리</td>	
							<td class="line_bg">영문 2자리</td>		
							<td class="line_bg">영문 1자리</td>		
							<td colspan="5" class="line_bg">50 Byte 이내 문자</td>	
						</tr>
						<tr>
							<td class="tlt">설치업체명</td>
							<td colspan="5">50 Byte 이내문자</td>																		
						</tr>
						<tr>
							<td class="tlt">설치업체 연락처</td>
							<td colspan="5" class="line_bg">50 Byte 이내문자</td>																		
						</tr>
					</tbody>
				</table>
				
				<br>
				<div class="content_title2"><ul><li>지진가속도계</li></ul></div>
				<table class="auth_group display2">
					<caption>지진가속도계 목록</caption>
					<thead>
						<tr>
							<th>번호</th>							
							<th>설치위치</th>	
							<th>계측성분</th>	
							<th>고유번호</th>
							<th>최종점검일</th>
							<th colspan="2">점검내역</th>
							<th>점검결과</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="num">S1</td>
							<td>자유장</td>	
							<td>3축(ZNE)</td>	
							<td>AA-AAG</td>	
							<td>YYYY-MM-DD</td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">초기</label> </td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">정기</label></td>	
							<td>적합</td>	
						</tr>
						<tr>
							<td class="num">S1</td>
							<td>자유장</td>	
							<td>3축(ZNE)</td>	
							<td>AA-AAG</td>	
							<td>YYYY-MM-DD</td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">초기</label> </td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">정기</label></td>	
							<td>적합</td>	
						</tr>
						<tr>
							<td class="num">S1</td>
							<td>자유장</td>	
							<td>3축(ZNE)</td>	
							<td>AA-AAG</td>	
							<td>YYYY-MM-DD</td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">초기</label> </td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">정기</label></td>	
							<td>적합</td>	
						</tr>
						<tr>
							<td class="num">S1</td>
							<td>자유장</td>	
							<td>3축(ZNE)</td>	
							<td>AA-AAG</td>	
							<td>YYYY-MM-DD</td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">초기</label> </td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">정기</label></td>	
							<td>적합</td>	
						</tr>
						<tr>
							<td class="num">S1</td>
							<td>자유장</td>	
							<td>3축(ZNE)</td>	
							<td>AA-AAG</td>	
							<td>YYYY-MM-DD</td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">초기</label> </td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">정기</label></td>	
							<td>적합</td>	
						</tr>
						<tr>
							<td class="num">S1</td>
							<td>자유장</td>	
							<td>3축(ZNE)</td>	
							<td>AA-AAG</td>	
							<td>YYYY-MM-DD</td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">초기</label> </td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">정기</label></td>	
							<td>적합</td>	
						</tr>
					</tbody>
				</table>

				<br>
				<div class="content_title2"><ul><li>지진가속도기록계</li></ul></div>
				<table class="auth_group display2">
					<caption>지진가속도기록계 목록</caption>
					<thead>
						<tr>
							<th>번호</th>							
							<th>설치위치</th>	
							<th>고유번호</th>	
							<th>계측센서<br>연결상태</th>
							<th>최종점검일</th>
							<th colspan="2">점검내역</th>
							<th>점검결과</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="num">R1</td>
							<td>자유장</td>	
							<td>3축(ZNE)</td>	
							<td>AA-AAG</td>	
							<td>YYYY-MM-DD</td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">초기</label> </td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">정기</label></td>	
							<td>적합</td>	
						</tr>
						<tr>
							<td class="num">R2</td>
							<td>자유장</td>	
							<td>3축(ZNE)</td>	
							<td>AA-AAG</td>	
							<td>YYYY-MM-DD</td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">초기</label> </td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">정기</label></td>	
							<td>적합</td>	
						</tr>
					</tbody>
				</table>

				<div style="width:350px;">
					<table class="auth_group display2">
					<caption>지진가속도기록계 목록</caption>
					<thead>
						<tr>
							<th>자유장</th>							
							<th>최하층</th>	
							<th colspan="2">최상층</th>	
							<th colspan="2">중간층</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="checkbox" name="" title="" value="" ><label for="">3축</label></td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">3축</label></td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">2축</label></td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">1축</label></td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">2축</label></td>	
							<td><input type="checkbox" name="" title="" value="" ><label for="">1축</label></td>		
						</tr>
					</tbody>
				</table>
				</div>
			</div>
			
			<div class="a_data_right">
				<div class="content_title2"><ul><li>S1</li></ul></div>
				<table class="auth_group display3">
					<caption>S1</caption>
					<thead>
						<tr>
							<th>번호</th>							
							<th>S1</th>	
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="tlt2">지진가속도계 고유번호</td>
							<td>6 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">제작사</td>
							<td>100 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">모델명</td>
							<td>20 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">일련번호</td>
							<td>30 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">가속도계분류</td>
							<td>영문 1자리</td>	
						</tr>
						<tr>
							<td class="tlt2">계측용도구분</td>
							<td>영문 1자리</td>	
						</tr>
						<tr>
							<td class="tlt2">설치층수</td>
							<td>4 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">계측채널 성문(ZNE)</td>
							<td>3 Byte 이내</td>	
						</tr>
						<tr>
							<td class="tlt2">계측계 고유번호</td>
							<td>9 Byte 문자형</td>	
						</tr>
					</tbody>
				</table>

				<br>
				
				<table class="auth_group display3">
					<caption>S2</caption>
					<thead>
						<tr>
							<th>번호</th>							
							<th>S2</th>	
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="tlt2">지진가속도계 고유번호</td>
							<td>6 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">제작사</td>
							<td>100 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">모델명</td>
							<td>20 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">일련번호</td>
							<td>30 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">가속도계분류</td>
							<td>영문 1자리</td>	
						</tr>
						<tr>
							<td class="tlt2">계측용도구분</td>
							<td>영문 1자리</td>	
						</tr>
						<tr>
							<td class="tlt2">설치층수</td>
							<td>4 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">계측채널 성문(ZNE)</td>
							<td>3 Byte 이내</td>	
						</tr>
						<tr>
							<td class="tlt2">계측계 고유번호</td>
							<td>9 Byte 문자형</td>	
						</tr>
					</tbody>
				</table>

				<br>
				
				<table class="auth_group display3">
					<caption>S3</caption>
					<thead>
						<tr>
							<th>번호</th>							
							<th>S3</th>	
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="tlt2">지진가속도계 고유번호</td>
							<td>6 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">제작사</td>
							<td>100 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">모델명</td>
							<td>20 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">일련번호</td>
							<td>30 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">가속도계분류</td>
							<td>영문 1자리</td>	
						</tr>
						<tr>
							<td class="tlt2">계측용도구분</td>
							<td>영문 1자리</td>	
						</tr>
						<tr>
							<td class="tlt2">설치층수</td>
							<td>4 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">계측채널 성문(ZNE)</td>
							<td>3 Byte 이내</td>	
						</tr>
						<tr>
							<td class="tlt2">계측계 고유번호</td>
							<td>9 Byte 문자형</td>	
						</tr>
					</tbody>
				</table>

				<br>
				
				<table class="auth_group display3">
					<caption>R1</caption>
					<thead>
						<tr>
							<th>번호</th>							
							<th>R1</th>	
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="tlt2">지진가속도계 고유번호</td>
							<td>6 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">제작사</td>
							<td>100 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">모델명</td>
							<td>20 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">일련번호</td>
							<td>30 Byte 문자형</td>	
						</tr>
						<tr>
							<td class="tlt2">기록계 품질 보증기간</td>
							<td>영문 1자리</td>	
						</tr>
						<tr>
							<td class="tlt2">기록저장방식</td>
							<td>영문 1자리</td>	
						</tr>
						<tr>
							<td class="tlt2">전송방식</td>
							<td>4 Byte 문자형</td>	
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
