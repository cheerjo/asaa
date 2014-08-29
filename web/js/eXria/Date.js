/**********************************************************************/
// 프로그램명 : 날짜스크립트
// 설      명 : 날짜스크립트 JS
// 최초작성자 : 백승호(shbaek)
// 최초작성일 : 2012.05.11
// 
// 수정 이력 :
// 
//   수정일      수정자                수정내용
// ==========  =========   ===============================
// 2012.05.11    백승호               최초생성
// 
// Copyright ⓒ 2012 DAESANG Information Technology All rights reserved.
/***********************************************************************/

var D_sServerDate;        	//서버날짜
var D_sYear;				//년
var D_sMonth;				//월
var D_sDay;					//일
var D_sHour;				//시
var D_sMinute;				//분
var D_sSecond;				//초
var D_sMillisecond;			//미리초
var D_oToday;				//오늘날짜 Date객체



/* ================================================== */ 
/* =============== 날짜 관련 함수 영역 ================ */ 
/* ================================================== */
 
/**
 * 서버의 오늘날짜로 설정한다.
 * @param psFormat String - 날짜포맷 (선택)(기본값:yyyyMMddHHmmss)
 */ 
function D_setServerDate(psFormat) {
    if (psFormat == null || psFormat == "") {
    	psFormat = "yyyyMMddHHmmss";
    }

    var oInstance = page.getInstance("ins_request");
    oInstance.setValue("/root/reqServerDate/format", psFormat);

    page.getSubmission("sbm_get_server_date").send();

    oInstance = page.getInstance("ins_response");
    D_sServerDate = oInstance.getValue("/root/getServerDate/serverDate");
    D_sYear = oInstance.getValue("/root/getServerDate/year");
    D_sMonth = oInstance.getValue("/root/getServerDate/month");
    D_sDay = oInstance.getValue("/root/getServerDate/day");
    D_sHour = oInstance.getValue("/root/getServerDate/hour");
    D_sMinute = oInstance.getValue("/root/getServerDate/minute");
    D_sSecond = oInstance.getValue("/root/getServerDate/second");
    D_sMillisecond = oInstance.getValue("/root/getServerDate/millisecond");
    D_oToday = new Date(parseInt(D_sMillisecond));
}

/**
 * 서버의 오늘날짜를 구한다.
 * @param psFormat String - 날짜포맷 (선택)(기본값:yyyyMMddHHmmss)
 * @return String 서버날짜
 */ 
function D_getServerDate(psFormat) {
    if (psFormat == null || psFormat == "") {
    	psFormat = "yyyyMMddHHmmss";
    }

    var oInstance = page.getInstance("ins_request");
    oInstance.setValue("/root/reqServerDate/format", psFormat);

    page.getSubmission("sbm_get_server_date").send();

    oInstance = page.getInstance("ins_response");
    var sServerDate = oInstance.getValue("/root/getServerDate/serverDate");
    return sServerDate;
}

/**
 * 해당 일만큼 증가(감소)된 날짜을 구한다.
 * @param psDate String - 기준날짜(포맷:yyyyMMdd)
 * @param pnDay Number - 증가(감소) 일수
 * @return String 증가(감소)된 날짜
 */ 
function D_addDays(psDate, pnDay) {
	if (Valid && Valid.isDate && !Valid.isDate(psDate)) {
		return null;
	}
	
	var nYear = parseInt(psDate.substring(0,4));
	var nMonth = parseInt(psDate.substring(4,6)) - 1;
	var nDay = parseInt(psDate.substring(6,8));
	var oDate = new Date(nYear, nMonth, nDay);
	
	oDate.setDate(oDate.getDate() + pnDay);
	
	var nAddMonth = oDate.getMonth() + 1;
	var nAddDay = oDate.getDate();
	var sAddYear = "" + oDate.getFullYear();
	var sAddMonth = nAddMonth < 10 ? "0"+nAddMonth : ""+nAddMonth;
	var sAddDay = nAddDay < 10 ? "0"+nAddDay : ""+nAddDay;
	
	var sRtnDate = sAddYear + sAddMonth + sAddDay;
	
	return sRtnDate;
}

/**
 * 두 날짜의 차이 일수를 구한다.
 * @param psSrtDate String - 시작날짜(포맷:yyyyMMdd)
 * @param psEndDate String - 종료날짜(포맷:yyyyMMdd)
 * @return Number 차이 일수
 */ 
function D_getDaysDiff(psSrtDate, psEndDate) {
	if (psSrtDate == null || psSrtDate == "" || psEndDate == null || psEndDate == "") {
		return -99999;
	}
	
	if (Valid && Valid.isDate && (!Valid.isDate(psSrtDate) || !Valid.isDate(psEndDate))) {
		return -99999;
	}
	
	var nYear = parseInt(psSrtDate.substring(0,4));
	var nMonth = parseInt(psSrtDate.substring(4,6)) - 1;
	var nDay = parseInt(psSrtDate.substring(6,8));
	var oSrtDate = new Date(nYear, nMonth, nDay);
	
	nYear = parseInt(psEndDate.substring(0,4));
	nMonth = parseInt(psEndDate.substring(4,6)) - 1;
	nDay = parseInt(psEndDate.substring(6,8));
	var oEndDate = new Date(nYear, nMonth, nDay);

    var nSrtDays = (oSrtDate.getTime()/3600000)/24;
    var nEndDays = (oEndDate.getTime()/3600000)/24;

    var nDaysDiff = nEndDays - nSrtDays;

	return nDaysDiff;
}
