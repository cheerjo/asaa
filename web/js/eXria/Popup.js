/**********************************************************************/
// 프로그램명 : 팝업스크립트
// 설      명 : 팝업스크립트 JS
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

var P_oCallbackFuncObj; //팝업 콜백 함수 객체
var P_oParamMap;        //팝업에 넘길 파라메터 맵

/**
 * 팝업 위치를 구한다. (미사용)
 * @param pnWidth 팝업 너비
 * @param pnHeight 팝업 높이
 */ 
function P_getPopupPosition(pnWidth, pnHeight) {
    var aRetArray = new Array();
    
    var nBrowserWidth = window.innerWidth;
    var nBrowserHeight = window.innerHeight;
    var nTop = (nBrowserHeight - pnHeight - 10) / 2;
    var nLeft = (nBrowserWidth - pnWidth) / 2;
    nTop = nTop < 0 ? 0 : nTop;
    nLeft = nLeft < 0 ? 0 : nLeft;
    
    aRetArray[0] = nTop;
    aRetArray[1] = nLeft;
    
    return aRetArray;
}


/**
 * 프로그램 검색 팝업을 띄운다.
 * @param poFuncObj 팝업 콜백 함수 객체 (필수)
 * @param psPopupName 팝업명 (선택)
 */
function P_popupPgmSrch(poFuncObj, psPopupName) {
    //콜백등록
     P_oCallbackFuncObj = poFuncObj;
    if (psPopupName == null || psPopupName == "") {
        psPopupName = "프로그램검색";
    }

    var oWindow = page.window;
    
    P_oParamMap = new Object();
    P_oParamMap.popupName = psPopupName;
    
    var nPopupWidth = 550;
    var nPopupHeight = 520;
    var sLocation = "/gnss/system/popup/PopupPgmSrch.xrf";
    var sFeature = "menubar=no,  scrollbars =no, toolbar=no,"
                 + "width=" + nPopupWidth + "px,"
                 + "height=" + nPopupHeight + "px"	
                 ;
	 var sRtnVal = oWindow.open(sLocation,"프로그램검색",sFeature);
}

/**
 * 프로그램 검색 팝업의 콜백 함수
 * @param psPgmId 프로그램ID
 * @param psPgmNm 프로그램명
 */ 
function P_callbackPopupPgmSrch(psPgmId, psPgmNm) {
    P_oCallbackFuncObj(psPgmId, psPgmNm);
}


/**
 * 비밀번호 변경 팝업을 띄운다.
 * @param poFuncObj 팝업 콜백 함수 객체 (필수)
 * @param psPopupName 팝업명 (선택)
 */ 
function P_popupConnPwChg(poFuncObj, psPopupName) {
    
    P_oCallbackFuncObj = poFuncObj;
    
    if (psPopupName == null || psPopupName == "") {
        psPopupName = "비밀번호 변경";
    }
    
    var nPopupWidth = 400;
    var nPopupHeight = 185;
    var aPopupPostionArray = P_getPopupPosition(nPopupWidth, nPopupHeight);
    var nPopupTop = aPopupPostionArray[0];
    var nPopupLeft = aPopupPostionArray[1];
    
    WebSquare.uiplugin.popup.openPopup("/gnss/system/popup/PopupConnPwChgWq.xml", {
        id : "PopupConnPwChg",
        type : "window", 
        width: nPopupWidth+"px",
        height: nPopupHeight+"px",
        top: nPopupTop+"px",
        left: nPopupLeft+"px",
     
        popupName : popupName, //popupName popup 객체의 이름으로 popup 프레임의 표시줄에 나타납니다.
        modal : true,
        useIFrame : true,
     
        style : "", //popup의 스타일을 지정합니다. 값이 있으면 left top width height는 적용되지 않습니다.
        
        // popup option window.open을 사용하는 경우(useIfrmae false인 경우) popup에 넘어가는 parameter
        resizable : false,
        status : false,
        menubar : false,
        scrollbars : false,
        title : false,
        
        srcData: "",
        destData: ""
    });
}

/**
 * 비밀번호 변경 팝업의 콜백 함수
 * @param psConnPw 비밀번호
 */ 
function P_callbackPopupConnPwChg(psConnPw) {
    P_oCallbackFuncObj(psConnPw);
}


