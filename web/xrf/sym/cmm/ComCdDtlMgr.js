/**
 * Object ComCdDtlMgr()
 * @base eXria.form.Page
 * @constructor
 * @class ComCdDtlMgr
 * @author cyberlhs at 13. 7. 2 오후 3:32
 */
var ComCdDtlMgr = function() {
	// extends eXria.form.Page Object
	eXria.form.Page.call(this, "ComCdDtlMgr"); //$NON-NLS-1$
	
	// TODO 
	
	/*
	 * 전역 변수 선언부
	 */
 
	var moReqData; //인스턴스 객체
	var moResData; //인스턴스 객체 
	var moResMsg //Message
	var moReqMethod //Method
	
	var vcDstressymcommcddtllist;
	var vcDstreqsymcommcddtlvo; 
	var vcDstressymcommcddtlvo;
	var mcGrxComCdDtl; //그리드 컨트롤	
	
	var vcCbbOrgnClsfCd;
    var vcIpbComName;
	
	var vcIpbCommCd;
	var vcLblCommNm;
    var vcIpbCommDtlCd;
	var vcIpbCommDtlNm;
	var vcIpbCommDtlInfo; 
	var vcIpbCommDtlOrd;
	var vcRdbUseYn;
	var vcBtnSchCode;
 
	var vcMethod;
	
	this.onLoad = function() {
		// TODO 하면 되는거죠. 제가 코딩좀 할께요..
		moReqData           = page.getInstance("requestData"); 
		moResData           = page.getInstance("responseData");    //인스턴스 객체 
		moResMsg            = page.getInstance("resMessage");       //인스턴스 객체 
		moReqMethod         = page.getInstance("reqMethod");
		
		vcDstressymcommcddtllist = page.getDataSet("dstResSymCommCdDtlList");
	    vcDstreqsymcommcddtlvo = page.getDataSet("dstReqSymCommCdDtlVO");
		vcDstressymcommcddtlvo = page.getDataSet("dstResSymCommCdDtlVO");
		 
	    mcGrxComCdDtl      	= page.getControl("grxComCdDtl");     //그리드 컨트롤
	    
		//변수 컨트롤 객체 선언
		vcCbbOrgnClsfCd = page.getControl("cbbOrgnClsfCd");
		vcIpbComName = page.getControl("ipbComName");
		
		vcIpbCommCd = page.getControl("ipbCommCd");
		vcBtnSchCode = page.getControl("btnSchCode");
	    vcLblCommNm = page.getControl("lblCommNm");
	    vcIpbCommDtlCd = page.getControl("ipbCommDtlCd");
		vcIpbCommDtlNm = page.getControl("ipbCommDtlNm");
		vcIpbCommDtlInfo = page.getControl("ipbCommDtlInfo"); 
		vcIpbCommDtlOrd = page.getControl("ipbCommDtlOrd");
		vcRdbUseYn = page.getControl("rdbUseYn");
		
		page.doLoad();
		page.doSrchList();
	};
	
	/**
	 * 
	 * @member ComCdDtlMgr
	 * @type void
	 * @author cyberlhs at 13. 8. 13 오후 6:57
	 */
	this.doLoad = function() {
    // TODO  
	    vcCbbOrgnClsfCd.setValue("");
		vcIpbComName.setValue("");
		vcMethod = ""; 
		page.doFncClear();
	};
	
	/*
	 * 조회조건 초기화 메서드
	 */	
	this.doFncClear = function() {
		// TODO 
		vcIpbCommCd.setValue("");
	    vcLblCommNm.setValue("");
	    vcIpbCommDtlCd.setValue("");
		vcIpbCommDtlNm.setValue("");
		vcIpbCommDtlInfo.setValue(""); 
		vcIpbCommDtlOrd.setValue("");
		vcRdbUseYn.setValue("1"); 
		vcIpbCommCd.readOnly = false;
		vcBtnSchCode.disabled = false;
		vcBtnSchCode.refresh();
		vcIpbCommDtlCd.readOnly = false;
		
		vcIpbCommCd.refresh();
		vcIpbCommDtlCd.refresh();
		
		vcMethod = "add";
	};	
	
	
	this.onClick_btnSrch = function(e /*:eXria.event.Event*/) { 
		// TODO 
		if(moReqData.getValue("/root/searchVO/searchCondition") == ""){
			alert("조회 구분을 선택하세요.");
		}else{
			page.doSrchList();
		}
	};
	//init
	this.onClick_btnInit = function(e /*:eXria.event.Event*/) {
		// TODO
			page.doFncClear();
	};
	//save
	this.onClick_btnSave = function(e /*:eXria.event.Event*/) {
		// TODO
		moReqMethod.setValue("/root/method", vcMethod);
		page.doFncSave();
	};
	//delete
	this.onClick_btnDelete = function(e /*:eXria.event.Event*/) {
		// TODO
		page.doFncDelete();
	};
	
	this.onGridexDblClick_grxComCdDtl = function(e /*:eXria.controls.xhtml.GridEx.event*/) {
		// TODO
		 var voEvent = e;
	     var vcGrx = e.object;   
		 
		 var vcGrxCommDtlCd = vcGrx.getValue(voEvent.row,"ghcCommDtlCd")  
		 var vIndex = mcGrxComCdDtl.getIndexOfRow(voEvent.row) 
		 var vcGrxCommCd = page.getControl("grxComCdDtl").getValue(e.row,"ghcCommNm") ;
		 
		 if ((vcGrxCommDtlCd == null && vcGrxCommCd == null) || (vcGrxCommDtlCd == "" && vcGrxCommCd == "")) {
			 return;
		 } 
		 vcIpbCommCd.readOnly = true;
		 vcBtnSchCode.disabled = true;
		 vcBtnSchCode.refresh();
		 vcIpbCommDtlCd.readOnly = true;
		 vcIpbCommCd.setValue(vcGrxCommCd);
		 vcIpbCommDtlCd.setValue(vcGrxCommDtlCd);  
		 Common.refreshCtl(["ipbCommCd","ipbCommDtlCd"]); 
		 
		 page.doFncRead(); 
	};
	
	/*
	 * 조회 메서드
	 */	
	this.doSrchList = function() {
    // TODO - 조회 Submmision Send, 그리드 Refresh
		var vbSuccess = Common.processSubmission("smsSymCommCdDtlList");
		if(vbSuccess == false) return;   
		// TODO pageing 추가
		//var vsPageNo = moInsData.getValue("/root/searchVO/pageNo");
		//page.doFacadePageNum(vsPageNo);
		mcGrxComCdDtl.refresh();
		page.doFncClear();
		 
	};
	
		/*
	 * 페이징 관련 조회 처리
	 */	
/*	this.doGoPage = function(psPageNum) {
    // TODO - 페이지 조회
        psPageNum = "" + psPageNum;
		moInsData.setValue("/root/searchVO/pageNo",psPageNum);
		page.doSrchList();
		page.doFacadePageNum(psPageNum);
		
	}; */
	/*
	 * 저장 메서드
	 */	
	this.doFncSave = function() {
	 // TODO - 저장 Submission Send 

	    var vbValid = Valid.checkValidation(["ipbCommCd", "ipbCommDtlCd", "ipbCommDtlNm"], true); 
		if (vcIpbCommCd.getValue() == "" || vcIpbCommDtlCd.getValue() == "" || vcIpbCommDtlNm.getValue()=="" ) {
			alert("필수값이 누락되었습니다.");	
			return;
		} 
		if(confirm("저장하시겠습니까?")) {
	        var vbSuccess = Common.processSubmission("smsSymCommCdDtlSave"); 
		    if(!vbSuccess) {
			   alert("저장이 실패하였습니다."); 
			   return;
			} 
			
			if(moResMsg.getValue("/root/message/procMsg") != ""){
				alert(moResMsg.getValue("/root/message/procMsg"));
			}else{
				alert("정상적으로 저장이 완료되었습니다."); 
			}
		   // page.doFacadePageNum(moReqData.getValue("/root/searchVO/pageNo"));   
			page.doSrchList();	
		} 
		
	};  
  
   this.doFncDelete = function() {
	  if (vcIpbCommDtlCd.getValue() == ""){
		  alert("삭제 할 데이터를 선택하세요.");
	  }else{
		  if(confirm("삭제 하시겠습니까?")) {
			var vbSuccess = Common.processSubmission("smsSymCommCdDtlDel");  
			if(!vbSuccess) {
			   alert("삭제에 실패하였습니다."); 
			   return;
			} 
			
			alert("정상적으로 삭제가 처리되었습니다.");  
			page.doSrchList(); 
			//page.doFacadePageNum(moReqData.getValue("/root/searchVO/pageNo")); 
		}	
		
		vcIpbCommCd.readOnly = false;
		vcBtnSchCode.disabled = false;
		vcBtnSchCode.refresh();
		vcIpbCommDtlCd.readOnly = false;
		
		vcIpbCommCd.refresh();
		vcIpbCommDtlCd.refresh();
		vcMethod = "add";
	  }
	  
   };		
	
   this.doFncRead = function() { 
 
	 var vbSuccess = Common.processSubmission("smsSymCommCdDtlRead");  
	 if(vbSuccess == false) { 
	 	return;
	 }   
	 if (vcDstressymcommcddtlvo == null || vcDstressymcommcddtlvo == "") {
		 alert("결과가 존재하지 않습니다.");
	 } else {	 
	 //TODO - DATASET 이용확인.
	 // var vcResIdx = vcDstressymcommcdvo.getIndex() + 1;
	   vcIpbCommCd.setValue(moResData.getValue("/root/resSymCommCdDtlVO/row[1]/commCd"));           //공통코드
	   vcLblCommNm.setValue(moResData.getValue("/root/resSymCommCdDtlVO/row[1]/commNm"));           //공통코드명
	   vcIpbCommDtlCd.setValue(moResData.getValue("/root/resSymCommCdDtlVO/row[1]/commDtlCd"));     //공통상세코드
	   vcIpbCommDtlNm.setValue(moResData.getValue("/root/resSymCommCdDtlVO/row[1]/commDtlNm"));   	 //공통상세코드명
	   vcIpbCommDtlInfo.setValue(moResData.getValue("/root/resSymCommCdDtlVO/row[1]/commDtlInfo")); //부가정보
	   vcIpbCommDtlOrd.setValue(moResData.getValue("/root/resSymCommCdDtlVO/row[1]/commDtlOrd"));   //표시순서
	   vcRdbUseYn.setValue(moResData.getValue("/root/resSymCommCdDtlVO/row[1]/useYn")); 
  
	   Common.refreshCtl(["ipbCommCd","lblCommNm","ipbCommDtlCd","ipbCommDtlNm","ipbCommDtlInfo","ipbCommDtlOrd","rdbUseYn"]);
	
	 } 
  	  vcMethod = "update";
   };	
   
	/**
	 * 팝업으로 코드정보를 조회하기 위한 부분
	 * @member ComCdDtlMgr
	 * @param {eXria.event.Event} e
	 * @type void
	 * @author cyberlhs at 13. 8. 15 오전 12:02
	 */
	this.onClick_btnSchCode = function(e /*:eXria.event.Event*/) {
		// TODO  -  레이어팝업 호출  
	    P_PopupCmmCode();
		// var voPopup = Common.openPopUp("PopupCmmCode", "/xrf/popup/PopupCmmCode.xrf?libScope=page", 500, 550, "status=no, toolbar=no", true);  
		//UtilPopUp.openLayeredPopup("/xrf/popup/PopupCmmCode.xrf?libScope=page",600,600,voUserAttr);
		// page.openPage("PopupCmmCode","/xrf/popup/PopupCmmCode.xrf?libScope=page", eXria.form.PageType.POPUP);
	};
	 
    
    /**
     * 프로그램검색 팝업의 콜백 함수
     * @param psPgmId 프로그램ID
     * @param psPgmNm 프로그램명
     */ 
    function callbackPopupCmmCode(psPgmId, psPgmNm) {
		
		var voUserAttr = {}; 
		voUserAttr.method = "add";
		
        var oInstance = page.getInstance("ins_request");
        oInstance.setValue("/root/inquiryInfo/reqPgmId", psPgmId);

        page.getControl("ipb_req_pgm_nm").setValue(psPgmNm);
        g_sReqPgmNm = psPgmNm;
    }  
	
	/**
	 * 공통코드 검색 팝업의 콜백 함수
	 * @param psSbrnCd 소분류코드
	 * @param psSbrnNm 소분류코드명
	 */
	function P_callbackPopupCmmCode(psSbrnCd, psSbrnNm) {
	    //P_oCallbackFuncObj(psSbrnCd, psSbrnNm);
		alert(psSbrnCd);
	}
      
	/**
	 * 공통코드 검색 팝업을 띄운다.
	 * @param poFuncObj 팝업 콜백 함수 객체 (필수)
	 * @param psPopupName 팝업명 (선택)
	 */
	function P_PopupCmmCode(poFuncObj, psPopupName) {
	    
	    //P_oCallbackFuncObj = poFuncObj;
	    
	    if (psPopupName == null || psPopupName == "") {
	        psPopupName = "공통코드검색";
	    }
	
	
	    var oWindow = page.window;
	    P_oParamMap = new Object();
	    P_oParamMap.popupName = psPopupName;
	    
	    var nPopupWidth = 500;
	    var nPopupHeight = 550;
	    
	    var sLocation = "/estam-ndmi/xrf/popup/PopupCmmCode.xrf";
	    var sFeature = "status:no; scroll:no; help:no;"
	                 + "dialogWidth:" + nPopupWidth + "px;"
	                 + "dialogHeight:" + nPopupHeight + "px;"
	                 ;
	    
	    var sRtnVal = oWindow.showModalDialog(sLocation, oWindow, sFeature);
		
		if(sRtnVal){
			vcIpbCommCd.setValue(sRtnVal.commCd);			
		}
	}
	 
};
