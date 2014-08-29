<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>지진가속도 응답신호 종합분석 시스템</title>

<meta name="description" content="국립재난안전연구원 지진가속도 응답신호 종합분석 시스템 웹사이트 입니다.">
<meta name="keywords" content="지진가속도, 응답신호 종합분석"> 

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=7, IE=9, IE=10">
<meta name="viewport" content="initial-scale=1, maximum-scale=1,user-scalable=no">

<link rel="stylesheet" href="/css/style.css"> 
<link rel="stylesheet" type="text/css" href="skin.css" />
<link rel="stylesheet" type="text/css" href="/js/dojo/dijit/themes/claro/claro.css">
<link rel="stylesheet" type="text/css" href="style.css">

<link href='http://api.mobilis.co.kr/webfonts/css/?fontface=NanumGothicWeb' rel='stylesheet' type="text/css"> 

 <link href="/js/chart/flot/examples/examples.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="/js/jquery/jquery-1.9.0.js"></script>

<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="/js/chart/flot/excanvas.min.js"></script><![endif]-->
<!-- script language="javascript" type="text/javascript" src="/js/chart/flot/jquery.js"></script> -->
<script language="javascript" type="text/javascript" src="/js/chart/flot/jquery.flot.js"></script>

<script type="text/javascript" src="/js/map/jquery.jcarousel.min.js"></script>

<script type="text/javascript" src="/js/map/ie8_compatibility.js"></script>
<script type="text/javascript" src="/js/map/CrossFader.js"></script>
<script type="text/javascript" src="/js/map/EventTarget.js"></script>
<script type="text/javascript" src="/js/map/LocationsService.js"></script>
<script type="text/javascript" src="/js/map/helper_functions.js"></script>
<script  type="text/javascript" src="/inc/ahn_common.js"></script>

<script type="text/javascript" src="http://serverapi.arcgisonline.com/jsapi/arcgis/?v=2.8"></script>

<script type="text/javascript">var djConfig = {parseOnLoad: true};</script>
 
 
<!--Social Media Links-->
<script type="text/javascript">var switchTo5x=true;</script><script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script><script type="text/javascript">stLight.options({publisher:'77225c91-2742-42f7-b1b4-bddda99a9bde'});</script>
<!--END Social Media Links-->


<script type="text/javascript">

dojo.require("dijit.layout.BorderContainer");
dojo.require("dijit.layout.ContentPane");
dojo.require("esri.map");

/******************************************************
***************** begin config section ****************
*******************************************************/

var TITLE = "한국에서 가장 아름다운 곳 Top 50"
var BYLINE= "이 스토리 맵은 CNN의 여행 전문 사이트인 CNN GO에서 2012년 1월에 선정한 “50 beautiful places to visit in Korea” 내용을 바탕으로 제작하였습니다."
var INTRO_PICTURE = "http://farm9.staticflickr.com/8482/8209451903_093f94faf0_z.jpg";
var INTRO_NAME = "성산일출봉"
var INTRO_DESCRIPTION = "성산 일출봉은 5,000여년전 제주도에서 일어난 화산 폭발로 생긴 것으로 현재 유네스코 세계 유산으로 선정되어 보호받고 있다. 다른 곳에서는 찾아볼 수 있는 희귀한 동식물들을 찾아볼 수 있으며 이름에서도 알 수 있듯이 일출이 특히나 유명한 곳으로 사랑받고 있다. 꼭대기까지 올라가는데는 30분정도 걸린다.";
var CSV_FILE = "/inc/locations.csv";
var BASEMAP_URL = "http://services.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer";
var BASEMAP_URL2 = "http://services.esrikr.com/ArcGIS/rest/services/Korea_Topo_Map/MapServer";


/* optionally, you can also define an initial extent.  if you do not define the extent,
   the map will default to the extent of the point dataset.*/
//var INITIAL_EXTENT = new esri.geometry.Extent({"xmin":-8573621,"ymin":4705444,"xmax":-8572546,"ymax":4706442,"spatialReference":{"wkid":102100}})

/******************************************************
***************** end config section ******************
*******************************************************/

var LOADING_IMAGE = "images/ajax-loader_white.gif";

var _carousel;
//var _crossFader;
var _map;

var _dojoReady = false;
var _jqueryReady = false;

var _locations;
var _selected;

