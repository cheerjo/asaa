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

import estam.app.signalux.service.AnysIdxCoffCfgService;
import estam.app.signalux.service.AnysIdxCoffCfgDefaultVO;
import estam.app.signalux.service.AnysIdxCoffCfgVO;

/**
 * @Class Name : AnysIdxCoffCfgController.java
 * @Description : AnysIdxCoffCfg Controller class
 * @Modification Information
 *
 * @author atres
 * @since 2013.11.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=AnysIdxCoffCfgVO.class)
public class AnysIdxCoffCfgController {

    @Resource(name = "anysIdxCoffCfgService")
    private AnysIdxCoffCfgService anysIdxCoffCfgService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * ANYS_IDX_COFF_CFG 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 AnysIdxCoffCfgDefaultVO
	 * @return "/anysIdxCoffCfg/AnysIdxCoffCfgList"
	 * @exception Exception
	 */
    @RequestMapping(value="/anysIdxCoffCfg/AnysIdxCoffCfgList.do")
    public String selectAnysIdxCoffCfgList(@ModelAttribute("searchVO") AnysIdxCoffCfgDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	//searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	//searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	//PaginationInfo paginationInfo = new PaginationInfo();
		//paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		//paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		//paginationInfo.setPageSize(searchVO.getPageSize());
		
		//searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		//searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		//searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        //List anysIdxCoffCfgList = anysIdxCoffCfgService.selectAnysIdxCoffCfgList(searchVO);
        //model.addAttribute("resultList", anysIdxCoffCfgList);
        
        //int totCnt = anysIdxCoffCfgService.selectAnysIdxCoffCfgListTotCnt(searchVO);
		//paginationInfo.setTotalRecordCount(totCnt);
        //model.addAttribute("paginationInfo", paginationInfo);
        //return "/estam/signalux/AnalysisCfgMgr";
        
        //return anysIdxCoffCfgService.selectAnysIdxCoffCfgListTotCnt(searchVO);
        
        return "/anysIdxCoffCfg/AnysIdxCoffCfgList";
    } 
    
    @RequestMapping("/anysIdxCoffCfg/addAnysIdxCoffCfg.do")
    public String addAnysIdxCoffCfg(
            AnysIdxCoffCfgVO anysIdxCoffCfgVO,
            @ModelAttribute("searchVO") AnysIdxCoffCfgDefaultVO searchVO, SessionStatus status)
            throws Exception {
    	anysIdxCoffCfgService.deleteAnysIdxCoffCfg(anysIdxCoffCfgVO);
        anysIdxCoffCfgService.insertAnysIdxCoffCfg(anysIdxCoffCfgVO); //
        status.setComplete();
    //    return "/signalux/AnalysisCfg.do";
        
        return "forward:/anysIdxCoffCfg/selectAnysIdxCoffCfg.do";
    }

    @RequestMapping("/anysIdxCoffCfg/selectAnysIdxCoffCfg.do")
    public String selectAnysIdxCoffCfg(
                @ModelAttribute("searchVO") AnysIdxCoffCfgDefaultVO searchVO, Model model)
                throws Exception {
        	 AnysIdxCoffCfgVO anysIdxCoffCfgVO = new AnysIdxCoffCfgVO();
        	 anysIdxCoffCfgVO.setAnysIdxCoffNo(BigDecimal.ONE);
        	 anysIdxCoffCfgVO = anysIdxCoffCfgService.selectAnysIdxCoffCfg(anysIdxCoffCfgVO);
       
            //model.addAttribute("anysIdxCoffCfgVO", AnysIdxCoffCfgVO());
            model.addAttribute("anysIdxCoffCfgVO",anysIdxCoffCfgVO);
            //return "/anysIdxCoffCfg/AnysIdxCoffCfgRegister";

            return "/estam/signalux/AnalysisCfgMgr";
 
    }
    
    @RequestMapping("/anysIdxCoffCfg/addAnysIdxCoffCfgView.do")
    public String addAnysIdxCoffCfgView(
            @ModelAttribute("searchVO") AnysIdxCoffCfgDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("anysIdxCoffCfgVO", new AnysIdxCoffCfgVO());
       // return "/anysIdxCoffCfg/AnysIdxCoffCfgRegister";
        return "forward:/anysIdxCoffCfg/selectAnysIdxCoffCfg.do";
    }
    

    
    @RequestMapping("/anysIdxCoffCfg/updateAnysIdxCoffCfgView.do")
    public String updateAnysIdxCoffCfgView(
            @RequestParam("anysIdxCoffNo") java.math.BigDecimal anysIdxCoffNo ,
            @ModelAttribute("searchVO") AnysIdxCoffCfgDefaultVO searchVO, Model model)
            throws Exception {
        AnysIdxCoffCfgVO anysIdxCoffCfgVO = new AnysIdxCoffCfgVO();
        anysIdxCoffCfgVO.setAnysIdxCoffNo(anysIdxCoffNo);
        // 변수명은 CoC 에 따라 anysIdxCoffCfgVO
       // model.addAttribute(selectAnysIdxCoffCfg(anysIdxCoffCfgVO, searchVO));
        return "/anysIdxCoffCfg/AnysIdxCoffCfgRegister";
    }

   

    @RequestMapping("/anysIdxCoffCfg/updateAnysIdxCoffCfg.do")
    public String updateAnysIdxCoffCfg(
            AnysIdxCoffCfgVO anysIdxCoffCfgVO,
            @ModelAttribute("searchVO") AnysIdxCoffCfgDefaultVO searchVO, SessionStatus status)
            throws Exception {
        anysIdxCoffCfgService.updateAnysIdxCoffCfg(anysIdxCoffCfgVO);
        status.setComplete();
        return "forward:/anysIdxCoffCfg/AnysIdxCoffCfgList.do";
    }
    
    @RequestMapping("/anysIdxCoffCfg/deleteAnysIdxCoffCfg.do")
    public String deleteAnysIdxCoffCfg(
            AnysIdxCoffCfgVO anysIdxCoffCfgVO,
            @ModelAttribute("searchVO") AnysIdxCoffCfgDefaultVO searchVO, SessionStatus status)
            throws Exception {
        anysIdxCoffCfgService.deleteAnysIdxCoffCfg(anysIdxCoffCfgVO);
        status.setComplete();
        return "forward:/anysIdxCoffCfg/AnysIdxCoffCfgList.do";
    }

}
