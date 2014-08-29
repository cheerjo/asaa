/**
 * 메시지 처리 공통 모듈
 */
var ComMsg = {
  /**
   * 레이어드 팝업 메시지 창을 식별 하기 위한 내부적인 시퀀스 인덱스
   * @type Number
   * @private
   */  
  seq : 0,
  /**
   * 개별 레이어드 팝업 메시지 창에서 호출될 콜백 함수를  시퀀스 인덱스 별로 저장하기 위한 오브젝트
   * @type Object
   * @private
   */  
  idxs : {},
  /**
   * 메시지 창의 반환값을 저장하기 위한 변수
   * @type String
   * @private
   */  
  retVal : null,
  
  /**
   * 모달 메시지 창에 표시될 메시지를 메시지 창에서 참조하도록 하기 위한 변수
   * @type Array
   * @private
   */  
  msgRef : null,
  
  /**
   * 메시지 창에서 참조할 상세 메시지 데이타를 저장하는 instance reference 정보
   * page Id, intance Id, instance path, col id(구분), col id(내용), col id(비고)
   * 정보를 순차적으로 ','를 구분자로 하여 하나의 문자열 값으로 구성
   * @type String
   * @private
   */  
  instanceRef : null,
  
  /**
   * 모달 메시지 창에 메시지 표시 영역 높이를 메시지 창에서 참조하도록 하기 위한 변수
   * @type Number
   * @private
   */  
  contentHeight : null,
  
  /**
   * 메시지 창의 고정 가로 길이.
   * 0일 경우 메시지 길이에 따른 가변 길이가 적용됨.
   * @type Number
   */  
  fixedWidth : 0,
  
  /**
   * 메시지 창의 고정 세로 길이.
   * 0일 경우 메시지 라인 수에 따른 가변 길이가 적용됨.
   * @type Number
   */  
  fixedHeight : 0,
  
  /**
   * 특정 메시지가 정의되어 있는 지를 확인하는 메소드.
   * @param {String} psId 메시지 정의 ID
   * @param {String} psMsg 메시지 내용
   * @private
   */  
  _verifyID : function(psId, psMsg) {
    if (eXria.util.ValueUtil.isNull(psMsg)) {
      //      this.alert(NLS.MSG.WRN.M006(psId)); // alert("[" + psId +
      // "]는 존재하지
      this.showMsg("co.error.missing", [psId]);
      // 않습니다.");
      return false;
    }
    return true;
  },
  /**
   * 메시지 팝업창 식별자를 내부적으로 설정해주는 메소드
   * @private
   */  
  _getUniqueIdx : function() {
    var vnCnt = 0;
    var attr = null;
    for (attr in this.idxs) {
      vnCnt++;
    }
    if (vnCnt == 0) {
      this.seq = 0;
    }
    this.idxs [this.seq++] = {};
  },
  /**
   * 메시지 창을 닫을 시 내부적으로 할당된 식별자를 해제해주는 메소드
   * @param {Number} pnIdx 해제할 창의 식별자
   * @private
   */  
  _unregIdx : function(pnIdx) {
    delete this.idxs [pnIdx];
  },
  /**
   * @private
   */  
  _getYesCallBack : function(pnIdx) {
    return this.idxs [pnIdx] ["yesCallBack"];
  },
  /**
   * @private
   */  
  _getNoCallBack : function(pnIdx) {
    return this.idxs [pnIdx] ["noCallBack"];
  },
  /**
   * @private
   */  
  getRetVal : function(pnIdx) {
    return this.idxs [pnIdx] ["retVal"];
  },
  /**
   * 다국어 처리 메시지를 위한 메소드
   * ex) ComMsg.getMsg("co.error.general", ["입력"], ["정수"]); -> NLS.co.error.general : 입력 중 오류가 발생하였습니다.\n정수 형식으로 입력하십시오.
   * @param {String} psMsg 메시지 객체를 문자열로 표현한 값
   * @param {Array(String)} paArgs 메시지 내용 중 @로 표시된 부분 넣어줄 데이터 배열
   * @return 메시지 내용
   * @type String
   */  
  getMsg : function(psId, paParam, paCoParam) {
    var vsMsg = "NLS." + psId + ".code";
    var vsCoMsg = null;
    try {
      vsMsg = eval(vsMsg);
      vsCoMsg = "NLS." + psId + ".coKey";
    } catch (err) {
      vsMsg = psId;
    }
    if (vsMsg.constructor != String) {
      vsMsg = this._getMsgFromFunc(vsMsg, paParam);
    }
    if (vsCoMsg) {
      try {
        vsCoMsg = eval(vsCoMsg);
        if (vsCoMsg) {
          vsCoMsg = eval("NLS." + vsCoMsg + ".code");
        }
      } catch (err) {
        vsCoMsg = null;
      }
      if (vsCoMsg && (vsCoMsg.constructor != String)) {
        vsCoMsg = this._getMsgFromFunc(vsCoMsg, paCoParam);
      }
    }
    if (vsCoMsg) {
      vsMsg += "\n" + vsCoMsg;
    }
    return vsMsg;
  },
  
  /**
   * 메시지를 표시한다.
   * @param {String} psMsg 메시지 정의 ID
   * @param {Array(String)} paArgs 메시지 내용 중 @로 표시된 부분 넣어줄 데이터 배열
   * @param {String} psType 메시지 창 종류 구분 문자열(error|info|warn|confirm)
   * @param {String} psInstRef 메시지 창에서 참조할 상세 메시지 데이타를 저장하는 instance reference 정보
   * @return 메시지창 확인 결과
   * @type String
   */  
  alert : function(psMsg, paArgs, psType, psInstRef) {
    var vsUrl = "/inc/msg/msgAlert.html";
    if (psType) {
      if (psType == "error") {
        vsUrl = "/inc/msg/msgError.html";
      } else if (psType == "info") {
        vsUrl = "/inc/msg/msgInfo.html";
      } else if (psType == "warn") {
        vsUrl = "/inc/msg/msgWarn.html";
      } else if (psType == "help") {
        vsUrl = "/inc/msg/msgHelp.html";
      } else if (psType == "confirm") {
        vsUrl = "/inc/msg/msgConfirm.html";
      }
    }
    this._showMsg(psMsg, paArgs, vsUrl, psInstRef);
    return this.retVal;
  },
  
  /**
   * Information 에 해당하는 메시지, NLS.MSG.INF 에 등록된 메세지만 가져옵니다.
   * ex) ComMsg.info("M001"); -> NLS.MSG.INF.M001 : 성공적으로 저장하였습니다.
   * @param {String} psId 메시지 정의 ID
   * @param {Array(String)} paArgs 메시지 내용 중 @로 표시된 부분 넣어줄 데이터 배열
   * @param {String} psInstRef 메시지 창에서 참조할 상세 메시지 데이타를 저장하는 instance reference 정보
   */  
  info : function(psId, paArgs, psInstRef) {
    var vsMsg = "NLS.MSG.INF." + psId;
    var vsUrl = "/inc/msg/msgInfo.html";
    this._showMsg(vsMsg, paArgs, vsUrl, psInstRef);
  },
  
  /**
   * Confirm 에 해당하는 메시지, NLS.MSG.CRM 에 등록된 메세지만 가져옵니다.
   * ex) ComMsg.confirm("M001"); -> NLS.MSG.CRM.M001 : 저장하시겠습니까?
   * @param {String} psId 메시지 정의 ID
   * @param {Array(String)} paArgs 메시지 내용 중 @로 표시된 부분 넣어줄 데이터 배열
   * @param {String} psInstRef 메시지 창에서 참조할 상세 메시지 데이타를 저장하는 instance reference 정보
   * @return Confirm 창의 확인 결과
   * @type Boolean
   */  
  confirm : function(psId, paArgs, psInstRef) {
    var vsMsg = "NLS.MSG.CRM." + psId;
    var vsUrl = "/inc/msg/msgConfirm.html";
    this._showMsg(vsMsg, paArgs, vsUrl, psInstRef);
    return this.retVal;
  },
  
  /**
   * Error 에 해당하는 메시지, NLS.MSG.ERR 에 등록된 메세지만 가져옵니다.
   * ex) ComMsg.error("M001", ["우편번호"]); -> NLS.MSG.ERR.M001 : 우편번호은(는) 변경된 사항이 없습니다.
   * @param {String} psId 메시지 정의 ID
   * @param {Array(String)} paArgs 메시지 내용 중 @로 표시된 부분 넣어줄 데이터 배열
   * @param {String} psInstRef 메시지 창에서 참조할 상세 메시지 데이타를 저장하는 instance reference 정보
   */  
  error : function(psId, paArgs, psInstRef) {
    var vsMsg = "NLS.MSG.ERR." + psId;
    var vsUrl = "/inc/msg/msgError.html";
    this._showMsg(vsMsg, paArgs, vsUrl, psInstRef);
  },
  
  /**
   * Warning 에 해당하는 메시지, NLS.MSG.WRN 에 등록된 메세지만 가져옵니다.
   * ex) ComMsg.warn("M003", ["발송인"]); -> NLS.MSG.WRN.M003 : 발송인을(를) 입력하십시오.
   * @param {String} psId 메시지 정의 ID
   * @param {Array(String)} paArgs 메시지 내용 중 @로 표시된 부분 넣어줄 데이터 배열
   * @param {String} psInstRef 메시지 창에서 참조할 상세 메시지 데이타를 저장하는 instance reference 정보
   */  
  warn : function(psId, paArgs, psInstRef) {
    var vsMsg = "NLS.MSG.WRN." + psId;
    var vsUrl = "/inc/msg/msgWarn.html";
    this._showMsg(vsMsg, paArgs, vsUrl, psInstRef);
  },
  
  /**
   * 다국어 처리 메시지 객체를 화면에 보여주기 위한 메소드
   * ex) ComMsg._showMsg("NLS.MSG.WRN.M003", ["발송인"]); -> NLS.MSG.WRN.M003 : 발송인을(를) 입력하십시오.
   * @param {String} psMsg 메시지 객체를 문자열로 표현한 값
   * @param {Array(String)} paArgs 메시지 내용 중 @로 표시된 부분 넣어줄 데이터 배열
   * @param {String} psUrl 메시지 내용을 표시할 화면 URL
   * @param {String} psInstRef 메시지 창에서 참조할 상세 메시지 데이타를 저장하는 instance reference 정보
   * @private
   */  
  _showMsg : function(psMsg, paArgs, psUrl, psInstRef) {
    if ((psInstRef != null) && (psInstRef != "")) {
      this.instanceRef = psInstRef;
    }
    var vsMsg = psMsg;
    if (vsMsg.indexOf("NLS.") == 0) {
      try {
        vsMsg = eval(psMsg);
      } catch (err) {
      }
    }
    if ((vsMsg != null) && (vsMsg.constructor != String)) {
      if (paArgs == null) {
        paArgs = [];
      }
      var vnSize = paArgs.length;
      var vsArgs = "(";
      for (var i = 0; i < vnSize; i++) {
        paArgs [i] = paArgs [i].replace("\n", "\\n");
        vsArgs += "\"" + paArgs [i] + "\",";
      }
      vsArgs = vsArgs.replace(/,$/, ")");
      if (psMsg.constructor == String) {
        vsMsg = eval(psMsg + vsArgs);
      } else {
        vsMsg = psMsg.apply(psMsg, paArgs);
      }
      vsMsg = vsMsg.replace(/\\\\n/g, "\n");
    }
    
    var vbValid = this._verifyID(psMsg, vsMsg);
    if (!vbValid) {
      return;
    }
    
    var vaMsgLine = vsMsg.split("\n");
    if (vaMsgLine.length == 1) {
      vaMsgLine = vaMsgLine [0].split("\\n");
    }
    this.msgRef = vaMsgLine;
    var vnByteLength;
    var vnMaxByteLength = 0;
    var vnDialogWidth = 0;
    var vnDialogHeight = 0;
    
    var vnCnt = vaMsgLine.length;
    if (this.fixedWidth == 0) {
      for (var i = 0; i < vnCnt; i++) {
        vnByteLength = UtilString.getByteLength(vaMsgLine [i]);
        if (vnByteLength > vnMaxByteLength) {
          vnMaxByteLength = vnByteLength;
        }
      }
      vnDialogWidth = (vnMaxByteLength * 6) + 100;
      if (vnDialogWidth < 420) {
        vnDialogWidth = 420;
      }
    } else {
      vnDialogWidth = this.fixedWidth;
    }
    
    if (this.fixedHeight == 0) {
      vnDialogHeight = 123 + (vnCnt * 19);
      if (vnDialogHeight < 205) {
        vnDialogHeight = 205;
      }
    } else {
      vnDialogHeight = this.fixedHeight;
    }
    
    var vnDialogLeft = (window.screen.availWidth - vnDialogWidth) / 2;
    var vnDialogTop = (window.screen.availHeight - vnDialogHeight) / 2;
    
    this.contentHeight = (vnCnt * 18) + 2;
    
    // this.alert(vsMsg);
    Common.openPopUp(" ", psUrl, vnDialogWidth, vnDialogHeight,
    "status=no, toolbar=no, scrollbars=no", true);
  },
  
  /**
   * 다국어 처리 메시지 객체를 화면에 모달 팝업형식으로 보여주기 위한 메소드
   * ex) ComMsg.showMsg("co.error.general", ["입력"], ["정수"]); -> NLS.co.error.general : 입력 중 오류가 발생하였습니다.\n정수 형식으로 입력하십시오.
   * @param {String} psId 메시지 정의 ID
   * @param {Array(String)} paParam 메시지 내용 중 @로 표시된 부분 넣어줄 데이터 배열
   * @param {Array(String)} paCoParam 함께 표현될 표시지 내용 중 @로 표시된 부분 넣어줄 데이터 배열
   */  
  showMsg : function(psId, paParam, paCoParam) {
    var vsMsg = "NLS." + psId + ".code";
    var vsCoMsg = null;
    var vnType = 0;
    try {
      vsMsg = eval(vsMsg);
      vsCoMsg = "NLS." + psId + ".coKey";
      vnType = "NLS." + psId + ".type";
      vnType = eval(vnType);
    } catch (err) {
      vsMsg = psId;
    }
    if (vsMsg.constructor != String) {
      vsMsg = this._getMsgFromFunc(vsMsg, paParam);
    }
    if (vsCoMsg) {
      try {
        vsCoMsg = eval(vsCoMsg);
        if (vsCoMsg) {
          vsCoMsg = eval("NLS." + vsCoMsg + ".code");
        }
      } catch (err) {
        vsCoMsg = null;
      }
      if (vsCoMsg && (vsCoMsg.constructor != String)) {
        vsCoMsg = this._getMsgFromFunc(vsCoMsg, paCoParam);
      }
    }
    if (vsCoMsg) {
      vsMsg += "\n" + vsCoMsg;
    }
    var vsType = "";
    switch (vnType) {
      case "1" :
      vsType = "error";
      break;
      case "2" :
      vsType = "help";
      break;
      case "3" :
      vsType = "info";
      break;
      case "4" :
      vsType = "warn";
      break;
    }
    this.alert(vsMsg, null, vsType);
  },
  
  /**
   * 다국어 처리 메시지 객체를 화면에 레이어드 팝업형식으로 보여주기 위한 메소드
   * ex) ComMsg.showMsg("co.error.general", ["입력"], ["정수"]); -> NLS.co.error.general : 입력 중 오류가 발생하였습니다.\n정수 형식으로 입력하십시오.
   * @param {String} psId 메시지 정의 ID
   * @param {Array(String)} paParam 메시지 내용 중 @로 표시된 부분 넣어줄 데이터 배열
   * @param {Array(String)} paCoParam 함께 표현될 표시지 내용 중 @로 표시된 부분 넣어줄 데이터 배열
   * @param {Function} poFunc 메시지 창 종료 시 수행될 call back 메소드
   */  
  showLayeredMsg : function(psId, paParam, paCoParam, poFunc, poCanFunc) {
    var vsMsg = "NLS." + psId + ".code";
    var vsCoMsg = null;
    var vnType = 0;
    try {
      vsMsg = eval(vsMsg);
      vsCoMsg = "NLS." + psId + ".coKey";
      vnType = "NLS." + psId + ".type";
      vnType = eval(vnType);
    } catch (err) {
      vsMsg = psId;
    }
    if (vsMsg.constructor != String) {
      vsMsg = this._getMsgFromFunc(vsMsg, paParam);
    }
    if (vsCoMsg) {
      try {
        vsCoMsg = eval(vsCoMsg);
        if (vsCoMsg) {
          vsCoMsg = eval("NLS." + vsCoMsg + ".code");
        }
      } catch (err) {
        vsCoMsg = null;
      }
      if (vsCoMsg && (vsCoMsg.constructor != String)) {
        vsCoMsg = this._getMsgFromFunc(vsCoMsg, paCoParam);
      }
    }
    if (vsCoMsg) {
      vsMsg += "\n" + vsCoMsg;
    }
    var vsType = "";
    switch (vnType) {
      case "1" :
      vsType = "error";
      break;
      case "2" :
      vsType = "help";
      break;
      case "3" :
      vsType = "info";
      break;
      case "4" :
      vsType = "warn";
      break;
    }
    var voMsg = {};
    voMsg.msg = vsMsg;
    voMsg.type = vsType;
    voMsg.callBackFunc = poFunc;
    voMsg.cancelFunc = poCanFunc;
    
    var voFunc = function() {
      UtilPopUp.openLayeredPopup("/inc/msgPopup.xrf", 402, 222, voMsg);
    };
    
    voFunc();
    
    // window.setTimeout(voFunc, 1000);
  },
  /**
   * 메시지 표현 Function 객체에 파라미터를 넘겨 완성된 메시지 문자열을 반환받는 메소드
   * @param {Function} poFunc 메시지 표현 Function
   * @param {Array(String)} paParam 메시지 표현 Function에 파라미터로 넘겨질 문자열 배열
   * @type String
   * @return 완성된 메시지 문자열
   */  
  
  _getMsgFromFunc : function(poFunc, paParam) {
    var vsMsg = null;
    var vsFunc = poFunc.toString();
    var vsParams = vsFunc.substring(9, vsFunc.indexOf(") {"));
    var vnParamSize = vsParams.split(",").length;
    if (paParam == null) {
      paParam = [];
    }
    for (var i = 0; i < vnParamSize; i++) {
      if (paParam [i] == null) {
        paParam [i] = "@" + (i + 1);
      }
    }
    
    vsMsg = poFunc.apply(this, paParam);
    return vsMsg;
  }
  
};

/**
 * Validation Check Library
 */