/**
 * 권한 검색 팝업을 띄운다.
 * @param poFuncObj 팝업 콜백 함수 객체 (필수)
 * @param psPopupName 팝업명 (선택)
 */ 
function P_popupAutSrch(poFuncObj, psPopupName) {
    
    P_oCallbackFuncObj = poFuncObj;
    
    if (psPopupName == null || psPopupName == "") {
        psPopupName = "권한검색";
    }


    var oWindow = page.window;
    
    P_oParamMap = new Object();
    P_oParamMap.popupName = psPopupName;
    
    var nPopupWidth = 550;
    var nPopupHeight = 520;
    
    var sLocation = "/gnss/system/popup/PopupAutSrch.xrf";
    var sFeature = "menubar=no,  scrollbars =no, toolbar=no,"
                 + "width=" + nPopupWidth + "px,"
                 + "height=" + nPopupHeight + "px"	
                 ;
     var sRtnVal = oWindow.open(sLocation,"권한검색",sFeature);
    
}

/**
 * 권한 검색 팝업의 콜백 함수
 * @param psAutId 권한ID
 * @param psAutNm 권한명
 * @param psAutDesc 권한설명
 */ 
function P_callbackPopupAutSrch(psAutId, psAutNm, psAutDesc) {
    P_oCallbackFuncObj(psAutId, psAutNm, psAutDesc);
}


/**
 * 공통코드 검색 팝업을 띄운다.
 * @param poFuncObj 팝업 콜백 함수 객체 (필수)
 * @param psLbrnCd 대분류코드 (필수)
 * @param psLbrnCdTxt 대분류코드 표기명 (선택)
 * @param psLbrnNmTxt 대분류명 표기명 (선택)
 * @param psTtlNo 소분류타이틀번호(1~5가 아니면 소분류명) (선택)
 * @param psPopupName 팝업명 (선택)
 */ 
function P_popupCmmnCd(poFuncObj, psLbrnCd, psLbrnCdTxt, psLbrnNmTxt, psTtlNo, psPopupName) {
    
    P_oCallbackFuncObj = poFuncObj;
    
    //팝업명 설정
    if (psPopupName == null || psPopupName == "") {
        if (psLbrnCdTxt != null && psLbrnCdTxt != "") {
            psPopupName = psLbrnCdTxt + " 검색";
        }
        else if (psLbrnNmTxt != null && psLbrnNmTxt != "") {
            psPopupName = psLbrnNmTxt + " 검색";
        }
        else {
            psPopupName = "공통코드 검색";
        }
    }
    
    var oWindow = page.window;
//    oWindow.paramObj = new Object();
//    var oParamObj = oWindow.paramObj;
//    oParamObj.lbrnCd = psLbrnCd;
//    oParamObj.lbrnCdTxt = psLbrnCdTxt;
//    oParamObj.lbrnNmTxt = psLbrnNmTxt;
//    oParamObj.ttlNo = psTtlNo;
//    oParamObj.popupName = psPopupName;
    
    P_oParamMap = new Object();
    P_oParamMap.lbrnCd = psLbrnCd;
    P_oParamMap.lbrnCdTxt = psLbrnCdTxt;
    P_oParamMap.lbrnNmTxt = psLbrnNmTxt;
    P_oParamMap.ttlNo = psTtlNo;
    P_oParamMap.popupName = psPopupName;
    
    var nPopupWidth = 550;
    var nPopupHeight = 520;
    
    var sLocation = "/gnss/system/popup/PopupCmmnCd.xrf";
   var sFeature = "menubar=no,  scrollbars =no, toolbar=no,"
                 + "width=" + nPopupWidth + "px,"
                 + "height=" + nPopupHeight + "px"	
                 ;
 //   var sRtnVal = oWindow.showModalDialog(sLocation, oWindow, sFeature);
//    var sRtnVal = page.openPage("popup", sLocation, eXria.form.PageType.MODAL, sFeature);
  var sRtnVal = oWindow.open(sLocation,"공통코드검색",sFeature);
}

/**
 * 공통코드 검색 팝업의 콜백 함수
 * @param psSbrnCd 소분류코드
 * @param psSbrnNm 소분류코드명
 */ 
function P_callbackPopupCmmnCd(psSbrnCd, psSbrnNm) {
    P_oCallbackFuncObj(psSbrnCd, psSbrnNm);
}


/**
 * 시스템사용자 검색 팝업을 띄운다.
 * @param poFuncObj 팝업 콜백 함수 객체 (필수)
 * @param psPopupName 팝업명 (선택)
 */ 