var _firstTime = true;
var _isLegacyIE = (navigator.appVersion.indexOf("MSIE 7.0") > -1) || (navigator.appVersion.indexOf("MSIE 8.0") > -1);

dojo.addOnLoad(function() {_dojoReady = true;init()});
jQuery(document).ready(function() {_jqueryReady = true;init()});

function init() {
	
	if (!_jqueryReady) return;
	if (!_dojoReady) return;
	
	situateFrame();
	
	// jQuery event assignment
	
	$(this).resize(situateFrame);
/*	$("#toggle").click(function(e) {
		if ($("#placard").css('display')=='none'){
		  $("#toggle").html('&#x25BC;');
		}
		else{
		  $("#toggle").html('&#x25B2;');
		}
		$("#placard").slideToggle();
    });
	$("#arrowPrev").click(prevPicture);			
	$("#arrowNext").click(nextPicture); */
			
	
	//$("#title").append(TITLE);
	//$("#subtitle").append(BYLINE);	 

	_map = new esri.Map("map");

	//Korea TopoMap 추가
	_map.addLayer(new esri.layers.ArcGISTiledMapServiceLayer(BASEMAP_URL));
	//World TopoMap 추가
	_map.addLayer(new esri.layers.ArcGISTiledMapServiceLayer(BASEMAP_URL2));

	//독도 레이어 추가
	var imageParameters = new esri.layers.ImageParameters();
    imageParameters.format = "jpeg";  //set the image type to PNG24, note default is PNG8.
    //Takes a URL to a non cached map service.
    var dynamicMapServiceLayer = new esri.layers.ArcGISDynamicMapServiceLayer("http://172.16.10.122:6080/arcgis/rest/services/Dokdo/MapServer", {"opacity":0.5, "imageParameters":imageParameters});
    _map.addLayer(dynamicMapServiceLayer);
	
	
	
	//_crossFader = new CrossFader($("#cfader"),LOADING_IMAGE);
	
	dojo.connect(_map, 'onLoad', function(theMap) { 
	
		//resize the map when the browser resizes
		dojo.connect(dijit.byId('map'), 'resize', _map,_map.resize);

		var locationsService = new LocationsService();		  
		locationsService.addListener("complete", function(){
			
			_locations = locationsService.getLocations();
			
			$(_locations).each(function(index, element) {
               _map.graphics.add(element); 
            });	
			
			var extent;
			if (typeof INITIAL_EXTENT === 'undefined') {
				extent = getGraphicsExtent(_locations).expand(1.1);
			} else {
				extent = INITIAL_EXTENT;
			}
			_map.setExtent(extent);
			
			
			// 성산일출봉을 선택하여 초기화 세팅
			//tile_Init();
			//alert(_map.getLevel());		
			setTimeout(function(){
				if (!_map.extent.contains(extent)) { 
					_map.setLevel(7); //_map.getLevel() + 5
				}
				},
				1000);
			
			
			dojo.connect(_map.graphics, "onMouseOver", layer_onMouseOver);
			dojo.connect(_map.graphics, "onMouseOut", layer_onMouseOut);
			dojo.connect(_map.graphics, "onClick", layer_onClick);

			jQuery('#mycarousel').jcarousel({
				scroll:5,
				itemLoadCallback: function(carousel, state) {
					
					if (state != 'init')
						return;
					
					_carousel = carousel;
					
					$(_locations).each(function(index,element){
						_carousel.add(index+1,createTag(index+1,element.attributes.name,element.attributes.thumbURL,element.attributes.color));
					});
					
					_carousel.size(_locations.length);
					$(".tile").click(tile_onClick);	
					$(".tile").mouseover(tile_onMouseOver);
					$(".tile").mouseout(tile_onMouseOut);
				//	_crossFader.setSource(INTRO_PICTURE);
					setPlacard(INTRO_NAME,INTRO_DESCRIPTION)
				}
			});			
		});
		
		locationsService.process(CSV_FILE);

    });
	
}

function tile_Init() {
	var index = 8;
	_selected = _locations[index];
	if (_selected) _map.centerAt(_selected.geometry);
	postSelection();
}



