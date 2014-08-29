//var C_pInqBtnYn = C_getParameter("inq_btn_yn");		//조회버튼 사용여부
//var C_pSaveBtnYn = C_getParameter("save_btn_yn");	//저장버튼 사용여부
var C_pInqBtnYn = 'Y'	//조회버튼 사용여부
var C_pSaveBtnYn = 'Y'	//저장버튼 사용여부

var C_sLoginUsrId;		//로그인 사용자ID
var C_sLoginUsrNm;		//로그인 사용자명
var C_sLoginEpno;		//로그인 사번
var C_sLoginAutIdBind;	//로그인 권한ID
var C_sCurPgmId;        //현재 프로그램ID
var C_sCurPgmNm;        //현재 프로그램명
var C_sDefaultBorderColor = "#A5BACC";  //컨트롤 Default Border Color

/**
 * 프로그램 타이틀을 설정한다.
 */ 
function C_setPgmTitle() {
    var cLblTitle = page.getControl("lbl_title");
	if (cLblTitle != null) {
		if (C_sCurPgmNm != null) {
            cLblTitle.setValue(C_sCurPgmNm);
		}
	}
}

/**
 * 메시지 데이터를 설정한다.
 */ 
function C_submitMessage() {
    page.getSubmission("sbm_message").send();
}


/* ================================================== */ 
/* ============== 로그인 관련 함수 영역 =============== */ 
/* ================================================== */

/**
 * 로그인 세션정보를 구한다.
 */ 
function C_submitGetSession() {
    page.getSubmission("sbm_get_http_session").send();

    var oInstance = page.getInstance("ins_response");
    C_sLoginUsrId = oInstance.getValue("/root/httpSession/row[1]/loginUsrId");
    C_sLoginUsrNm = oInstance.getValue("/root/httpSession/row[1]/loginUsrNm");
    C_sLoginEpno = oInstance.getValue("/root/httpSession/row[1]/loginEpno");
    C_sLoginAutIdBind = oInstance.getValue("/root/httpSession/row[1]/loginAutIdBind");
    
	C_chkSessionTimeOut();
}

/**
 * 로그인 세션정보를 제거한다.
 */ 
function C_submitRemoveSession() {
    page.getSubmission("sbm_remove_http_session").send();

	C_sLoginUsrId = "";
	C_sLoginUsrNm = "";
	C_sLoginEpno = "";
	C_sLoginAutIdBind = "";
}

/**
 * 로그인 세션 만료여부를 확인 처리한다.
 */ 
function C_chkSessionTimeOut() {
	if (C_sLoginUsrId == null || C_sLoginUsrId == "") {
		C_alertMessage("MSYS_GNR_007");    //로그인 정보가 없습니다. 로그인 화면으로 이동합니다.
		C_goLoginPage();
		
		throw '세션만료';
	}
}

/**
 * 로그인 세션정보가 유효한지 확인한다.
 * @return boolean 유효여부
 */ 
function C_validLoginSession() {
	C_submitGetSession();
	
	if (C_sLoginUsrId == null || C_sLoginUsrId == "") {
		return false;
	}
	
	return true;
}

/**
 * 로그인 화면으로 이동한다.
 */ 
function C_goLoginPage() {
    //top.document.location = "/websquare/websquare.html?w2xPath=/gnss/system/main/GnssLoginWq.xml";
}


/* ================================================== */ 
/* ============== 메시지 관련 함수 영역 =============== */ 
/* ================================================== */

/**
 * 메시지 Alert 창을 띄운다.
 * @param psMsgId 메시지ID
 * @param paArgArray 아규먼트 배열
 * @param psAlertType Alert 창 타입
 */ 
function C_alertMessage(psMsgId, paArgArray, psAlertType) {
    alert(C_getMessage(psMsgId, paArgArray));
}

/**
 * 메시지 Confirm 창을 띄운다.
 * @param psMsgId 메시지ID
 * @param paArgArray 아규먼트 배열
 * @param psAlertType Confirm 창 타입
 * @return boolean 확인여부
 */ 
function C_confirmMessage(psMsgId, paArgArray, psAlertType) {
	return confirm(C_getMessage(psMsgId, paArgArray));
}

/**
 * 메시지를 구한다.
 * @param psMsgId 메시지ID
 * @param paArgArray 아규먼트 배열
 * @return 메시지 내용
 */ 
function C_getMessage(psMsgId, paArgArray) {
    var oInstance = page.getInstance("ins_response");
    var sMsgText = oInstance.getValue("/root/messages/row[id='"+psMsgId+"']/text");
    
	if (sMsgText == null || sMsgText == "") {
		return psMsgId;
	}
	
	if (paArgArray != null && paArgArray.length > 0) {
		for (var i=0; i<paArgArray.length; i++) {
			sMsgText = sMsgText.replace(/__ARG__/, paArgArray[i]);
		}
		sMsgText = sMsgText.replace(/__ARG__/, "");
	}

	return sMsgText;
}


/**
 * 그리드 조회시 그리드의 변경 여부 확인
 * @param pcGridObj 그리드
 * @return boolean 확인 여부
 */ 
function C_confirmModifiedGrid4Inq(pcGridObj) {
	if (C_isModifiedGrid(pcGridObj)) {
	    if (C_confirmMessage("MSYS_EDIT_012")) {	//변경 내역이 있습니다. 그래도 조회하시겠습니까?
	    	return true;
	    }
	    
	    return false;
	}
	
	return true;
}

/**
 * 그리드 추가시 그리드의 변경 여부 확인
 * @param pcGridObj 그리드
 * @return boolean 확인 여부
 */ 
function C_confirmModifiedGrid4Add(pcGridObj) {
	if (C_isModifiedGrid(pcGridObj)) {
	    if (C_confirmMessage("MSYS_EDIT_014")) {	//하위 목록에 변경 내역이 있습니다. 그래도 추가하시겠습니까?
	    	return true;
	    }
	    
	    return false;
	}
	
	return true;
}

/**
 * Submission 결과 메시지 코드를 구한다.
 * @return String 메시지 코드
 */ 
function C_getResultMsgCd() {
    var oInstance = page.getInstance("ins_response");
    var sResultMsgCd = oInstance.getValue("/root/tranResult/msgCode");

	return sResultMsgCd;
}

/**
 * Submission 성공 여부를 구한다.
 * @return boolean 성공 여부
 */ 
