Common = {
  /**
   * 일정시간동안 첫번째 파라메터 메소드를 체크 해서 true 가 되면
   * 두번째 파라메터의 메소드를 실행한다.
   * ex)Common.runAsynch(voChkFunc, voRunChFunc, 500); 
   * @param {Function} poChkFunc 체크 대상이 되는 메소드(반드시 리턴 타입이 boolean)
   * @param {Function} poRunFunc 체크가 true가 되면 실행될 메소드
   * @param {Number} pnInterval poChkFunc 함수가 체크될 시간 간격
   */
  runAsynch : function(poChkFunc, poRunFunc, pnInterval){
    if(!poChkFunc || !poRunFunc || !pnInterval)
      return;
    
    if("function" !== typeof (poChkFunc) 
      || "function" !== typeof (poRunFunc))
      return;
      
    var voFunc = function(){
      var vbRtn = poChkFunc();
      if(vbRtn) {
        window.clearInterval(Common.tmpFncInterval);
        delete(Common.tmpFncInterval);
        poRunFunc();
      };      
    };
    
    Common.tmpFncInterval = window.setInterval(voFunc, pnInterval);
  },
  
  /**
   * 특정 콤보박스의 아이템들을 입력받은 값들을 기준으로 선택하는 메소드.
   * ex) Common.selectComboItem("cbbCombo", ["CT203REGI"]);
   * @param {String} psControl 컨트롤 아이디.
   * @param {Arrary(String)} paValue 선택 할 아이템 값 저장 배열.
   */  
  selectComboItem : function(psControl, paValue) {
    var voCtl = page.getControl(psControl);
    
    var vnLength = voCtl.getVisibleItemCount();
    if (vnLength < 0)
    return false;
    
    var vnSize = paValue.length;
    var vaIndexs = [];
    for (var i = 0; i < vnSize; i++) {
      var vnIdx = voCtl.listarea.getIndex(paValue [i]);
      vaIndexs.push(vnIdx);
    }
    
    voCtl.listarea.select(vaIndexs);
  },
  
  /**
   * 특정 그리드의 로우카운트를 지정된 컨트롤에 반영.
   * ex) Common.refreshRowCount("grxMain", null, false); 로우 카운트를 표시할 라벨의 아이디가 "grxMainRowCnt" 일 경우
   * ex) Common.refreshRowCount("grxMain", "lblMainCnt", true);
   * @param {String} psGrx 표시될 로우카운트를 갖는 그리드 아이디.
   * @param {String} psLbl 로우 카운트를 반영할 라벨 아이디. null일 경우 (psGrx + "RowCnt")을 라벨명으로 처리.
   * @param {Boolean} pbDst 그리드와 연결된 데이터셋의 Row 수를 리턴할지 여부.
   * @return 그리드 로우 수.
   * @type Number
   */  
  refreshRowCount : function(psGrx, psLbl, pbDst) {
    if (psLbl == null) psLbl = psGrx + "RowCnt";
    var voGridCtl = page.getControl(psGrx);
    if (voGridCtl.cfg.paging == "fast") pbDst = true;
    else pbDst = false;
    var vnRowCnt = 0;
    var vnTotCnt = 0;
    var vsRowCnt = "";
    
    if (true) {
      var vsDatasetId = voGridCtl.datasetId;
      if (vsDatasetId) {
        var voDataSet = page.getDataSet(vsDatasetId);
        vnTotCnt = voDataSet.getRowCnt();
      } else {
        var voCollectionNode = voGridCtl.data.getNodesetData();
        if (!voCollectionNode) vnTotCnt = 0;
        else vnTotCnt = voCollectionNode.size();
      }
      var vaRow = voGridCtl.grid.GetShownRows();
      if (vaRow.length) {
        var voRow = vaRow [vaRow.length - 1];
        vnRowCnt = voGridCtl.getIndexOfRow(voRow) + 1;
      }
      vsRowCnt = "[ " + vnRowCnt + "/" + vnTotCnt + " ]";
    } else {
      vnRowCnt = voGridCtl.getRowCnt();
      vsRowCnt = "[ " + vnRowCnt + " ]";
    }
    
    var poLabel = page.getControl(psLbl);
    poLabel.setValue(vsRowCnt);
    
    var vsEventCnt = "scrollEventCnt_" + voGridCtl.id;
    if (page [vsEventCnt] == null) page [vsEventCnt] = 0;
    
    //  if(voGridCtl.cfg.paging == "fast" && voGridCtl.onGridexScroll == null) {
    if (voGridCtl.onGridexScroll == null) {
      voGridCtl.onGridexScroll = function(poEvent) {
        page [vsEventCnt]++;
        if (page [vsEventCnt] == 1) {
          var vsFunc = "page." + vsEventCnt + "=0;"
          vsFunc += "Common.refreshRowCount(\"" + psGrx + "\", ";
          if (psLbl) vsFunc += "\"" + psLbl + "\", ";
          else vsFunc += "null, ";
          if (pbDst) vsFunc += "" + pbDst + "";
          else vsFunc += "null";
          vsFunc += ")";
          setTimeout(vsFunc, 1000);
        }
      }
    }
    
    return vnRowCnt;
  },
  
  /**
   * 특정 컨트롤들의 읽기전용 속성 on/off.
   * 컨트롤의 ReadOnly 속성이 있는 경우 ReadOnly 속성에, 아닌 경우 Disabled 속성에 값 설정.
   * ex) Common.setCtlReadOnlyAuth(true, ["lblTest", "ipbName"]);
   * @param {Boolean} pbEnable ReadOnly 활성화 여부.
   * @param {Array(String)} paCtlId ReadOnly 속성 값이 설정될 컨트롤들의 id 지정 배열.
   */  
  setCtlReadOnlyAuth : function(pbReadOnly, paCtlId) {
    var vnArgc = paCtlId.length;
    for (var i = 0; i < vnArgc; i++) {
      var voCtl = page.getControl(paCtlId [i]);
      if (voCtl == null || "undefined" == voCtl) {
        continue;
      } else {
        if (voCtl.readOnly !== undefined) {
          voCtl.applyAttr("readOnly", pbReadOnly);
          if (voCtl.toString() == "Group" || voCtl.toString() == "Freeform") {
            var voIterator = voCtl.controls.iterator();
            while (voIterator.hasNext()) {
              var voControl = voIterator.next();
              var vsType = voControl.toString();
              if (vsType == "Label" || vsType == "Output") {
                continue;
              }
              
              if (voControl.readOnly == undefined || vsType == "ComboBox") {
                voControl.applyAttr("disabled", pbReadOnly);
              }
            }
          }
        } else if (voCtl.toString() == "GridEx") {
          var vnEditing = 1;
          if (pbReadOnly) vnEditing = 0;
          voCtl.cfg.editing = vnEditing;
          voCtl.refresh();
        } else {
          voCtl.applyAttr("disabled", pbReadOnly);
        }
      }
    }
  },
  
  /**
   * 특정 컨트롤들의 Enable 속성 on/off.
   * ex) Common.setCtlEnable(true, ["lblTest", "ipbName"]);
   * @param {Boolean} pbEnable 컨트롤 활성화 여부.
   * @param {Array(String)} paCtlId Enable 속성 값이 설정될 컨트롤들의 id 지정 배열.
   */  
  setCtlEnable : function(pbEnable, paCtlId) {
    var vnArgc = paCtlId.length;
    for (var i = 0; i < vnArgc; i++) {
      var voCtl = page.getControl(paCtlId [i]);
      if (voCtl == null || "undefined" == voCtl) {
        continue;
      } else {
        voCtl.applyAttr("disabled", !pbEnable);
      }
    }
  },
  
  /**
   * 특정 컨트롤들의 읽기전용 속성 on/off.
   * ex) Common.setCtlReadOnly(true, ["lblTest", "ipbName"]);
   * @param {Boolean} pbEnable ReadOnly 활성화 여부.
   * @param {Array(String)} paCtlId ReadOnly 속성 값이 설정될 컨트롤들의 id 지정 배열.
   */  
  setCtlReadOnly : function(pbEnable, paCtlId) {
    var vnArgc = paCtlId.length;
    for (var i = 0; i < vnArgc; i++) {
      var voCtl = page.getControl(paCtlId [i]);
      if (voCtl == null || "undefined" == voCtl) {
        continue;
      } else {
        if (voCtl.readOnly !== undefined) {
          voCtl.applyAttr("readOnly", pbEnable);
        } else if (voCtl.toString() == "GridEx") {
          var vnEditing = 0;
          if (pbEnable) vnEditing = 1;
          voCtl.cfg.editing = vnEditing;
          voCtl.refresh();
        }
      }
    }
  },
  
  /**
   * 특정 컨트롤들의 Visible 속성 on/off.
   * ex) Common.setCtlVisible(true, ["lblTest", "ipbName"]);
   * @param {Boolean} pbVisible 컨트롤 보이기 여부.
   * @param {Array(String)} paCtlId Visible 속성 값이 설정될 컨트롤들의 id 지정 배열.
   */  
  setCtlVisible : function(pbVisible, paCtlId) {
    var vnArgc = paCtlId.length;
    for (var i = 0; i < vnArgc; i++) {
      var voCtl = page.getControl(paCtlId [i]);
      if (voCtl == null || "undefined" == voCtl) {
        continue;
      } else {
        voCtl.applyAttr("visible", pbVisible);
      }
    }
  },
  
  /**
   * 그리드컨트롤 Editing 속성 on/off(Grid->Cfg->Editing 속성 변경).
   * 그리드컨트롤에만 해당.
   * refresh()가 내부 호출되므로 데이터 초기화가 수반됨**주의요
   * ex) Common.setGridEditing(true, ["grxMst", "grxBtm"]);
   * @param {Boolean} pbEditing 그리드 컨트롤 Editing 여부.
   * @param {Array(String)} paCtlId Editing 속성 값이 설정될 그리드 컨트롤들의 id 지정 배열.
   */  
  setGridEditing : function(pbEditing, paCtlId) {
    var vbEditing;
    
    if (pbEditing == true) vbEditing = 1;
    else vbEditing = 0;
    
    var vnArgc = paCtlId.length;
    for (var i = 0; i < vnArgc; i++) {
      var voCtlId = page.getControl(paCtlId [i]);
      voCtlId.cfg.editing = vbEditing;
      voCtlId.refresh();
    }
  },
  
  /**
   * 특정 컨트롤들을 refresh하는 메소드.
   * ex) var vaBodyCtl = ["ipbCrudTxt", "ipbStudentNo", "ipbNm"];
   * Common.refreshCtl(vaBodyCtl);
   * @param {Array(String)} paCtl refresh 대상 컨트롤들의 id 지정 배열.
   */  
  refreshCtl : function(paCtlId) {
    var vnSize = paCtlId.length;
    for (var i = 0; i < vnSize; i++) {
      var vsCtlID = paCtlId [i];
      page.getControl(vsCtlID).refresh();
    }
  },
  
  /**
   * 특정 컨트롤들을 초기화하는 메소드.
   * ex) var vaBodyCtl = ["ipbCrudTxt", "ipbStudentNo", "ipbNm"];
   * Common.clearCtl(vaBodyCtl);
   * @param {Array(String)} paCtlId 초기화 대상 컨트롤들의 id 지정 배열.
   */  
  clearCtl : function(paCtlId) {
    var vnSize = paCtlId.length;
    for (var i = 0; i < vnSize; i++) {
      var vsCtlID = paCtlId [i];
      page.getControl(vsCtlID).setValue("");
    }
  },
  
  /**
   * 데이터 셋에 변경된 내역이 있는지 체크하는 메소드.
   * ex) var vbChanged = Common.isChangeDataSetStatus("dstMain");
   * @param {String} psDst 데이터셋 아이디.
   * @param {Boolean} pbChkDel 삭제된 로우도 체크 대상에 포함여부(default true) 
   * @return 변경 내역이 있는지 여부.
   * @type Boolean
   */  
  isChangeDataSetStatus : function(psDst, pbChkDel) {
    //sjunpark 프로그램권한이 조회인 경우 false 리턴
    var voPageInfo = page.moPageInfo;
    if (voPageInfo != null) {
      if (voPageInfo.menuAuthDivRcd != "CC00701" && voPageInfo.menuAuthDivRcd == "CC00702")
      return false;
    }
    var voDataSet = page.getDataSet(psDst);
    var voPluginDataSet = voDataSet.dataSet;
    var vbRtVal = false;
    var vaStatus = [voPluginDataSet.ETBADDEDFLAG,
    voPluginDataSet.ETBDELETEDFLAG, voPluginDataSet.ETBMODIFIEDFLAG];
    var vsIndexes = null;
    
    for (var i = 0; i < 3; i++) {
      vsIndexes = voDataSet.getStatusIndex(vaStatus [i]);
      if (vsIndexes == null || vsIndexes == "") {
        continue;
      } else {
        vbRtVal = true;
        break;
      }
    }
    
    if(false !== pbChkDel  )
      if (voPluginDataSet.getDelTableRowCnt() > 0) vbRtVal = true;
    
    return vbRtVal;
  },
  
  /**
   * 데이터 셋의 변경된 status가 있는지 체크하여 없는 경우 알림창을 호출하는 메소드.
   * ex) var vbChanged = Common.alertChangeDataSetStatus("dstMain");
   * @param {String} psDst 데이터셋 아이디.
   * @return 변경 내역이 있는지 여부.
   * @type Boolean
   */  
  alertChangeDataSetStatus : function(psDst) {
    var vbStatus = Common.isChangeDataSetStatus(psDst);
//    if (vbStatus == false) ComMsg.alert(NLS.MSG.WRN.M007);
    if (vbStatus == false) ComMsg.showMsg("co.warn.nochanged");
    return vbStatus;
  },
  
  /**
   * 특정 데이터셋 변경 사항이 있는 지를 반환하는 메소드.
   * ex) var vbChanged = Common.getChangeDataSetStatus("dstMain", "insert");
   * @param {String} psDst 데이터셋 아이디.
   * @param {String} psStatus 데이터셋 상태 지정 문자열(insert / update / delete).
   * @return 특정 데이터셋 변경 사항의 존재 여부
   * @type Boolean
   */  
  getChangeDataSetStatus : function(psDst, psStatus) {
    var voDataSet = page.getDataSet(psDst);
    var voPluginDataSet = voDataSet.dataSet;
    var vnStatus = null;
    var vsIndexes = 0;
    
    switch (psStatus) {
      case "insert" :
      vnStatus = voPluginDataSet.ETBADDEDFLAG;
      break;
      case "update" :
      vnStatus = voPluginDataSet.ETBMODIFIEDFLAG;
      break;
      case "delete" :
      vnStatus = voPluginDataSet.ETBDELETEDFLAG;
      break;
    }
    
    vsIndexes = voDataSet.getStatusIndex(vnStatus);
    vsIndexes = vsIndexes.extractNumber();
    
    if (UtilValue.fixNumber(vsIndexes) > 0) return true;
    else return false;
  },
  
  /**
   * 서브미션에 리퀘스트 파라미터를 추가합니다.
   * ex) Common.addSubmissionReqParam("subOnLoad", "impCommon", "reqList");
   * @param psSubId {String} 서브미션 아이디
   * @param psInstanceId {String} 추가할 인스턴스 아이디
   * @param psNodeId {String} 추가할 노드 아이디
   */  
  addSubmissionReqParam : function(psSubId, psInstanceId, psNodeId) {
    var voSubmission = page.getSubmission(psSubId);
    var voInstance = page.getInstance(psInstanceId);
    var voNode = voInstance.getValueNode("/root/" + psNodeId);
    var vnChildNode = voNode.node.getChildNodes().getLength();
    if (vnChildNode > 0) {
      voSubmission.addRef(psInstanceId, "/root/" + psNodeId);
    } else {
      voSubmission.addParameter(psNodeId, voNode.getValue());
    }
  },
  
  /**
   * Submmission error message를 출력하는 메소드
   * @param {Boolean} pbErrCode Error Code 출력 유무
   * @param {Boolean} pbErrMsg Error Message 출력 유무
   * @param {Boolean} pbErrSrc Error Source 출력 유무
   * @param {String} psMsg 헤더의 Msg창에 보여줄 메시지
   * @private
   */  
  openSubmissionErrMsg : function(pbErrCode, pbErrMsg, pbErrSrc, psMsg) {
    var vbSuccess = true;
    var vnDefInstId = page.model.plugin.getDefInstanceID();
    var voInst = page.getInstance(vnDefInstId);
    var voMapNode = voInst.getMapNode("/root/tranResult");
    var vsMsg = page.model.getErrorMessage(pbErrCode, pbErrMsg, pbErrSrc);
    if (vsMsg != null) {
      vbSuccess = false;
      //	  ComMsg.alert(vsMsg);
//      var vsInstanceRef = page.id + ",instance,/root/EXRIAERRMSG,ERRCODE,ERRMSG,ERRSRC";
//      try {
//        ComMsg.alert(vsMsg, null, "error", vsInstanceRef); //브라우저에서 팝업창 차단 설정 시 exception이 발생하여 예외처리 초치
//      } catch (err) {
////        alert(NLS.MSG.WRN.M154);
//        ComMsg.showMsg("co.warn.popblocked");
//      }
      voMapNode.set("tranSuccess", "");
      voMapNode.set("errorMsg", "");
      var voNode = page.getInstance(vnDefInstId).selectSingleNode("/root/EXRIAERRMSG");
//      var vRpErrCd = page.model.getErrorMessage(true, false, false);
      var vnSize = voNode.getChildNodes().getLength();
      var voChildNode = null;
      for (var i = 0; i < vnSize; i++) {
        voChildNode = voNode.getChildNodes().item(0);
        voNode.removeChild(voChildNode);
      }
//      if (vRpErrCd == "CMN014") {
//        if (UtilPopUp.isPopUp() == false) {
//          parent.location.href = "../../index.html";
//        } else {
//          window.close();
//          window.opener.parent.location.href = "../../index.html";
//        }
//        return vbSuccess;
//      }
    } else {
      if (psMsg == null) psMsg = "";
      this.setMsgStatus(psMsg);
      var vsTranSuccess = voMapNode.get("tranSuccess");
      if(vsTranSuccess == "FALSE") vbSuccess = false;
    }
    return vbSuccess;
  },
  /**
   * 파일업로드 서브미션 send, 결과 처리.
   * @param {String} psSubID 서브미션 아이디.   
   * @param {Object} poJson {psMsg : 서브미션 직후 헤더의 Msg창에 보여줄 메시지,
                             pbProgress : 서브미션동안 프로그래스바를 보여줄지 여부,
                             psImg : 프로그래스에 사용할 이미지,
                             pnErrType : 서버에서 받아올 에러메시지타입(예 : ERR.ERRSRC|ERR.ERRCODE ),
                             psFilePath : 파일 업로드 사용시 업로드 할 파일 path(여러개의 파일 업로드시 ';'로 구분)}
   * @return 성공여부.
   * @type Boolean
   */
  processFileUploadSubmission : function(psSubID, poJson) {
    if(!poJson) poJson = {};    
    
    return this.processSubmission(psSubID, poJson);
  },
  /**
   * 서브미션 send, 결과 처리.
   * ex) Common.processSubmission("subMain");
   * @param {String} psSubID 서브미션 아이디.
   * @param {Object} poJson {psMsg : 서브미션 직후 헤더의 Msg창에 보여줄 메시지,
                             pbProgress : 서브미션동안 프로그래스바를 보여줄지 여부,
                             psImg : 프로그래스에 사용할 이미지,
                             pnErrType : 서버에서 받아올 에러메시지타입(예 : ERR.ERRSRC|ERR.ERRCODE ),
                             psFilePath : 파일 업로드 사용시 업로드 할 파일 path(여러개의 파일 업로드시 ';'로 구분),
                             poFunction : 서브미션 처리후 실행될 콜백 함수,
                             psInstance : 서브미션 처리 메세지를 저장할 인스턴스명,
                             paAddResRef : 서브미션 처리 메세지를 저장할 노드명}   
   * @return 성공여부.
   * @type Boolean
   */
  processSubmission : function(psSubID, poJson) {
    
    if(!poJson) poJson = {};
    
    var psMsg = poJson['psMsg'] || null;
    var pbProgress = poJson['pbProgress'] || null;
    var psImg = poJson['psImg'] || null;
    var pnErrType = poJson['pnErrType'] || null;
    var psFilePath = poJson['psFilePath'] || null;
    var poFunction = poJson['poFunction'] || null;
    var paAddResRef = poJson['paAddResRef'] || null;
    var psInstance =  poJson['psInstance'] || null;
		var psSvcInstance = poJson['psSvcInstance'] || null;
	
    
    var voInst,voNode,vsIns,voJson, voAddResRef;    
    if(!!page.isTranResultExist) {
       voInst = page.getInstance(page.model.plugin.getDefInstanceID());
       voNode = voInst.createElement("tranResult");
       voInst.appendNode("/root", voNode);
       voNode = voInst.createElement("tranSuccess");
       voInst.appendNode("/root/tranResult", voNode);
       voNode = voInst.createElement("errorMsg");
       voInst.appendNode("/root/tranResult", voNode);
       page.isTranResultExist = true;
    }

    var voSubmission = page.getSubmission(psSubID);
    
    if(!!page.isTranResultExist){
      vsIns = page.model.plugin.getDefInstanceID();
      voSubmission.addResRef(vsIns, "/root/tranResult", true);
    }
    voJson = {};

    if(!!paAddResRef && !!psInstance){
      voInst = page.getInstance(psInstance);      
      var vnLength = paAddResRef.length;
      for(var i=0; i<vnLength; i++){    
        voNode = voInst.createElement(paAddResRef[i]);
        voInst.appendNode("/root", voNode);
        voAddResRef = "/root/"+paAddResRef[i];
        voSubmission.addResRef(psInstance, voAddResRef);
        voJson[paAddResRef[i]] = voAddResRef;    
      }
    }
    
    //  var voUserInfo = null;
    //  var voMenuInfo = null;
    //  var vsEtrstUseYn = "";
    //  var vsEtrstUserId = "";
    //  var vsUserId = "";
    //  voUserInfo = this.getUserInfo();
    //  voMenuInfo = this.getMenuInfo();
    //  vsEtrstUserYn = voUserInfo.get("ETRST_USE_YN");
    //  vsUserId = voUserInfo.get("USER_ID");
    //  
    //  if(vsEtrstUserYn == null ) vsEtrstUserYn = "";
    //
    //  if(vsEtrstUserYn == "Y"){
    //    vsEtrstUserId = voUserInfo.get("ETRST_USER_ID") + ":" +vsUserId;
    //    voSubmission.addParameter("TEMP_USER_ID", vsEtrstUserId ? vsEtrstUserId : "");
    //  } else {
    //    voSubmission.addParameter("TEMP_USER_ID", vsUserId ? vsUserId : "");
    //  }
    //  
    //  if(page.model.plugin) voSubmission.addParameter("TEMP_IP_MAC", page.model.plugin.getMacAddr());
    //  voSubmission.addParameter("TEMP_PGM_ID", voMenuInfo.get("PGM_ID") ? voMenuInfo.get("PGM_ID") : "");
    //     
    var vbErrMsg = false;
    var vbErrCode = false;
    var vbErrSrc = false;
    if (pnErrType == null) pnErrType = ERR.ERRMSG;
    if ((pnErrType & ERR.ERRMSG) == ERR.ERRMSG) vbErrMsg = true;
    if ((pnErrType & ERR.ERRCODE) == ERR.ERRCODE) vbErrCode = true;
    if ((pnErrType & ERR.ERRSRC) == ERR.ERRSRC) vbErrSrc = true;
    if ((pnErrType & ERR.ERRALL) == ERR.ERRALL) {
      vbErrMsg = vbErrCode = vbErrSrc = true;
    }
    
    if (pbProgress) {
      page.model.progressAction(true, psImg);
    }
    
    if (psFilePath) {
      voSubmission.setUpLoadFileNames(psFilePath);
    }
    
	if (!!psSvcInstance) {
		voJson.psSvcInstance = psSvcInstance;
	}
	
    var vbSuccess = voSubmission.send();
    voJson.submissionId = psSubID;    
    if(!!poFunction){
      vbSuccess = poFunction(voJson);
      return vbSuccess;
    }
    
    if(page.AutoStTime !== false) page.StTime = new Date().getTime(); //성능 측정용 로그에 사용될 값
    //  voSubmission.removeParameter("TEMP_USER_ID");
    //  voSubmission.removeParameter("TEMP_IP_MAC");
    //  voSubmission.removeParameter("TEMP_PGM_ID");
    if (pbProgress) page.model.progressAction(false);
    
    if (!psFilePath && !!psMsg) {
      vbSuccess = this.openSubmissionErrMsg(true, vbErrMsg, vbErrSrc, psMsg);
    }
    return vbSuccess;
  },
  
  /**
   * import 헤더(header.xrf) 말풍선 옆에 특정 메세지를 표시한다.
   * 수행되는 메소드는 header.xrf 파일에 정의.
   * 메세지는 다국어 처리가 가능한 메세지(NLS)에서 가져와서 표시한다.
   * @member Common
   * @param {String} psMsg 표시할 메세지
   * @ignore
   */  
  setMsgStatus : function(psMsg) {
    if (page.showMsgStatus) {
      page.doSetMsgI002(psMsg);
    }
  },
  /**
   * import 헤더(header.xrf) 말풍선 옆에 특정 메세지를 초기화한다.
   * 수행되는 메소드는 header.xrf 파일에 정의.
   * @member Common
   * @ignore
   */  
  clearMsgStatus : function() {
    if (page.showMsgStatus) {
      page.doClearMsgI002();
    }
  },
  /**
   * subPage(id:sbpHeader) 헤더(header.xrf), 말풍선 옆에 특정 메세지를 표시한다.
   * 수행되는 메소드는 header.xrf 파일에 정의.
   * 메세지는 다국어 처리가 가능한 메세지(NLS)에서 가져와서 표시한다.
   * @member Common
   * @param {String} psMsg 표시할 메세지
   * @ignore
   */  
  setSbpMsgStatus : function(psMsg) {
    var vcSbpPage = page.parent.getControl("sbpHeader").getPage();
    if (vcSbpPage.showMsgStatus) {
      vcSbpPage.doSetMsgI002(psMsg);
    }
  },
  /**
   * subPage 헤더(header.xrf) 말풍선 옆에 특정 메세지를 초기화한다.
   * 수행되는 메소드는 header.xrf 파일에 정의.
   * @member Common
   * @ignore
   */  
  clearSbpMsgStatus : function() {
    
  },
  /**
   * 그룹 내의 입력용 컨트롤 초기화.
   * ex) Common.clearGroup("groupId");
   * Common.clearGroup(page.getControl("groupId"));
   * @param {Object, String} poGroup 그룹 객체(그룹명이여도 동작함).
   */  
  clearGroup : function(poGroup) {
    var voGroup;
    var voIterator;
    var voControl;
    
    if (typeof (poGroup) == "string") {
      voGroup = page.getControl(poGroup);
    } else if (typeof (poGroup) == "object") {
      voGroup = poGroup;
    } else {
      return;
    }
    
    voIterator = voGroup.controls.iterator();
    
    while (voIterator.hasNext()) {
      voControl = voIterator.next();
      var voData = voControl.data;
      var vsInstanceId = voData.instanceId;
      voData.instanceId = null;
      
      switch (voControl.constructor) {
        case eXria.controls.xhtml.DateInput :
        case eXria.controls.xhtml.EditMask :
        case eXria.controls.xhtml.InputBox :
        case eXria.controls.xhtml.SecretBox :
        case eXria.controls.xhtml.TextArea :
        voControl.onchangeInitValue = undefined;
        voControl.setValue("");
        break;
        case eXria.controls.xhtml.CheckBox :
        case eXria.controls.xhtml.ComboBox :
        case eXria.controls.xhtml.ListBox :
        case eXria.controls.xhtml.RadioButton :
        voControl.onchangeInitValue = undefined;
        voControl.setValue("");
        break;
      }
      voData.instanceId = vsInstanceId;
    }
  },
  
  /**
   * 그룹 내의 입력용 컨트롤 refresh.
   * ex) Common.refreshGroup("groupId");
   * Common.refreshGroup(page.getControl("groupId"));
   * @param {Object, String} poGroup 그룹 객체(그룹명이여도 동작함).
   */  
  refreshGroup : function(poGroup) {
    var voGroup;
    var voIterator;
    var voControl;
    
    if (typeof (poGroup) == "string") {
      voGroup = page.getControl(poGroup);
    } else if (typeof (poGroup) == "object") {
      voGroup = poGroup;
    } else {
      return;
    }
    
    voIterator = voGroup.controls.iterator();
    
    while (voIterator.hasNext()) {
      voControl = voIterator.next();
      
      switch (voControl.constructor) {
        case eXria.controls.xhtml.DateInput :
        case eXria.controls.xhtml.EditMask :
        case eXria.controls.xhtml.InputBox :
        case eXria.controls.xhtml.SecretBox :
        case eXria.controls.xhtml.TextArea :
        voControl.refresh();
        break;
        case eXria.controls.xhtml.CheckBox :
        case eXria.controls.xhtml.ComboBox :
        case eXria.controls.xhtml.ListBox :
        case eXria.controls.xhtml.RadioButton :
        voControl.refresh();
        break;
      }
    }
  },
  
  /**
   * instance에 설정해둔 context menu item 정보를 이용하여 context menu를 구성하는 메소드.
   * context menu item 정보는 반드시 insCode 내에 위치해야 한다.
   *
   * 인스턴스 구조
   * &lt;insCode&gt;
   * &lt;ctmGrdUser&gt;
   * &lt;item&gt;
   *  &lt;item_id&gt;detail&lt;/item_id&gt;
   *  &lt;parent_item_id/&gt;
   *  &lt;item_name&gt;이용자상세보기&lt;/item_name&gt;
   *  &lt;hot_key&gt;Enter&lt;/hot_key&gt;
   *  &lt;icon_url&gt;../../css/theme1/context_menu/icon_detail.png&lt;/icon_url&gt;
   * &lt;/item&gt;
   * &lt;item&gt;
   *  &lt;item_id&gt;s01&lt;/item_id&gt;
   *  &lt;item_name&gt;-&lt;/item_name&gt;
   * &lt;/item&gt;
   * &lt;item&gt;
   *  &lt;item_id&gt;family&lt;/item_id&gt;
   *  &lt;parent_item_id/&gt;
   *  &lt;item_name&gt;가족관리&lt;/item_name&gt;
   *  &lt;hot_key/&gt;
   *  &lt;icon_url/&gt;
   * &lt;/item&gt;
   * &lt;item&gt;
   *  &lt;item_id&gt;family_del&lt;/item_id&gt;
   *  &lt;parent_item_id/&gt;
   *  &lt;item_name&gt;가족삭제&lt;/item_name&gt;
   *  &lt;hot_key/&gt;
   *  &lt;icon_url/&gt;
   * &lt;/item&gt;
   * &lt;item&gt;
   *  &lt;item_id&gt;family_new&lt;/item_id&gt;
   *  &lt;parent_item_id/&gt;
   *  &lt;item_name&gt;가족추가&lt;/item_name&gt;
   *  &lt;hot_key/&gt;
   *  &lt;icon_url/&gt;
   * &lt;/item&gt;
   * &lt;/ctmGrdUser&gt;
   * &lt;/insCode&gt;
   *
   * family 아이템 삭제
   * family_new, family_del 아이템 비활성화
   * ex) Common.setContextMenuItem("ctmGrdUser", "/root/ctmGrdUser", "family", "family_del,famil_new");
   *
   * @param {String} psContextMenuId  컨텍스트 메뉴 아이디.
   * @param {String} psContextMenuXPath 컨텍스트 메뉴 아이템셋 경로.
   * @param {String} psExcludeItemIds 컨텍스트 메뉴에서 제외할 아이템 아이디.
   * @param {String} psDisabledItemIds 컨켁스트 메뉴에서 비활성화 할 아이템 아이디.
   */  
  setContextMenuItem : function(psContextMenuId, psContextMenuXPath,
  psExcludeItemIds, psDisabledItemIds) {
    var viCode = page.getInstance("insCode");
    var voContextMenu = page.getControl(psContextMenuId);
    var voCndItem = viCode.getCollectionNode(psContextMenuXPath);
    var voMndItem;
    var voItem;
    var vsItemId;
    var vsItemName;
    var vsItemHotKey;
    var vsItemIconUrl;
    var vbExclude;
    var vaExcludeItemId = psExcludeItemIds.split(",");
    var vbDisabled;
    var vaDisabledItemId = psDisabledItemIds.split(",");
    
    // 전체 메뉴아이템 삭제
    voContextMenu.removeAll();
    
    for (var iLoop = 0; iLoop < voCndItem.size(); iLoop++) {
      // 값 초기화
      vbExclude = false;
      vbDisabled = false;
      
      // 아이템 정보 획득
      voMndItem = new eXria.data.xhtml.MapNode(voCndItem.get(iLoop));
      vsItemId = voMndItem.get("item_id");
      vsItemName = voMndItem.get("item_name");
      vsItemHotKey = voMndItem.get("hot_key");
      vsItemIconUrl = voMndItem.get("icon_url");
      
      if (vsItemName == null || vsItemName.getByteLength() == 0) {
        vsItemName = null;
      }
      if (vsItemHotKey == null || vsItemHotKey.getByteLength() == 0) {
        vsItemHotKey = null;
      }
      if (vsItemIconUrl == null || vsItemIconUrl.getByteLength() == 0) {
        vsItemIconUrl = null;
      }
      
      // 생성시 제외할 아이템인지 여부 확인
      for (var iLoop2 = 0; iLoop2 < vaExcludeItemId.length; iLoop2++) {
        if (vaExcludeItemId [iLoop2] == vsItemId) {
          vbExclude = true;
        }
      }
      
      // disable 처리할 아이템인지 여부 확인
      for (var iLoop2 = 0; iLoop2 < vaDisabledItemId.length; iLoop2++) {
        if (vaDisabledItemId [iLoop2] == vsItemId) {
          vbDisabled = true;
        }
      }
      
      if (vbExclude == false) {
        if (vsItemName == "-") {
          vsItemId = null;
        } // Seperator 는 id를 null로 변경해줘야 된다.
        
        // 아이템 생성
        voItem = voContextMenu.createMenuItem(vsItemName, vsItemId,
        vsItemIconUrl, vsItemHotKey);
        
        // 아이템 disabled [true | false]
        if (vbDisabled == true) {
          voItem.disabled = true;
        }
        
        voContextMenu.addChild(voItem);
      }
    }
    voContextMenu.refresh();
  },
  
  /**
   * Grid에 Row 추가, 현재 Focus된 행의 다음 행에 Row추가후 CRUD_TXT에 "N" Setting.
   * ex) var voRow = Common.insertRow("grxMain", "ghcUptStatus");
   * @param {String} psGrxId 그리드 아이디.
   * @param {String} psColId 신규행을 나타내는 컬럼의 헤더명(생략가능).
   * @param {Number} pnRowIdx 행 삽입 위치(after).
   * @return 추가된 Row 객체
   * @type Object
   */  
  insertRow : function(psGrxId, psColId, pnRowIdx) {
    var voGrid = page.getControl(psGrxId);
    var vnRowIdx = pnRowIdx;
    var vbAfter = true;
    var vbEmpty = false;
    if (vnRowIdx == null) vnRowIdx = voGrid.getFocusRowIndex();
    if (vnRowIdx == null) {
      var voFRow = voGrid.getFocusRow();
      if (voFRow) {
        vnRowIdx = voGrid.getIndexOfRow(voFRow.lastChild);
      } else {
        //vnRowIdx = voGrid.getRowCnt() - 1;
        //grouping된 그리드시 문제
        //		vnRowIdx = voGrid.dataset.getRowCnt() - 1;
        vnRowIdx = 0;
        vbAfter = false;
        if (voGrid.getRowCnt() == 0 && voGrid.getDataRowCnt() == 0) vbEmpty = true;
      }
    }
    //    if(vnRowIdx < 0) vnRowIdx = 0;
    
    var voInsertRow = null;
    
    var voRow = null;
    if (vbEmpty) voRow = voGrid.addRow(null, null, true);
    else voRow = voGrid.insertRow(vnRowIdx, vbAfter);
    if (voRow == null) pnRowIdx = vnRowIdx + 2;
    vnRowIdx = voGrid.getIndexOfRow(voRow);
    //    voGrid.setFocusRowIndex(vnRowIdx, true);
    
    if (null != psColId && "" != psColId && undefined != psColId) {
      if (voRow != null) {
        UtilGrid.setValue(psGrxId, voRow, psColId, "N");
        // 그리드의 setValue() 호출시 afterValueChanged() 이벤트를 자동으로 호출하기 때문에 로직 수행이 원활하지 않습니다.
        //voGrid.setValue(voRow, psColId, "N", true);
      } else {
        var voBodyCol = voGrid.getBodyColumn(null, psColId);
        var vsDataSetCol = voBodyCol.datasetCol;
        voGrid.dataset.set(pnRowIdx, vsDataSetCol, "N");
      }
    }
    return voRow;
  },
  
  /**
   * 로우가 편집이 되었을때 해당 컬럼에 "U"를 표시해준다.
   * 이 함수는 onGridexValueChanged 이벤트 안에서 호출되어야 한다.
   * ex) Common.markUpdate(e, "ghcUptStatus");
   * @param {Object} poEvent 그리드 이벤트.
   * @param {Object} psColId "U"를 표시하는 컬럼의 해드컬럼 아이디.
   */  
  markUpdate : function(poEvent, psColId) {
    var voControl = poEvent.object;
    var voBodyCol = voControl.getBodyColumn(null, psColId);
    var vsDataSetCol = voBodyCol.datasetCol;
    var voDataSet = voControl.dataset;
    var voRow = poEvent.row;
    var vnRowIndex = voControl.getIndexOfRow(voRow);
    vnRowIndex++;
    
    var vsUptStatus = voControl.getValue(voRow, psColId);
    if (psColId) {
      if (vsUptStatus != "N")
      if (voDataSet.getStatus(vnRowIndex) == voDataSet.dataSet.ETBMODIFIEDFLAG) {
        //          voControl.setValue(voRow, psColId, "U", true);
        voControl.grid.SetValue(voRow, psColId, "U", true);
        voDataSet.simpleSet(vnRowIndex, vsDataSetCol, "U");
      } else if (voDataSet.getStatus(vnRowIndex) == voDataSet.dataSet.ETBDELETEDFLAG) {
        voDataSet.setRowAttr(vnRowIndex, "old___Status", "U");
      } else if (voDataSet.getStatus(vnRowIndex) == voDataSet.dataSet.ETBUNCHANGEDFLAG) {
        voControl.grid.SetValue(voRow, psColId, "", true);
        voDataSet.simpleSet(vnRowIndex, vsDataSetCol, "");
        voDataSet.setRowAttr(vnRowIndex, "old___Status", "");
      }
    }
  },
  
  /**
   * 로우가 삭제 되었을때 해당 컬럼에 "D"를 표시해둔다.
   * ex) Common.markDelete("grxMain", "ghcUptStatus");
   * @param {Object} psGrxId 그리드 아이디.
   * @param {Object} psColId "D"를 표시하는 컬럼의 해드컬럼 아이디.
   * @param {Array(Number)} paIdx 삭제할 row index 저장 배열.
   */  
  markDelete : function(psGrxId, psColId, paIdx) {
    var voControl = page.getControl(psGrxId);
    voControl.grid.EndEdit(voControl.grid.FRow, voControl.grid.FCol, true);
    var voBodyCol = voControl.getBodyColumn(null, psColId);
    var vsDataSetCol = voBodyCol.datasetCol;
    var vaIdxs = paIdx;
    if (vaIdxs == null) vaIdxs = UtilGrid.getSelIdxsOrFRowIdx(psGrxId);
    if (vaIdxs == null) return;
    var sortNumber = function(a, b) {
      return a - b;
    };
    vaIdxs.sort(sortNumber);
    var vnSize = vaIdxs.length;
    for (var i = vnSize - 1; i >= 0; i--) {
      var vnRowIndex = vaIdxs [i];
      var voRow = voControl.getRowIndex(vnRowIndex);
      vnRowIndex++;
      var voDataSet = voControl.dataset;
      if (voRow == null)
      return;
      if (psColId) {
        var vsUptStatus = voControl.getValue(voRow, psColId);
        if (vsUptStatus == "") vsUptStatus = "O";
        if (vsUptStatus == "N") {
          voControl.delRow(voRow);
          if (voControl.getRowCnt() == 0) {
            voControl.grid.FRow = null;
            voControl.grid.FCol = null;
          }
        } else {
          voDataSet.setRowAttr(vnRowIndex, "old___Status", vsUptStatus);
          //          voControl.markDelRow(voRow, 2);
          voControl.grid.DeleteRow(voRow, 2);
          //        voControl.setValue(voRow, psColId, "D", true);
          voControl.grid.SetValue(voRow, psColId, "D", true);
          voDataSet.simpleSet(vnRowIndex, vsDataSetCol, "D");
        }
      }
    }
  },
  
  /**
   * CUD 가 정상적으로 처리 되고 나면 "D" Status 로우는 삭제 하고  "U,N"
   * Status 는 psColId 의 Status 를 공백으로 바꾼다.
   * ex) Common.commitChanged("grxMain", "dstMain", "ghcUptStatus");
   * @param {Object} psGrxId 그리드 아이디.
   * @param {String} psDst 데이터셋 아이디.
   * @param {Object} psColId "N,U,D" 가 표시되는 컬럼의 해드컬럼 아이디.
   */  
  commitChanged : function(psGrxId, psDst, psColId) {
    var voControl = page.getControl(psGrxId);
    voControl.grid.EndEdit(voControl.grid.FRow, voControl.grid.FCol, true);
    var voBodyCol = voControl.getBodyColumn(null, psColId);
    var vsDataSetCol = voBodyCol.datasetCol;
    
    //    var voPageInfo = page.moPageInfo;
    //    if(voPageInfo != null){
    //      if(voPageInfo.menuAuthDivRcd != "CC00701" && voPageInfo.menuAuthDivRcd == "CC00702")
    //        return false;
    //    } 
    
    var voDataSet = page.getDataSet(psDst);
    var voPluginDataSet = voDataSet.dataSet;
    var vaStatus = [voPluginDataSet.ETBADDEDFLAG,
    voPluginDataSet.ETBDELETEDFLAG, voPluginDataSet.ETBMODIFIEDFLAG];
    var vsIndexes = null;
    
    for (var i = 0; i < 3; i++) {
      vsIndexes = voDataSet.getStatusIndex(vaStatus [i]);
      if (vsIndexes == null || vsIndexes == "") {
        continue;
      } else {
        var vaIdx = [];
        vaIdx = vsIndexes.split(",");
        vaIdx.pop();
        vaIdx.sort(function(a, b) {
          return b - a;
        })
        
        var vnSize = vaIdx.length;
        for (var k = 0; k < vnSize; k++) {
          switch (i.toString()) {
            case "1" :
            voDataSet.deleteRow(Number(vaIdx [k]));
            //page.getInstance("insResponse").removeNode("/root/mainList/row["+vaIdx[k]+"]");
            break;
            default :
            voDataSet.set(Number(vaIdx [k]), vsDataSetCol, ""); break;
          }
        }
      }
    }
    
    voControl.refreshData();
  },
  
  /**
   * 삭제 마킹된 로우를 복원시켜주는 메소드
   * ex) Common.revertDelete("grxMain", "ghcUptStatus");
   * @param {Object} psGrxId 그리드 아이디.
   * @param {Object} psColId "D"를 표시하는 컬럼의 해드컬럼 아이디.
   */  
  revertDelete : function(psGrxId, psColId) {
    var voControl = page.getControl(psGrxId);
    var voBodyCol = voControl.getBodyColumn(null, psColId);
    var vsDataSetCol = voBodyCol.datasetCol;
    var voDataSet = voControl.dataset;
    var vaIdxs = UtilGrid.getSelIdxsOrFRowIdx(psGrxId);
    if (vaIdxs == null) return;
    var vnSize = vaIdxs.length;
    for (var i = 0; i < vnSize; i++) {
      var vnRowIndex = vaIdxs [i];
      var voRow = voControl.getRowIndex(vnRowIndex);
      vnRowIndex++;
      if (voRow == null)
      return;
      if (psColId) {
        var vsUptStatus = voControl.getValue(voRow, psColId);
        if (vsUptStatus != "D") return;
        voControl.markDelRow(voRow, 3);
        var vsOldStatus = voDataSet.getRowAttr(vnRowIndex, "old___Status");
        if (vsOldStatus != "U") vsOldStatus = "";
        var vnStatus = voDataSet.dataSet.ETBUNCHANGEDFLAG;
        if (vsOldStatus == "U") vnStatus = voDataSet.dataSet.ETBMODIFIEDFLAG;
        voControl.grid.SetValue(voRow, psColId, vsOldStatus, true);
        voDataSet.simpleSet(vnRowIndex, vsDataSetCol, vsOldStatus);
        voDataSet.setStatus(vnRowIndex, vnStatus);
      }
    }
  },
  
  /**
   * 선택된 로우 데이타를 초기 데이타로 되돌려주는 메소드
   * ex) Common.restoreSelected("grxMain", "ghcUptStatus");
   * @param {Object} psGrxId 그리드 아이디.
   * @param {Object} psColId 업데이트 상태를 표시하는 컬럼의 헤드컬럼 아이디.
   * @param {Array(Number)} paIdx 복원 대상 로우의 인덱스 배열. 생략 시 selected row indexes로 대체됨.
   */  
  restoreSelected : function(psGrxId, psColId, paIdx) {
    var voControl = page.getControl(psGrxId);
    voControl.grid.EndEdit(voControl.grid.FRow, voControl.grid.FCol, true);
    var voDataSet = voControl.dataset;
    var vaIdxs = UtilGrid.getSelIdxsOrFRowIdx(psGrxId);
    if (paIdx != null) vaIdxs = paIdx;
    if (vaIdxs == null)
    return;
    
    var sortNumber = function(a, b) {
      return a - b;
    };
    vaIdxs.sort(sortNumber);
    var voBodyCol = null;
    var vsDataSetCol = null;
    var vnSize = vaIdxs.length;
    for (var i = vnSize - 1; i >= 0; i--) {
      var vnRowIndex = vaIdxs [i];
      var voRow = voControl.getRowIndex(vnRowIndex);
      vnRowIndex++;
      if (voRow == null)
      continue;
      if (psColId) {
        var vsUptStatus = voControl.getValue(voRow, psColId);
        if (vsUptStatus == "")
        continue;
        if (vsUptStatus == "D") {
          voControl.markDelRow(voRow, 3);
          voControl.grid.SetValue(voRow, psColId, "", true);
          voBodyCol = voControl.getBodyColumn(null, psColId);
          vsDataSetCol = voBodyCol.datasetCol;
          voDataSet.simpleSet(vnRowIndex, vsDataSetCol, "");
        }
        var vsOldStatus = voDataSet.getRowAttr(vnRowIndex, "old___Status");
        if (vsUptStatus == "U" || vsOldStatus == "U") {
          var vaColIds = UtilGrid.getColNames(psGrxId);
          var vsColId = null;
          var vsOriginVal = null;
          var voColMap = new eXria.data.ArrayMap();
          for (var j = 0; j < vaColIds.length; j++) {
            vsColId = vaColIds [j];
            voBodyCol = voControl.getBodyColumn(null, vsColId);
            vsDataSetCol = voBodyCol.datasetCol;
            if (vsDataSetCol == null) continue;
            voColMap.put(vsDataSetCol, "");
            vsOriginVal = voDataSet.getOrigin(vnRowIndex, vsDataSetCol);
            //           voControl.setValue(voRow, vsColId, vsOriginVal, true);
            voDataSet.simpleSet(vnRowIndex, vsDataSetCol, vsOriginVal);
            //voDataSet.set(vnRowIndex, vsDataSetCol, vsOriginVal);
            vsOriginVal = voControl.convertValueTGrid(voBodyCol, vsOriginVal, voRow, vsColId);
            if (voBodyCol.type == "Image") {
              var vsHrefValue = "";
              var vsTargetValue = "";
              var vsWidthValue = "";
              var vsHeightValue = "";
              var vsLeftValue = "";
              var vsTopValue = "";
              if (voBodyCol.imageItem.href) vsHrefValue = voDataSet.getOrigin(vnRowIndex, voBodyCol.imageItem.href);
              if (voBodyCol.imageItem.target) vsTargetValue = voDataSet.getOrigin(vnRowIndex, voBodyCol.imageItem.target);
              if (voBodyCol.imageItem.width) vsWidthValue = voDataSet.getOrigin(vnRowIndex, voBodyCol.imageItem.width);
              if (voBodyCol.imageItem.height) vsHeightValue = voDataSet.getOrigin(vnRowIndex, voBodyCol.imageItem.height);
              if (voBodyCol.imageItem.left) vsLeftValue = voDataSet.getOrigin(vnRowIndex, voBodyCol.imageItem.left);
              if (voBodyCol.imageItem.top) vsTopValue = voDataSet.getOrigin(vnRowIndex, voBodyCol.imageItem.top);
              if (vsOriginVal != null) {
                var vaStrBuf = [];
                vaStrBuf.push("|");
                vaStrBuf.push(vsHrefValue);
                vaStrBuf.push("|");
                vaStrBuf.push(vsWidthValue);
                vaStrBuf.push("|");
                vaStrBuf.push(vsHeightValue);
                vaStrBuf.push("|");
                vaStrBuf.push(vsLeftValue);
                vaStrBuf.push("|");
                vaStrBuf.push(vsTopValue);
                vaStrBuf.push("|");
                vaStrBuf.push(vsTargetValue);
                vaStrBuf.push("\"");
                vsOriginVal = vaStrBuf.join("");
              }
            }
            voControl.grid.SetValue(voRow, vsColId, vsOriginVal, true);
          }
          
          //          var vnColCnt = voDataSet.getColCnt();
          //          for(var j = 0; j < vnColCnt; j++) {
          //            vsDataSetCol = voDataSet.dataSet.getColName(j);
          //            if(voColMap.get(vsDataSetCol) != null) continue;
          //            vsOriginVal = voDataSet.dataSet.getOrigin(vnRowIndex, vsDataSetCol);
          //            voDataSet.simpleSet(vnRowIndex, vsDataSetCol, vsOriginVal);
          //          }
        } else if (vsUptStatus == "N") {
          voControl.delRow(voRow);
          if (voControl.getRowCnt() == 0) {
            voControl.grid.FRow = null;
            voControl.grid.FCol = null;
          }
          return;
        }
        voDataSet.setStatus(vnRowIndex, voDataSet.dataSet.ETBUNCHANGEDFLAG);
      }
    }
  },
  
  /**
   * 해당 Control Focus 이동.
   * ex) Common.setFocus("ipbName");
   * @param {String} psCtlID 컨트롤 아이디.
   */  
  setFocus : function(psCtlID) {
    if (typeof (psCtlID) == "string") {
      page.canvas.setFocusByControl(page.getControl(psCtlID));
    } else if (typeof (psCtlID) == "object") {
      page.canvas.setFocusByControl(psCtlID);
    }
  },
  
  /**
   * 컨트롤의 속성을 변경한다.
   * ex) Common.setCtlAttr("visible", "false", ["ipbName", "ipbAddress", "ipbPhone"]);
   * @param {String} psAttr 변경할 속성명.
   * @param {String} psValue 속성 값.
   * @param {Array} paCtlIds 변경할 컨트롤 아이디(들).
   */  
  setCtlAttr : function(psAttr, psValue, paCtlIds) {
    var vnArgc = paCtlIds.length;
    for (var i = 0; i < vnArgc; i++) {
      page.getControl(paCtlIds [i]).applyAttr(psAttr, psValue);
    }
  },
  
  /**
   * CSV 파일 데이타를 dataset을 통해 읽어오는 메소드.
   * @param {String} psDataSetId 데이타셋 아이디
   * @param {String} psFileName 파일명(풀패스)
   * @param {Boolean} pbHeader 파일의 첫 row가 필드명을 나타내는 row 인지 여부
   * @param {Number} pnMinRow 부분적으로 데이타를 받아올 영역의 시작 행 번호(1 ...)
   * @param {Number} pnMaxRow 부분적으로 데이타를 받아올 영역의 끝 행 번호
   * @ignore
   */  
  csvToDataSet : function(psDataSetId, psFileName, pbHeader, pnMinRow, pnMaxRow) {
    var voPlugin = page.model.plugin;
    var conn = voPlugin.getConnection(psFileName
    , voPlugin.ETBCSVFILESOURCE | voPlugin.ETBUTF8FILETYPE
    , psFileName
    , voPlugin.ETBDATASETSOURCE
    , psDataSetId
    , "");
    var comm = conn.getCommand("commRead");
    if (pnMinRow !== null) comm.setMinRow(pnMinRow);
    if (pnMaxRow !== null) comm.setMaxRow(pnMaxRow);
    var vnExecConst = comm.ETBFIELDNAMENEW | comm.ETBDATAREPLACE;
    if (pbHeader !== false) vnExecConst = vnExecConst | comm.ETBFIRSTROWFIELD_SRC;
    comm.executeQuery(vnExecConst);
    conn.close();
  },
  
  /**
   * Excel 파일 데이타를 DataSet을 통해 읽어오는 메소드.
   * @param {String} psDataSetId 데이타셋 아이디
   * @param {String} psFileName 파일명(풀패스)
   * @param {Boolean} pbHeader 파일의 첫 row가 필드명을 나타내는 row 인지 여부
   * @param {Number} pnMinRow 부분적으로 데이타를 받아올 영역의 시작 행 번호(1 ...)
   * @param {Number} pnMaxRow 부분적으로 데이타를 받아올 영역의 끝 행 번호
   * @ignore
   */  
  excelToDataSet : function(psDataSetId, psFileName, pbHeader, pnMinRow, pnMaxRow) {
    var voPlugin = page.model.plugin;
    //var conn = page.model.getConnection("connToFile"
    var conn = page.model.getConnection(psFileName
    , voPlugin.ETBEXCELFILESOURCE
    , psFileName
    , voPlugin.ETBDATASETSOURCE
    , psDataSetId
    , "");
    var comm = conn.getCommand("commRead");
    if (pnMinRow !== null && pnMinRow !== "") comm.setMinRow(pnMinRow);
    if (pnMaxRow !== null && pnMaxRow !== "") comm.setMaxRow(pnMaxRow);
    var vnExecConst = comm.command.ETBDATAREPLACE | comm.command.ETBFIELDNAMENEW;
    if (pbHeader !== false) vnExecConst = vnExecConst | comm.command.ETBFIRSTROWFIELD_SRC;
    comm.executeQuery(vnExecConst);
    conn.close();
  },
  
  /**
   * Excel 파일 데이타를 Instance를 통해 읽어오는 메소드.
   * @param {String} psInstanceId instance 아이디
   * @param {String} psXpath 인스턴스 xpath
   * @param {String} psFileName 파일명(풀패스)
   * @param {Boolean} pbHeader 파일의 첫 row가 필드명을 나타내는 row 인지 여부
   * @param {Number} pnMinRow 부분적으로 데이타를 받아올 영역의 시작 행 번호(1 ...)
   * @param {Number} pnMaxRow 부분적으로 데이타를 받아올 영역의 끝 행 번호
   * @ignore
   */  
  excelToInstance : function(psInstanceId, psXpath, psFileName, pbHeader, pnMinRow, pnMaxRow) {
    var voPlugin = page.model.plugin;
    var conn = page.model.getConnection(psFileName
    , voPlugin.ETBEXCELFILESOURCE
    , psFileName
    , voPlugin.ETBINSTANCESOURCE
    , psInstanceId
    , psXpath);
    var comm = conn.getCommand("commRead");
    if (pnMinRow !== null) comm.setMinRow(pnMinRow);
    if (pnMaxRow !== null) comm.setMaxRow(pnMaxRow);
    var vnExecConst = comm.command.ETBDATAREPLACE | comm.command.ETBFIELDNAMENEW;
    if (pbHeader !== false) vnExecConst = vnExecConst | comm.command.ETBFIRSTROWFIELD_SRC;
    comm.executeQuery(vnExecConst);
    conn.close();
  },
  
  /**
   * dataset의 내용을 파일로 내보내기 위한 메소드.
   * @param {String} psDataSetId 데이타셋 아이디
   * @param {String} psFileName 파일명(풀패스)
   * @param {Boolean} pbHeader 파일의 첫 row가 필드명을 나타내는 row 인지 여부
   * @param {Number} pnMinRow 부분적으로 데이타를 받아올 영역의 시작 행 번호(1 ...)
   * @param {Number} pnMaxRow 부분적으로 데이타를 받아올 영역의 끝 행 번호
   * @ignore
   */  
  datasetToCsv : function(psDataSetId, psFileName, pbHeader, pnMinRow, pnMaxRow) {
    var voPlugin = page.model.plugin;
    var voDataSet = page.getDataSet(psDataSetId);
    var vsDelIdxs = voDataSet.getStatusIndex(voDataSet.dataSet.ETBDELETEDFLAG);
    var vaIdx = [];
    if (vsDelIdxs != null) vaIdx = vsDelIdxs.split(",");
    var vnSize = vaIdx.length;
    var vnIdx = null;
    for (var i = 0; i < vnSize; i++) {
      vnIdx = vaIdx [i];
      if (vnIdx !== "") {
        vnIdx = parseInt(vnIdx);
        voDataSet.deleteRow(vnIdx);
      }
    }
    var conn = voPlugin.getConnection(psFileName
    , voPlugin.ETBDATASETSOURCE
    , psDataSetId
    , voPlugin.ETBCSVFILESOURCE | voPlugin.ETBUTF8FILETYPE
    , ""
    , psFileName);
    
    var comm = conn.getCommand("commSave");
    if (pnMinRow !== null) comm.setMinRow(pnMinRow);
    if (pnMaxRow !== null) comm.setMaxRow(pnMaxRow);
    var vnExecConst = comm.ETBDATAREPLACE | comm.ETBFIELDNAMENEW;
    if (pbHeader !== false) vnExecConst = vnExecConst | comm.ETBFIRSTROWFIELD_TGT;
    comm.executeQuery(vnExecConst);
    conn.close();
  },
  
  /**
   * 두 개의 List형 컨트롤이 종속 관계를 가질 때 종속되는 컨트롤의 데이타를 필터링하기 위한 메소드.
   * 주로 Main컨트롤의 onChange 이벤트에서 호출된다.
   * ex) Common.cascadeList(e.object.id, "cbbSub", "CD");
   * @param {String} vsMainId 메인 컨트롤 id
   * @param {String} vsSubId 서브 컨트롤 id
   * @param {String} vsQueryKey 검색조건에서의 검색 필드명
   * @param {String} vsFullVal 메인 컨트롤 전체 검색 아이템값
   */  
  cascadeList : function(vsMainId, vsSubId, vsQueryKey, vsFullVal) {
    
    var voCtl = page.getControl(vsMainId);
    var vsValue = voCtl.getValue();
    if (vsValue instanceof Array && vsValue.length > 0) vsValue = vsValue [vsValue.length - 1];
    voCtl = page.getControl(vsSubId);
    var voData = voCtl.data;
    var vsRef = voData.nodesetInstancePath;
    var vsOriRef = vsRef;
    vsRef += "[" + vsQueryKey + "='" + vsValue + "']";
    
    //1. voData.data -> isProxy 체크
    if(voData.isProxy) {
      voData = voData.data;
    }
    
    if (! !vsFullVal) {
      if (vsFullVal === vsValue) {
        voData.nodesetInstancePath = vsOriRef;
      } else {
        voData.nodesetInstancePath = vsRef;
      }
    } else {
      voData.nodesetInstancePath = vsRef;
    }
    
    
    voCtl.refreshData();
    if (voCtl.getVisibleItemCount() > 0) voCtl.listarea.select([0]);
    voData.nodesetInstancePath = vsOriRef;
  },
  
  /**
   * 두 개의 List형 컨트롤이 종속 관계를 가질 때 종속되는 컨트롤의 데이타를 필터링하기 위한 메소드.
   * 주로 Main컨트롤의 onLoad 이벤트에서 호출된다.
   * 기준일이 시작일과 종료일 사이에 있을 경우에만 리스트에서 선택할 수 있다.
   * 날짜가 끊긴 경우에는 리스트목록에는 표시되지만 선택할 수 없다.
   * ex) Common.disableItemByDate(e.object.id, "EFFT_ST_DT", "EFFT_END_DT", "20100135130512");
   * @param {String} vsId 컨트롤 id
   * @param {String} vsStKey 시작일노드 노드명
   * @param {String} vsEdKey 종료일노드 노드명
   * @param {String} vsDate 비교할 기준일(기준일이 없으면 현재일)
   */  
  disableItemByDate : function(vsId, vsStKey, vsEdKey, vsDate) {
    var voCtl = page.getControl(vsId);
    var voData = voCtl.data;
    var vsValueTagName = voCtl.valueTagName;
    var voInstance = page.getInstance(voData.nodesetInstanceId);
    var voItemset = voCtl.itemset.getValueCollection();
    var vnSize = voItemset.size();
    var voItem = null;
    var vsRef = null;
    var vsValue = null;
    var voList = null;
    for (var i = 0; i < vnSize; i++) {
      voItem = voItemset.get(i);
      vsValue = voItem.value;
      vsRef = voData.nodesetInstancePath;
      vsRef += "[" + vsValueTagName + "='" + vsValue + "' and ";
      vsRef += "(" + vsStKey + " > '" + vsDate + "' or " + vsEdKey + " < '" + vsDate + "')]";
      voList = voInstance.selectNodes(vsRef);
      if (voList.getLength() > 0) {
        voItem.disabled = true;
      }
    }
    voCtl.repaint();
    
  },
  
  /**
   * 그리드와 컬럼 별 데이타 필터링 import 페이지를 초기화 시키기 위한 메소드.
   * 주로 import 시켜주는 페이지의 onLoad 이벤트 핸들러에서 호출됨.
   * ex) Common.initImpGridColFilter(["grxMst","grxTMst"], ["ghcUptStatus,ghcObjGbn","ghcUptStatus,ghcTxtGbn"]);
   * @param {Array(String)} paGridIds 검색 대상 그리드 id 리스트
   * @param {Array(String)} paExColList 검색 대상에서 제외될 그리드 헤드 컬럼 목록.
   * @param {Boolean} pbSkipExpand 펼침상태 재조정을 수행안할지 여부.
   * Tab컨트롤에서 TabPage간 이 메소드를 호출시 page의 onload이벤트에서 설정된 펼침상태를 유지시켜야 될 필요가 있으므로
   * 그 경우 true값을 넘겨줌
   * 한 그리드 내에 컬럼 목록은 ","로 구분된 하나의 문자열로 구성됨.
   * @ignore
   */
  initImpGridColFilter : function(paGridIds, paExColList, pbSkipExpand) {
    if (page.gridColFilter != true) return;
    page.doInitImpColFilter(paGridIds, paExColList);
    if (pbSkipExpand) return;
    page.doImpColFilterExpand();
  },
  
  /**
   * 임포트되는 헤더사이즈와 보여지는 형태를 조건에 따라서 조절하는 메소드입니다.
   * @member Common
   * @param {String} psCondition 팝업페이지라면:'popUp' 기본페이지라면: 이외의 모든값또는 생략;
   * @ignore
   */  
  initHeaderSize : function(psCondition) {
    var vcMessage = page.getControl("ipbMsgI002");
    var vcImp = vcMessage.ctrl.parentNode;
    var vcTitle = page.getControl("lblPagePgTitle");
    var vcImg = page.getControl("imgMessage");
    var vnImgWidth = 16;
    var vnTitleWidth = vcTitle.innerWidth;
    var vnTitleLeft = vcTitle.innerWidth;
    var vnImpWidth = vcImp.offsetWidth;
    var vnNewWidth = vnImpWidth - vnImgWidth - 6;
    if ("popUp" == psCondition) {
      page.getControl("lblPagePgPath").applyAttr("visible", false);
      vnNewWidth = vnNewWidth / 2;
      vcTitle.applyAttr("width", vnNewWidth);
      vcMessage.applyAttr("left", vnNewWidth);
      vcMessage.applyAttr("width", vnNewWidth);
      vcImg.applyAttr("left", vcMessage.left + vnNewWidth);
      //var vnSpace = vcMessage.width + vcMessage.left - vcImg.left;
      //if(vnSpace >= 0) {
      //	vcMessage.applyAttr("width", vnNewWidth - 5);
      //}	
    } else {
      var vcDepth = page.getControl("lblPagePgPath");
      vnNewWidth = vnNewWidth / 3;
      vcTitle.applyAttr("width", vnNewWidth + 95);
      vcDepth.applyAttr("left", vcTitle.left + vnNewWidth + 100);
      vcDepth.applyAttr("width", vnNewWidth);
      vcMessage.applyAttr("left", vcDepth.left + vnNewWidth - 100);
      vcMessage.applyAttr("width", vnNewWidth);
      vcImg.applyAttr("left", vcMessage.left + vnNewWidth);
      
    }
  },
  
  /**
   * Message status 표시 import 페이지를 초기화하기 위한 메소드.
   * 주로 import 시켜주는 페이지의 onLoad 이벤트 핸들러에서 호출됨.
   * ex) Common.initImpMsgStatus();
   * @ignore
   */  
  initImpMsgStatus : function() {
    if (page.showMsgStatus != true) return;
    page.doInitImpMsgStatus();
  },
  
  /**
   * 권한에 의한 Button 제어.
   * 수정가능여부를 체크하여 신규, 처리 Button 제어.
   * Common.setButtonByAuth("btnNew", "btnDel");
   *
   * @param {String} psCtlId 컨트롤 아이디.
   * @ignore
   */  
  setButtonByAuth : function(psCtlId) {
    //       var vaArgv  = psCtlId.arguments;
    // var vnArgc = vaArgv.length;
    // var vbFlag = false;
    // if ("Y" == page.getPageUpdPosbYn()) {
    // vbFlag = true;
    // }
    //
    // for(var i = 0; i < vnArgc; i++ ){
    // page.getControl(vaArgv[i]).applyAttr("visible", vbFlag);
    // }
  },
  
  /**
   * 언어 코드 설정.
   * @ignore
   */  
  getLangCode : function() {
  },
  /**
   * 세션정보 획득.
   * @ignore
   */  
  getSessionInfo : function() {
  },
  /**
   * 기본 request 정보 설정.
   * @ignore
   */  
  requestInfo : function() {
  },
  /**
   * 레이어 팝업 페이지 오픈
   * Common.openWindowLayerPopUp("target","parent","./subPage.xrf", 300, 300);
   * @param {String} psChildId 자식 id.
   * @param {String} psParentId 부모 id.
   * @param {String} psUrl 페이지 url.
   * @param {Number} psWidth 페이지 width
   * @param {Number} psHeight 페이지 height
   * @ignore
   */  
  openWindowLayerPopUp : function(psChildId, psParentId, psUrl, pnWidth, pnHeight) {
    var vnLeft = 0;
    var vnTop = 0;
    var vnOuterZindex = 30000;
    var vnPageZindex = 40000;
    
    //최상위 컨트롤
    var voPage = window.top.page;
    var voCanvas = voPage.canvas;
    var voCanvasCtrl = voCanvas.getCtrl();
    var voDocument = voPage.window.document;
    var voDomElement = voDocument.documentElement;
    var vnCanvasWidth = voDomElement.offsetWidth;
    var vnCanvasHeight = voDomElement.offsetHeight;
    
    //openWindowLayerPopUp가 여러번 호출되었을경우 zIndex 조정
    if (! !page.getControl(psParentId + "rtgLayerPopUpCoverPage")) {
      vnOuterZindex = vnPageZindex;
      vnPageZindex = vnPageZindex + 10;
    }
    
    // 백그라운드에 rectangle로 씌움
    {
      voCanvasCtrl.style.overflow = "visible";
      var vcRtg = voCanvas.createControl("rectangle", psChildId + "rtgLayerPopUpCoverPage", vnLeft, vnTop, vnCanvasWidth, vnCanvasHeight);
      vcRtg.zIndex = vnOuterZindex;
      vcRtg.fillType = "solid";
      vcRtg.fillStartColor = "#c0c0c0";
      vcRtg.fillOpacity = 80;
      vcRtg.penWeight = 0;
      voCanvas.appendControl(vcRtg);
    }
    
    vnLeft = (vnCanvasWidth - pnWidth) / 2;
    vnTop = (vnCanvasHeight - pnHeight) / 2;
    
    // 모든 컨트롤을 담을 그룹
    {
      var vcGroup = voCanvas.createControl("group", psChildId + "grpLayerPopUpOuterGroup",
      vnLeft, vnTop, pnWidth + 5, pnHeight + 5);
      vcGroup.borderWidth = 0;
      vcGroup.zIndex = vnOuterZindex;
      vcGroup.overflow = "visible";
      vcGroup.movable = true;
    }
    
    // 사용자가 넘겨준 xrf를 최외곽 group에 append
    var vcSbp = voCanvas.createControl("subpage", psChildId + "sbpLayerPopUpCoverPage", 5, 23, pnWidth, pnHeight);
    vcSbp.zIndex = vnPageZindex;
    vcGroup.addChild(vcSbp);
    
    // top 영역
    {
      var vcRct = voCanvas.createControl("rectangle",
      psChildId + "rctLayerPopTop", 5, 0, pnWidth, 22);
      vcRct.zIndex = 1;
      vcRct.fillType = "solid";
      vcRct.fillStartColor = "white";
      vcRct.fillOpacity = 100;
      vcGroup.addChild(vcRct);
    }
    
    // top의 닫기 버튼
    {
      var vcBtn = voCanvas.createControl("button",
      psChildId + "btnLayerPopClose", pnWidth - 18, 2, 17, 17);
      vcBtn.zIndex = 2;
      vcBtn.value = "X";
      vcBtn.onclick = function(e) {
        Common.cloaseWindowLayerPopUp(psChildId);
      }
      vcGroup.addChild(vcBtn);
    }
    
    voCanvas.appendControl(vcGroup);
    psUrl = eXria.controls.xhtml.Util.getImagePath(psUrl, page.window);
    vcSbp.setSrc(psUrl);
    
  },
  
  /**
   * 레이어 팝업 페이지 닫기
   * Common.cloaseWindowLayerPopUp("child");
   * @param {String} psChildId 자식 id.
   * @ignore
   */
  cloaseWindowLayerPopUp : function(psChildId) {
    //최상위 컨트롤
    var voPage = window.top.page;
    var voCanvas = voPage.canvas;
    
    voCanvas.removeControl(psChildId + "grpLayerPopUpOuterGroup");
    voCanvas.removeControl(psChildId + "rtgLayerPopUpCoverPage");
  },
  
  /**
   * 레이어 팝업 페이지 오픈(단일 팝업일 때만 사용가능하며, UtilPopUp.openLayeredPopup 메소드 사용권장)
   * ex) Common.openLayerPopUp("./subPage.xrf", 300, 300);
   * @param {String} psUrl 페이지 url.
   * @param {Number} psWidth 페이지 width
   * @param {Number} psHeight 페이지 height
   * @ignore
   */  
  openLayerPopUp : function(psUrl, pnWidth, pnHeight) {
    var pnLeft = 0;
    var pnTop = 0;
    var voCanvas = page.canvas;
    var pnCanvasWidth = voCanvas.width;
    var pnCanvasHeight = voCanvas.height;
    
    // 백그라운드에 rectangle로 씌움
    {
      var vcRtg = voCanvas.createControl("rectangle", "rtgLayerPopUpCoverPage", pnLeft, pnTop, pnCanvasWidth, pnCanvasHeight);
      vcRtg.zIndex = 10000;
      vcRtg.fillType = "solid";
      vcRtg.fillStartColor = "#c0c0c0";
      vcRtg.fillOpacity = 60;
      vcRtg.penWeight = 0;
      voCanvas.appendControl(vcRtg);
    }
    
    pnLeft = (pnCanvasWidth - pnWidth) / 2;
    pnTop = (pnCanvasHeight - pnHeight) / 2;
    
    // 모든 컨트롤을 담을 그룹
    {
      var vcGroup = voCanvas.createControl("group", "grpLayerPopUpOuterGroup",
      pnLeft, pnTop, pnWidth + 5, pnHeight + 5);
      vcGroup.borderWidth = 0;
      vcGroup.zIndex = 10000;
      vcGroup.overflow = "visible";
      vcGroup.movable = true;
    }
    
    // 사용자가 넘겨준 xrf를 최외곽 group에 append
    var vcSbp = voCanvas.createControl("subpage", "sbpLayerPopUpCoverPage", 5, 23, pnWidth, pnHeight);
    vcSbp.zIndex = 50000;
    vcGroup.addChild(vcSbp);
    
    // top 영역
    {
      var vcRct = voCanvas.createControl("rectangle",
      "rctLayerPopTop", 5, 0, pnWidth, 22);
      vcRct.zIndex = 1;
      vcRct.fillType = "solid";
      vcRct.fillStartColor = "white";
      vcRct.fillOpacity = 100;
      vcGroup.addChild(vcRct);
    }
    
    // top의 제목 표시줄
    {
      //    var vcLbl = voCanvas.createControl("label", "dialog_title_label",
      //        10, 1, pnWidth - 11, 18);
      //    // objTitleLabel.borderWidth = 0;
      //    // objTitleLabel.color = "#000000";
      //    vcLbl.textAlign = "left";
      //    vcLbl.value = "popup";
      //    vcLbl.zIndex = 2;
      //    vcLbl.onmousedown = function(e) {
      //      page.getControl("dialog_outer_group").startMove(e);
      //    }
      //    vcGroup.addChild(vcLbl);
    }
    //
    // top의 닫기 버튼
    {
      var vcBtn = voCanvas.createControl("button",
      "btnLayerPopClose", pnWidth - 18, 2, 17, 17);
      vcBtn.zIndex = 2;
      vcBtn.value = "X";
      vcBtn.onclick = function(e) {
        Common.closeLayerPopUp();
      }
      vcGroup.addChild(vcBtn);
    }
    
    voCanvas.appendControl(vcGroup);
    psUrl = eXria.controls.xhtml.Util.getImagePath(psUrl, page.window);
    vcSbp.setSrc(psUrl);
  },
  /**
   * 레이어 팝업 페이지 닫기
   * ex) Common.closeLayerPopUp();
   * @ignore
   */  
  closeLayerPopUp : function() {
    page.canvas.removeControl("grpLayerPopUpOuterGroup");
    page.canvas.removeControl("rtgLayerPopUpCoverPage");
  },
  /**
   * 팝업 페이지 오픈.
   * Common.openPopUp("subPage", "./subPage.xrf", "300", "300", "status=no,toolbar=no", false);
   *
   * @param {String} psId 페이지 아이디(필수입력 or " ").
   * @param {String} psUrl 페이지 url.
   * @param {String} psWidth 페이지 width
   * @param {String} psHeight 페이지 height
   * @param {String} psFeature 옵션.
   * @param {Boolean} pbModal modal인지 여부.
   * @ignore
   */  
  openPopUp : function(psId, psUrl, psWidth, psHeight, psFeature, pbModal) {
    if (pbModal == null) pbModal = true;
    var vnWidth = UtilValue.fixNumber(psWidth);
    var vnHeight = UtilValue.fixNumber(psHeight);
    
    var vsWidth = (vnWidth < 1) ? "" : ("width=" + vnWidth);
    var vsHeight = (vnHeight < 1) ? "" : ("height=" + vnHeight);
    
    var vsFeature = UtilValue.fixNull(psFeature);
    
    vsFeature = vsFeature + ((vsFeature.length > 0) ? "," : "") + vsWidth + ((vsWidth.length > 0) ? "," : "") + vsHeight;
    //status=no,toolbar=no,menubar=no,location=no
    if (UtilValue.fixBoolean(pbModal)) {
      vsFeature = vsFeature.replace(/,/g, ";");
      vsFeature = vsFeature.replace(/(top\s*=)/g, "dialogTop=");
      vsFeature.match(/(dialogTop=\s*\d+)/g);
      vsFeature = vsFeature.replace(/(dialogTop=\s*\d+)/g, RegExp.$1 + "px");
      vsFeature = vsFeature.replace(/(left\s*=)/g, "dialogLeft=");
      vsFeature.match(/(dialogLeft=\s*\d+)/g);
      vsFeature = vsFeature.replace(/(dialogLeft=\s*\d+)/g, RegExp.$1 + "px");
      vsFeature = vsFeature.replace(/(width\s*=)/g, "dialogWidth=");
      vsFeature.match(/(dialogWidth=\s*\d+)/g);
      vsFeature = vsFeature.replace(/(dialogWidth=\s*\d+)/g, RegExp.$1 + "px");
      vsFeature = vsFeature.replace(/(height\s*=)/g, "dialogHeight=");
      vsFeature.match(/(dialogHeight=\s*\d+)/g);
      vsFeature = vsFeature.replace(/(dialogHeight=\s*\d+)/g, RegExp.$1 + "px");
      vsFeature = vsFeature.replace(/(scrollbars\s*=)/g, "scroll=");
    }
    
    if (!UtilValue.fixBoolean(pbModal))
    return page.openPage(psId, psUrl, eXria.form.PageType.POPUP, vsFeature);
    else
    return page.openPage(psId, psUrl, eXria.form.PageType.MODAL, vsFeature);
  },
  
  /**
   * index.jsp top frame의 top.xrf에서 로그인된 사용자 정보를 얻어오기 위한 메소드.
   * @return 로그인된 사용자 정보가 저장된 eXria.data.ArrayMap 객체
   * @type eXria.data.ArrayMap
   * @ignore
   */  
  getUserInfo : function() {
    var voUserInfo = new eXria.data.ArrayMap();
    var voWindow = null;
    //    if(page == null || page == "undefined") return voMenuInfo;
    if (page == null || page == "undefined") {
      voWindow = window;
    } else {
      voWindow = page.window;
    }
    voWindow = this.findLibWindow(voWindow);
    if (voWindow == null || voWindow == "undefined") return voUserInfo;
    var voWindow = voWindow.document.getElementById("_eXriaGlobalLibraryMainFrame_").contentWindow;
    voWindow = voWindow.document.getElementById("frmTop").contentWindow;
    var voPage = voWindow.page;
    var voInstance = voPage.getInstance("instance");
    //	  var voMapNode = voInstance.getMapNode("/root/userInfo");
    //	  var vnSize = voMapNode.size();
    //	  var voCollection = voMapNode.getKeyCollection();
    //	  var vsKey = null;
    //	  for(var i = 0; i < vnSize; i++) {
    //	    vsKey = voCollection.get(i);
    //	    voUserInfo.put(vsKey, voMapNode.get(vsKey) ? voMapNode.get(vsKey) : "");
    //	  }
    
    var voMapNode = voInstance.selectNodesStr("/root/userInfo");
    if (voMapNode) {
      voMapNode = eval(voMapNode);
      voMapNode = voMapNode [0];
      for (var vsKey in voMapNode) {
        voUserInfo.put(vsKey, voMapNode [vsKey]);
      }
    }
    
    return voUserInfo;
  },
  
  /**
   * index.jsp left frame의 left.xrf에서 메뉴와 프로그램 정보를 얻어오기 위한 메소드.
   * @return 메뉴와 프로그램 정보가 저장된 eXria.data.ArrayMap 객체
   * @type eXria.data.ArrayMap
   * @ignore
   */  
  getMenuInfo : function() {
    var voMenuInfo = new eXria.data.ArrayMap();
    var voWindow = null;
    //    if(page == null || page == "undefined") return voMenuInfo;
    if (page == null || page == "undefined") {
      voWindow = window;
    } else {
      voWindow = page.window;
    }
    voWindow = this.findLibWindow(voWindow);
    if (voWindow == null || voWindow == "undefined") return voMenuInfo;
    var voWindow = voWindow.document.getElementById("_eXriaGlobalLibraryMainFrame_").contentWindow;
    voWindow = voWindow.document.getElementById("left").contentWindow;
    var voPage = voWindow.page;
    var voInstance = voPage.getInstance("instance");
    var vsCurMenuId = voPage.getControl("trvMenu").openedItem;
    if (vsCurMenuId == null) return voMenuInfo;
    else vsCurMenuId = vsCurMenuId.getValue();
    //    var voMapNode = UtilInstance.getMapNode("instance", "/root/leftMenuList", "row", "MENU_ID", vsCurMenuId, voPage);
    //    if(voMapNode == null) return voMenuInfo;
    //    var vnSize = voMapNode.size();
    //    var voCollection = voMapNode.getKeyCollection();
    //    var vsKey = null;
    //    for(var i = 0; i < vnSize; i++) {
    //      vsKey = voCollection.get(i);
    //      voMenuInfo.put(vsKey, voMapNode.get(vsKey) ? voMapNode.get(vsKey) : "");
    //    }
    
    var voMapNode = voInstance.selectNodesStr("/root/leftMenuList/row[MENU_ID='" + vsCurMenuId + "']");
    if (voMapNode == null) return voMenuInfo;
    voMapNode = eval(voMapNode);
    voMapNode = voMapNode [0];
    for (var vsKey in voMapNode) {
      voMenuInfo.put(vsKey, voMapNode [vsKey]);
    }
    return voMenuInfo;
  },
  
  /**
   * index.jsp top frame의 top.xrf에서 로그인된 사용자 정보를 얻어오기 위한 메소드.
   * @return 로그인된 사용자 정보가 저장된 eXria.data.ArrayMap 객체
   * @type eXria.data.ArrayMap
   * @ignore
   */  
  getDefaultLocale : function() {
    var voWindow = null;
    //	  if(page == null || page == "undefined") return "";
    if (page == null || page == "undefined") {
      voWindow = window;
    } else {
      voWindow = page.window;
    }
    voWindow = this.findLibWindow(voWindow);
    if (voWindow == null || voWindow == "undefined") return "";
    var voWindow = voWindow.document.getElementById("_eXriaGlobalLibraryMainFrame_").contentWindow;
    voWindow = voWindow.document.getElementById("frmTop").contentWindow;
    var voPage = voWindow.page;
    var voInstance = voPage.getInstance("instance");
    var vsDefaultLocale = voInstance.getValueNode("/root/default.locale").getValue();
    return vsDefaultLocale;
  },
  
  /**
   * index.jsp top frame의 top.xrf에서 로그인된 사용자 정보를 얻어오기 위한 메소드.
   * @return 로그인된 사용자 정보가 저장된 eXria.data.ArrayMap 객체
   * @type eXria.data.ArrayMap
   * @ignore
   */  
  getDeptInfo : function() {
    var vsDeptInfo = "";
    var voWindow = null;
    //	  if(page == null || page == "undefined") return vsDeptInfo;
    if (page == null || page == "undefined") {
      voWindow = window;
    } else {
      voWindow = page.window;
    }
    voWindow = this.findLibWindow(voWindow);
    if (voWindow == null || voWindow == "undefined") return vsDeptInfo;
    var voWindow = voWindow.document.getElementById("_eXriaGlobalLibraryMainFrame_").contentWindow;
    voWindow = voWindow.document.getElementById("frmTop").contentWindow;
    var voPage = voWindow.page;
    var vsXpath = "/root/deptInfo";
    var voIns = voPage.getInstance("instance");
    var voList = voIns.getCollectionNode(vsXpath);
    if (voList == null) return vsDeptInfo;
    var vnSize = voList.size();
    var voNode = null, voObjDivRcd = null, voDeptCd = null;
    var vsObjDivRcd = null, vsDeptCd = null;
    
    for (var i = 1; i <= vnSize; i++) {
      voNode = voList.get(i - 1);
      voObjDivRcd = voNode.getElementByTagName("OBJ_DIV_RCD");
      voDeptCd = voNode.getElementByTagName("DEPT_CD");
      if (voObjDivRcd == null || voDeptCd == null) return vsDeptInfo;
      vsObjDivRcd = String(voObjDivRcd.getNodeValue()); //박상찬 수정
      vsDeptCd = String(voDeptCd.getNodeValue()); //박상찬 수정
      
      if (vsObjDivRcd == null || vsDeptCd == null) continue;
      vsDeptInfo += vsObjDivRcd + "@" + vsDeptCd;
      if (i != vnSize) vsDeptInfo += ",";
    }
    return vsDeptInfo;
  },
  
  /**
   * index.jsp top frame의 top.xrf에서 로그인된 사용자 정보를 얻어오기 위한 메소드.
   * @return 로그인된 사용자 정보가 저장된 eXria.data.ArrayMap 객체
   * @type eXria.data.ArrayMap
   * @ignore
   */  
  getSystemLocale : function() {
    var voWindow = null;
    //    if(page == null || page == "undefined") return "";
    if (page == null || page == "undefined") {
      voWindow = window;
    } else {
      voWindow = page.window;
    }
    voWindow = this.findLibWindow(voWindow);
    if (voWindow == null || voWindow == "undefined") return "";
    var voWindow = voWindow.document.getElementById("_eXriaGlobalLibraryMainFrame_").contentWindow;
    voWindow = voWindow.document.getElementById("frmTop").contentWindow;
    var voPage = voWindow.page;
    var voInstance = voPage.getInstance("instance");
    var vsDefaultLocale = voInstance.getValueNode("/root/system.locale").getValue();
    return vsDefaultLocale;
  },
  
  /**
   * 공통 라이브러리를 포함한 메인 페이지의 window를 얻어오기 위한 메소드
   * @param {HTMLWindow} poWindow  메인 페이지 window 검색을 위해 검색 시작점이 되는 window 객체
   * @return 공통 라이브러리를 포함한 메인 페이지의 window
   * @type HTMLWindow
   * @ignore
   */  
  findLibWindow : function(poWindow) {
    var voWindow = null;
    var voLib = null;
    voLib = poWindow.top.document.getElementById("_eXriaGlobalLibraryFrame_");
    if (voLib == null) voWindow = this._findLibWindow(poWindow);
    else voWindow = poWindow.top;
    if (voWindow == null) {
      while (poWindow.opener || poWindow.dialogArguments) {
        poWindow = poWindow.opener || (poWindow.dialogArguments.window ? poWindow.dialogArguments.window : poWindow.dialogArguments);
        if (poWindow.document) voWindow = this._findLibWindow(poWindow);
        if (voWindow) break;
      }
    }
    return voWindow;
  },
  
  /**
   * 자신을 포함해서 상위 프레임으로 공통 라이브러리를 포함한 메인 페이지의 window를 얻어오기 위한 메소드
   * @param {HTMLWindow} poWindow  메인 페이지 window 검색을 위해 검색 시작점이 되는 window 객체
   * @return 공통 라이브러리를 포함한 메인 페이지의 window
   * @type HTMLWindow
   * @ignore
   */  
  _findLibWindow : function(poWindow) {
    var voWindow = null;
    var voLib = poWindow.document.getElementById("_eXriaGlobalLibraryFrame_");
    if (voLib == null) {
      while (poWindow.parent) {
        if (poWindow != poWindow.parent) poWindow = poWindow.parent;
        else break;
        voLib = poWindow.document.getElementById("_eXriaGlobalLibraryFrame_");
        if (voLib) {
          voWindow = poWindow;
          break;
        }
      }
    }
    return voWindow;
  },
  
  /**
   * 해당 파일이 지정된 확장자에 속하는지 체크.
   * ex) Common.checkFileFormat("c:\temp\download\test.xls", ["xls", "xlsx"]);
   * @param {String} psFileName 파일명.
   * @param {String} paFileFormat 확장자명.
   * @return 지정된 확장자인지 여부.
   * @type Boolean
   */  
  checkFileFormat : function(psFileName, paFileFormat) {
    try {
      var vs = psFileName.split(".");
      var vnSize = vs.length;
      
      var vsFormat = vs [vnSize - 1];
      var vbRt = false;
      
      for (var vsIdx in paFileFormat) {
        if (vsFormat == paFileFormat [vsIdx])
        vbRt = true;
      }
      
      if (!vbRt) throw new Exception();
      
    } catch (e) {
//      alert("지원하는 파일 폿맷이 아닙니다.");
        ComMsg.showMsg("co.error.fileformat");
      return false;
    }
    
    return true;
  },
  
  /**
   * FileSelector 컨트롤의 해당 파일이 지정된 확장자에 속하는지 체크.
   * ex) Common.checkFileSelectorFormat("voFileSelector", ["xls", "xlsx"]);
   * @param {String} psControlId 컨트롤 아이디.
   * @param {String} paFileFormat 지정 파일 확장자.
   * @return 저정된 확장자인지 여부.
   * @type Boolean
   */  
  checkFileSelectorFormat : function(psControlId, paFileFormat) {
    
    var vsFileName = page.getControl(psControlId).getValue();
    if (vsFileName == "") {
//      alert("로딩할 파일을 선택해주세요.");
      ComMsg.showMsg("co.warn.choosefile");
      return false;
    }
    
    return Common.checkFileFormat(vsFileName, paFileFormat);
  },
  
  /**
   * 현재 선택된 노드와 이전에 선택된 노드의 상위 루트가 다르다면 이전에 선택
   * 되어진 노드를 닫는다.(이전에 선택되어진값을 알고 있어야함)
   * @param {String} 트리뷰아이디.
   * @param {String} 이전에 선택되어진 노드값
   * @param {String} 현재 선택되어진 노드값
   */
  closeTrvNode : function(psTrvId, psBeforeVal, psSelVal) {
    if (psBeforeVal == null || psSelVal == null) return;
    var findParent = function(poNode) {
      var voParent = poNode;
      var voRoot = poNode.getRoot();
      while (voParent.parent != voRoot) {
        voParent = voParent.parent;
      }
      return voParent;
    };
    var vcTrv = page.getControl(psTrvId);
    var voBNode = vcTrv.getNodeByVal(psBeforeVal);
    var voBParent = findParent(voBNode);
    var voNNode = vcTrv.getNodeByVal(psSelVal);
    var voNParent = findParent(voNNode);
    if (voBParent != voNParent) vcTrv.toggleNode(voBParent);
  },
  
  /**
   * Fusion Chart 구성 정보를 문자열 형태로 반환해주는 메소드.
   * @param {String} psId 구성 정보 저장 인스턴스 아이디
   * @param {String} psXpath 구성 정보 저장 인스턴스 패스
   */  
  getChartFormatStr : function(psId, psXpath) {
    var appendStr = function(psTagName, psEnd, poNodeList) {
      var vsStr = "<" + psTagName;
      
      var vnChildLen = poNodeList.getLength();
      
      for (var i = 0; i < vnChildLen; i++) {
        var voSubChild = poNodeList.item(i).getFirstChild();
        if (voSubChild == null)
        continue;
        
        vsStr = vsStr + " " + voSubChild.getParentNode().getNodeName() + "='"
        + String(voSubChild.getNodeValue()) + "'"; //박상찬 수정
      }
      return vsStr + psEnd;
    };
    
    var appendStrRow = function(psTagName, psEnd, poNodeList) {
      var vsStr = "";
      
      var vnChildLen = poNodeList.getLength();
      for (var i = 0; i < vnChildLen; i++) {
        var poSubNodes = poNodeList.item(i).getChildNodes();
        var vnSubNodeSize = poSubNodes.getLength();
        
        vsStr += "<" + psTagName;
        
        for (var j = 0; j < vnSubNodeSize; j++) {
          var voSubChild = poSubNodes.item(j).getFirstChild();
          if (voSubChild == null)
          continue;
          //attribute name
          vsStr = vsStr + " " + voSubChild.getParentNode().getNodeName() + "='"
          + String(voSubChild.getNodeValue()) + "'"; //박상찬 수정
        }
        
        vsStr += psEnd;
      }
      return vsStr;
    };
    
    if (!psId || !psXpath)
    throw new Error("parameter Error.");
    
    var voInstance = page.getInstance(psId);
    if (voInstance == null)
    throw new Error("instance is null.");
    
    var voNodes = voInstance.selectSingleNode(psXpath);
    if (voNodes == null)
    throw new Error("node is null.");
    
    var voChildNodes = voNodes.getChildNodes();
    var vnLength = voChildNodes.getLength();
    
    var vsChartStr = "";
    var vsConfigStr = "";
    var vsSetStr = "";
    var vsCate = "";
    var vsDataSet = "";
    
    for (var i = 0; i < vnLength; i++) {
      var voChild = voChildNodes.item(i).getFirstChild();
      if (voChild == null)
      continue;
      
      var vsChildParenNodeName = String(voChild.getParentNode().getNodeName());//차트부분 수정
      
      if (voChild.getNodeType() == 1) {
        var voSubChilds = voChild.getParentNode().getChildNodes();
        
        switch (vsChildParenNodeName) {
          case "config" :
          vsConfigStr = appendStr("graph", ">", voSubChilds);
          break;
          case "data" :
            vsSetStr = appendStrRow("data", "/>", voSubChilds);
            break;
          case "set" :
          vsSetStr = appendStrRow("set", "/>", voSubChilds);
          break;
          case "categories" :
          var vsCateConfigStr = "";
          var vsCateStr = "";
          
          var voCateNodes = voSubChilds;
          
          var vnSize = voCateNodes.getLength();
          
          for (var j = 0; j < vnSize; j++) {
            
            switch (voCateNodes.item(j).getNodeName()) {
              case "config" :
              vsCateConfigStr = appendStr("categories", ">",
              voCateNodes.item(j).getChildNodes());
              break;
              case "category" :
              vsCateStr = appendStrRow("category", "/>",
              voCateNodes.item(j).getChildNodes());
              break;
            }
          }
          
          vsCate = (vsCateConfigStr.length > 0) ? vsCateConfigStr : "<categories>";
          
          vsCate = vsCate + vsCateStr + "</categories>";
          
          break;
          case "dataset" :
          var vnDataSetRowNodes = voSubChilds;
          var vsDataSetConfStr = "";
          var vsDataSetSetStr = "";
          var vnDataSetRowNodesSize = vnDataSetRowNodes.getLength();
          
          for (var k = 0; k < vnDataSetRowNodesSize; k++) {
            
            var voDataSetNodeChildNodes = vnDataSetRowNodes.item(k).getChildNodes();
            var vnChildNodeLen = voDataSetNodeChildNodes.getLength();
            
            for (var l = 0; l < vnChildNodeLen; l++) {
              switch (voDataSetNodeChildNodes.item(l).getNodeName()) {
                case "config" :
                vsDataSetConfStr = appendStr("dataset", ">",
                voDataSetNodeChildNodes.item(l).getChildNodes());
                break;
                case "set" :
                vsDataSetSetStr = appendStrRow("set", "/>",
                voDataSetNodeChildNodes.item(l).getChildNodes());
                break;
              }
            }
            vsDataSet += (vsDataSetConfStr.length > 0) ? vsDataSetConfStr : "<dataset>";
            vsDataSet = vsDataSet + vsDataSetSetStr + "</dataset>";
          }
          break;
          default :
        }
      }
    }
    
    vsChartStr = (vsConfigStr.length > 0) ? vsConfigStr : "<graph>";
    
    vsChartStr = vsChartStr + vsSetStr + vsCate + vsDataSet + "</graph>";
    
    return vsChartStr;
  },
  
  /**
   * 화면 제어를 막기위해 얇은 막을 씌워줍니다.
   * @param {Number} pnLeft 막의 left 위치
   * @param {Number} pnTop 막의 Top 위치
   * @param {Number} pnWidth 막의 가로 길이
   * @param {Number} pnHeight 막의 세로 길이
   */  
  coverPage : function(pnLeft, pnTop, pnWidth, pnHeight) {
    if (pnLeft == null) pnLeft = 0;
    if (pnTop == null) pnTop = 0;
    var voCanvas = page.canvas;
    if (pnWidth == null) pnWidth = voCanvas.width;
    if (pnHeight == null) pnHeight = voCanvas.height;
    
    // 백그라운드에 rectangle로 씌움
    var objBackgroundRect = voCanvas.createControl("rectangle", "rctCoverPage", pnLeft, pnTop, pnWidth, pnHeight);
    objBackgroundRect.zIndex = 10002;
    objBackgroundRect.fillType = "solid";
    objBackgroundRect.fillStartColor = "#FFFFFF";
    objBackgroundRect.fillOpacity = 40;
    objBackgroundRect.penWeight = 0;
    voCanvas.appendControl(objBackgroundRect);
  },
  
  /**
   * coverPage로 생성한 막을 제거합니다.
   */  
  removeCover : function() {
    var voRectBody = page.getControl("rctCoverPage");
    if (voRectBody) page.canvas.removeControl("rctCoverPage");
  },

  /**
  */  
 resizeWindow : function(paHList, paVList, paHVList) {
   page.mnWidth = page.window.document.documentElement.clientWidth;
   page.mnHeight = page.window.document.documentElement.clientHeight;
   var vsEventCnt = "resizeEventCnt_" + page.id;
   
   if(paHList == null && paVList == null && paHVList == null) {
     paHVList = [];
     var voControls = page.canvas.controls.entries;
     for(var member in voControls) {
       member = voControls[member];
       if(member.toString() == "SubPage") paHVList.push(member);
       else if(member.toString() == "GridEx") paHVList.push(member);
     }
   }
   if(paHList == null) paHList = [];
   if(paVList == null) paVList = [];
   if(paHVList == null) paHVList = [];
   var vnSize = paHVList.length;
   var voApplyAttrMap = {};
   var vcCtl = null;
   for(var i = 0; i < vnSize; i++) {
     vcCtl = paHVList[i];
     if(typeof(vcCtl) == "string") {
       vcCtl = page.getControl(vcCtl);
       paHVList[i] = vcCtl;
     }
     if(vcCtl.toString() == "SubPage") voApplyAttrMap[vcCtl.id] == "";
   }
   
   var voFunc = function() {
     page[vsEventCnt] = 0
     var vnHGap = page.window.document.documentElement.clientWidth - page.mnWidth;
     var vnVGap = page.window.document.documentElement.clientHeight - page.mnHeight;
     page.mnWidth = page.window.document.documentElement.clientWidth;
     page.mnHeight = page.window.document.documentElement.clientHeight;
     var vcCtl = null;
     var vnSize = paHList.length;
     for(var i = 0; i < vnSize; i++) {
       vcCtl = paHList[i];
       if(typeof(vcCtl) == "string") {
         vcCtl = page.getControl(vcCtl);
         paHList[i] = vcCtl;
       }
       vcCtl.applyAttr("width", vcCtl.width + vnHGap);
     }
     vnSize = paVList.length;
     for(var i = 0; i < vnSize; i++) {
       vcCtl = paVList[i];
       if(typeof(vcCtl) == "string") {
         vcCtl = page.getControl(vcCtl);
         paVList[i] = vcCtl;
       }
       vcCtl.applyAttr("height", vcCtl.height + vnVGap);
     }
     vnSize = paHVList.length;
     for(var i = 0; i < vnSize; i++) {
       vcCtl = paHVList[i];
       if(voApplyAttrMap[vcCtl.id] == null) {
         vcCtl.width = vcCtl.width + vnHGap;
         vcCtl.height = vcCtl.height + vnVGap;
         vcCtl.refresh(null, null, true);
       } else {
         vcCtl.applyAttr("width", vcCtl.width + vnHGap);
         vcCtl.applyAttr("height", vcCtl.height + vnVGap);
       }
     }
   };
   
   if (page[vsEventCnt] == null) page[vsEventCnt] = 0;
   
   if(page.window.onresize == null) {
     page.window.onresize = function(poEvent) {
       page[vsEventCnt]++;
       
       var voCaller = arguments.caller;       
       if(!!voCaller) return false; 

       if (page[vsEventCnt] == 1) {
         setTimeout(voFunc, 1000);
       }
     };
   }
   
 }
};

