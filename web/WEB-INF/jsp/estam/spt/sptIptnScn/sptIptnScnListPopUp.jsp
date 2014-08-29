<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>

<%
/**
 * @Class Name : sptIptnScnListPopUp.jsp
 * @Description : 센서정보 조회
 * @Modification Information
 * 
 *   수정일         수정자                   수정내용
 *  -------    --------    ---------------------------
 *  2013.12.07            최초 생성
 *
 * author NECIS 개발팀
 * since 2013.12.07
 */
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    
    <title>센서정보 검색</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="description" content="지진가속도 응답신호 종합분석시스템 웹사이트입니다.">
    <meta name="keywords" content="지진가속도,응답신호,종합분석시스템">
    
    <link rel="stylesheet" href="${ctx}/css/style.css"> 
    
    <link rel="stylesheet" href="<c:url value='/assets/css/style.css' />"> 
    <link rel="stylesheet" href="<c:url value='/assets/css/custom.css' />">
    
    <script type="text/javascript">
	    /* 페이징 */
	    function fn_page_move(pageNo){ 
	    	var form = document.zipCodeForm;
	        
	        if( form.pSido.value == "" ) {
                alert("검색하실 시/도를 선택하십시오.");
                form.pSido.focus();
                return;
            }
            
            if( form.pSigungu.value == "" ) {
                alert("검색하실 시/군/구를 입력하십시오.");
                form.pSigungu.focus();
                return;
            }
            
            if( form.pLawDong.value == "" && form.pDoroNm.value == "" && form.pLawRi.value == "" && form.pBldgNm.value == "" ) {
                alert("법정동,도로명,리,건물명 중 하나 이상을 입력하십시오.");
                return;
            }
	        
	        form.pageIndex.value = pageNo;
	        form.zipCodeType.value = "2";
	        form.action = "<c:url value='/cmmnl/zipCodeDoroList.do' />";
	        form.submit();
	    }    
	    
	    function fn_select_cd(zipcode, addr1) { 
            var zipcode1 = zipcode.substring(0,3);
            var zipcode2 = zipcode.substring(3,6);
            
              <c:if test="${ not empty zip1FormNm }"> 
                window.opener.document.<c:out value="${formNm}"/>.<c:out value="${zip1FormNm}"/>.value = zipcode1; 
	            //window.opener.document.getElementsByName("<c:out value="${zip1FormNm}"/>").value = zipcode1; 
	          </c:if>
	          
	          <c:if test="${ not empty zip2FormNm }"> 
	            window.opener.document.<c:out value="${formNm}"/>.<c:out value="${zip2FormNm}"/>.value = zipcode2; 
	            //window.opener.document.getElementsByName("<c:out value="${zip2FormNm}"/>").value = zipcode2; 
	          </c:if>
	          
	          <c:if test="${ not empty addr1FormNm }"> 
	            window.opener.document.<c:out value="${formNm}"/>.<c:out value="${addr1FormNm}"/>.value = addr1; 
	            //window.opener.document.getElementsByName("<c:out value="${addr1FormNm}"/>").value = addr1; 
	          </c:if>
          
          window.close();
        }
        
	    // 검색
        function fn_search() {
        	
       // 	alert("111111111");
        	var form = document.sptIptnScnForm;
        	
        	if( form.ehqkScnMdl.value == "" ) {
        		alert("검색하실 센서정보를 입력하십시오.");
        		form.ehqkScnMdl.focus();
        		return;
        	}

       // 	form.pageIndex.value = "1";

        	form.action = "<c:url value='/sptIptnRslt/sptIptnScnSearchList.do' />";
        	form.submit();
        }
        
        // 취소
        function fn_cancel() {
            window.close();
        }
        
        // 센서정보 추가
        function fn_insert() {
        	var form = document.sptIptnScnForm;
        	var checkCnt = 0; // 체크카운트
        	var sncChk = form.checkDownload;
        	
        	if(document.forms["sptIptnScnForm"]["checkDownload"].length > 1){
        		
        		
        		for (var i=0; i<document.forms["sptIptnScnForm"]["checkDownload"].length; i++) {
        	        
        	        
        	        if(form.checkDownload[i].checked){
        	        	checkCnt++;
        			}
        	    }
        		
        	//	alert("checkCnt:" + checkCnt);
        		if(checkCnt==0){
        			alert("최소한 하나의 대상은 선택하여야 합니다.");
        			return;
        		}
        		 var lo = 0;
        		    if( checkCnt >= 1 ) {
        		        for (var i=0; i<document.forms["sptIptnScnForm"]["checkDownload"].length; i++) {
        		        	
        		            if( form.checkDownload[i].checked ) {
        		          //  	alert("checkCnt:");	
        		                if(lo == 0){
        		                    document.forms["sptIptnScnForm"]["ehqkScnMdlList"].value = document.forms["sptIptnScnForm"]["ehqkScnMdl"][i].value;
        		                    document.forms["sptIptnScnForm"]["ehqkScnIstlPosList"].value = document.forms["sptIptnScnForm"]["ehqkScnIstlPos"][i].value;
        		                    document.forms["sptIptnScnForm"]["ehqkScnChlList"].value = document.forms["sptIptnScnForm"]["ehqkScnChl"][i].value;
        		                    document.forms["sptIptnScnForm"]["ehqkScnCmpyList"].value = document.forms["sptIptnScnForm"]["ehqkScnCmpy"][i].value;
        		                    document.forms["sptIptnScnForm"]["ehqkScnAuthInttList"].value = document.forms["sptIptnScnForm"]["ehqkScnAuthIntt"][i].value;
        		                } else {
        		                    document.forms["sptIptnScnForm"]["ehqkScnMdlList"].value = document.forms["sptIptnScnForm"]["ehqkScnMdlList"].value + "|" 
        		                        + document.forms["sptIptnScnForm"]["ehqkScnMdl"][i].value;
        		                    document.forms["sptIptnScnForm"]["ehqkScnIstlPosList"].value = document.forms["sptIptnScnForm"]["ehqkScnIstlPosList"].value + "|" 
    		                        	+ document.forms["sptIptnScnForm"]["ehqkScnIstlPos"][i].value;
        		                    document.forms["sptIptnScnForm"]["ehqkScnChlList"].value = document.forms["sptIptnScnForm"]["ehqkScnChlList"].value + "|" 
    		                        	+ document.forms["sptIptnScnForm"]["ehqkScnChl"][i].value;
        		                    document.forms["sptIptnScnForm"]["ehqkScnCmpyList"].value = document.forms["sptIptnScnForm"]["ehqkScnCmpyList"].value + "|" 
    		                        	+ document.forms["sptIptnScnForm"]["ehqkScnCmpy"][i].value;
        		                    document.forms["sptIptnScnForm"]["ehqkScnAuthInttList"].value = document.forms["sptIptnScnForm"]["ehqkScnAuthInttList"].value + "|" 
    		                        	+ document.forms["sptIptnScnForm"]["ehqkScnAuthIntt"][i].value;
        		                }
        		                lo = lo + 1;
        		            }
        		        }
        		    }
        		    
        	    var ehqkScnMdlList = document.forms["sptIptnScnForm"]["ehqkScnMdlList"].value;
        	    var ehqkScnIstlPosList = document.forms["sptIptnScnForm"]["ehqkScnIstlPosList"].value;
        	    var ehqkScnChlList = document.forms["sptIptnScnForm"]["ehqkScnChlList"].value;
        	    var ehqkScnCmpyList = document.forms["sptIptnScnForm"]["ehqkScnCmpyList"].value;
        	    var ehqkScnAuthInttList = document.forms["sptIptnScnForm"]["ehqkScnAuthInttList"].value;
        		
        	    alert("ehqkScnMdlList:" + ehqkScnMdlList);
        	}else {
        		if(document.forms["sptIptnScnForm"]["checkDownload"].checked){
        			var fileList = document.forms["sptIptnScnForm"]["filename"].value;
        		}else{
        			alert("최소한 하나의 대상은 선택하여야 합니다.");
        			return;
        		}
        	}
        	
        	form.action = "<c:url value='/cmmnl/zipCodeDoroList.do' />";
        	
        	alert("form.action:" + form.action);
            form.submit();
        	
      //      var startCalendar = form.observeDate.value;
      //      var endCalendar = form.observeDateSecond.value;
      //      var startChkCnt = 0;
      //      var endChkCnt = 0;
      //      if(startCalendar.length !=10){
      //  		alert("시작 날짜 입력칸에 '2013-01-01' 형식으로 입력 하여야 합니다.");
      //  		return;
      //  	}    
            
      //      for(var i=0; i<startCalendar.length; i++){
      //  		if(startCalendar.charAt(i) == '-'){
      //  			startChkCnt++;
      //  		}
      //  	}
            
      //  	if(startChkCnt!=2){
      //  		alert("시작 날짜 입력칸에 '2013-01-01' 형식으로 입력 하여야 합니다.");
      // 		return;
      //  	}
            
      //  	if(endCalendar.length !=10){
      //  		alert("종료 날짜 입력칸에 '2013-01-01' 형식으로 입력 하여야 합니다.");
      //  		return;
      //  	}    
            
      //      for(var i=0; i<endCalendar.length; i++){
      //  		if(endCalendar.charAt(i) == '-'){
      //  			endChkCnt++;
      //  		}
      //  	}
            
      //  	if(endChkCnt!=2){
      //  		alert("종료 날짜 입력칸에 '2013-01-01' 형식으로 입력 하여야 합니다.");
      //  		return;
      //  	}
      /*  	
        	var startYear = startCalendar.substring(0,4);
        	strTemp = startCalendar.substring(5);
        	var startMonth = strTemp.substring(0,strTemp.indexOf("-"));
        	var startDate = strTemp.substring(strTemp.indexOf("-") + 1);
        	
        	var endYear = endCalendar.substring(0,4);
        	strTemp = endCalendar.substring(5);
        	var endMonth = strTemp.substring(0,strTemp.indexOf("-"));
        	var endDate = strTemp.substring(strTemp.indexOf("-") + 1);
        	
        	if(startMonth > 12){
        		alert("시작 입력 월을 입력하세요");
        	}
        	
        	if( (startYear % 4 == 0) && (startYear % 100 !=0) || (startYear % 400 == 0)){
        		if(startMonth == 4 || startMonth == 6 || startMonth == 9 || startMonth == 11){
        			if( startDate > 30){
        				alert("시작 날짜를 확인해 주세요");
        				return;
        			}
        		}else if(startMonth == 2){
        			if(startDate > 29){
        				alert("시작 날짜를 확인해 주세요");
        				return;
        			}
        		}else{
        			if(startDate > 31){
        				alert("시작 날짜를 확인해 주세요");
        				return;
        			}
        		}
        	}else{
        		if(startMonth == 4 || startMonth == 6 || startMonth == 9 || startMonth == 11){
        			if(startDate > 30){
        				alert("시작 날짜를 확인해 주세요");
        				return;
        			}
        		}else if(startMonth == 2){
        			if(startDate > 28){
        				alert("시작 날짜를 확인해 주세요");
        				return;
        			}
        		}else{
        			if(startDate > 31){
        				alert("시작 날짜를 확인해 주세요");
        				return;
        			}
        		}
        	}
        	
        	if(endMonth > 12){
        		alert("종료 입력 월을 입력하세요");
        	}
        	
        	if( (endYear % 4 == 0) && (endYear % 100 !=0) || (endYear % 400 == 0)){
        		if(endMonth == 4 || endMonth == 6 || endMonth == 9 || endMonth == 11){
        			if( endDate > 30){
        				alert("종료 날짜를 확인해 주세요");
        				return;
        			}
        		}else if(endMonth == 2){
        			if(endDate > 29){
        				alert("종료 날짜를 확인해 주세요");
        				return;
        			}
        		}else{
        			if(endDate > 31){
        				alert("종료 날짜를 확인해 주세요");
        				return;
        			}
        		}
        	}else{
        		if(endMonth == 4 || endMonth == 6 || endMonth == 9 || endMonth == 11){
        			if(endDate > 30){
        				alert("종료 날짜를 확인해 주세요");
        				return;
        			}
        		}else if(endMonth == 2){
        			if(endDate > 28){
        				alert("종료 날짜를 확인해 주세요");
        				return;
        			}
        		}else{
        			if(endDate > 31){
        				alert("종료 날짜를 확인해 주세요");
        				return;
        			}
        		}
        	}
            
        	var startHour = form.observeHour.value;
        	var startMin = form.observeMin.value;
        	
        	var endHour = form.observeHourSecond.value;
        	var endMin = form.observeMinSecond.value;
        	
        	
        	if(0 > startHour || startHour>23){
        		alert("시작 시의 범위를 0~23로 해주세요");
        		return;
        	}
        	
        	if(0 > startMin || startMin>59){
        		alert("시작 시의 범위를 0~59로 해주세요");
        		return;
        	}
            
        	if(0 > endHour || endHour>23){
        		alert("종료시의 범위를 0~23로 해주세요");
        		return;
        	}
            
        	if(0 > endMin || endMin>59){
        		alert("종료 분의 범위를 0~59로 해주세요");
        		return;
        	}
            
        	var checkInitCalandar = new Date(startYear,startMonth -1,startDate,startHour,startMin,00);
        	var checkFiniCalandar = new Date(endYear,endMonth -1,endDate,endHour,endMin,00);
        	
        	if(checkFiniCalandar - checkInitCalandar > 86400000){
        		alert("구간의 간격을 24시간을 초과할수 없습니다.");
        		return;
        	}

        	var nowDate = new Date();
        	getStrHour = nowDate.getHours() - 9;
        	getStrMin =  nowDate.getMinutes();

        	var checkNowCalandar = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), getStrHour, getStrMin);
        	if(checkNowCalandar - checkFiniCalandar < 600000){
        		alert("종료 시간을 현재 시간 보다 10분 이내를 설정 할 수 없습니다. (UTC 기준) 현재시각"+" "+ getStrHour + "시 " + getStrMin + "분");
        		return;
        	}
        		
           	var scWidth = screen.availWidth/2-250;
           	var scHeight = screen.availHeight/2-50;
           	var userId = form.userId.value;
            
        	window.open(
        			"<c:url value='/usernl/earthquake/earthquake_down_popup_form.do?fileList="
        					+fileList+"&startCalendar="+startCalendar+"&startHour="+startHour+"&startMin="+startMin
        					+"&endCalendar="+endCalendar+"&endHour="+endHour+"&endMin="+endMin+"&userId="+userId+"'/>", 
        					"earthquake_down_popup_form", 'top='+scHeight+',left='+scWidth+',width=450, height=170,location=no,scrollbars=no,resizable=no,status=no,center=yes');
            */
        }
        
        function fn_onload_cursor() {
        	var form = document.zipCodeForm;
        	
        	<c:if test="${ empty zipCodeVO.zipCodeType || zipCodeVO.zipCodeType == '1' }"> 
        	    form.dong.focus();
        	</c:if>
        }
        
        function fn_zipcode_type(type) {
            var form = document.zipCodeForm;
            
            if( type == "1" ) {
            	form.zipCodeType.value = "1";
            	form.action = "<c:url value='/cmmnl/zipCodeList.do' />";
            } else {
            	form.zipCodeType.value = "2";
            	form.action = "<c:url value='/cmmnl/zipCodeDoroList.do' />";
            }
            
            form.submit();
        }
        
        function fn_search2() {
            var form = document.zipCodeForm;
            
            if( form.pSido.value == "" ) {
                alert("검색하실 시/도를 선택하십시오.");
                form.pSido.focus();
                return;
            }
            
            if( form.pSigungu.value == "" ) {
            	alert("검색하실 시/군/구를 입력하십시오.");
                form.pSigungu.focus();
                return;
            }
            
            if( form.pLawDong.value == "" && form.pDoroNm.value == "" && form.pLawRi.value == "" && form.pBldgNm.value == "" ) {
            	alert("법정동,도로명,리,건물명 중 하나 이상을 입력하십시오.");
            	return;
            }
            
            form.pageIndex.value = "1";
            form.zipCodeType.value = "2";
            form.action = "<c:url value='/cmmnl/zipCodeDoroList.do' />";
            form.submit();
        }
    </script>
