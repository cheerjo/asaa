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

<!-- STR:컨텐츠 -->	
<div id="contents_popup">
			
		<div class="content_title"><ul><li>시설물 개요</li></ul></div>
		<table class="auth_group display3">
			<caption></caption>
			<tbody>
				<tr>
					<td class="tlt3" rowspan="2">점검대상</td>									
					<td rowspan="2">000구청</td>									
					<td class="tlt3">건물규모</td>
					<td>지하#층/지상#층</td>
					<td class="tlt3">공고일</td>
					<td>2000.00.00</td>
				</tr>
				<tr>
					<td class="tlt3">건물높이</td>									
					<td>지하00m/지상00m</td>									
					<td class="tlt3">계약일</td>
					<td>2000.00.00</td>
				</tr>
				<tr>
					<td class="tlt3">주소</td>									
					<td colspan="3"><div style="text-align:left;padding-left:20px;">##시 00구 XXX로</div></td>									
					<td class="tlt3">준공(예정)일</td>
					<td>2000.00.00</td>
				</tr>
			</tbody>
		</table>		

		<br/>

		<div class="content_title"><ul><li>관리자 개요</li></ul></div>
		<table class="auth_group display4">
			<caption></caption>
			<thead>
				<tr>
					<th></th>	
					<th>담당자</th>	
					<th>소속</th>
					<th>직책</th>
					<th>연락처</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="num5">담당부서</td>
					<td>홍길동</td>
					<td>000구청</td>
					<td>주무관</td>
					<td>000-0000-0000</td>
				</tr>
				<tr>
					<td class="num5">설치기관</td>
					<td>홍길동</td>
					<td>000구청</td>
					<td>주무관</td>
					<td>000-0000-0000</td>
				</tr>
				<tr>
					<td class="num5">계측기 공급기관</td>
					<td>홍길동</td>
					<td>000구청</td>
					<td>주무관</td>
					<td>000-0000-0000</td>
				</tr>
			</tbody>
		</table>

		<br/>

		<div class="content_title"><ul><li>현장점검 개요</li></ul></div>
		<table class="auth_group display4">
			<caption></caption>
			<thead>
				<tr>
					<th>현장점검<br>요청일</th>	
					<th>현장점검<br>실시일</th>	
					<th>현장점검<br>결과보고일</th>
					<th>현장점검<br>결과</th>
					<th>현장점검<br>결과보고서 파일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>20##.00.00</td>
					<td>20##.00.00</td>
					<td>20##.00.00</td>
					<td>보안필요</td>
					<td><a href="#" class="css_button" onclick=""><span>파일찾기</span></a></td>
				</tr>
			</tbody>
		</table>

		<br/>

		<div class="content_title">
			<ul><li>센서 정보</li></ul>
			<div class="btn"><a href="#" class="css_button blue" onclick=""><span>추가</span></a></div>
		</div>
		<table class="auth_group display4">
			<caption></caption>
			<thead>
				<tr>
					<th>순번</th>
					<th>설치위치</th>
					<th>성분</th>	
					<th>모델명/일련번호</th>
					<th>제작자</th>
					<th>인증기관</th>
					<th>인증일</th>
					<th>설치일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>자유장</td>
					<td>3</td>
					<td><a href="#" class="css_button" onclick=""><span>검색</span></a></td>					
					<td></td>
					<td>한국지질자원<br>연구원</td>
					<td>20##.00.00</td>
					<td>20##.00.00</td>				
				</tr>
				<tr>
					<td>1</td>
					<td>자유장</td>
					<td>3</td>
					<td><a href="#" class="css_button" onclick=""><span>검색</span></a></td>					
					<td></td>
					<td>한국지질자원<br>연구원</td>
					<td>20##.00.00</td>
					<td>20##.00.00</td>				
				</tr>
				<tr>
					<td>1</td>
					<td>자유장</td>
					<td>3</td>
					<td><a href="#" class="css_button" onclick=""><span>검색</span></a></td>					
					<td></td>
					<td>한국지질자원<br>연구원</td>
					<td>20##.00.00</td>
					<td>20##.00.00</td>				
				</tr>
				<tr>
					<td>1</td>
					<td>자유장</td>
					<td>3</td>
					<td><a href="#" class="css_button" onclick=""><span>검색</span></a></td>					
					<td></td>
					<td>한국지질자원<br>연구원</td>
					<td>20##.00.00</td>
					<td>20##.00.00</td>				
				</tr>
			</tbody>
		</table>


		<br/>

		<div class="content_title">
			<ul><li>기록계 정보</li></ul>
			<div class="btn"><a href="#" class="css_button blue" onclick=""><span>추가</span></a></div>
		</div>
		<table class="auth_group display4">
			<caption></caption>
			<thead>
				<tr>
					<th>순번</th>
					<th>설치위치</th>
					<th>성분</th>	
					<th>모델명/일련번호</th>
					<th>제작자</th>
					<th>인증기관</th>
					<th>인증일</th>
					<th>설치일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>자유장</td>
					<td>3</td>
					<td><a href="#" class="css_button" onclick=""><span>검색</span></a></td>					
					<td></td>
					<td>한국지질자원<br>연구원</td>
					<td>20##.00.00</td>
					<td>20##.00.00</td>				
				</tr>
				<tr>
					<td>1</td>
					<td>자유장</td>
					<td>3</td>
					<td><a href="#" class="css_button" onclick=""><span>검색</span></a></td>					
					<td></td>
					<td>한국지질자원<br>연구원</td>
					<td>20##.00.00</td>
					<td>20##.00.00</td>				
				</tr>
			</tbody>
		</table>


		<br/>
		<div class="widget table_container">	
			<div class="content_title"><ul><li>도면 정보</li></ul></div>
				<div class="member_view">	
						
					<fieldset class="last">							
						<ul class="dic_write_item" style="width:800px;padding:5px 0 7px 0;">								
							<li>
								<input type="text" name="" title="" value="" style="width:780px;" onkeypress="" maxlength="" > 									
							</li>
						</ul>
						<div class="btn_group" style="padding:5px 0 0 0;">
							<a href="#" class="css_button blue" onclick=""><span>파일찾기</span></a>
						</div>
					</fieldset>
					
				</div> 
		</div> 
</div>
<!-- END:컨텐츠 -->	


</BODY>
</HTML>