PageNavigation = {
  /**
   * 그리드 컨트롤의 pageNavigation 생성
   * @param {String} psGrxId 그리드 아이디.
   * @param {String} psSubId  서브미션 아이디
   * @param {eXria.form.Page} poPage 페이지 객체
   */  
  create : function(psGrxId, psSubId, poPage) {
    //var voReturn = {};
    
  }
}

/**
 * 모달 다이어로그를 띄움.
 */
MsgBox = {
  // Dialog Type
  QUESTION : 1,
  INFORM : 2,
  CAUTION : 3,
  ALERT : 4,
  MESSAGE : 5,
  
  // Button Type
  OKONLY : 6,
  OKCANCEL : 7,
  YESNO : 8,
  YESNOCANCEL : 13,
  
  OK : 9,
  CANCEL : 10,
  
  YES : 11,
  NO : 12,
  MSG_TITLE : "KaeWon University",
  
  /**
   * 메시지 키를 통해 메세지를 얻어오는 메소드
   * ex) MsgBox.getMsg(NLS.MSG.INF.M004("처리"));
   * @param {String} psMsg 메세지 키
   * @param {Array(String)} psaArgs 메세지 치환 문자열 리스트
   * @return 메세지 문자열
   * @type String
   */  
  getMsg : function(psMsg, psaArgs) {
    if (psMsg == null || psMsg == "") return "";
    if (psaArgs == null || psaArgs == "") {
      return psMsg;
    }
    
    var vnIndex = 0;
    var vnCount = 0;
    while ((vnIndex = psMsg.indexOf("@", vnIndex)) != - 1) {
      if (psaArgs [vnCount] == null) psaArgs [vnCount] = "";
      psMsg = psMsg.substr(0, vnIndex) + String(psaArgs [vnCount]) + psMsg.substring(vnIndex + 1);
      vnIndex = vnIndex + String(psaArgs [vnCount++]).length;
    }
    return psMsg;
  },
  
  /**
   * 확인 다이얼로그 호출(예/아니오/취소 버튼).
   * ex) MsgBox.showConfirm(page, NLS.MSG.CRM.M001);
   * @param {eXria.form.Page} poPage 페이지 객체
   * @param {String} psMsg 기 정의된 메세지 스트링 객체 혹은 메세지 문자열
   * @param {Array(String)} paArgs pstrMessage 내의 @가 치환될 문자열 배열
   * @param {Number} pnWidth 메세지 창 가로 길이(생략가능)
   * @param {Number} pnHeight 메세지 창 세로 길이(생략가능)
   * @return 버튼 선택에 따른 결과값
   * @type String
   */  
  showConfirm : function(poPage, psMsg, paArgs, pnWidth, pnHeight) {
    var vsMsg = this.getMsg(psMsg, paArgs);
    var vnPopUpType = MsgBox.QUESTION;
    var vnBtnType = MsgBox.YESNOCANCEL;
    var vnDimensionWidth = 300;
    var vnDimensionHeight = 150;
    if (pnWidth) vnDimensionWidth = pnWidth;
    if (pnHeight) vnDimensionHeight = pnHeight;
    
    var vsRetVal = this.showDialog(vnPopUpType, vnBtnType, poPage, vnDimensionWidth, vnDimensionHeight, MsgBox.MSG_TITLE, vsMsg);
    return vsRetVal;
  },
  
  /**
   * 알림창 호출(확인 버튼).
   * ex) MsgBox.showConfirm(page, NLS.MSG.CRM.M001);
   * @param {eXria.form.Page} poPage 페이지 객체
   * @param {String} psMsg 기 정의된 메세지 스트링 객체 혹은 메세지 문자열
   * @param {Array(String)} paArgs pstrMessage 내의 @가 치환될 문자열 배열
   * @param {Number} pnWidth 메세지 창 가로 길이(생략가능)
   * @param {Number} pnHeight 메세지 창 세로 길이(생략가능)
   * @return 버튼 선택에 따른 결과값
   * @type String
   */  
  showInform : function(poPage, psMsg, paArgs, pnWidth, pnHeight) {
    var vsMsg = this.getMsg(psMsg, paArgs);
    var vnDimensionWidth = 300;
    var vnDimensionHeight = 150;
    if (pnWidth) vnDimensionWidth = pnWidth;
    if (pnHeight) vnDimensionHeight = pnHeight;
    
    var vsRetVal = this.showDialog(MsgBox.INFORM, this.OKONLY, poPage, vnDimensionWidth, vnDimensionHeight, MsgBox.MSG_TITLE, vsMsg);
    return vsRetVal;
  },
  
  /**
   * 경고창 호출(확인 버튼).
   * ex) MsgBox.showWarn(page, "@입니다.", ["테스트"]);
   * @param {eXria.form.Page} poPage 페이지 객체
   * @param {String} psMsg 기 정의된 메세지 스트링 객체 혹은 메세지 문자열
   * @param {Array(String)} paArgs pstrMessage 내의 @가 치환될 문자열 배열
   * @param {Number} pnWidth 메세지 창 가로 길이(생략가능)
   * @param {Number} pnHeight 메세지 창 세로 길이(생략가능)
   * @return 버튼 선택에 따른 결과값
   * @type String
   */  
  showWarn : function(poPage, psMsg, paArgs, pnWidth, pnHeight) {
    var vsErrMsg = this.getMsg(psMsg, paArgs);
    var vnDimensionWidth = 300;
    var vnDimensionHeight = 150;
    if (pnWidth) vnDimensionWidth = pnWidth;
    if (pnHeight) vnDimensionHeight = pnHeight;
    
    var vsRetVal = this.showDialog(this.ALERT, this.OKONLY, poPage, vnDimensionWidth, vnDimensionHeight, MsgBox.MSG_TITLE, vsErrMsg);
    return vsRetVal;
  },
  
  /**
   * 오류확인창 호출(확인 버튼).
   * ex) MsgBox.showError(page, NLS.MSG.ERR.SRV_);
   * @param {eXria.form.Page} poPage 페이지 객체
   * @param {String} psMsg 기 정의된 메세지 스트링 객체 혹은 메세지 문자열
   * @param {Array(String)} paArgs pstrMessage 내의 @가 치환될 문자열 배열
   * @param {Number} pnWidth 메세지 창 가로 길이(생략가능)
   * @param {Number} pnHeight 메세지 창 세로 길이(생략가능)
   * @return 버튼 선택에 따른 결과값
   * @type String
   */  
  showError : function(poPage, psMsg, paArgs, pnWidth, pnHeight) {
    var vsErrMsg = this.getMsg(psMsg, paArgs);
    var vnDimensionWidth = 300;
    var vnDimensionHeight = 150;
    if (pnWidth) vnDimensionWidth = pnWidth;
    if (pnHeight) vnDimensionHeight = pnHeight;
    
    var vsRetVal = this.showDialog(this.CAUTION, this.OKONLY, poPage, vnDimensionWidth, vnDimensionHeight, MsgBox.MSG_TITLE, vsErrMsg);
    return vsRetVal;
  },
  
  /**
   * 여러 메시지를 그리드에 표현하여 메시지 창 호출(확인 버튼).
   * 메시지 리스트를 서버로부터 받아오는 경우에 사용
   * ex) MsgBox.showMessage(page, "instance", "/root/message/list", "메시지 리스트");
   * @param {String} psInstanceId 메시지가 정의된 instance id
   * @param {String} psInstancePath 메시지가 정의된 instance path
   * @param {eXria.form.Page} poPage 페이지 객체
   * @param {String} psMsg 기 정의된 메세지 스트링 객체 혹은 메세지 문자열
   * @param {Array(String)} paArgs pstrMessage 내의 @가 치환될 문자열 배열
   * @param {Number} pnWidth 메세지 창 가로 길이(생략가능)
   * @param {Number} pnHeight 메세지 창 세로 길이(생략가능)
   * @return 버튼 선택에 따른 결과값
   * @type String
   */  
  showMessage : function(poPage, psInstanceId, psInstancePath, psMsg, paArgs, pnWidth, pnHeight) {
    var vnPopUpType = MsgBox.MESSAGE;
    var vnBtnType = MsgBox.OKONLY;
    var vsMsg = this.getMsg(psMsg, paArgs);
    var vnDimensionWidth = 600;
    var vnDimensionHeight = 400;
    if (pnWidth) vnDimensionWidth = pnWidth;
    if (pnHeight) vnDimensionHeight = pnHeight;
    
    var vsRetVal = this.showDialog(vnPopUpType, vnBtnType, poPage, vnDimensionWidth, vnDimensionHeight, MsgBox.MSG_TITLE, vsMsg, "kor", psInstanceId, psInstancePath);
    return vsRetVal;
  },
  
  /**
   *  메세지 번호에 해당하는 메시지를 보여준다.
   *  메세지 내용과 표시형식을 서버로부터 받아오는 경우에 사용한다.
   *  메세지가 저장되는 instance id와 instance Path는 각각 "insLang"과 "/root/msg/list"이다.
   * ex) MsgBox.showMessage(page, "instance", "/root/message/list", "메시지 리스트");
   * @param {eXria.form.Page} poPage 페이지 객체
   * @param {String} psMsgNo 메세지 번호지정 문자열
   * @param {Number} pnWidth 메세지 창 가로 길이(생략가능)
   * @param {Number} pnHeight 메세지 창 세로 길이(생략가능)
   * @return 버튼 선택에 따른 결과값
   * @type String
   */  
  showMsg : function(poPage, psMsgNo, pnWidth, pnHeight) {
    var vsRetVal = null;
    var vsInstanceId = "insLang";
    var vsInstancePath = "/root/msg/list";
    var voInstance = poPage.getInstance(vsInstanceId);
    
    // 인스턴스 존재여부
    if (voInstance == null || voInstance == 'undefined') {
//      alert("instance id(" + vsInstanceId + ")는 존재하지 않는다.");
      ComMsg.showMsg("co.error.instid", [vsInstanceId]);
      return vsRetVal;
    }
    
    var voMsgCollection;
    
    // 엘리먼트 존재여부
    try {
      voMsgCollection = voInstance.selectNodes(vsInstancePath);
    } catch (e) {
//      alert("엘리먼트(ID: " + vsInstanceId + ", XPath: " +
//      vsInstancePath + ")가 존재하지 않습니다.");
      ComMsg.showMsg("co.error.instpath", [vsInstanceId, vsInstancePath]);
      return vsRetVal;
    }
    
    var vnSize = voMsgCollection.getLength();
    if (vnSize <= 0) {
//      alert("메세지 번호(" + psMsgNo + ")가 없습니다.");
      ComMsg.showMsg("co.error.msgid", [psMsgNo]);
      return vsRetVal;
    }
    
    var voMsgMap = null;
    var vsMsgNo = "";
    var vsMsgName = "";
    var vsMsgType = "";
    
    // 메시지번호에 해당하는 메시지 타입과 메시지를 추출
    for (var i = 0; i < vnSize; i++) {
      voMsgMap = voMsgCollection.item(i);
      voMsgMap = new eXria.data.xhtml.MapNode(voMsgMap);
      var vsMsgNo = voMsgMap.get("msg_no");
      
      if (vsMsgNo == psMsgNo) {
        vsMsgNo = eXria.util.ValueUtil.fixNull(voMsgMap.get("msg_no"));
        vsMsgName = eXria.util.ValueUtil.fixNull(voMsgMap.get("msg_name"));
        vsMsgType = eXria.util.ValueUtil.fixNull(voMsgMap.get("msg_type_code"));
        break;
      }
    }
    
    // 메시지번호가 존재하지 않을 때,
    if (vsMsgNo.length <= 0) {
//      alert("메세지 번호(" + psMsgNo + ")가 없습니다.");
      ComMsg.showMsg("co.error.msgid", [psMsgNo]);
      return vsRetVal;
    }
    
    var vnPopUpType = MsgBox.ALERT;
    var vnBtnType = MsgBox.OKONLY;
    
    // 메시지 타입에 따라 다이어로그 타입과 버튼타입을 결정.
    if (vsMsgType.length <= 0) {
      // 메세지 타입이 존재하지 않을 때, alert
      
    } else if (vsMsgType == "inform") {
      vnPopUpType = MsgBox.INFORM;
      vnBtnType = MsgBox.OKONLY;
    } else if (vsMsgType == "alert") {
      vnPopUpType = MsgBox.ALERT;
      vnBtnType = MsgBox.OKONLY;
    } else if (vsMsgType == "question") {
      vnPopUpType = MsgBox.QUESTION;
      vnBtnType = MsgBox.YESNO;
    } else if (vsMsgType == "error") {
      vnPopUpType = MsgBox.CAUTION;
      vnBtnType = MsgBox.OKONLY;
    } else {
      // 메세지 타입이 존재하지 않을 때, alert
    }
    
    // 메시지 다이어로그를 띄움.
    var vnDimensionWidth = 300;
    var vnDimensionHeight = 150;
    if (pnWidth) vnDimensionWidth = pnWidth;
    if (pnHeight) vnDimensionHeight = pnHeight;
    
    vsRetVal = this.showDialog(vnPopUpType, vnBtnType, poPage, vnDimensionWidth, vnDimensionHeight, MsgBox.MSG_TITLE, vsMsgName);
    return vsRetVal;
  },
  
  /**
   * 메시지 다이어로그를 띄움.
   * ex) MsgBox.showDialog(MsgBox.ALTER, MsgBox.OKONLY, page, 300, 150, MsgBox.MSG_TITLE, NLS.MSG.CRM.M001);
   * @param {Number} pnPopUpType 메시지박스 타입 구분 상수
   * @param {Number} pnBtnType 버튼 타입 구분 상수
   * @param {eXria.form.Page} poRefPage 페이지 객체
   * @param {Number} pnDimensionWidth 메세지 창 가로 크기(px)
   * @param {Number} pnDimensionWidth 메세지 창 세로 크기(px)
   * @param {String} psTitle 메세지 창 제목 문자열
   * @param {String} psMsg 기 정의된 메세지 스트링 객체 혹은 메세지 문자열
   * @param {String} psLang 언어 구분 문자열
   * @param {String} psInstanceId 메세지가 정의된 instance id
   * @param {String} psInstancePath 메세지가 정의된 instance path
   */  
  showDialog : function(pnPopUpType, pnBtnType, poRefPage, pnDimensionWidth, pnDimensionHeight, psTitle, psMsg, psLang, psInstanceId, psInstancePath) {
    var vsRetVal = null;
    var voWindow = poRefPage.window;
    voWindow.moMsgPopUp = {};
    var voMsgPopUp = voWindow.moMsgPopUp;
    voMsgPopUp.popUpType = pnPopUpType;
    voMsgPopUp.btnType = pnBtnType;
    voMsgPopUp.refPage = poRefPage;
    voMsgPopUp.dimensionWidth = pnDimensionWidth;
    voMsgPopUp.dimensionHeight = pnDimensionHeight;
    voMsgPopUp.title = psTitle;
    voMsgPopUp.msg = psMsg;
    voMsgPopUp.lang = psLang;
    voMsgPopUp.instanceId = psInstanceId;
    voMsgPopUp.instancePath = psInstancePath;
    
    var vsSpecs = "status=0;resizable=0;scroll=0;";
    vsSpecs += "dialogWidth=" + pnDimensionWidth + "px;";
    vsSpecs += "dialogHeight=" + pnDimensionHeight + "px";
    
    voWindow.showModalDialog(page.metadata.resourceBaseUrl + "script/stdMsgDialog.xrf", voWindow, vsSpecs);
    if (voMsgPopUp.retVal) vsRetVal = voMsgPopUp.retVal;
    return vsRetVal;
  }
};