var Valid = {
  /**
   * validation check fail 시 해당 항목에 포커싱을 부여할 지 여부
   * @type boolean
   */  
  focusing : null,
  /**
   * 그리드 validation check fail 시 해당 항목에 포커싱될 컨트롤 id
   * @type String
   */  
  focusId : null,
  /**
   * 그리드 validation check fail 시 해당 항목에 포커싱될 row 객체
   * @type Object
   */  
  focusRow : null,
  /**
   * 그리드 validation check fail 시 해당 항목에 포커싱될 컬럼 id
   * @type String
   */  
  focusCol : null,
  /**
   * 사업자등록번호 체크 함수
   * @param {String} psBizNum 체크할 데이터 값
   * @return 체크성공여부
   * @type Boolean
   */  
  isBizNum : function(psBizNum) {
    var vsBizNum = psBizNum.replace(/-/gi, '');
    var vaCheckId = [1, 3, 7, 1, 3, 7, 1, 3, 5, 1];
    var i, vnSum = 0, vsCompare, vnRember;
    var vbRtnVal = false;
    
    for (i = 0; i <= 7; i++) {
      vnSum = vnSum + vaCheckId [i] * vsBizNum.charAt(i);
    }
    
    vsCompar = "0" + (vaCheckId [8] * vsBizNum.charAt(8));
    vsCompar = vsCompar.substring(vsCompar.length - 2, vsCompar.length);
    vnSum = vnSum + Math.floor(vsCompar.charAt(0))
    + Math.floor(vsCompar.charAt(1));
    
    vnRember = (10 - (vnSum % 10)) % 10;
    
    if (vsBizNum.length !== 10) {
      vbRtnVal = false;
    } else if (Math.floor(vsBizNum.charAt(9)) === vnRember) {
      vbRtnVal = true;
    } else {
      vbRtnVal = false;
    }
    
    return vbRtnVal;
  },
  
  /**
   * 주민등록번호 체크 함수
   * @param {Obejct} pcCtl 체크할 Control 객체
   * @param {String} psValue 체크할 데이터 값
   * @param {Number} pnFieldCount 주민등록번호 입력하는 컨트롤 갯수
   * @return 체크성공여부
   * @type Boolean
   */  
  isSsn : function(pcCtl, psValue, pnFieldCount) {
    var psSep = pcCtl.sep;
    if (psSep == undefined) {
      psSep = "";
    }
    
    var vsPattern = /^([0-9][0-9][0-1][0-9][0-3][0-9])([-]|[\s])?([1-4][0-9][0-9][0-9][0-9][0-9][0-9])$/g;
    
    if (vsPattern.test(psValue)) {
      var vsSsn1 = RegExp.$1;
      var vsSsn2 = RegExp.$3;
      
      if (pnFieldCount == 1) {
        pcCtl.value = vsSsn1 + psSep + vsSsn2;
      }
      
      return Valid.checkSsn(vsSsn1, vsSsn2);
    } else {
      return false;
    }
  },
  
  /**
   * Email 체크 함수
   * @param {String} psValue 체크할 데이터 값
   * @return 체크성공여부
   * @type Boolean
   */  
  isEmail : function(psValue) {
    //var pattern = /^(\w+(?:\.\w+)*)@((?:\w+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    // \w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*
    var vsPattern = /^[\w-]+([\\\.]+[\w-]*)?@([\w-]+\.)+[\w-]+$/i;
    return vsPattern.test(psValue);
  },
  
  /**
   * 전화번호 체크 함수
   * @param {String} psValue 체크할 데이터 값
   * @return 체크성공여부
   * @type Boolean
   */  
  isPhoneNumber : function(psValue) {
    var vsField = psValue.split("-");
    var vnLength = vsField.length;
    if ((vnLength < 2) || (vnLength > 3)) {
      return false;
    }
    for (var i = 0; i < vnLength; i++) {
      if (Valid.isNumber(vsField [i]) == false) {
        return false;
      }
    }
    return true;
  },
  
  /**
   * 날짜입력 형식 체크 함수
   * @param {String} psValue 체크할 데이터 값
   * @param {Number} pnFieldCount 날짜 입력하는 컨트롤 갯수
   * @return 체크성공여부
   * @type Boolean
   */  
  isDate : function(psValue, pnFieldcount) {
    
    var psPattern = /^([1-2][0-9][0-9][0-9])([0-1][0-9]|[1-9])([0-3][0-9]|[1-9])((([0-1][0-9])|([2][0-3]))([0-5][0-9])([0-5][0-9]))?$/g;
    
    if (psPattern.test(psValue)) {
      var vsYear = RegExp.$1;
      var vsMonth = RegExp.$2;
      var vsDay = RegExp.$3;
      
      if (pnFieldcount == 1) {
        var vsPrintMonth;
        var vsPrintDay;
        
        if (vsMonth.length == 1) {
          vsPrintMonth = "0" + vsMonth;
        } else {
          vsPrintMonth = vsMonth;
        }
        
        if (vsDay.length == 1) {
          vsPrintDay = "0" + vsDay;
        } else {
          vsPrintDay = vsDay;
        }
      }
      
      return Valid.checkDate(vsYear, vsMonth, vsDay);
    } else {
      return false;
    }
  },
  
  /**
   * 시간입력 형식 체크 함수
   * @param {String} psValue 체크할 데이터 값
   * @return 체크성공여부
   * @type Boolean
   */  
  isTime : function(psValue) {
    var psPattern = /^(([0-1][0-9])|([2][0-3]))[:]?([0-5][0-9])([:]?([0-5][0-9]))?$/g;
    
    if (psPattern.test(psValue)) {
      return true;
    } else {
      return false;
    }
  },
  
  /**
   * 숫자 check 함수
   * @param {String} psNum 체크할 데이터 값
   * @return 숫자인지 여부
   * @type Boolean
   */  
  isNumber : function(psNum) {
    return eXria.util.ValueUtil.isNumber(psNum);
  },
  
  /**
   * 알파벳 check 함수
   * @param {String} psValue 체크할 데이터 값
   * @return 알파벳인지 여부
   * @type Boolean
   */  
  isAlphabet : function(psValue) {
    if (psValue.length == 0) {
      return false;
    }
    var vbRet = /[^a-zA-z]+/.test(psValue);
    return !vbRet;
  },
  
  /**
   * 아스키문자로만 구성되어 있는지 Check
   * @param {String} psValue 체크할 데이터 값
   * @return 아스키문자로만 구성되어있는지 여부
   * @type Boolean
   */  
  isASCII : function(psValue) {
    if (psValue.length == 0) {
      return false;
    }
    var vnLength = psValue.length;
    for (var i = 0; i < vnLength; i++) {
      // blank : 32
      // ~ : 126
      if ((' ' > psValue.charAt(i)) || (psValue.charAt(i) > '~')) {
        return false;
      }
    }
    return true;
  },
  
  /**
   * 알파벳과 숫자로 구성되어 있는지 Check
   * @param {String} psValue 체크할 데이터 값
   * @return 알파벳과 숫자로 구성되어있는지 여부
   * @type Boolean
   */  
  isAlphaNumeric : function(psValue) {
    if (psValue.length == 0) {
      return false;
    }
    
    var vbRet = /[^a-zA-z0-9]+/.test(psValue);
    return !vbRet;
  },
  
  /**
   * 한글(2byte)인지 Check
   * @param {String} psValue 체크할 데이터 값
   * @return 한글(2byte)인지 여부
   * @type Boolean
   */  
  isKorean : function(psValue) {
    var i = 0;
    while (true) {
      var vsCharAt = psValue.charAt(i++);
      if ((vsCharAt == "") || (vsCharAt == null)) {
        break;
      } else if (vsCharAt == ' ') {
        continue;
      } else {
        var vsCh = escape(vsCharAt);
        if (vsCh.substring(0, 2) == "%u") {
          if (vsCh.substring(2, 4) == "00") {
            return false;
          }
        } else if (vsCh.substring(0, 1) == "%") {
          if (parseInt(vsCh.substring(1, 3), 16) <= 127) {
            return false;
          }
        } else {
          return false;
        }
      }
    }
    return true;
  },
  
  /**
   * 주민등록번호 Check
   * @param {String} psFirst 주민번호 앞에 6자리
   * @param {String} psLast 주민번호 뒤의 7자리
   * @return 주민등록번호 체크 성공 여부
   * @type Boolean
   */  
  checkSsn : function(psFirst, psLast) {
    var vsA1 = psFirst.substring(0, 1);
    var vsA2 = psFirst.substring(1, 2);
    var vsA3 = psFirst.substring(2, 3);
    var vsA4 = psFirst.substring(3, 4);
    var vsA5 = psFirst.substring(4, 5);
    var vsA6 = psFirst.substring(5, 6);
    var vsCheck_digit = vsA1 * 2 + vsA2 * 3 + vsA3 * 4 + vsA4 * 5 + vsA5 * 6
    + vsA6 * 7;
    var vsB1 = psLast.substring(0, 1);
    var vsB2 = psLast.substring(1, 2);
    var vsB3 = psLast.substring(2, 3);
    var vsB4 = psLast.substring(3, 4);
    var vsB5 = psLast.substring(4, 5);
    var vsB6 = psLast.substring(5, 6);
    var vsB7 = psLast.substring(6, 7);
    vsCheck_digit = vsCheck_digit + vsB1 * 8 + vsB2 * 9 + vsB3 * 2 + vsB4 * 3
    + vsB5 * 4 + vsB6 * 5;
    
    vsCheck_digit = vsCheck_digit % 11;
    vsCheck_digit = 11 - vsCheck_digit;
    vsCheck_digit = vsCheck_digit % 10;
    
    if (vsCheck_digit != vsB7) {
      return false;
    }
    return true;
  },
  
  /**
   * 년도/월/일 날짜 체크 함수
   * @param {String} psYear 년도
   * @param {String} psMonth 월
   * @param {String} psDay 일
   * @return 날짜 체크 성공 여부
   * @type Boolean
   */  
  checkDate : function(psYear, psMonth, psDay) {
    
    if (Valid.checkYear(psYear) == false) {
      return false;
    }
    
    if (Valid.checkMonth(psMonth) == false) {
      return false;
    }
    
    if (Valid.checkDay(psDay) == false) {
      return false;
    }
    
    var vsYear = Number(psYear);
    var vsMonth = Number(psMonth);
    var vsDay = Number(psDay);
    
    if (vsDay > Valid.daysInMonth(vsMonth)) {
      return false;
    }
    
    if ((vsMonth == 2) && (vsDay > Valid.daysInFebrary(vsYear))) {
      return false;
    }
    
    return true;
  },
  
  /**
   * 년도 체크 함수
   * @param {String} psYear 년도
   * @return 년도 체크 성공 여부
   * @type Boolean
   */  
  checkYear : function(psYear) {
    if (psYear == '') {
      return false;
    }
    if (Valid.isNumber(psYear) == false) {
      return false;
    }
    var vsYear = Number(psYear);
    if ((vsYear < 1889) || (vsYear > 2100)) {
      return false;
    }
    return true;
  },
  
  /**
   * 월 체크 함수
   * @param {String} psMonth 월
   * @return 월 체크 성공 여부
   * @type Boolean
   */  
  checkMonth : function(psMonth) {
    if (psMonth == '') {
      return false;
    }
    if (Valid.isNumber(psMonth) == false) {
      return false;
    }
    var vsMonth = Number(psMonth);
    if ((vsMonth < 1) || (vsMonth > 12)) {
      return false;
    }
    return true;
  },
  
  /**
   * 일 체크 함수
   * @param {String} psDay 일
   * @return 일 체크 성공 여부
   * @type Boolean
   */  
  checkDay : function(psDay) {
    if (psDay == '') {
      return false;
    }
    if (Valid.isNumber(psDay) == false) {
      return false;
    }
    var vsDay = Number(psDay);
    if ((vsDay < 1) || (vsDay > 31)) {
      return false;
    }
    return true;
  },
  
  /**
   * 월의 마지막 일자 가져오기
   * @param {String} psMonth 월
   * @return 월의 마지막 일자
   * @type Number
   */  
  daysInMonth : function(psMonth) {
    
    var vaDaysInMonth = new Array(13);
    vaDaysInMonth [1] = 31;
    vaDaysInMonth [2] = 29;
    vaDaysInMonth [3] = 31;
    vaDaysInMonth [4] = 30;
    vaDaysInMonth [5] = 31;
    vaDaysInMonth [6] = 30;
    vaDaysInMonth [7] = 31;
    vaDaysInMonth [8] = 31;
    vaDaysInMonth [9] = 30;
    vaDaysInMonth [10] = 31;
    vaDaysInMonth [11] = 30;
    vaDaysInMonth [12] = 31;
    
    return vaDaysInMonth [psMonth];
  },
  
  /**
   * 2월달의 마지막 일자 가져오기
   * @param {String} psYear 년도
   * @return 2월달의 마지막 일자
   * @type Number
   */  
  daysInFebrary : function(psYear) {
    return ((psYear % 4 == 0) && (!(psYear % 100 == 0) || (psYear % 400 == 0)) ? 29
    : 28);
  },
  
  /**
   * 날짜 비교 (psStId 컨트롤의 날짜 값과  psEdId 컨트롤의 날짜 값을 psCompType 조건에 따라 체크)
   * ex) var vbValid = Valid.compareDate("dipBeg", "dipEnd");
   * @param {String} psStId 시작일자 control객체 식별자
   * @param {String} psEdId 종료일자 control객체 식별자
   * @param {String} psCompType 날짜 비교 조건 문자열(비교연산자). 디폴트 값은 "<="
   * @return 체크 성공 여부
   * @type Boolean
   */  
  compareDate : function(psStId, psEdId, psCompType) {
    var vbReturn = true;
    if (psCompType == null) {
      psCompType = "<="
    }
    var voObj1 = page.getControl(psStId);
    var voObj2 = page.getControl(psEdId);
    var vsValue1 = voObj1.value;
    var vsValue2 = voObj2.value;
    var vaTitle = [];
    vaTitle.push(voObj1.userAttr);
    vaTitle.push(voObj2.userAttr);
    if (vsValue1.length == 8) {
      vsValue1 += "000000";
    }
    if (vsValue2.length == 8) {
      vsValue2 += "000000";
    }
    
    vbReturn = eval(vsValue1 + psCompType + vsValue2);
    if (vbReturn == false) {
      // ComMsg.warn("M130", vaTitle);
      ComMsg.showMsg("co.error.period", vaTitle);
    }
    return vbReturn;
  },
  
  /**
   * 그리드 컬럼의 날짜 비교 (psStColId 컬럼이  psEdColId 컬럼의 날짜 psCompType 조건에 따라 체크)
   * ex) var vbValid = Valid.compareDateGrid("grxMst", "ghcBegdt", "ghcEnddt");
   * @param {String} psGrxId 그리드 식별자
   * @param {String} psStColId 시작일자 헤드 컬럼 id
   * @param {String} psEdColId 종료일자 헤드 컬럼 id
   * @param {String} psCompType 날짜 비교 조건 문자열(비교연산자). 디폴트 값은 "<="
   * @return 체크 성공 여부
   * @type Boolean
   */  
  compareDateGrid : function(psGrxId, psStColId, psEdColId, psCompType) {
    var vbReturn = true;
    if (psCompType == null) {
      psCompType = "<="
    }
    var vcGrx = page.getControl(psGrxId);
    var voDst = vcGrx.dataset;
    
    var vaCUDType = [eXria.data.CrudType.MODIFIEDFLAG,
    eXria.data.CrudType.EMPTYEDFLAG, eXria.data.CrudType.ADDEDFLAG];
    
    var vaTotIdx = [];
    var vaIndex = null;
    var vnIndex = 0;
    var vnSize = 0;
    for (var i = 0; i <= 2; i++) {
      vaIndex = voDst.getStatusIndex(vaCUDType [i]);
      if ((vaIndex == null) || (vaIndex == "")) {
        continue;
      }
      if (vaIndex.lastIndexOf(",") == vaIndex.length - 1) {
        vaIndex = vaIndex.substring(0, vaIndex.length - 1);
      }
      if (vaIndex == "") {
        continue;
      }
      
      vaIndex = vaIndex.split(",");
      vnSize = vaIndex.length
      
      for (var j = 0; j < vnSize; j++) {
        vnIndex = parseInt(vaIndex [j], 10);
        vnIndex--;
        vaTotIdx.push(vnIndex);
      }
    }
    var vnCnt = vaTotIdx.length;
    var voRow = null;
    // var vbGrouped = false;
    // if(vcGrx.cfg.groupMain && vcGrx.cfg.groupCols) vbGrouped = true;
    // var vnGrxRowCnt = vcGrx.getRowCnt(vbGrouped);
    var vnGrxRowCnt = vcGrx.getRowCnt();
    var vnDstRowIdx = null;
    var vnRowIndex = null;
    for (var i = 0; i < vnCnt; i++) {
      
      //      var vnFilteredIdx = -1;
      // vnDstRowIdx = vaTotIdx[i];
      // for(var n = 0; n< vnGrxRowCnt; n++){
      // voRow = vcGrx.getRowIndex(n);
      // if(false == vcGrx.hasChildren(voRow)) vnFilteredIdx++;
      // if(vnDstRowIdx == vnFilteredIdx) {
      // vnRowIndex = n;
      // break;
      // }
      // }
      // voRow = vcGrx.getRowIndex(vnRowIndex);
      
      vnDstRowIdx = vaTotIdx [i];
      voRow = vcGrx.getRowIndex(vnDstRowIdx);
      var vsValue1 = vcGrx.getValue(voRow, psStColId);
      var vsValue2 = vcGrx.getValue(voRow, psEdColId);
      if ("" === vsValue1) {
        vsValue1 = "0";
      }
      if ("" === vsValue2) {
        vsValue2 = "0";
      }
      
      if (vsValue1.length == 8) {
        vsValue1 += "000000";
      }
      if (vsValue2.length == 8) {
        vsValue2 += "000000";
      }
      
      vbReturn = eval(vsValue1 + psCompType + vsValue2);
      if (vbReturn == false) {
        
        var vsGrxTitle = vcGrx.labelName;
        if (page.getControl(vsGrxTitle) != null) {
          //해당 컨트롤이 존재할 경우
          vsGrxTitle = page.getControl(vsGrxTitle).getValue();
        }
        
        //NLS.MSG.WRN.M113(vsGrxTitle, i + 1)
        // var vsTemp = i + 1+"";
        var vsTemp = vnDstRowIdx + 1;
        var vsMsg = ComMsg.getMsg("co.info.grxcell", [vsGrxTitle, vsTemp]);
        
        var vaTitle = [];
        vaTitle.push(vsMsg + vcGrx.getTitleText(psStColId));
        vaTitle.push(vcGrx.getTitleText(psEdColId))
        
        // ComMsg.warn("M130", vaTitle);
        ComMsg.showMsg("co.error.period", vaTitle);
        break;
      }
    }
    return vbReturn;
  },
  
  /**
   * 컨트롤들의 빈값 체크
   * ex) Valid.checkNotNullCtl(["CtlId", "CtlId2", "CtlId3"]);
   * -> ControlId의 Arrary객체를 argument로 보낸다. Control의 값이 null 인지 체크한다.
   * @param {Arrary(String)} paCtlId 체크할 ControlId의 Arrary객체
   * @return 체크 성공 여부
   * @type Boolean
   */  
  checkNotNullCtl : function(paCtlId) {
    return Valid._checkCtl("null", paCtlId);
  },
  
  /**
   * Grid 셀의 빈값 체크
   * ex) Valid.checkNotNullGrid(GridId, [1, 2, 3], ["HeaderId", "HeaderId2"]);
   * -> 체크할 GridId와 해당 Grid의 체크할 RowIndex, HeaderId의 Arrary 객체를 argument로 보낸다.
   * @param {String} psGrxId 체크할 GridId
   * @param {Arrary(Number)} paRowIdx 체크할 RowIdx의 Arrary객체
   * @param {Arrary(String)} paHeaderId 체크할 HeaderId의 Arrary객체
   * @return 체크 성공 여부
   * @type Boolean
   */  
  checkNotNullGrid : function(psGrxId, paRowIdx, paHeaderId) {
    var vaArgv = Valid.checkNotNullGrid.arguments;
    return Valid._checkGrid("null", vaArgv);
  },
  
  /**
   * 컨트롤들의 MaxLength 체크
   * ex) Valid.checkMaxLengthCtl(["CtlId", "CtlId2", "CtlId3"]);
   * -> ControlId의 Arrary객체를 argument로 보낸다. 이때 Max는 Control의 속성 MaxLength값으로 체크한다.
   * Valid.checkMaxLengthCtl(["CtlId:3", "CtlId2:5", "CtlId3:8"]);
   * -> ControlId=MaxLength 형태의 Arrary객체를 argument로 보낸다. 이때 Max는 보낸 argument값으로 체크한다.
   * @param {Arrary(String)} paCtlId 체크할 ControlId의 Arrary객체
   * @return 체크 성공 여부
   * @type Boolean
   */  
  checkMaxLengthCtl : function(paCtlId) {
    return Valid._checkCtl("max", paCtlId);
  },
  
  /**
   * 컨트롤들의 Max　Byte Length 체크
   * ex) Valid.checkMaxBLengthCtl(["CtlId", "CtlId2", "CtlId3"]);
   * -> ControlId의 Arrary객체를 argument로 보낸다. 이때 Max는 Control의 속성 MaxLength값으로 체크한다.
   * Valid.checkMaxLengthCtl(["CtlId:3", "CtlId2:5", "CtlId3:8"]);
   * -> ControlId=MaxLength 형태의 Arrary객체를 argument로 보낸다. 이때 Max는 보낸 argument값으로 체크한다.
   * @param {Arrary(String)} paCtlId 체크할 ControlId의 Arrary객체
   * @return 체크 성공 여부
   * @type Boolean
   */  
  checkMaxBLengthCtl : function(paCtlId) {
    return Valid._checkCtl("maxByte", paCtlId);
  },
  
  /**
   * Grid의 Column들의 MaxLength 체크
   * ex) Valid.checkMaxLengthGrid(GridId, [1, 2, 3], ["HeaderId", "HeaderId2"]);
   * -> 체크할 GridId와 해당 Grid의 체크할 RowIndex, HeaderId의 Arrary 객체를 argument로 보낸다.
   * 이때 Max는 HeaderId에 해당하는 BodyControl의 속성 MaxLength값으로 체크한다.
   * Valid.checkMaxLengthGrid(GridId, [1, 2, 3], ["HeaderId:3", "HeaderId2:5", "HeaderId3:8"]);
   * -> HeaderId=MaxLength 형태의 argument로 보낸다. 이때 Max는 보낸 argument값으로 체크한다.
   * @param {String} psGrxId 체크할 GridId
   * @param {Arrary(Number)} paRowIdx 체크할 RowIdx의 Arrary객체
   * @param {Arrary(String)} paHeaderId 체크할 HeaderId의 Arrary객체
   * @return 체크 성공 여부
   * @type Boolean
   */  
  checkMaxLengthGrid : function(psGrxId, paRowIdx, paHeaderId) {
    var vaArgv = Valid.checkMaxLengthGrid.arguments;
    return Valid._checkGrid("max", vaArgv);
  },
  
  /**
   * Grid의 Column들의 Max Byte Length 체크
   * ex) Valid.checkMaxLengthGrid(GridId, [1, 2, 3], ["HeaderId", "HeaderId2"]);
   * -> 체크할 GridId와 해당 Grid의 체크할 RowIndex, HeaderId의 Arrary 객체를 argument로 보낸다.
   * 이때 Max는 HeaderId에 해당하는 BodyControl의 속성 MaxLength값으로 체크한다.
   * Valid.checkMaxLengthGrid(GridId, [1, 2, 3], ["HeaderId:3", "HeaderId2:5", "HeaderId3:8"]);
   * -> HeaderId=MaxLength 형태의 argument로 보낸다. 이때 Max는 보낸 argument값으로 체크한다.
   * @param {String} psGrxId 체크할 GridId
   * @param {Arrary(Number)} paRowIdx 체크할 RowIdx의 Arrary객체
   * @param {Arrary(String)} paHeaderId 체크할 HeaderId의 Arrary객체
   * @return 체크 성공 여부
   * @type Boolean
   */  
  checkMaxBLengthGrid : function(psGrxId, paRowIdx, paHeaderId) {
    var vaArgv = Valid.checkMaxBLengthGrid.arguments;
    return Valid._checkGrid("maxByte", vaArgv);
  },
  
  /**
   * 컨트롤들의 MinLength 체크
   * ex) Valid.checkMinLengthCtl(["CtlId", "CtlId2", "CtlId3"]);
   * -> ControlId의 Arrary객체를 argument로 보낸다. 이때 Min는 Control의 속성 MinLength값으로 체크한다.
   * Valid.checkMinLengthCtl(["CtlId:3", "CtlId2:5", "CtlId3:8"]);
   * ControlId=MinLength 형태의 Arrary객체를 argument로 보낸다. 이때 Min는 보낸 argument값으로 체크한다.
   * @param {Arrary(String)} paCtlId 체크할 ControlId의 Arrary객체
   * @return 체크 성공 여부
   * @type Boolean
   */  
  checkMinLengthCtl : function(paCtlId) {
    return Valid._checkCtl("min", paCtlId);
  },
  
  /**
   * 컨트롤들의 Min Byte Length 체크
   * ex) Valid.checkMinLengthCtl(["CtlId", "CtlId2", "CtlId3"]);
   * -> ControlId의 Arrary객체를 argument로 보낸다. 이때 Min는 Control의 속성 MinLength값으로 체크한다.
   * Valid.checkMinLengthCtl(["CtlId:3", "CtlId2:5", "CtlId3:8"]);
   * ControlId=MinLength 형태의 Arrary객체를 argument로 보낸다. 이때 Min는 보낸 argument값으로 체크한다.
   * @param {Arrary(String)} paCtlId 체크할 ControlId의 Arrary객체
   * @return 체크 성공 여부
   * @type Boolean
   */  
  checkMinBLengthCtl : function(paCtlId) {
    return Valid._checkCtl("minByte", paCtlId);
  },
  
  /**
   * Grid의 Column들의 MinLength 체크
   * ex) Valid.checkMinLengthGrid(GridId, [1, 2, 3], ["HeaderId", "HeaderId2"]);
   * -> 체크할 GridId와 해당 Grid의 체크할 RowIndex, HeaderId의 Arrary 객체를 argument로 보낸다.
   * 이때 Min는 HeaderId에 해당하는 BodyControl의 속성 MinLength값으로 체크한다.
   * Valid.checkMinLengthGrid(GridId, [1, 2, 3], ["HeaderId:3", "HeaderId2:5", "HeaderId3:8"]);
   * -> HeaderId:MinLength 형태의 argument로 보낸다. 이때 Min는 보낸 argument값으로 체크한다.
   * @param {String} psGrxId Check할 GridId
   * @param {Arrary(Number)} paRowIdx 체크할 RowIdx의 Arrary객체
   * @param {Arrary(String)} paHeaderId 체크할 HeaderId의 Arrary객체
   * @return 체크 성공 여부(성공:true/실패:false)
   * @type Boolean
   */  
  checkMinLengthGrid : function(psGrxId, paRowIdx, paHeaderId) {
    var vaArgv = Valid.checkMinLengthGrid.arguments;
    return Valid._checkGrid("min", vaArgv);
  },
  
  /**
   * Grid의 Column들의 Min Byte Length 체크
   * ex) Valid.checkMinLengthGrid(GridId, [1, 2, 3], ["HeaderId", "HeaderId2"]);
   * -> 체크할 GridId와 해당 Grid의 체크할 RowIndex, HeaderId의 Arrary 객체를 argument로 보낸다.
   * 이때 Min는 HeaderId에 해당하는 BodyControl의 속성 MinLength값으로 체크한다.
   * Valid.checkMinLengthGrid(GridId, [1, 2, 3], ["HeaderId:3", "HeaderId2:5", "HeaderId3:8"]);
   * -> HeaderId:MinLength 형태의 argument로 보낸다. 이때 Min는 보낸 argument값으로 체크한다.
   * @param {String} psGrxId Check할 GridId
   * @param {Arrary(Number)} paRowIdx 체크할 RowIdx의 Arrary객체
   * @param {Arrary(String)} paHeaderId 체크할 HeaderId의 Arrary객체
   * @return 체크 성공 여부(성공:true/실패:false)
   * @type Boolean
   */  
  checkMinBLengthGrid : function(psGrxId, paRowIdx, paHeaderId) {
    var vaArgv = Valid.checkMinBLengthGrid.arguments;
    return Valid._checkGrid("minByte", vaArgv);
  },
  
  /**
   * (내부함수) 컨트롤들의 체크에 필요한 Data get
   * @param {String} psChkType Check할 validation Type (max/min/null/kind)
   * @param {Array(String)} Check할 control id 및 kind Type (ssn/date) 저장 배열
   * @return 체크 성공 여부(성공:true/실패:false)
   * @type Boolean
   * @private
   */  
  _checkCtl : function(psChkType, paArgv) {
    var vnArgc = paArgv.length;
    var vsValue = "";
    var vsTitle = ""; // 메시지 Title
    for (var i = 0; i < vnArgc; i++) {
      var vaArg2 = paArgv [i].trimAll().split(":");
      var vcCtl = page.getControl(vaArg2 [0]);
      if (vcCtl == null) {
        //        ComMsg.warn("M112", [vaArg2 [0]]);
        ComMsg.showMsg("co.error.valid", [vaArg2 [0]]);
        return false;
      }
      if (vaArg2.length == 2) {
        // ControlId=MaxLengthValue 형식일 경우
        vnChkVal = vaArg2 [1];
      } else {
        if (psChkType == "max") {
          vnChkVal = eXria.util.ValueUtil.fixNumber(vcCtl.maxLength);
          if (vcCtl.maxLength == null) {
            vnChkVal = null;
          }
        } else if (psChkType == "min") {
          vnChkVal = eXria.util.ValueUtil.fixNumber(vcCtl.minLength);
          if (vcCtl.minLength == null) {
            vnChkVal = null;
          }
        } else if (psChkType == "maxByte") {
          vnChkVal = eXria.util.ValueUtil.fixNumber(vcCtl.maxByteLength);
          if (vcCtl.maxByteLength == null) {
            vnChkVal = null;
          }
        } else if (psChkType == "minByte") {
          vnChkVal = eXria.util.ValueUtil.fixNumber(vcCtl.minByteLength);
          if (vcCtl.minByteLength == null) {
            vnChkVal = null;
          }
        } else if (psChkType == "null") {
          vnChkVal = eXria.util.ValueUtil.fixNumber(vcCtl.nullable);
        }
      }
      
      if (psChkType == "kind") {
        //kind 체크시
        if (vnChkVal == 'ssn') {
          //주민등록번호 형식일때
          vcCtl.setValue(Valid.setSsn(vcCtl.getValue()));
        } else if (vnChkVal == 'date') {
          //날짜 형식일때
          vcCtl.setValue(Valid.setDate(vcCtl.getValue()));
        }
      }
      
      vsValue = eXria.util.ValueUtil.fixNull(vcCtl.getValue());
      vsTitle = vcCtl.userAttr;
      if (page.getControl(vsTitle) != null) {
        //해당 컨트롤이 존재할 경우
        vsTitle = page.getControl(vsTitle).getValue();
      }
      
      if (!Valid._checkData(psChkType, vnChkVal, vsValue, vsTitle)) {
        //2010.01.11 kimdoohwan
        if ((vcCtl.disabled != true) && (vcCtl.readOnly != true)) {
          if (this.isFocusingFail) {
            page.canvas.setFocusByControl(vcCtl);
          } else {
            this.focusId = vcCtl.id;
          }
        }
        return false;
      }
    }
    this.focusId = null;
    return true;
  },
  
  /**
   * (내부함수) Grid의 체크에 필요한 Data get
   * @param {String} psChkType Check할 Type (max/min/null/kind)
   * @param {Array(String)} Check할 HeaderIds
   * @return 체크 성공 여부(성공:true/실패:false)
   * @type Boolean
   * @private
   */  
  _checkGrid : function(psChkType, paArgv) {
    var vnArgc = paArgv.length;
    var vcGrx = page.getControl(paArgv [0]); // 체크할 GridControl
    
    if (vcGrx == null) {
      //      ComMsg.warn("M112", [paArgv [0]]);
      ComMsg.showMsg("co.error.valid", [paArgv [0]]);
      return false;
    }
    
    var vsGrxTitle = vcGrx.labelName;
    
    if (page.getControl(vsGrxTitle) != null) {
      //해당 컨트롤이 존재할 경우
      vsGrxTitle = page.getControl(vsGrxTitle).getValue();
    }
    
    var vaTitle = new Array(); // 메세지에 뿌릴 Title
    var vaChkValue = new Array(); // 체크할 기준 Value
    var vaHeader = new Array(); // 체크할 HeaderID
    
    var vaHeadCols = vcGrx.getHeadColumnList(); // Grid의 HeadColumn get
    var vnLength = vaHeadCols.length;
    
    if (vnArgc == 3) {
      // argument로 HeaderId이 존재할 경우
      var vnArgHeaderLeng = paArgv [2].length; // argument로 보낸 HeaderId 개수
      for (var i = 0; i < vnLength; i++) {
        for (var j = 0; j < vnArgHeaderLeng; j++) {
          var vaArg2 = paArgv [2] [j].trimAll().split(":");
          vaHeader [j] = vaArg2 [0];
          
          if (vaHeadCols [i] == vaHeader [j]) {
            vaTitle [j] = vcGrx.getTitleText(vaHeader [j]);
            
            if (vaArg2.length == 2) {
              // HeaderId=MaxLengthValue 형식일 경우
              vaChkValue [j] = vaArg2 [1];
            } else {
              if (psChkType == "max") {
                vaChkValue [j] = eXria.util.ValueUtil.fixNumber(vcGrx
                .getBodyColumn(null, vaHeadCols [i]).maxLength);
                if (vcGrx.getBodyColumn(null, vaHeadCols [i]).maxLength == null) {
                  vaChkValue [j] = null;
                }
              } else if (psChkType == "min") {
                vaChkValue [j] = eXria.util.ValueUtil.fixNumber(vcGrx
                .getBodyColumn(null, vaHeadCols [i]).minLength);
                if (vcGrx.getBodyColumn(null, vaHeadCols [i]).minLength == null) {
                  vaChkValue [j] = null;
                }
              } else if (psChkType == "maxByte") {
                vaChkValue [j] = eXria.util.ValueUtil.fixNumber(vcGrx
                .getBodyColumn(null, vaHeadCols [i]).maxByteLength);
                if (vcGrx.getBodyColumn(null, vaHeadCols [i]).maxByteLength == null) {
                  vaChkValue [j] = null;
                }
              } else if (psChkType == "minByte") {
                vaChkValue [j] = eXria.util.ValueUtil.fixNumber(vcGrx
                .getBodyColumn(null, vaHeadCols [i]).minByteLength);
                if (vcGrx.getBodyColumn(null, vaHeadCols [i]).minByteLength == null) {
                  vaChkValue [j] = null;
                }
              } else if (psChkType == "null") {
                vaChkValue [j] = vcGrx.getBodyColumn(null, vaHeadCols [i]).nullable;
              }
            }
          }
        }
      }
    } else {
      // argument로 HeaderId가 존재하지 않을 경우
      for (var i = 0; i < vnLength; i++) {
        //Grid 모든 HeaderId
        vaTitle [i] = vcGrx.getTitleText(vaHeadCols [i]);
        vaHeader [i] = vaHeadCols [i];
        
        if (psChkType == "max") {
          vaChkValue [i] = eXria.util.ValueUtil.fixNumber(vcGrx.getBodyColumn(
          null, vaHeadCols [i]).maxLength);
          if (vcGrx.getBodyColumn(null, vaHeadCols [i]).maxLength == null) {
            vaChkValue [i] = null;
          }
        } else if (psChkType == "min") {
          vaChkValue [i] = eXria.util.ValueUtil.fixNumber(vcGrx.getBodyColumn(
          null, vaHeadCols [i]).minLength);
          if (vcGrx.getBodyColumn(null, vaHeadCols [i]).minLength == null) {
            vaChkValue [i] = null;
          }
        } else if (psChkType == "maxByte") {
          vaChkValue [i] = eXria.util.ValueUtil.fixNumber(vcGrx.getBodyColumn(
          null, vaHeadCols [i]).maxByteLength);
          if (vcGrx.getBodyColumn(null, vaHeadCols [i]).maxByteLength == null) {
            vaChkValue [i] = null;
          }
        } else if (psChkType == "minByte") {
          vaChkValue [i] = eXria.util.ValueUtil.fixNumber(vcGrx.getBodyColumn(
          null, vaHeadCols [i]).minByteLength);
          if (vcGrx.getBodyColumn(null, vaHeadCols [i]).minByteLength == null) {
            vaChkValue [i] = null;
          }
        } else if (psChkType == "null") {
          vaChkValue [i] = vcGrx.getBodyColumn(null, vaHeadCols [i]).nullable;
        }
      }
    }
    
    var vaRowIdx = paArgv [1]; // 체크할 RowIndex
    var voDst = vcGrx.dataset;
    var vaCUDType = [eXria.data.CrudType.MODIFIEDFLAG,
    eXria.data.CrudType.EMPTYEDFLAG, eXria.data.CrudType.ADDEDFLAG];
    var vaTotIdx = [];
    var vaIndex = null;
    var vnIndex = 0;
    var vnSize = 0;
    
    for (var i = 0; i <= 2; i++) {
      vaIndex = voDst.getStatusIndex(vaCUDType [i]);
      if ((vaIndex == null) || (vaIndex == "")) {
        continue;
      }
      if (vaIndex.lastIndexOf(",") == vaIndex.length - 1) {
        vaIndex = vaIndex.substring(0, vaIndex.length - 1);
      }
      if (vaIndex == "") {
        continue;
      }
      
      vaIndex = vaIndex.split(",");
      vnSize = vaIndex.length
      
      for (var j = 0; j < vnSize; j++) {
        vnIndex = parseInt(vaIndex [j], 10);
        vnIndex--;
        vaTotIdx.push(vnIndex);
      }
    }
    var vnCnt = vaTotIdx.length;
    
    var vbRowIndex = true; // 체크할 RowIndex가 존재 하는지 여부
    
    // if (vaRowIdx != undefined && paArgv[1].length != 0) {
    // vnCnt = paArgv[1].length;
    // vbRowIndex = true;
    // vaTotIdx = [];
    // for ( var j = 0; j < vnCnt; j++) {
    // vnIndex = parseInt(paArgv[1][j], 10);
    // vnIndex--;
    // vaTotIdx.push(vnIndex);
    // }
    // }
    
    var voRow = null;
    var vnHeaderLeng = vaHeader.length;
    var vsValue = "";
    var vnChkRowIdx = 0; // 체크하는 RowIndex
    for (var i = 0; i < vnCnt; i++) {
      vnIndex = vaTotIdx [i];
      // if (vbRowIndex) {
      // vnChkRowIdx = vaRowIdx[vnIndex];
      // } else {
      // vnChkRowIdx = vnIndex;
      // }
      
      // voRow = vcGrx.getRowIndex(vnChkRowIdx);
      voRow = vcGrx.getRowIndex(vnIndex);
      for (var j = 0; j < vnHeaderLeng; j++) {
        //        if(psChkType == "kind"){    //kind 체크시
        // if (vaChkValue[j] == 'ssn') { //주민등록번호 형식일때
        // vcGrx.setValue(voRow, vaHeader[j],
        // Valid.setSsn(vcGrx.getValue(voRow, vaHeader[j])), true);
        // } else if (vaChkValue[j] == 'date') { //날짜 형식일때
        // vcGrx.setValue(voRow, vaHeader[j],
        // Valid.setDate(vcGrx.getValue(voRow, vaHeader[j])), true);
        // }
        // }
        
        vsValue = vcGrx.getValue(voRow, vaHeader [j]);
        if (vsValue == 0) {
          if (vcGrx.getString(voRow, vaHeader [j]) == "") {
            vsValue = "";
          }
        }
        //        vsValue = vcGrx.getString(voRow, vaHeader[j]);
        
        // NLS.MSG.WRN.M113(vsGrxTitle, vnChkRowIdx + 1)
        // ComMsg.getMsg("co.info.grxcell", [vsGrxTitle, vnChkRowIdx +
        // 1+ ""])
        
        if (!Valid._checkData(psChkType, vaChkValue [j], vsValue, ComMsg.getMsg(
        "co.info.grxcell", [vsGrxTitle, vnIndex + 1 + ""])
        + vaTitle [j])) {
          if (this.isFocusingFail) {
            vcGrx.startEdit(voRow, vaHeader [j]);
          } else {
            this.focusId = vcGrx.id;
            this.focusRow = voRow;
            this.focusCol = vaHeader [j];
          }
          return false;
        }
      }
    }
    this.focusId = null;
    this.focusRow = null;
    this.focusCol = null;
    return true;
  },
  
  /**
   * (내부함수) 데이터 체크
   * @param {String} psChkType Check할 Type (max/min/null/kind)
   * @param {String} psChkValue psChkType이 kind일 경우의 kind 구분 문자열
   * @param {String} psValue 체크할 데이터 값
   * @param {String} psMsg 체크 실패시 표시할 메시지
   * @return 체크 성공 여부(성공:true/실패:false)
   * @type Boolean
   * @private
   */  
  _checkData : function(psChkType, psChkValue, psValue, psMsg) {
    var paValue = [];
    if (psValue instanceof Array) {
      paValue = psValue;
    } else {
      paValue.push(psValue);
    }
    var vsValue = null;
    var vnSize = paValue.length;
    for (var i = 0; i < vnSize; i++) {
      vsValue = paValue [i];
      if (psChkType == "max") {
        if (vsValue === "" || (vsValue == null)) {
          return true;
        }
        if (typeof vsValue != "string") {
          vsValue = new String(vsValue);
        }
        if ((psChkValue != null) && (vsValue.length > psChkValue)) {
          //          ComMsg.warn("M102", [psMsg, "" + psChkValue]);
          ComMsg.showMsg("co.error.maxlen", [psMsg, "" + psChkValue]);
          return false;
        }
      } else if (psChkType == "min") {
        if (vsValue === "" || (vsValue == null)) {
          return true;
        }
        if (typeof vsValue != "string") {
          vsValue = new String(vsValue);
        }
        if ((psChkValue != null) && (vsValue.length < psChkValue)) {
          //          ComMsg.warn("M101", [psMsg, "" + psChkValue]);
          ComMsg.showMsg("co.error.minlen", [psMsg, "" + psChkValue]);
          return false;
        }
      } else if (psChkType == "maxByte") {
        if (vsValue === "" || (vsValue == null)) {
          return true;
        }
        if (typeof vsValue != "string") {
          vsValue = new String(vsValue);
        }
        if ((psChkValue != null) && (vsValue.getByteLength() > psChkValue)) {
          //          ComMsg.warn("M102", [psMsg, "" + psChkValue]);
          ComMsg.showMsg("co.error.maxlen", [psMsg, "" + psChkValue]);
          return false;
        }
      } else if (psChkType == "minByte") {
        if (vsValue === "" || (vsValue == null)) {
          return true;
        }
        if (typeof vsValue != "string") {
          vsValue = new String(vsValue);
        }
        if ((psChkValue != null) && (vsValue.getByteLength() < psChkValue)) {
          //          ComMsg.warn("M101", [psMsg, "" + psChkValue]);
          ComMsg.showMsg("co.error.minlen", [psMsg, "" + psChkValue]);
          return false;
        }
      } else if (psChkType == "null") {
        if ((vsValue === "" || (vsValue == null)) && !psChkValue) {
          //          ComMsg.warn("M100", [psMsg]);
          ComMsg.showMsg("co.error.req", [psMsg]);
          return false;
        }
      } else if (psChkType == "kind") {
        if ((psChkValue == "") || (vsValue === "" || (vsValue == null))) {
          return true;
        }
        
        // 숫자 입력태그인 경우
        if (psChkValue.indexOf("number") == 0) {
          if (Valid.isNumber(vsValue) == false) {
            //            ComMsg.warn("M104", [psMsg]);
            ComMsg.showMsg("co.error.numeric", [psMsg]);
            return false;
          } else {
            var vsRestrict = psChkValue.replace(/number|[\(\)]/g, "");
            if (vsRestrict != "") {
              vaRestrict = vsRestrict.split(",");
              for (var i = vaRestrict.length - 1; i >= 0; i--) {
                vaRestrict [i] = parseInt(vaRestrict [i])
              }
              if (vaRestrict.length == 1) {
                vaRestrict.push(0);
              }
              var vsRegExp = "^";
              for (var i = 0; i < vaRestrict [0] - vaRestrict [1]; i++) {
                vsRegExp += "[0-9]?";
              }
              if (vaRestrict [1] == 0) {
                vsRegExp += "\\.?"
              } else {
                vsRegExp += "(\\."
                for (var i = 0; i < vaRestrict [1]; i++) {
                  vsRegExp += "[0-9]?";
                }
                vsRegExp += ")?"
              }
              vsRegExp += "$"
              if ((new RegExp(vsRegExp)).test(vsValue) == false) {
                //                ComMsg.warn("M153", [psMsg, psChkValue]);
                ComMsg.showMsg("co.error.format", [psMsg, psChkValue]);
                return false;
              }
            }
          }
          
          // 영문자+숫자 입력태그인 경우
        } else if (psChkValue == 'alphanumeric') {
          if (Valid.isAlphaNumeric(vsValue) == false) {
            //            ComMsg.warn("M105", [psMsg]);
            ComMsg.showMsg("co.error alphanumeric", [psMsg]);
            return false;
          }
          
          // 영문자 입력태그인 경우
        } else if (psChkValue == 'alphabet') {
          if (Valid.isAlphabet(vsValue) == false) {
            //            ComMsg.warn("M106", [psMsg]);
            ComMsg.showMsg("co.error.alpha", [psMsg]);
            return false;
          }
          
          // 한글(2 bytes) 입력태그인 경우
        } else if (psChkValue == 'korean') {
          if (Valid.isKorean(vsValue) == false) {
            //            ComMsg.warn("M107", [psMsg]);
            ComMsg.showMsg("co.error.kor", [psMsg]);
            return false;
          }
          
          // ASCII 문자만 입력받는 경우
        } else if (psChkValue == 'ascii') {
          if (Valid.isASCII(vsValue) == false) {
            //            ComMsg.warn("M108", [psMsg]);
            ComMsg.showMsg("co.error.nkor", [psMsg]);
            return false;
          }
          
          // Email 입력 태그인 경우
        } else if (psChkValue == 'email') {
          if (Valid.isEmail(vsValue) == false) {
            //            ComMsg.warn("M103", [psMsg]);
            ComMsg.showMsg("co.error.email", [psMsg]);
            return false;
          }
          
          // biznum 입력 태그인 경우
        } else if (psChkValue == 'biznum') {
          if (Valid.isBizNum(vsValue) == false) {
            //            ComMsg.warn("M103", [psMsg]);
            ComMsg.showMsg("co.error.biznum", [psMsg]);
            return false;
          }
          
          // 주민등록번호 (6+7) 입력태그인 경우
        } else if (psChkValue == 'ssn') {
          if (Valid.isSsn("", vsValue, 1) == false) {
            //            ComMsg.warn("M110", [psMsg]);
            ComMsg.showMsg("co.error.ssn", [psMsg]);
            return false;
          }
          
          // 날짜 입력 태그인 경우 (년+월+일)
        } else if (psChkValue == 'date') {
          if (Valid.isDate("", vsValue, 1) == false) {
            //            ComMsg.warn("M109", [psMsg]);
            ComMsg.showMsg("co.error.date", [psMsg]);
            return false;
          }
        } else if (psChkValue == 'time') {
          if (Valid.isTime("", vsValue, 1) == false) {
            //            ComMsg.warn("M118", [psMsg]);
            ComMsg.showMsg("co.error.time", [psMsg]);
            return false;
          }
        } else if (psChkValue == 'phone') {
          if (Valid.isPhoneNumber(vsValue) == false) {
            //            ComMsg.warn("M111", [psMsg]);
            ComMsg.showMsg("co.error.tel", [psMsg]);
            return false;
          }
        }
      }
    }
    return true;
  },
  
  /**
   * Validation 체크 (notNull, MaxLength, MinLength)
   * ex) Valid.checkValidation(["GridId", "CtlId", "CtlId2", "Grid2"]);
   * @param {Array(String)} paCtlId Check할 Control의 Arrary 객체
   * @param {Boolean} pbFocus 문제요소에 focusing 할 지 여부(default: true)
   * @return 체크 성공 여부(성공:true/실패:false)
   * @type Boolean
   */  
  checkValidation : function(paCtlId, pbFocus) {
    if (pbFocus == null) {
      pbFocus = true;
    }
    this.isFocusingFail = pbFocus;
    var vnArgc = paCtlId.length;
    for (var i = 0; i < vnArgc; i++) {
      if (page.getControl(paCtlId [i]) != "GridEx") {
        // 일반Control
        if (!Valid.checkNotNullCtl([paCtlId [i]])) {
          return false;
        }
        if (!Valid.checkMaxLengthCtl([paCtlId [i]])) {
          return false;
        }
        if (!Valid.checkMinLengthCtl([paCtlId [i]])) {
          return false;
        }
        if (!Valid.checkMaxBLengthCtl([paCtlId [i]])) {
          return false;
        }
        if (!Valid.checkMinBLengthCtl([paCtlId [i]])) {
          return false;
        }
      } else {
        // GridControl
        if (!Valid.checkNotNullGrid([paCtlId [i]])) {
          return false;
        }
        if (!Valid.checkMaxLengthGrid([paCtlId [i]])) {
          return false;
        }
        if (!Valid.checkMinLengthGrid([paCtlId [i]])) {
          return false;
        }
        if (!Valid.checkMaxBLengthGrid([paCtlId [i]])) {
          return false;
        }
        if (!Valid.checkMinBLengthGrid([paCtlId [i]])) {
          return false;
        }
      }
    }
    return true;
  },
  
  /**
   * 컨트롤들의 Kind에 따른 Validation 체크 (kind)
   * kind :
   *      text (default)
   *      number
   *      alphanumeric
   *      korean
   *      ascii
   *      alphabet
   *      date : sep="([.]|[/]|[-]|[\s]|[\,])?"
   *      year month day : group="SameName"
   *      ssn : sep="([-]|[\s])?"
   *      ssn1 ssn2 : group="SameName"
   *      email
   *      biznum
   * @param {Array(String)} paCtlId Check할 Control id의 Arrary 객체
   * @return 체크 성공 여부(성공:true/실패:false)
   * @type Boolean
   */  
  checkKindCtl : function(paCtlId) {
    return Valid._checkCtl("kind", paCtlId);
  },
  
  /**
   * Grid의 Kind에 따른 Validation 체크 (kind)
   * kind :
   *      text (default)
   *      number
   *      alphanumeric
   *      korean
   *      ascii
   *      alphabet
   *      date : sep="([.]|[/]|[-]|[\s]|[\,])?"
   *      year month day : group="SameName"
   *      ssn : sep="([-]|[\s])?"
   *      ssn1 ssn2 : group="SameName"
   *      email
   *      biznum
   * ex) var vbValid = Valid.checkKindGrid("grxMst", null, ["ghcTel:phone", "ghcEmail:email", "ghcBegdt:date"]))
   * @param {String} psGrxId Check할 GridId
   * @param {Arrary(Number)} paRowIdx 체크할 RowIdx의 Arrary객체
   * @param {Arrary(String)} paHeaderId 체크할 HeaderId의 Arrary객체
   * @param {Boolean} pbFocus 문제요소에 focusing 할 지 여부(default: true)
   * @return 체크 성공 여부(성공:true/실패:false)
   * @type Boolean
   */  
  checkKindGrid : function(psGrxId, paRowIdx, paHeaderId, pbFocus) {
    if (pbFocus == null) {
      pbFocus = true;
    }
    this.isFocusingFail = pbFocus;
    var vaArgv = Valid.checkKindGrid.arguments;
    return Valid._checkGrid("kind", vaArgv);
  },
  
  /**
   * 날짜 형식으로 set
   * @param {String} psValue Check할 데이터 값
   * @return 날짜 형식으로 변환된 값
   * @type String
   */  
  setDate : function(psValue) {
    var psPattern = /^([1-2][0-9][0-9][0-9])([.]|[\/]|[-]|[\s]|[\,])?([0-1][0-9]|[1-9])([.]|[\/]|[-]|[\s]|[\,])?([0-3][0-9]|[1-9])$/g;
    
    if (psPattern.test(psValue)) {
      var vsYear = RegExp.$1;
      var vsMonth = RegExp.$3;
      var vsDay = RegExp.$5;
      
      var vsPrintMonth;
      var vsPrintDay;
      
      if (vsMonth.length == 1) {
        vsPrintMonth = "0" + vsMonth;
      } else {
        vsPrintMonth = vsMonth;
      }
      
      if (vsDay.length == 1) {
        vsPrintDay = "0" + vsDay;
      } else {
        vsPrintDay = vsDay;
      }
      
      return vsYear + vsPrintMonth + vsPrintDay;
    } else {
      return "";
    }
  },
  
  /**
   * 주민등록번호 형식으로 set
   * @param {String} psValue Check할 데이터 값
   * @return 주민등록번호 형식으로 변환된 값
   * @type String
   */  
  setSsn : function(psValue) {
    var vsPattern = /^([0-9][0-9][0-1][0-9][0-3][0-9])([-]|[\s])?([1-4][0-9][0-9][0-9][0-9][0-9][0-9])$/g;
    
    if (vsPattern.test(psValue)) {
      var vsSsn1 = RegExp.$1;
      var vsSsn2 = RegExp.$3;
      
      return vsSsn1 + vsSsn2;
    } else {
      return "";
    }
  },
  
  /**
   * checkValidation에서 check fail 시 문제 요소에 focus를 부여해주는 메소드
   */  
  focus : function() {
    if (this.focusId) {
      var vcCtl = page.getControl(this.focusId);
      if (vcCtl == null) {
        return;
      }
      if (this.focusRow && this.focusCol && (vcCtl.toString() == "GridEx")) {
        vcCtl.startEdit(this.focusRow, this.focusCol);
      }
    }
  }
};
/**
 * Keybord Virtual Key Values
 */
