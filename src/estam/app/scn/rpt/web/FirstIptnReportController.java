package estam.app.scn.rpt.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import estam.app.fcty.service.FctyAddInfoService;
import estam.app.fcty.service.FctyAddInfoVO;
import estam.app.fcty.service.FctyImgService;
import estam.app.fcty.service.FctyImgVO;
import estam.app.scn.rpt.service.RptFrstEhqkScnDefaultVO;
import estam.app.scn.rpt.service.RptFrstEhqkScnService;
import estam.app.scn.rpt.service.RptFrstFreeDefaultVO;
import estam.app.scn.rpt.service.RptFrstFreeService;
import estam.app.scn.rpt.service.RptFrstFreeVO;
import estam.app.scn.rpt.service.RptFrstIptnDefaultVO;
import estam.app.scn.rpt.service.RptFrstIptnService;
import estam.app.scn.rpt.service.RptFrstIptnVO;
import estam.app.scn.rpt.service.RptFrstItemIptnDefaultVO;
import estam.app.scn.rpt.service.RptFrstItemIptnService;
import estam.app.scn.rpt.service.RptFrstItemIptnVO;
import estam.app.scn.rpt.service.RptFrstRccDefaultVO;
import estam.app.scn.rpt.service.RptFrstRccService;
import estam.app.scn.rpt.service.RptMgrDefaultVO;
import estam.app.scn.rpt.service.RptMgrService;
import estam.app.scn.rpt.service.RptMgrVO;

