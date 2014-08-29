/**
 * Object impGrxFRow()
 * @base eXria.form.Page
 * @constructor
 * @class impGrxFRow
 * @author JOYJ at 10. 12. 1 오후 4:49
 */
var impGrxFRow = function() {
  // extends eXria.form.Page Object
  eXria.form.Page.call(this, "impGrxFRow"); //$NON-NLS-1$
  
  this.onLoad = function() {
  // TODO
  };
  
  // TODO 
  this.doComboNavigation = function() {
    
    var voInsResponse = page.getInstance("insResponse");
    
    var voPagingInfo = voInsResponse.selectNodesStr("/root/pagingInfo/row");
    voPagingInfo = eval(voPagingInfo);

//    var voPagingInfo = voInsResponse.getMapNode("/root/pagingInfo");     
//    var vnTotalCount = voInsResponse.getValue("/root/pagingInfo/totalCount");
//    var vnTotalPage = voInsResponse.getValue("/root/pagingInfo/totalPage");
//    var vnCurrentPage = voInsResponse.getValue("/root/pagingInfo/currentPage");
//    var vnEndPage = voInsResponse.getValue("/root/pagingInfo/endPage");
    
    var vnTotalCount = voPagingInfo[0].totalCount;
    var vnTotalPage = voPagingInfo[0].totalPage;
    var vnCurrentPage = voPagingInfo[0].currentPage;
    var vnEndPage = voPagingInfo[0].endPage;
    
    var vcCbb = page.getControl("cbbRowNum");
    page.getControl("lblPgRowCnt").setValue("/ " + vnTotalPage);
    page.getControl("lblTotCnt").setValue(vnTotalCount);    
        
    if (0 === Number(vnTotalCount)){
     Common.setCtlEnable(false, ["cbbRowNum"]);    
     return;
    }

    vcCbb.frontItems.clear();
    vcCbb.itemset.clear();
    vcCbb.backItems.clear();
    
    for (var i = 1; i <= vnTotalPage; i++) {
      vcCbb.addItemBack(i + "", i + "");
    }
    
    vcCbb.disabled = false;    
    vcCbb.refresh(); //vcCbb.refreshData();  
    vcCbb.listarea.select([vnCurrentPage - 1]);
  };
  
  this.onItemChange_cbbRowNum = function(e /*:eXria.event.Event*/) {
    var vnCheckNum = e.object.value;
    page.doGoPage(vnCheckNum);
  };
  
};