VKey = {
  A : 65,
  P : 80,
  X : 88,
  Z : 90,
  a : 97,
  z : 122
  
  ,
  NUM_0 : 48,
  NUM_9 : 57,
  PAD_0 : 96,
  PAD_9 : 105
  
  ,
  PAD_MULTIPLY : 106,
  PAD_ADD : 107,
  PAD_ENTER : 108,
  PAD_MINUS : 109,
  PAD_DOT : 110,
  PAD_DIVIDE : 111
  
  ,
  BACKSPACE : 8,
  TAB : 9,
  ENTER : 13,
  SHIFT : 16,
  CTRL : 17,
  ESC : 27,
  SPACE : 32,
  END : 35,
  HOME : 36,
  DELETE : 46
  
  ,
  COLON : 186,
  COMMA : 188,
  MINUS : 189,
  DOT : 190,
  HAN : 229
  
  ,
  ARROW_LEFT : 37,
  ARROW_UP : 38,
  ARROW_RIGHT : 39,
  ARROW_DOWN : 40
  
  ,
  F1 : 112,
  F2 : 113,
  F3 : 114,
  F4 : 115,
  F5 : 116,
  F6 : 117,
  F7 : 118,
  F8 : 119,
  F9 : 120,
  F10 : 121,
  F11 : 122,
  F12 : 123
};

Util = {
  /**
   * IE 5,6 에서 Alpha 속성 적용을 위한 함수.
   * @private
   */  
  pngfix : function() {
    var vsEls = document.getElementsByTagName('*');
    var voReg = /\.png/i;
    var vnLen = vsEls.length;
    
    while (vnLen--> 0) {
      var voEl = vsEls [vnLen];
      var voEs = voEl.style;
      if (voEl.src && voEl.src.match(voReg) && (voEs.filter == '')) {
        voEl.height = voEl.height;
        voEl.width = voEl.width;
        voEs.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"
        + voEl.src + "',sizingMethod='crop')";
      } else {
        var vsImage = voEl.currentStyle.backgroundImage;
        if (vsImage.match(voReg)) {
          var vsPath = vsImage.split('"');
          var vsRep = (voEl.currentStyle.backgroundRepeat == 'no-repeat') ? 'crop'
          : 'scale';
          voEs.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"
          + vsPath [1] + "',sizingMethod='" + vsRep + "')";
          voEs.height = voEl.clientHeight + 'px';
          voEs.backgroundImage = "none";
        }
      }
      
      if ((voEl.currentStyle.position != 'absolute') && !voEs.filter
      && !voEl.tagName.match(/(body|html|script)/gi)) {
        voEs.position = "relative";
      }
      if (voEs.filter && (voEl.currentStyle.position == "relative")) {
        voEs.position = "static";
      }
    }
  },
  
  /**
   * IE 5,6 에서 Alpha 속성 적용을 위한 함수. IE 5, 6에서 사용.
   */  
  pngfix_ie_only : function() {
    var vsBrowserVer = /MSIE[ \t]\d+[.]/.exec(navigator.userAgent);
    
    if (vsBrowserVer) {
      vsBrowserVer = vsBrowserVer [0];
    } else {
      return;
    }
    
    var vnBrowserVer = parseInt(UtilString.extractNumber(vsBrowserVer));
    // if (navigator.userAgent.search("MSIE[ \t][5-6][.]") != -1) {
    if ((vnBrowserVer == 5) || (vnBrowserVer == 6)) {
      this.pngfix();
    }
  }
};

/**
 * UtilValue Value 체크 및 형 변환
 */
UtilValue = {
  /**
   * Null 여부 체크.
   * ex) var vsId = page.getControl("ipbId").getValue();
   * vsId = UtilValue.isNull(vsId);
   * @param {Object} poValue 체크할 객체.
   * @return Null 여부.
   * @type Boolean
   */  
  isNull : function(poValue) {
    return (this.fixNull(poValue) == "");
  },
  
  /**
   * Number형 value인지 체크
   * ex) UtilValue.isNumber("1234.56") == true
   * @param {String} 체크할 문자열.
   * @return Number 형인지 여부.
   * @type Boolean
   *
   */  
  isNumber : function(psValue) {
    var vnNum = Number(psValue);
    return isNaN(vnNum) == false;
  },
  
  /**
   * null이거나 정의되지 않은경우 ""로 반환
   * ex) var vsId = page.getControl("ipbId").getValue();
   * vsId = UtilValue.fixNull(vsId);
   * @param {Object} poValue 체크할 객체.
   * @return 처리된 객체
   * @type Object
   */  
  fixNull : function(poValue) {
    
    var vsType = typeof (poValue);
    
    var vsTemp = poValue;
    if ((vsType == "string")
    || ((vsType == "object") && poValue instanceof String)) {
      
      poValue = poValue.trim();
    } else {
      
      if (vsType != "object") {
        
        if ((poValue == null) || (poValue == "null")
        || (poValue == "undefined")) {
          poValue = "";
        } else {
          poValue = String(poValue);
        }
      } else {
        var vsTemp = "";
        var i = 0;
        for (number in poValue) {
          vsTemp = - 1;
          if (i > 0) {
            break;
          }
          i++;
        }
        
        if (vsTemp == - 1) {
          poValue = String(poValue);
        } else {
          poValue = "";
        }
      }
    }
    return poValue;
  },
  
  /**
   * Boolean형으로 반환
   * ex) var vsCheck = page.getControl("ipbCheckOut").getValue();
   * var vbCheck = UtilValue.fixBoolean(vsCheck);
   * @param {Object} poValue 변환할 객체
   * @return 변환된 Boolean 값.
   * @type Boolean
   */  
  fixBoolean : function(poValue) {
    if ((typeof (poValue) == "boolean") || poValue instanceof Boolean) {
      return poValue;
    }
    if ((typeof (poValue) == "number") || poValue instanceof Number) {
      return poValue != 0;
    }
    return (this.fixNull(poValue).toUpperCase() == "TRUE");
  },
  
  /**
   * Number형으로 반환.
   * ex) var vsPhone = page.getControl("ipbPhone").getValue();
   * vsPhone = UtilValue.fixNumber(vsPhone);
   * @param {Object} poValue 변환할 객체
   * @return 변환된 Number 객체.
   * @type Number
   */  
  fixNumber : function(poValue) {
    if ((typeof (poValue) == "number") || poValue instanceof Number) {
      return poValue;
    }
    var vnNum = Number(this.fixNull(poValue));
    return isNaN(vnNum) ? 0 : vnNum;
  }
  
};

UtilInstance = {
  /**
   * 맵노드 인스턴스 값을 ""로 초기화.
   * ex) var voNode = page.getInstance("instance").getMapNode("/root/Data/row");
   * UtilInstance.initialMapNode(voNode);
   * @param {Object} poNode 초기화시킬 Map 노드.
   */  
  initialMapNode : function(poNode) {
    //인스턴스 초기화 하기
    var voKeys = poNode.getKeyCollection();
    for (var i = 0; i < voKeys.size(); i++) {
      var sKey = voKeys.get(i);
      poNode.put(sKey, "");
    }
  },
  
  /**
   * 컬렉션 노드 인스턴스 값을 ""로 초기화.
   * ex) var voNode = page.getInstance("instance").getCollectionNode("/root/Data");
   * UtilInstance.initialCollectionNode(voNode);
   * @param {Object} poNode 초기화시킬 Collection노드.
   */  
  initialCollectionNode : function(poNode) {
    var vnSize = poNode.size();
    
    for (var i = 0; i < vnSize; i++) {
      var voNode = new eXria.data.xhtml.MapNode(poNode.get(i));
      UtilInstance.initialMapNode(voNode);
    }
  },
  
  /**
   * Instance MapNode 획득.
   * ex) UtilInstance.getMapNode("insCode", "/root/user", "list", "name", "Kim");
   * @param {String} psInstanceId 인스턴스 아이디.
   * @param {String} psXpath 가져올 MapNode의 Xpath경로.
   * @param {String} psMidNodeName 반복노드.
   * @param {String} psKeyNodeName 가져올 MapNode의 Key에 해댱하는 노드.
   * @param {String} psKeyNodeValue 가져올 MapNode의 Key에 해댱하는 노드의 Value.
   * @return psKeyNodeValue값을 가지고 있는 MapNode.
   * @type eXria.data.MapNode
   */  
  getMapNode : function(psInstanceId, psXpath, psMidNodeName, psKeyNodeName,
  psKeyNodeValue, poPage) {
    //       var voPage = page;
    // if(poPage) voPage = poPage;
    // var voIns = voPage.getInstance(psInstanceId);
    // var voList = voIns.getCollectionNode(psXpath);
    // var voNode;
    // var sMidNodeXpath;
    // var sKeyNodeXpath;
    // var sKey;
    //
    // for (var i = 1 ; i <= voList.size() ; i++) {
    // sMidNodeXpath = psXpath + "/" + psMidNodeName + "[" + i + "]";
    // sKeyNodeXpath = psXpath + "/" + psMidNodeName + "[" + i + "]/" +
    // psKeyNodeName;
    // sKey = voIns.getValueNode(sKeyNodeXpath).getValue();
    //
    // if (sKey == psKeyNodeValue) {
    // voNode = voIns.getMapNode(sMidNodeXpath);
    // break;
    // }
    // }
    // return voNode;
    
    var voPage = page;
    if (poPage) {
      voPage = poPage;
    }
    var voIns = voPage.getInstance(psInstanceId);
    var voNodes = voIns.selectSingleNode(psXpath);
    var voNode = null;
    var voMap = null;
    
    for (voNode = voNodes.getFirstChild(); voNode != null; voNode = voNode
    .getNextSibling()) {
      if (voNode.getNodeType() != 1) {
        continue;
      }
      
      voSingleNode = voNode.getElementByTagName(psKeyNodeName);
      if (String(voSingleNode.getNodeValue()) == psKeyNodeValue) {  //박상찬 수정
        voMap = new eXria.data.xhtml.MapNode(voNode);
        break;
      }
    }
    return voMap;
  },
  
  /**
   * Instance 의 Node Value 획득. psXpath 는 반드시 반복노드여야함
   * ex) UtilInstance.getNodeValue("instance", "/root/user/list", "name", "Kim", "address");
   * ex) UtilInstance.getNodeValue("instance", "/root/user/list", "name", "Kim", ["address","name"...]);
   * @param {String} psInstanceId 인스턴스 아이디.
   * @param {String} psXpath 가져올 MapNode의 Xpath경로.
   * @param {String} psKeyNodeName 가져올 MapNode의 Key에 해댱하는 노드.
   * @param {String} psKeyNodeValue 가져올 MapNode의 Key에 해댱하는 노드의 Value.
   * @param {String}{Array} psTargetNodeName value를 가져올 대상 노드명.
   * @return 대상 Node의 Value. Or 대상 Node의 Array Value
   * @type String|Array(String)
   */  
  getNodeValue : function(psInstanceId, psXpath, psKeyNodeName, psKeyNodeValue,
  psTargetNodeName) {
    var voIns;
    
    if (typeof (psInstanceId) === "string") {
      voIns = page.getInstance(psInstanceId);
    } else {
      voIns = psInstanceId;
    }
    
    // var vaXpath = psXpath.split("/");
    // var vaXpathLength = vaXpath.length - 1;
    // var vsParentPath = "";
    //
    // for (i = 1; i < vaXpathLength; i++) {
    // vsParentPath = vsParentPath + "/" + vaXpath [i]
    // }
    //
    // var voList = voIns.getCollectionNode(vsParentPath);
    // var voListSize = voList.size();
    // var sMidNodeXpath;
    // var sKeyNodeXpath;
    // var strTargetNodeXpath;
    // var sKey;
    // var strTargetNodeValue;
    //
    // for (var i = 1; i <= voListSize; i++) {
    // sMidNodeXpath = psXpath + "[" + i + "]";
    // sKeyNodeXpath = psXpath + "[" + i + "]/" + psKeyNodeName;
    //
    // sKey = voIns.getValueNode(sKeyNodeXpath).getValue();
    //
    // if (sKey == psKeyNodeValue) {
    // strTargetNodeXpath = psXpath + "[" + i + "]/";
    // if (UtilArray.isArray(psTargetNodeName)) {
    // var vnTemp = psTargetNodeName.length;
    // strTargetNodeValue = [];
    // for (var k = 0; k <= vnTemp - 1; k++) {
    // strTargetNodeValue.push(voIns.getValueNode(
    // strTargetNodeXpath + psTargetNodeName [k])
    // .getValue())
    // }
    // } else {
    // strTargetNodeValue = voIns.getValueNode(
    // strTargetNodeXpath + psTargetNodeName).getValue();
    // }
    // break;
    // }
    // }
    //
    // return strTargetNodeValue;
    
    // psXpath += "[" + psKeyNodeName + "='" + psKeyNodeValue + "']";
    // var voNode = voIns.selectSingleNode(psXpath);
    // var vsVal = null;
    // if(voNode) {
    // var voChildNode = voNode.getElementsByTagName(psTargetNodeName);
    // if(voChildNode && voChildNode.getLength() >= 1) {
    // vsVal = voChildNode.item(0).getNodeValue();
    // }
    // }
    
    var voRtnVal = null;
    if (UtilArray.isArray(psTargetNodeName)) {
      var vnTemp = psTargetNodeName.length;
      var voRtnVal = [];
      var vsTempXpath;
      psXpath += "[" + psKeyNodeName + "='" + psKeyNodeValue + "']";
      var voMapNode = voIns.getMapNode(psXpath);
      
      // for (var k = 0; k < vnTemp; k++) {
      // psXpath += "[" + psKeyNodeName + "='" + psKeyNodeValue + "']/" +
      // psTargetNodeName[k];
      // voRtnVal.push(voIns.getValueNode(psXpath).getValue());
      // psXpath = vsOriXpath;
      // }
      for (var k = 0; k < vnTemp; k++) {
        var vsVal = voMapNode.get(psTargetNodeName [k]);
        if (null === vsVal) {
          vsVal = "";
        }
        voRtnVal.push(vsVal);
      }
    } else {
      psXpath += "[" + psKeyNodeName + "='" + psKeyNodeValue + "']/"
      + psTargetNodeName;
      var voNode = voIns.getValueNode(psXpath);
      
      if (voNode) {
        voRtnVal = voNode.getValue();
      }
    }
    
    return voRtnVal;
  },
  
  /**
   * Instance 의 NodePath 획득. psXpath 는 반드시 반복노드여야함
   * ex) UtilInstance.getNodePath("instance", "/root/user/list", "name", "Kim");
   * @param {String} psInstanceId 인스턴스 아이디.
   * @param {String} psXpath 가져올 MapNode의 Xpath경로.
   * @param {String} psKeyNodeName 가져올 MapNode의 Key에 해댱하는 노드.
   * @param {String} psKeyNodeValue 가져올 MapNode의 Key에 해댱하는 노드의 Value.
   * @return 대상 Node의 Path.
   * @type String.
   */  
  getNodePath : function(psInstanceId, psXpath, psKeyNodeName, psKeyNodeValue) {
    var voIns = page.getInstance(psInstanceId);
    
    var vaXpath = psXpath.split("/");
    var vaXpathLength = vaXpath.length - 1;
    var vsParentPath = "";
    
    for (i = 1; i < vaXpathLength; i++) {
      vsParentPath = vsParentPath + "/" + vaXpath [i]
    }
    
    var voList = voIns.getCollectionNode(vsParentPath);
    var voListSize = voList.size();
    var sMidNodeXpath;
    var sKeyNodeXpath;
    var strTargetNodeXpath;
    var sKey;
    
    for (var i = 1; i <= voListSize; i++) {
      sMidNodeXpath = psXpath + "[" + i + "]";
      sKeyNodeXpath = psXpath + "[" + i + "]/" + psKeyNodeName;
      
      sKey = voIns.getValueNode(sKeyNodeXpath).getValue();
      if (sKey == psKeyNodeValue) {
        strTargetNodeXpath = psXpath + "[" + i + "]/" + psKeyNodeName;
        break;
      }
    }
    
    return strTargetNodeXpath;
  },
  
  /**
   * Instance 의Parent NodePath 획득. psXpath 는 반드시 반복노드여야함
   * ex) UtilInstance.getParentNodePath("instance", "/root/user/list", "name", "Kim");
   * @param {String} psInstanceId 인스턴스 아이디.
   * @param {String} psXpath 가져올 MapNode의 Xpath경로.
   * @param {String} psKeyNodeName 가져올 MapNode의 Key에 해댱하는 노드.
   * @param {String} psKeyNodeValue 가져올 MapNode의 Key에 해댱하는 노드의 Value.
   * @return 대상 Node의 ParentNode Path.
   * @type String.
   */  
  getParentNodePath : function(psInstanceId, psXpath, psKeyNodeName,
  psKeyNodeValue) {
    var voIns = page.getInstance(psInstanceId);
    var vaXpath = psXpath.split("/");
    var vaXpathLength = vaXpath.length - 1;
    var vsParentPath = "";
    
    for (i = 1; i < vaXpathLength; i++) {
      vsParentPath = vsParentPath + "/" + vaXpath [i]
    }
    
    var voList = voIns.getCollectionNode(vsParentPath);
    var voListSize = voList.size();
    var sMidNodeXpath;
    var sKeyNodeXpath;
    var strTargetNodeXpath;
    var sKey;
    
    for (var i = 1; i <= voListSize; i++) {
      sMidNodeXpath = psXpath + "[" + i + "]";
      sKeyNodeXpath = psXpath + "[" + i + "]/" + psKeyNodeName;
      
      sKey = voIns.getValueNode(sKeyNodeXpath).getValue();
      if (sKey == psKeyNodeValue) {
        break;
      }
    }
    
    return sMidNodeXpath;
  },
  
  /**
   * xml node의 xpath정보를 문자열 배열 형태로 반환하는 메소드
   * @param {Object} node xpath 정보를 조회할 노드 객체
   * @param {Array(String)} xpath 저장 배열.
   * return 값과 동일한 객체로 초기 메소드 호출 시에는 null 값이며 내부적으로 메소드가 자신을 재귀호출하며 파라미터를 넘겨줌.
   * @return 문자열 배열형태의 xml node의 xpath
   * @type Array(String)
   */  
  getXPath : function(node, path) {
    path = path || [];
    if (node.getParentNode()) {
      path = this.getXPath(node.getParentNode(), path);
    }
    
    if (node.getPreviousSibling()) {
      var count = 1;
      var sibling = node.getPreviousSibling()
      do {
        if ((sibling.getNodeType() == 1)
        && (sibling.getNodeName() == node.getNodeName())) {
          count++;
        }
        sibling = sibling.getPreviousSibling();
      } while (sibling);
      if (count == 1) {
        count = null;
      }
    } else if (node.getNextSibling()) {
      var sibling = node.getNextSibling();
      do {
        if ((sibling.getNodeType() == 1)
        && (sibling.getNodeName() == node.getNodeName())) {
          var count = 1;
          sibling = null;
        } else {
          var count = null;
          sibling = sibling.getPreviousSibling();
        }
      } while (sibling);
    }
    
    if (node.getNodeType() == 1) {
      path.push(node.getNodeName().toLowerCase()
      + (node.id ? "[@id='" + node.id + "']" : count > 0 ? "[" + count
      + "]" : ''));
    }
    return path;
  },
  
  /**
   * XML노드 문자열을 인스턴스에 APPEND 한다.
   * ex) UtilInstance.appendNodeFromText(page, instanceObject, "/root/user/list", "<root><row></row></root>");
   * @param {eXria.form.Page} poPage 페이지 객체
   * @param {object} psInstanceId 인스턴스 아이디.
   * @param {String} psXpath 가져올 MapNode의 Xpath경로.
   * @param {String} psXMLText append 할 XML TEXT
   * @return 작업성공 여부
   * @type Boolean
   */  
  appendNodeFromText : function(poPage, poInstance, psXpath, psXMLText) {
    var voPage = poPage;
    if (voPage == null) {
      return false;
    }
    
    // var voTmpInst =
    // voPage.model.createInstance("appendNodeFromTextInstance");
    // voTmpInst.loadTXT(psXMLText);
    //
    // var voSrcNode = voTmpInst.selectSingleNode("/root").cloneNode(true);
    // var voTargetInstance = poInstance;
    // var voTargetNode = voTargetInstance.selectSingleNode(psXpath);
    //
    // // plugin node merge 로 대체할 부분
    // var voNodeList = voSrcNode.getChildNodes();
    // var voNodeListLength = voNodeList.getLength();
    //
    // for (var i = 0; i < voNodeListLength; i++) {
    // var voNode = voSrcNode.removeChild(voNodeList.item(0));
    // voTargetNode.appendChild(voNode);
    // }
    //
    // // 부모노드가 존재 할경우에는 아래와 같이 하면 에러 발생(이중계약ㅋㅋ)
    // // for(var i=0; i<voNodeListLength; i++){
    // // voTargetNode.appendChild(voNodeList.item(i));
    // // }
    //
    // voPage.model.removeInstance("appendNodeFromTextInstance");
    
    var vsXMLText = psXMLText.replace("<root>", "");
    vsXMLText = vsXMLText.replace("</root>", "");
    
    poInstance.appendNodeByTxt(psXpath, vsXMLText);
    
    return true;
  }
  
};

