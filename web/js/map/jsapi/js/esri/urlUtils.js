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
define("esri/urlUtils",["dojo/_base/lang","dojo/_base/array","dojo/_base/url","dojo/io-query","esri/kernel","esri/config","esri/sniff"],function(_1,_2,_3,_4,_5,_6,_7){var _8={},_9=_6.defaults.io;_8.urlToObject=function(_a){var iq=_a.indexOf("?");if(iq===-1){return {path:_a,query:null};}else{return {path:_a.substring(0,iq),query:_4.queryToObject(_a.substring(iq+1))};}};_8.getProxyUrl=function(_b,_c){var _d=_1.isString(_b)?(_1.trim(_b).toLowerCase().indexOf("https:")===0):_b,_e=_9.proxyUrl,_f,_10,_11,_12,_13="esri.config.defaults.io.proxyUrl is not set.";if(_1.isString(_b)){_12=_8.getProxyRule(_b);if(_12){_e=_12.proxyUrl;}}if(!_e){console.log(_13);throw new Error(_13);}if(_d&&_c!==false&&window.location.href.toLowerCase().indexOf("https:")!==0){_10=_e;if(_10.toLowerCase().indexOf("http")!==0){_10=_8.getAbsoluteUrl(_10);}_10=_10.replace(/^http:/i,"https:");if(_8.canUseXhr(_10)){_e=_10;_11=1;}}_f=_8.urlToObject(_e);_f._xo=_11;return _f;};_8.addProxy=function(url){var _14=_8.getProxyRule(url),_15,_16,_17;if(_14){_15=_8.urlToObject(_14.proxyUrl);}else{if(_9.alwaysUseProxy){_15=_8.getProxyUrl();}}if(_15){_16=_8.urlToObject(url);url=_15.path+"?"+_16.path;_17=_4.objectToQuery(_1.mixin(_15.query||{},_16.query));if(_17){url+=("?"+_17);}}return url;};_8.addProxyRule=function(_18){var _19=_18.urlPrefix=(_8.urlToObject(_18.urlPrefix).path).replace(/([^\/])$/,"$1/").replace(/^https?:\/\//ig,"").toLowerCase(),_1a=_9.proxyRules,i,len=_1a.length,_1b,_1c=len;for(i=0;i<len;i++){_1b=_1a[i].urlPrefix;if(_19.indexOf(_1b)===0){if(_19.length===_1b){return -1;}else{_1c=i;break;}}else{if(_1b.indexOf(_19)===0){_1c=i+1;}}}_1a.splice(_1c,0,_18);return _1c;};_8.getProxyRule=function(url){var _1d=_9.proxyRules,i,len=_1d.length,_1e=(_8.urlToObject(url).path).replace(/([^\/])$/,"$1/").replace(/^https?:\/\//ig,"").toLowerCase(),_1f;for(i=0;i<len;i++){if(_1e.indexOf(_1d[i].urlPrefix)===0){_1f=_1d[i];break;}}return _1f;};_8.hasSameOrigin=function(_20,_21,_22){_20=_20.toLowerCase();_21=_21.toLowerCase();var _23=window.location.href.toLowerCase();_20=_20.indexOf("http")===0?new _3(_20):(_23=new _3(_23));_21=_21.indexOf("http")===0?new _3(_21):(_1.isString(_23)?new _3(_23):_23);return ((_22||(_20.scheme===_21.scheme))&&_20.host===_21.host&&_20.port===_21.port);};_8.canUseXhr=function(url,_24){var _25=false,_26=_8.hasSameOrigin,_27=_9.corsEnabledServers,_28,_29=-1;if(_7("esri-cors")&&_27&&_27.length){_25=_2.some(_27,function(_2a,idx){_28=(_1.trim(_2a).toLowerCase().indexOf("http")!==0);if(_26(url,_28?("http://"+_2a):_2a)||(_28&&_26(url,"https://"+_2a))){_29=idx;return true;}return false;});}return _24?_29:_25;};_8.getAbsoluteUrl=function(url){if(_1.isString(url)&&url.indexOf("http://")===-1&&url.indexOf("https://")===-1){if(url.indexOf("//")===0){return window.location.protocol+url;}else{if(url.indexOf("/")===0){return window.location.protocol+"//"+window.location.host+url;}else{return _5._appBaseUrl+url;}}}return url;};if(_7("extend-esri")){_1.mixin(_5,_8);_5._getProxyUrl=_8.getProxyUrl;_5._getProxiedUrl=_8.addProxy;_5._hasSameOrigin=_8.hasSameOrigin;_5._canDoXOXHR=_8.canUseXhr;_5._getAbsoluteUrl=_8.getAbsoluteUrl;}return _8;});