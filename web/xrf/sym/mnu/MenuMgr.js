/**
 * Object MenuMgr()
 * @base eXria.form.Page
 * @constructor
 * @class MenuMgr
 * @author cyberlhs at 13. 6. 28 오전 11:26
 */
var MenuMgr = function() {
	// extends eXria.form.Page Object
	eXria.form.Page.call(this, "MenuMgr"); //$NON-NLS-1$
	
	// TODO 
	/*
	 * 전역 변수 선언부
	 */
	    var P_oCallbackFuncObj;
	var moReqData; //인스턴스 객체
	var moResData; //인스턴스 객체  
	var moResMsg //Message
	var moReqMethod //Method
	var mcGrxSymMenu; //그리드 컨트롤	 
	
	var vcDstressymmenulist;
	var vcDstressymmenuvo;
	var vcDstreqsymmenuvo;
	
	var vcIpbSchMenuNm
	var vcIpbMenuCd;
	var vcIpbMenuNm;
	var vcIpbUpMenuCd;
	var vcLblUpMenuNm; 
	var vcIpbMenuDesc;
	var vcIpbDplyNo;
	var vcIpbReMark;
	var vcIpbLinkUrl; 
	var vcRdbUseYn;
	var psPageNum;
	
	var vcMethod; 
	
	this.onLoad = function() {
		// TODO 하면 되는거죠. 제가 코딩좀 할께요..
		moReqData           = page.getInstance("requestData"); 
		moResData           = page.getInstance("responseData");    //인스턴스 객체 
		moResMsg            = page.getInstance("resMessage");       //인스턴스 객체 
		moReqMethod         = page.getInstance("reqMethod")
	 
	    mcGrxSymMenu     	= page.getControl("grxSymMenu");     //그리드 컨트롤 
		
	    //변수 컨트롤 객체 선언
 		vcDstressymmenulist = page.getDataSet("dstResSymMenuList");
		vcDstressymmenuvo = page.getDataSet("dstResSymMenuVO");
		vcDstreqsymmenuvo = page.getDataSet("dstReqSymMenuVO");
		
		vcIpbSchMenuNm = page.getControl("ipbSchMenuNm");
		
		vcIpbMenuCd = page.getControl("ipbMenuCd");
		vcIpbMenuNm = page.getControl("ipbMenuNm");
		vcIpbUpMenuCd = page.getControl("ipbUpMenuCd");
		vcLblUpMenuNm = page.getControl("lblUpMenuNm"); 
		vcIpbMenuDesc = page.getControl("ipbMenuDesc");
		vcIpbDplyNo = page.getControl("ipbDplyNo");
		vcIpbReMark = page.getControl("ipbReMark");
		vcIpbLinkUrl = page.getControl("ipbLinkUrl"); 
		vcRdbUseYn = page.getControl("rdbUseYn"); 
		
		grpCtl = page.getControl("grp1");
		
 		page.doLoad();
		page.doSrchList();
	};
	this.doLoad = function() {
    // TODO  
 	    vcIpbSchMenuNm.setValue("");  
		vcMethod = ""; 
		//page.doFncClear();	 
	};
	
	/*
	 * 조회조건 초기화 메서드
	 */	
	this.doFncClear = function() {
		// TODO - combobox 조회조건 초기화
        vcIpbMenuCd.setValue("");
		vcIpbMenuNm.setValue("");
		vcIpbUpMenuCd.setValue("");
		//vcLblUpMenuNm.setValue("");
		vcIpbMenuDesc.setValue("");
		vcIpbDplyNo.setValue("");
		vcIpbReMark.setValue("");
		vcIpbLinkUrl.setValue("");
		vcRdbUseYn.setValue("");
		vcIpbMenuCd.readOnly = false;
		vcIpbMenuCd.refresh();
		vcMethod = "add";
	};	
	
	this.onClick_btnSrch = function(e /*:eXria.event.Event*/) {
		// TODO 
		
		page.doSrchList();
	};
	
	this.onGridexDblClick_grxSymMenu = function(e /*:eXria.controls.xhtml.GridEx.event*/) {
		// TODO
		 var voEvent = e;
	     var vcGrx = e.object; 
		 var vcGrxMenuCd = vcGrx.getValue(voEvent.row,"ghcMenuCd")
		 
		 if (vcGrxMenuCd == null || vcGrxMenuCd == "") {
			 return;
		 } 
		 vcIpbMenuCd.readOnly = true;
		 vcIpbMenuCd.setValue(vcGrxMenuCd);  
		 page.getInstance("requestData").getValueNode("/root/reqSymMenuVO/menuCd").setValue(vcGrxMenuCd);
		 
		 Common.refreshCtl(["ipbMenuCd"]); 
		 page.doFncRead(); 
	
	};
	
	this.onClick_btnInit = function(e /*:eXria.event.Event*/) {
		// TODO
		page.doFncClear(); 
	};
	
	this.onClick_btnSave = function(e /*:eXria.event.Event*/) {
		// TODO
		moReqMethod.setValue("/root/method", vcMethod);
		page.doFncSave();
	};
	
	this.onClick_btnDelete = function(e /*:eXria.event.Event*/) {
		// TODO
		page.doFncDelete();
	};
	/*
	 * 조회 메서드
	 */	
	this.doSrchList = function() {
    // TODO - 조회 Submmision Send, 그리드 Refresh
		var vbSuccess = Common.processSubmission("smsSymMenuList");
		if(vbSuccess == false) return;   
		// TODO pageing 추가
		//var vsPageNo = moInsData.getValue("/root/searchVO/pageNo");
		//page.doFacadePageNum(vsPageNo);
		page.getControl("grxSymMenu").refresh();
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
	    //var vbValid = Valid.checkValidation(["ipbMenuCd", "ipbMenuNm","ipbUpMenuCd","ipbLinkUrl"], true); 

		if (vcIpbMenuCd.getValue() == "" || vcIpbMenuNm.getValue() == "" || vcIpbLinkUrl.getValue() == "") {
			alert("필수값이 누락되었습니다.");	
			return;
		} 
		if(confirm("저장하시겠습니까?")) {
	        var vbSuccess = Common.processSubmission("smsSymMenuSave"); 
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
	  if (vcIpbMenuCd.getValue() == ""){
		  alert("삭제 할 데이터를 선택하세요.");
	  }else{
		  if(confirm("삭제 하시겠습니까?")) {
				var vbSuccess = Common.processSubmission("smsSymMenuDel");  
				
				if(!vbSuccess) {
				   alert("삭제에 실패하였습니다."); 
				   return;
				}
				
				alert("정상적으로 삭제가 처리되었습니다."); 
				page.doSrchList(); 
				//page.doFacadePageNum(moReqData.getValue("/root/searchVO/pageNo")); 
			}	
			vcIpbMenuCd.readOnly = false;
			
			vcMethod = "add";		  
	  }

   };		
	
   this.doFncRead = function() { 
	 var vbSuccess = Common.processSubmission("smsSymMenuRead");  
	 if(vbSuccess == false) { 
	 	return;
	 }   
	 if (vcDstressymmenuvo == null || vcDstressymmenuvo == "") {
		 alert("결과가 존재하지 않습니다.");
	 } else {	 
	 //TODO - DATASET 이용확인.
	 // var vcResIdx = vcDstressymcommcdvo.getIndex() + 1;
      vcIpbMenuCd.setValue(moResData.getValue("/root/resSymMenuVO/row[1]/menuCd"));
	  vcIpbMenuNm.setValue(moResData.getValue("/root/resSymMenuVO/row[1]/menuNm"));
	  vcIpbUpMenuCd.setValue(moResData.getValue("/root/resSymMenuVO/row[1]/upMenuCd"));
	  //vcLblUpMenuNm.setValue(moResData.getValue("/root/resSymMenuVO/row[1]/upMenuNm"));
	  vcIpbMenuDesc.setValue(moResData.getValue("/root/resSymMenuVO/row[1]/menuDesc"));
	  vcIpbDplyNo.setValue(moResData.getValue("/root/resSymMenuVO/row[1]/dplyNo"));
	  vcIpbReMark.setValue(moResData.getValue("/root/resSymMenuVO/row[1]/reMark"));
	  vcIpbLinkUrl.setValue(moResData.getValue("/root/resSymMenuVO/row[1]/linkUrl"));
	  vcRdbUseYn.setValue(moResData.getValue("/root/resSymMenuVO/row[1]/useYn"));
		
	   //page.getControl("grp1").refresh();	
	  //grpCtl.
	  Common.refreshCtl(["ipbMenuCd","ipbMenuNm","ipbUpMenuCd","ipbMenuDesc","ipbDplyNo","ipbReMark","ipbLinkUrl","rdbUseYn"]);
	 }    
  	  vcMethod = "update";
   };
	
	
//	this.onClick_btnUMenuSrh = function(e /*:eXria.event.Event*/) {
//		P_PopupMenu(callbackPopupMenu);
//	};
	
	 function callbackPopupMenu(psPgmNm,psPgmCd) {
		
        var oInstance = page.getInstance("requestData");
        oInstance.setValue("/root/inquiryInfo/upMenuNm", psPgmNm);
 		oInstance.setValue("/root/inquiryInfo/upMenuCd", psPgmCd);

		page.getControl("ipbUpMenuCd").setValue(psPgmNm)
        g_sReqPgmNm = psPgmNm;
		
    }  
	
	/**
	 * 공통코드 검색 팝업의 콜백 함수
	 * @param psSbrnCd 소분류코드
	 * @param psSbrnNm 소분류코드명
	 */ 
	function P_callbackPopupMenu(psSbrnNm,psSbrnCd) {
	    this.P_oCallbackFuncObj( psSbrnNm,psSbrnCd);
	}
    
	/**
	 * 공통코드 검색 팝업을 띄운다.
	 * @param poFuncObj 팝업 콜백 함수 객체 (필수)
	 * @param psPopupName 팝업명 (선택)
	 */
	function P_PopupMenu(poFuncObj, psPopupName) {
	     
	    this.P_oCallbackFuncObj = poFuncObj;
	    
	    if (psPopupName == null || psPopupName == "") {
	        psPopupName = "메뉴코드검색";
	    }
	
	
	    var oWindow = page.window;
	    
	    P_oParamMap = new Object();
	    P_oParamMap.popupName = psPopupName;
	    
	    var nPopupWidth = 550;
	    var nPopupHeight = 600;
	    
	    var sLocation = "/estam-ndmi/xrf/popup/PopupMenu.xrf";
	    var sFeature = "status:no; scroll:no; help:no;"
	                 + "dialogWidth:" + nPopupWidth + "px;"
	                 + "dialogHeight:" + nPopupHeight + "px;"
	                 ;
	    
	    var sRtnVal = oWindow.showModalDialog(sLocation, oWindow, sFeature);
	} 
	
	
	
};
