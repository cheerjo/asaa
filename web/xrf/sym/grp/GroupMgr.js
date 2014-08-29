/**
 * Object GroupMgr()
 * @base eXria.form.Page
 * @constructor
 * @class groupMgr
 * @author cyberlhs at 13. 6. 28 오전 11:33
 */
var GroupMgr = function() {
	// extends eXria.form.Page Object
	eXria.form.Page.call(this, "GroupMgr"); //$NON-NLS-1$
	
	// TODO 
	/*
	 * 전역 변수 선언부
	 */
	 
	var moReqData; //인스턴스 객체
	var moResData; //인스턴스 객체 
	var moResMsg //Message
	var moReqMethod //Method
	
	var vcDstsymprivgrplist; //데이터셋 객체 
    var vcDstsymprivgrpvo; //데이터셋 객체   
	var mcGrxSymPrivGrp; //그리드 컨트롤	
	
	var vcIpbPrivGrpNo; 
	var vcIpbPrivGrpNm;
	var vcIpbPrivGrpDesc;
	var vcIpbSchPrivGrpNm;
	
	var vcMethod;
	
	this.onLoad = function() {
		// TODO 하면 되는거죠. 제가 코딩좀 할께요..
		moReqData           = page.getInstance("requestData"); 
		moResData           = page.getInstance("responseData");    //인스턴스 객체 
		moResMsg            = page.getInstance("resMessage");       //인스턴스 객체 
		moReqMethod         = page.getInstance("reqMethod")
		vcDstsymprivgrplist = page.getDataSet("dstSymPrivGrpList");
		vcDstsymprivgrpvo   = page.getDataSet("dstSymPrivGrpVO"); 
	    mcGrxSymPrivGrp = page.getControl("grxSymPrivGrp"); 
		//변수 컨트롤 객체 선언
	    vcIpbPrivGrpNo = page.getControl("ipbPrivGrpNo");
	    vcIpbPrivGrpNm = page.getControl("ipbPrivGrpNm");
	    vcIpbPrivGrpDesc = page.getControl("ipbPrivGrpDesc");
	    vcIpbSchPrivGrpNm = page.getControl("ipbSchPrivGrpNm");
		page.doLoad();
		page.doSrchList();
	};
	
	this.doLoad = function() {
    // TODO  
	    vcIpbSchPrivGrpNm.setValue("");  
		vcMethod = ""; 
		page.doFncClear();
	};
	
	/*
	 * 조회조건 초기화 메서드
	 */	
	this.doFncClear = function() {
		// TODO - combobox 조회조건 초기화
        vcIpbPrivGrpNo.setValue("");
		vcIpbPrivGrpNm.setValue(""); 
 		vcIpbPrivGrpDesc.setValue(""); 
		vcIpbPrivGrpNo.readOnly = false;
		vcIpbPrivGrpNo.refresh();
		vcMethod = "add";
	};	
	
	this.onClick_btnSrch = function(e /*:eXria.event.Event*/) {
		// TODO - input type control  조회조건 초기화 
		page.doSrchList();
	};
	
	/**
	 * 
	 * @member GroupMgr
	 * @param {eXria.event.Event} e
	 * @type void
	 * @author cyberlhs at 13. 8. 13 오전 10:23
	 */
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
   
	
	this.onGridexDblClick_grxSymPrivGrp = function(e /*:eXria.controls.xhtml.GridEx.event*/) {
		// TODO 
	 var voEvent = e;
     var vcGrx = e.object; 
	 var vcGrxPrivGrpNo = vcGrx.getValue(voEvent.row,"ghcPrivGrpNo")
	 
	 if (vcGrxPrivGrpNo == null || vcGrxPrivGrpNo == "") {
		 return;
	 } 
	 vcIpbPrivGrpNo.readOnly = true;
	 vcIpbPrivGrpNo.setValue(vcGrxPrivGrpNo); 
	 page.getInstance("reqSymPrivGrpVO").getValueNode("/root/reqSymPrivGrpVO/privGrpNo").setValue(vcGrxPrivGrpNo); 
	 Common.refreshCtl(["ipbPrivGrpNo"]); 
	 page.doFncRead(); 
	};
	
	
	/*
	 * 조회 메서드
	 */	
	this.doSrchList = function() {
    // TODO - 조회 Submmision Send, 그리드 Refresh
		var vbSuccess = Common.processSubmission("smsSymPrivGrpList");
		if(vbSuccess == false) return;   
		// TODO pageing 추가
		//var vsPageNo = moInsData.getValue("/root/searchVO/pageNo");
		//page.doFacadePageNum(vsPageNo);
		mcGrxSymPrivGrp.refresh();
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
	    //var vbValid = Valid.checkValidation(["ipbPrivGrpNo", "ipbPrivGrpNm"], true); 
		
		if (vcIpbPrivGrpNo.getValue() == "" || vcIpbPrivGrpNm.getValue() == "") {
			alert("필수값이 누락되었습니다.");	
			return;
		} 
		if(confirm("저장하시겠습니까?")) {
	        var vbSuccess = Common.processSubmission("smsSymPrivGrpSave"); 
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
	  if (vcIpbPrivGrpNo.getValue() == ""){
		  alert("삭제 할 데이터를 선택하세요.");
	  }else{
		  
		  if(confirm("삭제 하시겠습니까?")) {
			var vbSuccess = Common.processSubmission("smsSymPrivGrpDel");  
			if(!vbSuccess) {
			   alert("삭제에 실패하였습니다."); 
			   return;
			} 
			
			alert("정상적으로 삭제가 처리되었습니다."); 
			page.doSrchList(); 
			//page.doFacadePageNum(moReqData.getValue("/root/searchVO/pageNo")); 
		}	
		vcIpbPrivGrpNo.readOnly = false;
		vcMethod = "add";	
	  }

   };		
	
   this.doFncRead = function() { 
 
	 var vbSuccess = Common.processSubmission("smsSymPrivGrpRead");  
	 if(vbSuccess == false) { 
	 	return;
	 }   
	 if (vcDstsymprivgrpvo == null || vcDstsymprivgrpvo == "") {
		 alert("결과가 존재하지 않습니다.");
	 } else {	 
	 //TODO - DATASET 이용확인.
	 // var vcResIdx = vcDstressymcommcdvo.getIndex() + 1;
	  vcIpbPrivGrpNo.setValue(moResData.getValue("/root/resSymPrivGrpVO/row[1]/privGrpNo"));
	  vcIpbPrivGrpNm.setValue(moResData.getValue("/root/resSymPrivGrpVO/row[1]/privGrpNm")); 
 	  vcIpbPrivGrpDesc.setValue(moResData.getValue("/root/resSymPrivGrpVO/row[1]/privGrpDesc")); 
		 
	  Common.refreshCtl(["ipbPrivGrpNo","ipbPrivGrpNm","ipbPrivGrpDesc"]);
	  }
  	  vcMethod = "update";
   };	
};
