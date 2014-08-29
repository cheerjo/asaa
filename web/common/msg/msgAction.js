var moOpenerPage = null;
function init() {
  moOpenerPage = window.opener ? window.opener.page : window.dialogArguments;
  moOpenerPage.window.ComMsg.retVal = null;
  if(moOpenerPage == null) return;
  var voTd = document.getElementById("msgTd");
  var vaMsgLine = moOpenerPage.window.ComMsg.msgRef;
  var vnSize = vaMsgLine.length;
  if(vnSize > 1) voTd.align = "left";
  var vsMsg = "";
  for(var i = 0; i < vnSize; i++) {
    vsMsg += vaMsgLine[i];
    if(i + 1 < vnSize) vsMsg += "<br>";
  }
  if(moOpenerPage.window.ComMsg.instanceRef) {
    vsMsg += " <img src=\"../../style/image/msg/btn_detail.gif\" width=\"66\" height=\"23\" align=\"absmiddle\" onclick=\"showDetail()\">";
  }
  voTd.innerHTML = vsMsg;
  
  var vaSpan = document.getElementsByTagName("span");
  var voSpan = null;
  var vnSize = vaSpan.length;
  for(var i = 0; i < vnSize; i++) {
    voSpan = vaSpan[i];
    voSpan.tabIndex = 0;
    voSpan.onkeydown = function(e) {
      e = e ? e : window.event;
      if(e.keyCode == 13) {
        this.onclick();
      }
    }
    if(i == 0) voSpan.focus();
  }
};

function doClose() {
  window.close();
};

function doYes() {
  moOpenerPage.window.ComMsg.retVal = true;
  window.close();
};

function doNo() {
  moOpenerPage.window.ComMsg.retVal = false;
  window.close();
};

function showDetail() {
  var voBrowser = moOpenerPage.metadata.browser;
  var vsUrl = "msgDetail.html";
  var vsFeature = null;

  var vnDialogWidth = 450;
  var vnDialogHeight = 237;
  
  if(voBrowser.ie > 0 || voBrowser.gecko == 1.9 || voBrowser.webkit > 0) {
    vsFeature = "status:no;toolbar:no;scroll:no;dialogWidth:" + vnDialogWidth + "px;dialogHeight:";
    vsFeature += vnDialogHeight + "px";
    window.showModalDialog(vsUrl/* + vsParam*/, window, vsFeature);
  } else {
    vsFeature = "status=no,toolbar=no,scrollbars=no,width=" + vnDialogWidth + ",height=";
    vsFeature += vnDialogHeight;
    window.openDialog(vsUrl/* + vsParam*/, "", "modal;" + vsFeature);
  }
}