<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  

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


<link rel="stylesheet" href="${ctx}/css/style.css">     
 <script src="${ctx}/js/estam_common.js"></script>  
 <script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script>
 <script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script> 
 <script type="text/javascript" src="<c:url value='/js/jquery/ui/calendar.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/js/egovframework/com/sym/cal/EgovCalPopup.js'/>" ></script>
 <script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/utl/EgovCmmUtl.js'/>" ></script>
 
 <script type="text/javascript">
 
 jQuery(document).ready(function(){
	 
	 var sptForm = document.sptIptnForm;
	 var pEqDtView = sptForm.pEqDtView.value;
	 
     stime = addDay(getTimeStamp().substring(0,10),-90);
     etime = addDay(getTimeStamp().substring(0,10),0);

  //   alert("sptIptnRsltCnt:" + $(':input[name=fctyCplnSDt]'));
     if( pEqDtView == ""){
    	 $(':input[name=fctyCplnSDt]').val(stime);
         $(':input[name=fctyCplnEDt]').val(etime);
         
         $(':input[name=sptIptnSDt]').val(stime);
         $(':input[name=sptIptnEDt]').val(etime);
     }
     
     
  //   document.sptIptnForm.fctyCplnSDt.readOnly = false;
 
     
 });  
 
 function sptIptnRslSearch(){  
     document.sptIptnForm.action = "<c:url value='/spt/SptIptnRsltReport.do'/>"; 
     document.sptIptnForm.submit();
 }
 function excelDownload(){ 
       var sptForm = document.sptIptnForm;
       sptForm.action = "<c:url value='/spt/SptIptnRsltReportExcel.do'/>";
       sptForm.submit();
 }
 
 function sptIptnRsltView(fctyCd, gvmtCd, sptInptDt) {
     var param = "?fctyCd="+fctyCd+"&gvmtCd="+gvmtCd+"&sptInptDt="+sptInptDt;
     var url = '<c:url value="/sptIptnRslt/addSptIptnRsltView.do"/>';
     var win = window.open(url+param, "1040", "800", "center:yes; help:no; status:no; resizable:no; scroll:yes");
     if(win.focus){
         win.focus();
     }     
 }
 
 /* 20131204 수정본 */
 function sptView(fctyCd, gvmtCd, sptInptDt, conDaGbcd) {
     var param = "?fctyCd="+fctyCd+"&gvmtCd="+gvmtCd+"&iptDt="+sptInptDt+"&conDaGbcd=02";
     var url = '<c:url value="/scn/addSptIptnRsltFctyMgrInfo.do"/>';
     var win = window.open(url+param, "1040", "800", "center:yes; help:no; status:no; resizable:no; scroll:yes");
     if(win.focus){
         win.focus();
     }     
 }
 
 /* 파일다운로드 */
 function fn_fileDownload(orginlFileNm, fileLc){

     //원래는 디렉터리 정보를 가지고 가야하지만, 임시 디렉터리로 가야하므로 주소를 하드 코딩함. 
     var fileLc = "/web/ROOT/up_file/AC/SL/";
     
  
     //var fileLc = fileLc;
     //청에서 테스트 할 땐, 상기 디렉터리명, 파일명을 지워줄 것.
     var orginlFileNm = "20131218.pptx";
     //var orginlFileNm = orginlFileNm;
    // alert(orginlFileNm);
    // alert(fileLc);

    var form = document.move_page;
	form.action = "<c:url value='/sptIptnRslt/fileDown.do?orginlFileNm="+orginlFileNm+"&fileLc="+fileLc+"'/>";
	form.submit();
	
   //  window.open("<c:url value='/sptIptnRslt/fileDown.do?orginlFileNm="+orginlFileNm+"&fileLc="+fileLc+"'/>");
     
 } 
 
  </script>
  <script type="text/javascript">
      function addDay(d, cnt){
            //var mmDate = new Date(d);
            var mmDate = new Date();
            var dayofMonth = mmDate.getDate();
            mmDate.setDate(dayofMonth + cnt);
            
            var year = mmDate.getFullYear(),
            month =  mmDate.getMonth()+1, 
            day = mmDate.getDate();

            month = fn_filZero(month);
            day = fn_filZero(day);

            return year + '-' + month + '-' + day;      
        }

     function fn_filZero(str){
         if (+str < 10) {
             str = '0' + str;
         }
         return str;
     }  
     function getTimeStamp() {
            var d = new Date();

            var s =
              fn_filZero(d.getFullYear(), 4) + '-' +
              fn_filZero(d.getMonth() + 1, 2) + '-' +
              fn_filZero(d.getDate(), 2) + ' ' +
              
              fn_filZero(d.getHours(), 2) + ':' +
              fn_filZero(d.getMinutes(), 2) + ':' +
              fn_filZero(d.getSeconds(), 2);
                
              return s;
     }
  </script>
</head>

<BODY>