/**
 * 팝업 처리 공통 모듈
 */
UtilPopUp = {
  /**
   * 레이어 팝업창 식별을 위한 내부적인 일련번호
   * @type Number
   * @private
   */  
  seq : 0,
  /**
   * 일련번호 목록을 저장하기 위한 오브젝트
   * @type Object
   * @private
   */  
  idxs : {},
  /**
   * 레이어드 팝업창 식별 일련번호를 부여하여 반환하는 메소드
   * @return 레이어 팝업창 식별 일련번호
   * @type Number
   * @private
   */  
  _getUniqueIdx : function() {
    var vnCnt = 0;
    var attr = null;
    for (attr in this.idxs) {
      vnCnt++;
    }
    if (vnCnt == 0) {
      this.seq = 0;
    }
    this.idxs [this.seq] = {};
    return this.seq++;
  },
  /**
   * 레이어 팝업창 종료 시 팝업창 식별 일련번호를 등록해제하기 위한 메소드
   * @private
   */  
  _unregIdx : function(pnIdx) {
    delete this.idxs [pnIdx];
  },
  /**
   * 레이어 팝업창에서 접근할 속성값 저장 객체를 반환해주는 메소드
   * @param {eXria.form.Page} 팝업페이지의 eXria.form.Page 객체
   * @return 레이어 팝업창에서 접근할 속성값 저장 객체
   * @type Object
   */  
  getPopupAttr : function(poPage) {
    var voParentPage = poPage.window.parent.page;
    var vsSbpId = poPage.window.frameElement.id;
    var voSbp = voParentPage.getControl(vsSbpId);
    return voSbp.userAttr;
  },
  /**
   * 레이어 팝업창에서 팝업페이지를 호출하는 eXria.controls.xhtml.SubPage 컨트롤 객체를 반환해주는 메소드
   * @param {eXria.form.Page} 팝업페이지의 eXria.form.Page 객체
   * @return 팝업페이지를 호출하는 eXria.controls.xhtml.SubPage 컨트롤 객체
   * @type eXria.controls.xhtml.SubPage
   */  
  getSbpCtl : function(poPage) {
    var voParentPage = poPage.window.parent.page;
    var vsSbpId = poPage.window.frameElement.id;
    var voSbp = voParentPage.getControl(vsSbpId);
    return voSbp;
  },
  
  /**
   * 레이어 팝업 페이지 오픈
   * ex) UtilPopUp.openLayeredPopup("./subPage.xrf", 300, 300, {});
   * @param {String} psUrl 페이지 url.
   * @param {Number} psWidth 페이지 width
   * @param {Number} psHeight 페이지 height
   * @param {Object} poUserAttr 사용자 지정 속성 저장 오브젝트
   */  
  openLayeredPopup : function(psUrl, pnWidth, pnHeight, poUserAttr) {
	//  debugger;
    //psUrl = eXria.util.xhtml.getImagePath(psUrl, page.window);
    var voPage = page;
    
    while (voPage) {
      if (voPage.window.parent.page && (voPage != voPage.window.parent.page)) {
        voPage = voPage.window.parent.page;
      } else {
        break;
      }
    }
    
    voPage.window.UtilPopUp._openLayeredPopup(psUrl, pnWidth, pnHeight, poUserAttr);
  },
  
  /**
   * 위치가 지정된 레이어 팝업 페이지 오픈
   * ex) UtilPopUp.openContextMenuPopUp("./subPage.xrf", 300, 300, {});
   * @param {String} psUrl 페이지 url.
   * @param {Number} psWidth 페이지 width
   * @param {Number} psHeight 페이지 height
   * @param {Object} poUserAttr 사용자 지정 오브젝트
   * @param {Object} 팝업창의 left, top 위치를 가져올 이벤트 객체
   */  
  openContextMenuPopUp : function(psUrl, pnWidth, pnHeight, poUserAttr, poEvent) {
    var voPage = page;
    while (voPage) {
      if (voPage.window.parent.page && (voPage != voPage.window.parent.page)) {
        voPage = voPage.window.parent.page;
      } else {
        break;
      }
    }
    
    voPage.window.UtilPopUp._controlCreate(psUrl, pnWidth, pnHeight,
    poUserAttr, poEvent);
    
  },
  
  /**
   * 레이어 팝업창 생성 메소드
   * @param {String} psUrl 팝업창에서 보여질 화면 url
   * @param {Number} pnWidth 팝업창 가로 길이
   * @param {Number} pnHeight 팝업창 세로 길이
   * @param {Object} poUserAttr 사용자 지정 오브젝트
   * @param {Object} 팝업창의 left, top 위치를 가져올 이벤트 객체
   * @private
   */  
  _controlCreate : function(psUrl, pnWidth, pnHeight, poUserAttr, poEvent) {
    var vnLeft = 0;
    var vnTop = 0;
    var vnOuterZindex = 30000;
    var vnPageZindex = 40000;
    var voPage = page;
    var vnIdx = this._getUniqueIdx();
    if (poUserAttr == null) {
      poUserAttr = {};
    }
    poUserAttr.popupIdx = vnIdx;
    poUserAttr.page = voPage;
    
    var voEvent = poEvent;
    var voCanvas = voPage.canvas;
    var voDocument = voPage.window.document;
    var voDomElement = voDocument.documentElement;
    
    // HTML 문서가 표시되는 화상 표시 영역인 뷰포트(viewport)의 크기
    // 이것은 브라우저 창 크기에서 메뉴바, 툴바, 스크롤바 등의 크기를 뺀 나머지
    var vnViewportWidth;
    var vnViewportHeight;
    
    // if(voPage.metadata.browser.ie){
    // vnViewportWidth = voDomElement.clientWidth;
    // vnViewportHeight = voDomElement.clientHeight;
    // }else{
    // vnViewportWidth = voPage.window.innerWidth;
    // vnViewportHeight = voPage.window.innerHeight;
    // }
    
    vnViewportWidth = voPage.canvas.width;
    vnViewportHeight = voPage.canvas.height;
    
    vnLeft = voEvent.clientX;
    vnTop = voEvent.clientY;
    
    // check horizontal position
    if (vnViewportWidth < voEvent.clientX + pnWidth) {
      vnLeft = parseInt(voEvent.clientX - pnWidth - 10)
    }
    //check vertical position
    if (vnViewportHeight < voEvent.clientY + pnHeight) {
      vnTop = parseInt(voEvent.clientY - pnHeight - 10)
    }
    
    // 모든 컨트롤을 담을 그룹
    {
      var vcGroup = voCanvas.createControl("group", vnIdx
      + "grpLayerPopUpOuterGroup", vnLeft, vnTop, pnWidth + 9, pnHeight + 28);
      vcGroup.backgroundColor = "#F1F1F1";
      vcGroup.borderWidth = 0;
      vcGroup.zIndex = vnOuterZindex;
      vcGroup.overflow = "visible";
    }
    
    // 사용자가 넘겨준 xrf를 최외곽 group에 append
    var vcSbp = voCanvas.createControl("subpage", vnIdx
    + "sbpLayerPopUpCoverPage", 3, 25, pnWidth + 3, pnHeight);
    vcSbp.borderWidth = 0;
    vcSbp.zIndex = vnPageZindex;
    vcSbp.userAttr = poUserAttr;
    vcGroup.addChild(vcSbp);
    
    // top 영역
    {
      var vcRct = voCanvas.createControl("label", vnIdx + "rctLayerPopTop", 0, 0,
      pnWidth + 9, 22);
      vcRct.zIndex = 1;
      vcRct.backgroundColor = "#669999";
      vcRct.borderWidth = 0;
      
      vcRct.onmousedown = function(e) {
        var voOuterGroup = page.getControl(vnIdx + "grpLayerPopUpOuterGroup");
        voOuterGroup.startMove(e);
      }
      vcGroup.addChild(vcRct);
    }
    
    // top의 닫기 버튼
    {
      var vcBtn = voCanvas.createControl("button", vnIdx + "btnLayerPopClose",
      pnWidth - 18, 2, 17, 17);
      vcBtn.zIndex = 2;
      vcBtn.value = "X";
      vcBtn.color = "#000000";
      vcBtn.backgroundColor = "white";
      var that = this;
      vcBtn.onclick = function(e) {
        that.closeLayeredPopup(vnIdx, voPage);
      }
      vcGroup.addChild(vcBtn);
    }
    
    voCanvas.appendControl(vcGroup);
    psUrl = eXria.controls.xhtml.Util.getImagePath(psUrl, voPage.window);
    vcSbp.setSrc(psUrl);
  },
  
  /**
   * 레이어 팝업 페이지 오픈 (openLayeredPopup의 실제 구현체)
   * ex) UtilPopUp._openLayeredPopup("./subPage.xrf", 300, 300, {});
   * @param {String} psUrl 페이지 url.
   * @param {Number} psWidth 페이지 width
   * @param {Number} psHeight 페이지 height
   * @param {Object} poUserAttr 사용자 지정 속성 저장 오브젝트
   * @private
   */  
  _openLayeredPopup : function(psUrl, pnWidth, pnHeight, poUserAttr) {
    
    var vnLeft = 0;
    var vnTop = 0;
    var vnOuterZindex = 30000;
    var vnPageZindex = 40000;
    
    var vnIdx = this._getUniqueIdx();
    if (poUserAttr == null) {
      poUserAttr = {};
    }
    poUserAttr.popupIdx = vnIdx;
    
    var voPage = page;
    poUserAttr.page = voPage;
    
    var voCanvas = voPage.canvas;
    var voCanvasCtrl = voCanvas.getCtrl();
    var voDocument = voPage.window.document;
    var voDomElement = voDocument.documentElement;
    var vnCanvasWidth = voDomElement.scrollWidth;
    var vnCanvasHeight = voDomElement.scrollHeight;
    
    // openWindowLayerPopUp가 여러번 호출되었을경우 zIndex 조정
    if (! !page.getControl(vnIdx - 1 + "rtgLayerPopUpCoverPage")) {
      vnOuterZindex = vnPageZindex;
      vnPageZindex = vnPageZindex + 10;
    }
    
    // 백그라운드에 rectangle로 씌움
    {
      voCanvasCtrl.style.overflow = "visible";
      var vcRtg = voCanvas.createControl("rectangle", vnIdx
      + "rtgLayerPopUpCoverPage", vnLeft, vnTop, vnCanvasWidth,
      vnCanvasHeight);
      vcRtg.zIndex = vnOuterZindex;
      vcRtg.fillType = "solid";
      vcRtg.fillStartColor = "#c0c0c0";
      vcRtg.fillOpacity = 50;
      vcRtg.penWeight = 0;
      voCanvas.appendControl(vcRtg);
    }
    
    vnLeft = (vnCanvasWidth - pnWidth) / 2;
    vnTop = (vnCanvasHeight - pnHeight) / 2;
    
    // 모든 컨트롤을 담을 그룹
    {
      var vcGroup = voCanvas.createControl("group", vnIdx
      + "grpLayerPopUpOuterGroup", vnLeft, vnTop, pnWidth + 9, pnHeight + 28);
      vcGroup.backgroundColor = "#F1F1F1";
      vcGroup.borderWidth = 0;
      vcGroup.zIndex = vnOuterZindex;
      vcGroup.overflow = "visible";
    }
    
    // 사용자가 넘겨준 xrf를 최외곽 group에 append
    var vcSbp = voCanvas.createControl("subpage", vnIdx
    + "sbpLayerPopUpCoverPage", 3, 25, pnWidth + 3, pnHeight);
    vcSbp.borderWidth = 0;
    vcSbp.zIndex = vnPageZindex;
    vcSbp.userAttr = poUserAttr;
    vcGroup.addChild(vcSbp);
    
    // top 영역
    {
      var vcRct = voCanvas.createControl("label", vnIdx + "rctLayerPopTop", 0, 0,
      pnWidth + 9, 22);
      vcRct.zIndex = 1;
      vcRct.backgroundColor = "#669999";
      vcRct.borderWidth = 0;
      
      vcRct.onmousedown = function(e) {
        var voOuterGroup = page.getControl(vnIdx + "grpLayerPopUpOuterGroup");
        voOuterGroup.startMove(e);
      }
      vcGroup.addChild(vcRct);
    }
    
    // top의 닫기 버튼
    {
      var vcBtn = voCanvas.createControl("button", vnIdx + "btnLayerPopClose",
      pnWidth - 18, 2, 17, 17);
      vcBtn.zIndex = 2;
      vcBtn.value = "X";
      vcBtn.color = "#000000";
      vcBtn.backgroundColor = "white";
      var that = this;
      vcBtn.onclick = function(e) {
        that.closeLayeredPopup(vnIdx, voPage);
      }
      vcGroup.addChild(vcBtn);
    }
    
    voCanvas.appendControl(vcGroup);
    psUrl = eXria.controls.xhtml.Util.getImagePath(psUrl, page.window);
    vcSbp.setSrc(psUrl);
    
    return this;
  },
  
  /**
   * 레이어 팝업 페이지 종료
   * ex) UtilPopUp.closeLayeredPopup(1);
   * @param {Number} pnIdx 레이어 팝업 식별 일련번호
   */  
  closeLayeredPopup : function(pnIdx) {
    var voPage = page;
    while (voPage) {
      if (voPage.window.parent.page && (voPage != voPage.window.parent.page)) {
        voPage = voPage.window.parent.page;
      } else {
        break;
      }
    }
    voPage.window.UtilPopUp._closeLayeredPopup(pnIdx);
  },
  
  /**
   * 실제 레이어 팝업이 생성된 페이지에서 레이어 팝업창을 종료시키기 위한 내부메소드
   * ex) UtilPopUp._closeLayeredPopup(1);
   * @param {Number} pnIdx 레이어 팝업 식별 일련번호
   * @return this;
   * @type void
   * @private
   */  
  _closeLayeredPopup : function(pnIdx) {
    var voCloseLayeredPopupFunc = function() {
      if (pnIdx === null || pnIdx === undefined) {
        return false;
      }
      page.window.UtilPopUp._unregIdx(pnIdx);
      
      if (! !page.getControl(pnIdx + "grpLayerPopUpOuterGroup")) {
        page.canvas.removeControl(pnIdx + "grpLayerPopUpOuterGroup");
      }
      
      if (! !page.getControl(pnIdx + "rtgLayerPopUpCoverPage")) {
        page.canvas.removeControl(pnIdx + "rtgLayerPopUpCoverPage");
      }
      
      return true;
    };
    
    window.setTimeout(voCloseLayeredPopupFunc, 100);
  },
  
  /**
   * 현재 페이지가 팝업창인지 여부 확인.
   * ex) UtilPopUp.isPopUp();
   * @return 현재 페이지가 팝업창인지 여부.
   * @type Boolean
   */  
  isPopUp : function() {
    //    var vbPopUp = true;
    // if(window.opener == null || window.opener == "undefined"){
    // vbPopUp = false;
    // }
    // return vbPopUp;
    if (window.opener || window.dialogArguments) {
      // 새창 or modal창
      return true;
    } else if (page.parent && (page != page.parent)) {
      // 내부다이얼로그
      return true;
    } else {
      return false;
    }
  },
  
  /**
   * 팝업창 닫기.
   * ex) UtilPopUp.close();
   */  
  close : function() {
    //   * @author dblim
    if (window.opener || window.dialogArguments) {
      // 새창 or modal창
      window.close();
    } else if (page.parent && (page != page.parent)) {
      // 내부다이얼로그
      UtilDialog.removeDialogCtrl(page.parent);
    } else {
      return false;
    }
  },
  
  /**
   * 대상 아이디를 갖는 객체로 부터 값을 가져오는 메소드
   * @param {String} psId 값을 가져올 대상의 아이디
   * psId로 사용 가능한 종류
   * 1. 인스턴스(/root/시작)
   * 2. 그리드의 셀 (ghc시작 헤더컬럼 아이디)
   * 3. 컨트롤 아이디
   * 4. 값 그대로
   * @param {String} psGrxId 그리드 아이디(생략가능, 그리드만 필요)
   * @param {Object} poRow 그리드 row 객체(생략가능, 그리드만 필요)
   * @return 대상 아이디를 갖는 객체에 설정된 값
   * @type Object
   */  
  getValue : function(psId, psGrxId, poRow) {
    //   * @author dblim
    var vsValue = "";
    if (typeof (psId) != "string") {
      // 문자열이 아니면  4. 값 그대로
      vsValue = psId;
    } else if (!psId) {
      // 아이디가 비어있으면 빈문자열 리턴.
      vsValue = "";
    } else if (psId.startsWith("/")) {
      // 1. 인스턴스(/root/시작)
      var vsInstanceId = "instance";
      if (page.model.defaultInstanceId) {
        vsInstanceId = page.model.defaultInstanceId
      } else if (page.model.plugin) {
        vsInstanceId = page.model.plugin.getDefInstanceID();
      }
      vsValue = page.getInstance(vsInstanceId).getValueNode(psId).getValue();
    } else if (psId.startsWith("ghc")) {
      // 2. 그리드의 셀 (ghc시작)
      vsValue = page.getControl(psGrxId).getValue(poRow, psId);
    } else if (page.getControl(psId)) {
      // 3. 컨트롤
      vsValue = page.getControl(psId).getValue();
    } else {
      // 4. 값 그대로
      vsValue = psId;
    }
    
    if ((vsValue == undefined) || (vsValue == null)) {
      vsValue = "";
    }
    return vsValue;
  },
  
  /**
   * 대상 아이디를 갖는 객체에 값을 설정해주는 메소드
   * @param {String} psId 값을 설정할 대상의 아이디
   * psId로 사용 가능한 종류
   * 1. 인스턴스(/시작)
   * 2. 그리드의 셀 (ghc시작 헤더컬럼 아이디)
   * 3. 컨트롤 아이디
   * @param {String} psValue 값
   * @param {String} psGrxId 그리드 아이디(생략가능, 그리드만 필요)
   * @param {Object} poRow 그리드 row 객체(생략가능, 그리드만 필요)
   */  
  setValue : function(psId, psValue, psGrxId, poRow) {
    //   * @author dblim
    if (!psId) {
      // 아이디가 비어있으면 리턴.
      return;
    } else if (psId.startsWith("/")) {
      // 1. 인스턴스(/시작)
      var vsInstanceId = "instance";
      if (page.model.defaultInstanceId) {
        vsInstanceId = page.model.defaultInstanceId
      } else if (page.model.plugin) {
        vsInstanceId = page.model.plugin.getDefInstanceID();
      }
      return page.getInstance(vsInstanceId).getValueNode(psId).setValue(psValue);
    } else if (psId.startsWith("ghc")) {
      // 2. 그리드의 셀 (ghc시작)
      return page.getControl(psGrxId).setValue(poRow, psId, psValue, true);
      // 그리드의 AfterValueChanged 이벤트가 발생하지 않도록.
      // return UtilGrid.setValue(psGrxId, poRow, psId, psValue);
    } else if (page.getControl(psId)) {
      // 3. 컨트롤
      return page.getControl(psId).setValue(psValue);
    } else {
      // 오타
      ComMsg.alert(psId + ": invalid ID");
    }
  },
  /**
   * 팝업창에 크기를 자신이 로딩한 xrf파일 사이즈에 맞게 새로고침해주는 메소드.
   * 주로 팝업창에 onLoad 이벤트 내에서 호출함.
   * ex) UtilPopUp.resizeToPage(100);
   * @param {Number} pnVAdd 덧 붙여줄 높이 값
   */  
  resizeToPage : function(pnVAdd) {
    if (pnVAdd == null) {
      pnVAdd = 0;
    }
    var vnWidth = page.canvas.width;
    var vnHeight = page.canvas.height;
    var voDocument = page.window.document;
    var vnCurWidth = voDocument.body.offsetWidth;
    var vnCurHeight = null;
    if (page.metadata.browser.ie) {
      vnCurHeight = voDocument.documentElement.offsetHeight;
    } else {
      vnCurHeight = voDocument.body.scrollHeight;
    }
    page.window.resizeBy(vnWidth - vnCurWidth, vnHeight - vnCurHeight + pnVAdd);
  }
};

/**
 * 배열관련 유틸 모듈
 */
UtilArray = {
  /**
   * 지정된 값이 Array인지 여부를 반환하는 메소드
   * @param {Object} psValue Array인지 여부를 확인하고자 하는 값
   * @return 지정된 값이 Array인지 여부
   * @type Boolean
   */  
  isArray : function(psValue) {
    return psValue && typeof psValue === 'object'
    && typeof psValue.length === 'number'
    && typeof psValue.splice === 'function'
    && !(psValue.propertyIsEnumerable('length'));
  }
};

/**
 * 배열관련 유틸 모듈
 */
UtilString = {
  /**
   * 문자열 양끝의 공백문자를 삭제하여 반환하는 메소드
   * @param {String} pstr 대상 문자열
   * @type String
   * @return 문자열 양끝의 공백문자가 삭제된 값
   */  
  trim : function(pstr) {
    if (pstr == null) {
      return null;
    } else {
      return pstr.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
    }
  },
  /**
   * 문자열 길이를 반환하는 메소드
   * @param {String} pstr 대상 문자열
   * @type Number
   * @return 문자열 길이
   */  
  length : function(pstr) {
    if ((pstr == null) || (pstr == undefined)) {
      return 0;
    } else {
      return pstr.length;
    }
  },
  
  /**
   * 문자열의 바이트를 수를 구한다.
   * @param {String} pstr 대상 문자열
   * @type Number
   * @return 문자열 바이트 수
   */  
  getByteLength : function(psText) {
    //      var strTemp;
    // var numCnt = 0;
    // var numLength = pstr.length;
    //
    // for (var i=0; i < numLength; i++) {
    // strTemp = pstr.charAt(i);
    // if (escape(strTemp).length > 4)
    // numCnt += 2;
    // else
    // numCnt++;
    // }
    // return numCnt;
    var vnByteLength = 0;
    if ((psText.valueOf() == null) || (psText.length == 0)) {
      return 0;
    }
    var vsTemp;
    for (var i = 0; i < psText.length; i++) {
      vsTemp = escape(psText.charAt(i));
      if (vsTemp.length == 1) {
        vnByteLength++;
      } else if (vsTemp.indexOf("%u") != - 1) {
        vnByteLength += 2;
      } else if (vsTemp.indexOf("%") != - 1) {
        vnByteLength += vsTemp.length / 3;
      }
    }
    return vnByteLength;
  },
  /**
   * 문자열에서 공백과 숫자가 아닌 모든 문자를 제거하여 반환하는 메소드
   * @param {String} psStr 대상 문자열
   * @type String
   * @return 문자열에서 공백과 숫자가 아닌 모든 문자가 제거된 값
   */  
  extractNumber : function(psStr) {
    if ((psStr == null) || (psStr == undefined)) {
      return 0;
    } else {
      psStr = psStr.replace(/\s/g, ''); // 공백(whitespace) 제거
      psStr = psStr.replace(/\D/g, ''); // 공백포함,숫자가 아닌 모든 문자 제거
      return psStr;
    }
  },
  
  /**
   * 문자열에서 특정 문자를 치환한다.
   * @param {String} strVal 대상 문자열
   * @param {String} oldStr 대상 문자열 내의 바꿀 문자
   * @param {String} newStr 대상 문자열 내의 바뀔 문자
   * @return 치환된 문자열
   * @type String
   */  
  changeStr : function(strVal, oldStr, newStr) {
    var newString = "";
    for (var j = 0; j <= strVal.length - 1; j++) {
      if (strVal.charAt(j) != oldStr) {
        newString = newString + strVal.charAt(j);
      } else {
        newString = newString + newStr;
      }
    }
    return newString;
  },
  
  /**
   * 입력받은 숫자를 원하는 자리수 만큼 0으로 채워준다.
   * ex) 2220000 == UtilString.makeWonFormat("222", 4, "right");
   * @param {String} val 대상 문자열
   * @param {Number} cnt 채울 0의 갯수
   * @param {String} location 채울 위치 구분 문자열("left"|"right")
   * @return 주어진 위치에 숫자만큼 0이 채워진 문자열
   * @type String
   */  
  makeWonFormat : function(val, cnt, location) {
    var sLen = val.length;
    
    if ((location == "") || (location == null)) {
      location = "right";
    }
    
    for (i = 0; i < cnt - sLen; i++) {
      if (location == "left") {
        val = "0" + val;
      } else if (location == "right") {
        val = val + "0";
      }
    }
    return val;
  },
  
  /**
   * 한글(2byte)인지 Check
   * @param {String} value 대상 문자열
   * @return 한글(2byte)인지 여부
   * @type Boolean
   */  
  isKorean : function(value) {
    var i = 0;
    while (true) {
      var varCh = value.charAt(i++);
      if ((varCh == "") || (varCh == null)) {
        break;
      } else if (varCh == ' ') {
        continue;
      } else {
        var ch = escape(varCh);
        if (ch.substring(0, 2) == "%u") {
          if (ch.substring(2, 4) == "00") {
            return false;
          }
        } else if (ch.substring(0, 1) == "%") {
          if (parseInt(ch.substring(1, 3), 16) <= 127) {
            return false;
          }
        } else {
          return false;
        }
      }
    }
    return true;
  },
  
  /**
   * 숫자에 원하는 자리수 마다 구분자를 찍어서 돌려준다
   * ex) UtilString.makeSeperateFormat(3330000, ",", 3) === "3,330,000";
   * @param {Number} pnNumber 변경대상.
   * @param {String} psSeperate 구분자
   * @param {Number} pnWidth 자리수
   * @return {String} 구분자가 적용된 숫자
   * @type String
   */  
  makeSeperateFormat : function(pnNumber, psSeperate, pnWidth) {
    var vsSeperate = (!psSeperate) ? "," : psSeperate;
    var vnWidth = (!pnWidth) ? 3 : pnWidth;
    var vsNumber = pnNumber + "";
    
    var vsRegExp = "(^[+-]?\\d+)(\\d{" + vnWidth + "})";
    vsRegExp = new RegExp(vsRegExp);
    
    while (vsRegExp.test(vsNumber)) {
      vsNumber = vsNumber.replace(vsRegExp, "$1" + vsSeperate + "$2");
    }
    
    return vsNumber;
  }
  
};

/*******************************************************************************
 * String class 함수
 ******************************************************************************/

/**
 * 지정한 문자열로 시작하는지 판단.
 *
 * @param {String}
 *          psWith 지정 문자열.
 * @return 지정 문자열로 시작하는지 여부.
 * @type Boolean
 */
String.prototype.startsWith = function(psWith) {
  return (this.indexOf(psWith) == 0);
};

/**
 * 지정한 문자열로 끝나는지 판단.
 *
 * @param {String}
 *          psWith 지정 문자열.
 * @return 지정 문자열로 끝나는지 여부.
 * @type Boolean
 */
String.prototype.endsWith = function(psWith) {
  var vnIdx = this.lastIndexOf(psWith);
  return (vnIdx != - 1) && (vnIdx == (this.length - psWith.length));
};

/**
 * 빈 문자열인지 판단.
 *
 * @return 빈 문자열인지 여부.
 * @type Boolean
 */
String.prototype.isEmpty = function() {
  return (this.length == 0);
};

/**
 * 지정한 문자열로 오른쪽 잘라내기, 미지정시 오른쪽 공백문자 제거. ex) "TestString".trimRight("String") ==
 * "Test"; "TestString ".trimRight() == "TestString";
 *
 * @param {String}
 *          psTrim 지정 문자열.
 * @return 처리된 문자열.
 * @type String
 */
String.prototype.trimRight = function(psTrim) {
  if (psTrim == null) {
    return this.replace(/(\s*$)/g, "");
  }
  var vnIdx = this.lastIndexOf(psTrim);
  return (vnIdx != - 1 ? this.substring(0, vnIdx) : this);
};

/**
 * 지정한 문자열로 왼쪽 잘라내기, 미지정시 왼쪽 공백문자 제거. ex) "TestString".trimLeft("Test") ==
 * "String"; " TestString".trimLeft() == "TestString";
 *
 * @param {String}
 *          psTrim 지정 문자열.
 * @return 처리된 문자열.
 * @type String
 */
String.prototype.trimLeft = function(psTrim) {
  if (psTrim == null) {
    return this.replace(/(^\s*)/g, "");
  }
  var vnIdx = this.indexOf(psTrim);
  return (vnIdx == 0 ? this.substring(psTrim.length) : this);
};

/**
 * 스트링의 자릿수를 Byte 단위로 환산하여 알려준다. 영문, 숫자는 1Byte이고 한글은 2Byte이다. (자/모 중에 하나만 있는 글자도
 * 2Byte이다.)
 *
 * @return 스트링의 바이트 수.
 * @type Number
 */
