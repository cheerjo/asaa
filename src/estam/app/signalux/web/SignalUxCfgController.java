package estam.app.signalux.web;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import estam.app.signalux.service.AnysIdxCoffCfgDefaultVO;
import estam.app.signalux.service.AnysIdxCoffCfgService;
import estam.app.signalux.service.AnysIdxCoffCfgVO;
import estam.app.signalux.service.SignalUxCfgService;
import estam.app.signalux.service.SignalUxCfgDefaultVO;
import estam.app.signalux.service.SignalUxCfgVO;

/**
 * @Class Name : SignalUxCfgController.java
 * @Description : SignalUxCfg Controller class
 * @Modification Information
 *
 * @author atres
 * @since 2013.08.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=SignalUxCfgVO.class)
public class SignalUxCfgController {

    @Resource(name = "signalUxCfgService")
    private SignalUxCfgService signalUxCfgService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	 
    @Resource(name = "anysIdxCoffCfgService")
    private AnysIdxCoffCfgService anysIdxCoffCfgService;    
    
    
    /**
	 * 분석지표 계수 설정 
	 * @param  
	 * @return  
	 * @exception Exception
	 */
    @RequestMapping(value="/signalux/AnalysisCfg.do")
    public String selectSignalUxCfgList(@ModelAttribute("searchVO") SignalUxCfgDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {

    	 AnysIdxCoffCfgVO anysIdxCoffCfgVO = new AnysIdxCoffCfgVO();
    	 anysIdxCoffCfgVO.setAnysIdxCoffNo(BigDecimal.ONE);
	   	 anysIdxCoffCfgVO = anysIdxCoffCfgService.selectAnysIdxCoffCfg(anysIdxCoffCfgVO);
  
	   	 model.addAttribute("anysIdxCoffCfgVO",anysIdxCoffCfgVO);
	   	 
        return "/estam/signalux/AnalysisCfgMgr";
    } 
    
    /**
     * 분석지표 계수 설정 저장(업데이트)
     * @param anysIdxCoffCfgVO
     * @param searchVO
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping("/signalux/updateAnalysisCfg.do")
    public String updateAnysIdxCoffCfg(
            AnysIdxCoffCfgVO anysIdxCoffCfgVO,
            @ModelAttribute("searchVO") AnysIdxCoffCfgDefaultVO searchVO, SessionStatus status)
            throws Exception {
    	
        anysIdxCoffCfgService.updateAnysIdxCoffCfg(anysIdxCoffCfgVO);
        searchVO.setSearchUseYn("Y");
        status.setComplete();
        return "/estam/signalux/AnalysisCfgMgr";
    }
    
//    @RequestMapping("/signalUxCfg/addSignalUxCfgView.do")
//    public String addSignalUxCfgView(
//            @ModelAttribute("searchVO") SignalUxCfgDefaultVO searchVO, Model model)
//            throws Exception {
//        model.addAttribute("signalUxCfgVO", new SignalUxCfgVO());
//        return "/signalUxCfg/SignalUxCfgRegister";
//    }
//    
    @RequestMapping("/signalUxCfg/addSignalUxCfg.do")
    public String addSignalUxCfg(
            SignalUxCfgVO signalUxCfgVO,
            @ModelAttribute("searchVO") SignalUxCfgDefaultVO searchVO, SessionStatus status)
            throws Exception {
        signalUxCfgService.insertSignalUxCfg(signalUxCfgVO);
        status.setComplete();
        return "forward:/signalUxCfg/SignalUxCfgList.do";
    }
//    
//    @RequestMapping("/signalUxCfg/updateSignalUxCfgView.do")
//    public String updateSignalUxCfgView(
//            @RequestParam("cd") java.lang.String cd ,
//            @RequestParam("grCd") java.lang.String grCd ,
//            @ModelAttribute("searchVO") SignalUxCfgDefaultVO searchVO, Model model)
//            throws Exception {
//        SignalUxCfgVO signalUxCfgVO = new SignalUxCfgVO();
//        signalUxCfgVO.setCd(cd);
//        signalUxCfgVO.setGrCd(grCd);
//        // 변수명은 CoC 에 따라 signalUxCfgVO
//        model.addAttribute(selectSignalUxCfg(signalUxCfgVO, searchVO));
//        return "/signalUxCfg/SignalUxCfgRegister";
//    }
//
//    @RequestMapping("/signalUxCfg/selectSignalUxCfg.do")
//    public @ModelAttribute("signalUxCfgVO")
//    SignalUxCfgVO selectSignalUxCfg(
//            SignalUxCfgVO signalUxCfgVO,
//            @ModelAttribute("searchVO") SignalUxCfgDefaultVO searchVO) throws Exception {
//        return signalUxCfgService.selectSignalUxCfg(signalUxCfgVO);
//    }
//
//    @RequestMapping("/signalUxCfg/updateSignalUxCfg.do")
//    public String updateSignalUxCfg(
//            SignalUxCfgVO signalUxCfgVO,
//            @ModelAttribute("searchVO") SignalUxCfgDefaultVO searchVO, SessionStatus status)
//            throws Exception {
//        signalUxCfgService.updateSignalUxCfg(signalUxCfgVO);
//        status.setComplete();
//        return "forward:/signalUxCfg/SignalUxCfgList.do";
//    }
//    
//    @RequestMapping("/signalUxCfg/deleteSignalUxCfg.do")
//    public String deleteSignalUxCfg(
//            SignalUxCfgVO signalUxCfgVO,
//            @ModelAttribute("searchVO") SignalUxCfgDefaultVO searchVO, SessionStatus status)
//            throws Exception {
//        signalUxCfgService.deleteSignalUxCfg(signalUxCfgVO);
//        status.setComplete();
//        return "forward:/signalUxCfg/SignalUxCfgList.do";
//    }

}
