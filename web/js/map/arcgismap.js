/**
 * ie8_compatibility 
 * @author cyberlhs at 13. 10. 1 오후 1:52
 */

var iCnt = 1;
var CSV_FILE = "/js/map/location031.csv";
var CSV_FILE01 = "/js/map/location033.csv";

if (!Array.prototype.indexOf)
{
  Array.prototype.indexOf = function(elt /*, from*/)
  {
    var len = this.length >>> 0;

    var from = Number(arguments[1]) || 0;
    from = (from < 0)
         ? Math.ceil(from)
         : Math.floor(from);
    if (from < 0)
      from += len;

    for (; from < len; from++)
    {
      if (from in this &&
          this[from] === elt)
        return from;
    }
    return -1;
  };
}

/**
 * CrossFader 
 * @param {?} div
 * @param {?} loading_image
 * @type void
 * @author cyberlhs at 13. 10. 1 오후 1:55
 */
function CrossFader(div,loading_image) {

	var _container = div;
	var _current;
	var _other;	
	var _img1;
	var _img2;
	var _spin;
	
	_img1 = document.createElement("img");
	$(_img1).addClass("member-image");
	
	_img2 = document.createElement("img");
	$(_img2).addClass("member-image");
	
	_spin = document.createElement("img");
	$(_spin).addClass("spinner");
	$(_spin).attr("src",loading_image);

	$(_container).append(_img2);
	$(_container).append(_img1);
	$(_container).append(_spin);		
	
	$(_img1).load(fade);
	$(_img2).load(fade);
	
	_current = _img1;	
	
	this.setSource = function(value) {
		
		var foo = value;  /* IE requires that we do something with the 
							 value -- anything, really -- in order for 
							 it to evaluate correctly. */
		if (_current.src == value) return;
		
		_current = (_current == _img1) ? _img2 : _img1;
		_other = (_current == _img1) ? _img2 : _img1;

		if (_current.src == value) {
			fade();
		} else {
			_current.src = value;
			$(_spin).toggle(true);
		}
	}
	
	function fade() {
		$(_spin).toggle(false);
		$(_current).fadeTo("slow",1);
		$(_other).fadeTo("slow",0);
	}
	
	
}

/**
 * 
 * @type void
 * @author cyberlhs at 13. 10. 1 오후 2:09
 *
 * Copyright (c) 2010 Nicholas C. Zakas. All rights reserved.
 * MIT License
 *
 */ 
function EventTarget(){
    this._listeners = {};
}

EventTarget.prototype = {

    constructor: EventTarget,

    addListener: function(type, listener){
        if (typeof this._listeners[type] == "undefined"){
            this._listeners[type] = [];
        }

        this._listeners[type].push(listener);
    },

    fire: function(event){
        if (typeof event == "string"){
            event = { type: event };
        }
        if (!event.target){
            event.target = this;
        }

        if (!event.type){  //falsy
            throw new Error("Event object missing 'type' property.");
        }

        if (this._listeners[event.type] instanceof Array){
            var listeners = this._listeners[event.type];
            for (var i=0, len=listeners.length; i < len; i++){
                listeners[i].call(this, event);
            }
        }
    },

    removeListener: function(type, listener){
        if (this._listeners[type] instanceof Array){
            var listeners = this._listeners[type];
            for (var i=0, len=listeners.length; i < len; i++){
                if (listeners[i] === listener){
                    listeners.splice(i, 1);
                    break;
                }
            }
        }
    }
};

/**
 * getGraphicsExtent
 * @param {?} graphics
 * @type ?
 * @return 
 * @author cyberlhs at 13. 10. 1 오후 2:16
 */
function getGraphicsExtent(graphics) {
  // accepts an array of graphic points and returns extent
  var minx = Number.MAX_VALUE;
  var miny = Number.MAX_VALUE;
  var maxx = - Number.MAX_VALUE;
  var maxy = - Number.MAX_VALUE;
  var graphic;
  for (var i = 0; i < graphics.length; i++) {
	  graphic = graphics[i];
	  if (graphic.geometry.x > maxx) maxx = graphic.geometry.x;
	  if (graphic.geometry.y > maxy) maxy = graphic.geometry.y;
	  if (graphic.geometry.x < minx) minx = graphic.geometry.x;
	  if (graphic.geometry.y < miny) miny = graphic.geometry.y;
  }
  return new esri.geometry.Extent({"xmin":minx,"ymin":miny,"xmax":maxx,"ymax":maxy,"spatialReference":{"wkid":102100}});;
}