function situateFrame() {
	
	viewportDim = getViewportDimensions();
	
	var widthViewport = parseInt(viewportDim[0]);
	var heightViewport = parseInt(viewportDim[1]);
	var heightHeader = parseInt($("#header").css("height"));
	var heightBottom = parseInt($("#bottom").css("height"));
	var heightMiddle = heightViewport - (heightHeader + heightBottom);
	
	$("#middle").css("height",heightMiddle);
	
	var height = calcAllottedHeight(widthViewport - 450,heightMiddle);
	$("#frame").css("height",height);
	$("#frame").css("width",height * 1.5);
	
	$("#left").css("width",widthViewport);  //parseInt($("#frame").css("width")) + 100
	$("#left").css("height",heightViewport); // heightMiddle legacy IE's require explicit calculation of height.	
	//$("#right").css("width",parseInt($("#middle").css("width")) - parseInt($("#left").css("width")));
	//$("#right").css("height",heightMiddle); // legacy IE's require explicit calculation of height.		
	
	$("#map").css("width",widthViewport);  //parseInt($("#right").css("width"))
	$("#map").css("height",heightViewport);  //parseInt($("#right").css("height"))
	
	$("#frame").css("top",(parseInt($("#left").css("height")) - parseInt($("#frame").css("height"))) / 2) - 2;
	$("#frame").css("left",47);
	
	// arrow dimensions 50 x 85
	$("#arrowNext").css("top",(parseInt($("#left").css("height")) - 85) / 2);
	$("#arrowPrev").css("top",(parseInt($("#left").css("height")) - 85) / 2);
	
	if (_carousel) _carousel.options.scroll = parseInt(widthViewport / parseInt($(".tile").css("width"))) - 1;

	if (_selected) _map.centerAt(_selected.geometry);	
	
}

function calcAllottedHeight(width,height) {
	width = width - 100;
	height = height - 40;
	for (var i = 0; i < height; i++)
	{
		height = height - 1;
		if (width >= height * 1.5) break;
	}
	return height;
}

function tile_onMouseOver() {
	if ($(this).hasClass("tile-selected")) {
		return;
	}
//	$(".tile").removeClass("tile-hover");
//	$(this).addClass("tile-hover");	
}

function tile_onMouseOut() {
	//$(".tile").removeClass("tile-hover");
}

function tile_onClick() {
	$(".tile").removeClass("tile-hover");
	$(".tile").removeClass("tile-selected");
	$(this).addClass("tile-selected");
	var index = $(".tile").index($(this));
	_selected = _locations[index];
	postSelection();
}

function nextPicture() {
	var index = 0;
	if (_selected) {
		index = $.inArray(_selected,_locations);
		if (index == (_locations.length - 1)) return;
		index++;
	}
	_selected = _locations[index];
	_carousel.scroll(index);
	// add style class to the 'selected' element
	$(".tile").removeClass("tile-selected");
	$(".tile:eq("+index+")").addClass("tile-selected");
	postSelection();
}

function prevPicture() {
	if (!_selected) {
		return;
	}
	var index = $.inArray(_selected,_locations);
	if (index == 0) return;
	index--;
	_selected = _locations[index];
	_carousel.scroll(index);
	// add style class to the 'selected' element
	$(".tile").removeClass("tile-selected");
	$(".tile:eq("+index+")").addClass("tile-selected");
	postSelection();
}

function layer_onClick(event)
{
	alert("개발중");
	return;
	_selected = event.graphic;
	var index = $.inArray(_selected,_locations);
	_carousel.scroll(index);
	// add style class to the 'selected' element
	$(".tile").removeClass("tile-selected");
	$(".tile:eq("+index+")").addClass("tile-selected");
	postSelection();
}

function layer_onMouseOver(event)
{
	_map.setMapCursor("pointer");
	var graphic = event.graphic;
	graphic.setSymbol(graphic.symbol.setHeight(30).setWidth(24));
	//$("#hoverInfo").html(graphic.attributes.name);
	var pt = _map.toScreen(graphic.geometry);
	hoverInfoPos(pt.x,pt.y);	
}

function layer_onMouseOut(event)
{
 	_map.setMapCursor("default");
	var graphic = event.graphic;	
	graphic.setSymbol(graphic.symbol.setHeight(28).setWidth(22));
	$("#hoverInfo").hide();	 
}

