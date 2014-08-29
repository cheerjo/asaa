/* Copyright � 2002 Jean-Claude Manoli [jc@manoli.net]
 *
 * This software is provided 'as-is', without any express or implied warranty.
 * In no event will the author(s) be held liable for any damages arising from
 * the use of this software.
 * 
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 * 
 *   1. The origin of this software must not be misrepresented; you must not
 *      claim that you wrote the original software. If you use this software
 *      in a product, an acknowledgment in the product documentation would be
 *      appreciated but is not required.
 * 
 *   2. Altered source versions must be plainly marked as such, and must not
 *      be misrepresented as being the original software.
 * 
 *   3. This notice may not be removed or altered from any source distribution.
 */ 

// Changes - 
// RWC: 2005-04-01 - Fix image pre-load section. Last line had typo causing some images not to load
// RWC: 2005-05-21 - Some work fixing TOC Sync
//

var treeSelected = null; //last treeNode clicked

//pre-load tree nodes images
var imgPlus = new Image();
imgPlus.src="../graphics/treenodeplus.gif";
var imgMinus = new Image();
imgMinus.src="../graphics/treenodeminus.gif";
var imgDot = new Image();
imgDot.src="../graphics/treenodedot.gif";    //rwc - fixed. Was... imgPlus.src="treenodedot.gif";


function findNode(el)
{
// Takes element and determines if it is a treeNode.
// If not, seeks a treeNode in its parents.
	while (el != null)
	{
		if (el.className == "treeNode")
		{
			break;
		}
		else
		{
			el = el.parentNode;
		}
	}
	return el;
}


function clickAnchor(el)
{
// handles click on a TOC link
//
	expandNode(el.parentNode);
	selectNode(el.parentNode);
	el.blur();
}


function selectNode(el)
{
// Un-selects currently selected node, if any, and selects the specified node
//
	if (treeSelected != null)
	{
		setSubNodeClass(treeSelected, 'A', 'treeUnselected');
	}
	setSubNodeClass(el, 'A', 'treeSelected');
	treeSelected = el;
}


function setSubNodeClass(el, nodeName, className)
{
// Sets the specified class name on el's first child that is a nodeName element
//
	var child;
	for (var i=0; i < el.childNodes.length; i++)
	{
		child = el.childNodes[i];
		if (child.nodeName == nodeName)
		{
			child.className = className;
			break;
		}
	}
}


function expandCollapse(el)
{
//	If source treeNode has child nodes, expand or collapse view of treeNode
//
	if (el == null)
		return;	//Do nothing if it isn't a treeNode
		
	var child;
	var imgEl;
	for(var i=0; i < el.childNodes.length; i++)
	{
		child = el.childNodes[i];
		if (child.src)
		{
			imgEl = child;
		}
		else if (child.className == "treeSubnodesHidden")
		{ 
      // open the book
			child.className = "treeSubnodes";
			imgEl.src = "../graphics/treenodeminus.gif";
      
      // show the overview page for books of samples
      // added by Derek Swingley, Dec. 8, 2011
      var hrefPieces = window.location.href.split("/");
      if ( hrefPieces[hrefPieces.length - 1] == "jssamples_toc.htm" ) {
        loadBookOverview(el);
      }

			break;
		}
		else if (child.className == "treeSubnodes")
		{
      // close the book
			child.className = "treeSubnodesHidden";
			imgEl.src = "../graphics/treenodeplus.gif";
			break;
		}
	}

}


function expandNode(el)
{
//	If source treeNode has child nodes, expand it
//
	var child;
	var imgEl;
	for(var i=0; i < el.childNodes.length; i++)
	{
		child = el.childNodes[i];
		if (child.src)
		{
			imgEl = child;
		}
		if (child.className == "treeSubnodesHidden")
		{
			child.className = "treeSubnodes";
			imgEl.src = "../graphics/treenodeminus.gif";
			break;
		}
	}
}


