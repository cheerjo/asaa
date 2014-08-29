package estam.app.chrt.flot.web;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.cmm.service.Globals;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import estam.app.iddl.service.IddlAassInfoDefaultVO;
import estam.app.iddl.service.IddlAassInfoService;
import estam.app.iddl.service.IddlAassInfoVO;
import estam.app.iddl.service.IddlAassWvflService;
import estam.app.iddl.service.WvIddlAassRlstVO;

/**
 * @Class Name : ConMmaDataController.java
 * @Description : ConMmaData Controller class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller 
public class FlotFormController {

	 private static final Logger logger = LoggerFactory.getLogger(FlotFormController.class);
  
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
	 
//    @Resource(name = "conMmaDataService")
//    private ConMmaDataService conMmaDataService; 
    
	  @Resource(name = "iddlAassInfoService")
	  private IddlAassInfoService iddlAassInfoService;
	   
	  @Resource(name = "iddlAassWvflService")
	  private IddlAassWvflService iddlAassWvflService;
	  
    /** EgovPropertyService */
//    @Resource(name = "propertiesService")
//    protected EgovPropertyService propertiesService;
	 
    /**
     * 
     * @param searchVO
     * @param flag
     * @param model
     * @return
     * @throws Exception
     * @ModelAttribute("searchVO") ConMmaDataDefaultVO searchVO   
     */
	 
    @RequestMapping(value="/flot/WaveForm.do")
    public String waveFormView( ModelMap model) 
           throws Exception {    
		   
        return "estam/chart/flot/WaveForm";
    
    }  
	 
    @RequestMapping(value="/flot/SimplePage.do",method=RequestMethod.GET)
    public String testFormView()
           throws Exception {   
    	   
        return "estam/chart/SimplePage";
    }  
     
	 
	/**
     * 
     * @param searchVO
     * @param flag
     * @param model
     * @return
     * @throws Exception
     */
     
    @RequestMapping(value="/flot/PgrBarForm.do")
    public String pgrBarFormView( ModelMap model)
           throws Exception {   
    	  
        return "estam/chart/flot/PgrBarForm";
    }   
    
    
    /**
     * 파형정보 화면 호출 
     * @param searchVO
     * @param flag
     * @param model
     * @return
     * @throws Exception
     * @ModelAttribute("searchVO") ConMmaDataDefaultVO searchVO   
     */
 
    @RequestMapping(value="/flot/WaveEventForm.do")
    public String waveEventFormView(  ModelMap model) 
           throws Exception {   
    	    
		   
        return "estam/chart/flot/WaveEventForm";
    }  
	
	
   	/**
        * 
        * @param searchVO
        * @param flag
        * @param model
        * @return
        * @throws Exception
        */
      
       @RequestMapping(value="/flot/PgrEventBarForm.do")
       public String pgrEventBarFormView( ModelMap model)
              throws Exception {  
       	   
           return "estam/chart/flot/PgrEventBarForm";
       }   
       
    	/**
        * 
        * @param searchVO
        * @param flag
        * @param model
        * @return
        * @throws Exception
        */
      
    @RequestMapping(value="/flot/PopWaveForm.do") 
   	public String PopWaveForm(@ModelAttribute("searchVO") IddlAassInfoDefaultVO searchVO, 
       		ModelMap model)
       	            throws Exception {
   		
   		   Map<String, Object> ehqkDataMap = new HashMap<String, Object>();
   		   String storageFilePath =  Globals.STORAGE_ROOT; //스토리지에 파형위치 정보를 가지고 온다...
   		   IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO(); 
   		   
   		   //값이 없으면 자유장 최대 가속도 값...시설기관정보가져오기 
		   if ((searchVO.getEhqkReqId() == null) || searchVO.getEhqkReqId().isEmpty()) {
			  List iddlWvEvntFree =  iddlAassInfoService.selectWvEvntList(searchVO);
			  
			  Map<String,Object> mapWvEvFr = (Map<String,Object>)iddlWvEvntFree.get(0);
			  
			  searchVO.setGvmtCd(mapWvEvFr.get("gvmtCd").toString());
			  searchVO.setFctyCd(mapWvEvFr.get("fctyCd").toString());
			  searchVO.setIddlAassNo(new BigDecimal(mapWvEvFr.get("iddlAassNo").toString()));
			  searchVO.setEhqkReqId(mapWvEvFr.get("ehqkReqId").toString());
			  searchVO.setEhqkTranGbcd(mapWvEvFr.get("ehqkTranGbcd").toString());
			  model.addAttribute("mapWvEvFr", mapWvEvFr);
		   } 
		   
   	 	  String filePath="";
   		  ArrayList<WvIddlAassRlstVO> wvList = new ArrayList<WvIddlAassRlstVO>();
   			 	  
   	 	   try{ 
   	 	        	
   		 	   	  if((searchVO.getEhqkReqId() != null) && (!searchVO.getEhqkReqId().isEmpty())) {
   	
   		 	   	   		iddlAassInfoVO.setGvmtCd(searchVO.getGvmtCd());
   		 	   	   		iddlAassInfoVO.setFctyCd(searchVO.getFctyCd());
   		 	   	   		iddlAassInfoVO.setIddlAassNo(searchVO.getIddlAassNo());
   		 	   	   		iddlAassInfoVO.setEhqkReqId(searchVO.getEhqkReqId()); 
   		 	   	   	    iddlAassInfoVO.setEhqkTranGbcd(searchVO.getEhqkTranGbcd());
   		 	   	   		
   		 	   	   		iddlAassInfoVO = iddlAassInfoService.selectIddlAassInfo(iddlAassInfoVO);   	   		
   		 	   	   		
   		 	   	   		//int modes = Integer.parseInt(searchVO.getModes());
   		 	   	   		filePath = iddlAassInfoVO.getWvScnRsltFlsv()+"/";
   		 	   	   		
   			 	        wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_10[0], FCTY_SCN_RSLT_FILE_COLUMN_10[0]);
   			   		    model.addAttribute("data", wvList);
   			
   			   		    
   			   	  }else {	   
   			   		  model.addAttribute("data", wvList);
   	                 
   			   	  }
   		 	   	  
   		 	   	  logger.debug("데이터 출력 : " + wvList);
   	 		  
   		 	   	/*
   	 		  for(int i=0; i<waveEvntFrm.size();i++){
   				     Map<String, String> wvEvntFrmVo = new HashMap<String, String>();
   				     wvEvntFrmVo = (Map<String, String>)waveEvntFrm.get(i);
   				     //logger.debug(">>> 리스트내용중 출력..........."+detail.get("price"));
   				     //TODO 파장정보 검색해서 자유장인것만 가지고 온다.
   				     if ("".equals(wvEvntFrmVo.get("iddl_aass_scn_flcd"))) {
   				    	  //FileReader in = new FileReader(args[0]);  //읽어들일 파일을 최초 클래스 호출시 인자값으로 받아 처리한다.
   				 	      //FileReader in = new FileReader("c:/txt.txt");  //인자가 아니라, 지정된 파일명으로 호출한다. 
   				    	 
   				    	  storageFilePath = storageFilePath + wvEvntFrmVo.get("iddl_aass_scn_flsv") + wvEvntFrmVo.get("iddl_aass_scn_flnm");
   				 	      FileReader in = new FileReader(storageFilePath);
   				 	      BufferedReader br = new BufferedReader(in);
   				 	      String strWvFrm = new String();
   				 	      while((strWvFrm=br.readLine()) != null){
   				 	       // 파장에대한 정보로 데이타을 보낸다.	  3가지 파형 정보  
   				 	        
   				 	    	 StringTokenizer tokenizer = new StringTokenizer(strWvFrm, " ") ;  //TODO 구분자분
   				 	    	 wvList.add(tokenizer.nextToken());
   				 	    	 wvList.add(tokenizer.nextToken());
   				 	       
   				 	      }
   				 	     StringTokenizer tokenmap = new StringTokenizer(wvEvntFrmVo.get("iddl_aass_scn_flnm"), ".") ;  //TODO 구분자분 
   			 	   
   				 	     ehqkDataMap.put(("wvEv_" + tokenmap.nextToken()),wvList);  
   				 	     
   				 	     in.close();
   				    } 
   				   */
   	 		 // }   
   	 	       
   	 	    }catch(IOException ie){
   	 	      System.out.println("파일이 존재하지 않습니다.");
   	 	      //IOException 의 경우에는, 별도로 java.io 패키지를 사용하는 경우 덧붙여 사용할 수 있다.(생략가능)
   	 	      //만약, 생략하면, 그냥 catch(Exception e) 에 걸린다.
   	 	    }catch(Exception e){
   	 	      System.out.println(e);
   	 	    } 
   		 	 
           return "estam/chart/flot/PopWaveForm";
       }  
       
        
	/** 
	 *  챠트 보이기 이벤트 파형에 대한 챠트... 
     * @param ehqkJsonData
     * @return
     * @throws Exception 
     */
	@RequestMapping(value="/flot/BarEvntFrmJson.do")
    @ResponseBody 
	public String getBarEvntFrmJson(@RequestBody Map<String,Object> ehqkJsonData) throws Exception{  
		
	  Map<String, Object> ehqkDataMap = new HashMap<String, Object>();
	  
	  ObjectMapper m = new ObjectMapper(); 
	  String reqDataJson =  "";
	 // String storageFilePath =  Globals.STORAGE_ROOT;
	 // List wvList = new ArrayList();
	  IddlAassInfoDefaultVO searchVO = new IddlAassInfoDefaultVO(); 
	   
	  try {   
			//	  List toList = new ArrayList(); /*Json 데이터중 리스트 구조의 데이터를 추출하기 위해선언*/
			//
			//	  toList= (ArrayList)body.get("data");
			// 
			//	  for(int i=0; i<toList.size();i++){
			//	     Map<String, Object> detail = new HashMap<String, Object>();
			//	     detail = (Map<String, Object>)toList.get(i);
			//	     logger.debug(">>> 리스트내용중 출력..........."+detail.get("price"));
			//	 } 
		  
		   
	 	   try{
	 		   
	 		  searchVO.setFctyCd(ehqkJsonData.get("fctyCd").toString());
	 		  searchVO.setGvmtCd(ehqkJsonData.get("gvmtCd").toString());
			  //  searchVO.setIddlAassNo(new BigDecimal(ehqkJsonData.get("iddlAassNo").toString()));
	 		  searchVO.setEhqkReqId(ehqkJsonData.get("ehqkReqId").toString());
	 		  searchVO.setEhqkTranGbcd(ehqkJsonData.get("ehqkTranGbcd").toString());  
			    
			   List barEvntFrmList = iddlAassInfoService.selectBarEventFrmInfo(searchVO);
			   ehqkDataMap.put("barEvntFrmList", barEvntFrmList); 
			    
	 	      
	 	    }catch(IOException ie){
	 	      System.out.println("파일이 존재하지 않습니다.");
	 	      //IOException 의 경우에는, 별도로 java.io 패키지를 사용하는 경우 덧붙여 사용할 수 있다.(생략가능)
	 	      //만약, 생략하면, 그냥 catch(Exception e) 에 걸린다.
	 	    }catch(Exception e){
	 	      System.out.println(e);
	 	    } 
		 	 
			 reqDataJson = m.writeValueAsString(ehqkDataMap);
			 logger.debug("EhqkInfoJson : " + reqDataJson);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	  return reqDataJson;    
   } 

	
	/** 
	 *  챠트 보이기 이벤트 파형에 대한 챠트... (2014.01.03 신규작성)  
	 * @param ehqkJsonData
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/flot/BarEvntFrm.do")
	@ResponseBody 
	public String getBarEvntFrm(@ModelAttribute("searchVO") IddlAassInfoDefaultVO searchVO, ModelMap model) throws Exception{  
		
		Map<String, Object> ehqkDataMap = new HashMap<String, Object>();

		ObjectMapper m = new ObjectMapper(); 
		String reqDataJson =  "";

		try {   
		  
			try{
				List barEvntFrmList = iddlAassInfoService.selectBarEventFrmInfo2(searchVO);
				ehqkDataMap.put("barEvntFrmList", barEvntFrmList); 
			  
			}catch(IOException ie){
				System.out.println("파일이 존재하지 않습니다.");
				//IOException 의 경우에는, 별도로 java.io 패키지를 사용하는 경우 덧붙여 사용할 수 있다.(생략가능)
				//만약, 생략하면, 그냥 catch(Exception e) 에 걸린다.
			}catch(Exception e){
				System.out.println(e);
			} 
			 
			reqDataJson = m.writeValueAsString(ehqkDataMap);
			logger.debug("EhqkInfoJson : " + reqDataJson);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reqDataJson;    
	} 
	
	
		/**
     * 3개파형 출력을 위한 처리  
     * @param ehqkJsonData
     * @return
     * @throws Exception 
     */
	@RequestMapping(value="/flot/WaveEvntFrmJson.do") 
	public String getWaveEvntFrmJson(@ModelAttribute("searchVO") IddlAassInfoDefaultVO searchVO, 
    		ModelMap model)
    	            throws Exception {
		
		   Map<String, Object> ehqkDataMap = new HashMap<String, Object>();
		   String storageFilePath =  Globals.STORAGE_ROOT; //스토리지에 파형위치 정보를 가지고 온다...
		   IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO();
		   
		   //값이 없으면 자유장 최대 가속도 값...시설기관정보가져오기 
		   if ((searchVO.getEhqkReqId() == null) || searchVO.getEhqkReqId().isEmpty()) {
			  List iddlWvEvntFree =  iddlAassInfoService.selectWvEvntList(searchVO);
			  
			  Map<String,Object> mapWvEvFr = (Map<String,Object>)iddlWvEvntFree.get(0);
			  
			  searchVO.setGvmtCd(mapWvEvFr.get("gvmtCd").toString());
			  searchVO.setFctyCd(mapWvEvFr.get("fctyCd").toString());
			  searchVO.setIddlAassNo(new BigDecimal(mapWvEvFr.get("iddlAassNo").toString()));
			  searchVO.setEhqkReqId(mapWvEvFr.get("ehqkReqId").toString());
			  searchVO.setEhqkTranGbcd(mapWvEvFr.get("ehqkTranGbcd").toString());
			  model.addAttribute("mapWvEvFr", mapWvEvFr);
		   } 
		    
		    //TODO 파형정보 읽어오기 파일로저장된 파형정보를 읽어와 처리한다.
		    //TODO 스토리지 저장 루트적용 후처리 함 - 이전은 테스트 디렉토리 이용함.
		    //TODO 자유장 정보인지 여부 확인 할것.  시설물코드, 파형구분(자유장)을 가지고와 MAX 값 처리  
	 	  String filePath="";
		  ArrayList<WvIddlAassRlstVO> wvList = new ArrayList<WvIddlAassRlstVO>();
			 	  
	 	   try{ 
	 	        	
		 	   	  if((searchVO.getEhqkReqId() != null) && (!searchVO.getEhqkReqId().isEmpty())) {
	
		 	   	   		iddlAassInfoVO.setGvmtCd(searchVO.getGvmtCd());
		 	   	   		iddlAassInfoVO.setFctyCd(searchVO.getFctyCd());
		 	   	   		iddlAassInfoVO.setIddlAassNo(searchVO.getIddlAassNo());
		 	   	   		iddlAassInfoVO.setEhqkReqId(searchVO.getEhqkReqId()); 
		 	   	   	    iddlAassInfoVO.setEhqkTranGbcd(searchVO.getEhqkTranGbcd());
		 	   	   		
		 	   	   		iddlAassInfoVO = iddlAassInfoService.selectIddlAassInfo(iddlAassInfoVO);   	   		
		 	   	   		
		 	   	   		//int modes = Integer.parseInt(searchVO.getModes());
		 	   	   		filePath = iddlAassInfoVO.getWvScnRsltFlsv()+"/";
		 	   	   		
			 	        wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_10[0], FCTY_SCN_RSLT_FILE_COLUMN_10[0]);
			   		    model.addAttribute("data", wvList);
			
			   		    
			   	  }else {	   
			   		  model.addAttribute("data", wvList);
	                 
			   	  }
		 	   	  
		 	   	  logger.debug("데이터 출력 : " + wvList);
	 		  
		 	   	/*
	 		  for(int i=0; i<waveEvntFrm.size();i++){
				     Map<String, String> wvEvntFrmVo = new HashMap<String, String>();
				     wvEvntFrmVo = (Map<String, String>)waveEvntFrm.get(i);
				     //logger.debug(">>> 리스트내용중 출력..........."+detail.get("price"));
				     //TODO 파장정보 검색해서 자유장인것만 가지고 온다.
				     if ("".equals(wvEvntFrmVo.get("iddl_aass_scn_flcd"))) {
				    	  //FileReader in = new FileReader(args[0]);  //읽어들일 파일을 최초 클래스 호출시 인자값으로 받아 처리한다.
				 	      //FileReader in = new FileReader("c:/txt.txt");  //인자가 아니라, 지정된 파일명으로 호출한다. 
				    	 
				    	  storageFilePath = storageFilePath + wvEvntFrmVo.get("iddl_aass_scn_flsv") + wvEvntFrmVo.get("iddl_aass_scn_flnm");
				 	      FileReader in = new FileReader(storageFilePath);
				 	      BufferedReader br = new BufferedReader(in);
				 	      String strWvFrm = new String();
				 	      while((strWvFrm=br.readLine()) != null){
				 	       // 파장에대한 정보로 데이타을 보낸다.	  3가지 파형 정보  
				 	        
				 	    	 StringTokenizer tokenizer = new StringTokenizer(strWvFrm, " ") ;  //TODO 구분자분
				 	    	 wvList.add(tokenizer.nextToken());
				 	    	 wvList.add(tokenizer.nextToken());
				 	       
				 	      }
				 	     StringTokenizer tokenmap = new StringTokenizer(wvEvntFrmVo.get("iddl_aass_scn_flnm"), ".") ;  //TODO 구분자분 
			 	   
				 	     ehqkDataMap.put(("wvEv_" + tokenmap.nextToken()),wvList);  
				 	     
				 	     in.close();
				    } 
				   */
	 		 // }   
	 	       
	 	    }catch(IOException ie){
	 	      System.out.println("파일이 존재하지 않습니다.");
	 	      //IOException 의 경우에는, 별도로 java.io 패키지를 사용하는 경우 덧붙여 사용할 수 있다.(생략가능)
	 	      //만약, 생략하면, 그냥 catch(Exception e) 에 걸린다.
	 	    }catch(Exception e){
	 	      System.out.println(e);
	 	    } 
		 	 
	 
	  return "estam/chart/flot/WaveEventForm";   
	 
   }
	
	
	/**
	 * 3개파형 출력을 위한 처리(2014.01.03 신규작성)  
	 * @param ehqkJsonData
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/flot/WaveEvntFrm.do") 
	public String getWaveEvntFrm(@ModelAttribute("searchVO") IddlAassInfoDefaultVO searchVO, ModelMap model) throws Exception {
		
		String url="estam/chart/flot/WaveEventForm";
		//팝업일 경우 와 분리함
		if("popup".equals(searchVO.getWinType())){
			url="estam/chart/flot/WaveEventFormPopup";
		}
		
		String storageFilePath =  Globals.STORAGE_ROOT; //스토리지에 파형위치 정보를 가지고 온다...
		IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO();
		
		//자유장최대계측가속도값 X,Y,Z 중 제일큰값???이 불확실해서 그냥 SUM해서 순위매김
		List iddlWvEvntFree = iddlAassInfoService.selectWvEvntList(searchVO);
		EgovMap rsltMap = (EgovMap)iddlWvEvntFree.get(0);
		logger.debug(rsltMap.toString());
		
		searchVO.setGvmtCd(rsltMap.get("gvmtCd").toString());
		searchVO.setFctyCd(rsltMap.get("fctyCd").toString());
		searchVO.setIddlAassNo(new BigDecimal(rsltMap.get("iddlAassNo").toString()));
		model.addAttribute("mapWvEvFr", rsltMap);
			
		//TODO 파형정보 읽어오기 파일로저장된 파형정보를 읽어와 처리한다.
		//TODO 스토리지 저장 루트적용 후처리 함 - 이전은 테스트 디렉토리 이용함.
		//TODO 자유장 정보인지 여부 확인 할것.  시설물코드, 파형구분(자유장)을 가지고와 MAX 값 처리  
		String filePath="";
		ArrayList<WvIddlAassRlstVO> wvList = new ArrayList<WvIddlAassRlstVO>();
			  
		try{ 
				
			if(searchVO.getIddlAassNo() != null && searchVO.getEhqkReqId() != null) {
				iddlAassInfoVO.setGvmtCd(searchVO.getGvmtCd());
				iddlAassInfoVO.setFctyCd(searchVO.getFctyCd());
				iddlAassInfoVO.setIddlAassNo(searchVO.getIddlAassNo());
				iddlAassInfoVO.setEhqkReqId(searchVO.getEhqkReqId()); 

				iddlAassInfoVO = iddlAassInfoService.selectIddlAassInfo(iddlAassInfoVO);   	   		

				//int modes = Integer.parseInt(searchVO.getModes());
				filePath = iddlAassInfoVO.getWvScnRsltFlsv()+"/";

				wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_10[0], FCTY_SCN_RSLT_FILE_COLUMN_10[0]);
				model.addAttribute("data", wvList);
			}else {	   
				model.addAttribute("data", wvList);
			}
			  
			logger.debug("데이터 출력 : " + wvList);
		  
		}catch(IOException ie){
			System.out.println("파일이 존재하지 않습니다.");
			//IOException 의 경우에는, 별도로 java.io 패키지를 사용하는 경우 덧붙여 사용할 수 있다.(생략가능)
			//만약, 생략하면, 그냥 catch(Exception e) 에 걸린다.
		}catch(Exception e){
			System.out.println(e);
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