/**
 * getViewportDimensions
 * @type Array
 * @return 
 * @author cyberlhs at 13. 10. 1 오후 2:17
 */
function getViewportDimensions() {
	var viewportwidth;
	var viewportheight;
  
	// the more standards compliant browsers (mozilla/netscape/opera/IE7) use window.innerWidth and window.innerHeight
	
	if (typeof window.innerWidth != 'undefined')
	{
		viewportwidth = window.innerWidth  ,
		viewportheight = window.innerHeight 
	}
	
	// IE6 in standards compliant mode (i.e. with a valid doctype as the first line in the document)
	
	else if (typeof document.documentElement != 'undefined'
	&& typeof document.documentElement.clientWidth !=
	'undefined' && document.documentElement.clientWidth != 0)
	{
		viewportwidth = document.documentElement.clientWidth  ,
		viewportheight = document.documentElement.clientHeight  
	}
 
	// older versions of IE
	
	else
	{
		viewportwidth = document.getElementsByTagName('body')[0].clientWidth  ,
		viewportheight = document.getElementsByTagName('body')[0].clientHeight  
	}
	return [viewportwidth,viewportheight]
}

LocationsService.prototype = new EventTarget();
LocationsService.prototype.constructor = LocationsService;

function LocationsService() {
       
	var _arr = [];
	EventTarget.call(this);	

	// **********
	// methods...
	// **********

	this.process = function(gisGubun) {
		var that = this; 
		_map.graphics.clear();
		if (gisGubun == "PGA") {
 
		     // featureLayer.setDefinitionExpression("FCTY_MMA >= 0");
		     // redrawMMA();
		    dynamicLayer2.hide();	 
   		    dynamicLayer.show();
   		    refreshMap();
		    	/*$.ajax({
				  type: 'GET',
				  url: CSV_FILE,  
				  cache: false, 
				  success: function(text){ 
					 
					parseCSV(text);	 
					that.fire("complete")
				  }
				}); */	
		} else if (gisGubun == "MM") {
		    dynamicLayer.hide();
		    dynamicLayer2.show(); 
   		    dynamicLayer2.refresh();
   		    
			 // featureLayer.setDefinitionExpression("FCTY_MMA >= 0");
		     // redrawMMA();
			/*$.ajax({
				  type: 'GET',
				  url: CSV_FILE,  
				  cache: false, 
				  success: function(text){ 
					 
					parseCSV(text);	 
					that.fire("complete")
				  }
				}); */	
			
		} else if (gisGubun == "GVMT") {
		         featureLayer.setDefinitionExpression("FCTY_MMA >= 0");
			 dynamicLayer.hide();
			 dynamicLayer2.hide();
		       //drawMMA();
		      /* $.ajax({
				  type: 'GET',
				  url: CSV_FILE01,  
				  cache: false, 
				  success: function(text){  
					parseCSV(text);	 
					that.fire("complete")
				  }
				}); */ 
		 
		/* var params="flag="+gisGubun;  
		    alert(gisGubun);
		  	$.ajax({
		  	      url: "/arcgis/ArcGisMapJsonView.do",
		  	      dataType: 'json',
		          type : 'POST',
		          contentType: "application/json; charset=UTF-8",
		          async: false,  
		  	      data: params ,
		  	      success: function(data) {  
		  	    	var pData = JSON.parse(data);  
		  	    	parseGvmt(data);	 
		  	    	that.fire("complete")
					
		  	      }
		  	  }); */  
			
		} else if (gisGubun == "GRND") {
			/*$.ajax({
				  type: 'GET',
				  url: CSV_FILE,  
				  cache: false, 
				  success: function(text){ 
					 
					parseCSV(text);	 
					that.fire("complete")
				  }
				});	 */
			
		} else if (gisGubun == "EVNT") {
			
		/*	var params="flag="+gisGubun;  
			 
		  	$.ajax({
		  	      url: "/arcgis/ArcGisMapJsonView.do",
		  	      dataType: 'json',
		          type : 'POST',
		          contentType: "application/json; charset=UTF-8",
		          async: false,  
		  	      data: params ,
		  	      success: function(data) {  
		  	    	var pData = JSON.parse(data);  
		  	    	parseEvent(data);	 
		  	    	that.fire("complete")
					
		  	      }
		  	  }); */
			
		}   
		
	}

	this.getLocations = function() {
		return _arr;
	}
	
	// *****************
	// private functions
	// *****************

	

	parseGvmt = function(pData) {
		
		  /* FCTY_NM
			, ROWNUM NUM
			, FCTY_NM AS FCTY_DESC
			, FCTY_LON
			, FCTY_LAT
			, ('R') AS ICON_COLOR
			, '' AS URL01
			, '' AS URL02 
		    ,  IMAGE_URL 
			, FCTY_ST_ADDR
			, FCTY_ED_ADDR 
			, FCTY_CD
			, GVMT_CD */
	
		var name,thumbURL,url,description,color,pt,pms,attr,graphic,fctyCd,gvmtCd;
		 
		 var values;
		
		  for (var idx = 0; idx < Object.keys(pData.listMapLocation).length;idx++) {   
	    		 
			    values = pData.mainEventSens[idx];
				name = values.fctyNm;
				thumbURL = values.url01;
				url = values.url02;
				description = values.fctyDesc;
				color = values.iconColor;	
				pt = esri.geometry.geographicToWebMercator(
					new esri.geometry.Point(
						[values.fctyLon,values.fctyLat],
						new esri.SpatialReference({ wkid:4326})) 
				);	
				fctyCd = values.fctyCd;
				gvmtCd = values.gvmtCd;
				
				pms = new esri.symbol.PictureMarkerSymbol(values.imageUrl,15,15);	
			 		
				pms.setOffset(3,8);
				attr = {name:name,thumbURL:thumbURL,url:url,description:description,color:color,fctyCd:fctyCd,gvmtCd:gvmtCd};
				graphic = new esri.Graphic(pt,pms,attr);		
		
				_arr.push(graphic); 
			
		  }
		
	 
	}

	parseEvent = function(pData) {
		
		/*DD.FCTY_NM
	    , ROWNUM NUM  
	    , DD.FCTY_NM AS FCTY_DESC
		, DD.FCTY_LON
		, DD.FCTY_LAT
		, '' AS URL01
		, '' AS URL02 
	    , AA.FCTY_STAT_SENS_TM
	    , AA.FCTY_STAT_SENS_PGA
	    , AA.FCTY_CD
	    , AA.GVMT_CD  */
	
		var name,thumbURL,url,description,color,pt,pms,attr,graphic,fctyCd,gvmtCd;
		 
		 var values;
		
		 for (var idx = 0; idx < Object.keys(pData.listMapLocation).length;idx++) {   
	    		 
			    values = pData.mainEventSens[idx];
				name = values.fctyNm;
				thumbURL = values.url01;
				url = values.url02;
				description = values.fctyDesc;
				color = values.iconColor;	
				pt = esri.geometry.geographicToWebMercator(
					new esri.geometry.Point(
						[values.fctyLon,values.fctyLat],
						new esri.SpatialReference({ wkid:4326})) 
				);	
				fctyCd = values.fctyCd;
				gvmtCd = values.gvmtCd;
				
				if (iCnt > 11) {
					iCnt = 1;
				} else {
					iCnt = iCnt + 1;
				} 
				if (iCnt > 9) {
					pms = new esri.symbol.PictureMarkerSymbol("/img/common/ico_map"+(iCnt)+"_r.png",15,15);	
				} else {
					pms = new esri.symbol.PictureMarkerSymbol("/img/common/ico_map0"+(iCnt)+"_r.png",15,15);	
				}  
					
				pms.setOffset(3,8);
				attr = {name:name,thumbURL:thumbURL,url:url,description:description,color:color,fctyCd:fctyCd,gvmtCd:gvmtCd};
				graphic = new esri.Graphic(pt,pms,attr);		
		
				_arr.push(graphic); 
			
		     }
		
	 
	}
	
	parseCSV = function(text) { 
		var name,thumbURL,url,description,color,pt,pms,attr,graphic,fctyCd,gvmtCd;
		
		var lines = CSVToArray(text)
		var fields = lines[0];
		
		var values;
		
		for (var i = 1; i < lines.length; i++) {
			
			values = lines[i];
			if (values.length == 1) {
				break;
			}
	               
			name = values[fields.indexOf("Name")];
			thumbURL = values[fields.indexOf("Thumb_URL")];
			url = values[fields.indexOf("URL")];
			description = values[fields.indexOf("Description")];
			color = values[fields.indexOf("Icon_color")];	
			pt = esri.geometry.geographicToWebMercator(
				new esri.geometry.Point(
					[values[fields.indexOf("Long")],values[fields.indexOf("Lat")]],
					new esri.SpatialReference({ wkid:4326})) 
			);	
			fctyCd = values[fields.indexOf("fctyCd")];
			gvmtCd = values[fields.indexOf("gvmtCd")];
			  
			/*if (iCnt > 11) {
				iCnt = 1;
			} else {
				iCnt = iCnt + 1;
			}
			
			
			if (iCnt > 9) {
				if (color == 'B') 
					pms = new esri.symbol.PictureMarkerSymbol("/img/common/ico_map"+(iCnt)+".png",15,15);			
				else
					pms = new esri.symbol.PictureMarkerSymbol("/img/common/ico_map"+(iCnt)+".png",15,15);   //images/icons/red/NumberIcon
					
			} else {
				if (color == 'B') 
					pms = new esri.symbol.PictureMarkerSymbol("/img/common/ico_map0"+(iCnt)+".png",15,15);			
				else
					pms = new esri.symbol.PictureMarkerSymbol("/img/common/ico_map0"+(iCnt)+".png",15,15);   //images/icons/red/NumberIcon
					
			}   */
			
		
			// pms.setOffset(3,8);
			attr = {name:name,thumbURL:thumbURL,url:url,description:description,color:color,fctyCd:fctyCd,gvmtCd:gvmtCd};
			graphic = new esri.Graphic(pt,pms,attr);		
	
			_arr.push(graphic);
	
		}
		
	}
	
	
	// This will parse a delimited string into an array of
	// arrays. The default delimiter is the comma, but this
	// can be overriden in the second argument.
	// courtesy of Ben Nadel www.bennadel.com

	function CSVToArray( strData, strDelimiter ){
		// Check to see if the delimiter is defined. If not,
		// then default to comma.
		strDelimiter = (strDelimiter || ",");
		 
		// Create a regular expression to parse the CSV values.
		var objPattern = new RegExp(
		(
		// Delimiters.
		"(\\" + strDelimiter + "|\\r?\\n|\\r|^)" +
		 
		// Quoted fields.
		"(?:\"([^\"]*(?:\"\"[^\"]*)*)\"|" +
		 
		// Standard fields.
		"([^\"\\" + strDelimiter + "\\r\\n]*))"
		),
		"gi"
		);
		 
		 
		// Create an array to hold our data. Give the array
		// a default empty first row.
		var arrData = [[]];
		 
		// Create an array to hold our individual pattern
		// matching groups.
		var arrMatches = null;
		 
		 
		// Keep looping over the regular expression matches
		// until we can no longer find a match.
		while (arrMatches = objPattern.exec( strData )){
		 
		// Get the delimiter that was found.
		var strMatchedDelimiter = arrMatches[ 1 ];
		 
		// Check to see if the given delimiter has a length
		// (is not the start of string) and if it matches
		// field delimiter. If id does not, then we know
		// that this delimiter is a row delimiter.
		if (
		strMatchedDelimiter.length &&
		(strMatchedDelimiter != strDelimiter)
		){
		 
		// Since we have reached a new row of data,
		// add an empty row to our data array.
		arrData.push( [] );
		 
		}
		 
		 
		// Now that we have our delimiter out of the way,
		// let's check to see which kind of value we
		// captured (quoted or unquoted).
		if (arrMatches[ 2 ]){
		 
		// We found a quoted value. When we capture
		// this value, unescape any double quotes.
		var strMatchedValue = arrMatches[ 2 ].replace(
		new RegExp( "\"\"", "g" ),
		"\""
		);
		 
		} else {
		 
		// We found a non-quoted value.
		var strMatchedValue = arrMatches[ 3 ];
		 
		}
		 
		 
		// Now that we have our value string, let's add
		// it to the data array.
		arrData[ arrData.length - 1 ].push( strMatchedValue );
		}
		 
		// Return the parsed data.
		return( arrData );
	}
 	
}

