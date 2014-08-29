/**
 * Object ipbNavigation()
 * @base eXria.form.Page
 * @constructor
 * @class ipbNavigation
 * @author Administrator at 11. 4. 11 오전 10:41
 */
var ipbNavigation = function() {
  // extends eXria.form.Page Object
  eXria.form.Page.call(this, "ipbNavigation"); //$NON-NLS-1$
  
  var mnIpbNaviTotalPage;
  
  // TODO 
  this.doIpbNavigation = function(){
    var voInsResponse = page.getInstance("insResponse");
    
    var voPagingInfo = voInsResponse.selectNodesStr("/root/pagingInfo/row");
    voPagingInfo = eval(voPagingInfo);
    
    var vnTotalCount = voPagingInfo[0].totalCount;   //총 문서 건수
    var vnTotalPage = voPagingInfo[0].totalPage;     //총 페이지
    var vnCurrentPage = voPagingInfo[0].currentPage; //현재 페이지
    var vnEndPage = voPagingInfo[0].endPage;         //마지막페이지
    
    mnIpbNaviTotalPage = Number(vnTotalPage);
    
    page.getControl("optIpbNaviTotPage").setValue(vnTotalPage);
    page.getControl("ipbIpbNaviSch").setValue(vnCurrentPage);    
    
            
  };
  
  this.onKeyDown_ipbIpbNaviSch = function(e /*:eXria.event.Event*/) {
    var vcIpb = page.getControl("ipbIpbNaviSch"); 
    if(229 === e.keyCode){
      vcIpb.setValue("");
      return;  
    }

    if(13 === e.keyCode){
      var vnPageNum = Number(vcIpb.getValue());
      if(vnPageNum > 0 && vnPageNum <= mnIpbNaviTotalPage)
      page.doGoPage(vnPageNum);       
    }
  };
  
  
  this.onClick_btnIpbNaviSch = function(e /*:eXria.event.Event*/) {
    var vcIpb = page.getControl("ipbIpbNaviSch");
      var vnPageNum = Number(vcIpb.getValue());
      if(vnPageNum > 0 && vnPageNum <= mnIpbNaviTotalPage)
        page.doGoPage(vnPageNum);      
  };
};
