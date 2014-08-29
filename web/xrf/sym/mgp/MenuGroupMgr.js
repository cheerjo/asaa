/**
 * Object MenuGroupMgr()
 * @base eXria.form.Page
 * @constructor
 * @class MenuGroupMgr
 * @author cyberlhs at 13. 6. 28 오전 11:34
 */
var MenuGroupMgr = function() {
	// extends eXria.form.Page Object
	eXria.form.Page.call(this, "MenuGroupMgr"); //$NON-NLS-1$
	
	// TODO 
	/*
	 * 전역 변수 선언부
	 */	
	
	var moReqData; //인스턴스 객체
	var moResData; //인스턴스 객체  
	var mcGrx; //그리드 컨트롤	
	var mcLeftTree, mcRightTree;
	var vcDstsymprivgrplist
	
	this.onLoad = function() {
		// TODO 하면 되는거죠. 제가 코딩좀 할께요..
		moReqData = page.getInstance("requestData");
		moResData = page.getInstance("responseData"); //인스턴스 객체  
		mcGrxLeftPrivGrp = page.getControl("grxLeftPrivGrp"); //그리드 컨트롤
		mcLeftTree = page.getControl("trvSelect");
		mcRightTree = page.getControl("trvNoSelect");
		
		vcDstsymprivgrplist = page.getDataSet("dstSymPrivGrpList");
		
		page.doLoad();
	};
	
	this.doLoad = function() {
		// TODO - 조회조건 Setting   
		//page.doFncClear();
		Common.processSubmission("smsSymPrivGrpList");
		page.getControl("grxLeftPrivGrp").refresh();
		
	};
	
	/*
	 * 조회조건 초기화 메서드
	 */	
	this.doFncClear = function() {
		// TODO - combobox 조회조건 초기화
		//        page.getControl("cbbSrchDept").setValue("");
		//		page.getControl("cbbSortType").setValue("1");
		//		page.getControl("cbbSrchKey").setValue("");
		//		page.getControl("cbbPageSize").setValue("10");
		//		
		//		page.getControl("ipbSrchWord").setValue("");
		//		page.getControl("dipFromHiredate").setValue("");
		//		page.getControl("dipToHireDate").setValue("");
		//		page.getControl("edmFromSal").setValue("");
		//		page.getControl("edmToSal").setValue(""); 
		
		// TODO - input type control  조회조건 초기화
	};
	/**
	 * 권한 그룹 조회
	 * @member MenuGroupMgr
	 * @param {eXria.event.Event} e
	 * @type void
	 * @author cyberlhs at 13. 8. 2 오후 2:43
	 */	
	this.onClick_btn2 = function(e /*:eXria.event.Event*/) {
		// TODO
		
		var vcprivGrpNo = mcGrxLeftPrivGrp.getValue(mcGrxLeftPrivGrp.focusRow, "ghcPrivGrpNo");
		page.getInstance("requestData").getValueNode("/root/reqSymPrivGrpVO/privGrpNo").setValue(vcprivGrpNo);
		
		var vbSuccess = Common.processSubmission("smsSymPrivMenuList");
		if (vbSuccess == false) return;
		
		mcLeftTree.refresh();
		mcRightTree.refresh();
		
		//var vbSuccess = Common.processSubmission("smsSymPrivMenuList");
		//if (vbSuccess == false) return;
		
		//mcGrxLeftPrivGrp.refresh();
	};
	/**
	 * 그리드 더블클릭 후 트리 출력 처리
	 * @member MenuGroupMgr
	 * @param {eXria.controls.xhtml.GridEx_event} e
	 * @type void
	 * @author cyberlhs at 13. 8. 3 오전 2:49
	 */	
	//	this.onGridexDblClick_grxLeftPrivGrp = function(e /*:eXria.controls.xhtml.GridEx.event*/) {
	//		// TODO
	//		
	//	};
	
	//	this.onGridexSelect_grxLeftPrivGrp = function(e /*:eXria.controls.xhtml.GridEx.event*/) {
	//		// TODO
	//		
	//	};
	
	this.onGridexAfterValueChanged_grxLeftPrivGrp = function(e /*:eXria.controls.xhtml.GridEx.event*/) {
		// TODO
		var voEvent = e;
		var vcGrx = e.object;
		var vcGhcCheck = vcGrx.getValue(voEvent.row, "ghcCheck")
		
		if (vcGhcCheck) {
			//메뉴쿼리 호출 
		}
		// var vcGrxLeftPrivGrp = vcGrx.getValue(voEvent.row,"ghcCheck")
		
		/** if (vcGrxCommCd == null || vcGrxCommCd == "") {
		 return;
		 }
		 vcIpbCommCd.readOnly = true;
		 vcIpbCommCd.setValue(vcGrxCommCd);
		 Common.refreshCtl(["ipbCommCd"]);
		 
		 var vbSuccess = Common.processSubmission("smsSymPrivMenuList");
		 if(vbSuccess == false) return;  */		
	};
	
	//	this.onClick_btn3 = function(e /*:eXria.event.Event*/) {
	//		// TODO
	//		
	//		Common.processSubmission("smsSymMenuList");
	//		page.getControl("trvSelect").refresh();
	//	};
	
	//	this.onClick_trvSelect = function(e /*:eXria.event.Event*/) {
	//		// TODO
	//		var voTrv = page.getControl("trvSelect");
	//		alert(voTrv.getValue());
	//				
	//	};
	
	this.onGridexDblClick_grxLeftPrivGrp = function(e /*:eXria.controls.xhtml.GridEx.event*/) {
		
		var voEvent = e;
		var vcGrx = e.object;
		var vcprivGrpNo = vcGrx.getValue(voEvent.row, "ghcPrivGrpNo");
		page.getInstance("requestData").getValueNode("/root/reqSymPrivGrpVO/privGrpNo").setValue(vcprivGrpNo);
		
		var vbSuccess = Common.processSubmission("smsSymPrivMenuList");
		if (vbSuccess == false) return;
		
		mcLeftTree.refresh();
		mcRightTree.refresh();
		
	};
	
	//	this.onChange_trvNoSelect = function(e /*:eXria.event.Event*/) {
	//	};
	
	this.onClick_btnShtLeft = function(e /*:eXria.event.Event*/) {
		
		var vsTrvVal = mcRightTree.getValue();
		
		if (vsTrvVal != null) {
			this.moveMenu("RTL", vsTrvVal);
		}
		else {
			alert("메뉴를 선택해주세요");
		}
		
	};
	this.onClick_btnShtRight = function(e /*:eXria.event.Event*/) {
		// TODO
		var vsTrvVal = mcLeftTree.getValue();
		
		if (vsTrvVal != null) {
			
			this.moveMenu("LTR", vsTrvVal);
		}
		else {
			alert("메뉴를 선택해주세요");
		}
	};
	
	this.moveMenu = function(cmd, value) {
		var voIns = page.getInstance("responseData");
		var voDesNode;
		var voSrcNode;
		var vnLen;
		var vsCmd;
		if (cmd == "LTR") {
			voSrcNode = "/root/resSymPrivMenuList/row";
			voDesNode = "/root/resSymPrivNonMenuList/row";
			vsCmd = "delete";
		}
		else if (cmd == "RTL") {
			voDesNode = "/root/resSymPrivMenuList/row";
			voSrcNode = "/root/resSymPrivNonMenuList/row";
			vsCmd = "insert";
		}
		else { 
			return;
		}
		vnLen = voIns.selectSingleNode(voSrcNode).getChildNodes().getLength();
		
		for (var i = 1; i <= vnLen; i++) {
			var tempNode = voIns.selectSingleNode(voSrcNode + "[" + i + "]/menuCd");
			if (tempNode.getNodeValue() == value) {
				
				var vsUpMenuCd = voIns.selectSingleNode(voSrcNode + "[" + i + "]/upMenuCd").getNodeValue();
				
				//중메뉴만 선택메뉴로 넘기기 위한 조건문
					if(cmd == "RTL"&&vsUpMenuCd!="ESTAM") {
						alert("중메뉴만 선택할 수 있습니다.");
						return;	
					}
					
					page.getInstance("requestData").getValueNode("/root/reqSymMenuList/menuCd").setValue(voIns.selectSingleNode(voSrcNode + "[" + i + "]/menuCd").getNodeValue());
					page.getInstance("requestData").getValueNode("/root/reqSymMenuList/upMenuCd").setValue(vsUpMenuCd);
					page.getInstance("reqMethod").getValueNode("/root/method").setValue(vsCmd);
					
					//메뉴이동
					var vbSuccess = Common.processSubmission("smsSymPrivMenuMove");
					if (vbSuccess == false) {
						alert("메뉴 이동 실패");
						return;
					}
					break; 
					
					
			}
		}
		//트리뷰 새로고침 
		var vbSuccess = Common.processSubmission("smsSymPrivMenuList");
		if (vbSuccess == false) {
			alert("트리뷰 초기화 실패");
			return;
		}
		
		mcLeftTree.refresh();
		mcRightTree.refresh();
	};
	
	//	this.onClick_btn4 = function(e /*:eXria.event.Event*/) {
	//		page.getControl("trvSelect").refresh();
	//	};
};
