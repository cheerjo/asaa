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
 
<link rel="stylesheet" href="${ctx}/css/style.css">    
  
 <link rel="stylesheet" href="${ctx}/js/map/js3.7/js/dojo/dijit/themes/claro/claro.css">
 <link rel="stylesheet" href="${ctx}/js/map/js3.7/js/esri/css/esri.css">
 <style>
       #map {
        padding: 0;
        margin: 0;
        height: 100%;
      }
      .esriSlider {
                  position:absolute;
                  text-align:center;
                  border:2px solid #666;
                  background-color:#FFF;
                  color:#666;
                  -webkit-user-select:none;
                  -moz-user-select:none;
                  -ms-user-select:none;
                  user-select:none;
                  -webkit-border-radius:5px;
                  -moz-border-radius:5px;
                  -o-border-radius:5px;
                  border-radius:5px;
                  }
      
      #evntinfo { 
        top: 120px;
        color: #444;
        height: 30px;
        font-family: arial;
        left: 190px;
        margin: 5px;
        padding: 10px;
        position: absolute;
        text-align: left;
        width: 100px;
        z-index: 40;
      }
    </style>
 <script type="text/javascript" src="${ctx}/js/jquery/jquery-1.9.0.js"></script> 
<script type="text/javascript" src="${ctx}/js/jquery/json2.js"></script>  
  
<!-- 이부분 로컬 api 적용할것 /js/map/jsapi/init_tc.js   js3.7/init.js-->
<script type="text/javascript" src="${ctx}/js/map/js3.7/init.js"></script>   
 
<script type="text/javascript" src="${ctx}/js/map/arcgismap.js"></script>

<script type="text/javascript">var djConfig = {parseOnLoad: true};</script>


<script type="text/javascript">
 

dojo.require("esri.map"); 
dojo.require("esri.layers.FeatureLayer"); 
dojo.require("esri.layers.ArcGISTiledMapServiceLayer"); 
dojo.require("esri.layers.ArcGISDynamicMapServiceLayer"); 	// 맵 서비스 선언 추가
dojo.require("esri.SpatialReference"); 
dojo.require("esri.geometry.Point"); 
dojo.require("esri.tasks.query"); 
dojo.require("esri.tasks.QueryTask"); 
dojo.require("esri.tasks.geometry"); 
dojo.require("esri.graphic"); 
dojo.require("esri.InfoTemplate"); 
dojo.require("esri.dijit.Scalebar"); 
dojo.require("esri.config"); 
dojo.require("dojo.colors"); 
dojo.require("dojo.Deferred");
dojo.require("dojo.dom"); 
dojo.require("dojo.domReady"); 
dojo.require("dojo._base.event");

/******************************************************
***************** begin config section ****************
*******************************************************/
var GIS_FLAG = "${leftMapGubun}";
var TITLE = "지진가속도응담신호 종합분석시스템";
 
var INTRO_NAME = "asaa"; 

var BASEMAP_URL1 = "http://10.32.28.202:6080/arcgis/rest/services/asaa/FCTY_PGA_INTERPOLATION/MapServer";
var BASEMAP_URL2 = "http://10.32.28.202:6080/arcgis/rest/services/asaa/FCTY_MMI_INTERPOLATION/MapServer";


/* optionally, you can also define an initial extent.  if you do not define the extent,
   the map will default to the extent of the point dataset.*/
//var INITIAL_EXTENT = new esri.geometry.Extent({"xmin":122.24770921432463,"ymin":35.99109263427591,"xmax":132.51971044407327,"ymax":38.682851992673896,"spatialReference":{"wkid":4326}})
 
/******************************************************
***************** end config section ******************
*******************************************************/
var _map;
var featureLayer, dynamicLayer;
var scalebar;
var distanceTable, colorTable;
var query, query2, queryTask, queryTask2, geometryService;
  
var MMA_COLOR_INDEX=0;
var MMA_LEVEL_INDEX=0;