function postSelection() {
	/* _crossFader.setSource(_selected.attributes.url);
	setPlacard(_selected.attributes.name,_selected.attributes.description);
	showInfoWindow(_selected.geometry,_selected.attributes.name);
	var index = $.inArray(_selected,_locations)
	$("#arrowNext").attr("src","images/picture_right.png");
	$("#arrowNext").css("cursor","pointer");	
	$("#arrowPrev").attr("src","images/picture_left.png");	
	$("#arrowPrev").css("cursor","pointer");	
	if (index == 0) {
		$("#arrowPrev").attr("src","images/picture_left_disabled.png");	
		$("#arrowPrev").css("cursor","default");
	} else if (index == _locations.length - 1) {
		$("#arrowNext").attr("src","images/picture_right_disabled.png");	
		$("#arrowNext").css("cursor","default");
	} else {
		// nothing
	} */
}

function createTag(number,name,url,color) {
	if (color == "B") 
		return '<div class="tile"><div class="number number-blue">'+number+'</div><img src="' + url + '" class="thumb"><div>'+name+'</div></div>';
	else
		return '<div class="tile"><div class="number">'+number+'</div><img src="' + url + '" class="thumb"><div>'+name+'</div></div>';
}

function showInfoWindow(pt,name) {
	
	/*	if (!_map.extent.contains(_selected.geometry)) {
		_map.centerAt(_selected.geometry);
	}
	$("#sizer p").remove();
	$("#sizer").append("<p>"+name+"</p>");
	
	_map.infoWindow.setTitle(name);

	if (!_isLegacyIE) {
		_map.infoWindow.resize($("#sizer").attr("clientWidth")+14,20);	
	} else {
		// infoWindow.resize() breaks the legacy IE's if height is less than 40px.
		_map.infoWindow.resize($("#sizer").attr("clientWidth")+14,40);	
	}
 	$(".infowindow .title").css("width",$("#sizer").attr("clientWidth")+14);
	
	
	if (_firstTime) {
		if (!_isLegacyIE) { 
			// this breaks the legacy IE's
			$(".infowindow .title").css("font","Verdana, Geneva, sans-serif");
		}
		$(".infowindow .title").css("font-size",10);
		$(".infowindow .window").css("color","#666");
		$(".infowindow .hide").css("margin-left",0);		
		$(".claro .infowindow .sprite").css("background-image","url(images/infowindow.png)");
		_firstTime = false;
	}
	
	_map.infoWindow.show(pt); */
	
}

function setPlacard(name,text) {
	//$("#placard div").remove();
	//$("#placard").append("<div class='name'>"+name+"<div/>");	
	//$("#placard").append("<div class='description'>"+text+"<div/>");	
}

function hoverInfoPos(x,y){
	/*if (x <= ($("#map").width())-230){
		$("#hoverInfo").css("left",x+15);
	}
	else{
		$("#hoverInfo").css("left",x-25-($("#hoverInfo").width()));
	}
	if (y >= ($("#hoverInfo").height())+50){
		$("#hoverInfo").css("top",y-35-($("#hoverInfo").height()));
	}
	else{
		$("#hoverInfo").css("top",y-15+($("#hoverInfo").height()));
	}
	$("#hoverInfo").show(); */
}

