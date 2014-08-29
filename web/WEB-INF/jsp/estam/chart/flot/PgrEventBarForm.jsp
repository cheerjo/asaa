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

<script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script>

<script type="text/javascript" src="${ctx}/js/chart/real/excanvas.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.time.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.stack.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script>
<script type="text/javascript" src="${ctx}/js/chart/real/jquery.flot.axislabels.js"></script>

<script>
	

	var barTicks01 = [ [ 0, "전국" ], [ 1, "서울특별시" ], [ 2, "부산광역시" ],
			[ 3, "대구광역시" ], [ 4, "인천광역시" ], [ 5, "광주광역시" ], [ 6, "대전광역시" ],
			[ 7, "울산광광역시" ], [ 8, "강원도" ] ];

	var barTicks02 = [ [ 0, "경기도" ], [ 1, "충청북도" ], [ 2, "충청남도" ],
			[ 3, "전라북도" ], [ 4, "전라남도" ], [ 5, "경상북도" ], [ 6, "경상남도" ],
			[ 7, "제주특별자치도" ], [ 8, "세종시" ] ];

	var options01 = {
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
			,
			tickFormatter: function (v, axis) {
			    //return $.formatNumber(v, { format: "#,###%", locale: "us" });
			    return v + "%";
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
		//  backgroundColor: { colors: ["#EDF5FF", "#ffffff"] }
		}
	// ,
	// colors:["#004078","#207800", "#613C00"]
	};

	var options02 = {
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
			tickFormatter: function (v, axis) {
			    //return $.formatNumber(v, { format: "#,###%", locale: "us" });
			    return v + "%";
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

	function barUpdate(wavedata) {

		var barRevData = wavedata.barEvntFrmList;
		var iCnt = 0;
		
		var barData01 = [ [ 0, 0 ], [ 1, 0 ], [ 2, 0 ], [ 3, 0 ], [ 4, 0 ],[ 5, 0 ], [ 6, 0 ], [ 7, 0 ], [ 8, 0 ] ];
		var barData02 = [ [ 0, 0 ], [ 1, 0 ], [ 2, 0 ], [ 3, 0 ], [ 4, 0 ],[ 5, 0 ], [ 6, 0 ], [ 7, 0 ], [ 8, 0 ] ];
		var barData03 = [ [ 0, 0 ], [ 1, 0 ], [ 2, 0 ], [ 3, 0 ], [ 4, 0 ],[ 5, 0 ], [ 6, 0 ], [ 7, 0 ], [ 8, 0 ] ];
		var barData04 = [ [ 0, 0 ], [ 1, 0 ], [ 2, 0 ], [ 3, 0 ], [ 4, 0 ],[ 5, 0 ], [ 6, 0 ], [ 7, 0 ], [ 8, 0 ] ];

		var dataset01 = [];
		var dataset02 = [];

		for ( var idx = 0; idx < Object.keys(barRevData).length; idx++) {

			if (barRevData[idx].fctyNo == "0") {

				barData01.push([ 0, barRevData[idx].nokPcnt ]);
				barData02.push([ 0, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "1") {

				barData01.push([ 1, barRevData[idx].nokPcnt ]);
				barData02.push([ 1, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "2") {

				barData01.push([ 2, barRevData[idx].nokPcnt ]);
				barData02.push([ 2, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "3") {

				barData01.push([ 3, barRevData[idx].nokPcnt ]);
				barData02.push([ 3, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "4") {

				barData01.push([ 4, barRevData[idx].nokPcnt ]);
				barData02.push([ 4, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "5") {

				barData01.push([ 5, barRevData[idx].nokPcnt ]);
				barData02.push([ 5, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "6") {

				barData01.push([ 6, barRevData[idx].nokPcnt ]);
				barData02.push([ 6, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "7") {

				barData01.push([ 7, barRevData[idx].nokPcnt ]);
				barData02.push([ 7, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "8") {

				barData01.push([ 8, barRevData[idx].nokPcnt ]);
				barData02.push([ 8, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "9") {

				barData03.push([ 0, barRevData[idx].nokPcnt ]);
				barData04.push([ 0, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "10") {

				barData03.push([ 1, barRevData[idx].nokPcnt ]);
				barData04.push([ 1, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "11") {

				barData03.push([ 2, barRevData[idx].nokPcnt ]);
				barData04.push([ 2, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "12") {

				barData03.push([ 3, barRevData[idx].nokPcnt ]);
				barData04.push([ 3, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "13") {

				barData03.push([ 4, barRevData[idx].nokPcnt ]);
				barData04.push([ 4, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "14") {

				barData03.push([ 5, barRevData[idx].nokPcnt ]);
				barData04.push([ 5, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "15") {

				barData03.push([ 6, barRevData[idx].nokPcnt ]);
				barData04.push([ 6, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "16") {

				barData03.push([ 7, barRevData[idx].nokPcnt ]);
				barData04.push([ 7, barRevData[idx].okPcnt ]);

			} else if (barRevData[idx].fctyNo == "17") {

				barData03.push([ 8, barRevData[idx].nokPcnt ]);
				barData04.push([ 8, barRevData[idx].okPcnt ]);
			}
		}

		dataset01 = [ {
			label : "안전",
			data : barData02,
			color : "#9bbb58"
		}, {
			label : "점검필요",
			data : barData01,
			color : "#da0404"
		} ];

		dataset02 = [ {
			label : "안전",
			data : barData04,
			color : "#9bbb58"
		}, {
			label : "점검필요",
			data : barData03,
			color : "#da0404"
		} ];
		
		//remove
		$("#barplaceholder01").empty();
		$("#barplaceholder02").empty();

		$.plot($("#barplaceholder01"), dataset01, options01);
		$.plot($("#barplaceholder02"), dataset02, options02);

		// $("#barplaceholder01").UseTooltip(); 
		// $("#barplaceholder02").UseTooltip();  
	}

	function eventBarExec() {
		$.ajax({
			url : "${ctx}/flot/BarEvntFrm.do",
			dataType : 'json',
			type : 'POST',
			//contentType : "application/json; charset=UTF-8",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			async : false,
			//data : $("#inptForm").serializeArray(),
			data : $("#inptForm").serialize(),
			error : function(request, status, error) {
				alert("에러 : " + request.status + "\r\에러메시지 : " + request.reponseText);
	        },
		    success : function(data) {

				//var pData = JSON.parse(data);
				pAreaData = JSON.parse(data);
				barUpdate(pAreaData);

			}
		});
	}

	$(document).ready(function() {
		//$("#load").hide();
		
		$("#bar_content01").css("width", 690);
		$("#bar_content01").css("height", 170); //205

		$("#bar_content02").css("width", 690);
		$("#bar_content02").css("height", 170);

		eventBarExec();

	});

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
<div id="bar_content01" class="bar-container">
	<div id="barplaceholder01" class="bar-placeholder"></div>
</div>
<div id="bar_content02" class="bar-container">
	<div id="barplaceholder02" class="bar-placeholder"></div>
</div>