String.prototype.getByteLength = function() {
  var vnByteLength = 0;
  if ((this.valueOf() == null) || (this.length == 0)) {
    return 0;
  }
  var vsTemp;
  for (var i = 0; i < this.length; i++) {
    vsTemp = escape(this.charAt(i));
    if (vsTemp.length == 1) {
      vnByteLength++;
    } else if (vsTemp.indexOf("%u") != - 1) {
      vnByteLength += 2;
    } else if (vsTemp.indexOf("%") != - 1) {
      vnByteLength += vsTemp.length / 3;
    }
  }
  return vnByteLength;
};

/**
 * 스트링 내에 있는 특정 스트링을 다른 스트링으로 모두 변환한다. String 객체의 replace 메소드와 동일한 기능을 하지만 간단한
 * 스트링의 치환시에 보다 유용하게 사용할 수 있다. ex) var str = "abcde"; str =
 * str.simpleReplace("cd", "xx");
 *
 * @param {String}
 *          psOldStr 바뀌어야 될 기존의 스트링.
 * @param {String}
 *          psNewStr 바뀌어질 새로운 스트링.
 * @return 변경된 스트링.
 * @type String
 */
String.prototype.simpleReplace = function(psOldStr, psNewStr) {
  var vsStr = psOldStr;
  
  vsStr = vsStr.replace(/\\/g, "\\\\");
  vsStr = vsStr.replace(/\^/g, "\\^");
  vsStr = vsStr.replace(/\$/g, "\\$");
  vsStr = vsStr.replace(/\*/g, "\\*");
  vsStr = vsStr.replace(/\+/g, "\\+");
  vsStr = vsStr.replace(/\?/g, "\\?");
  vsStr = vsStr.replace(/\./g, "\\.");
  vsStr = vsStr.replace(/\(/g, "\\(");
  vsStr = vsStr.replace(/\)/g, "\\)");
  vsStr = vsStr.replace(/\|/g, "\\|");
  vsStr = vsStr.replace(/\,/g, "\\,");
  vsStr = vsStr.replace(/\{/g, "\\{");
  vsStr = vsStr.replace(/\}/g, "\\}");
  vsStr = vsStr.replace(/\[/g, "\\[");
  vsStr = vsStr.replace(/\]/g, "\\]");
  vsStr = vsStr.replace(/\-/g, "\\-");
  
  var voReg = new RegExp(vsStr, "g");
  return this.replace(voReg, psNewStr);
};

/**
 * 스트링의 앞과 뒤에 있는 white space 를 제거. ex) var str = " abcde "; "abced" ==
 * str.trim();
 *
 * @return 앞뒤 공백이 제거된 문자열.
 * @type String
 */
String.prototype.trim = function() {
  return this.replace(/(^\s*)|(\s*$)/g, "");
};

/**
 * 메소드는 스트링 내에 있는 white space 를 모두 제거한다. ex) var str = " abc de " "abcde" ==
 * str.trimAll();
 *
 * @return 공백이 제거된 문자열.
 * @type String
 */
String.prototype.trimAll = function() {
  return this.replace(/\s*/g, "");
};

/**
 * 스트링의 특정 영역을 잘라낸다. ex) var str = "abcde"; "abe" == str.cut(2, 2);
 *
 * @param {Number}
 *          pnStart 시작지점.
 * @param {Number}
 *          pnLength 시작지점으로 부터 잘라낼 길이.
 * @return 변경된 문자열.
 * @type String
 */
String.prototype.cut = function(pnStart, pnLength) {
  return this.substring(0, pnStart) + this.substr(pnStart + pnLength);
};

/**
 * 스트링의 특정 영역에 주어진 스트링을 삽입한다. ex) var str = "abcde" "abcxyzde" == str.insert(3,
 * "xyz");
 *
 * @param {Number}
 *          pnIndex 삽입할 위치. 해당 스트링의 index 바로 앞에 삽입된다. index는 0부터 시작.
 * @param {String}
 *          psStr 삽일할 스트링.
 * @return 삽입된 스트링.
 * @type String
 */
String.prototype.insert = function(pnIndex, psStr) {
  return this.substring(0, pnIndex) + psStr + this.substr(pnIndex);
};

/**
 * String.split() 와 같지만 여러가지 옵션을 줄 수 있다. option list - i : ignored split 구분자 문자
 * 앞에 "\" 가 붙어있을 때는 구분자로 인식하지 않는다.('\' 문자를 string으로 표현할 때는 "\\" 로 해야함) ex) var
 * str = "abc,de\\,fg"; var strArr = str.advancedSplit(",", "i"); 위의 예에서
 * strArr[0]는 "abc", strArr[1]는 "de,fg"가 된다. - t : trimed split split 후에 splited
 * string 들을 trim 시킨다. ex) var str = "abc, de,fg" var strArr =
 * str.advancedSplit(",", "t"); 위의 예에서 strArr[0]는 "abc", strArr[1]는 "de",
 * strArr[2]는 "fg"가 된다. 옵션들은 복합적으로 사용될 수 있다. ex) var str = "abc, de\\,fg"; var
 * strArr = str.advancedSplit(",", "it"); 위의 예에서 strArr[0]는 "abc", strArr[1]는
 * "de,fg"가 된다.
 *
 * @param {String}
 *          psDelim 구분자.
 * @param {String}
 *          vsOptions 옵션.
 * @return 처리된 문자열.
 * @type String
 */
String.prototype.advancedSplit = function(psDelim, vsOptions) {
  if ((vsOptions == null) || (vsOptions.trim() == "")) {
    return this.split(psDelim);
  }
  
  var vbOptionI = false;
  var vbOptionT = false;
  
  vsOptions = vsOptions.trim().toUpperCase();
  
  for (var i = 0; i < vsOptions.length; i++) {
    if (vsOptions.charAt(i) == 'I') {
      vbOptionI = true;
    } else if (vsOptions.charAt(i) == 'T') {
      vbOptionT = true;
    }
  }
  
  var vaArr = new Array();
  var vnCnt = 0;
  var vnStartIdx = 0;
  var vnDelimIdx = - 1;
  var vsStr = this;
  
  while ((vnDelimIdx = (vsStr == null) ? - 1 : vsStr
  .indexOf(psDelim, vnStartIdx)) != - 1) {
    
    if (vbOptionI && (vsStr.substr(vnDelimIdx - 1, 2) == '\\' + psDelim)) {
      vsStr = vsStr.cut(vnDelimIdx - 1, 1);
      vnStartIdx = vnDelimIdx;
      continue;
    }
    
    vaArr [vnCnt++] = vbOptionT ? vsStr.substring(0, vnDelimIdx).trim() : vsStr
    .substring(0, vnDelimIdx);
    vsStr = vsStr.substr(vnDelimIdx + 1);
    vnStartIdx = 0;
  }
  
  vaArr [vnCnt] = (vsStr == null) ? "" : vsStr;
  
  return vaArr;
};

/**
 * 개행 문자열로 변환.
 *
 * @param {String}
 *          psaArg 변환할 문자열.
 * @return 변환된 문자열.
 * @type String
 */
String.prototype.toParam = function(psaArg) {
  
  var vsReturn = "";
  
  if ((typeof (psaArg) == "undefined") || (psaArg == null)) {
    return vsReturn;
  }
  
  var vnCount = psaArg.length;
  
  if (vnCount <= 0) {
    return vsReturn;
  }
  
  vsReturn = "\"";
  for (var i = 0; i < vnCount; i++) {
    var vsTemp = psaArg [i];
    
    vsTemp = String(vsTemp);
    
    vsTemp = vsTemp.replace(/\r/g, "\\r");
    vsTemp = vsTemp.replace(/\n/g, "\\n");
    
    vsReturn += vsTemp;
    if (i < vnCount - 1) {
      vsReturn += "\", \"";
    }
  }
  vsReturn += "\"";
  
  return vsReturn;
};

/**
 * 문자열 길이 반환.
 *
 * @return 문자열 길이.
 * @type Number
 */
String.prototype.length = function() {
  return this.length;
  
};

/**
 * 숫자를 제외한 문자열 제거.
 *
 * @return 변환된 문자열.
 * @type String
 */
String.prototype.extractNumber = function() {
  var vsRtVal = "";
  vsRtVal = this.replace(/\s/g, ''); // 공백(whitespace) 제거
  vsRtVal = this.replace(/\D/g, ''); // 공백포함,숫자가 아닌 모든 문자 제거
  return vsRtVal;
};

/**
 * 입력받은 숫자를 원하는 자리수 만큼 0으로 채워준다. ex) 2220000 == "222".makeWonFormat(4, "right");
 *
 * @param {Number}
 *          pnCnt 0을 채울 횟수.
 * @param {String}
 *          psLocation 추가할 위치 "right" 또는 "left"
 * @return 변환된 문자열.
 * @type String
 */
String.prototype.makeWonFormat = function(pnCnt, psLocation) {
  var vnLen = this.length;
  var vsRtVal = this.toString();
  if ((psLocation == "") || (psLocation == null)) {
    psLocation = "right";
  }
  
  for (i = 0; i < pnCnt - vnLen; i++) {
    if (psLocation == "left") {
      vsRtVal = "0" + vsRtVal;
    } else if (psLocation == "right") {
      vsRtVal = vsRtVal + "0";
    }
  }
  return vsRtVal;
};
/**
 * 한글(2byte)인지 Check
 *
 * @return 한글인지 여부.
 * @type Boolean
 */
String.prototype.isKorean = function() {
  var i = 0;
  while (true) {
    var varCh = this.charAt(i++);
    if ((varCh == "") || (varCh == null)) {
      break;
    } else if (varCh == ' ') {
      continue;
    } else {
      var ch = escape(varCh);
      if (ch.substring(0, 2) == "%u") {
        if (ch.substring(2, 4) == "00") {
          return false;
        }
      } else if (ch.substring(0, 1) == "%") {
        if (parseInt(ch.substring(1, 3), 16) <= 127) {
          return false;
        }
      } else {
        return false;
      }
    }
  }
  return true;
};

Util.pngfix_ie_only();

/**
 * 그리드 관련 유틸 모듈
 */
UtilGrid = {
  /**
   * 그리드의 체크 박스를 전체를 체크 하거나 체크 해제 한다.
   * 이 함수가 실행 되면 page 모드가 해제 된다.
   * @param {eXria.controls.xhtml.GridEx} pcGrx 그리드 컨트롤 객체
   * @param {String} psColId 그리드의 체크될 해더 컬럼 아이디
   * @param {Boolean} pbChecked true 일경우 체크, false 일경우 체크 해제
   * @param {Boolean} pbStatus true 일경우 데이터셋 변경 이력 남김, false 일경우 데이터셋은 변경 이력 남기지 않음
   */  
  setAllSelectedCheckBox : function(pcGrx, psColId, pbChecked, pbStatus) {
    var vcGrxSub = pcGrx;
    var voDst = vcGrxSub.dataset; // poDst;
    var voBodyCol = vcGrxSub.getBodyColumn(null, psColId);
    var vsDataSetCol = voBodyCol.datasetCol;
    var vnRowCnt = voDst.getRowCnt();
    vcGrxSub.cfg.paging = "none";
    
    var vsChecked = (! !pbChecked) ? "true" : "false";
    
    for (var i = 1; i <= vnRowCnt; i++) {
      if (! !pbStatus) {
        voDst.set(i, vsDataSetCol, vsChecked);
      } else {
        voDst.simpleSet(i, vsDataSetCol, vsChecked);
      }
    }
    
    vcGrxSub.refreshData(null, null, true);
  },
  
  /**
   * 그리드의 RenderComplete 시점에 파라미터로 넘겨주 메소드를 실행하고 그 결과값을 돌려받는다.
   * @param {String} psId 그리드 식별자
   * @param {Funtion} poFunction 실행 메소드
   * @return 실행 메소드 결과 값
   * @type Object
   */  
  // processRenderCompleate : function(psId, poFunction) {
  processRenderComplete : function(psId, poFunction) {
    //a.그리드의 rowcnt , b.데이터셋 rowcnt
    // 0 0 break
    // 0 X 루프
    // break
    var vcGrx = page.getControl(psId);
    var vnGrxRowCnt = vcGrx.getRowCnt();
    var vnDstRowCnt = vcGrx.getDataRowCnt();
    
    if (vnGrxRowCnt === 0 && vnDstRowCnt === 0) {
      
    } else if (vnGrxRowCnt === 0 && vnDstRowCnt !== 0) {
      
      //var vsFunc = "UtilGrid.processRenderCompleate(\"" + psId + "\","
      // + poFunction + ")";
      
      var vsFunc = function() {
        UtilGrid.processRenderComplete(psId, poFunction);
      }
      
      setTimeout(vsFunc, 1000);
    } else {
      
    }
    
    return poFunction();
  },
  
  /**
   * 검색조건에 해당하는 데이타 건수를 반환하는 메소드
   * @param {String} psId 그리드 식별자
   * @param {Array(String)} paCondition 'and' 관계로 묶일 검색조건 문자열 저장 배열 값
   * @return 검색조건에 해당하는 데이타 건수
   * @type Number
   */  
  getSearchCnt : function(psId, paCondition) {
    var vnCnt = 0;
    var vcGrx = page.getControl(psId);
    var voDst = vcGrx.dataset;
    var vsCondition = "";
    var vnSize = paCondition.length;
    var vaState = null;
    for (var i = 0; i < vnSize; i++) {
      vaState = paCondition [i].split(":");
      if (vsCondition != "") {
        vsCondition += " and "
      }
      vaState [0] = vcGrx.getBodyColumn(null, vaState [0]).datasetCol;
      vsCondition += vaState [0] + "='" + vaState [1] + "'";
    }
    voDst.compositeFilter(vsCondition, true);
    vnCnt = voDst.getRowCnt();
    voDst.compositeFilter(vsCondition, false);
    return vnCnt;
  },
  /**
   * 주어진 그리드의 선택된 row 데이타를 바로 다음에 insert row하여 데이타를 복사해주는 메소드
   * @param {String} psGrxId 그리드 식별자
   * @param {String} psCrudTxtID 업데이트 상태 값 표시 컬럼 식별자
   * @param {Function} poFunc 데이타 복사 작업을 수행해주는 메소드.
   * null일 경우 디폴트로 모든 cell의 데이타(업데이트 상태 값 표시 컬럼 제외)를 복사해주는 메소드가 할당됨.
   * @return 추가된 Row 객체
   */  
  copyAndPasteToNext : function(psGrxId, psCrudTxtID, poFunc) {
    var vcCtl = page.getControl(psGrxId);
    var vaIdx = UtilGrid.getSelIdxsOrFRowIdx(psGrxId);
    if ((vaIdx == null) || (vaIdx.length > 1)) {
      return;
    }
    var vnIdx = vaIdx [0];
    var voRow = Common.insertRow(psGrxId, psCrudTxtID);
    if (poFunc == null) {
      poFunc = this._defaultCP;
    }
    poFunc.call(this, psGrxId, psCrudTxtID, vnIdx);
    return voRow;
  },
  /**
   * 주어진 row 인덱스의 바로 다음 row에 모든 cell의 데이타(업데이트 상태 값 표시 컬럼 제외)를 복사해주는 메소드
   * @param {String} psGrxId 그리드 식별자
   * @param {String} psCrudTxtID 업데이트 상태 값 표시 컬럼 식별자
   * @param {Number} pnIndex 데이타를 복사해올 row index
   * @private
   */  
  _defaultCP : function(psGrxId, psCrudTxtID, pnIdx) {
    var vcCtl = page.getControl(psGrxId);
    var vaColNms = this.getColNames(psGrxId);
    var voSrcRow = vcCtl.getRowIndex(pnIdx);
    var voNextRow = vcCtl.getRowIndex(pnIdx + 1);
    
    var voValue = null;
    var vnSize = vaColNms.length;
    for (var i = 0; i < vnSize; i++) {
      if (vaColNms [i] == psCrudTxtID) {
        continue;
      }
      voValue = vcCtl.getValue(voSrcRow, vaColNms [i]);
      vcCtl.setValue(voNextRow, vaColNms [i], voValue, true);
    }
  },
  /**
   * 주어진 그리드의 헤드 컬럼 id들을 배열에 담아 반환하는 메소드
   * @param {String} psGrxId 그리드 식별자
   * @return 그리드의 헤드 컬럼 id들이 담긴 배열
   * @type Array(String)
   */  
  getColNames : function(psGrxId) {
    var vaColNms = [];
    var vcCtl = page.getControl(psGrxId);
    var voCols = new Array();
    var voColumn = null;
    voCols [0] = vcCtl.header.cols ["left"];
    voCols [1] = vcCtl.header.cols ["center"];
    voCols [2] = vcCtl.header.cols ["right"];
    for (var i = 0; i < 3; i++) {
      if (voCols [i]) {
        for (var j = 0; j < voCols [i].rows.length; j++) {
          var voRow = voCols [i].rows [j];
          for (var k = 0; k < voRow.columns.length; k++) {
            voColumn = voRow.columns [k];
            if (voColumn instanceof eXria.controls.xhtml.GridEx.HeadColumn) {
              vaColNms.push(voColumn.id);
            }
          }
        }
      }
    }
    
    return vaColNms;
  },
  
  /**
   * 그리드의 특정 row의 데이타 값을 주어진 Map Node의 값으로 설정해주는 메소드
   * @param {String} psGrxId 그리드 식별자
   * @param {Number} pnIndex row 인덱스
   * @param {eXria.data.xhtml.MapNode} poMapNode 설정될 값을 저장하는 MapNode 객체
   * @param {String} psSkipCol 스킵할 그리드 헤더ID
   */  
  setRowData : function(psGrxId, pnIndex, poMapNode, psSkipCol) {
    var vcCtl = page.getControl(psGrxId);
    var voDst = vcCtl.dataset;
    var vaColId = UtilGrid.getColNames(psGrxId);
    var voRow = vcCtl.getRowIndex(pnIndex);
    pnIndex++;
    var vsColId = null;
    var voBodyCol = null;
    var vsDataSetCol = null;
    var vsValue = null;
    var voColMap = new eXria.data.ArrayMap();
    for (var j = 0; j < vaColId.length; j++) {
      vsColId = vaColId [j];
      voBodyCol = vcCtl.getBodyColumn(null, vsColId);
      vsDataSetCol = voBodyCol.datasetCol;
      voColMap.put(vsDataSetCol, "");
      if (vsColId == psSkipCol) {
        voColMap.put(vsDataSetCol, "");
        continue;
      }
      //      voControl.setValue(voRow, vsColId, vsOriginVal, true);
      vsValue = poMapNode.get(vsDataSetCol);
      voDst.simpleSet(pnIndex, vsDataSetCol, vsValue == null ? "" : vsValue);
      vsValue = vcCtl.convertValueTGrid(voBodyCol, vsValue, voRow, vsColId);
      vcCtl.grid.SetValue(voRow, vsColId, vsValue, true);
    }
    
    var vnColCnt = voDst.getColCnt();
    for (var j = 0; j < vnColCnt; j++) {
      vsDataSetCol = voDst.dataSet.getColName(j);
      if (voColMap.get(vsDataSetCol) != null) {
        continue;
      }
      vsValue = poMapNode.get(vsDataSetCol);
      voDst.simpleSet(pnIndex, vsDataSetCol, vsValue == null ? "" : vsValue);
    }
  },
  
  /**
   * 그리드의 AfterValueChanged 이벤트가 발생하지 않고 setValue를 하는 메소드
   * @param {String} psGrxId 해당 그리드 아이디
   * @param {Object} poRow 그리드 로우
   * @param {String} psColId 해당 그리드 컬럼아이디
   * @param {String} psValue 설정할 값
   */  
  setValue : function(psGrxId, poRow, psColId, psValue) {
    var vcGrx = page.getControl(psGrxId);
    var voDst = vcGrx.dataset;
    var voBodyCol = vcGrx.getBodyColumn(null, psColId);
    var vsDataSetCol = voBodyCol.datasetCol;
    var vnIndex = vcGrx.getIndexOfRow(poRow);
    // voDst.set(vnIndex + 1, vsDataSetCol, psValue == null ? "" : psValue);
    var vsValue = vcGrx.convertValueTGrid(voBodyCol, psValue, poRow, psColId);
    vcGrx.grid.EndEdit(vcGrx.grid.FRow, vcGrx.grid.FCol, true);
    vcGrx.grid.SetValue(poRow, psColId, vsValue, true);
    if (vcGrx.dataset) {
      vsValue = vcGrx.getValue(poRow, psColId);
      // null 처리 추가 허용운 2010.02.26
      vsValue = (vsValue === null) ? "" : vsValue;
      // vsValue = vcGrx.convertValueExria(poRow, psColId, vsValue);
      vcGrx.dataset.set(vnIndex + 1, vsDataSetCol, vsValue == null ? "" : vsValue);
    }
  },
  
  /**
   * 그리드 refresh 이후 현재 포커싱된 row의 포커스를 복원하기 위해 그리드의 row 식별을 위한 데이타 셋의 primary key 항목을 기록하는 메소드.
   * 일반적으로 page onLoad 이벤트 핸들러 내에서 호출됨.
   * ex) UtilGrid.setPKeyMap("grxMst");
   * @param {Array(String} paGrxId 그리드 식별자
   */  
  setPKeyMap : function(paGrxId) {
    for (var i = 0, ij = paGrxId.length; i < ij; i++) {
      var vcCtl = page.getControl(paGrxId [i]);
      vcCtl.mbFocused = false;
      var voPKeyMap = null;
      if (vcCtl.moPKeyMap) {
        voPKeyMap = vcCtl.moPKeyMap;
      } else {
        vcCtl.moPKeyMap = new eXria.data.ArrayMap();
        voPKeyMap = vcCtl.moPKeyMap;
      }
      voPKeyMap.clear();
      voDst = vcCtl.dataset;
      var vsTableName = voDst.getCRUDTableNames();
      vsTableName = vsTableName.split(",") [0]
      var vaPKeys = voDst.getPrimaryKeys(vsTableName);
      vaPKeys = vaPKeys.replace(/,$/, "");
      vaPKeys = vaPKeys.split(",");
      var vnSize = vaPKeys.length;
      var vsKey = null;
      for (var i = 0; i < vnSize; i++) {
        vsKey = vaPKeys [i].split(":");
        vsKey = vsKey [1];
        voPKeyMap.put(vsKey, "");
      }
    }
  },
  /**
   * 그리드 refresh 이후 현재 포커싱된 row의 포커스를 복원하기 위해 현재 포커스된 row의 primary key 값을 저장하는 메소드.
   * 일반적으로 그리드의 onGridexFocus 이벤트 핸들러 내에서 호출됨.
   * ex) UtilGrid.setPKeyValues(e);
   * @param {eXria.event.Event} poEvent onGridexFocus 이벤트 핸들러의 이벤트 파라미터.
   * 스크립트를 통해 직접 이 메소드를 호출시에는 다음과 같이 빈 오브젝트 생성 후
   * 거기에 그리드 row 참조 객체를 담아 파라미터로 넘긴다.
   * var voEvent = {};
   * voEvent.object = vcGrx;
   * voEvent.row = vcGrx.getRowIndex(1);
   * UtilGrid.setPKeyValues(voEvent);
   */  
  setPKeyValues : function(poEvent) {
    var vcCtl = poEvent.object;
    var vnIndex;
    if (!vcCtl.cfg.hidePanel) {
      vnIndex = vcCtl.getIndexOfRow(poEvent.row);
    } else {
      vnIndex = vcCtl.getFocusRowIndex();
    }
    vnIndex++;
    vcCtl.mbFocused = true;
    var voPKeyMap = vcCtl.moPKeyMap;
    var voDst = vcCtl.dataset;
    var voCollection = voPKeyMap.getKeyCollection();
    var vnSize = voCollection.size();
    var vsKey = null;
    var vsValue = null;
    for (var i = 0; i < vnSize; i++) {
      vsKey = voCollection.get(i);
      vsValue = voDst.get(vnIndex, vsKey);
      if (vsValue == null) {
        vsValue = "";
      }
      voPKeyMap.put(vsKey, vsValue);
    }
  },
  /**
   * 그리드 refresh 이후 이전 포커싱된 row를 찾아 포커스를 유지시켜 주는 메소드.
   * 일반적으로 page onGridexRenderComplete 이벤트 핸들러 내에서 호출됨.
   * ex) UtilGrid.restoreFocusedRow("grxMst");
   * @param {String} psGrxId 그리드 식별자
   */  
  restoreFocusedRow : function(psGrxId) {
    var vcCtl = page.getControl(psGrxId);
    if (vcCtl.mbFocused != true) {
      return;
    }
    var voPKeyMap = vcCtl.moPKeyMap;
    var voDst = vcCtl.dataset;
    var voCollection = voPKeyMap.getKeyCollection();
    var vnSize = voCollection.size();
    var vsKey = null;
    var vsValue = null;
    var vsQuery = "";
    for (var i = 0; i < vnSize; i++) {
      vsKey = voCollection.get(i);
      vsValue = voPKeyMap.get(vsKey);
      if (vsValue == null) {
        vsValue = "";
      }
      // if(vsQuery != "") vsQuery += " and ";
      // vsQuery += vsKey + "='" + vsValue + "'";
      if (vsQuery != "") {
        vsQuery += ",";
      }
      vsQuery += vsKey + ":" + vsValue;
    }
    //      var vnIndex = voDst.dataSet.compositeIdx(vsQuery);
    var vnIndex = voDst.dataSet.find(vsQuery);
    vnIndex = parseInt(vnIndex);
    if (!vcCtl.cfg.hidePanel) {
      vcCtl.selectRow(vcCtl.getRowIndex(--vnIndex));
    } else {
      vcCtl.setFocusRowIndex(--vnIndex, true);
    }
  },
  /**
   * 해당 그리드의 선택된 row 나 포커싱된 row 인덱스를 얻어오기 위한 메소드.
   * 주의 : focus된 row와 select된 row는 GridEx에서 이벤트 메카니즘이 구분되어 처리되고 있음.
   * 단일 선택 모드에서 row선택 시 click -> focus 순으로 이벤트가 발생되며,
   * 다중 행 선택 시(ctrl + click) click -> selected 순으로 이벤트가 발생됨.
   * @param {String} psGrxId 그리드 식별자
   * @return 해당 그리드의 선택된 row 나 포커싱된 row 인덱스 저장 배열
   * @type Array(Number)
   */  
  getSelIdxsOrFRowIdx : function(psGrxId) {
    var vcCtl = page.getControl(psGrxId);
    var vaSelIndex = new Array(), vnIndex = 0, vnSelIndex = 0;
    
    for (var row = vcCtl.grid.GetFirstVisible(); row; row = vcCtl.grid
    .GetNextVisible(row)) {
      if (row.Selected) {
        vaSelIndex [vnSelIndex++] = vnIndex;
      }
      vnIndex++;
    }
    if (vnSelIndex == 0) {
      var vnIndex = vcCtl.getFocusRowIndex();
      if (vnIndex !== null) {
        vaSelIndex [0] = vnIndex;
      } else {
        return null;
      }
    }
    return vaSelIndex;
  },
  /**
   * cell이나 row의 CanEdit를 설정 값 반환
   * @param {Object} poRow 조회 Row
   * @param {String} psColId 조회될 Column의 headColumn의 ID, null일경우 Row에 설정
   * @return cell이나 row의 CanEdit 설정 값
   * @type Boolean
   */  
  getCanEdit : function(poRow, psColId) {
    // old name : getCanEdit
    var vsAttrName = null;
    if (psColId) {
      vsAttrName = psColId + "CanEdit";
    } else {
      vsAttrName = "CanEdit";
    }
    
    var vbEdit = null;
    if (poRow.getAttribute) {
      vbEdit = poRow.getAttribute(vsAttrName);
    } else {
      vbEdit = poRow [vsAttrName];
    }
    if (vbEdit == null) {
      vbEdit = true;
    }
    return pbEdit;
  },
  /**
   * 지정된 그리드의 특정 컬럼들의 편집가능 여부를 설정하기 위한 메소드
   * @param {String} psGrxId 그리드 ID
   * @param {Array(String)} paCol 컬럼 ID 지정 배열
   * @param {Boolean} pbEditable 편집가능 여부
   */  
  setCanEditByCol : function(psGrxId, paCol, pbEditable) {
    var vnEditable = 0;
    if (pbEditable) {
      vnEditable = 1;
    }
    var vcCtl = page.getControl(psGrxId);
    var vaColId = paCol
    if (paCol == null) {
      vaColId = UtilGrid.getColNames(psGrxId);
    }
    var vsColId = null;
    var voBodyCol = null;
    for (var j = 0; j < vaColId.length; j++) {
      vsColId = vaColId [j];
      voBodyCol = vcCtl.getBodyColumn(null, vsColId);
      voBodyCol.canEdit = vnEditable;
    }
    vcCtl.refresh(null, null, true);
  },
  
  /**
   * 지정된 그리드의 특정 컬럼들의 편집가능 여부를 설정하기 위한 메소드
   * @param {String} psGrxId 그리드 ID
   * @param {Object} poRow 조회 Row
   * @param {Array(String)} paCol 컬럼 ID 지정 배열, null 이면 전체컬럼대상
   * @param {Boolean} pbEditable 편집가능 여부
   */  
  setCanEditByRow : function(psGrxId, poRow, paCol, pbEditable) {
    if (! !poRow) {
      var vcCtl = page.getControl(psGrxId);
      var vaColId = paCol
      if (paCol == null) {
        vaColId = UtilGrid.getColNames(psGrxId);
      }
      var vsColId = null;
      var voBodyCol = null;
      for (var j = 0; j < vaColId.length; j++) {
        vsColId = vaColId [j];
        if (poRow.setAttribute) poRow.setAttribute(vsColId + "CanEdit", pbEditable);
        voBodyCol = vcCtl.getBodyColumn(null, vsColId);
        
        if ((! !voBodyCol) && voBodyCol.type == "Date") {
          if (!pbEditable) {
            poRow ["Button"] = "None";
          } else if (voBodyCol.calendarEnable) {
            poRow ["Button"] = "Date";
          }
        }
        vcCtl.refreshRow(poRow);
      }
    }
  },
  
  /**
   * 주어진 column의 cell에서 button이 클릭되었는지 여부는 체크하는 메소드.
   * onGridexClick에서 해당 button 타입의 column에서 button의 클릭여부를 필터링하기 위해 사용.
   * @param {eXria.controls.xhtml.GridEx.event} poEvent onGridexClick 이벤트 핸들러의 이벤트 객체
   * @param {String} psColId 이벤트 체크 Column의 headColumn의 ID
   * @return 이벤트 target이 해당 cell의 버튼인지 여부
   * @type Boolean
   */  
  isCellButtonClicked : function(poEvent, psColId) {
    if (poEvent == null) {
      return false;
    }
    if (poEvent.colId != psColId) {
      return false;
    }
    var voEvent = new eXria.event.Event(poEvent.e, page.window);
    if (voEvent.target && (voEvent.target.tagName == "BUTTON")) {
      return true;
    }
    return false;
  },
  /**
   * 주어진 Url의 그리드 css 파일을 브라우저 도큐먼트에 임포트 하기 위한 메소드
   * @param {String} psUrl 임포트 대상 그리드 css 파일 url
   */  
  importGridCss : function(psUrl) {
    if (page.mbGridCssImported) {
      return;
    }
    var voLink = document.createElement("link");
    voLink.href = eXria.controls.xhtml.Util.getImagePath(psUrl, window);
    voLink.rel = "Stylesheet";
    voLink.title = "GridStyle";
    var voHead = document.getElementsByTagName("head") [0];
    if (!voHead) {
      voHead = document.createElement("head");
      document.documentElement.insertBefore(voHead, document.body);
    }
    voHead.appendChild(voLink);
    page.mbGridCssImported = true;
  },

  /**
   * 그리드 틀고정 메소드
   * 주어진 그리드의 column 을 고정한다.
   * @param {String} psGrxId 그리드 ID
   * @param {eXria.controls.xhtml.GridEx.ColsRow} poSrcRow 그리드의 컬럼 ID
   * @param {eXria.controls.xhtml.GridEx.ColsRow} psCol 그리드의 컬럼 ID   
   */
  switchRow : function(psGrxId, poSrcRow, poTrgRow) {
    if(poSrcRow == null || poTrgRow == null) return;
    var vcGrx = page.getControl(psGrxId);
    var voValue = null;
    var vaHCol = vcGrx.getHeadColumnList();
    var vnSize = vaHCol.length;
    var psCol = null;
    for(var i = 0; i < vnSize; i++) {
      psCol = vaHCol[i];
      voValue = vcGrx.getValue(poSrcRow, psCol);
      vcGrx.simpleSetValue(poSrcRow, psCol, vcGrx.getValue(poTrgRow, psCol), false);
      vcGrx.simpleSetValue(poTrgRow, psCol, voValue, false);
    }
    vcGrx.refreshRow(poSrcRow);
    vcGrx.refreshRow(poTrgRow);
  },

  /**
   * 그리드 좌측 틀고정 메소드
   * 주어진 그리드의 column 을 고정한다.
   * @param {String} psGrxId 그리드 ID
   * @param {String} psCol 그리드의 컬럼 ID
   */
  fixColsLeft : function(psGrxId, psCol) {
    var vcGrx = page.getControl(psGrxId);
    var voCols = new Array();
    voCols[0] = vcGrx.header.cols["left"];
    voCols[1] = vcGrx.header.cols["center"];
    voCols[2] = vcGrx.header.cols["right"];
    
    if(voCols[0] == null) {
      voCols[0] = vcGrx.header.createCols();
      vcGrx.header.addCols(voCols[0], "left");
      for(var i = 0; i < voCols[1].rows.length; i++) {
        voCols[0].addColsRow(voCols[0].createColsRow());
      }
    }
    
    var voLeftRow = null;
    var voCenterRow = null;
    var voRightRow = null;
    var voColumn = null;
    
    for ( var i = 0; voCols[0].rows.length > i; i++) {
      voLeftRow = voCols[0].rows[i];
      voCenterRow = voCols[1].rows[i]
      for ( var j = 0; voLeftRow.columns.length > j; j++){
        voColumn = voLeftRow.columns[j];
        voCenterRow.columns.splice(j, 0, voColumn)
      }
    }
    
    var vnFixColIdx = -1;
    var vbOver = true;
    for ( var i = 0; voCols[1].rows.length > i; i++) {
      if(i == vcGrx.header.mainRow) {
        voCenterRow = voCols[1].rows[i]
        for ( var j = 0; voCenterRow.columns.length > j; j++){
          voColumn = voCenterRow.columns[j];
          if(voColumn.id == psCol) {
            vnFixColIdx = j;
            vbOver = false;
            break;
          }
        }
        if(vbOver && voCols[2]) {
          voRightRow = voCols[2].rows[i];
          for( var j = 0; j < voRightRow.length; j++) {
            voColumn = voCenterrow.columns[j];
            if(voColumn.id == psCol) {
              vnFixColIdx = j;
            }
          }
        }
      }
    }
    
    if(vnFixColIdx == -1) return;
    
    voCols[0] = vcGrx.body.cols["left"];
    voCols[1] = vcGrx.body.cols["center"];
    if(voCols[0] == null) {
      voCols[0] = vcGrx.body.createCols();
      vcGrx.body.addCols(voCols[0], "left");
      for(var i = 0; i < voCols[1].rows.length; i++) {
        voCols[0].addColsRow(voCols[0].createColsRow());
      }
    }
    
    var voLeftRow = null;
    var voCenterRow = null;
    for ( var i = 0; voCols[0].rows.length > i; i++) {
      voLeftRow = voCols[0].rows[i];
      voCenterRow = voCols[1].rows[i]
      for ( var j = 0; voLeftRow.columns.length > j; j++){
        voColumn = voLeftRow.columns[j];
        voCenterRow.columns.splice(j, 0, voColumn)
      }
    }
    

    voCols[0] = vcGrx.header.cols["left"];
    voCols[1] = vcGrx.header.cols["center"];
    voCols[2] = vcGrx.header.cols["right"];
    var vnSize = 0;
    for ( var i = 0; voCols[0].rows.length > i; i++) {
      voLeftRow = voCols[0].rows[i];
      voCenterRow = voCols[1].rows[i];
      if(vbOver) {
        voLeftRow.columns = voCenterRow.columns;
        voCenterRow.columns = [];
        voRightRow = voCols[2].rows[i];
        voLeftRow.columns = voRightRow.columns.slice(0, vnFixColIdx + 1).concat(voLeftRow.columns);
        voRightRow.columns.splice(vnFixColIdx + 1, voRightRow.columns.length - vnFixColIdx - 1);
      } else {
        voLeftRow.columns = voCenterRow.columns.slice(0, vnFixColIdx + 1);
        voCenterRow.columns.splice(0, vnFixColIdx + 1);
      }
      vnSize = voLeftRow.columns.length;
      for(var k = 0; k < vnSize; k++) {
        voColumn = voLeftRow.columns[k];
        if(voColumn.oldClassName == null) voColumn.oldClassName = voColumn.className;
        voColumn.className = "ghc_fix";
      }
      vnSize = voCenterRow.columns.length;
      for(var k = 0; k < vnSize; k++) {
        voColumn = voCenterRow.columns[k];
        if(voColumn.oldClassName) {
          voColumn.className = voColumn.oldClassName;
          voColumn.oldClassName = null;
        }
      }
    }
    
    var voColsRow = null;
    for ( var i = 0; voCols[0].rows.length > i; i++) {
      for(var j = 0; j < 3; j++) {
        if(voCols[j] == null) continue;
        voColsRow = voCols[j].rows[i];
        vnSize = voColsRow.columns.length;
        for(var k = 0; k < vnSize; k++) {
          voColumn = voColsRow.columns[k];
          voColumn.parent = voCols[j];
        }
      }
    }
    
    voCols[0] = vcGrx.body.cols["left"];
    voCols[1] = vcGrx.body.cols["center"];
    voCols[2] = vcGrx.body.cols["right"];
    var voLeftRow = null;
    var voCenterRow = null;
    for ( var i = 0; voCols[0].rows.length > i; i++) {
      voLeftRow = voCols[0].rows[i];
      voCenterRow = voCols[1].rows[i]
      if(vbOver) {
        voLeftRow.columns = voCenterRow.columns;
        voCenterRow.columns = [];
        voRightRow.columns = voCols[2].rows[i];
        voLeftRow.columns = voRightRow.columns.slice(0, vnFixColIdx + 1).concat(voLeftRow.columns);
        voRightRow.columns.splice(vnFixColIdx + 1, voRightRow.columns.length - vnFixColIdx - 1);
      } else {
        voLeftRow.columns = voCenterRow.columns.slice(0, vnFixColIdx + 1);
        voCenterRow.columns.splice(0, vnFixColIdx + 1);
      }
    }
    
    for ( var i = 0; voCols[0].rows.length > i; i++) {
      for(var j = 0; j < 3; j++) {
        if(voCols[j] == null) continue;
        voColsRow = voCols[j].rows[i];
        vnSize = voColsRow.columns.length;
        for(var k = 0; k < vnSize; k++) {
          voColumn = voColsRow.columns[k];
          voColumn.parent = voCols[j];
        }
      }
    }
    
    vcGrx.refresh(null, null, true);
    
  },
  
  /**
   * 그리드 우측 틀고정 메소드
   * 주어진 그리드의 column 을 고정한다.
   * @param {String} psGrxId 그리드 ID
   * @param {String} psCol 그리드의 컬럼 ID
   */
  fixColsRight : function(psGrxId, psCol) {
    var vcGrx = page.getControl(psGrxId);
    var voCols = new Array();
    voCols[0] = vcGrx.header.cols["right"];
    voCols[1] = vcGrx.header.cols["center"];
    voCols[2] = vcGrx.header.cols["left"];
    if(voCols[0] == null) {
      voCols[0] = vcGrx.header.createCols();
      vcGrx.header.addCols(voCols[0], "right");
      for(var i = 0; i < voCols[1].rows.length; i++) {
        voCols[0].addColsRow(voCols[0].createColsRow());
      }
    }
    
    var voRightRow = null;
    var voCenterRow = null;
    var voLeftRow = null;
    var voColumn = null;
    
    for ( var i = 0; i < voCols[0].rows.length; i++) {
      voRightRow = voCols[0].rows[i];
      voCenterRow = voCols[1].rows[i]
      for ( var j = 0; j < voRightRow.columns.length; j++){
        voColumn = voRightRow.columns[j];
        voCenterRow.columns.push(voColumn)
      }
    }
    
    var vnFixColIdx = -1;
    var vbOver = true;
    for ( var i = 0; voCols[1].rows.length > i; i++) {
      if(i == vcGrx.header.mainRow) {
        voCenterRow = voCols[1].rows[i]
        for ( var j = 0; j < voCenterRow.columns.length; j++) {
          voColumn = voCenterRow.columns[j];
          if(voColumn.id == psCol) {
            vnFixColIdx = j
            vbOver = false;
            break;
          }          
        }
        
        if(vbOver && voCols[2]) {
          voLeftRow = voCols[2].rows[i];
          for ( var j = 0; j < voLeftRow.columns.length; j++) {
            voColumn = voLeftRow.columns[j];
            if(voColumn.id == psCol) {
              vnFixColIdx = j
              break;
            }          
          }
        }
      }
    }
    if(vnFixColIdx == -1) return;
    
    voCols[0] = vcGrx.body.cols["right"];
    voCols[1] = vcGrx.body.cols["center"];
    voCols[2] = vcGrx.body.cols["left"];
    if(voCols[0] == null) {
      voCols[0] = vcGrx.body.createCols();
      vcGrx.body.addCols(voCols[0], "right");
      for(var i = 0; i < voCols[1].rows.length; i++) {
        voCols[0].addColsRow(voCols[0].createColsRow());
      }
    }
    
   for ( var i = 0; voCols[0].rows.length > i; i++) {
      voRightRow = voCols[0].rows[i];
      voCenterRow = voCols[1].rows[i]
      for ( var j = 0; j < voRightRow.columns.length; j++){
        voColumn = voRightRow.columns[j];
        voCenterRow.columns.push(voColumn)
      }
    }
    

    voCols[0] = vcGrx.header.cols["right"];
    voCols[1] = vcGrx.header.cols["center"];
    voCols[2] = vcGrx.header.cols["left"];
    var vnSize = 0;
    for ( var i = 0; voCols[0].rows.length > i; i++) {
      voRightRow = voCols[0].rows[i];
      voCenterRow = voCols[1].rows[i];
      if(vbOver) {
        voRightRow.columns = voCenterRow.columns;
        voCenterRow.columns = [];
        voLeftRow = voCols[2].rows[i];
        voRightRow.columns = voLeftRow.columns.slice(vnFixColIdx).concat(voRightRow.columns);
        voLeftRow.columns.splice(0, vnFixColIdx + 1);
      } else {
        voRightRow.columns = voCenterRow.columns.slice(vnFixColIdx);
        voCenterRow.columns.splice(vnFixColIdx, voCenterRow.columns.length - vnFixColIdx);
      }
      vnSize = voRightRow.columns.length;
      for(var k = 0; k < vnSize; k++) {
        voColumn = voRightRow.columns[k];
        if(voColumn.oldClassName == null) voColumn.oldClassName = voColumn.className;
        voColumn.className = "ghc_fix";
      }
      vnSize = voCenterRow.columns.length;
      for(var k = 0; k < vnSize; k++) {
        voColumn = voCenterRow.columns[k];
        if(voColumn.oldClassName) {
          voColumn.className = voColumn.oldClassName;
          voColumn.oldClassName = null;
        }
      }
    }
    
    var voColsRow = null;
    for ( var i = 0; voCols[0].rows.length > i; i++) {
      for(var j = 0; j < 3; j++) {
        if(voCols[j] == null) continue;
        voColsRow = voCols[j].rows[i];
        vnSize = voColsRow.columns.length;
        for(var k = 0; k < vnSize; k++) {
          voColumn = voColsRow.columns[k];
          voColumn.parent = voCols[j];
        }
      }
    }
    
    voCols[0] = vcGrx.body.cols["right"];
    voCols[1] = vcGrx.body.cols["center"];
    voCols[2] = vcGrx.body.cols["left"];
    for ( var i = 0; voCols[0].rows.length > i; i++) {
      voRightRow = voCols[0].rows[i];
      voCenterRow = voCols[1].rows[i];
      if(vbOver) {
        voRightRow.columns = voCenterRow.columns.slice(0, voCenterRow.columns.length);
        voCenterRow.columns = [];
        voLeftRow = voCols[2].rows[i];
        voRightRow.columns = voLeftRow.columns.slice(vnFixColIdx).concat(voRightRow.columns);
        voLeftRow.columns.splice(0, vnFixColIdx + 1);
      } else {
        voRightRow.columns = voCenterRow.columns.slice(vnFixColIdx);
        voCenterRow.columns.splice(vnFixColIdx, voCenterRow.columns.length - vnFixColIdx);
      }
    }
    
    for ( var i = 0; voCols[0].rows.length > i; i++) {
      for(var j = 0; j < 3; j++) {
        if(voCols[j] == null) continue;
        voColsRow = voCols[j].rows[i];
        vnSize = voColsRow.columns.length;
        for(var k = 0; k < vnSize; k++) {
          voColumn = voColsRow.columns[k];
          voColumn.parent = voCols[j];
        }
      }
    }
    vcGrx.refresh(null, null, true);
    
  },
  
  /**
   * 그리드 틀고정 해제 메소드
   * 주어진 그리드의 column 을 고정한다.
   * @param {String} psGrxId 그리드 ID
   * @param {String} psCol 그리드의 컬럼 ID
   */
  releaseFixCols : function(psGrxId, psCol) {
    var vcGrx = page.getControl(psGrxId);
    var voCols = new Array();
    voCols[0] = vcGrx.header.cols["left"];
    voCols[1] = vcGrx.header.cols["center"];
    voCols[2] = vcGrx.header.cols["right"];
    
    var voCenterRow = null;
    var voColsRow = null;
    var voReleaseCols = null;
    var vbLeft = null;
    var voColumn = vcGrx.getHeadColumn(psCol);
    if(voColumn.parent == voCols[0]) {
      voReleaseCols = voCols[0];
      vbLeft = true;
    } else if(voColumn.parent == voCols[2]) {
      voReleaseCols = voCols[2];
      vbLeft = false;
    }
    
    if(voReleaseCols == null) return;
    
    for ( var i = 0; i < voReleaseCols.rows.length; i++) {
      voColsRow = voReleaseCols.rows[i];
      voCenterRow = voCols[1].rows[i]
      for ( var j = 0; j < voColsRow.columns.length; j++){
        voColumn = voColsRow.columns[j];
        if(voColumn.oldClassName) {
          voColumn.className = voColumn.oldClassName;
          voColumn.oldClassName = null;
        }
        if(vbLeft) {
          voCenterRow.columns.splice(j, 0, voColumn);
        } else {
          voCenterRow.columns.push(voColumn)
        }
        voColumn.parent = voCols[1];
      }
      voColsRow.columns = [];
    }
    
    if(vbLeft) voReleaseCols = vcGrx.body.cols["left"];
    else voReleaseCols = vcGrx.body.cols["right"];
    voCols[1] = vcGrx.body.cols["center"];
    for ( var i = 0; voReleaseCols.rows.length > i; i++) {
      voColsRow = voReleaseCols.rows[i];
      voCenterRow = voCols[1].rows[i];
      for ( var j = 0; j < voColsRow.columns.length; j++){
        voColumn = voColsRow.columns[j];
        if(vbLeft) {
          voCenterRow.columns.splice(j, 0, voColumn);
        } else {
          voCenterRow.columns.push(voColumn)
        }
        voColumn.parent = voCols[1];
      }
      voColsRow.columns = [];
    }
    
    vcGrx.refresh(null, null, true);
    
  }
};

