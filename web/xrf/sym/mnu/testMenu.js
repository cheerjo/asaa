/**
 * Object testMenu()
 * @base eXria.form.Page
 * @constructor
 * @class testMenu
 * @author zacade at 13. 12. 5 오후 3:17
 */
var testMenu = function() {
	// extends eXria.form.Page Object
	eXria.form.Page.call(this, "testMenu"); //$NON-NLS-1$
	
	// TODO 
	
	
	this.onClick_btn1 = function(e /*:eXria.event.Event*/) {
		// TODO
		page.getSubmission("subList").send();
		
		page.getControl("grx1").refresh();
	};
};
