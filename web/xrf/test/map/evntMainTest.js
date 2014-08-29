/**
 * Object evntMainTest()
 * @base eXria.form.Page
 * @constructor
 * @class evntMainTest
 * @author cyberlhs at 13. 9. 3 오후 5:06
 */
var evntMainTest = function() {
	// extends eXria.form.Page Object
	eXria.form.Page.call(this, "evntMainTest"); //$NON-NLS-1$
	
	// TODO 
	// TODO 
	// TODO  	
	this.onLoad = function() {
		page.doLoad();
	};
	
	this.doLoad = function() {
		page.getControl("sbpMapPage").setSrc("testGis.html");
		page.getControl("sbpWaveFrom01").setSrc("waveForm.html");
		page.getControl("sbpWaveFrom02").setSrc("waveForm.html");
		page.getControl("sbpWaveFrom03").setSrc("waveForm.html");
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
