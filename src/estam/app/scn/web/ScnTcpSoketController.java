package estam.app.scn.web;
/**
 * 
 * TCP 통신으로 넘어온 리포트 완료 값을 받을 경우 인서트 처리하는 클래스
 * TCP 통신으로 넘어온 지진정보을 인서트 하는 부분 
 * 
 * 
 */

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import estam.app.scn.rpt.service.RptFrstFreeDefaultVO;
import estam.app.scn.rpt.service.RptFrstFreeService;
import estam.app.scn.rpt.service.RptFrstFreeVO;

/**
 * @Class Name : RptFrstFreeController.java
 * @Description : RptFrstFree Controller class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=RptFrstFreeVO.class)
public class ScnTcpSoketController {

    @Resource(name = "rptFrstFreeService")
    private RptFrstFreeService rptFrstFreeService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * REPORT 데이터 파일을 읽어 저장하는 루틴.
	 * @param  
	 * @exception Exception
	 */ 
    private void inertRptData() throws Exception {
    	
    	 
    } 
    
    /**
 	 * event 지진정보 결과 xml  파싱 저장하는 루틴 
 	 * @param  
 	 * @exception Exception
 	 */ 
     private void inertEhqkOcurInfoData(Map xmlMapData) throws Exception {
     	
     	 
     } 
//    
//    @RequestMapping("/rptFrstFree/addRptFrstFreeView.do")
//    public String addRptFrstFreeView(
//            @ModelAttribute("searchVO") RptFrstFreeDefaultVO searchVO, Model model)
//            throws Exception {
//        model.addAttribute("rptFrstFreeVO", new RptFrstFreeVO());
//        return "/rptFrstFree/RptFrstFreeRegister";
//    }
//    
//    @RequestMapping("/rptFrstFree/addRptFrstFree.do")
//    public String addRptFrstFree(
//            RptFrstFreeVO rptFrstFreeVO,
//            @ModelAttribute("searchVO") RptFrstFreeDefaultVO searchVO, SessionStatus status)
//            throws Exception {
//        rptFrstFreeService.insertRptFrstFree(rptFrstFreeVO);
//        status.setComplete();
//        return "forward:/rptFrstFree/RptFrstFreeList.do";
//    }
//    
//    @RequestMapping("/rptFrstFree/updateRptFrstFreeView.do")
//    public String updateRptFrstFreeView(
//            @RequestParam("freScnId") java.lang.String freScnId ,
//            @RequestParam("iptDt") java.lang.String iptDt ,
//            @ModelAttribute("searchVO") RptFrstFreeDefaultVO searchVO, Model model)
//            throws Exception {
//        RptFrstFreeVO rptFrstFreeVO = new RptFrstFreeVO();
//        rptFrstFreeVO.setFreScnId(freScnId);
//        rptFrstFreeVO.setIptDt(iptDt);
//        // 변수명은 CoC 에 따라 rptFrstFreeVO
//        model.addAttribute(selectRptFrstFree(rptFrstFreeVO, searchVO));
//        return "/rptFrstFree/RptFrstFreeRegister";
//    }
//
//    @RequestMapping("/rptFrstFree/selectRptFrstFree.do")
//    public @ModelAttribute("rptFrstFreeVO")
//    RptFrstFreeVO selectRptFrstFree(
//            RptFrstFreeVO rptFrstFreeVO,
//            @ModelAttribute("searchVO") RptFrstFreeDefaultVO searchVO) throws Exception {
//        return rptFrstFreeService.selectRptFrstFree(rptFrstFreeVO);
//    }
//
//    @RequestMapping("/rptFrstFree/updateRptFrstFree.do")
//    public String updateRptFrstFree(
//            RptFrstFreeVO rptFrstFreeVO,
//            @ModelAttribute("searchVO") RptFrstFreeDefaultVO searchVO, SessionStatus status)
//            throws Exception {
//        rptFrstFreeService.updateRptFrstFree(rptFrstFreeVO);
//        status.setComplete();
//        return "forward:/rptFrstFree/RptFrstFreeList.do";
//    }
//    
//    @RequestMapping("/rptFrstFree/deleteRptFrstFree.do")
//    public String deleteRptFrstFree(
//            RptFrstFreeVO rptFrstFreeVO,
//            @ModelAttribute("searchVO") RptFrstFreeDefaultVO searchVO, SessionStatus status)
//            throws Exception {
//        rptFrstFreeService.deleteRptFrstFree(rptFrstFreeVO);
//        status.setComplete();
//        return "forward:/rptFrstFree/RptFrstFreeList.do";
//    }

}
