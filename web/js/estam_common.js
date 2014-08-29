

function tabContents(tabContainerID, tagName) {

	var tabContainer = document.getElementById(tabContainerID);

	var tabAnchor = tabContainer.getElementsByTagName(tagName);

	var i = 0;

	for(i=0; i<tabAnchor.length; i++) {

		if (tabAnchor.item(i).className == "tablist")

			thismenu = tabAnchor.item(i);

		else

			continue;

		thismenu.container = tabContainer;

		thismenu.targetEl = document.getElementById(tabAnchor.item(i).href.split("#")[1]);

		thismenu.targetEl.style.display = "none";

		thismenu.imgEl = thismenu.getElementsByTagName("img").item(0);

		thismenu.onclick = function tabMenuClick() {

			currentmenu = this.container.current;

			if (currentmenu == this)

				return false;

			if (currentmenu) {

				currentmenu.targetEl.style.display = "none";

				if (currentmenu.imgEl) {

					currentmenu.imgEl.src = currentmenu.imgEl.src.replace(/_on.png$/, ".png");

				} else {

					currentmenu.className = currentmenu.className.replace(" selected", "");

				}

			}

			this.targetEl.style.display = "";

			if (this.imgEl) {

				this.imgEl.src = this.imgEl.src.replace(/.png$/, "_on.png");

			} else {

				this.className += " selected";

			}

			this.container.current = this;

			return false;

		};

		if (!thismenu.container.first) thismenu.container.first = thismenu;

	}

	if (tabContainer.first)	tabContainer.first.onclick();

}



/* recent data scrole*/

function initMoving(target, position, topLimit, btmLimit) {

	    if (!target)

	        return false;



	    var obj = target;

	    obj.initTop = position;

	    obj.topLimit = topLimit;

	    obj.bottomLimit = document.documentElement.scrollHeight - btmLimit;



	    obj.style.position = "absolute";

	    obj.top = obj.initTop;

	    obj.left = obj.initLeft;



	    if (typeof(window.pageYOffset) == "number") {

	        obj.getTop = function() {

	            return window.pageYOffset;

	        }

	    } else if (typeof(document.documentElement.scrollTop) == "number") {

	        obj.getTop = function() {

	            return document.documentElement.scrollTop;

	        }

	    } else {

	        obj.getTop = function() {

	            return 0;

	        }

	    }



	    if (self.innerHeight) {

	    	obj.getHeight = function() {

	            return self.innerHeight;

	        }

	    } else if(document.documentElement.clientHeight) {

	        obj.getHeight = function() {

            return document.documentElement.clientHeight;

	        }

	    } else {

	        obj.getHeight = function() {

	            return 500;

	        }

	    }



	    obj.move = setInterval(function() {

	        if (obj.initTop > 0) {

	            pos = obj.getTop() + obj.initTop;

	        } else {

	            pos = obj.getTop() + obj.getHeight() + obj.initTop;

	            pos = obj.getTop() + obj.getHeight() / 2 - 15;

	        }



	        if (pos > obj.bottomLimit)

	            pos = obj.bottomLimit;

	        if (pos < obj.topLimit)

	            pos = obj.topLimit;



	        interval = obj.top - pos;

	        obj.top = obj.top - interval / 3;

	        obj.style.top = obj.top + "px";

	    }, 30)

	}



// GNB