/**
 * 위치를 담고 있는 클래스
 *
 * @param left
 * @param top
 * @param width
 * @param height
 * @return
 * @private
 */
function Position(left, top, width, height) {
  this.left = left;
  this.top = top;
  this.width = width;
  this.height = height;
}

/**
 * 타입에 따른 디자인을 계산하는 클래스
 * @private
 */
function DesignManager(pnPopUpType) {
  this.type = pnPopUpType;
  
  this.getIconSrc = function() {
    var iconPath = page.metadata.resourceBaseUrl + "/sj/style/theme1/icon/";
    var src = "";
    
    switch (this.type) {
      case MsgBox.QUESTION :
      src = "icon_bigminus.gif";
      break;
      case MsgBox.INFORM :
      src = "icon_bigplus.gif";
      break;
      case MsgBox.CAUTION :
      src = "icon_calendar.gif";
      break;
      case MsgBox.ALERT :
      src = "icon_next.gif";
      break;
      case MsgBox.MESSAGE :
      src = "icon_plus.gif";
      break;
    }
    
    return iconPath + src;
  };
  
  this.getIconClassName = function() {
    var strClassName = "";
    
    switch (this.type) {
      case MsgBox.QUESTION :
      strClassName = "alert_icon02";
      break;
      case MsgBox.INFORM :
      strClassName = "alert_icon03";
      break;
      case MsgBox.CAUTION :
      strClassName = "alert_icon01";
      break;
      case MsgBox.ALERT :
      strClassName = "alert_icon04";
      break;
      case MsgBox.MESSAGE :
      strClassName = "alert_icon04";
      break;
    }
    
    return strClassName;
  };
}

