var ComCdMgrUI = function() {
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
voCtl = poPage.canvas.createControl("label","lblSubTitle01",10,584,1601,36);
voCtl.className = "lbl_subtitle";
voCtl.outerClassName = "lbl_subtitle_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 0;
voCtl.value = "기본정보";
voCtl.borderWidth = 0;
voCtl.textAlign = "left";
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("group","grp1",10,620,1601,57);
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
voCtl_InnerCtl.value = "코드";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl58",280,1,110,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 2;
voCtl_InnerCtl.value = "코드명";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lblLine2",0,28,1611,1);
voCtl_InnerCtl.outerClassName = "lbl_formvalbox_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 3;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl59",0,29,110,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 4;
voCtl_InnerCtl.value = "부가정보";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl60",120,29,150,28);
voCtl_InnerCtl.className = "lbl_formval";
voCtl_InnerCtl.outerClassName = "lbl_formval_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 5;
voCtl_InnerCtl.color = "gray";
voCtl_InnerCtl.borderStyle = "solid";
voCtl_InnerCtl.borderLeftWidth = 0;
voCtl_InnerCtl.borderTopWidth = 0;
voCtl_InnerCtl.borderRightWidth = 0;
voCtl_InnerCtl.borderBottomWidth = 0;
voCtl_InnerCtl.textAlign = "center";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lblLine3",0,56,1611,1);
voCtl_InnerCtl.outerClassName = "lbl_formvalbox_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 6;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lblLine7",0,168,1611,1);
voCtl_InnerCtl.outerClassName = "lbl_formvalbox_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 7;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbCommNm",400,5,341,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymCommCdVO/commNm");
voCtl_InnerCtl.className = "ipt_form";
voCtl_InnerCtl.outerClassName = "ipt_form_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 8;
voCtl_InnerCtl.readOnly = false;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbCommInfo",120,33,1471,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymCommCdVO/commInfo");
voCtl_InnerCtl.className = "ipt_form";
voCtl_InnerCtl.outerClassName = "ipt_form_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 9;
voCtl_InnerCtl.readOnly = false;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbCommCd",120,5,150,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymCommCdVO/commCd");
voCtl_InnerCtl.className = "ipt_form";
voCtl_InnerCtl.outerClassName = "ipt_form_outer";
voCtl_InnerCtl.zIndex = 10;
voCtl_InnerCtl.readOnly = false;
voCtl.addChild(voCtl_InnerCtl);
}
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("group","grp3",10,10,1601,571);
voCtl.tabIndex = 0;
voCtl.zIndex = 2;
{
var voCtl_InnerCtl = null;
voCtl_InnerCtl = poPage.canvas.createControl("label","lblSerchArea1",10,10,1581,35);
voCtl_InnerCtl.outerClassName = "lbl_srcharea_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 0;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lblOrgnClsfCd_copy_1",20,17,60,20);
voCtl_InnerCtl.className = "lbl_srch";
voCtl_InnerCtl.outerClassName = "lbl_srch_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 1;
voCtl_InnerCtl.value = "코드명";
voCtl_InnerCtl.borderWidth = 0;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbSearchCdNm",90,17,261,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/searchVO/searchKeyword");
voCtl_InnerCtl.className = "ipt_srch";
voCtl_InnerCtl.zIndex = 2;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("button","btnSrch",360,15,77,24);
voCtl_InnerCtl.className = "btn_srch";
voCtl_InnerCtl.outerClassName = "btn_srch_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 3;
voCtl_InnerCtl.value = "조회";
voCtl_InnerCtl.onclick = function(e) { page.onClick_btnSrch(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("gridex","grxSymCommCd",10,45,1581,516);
voCtl_InnerCtl.zIndex = 4;
voCtl_InnerCtl.datasetId = "dstSymCommCdList";
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
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghcCommCd", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "코드";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghcCommNm", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "코드명";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghcCommInfo", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "부가정보";
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
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbc1", "ghc1", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 50;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.textAlign = "center";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcCommCd", "ghcCommCd", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 168;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.textAlign = "center";
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "commCd";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbc4", "ghcCommNm", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 340;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "commNm";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbc5", "ghcCommInfo", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 1023;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "commInfo";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols.addColsRow(voCtl_InnerCtl_body_cols_colsRow);
voCtl_InnerCtl_body.addCols(voCtl_InnerCtl_body_cols, "center");
}
voCtl_InnerCtl.addBody(voCtl_InnerCtl_body);
}
voCtl_InnerCtl.onGridexDblClick = function(e) { page.onGridexDblClick_grxSymCommCd(e); };
voCtl.addChild(voCtl_InnerCtl);
}
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("button","btnInit",1413,592,54,20);
voCtl.className = "btn_inn02s";
voCtl.outerClassName = "btn_inn_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 3;
voCtl.value = "초기화";
voCtl.onclick = function(e) { page.onClick_btnInit(e); };
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("button","btnSave",1480,592,54,20);
voCtl.className = "btn_inn02s";
voCtl.outerClassName = "btn_inn_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 4;
voCtl.value = "저장";
voCtl.onclick = function(e) { page.onClick_btnSave(e); };
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("button","btnDelete",1549,592,54,20);
voCtl.className = "btn_inn02s";
voCtl.outerClassName = "btn_inn_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 5;
voCtl.value = "삭제";
voCtl.onclick = function(e) { page.onClick_btnDelete(e); };
poPage.canvas.appendControl(voCtl);

};

};