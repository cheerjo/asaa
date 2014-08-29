package estam.app.scn.rpt.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.property.EgovPropertyService;
import estam.app.scn.rpt.service.RptFrstIptnVO;
import estam.app.scn.rpt.service.RptFrstItemIptnVO;
import estam.app.scn.rpt.service.RptMgrDefaultVO;
import estam.app.scn.rpt.service.RptMgrService;
import estam.app.scn.rpt.service.RptRglrIptnDefaultVO;
import estam.app.scn.rpt.service.RptRglrIptnService;
import estam.app.scn.rpt.service.RptRglrIptnVO;

/**
 * @Class Name : RptRglrIptnController.java
 * @Description : RptRglrIptn Controller class
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
public class RglrIptnReportController {

	private static final Logger logger = LoggerFactory.getLogger(RglrIptnReportController.class); 
	
    @Resource(name = "rptRglrIptnService")
    private RptRglrIptnService rptRglrIptnService;
     
    @Resource(name = "rptMgrService")
    private RptMgrService rptMgrService;
    /** EgovCmmUseService */
	@Resource(name="EgovCmmUseService")
	private EgovCmmUseService cmmUseService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	 
	/**
	 * RPT_MGR 목록을 조회한다. 시설물 기본정보리스트 
	 * @param searchVO - 조회할 정보가 담긴 RptMgrDefaultVO
	 * @return "/rptMgr/RptMgrList"
	 * @exception Exception
	 */
   @RequestMapping(value="/scn/RglrIptnReport.do")
   public String selectRptMgrList(@ModelAttribute("searchVO") RptMgrDefaultVO searchVO, 
   		ModelMap model)
           throws Exception {  
	
	   ComDefaultCodeVO vo = new ComDefaultCodeVO();
   	
		vo.setCommCd("ITEM_008");
		List fctyAreaList = cmmUseService.selectCmmCodeDetail(vo);
		model.addAttribute("fctyAreaList", fctyAreaList);
		
		 
		vo.setCommCd("ITEM_011");
		List fctyKndList = cmmUseService.selectCmmCodeDetail(vo);
		model.addAttribute("fctyKndList", fctyKndList);
		
		logger.debug("fctyKndList"+ fctyKndList);
		
	   	if (null == searchVO.getConDaGbcd()) {
	   		searchVO.setConDaGbcd("04");
	   	}  
   	
       List rptMgrList = rptMgrService.selectRptMgrList(searchVO);
       model.addAttribute("rptMgrList", rptMgrList);
       
       Map<String, Object> fctyStatSensVO = new HashMap<String, Object>();
       String fctycdSearch="";
       if(rptMgrList.size() > 0) {
    	   fctyStatSensVO =  (Map<String, Object>)rptMgrList.get(0); 
    	   fctycdSearch = "fctycd:" +fctyStatSensVO.get("iptDt").toString() +":"+ fctyStatSensVO.get("fctyCd").toString() +":04:"+ fctyStatSensVO.get("gvmtCd").toString();
       }
       model.addAttribute("fctycdSearch", fctycdSearch);
       //안쓰는 것 같아서 주석처리
       //int totCnt = rptMgrService.selectRptMgrListTotCnt(searchVO); 
       //model.addAttribute("rptMgrCnt", totCnt);
        
       
       return "/estam/scn/rpt/RglrIptnReport";
   } 
    
  /**
   * 정기 점검 기본정보 가져 오기   
   * @param rptFrstIptnVO
   * @param searchVO
   * @return
   * @throws Exception
   */
  @RequestMapping("/scn/RptRglrIptnInfo.do")
  public String selectRptRglrIptnInfo( 
          @ModelAttribute("searchVO") RptRglrIptnDefaultVO searchVO,ModelMap model) throws Exception {
	  
	   //정기 점검보고서   
	   //TODO - 점검항목데이터 가져오기 항목에서.... 임시테이블 설정....
	 
	   RptRglrIptnVO rptRglrIptntIptnVO = new RptRglrIptnVO();
	    
	   try { 
		   rptRglrIptntIptnVO.setFctyCd(searchVO.getFctyCd());
		   rptRglrIptntIptnVO.setConDaGbcd(searchVO.getConDaGbcd()); //초기점검보고서
		   rptRglrIptntIptnVO.setGvmtCd(searchVO.getGvmtCd()); //초기점검보고서
		   rptRglrIptntIptnVO.setIptDt(searchVO.getIptDt());
		   List rptRglrIptnList = rptRglrIptnService.selectRptRglrIptnList(rptRglrIptntIptnVO);
		   model.addAttribute("rptRglrIptnList", rptRglrIptnList);

		   rptRglrIptntIptnVO = rptRglrIptnService.selectRptRglrIptn(rptRglrIptntIptnVO);
		   model.addAttribute("rptRglrIptn", rptRglrIptntIptnVO);
	    
	    } catch(EgovBizException egbe){
		   	 
	  		logger.debug("EgovBizException" + egbe.getMessage());
	  		logger.debug("EgovBizException : " + egbe.getMessageKey());
	 		//egbe.printStackTrace();
	 	 
		} 		    
        
	  	return "/estam/scn/rpt/inc/RptRglrIptnInfo";
  } 
    
  /**
   * 정기 점검 Item 정보 가져오기   
   * @param rptFrstIptnVO
   * @param searchVO
   * @return
   * @throws Exception
   */
  @RequestMapping("/scn/RptRglrIptnItemInfo.do")
  public String selectRptRglrIptnItemInfo( 
          @ModelAttribute("searchVO") RptRglrIptnDefaultVO searchVO,ModelMap model) throws Exception {
	   //정기 점검보고서   
	   //TODO - 점검항목데이터 가져오기 항목에서.... 임시테이블 설정....
	   RptRglrIptnVO rptRglrIptntIptnVO = new RptRglrIptnVO();
	    
	   try {
		   
		   rptRglrIptntIptnVO.setFctyCd(searchVO.getFctyCd());
		   rptRglrIptntIptnVO.setConDaGbcd(searchVO.getConDaGbcd()); //초기점검보고서
		   rptRglrIptntIptnVO.setGvmtCd(searchVO.getGvmtCd()); //초기점검보고서
		   rptRglrIptntIptnVO.setIptDt(searchVO.getIptDt());
		   
		   rptRglrIptntIptnVO = rptRglrIptnService.selectRptRglrIptn(rptRglrIptntIptnVO);
		   model.addAttribute("rptRglrIptn", rptRglrIptntIptnVO);
	    
	    } catch(EgovBizException egbe){
		   	 
	  		logger.debug("EgovBizException" + egbe.getMessage());
	  		logger.debug("EgovBizException : " + egbe.getMessageKey());
	 		//egbe.printStackTrace();
	 	 
		} 		    
        
	  	return "/estam/scn/rpt/inc/RptRglrIptnItemInfo";
  } 
    /**
	 * RPT_RGLR_IPTN 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 RptRglrIptnDefaultVO
	 * @return "/rptRglrIptn/RptRglrIptnList"
	 * @exception Exception
	 */