/**
 * 타입에 따른 레이아웃을 계산하는 클래스
 * @private
 */
function LayoutManager(pnPopUpType, pnBtnType, pnMsgBoxWidth, pnMsgBoxHeight, pnCanvasWidth, pnCanvasHeight) {
  this.type = pnPopUpType;
  this.btnType = pnBtnType;
  this.canvasWidth = pnCanvasWidth;
  this.canvasHeight = pnCanvasHeight;
  
  this.messageBoxWidth = pnMsgBoxWidth;
  this.messageBoxHeight = pnMsgBoxHeight;
  
  this.messageBoxLeft = (this.canvasWidth - this.messageBoxWidth) / 2;
  this.messageBoxTop = (this.canvasHeight - this.messageBoxHeight) / 2;
  // this.messageBoxRight = this.messageBoxLeft + this.messageBoxWidth;
  // this.messageBoxBottom = this.messageBoxTop + this.messageBoxHeight;
  
  this.titleAreaHeight = 30; // 타이틀 영역 높이
  
  this.verticalBorder = 20; // 메시지 박스 양 옆의 보더
  this.horizontalBorder = 15; // 메시지 박스 위 아래 보더
  
  this.titleWidth = this.messageBoxWidth; // 타이틀 라벨의 가로 길이
  this.titleHeight = 30; // 타이틀 라벨의 세로 길이
  
  this.iconWidth = 46; // 아이콘의 가로 길이
  this.iconHeight = 40; // 아이콘의 세로 길이
  
  this.buttonWidth = 80;
  this.buttonHeight = 21;
  
  this.iconContentBorder = 5;
  this.iconButtonBorder = 10;
  
  if (pnBtnType == MsgBox.YESNOCANCEL) {
    this.buttonBorder = 0.25 * (this.messageBoxWidth - 3 * this.buttonWidth);
    this.buttonMsgBoxBorder = 0.45 * (this.messageBoxWidth - 3 * this.buttonWidth);
  } else {
    this.buttonBorder = 0.25 * (this.messageBoxWidth - 2 * this.buttonWidth);
    this.buttonMsgBoxBorder = 0.375 * (this.messageBoxWidth - 2 * this.buttonWidth);
  }
  
  this.gridBorder = 3;
  
  this.contentLeft = this.verticalBorder + this.iconWidth + this.iconContentBorder;
  this.contentTop = this.horizontalBorder + this.titleAreaHeight;
  this.contentWidth = this.messageBoxWidth - (this.verticalBorder + this.iconWidth + this.iconContentBorder + this.verticalBorder);
  this.contentHeight = this.messageBoxHeight -
  (this.horizontalBorder + this.titleAreaHeight + this.buttonHeight + this.iconButtonBorder + this.horizontalBorder);
  
  this.content2Height = 0.2 * (this.messageBoxHeight -
  (this.horizontalBorder + this.titleAreaHeight + this.buttonHeight + this.iconButtonBorder + this.horizontalBorder + this.gridBorder));
  
  this.gridTop = this.contentTop + this.content2Height + this.gridBorder;
  this.gridWidth = this.messageBoxWidth - (this.verticalBorder + this.verticalBorder);
  this.gridHeight = 0.8 * (this.messageBoxHeight -
  (this.horizontalBorder + this.titleAreaHeight + this.buttonHeight + this.iconButtonBorder + this.horizontalBorder + this.gridBorder));
  
  this.getBackgroundRect = function() {
    return new Position(0, 0, this.canvasWidth, this.canvasHeight);
  };
  
  this.getMessageBoxRect = function() {
    return new Position(this.messageBoxLeft, this.messageBoxTop, this.messageBoxWidth, this.messageBoxHeight);
  };
  
  this.getTitleAreaRect = function() {
    return new Position(this.messageBoxLeft, this.messageBoxTop, this.messageBoxWidth, this.titleAreaHeight);
  };
  
  this.getTitleRect = function() {
    return new Position(this.messageBoxLeft, this.messageBoxTop, this.titleWidth, this.titleHeight);
  };
  
  this.getIconRect = function() {
    var numTopBorder = this.titleAreaHeight + this.horizontalBorder;
    
    return new Position(this.verticalBorder, numTopBorder,
    this.iconWidth, this.iconHeight);
    /*
     * if(this.type == MsgBox.INFORM || this.type == MsgBox.CAUTION ||
     * this.type == MsgBox.ALERT || this.type == MsgBox.QUESTION) {
     *
     * return new Position(this.messageBoxLeft + 20, this.messageBoxTop + 20,
     * this.messageBoxHeight - 90, this.messageBoxHeight - 90); } else if
     * (this.type == MsgBox.MESSAGE) { return new
     * Position(this.messageBoxLeft + 20, this.messageBoxTop + 20,
     * (this.messageBoxHeight - 110) * 0.3, (this.messageBoxHeight - 110) *
     * 0.3); }
     */    
  }
  
  this.getContentRect = function() {
    if (this.type == MsgBox.INFORM || this.type == MsgBox.CAUTION
    || this.type == MsgBox.ALERT || this.type == MsgBox.QUESTION) {
      
      return new Position(this.contentLeft, this.contentTop, this.contentWidth, this.contentHeight);
      
    } else if (this.type == MsgBox.MESSAGE) {
      return new Position(this.contentLeft, this.contentTop, this.contentWidth, this.content2Height);
      
    }
  };
  
  this.getMessageGridRect = function() {
    if (this.type == MsgBox.INFORM || this.type == MsgBox.CAUTION
    || this.type == MsgBox.ALERT || this.type == MsgBox.QUESTION) {
      
      return null;
      
    } else if (this.type == MsgBox.MESSAGE) {
      return new Position(this.verticalBorder, this.gridTop, this.gridWidth, this.gridHeight);
    }
  };
  
  this.getMessageGridWidth = function() {
    if (this.type == MsgBox.INFORM || this.type == MsgBox.CAUTION
    || this.type == MsgBox.ALERT || this.type == MsgBox.QUESTION) {
      
      return null;
      
    } else if (this.type == MsgBox.MESSAGE) {
      return this.gridWidth;
    }
  };
  
  this.getOKOnlyBtnRect = function() {
    var left = this.messageBoxWidth / 2 - this.buttonWidth / 2;
    var top = this.messageBoxHeight - this.horizontalBorder - this.buttonHeight;
    
    return new Position(left, top, this.buttonWidth, this.buttonHeight);
  };
  
  this.getOkBtnRect = function() {
    var left = this.buttonMsgBoxBorder;
    var top = this.messageBoxHeight - this.horizontalBorder - this.buttonHeight;
    
    return new Position(left, top, this.buttonWidth, this.buttonHeight);
    
    return new Position(this.messageBoxWidth - 203, this.messageBoxHeight - 50, 90, 30);
  };
  
  this.getNoBtnRect = function() {
    if (pnBtnType == MsgBox.YESNOCANCEL) {
      var left = this.buttonMsgBoxBorder + this.buttonWidth + this.buttonBorder / 3;
      var top = this.messageBoxHeight - this.horizontalBorder - this.buttonHeight;
    } else {
      var left = this.buttonMsgBoxBorder + this.buttonWidth + this.buttonBorder;
      var top = this.messageBoxHeight - this.horizontalBorder - this.buttonHeight;
    }
    
    return new Position(left, top, this.buttonWidth, this.buttonHeight);
  };
  
  this.getCancelBtnRect = function() {
    if (pnBtnType == MsgBox.YESNOCANCEL) {
      var left = this.buttonMsgBoxBorder + this.buttonWidth + this.buttonBorder / 3 + this.buttonWidth + this.buttonBorder / 3;
      var top = this.messageBoxHeight - this.horizontalBorder - this.buttonHeight;
    } else {
      var left = this.buttonMsgBoxBorder + this.buttonWidth + this.buttonBorder;
      var top = this.messageBoxHeight - this.horizontalBorder - this.buttonHeight;
    }
    
    return new Position(left, top, this.buttonWidth, this.buttonHeight);
  };
}

