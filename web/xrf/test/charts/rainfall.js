/**
 * Object rainfall()
 * @base eXria.form.Page
 * @constructor
 * @class rainfall
 * @author skip at 13. 6. 7 오후 1:37
 */
var rainfall = function() {
  // extends eXria.form.Page Object
  eXria.form.Page.call(this, "rainfall"); //$NON-NLS-1$
  
  // TODO 
  
  this.onClick_btn1 = function(e /*:eXria.event.Event*/) {
    //   var d = new Date();
    //  d.setTime(1199113200000);
    //   alert(d.toLocaleDateString());
    
    // page.getControl("grx1").refresh();
    
    //    alert(page.getInstance("instance").selectSingleNode("root/items[0]/busan").getNodeValue());
    
    //alert(page.getControl("grx1").getValue(page.getControl("grx1").getHeaderRowByIndex(0),"ghc1")) ;
    //  page.getControl("grx1").createHeader().addCols()
    //  page.getControl("grx1").addHeader();
    //  page.getControl("grx1").refresh();
    
    var a = page.getControl("sbp1").setSrc("./rainfall.html");
    
  };
  
  this.onInit = function() {
    page.getSubmission("getData").send();
  };
  
  this.getData = function() {
    var grx = page.getControl("grx1");
    var lenGrx = grx.getRowCnt();
    var root = new Array();
    root ["angle"] = page.getControl("ipb2").getValue();
    root ["depth3D"] = page.getControl("ipb3").getValue();
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