var value;
var feats, geos;

var _carousel;
var _crossFader;


var _dojoReady = false;
var _jqueryReady = false;

var _locations;
var _selected;

var _firstTime = true;
var _isLegacyIE = (navigator.appVersion.indexOf("MSIE 7.0") > -1) || (navigator.appVersion.indexOf("MSIE 8.0") > -1);

dojo.addOnLoad(function() {_dojoReady = true;init()});
jQuery(document).ready(function() {_jqueryReady = true;init()});

 var locationsService = new LocationsService();

function init() {
	 
	if (!_jqueryReady) return;  
	if (!_dojoReady) return; 
	 
	 situateFrame();
	 
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
	
	 distanceTable = 
		new Array(
				new Array(10,  0,  0,  0,  0,  0,  0,  0,  0,  0),		// <= 1
				new Array(20, 10,  0,  0,  0,  0,  0,  0,  0,  0),		// <= 2
				new Array(30, 20, 10,  0,  0,  0,  0,  0,  0,  0),		// <= 3
				new Array(40, 30, 20, 10,  0,  0,  0,  0,  0,  0),		// <= 4
				new Array(50, 40, 30, 20, 10,  0,  0,  0,  0,  0),		// <= 5
				new Array(60, 50, 40, 30, 20, 10,  0,  0,  0,  0),		// <= 6
				new Array(70, 60, 50, 40, 30, 20, 10,  0,  0,  0),		// <= 7
				new Array(80, 70, 60, 50, 40, 30, 20, 10,  0,  0),		// <= 8
				new Array(90, 80, 70, 60, 50, 40, 30, 20, 10,  0),		// <= 9
				new Array(100,90, 80, 70, 60, 50, 40, 30, 20, 10)		// > 9 (over 10+)
		);

	   // colorTable[shows step] = color value;
     colorTable =
     	new Array(
     		new dojo.Color([152,   0,   0, 0.2]),
     		new dojo.Color([152,   0,   0, 0.2]),
     		new dojo.Color([152,   0,   0, 0.2]),
     		new dojo.Color([152,   0,   0, 0.2]),
     		new dojo.Color([152,   0,   0, 0.2]),
     		new dojo.Color([152,   0,   0, 0.2]),
     		new dojo.Color([152,   0,   0, 0.2]),
     		new dojo.Color([152,   0,   0, 0.2]),
     		new dojo.Color([152,   0,   0, 0.2]),
     		new dojo.Color([152,   0,   0, 0.2])
     	); 
			
	        _map = new esri.Map("map", {sliderOrientation:"vertical", sliderPosition:"top-left", sliderStyle:"large", logo:false});
			_map.centerAndZoom(new esri.geometry.Point(127.2, 36.8), 0);
            _map.addLayer(new esri.layers.ArcGISTiledMapServiceLayer("http://10.32.28.202:6080/arcgis/rest/services/asaa/FCTY_WORLD/MapServer"));
		 
            _map.addLayer(new esri.layers.ArcGISTiledMapServiceLayer("http://10.32.28.202:6080/arcgis/rest/services/asaa/newaddr_basemap/MapServer"));
			
            // FCTY_MMI_INTERPOLATION, FCTY_MMI_RLT_INTERPOLATION, FCTY_PGA_INTERPOLATION, FCTY_PGA_RLT_INTERPOLATION 로 변경하여 적용 
   	       dynamicLayer = new esri.layers.ArcGISDynamicMapServiceLayer(BASEMAP_URL1 ,
			{refreshInterval:10,	// 지도 갱신 주기(단위:분)
			 opacity:0.7});	            // 상기 4개 맵서비스에 추가
	       dynamicLayer2 = new esri.layers.ArcGISDynamicMapServiceLayer(BASEMAP_URL2 ,
			{refreshInterval:10,	// 지도 갱신 주기(단위:분)
			 opacity:0.7});	            // 상기 4개 맵서비스에 추가    
            
               featureLayer = new esri.layers.FeatureLayer("http://10.32.28.202:6080/arcgis/rest/services/asaa/FCTY_MMA/MapServer/0",{
				mode: esri.layers.FeatureLayer.MODE_ONDEMAND,
				infoTemplate: new esri.InfoTemplate(),
				outFields: ["FCTY_CD","FCTY_NM","FCTY_LON", "FCTY_LAT", "FCTY_MMA","GVMT_CD"],
				visible:true
	        });
			//infoTemplate.setTitle("관측소 정보");
			//infoTemplate.setContent("관측소 코드:${FCTY_CD}<br>관측소 이름:${FCTY_NM}<br>관측소 X좌표:${FCTY_LON}<br>관측소 Y좌표:${FCTY_LAT}<br>관측값:${FCTY_MMA}");
			//featureLayer.infoTemplate = infoTemplate;
			 
              //featureLayer.setDefinitionExpression("FCTY_MMA >= 1");
			  _map.addLayer(featureLayer); 
			  _map.addLayer(dynamicLayer);
			  _map.addLayer(dynamicLayer2); 
			  
		       query = new esri.tasks.Query();
		       queryTask = new esri.tasks.QueryTask("http://10.32.28.202:6080/arcgis/rest/services/asaa/FCTY_MMA/MapServer/0");
		       geometryService = new esri.tasks.GeometryService("http://10.32.28.202:6080/arcgis/rest/services/Utilities/Geometry/GeometryServer");
		       
		 
	        featureLayer.on("mouse-over", function (evt) {
	        	var fcty_nm = evt.graphic.attributes['FCTY_NM'];
			_map.setMapCursor("pointer"); 
			var graphic = event.graphic;
			
			var pt = _map.toScreen(graphic.geometry); 
			 
			  _map.infoWindow.setTitle(fcty_nm);
		   
			  $(".infowindow .title").css("width",100);
			   
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
	        });
		
		 featureLayer.on("mouse-out", function (evt) {
	        	_map.setMapCursor("default"); 
			var graphic = event.graphic;	 
			var pt = _map.toScreen(graphic.geometry);
			_map.infoWindow.hide(pt);
	        }); 
		 
	        featureLayer.on("click", function (evt) {

	        	var fctyNm = evt.graphic.attributes['FCTY_NM'];
	        	var fctyCd = evt.graphic.attributes['FCTY_CD'];
	        	var gvmtCd = evt.graphic.attributes['GVMT_CD'];
	        	
	        	mapClickEventBar(fctyNm, fctyCd, gvmtCd);
	        	event.stop(evt);
	        });		       
		        
		       
		      dojo.connect(_map, 'onLoad', function(theMap) { 
	               
		             dynamicLayer2.hide();
		             // drawMMA();
			   
			     locationsService.addListener("complete", function(){ 
				 
			     _locations = locationsService.getLocations();
			    
			     $(_locations).each(function(index, element) {
			       _map.graphics.add(element); 
			     });
			     
			     initMap();
			 });  
			
			//dojo.connect(_map.graphics, "onMouseOver", layer_onMouseOver);
			//dojo.connect(_map.graphics, "onMouseOut", layer_onMouseOut);
			//dojo.connect(_map.graphics, "onClick", layer_onClick);
 	 
		});
		 
		//dojo.connect(_map, "onLoad", drawMMA);
		//dojo.connect(_map, "onClick", redrawMMA);

}

