/**
 * Object PopupCmmCode()
 * @base eXria.form.Page
 * @constructor
 * @class PopupCmmCode
 * @author cyberlhs at 13. 8. 7 오후 9:45
 */
var PopupCmmCode = function() {
	// extends eXria.form.Page Object
	eXria.form.Page.call(this, "PopupCmmCode"); //$NON-NLS-1$
	
	// TODO  
	var moReqData; //인스턴스 객체
	var moResData; //인스턴스 객체 
	var moResMsg; //Message
	var moReqMethod; //Method
	var mcGrxgrxSymCommCd;
	
    var g_oOpener;          //오프너객체
   
	
	this.onLoad = function() {
		// TODO
		moReqData           = page.getInstance("requestData"); 
		moResData           = page.getInstance("responseData");    //인스턴스 객체 
		moResMsg            = page.getInstance("resMessage");       //인스턴스 객체 
		moReqMethod         = page.getInstance("reqMethod"); 
	    
	    mcGrxgrxSymCommCd    	= page.getControl("grxSymCommCd");     //그리드 컨트롤 
		//변수 컨트롤 객체 선언
		  
        g_oOpener = window.dialogArguments;
  
//        if (C_nvl(g_oOpener.P_oParamMap.popupName) != "") {
//            document.title = g_oOpener.P_oParamMap.popupName;   //팝업명 설정
//        }
	    page.doFncInit(); 
	};
	
	this.doFncInit = function() {
	   // C_submitMessage();      //메시지데이터를 로드한다.
        //C_submitGetSession();   //세션 정보를 로드한다.

        //setInitData();          //초기데이터를 설정한다.
        
        Common.processSubmission("subList");  //목록을 조회한다.
        mcGrxgrxSymCommCd.refresh();
	};
	 
	
	this.onClick_btnSrch = function(e /*:eXria.event.Event*/) {
		// TODO 
		page.doFncInit(); 
	};
	
	 

    /**
     * 화면 재설정한다.
     */ 
    function resizeWindow() {
        //조회영역과 그리드영역의 위치를 조정한다.
        C_setComponentLeftWidth(["grp_inquiry_area",g_cGridObj1.id], 3, 3);

        //하단 버튼영역의 위치를 조정한다.
        C_setComponentWithCenter(["grp_bottom_button"]);
    }

        
    /* ================================================== */ 
    /* ============== 컨트롤 이벤트 함수 영역 ============= */ 
    /* ================================================== */
    
    /**
     * 조회 버튼 클릭 함수.
     */ 
    this.onClick_btn_inquiry_cbt = function(e /*:eXria.event.Event*/) {
        doSearch(); 
    };

    /**
     * 선택 버튼 클릭 함수.
     */ 
    this.onClick_btn_select_popup = function(e /*:eXria.event.Event*/) {
        doSelect(g_cGridObj1.focusRow);
    };

    /**
     * 닫기 버튼 클릭 함수.
     */ 
    this.onClick_btn_close_popup = function(e /*:eXria.event.Event*/) {

        window.returnValue = "close";

        self.close();
    };
    
    /**
     * 그리드 더블클릭 함수.
     */ 
    this.onGridexDblClick_grd_pgm_list = function(e /*:eXria.controls.xhtml.GridEx.event*/) {

    };

 


    /**
     * 목록 조회
     */ 
    function doSearch(){
        page.getSubmission("sbm_pgm_list").send();
		Common.processSubmission("subList");
        g_cGridObj1.refreshData();
    }


    /**
     * 선택 함수
     * @param poRow 선택 로우 객체
     */ 
    function doSelect(poRow) {
        if (poRow == null) {
            C_alertMessage("MSYS_GNR_003"); //선택된 자료가 없습니다.
            return;
        }
		
		var sPgmId = mcGrxgrxSymCommCd.getValue(poRow,"ghcCommCd");
		var sPgmNm = mcGrxgrxSymCommCd.getValue(poRow,"ghcCommNm");
        //콜백함수 호출
        //var sPgmId = g_cGridObj1.getValue(poRow, "PGM_ID");
       // var sPgmNm = g_cGridObj1.getValue(poRow, "PGM_NM");
       // g_oOpener.P_callbackPopupCmmCode(sPgmId, sPgmNm);
	    g_oOpener.commCd = sPgmId;
	    g_oOpener.commNm = sPgmNm;
		
		this.returnValue = g_oOpener;
        //window.returnValue = "select";
        self.close();
    }

	
	this.onGridexDblClick_grxSymCommCd = function(e /*:eXria.controls.xhtml.GridEx.event*/) {
		// TODO
        doSelect(e.object.focusRow);
	};
	
	this.onClick_btnInit = function(e /*:eXria.event.Event*/) {
		// TODO
		self.close();
	};
	
	this.onClick_btnConform = function(e /*:eXria.event.Event*/) {
		// TODO
		doSelect(mcGrxgrxSymCommCd.focusRow);
	};
};