/**
 * @Class Name : RptFrstIptnController.java
 * @Description : RptFrstIptn Controller class
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
public class FirstIptnReportController {

	private static final Logger logger = LoggerFactory.getLogger(FirstIptnReportController.class);
	
    @Resource(name = "rptFrstIptnService")
    private RptFrstIptnService rptFrstIptnService;
 
    @Resource(name = "rptMgrService")
    private RptMgrService rptMgrService;
    
    @Resource(name = "fctyImgService")
    private FctyImgService fctyImgService;
    
    
    @Resource(name = "fctyAddInfoService")
    private FctyAddInfoService fctyAddInfoService;
    
    @Resource(name = "rptFrstItemIptnService")
    private RptFrstItemIptnService rptFrstItemIptnService;
    
    @Resource(name = "rptFrstFreeService")
    private RptFrstFreeService rptFrstFreeService;
    
    @Resource(name = "rptFrstEhqkScnService")
    private RptFrstEhqkScnService rptFrstEhqkScnService;
    
    @Resource(name = "rptFrstRccService")
    private RptFrstRccService rptFrstRccService;
    
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
   @RequestMapping(value="/scn/FirstIptnReport.do")
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
    		searchVO.setConDaGbcd("02");
    	} 
    	
        List rptMgrList = rptMgrService.selectRptMgrList(searchVO);
        model.addAttribute("rptMgrList", rptMgrList);
        
        Map<String, Object> fctyStatSensVO = new HashMap<String, Object>();
        String fctycdSearch="";
        if(rptMgrList.size() > 0) {
        	fctyStatSensVO =  (Map<String, Object>)rptMgrList.get(0); 
        	fctycdSearch = "fctycd:" +fctyStatSensVO.get("iptDt").toString() +":"+ fctyStatSensVO.get("fctyCd").toString() +":03:"+ fctyStatSensVO.get("gvmtCd").toString();
        }
        model.addAttribute("fctycdSearch", fctycdSearch);
       //안쓰는 것 같아서 주석처리  
      //  int totCnt = rptMgrService.selectRptMgrListTotCnt(searchVO); 
      //  model.addAttribute("rptMgrCnt", totCnt);
         
       
       return "/estam/scn/rpt/FirstIptnReport";
   } 
    
  /**
   * 초기점검 기본정보 가져 오기   
   * @param rptFrstIptnVO
   * @param searchVO
   * @return
   * @throws Exception
   */
  @RequestMapping("/scn/RptFrstIptnCenterInfo.do")
  public String selectRptFrstIptn( 
          @ModelAttribute("searchVO") RptFrstIptnDefaultVO searchVO,ModelMap model) throws Exception {
	  
	   //초기점검보고서 중앙 
	   RptFrstIptnVO rptFrstIptnVO = new RptFrstIptnVO();  
	   RptFrstItemIptnVO rptFrstItemIptnVO = new RptFrstItemIptnVO();
	 
	try {   
	   rptFrstIptnVO.setFctyCd(searchVO.getFctyCd());
	   rptFrstIptnVO.setConDaGbcd(searchVO.getConDaGbcd()); //초기점검보고서
	   rptFrstIptnVO.setGvmtCd(searchVO.getGvmtCd()); //초기점검보고서
	   rptFrstIptnVO = rptFrstIptnService.selectRptFrstIptn(rptFrstIptnVO);
	
	   
	   rptFrstItemIptnVO.setFctyCd(searchVO.getFctyCd());
	   rptFrstItemIptnVO.setConDaGbcd(searchVO.getConDaGbcd()); //초기점검보고서
	   rptFrstItemIptnVO.setGvmtCd(searchVO.getGvmtCd()); //초기점검보고서
	   rptFrstItemIptnVO = rptFrstItemIptnService.selectRptFrstItemIptn(rptFrstItemIptnVO);
	  
    } catch(EgovBizException egbe){
	   	 
    	logger.debug("EgovBizException" + egbe.getMessage());
    	logger.debug("EgovBizException : " + egbe.getMessageKey());
   		//egbe.printStackTrace();
   	 
	} 	
	
	 	model.addAttribute("rptFirstIptn", rptFrstIptnVO); 
	 	model.addAttribute("rptFrstItemIptn", rptFrstItemIptnVO);
	   
	  	return "/estam/scn/rpt/inc/RptFrstIptnCenterInfo";
  } 
    
  /**
   * 초기점검 센서에 따른 정보 가져오기...
   * @param rptFrstIptnVO
   * @param searchVO
   * @return
   * @throws Exception
   */
  @RequestMapping("/scn/RptFrstIptnRightInfo.do")
  public String selectRptFrstEhqkIptn( 
          @ModelAttribute("searchVO") RptFrstIptnDefaultVO searchVO,ModelMap model) throws Exception {
	  
	   //초기점검보고서 RIGHT
	  try {    
		   //자유장...
		   RptFrstFreeVO rptFrstFreeVO  =  new RptFrstFreeVO();
		   rptFrstFreeVO.setFctyCd(searchVO.getFctyCd());
		   rptFrstFreeVO.setConDaGbcd(searchVO.getConDaGbcd()); //초기점검보고서
		   rptFrstFreeVO.setGvmtCd(searchVO.getGvmtCd()); //초기점검보고서
		   rptFrstFreeVO = rptFrstFreeService.selectRptFrstFree(rptFrstFreeVO);
	       model.addAttribute("rptFrstFree", rptFrstFreeVO);
		  	
	       //센서.정보
	       RptFrstEhqkScnDefaultVO rptFrstEhqkScnDefault = new RptFrstEhqkScnDefaultVO();
		   
	       rptFrstEhqkScnDefault.setFctyCd(searchVO.getFctyCd());
	       rptFrstEhqkScnDefault.setConDaGbcd(searchVO.getConDaGbcd()); //초기점검보고서
	       rptFrstEhqkScnDefault.setGvmtCd(searchVO.getGvmtCd()); //초기점검보고서
		   List rptFrstEhqkScnList = rptFrstEhqkScnService.selectRptFrstEhqkScnList(rptFrstEhqkScnDefault);
		   model.addAttribute("rptFrstScnList", rptFrstEhqkScnList); 
	        
		   //기록계 정보.
		   RptFrstRccDefaultVO  rptFrstRccDefault = new RptFrstRccDefaultVO(); 
		   rptFrstRccDefault.setFctyCd(searchVO.getFctyCd());
		   rptFrstRccDefault.setConDaGbcd(searchVO.getConDaGbcd()); //초기점검보고서
		   rptFrstRccDefault.setGvmtCd(searchVO.getGvmtCd()); //초기점검보고서
		   List rptFrstRccList = rptFrstRccService.selectRptFrstRccList(rptFrstRccDefault);
		   model.addAttribute("rptFrstRccList", rptFrstRccList); 
		   
	  } catch(EgovBizException egbe){
		   	 
	  	logger.debug("EgovBizException" + egbe.getMessage());
	  	logger.debug("EgovBizException : " + egbe.getMessageKey());
	 		//egbe.printStackTrace();
	 	 
	 } 		   
	  	return "/estam/scn/rpt/inc/RptFrstIptnRightInfo";
  }  
    
    /**
	 * RPT_FRST_IPTN 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 RptFrstIptnDefaultVO
	 * @return "/rptFrstIptn/RptFrstIptnList"
	 * @exception Exception
	 */
