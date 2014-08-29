<%@ page language="java" contentType="application/vnd.ms-excel; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String excelFileName = "sptlptnRsltReport_excel.xls";
    response.setHeader("Content-Type", "application/vnd.ms-xls");
    response.setHeader("Content-Disposition", "inline;filename="+excelFileName);
%>
<html>
<head><meta http-equiv="Content-type" content="application/vns.ms-excel;charset=UTF-8"></head>
<body>
<table border="1">
    <thead>
        <tr>
             <th bgcolor="#F7F7F7" align="center" rowspan="2">NO</th>
             <th bgcolor="#F7F7F7" align="center" rowspan="2">시설물유형</th>
             <th bgcolor="#F7F7F7" align="center" rowspan="2">지역</th>
             <th bgcolor="#F7F7F7" align="center" rowspan="2">시설물명칭</th>
             <th bgcolor="#F7F7F7" align="center" rowspan="2">발주일</th>
             <th bgcolor="#F7F7F7" align="center" rowspan="2">계약일</th>
             <th bgcolor="#F7F7F7" align="center" rowspan="2">준공예정일</th>
             <th bgcolor="#F7F7F7" align="center" rowspan="2">가동연계일</th>
             <th bgcolor="#F7F7F7" align="center" colspan="3">현장점검</th>
             <th bgcolor="#F7F7F7" align="center" rowspan="2">결과</th>
             <th bgcolor="#F7F7F7" align="center" rowspan="2">계측기 공급기관</th>
             <th bgcolor="#F7F7F7" align="center" colspan="3">설치업체</th>
             <th bgcolor="#F7F7F7" align="center" colspan="3">유지관리업체</th>
             <th bgcolor="#F7F7F7" align="center" colspan="3">담당부서</th>
             <th bgcolor="#F7F7F7" align="center" rowspan="2">현장점검보고서파일</th>
             <th bgcolor="#F7F7F7" align="center" rowspan="2">센서 및 기록계 정보</th>
         </tr>
         <tr>
             <th bgcolor="#F7F7F7" align="center" >현장점검 요청일</th>
             <th bgcolor="#F7F7F7" align="center" >현장점검 실시일</th>
             <th bgcolor="#F7F7F7" align="center" >현장점검 결과보고일</th>
             <th bgcolor="#F7F7F7" align="center" >설치업체</th>
             <th bgcolor="#F7F7F7" align="center" >담당자</th>
             <th bgcolor="#F7F7F7" align="center" >연락처</th>
             <th bgcolor="#F7F7F7" align="center" >유지관리업체</th>
             <th bgcolor="#F7F7F7" align="center" >담당자</th>
             <th bgcolor="#F7F7F7" align="center" >연락처</th>
             <th bgcolor="#F7F7F7" align="center" >덤당부서업체</th>
             <th bgcolor="#F7F7F7" align="center" >담당자</th>
             <th bgcolor="#F7F7F7" align="center" >연락처</th>
         </tr>
    </thead>
    <tbody>
    <c:choose>
    <c:when test="${empty sptIptnRsltList}">
       <tr><td colspan="24" align="center">자료가 존재하지 않습니다.</td></tr>
    </c:when>
       <c:otherwise>
        <c:set var="iCnt" value="1"/>
        <c:forEach var="sptIptnRsltList" items="${sptIptnRsltList}" varStatus="status">                             
            <tr>
                <td align="center">${iCnt}</td>
                <td align="center">${sptIptnRsltList.fctyKndNm}</td>
                <td align="center">${sptIptnRsltList.fctyAreaNm}</td>
                <td align="center">${sptIptnRsltList.fctyNm}</td>
                <td align="center"></td>
                <td align="center"></td>
                <td align="center"></td>
                <td align="center">${sptIptnRsltList.sptIptnReqtDt}</td> 
                <td align="center">${sptIptnRsltList.sptIptnDt}</td>
                <td align="center">${sptIptnRsltList.sptIptnRsltDt}</td> 
                <td align="center">${sptIptnRsltList.sptIptnRsltYn}</td>
                <td align="center">${sptIptnRsltList.istlDept}</td>
                <td align="center">${sptIptnRsltList.istlDept}</td> 
                <td align="center">${sptIptnRsltList.istlUsrNm}</td> 
                <td align="center">${sptIptnRsltList.istlUsrTel}</td> 
                <td align="center">${sptIptnRsltList.spprDept}</td> 
                <td align="center">${sptIptnRsltList.spprUsrNm}</td> 
                <td align="center">${sptIptnRsltList.spprUsrTel}</td>
                <td align="center">${sptIptnRsltList.mgrSlfDept}</td> 
                <td align="center">${sptIptnRsltList.mgrSlfUsrNm}</td> 
                <td align="center">${sptIptnRsltList.mgrSlfUsrTel}</td> 
                <td align="center"></td>
                <td align="center"></td>
            </tr>
          <c:set var="iCnt" value="${iCnt+1}"/>
          </c:forEach> 
    </c:otherwise>
    </c:choose>            
    </tbody>
</table>          
</BODY>
</HTML> 
