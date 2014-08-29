<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
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
<%@ page import ="egovframework.com.cmm.LoginVO" %>
 
<link rel="stylesheet" type="text/css" href="${ctx}/css/map/skin.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/arcgis_js_api/library/3.6/jsapi/js/dojo/dijit/themes/claro/claro.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/map/style.css">
  
<script type="text/javascript" src="${ctx}/js/jquery/jquery.jcarousel.min.js"></script> 
  
<!-- 이부분 로컬 api 적용할것
<script type="text/javascript" src="http://serverapi.arcgisonline.com/jsapi/arcgis/?v=2.8"></script>      -->

<script type="text/javascript" src="${ctx}/arcgis_js_api/library/3.6/jsapi/init.js"></script>

<script type="text/javascript" src="${ctx}/js/map/arcgismap.js"></script>
 

<script type="text/javascript">var djConfig = {parseOnLoad: true};</script> 
 
<script type="text/javascript">

dojo.require("dijit.layout.BorderContainer");
dojo.require("dijit.layout.ContentPane");
dojo.require("esri.map");

/******************************************************
***************** begin config section ****************
*******************************************************/

var TITLE = "지진가속도응담신호 종합분석시스템"
var BYLINE= ""
var INTRO_PICTURE = "";
var INTRO_NAME = "estam"
var INTRO_DESCRIPTION = "";
var CSV_FILE = "${ctx}/js/map/location031.csv";
//var BASEMAP_URL = "http://services.arcgisonline.com/ArcGIS/rest/services/World_Topo_Map/MapServer";
var BASEMAP_URL = "http://10.32.28.202:6080/arcgis/rest/services/asaa/south_korea_1/MapServer";
var BASEMAP_URL2 = "http://services.esrikr.com/ArcGIS/rest/services/Korea_Topo_Map/MapServer";


/* optionally, you can also define an initial extent.  if you do not define the extent,
   the map will default to the extent of the point dataset.*/
//var INITIAL_EXTENT = new esri.geometry.Extent({"xmin":-8573621,"ymin":4705444,"xmax":-8572546,"ymax":4706442,"spatialReference":{"wkid":102100}})

/******************************************************
***************** end config section ******************
*******************************************************/

var LOADING_IMAGE = "${ctx}/images/ajax-loader_white.gif";

var _carousel;
var _crossFader;
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
	$("#toggle").click(function(e) {
		if ($("#placard").css('display')=='none'){
		  $("#toggle").html('&#x25BC;');
		}
		else{
		  $("#toggle").html('&#x25B2;');
		}
		$("#placard").slideToggle();
    });
	$("#arrowPrev").click(prevPicture);			
	$("#arrowNext").click(nextPicture);
			
	
	$("#title").append(TITLE);
	$("#subtitle").append(BYLINE);	
	

	_map = new esri.Map("map");

	//Korea TopoMap 추가
	_map.addLayer(new esri.layers.ArcGISTiledMapServiceLayer(BASEMAP_URL));
	//World TopoMap 추가
	//_map.addLayer(new esri.layers.ArcGISTiledMapServiceLayer(BASEMAP_URL2));

	//독도 레이어 추가
	var imageParameters = new esri.layers.ImageParameters();
    imageParameters.format = "jpeg";  //set the image type to PNG24, note default is PNG8.
    //Takes a URL to a non cached map service.
    var dynamicMapServiceLayer = new esri.layers.ArcGISDynamicMapServiceLayer("http://172.16.10.122:6080/arcgis/rest/services/Dokdo/MapServer", {"opacity":0.5, "imageParameters":imageParameters});
    _map.addLayer(dynamicMapServiceLayer);
	
	
	
	_crossFader = new CrossFader($("#cfader"),LOADING_IMAGE);
	
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
			tile_Init();
			
		/* 	setTimeout(function(){
				if (!_map.extent.contains(extent)) {
					_map.setLevel(_map.getLevel() +5);
				}
				},
				1000); */
			
			
			dojo.connect(_map.graphics, "onMouseOver", layer_onMouseOver);
			dojo.connect(_map.graphics, "onMouseOut", layer_onMouseOut);
			dojo.connect(_map.graphics, "onClick", layer_onClick);

			  jQuery('#mycarousel').jcarousel({
				scroll:10,
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
					_crossFader.setSource(INTRO_PICTURE);
					setPlacard(INTRO_NAME,INTRO_DESCRIPTION)
				}
			}); 		
		});
		
		locationsService.process(CSV_FILE);

    });
	
}

