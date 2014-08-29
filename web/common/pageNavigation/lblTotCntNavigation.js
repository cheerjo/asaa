/**
 * Object lblTotCntNavigation()
 * @base eXria.form.Page
 * @constructor
 * @class lblTotCntNavigation
 * @author Administrator at 11. 4. 12 오전 10:15
 */
var lblTotCntNavigation = function() {
  // extends eXria.form.Page Object
  eXria.form.Page.call(this, "lblTotCntNavigation"); //$NON-NLS-1$
  
  // TODO 
  this.doLblTotCntNavigation = function(){
    var vcLbl = page.getControl("lblLblTotCntNavi");
    var voInsResponse = page.getInstance("insResponse");
    
    var voPagingInfo = voInsResponse.selectNodesStr("/root/pagingInfo/row");
    voPagingInfo = eval(voPagingInfo);
    
    var vnTotalCount = voPagingInfo[0].totalCount;   //총 문서 건수
    var vnTotalPage = voPagingInfo[0].totalPage;     //총 페이지
    var vnCurrentPage = voPagingInfo[0].currentPage; //현재 페이지
    var vnEndPage = voPagingInfo[0].endPage;         //마지막페이지
    
    vcLbl.setValue("총건수 : " + vnTotalCount + " 건");    
  };
};
