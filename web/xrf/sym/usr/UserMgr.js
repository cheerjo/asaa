/**
 * Object UserMgr()
 * @base eXria.form.Page
 * @constructor
 * @class UserMgr
 * @author cyberlhs at 13. 6. 28 오전 11:33
 */
var UserMgr = function() {
	// extends eXria.form.Page Object
	eXria.form.Page.call(this, "UserMgr"); //$NON-NLS-1$
	
	/*
	 * 전역 변수 선언부
	 */    
	var moReqData; //인스턴스 객체
	var moResData; //인스턴스 객체 
	var moDst; //데이터셋 객체
	var mcGrxSymUser; //그리드 컨트롤
	var vcDstressymuservo;
	
	var moResMsg //Message
	var moReqMethod //Method
	 
	//변수 선언 
	var vcCbbSearchGubun;
    var vcIpbSchWord;
	 
	var vcIpbUserId; 
	var vcIpbUserNm;
	var vcCbbPrivGrpNo;  
	var vcCbbOrgYn;
	var vcIpbOrgNm;
	var vcIpbUsrEmail;
	var vcEdmTelNo;
	var vcEdmMblNo;
	var vcScbUsrPwd; 
	//구분자
	var vcMethod;	 	
	
	// TODO  	
	this.onLoad = function() {
		// TODO 하면 되는거죠. 제가 코딩좀 할께요..
		moReqData     = page.getInstance("requestData"); 
		moResData     = page.getInstance("responseData"); //인스턴스 객체 
	    moDst         = page.getDataSet("dstSymUserList"); //데이터셋 객체
	    mcGrxSymUser  = page.getControl("grxSymUser"); //그리드 컨트롤
		
		vcDstressymuservo = page.getDataSet("dstResSymUserVo");
		
		moResMsg            = page.getInstance("resMessage");       //인스턴스 객체 
		moReqMethod         = page.getInstance("reqMethod")
		
	    vcCbbSearchGubun = page.getControl("cbbSearchGubun");
        vcIpbSchWord = page.getControl("ipbSchWord");

		vcIpbUserId = page.getControl("ipbUserId"); 
		vcIpbUserNm = page.getControl("ipbUserNm");
		vcCbbPrivGrpNo = page.getControl("cbbPrivGrpNo");  
		vcCbbOrgYn = page.getControl("cbbOrgYn");
		vcIpbOrgNm = page.getControl("ipbOrgNm");
		vcIpbUsrEmail = page.getControl("ipbUsrEmail");
		vcEdmTelNo = page.getControl("edmTelNo");
		vcEdmMblNo = page.getControl("edmMblNo");
		vcScbUsrPwd = page.getControl("scbUsrPwd"); 
	
		page.doSrchList();
		//page.doLoad();
	};
	
	this.doLoad = function() {
    // TODO - 조회조건 Setting 
		var vbSuccess = Common.processSubmission("smsSelectComboList");
		if(vbSuccess == false) return;  
		 
	    page.getControl("cbbPrivGrpNo").refresh();    
	    page.getControl("grxSymUser").refresh();  
		   
		vcCbbSearchGubun.setValue("USERNM");
        vcIpbSchWord.setValue("");
 
 		page.doFncClear();
	}; 

	/**
	 * 조회버튼 클릭시 조회조건에 따라 사용자 정보를 검색
	 * @member UserMgr
	 * @param {?} e
	 * @type void
	 * @author cyberlhs at 13. 7. 12 오후 5:31
	 */
	this.onClick_btnSrch = function(e /*:eXria.event.Event*/) {
		// TODO 
		if(moReqData.getValue("/root/searchVO/searchCondition") == ""){
			alert("조회 구분을 선택하세요.");
		}else{
			page.doSrchList();
		}
		
	};
	
	/*
	 * 조회 메서드
	 */	
	this.doSrchList = function() {
    // TODO - 조회 Submmision Send, 그리드 Refresh
		var vbSuccess = Common.processSubmission("smsSysUserList");
		if(vbSuccess == false) return; 
		
			// TODO pageing 추가
		//var vsPageNo = moInsData.getValue("/root/searchVO/pageNo");
		//page.doFacadePageNum(vsPageNo);
		 
	    page.getControl("cbbPrivGrpNo").refresh();    
		page.getControl("grxSymUser").refresh();
		
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
 
	//init 
	this.onClick_btnInit = function(e /*:eXria.event.Event*/) {
		// TODO 
		page.doFncClear();
	};
	//저장
	this.onClick_btnSave = function(e /*:eXria.event.Event*/) {
		// TODO
		moReqMethod.setValue("/root/method", vcMethod);
		page.doFncSave();
	};
	
	//삭제
	this.onClick_btnDelete = function(e /*:eXria.event.Event*/) {
		// TODO
		page.doFncDelete();
	};
	
    /*
	 * 초기화 메서드
	 */	
	this.doFncClear = function() {
		// TODO  
	   vcIpbUserId.setValue(""); 
	   vcIpbUserNm.setValue("");
	   vcScbUsrPwd.setValue("");
	   vcCbbPrivGrpNo.setValue("");
	   vcCbbOrgYn.setValue("");
	   vcIpbOrgNm.setValue("");
	   vcIpbUsrEmail.setValue("");
	   vcEdmTelNo.setValue("");
	   vcEdmMblNo.setValue(""); 

       vcIpbUserId.readOnly = false;
	   vcIpbUserId.refresh();
		vcMethod = "add";
	};
	 
	
	/**
	 * 저장메서드 - insert 
	 * @member UserMgr
	 * @type void
	 * @author cyberlhs at 13. 7. 23 오후 1:27
	 */
	this.doFncSave = function() {
	 // TODO - 저장 Submission Send	
		if (vcIpbUserId.getValue() == "" || vcIpbUserNm.getValue() == "" || vcScbUsrPwd.getValue() == "") {
			alert("필수값이 누락되었습니다.");	
			return;
		} 
		if(confirm("저장하시겠습니까?")) {
	        var vbSuccess = Common.processSubmission("smsSysUserSave"); 
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
 
	 
	/**
	 * 삭제메서드
	 * @member UserMgr
	 * @type void
	 * @author cyberlhs at 13. 7. 23 오후 1:27
	 */
	this.doFncDelete = function() {
		// TODO
		if(vcIpbUserId.getValue() == ""){
			alert("삭제 할 데이터를 선택하세요."); 
		}else{
			 if(confirm("삭제하시겠습니까?")) {
				var vbSuccess = Common.processSubmission("smsSysUserDel");  
				if(!vbSuccess) {
				   alert("삭제에 실패하였습니다."); 
				   return;
				} 
				alert("정상적으로 삭제가 처리되었습니다."); 
				
				vcIpbUserId.readOnly = false;
				vcMethod = "add"; 		
			
				page.doSrchList(); 
				//page.doFacadePageNum(moReqData.getValue("/root/searchVO/pageNo")); 
			}	
		
		}

	};	 
	
	/**
	 * 그리드 row 더블클릭시
	 * @member UserMgr
	 * @param {?} e
	 * @type void
	 * @author cyberlhs at 13. 7. 23 오후 1:26
	 */
	this.onGridexDblClick_grxSymUser = function(e /*:eXria.controls.xhtml.GridEx.event*/) {
		// TODO
		 // TODO 
	 var voEvent = e;
     var vcGrx = e.object; 
	 var vcGrxSymUserId = vcGrx.getValue(voEvent.row,"ghcUserId");
	 
	 if (vcGrxSymUserId == null || vcGrxSymUserId == "") {
		 return;
	 } 
	 vcIpbUserId.readOnly = true;
	 vcIpbUserId.setValue(vcGrxSymUserId);  
	 Common.refreshCtl(["ipbUserId"]); 
	 page.doFncRead();  
	};
	
	 this.doFncRead = function() { 
 
	 var vbSuccess = Common.processSubmission("smsSysUserRead");  
	 if(vbSuccess == false) { 
	 	return;
	 }   
	 if (vcDstressymuservo == null || vcDstressymuservo == "") {
		 alert("결과가 존재하지 않습니다.");
	 } else {	 
	 //TODO - DATASET 이용확인.
	 // var vcResIdx = vcDstressymcommcdvo.getIndex() + 1;
	 
	    vcIpbUserId.setValue(moResData.getValue("/root/resSymUserVO/row[1]/userId")); 
	    vcIpbUserNm.setValue(moResData.getValue("/root/resSymUserVO/row[1]/userNm"));
	    vcScbUsrPwd.setValue(moResData.getValue("/root/resSymUserVO/row[1]/usrPswd"));
	    vcCbbPrivGrpNo.setValue(moResData.getValue("/root/resSymUserVO/row[1]/privGrpNo"));
	    vcCbbOrgYn.setValue(moResData.getValue("/root/resSymUserVO/row[1]/orgYn"));
		vcIpbOrgNm.setValue(moResData.getValue("/root/resSymUserVO/row[1]/orgNm"));
	    vcIpbUsrEmail.setValue(moResData.getValue("/root/resSymUserVO/row[1]/usrEmail"));
	    vcEdmTelNo.setValue(moResData.getValue("/root/resSymUserVO/row[1]/telNo"));
	    vcEdmMblNo.setValue(moResData.getValue("/root/resSymUserVO/row[1]/mblNo")); 
	    
	    Common.refreshCtl(["ipbUserId","ipbUserNm","cbbPrivGrpNo","scbUsrPwd","cbbOrgYn","ipbOrgNm","ipbUsrEmail","edmTelNo","edmMblNo"]);
	    vcMethod = "update"; 
	  } 
  	  
   };		
};
