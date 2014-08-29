/**
 * Object mainTest()
 * @base eXria.form.Page
 * @constructor
 * @class mainTest
 * @author cyberlhs at 13. 9. 3 오후 1:38
 */
var mainTest = function() {
	// extends eXria.form.Page Object
	eXria.form.Page.call(this, "mainTest"); //$NON-NLS-1$
	
	// TODO 
	// TODO  	
	this.onLoad = function() {
		page.doLoad();
	};
	
	this.doLoad = function() {
		page.getControl("sbpMapPage").setSrc("testGis.html");
		page.getControl("sbpWaveFrom").setSrc("waveForm.html");
		page.getControl("sbpPgaBar01").setSrc("pgaBar.html");
		page.getControl("sbpPgaBar02").setSrc("pgaBar.html");
		page.getControl("sbpPgaBar03").setSrc("pgaBar.html");
		page.getControl("sbpPgaBar04").setSrc("pgaBar.html");
		page.getControl("sbpPgaBar05").setSrc("pgaBar.html");
		page.getControl("sbpPgaBar06").setSrc("pgaBar.html");
		page.getControl("sbpPgaBar07").setSrc("pgaBar.html");
		page.getControl("sbpPgaBar08").setSrc("pgaBar.html");
		page.getControl("sbpPgaBar09").setSrc("pgaBar.html");
		page.getControl("sbpPgaBar10").setSrc("pgaBar.html");
	};
};
