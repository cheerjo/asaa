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

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.property.EgovPropertyService;
import estam.app.fcty.service.FctyAddInfoService;
import estam.app.fcty.service.FctyAddInfoVO;
import estam.app.fcty.service.FctyImgService;
import estam.app.fcty.service.FctyImgVO;
import estam.app.scn.rpt.service.RptMgrDefaultVO;
import estam.app.scn.rpt.service.RptMgrEhqkScnDefaultVO;
import estam.app.scn.rpt.service.RptMgrEhqkScnService;
import estam.app.scn.rpt.service.RptMgrRccDefaultVO;
import estam.app.scn.rpt.service.RptMgrRccService;
import estam.app.scn.rpt.service.RptMgrService;
import estam.app.scn.rpt.service.RptMgrVO;

/**
 * @Class Name : RptMgrController.java
 * @Description : RptMgr Controller class
 * @Modification Information
 *
 * @author atres
 * @since 2013.1016
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller 
public class ScnRccManagerController {

	
	private static final Logger logger = LoggerFactory.getLogger(ScnRccManagerController.class);
	
    @Resource(name = "rptMgrService")
    private RptMgrService rptMgrService;
    
    @Resource(name = "rptMgrEhqkScnService")
    private RptMgrEhqkScnService rptMgrEhqkScnService;
    
    @Resource(name = "fctyImgService")
    private FctyImgService fctyImgService;
    
    @Resource(name = "fctyAddInfoService")
    private FctyAddInfoService fctyAddInfoService;
    
    @Resource(name = "rptMgrRccService")
    private RptMgrRccService rptMgrRccService;
   
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
    @RequestMapping(value="/scn/ScnRccManager.do")
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
    	
	    try {	
	    	
	        List rptMgrList = rptMgrService.selectRptMgrList(searchVO);
	        model.addAttribute("rptMgrList", rptMgrList);
	        
	        Map<String, Object> fctyStatSensVO = new HashMap<String, Object>();
	        String fctycdSearch="";
	        if(rptMgrList.size() > 0) {
	        	fctyStatSensVO =  (Map<String, Object>)rptMgrList.get(0); 
	        	fctycdSearch = "fctycd:" +fctyStatSensVO.get("iptDt").toString() +":"+ fctyStatSensVO.get("fctyCd").toString() +":"+ fctyStatSensVO.get("conDaGbcd").toString() +":"+ fctyStatSensVO.get("gvmtCd").toString();
	        }
	        model.addAttribute("fctycdSearch", fctycdSearch);
	        
	        //int totCnt = rptMgrService.selectRptMgrListTotCnt(searchVO); 
	        //model.addAttribute("rptMgrCnt", totCnt);
	        
	    } catch(EgovBizException egbe){
		   	 
	    	logger.debug("selectRptMgrList - EgovBizException : " + egbe.getMessage());
	    	logger.debug("selectRptMgrList - EgovBizException : " + egbe.getMessageKey());
	   		//egbe.printStackTrace();
	   	 
		} 
	    
        return "/estam/scn/rpt/ScnRccManager";
    } 
    

    /**
     * 시설물 상단 기본정보  출력부 처리  
     * @param rptMgrVO
     * @param searchVO
     * @return
     * @throws Exception
     */
    
    @RequestMapping("/scn/rptFctyMgrTopInfo.do")
    public  String  rptFctyMgrTopInfo( 
            @ModelAttribute("searchVO") RptMgrDefaultVO searchVO,ModelMap model) throws Exception {
  	        
	   	 FctyImgVO fctyImgVO = new FctyImgVO();
	   	 FctyAddInfoVO fctyAddInfoVO  = new FctyAddInfoVO();  //시설물추가정보  
	   	// StringBuffer sbRptFctyInfo = new StringBuffer(); 
	     
	   	 try {
	   		 
	   		 //이미지 정보  
		   	fctyImgVO.setFctyCd(searchVO.getFctyCd());  
		   	fctyImgVO.setGvmtCd(searchVO.getGvmtCd());
			fctyImgVO  = fctyImgService.selectFctyImg(fctyImgVO);
			
		    fctyAddInfoVO.setFctyCd(searchVO.getFctyCd()); 
		    fctyAddInfoVO.setGvmtCd(searchVO.getGvmtCd());
	        fctyAddInfoVO = fctyAddInfoService.selectFctyAddInfo(fctyAddInfoVO);
	         
	        
	    } catch(EgovBizException egbe){
	   	 
	    	logger.debug("EgovBizException : " + egbe.getMessage());
	    	logger.debug("EgovBizException : " + egbe.getMessageKey());
	   		//egbe.printStackTrace();
	   	 
		} 
	   	 
	   	 model.addAttribute("fctyImgUrl", fctyImgVO);  
         model.addAttribute("fctyAddRsltMgr", fctyAddInfoVO);
 	    //model.addAttribute("rptFctyMgrTop", sbRptFctyInfo);
	    
	    return "/estam/scn/rpt/inc/rptFctyMgrTopInfo";
	     
    } 
      
	
    /**
     * 시설물 관리대장 정보 
     * @param rptMgrVO
     * @param searchVO
     * @return
     * @throws Exception
     */
    @RequestMapping("/scn/rptFctyMgrCenterInfo.do")
    public  String rptFctyMgrCenterInfo( 
            @ModelAttribute("searchVO") RptMgrDefaultVO searchVO,ModelMap model) throws Exception {
  	     
    	 //시설물 기본정보 	
     	 RptMgrVO rptMgrVO = new RptMgrVO(); 
   	  
	   	 try { 
	   	  
	   		rptMgrVO.setIptDt(searchVO.getIptDt());
	     	rptMgrVO.setFctyCd(searchVO.getFctyCd());
	     	rptMgrVO.setConDaGbcd(searchVO.getConDaGbcd()); //관리대장보고서
	     	rptMgrVO.setGvmtCd(searchVO.getGvmtCd()); //관리대장보고서
	     	
	     	rptMgrVO = rptMgrService.selectRptMgr(rptMgrVO);
	     	model.addAttribute("rptFctyMgr", rptMgrVO);
	     	
	   	    //시설물 지진가속도계 통합정보 
	        List rptFctyMgrTotScnList = rptMgrService.selectRptFctyMgrScnList(searchVO);
	         model.addAttribute("rptFctyMgrTotScnList", rptFctyMgrTotScnList);
	   	    //시설물 지진가속도기록계 통합정보 
	        List rptFctyMgrTotRccList = rptMgrService.selectRptFctyMgrRccList(searchVO);
	   	    model.addAttribute("rptFctyMgrTotRccList", rptFctyMgrTotRccList);
	        
	    } catch(EgovBizException egbe){
	   	 
	    	logger.debug("EgovBizException" + egbe.getMessage());
	    	logger.debug("EgovBizException : " + egbe.getMessageKey());
	   		//egbe.printStackTrace();
	   	 
		} 	 
        
        return "/estam/scn/rpt/inc/RptFctyMgrCenterInfo";
    } 
    
    /**
     * 시설물 센서/기록계정보 
     * @param rptMgrVO
     * @param searchVO
     * @return
     * @throws Exception
     */
    @RequestMapping("/scn/rptFctyMgrRightInfo.do")
    public  String rptFctyMgrRightInfo( 
            @ModelAttribute("searchVO") RptMgrDefaultVO searchVO,ModelMap model) throws Exception {
  	      
  	   
  	   //시설물 계측기 지진가속도계 상세정보리스트 
    	RptMgrEhqkScnDefaultVO rptMgrEhqkScnDefaultVO = new RptMgrEhqkScnDefaultVO(); 
    	rptMgrEhqkScnDefaultVO.setIptDt(searchVO.getIptDt());
    	rptMgrEhqkScnDefaultVO.setFctyCd(searchVO.getFctyCd());
    	rptMgrEhqkScnDefaultVO.setConDaGbcd(searchVO.getConDaGbcd());
  	    List rptMgrEhqkScnList = rptMgrEhqkScnService.selectRptMgrEhqkScnList(rptMgrEhqkScnDefaultVO);
  	    model.addAttribute("rptMgrEhqkScnList", rptMgrEhqkScnList);
  	    
  	    //시설물 게측기 지진가속도기록계 상세정보리스트  
  	    RptMgrRccDefaultVO rptMgrRccDefaultVO = new RptMgrRccDefaultVO();
  	    rptMgrRccDefaultVO.setIptDt(searchVO.getIptDt());
  	    rptMgrRccDefaultVO.setFctyCd(searchVO.getFctyCd());
  	    rptMgrRccDefaultVO.setConDaGbcd(searchVO.getConDaGbcd());
        List rptMgrRccList = rptMgrRccService.selectRptMgrRccList(rptMgrRccDefaultVO);
        model.addAttribute("rptMgrRccList", rptMgrRccList);  
        
        return "/estam/scn/rpt/inc/RptFctyMgrRightInfo";
    }  

    /**
     * 시설물 관리대장 정보 
     * @param rptMgrVO
     * @param searchVO
     * @return
     * @throws Exception
     */
    @RequestMapping("/scn/addSptIptnRsltFctyMgrInfo.do")
    public  String SptIptnRsltFctyMgrInfo( 
            @ModelAttribute("searchVO") RptMgrDefaultVO searchVO,ModelMap model) throws Exception {
  	     
    	 //시설물 기본정보 	
     	 RptMgrVO rptMgrVO = new RptMgrVO(); 
     	 //시설물 계측기 지진가속도계 상세정보리스트 
     	 RptMgrEhqkScnDefaultVO rptMgrEhqkScnDefaultVO = new RptMgrEhqkScnDefaultVO(); 
     	 //시설물 게측기 지진가속도기록계 상세정보리스트  
  	     RptMgrRccDefaultVO rptMgrRccDefaultVO = new RptMgrRccDefaultVO();
   	  
	   	 try { 
	   	  
	   		rptMgrVO.setIptDt(searchVO.getIptDt());
	     	rptMgrVO.setFctyCd(searchVO.getFctyCd());
	     	rptMgrVO.setConDaGbcd(searchVO.getConDaGbcd()); //관리대장보고서
	     	rptMgrVO.setGvmtCd(searchVO.getGvmtCd()); //관리대장보고서
	     	
	     	rptMgrVO = rptMgrService.selectRptMgr(rptMgrVO);
	     	model.addAttribute("rptFctyMgr", rptMgrVO);
	     	
	   	    //시설물 지진가속도계 통합정보 
	        List rptFctyMgrTotScnList = rptMgrService.selectRptFctyMgrScnList(searchVO);
	         model.addAttribute("rptFctyMgrTotScnList", rptFctyMgrTotScnList);
	   	    //시설물 지진가속도기록계 통합정보 
	        List rptFctyMgrTotRccList = rptMgrService.selectRptFctyMgrRccList(searchVO);
	   	    model.addAttribute("rptFctyMgrTotRccList", rptFctyMgrTotRccList);
	   	    
	   	    rptMgrEhqkScnDefaultVO.setIptDt(searchVO.getIptDt());
	    	rptMgrEhqkScnDefaultVO.setFctyCd(searchVO.getFctyCd());
	    	rptMgrEhqkScnDefaultVO.setConDaGbcd(searchVO.getConDaGbcd());
	  	    List rptMgrEhqkScnList = rptMgrEhqkScnService.selectRptMgrEhqkScnList(rptMgrEhqkScnDefaultVO);
	  	    model.addAttribute("rptMgrEhqkScnList", rptMgrEhqkScnList);
	  	    
	  	    rptMgrRccDefaultVO.setIptDt(searchVO.getIptDt());
	  	    rptMgrRccDefaultVO.setFctyCd(searchVO.getFctyCd());
	  	    rptMgrRccDefaultVO.setConDaGbcd(searchVO.getConDaGbcd());
	        List rptMgrRccList = rptMgrRccService.selectRptMgrRccList(rptMgrRccDefaultVO);
	        model.addAttribute("rptMgrRccList", rptMgrRccList);  
	        
	    } catch(EgovBizException egbe){
	   	 
	    	logger.debug("EgovBizException" + egbe.getMessage());
	    	logger.debug("EgovBizException : " + egbe.getMessageKey());
	   		//egbe.printStackTrace();
	   	 
		} 	 
        
        return "estam/spt/inc/SptIptnRsltFctyMgrInfo";
    } 
}