function tile_Init() {
	var index = 0;
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
	
	//$("#middle").css("height",heightMiddle);
	
	var height = calcAllottedHeight(widthViewport - 450,heightMiddle);
	//$("#frame").css("height",height);
	//$("#frame").css("width",height * 1.5);
	
	$("#left").css("width",widthViewport - 163);  //parseInt($("#frame").css("width")) + 100
	$("#left").css("height",heightViewport); // heightMiddle legacy IE's require explicit calculation of height.	
	//$("#right").css("width",parseInt($("#middle").css("width")) - parseInt($("#left").css("width")));
	//$("#right").css("height",heightMiddle); // legacy IE's require explicit calculation of height.		
	
	$("#map").css("width",widthViewport -163);  //parseInt($("#right").css("width"))
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
	$(".tile").removeClass("tile-hover");
	$(this).addClass("tile-hover");	
}

function tile_onMouseOut() {
	$(".tile").removeClass("tile-hover");
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
	_selected = event.graphic;
	var index = $.inArray(_selected,_locations);
	_carousel.scroll(index);
	// add style class to the 'selected' element
	$(".tile").removeClass("tile-selected");
	$(".tile:eq("+index+")").addClass("tile-selected");
	postSelection();
	alert("개발중");
}

function layer_onMouseOver(event)
{
	_map.setMapCursor("pointer");
	var graphic = event.graphic;
	graphic.setSymbol(graphic.symbol.setHeight(30).setWidth(24));
	$("#hoverInfo").html(graphic.attributes.name);
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
	_crossFader.setSource(_selected.attributes.url);
	setPlacard(_selected.attributes.name,_selected.attributes.description);
	showInfoWindow(_selected.geometry,_selected.attributes.name);
	var index = $.inArray(_selected,_locations)
	$("#arrowNext").attr("src","${ctx}/images/picture_right.png");
	$("#arrowNext").css("cursor","pointer");	
	$("#arrowPrev").attr("src","${ctx}/images/picture_left.png");	
	$("#arrowPrev").css("cursor","pointer");	
	if (index == 0) {
		$("#arrowPrev").attr("src","${ctx}/images/picture_left_disabled.png");	
		$("#arrowPrev").css("cursor","default");
	} else if (index == _locations.length - 1) {
		$("#arrowNext").attr("src","${ctx}/images/picture_right_disabled.png");	
		$("#arrowNext").css("cursor","default");
	} else {
		// nothing
	}
}

function createTag(number,name,url,color) {
	if (color == "B") 
		return '<div class="tile"><div class="number number-blue">'+number+'</div><img src="' + url + '" class="thumb"><div>'+name+'</div></div>';
	else
		return '<div class="tile"><div class="number">'+number+'</div><img src="' + url + '" class="thumb"><div>'+name+'</div></div>';
}

function showInfoWindow(pt,name) {
	
	if (!_map.extent.contains(_selected.geometry)) {
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
	
	_map.infoWindow.show(pt);
	
}

function setPlacard(name,text) {
	$("#placard div").remove();
	$("#placard").append("<div class='name'>"+name+"<div/>");	
	$("#placard").append("<div class='description'>"+text+"<div/>");	
}

function hoverInfoPos(x,y){
	if (x <= ($("#map").width())-230){
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
	$("#hoverInfo").show();
}

</script>
  
   <div id="left" dojotype="dijit.layout.BorderContainer" design="headline" gutters="false">
       <div id="sizer"><p></p></div>
       <div id="map" dojotype="dijit.layout.ContentPane" region="center">
        <div id="hoverInfo"></div>
       </div>
   </div>            
         