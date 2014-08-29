<%@page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/taglibs.jsp"%>

<%
	/**
	 * @Class Name :  
	 * @Description : main bar  컨트롤 
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
<script src="${ctx}/js/estam_common.js"></script>

<script type="text/javascript"
	src="${ctx}/js/chart/real/excanvas.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/chart/real/jquery.flot.min.js"></script>

<script type="text/javascript"
	src="${ctx}/js/chart/real/jquery.flot.time.js"></script>
<script type="text/javascript"
	src="${ctx}/js/chart/real/jshashtable-2.1.js"></script>
<script type="text/javascript"
	src="${ctx}/js/chart/real/jquery.numberformatter-1.2.3.min.js"></script>
<script type="text/javascript"
	src="${ctx}/js/chart/real/jquery.flot.symbol.js"></script>
<script type="text/javascript"
	src="${ctx}/js/chart/real/jquery.flot.axislabels.js"></script>
<script type="text/javascript"
	src="${ctx}/js/chart/real/jquery.flot.orderBars.js"></script>



<script>
	//바처리 부분    

	/*
	var barTicks01 = [ [ 0, "전국" ], [ 1, "서울특별시<br>(과기대)" ],
			[ 2, "인천광역시<br>(남동구청)" ], [ 3, "대구광역시<br>(대구공항)" ],
			[ 4, "대전광역시<br>(한밭대학교)" ], [ 5, "부산광역시<br>(부산대학교)" ],
			[ 6, "울산광역시<br>(울산공항)" ], [ 7, "광주광광역시<br>(광주시청)" ],
			[ 8, "세종시<br>(열병합발전소)" ] ];

	var barTicks02 = [ [ 0, "경기도<br>(경기도청)" ], [ 1, "강원도<br>(강원대학교)" ],
			[ 2, "경상남도<br>(통영시청)" ], [ 3, "경상북도<br>(포항공항)" ],
			[ 4, "전라남도<br>(목포대학교)" ], [ 5, "전라남도<br>(김제시청)" ],
			[ 6, "충청남도<br>(충남도청)" ], [ 7, "충청북도<br>(충북도청)" ],
			[ 8, "제주특별자치도<br>(화력발전소)" ] ];
*/

	var pAreaData;
	var barTicks01 = [
			[ 0, "전국" ],
			[ 1,
					"<a href='#' onclick='barAreaClickEvent(\"서울특별시\")'>서울특별시<br>(과기대)</a>" ],
			[ 2,
					"<a href='#' onclick='barAreaClickEvent(\"인천광역시\")'>인천광역시<br>(남동구청)</a>" ],
			[ 3,
					"<a href='#' onclick='barAreaClickEvent(\"대구광역시\")'>대구광역시<br>(대구공항)</a>" ],
			[ 4,
					"<a href='#' onclick='barAreaClickEvent(\"대전광역시\")'>대전광역시<br>(한밭대학교)</a>" ],
			[ 5,
					"<a href='#' onclick='barAreaClickEvent(\"부산광역시\")'>부산광역시<br>(부산대학교)</a>" ],
			[ 6,
					"<a href='#' onclick='barAreaClickEvent(\"울산광역시\")'>울산광역시<br>(울산공항)</a>" ],
			[ 7,
					"<a href='#' onclick='barAreaClickEvent(\"광주광역시\")'>광주광역시<br>(광주시청)</a>" ],
			[ 8,
					"<a href='#' onclick='barAreaClickEvent(\"세종시\")'>세종시<br>(열병합발전소)</a>" ] ];

	var barTicks02 = [
			[ 0,
					"<a href='#' onclick='barAreaClickEvent(\"경기도\")'>경기도<br>(경기도청)</a>" ],
			[ 1,
					"<a href='#' onclick='barAreaClickEvent(\"강원도\")'>강원도<br>(강원대학교)</a>" ],
			[ 2,
					"<a href='#' onclick='barAreaClickEvent(\"경상남도\")'>경상남도<br>(통영시청)</a>" ],
			[ 3,
					"<a href='#' onclick='barAreaClickEvent(\"경상북도\")'>경상북도<br>(포항공항)</a>" ],
			[ 4,
					"<a href='#' onclick='barAreaClickEvent(\"전라북도\")'>전라북도<br>(목포대학교)</a>" ],
			[ 5,
					"<a href='#' onclick='barAreaClickEvent(\"전라남도\")'>전라남도<br>(김제시청)</a>" ],
			[ 6,
					"<a href='#' onclick='barAreaClickEvent(\"충청남도\")'>충청남도<br>(충남도청)</a>" ],
			[ 7,
					"<a href='#' onclick='barAreaClickEvent(\"충청북도\")'>충청북도<br>(충북도청)</a>" ],
			[ 8,
					"<a href='#' onclick='barAreaClickEvent(\"제주특별자치도\")'>제주특별자치도<br>(화력발전소)</a>" ] ];

	
	  //지도 계측소 클릭시 호출되는 함수.
	 function mapClickEventBar(wvName,wvFctyCd,wvGvmtCd) { 
		  
		    if (wvName == "") {
		    	 $("#waveTitle").text("과기대 - 자유장 실시간 PGA계측값이력");
		    	 fctyExec('PGA','SL','AC');   
		    	 WaveMainForm('PGA','SL','AC') ;
			
		    } else {
		    	$("#waveTitle").text(wvName + " - 자유장 실시간 PGA계측값이력"); 
				fctyExec('PGA',wvFctyCd,wvGvmtCd);  
				WaveMainForm('PGA',wvFctyCd,wvGvmtCd) ;
		    }  
			
	 } 	
	
	 	
	  
	function barAreaClickEvent(area) {
		var ob, gvmtNmj;
		area = $.trim(area);
		if (area != "전국") {
			for ( var i = 0; i < pAreaData.barRevData.length; i++) {
				obj = pAreaData.barRevData[i];
				gvmtNm = $.trim(obj.gvmtNm);
				if (obj.gvmtNm.indexOf(area) >= 0) {
					mapClickEventBar(obj.fctyNm, obj.fctyCd, obj.gvmtCd);
				}
			}
		}

	}

	var barOptions01 = {
		series : {
			bars : {
				show : true,
				order : 1
			}
		},
		//valueLabels: {
		//    show: true
		//},
		bars : {
			align : "left",
			barWidth : 0.3
		},
		xaxis : {
			// axisLabel: "World Cities",
			axisLabelUseCanvas : true,
			axisLabelFontSizePixels : 12,
			axisLabelFontFamily : 'Verdana, Arial',
			axisLabelPadding : 10,
			ticks : barTicks01

		},
		yaxis : {
			min:0,
			max:0.05,
			axisLabel : "PGA (gal)",
			axisLabelUseCanvas : true,
			axisLabelFontSizePixels : 12,
			axisLabelFontFamily : 'Verdana, Arial',
			axisLabelPadding : 1,
			tickFormatter : function(v, axis) {
				return v;
			}
		},
		legend : {
			noColumns : 0,
			//   labelBoxBorderColor: "#000000",
			position : "ne"
		},
		grid : {
			hoverable : true,
			borderWidth : 0
		// backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
		}
	};

	var barOptions02 = {
		series : {
			bars : {
				show : true,
				order : 1
			}
		},
		//valueLabels: {
		//    show: true
		//},
		bars : {
			align : "left",
			barWidth : 0.25
		},
		xaxis : {
			// axisLabel: "World Cities",
			axisLabelUseCanvas : true,
			axisLabelFontSizePixels : 12,
			axisLabelFontFamily : 'Verdana, Arial',
			axisLabelPadding : 10,
			ticks : barTicks02

		},
		yaxis : {
			min:0,
			max:0.05,
			axisLabel : "PGA (gal)",
			axisLabelUseCanvas : true,
			axisLabelFontSizePixels : 12,
			axisLabelFontFamily : 'Verdana, Arial',
			axisLabelPadding : 3,
			tickFormatter : function(v, axis) {
				return v;
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
		//,        
		// backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
		}
	};
	
	function barUpdate(wavedata) {
		var barRevData = wavedata.barRevData;
		
		var barData01 = [ [ 0, 0 ], [ 1, 0 ], [ 2, 0 ], [ 3, 0 ], [ 4, 0 ],
		      			[ 5, 0 ], [ 6, 0 ], [ 7, 0 ], [ 8, 0 ]

		      	];
      	var barData02 = [ [ 0, 0 ], [ 1, 0 ], [ 2, 0 ], [ 3, 0 ], [ 4, 0 ],
      			[ 5, 0 ], [ 6, 0 ], [ 7, 0 ], [ 8, 0 ] ];

      	var barData03 = [ [ 0, 0 ], [ 1, 0 ], [ 2, 0 ], [ 3, 0 ], [ 4, 0 ],
      			[ 5, 0 ], [ 6, 0 ], [ 7, 0 ], [ 8, 0 ]

      	];
      	var barData04 = [ [ 0, 0 ], [ 1, 0 ], [ 2, 0 ], [ 3, 0 ], [ 4, 0 ],
      			[ 5, 0 ], [ 6, 0 ], [ 7, 0 ], [ 8, 0 ] ];

      	var barDataset01 = [ {
      		label : "10분간 PGA",
      		data : barData01,
      		color : "#ffc000"
      	}, {
      		label : "실시간 3초간 PGA",
      		data : barData02,
      		color : "#8eb4e3"
      	} ];

      	var barDataset02 = [ {
      		label : "10분간 PGA",
      		data : barData03,
      		color : "#ffc000"
      	}, {
      		label : "실시간 3초간 PGA",
      		data : barData04,
      		color : "#8eb4e3"
      	} ];

         
		for ( var idx = 0; idx < Object.keys(barRevData).length; idx++) {

			if (barRevData[idx].fctyNo == "0") {

				barData01.push([ 0, barRevData[idx].fctyPga10 ]);
				barData02.push([ 0, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "1") {

				barData01.push([ 1, barRevData[idx].fctyPga10 ]);
				barData02.push([ 1, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "2") {

				barData01.push([ 2, barRevData[idx].fctyPga10 ]);
				barData02.push([ 2, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "3") {

				barData01.push([ 3, barRevData[idx].fctyPga10 ]);
				barData02.push([ 3, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "4") {

				barData01.push([ 4, barRevData[idx].fctyPga10 ]);
				barData02.push([ 4, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "5") {

				barData01.push([ 5, barRevData[idx].fctyPga10 ]);
				barData02.push([ 5, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "6") {

				barData01.push([ 6, barRevData[idx].fctyPga10 ]);
				barData02.push([ 6, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "7") {

				barData01.push([ 7, barRevData[idx].fctyPga10 ]);
				barData02.push([ 7, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "8") {

				barData01.push([ 8, barRevData[idx].fctyPga10 ]);
				barData02.push([ 8, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "9") {

				barData03.push([ 0, barRevData[idx].fctyPga10 ]);
				barData04.push([ 0, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "10") {

				barData03.push([ 1, barRevData[idx].fctyPga10 ]);
				barData04.push([ 1, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "11") {

				barData03.push([ 2, barRevData[idx].fctyPga10 ]);
				barData04.push([ 2, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "12") {

				barData03.push([ 3, barRevData[idx].fctyPga10 ]);
				barData04.push([ 3, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "13") {

				barData03.push([ 4, barRevData[idx].fctyPga10 ]);
				barData04.push([ 4, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "14") {

				barData03.push([ 5, barRevData[idx].fctyPga10 ]);
				barData04.push([ 5, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "15") {

				barData03.push([ 6, barRevData[idx].fctyPga10 ]);
				barData04.push([ 6, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "16") {

				barData03.push([ 7, barRevData[idx].fctyPga10 ]);
				barData04.push([ 7, barRevData[idx].fctyPga ]);

			} else if (barRevData[idx].fctyNo == "17") {

				barData03.push([ 8, barRevData[idx].fctyPga10 ]);
				barData04.push([ 8, barRevData[idx].fctyPga ]);

			}

		}

		//remove
		
		$("#barplaceholder01").empty();
		$("#barplaceholder02").empty();
		
		$.plot($("#barplaceholder01"), barDataset01, barOptions01);
		$.plot($("#barplaceholder02"), barDataset02, barOptions02);

	};	

	function eventBarExec() {

		var eventBarForm = {
			flag : "PGA"
		};

		$.ajax({
			url : "${ctx}/bar/BarFormRev.do",
			dataType : 'json',
			type : 'POST',
			contentType : "application/json; charset=UTF-8",
			async : false,
			data : JSON.stringify(eventBarForm),
			success : function(data) {

				//var pData = JSON.parse(data);
				pAreaData = JSON.parse(data);
				barUpdate(pAreaData);

			}
		});
	}

	$(document).ready(function() {

		$("#bar_content01").css("width", 690);
		$("#bar_content01").css("height", 205);

		$("#bar_content02").css("width", 690);
		$("#bar_content02").css("height", 205);


		function eventBarUpdate() {
			eventBarExec();
			setTimeout(eventBarUpdate, 10000);
		}

		eventBarUpdate();
	 

	});

	function gd(year, month, day) {
		return new Date(year, month, day).getTime();
	}

	var previousPoint = null, previousLabel = null;

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

							//console.log(item.series.xaxis.ticks[x].label);                

							showTooltip(item.pageX, item.pageY, color,
									"<strong>" + item.series.label
											+ "</strong><br>"
											+ item.series.xaxis.ticks[x].label
											+ " : <strong>" + y + "</strong>");
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