function C_isSuccessSubmit() {
    var oInstance = page.getInstance("ins_response");
    var sTranSuccess = oInstance.getValue("/root/tranResult/tranSuccess");

	if (sTranSuccess == "TRUE") {
		return true;
	}
	
	return false;
}

/**
 * 저장 건수를 구한다.
 * @return String 저장 건수
 */ 
function C_getResultCount() {
    var oInstance = page.getInstance("ins_response");
    var sResultSuccess = oInstance.getValue("/root/tranResult/tranSuccess");
    var sResultCount = oInstance.getValue("/root/tranResult/saveCnt");

	if (sResultSuccess == "TRUE") {
		return sResultCount;
	}
	
	return "0";
}

/**
 * 저장 결과값을 구한다.
 * @return String 저장 결과값
 */ 
function C_getResultValue() {
    var oInstance = page.getInstance("ins_response");
    var sResultSuccess = oInstance.getValue("/root/tranResult/tranSuccess");
    var sResultCount = oInstance.getValue("/root/tranResult/saveCnt");

    if (sResultSuccess == "TRUE") {
        return sResultCount;
    }
    
    return "";
}

/**
 * HTTP Request Parameter를 구한다.
 * @param psName 파라메터명
 */ 
function C_getParameter(psName) {
    var aParamArray = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    var sHash;
    
    for(var i=0; i<aParamArray.length; i++) {
        sHash = aParamArray[i].split('=');
        if (sHash[0] == psName) {
            return sHash[1];
        }
    }
    
    return "";
}

/**
 * 쿠키를 설정한다.
 * @param psName 쿠키명
 * @param psValue 쿠키값
 * @param pnExdays 만료날수
 */ 
function C_setCookie(psName, psValue, pnExdays) {
	var oExdate = new Date();
	oExdate.setDate(oExdate.getDate() + pnExdays);
	var sValue = escape(psValue) + ((pnExdays==null) ? "" : "; expires="+oExdate.toUTCString());
	document.cookie = psName + "=" + sValue;
}

/**
 * 쿠키값을 구한다.
 * @param psName 쿠키명
 * @return String 쿠키값
 */ 
function C_getCookie(psName) {
	var i,x,y;
    var aCookies = document.cookie.split(";");
	for (i=0; i<aCookies.length; i++) {
		x = aCookies[i].substr(0,aCookies[i].indexOf("="));
		y = aCookies[i].substr(aCookies[i].indexOf("=")+1);
		x = x.replace(/^\s+|\s+$/g,"");
		if (x == psName) {
			return unescape(y);
		}
	}
	return "";
}

/**
 * 문자열 앞뒤 공백을 제거한다.
 * @param psStr 문자열
 * @return String
 */ 
function C_trim(psStr) {
	return psStr.replace(/^\s*|\s*$/g, '');
}

/**
 * 문자열 앞 공백을 제거한다.
 * @param psStr 문자열
 * @return String
 */ 
function C_ltrim(psStr) {
	return psStr.replace(/^\s*/g, '');
}

/**
 * 문자열 뒷 공백을 제거한다.
 * @param psStr 문자열
 * @return String
 */ 
function C_rtrim(psStr) {
	return psStr.replace(/\s*$/g, '');
}

/**
 * 사용자접근이력을 추가한다.
 * @param psApprGbcd 접근구분코드
 * @param psUsrId 사용자ID
 * @param psPgmId 프로그램ID
 * @param psUpdUsrId 수정자ID
 */ 
function C_submitInsertUsrApprHisInfo(psApprGbcd, psUsrId, psPgmId, psUpdUsrId) {
	if (psApprGbcd == null || psApprGbcd == "") {
		return;
	}

	if (psUsrId == null || psUsrId == "") {
		psUsrId = C_sLoginUsrId;
	}

	if (psPgmId == null) {
		psPgmId = C_sCurPgmId;
	}

	if (psUpdUsrId == null || psUpdUsrId == "") {
		psUpdUsrId = "SYSTEM";
	}

    var oInstance = page.getInstance("ins_request");
    oInstance.setValue("/root/insertUsrApprHisInfo/usrId", psUsrId);
    oInstance.setValue("/root/insertUsrApprHisInfo/pgmId", psPgmId);
    oInstance.setValue("/root/insertUsrApprHisInfo/apprGbcd", psApprGbcd);
    oInstance.setValue("/root/insertUsrApprHisInfo/updUsrId", psUpdUsrId);

    page.getSubmission("sbm_insert_usr_appr_his_info").send();
}

/**
 * 그리드를 엑셀로 저장한다. (코드는 코드명으로 출력된다)
 * @param pcGridObj 그리드객체
 * @param psExcelFileNm 엑셀파일명
 */ 
function C_saveExcelFile(pcGridObj, psExcelFileNm) {
    var sTmp = pcGridObj.id;
    pcGridObj.id = psExcelFileNm;
    pcGridObj.exportExcelMatchHeader(true, psExcelFileNm);
    pcGridObj.id = sTmp;
    C_submitInsertUsrApprHisInfo("EXL");   //사용자접근이력 추가
}

/**
 * 그리드를 엑셀로 저장한다. (코드는 코드값 그래로 출력된다)
 * @param pcGridObj 그리드객체
 * @param psExcelFileNm 엑셀파일명
 */ 
function C_saveExcelFile2(pcGridObj, psExcelFileNm) {
    UtilDataSet.exportExcel(pcGridObj.dataset, psExcelFileNm);
    C_submitInsertUsrApprHisInfo("EXL");   //사용자접근이력 추가
}

/**
 * 그리드 행 정보와 상세정보를 동기화한다.
 * @param paGridDetailArray 그리드와 상세 컴포넌트의 배열 
 * @param pcGridObj 그리드 객체
 */ 
function C_syncGirdRowToDetail(paGridDetailArray, pcGridObj) {
    var oRow = pcGridObj.focusRow;
    var sTmpValue;

	for (var i=0; i<paGridDetailArray.length; i++) {
        sTmpValue = pcGridObj.getValue(oRow, paGridDetailArray[i][0]);
        page.getControl(paGridDetailArray[i][1]).setValue(sTmpValue);
	}
}

/**
 * 그리드 셀정보와 상세정보를 동기화한다.
 * @param paGridDetailArray 그리드와 상세 컴포넌트의 배열 
 * @param pcGridObj 그리드 객체
 * @param psColId 그리드 컬럼ID
 */ 
