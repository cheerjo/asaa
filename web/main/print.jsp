<%@ page language="java"	contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>국립재난안전연구원 지진가속도 응답신호 종합분석 시스템</title>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석 시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석">

<link rel="stylesheet" href="/css/style.css"> 
<script src="/js/ahn_common.js"></script>
     
</head>

<BODY>

<!-- STR:top_menu -->
<div id="print_wrap">
	<div class="pt_title">금천구청 긴급 건전성평가 결과 보고</div>

	<div class="pt_title01">
		<ul>
			<li><img src="/img/bg/heading2_bg_pt.jpg" /></li>
			<li>금천구청 긴급 건전성평가 결과</li>
		</ul>
	</div>
	<table>
		<thead>
		<tr>
			<td rowspan="2">평가지표</td>
			<td colspan="2">분석결과 <sup>※</sup> (%)</td>
			<td colspan="2">평가결과</td>
			<td rowspan="2">안전관리기준</td>
		</tr>
		<tr>			
			<td>장축</td>
			<td>단축</td>
			<td>장축</td>
			<td>단축</td>
		</tr>
		</thead>
		<tr>
			<td>최대층간변위비 <sup>1)</sup></td>
			<td>0.00</td>
			<td>0.00</td>
			<td class="pt_gray">안전</td>
			<td class="pt_gray">안전</td>
			<td>0.50% 이하</td>
		</tr>
		<tr>
			<td>고유진동수 변화율 <sup>2)</sup></td>
			<td>0.00</td>
			<td>0.00</td>
			<td class="pt_gray">안전</td>
			<td class="pt_gray">안전</td>
			<td>20% 이하</td>
		</tr>
		<tr>
			<td>건축물과 자유장<br> 고유진동수비 <sup>3)</sup></td>
			<td>0.00</td>
			<td>0.00</td>
			<td class="pt_gray">안전</td>
			<td class="pt_gray">안전</td>
			<td>20% 이하</td>
		</tr>
		<tr>
			<td>설치가속도 초과율 <sup>4)</sup></td>
			<td>0.00</td>
			<td>0.00</td>
			<td class="pt_gray">안전</td>
			<td class="pt_gray">안전</td>
			<td>20% 이하</td>
		</tr>
	</table>

	<ul class="pt_comment">
		<li>∴ 평가결과는 [안전] 또는 [점검필요] 로 표현되며 '건축물과 자유장 고유주기비'는 참고자료로써 활용</li>
		<li>※ 건물마다 다른 변동수준을 관리하기 위해서 분석결과는 무차원화하여 비율로 나타냄 (단위 없음)</li>
		<li style="float:left;">주</li>
			<ul style="float:left;margin:0 0 0 5px;">
				<li><sup>1)</sup>최대층간변위비 = </li>
				<li><sup>2)</sup>고유진동수 변화율 = </li>
				<li><sup>3)</sup>건축물/자유장 고유진동수비 = </li>
				<li><sup>4)</sup>설계가속도 초과율 = </li>
			</ul>
	</ul>
	<br class="clear">

	<div class="pt_title01">
		<ul>
			<li><img src="/img/bg/heading2_bg_pt.jpg" /></li>
			<li>데이터 정보</li>
		</ul>
	</div>
	<div class="pt_title02">
		<ul>
			<li><img src="/img/bg/bullet_green_pt.jpg" /></li>
			<li>최대가속도(gal)</li>
		</ul>
	</div>
	<div style="width:100%;">
		<div style="float:left;width:30%;">
			<table>
			<thead>
				<tr>
					<td colspan="2">자유장</td>
				</tr>
				<tr>
					<td>계측방향</td>
					<td>계측값</td>
				</tr>
				</thead>
				<tr>
					<td>동서</td>
					<td>0.34</td>
				</tr>
				<tr>
					<td>남북</td>
					<td>0.34</td>
				</tr>
				<tr>
					<td>수평성분합성</td>
					<td>0.34</td>
				</tr>
				<tr>
					<td>연직</td>
					<td>0.34</td>
				</tr>
			</table>
		</div>
		<div style="float:right;width:68%;">
			<table>
				<thead>
				<tr>
					<td colspan="4">건축물</td>
				</tr>
				<tr>
					<td>계측방향</td>
					<td>최하층</td>
					<td>중간층</td>
					<td>최상층</td>
				</tr>
				</thead>
				<tr>
					<td>장축1</td>
					<td>0.00</td>
					<td>0.00</td>
					<td>0.00</td>
				</tr>
				<tr>
					<td>단축1</td>
					<td>0.00</td>
					<td>0.00</td>
					<td>0.00</td>
				</tr>
				<tr>
					<td>단축2</td>
					<td>0.00</td>
					<td>0.00</td>
					<td>0.00</td>
				</tr>
				<tr>
					<td>연직</td>
					<td>0.00</td>
					<td>0.00</td>
					<td>0.00</td>
				</tr>
			</table>
		</div>
		<br class="clear">
	</div>
	
	<br/>
	<div class="pt_title02">
		<ul>
			<li><img src="/img/bg/bullet_green_pt.jpg" /></li>
			<li>보조자료</li>
		</ul>
	</div>
	<div style="width:100%;">
		<div style="float:left;width:68%;">
			<table>
				<thead>
				<tr>
					<td rowspan="2" colspan="2"></td>
					<td rowspan="2">최대변위<br/>(mm)</td>
					<td colspan="2">고유진동수</td>
				</tr>
				<tr>
					<td>상시 계측값</td>
					<td>현재 계측값</td>
				</tr>
				</thead>
				<tr>
					<td colspan="2">자유장</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td rowspan="2">건축물<br/>(최상층)</td>
					<td>장축</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>단축</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>

		<div style="float:right;width:30%;">
			<table>
				<thead>
				<tr>
					<td>건축물 <br/> 높이(m)</td>
					<td>설계지반 <br/> 가속도 <br/> (gal)</td>
				</tr>
				</thead>
				<tr>
					<td style="height:60px;"></td>
					<td></td>
				</tr>
			</table>
		</div>
		<br class="clear">
	</div>

	<div class="pt_title01">
		<ul>
			<li><img src="/img/bg/heading2_bg_pt.jpg" /></li>
			<li>검토결과</li>
		</ul>
	</div>
	<table>
		<tr>
			<td class="pt_gray" style="width:100px;"><b>붙임 1</b></td>
			<td style="text-align:left;">계측값 상세</td>
		</tr>
	</table>

	<div class="pt_title01">
		<ul>
			<li><img src="/img/bg/heading2_bg_pt.jpg" /></li>
			<li>자유장 계측값</li>
		</ul>
	</div>
	<table>
		<thead>
		<tr>
			<td style="width:150px;"></td>
			<td>동서</td>
			<td>남북</td>
			<td>연직</td>
		</tr>
		</thead>
		<tr>
			<td>최대지반가속도<br/>(gal (cm/sec<sup>2</sup>))</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>		
			<td>최대지반속도<br/>(mm/sec)</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>최대지반변위 (mm)</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>지반진동수 (Hz)</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td>누적절대속도 <br/>(mm/sec)</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="4"><b>자유장 가속도 응답 스펙트럼</b></td>
		</tr>
		<tr>
			<td colspan="4">그래프영역</td>
		</tr>
	</table>

	
	<div class="pt_title01">
		<ul>
			<li><img src="/img/bg/heading2_bg_pt.jpg" /></li>
			<li>건축물 계측값</li>
		</ul>
	</div>
	<table>
		<thead>
		<tr>
			<td style="width:150px;"></td>
			<td>장축</td>
			<td>단축</td>
		</tr>
		</thead>
		<tr>
			<td>최대층간변위비 (%)</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>최대층최대변위 (mm)</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>최대층 최대가속도<br/>(gal (cm/sec<sup>2</sup>))</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>고유진동수 (Hz)</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="3"><b>최상층 상대변위</b></td>
		</tr>
		<tr>
			<td colspan="3">그래프영역</td>
		</tr>
	</table>
	
</div>
<!-- END:footer -->

</BODY>
</HTML>