</script>
 <script type="text/javascript">
 
	
	$(function() { 
		
		function getFlotViewportDimensions() {
			var viewportwidth;
			var viewportheight;
		  
			// the more standards compliant browsers (mozilla/netscape/opera/IE7) use window.innerWidth and window.innerHeight
			
			if (typeof window.innerWidth != 'undefined')
			{
				viewportwidth = window.innerWidth,
				viewportheight = window.innerHeight
			}
			
			// IE6 in standards compliant mode (i.e. with a valid doctype as the first line in the document)
			
			else if (typeof document.documentElement != 'undefined'
			&& typeof document.documentElement.clientWidth !=
			'undefined' && document.documentElement.clientWidth != 0)
			{
				viewportwidth = document.documentElement.clientWidth,
				viewportheight = document.documentElement.clientHeight
			}
			
			// older versions of IE
			
			else
			{
				viewportwidth = document.getElementsByTagName('body')[0].clientWidth,
				viewportheight = document.getElementsByTagName('body')[0].clientHeight
			}
			return [viewportwidth,viewportheight]
		}
		
		
	    viewportDim = getFlotViewportDimensions();
		//alert(viewportDim[1]);
		var widthViewport = parseInt(viewportDim[0]);
		var heightViewport = parseInt(viewportDim[1]);
	  
		
		$("#flot_content").css("width",450);   
		$("#flot_content").css("height",160);  
		
		//$(this).resize(situateFrame);
		
		// We use an inline data source in the example, usually data would
		// be fetched from a server 
		var data = [],
			totalPoints = 300;

		function getRandomData() {

			if (data.length > 0)
				data = data.slice(1);

			// Do a random walk

			while (data.length < totalPoints) {

				var prev = data.length > 0 ? data[data.length - 1] : 50,
					y = prev + Math.random() * 10 - 5;

				if (y < 0) {
					y = 0;
				} else if (y > 100) {
					y = 100;
				}

				data.push(y);
			}

			// Zip the generated y values with the x values

			var res = [];
			for (var i = 0; i < data.length; ++i) {
				res.push([i, data[i]])
			}

			return res;
		}

		// Set up the control widget

		var updateInterval = 30;
		$("#updateInterval").val(updateInterval).change(function () {
			var v = $(this).val();
			if (v && !isNaN(+v)) {
				updateInterval = +v;
				if (updateInterval < 1) {
					updateInterval = 1;
				} else if (updateInterval > 2000) {
					updateInterval = 2000;
				}
				$(this).val("" + updateInterval);
			}
		});

		var plot = $.plot("#placeholder", [ getRandomData() ], {
			series: {
				shadowSize: 0	// Drawing is faster without shadows
			},
			yaxis: {
				min: 0,
				max: 100
			},
			xaxis: {
				show: true
			}
		});

		function update() {

			plot.setData([getRandomData()]);

			// Since the axes don't change, we don't need to call plot.setupGrid()

			plot.draw();
			setTimeout(update, updateInterval);
		}

		update();

		// Add the Flot version string to the footer

	//	$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
	});

	</script>

</head>

<BODY>

<!-- STR:top_menu -->
<div id="top_wrap">
    <c:import url="/EgovPageLink.do?link=estam/main/inc/EstamIncHeader" /> 
</div>
<!-- END:top_menu -->


