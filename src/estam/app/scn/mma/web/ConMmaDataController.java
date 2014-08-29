package estam.app.scn.mma.web;

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

import estam.app.scn.mma.service.ConMmaDataService;
import estam.app.scn.mma.service.ConMmaDataDefaultVO;
import estam.app.scn.mma.service.ConMmaDataVO;

/**
 * @Class Name : ConMmaDataController.java
 * @Description : ConMmaData Controller class
 * @Modification Information
 *
 * @author ates
 * @since 2013.10.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=ConMmaDataVO.class)
public class ConMmaDataController {

    @Resource(name = "conMmaDataService")
    private ConMmaDataService conMmaDataService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * CON_MMA_DATA 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 ConMmaDataDefaultVO
	 * @return "/conMmaData/ConMmaDataList"
	 * @exception Exception
	 */
    @RequestMapping(value="/conMmaData/ConMmaDataList.do")
    public String selectConMmaDataList(@ModelAttribute("searchVO") ConMmaDataDefaultVO searchVO, 
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
		
        List conMmaDataList = conMmaDataService.selectConMmaDataList(searchVO);
        model.addAttribute("resultList", conMmaDataList);
        
        int totCnt = conMmaDataService.selectConMmaDataListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/conMmaData/ConMmaDataList";
    } 
    
    @RequestMapping("/conMmaData/addConMmaDataView.do")
    public String addConMmaDataView(
            @ModelAttribute("searchVO") ConMmaDataDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("conMmaDataVO", new ConMmaDataVO());
        return "/conMmaData/ConMmaDataRegister";
    }
    
   
    @RequestMapping("/conMmaData/addConMmaData.do")
    public String addConMmaData(
            ConMmaDataVO conMmaDataVO,
            @ModelAttribute("searchVO") ConMmaDataDefaultVO searchVO, SessionStatus status)
            throws Exception {
        conMmaDataService.insertConMmaData(conMmaDataVO);
        status.setComplete();
        return "forward:/conMmaData/ConMmaDataList.do";
    }
    
    @RequestMapping("/conMmaData/updateConMmaDataView.do")
    public String updateConMmaDataView(
            @RequestParam("mmaGvmtCd") java.lang.String mmaGvmtCd ,
            @RequestParam("mmaFctyLocVal") java.lang.String mmaFctyLocVal ,
            @RequestParam("mmaMsrdDt") java.lang.String mmaMsrdDt ,
            @RequestParam("mmaMsrdSeq") java.math.BigDecimal mmaMsrdSeq ,
            @ModelAttribute("searchVO") ConMmaDataDefaultVO searchVO, Model model)
            throws Exception {
        ConMmaDataVO conMmaDataVO = new ConMmaDataVO();
        conMmaDataVO.setMmaGvmtCd(mmaGvmtCd);
        conMmaDataVO.setMmaFctyLocVal(mmaFctyLocVal);
        conMmaDataVO.setMmaMsrdDt(mmaMsrdDt);
        conMmaDataVO.setMmaMsrdSeq(mmaMsrdSeq);
        // 변수명은 CoC 에 따라 conMmaDataVO
        model.addAttribute(selectConMmaData(conMmaDataVO, searchVO));
        return "/conMmaData/ConMmaDataRegister";
    }

    @RequestMapping("/conMmaData/selectConMmaData.do")
    public @ModelAttribute("conMmaDataVO")
    ConMmaDataVO selectConMmaData(
            ConMmaDataVO conMmaDataVO,
            @ModelAttribute("searchVO") ConMmaDataDefaultVO searchVO) throws Exception {
        return conMmaDataService.selectConMmaData(conMmaDataVO);
    }

    @RequestMapping("/conMmaData/updateConMmaData.do")
    public String updateConMmaData(
            ConMmaDataVO conMmaDataVO,
            @ModelAttribute("searchVO") ConMmaDataDefaultVO searchVO, SessionStatus status)
            throws Exception {
        conMmaDataService.updateConMmaData(conMmaDataVO);
        status.setComplete();
        return "forward:/conMmaData/ConMmaDataList.do";
    }
    
    @RequestMapping("/conMmaData/deleteConMmaData.do")
    public String deleteConMmaData(
            ConMmaDataVO conMmaDataVO,
            @ModelAttribute("searchVO") ConMmaDataDefaultVO searchVO, SessionStatus status)
            throws Exception {
        conMmaDataService.deleteConMmaData(conMmaDataVO);
        status.setComplete();
        return "forward:/conMmaData/ConMmaDataList.do";
    }

}
