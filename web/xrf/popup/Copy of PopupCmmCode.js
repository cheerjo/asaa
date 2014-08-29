/**
 * Object PopupCmmCode()
 * @base eXria.form.Page
 * @constructor
 * @class PopupCmmCode
 * @author cyberlhs at 13. 8. 7 오후 9:45
 */
var PopupCmmCode = function() {
	// extends eXria.form.Page Object
	eXria.form.Page.call(this, "PopupCmmCode"); //$NON-NLS-1$
	
	// TODO 
	//this.moUserAttr = null;
	
	this.onLoad = function() {
		// TODO
		//moReqData           = page.getInstance("requestData"); 
		//moResData           = page.getInstance("responseData");    //인스턴스 객체 
		//moResMsg            = page.getInstance("resMessage");       //인스턴스 객체 
		//moReqMethod         = page.getInstance("reqMethod"); 
	    //mcGrxComCdDtl      	= page.getControl("grxComCdDtl");     //그리드 컨트롤 
		//변수 컨트롤 객체 선언
 
	    page.doFncInit(); 
	};
	
	this.doFncInit = function() {
		//page.moUserAttr = UtilPopUp.getPopupAttr(page);
		//var vsMethod = page.moUserAttr.method;
		
	//	if (vsMethod == "add") {
//			page.moUserAttr = UtilPopUp.getPopupAttr(page);
//			var voPage = page.moUserAttr.page;
//			var vsDeptList = voPage.getInstance("insData").getXML("/root/deptList");
//			//alert(vsDeptList);
//			var voInst = page.getInstance("insData");
//			voInst.removeNode("/root/deptList");
//			voInst.appendNodeByTxt("/root", vsDeptList);
//			//alert(voInst.getXML("/root/deptList"));
//			var vcCtl = page.getControl("frfDetail");
//			vcCtl.refresh();
//			page.getControl("cbbDeptno").setValue("");
		//}
	};
	 
	
	this.onClick_btnSrch = function(e /*:eXria.event.Event*/) {
		// TODO 
	};
	
	this.onClick_btnClose = function(e /*:eXria.event.Event*/) {
		// TODO
		//UtilPopUp.closeLayeredPopup(page.moUserAttr.popupIdx);
	};
	
	this.onClick_btnConform = function(e /*:eXria.event.Event*/) {
		// TODO
//		var vbValid = Valid.checkValidation(["ipbEname", "dipHiredate"], true);
//		
//		if (!vbValid) return;
//		var voSms = page.getSubmission("smsSave");
//		
//		page.getInstance("insReq").setValue("/root/method", page.moUserAttr.method);
//		
//		var vbSuccess = Common.processSubmission("smsSave");
//		
//		var voInst = page.getInstance("insRes");
//		var voNode = voInst.selectSingleNode("/root/validCheck");
//		if (voNode.hasChildNodes()) {
//			var voNodeList = voNode.getChildNodes();
//			var vnSize = voNodeList.getLength();
//			var voItem = null;
//			for (var i = 0; i < vnSize; i++) {
//				voItem = voNodeList.item(i);
//				voItem.setNodeValue(eval("NLS." + voItem.getNodeValue() + ".code"));
//			}
//			page.getControl("lblValidSal").refresh();
//			return;
//		}
//		
//		var voPage = page.moUserAttr.page;
//		voPage.doSrchList();
//		voPage.doFacadePageNum(voPage.getInstance("insData").getValue("/root/searchVO/pageNo"));
//		UtilPopUp.closeLayeredPopup(page.moUserAttr.popupIdx);
	};
};
