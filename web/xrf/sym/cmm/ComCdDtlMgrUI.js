var ComCdDtlMgrUI = function() {
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
voCtl = poPage.canvas.createControl("group","grp1",10,586,1601,113);
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
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbCommDtlCd",690,5,150,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymCommCdDtlVO/commDtlCd");
voCtl_InnerCtl.className = "ipt_form";
voCtl_InnerCtl.outerClassName = "ipt_form_outer";
voCtl_InnerCtl.zIndex = 2;
voCtl_InnerCtl.readOnly = true;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl58",580,1,100,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 3;
voCtl_InnerCtl.value = "상세코드";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lblLine2",0,28,1611,1);
voCtl_InnerCtl.outerClassName = "lbl_formvalbox_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 4;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl59",0,29,110,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 5;
voCtl_InnerCtl.value = "상세코드명";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl70",580,29,100,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 6;
voCtl_InnerCtl.value = "표시순서";
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
voCtl_InnerCtl.value = "부가정보";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lblLine4",0,84,1611,1);
voCtl_InnerCtl.outerClassName = "lbl_formvalbox_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 9;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lbl78",0,85,110,28);
voCtl_InnerCtl.className = "lbl_formattr";
voCtl_InnerCtl.outerClassName = "lbl_formattr_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 10;
voCtl_InnerCtl.value = "사용여부";
voCtl_InnerCtl.borderStyle = "solid";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("radio","rdbUseYn",120,89,150,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymCommCdDtlVO/useYn");
voCtl_InnerCtl.className = "rdb_form";
voCtl_InnerCtl.outerClassName = "rdb_form_outer";
voCtl_InnerCtl.zIndex = 11;
voCtl_InnerCtl.displayMode = "horizontal";
voCtl_InnerCtl.fontSize = 9;
voCtl_InnerCtl.itemgroup.width = 75;
var vcItem = voCtl_InnerCtl.addItemFront("사용", "Y");
var vcItem = voCtl_InnerCtl.addItemFront("미사용", "N");
vcItem.selected = true;
voCtl_InnerCtl.borderWidth = 0;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbCommCd",120,5,100,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymCommCdDtlVO/commCd");
voCtl_InnerCtl.className = "ipt_form";
voCtl_InnerCtl.outerClassName = "ipt_form_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 12;
voCtl_InnerCtl.readOnly = false;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("button","btnSchCode",226,5,54,20);
voCtl_InnerCtl.className = "btn_inn02s";
voCtl_InnerCtl.outerClassName = "btn_inn_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.visible = true;
voCtl_InnerCtl.zIndex = 13;
voCtl_InnerCtl.value = "검색";
voCtl_InnerCtl.onclick = function(e) { page.onClick_btnSchCode(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lblCommNm",290,1,280,28);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymCommCdDtlVO/commNm");
voCtl_InnerCtl.className = "lbl_formval";
voCtl_InnerCtl.outerClassName = "lbl_formval_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 14;
voCtl_InnerCtl.color = "gray";
voCtl_InnerCtl.borderStyle = "solid";
voCtl_InnerCtl.borderLeftWidth = 0;
voCtl_InnerCtl.borderTopWidth = 0;
voCtl_InnerCtl.borderRightWidth = 0;
voCtl_InnerCtl.borderBottomWidth = 0;
voCtl_InnerCtl.textAlign = "center";
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbCommDtlNm",120,33,450,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymCommCdDtlVO/commDtlNm");
voCtl_InnerCtl.className = "ipt_form";
voCtl_InnerCtl.outerClassName = "ipt_form_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 15;
voCtl_InnerCtl.readOnly = false;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbCommDtlInfo",120,61,1471,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymCommCdDtlVO/commDtlInfo");
voCtl_InnerCtl.className = "ipt_form";
voCtl_InnerCtl.outerClassName = "ipt_form_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 16;
voCtl_InnerCtl.readOnly = false;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbCommDtlOrd",690,33,150,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/reqSymCommCdDtlVO/commDtlOrd");
voCtl_InnerCtl.className = "ipt_form";
voCtl_InnerCtl.outerClassName = "ipt_form_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 17;
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
voCtl_InnerCtl.outerClassName = "lbl_srcharea_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 0;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lblOrgnClsfCd",10,17,60,20);
voCtl_InnerCtl.className = "lbl_srch";
voCtl_InnerCtl.outerClassName = "lbl_srch_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 1;
voCtl_InnerCtl.value = "코드";
voCtl_InnerCtl.borderWidth = 0;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("combo","cbbOrgnClsfCd",80,17,180,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/searchVO/searchCondition");
voCtl_InnerCtl.className = "cbb_srch";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 2;
voCtl_InnerCtl.readOnly = true;
voCtl_InnerCtl.btnWidth = 20;
voCtl_InnerCtl.expandImage = "url('../../../img/btn/combo_dropdown_expand.png')";
voCtl_InnerCtl.collapseImage = "url('../../../img/btn/combo_dropdown_collapse.png')";
voCtl_InnerCtl.listarea.className = "cbb_srch_list";
voCtl_InnerCtl.listarea.focusBackgroundColor = "#E5E5E5";
var vcItem = voCtl_InnerCtl.addItemFront("코드명", "1");
vcItem.selected = true;
var vcItem = voCtl_InnerCtl.addItemFront("상세코드명", "2");
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("label","lblOrgnClsfCd_copy_1",260,17,81,20);
voCtl_InnerCtl.className = "lbl_srch";
voCtl_InnerCtl.outerClassName = "lbl_srch_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 3;
voCtl_InnerCtl.value = "코드명";
voCtl_InnerCtl.borderWidth = 0;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("input","ipbComName",350,17,241,20);
voCtl_InnerCtl.data.setRef("requestData", "/root/searchVO/searchKeyword");
voCtl_InnerCtl.className = "ipt_srch";
voCtl_InnerCtl.zIndex = 4;
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("button","btnSrch",600,15,77,24);
voCtl_InnerCtl.className = "btn_srch";
voCtl_InnerCtl.outerClassName = "btn_srch_outer";
voCtl_InnerCtl.tabIndex = 0;
voCtl_InnerCtl.zIndex = 5;
voCtl_InnerCtl.value = "조회";
voCtl_InnerCtl.onclick = function(e) { page.onClick_btnSrch(e); };
voCtl.addChild(voCtl_InnerCtl);
voCtl_InnerCtl = poPage.canvas.createControl("gridex","grxComCdDtl",10,45,1581,476);
voCtl_InnerCtl.zIndex = 6;
voCtl_InnerCtl.datasetId = "dstResSymCommCdDtlList";
voCtl_InnerCtl.hideInitRow = true;
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
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghcCommNm", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "코드명";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghcCommDtlCd", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "상세코드";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghcCommDtlNm", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "상세코드명";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghcCommDtlInfo", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "부가정보";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghcCommDtlOrd", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "표시순서";
voCtl_InnerCtl_header_cols_colsRow.addColumn(voCtl_InnerCtl_header_cols_colsRow_headCol);
voCtl_InnerCtl_header_cols_colsRow_headCol = voCtl_InnerCtl_header_cols_colsRow.createHeadColumn("ghcUseYn", null, null);
voCtl_InnerCtl_header_cols_colsRow_headCol.colspan = 1;
voCtl_InnerCtl_header_cols_colsRow_headCol.textAlign = "center";
voCtl_InnerCtl_header_cols_colsRow_headCol.className = "ghc";
voCtl_InnerCtl_header_cols_colsRow_headCol.value = "사용여부";
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
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcCommNm", "ghcCommNm", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 154;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "commCd";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcCommDtlCd", "ghcCommDtlCd", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 214;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "commDtlCd";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcCommDtlNm", "ghcCommDtlNm", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 372;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "commDtlNm";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcCommDtlInfo", "ghcCommDtlInfo", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 541;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "commDtlInfo";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcCommDtlOrd", "ghcCommDtlOrd", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 129;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "commDtlOrd";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols_colsRow_bodyCol = voCtl_InnerCtl_body_cols_colsRow.createBodyColumn("gbcUseYn", "ghcUseYn", "Text", null, null);
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regMask = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.regFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.groupFormat = null;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.width = 100;
voCtl_InnerCtl_body_cols_colsRow_bodyCol.datasetCol = "useYn";
voCtl_InnerCtl_body_cols_colsRow.addColumn(voCtl_InnerCtl_body_cols_colsRow_bodyCol);
voCtl_InnerCtl_body_cols.addColsRow(voCtl_InnerCtl_body_cols_colsRow);
voCtl_InnerCtl_body.addCols(voCtl_InnerCtl_body_cols, "center");
}
voCtl_InnerCtl.addBody(voCtl_InnerCtl_body);
}
voCtl_InnerCtl.onGridexDblClick = function(e) { page.onGridexDblClick_grxComCdDtl(e); };
voCtl.addChild(voCtl_InnerCtl);
}
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("button","btnInit",1404,558,54,20);
voCtl.className = "btn_inn02s";
voCtl.outerClassName = "btn_inn_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 3;
voCtl.value = "초기화";
voCtl.onclick = function(e) { page.onClick_btnInit(e); };
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("button","btnSave",1471,558,54,20);
voCtl.className = "btn_inn02s";
voCtl.outerClassName = "btn_inn_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 4;
voCtl.value = "저장";
voCtl.onclick = function(e) { page.onClick_btnSave(e); };
poPage.canvas.appendControl(voCtl);
voCtl = poPage.canvas.createControl("button","btnDelete",1540,558,54,20);
voCtl.className = "btn_inn02s";
voCtl.outerClassName = "btn_inn_outer";
voCtl.tabIndex = 0;
voCtl.zIndex = 5;
voCtl.value = "삭제";
voCtl.onclick = function(e) { page.onClick_btnDelete(e); };
poPage.canvas.appendControl(voCtl);
voCtl = new eXria.form.Import("impCommModule", 18,776,33,24,poPage.canvas);
voCtl.ctrl.zIndex = 6;
voCtl.setImport();

