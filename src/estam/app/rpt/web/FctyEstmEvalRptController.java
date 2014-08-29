package estam.app.rpt.web;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.Globals;
import egovframework.rte.fdl.property.EgovPropertyService;
import estam.app.fcty.service.FctyImgService;
import estam.app.fcty.service.FctyMgrDefaultVO;
import estam.app.fcty.service.FctyMgrService;
import estam.app.fcty.service.FctyMgrUsrDefaultVO;
import estam.app.fcty.service.FctyMgrUsrService;
import estam.app.fcty.service.FctyMgrUsrVO;
import estam.app.fcty.service.FctyMgrVO;
import estam.app.iddl.service.IddlAassInfoService;
import estam.app.iddl.service.IddlAassInfoVO;
import estam.app.iddl.service.IddlAassRlstDefaultVO;
import estam.app.iddl.service.IddlAassRlstStttService;
import estam.app.iddl.service.IddlAassRlstService;
import estam.app.iddl.service.IddlAassRlstVO;
import estam.app.iddl.service.WvIddlAassRlstVO;

import estam.app.iddl.service.IddlEhqkOcurInfoVO;
import estam.app.iddl.web.IddlAassRlstController;
import estam.app.signalux.service.SignalUxExecDefaultVO;
import estam.app.signalux.service.SignalUxExecService;
import estam.app.signalux.service.SignalUxExecVO;


