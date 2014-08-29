/****************************************************************
 *
 * 파일명 : EgovCalPopup.js
 * 설  명 : 전자정부 공통서비스 달력 팝업 JavaScript
 *
 *    수정일      수정자     Version        Function 명
 * ------------    ---------   -------------  ----------------------------
 * 2009.03.30    이중호       1.0             최초생성
 * 2011.08.30	 이기하		  1.1			  contextpath 적용
 *
 *
 */

/**********************************************
 * 함수명 : fn_egov_AdministCalendar
 * 설  명 : 행정달력 팝업 호출
 * 인  자 : 사용할 Form 객체, 연월일(yyyy-MM-dd)
 * 사용법 : fn_egov_AdministCalendar(frm, sDate)
 *
 * 수정일        수정자      수정내용
 * ------        ------     -------------------
 * 2009.03.30    이중호      신규작업
 *
 */

function fn_egov_AdministCalendar(frm, sDate, vDate) {
	var retVal;

	var url = frm.cal_url.value;
//	var url = "/sym/cal/EgovAdministCalPopup.do";

	var varParam = new Object();
	varParam.sDate = sDate.value;

	// IE
	//var openParam = "dialogWidth:252px;dialogHeight:175px;scroll:no;status:no;center:yes;resizable:yes;";
	// FIREFOX
	var openParam = "dialogWidth:320px;dialogHeight:220px;scroll:no;status:no;center:yes;resizable:yes;";

	retVal = window.showModalDialog(url, varParam, openParam);

	if(retVal) {
		sDate.value = retVal.sDate;
		vDate.value = retVal.vDate;
	}
}

/**********************************************
 * 함수명 : fn_egov_NormalCalendar
 * 설  명 : 일반달력 팝업 호출
 * 인  자 : 사용할 Form 객체, 연월일(yyyy-MM-dd)
 * 사용법 : fn_egov_NormalCalendar(frm, sDate)
 *
 * 수정일        수정자      수정내용
 * ------        ------     -------------------
 * 2009.03.30    이중호      신규작업
 *
 */
function fn_egov_NormalCalendar(frm, sDate, vDate) {
	var retVal;

	var url = frm.cal_url.value;
//	var url = "/sym/cal/EgovNormalCalPopup.do";

	var varParam = new Object();
	varParam.sDate = sDate.value;

	// IE
	//var openParam = "dialogWidth:252px;dialogHeight:175px;scroll:no;status:no;center:yes;resizable:yes;";
	// FIREFOX
	var openParam = "";
	var sAppName = navigator.appName ;

	if( sAppName.indexOf("Netscape") > -1){
		openParam = "dialogWidth:275px;dialogHeight:192px;scroll:no;status:no;center:yes;resizable:yes;";
	}else if(sAppName.indexOf("Microsoft") > -1){
		openParam = "dialogWidth:275px;dialogHeight:192px;scroll:no;status:no;center:yes;resizable:yes;";
	}else{
		openParam = "dialogWidth:275px;dialogHeight:192px;scroll:no;status:no;center:yes;resizable:yes;";
	}

	retVal = window.showModalDialog(url, varParam, openParam);

	if(retVal) {
		if(fn_egov_NormalCalendar.arguments.length == 2){
			sDate.value = retVal.vDate;
		}else{
			sDate.value = retVal.sDate;
			vDate.value = retVal.vDate;
		}
	}
}

/**********************************************
 * 함수명 : fn_egov_NormalCalendar2
 * 설  명 : 일반달력 팝업 호출 후 셋팅시에 to일자 기본값 셋팅
 * 인  자 : 사용할 Form 객체, 연월일(yyyy-MM-dd)
 * 사용법 : fn_egov_NormalCalendar(frm, sDate)
 *
 * 수정일        수정자      수정내용
 * ------        ------     -------------------
 * 2013.04.22    권태용      신규작업
 *
 */
function fn_egov_NormalCalendar2(frm, sDate, vDate, tDate) {
	var retVal;

	var url = frm.cal_url.value;
//	var url = "/sym/cal/EgovNormalCalPopup.do";
	var varParam = new Object();
	varParam.sDate = sDate.value;

	// IE
	//var openParam = "dialogWidth:252px;dialogHeight:175px;scroll:no;status:no;center:yes;resizable:yes;";
	// FIREFOX
	var openParam = "";
	var sAppName = navigator.appName ;

	if( sAppName.indexOf("Netscape") > -1){
		openParam = "dialogWidth:275px;dialogHeight:192px;scroll:no;status:no;center:yes;resizable:yes;";
	}else if(sAppName.indexOf("Microsoft") > -1){
		openParam = "dialogWidth:275px;dialogHeight:192px;scroll:no;status:no;center:yes;resizable:yes;";
	}else{
		openParam = "dialogWidth:275px;dialogHeight:192px;scroll:no;status:no;center:yes;resizable:yes;";
	}

	retVal = window.showModalDialog(url, varParam, openParam);

	alert("retVal.vDate:" + retVal.vDate); // 달력콤포넌트에서 선택한 날짜값
	alert("fn_egov_NormalCalendar2.arguments.length:" + fn_egov_NormalCalendar2.arguments.length); // 4
	if(retVal) {
		
		if(fn_egov_NormalCalendar2.arguments.length == 2){
		//	alert("fn_egov_NormalCalendar2.arguments.length==2");
			sDate.value = retVal.vDate;
			tDate.value = retVal.tDate;
		}else{
		//	alert("fn_egov_NormalCalendar2.arguments.length!=2");
			sDate.value = retVal.sDate;
			vDate.value = retVal.vDate;
		//	tDate.value = retVal.sDate;
			tDate.value = addDay(retVal.sDate.replace(/-/gi, ""), 1);
			
			
		}
	}
	
}

/**********************************************
 * 함수명 : fn_egov_Calendar
 * 설  명 : 달력 팝업 호출
 * 인  자 : 사용할 Form 객체, 연월일(yyyy-MM-dd)
 * 사용법 : fn_egov_Calendar(frm, sDate)
 *
 * 수정일        수정자      수정내용
 * ------        ------     -------------------
 * 2009.10.13    이중호      신규작업
 *
 */
function fn_egov_Calendar(frm, sDate, vDate) {
	var retVal;

	var url = frm.cal_url.value;
//	var url = "/sym/cal/callCalPopup.do";

	var varParam = new Object();
	varParam.sDate = sDate.value;

	// IE
	//var openParam = "dialogWidth:252px;dialogHeight:175px;scroll:no;status:no;center:yes;resizable:yes;";
	// FIREFOX
	var openParam = "dialogWidth:320px;dialogHeight:220px;scroll:no;status:no;center:yes;resizable:yes;";

	retVal = window.showModalDialog(url, varParam, openParam);

	if(retVal) {
		if(fn_egov_Calendar.arguments.length == 2){
			sDate.value = retVal.vDate;fn_egov_Calendar;
		}else{
			sDate.value = retVal.sDate;
			vDate.value = retVal.vDate;
		}
	}
}