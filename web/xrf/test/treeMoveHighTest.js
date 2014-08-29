/**
 * Object treeMoveHighTest()
 * @base eXria.form.Page
 * @constructor
 * @class treeMoveHighTest
 * @author nogisun at 13. 8. 19 오후 3:54
 */
var treeMoveHighTest = function() {
	// extends eXria.form.Page Object
	eXria.form.Page.call(this, "treeMoveHighTest"); //$NON-NLS-1$
	
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
		var voNodeRightList = voIns.getCollectionNode("/root/treeRightData");
		
		//1. 좌측 treeView의 로우 size 만큼 루프를 돌면서 check된 데이터를 확인
		//2. check된 데이터가 있다면 parent node 인지 확인한다.
		//3. 최상위 parent node 이면 childe node를 모두 확인
		//4. 최하위 node 라면 parent node를 확인하고, 같은 동일한 위치의 node가 있는지 확인. 
		// - 동일한 위치의 노드가 있을 경우
		//    = 모두 체크 되어 있는지 : 해당 부모노드 까지 삭제, 우측으로 이동
		//    = 체크 되어 있지 않는 것이 하나라도 존재 하는 지 : 부모노드를 삭제하지 않고 우측에 부모노드 생성
		
		var vaParentData = new Array();
		var vaParentValue = new Array();
		var vaParentLabel = new Array();
		var vaParentIdx = new Array();
		var vaChkChildeData = new Array();
		var vaChkChildeValue = new Array();
		var vaChkChildeLabel = new Array();
		var vaChkChildeParentValue = new Array();
		var vaChkChildeIdx = new Array();
		var vaUnChkChildeData = new Array();
		var vaUnChkChildeValue = new Array();
		var vaUnChkChildeLabel = new Array();
		var vaUnChkChildeParentValue = new Array();
		var vaUnChkChildeIdx = new Array();
		var vaChkTempIdx = new Array();
		var vaUnChkTempIdx = new Array();
		
		var vsMenuId;
		var vsMenuNm;
		var vsParentVal;
		var vbFlag = false;
		
		var vnChkCnt = 0;
		var vnUnChkCnt = 0;
		var vnNotChk = 0;
		//좌측 node의 size 만큼 데이터 확인을 한다.
		for (var i = 1; i <= voNodeLeftList.size(); i++) {
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
			
			if (!(voChkCtrl.checked === false)) {
				vbFlag = true;
			}
			
			var nodeXml = "<row>"
				+ "<LABEL>"+vsMenuNm+"</LABEL>"
				+ "<VALUE>"+vsMenuId+"</VALUE>"
				+ "<PARENT>"+vsParentVal+"</PARENT>"
				+ "<STATUS></STATUS>"
				+ "</row>";
			
			if(!vsParentVal){
				//부모노드 라면
				vaParentData.push(nodeXml);
				vaParentValue.push(vsMenuId);
				vaParentLabel.push(vsMenuNm);
				vaParentIdx.push(i);
			}else{
				if (voChkCtrl.checked === false) {
					vaUnChkChildeData.push(nodeXml);
					vaUnChkChildeValue.push(vsMenuId);
					vaUnChkChildeLabel.push(vsMenuNm);
					vaUnChkChildeParentValue.push(vsParentVal);
					vaUnChkChildeIdx.push(i);			
				}else{
					vaChkChildeData.push(nodeXml);
					vaChkChildeValue.push(vsMenuId);
					vaChkChildeLabel.push(vsMenuNm);
					vaChkChildeParentValue.push(vsParentVal);
					vaChkChildeIdx.push(i);					
				}
			}
		}
		if(!vbFlag){
			alert("선택된 데이터가 없습니다.");
			return;
		}
		
		for (var i = voNodeLeftList.size(), n = 0; i > n; i--) {
			voIns.removeNode("/root/treeLeftData/row["+i+"]");
		}
		
		//나누어 담은 array 정보를 형태로 다시 모든 인스턴스 값을 넣는다.
		for(var i = 0; i < vaParentValue.length; i++){
			var vsTempVal = vaParentValue[i];
			for(var j = 0; j < vaChkChildeParentValue.length; j++){
				if(vsTempVal === vaChkChildeParentValue[j]){
					vaChkTempIdx.push(j);//해당 데이터가 있는 index 값 삽입
					vnChkCnt++;
				}
			}
			for(var j = 0; j < vaUnChkChildeParentValue.length; j++){
				if(vsTempVal === vaUnChkChildeParentValue[j]){
					vaUnChkTempIdx.push(j);//해당 데이터가 있는 index 값 삽입
					vnUnChkCnt++;
				}
			}
			
			if(vnUnChkCnt > 0 && vnChkCnt > 0){
				if(page.doFncChkChildeNodeDup(vaParentValue[i], vaParentLabel[i], "", true)){
					voIns.appendNodeByTxt("/root/treeRightData", vaParentData[i]);
				}
				voIns.appendNodeByTxt("/root/treeLeftData", vaParentData[i]);
				for(var k = 0; k < vaUnChkTempIdx.length; k++){
					voIns.appendNodeByTxt("/root/treeLeftData", vaUnChkChildeData[vaUnChkTempIdx[k]]);
				}
				for(var k = 0; k < vaChkTempIdx.length; k++){
					voIns.appendNodeByTxt("/root/treeRightData", vaChkChildeData[vaChkTempIdx[k]]);
				}
			}else if(vnUnChkCnt === 0 && vnChkCnt > 0){
				if(page.doFncChkChildeNodeDup(vaParentValue[i], vaParentLabel[i], "", true)){
					voIns.appendNodeByTxt("/root/treeRightData", vaParentData[i]);
				}
				for(var k = 0; k < vaChkTempIdx.length; k++){
					voIns.appendNodeByTxt("/root/treeRightData", vaChkChildeData[vaChkTempIdx[k]]);
				}				
			}else if(vnUnChkCnt > 0 && vnChkCnt === 0){
				voIns.appendNodeByTxt("/root/treeLeftData", vaParentData[i]);
				for(var k = 0; k < vaUnChkTempIdx.length; k++){
					voIns.appendNodeByTxt("/root/treeLeftData", vaUnChkChildeData[vaUnChkTempIdx[k]]);
				}
			}else{//자식노드가 없다면
				voIns.appendNodeByTxt("/root/treeLeftData", vaParentData[i]);
			}
			vaChkTempIdx = new Array();
			vaUnChkTempIdx = new Array();
			vnChkCnt = 0;
			vnUnChkCnt = 0;
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
		
		var voNodeLeftList = voIns.getCollectionNode("/root/treeLeftData");
		var voNodeRightList = voIns.getCollectionNode("/root/treeRightData");
		
		//1. 좌측 treeView의 로우 size 만큼 루프를 돌면서 check된 데이터를 확인
		//2. check된 데이터가 있다면 parent node 인지 확인한다.
		//3. 최상위 parent node 이면 childe node를 모두 확인
		//4. 최하위 node 라면 parent node를 확인하고, 같은 동일한 위치의 node가 있는지 확인. 
		// - 동일한 위치의 노드가 있을 경우
		//    = 모두 체크 되어 있는지 : 해당 부모노드 까지 삭제, 우측으로 이동
		//    = 체크 되어 있지 않는 것이 하나라도 존재 하는 지 : 부모노드를 삭제하지 않고 우측에 부모노드 생성
		
		var vaParentData = new Array();
		var vaParentValue = new Array();
		var vaParentLabel = new Array();
		var vaParentIdx = new Array();
		var vaChkChildeData = new Array();
		var vaChkChildeValue = new Array();
		var vaChkChildeLabel = new Array();
		var vaChkChildeParentValue = new Array();
		var vaChkChildeIdx = new Array();
		var vaUnChkChildeData = new Array();
		var vaUnChkChildeValue = new Array();
		var vaUnChkChildeLabel = new Array();
		var vaUnChkChildeParentValue = new Array();
		var vaUnChkChildeIdx = new Array();
		var vaChkTempIdx = new Array();
		var vaUnChkTempIdx = new Array();
		
		var vsMenuId;
		var vsMenuNm;
		var vsParentVal;
		var vbFlag = false;
		
		var vnChkCnt = 0;
		var vnUnChkCnt = 0;
		var vnNotChk = 0;
		//좌측 node의 size 만큼 데이터 확인을 한다.
		for (var i = 1; i <= voNodeRightList.size(); i++) {
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
			
			if (!(voChkCtrl.checked === false)) {
				vbFlag = true;
			}
			
			var nodeXml = "<row>"
				+ "<LABEL>"+vsMenuNm+"</LABEL>"
				+ "<VALUE>"+vsMenuId+"</VALUE>"
				+ "<PARENT>"+vsParentVal+"</PARENT>"
				+ "<STATUS></STATUS>"
				+ "</row>";
			
			if(!vsParentVal){
				//부모노드 라면
				vaParentData.push(nodeXml);
				vaParentValue.push(vsMenuId);
				vaParentLabel.push(vsMenuNm);
				vaParentIdx.push(i);
			}else{
				if (voChkCtrl.checked === false) {
					vaUnChkChildeData.push(nodeXml);
					vaUnChkChildeValue.push(vsMenuId);
					vaUnChkChildeLabel.push(vsMenuNm);
					vaUnChkChildeParentValue.push(vsParentVal);
					vaUnChkChildeIdx.push(i);			
				}else{
					vaChkChildeData.push(nodeXml);
					vaChkChildeValue.push(vsMenuId);
					vaChkChildeLabel.push(vsMenuNm);
					vaChkChildeParentValue.push(vsParentVal);
					vaChkChildeIdx.push(i);					
				}
			}
		}
		if(!vbFlag){
			alert("선택된 데이터가 없습니다.");
			return;
		}
		
		for (var i = voNodeRightList.size(), n = 0; i > n; i--) {
			voIns.removeNode("/root/treeRightData/row["+i+"]");
		}
		
		//나누어 담은 array 정보를 형태로 다시 모든 인스턴스 값을 넣는다.
		for(var i = 0; i < vaParentValue.length; i++){
			var vsTempVal = vaParentValue[i];
			for(var j = 0; j < vaChkChildeParentValue.length; j++){
				if(vsTempVal === vaChkChildeParentValue[j]){
					vaChkTempIdx.push(j);//해당 데이터가 있는 index 값 삽입
					vnChkCnt++;
				}
			}
			for(var j = 0; j < vaUnChkChildeParentValue.length; j++){
				if(vsTempVal === vaUnChkChildeParentValue[j]){
					vaUnChkTempIdx.push(j);//해당 데이터가 있는 index 값 삽입
					vnUnChkCnt++;
				}
			}
			
			if(vnUnChkCnt > 0 && vnChkCnt > 0){
				if(page.doFncChkChildeNodeDup(vaParentValue[i], vaParentLabel[i], "", false)){
					voIns.appendNodeByTxt("/root/treeLeftData", vaParentData[i]);
				}
				voIns.appendNodeByTxt("/root/treeRightData", vaParentData[i]);
				for(var k = 0; k < vaUnChkTempIdx.length; k++){
					voIns.appendNodeByTxt("/root/treeRightData", vaUnChkChildeData[vaUnChkTempIdx[k]]);
				}
				for(var k = 0; k < vaChkTempIdx.length; k++){
					voIns.appendNodeByTxt("/root/treeLeftData", vaChkChildeData[vaChkTempIdx[k]]);
				}
			}else if(vnUnChkCnt === 0 && vnChkCnt > 0){
				if(page.doFncChkChildeNodeDup(vaParentValue[i], vaParentLabel[i], "", false)){
					voIns.appendNodeByTxt("/root/treeLeftData", vaParentData[i]);
				}
				for(var k = 0; k < vaChkTempIdx.length; k++){
					voIns.appendNodeByTxt("/root/treeLeftData", vaChkChildeData[vaChkTempIdx[k]]);
				}				
			}else if(vnUnChkCnt > 0 && vnChkCnt === 0){
				voIns.appendNodeByTxt("/root/treeRightData", vaParentData[i]);
				for(var k = 0; k < vaUnChkTempIdx.length; k++){
					voIns.appendNodeByTxt("/root/treeRightData", vaUnChkChildeData[vaUnChkTempIdx[k]]);
				}
			}else{//자식노드가 없다면
				voIns.appendNodeByTxt("/root/treeRightData", vaParentData[i]);
			}
			vaChkTempIdx = new Array();
			vaUnChkTempIdx = new Array();
			vnChkCnt = 0;
			vnUnChkCnt = 0;
		}
		voLeftCtr.refreshData();
		voRightCtr.refreshData();
	};
	
	/**
	 * 부모노드의 동일한 값을 상대방이 가지는지 확인
	 * @member treeMoveTest
	 * @param {?} psId
	 * @param {?} psNm
	 * @param {?} psParent
	 * @param {?} pbFlag
	 * @type Boolean
	 * @return 
	 * @author nogisun at 13. 8. 21 오전 10:26
	 */
	this.doFncChkChildeNodeDup = function(psId, psNm, psParent, pbFlag){
		var voIns = page.getInstance("responseData");
		var voLeftCtr = page.getControl("trv1");
		var voRightCtr = page.getControl("trv2");
		var vbFlag = pbFlag; // left = false; right = true;
		
		var voNodeLeftList = voIns.getCollectionNode("/root/treeLeftData");
		var voNodeRightList = voIns.getCollectionNode("/root/treeRightData");
		
		if(vbFlag === true){
			for (var i = voNodeRightList.size(), n = 0; i >= n; i--) {
				vsMenuId = voIns.getValue("/root/treeRightData/row[" + i + "]/VALUE");
				vsMenuNm = voIns.getValue("/root/treeRightData/row[" + i + "]/LABEL");
				vsParentVal = voIns.getValue("/root/treeRightData/row[" + i + "]/PARENT");
			
				if(vsMenuId == psId && vsMenuNm == psNm && vsParentVal == psParent){
					return false;
				}
			}	
		}else if(vbFlag === false){
			for (var i = voNodeLeftList.size(), n = 0; i >= n; i--) {
				vsMenuId = voIns.getValue("/root/treeLeftData/row[" + i + "]/VALUE");
				vsMenuNm = voIns.getValue("/root/treeLeftData/row[" + i + "]/LABEL");
				vsParentVal = voIns.getValue("/root/treeLeftData/row[" + i + "]/PARENT");
			
				if(vsMenuId == psId && vsMenuNm == psNm && vsParentVal == psParent){
					return false;
				}
			}
		}
		return true;
	};
	
	/**
	 * Instance 중복체크
	 * @member treeMoveTest
	 * @param {?} psNode
	 * @param {?} paCol
	 * @type Boolean
	 * @return 
	 * @author nogisun at 13. 8. 21 오전 10:26
	 */
	this.doFncChkDup = function(psNode, paCol) {
		var voIns = page.getInstance("responseData");
		var voCollNode = voIns.getCollectionNode(psNode);
		var voMap, voTempNode, vsTempVal, vsChild = "";
		
		for (var i = 0; i < voCollNode.size(); i++) {
			voTempNode = voCollNode.get(i);
			voMap = new eXria.data.xhtml.MapNode(voTempNode);
			var vsColAry = paCol.split(',');
			for (var j = 0; j < vsColAry.length; j++) {
				vsTempVal = voMap.get(vsColAry [j]);
				if (vsChild.length > 0) {
					vsChild = vsChild + " and " + vsColAry [j] + "='" + vsTempVal + "'";
				} else {
					vsChild = vsColAry [j] + "='" + vsTempVal + "'";
				}
			}
			var vsTemp = voIns.selectNodes(psNode + "/row[child::" + vsChild + "]");
			
			if (vsTemp.getLength() > 1) {
				
				return false;
			}
			vsChild = "";
		}
		return true;
	};
	
	this.onChange_trv1 = function(e /*:eXria.event.Event*/) {
		// TODO
	};
	
	this.onChange_trv2 = function(e /*:eXria.event.Event*/) {
		// TODO
	};
	
	this.onClick_btn5 = function(e /*:eXria.event.Event*/) {
		var voIns = page.getInstance("responseData");		
		var voNodeLeftList = voIns.getCollectionNode("/root/treeLeftData");
		var voNodeRightList = voIns.getCollectionNode("/root/treeRightData");
		var vsLeftVal = "";
		var vsRightVal = "";		
		
		for (var i = voNodeLeftList.size(), n = 0; i > n; i--) {
			vsLeftVal += voIns.getValue("/root/treeLeftData/row[" + i + "]/LABEL") + "; ";
		}
		for (var i = voNodeRightList.size(), n = 0; i > n; i--) {
			vsRightVal += voIns.getValue("/root/treeRightData/row[" + i + "]/LABEL") + "; ";
		}
		
		alert("voNodeLeftList.size() : "+voNodeLeftList.size() +", voNodeRightList.size() : "+voNodeRightList.size());
		alert(vsLeftVal+" /// "+vsRightVal);
		
	};
};