</head>

<body class="popup" onload="fn_onload_cursor();">
<form:form commandName="sptIptnScnVO" name="sptIptnScnForm" method="post">
    
    <input type="hidden" name="formNm" value="<c:out value='${formNm}'/>">
    <input type="hidden" name="ehqkScnMdlList"  value=""/>
    <input type="hidden" name="ehqkScnIstlPosList"  value=""/>
    <input type="hidden" name="ehqkScnChlList"  value=""/>
    <input type="hidden" name="ehqkScnCmpyList"  value=""/>
    <input type="hidden" name="ehqkScnAuthInttList"  value=""/>
    <c:choose>
	    <c:when test="${zipCodeVO.zipCodeType == '2'}">
	        <div class="category_popup_wrapper category_popup_wrapper2">
		        <div class="popup_content_wrapper center">
		        <!-- 
		            <fieldset class="zipcode_select">
		                <input type="radio" id="radio1-1" name="zipCodeTypeRadio" value="1" onclick="fn_zipcode_type('1');"> <label for="radio1-1">(구)우편번호</label>
		                <input type="radio" id="radio1-2" name="zipCodeTypeRadio" value="2" onclick="fn_zipcode_type('2');" checked> <label for="radio1-2">(신)도로명우편번호</label>
		            </fieldset>
		         -->
		             
		            <p>
				                시/도 및 시/군/구를  반드시 입력하신 후<br>
				                도로명, 건물명, 법정동(읍,면) 중 하나 이상 입력하여 검색하십시오.<br>
				                (신 도로명 참조사이트 : <a href="http://www.juso.go.kr/" target="_blank" title="신도로명 참조사이트 새창열림">http://www.juso.go.kr/</a>)
		            </p>
		            
		            <div class="new_address_select">
		                <fieldset>
		                    <ul>
		                        <li>
		                            <label for="select1">* 시/도</label>
		                            <select name="pSido" style="width:120px">
		                                <c:forEach var="sido" items="${sidoList}" varStatus="status">
	                                        <option value="<c:out value='${sido.cdNm}'/>" <c:if test="${zipCodeVO.pSido == sido.cdNm}">selected</c:if>><c:out value='${sido.cdNm}'/></option>
	                                    </c:forEach>
		                            </select>
		                        </li>
		                        <li>
		                            <label for="text1">읍,면,동</label>
		                            <input type="text" name="pLawDong" id="text1" style="width:104px" value="<c:out value='${zipCodeVO.pLawDong}'/>" style="ime-mode:active;" onfocus="this.select();" >
		                        </li>
		                        <li>
		                            <label for="text2">도로명</label>
		                            <input type="text" name="pDoroNm" id="text2" style="width:104px" value="<c:out value='${zipCodeVO.pDoroNm}'/>" style="ime-mode:active;" onfocus="this.select();" >
		                        </li>
		                    </ul>
		                </fieldset>
		                
		                <fieldset>
		                    <ul>
		                        <li>
		                            <label for="text3">* 시/군/구</label>
		                            <input type="text" name="pSigungu" id="text3" value="<c:out value='${zipCodeVO.pSigungu}'/>" style="ime-mode:active;" onfocus="this.select();">
		                        </li>
		                        <li>
		                            <label for="text4">리</label>
		                            <input type="text" name="pLawRi" id="text4" value="<c:out value='${zipCodeVO.pLawRi}'/>" style="ime-mode:active;" onfocus="this.select();">
		                        </li>
		                        <li>
		                            <label for="text5">건물명</label>
		                            <input type="text" name="pBldgNm" id="text5" value="<c:out value='${zipCodeVO.pBldgNm}'/>" style="ime-mode:active;" onfocus="this.select();">
		                        </li>
		                    </ul>
		                </fieldset>
		                
		                <fieldset class="search_btn">
		                    <a href="#panel5" class="css_button" onclick="fn_search2();"><span>검색</span></a>
		                </fieldset>
		                
		            </div>
		       </div>
		       
		       <div class="category_table2 zipcode">
		            <div class="dataTables_wrapper">
		                
		                <table class="display data_table2 dataTable">
		                    <caption>&gt; 아래 우편번호 검색결과에서 원하시는 주소를 선택해주세요.</caption>
		                    <tbody>
		                        
		                        <c:forEach var="result" items="${sptIptnScnSearchList}" varStatus="status">
			                        <tr>
			                            <td class="zipcode"><input type="hidden" name="ehqkScnMdl" value="<c:out value='${result.ehqkScnMdl}'/>"><c:out value="${result.ehqkScnMdl}"/></td>
			                            <td class="zipcode"><input type="hidden" name="ehqkScnCmpy" value="<c:out value='${result.ehqkScnCmpy}'/>"><c:out value="${result.ehqkScnCmpy}"/></td>
			                            <input type="hidden" name="ehqkScnMdl" value="<c:out value='${result.ehqkScnMdl}'/>">
			                            <input type="hidden" name="ehqkScnMdl" value="<c:out value='${result.ehqkScnMdl}'/>">
			                            <input type="hidden" name="ehqkScnMdl" value="<c:out value='${result.ehqkScnMdl}'/>">
			                            <input type="hidden" name="ehqkScnMdl" value="<c:out value='${result.ehqkScnMdl}'/>">
			                        </tr>
		                        </c:forEach>
		                        
		                        <c:if test="${fn:length(sptIptnScnSearchList) == 0}">
			                        <tr>
			                            <td colspan="2">조회된 센서정보가 없습니다.</td>
			                        </tr>
		                        </c:if>
		                    </tbody>
		                </table>
		                
		                <div class="dataTables_paginate paging_full_numbers">
                            <ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_page_move" />
                        </div>
		                
		            </div>
		        </div>
		    
		    </div>
	    </c:when>
	    <c:otherwise>
	        <div class="category_popup_wrapper category_popup_wrapper2">
		        <div class="popup_content_wrapper center">
		        <!-- 
		            <fieldset class="zipcode_select">
		                <input type="radio" id="radio1-1" name="zipCodeTypeRadio" value="1" onclick="fn_zipcode_type('1');" checked> <label for="radio1-1">(구)우편번호</label>
		                <input type="radio" id="radio1-2" name="zipCodeTypeRadio" value="2" onclick="fn_zipcode_type('2');"> <label for="radio1-2">(신)도로명우편번호</label>
		            </fieldset>
		         -->
		             
		            <p>■ 센서정보</p>
		            <fieldset>
		                <label for="text1">모델 명</label> 
		                <input type="text" id="text1" name="ehqkScnMdl" value="<c:out value='${sptIptnScnVO.ehqkScnMdl}'/>" style="ime-mode:active;" onfocus="this.select();"> 
		                <div class="btn"><a href="#" class="css_button blue" onclick="fn_search()"><span>검색</span></a></div>
		            </fieldset>
		            
		        </div>
		        
		        <div class="category_table zipcode">
		            <div class="dataTables_wrapper">
		                
		                <table class="display data_table2 dataTable">
		                    <caption></caption>
		                    <thead>
								<tr>
								    <th class="check"><input type="checkbox" title="전체선택" name="checkAll" onclick="fn_selectAll(this.checked);"></th>
									<th>모델명</th>
									<th>설치위치</th>
									<th>성분 종류</th>	
									<th>제작자</th>
									<th>인증기관</th>
								</tr>
							</thead>
		                    <tbody>
		                        <c:forEach var="result" items="${sptIptnScnSearchList}" varStatus="status">
		                            <tr>
		                                <td><input type="checkbox" title="선택" name="checkDownload"></td>
		                                <td class="zipcode"><input type="hidden" name="ehqkScnMdl"      id="ehqkScnMdl"      value="${result.ehqkScnMdl}"/>       <c:out value="${result.ehqkScnMdl}"/></td>      <!-- 모델명 -->
		                                <td class="zipcode"><input type="hidden" name="ehqkScnIstlPos"  id="ehqkScnIstlPos"  value="${result.ehqkScnIstlPos}"/>   <c:out value="${result.ehqkScnIstlPos}"/></td>  <!-- 설치위치 -->
		                                <td class="zipcode"><input type="hidden" name="ehqkScnChl"      id="ehqkScnChl"      value="${result.ehqkScnChl}"/>       <c:out value="${result.ehqkScnChl}"/></td>      <!-- 성분종류 -->
			                            <td class="zipcode"><input type="hidden" name="ehqkScnCmpy"     id="ehqkScnCmpy"     value="${result.ehqkScnCmpy}"/>      <c:out value="${result.ehqkScnCmpy}"/></td>     <!-- 제작사 -->
			                            <td class="zipcode"><input type="hidden" name="ehqkScnAuthIntt" id="ehqkScnAuthIntt" value="${result.ehqkScnAuthIntt}"/>  <c:out value="${result.ehqkScnAuthIntt}"/></td> <!-- 인증기관 -->
		                            </tr>
		                            <c:if test="${status.last }">
                                    	<input type="hidden" name="listCnt" id="listCnt" value="${status.count }"/>
                                	</c:if>
		                        </c:forEach>
		                        
		                        <c:if test="${fn:length(sptIptnScnSearchList) == 0}">
		                            <tr>
		                              <!--    <td colspan="2">조회된 센서정보가 없습니다.</td> -->
		                                <td colspan="2"><spring:message code="common.nodata.msg" /></td>
		                            </tr>
		                        </c:if>
		                    </tbody>
		                </table>
		                
		            </div>
		        </div>
		        
		       <!-- btn_group -->
                <div class="btn_group">
                    
       				<div class="btn"><a href="#" class="css_button blue" onclick="fn_cancel()"><span>취소</span></a></div>
       				<div class="btn"><a href="#" class="css_button blue" onclick="fn_insert(document.sptIptnScnForm.listCnt.value)"><span>확인</span></a></div>
       				
                </div>
                <!-- //btn_group -->
                
                <!-- pagination --> 
		    </div>
	    </c:otherwise>
	</c:choose>

</form:form>    
</body>
</html>