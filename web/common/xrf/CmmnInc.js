
var CmmnInc = function() {
    eXria.form.Page.call(this, "CmmnInc"); //$NON-NLS-1$
    
    /**
     * onLoad 함수.
     */ 
    this.onLoad = function() {
        setCurPgmInfo();
    };
    
    /**
     * 현재 프로그램정보를 설정한다.
     */ 
    function setCurPgmInfo() {
        try {
            C_sCurPgmId = page.parent.getSelPgmId();
            C_sCurPgmNm = page.parent.getSelPgmNm();
        }
        catch(exception) {
        } 
    }
};
