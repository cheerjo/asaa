/**
 * Object cbbNavigation()
 * @base eXria.form.Page
 * @constructor
 * @class cbbNavigation
 * @author johnson at 11. 4. 29 오후 1:54
 */
var cbbNavigation = function() {
  // extends eXria.form.Page Object
  eXria.form.Page.call(this, "cbbNavigation"); //$NON-NLS-1$
  
  // TODO 
  var mnCbbNaviCurrentPage = 0;
  
  this.doCbbNavigation = function(){
    var voInsResponse = page.getInstance("insResponse");
    
    var voPagingInfo = voInsResponse.selectNodesStr("/root/pagingInfo/row");
    voPagingInfo = eval(voPagingInfo);

    var vnTotalCount = voPagingInfo[0].totalCount;   //총 문서 건수
    var vnTotalPage = voPagingInfo[0].totalPage;     //총 페이지
    var vnCurrentPage = voPagingInfo[0].currentPage; //현재 페이지
    var vnEndPage = voPagingInfo[0].endPage;         //마지막페이지
    mnCbbNaviCurrentPage = vnCurrentPage;
    
    var vcCbb = page.getControl("cbbCbbNaviSch");
    
    if (0 === Number(vnTotalCount)){
     Common.setCtlEnable(false, ["cbbCbbNaviSch"]);    
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
  
  this.onClick_imgBtnPrevEnd = function(e /*:eXria.event.Event*/) {
    page.doGoPage(1); 
  };
  
  this.onClick_imgBtnPrev = function(e /*:eXria.event.Event*/) {
    var voInsResponse = page.getInstance("insResponse");
    var vsPageNum = voInsResponse.getValue("/root/pagingInfo/row/prevPage");    

    if(-1 == Number(vsPageNum))
      return;     
    else{
      page.doGoPage(vsPageNum);
    } 
  };
  
  this.onClick_imgBtnNext = function(e /*:eXria.event.Event*/) {
    var voInsResponse = page.getInstance("insResponse");
    var vsPageNum = voInsResponse.getValue("/root/pagingInfo/row/nextPage");    
  
    if(-1 == Number(vsPageNum))
      return;     
    else{
      page.doGoPage(vsPageNum);
    }
  };
  
  this.onClick_imgBtnNextEnd = function(e /*:eXria.event.Event*/) {
    var voInsResponse = page.getInstance("insResponse");
    var vsPageNum = voInsResponse.getValue("/root/pagingInfo/row/totalPage");
    var vsCurrentPage = voInsResponse.getValue("/root/pagingInfo/row/currentPage");    
    
    if(Number(vsCurrentPage) == Number(vsPageNum))
      return;     
    else{
      page.doGoPage(vsPageNum);
    }
  };
  
  
  this.onItemChange_cbbCbbNaviSch = function(e /*:eXria.event.Event*/) {
    var vnCheckNum = e.object.value;
    page.doGoPage(vnCheckNum);
  };
  
};
