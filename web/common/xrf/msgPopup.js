/**
 * Object msgPopup()
 * @base eXria.form.Page
 * @constructor
 * @class msgPopup
 * @author JOYJ at 10. 10. 12 오전 11:15
 */
var msgPopup = function() {
  // extends eXria.form.Page Object
  eXria.form.Page.call(this, "msgPopup"); //$NON-NLS-1$
  
  // TODO 
  var moMsg = null;
  
  this.onLoad = function() {
    // TODO
//    var vcTitle = page.getControl("lblTitle");
    var vcImg = page.getControl("imgIcon");
    moMsg = UtilPopUp.getPopupAttr(page);
    var psUrl = eXria.controls.xhtml.Util.getImagePath("/style/images/msg/", page.window);
    switch(moMsg.type) {
      case "error" :
//        vcTitle.setValue("Error");
        vcImg.setSrc(psUrl + "puicon4.gif");
        break;
      case "help" :
//        vcTitle.setValue("Error");
        vcImg.setSrc(psUrl + "puicon1.gif");
        break;
      case "info" :
//        vcTitle.setValue("Error");
        vcImg.setSrc(psUrl + "puicon2.gif");
        page.getControl("btnYes").applyAttr("visible", true);
        page.getControl("btnNo").applyAttr("visible", true);;
        page.getControl("btnConfirm").applyAttr("visible", false);
        break;
      case "warn" :
//        vcTitle.setValue("Error");
        vcImg.setSrc(psUrl + "puicon3.gif");
        break;
      default :
//        vcTitle.setValue("");
        vcImg.applyAttr("visible", false);
    }
    page.getControl("lblMsg").setValue(moMsg.msg);
  };
  
  this.onClick_btnYes = function(e /*:eXria.event.Event*/) {
    // TODO
    
    var voFunc = moMsg.callBackFunc;
    moMsg.retVal = true;
    if(voFunc) {
      voFunc();
    }
    UtilPopUp.closeLayeredPopup(moMsg.popupIdx, moMsg.page);
  };
  
  this.onClick_btnNo = function(e /*:eXria.event.Event*/) {
    // TODO
    var voFunc = moMsg.callBackFunc;
    moMsg.retVal = false;
    if(voFunc) {
      voFunc(moMsg);
    }
    UtilPopUp.closeLayeredPopup(moMsg.popupIdx, moMsg.page);
  };
  
  this.onClick_btnConfirm = function(e /*:eXria.event.Event*/) {
    // TODO
    var voFunc = moMsg.callBackFunc;
    moMsg.retVal = true;
    if(voFunc) {
      voFunc(moMsg);
    }
    UtilPopUp.closeLayeredPopup(moMsg.popupIdx, moMsg.page);
  };
};
