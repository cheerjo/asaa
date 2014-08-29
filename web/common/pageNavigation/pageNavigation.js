/**
 * Object pageNavigation()
 * @base eXria.form.Page
 * @constructor
 * @class pageNavigation
 * @author Administrator at 10. 10. 7 오전 11:44
 */
var pageNavigation = function() {
  // extends eXria.form.Page Object
  eXria.form.Page.call(this, "pageNavigation"); //$NON-NLS-1$

  this.mnOriGrpNumbresWidth;
  this.mnOriGrpNumbresLeft;

  this.onLoad = function() {
    var vcGrpNumbres = page.getControl("grpNumbres");
	
    page.mnOriGrpNumbresWidth = vcGrpNumbres.width;
    page.mnOriGrpNumbresLeft = vcGrpNumbres.left;
			
  };
  
  //******************************************************************************************
  //사용자 정의 함수 영역 start
  //******************************************************************************************    
  this.doPageNumValueChange = function(pnStartNum, pnEndNum){
    var voInsResponse = page.getInstance("insRes");
	var vcLblId = "lblPageNum";
    var vnIdNum = 1;

    for(var i = pnStartNum; i <= pnEndNum; i++){
      page.getControl(vcLblId + vnIdNum).setValue(i);
      vnIdNum = vnIdNum + 1;
    }  
    
    if(vnIdNum < 11){
      for(var k = vnIdNum; k <= 10; k++){
        page.getControl(vcLblId + vnIdNum).setValue("");
        vnIdNum = vnIdNum + 1;
      }  
    }
        
  };
  
  this.doPageNumReSize = function(psPageNum){
    var vnVisibleIdNum = 10;
    var vcLbl;
    var vcLblId = "lblPageNum";
    var vcGrpNumbres = page.getControl("grpNumbres");     
    
    for(var i = 10; i >= 1; i--){
      vcLbl = page.getControl(vcLblId+i);
      if(psPageNum == vcLbl.getValue()) {
        vcLbl.backgroundColor = "#689130";
        vcLbl.color = "#FFFFFF";
      } else {
        vcLbl.backgroundColor = "";
        vcLbl.color = "#555555";
      }
        
      if("" === vcLbl.getValue()){
        vcLbl.visible = false;
        vnVisibleIdNum = i - 1;
      }else{
        vcLbl.visible = true;
      }
    }
    
    vcLbl = page.getControl(vcLblId + vnVisibleIdNum);
        
    if(!!vcLbl ){
      vcGrpNumbres.width = vcLbl.left + vcLbl.width;
    }
    
    vcGrpNumbres.refresh();
  };
  
  this.doPageNumRepaint = function(){
    var vcGrpNexts = page.getControl("grpNexts");
    var vcGrpPrevs = page.getControl("grpPrevs");
    var vcGrpNumbres = page.getControl("grpNumbres");
    var vnGrpNumbresLeft = 0;
    
    if(vcGrpNumbres.width === page.mnOriGrpNumbresWidth)
      vcGrpNumbres.left = page.mnOriGrpNumbresLeft;
    else
      vcGrpNumbres.left = page.mnOriGrpNumbresLeft + (page.mnOriGrpNumbresWidth - vcGrpNumbres.width)/2
    
    vcGrpNumbres.refresh();
  };
  
  this.doPageNumVisible = function(pnTotalItems){
    var vcOpt = page.getControl("optPageTCNoSearch");
    
    if(0 == pnTotalItems)
      vcOpt.visible = true;
    else
      vcOpt.visible = false;
      
    vcOpt.refresh();
  };
  
  this.doFacadePageNum = function(psPageNum){
	var vnPageNum = parseInt(psPageNum);
	var voInsResponse = page.getInstance("insRes");
    var vnTotalItems = voInsResponse.getValue("/root/pagingInfo/row[1]/totalItems");
	vnTotalItems = parseInt(vnTotalItems);
	var vnPageSize = voInsResponse.getValue("/root/pagingInfo/row[1]/pageSize");
	vnPageSize = parseInt(vnPageSize);
	var vnPageUnit = voInsResponse.getValue("/root/pagingInfo/row[1]/pageUnit");
	vnPageUnit = parseInt(vnPageUnit);
	var vnStartNum = Math.floor(vnPageNum / vnPageUnit) * vnPageUnit + 1;
	var vnTotalPages = voInsResponse.getValue("/root/pagingInfo/row[1]/totalPages");
	vnTotalPages = parseInt(vnTotalPages);
	var vnEndNum = Math.floor(vnPageNum / vnPageUnit) * vnPageUnit + vnPageUnit;
	if(vnEndNum > vnTotalPages) vnEndNum = vnTotalPages;
    page.doPageNumVisible(vnTotalItems);
    page.doPageNumValueChange(vnStartNum, vnEndNum);
    page.doPageNumReSize(psPageNum);
    page.doPageNumRepaint();
    //optNoSearchOpt
  };

  //******************************************************************************************
  //사용자 정의 함수 영역 End
  //******************************************************************************************    

  //페이지Num 선택 Start
  this.onClick_lblPageNum1 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  this.onClick_lblPageNum2 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  this.onClick_lblPageNum3 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  this.onClick_lblPageNum4 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  this.onClick_lblPageNum5 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  this.onClick_lblPageNum6 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  this.onClick_lblPageNum7 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  this.onClick_lblPageNum8 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  this.onClick_lblPageNum9 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  this.onClick_lblPageNum10 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };  
  //페이지Num 선택 End
  
  this.onClick_imgBtnPrevEnd = function(e /*:eXria.event.Event*/) {
    page.doGoPage(1); 
  };
  
  this.onClick_imgBtnPrev = function(e /*:eXria.event.Event*/) {
    var voInsResponse = page.getInstance("insRes");
    var vnPageNum = voInsResponse.getValue("/root/pagingInfo/row[1]/currPage");  
	vnPageNum = parseInt(vnPageNum);
	vnPageNum--;
    if(1 == vnPageNum)
      return;     
    else{
      page.doGoPage(vnPageNum);
    } 
  };
  
  this.onClick_imgBtnNextEnd = function(e /*:eXria.event.Event*/) {
    var voInsResponse = page.getInstance("insRes");
    var vnTotalItems = voInsResponse.getValue("/root/pagingInfo/row[1]/totalItems");
	vnTotalItems = parseInt(vnTotalItems);
    var vnPageNum = voInsResponse.getValue("/root/pagingInfo/row[1]/currPage");
	vnPageNum = parseInt(vnPageNum);
	var vnPageSize = voInsResponse.getValue("/root/pagingInfo/row[1]/pageSize");
	vnPageSize = parseInt(vnPageSize);
    var vnTotalPages = voInsResponse.getValue("/root/pagingInfo/row[1]/totalPages");
	vnTotalPages = parseInt(vnTotalPages);
    
    if(vnPageNum == vnTotalPages)
      return;     
    else{
      page.doGoPage(vnTotalPages);
    }
  };
  
  this.onClick_imgBtnNext = function(e /*:eXria.event.Event*/) {
    var voInsResponse = page.getInstance("insRes");
    var vnTotalItems = voInsResponse.getValue("/root/pagingInfo/row[1]/totalItems");
	vnTotalItems = parseInt(vnTotalItems);
    var vnPageNum = voInsResponse.getValue("/root/pagingInfo/row[1]/currPage");
	vnPageNum = parseInt(vnPageNum);
	vnPageNum++;
	var vnPageSize = voInsResponse.getValue("/root/pagingInfo/row[1]/pageSize");
	vnPageSize = parseInt(vnPageSize);
    var vnTotalPages = voInsResponse.getValue("/root/pagingInfo/row[1]/totalPages");
	vnTotalPages = parseInt(vnTotalPages);
    
    if(vnPageNum == vnTotalPages)
      return;     
    else{
      page.doGoPage(vnPageNum);
    }
  };

};
