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
define("esri/dijit/editing/tools/Union","dojo/_base/declare dojo/_base/lang dojo/_base/array dojo/has esri/graphicsUtils esri/graphic esri/toolbars/draw esri/dijit/editing/Union esri/dijit/editing/tools/ButtonToolBase esri/kernel".split(" "),function(a,b,d,h,l,m,e,n,p,q){a=a([p],{declaredClass:"esri.dijit.editing.tools.Union",id:"btnFeatureUnion",_enabledIcon:"toolbarIcon unionIcon",_disabledIcon:"toolbarIcon unionIcon",_drawType:e.POLYLINE,_enabled:!0,_label:"NLS_unionLbl",_onClick:function(a){this._settings.editor._activeTool=
"UNION";a=d.filter(this._settings.layers,function(a){return"esriGeometryPolygon"===a.geometryType&&a.visible&&a._isMapAtVisibleScale()});var k=[],f=0;d.forEach(a,function(a,h){var c=a.getSelectedFeatures();if(2<=c.length){f++;var e=d.map(c,function(a){return new m(b.clone(a.toJson()))});this._settings.geometryService.union(l.getGeometries(c),b.hitch(this,function(g){g=[c.pop().setGeometry(g)];k.push({layer:a,updates:g,deletes:c,preUpdates:e});f--;if(0>=f)this.onApplyEdits(k,b.hitch(this,function(){if(this._settings.undoRedoManager){var a=
this._settings.undoRedoManager;d.forEach(this._edits,b.hitch(this,function(b){a.add(new n({featureLayer:b.layer,addedGraphics:b.deletes,preUpdatedGraphics:b.preUpdates,postUpdatedGraphics:b.updates}))}),this)}this._settings.editor._selectionHelper.clearSelection(!1);this.onFinished()}))}))}},this)}});h("extend-esri")&&b.setObject("dijit.editing.tools.Union",a,q);return a});