//화면 갱신 함수 추가		
function refreshMap() { 
	dynamicLayer.refresh();
}

// 맵 이벤트 등록
function initMap() {
	map.on("click", refreshMap);
}		

function initArray() {
	feats=new Array(
			new Array(), new Array(), new Array(), new Array(), new Array(),
			new Array(), new Array(), new Array(), new Array(), new Array()
		);
	geos=new Array(
			new Array(), new Array(), new Array(), new Array(), new Array(),
			new Array(), new Array(), new Array(), new Array(), new Array()
		);
}

function redrawMMA() {
	 _map.graphics.clear();
	drawMMA();
}

function drawMMA() {
	initArray();
	queryFeatures();
}

function queryFeatures() {
	query.outSpatialReference = _map.spatialReference;
	query.where = "FCTY_MMA > 0";
	query.returnGeometry = true;
	query.outFields = ["FCTY_NM", "FCTY_MMA"];
	queryTask.execute(query, queryComplete);
}

function queryComplete(featureSet) {
	if (featureSet == null || featureSet.features.length == 0) {
		return ;
	}
	
	var resultFeatures = featureSet.features;
	
	for (var i=0, len=resultFeatures.length; i<len; i++) {
		geos[resultFeatures[i].attributes['FCTY_MMA']-1].push(resultFeatures[i].geometry);
		feats[resultFeatures[i].attributes['FCTY_MMA']-1].push(resultFeatures[i]);
	}

	makeBuffers();
}