<!-- STR:top_menu -->
<div id="top_wrap">
      <c:import url="/main/EstamIncHeader.do?flag=MAIN" /> 
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
             <form:form commandName="searchVO" name="sptIptnForm" id="sptIptnForm" method="post">
                <input type="hidden" name="cal_url" value="<c:url value='/sym/cal/EgovNormalCalPopup.do'/>" />
                <input type="hidden" name="pEqDtView" value=""/>
                <input type="hidden" name="pEqDt2View" value=""/>
                <div class="content_title"><ul><li>정렬방식</li></ul></div>
                    <div class="member_view">
                        
                        <fieldset>
                            <ul class="dic_write_item">
                                <li class="title"><strong>지역</strong></li>
                                <li class="value">
                                    <form:select path="fctyAreaCd" multiple="false">
                                        <form:option value="" label="전국" /> 
                                         <form:options items="${fctyAreaList}" itemValue="commDtlCd" itemLabel="commDtlNm" />
                                    </form:select>                          
                                </li>
                            </ul>
                            <ul class="dic_write_item">
                                <li class="title"><strong>시설물유형</strong></li>
                                <li class="value">
                                    <form:select path="fctyKndCd" multiple="false"> 
                                        <form:option value="" label="전체" />
                                        <form:options items="${fctyKndList}" itemValue="commDtlCd" itemLabel="commDtlNm" /> 
                                    </form:select>
                                </li>
                            </ul>
                            <ul class="dic_write_item">
                                <li class="title"><strong>점검결과</strong></li>
                                <li class="value">
                                    <form:select path="sptIptnRsltYn" multiple="false"> 
                                        <form:option value="Y" label="적합" /> 
                                        <form:option value="N" label="부적합" /> 
                                    </form:select>                                      
                                </li>
                            </ul>
                            
                            
                            <ul class="dic_write_item">
                                <li class="title"><strong>준공일</strong></li>
                                <li>
                                    <input type="text" id="fctyCplnSDt" name="fctyCplnSDt" title="" value="" style="width:80px;" onfocus="setInFocusFormat(this);" onblur="setOutFocusFormat2(this);" > 
                                    <img src="<c:url value='/img/btn/btn_cal.gif'/>" onclick="javascript:fn_egov_NormalCalendar(document.sptIptnForm, document.sptIptnForm.pEqDtView, document.sptIptnForm.fctyCplnSDt);" alt="달력창 열기" />
                                    - 
                                    <input type="text" id="fctyCplnEDt" name="fctyCplnEDt" title="" value="" style="width:80px;" onfocus="setInFocusFormat(this);" onblur="setOutFocusFormat2(this);" > 
                                    <img src="<c:url value='/img/btn/btn_cal.gif'/>" onclick="javascript:fn_egov_NormalCalendar(document.sptIptnForm, document.sptIptnForm.pEqDt2View, document.sptIptnForm.fctyCplnEDt);" style="cursor:hand"  alt="달력창 열기" /> 
                                </li>
                            </ul>
                            
                            <ul class="dic_write_item">
                                <li class="title"><strong>현장점검실시일</strong></li>
                                <li>
                                    <input type="text" name="sptIptnSDt" id="sptIptnSDt" title="달력" value="" style="width:80px;" onfocus="setInFocusFormat(this);" onblur="setOutFocusFormat2(this);">  
                                    <img src="<c:url value='/img/btn/btn_cal.gif'/>" onclick="javascript:fn_egov_NormalCalendar(document.sptIptnForm, document.sptIptnForm.pEqDtView, document.sptIptnForm.sptIptnSDt);" style="cursor:hand"  alt="달력창 열기" />  
                                    -
                                    <input type="text" name="sptIptnEDt" id="sptIptnEDt" title="달력" value="" style="width:80px;" onfocus="setInFocusFormat(this);" onblur="setOutFocusFormat2(this);">  
                                    <img src="<c:url value='/img/btn/btn_cal.gif'/>" onclick="javascript:fn_egov_NormalCalendar(document.sptIptnForm, document.sptIptnForm.pEqDtView, document.sptIptnForm.sptIptnEDt);" style="cursor:hand"  alt="달력창 열기" /> 
                                </li>
                            </ul>
                            <div class="btn_group">
                                <a href="#" class="css_button blue" onclick="javascript:sptIptnRslSearch();"><span>검색</span></a>
                            </div> 
                        </fieldset>   
  
  						<!-- 
                        <fieldset>
                        
                            <ul class="dic_write_item">
                                <li class="title"><strong>준공일</strong></li>
                                <li>
                                    <input type="text" id="fctyCplnSDt" name="fctyCplnSDt" title="" value="" style="width:80px;" onfocus="setInFocusFormat(this);" onblur="setOutFocusFormat2(this);" > 
                                    <img src="<c:url value='/img/btn/btn_cal.gif'/>" onclick="javascript:fn_egov_NormalCalendar(document.sptIptnForm,document.sptIptnForm.fctyCplnSDt);" style="cursor:hand"  alt="달력창 열기" />
                                    - 
                                    <input type="text" id="fctyCplnEDt" name="fctyCplnEDt" title="" value="" style="width:80px;" onfocus="setInFocusFormat(this);" onblur="setOutFocusFormat2(this);" > 
                                    <img src="<c:url value='/img/btn/btn_cal.gif'/>" onclick="javascript:fn_egov_NormalCalendar(document.sptIptnForm,document.sptIptnForm.fctyCplnEDt);" style="cursor:hand"  alt="달력창 열기" /> 
                                </li>
                            </ul>
                                                	

                            <ul class="dic_write_item">
                                <li class="title"><strong>현장점검실시일</strong></li>
                                <li>
                                    <input type="text" name="sptIptnSDt" id="sptIptnSDt" title="달력" value="" style="width:80px;" onfocus="setInFocusFormat(this);" onblur="setOutFocusFormat2(this);">  
                                    <img src="<c:url value='/img/btn/btn_cal.gif'/>" onclick="javascript:fn_egov_NormalCalendar(document.sptIptnForm,document.sptIptnForm.sptIptnSDt);" style="cursor:hand"  alt="달력창 열기" />  
                                    -
                                    <input type="text" name="sptIptnEDt" id="sptIptnEDt" title="달력" value="" style="width:80px;" onfocus="setInFocusFormat(this);" onblur="setOutFocusFormat2(this);">  
                                    <img src="<c:url value='/img/btn/btn_cal.gif'/>" onclick="javascript:fn_egov_NormalCalendar(document.sptIptnForm,document.sptIptnForm.sptIptnEDt);" style="cursor:hand"  alt="달력창 열기" /> 
                                </li>
                            </ul>
                      		
                      		<div class="btn_group">
                                <a href="#" class="css_button blue" onclick="javascript:sptIptnRslSearch();"><span>검색</span></a>
                            </div>
                            
                        </fieldset>

                      -->  
                        
                    </div> 
                </form:form>

                <div class="tableName">
                    <div class="dataTables_wrapper">
                        <div class="widget_header3" id="FctyLeftScl"  style="height:530px;overflow-y:scroll;"> 
                        <table id="chTable" class="buil_list_tb auth_group display dataTable"> 
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
                                <c:set var="iCnt" value="1"/>
                                <c:forEach var="sptIptnRsltList" items="${sptIptnRsltList}" varStatus="status">                             
                                    <tr>
                                        <td>${iCnt}</td>
                                        <td>${sptIptnRsltList.fctyKndNm}</td>
                                        <td>${sptIptnRsltList.fctyAreaNm}</td>
                                        <td>
                                            <a href="javascript:sptIptnRsltView('${sptIptnRsltList.fctyCd}', '${sptIptnRsltList.gvmtCd}','${sptIptnRsltList.sptIptnDt}');" class="css_button" onclick=""><span>${sptIptnRsltList.fctyNm}</span></a>
                                        </td>
                                        <td>${sptIptnRsltList.fctyCplnDt}</td>
                                        <td>${sptIptnRsltList.sptIptnDt}</td>
                                        <td><c:if test="${sptIptnRsltList.sptIptnRsltYn == 'Y'}">적합</c:if><c:if test="${sptIptnRsltList.sptIptnRsltYn == 'N'}">부접합</c:if></td>
                                        <td>${sptIptnRsltList.istlDept}</td>
                                        <td><a href="#" class="css_button"><img onClick="javascript:fn_fileDownload('${sptIptnRsltList.sptIptnFlnm}', '${ctx}${sptIptnRsltList.sptIptnFlsv}'); return false;" src="<c:url value='/img/btn/file.png'/>" /></a></td>
                                        <td><a href="#" class="css_button"><img onClick="javascript:sptView('${sptIptnRsltList.fctyCd}', '${sptIptnRsltList.gvmtCd}','${sptIptnRsltList.fctyCplnDt}','${sptIptnRsltList.conDaGbcd}'); return false;" src="<c:url value='/img/btn/play.png'/>"/></a></td>
                                    </tr>
                                  <c:set var="iCnt" value="${iCnt+1}"/>
                                  </c:forEach> 
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
                </div>

                <div class="btn_group">
                    <div style="padding:5px 0 0 0;">
                        <a href="javascript:excelDownload();" alt="파일저장"><img src="<c:url value='/img/btn/btn_down2.png'/>"/></a>
                        <!-- <a href="#" alt="파일저장"><img src="<c:url value='/img/btn/btn_print2.png'/>"/></a> -->
                    </div>

                </div>
            
            </div>
        </div> 
    </div>  
</div>
<!-- END:컨텐츠 -->    

  <form id="move_page" method="post" name="move_page" target='ifDown' onsubmit="return false">
  </form>
  <iframe name="ifDown" style='display: none;'></iframe>
  
<!-- STR:footer -->
<div id="footer">
    <c:import url="/EgovPageLink.do?vlink=estam/main/inc/EstamIncFooter" /> 
</div>
<!-- END:footer -->

</BODY>
</HTML> 