/**
 * eXria 컨트롤 관련 유틸 모듈
 */
UtilControl = {
  /**
   * 트리의 특정노드의  disable 처리 여부를 결정한다.
   * 반드시 onChange 이벤트에서 사용해야한다.
   * @param {eXria.event.Event} poEvent 컨트롤 이벤트
   * @param {Boolean} pbDisabled disabled 여부
   */  
  setTreeNodeDisabled : function(poEvent, pbDisabled) {
    var voErrMsg = {};
    
    var disabledExpandChild = function(poTreeNode, pbDisabled) {
      poTreeNode.expand = true;
      var voChildrens = poTreeNode.children;
      var vnSize = voChildrens.length;
      var voChildNode = null;
      for (var i = 0; i < vnSize; i++) {
        voChildNode = voChildrens [i];
        voChildNode.expand = true;
        voChildNode.disabled = pbDisabled;
        if (voChildNode.children.length > 0) {
          disabledExpandChild(voChildNode, pbDisabled);
        }
      }
    };
    
    try {
      
      if (!poEvent || null === pbDisabled || undefined === pbDisabled) {
        voErrMsg.name = "UtilControl.setTreeNodeDisabled"
        voErrMsg.message = "poEvent 혹은 pbDisabled 가 null 이거나 공백 입니다."
        throw voErrMsg;
      }
      
      if ('boolean' !== typeof (pbDisabled)) {
        voErrMsg.name = "UtilControl.setTreeNodeDisabled"
        voErrMsg.message = "pbDisabled는 반드시 Boolean 타입이어야 합니다."
        throw voErrMsg;
      }
      
      var voTreeNode = poEvent.object;
      var voTree = voTreeNode.tree;
      
      voTreeNode.disabled = pbDisabled;
      disabledExpandChild(voTreeNode, pbDisabled);
      
      voTree.addChangedNode(voTree.root);
      voTree.repaint();
    } catch (err) {
      //      alert("UtilControl"+ "\n" +
      // "method : " + err.name + "\n" +
      // "message : " + err.message);
      ComMsg.showMsg("co.error.formfieldmake", [err.name, err.message]);
    }
  },
  
  /**
   * 트리에 체크 박스가 존재 하는 경우 부모 체크박스의 선택여부에 따라 자식 노드 전체 선택, 선택해제
   * 반드시 onChange 이벤트에서 사용해야한다.
   * @param {eXria.event.Event} poEvent 컨트롤 이벤트
   */  
  setTreeCheckBoxChecked : function(poEvent) {
    var voErrMsg = {};
    
    function selAndExpandChild(poTreeNode) {
      poTreeNode.expand = true;
      voTree.selectedItems.put(poTreeNode.index, poTreeNode);
      var voChildrens = poTreeNode.children;
      var vnSize = voChildrens.length;
      var voChildNode = null;
      for (var i = 0; i < vnSize; i++) {
        voChildNode = voChildrens [i];
        voChildNode.expand = true;
        voTree.selectedItems.put(voChildNode.index, voChildNode);
        if (voChildNode.children.length > 0) {
          selAndExpandChild(voChildNode);
        }
      }
    }
    ;
    
    function unSelAndExpandChild(poTreeNode) {
      poTreeNode.expand = false;
      voTree.selectedItems.remove(poTreeNode.index);
      var voChildrens = poTreeNode.children;
      var vnSize = voChildrens.length;
      var voChildNode = null;
      for (var i = 0; i < vnSize; i++) {
        voChildNode = voChildrens [i];
        voChildNode.expand = true;
        voTree.selectedItems.remove(voChildNode.index);
        if (voChildNode.children.length > 0) {
          unSelAndExpandChild(voChildNode);
        }
      }
    }
    ;
    
    if (!poEvent) {
      return false;
    }
    
    var vcCtrl = poEvent.object;
    var vsId = vcCtrl.tree.id;
    var voDocument = vcCtrl.tree.document;
    var vnIndex = vcCtrl.index;
    
    var voTreeNode = vcCtrl;
    var voTree = voTreeNode.tree;
    
    voDiv = voDocument.getElementById(vsId + "_node" + vnIndex);
    var voChkCtrl = vcCtrl.tree.getSubCtrl("input", voDiv, voDocument);
    
    if (voChkCtrl.checked) {
      selAndExpandChild(voTreeNode);
    } else {
      unSelAndExpandChild(voTreeNode);
    }
    
    voTree.addChangedNode(voTree.root);
    voTree.repaint();
  },
  

  /**
   * 트리에 체크 박스가 존재 하는 경우 자식 체크박스의 선택여부에 따라 자식 노드 전체 선택, 선택해제
   * 반드시 onChange 이벤트에서 사용해야한다.
   * @param {eXria.event.Event} poEvent 컨트롤 이벤트
   */  
   setParentTreeCheckBoxChecked : function(poEvent) {
    var voErrMsg = {}; 
    function selAndExpandParent(poTreeNode) { 
      voTree.selectedItems.put(poTreeNode.index, poTreeNode);
      var voParentNode = poTreeNode.parent; 
	    if (null != voParentNode) {
         voParentNode.expand = true;
         voTree.selectedItems.put(voParentNode.index, voParentNode);
		} 
    };
    
    function unSelAndExpandParent(poTreeNode) { 
      voTree.selectedItems.remove(poTreeNode.index);
      var voParentNode = poTreeNode.parent; 
      voTree.selectedItems.remove(voParentNode.index);
      
    } ;
    
    if (!poEvent) {
      return false;
    }
   
    var vcCtrl = poEvent.object;
    var vsId = vcCtrl.tree.id;
    var voDocument = vcCtrl.tree.document;
    var vnIndex = vcCtrl.index;
    
    var voTreeNode = vcCtrl;
    var voTree = voTreeNode.tree;
    
    voDiv = voDocument.getElementById(vsId + "_node" + vnIndex);
    var voChkCtrl = vcCtrl.tree.getSubCtrl("input", voDiv, voDocument);
    
    if (voChkCtrl.checked) { 
      selAndExpandParent(voTreeNode);
    } else { 
      unSelAndExpandParent(voTreeNode);
    }
    
    voTree.addChangedNode(voTree.root);
    voTree.repaint();
  },
  
  /**
   * 주어진 2개의 DateInput 컨트롤 아이디 간의 날짜를 비교 하여 잘못된 기간일 경우
   * Layered 메세지 팝업을 띄우고 값을 지운다.
   * @param {String} psStartDate 첫번재 달력 컨트롤 아이디
   * @param {String} psEndDate 두번째 달력 컨트롤 아이디
   * @param {Json} poJson 메세지 창에 구분자로 보여질 문자열
   * ex) {"startDate" : "시작일", "endDate" : "종료일"}
   */  
  setDateCompare : function(psStartDate, psEndDate, poJson) {
    var vaCtrls = [psStartDate, psEndDate];
    var vsEvent = "onchange";
    
    if (!poJson) {
      poJson = {};
      poJson.startDate = "시작일";
      poJson.endDate = "종료일";
    }
    
    for (var i = 0; i < vaCtrls.length; i++) {
      var vcInnerDip = page.getControl(vaCtrls [i]);
      var vsTargetFunc = "" + "var vnStart = Number(page.getControl('"
      + psStartDate + "').getValue());"
      + "var vnEnd = Number(page.getControl('" + psEndDate
      + "').getValue());" + "if(!vnStart || !vnEnd){" + " return;" + "}"
      + "if(vnStart > vnEnd){"
      + "  ComMsg.showLayeredMsg('co.error.period', ['" + poJson.startDate
      + "','" + poJson.endDate + "']);" + "  e.object.setValue('');"
      + "  return;" + "}";
      
      // 혹시 변경될지 모르니 기존에 등록된 이벤트를 백업하는 로직 추가
      if (typeof (vcInnerDip [vsEvent]) === 'function') {
        var vsFunc = vcInnerDip [vsEvent].toString();
        var vnStIdx = vsFunc.indexOf("{") + 1;
        var vnEdIdx = vsFunc.lastIndexOf("}");
        
        vsFunc = vsFunc.substring(vnStIdx, vnEdIdx);
        vsTargetFunc = vsTargetFunc + vsFunc;
      }
      eval("vcInnerDip[vsEvent]=function(e) {" + vsTargetFunc + "};");
      vcInnerDip.refresh();
    }
  },
  
  /**
   * 주어진 값들을 갖는 메뉴 아이템들의 활성화 여부를 설정해주는 메소드
   * @param {String} psMenuId 컨텍스트메뉴 컨트롤 식별자
   * @param {Array(String)} paItemValue 활성화 대상 메뉴 아이템의 value 값들을 담은 배열
   * @param {Boolean} pbEnable 메뉴 아이템 활성화 여부
   */  
  setEnableMenuItem : function(psMenuId, paItemValue, pbEnable) {
    var vcCtl = page.getControl(psMenuId);
    var vsItemId = null;
    var voMenuItem = null;
    var vnSize = paItemValue.length;
    var vsItemValue = null;
    for (var i = 0; i < vnSize; i++) {
      vsItemValue = paItemValue [i];
      vsItemId = psMenuId + "_item_" + vsItemValue;
      voMenuItem = vcCtl.getItemById(vsItemId);
      voMenuItem.disabled = pbEnable ? false : true;
    }
    vcCtl.refresh();
  },
  /**
   * 주어진 id를 갖는 컨텍스트 메뉴를 지정된 위치에 표시해주는 메소드.
   * 이 메소드를 통해 컨텍스트 메뉴를 호출하는 것은 eXria 클라이언트 프레임워크의 기본적인 기능을 변형한
   * 것이므로 컨트롤에 바인딩될 수 없습니다.
   * @param {String} psMenuId 컨텍스트메뉴 컨트롤 식별자 .
   * @param {Number} pnX 컨텍스트 메뉴 좌상단 꼭지점의 x좌표
   * @param {Number} pnY 컨텍스트 메뉴 좌상단 꼭지점의 y좌표
   */  
  showContextMenu : function(psMenuId, pnX, pnY) {
    var voCanvas = page.canvas;
    voCanvas.showContextMenu(null, psMenuId, pnX, pnY);
    voCanvas.selectedContextMenuId = null;
    voCanvas.collapseControl = null;
    
    var vcCtl = page.getControl(psMenuId);
    if (vcCtl.mbOverride == null) {
      vcCtl.finalclick = function(e) {
        voCanvas.selectedContextMenuId = psMenuId;
        voCanvas.collapseControl = vcCtl;
        voCanvas.hideContextMenu();
      };
      vcCtl.mbOverride = true;
    }
  },
  
  /**
   * 컨트롤의 onchange 이벤트가 발생하지 않고 setValue를 하는 메소드
   * @param {String} psId 해당 컨트롤 아이디
   * @param {Object} poValue 컨트롤에 설정할 값
   */  
  setValue : function(psId, poValue) {
    var vcCtl = page.getControl(psId);
    if (vcCtl == null) {
      return;
    }
    var vsType = vcCtl.toString();
    switch (vsType) {
      case "InputBox" :
      case "DateInput" :
      case "EditMask" :
      vcCtl.onchangeInitValue = undefined;
      vcCtl.setValue(poValue);
      break;
      default :
      vcCtl.setValue(poValue);
    }
  },
  /**
   * userAttr에 설정된 값이 메세지 객체이거나 컨트롤 id일 경우 해당 메세제 객체나 컨트롤의 값을 바로 얻어오기 위한 메소드
   * @param {String} psId 컨트롤 아이디
   * @return userAttr에 설정된 값이 메세지 객체이거나 컨트롤 id일 경우의 해당 메세제 객체나 컨트롤의 값
   * @type Object|String
   */  
  evalUserAttr : function(psId) {
    var vcCtl = page.getControl(psId);
    var voRet = vcCtl.userAttr;
    if (page.getControl(voRet) != null) {
      //해당 컨트롤이 존재할 경우
      voRet = page.getControl(voRet).getValue();
    } else if (voRet.indexOf("NLS.") == 0) {
      voRet = eval(voRet);
    }
    return voRet;
  },
  /**
   * 라벨 컨트롤의 필수 항목 체크 표현을 구현하는 메소드
   * @param {eXria.controls.xhtml.Label} pcCtl 라벨 컨트롤
   * @param {HTMLElement} poDiv 라벨이 표시될 HTML Element 객체
   * @param {String} psLbl 라벨 텍스트
   */  
  makeLblNec : function(pcCtl, poDiv, psLbl) {
    var vsTable = "<table width=\"100%\"><tr><td width=\"90%\">";
    vsTable += psLbl;
    vsTable += "</td><td width=\"10%\" style=\"color:red;\">*</td></tr><table>";
    poDiv.innerHTML = vsTable;
  },
  /**
   * 라벨 컨트롤의 필수 항목 체크 표현을 구현하는 메소드
   * @param {eXria.controls.xhtml.Label} pcCtl 라벨 컨트롤
   * @param {HTMLElement} poDiv 라벨이 표시될 HTML Element 객체
   * @param {String} psLbl 라벨 텍스트
   */  
  makeLblNec : function(pcCtl, poDiv, psLbl) {
	if(psLbl == null) psLbl = "";
	psLbl = psLbl.replace(/</g, "&lt;");
	psLbl = psLbl.replace(/>/g, "&gt;");
	psLbl = psLbl.replace(/\n/g, "<br>");  
	psLbl = psLbl.replace(/\s/g, "&nbsp;");  
	poDiv.innerHTML = "* " + psLbl;
  },
  /**
   * 대상 HTMLElement에 Fade in out 효과를 나타내는 메소드
   * @param {eXria.form.Page} poPage 페이지 객체
   * @param {String|HTMLElement} psCtrlId fadeInOut 이 적용될 컨트롤 아이디 or 컨트롤의 HTMLElement
   * @param {Boolean} pbShow Fade in 여부 (defalut true)
   */  
  ctrlFadeInOut : function(poPage, psCtrlId, pbShow) {
    
    var voElement;
    if ("string" === typeof (psCtrlId)) {
      voElement = poPage.getControl(psCtrlId).ctrl;
    } else {
      voElement = psCtrlId;
    }
    var TimeToFade = 1000.0;
    
    if (!pbShow) {
      voElement.FadeState = 2;
      voElement.style.opacity = 1;
    } else {
      voElement.FadeState = - 2;
      voElement.style.opacity = 0;
    }
    
    if (voElement.FadeState == null) {
      if ((voElement.style.opacity == null) || (voElement.style.opacity == '')
      || (voElement.style.opacity == '1')) {
        voElement.FadeState = 2;
      }
    }
    
    //alert(voElement.FadeState);
    
    if ((voElement.FadeState == 1) || (voElement.FadeState == - 1)) {
      voElement.FadeState = voElement.FadeState == 1 ? - 1 : 1;
      voElement.FadeTimeLeft = TimeToFade - voElement.FadeTimeLeft;
    } else {
      voElement.FadeState = voElement.FadeState == 2 ? - 1 : 1;
      voElement.FadeTimeLeft = TimeToFade;
      
      var voFunc = function() {
        UtilControl._ctrlAnimateFade(new Date().getTime(), voElement);
      };
      
      setTimeout(voFunc, 33);
    }
    
  },
  /**
   * 대상 HTMLElement에 Fade in out 효과를 나타내기 위해 일정시간 동안 반복적으로 호출되는 내부 메소드
   * @param {Number} pnLastTick 마지막으로 이 메소드가 호출된 시간
   * @param {HTMLElement} psCtrlId fadeInOut 이 적용될 컨트롤의 HTMLElement
   */  
  _ctrlAnimateFade : function(pnLastTick, poElement) {
    var curTick = new Date().getTime();
    var elapsedTicks = curTick - pnLastTick;
    var TimeToFade = 1000.0;
    
    var voElement = poElement;
    
    if (voElement.FadeTimeLeft <= elapsedTicks) {
      //      alert(voElement.FadeState)
      voElement.style.opacity = voElement.FadeState == 1 ? '1' : '0';
      voElement.style.filter = 'alpha(opacity = ' + (voElement.FadeState == 1 ? '100'
      : '0') + ')';
      voElement.FadeState = voElement.FadeState == 1 ? 2 : - 2;
      // alert(voElement.FadeState)
      return;
    }
    
    voElement.FadeTimeLeft -= elapsedTicks;
    var newOpVal = voElement.FadeTimeLeft / TimeToFade;
    if (voElement.FadeState == 1) {
      newOpVal = 1 - newOpVal;
    }
    
    voElement.style.opacity = newOpVal;
    voElement.style.filter = 'alpha(opacity = ' + (newOpVal * 100) + ')';
    
    var voFunc = function() {
      UtilControl._ctrlAnimateFade(curTick, voElement);
    };
    
    setTimeout(voFunc, 33);
  }
};

