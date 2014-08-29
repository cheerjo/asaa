var MenuGroupMgrUI = function() {
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
voCtl = poPage.canvas.createControl("label","lblShtTitle02",1040,10,551,31);
voCtl.className = "lbl_shuttle";
voCtl.outerClassName = "lbl_shttitle_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 0;
voCtl.value = "미선택메뉴";
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("label","lblShtTitle01",490,10,501,31);
voCtl.className = "lbl_shuttle";
voCtl.outerClassName = "lbl_shttitle_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 1;
voCtl.value = "선택메뉴";
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("button","btnShtRight",999,177,32,32);
voCtl.className = "btn_shtright";
voCtl.outerClassName = "btn_sht_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 2;
voCtl.onclick = function(e) { page.onClick_btnShtRight(e); };
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("button","btnShtLeft",999,227,32,32);
voCtl.className = "btn_shtleft";
voCtl.outerClassName = "btn_sht_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 3;
voCtl.backgroundRepeat = "no-repeat";
voCtl.onclick = function(e) { page.onClick_btnShtLeft(e); };
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("label","lblShtTitle01_copy_1",28,10,423,31);
voCtl.className = "lbl_shuttle";
voCtl.outerClassName = "lbl_shttitle_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 4;
voCtl.value = "권한그룹";
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("gridex","grxLeftPrivGrp",28,42,423,429);
voCtl.tabIndex = 0;
voCtl.zIndex = 5;
voCtl.datasetId = "dstSymPrivGrpList";
voCtl.hideInitRow = true;
voCtl.cfg.editing = 1;
voCtl.cfg.sorted = false;
voCtl.cfg.sorting = false;
voCtl.cfg.idColumn = "ghcSeq";
{
var voCtl_header = voCtl.createHeader();
{
var voCtl_header_cols = voCtl_header.createCols();
var voCtl_header_cols_colsRow;
voCtl_header_cols_colsRow = voCtl_header_cols.createColsRow();
var voCtl_header_cols_colsRow_headCol;
voCtl_header_cols_colsRow_headCol = voCtl_header_cols_colsRow.createHeadColumn("ghcSeq", null, null);
voCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_header_cols_colsRow_headCol.value = "seq";
voCtl_header_cols_colsRow.addColumn(voCtl_header_cols_colsRow_headCol);
voCtl_header_cols_colsRow_headCol = voCtl_header_cols_colsRow.createHeadColumn("ghcPrivGrpNo", null, null);
voCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_header_cols_colsRow_headCol.value = "그룹번호";
voCtl_header_cols_colsRow.addColumn(voCtl_header_cols_colsRow_headCol);
voCtl_header_cols_colsRow_headCol = voCtl_header_cols_colsRow.createHeadColumn("ghcPrivGrpNm", null, null);
voCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_header_cols_colsRow_headCol.value = "그룹명";
voCtl_header_cols_colsRow.addColumn(voCtl_header_cols_colsRow_headCol);
var voCtl_header_cols_colsRow_functionCol;
voCtl_header_cols.addColsRow(voCtl_header_cols_colsRow);
voCtl_header.addCols(voCtl_header_cols, "center");
}
voCtl.addHeader(voCtl_header);
}
{
var voCtl_body = voCtl.createBody();
{
var voCtl_body_cols = voCtl_body.createCols();
var voCtl_body_cols_colsRow;
voCtl_body_cols_colsRow = voCtl_body_cols.createColsRow();
voCtl_body_cols_colsRow.height = 20;
var voCtl_body_cols_colsRow_bodyCol;
voCtl_body_cols_colsRow_bodyCol = voCtl_body_cols_colsRow.createBodyColumn("gbcSeq", "ghcSeq", "Text", null, null);
voCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_body_cols_colsRow_bodyCol.inputMode = "number";
voCtl_body_cols_colsRow_bodyCol.canEdit = 2;
voCtl_body_cols_colsRow_bodyCol.width = 69;
voCtl_body_cols_colsRow_bodyCol.textAlign = "center";
voCtl_body_cols_colsRow_bodyCol.datasetCol = "";
voCtl_body_cols_colsRow.addColumn(voCtl_body_cols_colsRow_bodyCol);
voCtl_body_cols_colsRow_bodyCol = voCtl_body_cols_colsRow.createBodyColumn("gbcPrivGrpNo", "ghcPrivGrpNo", "Text", null, null);
voCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_body_cols_colsRow_bodyCol.canEdit = 2;
voCtl_body_cols_colsRow_bodyCol.width = 145;
voCtl_body_cols_colsRow_bodyCol.datasetCol = "privGrpNo";
voCtl_body_cols_colsRow.addColumn(voCtl_body_cols_colsRow_bodyCol);
voCtl_body_cols_colsRow_bodyCol = voCtl_body_cols_colsRow.createBodyColumn("gbcPrivGrpNm", "ghcPrivGrpNm", "Text", null, null);
voCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_body_cols_colsRow_bodyCol.canEdit = 2;
voCtl_body_cols_colsRow_bodyCol.width = 206;
voCtl_body_cols_colsRow_bodyCol.datasetCol = "privGrpNm";
voCtl_body_cols_colsRow.addColumn(voCtl_body_cols_colsRow_bodyCol);
voCtl_body_cols.addColsRow(voCtl_body_cols_colsRow);
voCtl_body.addCols(voCtl_body_cols, "center");
}
voCtl.addBody(voCtl_body);
}
voCtl.onGridexAfterValueChanged = function(e) { page.onGridexAfterValueChanged_grxLeftPrivGrp(e); };
voCtl.onGridexDblClick = function(e) { page.onGridexDblClick_grxLeftPrivGrp(e); };
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("treeview","trvSelect",490,42,501,426);
voCtl.zIndex = 6;
voCtl.expandAll = true;
{
{
var voNodeSet0;
voNodeSet0 = voCtl.createTreeNodeset();
voNodeSet0.labelTagName = "menuNm";
voNodeSet0.valueTagName = "menuCd";
voNodeSet0.parentTagName = "upMenuCd";
voNodeSet0.data.setNodesetRef("responseData", "/root/resSymPrivMenuList/row");
voCtl.root.addChild(voNodeSet0);
}
}
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("treeview","trvNoSelect",1040,42,551,426);
voCtl.tabIndex = 0;
voCtl.zIndex = 7;
voCtl.expandAll = true;
voCtl.showCheckBox = false;
voCtl.selectionMode = "single";
{
{
var voNodeSet0;
voNodeSet0 = voCtl.createTreeNodeset();
voNodeSet0.labelTagName = "menuNm";
voNodeSet0.valueTagName = "menuCd";
voNodeSet0.parentTagName = "upMenuCd";
voNodeSet0.data.setNodesetRef("responseData", "/root/resSymPrivNonMenuList/row");
voCtl.root.addChild(voNodeSet0);
}
}
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("button","btn2",1530,480,61,25);
voCtl.className = "btn_cud";
voCtl.outerClassName = "btn_cud_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 8;
voCtl.value = "조회";
voCtl.onclick = function(e) { page.onClick_btn2(e); };
poPage.canvas.appendControl(voCtl);

};

};