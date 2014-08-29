/**
 * Object necis()
 * @base eXria.form.Page
 * @constructor
 * @class necis
 * @author skip at 13. 6. 13 오후 6:44
 */
var necis = function() {
  // extends eXria.form.Page Object
  eXria.form.Page.call(this, "necis"); //$NON-NLS-1$
  
  this.onInit = function() {
    
  };
  
  this.onClick_btn1 = function(e /*:eXria.event.Event*/) {
    this.deleteall(page.getControl("grx1"));
    this.makeRan(page.getControl("grx1"), 2, 7);
    
  };
  
  this.onClick_btn2 = function(e /*:eXria.event.Event*/) {
    this.callPage();
  };
  this.callPage = function() {
    page.getControl("sbp1").setSrc("./necis.html");
  };
  this.getData1 = function(data) {
    var grx = null;
    switch (data) {
      case "d1" : {
        grx = page.getControl("grx1"); break;
      }
      case "d2" : {
        grx = page.getControl("grx2"); break;
      }
      case "d3" : {
        grx = page.getControl("grx3"); break;
      }
      
    }
    
    var lenRow = grx.getRowCnt();
    var lenCol = grx.getHeadColumnList().length;
    
    var root = new Array();
    
    var data = new Array();
    
    for (var i = 0; i < lenRow; i++) {
      
      for (var j = 0; j < lenCol; j++) {
        var x = 10 * i + j;
        var y = parseFloat(grx.getValue(grx.getRowIndex(i), grx.getHeadColumnList() [j]));
        data.push([x, y]);
        
      }
    }
    root ["data"] = data;
    return root;
    
  };
  
  this.makeRan = function(grx, minY, maxY) {
    
    for (var i = 0; i < 10; i++) {
      var a = grx.addRow();
      for (var j = 1; j <= 10; j++) {
        grx.setValue(a, grx.getHeadColumnList() [j - 1], ((Math.random() * (maxY - minY) + minY)).toFixed(2), true);
      }
      
    }
  };
  this.deleteall = function(grx) {
    var rowcnt = grx.getRowCnt();
    for (var i = 0; i < rowcnt; i++) {
      grx.delRowByIndex(0);
    }
  };
  
  this.onClick_btn5 = function(e /*:eXria.event.Event*/) {
    this.deleteall(page.getControl("grx1"));
  };
  this.onClick_btn6 = function(e /*:eXria.event.Event*/) {
    this.deleteall(page.getControl("grx2"));
  };
  
  this.onClick_btn4 = function(e /*:eXria.event.Event*/) {
    this.callPage();
  };
  
  this.onClick_btn3 = function(e /*:eXria.event.Event*/) {
    this.deleteall(page.getControl("grx2"));
    this.makeRan(page.getControl("grx2"), 8.9, 9);
  };
  
  this.onClick_btn7 = function(e /*:eXria.event.Event*/) {
    var grx = page.getControl("grx3");
    var min1 = parseFloat(page.getControl("ipb1").getValue());
    var min2 = parseFloat(page.getControl("ipb3").getValue());
    var min3 = parseFloat(page.getControl("ipb5").getValue());
    var max1 = parseFloat(page.getControl("ipb2").getValue());
    var max2 = parseFloat(page.getControl("ipb4").getValue());
    var max3 = parseFloat(page.getControl("ipb6").getValue());
    
    if (min1 < 8 || max1 > 23 || min2 < 8 || max2 > 23 || min3 < 8 || max3 > 23) {
      alert("값이 범위를 넘었습니다.");
    }
    else {
      this.deleteall(grx);
      this.makeRan(grx, min1, max1);
      this.makeRan(grx, min2, max2);
      this.makeRan(grx, min3, max3);
    }
    
  };
  
  this.onClick_btn9 = function(e /*:eXria.event.Event*/) {
    this.deleteall(page.getControl("grx3"));
  };
  
  this.onClick_btn8 = function(e /*:eXria.event.Event*/) {
    this.callPage();
  };
};