/**
 * @Class Name : FctyMgrUsrController.java
 * @Description : FctyMgrUsr Controller class
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
public class FctyEstmEvalRptController {

	private static final Logger logger = LoggerFactory.getLogger(FctyEstmEvalRptController.class);
	
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_10 =  {"f_acc.rec"};  //가속도 파형3
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_10 =  {"4"};  //가속도 파형3
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_20  = {"f_vel.rec"};   //속도
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_20  = {"4"};   //속도
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_30  = {"f_dis.rec"};   //변위
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_30  = {"4"};   //변위
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_40  = {"f_hvr.rec","f_spect.rec"};   //응답스펙트럼   
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_40  = {"2","7"};   //응답스펙트럼
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_50  = {"tr_acc.rec"};   //최상층가속도
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_50  = {"3"};   //최상층가속도
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_60  = {"tr_vel.rec"};   //최상층속도
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_60  = {"3"};   //최상층속도
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_70  = {"tr_dis.rec"};   //최상층 변위
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_70  = {"3"};   //최상층 변위
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_80  = {"tr_tf.rec", "tr_dis.rec"};   //안정성평가결과
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_80  = {"3", "3"};   //안정성평가결과

//    @Resource(name = "fctyMgrUsrService")
//    private FctyMgrUsrService fctyMgrUsrService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
	@Resource(name = "fctyMgrService")
	private FctyMgrService fctyMgrService;
	    
	@Resource(name = "fctyImgService")
	private FctyImgService fctyImgService;

	
	@Resource(name = "iddlAassRlstStttService")
    private IddlAassRlstStttService iddlAassRlstStttService;
	
	@Resource(name = "iddlAassInfoService")
    private IddlAassInfoService iddlAassInfoService;
	
    /** EgovCmmUseService */
	@Resource(name="EgovCmmUseService")
	private EgovCmmUseService cmmUseService;
	
	@Resource(name = "iddlAassRlstService")
    private IddlAassRlstService iddlAassRlstService;
    
    /**
	 * 보고서작성 - 개별 시설물 건전성 평가 보고서 
	 * @param searchVO - 조회할 정보가 담긴 FctyMgrUsrDefaultVO
	 * @return "/fctyMgrUsr/FctyMgrUsrList"
	 * @exception Exception
	 */
    @RequestMapping(value="/rpt/FctyEstmEvalRpt.do")
    public String selectFctyMgrUsrList(@ModelAttribute("searchVO") FctyMgrDefaultVO searchVO , ModelMap model)
            throws Exception {
    	
	    ComDefaultCodeVO vo = new ComDefaultCodeVO();
	   	
 		vo.setCommCd("ITEM_008");
 		List fctyAreaList = cmmUseService.selectCmmCodeDetail(vo);
 		model.addAttribute("fctyAreaList", fctyAreaList);
 		
 		 
 		vo.setCommCd("ITEM_011");
 		List fctyKndList = cmmUseService.selectCmmCodeDetail(vo);
 		model.addAttribute("fctyKndList", fctyKndList);
 		
 		//logger.debug("fctyKndList"+ fctyKndList);

 		//가지고 올때 이미지 정보도 통합해서 가지고 온다.
        List fctyMgrList = fctyMgrService.selectFctyMgrList(searchVO);
        model.addAttribute("fctyMgrList", fctyMgrList);
        
        logger.debug("fctyMgrList"+ fctyMgrList);
        
        int totCnt = fctyMgrService.selectFctyMgrListTotCnt(searchVO);
        model.addAttribute("fctyMgrCnt", totCnt);
  	
        String fctycdSearch="";
        if(fctyMgrList.size() > 0) {
     	   FctyMgrVO fctyMgrVO = (FctyMgrVO)fctyMgrList.get(0);
     	   fctycdSearch = "fctycd:" + fctyMgrVO.getFctyCd() +":"+ fctyMgrVO.getGvmtCd();
        }
        model.addAttribute("fctycdSearch", fctycdSearch);  

        return "/estam/rpt/FctyEstmEvalRpt";
    }
    
    @RequestMapping("/rpt/FctyEstmEvalInfoList.do")
    public String selectFctyEstmEvalInfoList(
    		@ModelAttribute("searchVO") FctyMgrDefaultVO VO1, IddlAassRlstDefaultVO searchVO ,Model model) throws Exception {
        model.addAttribute("fctyMgrUsrVO", new FctyMgrUsrVO());
       
        
        // 지진정보
        IddlEhqkOcurInfoVO eqVo = new IddlEhqkOcurInfoVO();
        
        eqVo.setFctyCd(VO1.getFctyCd());
        eqVo.setGvmtCd(VO1.getGvmtCd());
        
        List ehqkOcurInfoList = iddlAassRlstStttService.selectIddlEhqkOcurRptInfoList(eqVo);
        model.addAttribute("ehqkOcurInfoList", ehqkOcurInfoList);

        //logger.debug("IddlEhqkOcurInfoVO"+ eqVo);
        
        /*
        IddlAassRlstVO iddlAassRlstVO1 = new IddlAassRlstVO();
  	   
  	  	iddlAassRlstVO1.setFctyCd(searchVO.getFctyCd());
  	  	iddlAassRlstVO1.setIddlAassNo(searchVO.getIddlAassNo());
        
        iddlAassRlstVO1 = iddlAassRlstService.selectIddlAassRlst(iddlAassRlstVO1);
  	  	model.addAttribute("readIddlAssRlst", iddlAassRlstVO1);
        */
        return "/estam/rpt/inc/FctyEstmEvalInfoList";
    }
    
	@RequestMapping("/rpt/FctyEstmEvalPrint.do")
	public String selectFctyEstmEvalPrint(
			  @ModelAttribute("searchVO") FctyMgrDefaultVO VO1 ,
			  FctyMgrUsrDefaultVO searchVO, 
			  IddlAassRlstDefaultVO searchVO1, 
			  Model model) throws Exception {
	      model.addAttribute("fctyMgrUsrVO", new FctyMgrUsrVO());
	      
	      IddlAassRlstVO iddlAassRlstVO1 = new IddlAassRlstVO();
		   
		  iddlAassRlstVO1.setFctyCd(searchVO1.getFctyCd());
		  iddlAassRlstVO1.setGvmtCd(searchVO1.getGvmtCd());
		  iddlAassRlstVO1.setIddlAassNo(searchVO1.getIddlAassNo());
	      
	      iddlAassRlstVO1 = iddlAassRlstService.selectIddlAassRlst(iddlAassRlstVO1);
		  model.addAttribute("readIddlAssRlst", iddlAassRlstVO1);
	      
	      
	      return "/estam/rpt/inc/FctyEstmEvalPrint";
	}    
    
	@RequestMapping("/rtp/inc/rptBlank.do")
	public String selectFctyBlank(
			  @ModelAttribute("searchVO") FctyMgrDefaultVO VO1 ,
			  FctyMgrUsrDefaultVO searchVO, 
			  IddlAassRlstDefaultVO searchVO1, 
			  Model model) throws Exception {
	      
	      return "/estam/rpt/inc/rptBlank";
	} 
	
	@RequestMapping("/rpt/FctyEstmEvalPrintGrp.do")
	public String selectFctyEstmEvalPrintGrp(
			  @ModelAttribute("searchVO") FctyMgrDefaultVO searchVO ,
			  IddlAassRlstDefaultVO searchVO1, 
			  Model model) throws Exception {

 	  String url ="/estam/rpt/inc/rptGrpDsltInfo";
	  ArrayList<WvIddlAassRlstVO> wvList = new ArrayList<WvIddlAassRlstVO>();
	  ArrayList<WvIddlAassRlstVO> wvList2 = new ArrayList<WvIddlAassRlstVO>();
	  
  	  if(searchVO.getIddlAassNo() != null) {
  			String storageFilePath =  Globals.STORAGE_ROOT;  //스토리지에 파형위치 정보를 가지고 온다...
  	   		String fileName ="";
  	   		String fileName2 ="";
  	   		String filePath ="";
  	   	
  	        IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO();
  	        
  	   		Map<String, Object> map=null;

  	   		iddlAassInfoVO.setGvmtCd(searchVO.getGvmtCd());
  	   		iddlAassInfoVO.setFctyCd(searchVO.getFctyCd());
  	   		iddlAassInfoVO.setIddlAassNo(searchVO.getIddlAassNo());
  	   		iddlAassInfoVO.setEhqkReqId(searchVO.getEhqkReqId());
  	   		iddlAassInfoVO = iddlAassInfoService.selectIddlAassInfo(iddlAassInfoVO);
  	   	
  	   		int modes = Integer.parseInt(searchVO.getModes());
  	   		filePath = iddlAassInfoVO.getWvScnRsltFlsv()+"/";

  	   		logger.error(storageFilePath + filePath);
  	    	switch (modes) {
  	    		case 30 :
  	    			//변위
  	    			url = "/estam/rpt/inc/rptGrpDsltInfo";
  	    			wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_30[0],FCTY_SCN_RSLT_FILE_COLUMN_30[0]);
  	    			break;
  	    		case 40 :
   	    			//응답스펙트럼
   	    			url = "/estam/rpt/inc/rptGrpAclnInfo";
   	    			wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_40[0],FCTY_SCN_RSLT_FILE_COLUMN_40[0]);
   	    			wvList2 = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_40[1],FCTY_SCN_RSLT_FILE_COLUMN_40[1]);
   	    			break;
  	    		default:
  	    			//가속도
  	    			url = "/estam/rpt/inc/rptGrpDsltInfo";
  	    			wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_10[0],FCTY_SCN_RSLT_FILE_COLUMN_10[0]);
  	    			break;
  	    	}
  	    	
  		    model.addAttribute("data", wvList);
  		    model.addAttribute("data2", wvList2);
  		    
  	  }else {	   
  		  model.addAttribute("data", wvList);
  		  model.addAttribute("data2", wvList2);
  	  }
  	  
       return url;
       
	} 
	
	
	public ArrayList<WvIddlAassRlstVO> readIddlAassRlstFile(String storageFilePath, String fileName, String columnCnt)
            throws Exception {
    	
    	ArrayList<WvIddlAassRlstVO> wvList = new ArrayList<WvIddlAassRlstVO>();
   		File uFile = new File(storageFilePath,fileName);
   		
	    int fSize  = (int)uFile.length();

		if (!uFile.exists()) {
			System.out.println("path_error.... please change path in this program");
		} 
		
	    if (fSize > 0) {
	    	//파일 읽기
	    	FileInputStream fls = new FileInputStream(uFile);
	    	Scanner s = new Scanner(fls);
	    	String times = "", accCol1, accCol2, accCol3, accCol4, accCol5, accCol6, accCol7; 
	    	int i=0;
	    	int columns = Integer.parseInt(columnCnt);
	    	while(s.hasNext()){
	    		WvIddlAassRlstVO v_WvIddlAassRlst = new WvIddlAassRlstVO();

	    		switch (columns) {
	   	    		case 2 :
	   	    			//응답스펙트럼
	   	    			times = s.next();
	   	    			accCol2 = s.next();
	   	    			v_WvIddlAassRlst.setRsltTimeX(new BigDecimal(times));
	   	    			v_WvIddlAassRlst.setRsltValueY2(new BigDecimal(accCol2));
	   	    			break;
	   	    		case 3:
	   	    			//최상층가속도, 최상층속도, 최상층변위, 안전성평가결과
	   	    			if(i==0) {
	   	    				accCol1 = s.nextLine();
	   	    				v_WvIddlAassRlst.setStableEvaInfVal(accCol1);
	   	    			}else {
	   	    				times = s.next();
	   	    				v_WvIddlAassRlst.setRsltTimeX(new BigDecimal(times));	   	    				
		   	    			accCol2 = s.next();
		   	    			accCol3 = s.next();
		   	    			v_WvIddlAassRlst.setRsltValueY2(new BigDecimal(accCol2));
		   	    			v_WvIddlAassRlst.setRsltValueY3(new BigDecimal(accCol3));
	   	    			}
	   	    			break;
	   	    		case 4 :
	   	    			//가속도, 속도, 변위,
	   		    		times = s.next();
	   	    			accCol2 = s.next();
	   	    			accCol3 = s.next();
	   	    			accCol4 = s.next();
	   	    			v_WvIddlAassRlst.setRsltTimeX(new BigDecimal(times));
	   	    			v_WvIddlAassRlst.setRsltValueY2(new BigDecimal(accCol2));
	   	    			v_WvIddlAassRlst.setRsltValueY3(new BigDecimal(accCol3));
	   	    			v_WvIddlAassRlst.setRsltValueY4(new BigDecimal(accCol4));
	   	    			break;
	   	    		case 7 :
	   	    			//응답스펙트럼
	   	    			times = s.next();
	   	    			accCol2 = s.next();
	   	    			accCol3 = s.next();
	   	    			accCol4 = s.next();
	   	    			accCol5 = s.next();
	   	    			accCol6 = s.next();
	   	    			accCol7 = s.next();
	   	    			v_WvIddlAassRlst.setRsltTimeX(new BigDecimal(times));
	   	    			v_WvIddlAassRlst.setRsltValueY2(new BigDecimal(accCol2));
	   	    			v_WvIddlAassRlst.setRsltValueY3(new BigDecimal(accCol3));
	   	    			v_WvIddlAassRlst.setRsltValueY4(new BigDecimal(accCol4));
	   	    			v_WvIddlAassRlst.setRsltValueY5(new BigDecimal(accCol5));
	   	    			v_WvIddlAassRlst.setRsltValueY6(new BigDecimal(accCol6));
	   	    			v_WvIddlAassRlst.setRsltValueY7(new BigDecimal(accCol7));
	   	    			break;
	   	    		default:
	   	    			//최상층가속도, 최상층속도, 최상층변위, 안전성평가결과
	   	    			times = s.next();
	   	    			accCol2 = s.next();
	   	    			accCol3 = s.next();
	   	    			v_WvIddlAassRlst.setRsltTimeX(new BigDecimal(times));	   	    			
	   	    			v_WvIddlAassRlst.setRsltValueY2(new BigDecimal(accCol2));
	   	    			v_WvIddlAassRlst.setRsltValueY3(new BigDecimal(accCol3));
	   	    			break;
	   	    	}	    		
	    	    wvList.add(v_WvIddlAassRlst);
	    		i++;
	    	}
	    	
	    }	
    	return wvList;
    }


}