function C_syncGridCellToDetail(paGridDetailArray, pcGridObj, psColId) {
    var sTmpValue = pcGridObj.getValue(pcGridObj.focusRow, psColId);

    for (var i=0; i<paGridDetailArray.length; i++) {
		if (psColId == paGridDetailArray[i][0]) {
	        page.getControl(paGridDetailArray[i][1]).setValue(sTmpValue);
			break;
		}
	}
}

/**
 * 상세정보와 그리드 셀정보를 동기화한다.
 * @param paGridDetailArray 그리드와 상세 컴포넌트의 배열 
 * @param pcGridObj 그리드 객체
 * @param psCompId 상세 컴포넌트 ID
 */ 
function C_syncDetailToGridCell(paGridDetailArray, pcGridObj, psCompId) {
    var oFocusRow = pcGridObj.focusRow;
    var sTmpValue = page.getControl(psCompId).getValue();
	
	for (var i=0; i<paGridDetailArray.length; i++) {
		if (psCompId == paGridDetailArray[i][1]) {
			pcGridObj.setValue(oFocusRow, paGridDetailArray[i][0], sTmpValue, true);
			break;
		}
	}
}

/**
 * 그리드의 컬럼값 모두를 설정한다.
 * @param pcGridObj 그리드 객체
 * @param psColId 컬럼ID
 * @param psValue 컬럼값
 * @param pbRefresh 그리드 셀 새로고침 여부(기본값:true)
 */ 
function C_setGridAllColValue(pcGridObj, psColId, psValue, pbRefresh) {
    var oDataset = pcGridObj.dataset;
    var oRow;
    
    C_setDatasetAllColValue(oDataset, psColId, psValue);
    
    for (var i=0; i<pcGridObj.rowCount; i++) {
        oRow = pcGridObj.getRowIndex(i);
        if (pbRefresh == false) {
            pcGridObj.setValue(oRow, psColId, psValue);
        }
        else {
            pcGridObj.setValue(oRow, psColId, psValue, pbRefresh);
        }
    }
}

/**
 * 그리드의 데이터셋 컬럼값 모두를 설정한다.
 * @param pcGridObj 그리드 객체
 * @param psColId 컬럼ID
 * @param psValue 컬럼값
 * @param pbRefresh 그리드 새로고침 여부(기본값:true)
 */ 
function C_setGridDatasetAllColValue(pcGridObj, psColId, psValue, pbRefresh) {
    var oDataset = pcGridObj.dataset;
    
    C_setDatasetAllColValue(oDataset, psColId, psValue);
    
    if (pbRefresh == false) {
        return
    }
    
    pcGridObj.refreshData();
}

/**
 * 데이터셋의 컬럼값 모두를 설정한다.
 * @param poDstObj 데이터셋 객체
 * @param psColId 컬럼ID
 * @param psValue 컬럼값
 */ 
function C_setDatasetAllColValue(poDstObj, psColId, psValue) {
    for (var i=1; i<=poDstObj.getRowCnt(); i++) {
        poDstObj.set(i, psColId, psValue);
    }
}

/**
 * Canvas의 사이즈를 창의 사이즈에 맞게 조정한다.
 */ 
function C_resizeCanvas() {
    var nCanvasWidth = window.innerWidth;
    var nCanvasHeight = window.innerHeight;
    var nMinWidth = 300;    //최소 너비
    var nMinHeight = 200;    //최소 높이

    if (page.getControl("tab_content") == null && page.parent.getControl && page.parent.getControl("tab_content")) {
        nCanvasWidth = page.parent.getControl("tab_content").width;
        nCanvasHeight = page.parent.getControl("tab_content").height;
//alert(nCanvasWidth+"  "+nCanvasHeight);
//        nCanvasWidth = parseInt(page.parent.getControl("tab_content").getCtrl().style.width.replace(/px/g,''));
//        nCanvasHeight = parseInt(page.parent.getControl("tab_content").getCtrl().style.height.replace(/px/g,''));
//alert(nCanvasWidth);
    }
    
    if (nCanvasWidth < nMinWidth) {
        nCanvasWidth = nMinWidth;
    }
    if (nCanvasHeight < nMinHeight) {
        nCanvasHeight = nMinHeight;
    }
    
    page.canvas.width = nCanvasWidth;
    page.canvas.height = nCanvasHeight;
    page.canvas.refresh();
}

/**
 * Canvas의 너비 사이즈를 창의 사이즈에 맞게 조정한다.
 */ 
function C_resizeCanvasWidth() {
    var nCanvasWidth = window.innerWidth;
    var nMinWidth = 300;    //최소 너비

    if (page.getControl("tab_content") == null && page.parent.getControl && page.parent.getControl("tab_content")) {
        nCanvasWidth = page.parent.getControl("tab_content").width;
//        nCanvasWidth = parseInt(page.parent.getControl("tab_content").getCtrl().style.width.replace(/px/g,''));
    }
    
    if (nCanvasWidth < nMinWidth) {
        nCanvasWidth = nMinWidth;
    }
    
    page.canvas.width = nCanvasWidth;
    page.canvas.refresh();
}

/**
 * "grp_all_area"의 사이즈를 창의 사이즈에 맞게 조정한다.
 */ 
function C_resizeGrpAllArea() {
    //"grp_all_area"가 존재하지 않는 경우 리턴한다.
    if (page.getControl("grp_all_area") == null) {
        return;
    }

    var nGrpAllAreaWidth = window.innerWidth;
    var nGrpAllAreaHeight = window.innerHeight;

    if (page.getControl("tab_content") == null && page.parent.getControl && page.parent.getControl("tab_content")) {
        nGrpAllAreaWidth = page.parent.getControl("tab_content").width;
        nGrpAllAreaHeight = page.parent.getControl("tab_content").height - 25;
//        nGrpAllAreaWidth = parseInt(page.parent.getControl("tab_content").getCtrl().style.width.replace(/px/g,''));
//        nGrpAllAreaHeight = parseInt(page.parent.getControl("tab_content").getCtrl().style.height.replace(/px/g,'')) - 25;
    }
    
    page.getControl("grp_all_area").width = nGrpAllAreaWidth;
    page.getControl("grp_all_area").height = nGrpAllAreaHeight;
    page.getControl("grp_all_area").resize();
}