function makeBuffers() {

	MMA_COLOR_INDEX = 0;
	MMA_LEVEL_INDEX = 0;
	
	makeBuffer();
}

function makeBuffer() {
	
	if (geos[MMA_LEVEL_INDEX].length == 0) {
		makeNextBuffer();
		return ;
	}

	var params = new esri.tasks.BufferParameters();

	params.geometries = geos[MMA_LEVEL_INDEX];
	params.distances = [ distanceTable[MMA_LEVEL_INDEX][MMA_COLOR_INDEX] ];
	params.unit = esri.tasks.GeometryService.UNIT_KILOMETER;
	params.bufferSpatialReference = new esri.SpatialReference({wkid:102100});
	params.outSpatialReference = _map.spatialReference;
params.unionResults = true;
geometryService.buffer(params, showBuffer, errBack);
}

function makeNextBuffer() {
	if (++MMA_LEVEL_INDEX >= feats.length) {
		MMA_LEVEL_INDEX = ++MMA_COLOR_INDEX;
		
		if (MMA_COLOR_INDEX >= colorTable.length) {
			return ;
		}
	}
	makeBuffer();
}

function errBack(err) {
	alert (err);
}

function showBuffer(geometries) {
		
	var symbol = new esri.symbol.SimpleFillSymbol(
		esri.symbol.SimpleFillSymbol.STYLE_SOLID,
		null,
		colorTable [ MMA_COLOR_INDEX ]
	);
	
	dojo.forEach(geometries, function(geometry) {
	var graphic = new esri.Graphic(geometry,symbol);
		_map.graphics.add(graphic);
	});
	
	makeNextBuffer();
} 

//지도 뿌리기. 
function setLocProcess(mapFlag) { 
             
     locationsService.process(mapFlag);  
          
}

function mapfctyKndExec(src01, src02) {  
          
    featureLayer.setDefinitionExpression("FCTY_KND_CD = '" + src01 + "' or FCTY_KND_CD = '" + src02 + "'");
          
}
 


