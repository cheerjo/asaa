<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
		
		<br>
		<div class="content_title"><h2>현장점검보고서</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">지진가속도계측기관리</a></li>
				<li class="last">현장점검보고서</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>
		

		<div class="inner">
		
			<div class="widget table_container">	
			
				<div class="content_title"><ul><li>정렬방식</li></ul></div>

					<div class="member_view">
						
						<fieldset>
							<ul class="dic_write_item">
								<li class="title"><strong>지역</strong></li>
								<li class="value">
									<select title="" name="">
										<option value="">서울</option>
									</select>							
								</li>
							</ul>
							<ul class="dic_write_item">
								<li class="title"><strong>시설물유형</strong></li>
								<li class="value">
									<select title="" name="">
										<option value="">지자체청사</option>
									</select>
								</li>
							</ul>
							<ul class="dic_write_item">
								<li class="title"><strong>점검결과</strong></li>
								<li class="value">
									<select title="" name="">
										<option value="">보안필요</option>
									</select>
								</li>
							</ul>
						</fieldset>   
						
						<fieldset class="last">
							<ul class="dic_write_item">
								<li class="title"><strong>준공일</strong></li>
								<li>
									<input type="text" name="" title="" value="" style="width:80px;" onkeypress="" maxlength="" > 
									<img src="/img/btn/btn_cal.gif"/> 
									-
									<input type="text" name="" title="" value="" style="width:80px;" onkeypress="" maxlength="" > 
									<img src="/img/btn/btn_cal.gif"/> 
								</li>
							</ul>
							<ul class="dic_write_item">
								<li class="title"><strong>현장점검실시일</strong></li>
								<li>
									<input type="text" name="" title="" value="" style="width:80px;" onkeypress="" maxlength="" > 
									<img src="/img/btn/btn_cal.gif"/> 
									-
									<input type="text" name="" title="" value="" style="width:80px;" onkeypress="" maxlength="" > 
									<img src="/img/btn/btn_cal.gif"/> 
								</li>
							</ul>

							<div class="btn_group">
								<a href="#" class="css_button blue" onclick=""><span>검색</span></a>
							</div>
						</fieldset>

						
						
					</div> 
				

				<div class="tableName">
					<div class="dataTables_wrapper">
						
						<table class="auth_group display dataTable">
							<caption></caption>
							<thead>
								<tr>
									<th>
										<div class="th_wrapp">NO</div>
									</th>
									
									<th>
										<div class="th_wrapp">시설물유형</div>
									</th>
									
									<th>
										<div class="th_wrapp">지역</div>
									</th>
									
									<th>
										<div class="th_wrapp">시설물명칭</div>
									</th>
									
									<th>
										<div class="th_wrapp">준공일</div>
									</th>
									
									<th>
										<div class="th_wrapp">현장점검<br> 실시일</div>
									</th>

									<th>
										<div class="th_wrapp">점검결과</div>
									</th>

									<th>
										<div class="th_wrapp">계측기<br>공급기관</div>
									</th>

									<th>
										<div class="th_wrapp">현장점검<br>결과보고서</div>
									</th>

									<th>
										<div class="th_wrapp">계측기<br>정보</div>
									</th>
								</tr>
							</thead>
							<tbody>
									<tr>
										<td>1</td>
										
										<td>지자체청사</td>
										
										<td>경기</td>
										
										<td>
											<a href="#" class="css_button" onclick=""><span>군포시청</span></a>
										</td>
										
										<td>2013.00.00</td>

										<td>2013.00.00</td>
										
										<td>보완필요</td>
										
										<td>AKGC</td>
										
										<td><img src="/img/btn/file.png"/> </td>
										
										<td><img src="/img/btn/play.png"/> </td>
									</tr>

									<tr>
										<td>1</td>
										
										<td>국립대학교</td>
										
										<td>전북</td>
										
										<td>
											<a href="#" class="css_button" onclick=""><span>군산대학교</span></a>
										</td>
										
										<td>2013.00.00</td>

										<td>2013.00.00</td>
										
										<td>보완필요</td>
										
										<td>희송지오텍</td>
										
										<td><img src="/img/btn/file.png"/> </td>
										
										<td><img src="/img/btn/play.png"/> </td>
									</tr>
							</tbody>
						</table>
						<!-- 
						<div class="comment">
							<ul>
								<li class="red">검색결과가 없습니다. 재조회 하시기 바랍니다.</li>
							</ul>
						</div> -->

					</div>
				</div>

				<div class="btn_group">
					<div style="padding:5px 0 0 0;">
						<a href="#" alt="파일저장"><img src="/img/btn/btn_down2.png"/></a>
						<a href="#" alt="파일저장"><img src="/img/btn/btn_print2.png"/></a>
					</div>

				</div>
			
			</div>
		</div>



	</div>	
</div>
<!-- END:컨텐츠 -->	


<!-- STR:footer -->
<div id="footer">
 <c:import url="/EgovPageLink.do?link=estam/main/inc/EstamIncFooter" /> 
</div>
<!-- END:footer -->

</BODY>
</HTML>