function gnbNavi() {



	var gnbNavi = document.getElementById("gnb");



	subMenu = gnbNavi.getElementsByTagName("ul");



	for (i=0; i<subMenu.length; i++) {



		subMenu[i].style.display = "none";







		subLink = subMenu[i].getElementsByTagName("a");



		for (m=0; m<subLink.length; m++) {



			thismenu = subLink[m];



			thismenu.onmouseover = function() {



				subImage = this.getElementsByTagName("img")[0];



				if (subImage.src.indexOf("_on.png") != -1) return false;



				subImage.src = subImage.src.replace(".png","_on.png");



			}



			subLink[m].onfocus = function() {



				subImage = this.getElementsByTagName("img")[0];



				if (subImage.src.indexOf("_on.png") != -1) return false;



				subImage.src = subImage.src.replace(".png","_on.png");



			}



			subLink[m].onmouseout = function() {



				subImage = this.getElementsByTagName("img")[0];



				subImage.src = subImage.src.replace("_on.png",".png");



			}



			subLink[m].onblur = function() {



				subImage = this.getElementsByTagName("img")[0];



				subImage.src = subImage.src.replace("_on.png",".png");



			}



		}



	}







	var gnbmenu = gnbNavi.getElementsByTagName("li");



	for (j=0; j<gnbmenu.length; j++) {



		if (gnbmenu[j].className == "gnb_menu") {



			thismenu = gnbmenu[j].getElementsByTagName("a")[0];



			thismenu.onmouseover = function() {



				subMenu = gnbNavi.getElementsByTagName("ul");



				for (k=0; k<subMenu.length; k++) {



					subMenu[k].style.display = "none";



					subMenu[k].parentNode.style.zIndex = "0";



				}







				gnbImg = gnbNavi.getElementsByTagName("img");



				for (l=0; l<gnbImg.length; l++) {



					if (gnbImg[l].src.indexOf("_on.png") != -1 ){



						gnbImg[l].src = gnbImg[l].src.replace("_on.png",".png");



					}



				}







				this.getElementsByTagName("img")[0].src = this.getElementsByTagName("img")[0].src.replace(".png","_on.png");



				if (!this.parentNode.getElementsByTagName("ul")[0]) return false;



				this.parentNode.getElementsByTagName("ul")[0].style.display = "";



				this.parentNode.getElementsByTagName("ul")[0].parentNode.style.zIndex = "1";







			}



			thismenu.onfocus = function() {



				subMenu = gnbNavi.getElementsByTagName("ul");



				for (k=0; k<subMenu.length; k++) {



					subMenu[k].style.display = "none";



					subMenu[k].parentNode.style.zIndex = "0";



				}







				gnbImg = gnbNavi.getElementsByTagName("img");



				for (l=0; l<gnbImg.length; l++) {



					if (gnbImg[l].src.indexOf("_on.png") != -1 ){



						gnbImg[l].src = gnbImg[l].src.replace("_on.png",".png");



					}



				}




			
				this.getElementsByTagName("img")[0].src = this.getElementsByTagName("img")[0].src.replace(".png","_on.png");



				if (!this.parentNode.getElementsByTagName("ul")[0]) return false;



				this.parentNode.getElementsByTagName("ul")[0].style.display = "";



				this.parentNode.getElementsByTagName("ul")[0].parentNode.style.zIndex = "1";



			}



		}



	}







}



// family site

function familysite(familyID) {

	var title = document.getElementById(familyID).getElementsByTagName('h4')[0].getElementsByTagName('a')[0];

	var family_list = document.getElementById('family_list');

	family_list.style.display = "none";



	var option = family_list.getElementsByTagName('a');

	title.onclick = function() {

		if (family_list.style.display == "block") {

			family_list.style.display = "none";

		} else {

			family_list.style.display = "block";

		}

		this.onmouseout = function(){

			family_list.style.display = "none";

		}

		return false;

	}

	family_list.onmouseover = function(){

		this.style.display = "block";

	}

	family_list.onmouseout = function(){

		this.style.display = "none";

	}

	for (i=0; i < option.length; i++){

		option[i].onfocus = function(){

			family_list.style.display = "block";

		}

		option[option.length-1].onblur = function(){

			family_list.style.display = "none";

		}

	}

}






// search select

function search_option () {

	var title = document.getElementById('search_value');

	var value = title.childNodes[0].nodeValue;

	var list = document.getElementById('option_list');

	var list_option = list.getElementsByTagName('a');

	title.onclick = function () {

		list.style.display = "block";

		return false; 

	}

	list.onmouseover = function() {

		this.style.display = "block";

	}

	list.onmouseout = function() {

		this.style.display = "none";

	}

	for (i=0; i < list_option.length; i++) {

		list_option[i].onclick = function () {

			title.childNodes[0].nodeValue = this.childNodes[0].nodeValue;

			list.style.display = "none";

			return false;

		}

	}

}



/*  gnb snb control */
function curh(obj){
	var list = obj.parentNode.parentNode.getElementsByTagName('li');

	for(var i=0; i<list.length; i++){
		if(list[i].getElementsByTagName('img')[0]&&list[i].getElementsByTagName('img')[0].src.slice(-5,-4)=='_'){
			list[i].getElementsByTagName('img')[0].src=list[i].getElementsByTagName('img')[0].src.slice(0,-5)+'.png';
		}
	}
	if(obj.getElementsByTagName('img')[0]&&obj.getElementsByTagName('img')[0].src.slice(-5,-4)!='_'){
		obj.getElementsByTagName('img')[0].src=obj.getElementsByTagName('img')[0].src.slice(0,-4)+'_.png';
	}
}

