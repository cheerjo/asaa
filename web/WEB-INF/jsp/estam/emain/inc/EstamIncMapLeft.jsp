<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  
 
<script type="text/javascript"> 
    function goLeftMapPage(mapFlag,linkUrl){
       // document.getElementById("flag").value=mapFlag;
       // document.getElementById("maplink").value="redirect:" + linkUrl;   
       // document.mapLeftForm.action = "<c:url value='/EgovPageLink.do'/>"; 
       // document.mapLeftForm.submit();
   	 $.ajax({
	     type : "POST" //"POST", "GET"
	     , async : false //true, false
	     , url : "${ctx}/arcgis/ArcGisMapView.do?flag=" + mapFlag//Request URL
	     , dataType : "html" //전송받을 데이터의 타입
	                                //"xml", "html", "script", "json" 등 지정 가능
	                                //미지정시 자동 판단
	     //, timeout : 30000 //제한시간 지정
	     , cache : false  //true, false
	     , data : ""  //$("#inputForm").serialize() //서버에 보낼 파라메터
	                      //form에 serialize() 실행시 a=b&c=d 형태로 생성되며 한글은 UTF-8 방식으로 인코딩
	                      //"a=b&c=d" 문자열로 직접 입력 가능
	                      //{a:b, c:d} json 형식 입력 가능
	     , contentType: "application/x-www-form-urlencoded; charset=UTF-8"
	     , error : function(request, status, error) {
	      //통신 에러 발생시 처리
	      alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
	     }
	     , success : function(response, status, request) {
	      //통신 성공시 처리 
	      $('#map_rightview').html(response);   
	     }
	    // , beforeSend: function() {
	      //통신을 시작할때 처리
	     // $('#ajax_indicator').show().fadeIn('fast');
	    // }
	    // , complete: function() {
	      //통신이 완료된 후 처리
	   //   $('#ajax_indicator').fadeOut();
	    // }
	 }); 
   	 
    } 
</script>
 	<!-- STR:지도 왼쪽 버튼 --> 
				<div class="map_btn">
					<ul>
						<li class="btn_map01"><a href="#LEFT" onclick="javascript:goLeftMapPage('PGA','<c:out value="${curLinkUrl}"/>')" title="PGA">PGA</a></li>	
						<li class="btn_map02"><a href="#LEFT" onclick="javascript:goLeftMapPage('MM','<c:out value="${curLinkUrl}"/>')" title="진도(MMI)">진도(MMI)</a></li>	
						<li class="btn_map03"><a href="#LEFT" onclick="javascript:goLeftMapPage('GVMT','<c:out value="${curLinkUrl}"/>')" title="계측소">계측소</a></li>	 
						<li class="btn_map06"><a href="#LEFT" onclick="javascript:goLeftMapPage('EVRS','<c:out value="${curLinkUrl}"/>')" title="안전성분석결과">안전성분석결과</a></li>	
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
							<td><img src="${ctx}/img/common/ico_map01.png" title="" /></td>
							<td>중앙행정기관(청사) (${readFctyLeft.fcty01})</td>
						</tr>
						<tr>
							<td><img src="${ctx}/img/common/ico_map02.png" title="" /></td>
							<td>국립대학교(${readFctyLeft.fcty02}) </td>
						</tr>
						<tr>
							<td><img src="${ctx}/img/common/ico_map03.png" title="" /></td>
							<td>공공건축물(${readFctyLeft.fcty03}) </td>
						</tr>
					</table>
					<table>
						<tr>
							<td><img src="${ctx}/img/common/ico_map04.png" title="" /></td>
							<td>공항시설 (${readFctyLeft.fcty04})</td>
						</tr>
						<tr>
							<td><img src="${ctx}/img/common/ico_map05.png" title="" /></td>
							<td>댐,저수지 (${readFctyLeft.fcty05})  </td>
						</tr>
						<tr>
							<td><img src="${ctx}/img/common/ico_map06.png" title="" /></td>
							<td>현수교(사장교)(${readFctyLeft.fcty06}) </td>
						</tr>
					</table>
					<table>
						<tr>
							<td><img src="${ctx}/img/common/ico_map07.png" title="" /></td>
							<td>가스시설(${readFctyLeft.fcty07})</td>
						</tr>
						<tr>
							<td><img src="${ctx}/img/common/ico_map08.png" title="" /></td>
							<td>고속철도(${readFctyLeft.fcty08})<br></td>
						</tr>
						<tr>
							<td><img src="${ctx}/img/common/ico_map09.png" title="" /></td>
							<td>원자력(${readFctyLeft.fcty09}) </td>
						</tr> 
						<tr>
							<td><img src="${ctx}/img/common/ico_map10.png" title="" /></td>
							<td>변전소 (${readFctyLeft.fcty10})</td>
						</tr>
						<tr>
							<td><img src="${ctx}/img/common/ico_map11.png" title="" /></td>
							<td>화력,수력발전설비(${readFctyLeft.fcty11})  </td>
						</tr>
						<tr>
							<td><img src="${ctx}/img/common/ico_map12.png" title="" /></td>
							<td>기타(${readFctyLeft.fcty12}) </td>
						</tr>
					</table>
				</div>  
				<!-- END:지도 왼쪽 아이콘 -->