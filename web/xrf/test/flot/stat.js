/**
 * Object stat()
 * @base eXria.form.Page
 * @constructor
 * @class stat
 * @author skip at 13. 6. 11 오후 3:31
 */
var stat = function() {
  // extends eXria.form.Page Object
  eXria.form.Page.call(this, "stat"); //$NON-NLS-1$
  
  // TODO 
  
  this.onInit = function() {
    page.getSubmission("getData").send();
  };
  
  this.onClick_btn1 = function(e /*:eXria.event.Event*/) {
    page.getControl("sbp1").setSrc("./stat.html");
  };
  
  this.getData = function() {
    var grx = page.getControl("grx1");
    var lenGrx = grx.getRowCnt();
    var root = new Array();
    
    var data1 = new Array();
    var data2 = new Array();
    var data3 = new Array();
    
    for (var i = 0; i < lenGrx; i++) {
      var year = grx.getValue(grx.getRowIndex(i), "ghc12")*1
      data1 [i] = [year, grx.getValue(grx.getRowIndex(i), "ghc1")*1];
      data2 [i] = [year, grx.getValue(grx.getRowIndex(i), "ghc4")*1];
      data3 [i] = [year, grx.getValue(grx.getRowIndex(i), "ghc5")*1];
      
    }
    root ["data1"] = data1;
    root ["data2"] = data2;
    root ["data3"] = data3;
    
    return root;
    
  };
  
  
  
   this.getData1 = function() {
    var grx = page.getControl("grx3");
    var lenGrx = grx.getRowCnt();
    var root = new Array();
    
    var locs = new Array();
    var data = new Array();
    
    for (var i = 0; i < lenGrx; i++) {
      locs [i] =grx.getValue(grx.getRowIndex(i), "ghc3");
      data [i] = [i, grx.getValue(grx.getRowIndex(i), "ghc6")*1];
    }
    root ["locs"] = locs;
    root ["data"] = data;
    
    return root;
    
  };
  
   this.getData2 = function() {
    var grx = page.getControl("grx4");
    var lenGrx = grx.getRowCnt();
    var root = new Array();
    
    var locs = new Array();
    var data = new Array();
    
    for (var i = 0; i < lenGrx; i++) {
     
      var str = grx.getValue(grx.getRowIndex(i), "ghc9");
      var spl  = str.split(",");
      
       locs [i] =spl.join("<br>");
      data [i] = [i, grx.getValue(grx.getRowIndex(i), "ghc10")*1];
    }
    root ["locs"] = locs;
    root ["data"] = data;
    
    return root;
    
  };
    this.getData3 = function() {
    var grx = page.getControl("grx2");
    var lenGrx = grx.getRowCnt();
    var root = new Array();
    
     var locs = new Array();
    var data = new Array();
    
    for (var i = 0; i < lenGrx; i++) {
      locs [i] =grx.getValue(grx.getRowIndex(i), "ghc2");
      data [i] = [0, grx.getValue(grx.getRowIndex(i), "ghc8")*1];
    }
    root ["locs"] = locs;
    root ["data"] = data;
    
    return root;
    
  };
  
  
};
