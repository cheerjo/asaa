<%@page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>

<%
	/**
	 * @Class Name : FctyMgrList.jsp
	 * @Description : FctyMgr List 화면
	 * @Modification Information
	 * 
	 * @author atres
	 * @since 2013.10.01
	 * @version 1.0
	 * @see
	 *  
	 * Copyright (C) All right reserved. 
	 */
%>

<link rel="stylesheet" href="${ctx}/css/style.css">

<script type="text/javascript" src="${ctx}/js/chart/real/excanvas.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.stack.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.axislabels.js"></script>

<script>
	$(document).ready(function() {
		//$("#load").hide();
		
		$("#bar_contentZ1").css("width", 690);
		$("#bar_contentZ1").css("height", 170); //205
	
		$("#bar_contentZ2").css("width", 690);
		$("#bar_contentZ2").css("height", 170);
	
		//eventBarExec();
	});

	var barDataZ1 = [ [ 0, 0 ], [ 1, 0 ], [ 2, 0 ], [ 3, 0 ], [ 4, 0 ],[ 5, 0 ], [ 6, 0 ], [ 7, 0 ], [ 8, 0 ] ];
	var barDataZ2 = [ [ 0, 0 ], [ 1, 0 ], [ 2, 0 ], [ 3, 0 ], [ 4, 0 ],[ 5, 0 ], [ 6, 0 ], [ 7, 0 ], [ 8, 0 ] ];
	var barDataZ3 = [ [ 0, 0 ], [ 1, 0 ], [ 2, 0 ], [ 3, 0 ], [ 4, 0 ],[ 5, 0 ], [ 6, 0 ], [ 7, 0 ], [ 8, 0 ] ];
	var barDataZ4 = [ [ 0, 0 ], [ 1, 0 ], [ 2, 0 ], [ 3, 0 ], [ 4, 0 ],[ 5, 0 ], [ 6, 0 ], [ 7, 0 ], [ 8, 0 ] ];
	
	var datasetZ1 = [];
	var datasetZ2 = [];
	
	var barTicks01 = [ [ 0, "전국" ], [ 1, "서울특별시" ], [ 2, "인천광역시" ],
			[ 3, "대구광역시" ], [ 4, "대전광역시" ], [ 5, "부산광역시" ], [ 6, "울산광역시" ],
			[ 7, "광주광광역시" ], [ 8, "세종시" ] ];
	
	var barTicks02 = [ [ 0, "경기도" ], [ 1, "강원도" ], [ 2, "경상남도" ],
			[ 3, "경상북도" ], [ 4, "전라남도" ], [ 5, "전라남도" ], [ 6, "충청남도" ],
			[ 7, "충청북도" ], [ 8, "제주특별자치도" ] ];
	
	var optionsZ1 = {
		series : {
			stack : true,
			bars : {
				show : true
			}
		},
		bars : {
			align : "center",
			barWidth : 0.2, //24 * 60 * 60 * 600,
			lineWidth : 1
	
		},
		xaxis : {
			//  mode: "time",
			//  tickSize: [2, "day"],
			//  tickLength: 10,
			color : "black",
			//  axisLabel: "Date",
			axisLabelUseCanvas : true,
			axisLabelFontSizePixels : 12,
			axisLabelFontFamily : 'Verdana, Arial',
			axisLabelPadding : 10,
			ticks : barTicks01
		},
		yaxis : {
			min : 0,
			max : 100,
			color : "black",
			//axisLabel : "%",
			axisLabelUseCanvas : true,
			axisLabelFontSizePixels : 12,
			axisLabelFontFamily : 'Verdana, Arial',
			axisLabelPadding : 3
		//,
		//tickFormatter: function (v, axis) {
		//    return $.formatNumber(v, { format: "#,###", locale: "us" });
		// }
		},
		legend : {
			noColumns : 0,
			//  labelBoxBorderColor: "#000000",
			position : "ne"
		},
		grid : {
			hoverable : true,
			borderWidth : 0
		//  backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
		}
	// ,
	// colors:["#004078","#207800", "#613C00"]
	};
	
	var optionsZ2 = {
		series : {
			stack : true,
			bars : {
				show : true
			}
		},
		bars : {
			align : "center",
			barWidth : 0.25, //24 * 60 * 60 * 600,
			lineWidth : 1
	
		},
		xaxis : {
			//  mode: "time",
			//  tickSize: [2, "day"],
			//  tickLength: 10,
			color : "black",
			//  axisLabel: "Date",
			axisLabelUseCanvas : true,
			axisLabelFontSizePixels : 12,
			axisLabelFontFamily : 'Verdana, Arial',
			axisLabelPadding : 10,
			ticks : barTicks02
		},
		yaxis : {
			min : 0,
			max : 100,
			color : "black",
			//  axisLabel: "DNS Query Count",
			axisLabelUseCanvas : true,
			axisLabelFontSizePixels : 12,
			axisLabelFontFamily : 'Verdana, Arial',
			axisLabelPadding : 3,
			tickFormatter : function(v, axis) {
				return $.formatNumber(v, {
					format : "#,###",
					locale : "us"
				});
			}
		},
		legend : {
			noColumns : 0,
			//  labelBoxBorderColor: "#000000",
			position : "ne"
		},
		grid : {
			hoverable : true,
			borderWidth : 0
		//   backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
		}
	//,
	// colors:["#004078","#207800", "#613C00"]
	};
	
	var plot01 = $.plot($("#barplaceholder01"), datasetZ1, optionsZ1);
	var plot02 = $.plot($("#barplaceholder02"), datasetZ2, optionsZ2);	

	
	function barUpdate(wavedata) {

		var barRevData = wavedata.barEvntFrmList;
		var iCnt = 0;

		for ( var idx = 0; idx < Object.keys(barRevData).length; idx++) {

			if (barRevData[idx].fctyNo == "0") {

				barDataZ1.push([ 0, barRevData[idx].nokPcnt ]);
				barDataZ2.push([ 0, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "1") {

				barDataZ1.push([ 1, barRevData[idx].nokPcnt ]);
				barDataZ2.push([ 1, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "2") {

				barDataZ1.push([ 2, barRevData[idx].nokPcnt ]);
				barDataZ2.push([ 2, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "3") {

				barDataZ1.push([ 3, barRevData[idx].nokPcnt ]);
				barDataZ2.push([ 3, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "4") {

				barDataZ1.push([ 4, barRevData[idx].nokPcnt ]);
				barDataZ2.push([ 4, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "5") {

				barDataZ1.push([ 5, barRevData[idx].nokPcnt ]);
				barDataZ2.push([ 5, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "6") {

				barDataZ1.push([ 6, barRevData[idx].nokPcnt ]);
				barDataZ2.push([ 6, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "7") {

				barDataZ1.push([ 7, barRevData[idx].nokPcnt ]);
				barDataZ2.push([ 7, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "8") {

				barDataZ1.push([ 8, barRevData[idx].nokPcnt ]);
				barDataZ2.push([ 8, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "9") {

				barDataZ3.push([ 0, barRevData[idx].nokPcnt ]);
				barDataZ4.push([ 0, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "10") {

				barDataZ3.push([ 1, barRevData[idx].nokPcnt ]);
				barDataZ4.push([ 1, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "11") {

				barDataZ3.push([ 2, barRevData[idx].nokPcnt ]);
				barDataZ4.push([ 2, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "12") {

				barDataZ3.push([ 3, barRevData[idx].nokPcnt ]);
				barDataZ4.push([ 3, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "13") {

				barDataZ3.push([ 4, barRevData[idx].nokPcnt ]);
				barDataZ4.push([ 4, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "14") {

				barDataZ3.push([ 5, barRevData[idx].nokPcnt ]);
				barDataZ4.push([ 5, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "15") {

				barDataZ3.push([ 6, barRevData[idx].nokPcnt ]);
				barDataZ4.push([ 6, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "16") {

				barDataZ3.push([ 7, barRevData[idx].nokPcnt ]);
				barDataZ4.push([ 7, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "17") {

				barDataZ3.push([ 8, barRevData[idx].nokPcnt ]);
				barDataZ4.push([ 8, barRevData[idx].okPcnt ]);
			}
		}

		datasetZ1 = [ {
			label : "안전",
			data : barDataZ2,
			color : "#9bbb58"
		}, {
			label : "점검필요",
			data : barDataZ1,
			color : "#da0404"
		} ];

		datasetZ2 = [ {
			label : "안전",
			data : barDataZ4,
			color : "#9bbb58"
		}, {
			label : "점검필요",
			data : barDataZ3,
			color : "#da0404"
		} ];

		plot01.setData(datasetZ1); 
        plot01.draw();
        plot02.setData(datasetZ2); 
        plot02.draw();
		
		// $("#barplaceholder01").UseTooltip(); 
		// $("#barplaceholder02").UseTooltip();  
	}

	function gd(year, month, day) {
		return new Date(year, month - 1, day).getTime();
	}

	var previousPoint = null, previousLabel = null;
	//var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

	$.fn.UseTooltip = function() {
		$(this).bind(
				"plothover",
				function(event, pos, item) {
					if (item) {
						if ((previousLabel != item.series.label)
								|| (previousPoint != item.dataIndex)) {
							previousPoint = item.dataIndex;
							previousLabel = item.series.label;
							$("#tooltip").remove();

							var x = item.datapoint[0];
							var y = item.datapoint[1];

							var color = item.series.color;
							var day = ""; //"Jan " + new Date(x).getDate();

							showTooltip(item.pageX, item.pageY, color,
									"<strong>" + item.series.label
											+ "</strong><br>" + day
											+ " : <strong>"
											+ $.formatNumber(y, {
												format : "###",
												locale : "us"
											}) + "</strong>(%)");
						}
					} else {
						$("#tooltip").remove();
						previousPoint = null;
					}
				});
	};

	function showTooltip(x, y, color, contents) {
		$('<div id="tooltip">' + contents + '</div>').css({
			position : 'absolute',
			display : 'none',
			top : y - 40,
			left : x - 120,
			border : '2px solid ' + color,
			padding : '3px',
			'font-size' : '9px',
			'border-radius' : '5px',
			'background-color' : '#fff',
			'font-family' : 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
			opacity : 0.9
		}).appendTo("body").fadeIn(200);
	}
</script>
<div id="bar_contentZ1" class="bar-container">
	<div id="barplaceholder01" class="bar-placeholder"></div>
</div>
<div id="bar_contentZ2" class="bar-container">
	<div id="barplaceholder02" class="bar-placeholder"></div>
</div>