//    @RequestMapping(value="/rptFrstIptn/RptFrstIptnList.do")
//    public String selectRptFrstIptnList(@ModelAttribute("searchVO") RptFrstIptnDefaultVO searchVO, 
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
//        List rptFrstIptnList = rptFrstIptnService.selectRptFrstIptnList(searchVO);
//        model.addAttribute("resultList", rptFrstIptnList);
//        
//        int totCnt = rptFrstIptnService.selectRptFrstIptnListTotCnt(searchVO);
//		paginationInfo.setTotalRecordCount(totCnt);
//        model.addAttribute("paginationInfo", paginationInfo);
//        
//        return "/rptFrstIptn/RptFrstIptnList";
//    } 
//    
//    @RequestMapping("/rptFrstIptn/addRptFrstIptnView.do")
//    public String addRptFrstIptnView(
//            @ModelAttribute("searchVO") RptFrstIptnDefaultVO searchVO, Model model)
//            throws Exception {
//        model.addAttribute("rptFrstIptnVO", new RptFrstIptnVO());
//        return "/rptFrstIptn/RptFrstIptnRegister";
//    }
//    
//    @RequestMapping("/rptFrstIptn/addRptFrstIptn.do")
//    public String addRptFrstIptn(
//            RptFrstIptnVO rptFrstIptnVO,
//            @ModelAttribute("searchVO") RptFrstIptnDefaultVO searchVO, SessionStatus status)
//            throws Exception {
//        rptFrstIptnService.insertRptFrstIptn(rptFrstIptnVO);
//        status.setComplete();
//        return "forward:/rptFrstIptn/RptFrstIptnList.do";
//    }
//    
//    @RequestMapping("/rptFrstIptn/updateRptFrstIptnView.do")
//    public String updateRptFrstIptnView(
//            @RequestParam("iptDt") java.lang.String iptDt ,
//            @RequestParam("conDaGbcd") java.lang.String conDaGbcd ,
//            @RequestParam("fctyCd") java.lang.String fctyCd ,
//            @ModelAttribute("searchVO") RptFrstIptnDefaultVO searchVO, Model model)
//            throws Exception {
//        RptFrstIptnVO rptFrstIptnVO = new RptFrstIptnVO();
//        rptFrstIptnVO.setIptDt(iptDt);
//        rptFrstIptnVO.setConDaGbcd(conDaGbcd);
//        rptFrstIptnVO.setFctyCd(fctyCd);
//        // 변수명은 CoC 에 따라 rptFrstIptnVO
//        model.addAttribute(selectRptFrstIptn(rptFrstIptnVO, searchVO));
//        return "/rptFrstIptn/RptFrstIptnRegister";
//    }
//
//    @RequestMapping("/rptFrstIptn/selectRptFrstIptn.do")
//    public @ModelAttribute("rptFrstIptnVO")
//    RptFrstIptnVO selectRptFrstIptn(
//            RptFrstIptnVO rptFrstIptnVO,
//            @ModelAttribute("searchVO") RptFrstIptnDefaultVO searchVO) throws Exception {
//        return rptFrstIptnService.selectRptFrstIptn(rptFrstIptnVO);
//    }
//
//    @RequestMapping("/rptFrstIptn/updateRptFrstIptn.do")
//    public String updateRptFrstIptn(
//            RptFrstIptnVO rptFrstIptnVO,
//            @ModelAttribute("searchVO") RptFrstIptnDefaultVO searchVO, SessionStatus status)
//            throws Exception {
//        rptFrstIptnService.updateRptFrstIptn(rptFrstIptnVO);
//        status.setComplete();
//        return "forward:/rptFrstIptn/RptFrstIptnList.do";
//    }
//    
//    @RequestMapping("/rptFrstIptn/deleteRptFrstIptn.do")
//    public String deleteRptFrstIptn(
//            RptFrstIptnVO rptFrstIptnVO,
//            @ModelAttribute("searchVO") RptFrstIptnDefaultVO searchVO, SessionStatus status)
//            throws Exception {
//        rptFrstIptnService.deleteRptFrstIptn(rptFrstIptnVO);
//        status.setComplete();
//        return "forward:/rptFrstIptn/RptFrstIptnList.do";
//    }

}
