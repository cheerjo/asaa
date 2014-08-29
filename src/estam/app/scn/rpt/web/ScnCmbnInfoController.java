/**
 * 
 */
package estam.app.scn.rpt.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import estam.app.scn.rpt.service.RptFrstIptnDefaultVO;


/**
 * @Class Name : ScnCmbnInfoController.java
 * @Description : ScnCmbnInfoController class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@Controller
public class ScnCmbnInfoController {

    //@Resource(name = "rptFrstIptnService")
    //private RptFrstIptnService rptFrstIptnService;
    
    /** EgovPropertyService */
    //@Resource(name = "propertiesService")
    //protected EgovPropertyService propertiesService;
	
    /**
	 * RPT_FRST_IPTN 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 RptFrstIptnDefaultVO
	 * @return "/rptFrstIptn/RptFrstIptnList"
	 * @exception Exception
	 */
    @RequestMapping(value="/scn/ScnCmbnInfo.do")
    public String scnCmbnInfo(@ModelAttribute("searchVO") RptFrstIptnDefaultVO searchVO, 
    		ModelMap model)
            throws Exception { 
        
        return "/estam/scn/ScnCmbnInfo";
    }  
}

