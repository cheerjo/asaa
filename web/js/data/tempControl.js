var fnClickHandler = function(pnIdx){
	iptn_update2(pnIdx);
	eventBarUpdate2(pnIdx);
	otn_update2(pnIdx);
};

//지진안전성분석결과 목록
var sf_update2 = function() {
	var idx = 0;
	var vnLenth = list.length;
	$("#sfResultInfo").empty();
	
	for (; idx < vnLenth; idx++) {
		$("#sfResultInfo").append("<li class='graph_txt2' style='cursor:pointer'" + "onclick='fnClickHandler("+idx+");'" +">[" + list [idx].date + "] " + list [idx].content + "</li>");
	}
};

//
var eventBarUpdate2 = function(pnIdx){
	$("#bar_content01").css("width", 690);
	$("#bar_content01").css("height", 170); //205
	$("#bar_content02").css("width", 690);
	$("#bar_content02").css("height", 170);	
	barUpdate(pnIdx);
};

//점검필요시설물 목록 	
var iptn_update2 = function(pnIdx) {
	var idx = 0;
	var vnLength = list2[pnIdx].iptnInfoList.length;
	$("#chkIptn").text("시설물점검정보 - " + list2[pnIdx].iddlFctyChkCnt + "/" + list2[pnIdx].fctyTotCnt + "개소");
	
	$("#chkIptnList").empty();
	for (; idx < vnLength; idx++) {
		$("#chkIptnList").append("<li>[" + list2[pnIdx].iptnInfoList[idx].fctyKndNm + "]" + list2[pnIdx].iptnInfoList[idx].fctyNm + "</li>");
	}
};

//분석결과요약
var otn_update2 = function(pnIdx) {
	var idx = 0;
	var vnLength = list3[pnIdx].length;
	$("#otnInputList").empty();
	$("#otnInputList").append("<li>[" + list3[pnIdx][0] + "]" + "</li>");
	$("#otnInputList").append("<li>[" + list3[pnIdx][1] + "]" + "</li>");
};