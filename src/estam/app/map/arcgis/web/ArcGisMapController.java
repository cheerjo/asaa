package estam.app.map.arcgis.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import estam.app.fcty.service.FctyMgrService;
import estam.app.fcty.service.FctyStatSensDefaultVO;
import estam.app.fcty.service.FctyStatSensVO;
import estam.app.main.service.MainEventSensVO;
import estam.app.main.service.MainMenuMgrVO;
import estam.app.main.web.MainController;
import estam.app.map.arcgis.service.ArcGisMapService;
import estam.app.map.arcgis.service.ArcGisMapDefaultVO;
import estam.app.map.arcgis.service.ArcGisMapVO;

/**
 * @Class Name : ArcGisMapController.java
 * @Description : ArcGisMap Controller class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.01
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=ArcGisMapVO.class)
public class ArcGisMapController {

	
	private static final Logger logger = LoggerFactory.getLogger(ArcGisMapController.class);
	
    @Resource(name = "arcGisMapService")
    private ArcGisMapService arcGisMapService;
     
	@Resource(name = "fctyMgrService")
	private FctyMgrService fctyMgrService;
	  
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	 
    /**
   	 * FCTY_MGR 목록을 조회한다. (pageing)
   	 * @param searchVO - 조회할 정보가 담긴 ArcGisMapDefaultVO
   	 * @return "/arcGisMap/ArcGisMapList"
   	 * @exception Exception
   	 */
       @RequestMapping(value="/arcgis/ArcGisMapView.do")
       public String arcGisMapView(@ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO,  
       		@RequestParam(value="flag", required=false) String flag, 
       		ModelMap model)
               throws Exception { 
    	   
    	   String leftMapGubun = flag;
    	   if (leftMapGubun == null) {
    		   leftMapGubun = "PGA";
    	   }
    	   model.addAttribute("leftMapGubun", flag);
           
           return "/estam/arcgis/ArcGisMapView";
       } 
       
       /**
      	 * FCTY_MGR 목록을 조회한다. (pageing)
      	 * @param searchVO - 조회할 정보가 담긴 ArcGisMapDefaultVO
      	 * @return "/arcGisMap/ArcGisMapList"
      	 * @exception Exception
      	 */
          @RequestMapping(value="/arcgis/ArcGisMapViewFull.do")
          public String arcGisMapViewFull(@ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO,  
          		@RequestParam(value="flag", required=false) String flag, 
          		ModelMap model)
                  throws Exception { 
       	   
       	   String leftMapGubun = flag;
       	   if (leftMapGubun == null) {
       		   leftMapGubun = "PGA";
       	   }
       	   model.addAttribute("leftMapGubun", flag);
              
              return "/estam/arcgis/ArcGisMapViewFull";
          } 
          
          
          /**
         	 * FCTY_MGR 목록을 조회한다. (pageing)
         	 * @param searchVO - 조회할 정보가 담긴 ArcGisMapDefaultVO
         	 * @return "/arcGisMap/ArcGisMapList"
         	 * @exception Exception
         	 */
             @RequestMapping(value="/arcgis/ArcGisEvntMapViewFull.do")
             public String arcGisEvntMapViewFull(@ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO,  
             		@RequestParam(value="flag", required=false) String flag, 
             		ModelMap model)
                     throws Exception { 
          	   
          	   String leftMapGubun = flag;
          	   if (leftMapGubun == null) {
          		   leftMapGubun = "PGA";
          	   }
          	   model.addAttribute("leftMapGubun", flag);
                 
                 return "/estam/arcgis/ArcGisEvntMapViewFull";
             } 
          
          
          /**
        	 * FCTY_MGR 목록을 조회한다. (pageing)
        	 * @param searchVO - 조회할 정보가 담긴 ArcGisMapDefaultVO
        	 * @return "/arcGisMap/ArcGisMapList"
        	 * @exception Exception
        	 */
            @RequestMapping(value="/arcgis/ArcGisFullMap.do")
            public String arcGisFullMap(@ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO,  
            		@RequestParam(value="flag", required=false) String flag, 
            		ModelMap model)
                    throws Exception { 
         	   
         	   String leftMapGubun = flag;
         	   if (leftMapGubun == null) {
         		   leftMapGubun = "PGA";
         	   }
         	   model.addAttribute("leftMapGubun", flag);
                
                return "/estam/arcgis/ArcGisFullMap";
            } 
            
            
            /**
          	 * FCTY_MGR 목록을 조회한다. (pageing)
          	 * @param searchVO - 조회할 정보가 담긴 ArcGisMapDefaultVO
          	 * @return "/arcGisMap/ArcGisMapList"
          	 * @exception Exception
          	 */
              @RequestMapping(value="/arcgis/ArcGisEvntFullMap.do")
              public String arcGisEvntFullMap(@ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO,  
              		@RequestParam(value="flag", required=false) String flag, 
              		ModelMap model)
                      throws Exception { 
           	   
           	   String leftMapGubun = flag;
           	   if (leftMapGubun == null) {
           		   leftMapGubun = "PGA";
           	   }
           	   model.addAttribute("leftMapGubun", flag);
                  
                  return "/estam/arcgis/ArcGisEvntFullMap";
              }
       
       
       /**
      	 * FCTY_MGR 목록을 조회한다. (pageing)
      	 * @param searchVO - 조회할 정보가 담긴 ArcGisMapDefaultVO
      	 * @return "/arcGisMap/ArcGisMapList"
      	 * @exception Exception
      	 */
          @RequestMapping(value="/arcgis/ArcGisEvntMapView.do")
          public String arcGisEvntMapView(@ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO,  
          		@RequestParam(value="flag", required=false) String flag, 
          		ModelMap model)
                  throws Exception { 
       	   
       	   String leftMapGubun = flag;
       	   if (leftMapGubun == null) {
       		   leftMapGubun = "PGA";
       	   }
       	   model.addAttribute("leftMapGubun", flag);
              
              return "/estam/arcgis/ArcGisEvntMapView";
          } 
       
       /**
      	 * FCTY_MGR 목록을 조회한다. (pageing)
      	 * @param searchVO - 조회할 정보가 담긴 ArcGisMapDefaultVO
      	 * @return "/arcGisMap/ArcGisMapList"
      	 * @exception Exception
      	 */
          @RequestMapping(value="/arcgis/ArcGisMapJsonView.do")
          @ResponseBody 
          public String arcGisMapJsonView(@ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO,  
          		@RequestParam(value="flag", required=false) String flag, 
          		ModelMap model)
                  throws Exception { 
        	  Map<String, Object> gisDataMap = new HashMap<String, Object>();  
        	  ObjectMapper m = new ObjectMapper(); 
        	  String reqDataJson =  "";
        	  
        	//선택된 flag 값에 따른 지도 표출
        	String leftMapGubun = flag;
        	
        	logger.debug("leftMapGubun : " + leftMapGubun);
        	
        	 try {   
        			//List toList = new ArrayList(); /*Json 데이터중 리스트 구조의 데이터를 추출하기 위해선언*/
	        		//선택된 값에 따라  지도 표출 데이터를 가죠오는 함수 호출
	             	List listMapLocation = mapLocationService(leftMapGubun);
	             	model.put("listMapLocation", listMapLocation);   
	             	model.put("leftMapGubun", leftMapGubun);       //지도맵처리구분자.
        			 
	             	gisDataMap.put("listMapLocation", listMapLocation);    
        			reqDataJson = m.writeValueAsString(gisDataMap);
        			logger.debug("listMapLocation : " + reqDataJson);
        			 
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
           
      	
      	private List mapLocationService(String strleftMapGubun) throws Exception 
      	{
      		 
      		List listMapResult =  null;
      		//PGA
      		if ("PGA".equals(strleftMapGubun)) {
      			
      			listMapResult = fctyMgrService.selectFctyPga();
      			
      		//진도(MMI)
      		} else if ("MM".equals(strleftMapGubun)) {
      			
      			listMapResult = fctyMgrService.selectFctyMmi(); 
      	        
      		//계측소
      		} else if ("GVMT".equals(strleftMapGubun)) {
      			
      			listMapResult = fctyMgrService.selectFctyGvmt();
      	        
      		//지반분류	
      		} else if ("GRND".equals(strleftMapGubun)) {
      			
      			listMapResult = fctyMgrService.selectFctyGrnd();
      	        
      		//이상진동감지	
      		} else if ("EVNT".equals(strleftMapGubun)) {
      			 
      			listMapResult = fctyMgrService.selectFctyEvnt();
      	        
      		} 
      		
      		return listMapResult; 
      	}
          
          
          
    /**
	 * FCTY_MGR 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 ArcGisMapDefaultVO
	 * @return "/arcGisMap/ArcGisMapList"
	 * @exception Exception
	 */
    @RequestMapping(value="/arcGisMap/ArcGisMapList.do")
    public String selectArcGisMapList(@ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO, 
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
		
        List arcGisMapList = arcGisMapService.selectArcGisMapList(searchVO);
        model.addAttribute("resultList", arcGisMapList);
        
        int totCnt = arcGisMapService.selectArcGisMapListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/arcGisMap/ArcGisMapList";
    } 
    
    @RequestMapping("/arcGisMap/addArcGisMapView.do")
    public String addArcGisMapView(
            @ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("arcGisMapVO", new ArcGisMapVO());
        return "/arcGisMap/ArcGisMapRegister";
    }
    
    @RequestMapping("/arcGisMap/addArcGisMap.do")
    public String addArcGisMap(
            ArcGisMapVO arcGisMapVO,
            @ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO, SessionStatus status)
            throws Exception {
        arcGisMapService.insertArcGisMap(arcGisMapVO);
        status.setComplete();
        return "forward:/arcGisMap/ArcGisMapList.do";
    }
    
    @RequestMapping("/arcGisMap/updateArcGisMapView.do")
    public String updateArcGisMapView(
            @RequestParam("fctyCd") java.lang.String fctyCd ,
            @ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO, Model model)
            throws Exception {
        ArcGisMapVO arcGisMapVO = new ArcGisMapVO();
        arcGisMapVO.setFctyCd(fctyCd);
        // 변수명은 CoC 에 따라 arcGisMapVO
        model.addAttribute(selectArcGisMap(arcGisMapVO, searchVO));
        return "/arcGisMap/ArcGisMapRegister";
    }

    @RequestMapping("/arcGisMap/selectArcGisMap.do")
    public @ModelAttribute("arcGisMapVO")
    ArcGisMapVO selectArcGisMap(
            ArcGisMapVO arcGisMapVO,
            @ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO) throws Exception {
        return arcGisMapService.selectArcGisMap(arcGisMapVO);
    }

    @RequestMapping("/arcGisMap/updateArcGisMap.do")
    public String updateArcGisMap(
            ArcGisMapVO arcGisMapVO,
            @ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO, SessionStatus status)
            throws Exception {
        arcGisMapService.updateArcGisMap(arcGisMapVO);
        status.setComplete();
        return "forward:/arcGisMap/ArcGisMapList.do";
    }
    
    @RequestMapping("/arcGisMap/deleteArcGisMap.do")
    public String deleteArcGisMap(
            ArcGisMapVO arcGisMapVO,
            @ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO, SessionStatus status)
            throws Exception {
        arcGisMapService.deleteArcGisMap(arcGisMapVO);
        status.setComplete();
        return "forward:/arcGisMap/ArcGisMapList.do";
    }

}