/**
 * ContentsManager
 * @param pnumPopUpType
 * @param pnumBtnType
 * @param poPage
 * @param psMsg
 * @param pstrTitle
 * @param pstrLanguage
 * @param pstrInstanceId
 * @param pstrInstanceXpath
 * @return
 * @private
 */
function ContentsManager(pnumPopUpType, pnumBtnType, poPage, psMsg,
pstrTitle, pstrLanguage, pstrInstanceId, pstrInstanceXpath) {
  this.type = pnumPopUpType;
  this.btnType = pnumBtnType;
  this.page = poPage;
  
  this.msg = psMsg;
  this.title = pstrTitle;
  this.lang = pstrLanguage;
  
  this.instanceId = pstrInstanceId;
  this.instanceXpath = pstrInstanceXpath;
  
  this.getInstanceId = function() {
    return this.instanceId;
  }
  
  this.getInstanceXPath = function() {
    return this.instanceXpath;
  }
  
  this.getMessage = function() {
    return this.msg;
  }
  
  this.getTitle = function() {
    return this.title;
  }
};

var ERR = {
  ERRCODE : 0X01, // 경고창에 ERRCODE부분을 보여줍니다
  ERRMSG : 0X02, // 경고창에 ERRMSG부분을 보여줍니다
  ERRSRC : 0X04, // 경고창에 ERRSRC부분을 보여줍니다
  ERRALL : 0X08 // 경고창에 모든 에러를 보여줍니다
};