function cur(obj){
	if (obj.href.indexOf("#") != -1) {
		curh(obj);
		if(obj.parentNode.parentNode.getElementsByTagName('ul').length>0){
		for(var i=0; i<obj.parentNode.parentNode.getElementsByTagName('ul').length; i++){
			obj.parentNode.parentNode.getElementsByTagName('ul')[i].style.display='none';
			}
		}
		if(obj.parentNode.getElementsByTagName('ul').length>0){
			obj.parentNode.getElementsByTagName('ul')[0].style.display='block';
		}
	}
}

function curtop(obj){
	curh(obj);
	if(obj.parentNode.parentNode.getElementsByTagName('ul').length>0){
	for(var i=0; i<obj.parentNode.parentNode.getElementsByTagName('ul').length; i++){
		obj.parentNode.parentNode.getElementsByTagName('ul')[i].style.display='none';
		}
	}
	if(obj.parentNode.getElementsByTagName('ul').length>0){
		obj.parentNode.getElementsByTagName('ul')[0].style.display='block';
	}
}

function intlevelsmenu(){
	if(document.getElementById('levels')){
		for(var i=0; i<document.getElementById('levels').getElementsByTagName('a').length; i++){
			document.getElementById('levels').getElementsByTagName('a')[i].onclick=function(){
				if (this.href.indexOf("#") != -1)
				{
					cur(this);
					return false;
				}
				else {
					location.href=this.href;
				}
			};
			document.getElementById('levels').getElementsByTagName('a')[i].onfocus=function(){
				curh(this);
				cur(this);
			};
			document.getElementById('levels').getElementsByTagName('a')[i].onmouseover=function(){
				curh(this);

			};
		}
	}
}


function initNavigation(seq) {

	var nav = document.getElementById("topmenu");

	nav.menu = new Array();

	nav.current = null;

	nav.menuseq = 0;

	navLen = nav.childNodes.length;

	

	allA = nav.getElementsByTagName("a");

	for(k = 0; k < allA.length; k++) {



		allA.item(k).onmouseover = allA.item(k).onfocus = function () {

			nav.isOver = true;

		}

		allA.item(k).onmouseout = allA.item(k).onblur = function () {

			nav.isOver = false;

			//alert(event.button);

			setTimeout(function () {

				if (nav.isOver == false) {

					if (nav.menu[seq]) {

						nav.menu[seq].onmouseover();	

					} else if(nav.current) {			

						if( seq != 0)

						this.current.parentNode.className = this.current.parentNode.className.replace(" over","");						

						if (nav.current.submenu)						

							nav.current.submenu.style.display = "none";

						nav.current = null;					

					}

				}

			}, 500);

		}

	}



	for (i = 0; i < navLen; i++) {

		navItem = nav.childNodes.item(i);

		if (navItem.tagName != "LI")

			continue;



		navAnchor = navItem.getElementsByTagName("a").item(0);

		navAnchor.submenu = navItem.getElementsByTagName("div").item(0);

		

		navAnchor.onmouseover = navAnchor.onfocus = function () {

			if (nav.current) {		

				if( seq !=0)

				nav.current.parentNode.className = nav.current.parentNode.className.replace(" over","");			

				if (nav.current.submenu)				

					nav.current.submenu.style.display = "none";

				nav.current = null;

			}

			

			if (nav.current != this) {

				if( seq !=0)

		this.submenu.parentNode.className +=" over";			

				if (this.submenu)		{						

					this.submenu.style.display = "block";

				}

				nav.current = this;

			}

			nav.isOver = true;

		}

		nav.menuseq++;

		nav.menu[nav.menuseq] = navAnchor;

	}

	if (nav.menu[seq])

		nav.menu[seq].onmouseover();

}

 


function rollOverImg(elId, tagName) {

	var el = document.getElementById(elId).getElementsByTagName(tagName);

	for (i=0; i<el.length; i++) {

		  if (el[i].src.substring(el[i].src.indexOf(".png"))

				||el[i].src.substring(el[i].src.indexOf("_on.png"))) {

				el[i].onmouseover = changeOver;
				

				el[i].parentNode.onfocus = changeFocus;

				el[i].onmouseout = changeOut;

		}

	}

}

function changeOver() {

	this.src=this.src.replace(".png", "_on.png");
	

}

function changeOut() {

  this.src=this.src.replace("_on.png", ".png");

}

function changeFocus() {

  this.childNodes[0].src=this.childNodes[0].src.replace("_on.png", ".png");

}

