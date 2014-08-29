package estam.app.intro.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.fdl.property.EgovPropertyService;
import estam.app.map.arcgis.service.ArcGisMapDefaultVO;

@Controller  
public class IntroController {

	
	private static final Logger logger = LoggerFactory.getLogger(IntroController.class);
	 
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	 
    /**
   	 * FCTY_MGR 목록을 조회한다. (pageing)
   	 * @param searchVO - 조회할 정보가 담긴 ArcGisMapDefaultVO
   	 * @return "/arcGisMap/ArcGisMapList"
   	 * @exception Exception
   	 */
       @RequestMapping(value="/intro/IntroGisView.do")
       public String arcGisMapView(@ModelAttribute("searchVO") ArcGisMapDefaultVO searchVO,  
       		@RequestParam(value="flag", required=false) String flag, 
       		ModelMap model)
               throws Exception { 
    	   
    	   String leftMapGubun = flag;
    	   if (leftMapGubun == null) {
    		   leftMapGubun = "PGA";
    	   }
    	   model.addAttribute("leftMapGubun", flag);
           
           return "/estam/arcgis/IntroGisView";
       }  
     
}
