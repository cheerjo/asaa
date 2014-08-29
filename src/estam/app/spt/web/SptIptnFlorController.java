package estam.app.spt.web;

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

import estam.app.spt.service.SptIptnFlorService;
import estam.app.spt.service.SptIptnFlorDefaultVO;
import estam.app.spt.service.SptIptnFlorVO;

/**
 * @Class Name : SptIptnFlorController.java
 * @Description : SptIptnFlor Controller class
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
@SessionAttributes(types=SptIptnFlorVO.class)
public class SptIptnFlorController {

    @Resource(name = "sptIptnFlorService")
    private SptIptnFlorService sptIptnFlorService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * SPT_IPTN_FLOR 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SptIptnFlorDefaultVO
	 * @return "/sptIptnFlor/SptIptnFlorList"
	 * @exception Exception
	 */
    @RequestMapping(value="/sptIptnFlor/SptIptnFlorList.do")
    public String selectSptIptnFlorList(@ModelAttribute("searchVO") SptIptnFlorDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List sptIptnFlorList = sptIptnFlorService.selectSptIptnFlorList(searchVO);
        model.addAttribute("resultList", sptIptnFlorList);
        
        int totCnt = sptIptnFlorService.selectSptIptnFlorListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/sptIptnFlor/SptIptnFlorList";
    } 
    
    @RequestMapping("/sptIptnFlor/addSptIptnFlorView.do")
    public String addSptIptnFlorView(
            @ModelAttribute("searchVO") SptIptnFlorDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("sptIptnFlorVO", new SptIptnFlorVO());
        return "/sptIptnFlor/SptIptnFlorRegister";
    }
    
    @RequestMapping("/sptIptnFlor/addSptIptnFlor.do")
    public String addSptIptnFlor(
            SptIptnFlorVO sptIptnFlorVO,
            @ModelAttribute("searchVO") SptIptnFlorDefaultVO searchVO, SessionStatus status)
            throws Exception {
        sptIptnFlorService.insertSptIptnFlor(sptIptnFlorVO);
        status.setComplete();
        return "forward:/sptIptnFlor/SptIptnFlorList.do";
    }
    
    @RequestMapping("/sptIptnFlor/updateSptIptnFlorView.do")
    public String updateSptIptnFlorView(
            @RequestParam("fctyCd") java.lang.String fctyCd ,
            @RequestParam("sptIptnDt") java.lang.String sptIptnDt ,
            @RequestParam("sptIptnFlorSeq") java.lang.String sptIptnFlorSeq ,
            @ModelAttribute("searchVO") SptIptnFlorDefaultVO searchVO, Model model)
            throws Exception {
        SptIptnFlorVO sptIptnFlorVO = new SptIptnFlorVO();
        sptIptnFlorVO.setFctyCd(fctyCd);
        sptIptnFlorVO.setSptIptnDt(sptIptnDt);
        sptIptnFlorVO.setSptIptnFlorSeq(sptIptnFlorSeq);
        // 변수명은 CoC 에 따라 sptIptnFlorVO
        model.addAttribute(selectSptIptnFlor(sptIptnFlorVO, searchVO));
        return "/sptIptnFlor/SptIptnFlorRegister";
    }

    @RequestMapping("/sptIptnFlor/selectSptIptnFlor.do")
    public @ModelAttribute("sptIptnFlorVO")
    SptIptnFlorVO selectSptIptnFlor(
            SptIptnFlorVO sptIptnFlorVO,
            @ModelAttribute("searchVO") SptIptnFlorDefaultVO searchVO) throws Exception {
        return sptIptnFlorService.selectSptIptnFlor(sptIptnFlorVO);
    }

    @RequestMapping("/sptIptnFlor/updateSptIptnFlor.do")
    public String updateSptIptnFlor(
            SptIptnFlorVO sptIptnFlorVO,
            @ModelAttribute("searchVO") SptIptnFlorDefaultVO searchVO, SessionStatus status)
            throws Exception {
        sptIptnFlorService.updateSptIptnFlor(sptIptnFlorVO);
        status.setComplete();
        return "forward:/sptIptnFlor/SptIptnFlorList.do";
    }
    
    @RequestMapping("/sptIptnFlor/deleteSptIptnFlor.do")
    public String deleteSptIptnFlor(
            SptIptnFlorVO sptIptnFlorVO,
            @ModelAttribute("searchVO") SptIptnFlorDefaultVO searchVO, SessionStatus status)
            throws Exception {
        sptIptnFlorService.deleteSptIptnFlor(sptIptnFlorVO);
        status.setComplete();
        return "forward:/sptIptnFlor/SptIptnFlorList.do";
    }

}