function P_popupSysUsrSrch(poFuncObj, psPopupName) {
    
    P_oCallbackFuncObj = poFuncObj;
    
    if (psPopupName == null || psPopupName == "") {
        psPopupName = "시스템사용자 검색";
    }
    
    var oWindow = page.window;
    
    P_oParamMap = new Object();
    P_oParamMap.popupName = psPopupName;
    
    var nPopupWidth = 550;
    var nPopupHeight = 520;
    
    var sLocation = "/gnss/system/popup/PopupSysUsrSrch.xrf";
    var sFeature = "menubar=no,  scrollbars =no, toolbar=no,"
                 + "width=" + nPopupWidth + "px,"
                 + "height=" + nPopupHeight + "px"	
                 ;
    
    var sRtnVal = oWindow.open(sLocation,"시스템사용자검색",sFeature);
}

/**
 * 시스템사용자 검색 팝업의 콜백 함수
 * @param psUsrId 사용자ID
 * @param psUsrNm 사용자명
 * @param psEpno 사번
 * @param psOrgzKorNm 조직명
 */ 
function P_callbackPopupSysUsrSrch(psUsrId, psUsrNm, psEpno, psOrgzKorNm) {
    P_oCallbackFuncObj(psUsrId, psUsrNm, psEpno, psOrgzKorNm);
}


/**
 * 메뉴 검색 팝업을 띄운다.
 * @param poFuncObj 팝업 콜백 함수 객체 (필수)
 * @param psPopupName 팝업명 (선택)
 */ 
function P_popupMnuSrch(poFuncObj, psPopupName) {
    
    P_oCallbackFuncObj = poFuncObj;
    
    if (psPopupName == null || psPopupName == "") {
        psPopupName = "메뉴 검색";
    }
    
    var nPopupWidth = 530;
    var nPopupHeight = 540;
    var aPopupPostionArray = P_getPopupPosition(nPopupWidth, nPopupHeight);
    var nPopupTop = aPopupPostionArray[0];
    var nPopupLeft = aPopupPostionArray[1];
    
    WebSquare.uiplugin.popup.openPopup("/gnss/system/popup/PopupMnuSrchWq.xml", {
        id : "PopupMnuSrch",
        type : "window", 
        width: nPopupWidth+"px",
        height: nPopupHeight+"px",
        top: nPopupTop+"px",
        left: nPopupLeft+"px",
     
        popupName : popupName, //popupName popup 객체의 이름으로 popup 프레임의 표시줄에 나타납니다.
        modal : true,
        useIFrame : true,
     
        style : "", //popup의 스타일을 지정합니다. 값이 있으면 left top width height는 적용되지 않습니다.
        
        // popup option window.open을 사용하는 경우(useIfrmae false인 경우) popup에 넘어가는 parameter
        resizable : false,
        status : false,
        menubar : false,
        scrollbars : false,
        title : false,
        
        srcData: "",
        destData: ""
    });
    
}

/**
 * 메뉴 검색 팝업의 콜백 함수
 * @param psMnuId 메뉴ID
 * @param psMnuNm 메뉴명
 * @param psTopMnuId 최상위메뉴ID
 * @param psTopMnuNm 최상위메뉴명
 * @param psPgmId 프로그램ID
 * @param psPgmNm 프로그램명
 */ 
function P_callbackPopupMnuSrch(psMnuId, psMnuNm, psTopMnuId, psTopMnuNm, psPgmId, psPgmNm) {
    P_oCallbackFuncObj(psMnuId, psMnuNm, psTopMnuId, psTopMnuNm, psPgmId, psPgmNm);
}


/**
 * 매직원등록 팝업을 실행한다.
 * @param sPgmNm 프로그램 Name
 * @param sPgmId 프로그램 Id
 */ 
function P_popupMagcRegsPop(psPgmNm, psPgmId) {
    
    var oWindow = page.window;
    
    P_oParamMap = new Object();
    P_oParamMap.pgmNmTxt = psPgmNm;
    P_oParamMap.pgmIdTxt = psPgmId;
    
      var nPopupWidth = 718;
    var nPopupHeight = 617;
    
    
    var sLocation = "/gnss/system/magicone/MagcRegsPop.xrf";
    var sFeature = "menubar=no,  scrollbars =no, toolbar=no,"
                 + "width=" + nPopupWidth + "px,"
                 + "height=" + nPopupHeight + "px"	
                 ;

	//멀티파일업로드flash가 modaldialog에서 파일찾기 클릭시 작동이 안되고 다이얼로그창을 닫으면 열리는 현상
	//modaldialog를 open함수로 대체
    var sRtnVal = oWindow.open(sLocation,"매직원등록팝업",sFeature);
}


