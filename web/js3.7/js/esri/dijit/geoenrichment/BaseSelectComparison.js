/*
 COPYRIGHT 2009 ESRI

 TRADE SECRETS: ESRI PROPRIETARY AND CONFIDENTIAL
 Unpublished material - all rights reserved under the
 Copyright Laws of the United States and applicable international
 laws, treaties, and conventions.

 For additional information, contact:
 Environmental Systems Research Institute, Inc.
 Attn: Contracts and Legal Services Department
 380 New York Street
 Redlands, California, 92373
 USA

 email: contracts@esri.com
 */
//>>built
define("esri/dijit/geoenrichment/BaseSelectComparison",["../../declare","./BaseWidget","dijit/form/Select","dojo/dom-class"],function(f,g,h,k){return f("esri.dijit.geoenrichment.BaseSelectComparison",[g],{updateUI:function(){this.inherited(arguments);this._state.selectedComparison=Math.min(this._state.selectedComparison||0,this.data.features.length-2)},updateUIExpanded:function(){this.inherited(arguments);if(this.select){for(var a=[],b=[],d=Math.max(this.data.features.length-1,0),c=0;c<d;c++){var e=
{label:this.getFeatureTitle(c+1),value:c.toString()};c>=this.select.options.length?a.push(e):b.push(e)}0<a.length&&this.select.addOption(a);for(0<b.length&&this.select.updateOption(b);this.select.options.length>d;)this.select.removeOption(this.select.options.length-1);this.select.set("value",this._state.selectedComparison.toString())}},_createComboBox:function(a){var b=this;k.add(a,"BaseSelectComparison_Select");this.select=new h({maxHeight:151,onChange:function(){var a=b._state.selectedComparison;
b._state.selectedComparison=+b.select.get("value");b._state.selectedComparison!=a&&b.updateUIExpanded()}});this.select.placeAt(a)},_getComparisonRow:function(){var a=this._state.selectedComparison;if(0<=a)return a+1},destroy:function(){this.select&&(this.select.destroy(),this.select=null);this.inherited(arguments)}})});