// begin import file's contents...
poPage.model.loadURL("/common/xrf/CmmnInc.xml", true);
{
var beforeOnload_impCommModule = poPage.onLoad; poPage.onLoad = null;

     //$NON-NLS-1$
    
    /**
     * onLoad 함수.
     */ 
    poPage.onLoad = function() {
        setCurPgmInfo();
    };
    
    /**
     * 현재 프로그램정보를 설정한다.
     */ 
    function setCurPgmInfo() {
        try {
            C_sCurPgmId = page.parent.getSelPgmId();
            C_sCurPgmNm = page.parent.getSelPgmNm();
        }
        catch(exception) {
        } 
    }
if(poPage.onLoad != null && poPage.onLoad != undefined) {
poPage.onLoad_impCommModule = poPage.onLoad;
poPage.onLoad = function() {
poPage.onLoad_impCommModule();
beforeOnload_impCommModule();
};
} else {
poPage.onLoad = beforeOnload_impCommModule;
}
}

// import file's ui contents
this.rendering_impCommModule = function(poPage_impCommModule){
var voCtl = null;
poPage_impCommModule.canvas.backgroundColor = null;
poPage_impCommModule.canvas.backgroundRepeat = null;
poPage_impCommModule.canvas.backgroundPosition = null;
poPage_impCommModule.canvas.focusBorderColor = null;
poPage_impCommModule.canvas.focusBorderStyle = null;
poPage_impCommModule.canvas.contextMenuId = null;
poPage_impCommModule.canvas.horizontalAlign = null;
poPage_impCommModule.canvas.width = 1;
poPage_impCommModule.canvas.height = 1;
poPage_impCommModule.canvas.refresh();

};


// end import file's contents...

this.rendering_impCommModule(voCtl);

};

};