//    @RequestMapping(value="/rptRglrIptn/RptRglrIptnList.do")
//    public String selectRptRglrIptnList(@ModelAttribute("searchVO") RptRglrIptnDefaultVO searchVO, 
//    		ModelMap model)
//            throws Exception {
//    	
//    	/** EgovPropertyService.sample */
//    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
//    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
//    	
//    	/** pageing */
//    	PaginationInfo paginationInfo = new PaginationInfo();
//		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
//		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
//		paginationInfo.setPageSize(searchVO.getPageSize());
//		
//		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
//		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
//		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
//		
//        List rptRglrIptnList = rptRglrIptnService.selectRptRglrIptnList(searchVO);
//        model.addAttribute("resultList", rptRglrIptnList);
//        
//        int totCnt = rptRglrIptnService.selectRptRglrIptnListTotCnt(searchVO);
//		paginationInfo.setTotalRecordCount(totCnt);
//        model.addAttribute("paginationInfo", paginationInfo);
//        
//        return "/rptRglrIptn/RptRglrIptnList";
//    } 
//    
//    @RequestMapping("/rptRglrIptn/addRptRglrIptnView.do")
//    public String addRptRglrIptnView(
//            @ModelAttribute("searchVO") RptRglrIptnDefaultVO searchVO, Model model)
//            throws Exception {
//        model.addAttribute("rptRglrIptnVO", new RptRglrIptnVO());
//        return "/rptRglrIptn/RptRglrIptnRegister";
//    }
//    
//    @RequestMapping("/rptRglrIptn/addRptRglrIptn.do")
//    public String addRptRglrIptn(
//            RptRglrIptnVO rptRglrIptnVO,
//            @ModelAttribute("searchVO") RptRglrIptnDefaultVO searchVO, SessionStatus status)
//            throws Exception {
//        rptRglrIptnService.insertRptRglrIptn(rptRglrIptnVO);
//        status.setComplete();
//        return "forward:/rptRglrIptn/RptRglrIptnList.do";
//    }
//    
//    @RequestMapping("/rptRglrIptn/updateRptRglrIptnView.do")
//    public String updateRptRglrIptnView(
//            @RequestParam("iptDt") java.lang.String iptDt ,
//            @RequestParam("fctyCd") java.lang.String fctyCd ,
//            @RequestParam("conDaGbcd") java.lang.String conDaGbcd ,
//            @ModelAttribute("searchVO") RptRglrIptnDefaultVO searchVO, Model model)
//            throws Exception {
//        RptRglrIptnVO rptRglrIptnVO = new RptRglrIptnVO();
//        rptRglrIptnVO.setIptDt(iptDt);
//        rptRglrIptnVO.setFctyCd(fctyCd);
//        rptRglrIptnVO.setConDaGbcd(conDaGbcd);
//        // 변수명은 CoC 에 따라 rptRglrIptnVO
//        model.addAttribute(selectRptRglrIptn(rptRglrIptnVO, searchVO));
//        return "/rptRglrIptn/RptRglrIptnRegister";
//    }
//
//    @RequestMapping("/rptRglrIptn/selectRptRglrIptn.do")
//    public @ModelAttribute("rptRglrIptnVO")
//    RptRglrIptnVO selectRptRglrIptn(
//            RptRglrIptnVO rptRglrIptnVO,
//            @ModelAttribute("searchVO") RptRglrIptnDefaultVO searchVO) throws Exception {
//        return rptRglrIptnService.selectRptRglrIptn(rptRglrIptnVO);
//    }
//
//    @RequestMapping("/rptRglrIptn/updateRptRglrIptn.do")
//    public String updateRptRglrIptn(
//            RptRglrIptnVO rptRglrIptnVO,
//            @ModelAttribute("searchVO") RptRglrIptnDefaultVO searchVO, SessionStatus status)
//            throws Exception {
//        rptRglrIptnService.updateRptRglrIptn(rptRglrIptnVO);
//        status.setComplete();
//        return "forward:/rptRglrIptn/RptRglrIptnList.do";
//    }
//    
//    @RequestMapping("/rptRglrIptn/deleteRptRglrIptn.do")
//    public String deleteRptRglrIptn(
//            RptRglrIptnVO rptRglrIptnVO,
//            @ModelAttribute("searchVO") RptRglrIptnDefaultVO searchVO, SessionStatus status)
//            throws Exception {
//        rptRglrIptnService.deleteRptRglrIptn(rptRglrIptnVO);
//        status.setComplete();
//        return "forward:/rptRglrIptn/RptRglrIptnList.do";
//    }

}