function syncTree(href)
{
// Selects and scrolls into view the node that references the specified URL
//
	var loc = new String();
	loc = href;

        //RWC 2005-05-21 - This is the real URL base of the TOC
        var gbase = location.href;
        if (gbase.substring(0, 7) == 'file://')
          gbase = 'file:///' + gbase.substring(7, gbase.length);
        gbase = gbase.replace(/\\/g, '/');
        gbase = gbase.substr(0, gbase.lastIndexOf('/') + 1);


	if (loc.substring(0, 7) == 'file://')
	{
		loc = 'file:///' + loc.substring(7, loc.length);
		loc = loc.replace(/\\/g, '/');
	}

	loc = encodeURI(loc); //encode as valid URI

        //RWC 2005-05-21 - properly Scrub URL of encoding
        loc = unescape(loc);  //Converts %2520 -> %20  (under FireFox)
        loc = unescape(loc);  //Converts %20 = ' '

        //RWC 2005-05-21- remove	var base = loc.substr(0, loc.lastIndexOf('/') + 1);
	var tocEl = findHref(document.getElementById('treeRoot'), loc, gbase);
	if (tocEl != null)
	{

		selectAndShowNode(tocEl);
	}
}

function findHref(node, href, base)
{
// find the <a> element with the specified href value
//
        //RWC 24/3/2006: Consider any bookmark on the URL to test
        var href_BaseURL = '';
        var iBookmark = href.indexOf('#');
        if (iBookmark > 0)
          href_BaseURL = href.substr(0, iBookmark);


	var el;
	var anchors = node.getElementsByTagName('A');
	for (var i = 0; i < anchors.length; i++)
	{
		el = anchors[i];
		var aref = new String();
		aref = el.getAttribute('href');
		
		if ((aref.substring(0, 7) != 'http://') 
			&& (aref.substring(0, 8) != 'https://')
			&& (aref.substring(0, 7) != 'file://'))
		{
			aref = base + aref;
		}

                //RWC: Scrub embedded codes 
                aref = unescape(aref);
                //alert(aref + ', ' + href);

                //RWC: If href has #bookmark and aref does not then compare without bookmarks
                if ((href_BaseURL.length > 0) && (aref.indexOf('#') < 0))
                  if (aref == href_BaseURL)
                     return el;

		if (aref == href)
		{
			return el;
		}
	}
	return null;
}

function selectAndShowNode(node)
{
// Selects and scrolls into view the specified node
//
	var el = findNode(node);
	if (el != null) 
	{
		selectNode(el);
		do 
		{
			expandNode(el);
			el = findNode(el.parentNode);
		} while ((el != null))  
		
		//vertical scroll element into view
		var windowTop;
		var windowBottom;
		var treeDiv = document.getElementById('tree');
		
		var ua = window.navigator.userAgent.toLowerCase();
		if ((i = ua.indexOf('msie')) != -1)
		{
			windowTop = node.offsetTop - treeDiv.scrollTop;
			windowBottom = treeDiv.clientHeight - windowTop - node.offsetHeight;
		}
		else if (ua.indexOf('gecko') != -1)
		{
			windowTop = node.offsetTop - treeDiv.offsetTop - treeDiv.scrollTop;
			windowBottom = treeDiv.clientHeight - windowTop - node.offsetHeight;
		}
		else 
		{
			return;
		}
		
		if (windowTop < 0)
		{
			treeDiv.scrollTop += windowTop - 18;
			return;
		}
		if (windowBottom < 0)
		{
			treeDiv.scrollTop -= windowBottom - 18;
			return;
		}
	}
}


function resizeTree()
{
	var treeDiv = document.getElementById('tree');
	//treeDiv.setAttribute('style', 'width: ' + document.body.offsetWidth + 'px; height: ' + (document.body.offsetHeight - 27) + 'px;');
	treeDiv.style.width = document.documentElement.offsetWidth;
	treeDiv.style.height = document.documentElement.offsetHeight - 27;
}

// load the overview page for the book that was clicked
// added by Derek Swingley, Dec. 8, 2011
function loadBookOverview(el) {
  var spanNodes, bookName, bookNameLower, overviewName, whiteList;
  spanNodes = el.getElementsByTagName("span");
  if ( spanNodes.length == 0 ) {
    return;
  }
  // the name of the book that was clicked with leading and trailing
  // whitespace removed
  bookNameLower = spanNodes[0].innerHTML.replace(/(^\s*)|(\s*$)/g, '').toLowerCase();
  // replace any spaces with underscores
  bookName = bookNameLower.replace(/ /g, '_');
  // alert("Book Name: \"" + bookName + "\"");

  // update the right frame with the overview html 
  // page for the book that was clicked
  overviewName = "jshelp/book_overviews/overview_" + bookName + ".html";
  parent.frames[2].location = overviewName; 
}