/* ================================================== */ 
/* =========== 컴포넌트 위치 설정 함수 영역 ============ */ 
/* ================================================== */
 
/**
 * 본문 너비를 구한다.
 * @return Number - 너비
 */ 
function C_getBodyWidth() {
    var nInnerWidth = window.innerWidth;
    if (page.getControl("grp_all_area")) {
        nInnerWidth = page.getControl("grp_all_area").innerWidth  - 17;
    }
    else if (page.parent.getControl && page.parent.getControl("tab_content")) {
        nInnerWidth = page.parent.getControl("tab_content").width - 1;
//        nInnerWidth = parseInt(page.parent.getControl("tab_content").getCtrl().style.width.replace(/px/g,'')) - 1;
    }
    
    return nInnerWidth;
}

/**
 * 본문 높이를 구한다.
 * @return Number - 높이
 */ 
function C_getBodyHeight() {
    var nInnerHeight = window.innerHeight;
    if (page.getControl("grp_all_area")) {
        nInnerHeight = page.getControl("grp_all_area").innerHeight;
    }
    else if (page.parent.getControl && page.parent.getControl("tab_content")) {
        nInnerHeight = page.parent.getControl("tab_content").height;
//        nInnerHeight = parseInt(page.parent.getControl("tab_content").getCtrl().style.height.replace(/px/g,''));
    }
    
    return nInnerHeight - 17;
}

/**
 * 컴포넌트의 오른쪽 위치값을 구한다.
 * @param psCompId String - 컴포넌트ID
 * @return Number - 오른쪽 위치값
 */ 
function C_getComponentRight(psCompId) {
    var cCompObj = page.getControl(psCompId);
    var nCompRight = cCompObj.left + cCompObj.width;
    
    return nCompRight;
}

/**
 * 컴포넌트의 아래쪽 위치값을 구한다.
 * @param psCompId String - 컴포넌트ID
 * @return Number - 아래쪽 위치값
 */ 
function C_getComponentBottom(psCompId) {
    var cCompObj = page.getControl(psCompId);
    var nCompBottom = cCompObj.top + cCompObj.height;
    
    return nCompBottom;
}

/**
 * 컴포넌트들의 위치를 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열
 * @param psBaseCompId String - 기준이 되는 컴포넌트ID
 * @param pnFirstMargin Number - 첫번째 간격
 * @param pnCompMargin Number - 컴포넌트 간의 간격
 * @param psDirection String - 위치설정 방향(RTL:오른쪽에서왼쪽, LTR:왼쪽에서오른쪽, TTB:위쪽에서아래쪽, BTT:아래에서위쪽)
 */ 
function C_setComponentPosition(paCompArray, psBaseCompId, pnFirstMargin, pnCompMargin, psDirection) {
    var sDirection = psDirection.toUpperCase();

    switch (sDirection) {
    case "RTL":
        C_setComponentPositionRightToLeft(paCompArray, psBaseCompId, pnFirstMargin, pnCompMargin);
        break;
    case "LTR":
        C_setComponentPositionLeftToRight(paCompArray, psBaseCompId, pnFirstMargin, pnCompMargin);
        break;
    case "TTB":
        C_setComponentPositionTopToBottom(paCompArray, psBaseCompId, pnFirstMargin, pnCompMargin);
        break;
    case "BTT":
        C_setComponentPositionBottomToTop(paCompArray, psBaseCompId, pnFirstMargin, pnCompMargin);
        break;
    }
}

/**
 * 오른쪽에서 왼쪽 방향으로 컴포넌트들의 위치를 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열
 * @param psBaseCompId String - 기준이 되는 컴포넌트ID
 * @param pnFirstMargin Number - 첫번째 간격
 * @param pnCompMargin Number - 컴포넌트 간의 간격
 */ 
function C_setComponentPositionRightToLeft(paCompArray, psBaseCompId, pnFirstMargin, pnCompMargin) {
    if (pnFirstMargin == null) {
        pnFirstMargin = 0;
    }
    if (pnCompMargin == null) {
        pnCompMargin = 0;
    }
    
    var nBasePosition = psBaseCompId.left + psBaseCompId.width;
    var nCompPosition = nBasePosition - pnFirstMargin;
    var cCompObj;
   
    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        nCompPosition -= cCompObj.width;
        cCompObj.left = nCompPosition;
        cCompObj.resize(false);
        nCompPosition -= pnCompMargin;
    }
}

/**
 * 왼쪽에서 오른쪽 방향으로 컴포넌트들의 위치를 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열
 * @param psBaseCompId String - 기준이 되는 컴포넌트ID
 * @param pnFirstMargin Number - 첫번째 간격
 * @param pnCompMargin Number - 컴포넌트 간의 간격
 */ 
function C_setComponentPositionLeftToRight(paCompArray, psBaseCompId, pnFirstMargin, pnCompMargin) {
    if (pnFirstMargin == null) {
        pnFirstMargin = 0;
    }
    if (pnCompMargin == null) {
        pnCompMargin = 0;
    }
    
    var nBasePosition = psBaseCompId.left;
    var nCompPosition = nBasePosition + pnFirstMargin;
    var cCompObj;
    
    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.left = nCompPosition;
        cCompObj.resize(false);
        nCompPosition += pnCompMargin + cCompObj.width;
    }
}

/**
 * 위쪽에서 아래쪽 방향으로 컴포넌트들의 위치를 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열
 * @param psBaseCompId String - 기준이 되는 컴포넌트ID
 * @param pnFirstMargin Number - 첫번째 간격
 * @param pnCompMargin Number - 컴포넌트 간의 간격
 */ 
function C_setComponentPositionTopToBottom(paCompArray, psBaseCompId, pnFirstMargin, pnCompMargin) {
    if (pnFirstMargin == null) {
        pnFirstMargin = 0;
    }
    if (pnCompMargin == null) {
        pnCompMargin = 0;
    }
    
    var nBasePosition = psBaseCompId.top + psBaseCompId.height;
    var nCompPosition = nBasePosition + pnFirstMargin;
    var cCompObj;
    
    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.top = nCompPosition;
        cCompObj.resize(false);
        nCompPosition += pnCompMargin + cCompObj.height;
    }
}

