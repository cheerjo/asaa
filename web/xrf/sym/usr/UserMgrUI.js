var UserMgrUI = function() {
this.rendering = function(poPage) {
var voCtl = null;
poPage.canvas.backgroundColor = null;
poPage.canvas.backgroundRepeat = null;
poPage.canvas.backgroundPosition = null;
poPage.canvas.focusBorderColor = null;
poPage.canvas.focusBorderStyle = null;
poPage.canvas.contextMenuId = null;
poPage.canvas.horizontalAlign = null;
poPage.canvas.width = 1620;
poPage.canvas.height = 735;
poPage.canvas.refresh();
voCtl = poPage.canvas.createControl("label","lblSubTitle01",10,550,1601,36);
voCtl.className = "lbl_subtitle";
voCtl.outerClassName = "lbl_subtitle_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 0;
voCtl.value = "기본정보";
voCtl.borderWidth = 0;
voCtl.textAlign = "left";
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("group","grp1",10,588,1601,113);
voCtl.tabIndex = 0;
voCtl.zIndex = 1;
voCtl.overflow = "visible";
voCtl.borderColor = "#A5BACC";
voCtl.borderWidth = 0;
voCtl.borderColor = "#A5BACC";
voCtl.borderLeftWidth = 1;
voCtl.borderRightWidth = 1;
voCtl.borderBottomWidth = 1;
{
var voCtl_InnerCtl = null;
voCtl_InnerCtl = poPage.canvas.createControl("label","lblLine1",0,0,1611,1);
voCtl_InnerCtl.outerClassName = "lbl_formvalbox_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 0;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl65",0,1,110,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 1;
voCtl_InnerCtl.value = "회원ID";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbUserId",120,5,150,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymUserVO/userId");
voCtl_InnerCtl.zIndex = 2;
voCtl_InnerCtl.readOnly = false;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl58",280,1,110,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 3;
voCtl_InnerCtl.value = "성   명";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl59",0,29,110,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 4;
voCtl_InnerCtl.value = "권한그룹";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl61",280,29,110,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 5;
voCtl_InnerCtl.value = "소속구분";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl70",580,29,100,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 6;
voCtl_InnerCtl.value = "이메일";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lblLine3",0,56,1611,1);
voCtl_InnerCtl.outerClassName = "lbl_formvalbox_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 7;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl72",0,57,110,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 8;
voCtl_InnerCtl.value = "휴대전화";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl76",580,1,100,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 9;
voCtl_InnerCtl.value = "패스워드";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl74",280,57,110,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 10;
voCtl_InnerCtl.value = "전화번호";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lblLine4",0,84,1611,1);
voCtl_InnerCtl.outerClassName = "lbl_formvalbox_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 11;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl78",0,85,110,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 12;
voCtl_InnerCtl.value = "사용목적";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("combo","cbbOrgYn",1050,33,171,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymUserVO/orgYn");
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.visible = false;
voCtl_InnerCtl.zIndex = 13;
voCtl_InnerCtl.readOnly = true;
voCtl_InnerCtl.btnWidth = 20;
voCtl_InnerCtl.expandImage = "url('/img/btn/combo_dropdown_expand.png')";
voCtl_InnerCtl.collapseImage = "url('/img/btn/combo_dropdown_collapse.png')";
voCtl_InnerCtl.listarea.className = "cbb_srch_list";
voCtl_InnerCtl.listarea.focusBackgroundColor = "#E5E5E5";
var vcItem = voCtl_InnerCtl.addItemFront("연구소", "G");
vcItem.selected = true;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbUserNm",400,5,171,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymUserVO/userNm");
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 14;
voCtl_InnerCtl.readOnly = false;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("editmask","edmMblNo",120,61,150,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymUserVO/mblNo");
voCtl_InnerCtl.zIndex = 15;
voCtl_InnerCtl.calendarImageUrl = "";
voCtl_InnerCtl.calendarEnable = false;
voCtl_InnerCtl.formatType = "string";
voCtl_InnerCtl.regMask = null;
voCtl_InnerCtl.regFormat = null;
voCtl_InnerCtl.textAlign = "center";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("editmask","edmTelNo",400,61,171,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymUserVO/telNo");
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 16;
voCtl_InnerCtl.calendarImageUrl = "";
voCtl_InnerCtl.calendarEnable = false;
voCtl_InnerCtl.formatType = "string";
voCtl_InnerCtl.regMask = null;
voCtl_InnerCtl.regFormat = null;
voCtl_InnerCtl.textAlign = "center";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbUseObjt",120,89,1471,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymUserVO/useObjt");
voCtl_InnerCtl.zIndex = 17;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("secret","scbUsrPwd",690,5,141,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymUserVO/usrPswd");
voCtl_InnerCtl.zIndex = 18;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbUsrEmail",690,33,311,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymUserVO/usrEmail");
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 19;
voCtl_InnerCtl.readOnly = false;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("combo","cbbPrivGrpNo",120,33,150,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymUserVO/privGrpNo");
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 20;
voCtl_InnerCtl.readOnly = true;
voCtl_InnerCtl.btnWidth = 20;
voCtl_InnerCtl.expandImage = "url('/img/btn/combo_dropdown_expand.png')";
voCtl_InnerCtl.collapseImage = "url('/img/btn/combo_dropdown_collapse.png')";
voCtl_InnerCtl.listarea.className = "cbb_srch_list";
voCtl_InnerCtl.listarea.focusBackgroundColor = "#E5E5E5";
voCtl_InnerCtl.data.setNodesetRef("responseData", "/root/privGrpList/row");
voCtl_InnerCtl.labelTagName = "privGrpNm";
voCtl_InnerCtl.valueTagName = "privGrpNo";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lblLine2",0,28,1611,1);
voCtl_InnerCtl.outerClassName = "lbl_formvalbox_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 21;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbOrgNm",400,33,171,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymUserVO/orgNm");
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 22;
voCtl_InnerCtl.readOnly = false;
voCtl.addChild(voCtl_InnerCtl);
}
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("group","grp3",10,10,1601,531);
voCtl.tabIndex = 0;
voCtl.zIndex = 2;
{
var voCtl_InnerCtl = null;
voCtl_InnerCtl = poPage.canvas.createControl("label","lblSerchArea1",10,10,1581,35);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 0;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lblOrgnClsfCd",20,17,70,20);
voCtl_InnerCtl.className = "lbl_srch";
voCtl_InnerCtl.outerClassName = "lbl_srch_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 1;
voCtl_InnerCtl.value = "구   분";
voCtl_InnerCtl.borderWidth = 0;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("combo","cbbSearchGubun",100,17,121,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/searchVO/searchCondition");
voCtl_InnerCtl.className = "cbb_srch";
voCtl_InnerCtl.outerClassName = "cbb_srch_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 2;
voCtl_InnerCtl.readOnly = true;
voCtl_InnerCtl.btnWidth = 20;
voCtl_InnerCtl.expandImage = "url('/img/btn/combo_dropdown_expand.png')";
voCtl_InnerCtl.collapseImage = "url('/img/btn/combo_dropdown_collapse.png')";
voCtl_InnerCtl.listarea.className = "cbb_srch_list";
voCtl_InnerCtl.listarea.focusBackgroundColor = "#E5E5E5";
var vcItem = voCtl_InnerCtl.addItemFront("성 명", "USERNM");
vcItem.selected = true;
var vcItem = voCtl_InnerCtl.addItemFront("이메일", "USREMAIL");
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbSchWord",224,17,237,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/searchVO/searchKeyword");
voCtl_InnerCtl.className = "ipt_srch";
voCtl_InnerCtl.zIndex = 3;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("button","btnSrch",474,15,77,24);
voCtl_InnerCtl.className = "btn_srch";
voCtl_InnerCtl.outerClassName = "btn_srch_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 4;
voCtl_InnerCtl.value = "조회";
voCtl_InnerCtl.onclick = function(e) { page.onClick_btnSrch(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("gridex","grxSymUser",10,54,1581,436);
voCtl_InnerCtl.zIndex = 5;
voCtl_InnerCtl.datasetId = "dstResSymUserList";
voCtl_InnerCtl.defaultFileName = "/eXria/lib/gridex/Defaults.xml";
voCtl_InnerCtl.cfg.editing = 2;
voCtl_InnerCtl.cfg.sorted = false;
voCtl_InnerCtl.cfg.sorting = false;
voCtl_InnerCtl.cfg.idColumn = "ghc1";
{
var voCtl_InnerCtl_header = voCtl_InnerCtl.createHeader();
{
var voCtl_InnerCtl_header_cols = voCtl_InnerCtl_header.createCols();
var voCtl_InnerCtl_header_cols_colsRow;
voCtl_InnerCtl_header_cols_colsRow = voCtl_InnerCtl_header_cols.createColsRow();
var voCtl_InnerCtl_header_cols_colsRow_headCol;
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghc1", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "No";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghcUserId", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "회원ID";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghc3", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "권한그룹";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghc4", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "소속";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghc5", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "성명";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghc6", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "이메일";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghc7", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "휴대전화";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghc8", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "전화번호";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghc10", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "등록일자";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
var voCtl_InnerCtl_header_cols_colsRow_functionCol;
voCtl_InnerCtl_header_cols.addColsRow(voCtl_InnerCtl_header_cols_colsRow);
voCtl_InnerCtl_header.addCols(voCtl_InnerCtl_header_cols, "center");
}
voCtl_InnerCtl.addHeader(voCtl_InnerCtl_header);
}
{
var voCtl_InnerCtl_body = voCtl_InnerCtl.createBody();
{
var voCtl_InnerCtl_body_cols = voCtl_InnerCtl_body.createCols();
var voCtl_InnerCtl_body_cols_colsRow;
voCtl_InnerCtl_body_cols_colsRow = voCtl_InnerCtl_body_cols.createColsRow();
voCtl_InnerCtl_body_cols_colsRow.height = 20;
var voCtl_InnerCtl_body_cols_colsRow_bodyCol;
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcNo", "ghc1", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 50;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.textAlign = "center";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcUserId", "ghcUserId", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 151;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "userId";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcPrivGrpNo", "ghc3", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 122;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "privGrpNo";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcOrgYn", "ghc4", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 177;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "orgNm";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcUserNm", "ghc5", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 178;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "userNm";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcUsrEmail", "ghc6", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 483;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "usrEmail";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcMblNO", "ghc7", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 153;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "mblNo";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcTelNo", "ghc8", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 149;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "telNo";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcInptDt", "ghc10", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 117;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "inptDt";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols.addColsRow(voCtl_InnerCtl_body_cols_colsRow);
voCtl_InnerCtl_body.addCols(voCtl_InnerCtl_body_cols, "center");
}
voCtl_InnerCtl.addBody(voCtl_InnerCtl_body);
}
voCtl_InnerCtl.onGridexDblClick = function(e) { page.onGridexDblClick_grxSymUser(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = new eXria.form.Import("impPaging", 10,490,1581,31,poPage.canvas);
voCtl_InnerCtl.ctrl.outerClassName = "imp_pgnavi_outer";
voCtl_InnerCtl.ctrl.tabIndex = 0;
voCtl_InnerCtl.ctrl.visible = false;
voCtl_InnerCtl.ctrl.zIndex = 6;
voCtl_InnerCtl.setImport(voCtl);

// begin import file's contents...
poPage.model.loadURL("/common/pageNavigation/pageNavigation.xml", true);
{
var beforeOnload_impPaging = poPage.onLoad; poPage.onLoad = null;

  // import file's JS contents
   //$NON-NLS-1$

  poPage.mnOriGrpNumbresWidth;
  poPage.mnOriGrpNumbresLeft;

  poPage.onLoad = function() {
    var vcGrpNumbres = page.getControl("grpNumbres");
	
    page.mnOriGrpNumbresWidth = vcGrpNumbres.width;
    page.mnOriGrpNumbresLeft = vcGrpNumbres.left;
			
  };
  
  //******************************************************************************************
  //사용자 정의 함수 영역 start
  //******************************************************************************************    
  poPage.doPageNumValueChange = function(pnStartNum, pnEndNum){
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
  
  poPage.doPageNumReSize = function(psPageNum){
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
  
  poPage.doPageNumRepaint = function(){
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
  
  poPage.doPageNumVisible = function(pnTotalItems){
    var vcOpt = page.getControl("optPageTCNoSearch");
    
    if(0 == pnTotalItems)
      vcOpt.visible = true;
    else
      vcOpt.visible = false;
      
    vcOpt.refresh();
  };
  
  poPage.doFacadePageNum = function(psPageNum){
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
  poPage.onClick_lblPageNum1 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  poPage.onClick_lblPageNum2 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  poPage.onClick_lblPageNum3 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  poPage.onClick_lblPageNum4 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  poPage.onClick_lblPageNum5 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  poPage.onClick_lblPageNum6 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  poPage.onClick_lblPageNum7 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  poPage.onClick_lblPageNum8 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  poPage.onClick_lblPageNum9 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };
  
  poPage.onClick_lblPageNum10 = function(e /*:eXria.event.Event*/) {
    page.doGoPage(e.object.getValue()); 
  };  
  //페이지Num 선택 End
  
  poPage.onClick_imgBtnPrevEnd = function(e /*:eXria.event.Event*/) {
    page.doGoPage(1); 
  };
  
  poPage.onClick_imgBtnPrev = function(e /*:eXria.event.Event*/) {
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
  
  poPage.onClick_imgBtnNextEnd = function(e /*:eXria.event.Event*/) {
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
  
  poPage.onClick_imgBtnNext = function(e /*:eXria.event.Event*/) {
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

if(poPage.onLoad != null && poPage.onLoad != undefined) {
poPage.onLoad_impPaging = poPage.onLoad;
poPage.onLoad = function() {
poPage.onLoad_impPaging();
beforeOnload_impPaging();
};
} else {
poPage.onLoad = beforeOnload_impPaging;
}
}

// import file's ui contents
this.rendering_impPaging = function(poPage_impPaging){
var voCtl = null;
poPage_impPaging.canvas.backgroundColor = null;
poPage_impPaging.canvas.backgroundRepeat = null;
poPage_impPaging.canvas.backgroundPosition = null;
poPage_impPaging.canvas.focusBorderColor = null;
poPage_impPaging.canvas.focusBorderStyle = null;
poPage_impPaging.canvas.contextMenuId = null;
poPage_impPaging.canvas.horizontalAlign = null;
poPage_impPaging.canvas.width = 346;
poPage_impPaging.canvas.height = 31;
poPage_impPaging.canvas.refresh();
voCtl = poPage_impPaging.canvas.createControl("group","grpPrevs",8,4,34,26);
voCtl.tabIndex = 0;
voCtl.zIndex = 0;
voCtl.borderWidth = 0;
{
var voCtl_InnerCtl = null;
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("image","imgBtnPrev",19,5,15,15);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 0;
voCtl_InnerCtl.src = "/style/image/icon_prev.gif";
voCtl_InnerCtl.borderWidth = 0;
voCtl_InnerCtl.borderStyle = "none";
voCtl_InnerCtl.borderStyle = "none";
voCtl_InnerCtl.onclick = function(e) { page.onClick_imgBtnPrev(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("image","imgBtnPrevEnd",0,5,15,15);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 1;
voCtl_InnerCtl.src = "/style/image/icon_prev10.gif";
voCtl_InnerCtl.borderWidth = 0;
voCtl_InnerCtl.borderStyle = "none";
voCtl_InnerCtl.borderStyle = "none";
voCtl_InnerCtl.onclick = function(e) { page.onClick_imgBtnPrevEnd(e); };
voCtl.addChild(voCtl_InnerCtl);
}
poPage_impPaging.canvas.appendControl(voCtl);
voCtl = poPage_impPaging.canvas.createControl("group","grpNexts",301,3,34,26);
voCtl.tabIndex = 0;
voCtl.zIndex = 1;
voCtl.borderWidth = 0;
voCtl.borderStyle = "none";
{
var voCtl_InnerCtl = null;
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("image","imgBtnNext",0,5,15,15);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 0;
voCtl_InnerCtl.src = "/style/image/icon_next.gif";
voCtl_InnerCtl.borderWidth = 0;
voCtl_InnerCtl.borderStyle = "none";
voCtl_InnerCtl.borderStyle = "none";
voCtl_InnerCtl.onclick = function(e) { page.onClick_imgBtnNext(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("image","imgBtnNextEnd",18,5,15,15);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 1;
voCtl_InnerCtl.src = "/style/image/icon_next10.gif";
voCtl_InnerCtl.borderWidth = 0;
voCtl_InnerCtl.borderStyle = "none";
voCtl_InnerCtl.borderStyle = "none";
voCtl_InnerCtl.onclick = function(e) { page.onClick_imgBtnNextEnd(e); };
voCtl.addChild(voCtl_InnerCtl);
}
poPage_impPaging.canvas.appendControl(voCtl);
voCtl = poPage_impPaging.canvas.createControl("group","grpNumbres",50,3,243,26);
voCtl.tabIndex = 0;
voCtl.zIndex = 2;
voCtl.borderWidth = 0;
voCtl.borderStyle = "none";
{
var voCtl_InnerCtl = null;
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("label","lblPageNum1",0,5,18,18);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 0;
voCtl_InnerCtl.value = "1";
voCtl_InnerCtl.onclick = function(e) { page.onClick_lblPageNum1(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("label","lblPageNum2",25,5,18,18);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 1;
voCtl_InnerCtl.value = "2";
voCtl_InnerCtl.onclick = function(e) { page.onClick_lblPageNum2(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("label","lblPageNum3",50,5,18,18);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 2;
voCtl_InnerCtl.value = "3";
voCtl_InnerCtl.onclick = function(e) { page.onClick_lblPageNum3(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("label","lblPageNum4",75,5,18,18);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.visible = true;
voCtl_InnerCtl.zIndex = 3;
voCtl_InnerCtl.value = "4";
voCtl_InnerCtl.onclick = function(e) { page.onClick_lblPageNum4(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("label","lblPageNum5",100,5,18,18);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.visible = true;
voCtl_InnerCtl.zIndex = 4;
voCtl_InnerCtl.value = "5";
voCtl_InnerCtl.onclick = function(e) { page.onClick_lblPageNum5(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("label","lblPageNum6",125,5,18,18);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.visible = true;
voCtl_InnerCtl.zIndex = 5;
voCtl_InnerCtl.value = "6";
voCtl_InnerCtl.onclick = function(e) { page.onClick_lblPageNum6(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("label","lblPageNum7",150,5,18,18);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.visible = true;
voCtl_InnerCtl.zIndex = 6;
voCtl_InnerCtl.value = "7";
voCtl_InnerCtl.onclick = function(e) { page.onClick_lblPageNum7(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("label","lblPageNum8",175,5,18,18);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.visible = true;
voCtl_InnerCtl.zIndex = 7;
voCtl_InnerCtl.value = "8";
voCtl_InnerCtl.onclick = function(e) { page.onClick_lblPageNum8(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("label","lblPageNum9",200,5,18,18);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.visible = true;
voCtl_InnerCtl.zIndex = 8;
voCtl_InnerCtl.value = "9";
voCtl_InnerCtl.onclick = function(e) { page.onClick_lblPageNum9(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage_impPaging.canvas.createControl("label","lblPageNum10",225,5,18,18);
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.visible = true;
voCtl_InnerCtl.zIndex = 9;
voCtl_InnerCtl.value = "10";
voCtl_InnerCtl.onclick = function(e) { page.onClick_lblPageNum10(e); };
voCtl.addChild(voCtl_InnerCtl);
}
poPage_impPaging.canvas.appendControl(voCtl);
voCtl = poPage_impPaging.canvas.createControl("output","optPageTCNoSearch",1,3,341,27);
voCtl.tabIndex = 0;
voCtl.zIndex = 3;
voCtl.value = "검색결과가 없습니다. 재조회 하시기 바랍니다.";
voCtl.formatType = "string";
voCtl.regFormat = null;
voCtl.textAlign = "center";
poPage_impPaging.canvas.appendControl(voCtl);

};


// end import file's contents...

this.rendering_impPaging(voCtl_InnerCtl);
if(voCtl.impList != undefined)voCtl.impList.add("impPaging");
}
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("button","btnInit",1410,558,54,20);
voCtl.className = "btn_inn02s";
voCtl.outerClassName = "btn_inn_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 3;
voCtl.value = "초기화";
voCtl.onclick = function(e) { page.onClick_btnInit(e); };
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("button","btnSave",1477,558,54,20);
voCtl.className = "btn_inn02s";
voCtl.outerClassName = "btn_inn_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 4;
voCtl.value = "저장";
voCtl.onclick = function(e) { page.onClick_btnSave(e); };
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("button","btnDelete",1546,558,54,20);
voCtl.className = "btn_inn02s";
voCtl.outerClassName = "btn_inn_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 5;
voCtl.value = "삭제";
voCtl.onclick = function(e) { page.onClick_btnDelete(e); };
poPage.canvas.appendControl(voCtl);

};

};