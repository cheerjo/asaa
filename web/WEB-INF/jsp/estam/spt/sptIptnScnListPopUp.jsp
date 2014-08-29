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
        
        function fn_search() {
        	var form = document.zipCodeForm;
        	
        	if( form.dong.value == "" ) {
        		alert("검색하실 동/읍/면을 입력하십시오.");
        		form.dong.focus();
        		return;
        	}
        	
        	form.zipCodeType.value = "1";
        	form.action = "<c:url value='/cmmnl/zipCodeList.do' />";
        	form.submit();
        }
        
        function fn_close() {
            window.close();
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
<form:form commandName="zipCodeVO" name="zipCodeForm" method="post">
    <input type="hidden" name="pageIndex"  value="<c:out value='${zipCodeVO.pageIndex}'/>"/>
    <input type="hidden" name="zipCodeType" value="">
    
    <input type="hidden" name="formNm" value="<c:out value='${formNm}'/>">
    <input type="hidden" name="zip1FormNm" value="<c:out value='${zip1FormNm}'/>">
    <input type="hidden" name="zip2FormNm" value="<c:out value='${zip2FormNm}'/>">
    <input type="hidden" name="addr1FormNm" value="<c:out value='${addr1FormNm}'/>">

    <c:choose>
	    <c:when test="${zipCodeVO.zipCodeType == '2'}">
	        <div class="category_popup_wrapper category_popup_wrapper2">
		        <div class="popup_content_wrapper center">
		            <fieldset class="zipcode_select">
		                <input type="radio" id="radio1-1" name="zipCodeTypeRadio" value="1" onclick="fn_zipcode_type('1');"> <label for="radio1-1">(구)우편번호</label>
		                <input type="radio" id="radio1-2" name="zipCodeTypeRadio" value="2" onclick="fn_zipcode_type('2');" checked> <label for="radio1-2">(신)도로명우편번호</label>
		            </fieldset>
		            
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
		                        
		                        <c:forEach var="result" items="${resultList}" varStatus="status">
			                        <tr>
			                            <td class="zipcode"><c:out value="${fn:substring(result.zip, 0, 3)}" />-<c:out value="${fn:substring(result.zip, 3, 6)}" /></td>
			                            <td class="address"><a href="#panel5" onclick="fn_select_cd('<c:out value="${result.zip}"/>', '<c:out value="${result.sido}"/> <c:out value="${result.sigungu}"/> <c:out value="${result.doroNm}"/> <c:out value="${result.bldgMainNo}"/><c:if test="${not empty result.bldgSubNo && result.bldgSubNo != '0'}">-<c:out value="${result.bldgSubNo}"/></c:if> <c:if test="${not empty result.bldgNm}"><c:out value="${result.bldgNm}"/></c:if> (<c:out value="${result.lawDong}"/>)')"><c:out value="${result.sido}"/> <c:out value="${result.sigungu}"/> <c:out value="${result.doroNm}"/> <c:out value="${result.bldgMainNo}"/><c:if test="${not empty result.bldgSubNo && result.bldgSubNo != '0'}">-<c:out value="${result.bldgSubNo}"/></c:if> <c:if test="${not empty result.bldgNm}"><c:out value="${result.bldgNm}"/></c:if> (<c:out value="${result.lawDong}"/>)</a></td>
			                        </tr>
		                        </c:forEach>
		                        
		                        <c:if test="${fn:length(resultList) == 0}">
			                        <tr>
			                            <td colspan="2">조회된 우편번호가 없습니다.</td>
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
		            <fieldset class="zipcode_select">
		                <input type="radio" id="radio1-1" name="zipCodeTypeRadio" value="1" onclick="fn_zipcode_type('1');" checked> <label for="radio1-1">(구)우편번호</label>
		                <input type="radio" id="radio1-2" name="zipCodeTypeRadio" value="2" onclick="fn_zipcode_type('2');"> <label for="radio1-2">(신)도로명우편번호</label>
		            </fieldset>
		            
		            <p>찾으실 지역의 동/읍/면/리 명을 입력해주세요.</p>
		            <fieldset>
		                <label for="text1">우편번호 검색</label> 
		                <input type="text" id="text1" name="dong" value="<c:out value='${zipCodeVO.dong}'/>" style="ime-mode:active;" onfocus="this.select();"> 
		                <a href="#panel2" class="css_button" onclick="fn_search()"><span>검색</span></a>
		            </fieldset>
		            
		        </div>
		        
		        <div class="category_table zipcode">
		            <div class="dataTables_wrapper">
		                
		                <table class="display data_table2 dataTable">
		                    <caption>&gt; 아래 우편번호 검색결과에서 원하시는 주소를 선택해주세요.</caption>
		                    <tbody>
		                        <c:forEach var="result" items="${resultList}" varStatus="status">
		                            <tr>
		                                <td class="zipcode"><c:out value="${fn:substring(result.zip, 0, 3)}" />-<c:out value="${fn:substring(result.zip, 3, 6)}" /></td>
		                                <td class="address"><a href="#panel5" onclick="fn_select_cd('<c:out value="${result.zip}"/>', '<c:out value="${result.fullAddr}"/>')"><c:out value="${result.fullAddr}"/></a></td>
		                            </tr>
		                        </c:forEach>
		                        
		                        <c:if test="${fn:length(resultList) == 0}">
		                            <tr>
		                                <td colspan="2">조회된 우편번호가 없습니다.</td>
		                            </tr>
		                        </c:if>
		                    </tbody>
		                </table>
		                
		            </div>
		        </div>
		    </div>
	    </c:otherwise>
	</c:choose>

</form:form>    
</body>
</html>