/**
 * 아래쪽에서 위쪽 방향으로 컴포넌트들의 위치를 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열
 * @param psBaseCompId String - 기준이 되는 컴포넌트ID
 * @param pnFirstMargin Number - 첫번째 간격
 * @param pnCompMargin Number - 컴포넌트 간의 간격
 */ 
function C_setComponentPositionBottomToTop(paCompArray, psBaseCompId, pnFirstMargin, pnCompMargin) {
    if (pnFirstMargin == null) {
        pnFirstMargin = 0;
    }
    if (pnCompMargin == null) {
        pnCompMargin = 0;
    }
    
    var nBasePosition = psBaseCompId.top;
    var nCompPosition = nBasePosition + pnFirstMargin;
    var cCompObj;
    
    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.top = nCompPosition - cCompObj.height;
        cCompObj.resize(false);
        nCompPosition -= pnCompMargin;
    }
}

/**
 * 컴포넌트들의 위치를 기준 컴포넌트의 왼쪽으로 얼마만큼 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열 (필수)
 * @param psBaseCompId String - 기준이 되는 컴포넌트ID (필수)
 * @param pnMargin Number - 간격 (선택)
 */ 
function C_setComponentPositionToLeft(paCompArray, psBaseCompId, pnMargin) {
    if (pnMargin == null) {
        pnMargin = 0;
    }
    
    var cBaseComp = page.getControl(psBaseCompId);
    var cCompObj;

    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.left = cBaseComp.left + pnMargin + cCompObj.width;
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 위치를 기준 컴포넌트의 오른쪽으로 얼마만큼 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열 (필수)
 * @param psBaseCompId String - 기준이 되는 컴포넌트ID (필수)
 * @param pnMargin Number - 간격 (선택)
 */ 
function C_setComponentPositionToRight(paCompArray, psBaseCompId, pnMargin) {
    if (pnMargin == null) {
        pnMargin = 0;
    }
    
    var cBaseComp = psBaseCompId;
    var cCompObj;

    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.left = cBaseComp.left + cBaseComp.width + pnMargin;
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 위치를 기준 컴포넌트의 위쪽으로 얼마만큼 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열 (필수)
 * @param psBaseCompId String - 기준이 되는 컴포넌트ID (필수)
 * @param pnMargin Number - 간격 (선택)
 */ 
function C_setComponentPositionToTop(paCompArray, psBaseCompId, pnMargin) {
    if (pnMargin == null) {
        pnMargin = 0;
    }
    
    var cBaseComp = psBaseCompId;
    var cCompObj;

    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.top = cBaseComp.top + pnMargin + cCompObj.height;
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 위치를 기준 컴포넌트의 아래쪽으로 얼마만큼 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열 (필수)
 * @param psBaseCompId String - 기준이 되는 컴포넌트ID (필수)
 * @param pnMargin Number - 간격 (선택)
 */ 
function C_setComponentPositionToBottom(paCompArray, psBaseCompId, pnMargin) {
    if (pnMargin == null) {
        pnMargin = 0;
    }
    
    var cBaseComp = psBaseCompId;
    var cCompObj;

    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.top = cBaseComp.top + cBaseComp.height + pnMargin;
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 위치를 가운데로 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열 (필수)
 * @param pnMargin Number - 왼쪽 간격 (선택)
 */ 
function C_setComponentWithCenter(paCompArray, pnMargin) {
    if (pnMargin == null) {
        pnMargin = 0;
    }
    
    var cCompObj;
    var nBodyWidth = C_getBodyWidth();
    
    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.left = ((nBodyWidth - cCompObj.width) / 2) + pnMargin;
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 가로 위치를 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열
 * @param pnLeftMargin Number - 왼쪽 여백
 * @param pnRightMargin Number - 오른쪽 여백
 */ 
function C_setComponentLeftWidth(paCompArray, pnLeftMargin, pnRightMargin) {
    var cCompObj;
    var nBodyWidth = C_getBodyWidth();

    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.left = pnLeftMargin;   //left 설정
        cCompObj.width = nBodyWidth - pnLeftMargin - pnRightMargin; //width 설정
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 세로 위치를 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열 (필수)
 * @param pnTopMargin Number - 위쪽 여백 (필수)
 * @param pnBottomMargin Number - 아래쪽 여백 (필수)
 * @param pnMinHeight Number - 최소 높이 (선택)
 */ 
function C_setComponentTopHeight(paCompArray, pnTopMargin, pnBottomMargin, pnMinHeight) {
    var cCompObj;
    var nCompHeight;
    var nBodyHeight = C_getBodyHeight();
    
    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.top = pnTopMargin;    //top 설정
        
        nCompHeight = nBodyHeight - cCompObj.top - pnBottomMargin;  //그리드 높이(윈도우높이-그리드상위위치-그리드하단공백)
        if (pnMinHeight) {
            if (nCompHeight < pnMinHeight) {
                nCompHeight = pnMinHeight;
            }
        }
    
        cCompObj.height = nCompHeight;  //height 설정
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 왼쪽 위치를 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열
 * @param pnLeft Number - 왼쪽 픽셀값
 */ 
function C_setComponentLeft(paCompArray, pnLeft) {
    var cCompObj;

    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.left = pnLeft;   //left 설정
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 위쪽 위치를 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열
 * @param pnTop Number - 위쪽 픽셀값
 */ 
function C_setComponentTop(paCompArray, pnTop) {
    var cCompObj;
    
    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.top = pnTop;    //top 설정
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 너비를 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열
 * @param pnWidth Number - 너비 픽셀값
 */ 
function C_setComponentWidth(paCompArray, pnWidth) {
    var cCompObj;
    
    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.width = pnWidth;    //width 설정
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 높이를 설정한다.
 * @param paCompArray Array - 컴포넌트ID 배열
 * @param pnHeight Number - 높이 픽셀값
 */ 
function C_setComponentHeight(paCompArray, pnHeight) {
    var cCompObj;
    
    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.height = pnHeight;    //height 설정
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 왼쪽 위치를 특정 컴포넌트를 기준으로 맞춘다.
 * @param paCompArray Array - 컴포넌트ID 배열 (필수)
 * @param psBaseCompId Object - 기준이 되는 컴포넌트ID (필수)
 * @param pnMargin Number - 간격 픽셀값 (선택)
 */ 
function C_setComponentSameLeft(paCompArray, psBaseCompId, pnMargin) {
    if (pnMargin == null) {
        pnMargin = 0;
    }
    
    var nBasePosition = psBaseCompId.left;
    var nPixel = nBasePosition + pnMargin;
    var cCompObj;
    
    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.left = nPixel;
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 위쪽 위치를 특정 컴포넌트를 기준으로 맞춘다.
 * @param paCompArray Array - 컴포넌트ID 배열 (필수)
 * @param psBaseCompId Object - 기준이 되는 컴포넌트ID (필수)
 * @param pnMargin Number - 간격 픽셀값 (선택)
 */ 
function C_setComponentSameTop(paCompArray, psBaseCompId, pnMargin) {
    if (pnMargin == null) {
        pnMargin = 0;
    }
    
    var nBasePosition = psBaseCompId.top;
    var nPixel = nBasePosition + pnMargin;
    var cCompObj;
    
    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.top = nPixel;
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 너비를 특정 컴포넌트를 기준으로 맞춘다.
 * @param paCompArray Array - 컴포넌트ID 배열 (필수)
 * @param psBaseCompId Object - 기준이 되는 컴포넌트ID (필수)
 * @param pnMargin Number - 간격 픽셀값 (선택)
 */ 
function C_setComponentSameWidth(paCompArray, psBaseCompId, pnMargin) {
    if (pnMargin == null) {
        pnMargin = 0;
    }
    
    var nBasePosition = psBaseCompId.width;
    var nPixel = nBasePosition + pnMargin;
    var cCompObj;
    
    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.width = nPixel;
        cCompObj.resize(false);
    }
}

/**
 * 컴포넌트들의 높이를 특정 컴포넌트를 기준으로 맞춘다.
 * @param paCompArray Array - 컴포넌트ID 배열 (필수)
 * @param psBaseCompId Object - 기준이 되는 컴포넌트ID (필수)
 * @param pnMargin Number - 간격 픽셀값 (선택)
 */ 
function C_setComponentSameHeight(paCompArray, psBaseCompId, pnMargin) {
    if (pnMargin == null) {
        pnMargin = 0;
    }
    
    var nBasePosition = psBaseCompId.height;
    var nPixel = nBasePosition + pnMargin;
    var cCompObj;
    
    for (var i=0; i<paCompArray.length; i++) {
        cCompObj = page.getControl(paCompArray[i]);
        cCompObj.height = nPixel;
        cCompObj.resize(false);
    }
}


/* ================================================== */ 
/* ============== 그리드 관련 함수 영역 =============== */ 
/* ================================================== */
 
/**
 * 그리드의 변경(추가,수정,삭제) 여부
 * @param pcGridObj 그리드
 * @return boolean 변경 여부
 */ 
function C_isModifiedGrid(pcGridObj) {
    var oDataset = pcGridObj.dataset;
    var aAddIdxArray = oDataset.getStatusIndex(eXria.data.CrudType.ADDEDFLAG).split(",");
    var aUpdIdxArray = oDataset.getStatusIndex(eXria.data.CrudType.MODIFIEDFLAG).split(",");
    var aDelIdxArray = oDataset.getStatusIndex(eXria.data.CrudType.DELETEDFLAG).split(",");
    
    aAddIdxArray.pop();
    aUpdIdxArray.pop();
    aDelIdxArray.pop();
    
    if (aAddIdxArray.length == 0 && aUpdIdxArray.length == 0 && aDelIdxArray.length == 0) {
        return false;
    }
    
	return true;
}

/**
 * 그리드의 추가 여부
 * @param pcGridObj 그리드
 * @return boolean 변경 여부
 */ 
function C_isAddedGrid(pcGridObj) {
    var oDataset = pcGridObj.dataset;
    var aAddIdxArray = oDataset.getStatusIndex(eXria.data.CrudType.ADDEDFLAG).split(",");
    
    aAddIdxArray.pop();
    
    if (aAddIdxArray.length == 0) {
        return false;
    }
    
	return true;
}

/**
 * 그리드의 수정 여부
 * @param pcGridObj 그리드
 * @return boolean 변경 여부
 */ 
function C_isUpdatedGrid(pcGridObj) {
    var oDataset = pcGridObj.dataset;
    var aUpdIdxArray = oDataset.getStatusIndex(eXria.data.CrudType.MODIFIEDFLAG).split(",");
    
    aUpdIdxArray.pop();
    
    if (aUpdIdxArray.length == 0) {
        return false;
    }
    
	return true;
}

/**
 * 그리드의 삭제 여부
 * @param pcGridObj 그리드
 * @return boolean 변경 여부
 */ 
function C_isDeletedGrid(pcGridObj) {
    var oDataset = pcGridObj.dataset;
    var aDelIdxArray = oDataset.getStatusIndex(eXria.data.CrudType.DELETEDFLAG).split(",");
    
    aDelIdxArray.pop();
    
    if (aDelIdxArray.length == 0) {
        return false;
    }
    
	return true;
}

/**
 * 그리드에 선택된 로우 데이타를 초기 데이타로 되돌려주는 함수.
 * @param pcGridObj Object - 그리드객체
 * @param psStatusColId String - 상태 컬럼의 ID
 */  
function C_undoGridData(pcGridObj, psStatusColId) {
    Common.restoreSelected(pcGridObj.id, psStatusColId);
    var oCurrRow = pcGridObj.focusRow;
    pcGridObj.grid.SetValue(oCurrRow, psStatusColId, "", true);
}

/**
 * 그리드에 로우를 추가하는 함수.
 * @param pcGridObj Object - 그리드객체
 * @param psStatusColId String - 상태 컬럼의 ID
 * @return Object 추가된 로우 객체
 */  
function C_addGridData(pcGridObj, psStatusColId) {
    var oAddRow = pcGridObj.addRow(); 
    pcGridObj.setFocusRow(oAddRow);
    pcGridObj.grid.SetValue(oAddRow, psStatusColId, "N", true);
    
    return oAddRow;
}

/**
 * 그리드에 로우를 삭제하는 함수.
 * @param pcGridObj Object - 그리드객체
 * @param psStatusColId String - 상태 컬럼의 ID
 */  
function C_deleteGridData(pcGridObj, psStatusColId) {
    var oDataset = pcGridObj.dataset;
    var oCurrRow = pcGridObj.focusRow;
    var nCurrRowIdx = pcGridObj.getIndexOfRow(oCurrRow);
    var nStatus = oDataset.getStatus(nCurrRowIdx+1);
    
    if (nStatus == eXria.data.CrudType.ADDEDFLAG
            || nStatus == eXria.data.CrudType.EMPTYEDFLAG ) {
        pcGridObj.delRow(oCurrRow);
    }
    else if (nStatus != eXria.data.CrudType.DELETEDFLAG) {
        Common.markDelete(pcGridObj.id, psStatusColId);
//        pcGridObj.grid.DeleteRow(oCurrRow, 2);
//        pcGridObj.grid.SetValue(oCurrRow, psStatusColId, "D", true);
        oDataset.setStatus(nCurrRowIdx+1, eXria.data.CrudType.DELETEDFLAG);
    }
}

/**
 * 그리드 셀의 값이 변경될 때 호출하여 데이터셋의 상태값을 설정하는 함수.
 * @param pcGridObj Object - 그리드객체
 * @param psChgColId String - 변경된 컬럼의 ID
 * @param psStatusColId String - 상태 컬럼의 ID
 */  
function C_setStatusByGridValueChanged(pcGridObj, psChgColId, psStatusColId) {
    if (psChgColId == psStatusColId) {
        return;
    }

    var oDataset = pcGridObj.dataset;
    var oCurrRow = pcGridObj.focusRow;
    var nCurrRowIdx = pcGridObj.getIndexOfRow(oCurrRow);
    var nStatus = oDataset.getStatus(nCurrRowIdx+1);

    if (nStatus == eXria.data.CrudType.ADDEDFLAG
            || nStatus == eXria.data.CrudType.EMPTYEDFLAG
            || nStatus == eXria.data.CrudType.DELETEDFLAG) {
        return;
    }
    
    if (pcGridObj.getValue(oCurrRow, psStatusColId) == "D") {
        //데이터셋의 상태를 삭제상태로 바꾼다.
        oDataset.setStatus(nCurrRowIdx+1, eXria.data.CrudType.DELETEDFLAG);
        return;
    }
    
    pcGridObj.setValue(oCurrRow, psStatusColId, "U", true);
}

/**
 * 그리드의 총건수를 표시하는 함수.
 * @param psLblCompId String - 표시 Label 컴포넌트ID (필수)
 * @param pcGridObj Object - 그리드객체 (필수)
 * @param psLblTitle String - 타이틀 값 (선택)(기본값:총건수)
 */  
function C_setLblGridRowCount(psLblCompId, pcGridObj, psLblTitle) {
    if (psLblTitle == null) {
        psLblTitle = "총건수";
    }
    
    var sLabelText = "[ "
                   + psLblTitle
                   + " : "
                   + pcGridObj.getRowCnt()
                   + " ]"
                   ;
    
    page.getControl(psLblCompId).setValue(sLabelText);
}

/**
 * 그리드의 선택건수를 표시하는 함수.
 * @param psLblCompId String - 표시 Label 컴포넌트ID (필수)
 * @param pcGridObj Object - 그리드객체 (필수)
 * @param psSelColId String - 선택 그리드컬럼ID (필수)
 * @param psLblTitle String - 타이틀 값 (선택)(기본값:선택건수)
 */  
function C_setLblGridSelCount(psLblCompId, pcGridObj, psSelColId, psLblTitle) {
    if (psLblTitle == null) {
        psLblTitle = "선택건수";
    }

    var nSelCnt = 0;
    
    for (var i=0; i<pcGridObj.getRowCnt(); i++) {
        var sRowSelected = pcGridObj.getValue(pcGridObj.getRowIndex(i), psSelColId);
        if (sRowSelected == "true") {
            nSelCnt++;
        }
    }
    
    var sLabelText = "[ "
                   + psLblTitle
                   + " : "
                   + nSelCnt
                   + " ]"
                   ;
    
    page.getControl(psLblCompId).setValue(sLabelText);
}

/**
 * 그리드의 높이 값을 구한다.
 * @param pnGridCnt Number - 그리드의 개수 (필수)
 * @param pnGridTop Number - 그리드의 상단값 (필수)
 * @param pnGridAreaTop Number - 그리드영역의 상단값 (필수)
 * @param pnGridMargin Number - 그리드영역 간의 여백 (필수)
 * @param pnBottomMargin Number - 아래쪽 여백 (필수)
 */ 
function C_getGridHeight(pnGridCnt, pnGridTop, pnGridAreaTop, pnGridMargin, pnBottomMargin) {
    var nBodyHeight = C_getBodyHeight();
    var nGridTitleHeight = pnGridTop - pnGridAreaTop;
    var nMargin = ((pnGridCnt-1) * pnGridMargin) + pnBottomMargin;
    var nGridHeight = (nBodyHeight - pnGridAreaTop - nMargin) / pnGridCnt;
    nGridHeight -= nGridTitleHeight;
    
    return nGridHeight;
}

/**
 * 그리드에 특정 값이 존재하는 첫번째 로우 인덱스를 구한다.
 * @param pcGridObj Object - 그리드객체 (필수)
 * @param psColId String - 그리드의 컬럼ID (필수)
 * @param psCellValue String - 비교대상 값 (필수)
 * @return Number 로우 인덱스
 */ 
function C_getGridMatchedIndex(pcGridObj, psColId, psCellValue) {
    var nMatchedRowIdx = null;
    
    for (var i=0; i<pcGridObj.getRowCnt(); i++) {
        if (psCellValue == pcGridObj.getValue(pcGridObj.getRowIndex(i), psColId)) {
            nMatchedRowIdx = i;
            break;
        }
    }
    
    return nMatchedRowIdx;
}

/**
 * 그리드에 특정 값이 존재하는지 여부를 구한다.
 * @param pcGridObj Object - 그리드객체 (필수)
 * @param psColId String - 그리드의 컬럼ID (필수)
 * @param psCellValue String - 비교대상 값 (필수)
 * @return boolean 존재여부
 */ 
function C_isExistGridValue(pcGridObj, psColId, psCellValue) {
    var bFound = false;
    
    for (var i=0; i<pcGridObj.getRowCnt(); i++) {
        if (psCellValue == pcGridObj.getValue(pcGridObj.getRowIndex(i), psColId)) {
            bFound = true;
            break;
        }
    }
    
    return bFound;
}

/**
 * 그리드에서 신규 상태인 행의 인덱스를 구한다.
 * @param pcGridObj Object - 그리드객체
 * @return Array 행인덱스 배열
 */ 
function C_getAddedIndex(pcGridObj) {
    var oDataset = pcGridObj.dataset;
    var aAddIdxArray = oDataset.getStatusIndex(eXria.data.CrudType.ADDEDFLAG).split(",");
    aAddIdxArray.pop();
    var aRtnArray = new Array();
    
    for (var i=0; i<aAddIdxArray.length; i++) {
        aRtnArray.push(aAddIdxArray[i] - 1);
    }

    return aRtnArray;
}

/**
 * 그리드에서 수정 상태인 행의 인덱스를 구한다.
 * @param pcGridObj Object - 그리드객체
 * @return Array 행인덱스 배열
 */ 
function C_getUpdatedIndex(pcGridObj) {
    var oDataset = pcGridObj.dataset;
    var aUpdIdxArray = oDataset.getStatusIndex(eXria.data.CrudType.MODIFIEDFLAG).split(",");
    aUpdIdxArray.pop();
    var aRtnArray = new Array();
    
    for (var i=0; i<aUpdIdxArray.length; i++) {
        aRtnArray.push(aUpdIdxArray[i] - 1);
    }

    return aRtnArray;
}

/**
 * 그리드에서 삭제 상태인 행의 인덱스를 구한다.
 * @param pcGridObj Object - 그리드객체
 * @return Array 행인덱스 배열
 */ 
function C_getDeletedIndex(pcGridObj) {
    var oDataset = pcGridObj.dataset;
    var aDelIdxArray = oDataset.getStatusIndex(eXria.data.CrudType.DELETEDFLAG).split(",");
    aDelIdxArray.pop();
    var aRtnArray = new Array();
    
    for (var i=0; i<aDelIdxArray.length; i++) {
        aRtnArray.push(aDelIdxArray[i] - 1);
    }

    return aRtnArray;
}

/**
 * 그리드에서 선택된 행들의 인덱스 배열을 구한다.
 * @param pcGridObj Object - 그리드객체
 * @return Array 행인덱스 배열
 */ 
function C_getSelRowIdxs(pcGridObj) {
    var aSelRowIdxs = pcGridObj.getSelectedIndexes();

    if (aSelRowIdxs == null) {
        aSelRowIdxs = new Array();
        if (pcGridObj.getFocusRowIndex() != null) {
            aSelRowIdxs.push(pcGridObj.getFocusRowIndex());
        }
    }

    return aSelRowIdxs;
}


/* ================================================== */ 
/* ============== 첨부파일 관련 함수 영역 ============== */ 
/* ================================================== */
 
/**
 * 파일 전체경로에서 파일명을 추출한다.
 * @param psFile String - 파일전체경로
 * @return String 파일명
 */ 
function C_getFileName(psFile) {
    if (psFile == null) {
        return '';
    }
    
//    var sFile = psFile.substring(psFile.lastIndexOf('\\') + 1, psFile.length);
//    var sFileName;
//    var sExp;
//    if (sFile.indexOf('.') >= 0) {
//        sFileName = sFile.substring(0, sFile.lastIndexOf('.'));
//        sExp = sFile.substring(sFile.lastIndexOf('.') + 1, sFile.length);
//    } else {
//        sFileName = sFile;
//        sExp = '';
//    }

    var sFileName = psFile.substring(psFile.lastIndexOf('\\') + 1);

    return sFileName;
}

/**
 * 첨부파일을 다운로드한다.
 * @param psOrgFileNm String - 원본파일명
 * @param psSaveFileNm String - 저장파일명
 * @param psFilePath String - 파일경로
 */ 
function C_downloadAtchFile(psOrgFileNm, psSaveFileNm, psFilePath) {
    //CRE 에서 제공하는 FileDownloadUtil 객체를 이용해 파일을 다운로드한다
    //생성자로 this 객체를 넘겨준다
    var fileUtil = new eXria.util.FileDownloadUtil(this);
     
    //다운로드를 위한 파라미터값을 추가한다
    fileUtil.addParam(page, "orgFileNm", psOrgFileNm);
    fileUtil.addParam(page, "saveFileNm", psSaveFileNm);
    fileUtil.addParam(page, "filePath", psFilePath);
    fileUtil.setURL("/gnss/system/common/cmmnAtchFile/downloadAtchFile.do");
     
    //설정을 마치고 fileDown 함수를 호출하면 요청이 서버로 전송되고 파일이 다운로드 된다
    fileUtil.fileDown();
	
}


/* ================================================== */ 
/* =============== 기타 일반 함수 영역 ================ */ 
/* ================================================== */
 
/**
 * DB에 저장된 파라미터 값을 구한다.
 * @param psParaId 파라미터ID
 * @return String 파라미터값
 */ 
function C_getDbParamValue(psParaId) {
    if (psParaId == null || psParaId == "") {
        return;
    }

    var oInstance = page.getInstance("ins_request");
    oInstance.setValue("/root/reqDbParamValue/reqParaId", psParaId);
    page.getSubmission("sbm_get_db_param_value").send();

    oInstance = page.getInstance("ins_response");
    var sDbParamValue = oInstance.getValue("/root/getDbParamValue/PARA_VAL");
    
    return sDbParamValue;
}

/**
 * 값이 null일 경우 대체한다.
 * @param psSrcVal 원본 문자열 (필수)
 * @param psNewVal 대체 문자열 (선택)(기본값: "")
 * @return String 결과값
 */ 
function C_nvl(psSrcVal, psNewVal) {
	var sRtnVal = psSrcVal;
	
	if (psNewVal == null) {
		psNewVal = "";
	}
	
	if (psSrcVal == null) {
		sRtnVal = psNewVal;
	}
	
	return sRtnVal;
}

/**
 * 배열의 sort()에 이용할 숫자 오름차순 함수.
 * @param pnVal1 원본 문자열 (필수)
 * @param pnVal2 대체 문자열 (선택)(기본값: "")
 * @return Number 결과값
 */ 
function C_ascNum4Array(pnVal1, pnVal2){
	return pnVal1 - pnVal2;
}

/**
 * 배열의 sort()에 이용할 숫자 내림차순 함수.
 * @param pnVal1 원본 문자열 (필수)
 * @param pnVal2 대체 문자열 (선택)(기본값: "")
 * @return Number 결과값
 */ 
function C_descNum4Array(pnVal1, pnVal2){
	return pnVal2 - pnVal1;
}