function situateFrame() {
	 
	/*viewportDim = getViewportDimensions();
 
	var widthViewport = parseInt(viewportDim[0]);
	var heightViewport = parseInt(viewportDim[1]);
	var heightHeader = parseInt($("#top_menu").css("height"));
	var heightBottom = parseInt($("#footer").css("height"));
	var heightMiddle = heightViewport - (heightHeader + heightBottom);
	 
	var height = calcAllottedHeight(widthViewport - 450,heightMiddle);
	 
	$("#left_map").css("width",widthViewport - parseInt($("#graph").css("width")) - parseInt($("#map_left").css("width")) - 55);  // 
	$("#left_map").css("height",heightViewport - heightBottom - 50); // heightMiddle legacy IE's require explicit calculation of height.	
	 
	$("#map").css("width",widthViewport - parseInt($("#graph").css("width")) - parseInt($("#map_left").css("width")) - 55);   
	$("#map").css("height",heightViewport - heightBottom - 50);   */ 
	  
	//if (_carousel) _carousel.options.scroll = parseInt(widthViewport / parseInt($(".tile").css("width"))) - 1;

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
 
  
function layer_onClick(event)
{
	// redrawMMA(); 
	_selected = event.graphic;
	var index = $.inArray(_selected,_locations);
	//_carousel.scroll(index);
	// add style class to the 'selected' element
	//$(".tile").removeClass("tile-selected");
	//$(".tile:eq("+index+")").addClass("tile-selected"); 
	//parent.mapClickEvent(_selected.attributes.name,_selected.attributes.fctyCd,_selected.attributes.gvmtCd);
}

function layer_onMouseOver(event)
{
      
	_map.setMapCursor("pointer"); 
	var graphic = event.graphic;  
	graphic.setSymbol(graphic.symbol.setHeight(17).setWidth(17));
	$("#hoverInfo").html(graphic.attributes.name);
	var pt = _map.toScreen(graphic.geometry);
	hoverInfoPos(pt.x,pt.y);	
}

function layer_onMouseOut(event)
{
	_map.setMapCursor("default");
	var graphic = event.graphic;	
	graphic.setSymbol(graphic.symbol.setHeight(15).setWidth(15));
	$("#hoverInfo").hide();	
}

function postSelection() {
	//_crossFader.setSource(_selected.attributes.url);
	//setPlacard(_selected.attributes.name,_selected.attributes.description);
	showInfoWindow(_selected.geometry,_selected.attributes.name);
	var index = $.inArray(_selected,_locations)
	//$("#arrowNext").attr("src","${ctx}/images/picture_right.png");
	//$("#arrowNext").css("cursor","pointer");	
	//$("#arrowPrev").attr("src","${ctx}/images/picture_left.png");	
	//$("#arrowPrev").css("cursor","pointer");	
	/*if (index == 0) {
		$("#arrowPrev").attr("src","${ctx}/images/picture_left_disabled.png");	
		$("#arrowPrev").css("cursor","default");
	} else if (index == _locations.length - 1) {
		$("#arrowNext").attr("src","${ctx}/images/picture_right_disabled.png");	
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
	 
	if (!_map.extent.contains(_selected.geometry)) {
		_map.centerAt(_selected.geometry);
	}
	 
	//$("#sizer p").remove();
	//$("#sizer").append("<p>"+name+"</p>");
	
	_map.infoWindow.setTitle(name);

	/*if (!_isLegacyIE) {
		_map.infoWindow.resize($("#sizer").attr("clientWidth")+14,20);	
	} else {
		// infoWindow.resize() breaks the legacy IE's if height is less than 40px.
		_map.infoWindow.resize($("#sizer").attr("clientWidth")+14,40);	
	} */
	//$(".infowindow .title").css("width",$("#sizer").attr("clientWidth")+14);
	
	
	/*if (_firstTime) {
		if (!_isLegacyIE) { 
			// this breaks the legacy IE's
			$(".infowindow .title").css("font","Verdana, Geneva, sans-serif");
		}
		$(".infowindow .title").css("font-size",10);
		$(".infowindow .window").css("color","#666");
		$(".infowindow .hide").css("margin-left",0);		
		$(".claro .infowindow .sprite").css("background-image","url(images/infowindow.png)");
		_firstTime = false;
	} */
	 
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

function newOpen() {
	window.open("${ctx}/arcgis/ArcGisMapViewFull.do");
}
</script>
  
   <div id="left_map"  dojotype="dijit.layout.BorderContainer" design="headline" gutters="false"  class="claro"  style="position:relative;">
       <div id="evntinfo" class="btn_total_view"><a href="#" onClick="javascript:newOpen();">전체보기</a></div>
       <div id="map" dojotype="dijit.layout.ContentPane" region="center" style="width:712px;height:830px">   
       </div>
   </div>
    