<!-- STR:컨텐츠 -->	
<div id="contents_wrap">
	<div id="contents">

		<!-- STR:지도 -->		
		<div class="map">
			<div class="map_left">
				
				<!-- STR:지도 왼쪽 버튼 -->
				<div class="map_btn">
					<ul>
						<li class="btn_map01"><a href="#" title="PGA">PGA</a></li>	
						<li class="btn_map02"><a href="#" title="진도(MMI)">진도(MMI)</a></li>	
						<li class="btn_map03"><a href="#" title="계측소">계측소</a></li>	
						<li class="btn_map04"><a href="#" title="지반분류">지반분류</a></li>	
						<li class="btn_map05"><a href="#" title="이상진동감지">이상진동감지</a></li>	
					</ul>
				</div>
				<!-- END:지도 왼쪽 버튼 -->
				
				<!-- STR:지도 왼쪽 테이블 -->
				<div class="map_tb">
					<table>
						<tr>
							<th>진도<br>(MMI)</th>
							<th>진동감지</th>
						</tr>
						<tr>
							<td class="step">Ⅰ</td>
							<td>무감</td>
						</tr>
						<tr>
							<td class="step">Ⅱ-Ⅲ</td>
							<td>약한진동</td>
						</tr>
						<tr>
							<td class="step">Ⅳ</td>
							<td>가벼운진동</td>
						</tr>
						<tr>
							<td class="step">Ⅴ</td>
							<td>보통진동</td>
						</tr>
						<tr>
							<td class="step">Ⅵ</td>
							<td>강한진동</td>
						</tr>
						<tr>
							<td class="step">Ⅶ</td>
							<td>매우강한진동</td>
						</tr>
						<tr>
							<td class="step">Ⅷ</td>
							<td>심한진동</td>
						</tr>
						<tr>
							<td class="step">Ⅸ</td>
							<td>격렬한진동</td>
						</tr>
						<tr>
							<td class="step">Ⅹ+</td>
							<td>극한진동</td>
						</tr>
					</table>
				</div>
				<!-- END:지도 왼쪽 테이블 -->

				<!-- STR:지도 왼쪽 아이콘 -->
				<div class="map_tb_ico">
					<table>
						<tr>
							<td><img src="/img/common/ico_map01.png" title="" /></td>
							<td>건축물 (123/600 - 2)</td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map02.png" title="" /></td>
							<td>교량 (80/80 - 1) </td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map03.png" title="" /></td>
							<td>댐, 저수지 (22/38 - 0) </td>
						</tr>
					</table>
					<table>
						<tr>
							<td><img src="/img/common/ico_map04.png" title="" /></td>
							<td>공항시설 (15/15 - 2)</td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map05.png" title="" /></td>
							<td>가스시설 (32/32 - 1)  </td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map06.png" title="" /></td>
							<td>고속철도 (50/50 - 0) </td>
						</tr>
					</table>
					<table>
						<tr>
							<td><img src="/img/common/ico_map07.png" title="" /></td>
							<td>원자력 시설 (6/6 - 0)</td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map08.png" title="" /></td>
							<td>발전용 수력, 화력설비<br> (82/82 - 1)  </td>
						</tr>
						<tr>
							<td><img src="/img/common/ico_map03.png" title="" /></td>
							<td>변전소 (50/112 - 2) </td>
						</tr>
					</table>
				</div>
				<!-- END:지도 왼쪽 아이콘 -->

			</div>

			<div class="map_right">		
				   <div id="left" dojotype="dijit.layout.BorderContainer" design="headline" gutters="false">
		           <!-- <div id="sizer"></div> -->
		            <div id="map" dojotype="dijit.layout.ContentPane" region="center">
			            <div id="hoverInfo"></div>
		            </div>
		          </div>      
			</div>
		
		</div>
		<!-- END:지도 -->
		
		<!-- STR:우측 그래프 -->
		<div class="graph">

			<!-- STR:이상진동 감지 -->
			<div class="data01">
				<div class="data_step">
					<img src="/img/common/data_step.jpg" title="" />
				</div>
				<ul>
					<li class="graph_title01">이상진동 감지  -  (없음)/00개소</li>
					<li class="graph_txt">시각 : 2013. 07.19.  17:27:12</li> 
					<li class="graph_txt">위치 : 대구시청&nbsp;&nbsp;&nbsp;&nbsp;연락처 (000-000-0000)</li>
					<li class="graph_txt">계측 PGA : 15 gal</li>
				</ul>				
			</div>
			<!-- END:이상진동감지 -->
			
			<!-- STR:계측신호 오류 감지 -->
			<div class="data01">
				<ul>
					<li class="graph_title01">계측신호 오류 감지  -  (없음)/00개소</li>
					<li class="graph_txt">[건축물] 인천광역시 소방안전본부</li> 
					<li class="graph_txt">건축물] 전남대학교</li>
					<li class="graph_txt">[교량] 광안대교</li>
				</ul>
			</div>
			<!-- END:계측신호 오류감지 -->

			<!-- STR:지진가속도 계측 최대값 -->
			<div class="data02">
				<ul>
					<li class="graph_title02">행정구역별 실시간 지진가속도 계측 최대값</li>
				</ul>
				<div class="data02_down">
					그래프
				</div>
			</div>
			<!-- END:지진가속도 계측 최대값 -->
			
			<!-- STR:지진가속도 계측 최대값 하단 결과값 -->
			<div class="data03">				
				<div class="graph_bott">
					<ul>
						<li class="graph_title03">서울특별시청사 - 1초간 PGA 시간 이력</li>
					</ul>
					<div class="graph_bott_down">
						<div id="flot_content" class="demo-container">
							<div id="placeholder" class="demo-placeholder"></div>
							<input id="updateInterval" type="hidden" value="100"  > 
						</div> 
					</div>
				</div> 
				<div class="graph_bott_right">
					<ul>
						<li><img src="/img/etc/photo.jpg" title="" /></li>
						<li class="title">서울특별시청사</li>
						<li>위치 : 서울특별시 중구 을지로1가 63</li>
						<li>안전성 점검결과 : 안전</li>
						<li>지진가속도계측기 상태 : 정상</li>
						<li>설치개수 : 자유장 1, 최상층 2, 중간층 1</li>
					</ul>
				</div>
			</div>
			<!-- END:지진가속도 계측 최대값 하단 결과값-->

		</div>
		<!-- END:우측 그래프 -->

	</div>	
</div>
<!-- END:컨텐츠 -->	 
<!-- STR:footer -->
<div id="footer">
	<c:import url="/EgovPageLink.do?link=estam/main/inc/EstamIncFooter" />  
</div>
<!-- END:footer -->

</BODY>
</HTML>
