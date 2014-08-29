//>>built
define("dgrid/selector","dojo/_base/kernel dojo/_base/array dojo/_base/lang dojo/on dojo/aspect dojo/_base/sniff put-selector/put".split(" "),function(u,v,n,x,p,w,q){n.getObject("dgrid.selector",!0);return dgrid.selector=function(b,e){function r(d){return function(c){var g=c.rows,f=g.length;c="false";var e;for(e=0;e<f;e++){var h=a.cell(g[e],b.id).element;h&&(h=(h.contents||h).input,h.disabled||(h.checked=d,h.setAttribute("aria-checked",d)))}if("checkbox"==k.type){g=a.selection;f=!1;for(e in g)if(g[e]!=
a.allSelected){f=!0;break}k.indeterminate=f;k.checked=a.allSelected;f?c="mixed":a.allSelected&&(c="true");k.setAttribute("aria-checked",c)}}}function n(d){if("click"==d.type||32==d.keyCode||!w("opera")&&13==d.keyCode||0===d.keyCode){var c=a.row(d),b=a._lastSelected&&a.row(a._lastSelected);a._selectionTriggerEvent=d;if("radio"==e){if(!b||b.id!=c.id)a.clearSelection(),a.select(c,null,!0),a._lastSelected=c.element}else c?(d.shiftKey?r(!0)({rows:[c]}):b=null,b=d.shiftKey?b:null,a.select(b||c,c,b?void 0:
null),a._lastSelected=c.element):(q(this,(a.allSelected?"!":".")+"dgrid-select-all"),a[a.allSelected?"clearSelection":"selectAll"]());a._selectionTriggerEvent=null}}function s(){a._hasSelectorInputListener=!0;l.push(p.before(a,"_initSelectionEvents",function(){this.on(".dgrid-selector:click,.dgrid-selector:keydown",n)}));var d=a._handleSelect;a._handleSelect=function(a){this.cell(a).column!=b&&d.apply(this,arguments)};if("function"==typeof b.disabled){var c=a.allowSelect;a.allowSelect=function(a){return c.call(this,
a)&&!b.disabled(a.data)}}l.push(a.on("dgrid-select",r(!0)));l.push(a.on("dgrid-deselect",r(!1)))}var l=[],a,k;b||(b={});b.type&&(b.selectorType=b.type,u.deprecated("columndef.type","use columndef.selectorType instead","dgrid 1.0"));b.selectorType=e=e||b.selectorType||"checkbox";b.sortable=!1;var m=b.disabled,t="function"==typeof e?e:function(d,c,g){var f=c.parentNode;q(f&&f.contents?f:c,".dgrid-selector");c=c.input||(c.input=q(c,"input[type\x3d"+e+"]",{tabIndex:isNaN(b.tabIndex)?-1:b.tabIndex,disabled:m&&
("function"==typeof m?m(g):m),checked:d}));c.setAttribute("aria-checked",!!d);a._hasSelectorInputListener||s();return c};p.after(b,"init",function(){a=b.grid});p.after(b,"destroy",function(){v.forEach(l,function(a){a.remove()});a._hasSelectorInputListener=!1});b.renderCell=function(b,c,e,f,k){c=(c=b&&a.row(b))&&a.selection[c.id];t(c,e,b)};b.renderHeaderCell=function(d){var c=b.label||b.field||"";"radio"==e||!a.allowSelectAll?(d.appendChild(document.createTextNode(c)),a._hasSelectorInputListener||
s()):t(!1,d,{});k=d.lastChild};return b}});