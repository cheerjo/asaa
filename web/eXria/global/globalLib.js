var HttpRequestFactory = {
  msxmlNames : [ "MSXML2.XMLHTTP.5.0", "MSXML2.XMLHTTP.4.0",
      "MSXML2.XMLHTTP.3.0", "MSXML2.XMLHTTP", "Microsoft.XMLHTTP" ],
  create : function() {
    /* Microsoft MSXML ActiveX */
    var voRequest = null;
    if (window.ActiveXObject !== undefined) {
      for ( var i = 0; i < this.msxmlNames.length; i++) {
        if (this.msxmlNames[i] != "MSXML2.XMLHTTP.6.0") {
          try {
            return new ActiveXObject(this.msxmlNames[i]);
          } catch (e) {
          }
        } else {
          try {
            return new ActiveXObject("Microsoft.XMLHTTP");
          } catch (e) {
          }
        }
        if (voRequest != null) {
          break;
        }
      }
    } else if (window.XMLHttpRequest) {
      /* Mozilla XMLHttpRequest */
      return new XMLHttpRequest();
    } else {
      /* None found */
      return null;
    }
  }
};

var voWindow = window;
var voFrm = null;

try {
  voFrm = voWindow.document.getElementById("_eXriaGlobalLibraryFrame_");
} catch(e) {}

if(voFrm == null) {
  var voParent = voWindow.parent;

  while(voParent != voWindow) {
    voWindow = voParent;

    try {
      voFrm = voWindow.document.getElementById("_eXriaGlobalLibraryFrame_");
    } catch(e) {}

    if(voFrm != null) break;

    voParent = voWindow.parent;
  }
}

if(voFrm == null) {
  var voOpener = voWindow.opener;
  var voDialogArg = voWindow.dialogArguments;
  var voParent = null;

  while (voOpener || voDialogArg) {
    voWindow = voOpener ? voOpener : voDialogArg.window;

    voParent = voWindow.parent;

    while(voParent != voWindow) {
      voWindow = voParent;

      try {
        voFrm = voWindow.document.getElementById("_eXriaGlobalLibraryFrame_");
      } catch(e) {}

      if(voFrm != null) break;

      voParent = voWindow.parent;
    }

    if(voFrm != null) break;

    voOpener = voWindow.opener;
    voDialogArg = voWindow.dialogArguments;
  }
}

if (voFrm != null) {
  $customEval(voFrm.contentWindow.exriaResource);
  $customEval(voFrm.contentWindow.cssResource);
} else {
  if (false) {
    var downloadLibs = [ "/exria.js", "/eXria/custom/eXria_CRE_Configuration.js" ];
    for ( var i = 0; i < downloadLibs.length; i++) {
      $include(downloadLibs[i]);
    }
  }
}
function $customEval(psResource) {
  if (window.execScript) { //IE
    window.execScript(psResource);
  } else {
    var vbSafari = navigator.userAgent.match(/\Safari/i) != null;
    if (vbSafari) { //SAFARI
      var voScript = document.createElement("script");
      voScript.appendChild(document.createTextNode(psResource));
      document.documentElement.appendChild(voScript);
    } else { //FIREFOX, OPERA
      window.eval(psResource);
    }
  }
}
function $include(psUrl) {
  var voRequest = HttpRequestFactory.create();

  voRequest.open("GET", psUrl, false);
  voRequest.send(null);

  var vsJs = voRequest.responseText;

  if (window.execScript) { //IE
    window.execScript(vsJs);
  } else {
    var vbSafari = navigator.userAgent.match(/\Safari/i) != null;
    if (vbSafari) { //SAFARI
      var voScript = document.createElement("script");
      voScript.appendChild(document.createTextNode(vsJs));
      document.documentElement.appendChild(voScript);
    } else { //FIREFOX, OPERA
      eXriaGlobal.eval(vsJs);
    }
  }
};

function $loadCSS(psUrl) {
  var vsCSSId = "eXriaDynamicCSS";

  var voHead = document.getElementsByTagName("head")[0];
  var voCSS = document.getElementById(vsCSSId);

  if (voCSS) {
    voHead.removeChild(voCSS);
  }

  var voCSSNode = document.createElement('link');
  voCSSNode.id = vsCSSId;
  voCSSNode.name = vsCSSId;
  voCSSNode.type = 'text/css';
  voCSSNode.rel = 'stylesheet';
  voCSSNode.href = psUrl;
  voCSSNode.media = 'screen';
  voHead.appendChild(voCSSNode);
};