/**
 * 데이타셋 관련 유틸 모듈
 */
UtilDataSet = {
  /**
   * 주어진 그리드의 선택된 row 데이타를 바로 다음에 insert row하여 데이타를 복사해주는 메소드
   * @param {String} psDstId 데이타셋 식별자
   * @param {String} pnTrgIndex 삽입될 데이타셋의 row index(주의: dataset의 기저 인덱스는 1임)
   * @param {Number} pnSrcIndex 데이타가 복사될 row의 인덱스(생략가능. 생략 시 데이타 copy작업을 수행하지 않음).
   * pnSrcIndex는 insert이전 시점에서의 인덱스임.
   */  
  copyAndInsert : function(psDstId, pnTrgIndex, pnSrcIndex) {
    var voDst = page.getDataSet(psDstId);
    var vnColCnt = voDst.getColCnt();
    voDst.insertRow(pnTrgIndex, false);
    if (pnSrcIndex != null) {
      if (pnSrcIndex >= pnTrgIndex) {
        pnSrcIndex++;
      }
      for (var j = 0; j < vnColCnt; j++) {
        vsDataSetCol = voDst.dataSet.getColName(j);
        vsValue = voDst.get(pnSrcIndex, vsDataSetCol);
        voDst.set(pnTrgIndex, vsDataSetCol, vsValue == null ? "" : vsValue);
      }
    }
  },
  /**
   * dataset의 request CRUDTable 정보 구성.
   * @param {String} psDstId 데이타셋 식별자
   * @param {Array(String)} paTable CRUD 테이블명 저장 배열
   * @param {Array(String)} paPrefix CRUD 테이블 prefix 저장 배열
   * @param {Array(String)} paKColsList ","을 구분자로 한 primary key 컬럼리스트 문자열 저장 배열
   * @param {Array(String)} paColsList ","을 구분자로 한 업데이트 컬럼리스트 문자열 저장 배열
   */  
  configureCRUD : function(psDstId, paTable, paPrefix, paKColsList, paColsList) {
    var voDst = page.model.getDataSet(psDstId);
    var vnTableCnt = paTable.length;
    var vaKCols = null;
    var vaCols = null;
    var vnColCnt = null;
    var vaCol = null;
    for (var i = 0; i < vnTableCnt; i++) {
      voDst.addCRUDTable(paTable [i]);
      voDst.setPrefix(paTable [i], paPrefix [i]);
      
      vaCols = paKColsList [i].split(",")
      vnColCnt = vaCols.length;
      for (var j = 0; j < vnColCnt; j++) {
        if (vaCols [j] != "") {
          vaCol = vaCols [j].split(":")
          voDst.addPrimaryKey(paTable [i], vaCol [0], vaCol [1]);
        }
      }
      
      vaCols = paColsList [i].split(",")
      vnColCnt = vaCols.length;
      for (var j = 0; j < vnColCnt; j++) {
        if (vaCols [j] == "") {
          continue;
        }
        vaCol = vaCols [j].split(":")
        voDst.addUpdateColumn(paTable [i], vaCol [0], vaCol [1]);
      }
    }
  },
  /**
   * 주어진 dataset으로부터 CRUD 정보를 참조해 오기 위한 메소드
   * @param {eXria.data.plugin.DataSetCmd} poDst 정보 추출 대상 데이타셋
   * @param {Array(String)} paTable CRUD 테이블명 리스트가 저장될 배열
   * @param {Array(String)} paPrefix CRUD 테이블 prefix가 저장될 배열
   * @param {Array(String)} paKColsList ","을 구분자로 한 primary key 컬럼리스트 문자열 목록이 저장될 배열
   * @param {Array(String)} paColsList ","을 구분자로 한 업데이트 컬럼리스트 문자열 목록이 저장될 배열
   */  
  getCRUDInfo : function(poDst, paTable, paPrefix, paKColsList, paColsList) {
    var vsTableList = poDst.getCRUDTableNames().replace(/,$/, "");
    var vaTable = vsTableList.split(",");
    var vnCnt = vaTable.length;
    for (var i = 0; i < vnCnt; i++) {
      paTable.push(vaTable [i]);
      paPrefix.push(poDst.getPrefix(vaTable [i]));
    }
    vnCnt = paTable.length;
    for (var i = 0; i < vnCnt; i++) {
      paKColsList.push(poDst.getPrimaryKeys(paTable [i]).replace(/,$/, ""))
      paColsList.push(poDst.getUpdateCols(paTable [i]).replace(/,$/, ""));
    }
  },
  /**
   * DataSet컬럼명을  Export될 Excel의 컬럼명으로 하여  Dataset을 Excel파일로 export 한다.
   * @param {eXria.data.plugin.DataSetCmd} poDst 정보 추출 대상 데이타셋(필수)
   * @param {String} psFileName 화일명
   * @param {Boolean} pbHeader Header 유무, false가 넘어올 경우에만 Header를 출력하지 않음
   * @param {Number} pnStartIdx export할 시작 Index
   * @param {Number} pnEndIdx export할 마지막 Index
   * @param {Array} paExcluColIds 제외될 dataSetColId, 여러개일 경우 쉼표로 구분.
   * ex) ["colId1" ,"colId2", "label1"]
   * @param {Json} poColIdLabel 데이터셋과 매핑될 컬럼라벨명, 여러개일 경우 쉼표로 구분.
   * ex) {"colId1":"라벨1","colId2":"라벨2","colId3":"라벨3"}
   * @type Boolean
   * @return Export 성공 유무
   */  
  exportExcel : function(poDst, psFileName, pbHeader, pnStartIdx, pnEndIdx,
  paExcluColIds, poColIdLabel) {
    
    if (!poDst) {
      return false;
    }
    var voModel = page.model;
    var voPlugin = voModel.plugin;
    var voFSO = voModel.getFileSystemObject();
    var vsFileName = psFileName;
    if (!vsFileName) {
      vsFileName = 'hasNoName';
    }
    psPath = voFSO.showFilePicker("Export Excel File", vsFileName + ".xls",
    "excel (*.xls)|*.xls|", 4);
    if (!psPath) {
      return false;
    }
    
    function getColIdsToStr(poDst) {
      var voDst = poDst;
      var vnConCnt = voDst.getColCnt();
      var vsColStr = "";
      
      for (var i = 1; i <= vnConCnt; i++) {
        vsColStr = vsColStr + voDst.getColName(i) + ",";
      }
      
      return vsColStr.substring(0, vsColStr.length - 1);
    }
    ;
    
    try {
      var conn = voPlugin.getConnection(poDst.id + "conn",
      voPlugin.ETBDATASETSOURCE, poDst.id, voPlugin.ETBEXCELFILESOURCE, "",
      psPath);
      var comm = conn.getCommand(poDst.id + "conn");
      comm.changeTarget(voPlugin.ETBEXCELFILESOURCE, "", psPath);
      
      var vsExcluColIds = paExcluColIds;
      var vsColIds = getColIdsToStr(poDst);
      
      if (! !vsExcluColIds) {
        
        var vaTmp = vsColIds.split(",");
        var vaRtn = [];
        vsExcluColIds = vsExcluColIds.join();
        
        var vnLength = vaTmp.length;
        for (var k = 0; k < vnLength; k++) {
          var vsTmpStr = vaTmp [k];
          
          if (- 1 === vsExcluColIds.indexOf(vsTmpStr)) {
            vaRtn.push(vsTmpStr);
          }
        }
        
        //넣음 데이터만 나오게함
        vsColIds = vaRtn.join(",");
      }
      
      var vnExecConst = comm.ETBFIELDNAMENEW | comm.ETBDATAREPLACE;
      var vaTmpColRef = [];
      
      if (pbHeader != false) {
        vnExecConst = vnExecConst | comm.ETBFIRSTROWFIELD_TGT;
      }
      
      if (! !poColIdLabel) {
        var voDst = poDst;
        var vnConCnt = voDst.getColCnt();
        var vsColRef;
        var vsTitle;
        for (var i = 1; i <= vnConCnt; i++) {
          vsColRef = voDst.getColName(i);
          vsTitle = poColIdLabel [vsColRef]
          if (!vsTitle) {
            continue;
          }
          
          comm.setFieldMatch(vsColRef, vsTitle);
        }
      }
      
      comm.setColSeq(vsColIds);
      if (pnStartIdx) {
        comm.setMinRow(pnStartIdx);
      }
      if (pnEndIdx) {
        comm.setMaxRow(pnEndIdx);
      }
      comm.executeQuery(vnExecConst);
      comm.setColSeq("");
      conn.close();
      
    } catch (e) {
      return false;
    }
    return true;
    
  }
  
};

/**
 * DialogUtil openDialog() 호출로 그리드나 마우스 커서 위치에서 새로운 영역을 생성한다. 영역에 원하는 컨트롤들을 올릴 수
 * 있다.
 *
 * @author Choe, Hyeon jong
 * @version 1.0
 * @constructor
 */
UtilDialog = {
  /**
   * 영역에 생긴 컨트롤을 삭제한다.
   * @param {eXria.form.Page} poPage (생략가능) 페이지 객체
   * @private
   */  
  removeDialogCtrl : function(poPage, poGrp) {
    //dialog 삭제
    if (!poPage) {
      poPage = page;
    }
    if (poGrp) {
      var voCtrl = poGrp.ctrl;
      voCtrl.style.display = "none";
      voCtrl.parentNode.removeChild(voCtrl);
      poPage.canvas.ctrl.appendChild(voCtrl);
    }
    var voOuterGroup = poPage.getControl("dialog_outer_group");
    if (voOuterGroup) {
      poPage.canvas.removeControl("dialog_outer_group");
    }
    var voShadow = poPage.getControl("dialog_shadow_rectangle");
    if (voShadow) {
      poPage.canvas.removeControl("dialog_shadow_rectangle");
    }
    var voBackgroundRect = poPage.getControl("dialog_background_rectangle");
    if (voBackgroundRect) {
      poPage.canvas.removeControl("dialog_background_rectangle");
    }
  },
  
  /**
   * 화면에 얇은 투명막을 씌운다.
   * @private
   */  
  createBackGround : function() {
    var voCanvas = page.canvas;
    // 백그라운드에 rectangle로 씌움
    {
      var objBackgroundRect = voCanvas.createControl("rectangle",
      "dialog_background_rectangle_BG", 0, 0, voCanvas.width,
      voCanvas.height);
      objBackgroundRect.zIndex = 10000;
      objBackgroundRect.fillType = "solid";
      objBackgroundRect.fillStartColor = "#FFFFFF";
      objBackgroundRect.fillOpacity = 40;
      objBackgroundRect.penWeight = 0;
      voCanvas.appendControl(objBackgroundRect);
    }
  },
  /**
   * 백그라운드 영역을 제거하는 내부 메소드
   * @private
   */  
  removeBackGround : function() {
    var voRectBody = page.getControl("dialog_background_rectangle_BG");
    if (voRectBody) {
      page.canvas.removeControl("dialog_background_rectangle_BG");
    }
  },
  
  /**
   * 새로운 영역을 생성한다.
   * @member UtilDialog
   * @param {Number} pnWidth 전체 영역 넓이
   * @param {Number} pnHeight 전체 영역 높이
   * @param {Number} pnPosition 생성좌표옵션
   *                      1: canvas의 중앙(뒤에 넘어오는 pnLeft, pnTop 무시)
   *                      2: 클릭좌표가 top, left로 설정(뒤에 넘어오는 pnLeft, pnTop 무시)
   *                      3: 사용자가 입력한 파라메타
   * @param {Number} pnLeft 좌표값
   * @param {Number} pnTop 좌표값
   * @param {String} psTitle 해당 영역의 타이틀
   * @param {Array} poControls 영역에 생성할 컨트롤 오브젝트 배열(아이디 x)
   * @param {event} e 일반 컨트롤 이벤트, 그리드 이벤트는 제외.
   * @param {Boolean} 하단에 Ok, Cancel 버튼의 유무
   * @type void
   * @author Administrator at 09. 11. 11 오후 1:57
   */  
  openDialog : function(pnWidth, pnHeight, pnPosition, pnLeft, pnTop, psTitle,
  poControls, e, pbBtn, poGrp) {
    var voCanvas = page.canvas;
    var voObject = e.object;
    if (poGrp) {
      pnWidth = poGrp.width + 10;
      pnHeight = poGrp.height + 60;
    }
    
    /**
     * 포커스 된 셀의 위치를 얻어오는 메소드
     *
     * @param {Object}
     *          poElement 포커스 된 셀 오브젝트
     * @type return_Object
     * @return
     * @author Administrator at 09. 11. 18 오후 5:48
     */    
    var getFCelPos = function(poElement) {
      var pnX = 0;
      var pnY = 0;
      var pnWidth = poElement.offsetWidth;
      var voParent = poElement;
      var voBody = voObject.window.document.body;
      var vnCnt = 0;
      while (voParent != voBody) {
        pnX += voParent.offsetLeft;
        pnX -= voParent.scrollLeft;
        if ((voParent.tagName != "TD") && (voParent.tagName != "TABLE")) {
          pnY += voParent.offsetTop;
        }
        if (voParent.id == voObject.id) {
          pnX += voParent.parentNode.offsetLeft;
          voParent = voParent.parentNode.parentNode;
          pnX += voParent.offsetLeft;
          pnY += voParent.offsetTop;
          break;
        }
        voParent = voParent.parentNode;
      }
      
      return {
        x : pnX + pnWidth,
        y : pnY
      };
    };
    
    if (pnPosition == 1) {
      //center
      pnLeft = (voCanvas.width / 2) - (pnWidth / 2);
      pnTop = (voCanvas.height / 2) - (pnHeight / 2);
    } else if (pnPosition == 2) {
      //마우스 클릭 위치
      if (e.object.toString() == "GridEx") {
        var vnScrollTop = voObject.grid.GetScrollTop();
        if (e.row && e.colId) {
          var voElement = voObject.getCell(e.row, e.colId, 2);
          if (voElement == null) {
            voElement = voObject.getCell(e.row, e.colId, 1);
          }
          var voPos = getFCelPos(voElement);
          pnLeft = voPos.x;
          pnTop = voPos.y - vnScrollTop;
        } else if (e.x == null) {
          pnLeft = (voCanvas.width / 2) - (pnWidth / 2);
          pnTop = (voCanvas.height / 2) - (pnHeight / 2);
        } else {
          pnLeft = e.x;
          pnTop = e.y;
        }
      } else {
        var event = e || window.event;
        
        var mouseX = event.clientX;
        var mouseY = event.clientY;
        
        var dd = document.documentElement;
        var db = document.body;
        if (dd) {
          mouseX += dd.scrollLeft;
          mouseY += dd.scrollTop;
        } else if (db) {
          mouseX += db.scrollLeft;
          mouseY += db.scrollTop;
        }
        pnTop = mouseY;
        pnLeft = mouseX;
      }
    }
    if (pnTop < 0) {
      pnTop = 0;
    }
    if ((pnTop + pnHeight) > voCanvas.height) {
      pnTop = voCanvas.height - pnHeight;
    }
    if (pnLeft < 0) {
      pnLeft = 0;
    }
    if (pnLeft + pnWidth > voCanvas.width) {
      pnLeft = voCanvas.width - pnWidth;
    }
    
    // 백그라운드에 rectangle로 씌움
    {
      var objBackgroundRect = voCanvas.createControl("rectangle",
      "dialog_background_rectangle", 0, 0, voCanvas.width, voCanvas.height);
      objBackgroundRect.zIndex = 10000;
      objBackgroundRect.fillType = "solid";
      objBackgroundRect.fillStartColor = "#FFFFFF";
      objBackgroundRect.fillOpacity = 40;
      objBackgroundRect.penWeight = 0;
      voCanvas.appendControl(objBackgroundRect);
    }
    
    // 모든 컨트롤을 담을 그룹
    {
      var objOuterGroup = voCanvas.createControl("group", "dialog_outer_group",
      pnLeft, pnTop, pnWidth + 5, pnHeight + 5);
      objOuterGroup.borderWidth = 0;
      objOuterGroup.zIndex = 10000;
      objOuterGroup.overflow = "visible";
      objOuterGroup.movable = true;
    }
    // 그림자 영역
    {
      var objRectShadow = voCanvas.createControl("rectangle",
      "dialog_shadow_rectangle", 5, 5, pnWidth, pnHeight);
      
      objRectShadow.penColor = "transparent";
      objRectShadow.zIndex = 0;
      objRectShadow.borderWidth = 0;
      objRectShadow.fillType = "solid";
      objRectShadow.fillStartColor = "#333333";
      objRectShadow.fillOpacity = 20;
      objOuterGroup.addChild(objRectShadow);
    }
    // 최외곽 rectangle 영역
    {
      var objRectBody = voCanvas.createControl("rectangle",
      "dialog_outer_rectangle", 0, 21, pnWidth, pnHeight - 21);
      objRectBody.zIndex = 1;
      objRectBody.fillType = "solid";
      objRectBody.fillStartColor = "#dcfb93";
      objRectBody.fillEndColor = "#FFFFFF";
      objRectBody.fillOpacity = 100;
      objOuterGroup.addChild(objRectBody);
    }
    // 사용자가 넘겨준 control을 담는 Group 영역
    {
      var objGroupBody = null;
      if (poGrp == null) {
        voCanvas.createControl("group", "dialog_controls_group", 5, 23,
        pnWidth - 10, pnHeight - 60);
        objGroupBody.zIndex = 2;
        objGroupBody.overflow = "visible";
        objGroupBody.fillStartColor = "#FFFFFF";
        objGroupBody.fillOpacity = 50;
        
        // 사용자가 넘겨준 control 추가
        if (poControls != null) {
          var vnLen = poControls.size();
          for (var i = 0; i < vnLen; i++) {
            objGroupBody.addChild(poControls.get(i));
          }
          poControls = null;
        }
        // 사용자가 넘겨준 control들을 전부 추가 후
      }
    }
    // top 영역
    {
      var objRectTop = voCanvas.createControl("rectangle",
      "dialog_top_rectangle", 0, 0, pnWidth, 21);
      objRectTop.zIndex = 1;
      objRectTop.fillType = "solid";
      objRectTop.fillStartColor = "white";
      objRectTop.fillOpacity = 100;
      objOuterGroup.addChild(objRectTop);
    }
    // top의 제목 표시줄
    {
      var objTitleLabel = voCanvas.createControl("label", "dialog_title_label",
      10, 1, pnWidth - 11, 18);
      // objTitleLabel.borderWidth = 0;
      // objTitleLabel.color = "#000000";
      objTitleLabel.textAlign = "left";
      objTitleLabel.className = "lblTitleUtilDialog";
      objTitleLabel.outerClassName = "lblBorder";
      objTitleLabel.value = psTitle;
      objTitleLabel.zIndex = 2;
      objTitleLabel.onmousedown = function(e) {
        var voOuterGroup = page.getControl("dialog_outer_group");
        voOuterGroup.startMove(e);
      }
      objOuterGroup.addChild(objTitleLabel);
    }
    // top의 닫기 버튼
    {
      var objTitleClose = voCanvas.createControl("button",
      "dialog_title_close", pnWidth - 22, 2, 17, 17);
      // objTitleClose.backgroundColor = "#D5D5D5";
      // objTitleClose.color = "#000000";
      // objTitleClose.value = "X";
      objTitleClose.className = "btnClose";
      objTitleClose.outerClassName = "btnOtherBorder";
      objTitleClose.zIndex = 2;
      objTitleClose.onclick = function(e) {
        UtilDialog.removeDialogCtrl(null, poGrp);
      }
      objOuterGroup.addChild(objTitleClose);
    }
    // 하단 컨트롤을 담을 그룹
    {
      var objBottomCtrlGroup = voCanvas.createControl("group",
      "dialog_bottom_control_group", 5, pnHeight - 35, pnWidth - 10, 30);
      objBottomCtrlGroup.zIndex = 2;
    }
    // 확인버튼
    if (pbBtn != false) {
      {
        var objOkBtn = voCanvas.createControl("button", "dialog_ok_button",
        pnWidth + 5 - 125, 4, 50, 20);
        objOkBtn.value = "OK";
        objOkBtn.zIndex = 3;
        objOkBtn.className = "btnUtilDialog";
        objOkBtn.outerClassName = "btnOtherBorder";
        var voGrxEvent = e;
        objOkBtn.onclick = function(e) {
          var vbSuccess = true;
          if (page.onClick_btnDialogOk) {
            vbSuccess = page.onClick_btnDialogOk(e, voGrxEvent, poGrp);
          }
          if (vbSuccess) {
            UtilDialog.removeDialogCtrl(null, poGrp);
          }
        }
        objBottomCtrlGroup.addChild(objOkBtn);
      }
      // 취소 버튼
      {
        var objCancelBtn = voCanvas.createControl("button",
        "dialog_cancel_button", pnWidth - 5 - 60, 4, 50, 20);
        objCancelBtn.value = "Cancel";
        objCancelBtn.className = "btnUtilDialog";
        objCancelBtn.outerClassName = "btnOtherBorder";
        objCancelBtn.zIndex = 3;
        objCancelBtn.onclick = function(e) {
          UtilDialog.removeDialogCtrl(null, poGrp);
        }
        objBottomCtrlGroup.addChild(objCancelBtn);
      }
    }
    // 하단 컨트롤 그룹 추가
    objOuterGroup.addChild(objBottomCtrlGroup);
    
    // canvas에 popup 추가
    voCanvas.appendControl(objOuterGroup);
    if (poGrp) {
      var voCtrl = poGrp.ctrl;
      page.canvas.ctrl.removeChild(voCtrl);
      var voStyle = poGrp.ctrl.style;
      voStyle.left = "5px";
      voStyle.top = "23px";
      voStyle.width = (pnWidth - 10 - 2 * parseInt(voStyle.borderWidth)) + "px";
      voStyle.height = (pnHeight - 60 - 2 * parseInt(voStyle.borderWidth))
      + "px";
      voStyle.zIndex = 2;
      voStyle.overflow = "visible";
      voStyle.display = "block";
      objOuterGroup.ctrl.appendChild(poGrp.ctrl);
    }
    
    /*
     * onLoad() 형식의 함수 호출. 유틸 다이얼로그에 바인딩 되는 컨트롤이 있을 경우 이 메소드를 만들어서 처리한다.
     */    
    if (page.onLoadUtilDialog) {
      page.onLoadUtilDialog();
    }
  }
};

/**
 * 그리드 컬럼 확장 기능 관련 유틸 모듈
 */
