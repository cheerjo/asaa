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
		<div class="content_title"><h2>시설물기본정보관리</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">시설물상세정보</a></li>
				<li class="last">시설물기본정보관리</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>

		<div class="a_data_total">
			<div class="a_data_left2">
				<div class="widget_header2">                        
					<ul class="last">
						<li>
							<fieldset class="inline2">
								<input type="checkbox" name="" title="" value="" ><label for="">발생</label>
								<input type="text" name="" title="" value="" class="small" onkeypress="" maxlength="" > 년	- 	
								<input type="text" name="" title="" value="" class="small" onkeypress="" maxlength="" > 년
								<div class="btn2">
									<ul>
										<li><a href="#" class="css_button" onclick=""><span>최근1년</span></a></li>
										<li><a href="#" class="css_button" onclick=""><span>최근10년</span></a></li>
									</ul>
								</div>
							</fieldset> 
							<fieldset class="inline2">
								<input type="checkbox" name="" title="" value="" ><label for="">규모</label>
								<input type="text" name="" title="" value="" class="small" onkeypress="" maxlength="" > &nbsp; - &nbsp;
								<input type="text" name="" title="" value="" class="small" onkeypress="" maxlength="" >
								<div class="btn2">
									<ul>
										<li><input type="checkbox" name="orgYn" title="구분" id="" value="" onClick="" ></li>
										<li><input type="radio" name="orgYn" title="구분" id="" value="" onClick="" ><label for="">육지</label></li>
										<li><input type="radio" name="orgYn" title="구분" id="" value="" onClick="" ><label for="">바다</label></li>
									</ul>
								</div>
							</fieldset> 
							<fieldset class="inline2">
								<input type="checkbox" name="" title="" value="" ><label for="">검색</label>
								<input type="text" name="" title="" value="" class="large" onkeypress="" maxlength="" > 
								<div class="btn2">
									<a href="#" class="css_button blue" onclick=""><span>실행</span></a>							
								</div>
							</fieldset> 
						</li>                        
					</ul>					
				</div>
				<div class="widget_header3" style="height:650px;overflow-y:scroll;"> 
					<table class="buil_list_tb" id="chTable">
						<caption>시설물 목록</caption>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
						<tr>
							<td class="num2">1</td>
							<td>전북 군산시 어청도 동북동쪽 20km 해역<br><font class="add">2013/06/29 &nbsp;&nbsp;13:32:48</font></td>
						</tr>
					</table>
				</div>

				<div class="a_pop">
					<div class="a_pop_btn">
						<a href="#"><img src="/img/btn/btn_close.png" title="닫기" /></a>
					</div>
					<ul>
						<li class="title_a"><a href="#">M2.5 전북 군산시 어청도 동북동쪽 20km 해역</a></li>
						<li>시간 : 2013-00-00 00:00:00</li>
						<li>위치 : 26.00 </li>
						<li>깊이 : 00km </li>
					</ul>
				</div>

				<div class="a_pop_comment">
					계측된 시설물 수 : 600
				</div>

			</div>
			
			<div style="float:left;">
				<div class="map_tab">
					<ul>
						<li class="on"><a href="#">전국</a></li>
						<li><a href="#">경기도</a></li>
						<li><a href="#">충청북도</a></li>
						<li><a href="#">충청남도</a></li>
						<li><a href="#">경상북도</a></li>
						<li><a href="#">경상남도</a></li>
						<li><a href="#">전라북도</a></li>
						<li><a href="#">전라남도</a></li>
						<li><a href="#">강원도</a></li>
						<li><a href="#">제주도</a></li>
					</ul>
					<div class="map_tab_btn">
						<a href="#"><img src="/img/btn/btn_down.png" title="다운받기" /></a>
						<a href="#"><img src="/img/btn/btn_print.png" title="프린트하기" /></a>
					</div>
				</div>
				<div class="a_data_center2">
					<div class="content_title2"><ul><li>시설물 기본정보</li></ul></div>		
					<table class="auth_group display2">
						<caption>시설물 기본정보 목록</caption>
						
						<tbody>						
							<tr>
								<td class="tlt">계측소명</td>
								<td colspan="4" class="line_bg"><b>금천구청(30 Byte 이내 문자)</b></td>																		
							</tr>
							<tr>
								<td class="tlt">시설물 위치</td>
								<td colspan="4">치서울특별시 금천구 시흥동 1020 (번지 및 기타 주소)리</td>																		
							</tr>
							<tr>
								<td class="tlt" rowspan="2">시설물 코드</td>
								<td class="line_bg">기관코드</td>	
								<td class="line_bg">계측소 코드</td>		
								<td class="line_bg">시설물 종류</td>		
								<td class="line_bg">행정구역 코드</td>		
							</tr>
							<tr>
								<td>****</td>	
								<td>****</td>	
								<td>****</td>	
								<td>****</td>	
							</tr>
							<tr>
								<td class="tlt" rowspan="2">건물개요</td>
								<td class="line_bg">기관코드</td>	
								<td class="line_bg">계측소 코드</td>		
								<td class="line_bg">시설물 종류</td>		
								<td class="line_bg">행정구역 코드</td>		
							</tr>
							<tr>
								<td>****</td>	
								<td>****</td>	
								<td>****</td>	
								<td>****</td>	
							</tr>
							<tr>
								<td class="tlt" rowspan="2">규모</td>
								<td class="line_bg">기관코드</td>	
								<td class="line_bg">계측소 코드</td>		
								<td class="line_bg">시설물 종류</td>		
								<td class="line_bg">행정구역 코드</td>		
							</tr>
							<tr>
								<td>****</td>	
								<td>****</td>	
								<td>****</td>	
								<td>****</td>	
							</tr>
							<tr>
								<td class="tlt" rowspan="2">구조</td>
								<td class="line_bg" colspan="2">기관코드</td>	
								<td class="line_bg">계측소 코드</td>
								<td class="line_bg">계측소 코드</td>		
							</tr>
							<tr>
								<td colspan="2">****</td>	
								<td>****</td>	
								<td>****</td>	
							</tr>
						</tbody>
					</table>
					
					<div class="buil_view">
						<img src="/img/etc/photo3.jpg" title="" />
					</div>				
				</div>
				
				<div class="a_data_right2">
					<div class="content_title3"><ul><li>시설물 목록</li></ul></div>	
					<div style="height:813px;overflow-y:scroll;">
						<div class="buil_list_a">
							<ul>
								<li class="buil_list_a_tlt">금천구청</li>
								<li>서울특별시 금천구 시흥동 1020 | 철골구조 | 지상 10층</li>
								<li>2008년 준공 | 계측기 정상 | 계측이벤트 8개 </li>
							</ul>
							<div class="buil_list_a_btn">
								<img src="/img/btn/btn_under.png" title="" />
							</div>
						</div>
						<div class="buil_list_a">
							<ul>
								<li class="buil_list_a_tlt">금천구청</li>
								<li>서울특별시 금천구 시흥동 1020 | 철골구조 | 지상 10층</li>
								<li>2008년 준공 | 계측기 정상 | 계측이벤트 8개 </li>
							</ul>
							<div class="buil_list_a_btn">
								<img src="/img/btn/btn_under.png" title="" />
							</div>
						</div>
						<div class="buil_list_a">
							<ul>
								<li class="buil_list_a_tlt">금천구청</li>
								<li>서울특별시 금천구 시흥동 1020 | 철골구조 | 지상 10층</li>
								<li>2008년 준공 | 계측기 정상 | 계측이벤트 8개 </li>
							</ul>
							<div class="buil_list_a_btn">
								<img src="/img/btn/btn_under.png" title="" />
							</div>
						</div>
						<div class="buil_list_a">
							<ul>
								<li class="buil_list_a_tlt">금천구청</li>
								<li>서울특별시 금천구 시흥동 1020 | 철골구조 | 지상 10층</li>
								<li>2008년 준공 | 계측기 정상 | 계측이벤트 8개 </li>
							</ul>
							<div class="buil_list_a_btn">
								<img src="/img/btn/btn_under.png" title="" />
							</div>
						</div>
						<div class="buil_list_a">
							<ul>
								<li class="buil_list_a_tlt">금천구청</li>
								<li>서울특별시 금천구 시흥동 1020 | 철골구조 | 지상 10층</li>
								<li>2008년 준공 | 계측기 정상 | 계측이벤트 8개 </li>
							</ul>
							<div class="buil_list_a_btn">
								<img src="/img/btn/btn_under.png" title="" />
							</div>
						</div>
						<div class="buil_list_a">
							<ul>
								<li class="buil_list_a_tlt">금천구청</li>
								<li>서울특별시 금천구 시흥동 1020 | 철골구조 | 지상 10층</li>
								<li>2008년 준공 | 계측기 정상 | 계측이벤트 8개 </li>
							</ul>
							<div class="buil_list_a_btn">
								<img src="/img/btn/btn_under.png" title="" />
							</div>
						</div>
						<div class="buil_list_a">
							<ul>
								<li class="buil_list_a_tlt">금천구청</li>
								<li>서울특별시 금천구 시흥동 1020 | 철골구조 | 지상 10층</li>
								<li>2008년 준공 | 계측기 정상 | 계측이벤트 8개 </li>
							</ul>
							<div class="buil_list_a_btn">
								<img src="/img/btn/btn_under.png" title="" />
							</div>
						</div>
						<div class="buil_list_a">
							<ul>
								<li class="buil_list_a_tlt">금천구청</li>
								<li>서울특별시 금천구 시흥동 1020 | 철골구조 | 지상 10층</li>
								<li>2008년 준공 | 계측기 정상 | 계측이벤트 8개 </li>
							</ul>
							<div class="buil_list_a_btn">
								<img src="/img/btn/btn_under.png" title="" />
							</div>
						</div>
						<div class="buil_list_a">
							<ul>
								<li class="buil_list_a_tlt">금천구청</li>
								<li>서울특별시 금천구 시흥동 1020 | 철골구조 | 지상 10층</li>
								<li>2008년 준공 | 계측기 정상 | 계측이벤트 8개 </li>
							</ul>
							<div class="buil_list_a_btn">
								<img src="/img/btn/btn_under.png" title="" />
							</div>
						</div>
						<div class="buil_list_a">
							<ul>
								<li class="buil_list_a_tlt">금천구청</li>
								<li>서울특별시 금천구 시흥동 1020 | 철골구조 | 지상 10층</li>
								<li>2008년 준공 | 계측기 정상 | 계측이벤트 8개 </li>
							</ul>
							<div class="buil_list_a_btn">
								<img src="/img/btn/btn_under.png" title="" />
							</div>
						</div>
						<div class="buil_list_a">
							<ul>
								<li class="buil_list_a_tlt">금천구청</li>
								<li>서울특별시 금천구 시흥동 1020 | 철골구조 | 지상 10층</li>
								<li>2008년 준공 | 계측기 정상 | 계측이벤트 8개 </li>
							</ul>
							<div class="buil_list_a_btn">
								<img src="/img/btn/btn_under.png" title="" />
							</div>
						</div>
						<div class="buil_list_a">
							<ul>
								<li class="buil_list_a_tlt">금천구청</li>
								<li>서울특별시 금천구 시흥동 1020 | 철골구조 | 지상 10층</li>
								<li>2008년 준공 | 계측기 정상 | 계측이벤트 8개 </li>
							</ul>
							<div class="buil_list_a_btn">
								<img src="/img/btn/btn_under.png" title="" />
							</div>
						</div>
					</div>
				</div>
				<br class="clear">
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
