/**
 * Object temperature()
 * @base eXria.form.Page
 * @constructor
 * @class temperature
 * @author skip at 13. 6. 10 오후 6:03
 */
var temperature = function() {
  // extends eXria.form.Page Object
  eXria.form.Page.call(this, "temperature"); //$NON-NLS-1$
  
  // TODO 
  
  
  this.onClick_btn1 = function(e /*:eXria.event.Event*/) {
   var a = page.getControl("sbp1").setSrc("./temperature.html");
  };
  
  this.onInit = function() {
      page.getSubmission("getData").send();
      

  };
  
   this.getData = function() {
    var grx = page.getControl("grx1");
    var lenGrx = grx.getRowCnt();
    var root = new Array();
  
    root ["linecolor1"] = page.getControl("ipb4").getValue();
    root ["linecolor2"] = page.getControl("ipb5").getValue();
    root ["linecolor3"] = page.getControl("ipb6").getValue();
    root ["title"] = page.getControl("ipb1").getValue();
    
    var items = new Array();
    
    for (var i = 0; i < lenGrx; i++) {
      items [i] = {
        month : parseInt(grx.getValue(grx.getRowIndex(i), "ghc1")), seoul : parseInt(grx.getValue(grx.getRowIndex(i), "ghc2")),
        busan : parseInt(grx.getValue(grx.getRowIndex(i), "ghc3")), gwangju : parseInt(grx.getValue(grx.getRowIndex(i), "ghc4"))
      };
      
    }
    root ["items"] = items
    
    return root;
    
  };
  
  
};
