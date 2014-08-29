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
	<c:import url="/EgovPageLink.do?link=estam/main/inc/EstamIncHeader" /> 
</div>
<!-- END:top_menu -->


<!-- STR:컨텐츠 -->	
<div id="contents_wrap">
	<div id="contents">
		
		<br>
		<div class="content_title"><h2>사용자관리</h2>
			<ul class="sub_nav">
				<li><a href="#">홈</a></li>
				<li><a href="#">시스템설정</a></li>
				<li class="last">사용자관리</li>    <!-- 맨 끝 li에 last class를 넣어주십시오 -->
			</ul>
		</div>
		

		<div class="inner">
		
			<div class="widget table_container">
				
				<div class="content_title"><ul><li>사용자관리</li></ul></div>
				<div class="widget_header">                        
					<ul class="last">
						<li>
							<fieldset class="inline">
								<label>구분</label>
								 <select title="" name="">
									<option value="">성명</option>
								</select>
								<input type="text" class="search_text4" id="" name="" title="" value="" >							
								<a href="#" class="css_button blue" onclick=""><span>조회</span></a>
							</fieldset> 
						</li>                        
					</ul>					
				</div>

				<div class="tableName">
					<div class="dataTables_wrapper">
						
						<table class="auth_group display data_table2 dataTable">
							<caption>기록계 목록</caption>
							<thead>
								<tr>
									<th>
										<div class="th_wrapp">NO</div>
									</th>
									
									<th>
										<div class="th_wrapp">회원ID</div>
									</th>
									
									<th>
										<div class="th_wrapp">권한그룹</div>
									</th>
									
									<th>
										<div class="th_wrapp">소속구분</div>
									</th>
									
									<th>
										<div class="th_wrapp">성명</div>
									</th>
									
									<th>
										<div class="th_wrapp">이메일</div>
									</th>

									<th>
										<div class="th_wrapp">휴대전화</div>
									</th>

									<th>
										<div class="th_wrapp">전화번호</div>
									</th>

									<th>
										<div class="th_wrapp">등록일자</div>
									</th>
								</tr>
							</thead>
							<tbody>
									<tr>
										<td>
										</td>
										
										<td>
										</td>
										
										<td>
										</td>
										
										<td>
										</td>
										
										<td>
										</td>

										<td>
										</td>
										
										<td>
										</td>
										
										<td>
										</td>
										
										<td>
										</td>									
									</tr>	
									<tr>
										<td>
										</td>
										
										<td>
										</td>
										
										<td>
										</td>
										
										<td>
										</td>
										
										<td>
										</td>

										<td>
										</td>
										
										<td>
										</td>
										
										<td>
										</td>
										
										<td>
										</td>									
									</tr>	
							</tbody>
						</table>
						
						<div class="comment">
							<ul>
								<li class="red">검색결과가 없습니다. 재조회 하시기 바랍니다.</li>
							</ul>
						</div>

					</div>
				</div>



			
				<div class="content_title"><ul><li>기본정보</li></ul></div>

					<div class="member_view">
						
						<fieldset>
							<ul class="dic_write_item">
								<li class="title"><strong>회원ID</strong></li>
								<li class="value">
									<input type="text" name="" title="" value="" style="" onkeypress="" maxlength="" >								
								</li>
							</ul>
							<ul class="dic_write_item">
								<li class="title"><strong>성명</strong></li>
								<li class="value">
									<input type="text" name="" title="" value="" style="" onkeypress="" maxlength="" >
								</li>
							</ul>
							<ul class="dic_write_item">
								<li class="title"><strong>패스워드</strong></li>
								<li class="value">
									<input type="text" name="" title="" value="" style="" onkeypress="" maxlength="" >
								</li>
							</ul>
						</fieldset>   
						
						<fieldset>
							<ul class="dic_write_item">
								<li class="title"><strong>권한그룹</strong></li>
								<li class="value">
									<select title="" name="">
										<option value="">권한그룹</option>
									</select>
								</li>
							</ul>
							<ul class="dic_write_item">
								<li class="title"><strong>소속구분</strong></li>
								<li class="value">
									<select title="" name="">
										<option value="">소속구분</option>
									</select>
								</li>
							</ul>
							<ul class="dic_write_item">
								<li class="title"><strong>이메일</strong></li>
								<li class="value">
									<input type="text" name="" title="" value="" style="" onkeypress="" maxlength="" >
								</li>
							</ul>
						</fieldset>

						<fieldset>
							<ul class="dic_write_item">
								<li class="title"><strong>휴대전화</strong></li>
								<li class="value">
									<input type="text" name="" title="" value='' class="tel" maxlength="4" onkeypress="">
									-
									<input type="text" name="" title="" value='' class="tel" maxlength="4" onkeypress="">
									-
									<input type="text" name="" title="" value='' class="tel" maxlength="4" onkeypress="">
								</li>
							</ul>
							<ul class="dic_write_item">
								<li class="title"><strong>전화번호</strong></li>
								<li class="value">
									<input type="text" name="" title="" value='' class="tel" maxlength="4" onkeypress="">
									-
									<input type="text" name="" title="" value='' class="tel" maxlength="4" onkeypress="">
									-
									<input type="text" name="" title="" value='' class="tel" maxlength="4" onkeypress="">
								</li>
							</ul>
						</fieldset>

						<fieldset class="last">
							<ul class="dic_write_item large">
								<li class="title"><strong>사용목적</strong></li>
								<li class="value auto">
								<input type="text" name="" title="" value="" class="search_text5" onkeypress="" maxlength="" >
								</li>                               
							</ul>
						</fieldset>
						
					</div> 
			</div>
		</div>

		<!-- btn_group -->
		<div class="btn_group">
			<a href="#" class="css_button" onclick=""><span>초기화</span></a>
			<a href="#" class="css_button blue" onclick=""><span>저장</span></a>
			<a href="#" class="css_button" onclick=""><span>삭제</span></a>
		</div>
		<!-- //btn_group -->


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