/**
 * 매직원 작업이력 팝업을 띄운다.
 * @param psPgmId 프로그램 ID(필수)
 */ 
function P_popupPgmMagcHisPop(psPgmId) {
    
    var oWindow = page.window;
   
    P_oParamMap = new Object();
    P_oParamMap.PgmId = psPgmId;
    
    var nPopupWidth = 745;
    var nPopupHeight = 1020;
    
    var sLocation = "/gnss/system/magicone/PgmMagcHisPop.xrf";
    var sFeature = "menubar=no,  scrollbars =no, toolbar=no,"
                 + "width=" + nPopupWidth + "px,"
                 + "height=" + nPopupHeight + "px"	
                 ;
    
    var sRtnVal = oWindow.open(sLocation,"매직원작업이력",sFeature);
}


/**
 * 사원 검색 팝업을 띄운다.
 * @param poFuncObj 팝업 콜백 함수 객체 (필수)
 * @param psPopupName 팝업명 (선택)
 */
function P_popupEmpySrch(poFuncObj, psPopupName) {
    
    P_oCallbackFuncObj = poFuncObj;
    
    if (psPopupName == null || psPopupName == "") {
        psPopupName = "사원 검색";
    }

    var oWindow = page.window;
    
    P_oParamMap = new Object();
    P_oParamMap.popupName = psPopupName;
    
    var nPopupWidth = 426;
    var nPopupHeight = 520;
    
    var sLocation = "/gnss/system/popup/PopupEmpySrch.xrf";
    var sFeature = "menubar=no,  scrollbars =no, toolbar=no,"
                 + "width=" + nPopupWidth + "px,"
                 + "height=" + nPopupHeight + "px"	
                 ;
    
        var sRtnVal = oWindow.open(sLocation,"사원검색",sFeature);
}

/**
 * 사원 검색 팝업의 콜백 함수
 * @param psEpno 사번
 * @param psKorNm 성명
 * @param psOrgzId 조직ID
 * @param psOrgzKorNm 조직명
 * @param psUsrId 이용자ID
 */ 
function P_callbackPopupEmpySrch(psEpno, psKorNm, psOrgzId, psOrgzKorNm, psUsrId) {
    P_oCallbackFuncObj(psEpno, psKorNm, psOrgzId, psOrgzKorNm, psUsrId);
}


/**
 * 사원 검색(다중선택) 팝업을 띄운다.
 * @param poFuncObj 팝업 콜백 함수 객체 (필수)
 * @param psPopupName 팝업명 (선택)
 */
function P_popupEmpyMulSrch(poFuncObj, psPopupName) {
    
    P_oCallbackFuncObj = poFuncObj;
    
    if (psPopupName == null || psPopupName == "") {
        psPopupName = "사원 검색";
    }

    var oWindow = page.window;
    
    P_oParamMap = new Object();
    P_oParamMap.popupName = psPopupName;
    
    var nPopupWidth = 426;
    var nPopupHeight = 520;
    
    var sLocation = "/gnss/system/popup/PopupEmpyMulSrch.xrf";
   var sFeature = "menubar=no,  scrollbars =no, toolbar=no,"
                 + "width=" + nPopupWidth + "px,"
                 + "height=" + nPopupHeight + "px"	
                 ;
    
        var sRtnVal = oWindow.open(sLocation,"사원검색",sFeature);
}

/**
 * 사원 검색(다중선택) 팝업의 콜백 함수
 * @param paEpno 사번 배열
 * @param paKorNm 성명 배열
 * @param paOrgzId 조직ID 배열
 * @param paOrgzKorNm 조직명 배열
 * @param paUsrId 이용자ID 배열
 */ 
function P_callbackPopupEmpyMulSrch(paEpno, paKorNm, paOrgzId, paOrgzKorNm, paUsrId) {
    P_oCallbackFuncObj(paEpno, paKorNm, paOrgzId, paOrgzKorNm, paUsrId);
}
