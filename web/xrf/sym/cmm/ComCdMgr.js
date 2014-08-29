/**
 * Object ComCdMgr()
 * @base eXria.form.Page
 * @constructor
 * @class ComCdMgr
 * @author cyberlhs at 13. 7. 23 오후 4:53
 */
var ComCdMgr = function() {
	// extends eXria.form.Page Object
	eXria.form.Page.call(this, "ComCdMgr"); //$NON-NLS-1$
 
	// TODO 
	/*
	 * 전역 변수 선언부
	 */
	 
	var moReqData; //인스턴스 객체
	var moResData; //인스턴스 객체 
	var moDstSymCommCdList; //데이터셋 객체
    var vcDstreqsymcommcdvo; //데이터셋 객체 
	var vcDstressymcommcdvo;
	var moResMsg //Message
	var moReqMethod //Method
	var mcGrxCommCd; //그리드 컨트롤	
	var vcIpbCommCd;
	var vcIpbCommNm; 
	var vcIpbCommInfo;
	var vcIpbSearchCdNm; 
	
	var vcMethod;
	 
	this.onLoad = function() {
		// TODO 
		moReqData           = page.getInstance("requestData"); 
		moResData           = page.getInstance("responseData");    //인스턴스 객체 
		moResMsg            = page.getInstance("resMessage");       //인스턴스 객체 
		moReqMethod         = page.getInstance("reqMethod")
	    moDstSymCommCdList  = page.getDataSet("dstSymCommCdList"); //데이터셋 객체 
	    mcGrxCommCd      	= page.getControl("grxSymCommCd");     //그리드 컨트롤
	    vcDstreqsymcommcdvo = page.getDataSet("dstReqSymCommCdVO"); 
		vcDstressymcommcdvo = page.getDataSet("dstResSymCommCdVO");
		//변수 컨트롤 객체 선언
		vcIpbSearchCdNm = page.getControl("ipbSearchCdNm");
		vcIpbCommCd = page.getControl("ipbCommCd");
		vcIpbCommNm = page.getControl("ipbCommNm");
		vcIpbCommInfo = page.getControl("ipbCommInfo");
	  
		page.doLoad();
		page.doSrchList();
	};
	this.doLoad = function() {
    // TODO
	    vcIpbSearchCdNm.setValue("");  
		vcMethod = ""; 
		page.doFncClear();
	};
	
	/*
	 * 조회조건 초기화 메서드
	 */	
	this.doFncClear = function() { 
		// TODO - input type control  조회조건 초기화
        vcIpbCommCd.setValue("");
		vcIpbCommNm.setValue(""); 
 		vcIpbCommInfo.setValue(""); 
		vcIpbCommCd.readOnly = false;
		vcIpbCommCd.refresh();
		vcMethod = "add";
	};	
	
	this.onClick_btnSrch = function(e /*:eXria.event.Event*/) {
		// TODO  
		page.doSrchList();
	};
	
	this.onGridexDblClick_grxSymCommCd = function(e /*:eXria.controls.xhtml.GridEx.event*/) {
 
	 // TODO 
	 var voEvent = e;
     var vcGrx = e.object; 
	 var vcGrxCommCd = vcGrx.getValue(voEvent.row,"ghcCommCd")
	 
	 if (vcGrxCommCd == null || vcGrxCommCd == "") {
		 return;
	 } 
	 vcIpbCommCd.readOnly = true;
	 vcIpbCommCd.setValue(vcGrxCommCd);  
	 Common.refreshCtl(["ipbCommCd"]); 
	 page.doFncRead(); 
	};
	
	/*
	 * 조회 메서드
	 */	
	this.doSrchList = function() {
    // TODO - 조회 Submmision Send, 그리드 Refresh
		var vbSuccess = Common.processSubmission("smsSymCommCdList");
		if(vbSuccess == false) return;   
		// TODO pageing 추가
		//var vsPageNo = moInsData.getValue("/root/searchVO/pageNo");
		//page.doFacadePageNum(vsPageNo);
		mcGrxCommCd.refreshData();
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
	
	/*
	 * 저장 메서드
	 */	
	this.doFncSave = function() {
	 // TODO - 저장 Submission Send	
	   // var vbValid = Valid.checkValidation(["ipbCommCd", "ipbCommNm"], true); 

		if (vcIpbCommCd.getValue() == "" || vcIpbCommNm.getValue() == "" ) {
			alert("필수값이 누락되었습니다.");	
			return;
		} 
		if(confirm("저장하시겠습니까?")) {
	        var vbSuccess = Common.processSubmission("smsSymCommCdSave"); 
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
	  if (vcIpbCommCd.getValue() == ""){
		  alert("삭제 할 데이터를 선택하세요.");
	  }else{
		  if(confirm("삭제 하시겠습니까?")) {
			var vbSuccess = Common.processSubmission("smsSymCommCdDel");  
			if(!vbSuccess) {
			   alert("삭제에 실패하였습니다."); 
			   return;
			} 
			
			alert("정상적으로 삭제가 처리되었습니다."); 
			page.doSrchList(); 
			//page.doFacadePageNum(moReqData.getValue("/root/searchVO/pageNo")); 
		}	
		vcIpbCommCd.readOnly = false;
		vcIpbCommCd.refresh();
		vcMethod = "add";
	  }
	  
   };		
	
   this.doFncRead = function() { 
 
	 var vbSuccess = Common.processSubmission("smsSymCommCdRead");  
	 if(vbSuccess == false) { 
	 	return;
	 }   
	 if (vcDstressymcommcdvo == null || vcDstressymcommcdvo == "") {
		 alert("결과가 존재하지 않습니다.");
	 } else {	 
	 //TODO - DATASET 이용확인.
	 // var vcResIdx = vcDstressymcommcdvo.getIndex() + 1;
	  vcIpbCommCd.setValue(moResData.getValue("/root/resSymCommCdVO/row[1]/commCd")); 
	  vcIpbCommNm.setValue(moResData.getValue("/root/resSymCommCdVO/row[1]/commNm"));
	  vcIpbCommInfo.setValue(moResData.getValue("/root/resSymCommCdVO/row[1]/commInfo"));
 
	  Common.refreshCtl(["ipbCommCd","ipbCommNm","ipbCommInfo"]);
	  }
	  
  	  vcMethod = "update";
   };		
	 
 
};
