<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>  

<%@ page import ="egovframework.com.cmm.LoginVO" %>     
<script>
function goFooterPage(footName,linkUrl){  
	
    document.getElementById("maplink").value="redirect:" +linkUrl;   //"forward:"+getLastLink(menuNo);
    //alert(document.getElementById("menuNo").value);
    var frm = document.getElementById("mapLeftForm");
    frm.action = "<c:url value='/EgovPageLink.do'/>";
    //document.selectOne.action = "<c:url value='/sym/mms/EgovMainMenuLeft.do'/>";
    //document.selectOne.target = "main_left";
    //document.selectOne.submit();
    //document.selectOne.action = "<c:url value='/sym/mms/EgovMainMenuRight.do'/>";
    //document.selectOne.target = "main_right";
    frm.submit();
}
</script>
	<div id="footer_wrap">

		<!-- <ul class="footer_btn">
			<li><a href=""><img src="${pageContext.request.contextPath}/img/btn/btn_footer01.png" title="개인정보 보호정책" /></a></li>
			<li><a href=""><img src="${pageContext.request.contextPath}/img/btn/btn_footer02.png" title="뷰어프로그램 다운로드" /></a></li>
			<li><a href=""><img src="${pageContext.request.contextPath}/img/btn/btn_footer03.png" title="이메일주소 무단수집거부" /></a></li>
			<li><a href=""><img src="${pageContext.request.contextPath}/img/btn/btn_footer04.png" title="사이트맵" /></a></li>
		</ul> -->

		<!-- STR:지도 왼쪽 버튼 -->
		<div class="quick_btn">
			<ul>
				<li class="quick_btn01"><a href="#" onclick="javascript:goFooterPage('ScnRccManager','${ctx}/scn/ScnRccManager.do')" title="가속도계측기관리대장">가속도계측기관리대장</a></li>	
				<li class="quick_btn02"><a href="#" onclick="javascript:goFooterPage('SptIptnRsltReport','${ctx}/spt/SptIptnRsltReport.do')" title="가속도계측기현장점검보고서">가속도계측기현장점검보고서</a></li>	
				<li class="quick_btn03"><a href="#" onclick="javascript:goFooterPage('FctyEstmEvalRpt','${ctx}/rpt/OverallAnalyRpt.do')" title="종합분석보고서작성">종합분석보고서작성</a></li>
			</ul>
		</div>
		<!-- END:지도 왼쪽 버튼 -->

	</div>