UtilJoinSub = {
  /**
   * GridEx의 칼럼과 이벤트 정보를 다른 GridEx에서 가져와 확장한다.
   * @param {eXria.controls.xhtml.GridEx} pcGrx 컬럼확장 대상 그리드 객체
   * @param {String} psGrxId 확장될 컬럼 템플릿 정보를 갖는 그리드 아이디
   * @param {Number} pnRepeat 확장될 컬럼들을 반복 생성할 횟수
   * @param {Function} poColNmFunc 컬럼 라벨 생성 메소드
   */  
  extendCols : function(pcGrx, psGrxId, pnRepeat, poColNmFunc) {
    //debugger;
    var vcCtl = page.getControl(psGrxId);
    var vnRepeatBase = vcCtl.repeatBase;
    if (vnRepeatBase == null) {
      vnRepeatBase = 0;
    }
    vcCtl.repeatBase = vnRepeatBase + pnRepeat;
    
    var voTrgDst = vcCtl.dataset;
    var voTrgHColsRow = vcCtl.header.cols ["center"].rows [0];
    var voTrgBColsRow = vcCtl.body.cols ["center"].rows [0];
    var voCol = null;
    
    var voSrcDst = pcGrx.dataset;
    var voSrcHColsRow = pcGrx.header.cols ["center"].rows [0];
    var vaSrcHColumns = voSrcHColsRow.columns;
    var voSrcHCol = null;
    var voSrcBCol = null;
    var vnSize = vaSrcHColumns.length;
    var vsSuffix = null;
    var vsDstCol = null;
    if (pnRepeat == null) {
      pnRepeat = 1;
    }
    pnRepeat--;
    for (var h = vnRepeatBase; h <= pnRepeat + vnRepeatBase; h++) {
      vsSuffix = "" + h;
      vsSuffix = vsSuffix == "0" ? "" : vsSuffix;
      for (var i = 0; i < vnSize; i++) {
        voSrcHCol = vaSrcHColumns [i];
        voSrcBCol = pcGrx.getBodyColumn(null, voSrcHCol.id)
        
        voCol = voTrgHColsRow.createHeadColumn(voSrcHCol.id + vsSuffix, null,
        null);
        
        voCol.colspan = voSrcHCol.colspan;
        if (poColNmFunc) {
          voCol.value = poColNmFunc(h);
        } else {
          voCol.value = voSrcHCol.value + vsSuffix;
        }
        voTrgHColsRow.addColumn(voCol);
        
        voCol = voTrgBColsRow.createBodyColumn(voSrcBCol.id + vsSuffix,
        voSrcHCol.id + vsSuffix, voSrcBCol.type, voSrcBCol.instanceId,
        voSrcBCol.ref);
        voCol.regMask = voSrcBCol.regMask;
        voCol.regFormat = voSrcBCol.regFormat;
        voCol.groupFormat = voSrcBCol.groupFormat;
        voCol.width = voSrcBCol.width;
        vsDstCol = voSrcBCol.datasetCol + vsSuffix;
        
        // alert("createHeadColumn : " + voSrcHCol.id + vsSuffix +"\n"
        // +"vsDstCol : " + vsDstCol + "\n");
        
        voCol.datasetCol = vsDstCol;
        var voItemGroup = null;
        switch (voCol.type) {
          case "Enum" :
          var voData = voSrcBCol.itemgroup.data;
          if (voData.nodesetInstanceId && voData.nodesetInstancePath) {
            voItemGroup = voCol.itemgroup;
            voItemGroup.data.setNodesetRef(voData.nodesetInstanceId,
            voData.nodesetInstancePath);
            voItemGroup.labelTagName = voSrcBCol.itemgroup.labelTagName;
            voItemGroup.valueTagName = voSrcBCol.itemgroup.valueTagName;
          }
          
          var voItems = voSrcBCol.itemgroup.frontItems;
          var vnItemCnt = voItems.size();
          var voItemKeys = voItems.getKeyCollection();
          var voItemValues = voItems.getValueCollection();
          var vsItemKey = null;
          var vsItemValue = null;
          for (var j = 0; j < vnItemCnt; j++) {
            vsItemKey = voItemKeys.get(j);
            vsItemValue = voItemValues.get(j);
            voItemGroup.addItemFront(vsItemKey, vsItemValue);
          }
          voItems = voSrcBCol.itemgroup.backItems;
          vnItemCnt = voItems.size();
          voItemKeys = voItems.getKeyCollection();
          voItemValues = voItems.getValueCollection();
          for (var j = 0; j < vnItemCnt; j++) {
            vsItemKey = voItemKeys.get(j);
            vsItemValue = voItemValues.get(j);
            voItemGroup.addItemBack(vsItemKey, vsItemValue);
          }
          break;
        }
        
        voTrgBColsRow.addColumn(voCol);
        
        voTrgDst.addColumn(- 1, voCol.datasetCol);
      }
    }
    //      page.getInstance("instance").print("/root/main");
    var vaTableName = voSrcDst.getCRUDTableNames().split(",");
    var vnTblCnt = vaTableName.length;
    var vsTableNm = null;
    var vnColCnt = null;
    var vaColName = null;
    var vsColNm = null;
    var vaCol = null;
    var vsPrefix = null;
    for (var i = 0; i < vnTblCnt; i++) {
      vsTableNm = vaTableName [i];
      if (vsTableNm == "") {
        break;
      }
      vsPrefix = voSrcDst.getPrefix(vsTableNm);
      voTrgDst.addCRUDTable(vsTableNm);
      voTrgDst.setPrefix(vsTableNm, vsPrefix);
      vaColName = voSrcDst.getPrimaryKeys(vsTableNm).split(",");
      vnColCnt = vaColName.length;
      for (var h = vnRepeatBase; h <= pnRepeat + vnRepeatBase; h++) {
        vsSuffix = "" + h;
        vsSuffix = vsSuffix == "0" ? "" : vsSuffix;
        for (var j = 0; j < vnColCnt; j++) {
          vsColNm = vaColName [j];
          if (vsColNm == "") {
            break;
          }
          vaCol = vsColNm.split(":");
          vsColNm = voTrgDst.addPrimaryKey(vsTableNm, vaCol [0] + vsSuffix,
          vaCol [1] + vsSuffix);
        }
        
        vaColName = voSrcDst.getUpdateCols(vsTableNm).split(",");
        vnColCnt = vaColName.length;
        for (var j = 0; j < vnColCnt; j++) {
          vsColNm = vaColName [j];
          if (vsColNm == "") {
            break;
          }
          vaCol = vsColNm.split(":");
          vsColNm = voTrgDst.addUpdateColumn(vsTableNm, vaCol [0] + vsSuffix,
          vaCol [1] + vsSuffix);
        }
      }
    }
    
    for (var attr in pcGrx) {
      if (attr.indexOf("onGridex") == 0) {
        var vsFunc = pcGrx [attr].toString();
        if (vcCtl [attr] == null) {
          vcCtl [attr] = eval(vaFunc);
        } else {
          var vsTrgFunc = vcCtl [attr]
          var vnStIdx = vsTrgFunc.indexOf("{") + 1;
          var vnEdIdx = vsTrgFunc.lastIndexOf("}");
          vsTrgFunc = vsTrgFunc.substring(vnStIdx, vnEdIdx);
          
          var vnStIdx = vsFunc.indexOf("{") + 1;
          var vnEdIdx = vsFunc.lastIndexOf("}");
          vsFunc = vsFunc.substring(vnStIdx, vnEdIdx);
          vcCtl [attr] = eval("function(e) {" + vsTrgFunc + vsFunc + "};");
          // execScript(vsFunc);
        }
      }
    }
    
    vcCtl.refresh();
  },
  
  /**
   * 그리드 컬럼이 확장되고 난 후 다시 원상태로 복귀하기 위해 초기 컬럼 정보 등을 저장하기 위한 작업 등을 수행하는 메소드.
   * @param {Array(String}} paGrxId 초기정보를 저장할 대상 그리드 아이디들을 담은 문자열 배열
   */  
  initMain : function(paGrxId) {
    page.moHeadColMap = {};
    page.moDstTableMap = {};
    page.moDstRestoreObj = {};
    
    var vsGrxId = null;
    var vnCnt = paGrxId.length;
    for (var i = 0; i < vnCnt; i++) {
      vsGrxId = paGrxId [i];
      page.moHeadColMap [vsGrxId] = {};
      
      var voHeadColMap = page.moHeadColMap [vsGrxId];
      var vcCtl = page.getControl(vsGrxId);
      var voDst = vcCtl.dataset;
      var vaCol = vcCtl.getHeadColumnList(1);
      var vsCol = null;
      var vnSize = vaCol.length;
      for (var j = 0; j < vnSize; j++) {
        vsCol = vaCol [j];
        voHeadColMap [vsCol] = "";
      }
      
      var vaTbl = voDst.getCRUDTableNames().split(",");
      vnSize = vaTbl.length;
      var vsTbl = null;
      for (var j = 0; j < vnSize; j++) {
        vsTbl = vaTbl [j];
        if (vsTbl == "") {
          break;
        }
        page.moDstTableMap [vsTbl] = "";
      }
    }
  },
  
  /**
   * 초기 확장 정보로 되돌리기 위한 메소드
   * @param {Array(String)} paGrxId 초기화 대상 아이디들을 담은 문자열 배열
   */  
  resetMain : function(paGrxId) {
    var vsGrxId = null;
    var vnCnt = paGrxId.length;
    for (var i = 0; i < vnCnt; i++) {
      vsGrxId = paGrxId [i];
      
      var voHeadColMap = page.moHeadColMap [vsGrxId];
      var vcCtl = page.getControl(vsGrxId);
      var voDst = vcCtl.dataset;
      var vaCol = vcCtl.getHeadColumnList(1);
      var vsCol = null;
      var voCol = null;
      var vnSize = vaCol.length;
      for (var j = 0; j < vnSize; j++) {
        vsCol = vaCol [j];
        if (voHeadColMap [vsCol] == null) {
          vcCtl.removeHeadColumn(vsCol);
          voCol = vcCtl.removeBodyColumn(null, vsCol);
          voDst.removeColumn(voCol.datasetCol);
        }
      }
      
      var vaTbl = voDst.getCRUDTableNames().split(",");
      vnSize = vaTbl.length;
      var vsTbl = null;
      for (var j = 0; j < vnSize; j++) {
        vsTbl = vaTbl [j];
        if (page.moDstTableMap [vsTbl] == null) {
          voDst.removeCRUDTable(vsTbl);
        }
      }
      vcCtl.refresh();
    }
  },
  
  /**
   * 일반적으로 그리드와 연결된 데이타셋의 CUD내역을 submission객체를 통해 서버로 전달할 때 기본 테이블의 내용과 확장 테이블에 내용이 같이 보내지게됨.
   * 기본테이블의 CUD내역만을 submission을 통해 서버로 전달할 경우 setDstReqMode(true)를 호출 후 submission send를 호출하면됨.
   * 다시 기본테이블과 확장테이블의 CUD내역을 모두 보내고자 할 경우에는 setDstReqMode(false)를 호출하여 setDstReqMode(true) 상태를 해지시킴.
   * @param {String} psGrxId 대상 그리드 아이디
   * @param {Boolean} pbStandard true이면 원래 가지고 있던 영역에 대한 것만 보내는 모드로 변경하고 이 모드를 해제하는 경우에만 false로 지정
   */  
  setDstReqMode : function(psGrxId, pbStandard) {
    var vcCtl = page.getControl(psGrxId);
    var voDst = vcCtl.dataset;
    var voRestore = null;
    var vsTbl = null;
    var voObj = null;
    var vaCols = null;
    var vnSize = null;
    if (pbStandard == true) {
      page.moDstRestoreObj [psGrxId] = {};
      voRestore = page.moDstRestoreObj [psGrxId];
      var vaTbl = voDst.getCRUDTableNames();
      vaTbl = vaTbl.replace(/\,$/, "");
      vaTbl = vaTbl.split(",");
      vnSize = vaTbl.length;
      for (var i = 0; i < vnSize; i++) {
        vsTbl = vaTbl [i];
        if (page.moDstTableMap [vsTbl] == null) {
          voObj = {};
          voObj.prefix = voDst.getPrefix(vsTbl);
          vaCols = voDst.getPrimaryKeys(vsTbl);
          vaCols = vaCols.replace(/\,$/, "");
          if (vaCols == "") {
            vaCols = [];
          } else {
            vaCols = vaCols.split(",");
          }
          voObj.primaryKeys = vaCols;
          
          vaCols = voDst.getUpdateCols(vsTbl);
          vaCols = vaCols.replace(/\,$/, "");
          if (vaCols == "") {
            vaCols = [];
          } else {
            vaCols = vaCols.split(",");
          }
          voObj.updateCols = vaCols;
          
          voRestore [vsTbl] = voObj;
          voDst.removeCRUDTable(vsTbl);
        }
      }
    } else {
      if (page.moDstRestoreObj [psGrxId] == null) {
        return;
      }
      voRestore = page.moDstRestoreObj [psGrxId];
      for (vsTbl in voRestore) {
        voObj = voRestore [vsTbl];
        voDst.addCRUDTable(vsTbl);
        voDst.setPrefix(vsTbl, voObj.prefix);
        var vaPrimaryKeys = voObj.primaryKeys;
        vnSize = vaPrimaryKeys.length;
        for (var i = 0; i < vnSize; i++) {
          vaCols = vaPrimaryKeys [i].split(":");
          voDst.addPrimaryKey(vsTbl, vaCols [0], vaCols [1]);
        }
        var vaUpdateCols = voObj.updateCols;
        vnSize = vaUpdateCols.length;
        for (var i = 0; i < vnSize; i++) {
          vaCols = vaUpdateCols [i].split(":");
          voDst.addUpdateColumn(vsTbl, vaCols [0], vaCols [1]);
        }
      }
      delete page.moDstRestoreObj [psGrxId];
    }
  }
};

/**
 * 입력폼 컨트롤 동적생성 관련 유틸 모듈
 */
UtilFormFieldMake = {
  "psInstanceId" : "",
  "psTagetGrpCtrlId" : "",
  "pnLabelWidth" : 100,
  "pnLabelHeight" : 20,
  "pnInputWidth" : 100,
  "pnInputHeight" : 20,
  "pnComboWidth" : 100,
  "pnComboHeight" : 20,
  "pnHGap" : 20,
  "pnVGap" : 30,
  "pnTop" : 5,
  "psInputInsXpath" : "/root/inputCtrlList/row",
  "psComboInsXpath" : "/root/comboCtrlList/row",
  "psDynamicCtrlListXpath" : "/root/dynamicCtrlList/row",
  "psDataInstance" : "",
  "psSubmission" : "",
  "psRequestInstance" : "",
  "psRequestXpath" : "",
  "psLabelClassName" : "",
  "psLabelOuterClassName" : "",
  "psInputClassName" : "",
  "psInputOuterClassName" : "",
  "psComboClassName" : "",
  "psComboOuterClassName" : "",
  
  "poMessage" : {
    name : "",
    message : ""
  },
  
  /**
   * 폼 컨트롤 생성 내부 메소드
   * @param {Object} poCtrl 컨트롤
   * @param {Object} psCtrlType 컨트롤 타입
   * @param {Object} pcTargetGrp 컨트롤이 생성될 그룹 컨트롤
   * @private
   */  
  _runCtrlMaker : function(poCtrl, psCtrlType, pcTargetGrp) {
    if (!poCtrl) {
      voErrMsg.name = "_runCtrlMaker"
      voErrMsg.message = "poCtrl 가 null 이거나 공백 입니다."
      throw voErrMsg;
    }
    ;
    if (!psCtrlType) {
      voErrMsg.name = "_runCtrlMaker"
      voErrMsg.message = "psCtrlType 가 null 이거나 공백 입니다."
      throw voErrMsg;
    }
    ;
    if (!psCtrlType) {
      voErrMsg.name = "_runCtrlMaker"
      voErrMsg.message = "pcTargetGrp 가 null 이거나 공백 입니다."
      throw voErrMsg;
    }
    ;
    
    try {
      var vsControlId = poCtrl ["controlId"];
      var vsControlValue = poCtrl ["controlValue"];
      var vsLabelValue = poCtrl ["labelValue"];
      var vsDataRef = poCtrl ["dataRef"];
      var vsDataNodesetRef = poCtrl ["dataNodesetRef"];
      
      var vnControlWidth;
      var vnControlHeight;
      
      var voPage = page;
      var voCanvas = voPage.canvas;
      
      // style 설정
      if ("input" === psCtrlType) {
        vnControlWidth = poCtrl ["controlWidth"] === "0" ? UtilFormFieldMake ["pnInputWidth"]
        : poCtrl ["controlWidth"];
        vnControlHeight = poCtrl ["controlHeight"] === "0" ? UtilFormFieldMake ["pnInputHeight"]
        : poCtrl ["controlHeight"];
      }
      
      if ("combo" === psCtrlType) {
        vnControlWidth = poCtrl ["controlWidth"] === "0" ? UtilFormFieldMake ["pnComboWidth"]
        : poCtrl ["controlWidth"];
        vnControlHeight = poCtrl ["controlHeight"] === "0" ? UtilFormFieldMake ["pnComboHeight"]
        : poCtrl ["controlHeight"];
      }
      
      vnControlWidth = Number(vnControlWidth);
      vnControlHeight = Number(vnControlHeight);
      
      // 라벨 컨트롤 생성
      var vcCreateCtrl = voCanvas
      .createControl("label", "dynamicLabel" + vsControlId, 5,
      UtilFormFieldMake ["pnTop"], UtilFormFieldMake ["pnLabelWidth"],
      UtilFormFieldMake ["pnLabelHeight"]);
      
      vcCreateCtrl.className = UtilFormFieldMake ["psLabelClassName"];
      vcCreateCtrl.outerClassName = UtilFormFieldMake ["psLabelOuterClassName"];
      
      vcCreateCtrl.value = vsLabelValue;
      pcTargetGrp.addChild(vcCreateCtrl);
      
      // 요청 컨트롤 생성(input, common)
      vcCreateCtrl = voCanvas.createControl(psCtrlType, vsControlId,
      UtilFormFieldMake ["pnLabelWidth"] + UtilFormFieldMake ["pnHGap"],
      UtilFormFieldMake ["pnTop"], vnControlWidth, vnControlHeight);
      vcCreateCtrl.value = vsControlValue;
      UtilFormFieldMake ["pnTop"] = UtilFormFieldMake ["pnTop"]
      + UtilFormFieldMake ["pnVGap"];
      
      // 요청 컨트롤과 스타일 css맵핑
      if ("input" === psCtrlType) {
        vcCreateCtrl.className = UtilFormFieldMake ["psInputClassName"];
        vcCreateCtrl.outerClassName = UtilFormFieldMake ["psInputOuterClassName"];
      }
      
      if ("combo" === psCtrlType) {
        vcCreateCtrl.className = UtilFormFieldMake ["psComboClassName"];
        vcCreateCtrl.outerClassName = UtilFormFieldMake ["psComboOuterClassName"];
      }
      
      // 요청 컨트롤과 인스턴스 맵핑
      if (vsDataNodesetRef !== "" && "combo" === psCtrlType) {
        vcCreateCtrl.data.setNodesetRef(UtilFormFieldMake ["psInstanceId"],
        vsDataNodesetRef);
        
        vcCreateCtrl.labelTagName = "itemName";
        vcCreateCtrl.valueTagName = "itemValue";
      }
      
      if (vsDataRef !== "") {
        vcCreateCtrl.data
        .setRef(UtilFormFieldMake ["psDataInstance"], vsDataRef);
      }
      
      pcTargetGrp.addChild(vcCreateCtrl);
    } catch (err) {
      throw err;
    }
  },
  
  /**
   * Input, Combo 컨트롤 을 동적으로 생성
   * ex)UtilFormFieldMake.createCtrl({psInstanceId : "insDynamicTest",psTagetGrpCtrlId : "grp1"}) JSON 형태의 Paramter 사용
   * @param {Object} poJson css스타일 옵션
   * psInstanceId 인스턴스 ID 필수
   * psTagetGrpCtrlId addChild 될 그룹 컨트롤 ID 옵션
   * pnLabelWidth 라벨컨트롤의 기본 width 값 (미지정 100) 옵션
   * pnLabelHeight 라벨컨트롤의 기본 height 값(미지정 20) 옵션
   * pnInputWidth 인풋컨트롤의 기본 width 값 (미지정 100) 옵션
   * pnInputHeight 인풋컨트롤의 기본 height 값 (미지정 20) 옵션
   * pnComboWidth 콤보박스컨트롤의 기본 width 값 (미지정 100) 옵션
   * pnComboHeight 콤보박스컨트롤의 기본 height 값 (미지정 20) 옵션
   * pnHGap 컨트롤간의 가로 여백 값 (미지정 20) 옵션
   * pnVGap 컨트롤간의 세로 여백 값 (미지정 30) 옵션
   * psInputInsXpath 인풋컨트롤노드XPATH (미지정/root/inputCtrlList/row) // deprecated
   // 옵션
   * psComboInsXpath 콤보박스컨트롤노드XPATH (미지정/root/comboCtrlList/row) // deprecated
   // 옵션
   * psDynamicCtrlListXpath 동적생성컨트롤노드XPATH (미지정 /root/dynamicCtrlList/row) 옵션
   * psDataInstance 컨트롤에 바인딩될 data정보가 들어있는 인스턴스ID (미지정 psInstanceId 와 동일) 옵션
   * psSubmission request될 서브미션 ID 옵션
   * psRequestInstance request될 인스턴스 ID 옵션
   * psRequestXpath request될 노드XPATH
   * psLabelClassName 라벨컨트롤의 css스타일 옵션
   * psLabelOuterClassName 라벨컨트롤의 css스타일 옵션
   * psInputClassName  인풋컨트롤의 css스타일 옵션
   * psInputOuterClassName 인풋컨트롤의 css스타일 옵션
   * psComboClassName 콤보컨트롤의 css스타일 옵션
   * psComboOuterClassName 콤보컨트롤의 css스타일 옵션
   */  
  createCtrl : function(poJson) {
    try {
      if (!poJson.psInstanceId) {
        voErrMsg.name = "createCtrl"
        voErrMsg.message = "psInstanceId 가 null 이거나 공백 입니다."
        throw voErrMsg;
      }
      
      if (!poJson.psTagetGrpCtrlId) {
        voErrMsg.name = "createCtrl"
        voErrMsg.message = "psTagetGrpCtrlId 가 null 이거나 공백 입니다."
        throw voErrMsg;
      }
      
      UtilFormFieldMake.pnLabelWidth = poJson ["pnLabelWidth"]
      || UtilFormFieldMake.pnLabelWidth;
      UtilFormFieldMake.pnLabelHeight = poJson ["pnLabelHeight"]
      || UtilFormFieldMake.pnLabelHeight;
      UtilFormFieldMake.pnInputWidth = poJson ["pnInputWidth"]
      || UtilFormFieldMake.pnInputWidth;
      UtilFormFieldMake.pnInputHeight = poJson ["pnInputHeight"]
      || UtilFormFieldMake.pnInputHeight;
      UtilFormFieldMake.pnComboWidth = poJson ["pnComboWidth"]
      || UtilFormFieldMake.pnComboWidth;
      UtilFormFieldMake.pnComboHeight = poJson ["pnComboHeight"]
      || UtilFormFieldMake.pnComboHeight;
      UtilFormFieldMake.pnHGap = poJson ["pnHGap"] || UtilFormFieldMake.pnHGap;
      UtilFormFieldMake.pnVGap = poJson ["pnVGap"] || UtilFormFieldMake.pnVGap;
      
      UtilFormFieldMake.psDataInstance = poJson ["psDataInstance"]
      || UtilFormFieldMake.psDataInstance;
      UtilFormFieldMake.psDynamicCtrlListXpath = poJson ["psDynamicCtrlListXpath"]
      || UtilFormFieldMake.psDynamicCtrlListXpath;
      
      UtilFormFieldMake ["psInstanceId"] = poJson ["psInstanceId"];
      UtilFormFieldMake ["psTagetGrpCtrlId"] = poJson ["psTagetGrpCtrlId"];
      
      UtilFormFieldMake ["psSubmission"] = poJson ["psSubmission"];
      UtilFormFieldMake ["psRequestInstance"] = poJson ["psRequestInstance"];
      UtilFormFieldMake ["psRequestXpath"] = poJson ["psRequestXpath"];
      
      UtilFormFieldMake.psLabelClassName = poJson ["psLabelClassName"]
      || UtilFormFieldMake.psLabelClassName;
      UtilFormFieldMake.psLabelOuterClassName = poJson ["psLabelOuterClassName"]
      || UtilFormFieldMake.psLabelOuterClassName;
      UtilFormFieldMake.psInputClassName = poJson ["psInputClassName"]
      || UtilFormFieldMake.psInputClassName;
      UtilFormFieldMake.psInputOuterClassName = poJson ["psInputOuterClassName"]
      || UtilFormFieldMake.psInputOuterClassName;
      UtilFormFieldMake.psComboClassName = poJson ["psComboClassName"]
      || UtilFormFieldMake.psComboClassName;
      UtilFormFieldMake.psComboOuterClassName = poJson ["psComboOuterClassName"]
      || UtilFormFieldMake.psComboOuterClassName;
      
      var vsInstanceId = UtilFormFieldMake ["psInstanceId"];
      var vsTagetGrpCtrlId = UtilFormFieldMake ["psTagetGrpCtrlId"];
      
      var voPage = page;
      var voCanvas = voPage.canvas;
      var voInstance = voPage.getInstance(vsInstanceId);
      var vcGrp = voPage.getControl(vsTagetGrpCtrlId);
      
      var voCtrlNode = voInstance
      .selectNodesStr(UtilFormFieldMake.psDynamicCtrlListXpath);
      voCtrlNode = eval(voCtrlNode);
      
      // 브라우저 버전에 따러서 배열에서 제공되는 메소드가 제한된다.
      // IE6에서는 배열에 SIZE 메소드가 없다.
      // var vnSize = null;
      // if(!voCtrlNode.size) vnSize = voCtrlNode.length;
      // else vnSize = voCtrlNode.size();
      
      var vnSize = voCtrlNode.length;
      var voCtrl;
      var voCtrlType;
      
      for (var i = 0; i < vnSize; i++) {
        voCtrl = voCtrlNode [i];
        voCtrlType = voCtrl ["controlType"];
        UtilFormFieldMake._runCtrlMaker(voCtrl, voCtrlType, vcGrp);
      }
      
      //데이터셋 생성및 연동 작업
      if (! !UtilFormFieldMake ["psSubmission"]) {
        var voSubmission = voPage
        .getSubmission(UtilFormFieldMake ["psSubmission"]);
        voSubmission.addRef(UtilFormFieldMake ["psRequestInstance"],
        UtilFormFieldMake ["psRequestXpath"]);
      }
      
    } catch (err) {
      //      alert("UtilFormFieldMake"+ "\n" +
      // "method : " + err.name + "\n" +
      // "message : " + err.message);
      ComMsg.showMsg("co.error.formfieldmake", [err.name, err.message]);
    }
  }
};

/**
 * Toggle 기능 수행
 */
var UtilToggle = {
  /**
   * @private
   */  
  timerlen : 100,
  
  /**
   * @private
   */  
  slideAniLen : 150,
  
  /**
   * @private
   */  
  timerID : {},
  
  /**
   * @private
   */  
  startTime : {},
  
  /**
   * @private
   */  
  obj : {},
  
  /**
   * @private
   */  
  endHeight : {},
  
  /**
   * @private
   */  
  moving : {},
  
  /**
   * @private
   */  
  dir : {},
  
  /**
   * @private
   */  
  outherCtl : [],
  
  /**
   * @private
   */  
  otherCtlTop : [],
  
  /**
   * 폼 컨트롤 생성 내부 메소드
   * ex) vaCtrl.push(page.getControl("lbl2"));
   * vaCtrl.push(page.getControl("grp2"));
   * vaCtrl.push(page.getControl("lbl3"));
   * vaCtrl.push(page.getControl("grp3"));
   * utilCtrl.toggleSlide(page, "grp1", vaCtrl);
   * @param {eXria.form.Page} poPage (생략가능) 페이지 객체
   * @param {String} psCtlId 컨트롤 아이디
   * @param {Array(eXria.controls.Control)} paCtl 컨트롤이 생성될 그룹 컨트롤 배열
   */  
  toggleSlide : function(poPage, psCtlId, paCtl) {
    var voElement;
    if ("string" === typeof (psCtlId)) {
      voElement = poPage.getControl(psCtlId).ctrl;
    } else {
      voElement = psCtlId;
    }
    if ("none" === voElement.style.display) {
      this.slidedown(psCtlId, voElement, paCtl);
    } else {
      this.slideup(psCtlId, voElement, paCtl);
    }
  },
  
  /**
   * @private
   */  
  slidedown : function(psCtlId, poElement, paCtl) {
    if (this.moving [psCtlId]) {
      return;
    }
    
    var voElement = poElement;
    
    if ("none" !== voElement.style.display) {
      return;
    }
    
    this.moving [psCtlId] = true;
    this.dir [psCtlId] = "down";
    this.startslide(psCtlId, voElement, paCtl);
  },
  
  /**
   * @private
   */  
  slideup : function(psCtlId, poElement, paCtl) {
    if (this.moving [psCtlId]) {
      return;
    }
    
    var voElement = poElement;
    
    if ("none" === voElement.style.display) {
      return;
    }
    
    this.moving [psCtlId] = true;
    this.dir [psCtlId] = "up";
    this.startslide(psCtlId, voElement, paCtl);
  },
  
  /**
   * @private
   */  
  startslide : function(psCtlId, poElement, paCtl) {
    var vsCtrId = psCtlId;
    this.obj [vsCtrId] = poElement;
    
    this.endHeight [vsCtrId] = parseInt(this.obj [vsCtrId].style.height);
    // 나머지 컨트롤 Height의 종료 기준선정
    
    // paCtlId
    if (! !paCtl) {
      this.otherCtlTop = [];
      this.outherCtl = [];
      var vaCtlId = paCtl;
      var voCtl;
      var vnIdLength = vaCtlId.length;
      for (var i = 0; i < vnIdLength; i++) {
        voCtl = vaCtlId [i];
        this.outherCtl [i] = voCtl.ctrl;
        
        if ("up" === this.dir [psCtlId]) {
          this.otherCtlTop [i] = parseInt(voCtl.ctrl.style.top)
          - this.endHeight [vsCtrId];
        } else {
          this.otherCtlTop [i] = parseInt(voCtl.ctrl.style.top)
          + this.endHeight [vsCtrId];
        }
      }
    }
    
    this.startTime [vsCtrId] = (new Date()).getTime();
    
    if ("down" === this.dir [vsCtrId]) {
      this.obj [vsCtrId].style.height = "1px";
    }
    
    this.obj [vsCtrId].style.display = "block";
    
    var voFunc = function() {
      UtilToggle.slidetick(vsCtrId);
    };
    this.timerID [vsCtrId] = setInterval(voFunc, this.timerlen);
    
    // UtilControl.ctrlFadeInOut(page, psCtlId, true);
  },
  
  /**
   * @private
   */  
  slidetick : function(psCtlId) {
    var elapsed = (new Date()).getTime() - this.startTime [psCtlId];
    
    if (elapsed > this.slideAniLen) {
      this.endSlide(psCtlId)
    } else {
      
      var vnHeight = Math.round(elapsed / this.slideAniLen
      * this.endHeight [psCtlId]);
      
      // console.log("var vnHeight : " + vnHeight);
      
      if ("up" === this.dir [psCtlId]) {
        vnHeight = this.endHeight [psCtlId] - vnHeight;
        // console.log("this.endHeight [psCtlId] - vnHeight : " +
        // vnHeight);
      }
      
      this.obj [psCtlId].style.height = vnHeight + "px";
      
      var vnLength = this.outherCtl.length;
      if (! !vnLength) {
        var vcCtrl;
        var vsTop;
        for (var i = 0; i < vnLength; i++) {
          vcCtrl = this.outherCtl [i];
          vsTop = parseInt(vcCtrl.style.top);
          
          if ("up" === this.dir [psCtlId]) {
            vcCtrl.style.top = vsTop - vnHeight + "px";
          } else {
            vcCtrl.style.top = vsTop + vnHeight + "px";
          }
        }
      }
      
    }
    return;
  },
  
  /**
   * @private
   */  
  endSlide : function(psCtlId) {
    clearInterval(this.timerID [psCtlId]);
    
    if ("up" === this.dir [psCtlId]) {
      this.obj [psCtlId].style.display = "none";
    }
    
    this.obj [psCtlId].style.height = this.endHeight [psCtlId] + "px";
    
    var vnLength = this.outherCtl.length;
    
    if (! !vnLength) {
      for (var i = 0; i < vnLength; i++) {
        this.outherCtl [i].style.top = this.otherCtlTop [i] + "px";
        delete (this.outherCtl [i]);
        delete (this.otherCtlTop [i]);
      }
    }
    
    delete (this.moving [psCtlId]);
    delete (this.timerID [psCtlId]);
    delete (this.startTime [psCtlId]);
    delete (this.endHeight [psCtlId]);
    delete (this.obj [psCtlId]);
    delete (this.dir [psCtlId]);
    
    return;
  }
};

/**
 * AOP 기능을 사용하기 위한 유틸(native code인(기본제공)인 함수에는 사용이 불가능)
 * ex : AOP.addBefore(this, "setFrist", testBeforeAdvisor);
 */
AOP = {
  addBefore : function(obj, fname, before) {
    var oldFunc = obj [fname];
    obj [fname] = function() {
      before(arguments, obj);
      return oldFunc.apply(this, arguments);
    };
  },
  
  addAfter : function(obj, fname, after) {
    var oldFunc = obj [fname];
    obj [fname] = function() {
      result = oldFunc.apply(this, arguments);
      try {
        return result;
      } finally {
        after(result, arguments, obj);
      }
    };
  }
}

/**
 * debugForm을 이용해 xrf를 호출 시 사용가능한 로그 유틸
 */
UtilDebug = {
  /**
   * debugForm의 page 객체
   * @type eXria.form.page
   */  
  debugPage : null,
  /**
   * debugForm에서 log를 출력하는 TextArea 컨트롤
   * @type eXria.controls.xhtml.TextArea
   */  
  logArea : null,
  /**
   * 로거 사용을 위한 초기화 작업을 수행하는 메소드
   * @private
   */  
  init : function() {
    var voWindow = page.window.parent;
    var voPage = voWindow.page;
    while (voPage) {
      if (voPage.id == "debugForm") {
        this.debugPage = voPage;
        this.logArea = voPage.getControl("txtLog");
        break;
      }
      voWindow = voWindow.parent;
      voPage = voWindow.page;
    }
  },
  /**
   * logArea에 줄바꿈 없이 로그를 출력하는 메소드
   * @param {String} psTxt 출력할 문자열
   */  
  print : function(psTxt) {
    var vsTxt = this.logArea.getValue();
    if (vsTxt == null) {
      vsTxt = "";
    }
    vsTxt += psTxt;
    this.logArea.setValue(vsTxt);
    var voCtrl = this.logArea.subElement.textarea;
    if (voCtrl.scrollHeight > voCtrl.clientHeight) {
      voCtrl.scrollTop = voCtrl.scrollHeight - this.logArea.height;
    }
  },
  /**
   * logArea에 로그를 출력하고 줄바꿈을 수행하는 메소드
   * @param {String} psTxt 출력할 문자열
   */  
  println : function(psTxt) {
    var vsTxt = this.logArea.getValue();
    if (vsTxt == null) {
      vsTxt = "";
    }
    vsTxt += psTxt + "\n";
    this.logArea.setValue(vsTxt);
    var voCtrl = this.logArea.subElement.textarea;
    if (voCtrl.scrollHeight > voCtrl.clientHeight) {
      voCtrl.scrollTop = voCtrl.scrollHeight - this.logArea.height;
    }
  },
  /**
   * logArea를 초기화 시켜주는 메소드
   */  
  clear : function() {
    this.logArea.setValue("");
  }
};