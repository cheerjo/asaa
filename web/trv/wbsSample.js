/**
 * Object wbsSample()
 * @base eXria.form.Page
 * @constructor
 * @class wbsSample
 * @author Administrator at 10. 12. 13 오전 11:27
 */
var wbsSample = function() {
  // extends eXria.form.Page Object
  eXria.form.Page.call(this, "wbsSample"); //$NON-NLS-1$
  
  // TODO 
  
  
  this.onClick_btn1 = function(e /*:eXria.event.Event*/) {
    // TODO
    var vcCtl = page.getControl("trv1");
    vcCtl.dragDrop = true;
    vcCtl.onDrop = function(poEvent) {
      if(poEvent.objectType != "item") {
        alert("Not a item!");
        return;
      }
      var vsSrcTreeNo = poEvent.srcObject.getValue();
      var vsTrtTreeNo = poEvent.object.getValue();
      alert(poEvent.object.name);
    };
  };
  
  this.onClick_btn2 = function(e /*:eXria.event.Event*/) {
    // TODO
    var vcCtl = page.getControl("trv1");
    vcCtl.dragDrop = false;
//    vcCtl.scrollToItem("14");
  };
  
  this.onLoad = function() {
    // TODO
    var vcCtl = page.getControl("trv1");
    vcCtl.expandToDepth(2);
//    alert(UtilString.changeStr("adadad", "d", "b"));
  };
  
  this.onInit = function() {
    // TODO
    // TODO
    window.maMenuAttr = [];
//    // 최상위 메뉴
    window.maMenuAttr[0] = {
      className : "menu_depth01",
      focusClassName : "menu_depth01",
      backgroundColor : "transparent",
      height : 34
    };
//    // 자식 메뉴를 갖는 하위 메뉴
    window.maMenuAttr[1] = {
      className : "menu_depth02",
      backgroundColor : "#FFFFFF",
      height : 22
    };
//    // 자식 메뉴를 갖지 않는 하위 메뉴
    window.maMenuAttr[2] = {
      className : "menu_depth02",
      focusClassName : "menu_depth02_on",
      backgroundColor : "transparent",
      height : 22
    };
  };
	
	this.onChange_trvMenu_copy_1 = function(e /*:eXria.event.Event*/) {
		// TODO
		var checkValue = false;   //parent check 여부 
	    var voEvt = e.object;
		var voEvent = {};   
	    var vcTrv = page.getControl("trvMenu_copy_1");  
		var voTreeNode = vcTrv.getNodeByVal(voEvt.getValue()); 
	    voEvent.object = voTreeNode; 
		var voChildrens = voTreeNode.children;
        var vnSize = voChildrens.length;
		if (vnSize > 0) {
			UtilControl.setTreeCheckBoxChecked(voEvent);  
		} else {
 
    	var voCheckEvent = {};
        var voCheckedParentNode = voTreeNode.parent; 
		 
		var voCheckTreeNode = vcTrv.getNodeByVal(voCheckedParentNode.getValue()); 
		
	    voCheckEvent.object = voCheckTreeNode; 
		var voCheckChildrens = voCheckTreeNode.children;
        var vnCheckSize = voCheckChildrens.length;
	  
	    if (null != voCheckedParentNode) {  
			  var voCheckChildNode = null;
		      for (var i = 0; i < vnCheckSize; i++) {
		        voCheckChildNode = voCheckChildrens[i]; 
   				if (voCheckChildNode.isSelected()) {
		            checkValue = true;
				}
		      } 
			  if (!checkValue) { 
				UtilControl.setParentTreeCheckBoxChecked(voEvent);
			  } else { 
				 if (!voCheckTreeNode.isSelected()) {
				    UtilControl.setParentTreeCheckBoxChecked(voEvent);
				 }
			  }  
		  }	  
		}	
		 
	};
	
	this.onClick_trvMenu_copy_1 = function(e /*:eXria.event.Event*/) {
		// TODO
/*		var voNode = page.getControl("trvMenu_copy_1").openedItem;
		if(voNode == null || voNode == "" || voNode == undefined) {
			alert("선택된 노드가 없습니다.");
			return;
		} else {
			
	  
		} */
	}; 
	
	/**
	 * 
	 * @member wbsSample
	 * @param {eXria.event.Event} e
	 * @type void
	 * @author cyberlhs at 13. 8. 1 오전 11:37
	 */
	this.onClick_btnNodeAdd = function(e /*:eXria.event.Event*/) {
		// TODO
	 	var chkInValue = false;   //parent check 여부 
	    //var voEvt = e.object;
		var voEvent = {};
		var voNoEvent = {};   
		var vcMenuTrv = page.getControl("trv2");  
	    var vcNoMenuTrv = page.getControl("trvMenu_copy_1");  
		
	    var voNoArray = vcNoMenuTrv.items;
	    var vnNoCnt = voNoArray.cnt;
		var voNoNode;
		for(var kk = 0; kk < vnNoCnt; kk++) {
			voNoNode = voNoArray.get(kk);
			if(!voNoNode) continue;
			if(voNoNode.isSelected()){
			  
			  var voArray = vcMenuTrv.items;
			  var vnCnt = voArray.cnt;
			  var voNode; 
			  for(var jj = vnCnt - 1; jj >= 0; jj--) {
				voNode = voArray.get(jj);
				if(!voNode) continue;
				//var voNoParentNode = voNoNode.Parent;
			    //if (null == voNoParentNode) { 
				if (!voNoNode.isLeaf()) { 
				 	if(voNoNode.name == voNode.name) { 
						break;
                     	chkInValue = true;
					} else {
						 
					    var neMenuTrv =  voNoNode;//vcMenuTrv.createTreeNode(voNoNode.name);  
						var node = vcMenuTrv.root
		                node.addChild(neMenuTrv); 
				  		vcMenuTrv.addChangedNode(node.root);
						//vcMenuTrv.repaint();
					}   
			    } else {
				   
				} 
				  
			  }	 
			 
			  if (!chkInValue) {
				  
				//  alert(voNoNode.isAncestor(voNoNode));
			//	var voNoParentNode = voNoNode.Parent;
			//	alert(voNoNode.Parent);
			   // if (null == voNoParentNode) { 
				 if (!voNoNode.isLeaf()) {   //자식노드가 존재하면  
				 
					    var neMenuTrv =  voNoNode;//vcMenuTrv.createTreeNode(voNoNode.name);  
						var vpNode = vcMenuTrv.root;
		                vpNode.addChild(neMenuTrv); 
				  		vcMenuTrv.addChangedNode(vpNode.root); 
					    
			    } else {
					
				/*	var voNoParentNode = voNoNode.parent;
					var neMenuNoTrv = voNoNode;
				    var vcNode =  vcNoMenuTrv.getNodeByVal(voNoParentNode.getValue());
					vcNode.removeChild(neMenuNoTrv);
					vcNoMenuTrv.addChangedNode(vcNode.root);   */
					
				} 
				chkInValue = false;
			  }
			 
			}
			
		 }	
   /* var voaNode = vcNoMenuTrv.root.children[0];
    var voaEvent = {};
    voaEvent.object = voaNode;
	
	 var treeView = page.getControl("treeview");
     var newNode = treeView.createTreeNode("nodeName");
     var node = treeView.getNodeByVal("value");
     node.addChild(newNode);
	var vcCtrl = voaEvent.object;
    var vsId = vcCtrl.tree.id;
    var voDocument = vcCtrl.tree.document;
    var vnIndex = vcCtrl.index;
    
    var voTreeNode = vcCtrl;*/ 
      // var voTree = vcNoMenuTrv.tree; 
	  // vcNoMenuTrv.addChangedNode(voTree.root);
		vcNoMenuTrv.refresh();
		vcMenuTrv.refresh();
    //vcaTree.selectNode(voaNode, voaEvent);     
	 
			//vcMenuTrv.root.extData(voNoArray); 
		    
			//alert( vcMenuTrv.root.children[0].name ); 
		   // vcMenuTrv.reloadData(); 
		   
		 	//vcMenuTrv.refresh();
			
			 
			//vcMenuTrv.repaint(); 
			
		//}
		  
	   
	
		//var voNoTreeNode = vcNoMenuTrv.getNodeByVal(voEvt.getValue()); 
	    //voNoEvent.object = voNoTreeNode; 
		
		//var voNoParentNode = voNoTreeNode.parent; 
		
		//var voNoChildrens = voNoTreeNode.children;
		
		//alert(voNoParentNode.name);
		//alert(voNoChildrens[0].name);
        //var vnSize = voNoChildrens.length;
		//if (vnSize > 0) {
			//UtilControl.setTreeCheckBoxChecked(voNoEvent);  
		//} 
		
/*		else {
 
    	var voCheckEvent = {};
        var voCheckedParentNode = voNoTreeNode.parent; 
		 
		var voCheckTreeNode = vcTrv.getNodeByVal(voCheckedParentNode.getValue()); 
		
	    voCheckEvent.object = voCheckTreeNode; 
		var voCheckChildrens = voCheckTreeNode.children;
        var vnCheckSize = voCheckChildrens.length;
	  
	    if (null != voCheckedParentNode) {  
			  var voCheckChildNode = null;
		      for (var i = 0; i < vnCheckSize; i++) {
		        voCheckChildNode = voCheckChildrens[i]; 
   				if (voCheckChildNode.isSelected()) {
		            checkValue = true;
				}
		      } 
			  if (!checkValue) { 
				UtilControl.setParentTreeCheckBoxChecked(voEvent);
			  } else { 
				 if (!voCheckTreeNode.isSelected()) {
				    UtilControl.setParentTreeCheckBoxChecked(voEvent);
				 }
			  }  
		  }	  
		} */	
		
	};
};
