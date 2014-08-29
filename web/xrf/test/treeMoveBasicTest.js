/**
 * Object treeMoveBasicTest()
 * @base eXria.form.Page
 * @constructor
 * @class treeMoveBasicTest
 * @author nogisun at 13. 8. 19 오후 3:54
 */
var treeMoveBasicTest = function() {
	// extends eXria.form.Page Object
	eXria.form.Page.call(this, "treeMoveBasicTest"); //$NON-NLS-1$
	
	document.title = "Main Template";
	
	this.onLoad = function() {
		// TODO
	};
	
	this.onClick_btn3 = function(e /*:eXria.event.Event*/) {
		page.refresh();
	};
	
	this.onClick_btn4 = function(e /*:eXria.event.Event*/) {
		var voLeftTree = page.getControl("trv1");
		var voRightTree = page.getControl("trv2");
		
		voLeftTree.refresh();
		voRightTree.refresh();
	};
	
	/**
	 * 좌측 treeView 데이터 -> 우측 treeView 로 이동
	 * @member treeMoveTest
	 * @param {eXria.event.Event} e
	 * @type void
	 * @author nogisun at 13. 8. 20 오전 10:52
	 */	
	this.onClick_btnRight = function(e /*:eXria.event.Event*/) {
		var voIns = page.getInstance("responseData");
		var voLeftCtr = page.getControl("trv1");
		var voRightCtr = page.getControl("trv2");
		
		var voNodeLeftList = voIns.getCollectionNode("/root/treeLeftData");
				
		var vsMenuId;
		var vsMenuNm;
		var vsParentVal;
		var vnCnt = 0;
		
		//좌측 node의 size 만큼 데이터 확인을 한다.
		for (var i = voNodeLeftList.size(), n = 0; i > n; i--) {
			vsMenuId = voIns.getValue("/root/treeLeftData/row[" + i + "]/VALUE");
			vsMenuNm = voIns.getValue("/root/treeLeftData/row[" + i + "]/LABEL");
			vsParentVal = voIns.getValue("/root/treeLeftData/row[" + i + "]/PARENT");
			//만약 체크 여부 값을 가지고 뒷단에서 작업을 하고 싶다면 컬럼을 하나 더 두어서 처리
			//vnDataVal = voIns.getValue("/root/trvAUTH/row[" + i + "]/MENU_CHK");
			
			var vsId = voLeftCtr.id;
			var voDocument = voLeftCtr.document;
			var voTree = voLeftCtr;
			
			voDiv = voDocument.getElementById(vsId + "_node" + i);
			var voChkCtrl = voLeftCtr.getSubCtrl("input", voDiv, voDocument);
			
			//check 가 되어 있지 않다면 
			if (voChkCtrl.checked === false) {				
				
			} else {//check 가 되어 있다면
				var nodeXml = "<row>"
				+ "<LABEL>"+vsMenuNm+"</LABEL>"
				+ "<VALUE>"+vsMenuId+"</VALUE>"
				+ "<PARENT>"+vsParentVal+"</PARENT>"
				+ "<STATUS></STATUS>"
				+ "</row>";
				voIns.appendNodeByTxt("/root/treeRightData", nodeXml);
				
				voIns.removeNode("/root/treeLeftData/row["+i+"]");
				vnCnt++;
			}
		}
		if(!vnCnt){
			alert("선택된 데이터가 없습니다.");
		}
		
		voLeftCtr.refreshData();
		voRightCtr.refreshData();
	};
	
	/**
	 * 우측 treeView 데이터 -> 좌측 treeView 로 이동
	 * @member treeMoveTest
	 * @param {eXria.event.Event} e
	 * @type void
	 * @author nogisun at 13. 8. 20 오전 10:52
	 */	
	this.onClick_btnLeft = function(e /*:eXria.event.Event*/) {
		var voIns = page.getInstance("responseData");
		var voLeftCtr = page.getControl("trv1");
		var voRightCtr = page.getControl("trv2");
		
		var voNodeLeftList = voIns.getCollectionNode("/root/treeRightData");
				
		var vsMenuId;
		var vsMenuNm;
		var vsParentVal;
		var vnCnt = 0;
		
		//좌측 node의 size 만큼 데이터 확인을 한다.
		for (var i = voNodeLeftList.size(), n = 0; i > n; i--) {
			vsMenuId = voIns.getValue("/root/treeRightData/row[" + i + "]/VALUE");
			vsMenuNm = voIns.getValue("/root/treeRightData/row[" + i + "]/LABEL");
			vsParentVal = voIns.getValue("/root/treeRightData/row[" + i + "]/PARENT");
			//만약 체크 여부 값을 가지고 뒷단에서 작업을 하고 싶다면 컬럼을 하나 더 두어서 처리
			//vnDataVal = voIns.getValue("/root/trvAUTH/row[" + i + "]/MENU_CHK");
			
			var vsId = voRightCtr.id;
			var voDocument = voRightCtr.document;
			var voTree = voRightCtr;
			
			voDiv = voDocument.getElementById(vsId + "_node" + i);
			var voChkCtrl = voRightCtr.getSubCtrl("input", voDiv, voDocument);
			
			//check 가 되어 있지 않다면 
			if (voChkCtrl.checked === false) {				
				
			} else {//check 가 되어 있다면
				var nodeXml = "<row>"
				+ "<LABEL>"+vsMenuNm+"</LABEL>"
				+ "<VALUE>"+vsMenuId+"</VALUE>"
				+ "<PARENT>"+vsParentVal+"</PARENT>"
				+ "<STATUS></STATUS>"
				+ "</row>";
				voIns.appendNodeByTxt("/root/treeLeftData", nodeXml);
				
				voIns.removeNode("/root/treeRightData/row["+i+"]");
				vnCnt++;
			}
		}
		if(!vnCnt){
			alert("선택된 데이터가 없습니다.");
		}
		voRightCtr.refreshData();
		voLeftCtr.refreshData();
	};
	
	this.onChange_trv1 = function(e /*:eXria.event.Event*/) {
		// TODO
	};
	
	this.onChange_trv2 = function(e /*:eXria.event.Event*/) {
		// TODO
	};
};