/* footer rotate banner */



function ImageRotation() {

	// options

	// var scrollType = 'vertical'; // 'horizontal', 'vertical', 'none';



	// private

	var currentNumber = 0;

	var objWrap = null;

	var objContentBox = null;

	var objWrapLIs = null;

	var cellWidth = 0;

	var cellHeight = 0;

	this.GoodsSetTime = null;



	// scroll animation variables.

	var scroll = {time:1, start:0, change:0, duration:25, timer:null};

	var originaltime = scroll.time;



	this.setScrollType = function (type) {

		switch (type) {

			case 'vertical':

			case 'horizontal':

			case 'none':

				scrollType = type;

				break;

			default:

				alert('!');

				break;

		}

	}

	// constructor

	this.initialize = function () {

		objWrap = document.getElementById(this.wrapId);

		objContentBox = document.getElementById(this.listId);

		objWrapLIs = objWrap.getElementsByTagName('li');

		cellWidth = objWrapLIs[0].offsetWidth;

		cellHeight= objWrapLIs[0].offsetHeight;



		switch (scrollType) {

			case 'vertical':

				this.objWrapSize = objWrap.offsetHeight;

				this.objSize = objWrapLIs.length * cellHeight;

				break;

			case 'none':

				this.objWrapSize = objWrap.offsetWidth;

				this.objSize = objWrapLIs.length * cellWidth;

				break;

			default:

				this.objWrapSize = objWrap.offsetWidth;

				this.objSize = objWrapLIs.length * cellWidth;

				break;

		}

		//alert(this.objWrapSize +' / '+ this.objSize);

		if (this.objWrapSize <= this.objSize) {



			if (objWrapLIs.length > 0) {

				switch (scrollType) {

					case 'vertical':

						objContentBox.style.height = objWrapLIs.length * cellHeight + 'px';

						break;

					case 'none':

						objContentBox.style.width = objWrapLIs.length * cellWidth + 'px';

						break;

					default:

						objContentBox.style.width = objWrapLIs.length * cellWidth + 'px';

						break;

				}

			}

			document.getElementById(this.btnPrev).href = "javascript:" + this.objName + ".prev();";

			document.getElementById(this.btnNext).href = "javascript:" + this.objName + ".next();";



			if (this.autoScroll == 'none') {

			} else {

				if (this.scrollDirection == 'direction') {

					this.GoodsSetTime = setInterval(this.objName + ".next()", this.scrollGap);

				} else {

					this.GoodsSetTime = setInterval(this.objName + ".prev()", this.scrollGap);

				}

			}

		} else {

			document.getElementById(this.btnPrev).href = "javascript:" + this.objName + ".none();";

			document.getElementById(this.btnNext).href = "javascript:" + this.objName + ".none();";

		}

	}

	this.none = function() {

		return;

	}



	this.prev = function () {

		if (currentNumber == 0) {

			var objLastNode = objContentBox.removeChild(objContentBox.getElementsByTagName('li').item(objWrapLIs.length - 1));

			objContentBox.insertBefore(objLastNode, objContentBox.getElementsByTagName('li').item(0));

			switch (scrollType) {

				case 'vertical':

					objWrap.scrollTop += cellHeight;

					break;

				case 'none':

					objWrap.scrollLeft += cellWidth;

					break;

				default:

					objWrap.scrollLeft += cellWidth;

					break;

			}



			currentNumber++;

		}



		//objWrap.scrollLeft -= cellWidth;

		var position = getActionPoint('indirect');

		//console.log('start x:' + position.start +', change x:' + position.end);

		startScroll(position.start, position.end);



		currentNumber = currentNumber - 1;

		//console.log(currentNumber);



		if (currentNumber > 0)

			currentNumber = 0;

		if (this.autoScroll == 'none') {

		} else {

			this.scrollDirection = 'indirection';

			clearInterval(this.GoodsSetTime);

			this.GoodsSetTime = setInterval(this.objName + ".prev()", this.scrollGap);

		}

	}



	this.next = function () {

		if (currentNumber == objWrapLIs.length - 1) {

			var objLastNode = objContentBox.removeChild(objContentBox.getElementsByTagName('li').item(0));

			objContentBox.appendChild(objLastNode);

			switch (scrollType) {

				case 'vertical':

					objWrap.scrollTop -= cellHeight;

					break;

				case 'none':

					objWrap.scrollLeft -= cellWidth;

					break;

				default:

					objWrap.scrollLeft -= cellWidth;

					break;

			}

			currentNumber--;

		}



		//objWrap.scrollLeft += cellWidth;

		var position = getActionPoint('direct');

		//console.log('start x:' + position.start +', change x:' + position.end);

		startScroll(position.start, position.end);



		currentNumber = currentNumber + 1;



		if (currentNumber < objWrapLIs.length - 1)

			currentNumber = objWrapLIs.length - 1;

		//console.log(currentNumber);



		if (this.autoScroll == 'none') {

		} else {

			this.scrollDirection = 'indirection';

			clearInterval(this.GoodsSetTime);

			this.GoodsSetTime = setInterval(this.objName + ".next()", this.scrollGap);

		}

	}



	var startScroll = function (start, end) {

		if (scroll.timer != null) {

			clearInterval(scroll.timer);

			scroll.timer = null;

		}



		scroll.start = start;

		scroll.change = end - start;



		switch (scrollType) {

			case 'vertical':

				scroll.timer = setInterval(scrollVertical, 15);

				break;

			case 'none':

				objWrap.scrollLeft = end;

				break;

			default:

				scroll.timer = setInterval(scrollHorizontal, 15);

				break;

		}

	}



	var scrollVertical = function () {

		if (scroll.time > scroll.duration) {

			clearInterval(scroll.timer);

			scroll.time = originaltime;

			scroll.timer = null;

		}

		else {

			objWrap.scrollTop = sineInOut(scroll.time, scroll.start, scroll.change, scroll.duration);

			scroll.time++;

		}

	}



	var scrollHorizontal = function () {

		if (scroll.time > scroll.duration) {

			clearInterval(scroll.timer);

			scroll.time = originaltime;

			scroll.timer = null;

		} else {

			objWrap.scrollLeft = sineInOut(scroll.time, scroll.start, scroll.change, scroll.duration);

			scroll.time++;

		}

	}



	var getActionPoint = function (dir) {

		if (dir == 'direct') {

			var position = findElementPos(objWrap.getElementsByTagName('li').item(currentNumber + 1)); // target image.

			var offsetPos = findElementPos(objWrap.getElementsByTagName('li').item(currentNumber)); // first image.

		} else {

			var position = findElementPos(objWrap.getElementsByTagName('li').item(currentNumber - 1)); // target image.

			var offsetPos = findElementPos(objWrap.getElementsByTagName('li').item(currentNumber)); // first image.

		}



		//console.log('current(' + offsetPos[0] + ',' + offsetPos[1] + '), target(' + position[0] + ',' + position[1] + ')');



		switch (scrollType) {

			case 'vertical':

				var start = objWrap.scrollTop;

				var end = position[1] - offsetPos[1];

				break;

			case 'none':

				// do nothing.

				break;

			default:

				var start =  objWrap.scrollLeft;

				var end = position[0] - offsetPos[0];

				break;

		}

		//console.log(scrollType);



		var position = {start:0, end:0};

		position.start = start;

		position.end = end;



		return position;

	}



	var sineInOut = function (t, b, c, d) {

		return -c/2 * (Math.cos(Math.PI*t/d) - 1) + b;

	}



	var findElementPos = function (elemFind) {

		var elemX = 0;

		var elemY = 0;

		do {

			elemX += elemFind.offsetLeft;

			elemY += elemFind.offsetTop;

		} while (elemFind = elemFind.offsetParent)



		return Array(elemX, elemY);

	}



}

/* 화면 확대 축소 시작 IE 전용 */
 var nowZoom = 100; // 현재비율
 var maxZoom = 140; // 최대비율(500으로하면 5배 커진다)
 var minZoom = 100; // 최소비율

 

 //화면 키운다.
 function zoomIn() {
  if (nowZoom < maxZoom) {
   nowZoom += 10; //25%씩 커진다.
  } else {
   return;
  }

   document.getElementById("wrap").style.zoom = nowZoom + "%";
 }


 //화면 줄인다.
 function zoomOut() {
  if (nowZoom > minZoom) {
   nowZoom -= 10; //25%씩 작아진다.
  } else {
   return;
  }

   document.getElementById("wrap").style.zoom = nowZoom + "%";
 }

	
/* $(document).ready(function(){
if (jQuery.browser.msie === true) {
	jQuery('.inputborder')
			.bind('focus', function() {
					$(this).addClass('ieFocusHack');
			}).bind('blur', function() {
					$(this).removeClass('ieFocusHack');
			});
}

}); */