package estam.app.sym.cmm.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.tomatosystem.adaptor.egovframework.uiadaptor.ExriaUDDTO;
import com.tomatosystem.adaptor.exria.AdaptorConstants;
import com.tomatosystem.adaptor.exria.RequestData;

import egovframework.com.cmm.LoginVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import estam.app.com.util.ExriaUdtoMapUtil;
import estam.app.sym.cmm.service.SymCommCdDefaultVO;
import estam.app.sym.cmm.service.SymCommCdService;
import estam.app.sym.cmm.service.SymCommCdVO;

/**
 * @Class Name : SymCommCdController.java
 * @Description : SymCommCd Controller class
 * @Modification Information
 *
 * @author atres
 * @since 2013.07.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=SymCommCdVO.class)
public class SymCommCdController {

    @Resource(name = "symCommCdService")
    private SymCommCdService symCommCdService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    @Resource(name = "messageSource")
	protected MessageSource messageSource;
    
	@Resource(name = "beanValidator")
	private DefaultBeanValidator beanValidator;
	

    /**
     * 
     * @param searchVO
     * @param flag
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/sym/symCommCd/SymCommCd.do")
    public String pgrBarFormView(@ModelAttribute("searchVO") SymCommCdDefaultVO searchVO,  
  		    ModelMap model)
           throws Exception { 
       
        return "/estam/sym/symCommCd/SymCommCd";
    }  
    
    /**
	 * SYM_COMM_CD 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SymCommCdDefaultVO
	 * @return "/symCommCd/SymCommCdList"
	 * @exception Exception
	 */
    @RequestMapping(value="/sym/symCommCd/SymCommCdList.do")
    public String selectSymCommCdList(@ModelAttribute("searchVO") SymCommCdDefaultVO searchVO, 
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
		
        List symCommCdList = symCommCdService.selectSymCommCdList(searchVO);
        model.addAttribute("resultList", symCommCdList);
        
        int totCnt = symCommCdService.selectSymCommCdListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/sym/symCommCd/SymCommCdList";
    } 
    
    /**
   	 * SYM_COMM_CD 목록을 조회한다. (pageing)
   	 * @param searchVO - 조회할 정보가 담긴 SymCommCdDefaultVO
   	 * @return "/symCommCd/SymCommCdList"
   	 * @exception Exception
   	 */
       @RequestMapping(value="/sym/symCommCd/SymCommCdListEx.do")
       public ModelAndView selectSymCommCdListEx(ExriaUDDTO uDto, 
          		ModelMap model, HttpServletRequest request )
               throws Exception {
       	
    	    RequestData reqData = uDto.getRequestData();
          	HttpSession session = request.getSession(); 
      		session.removeAttribute("method");
      		SymCommCdDefaultVO searchVO =  (SymCommCdDefaultVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.cmm.service.SymCommCdDefaultVO"); 
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
      		
      		 
      		/*if(session.getAttribute("useSessionInfo") != null) {
      			searchVO = (SymCommCdDefaultVO)session.getAttribute("searchVO");
      			session.removeAttribute("searchVO");
      		}*/
    
//          	Map searchMap = PropertyUtils.describe(searchVO);
//      		PageVO pageVO = new PageVO(searchVO.getRecordCountPerPage(),
//      				symUserService.selectSymUserListTotCnt(searchVO),
//      				searchVO.getPageSize());
//      		searchVO.setRecordCountPerPage(pageVO.getCurrPage());
      		  
      		List symCommCdList = new ArrayList(); 
      		Map<String, Object> mm = new HashMap<String, Object>();   
             
      		List<Map<String,Object>> symCommCdMList =  symCommCdService.selectSymCommCdList(searchVO);
      		
      		Map<String, Object> symCommCdMap = new HashMap<String, Object>();
      		
      		if(symCommCdMList.size() > 0){
      			for (Map<String,Object> map : symCommCdMList) { 
          			symCommCdMap = new HashMap<String, Object>();
          			for (Map.Entry<String,Object> entry: map.entrySet()) {
          				String key = entry.getKey();
          				Object value = entry.getValue();
          				symCommCdMap.put(key, value); 
          			}   
          			symCommCdList.add(symCommCdMap); 
          		} 
          		
          		mm.put("resSymCommCdList", symCommCdList); 			
      		}else{
      			mm.put("resSymCommCdList", null); 	
      		}

      	 	
      		int totCnt = symCommCdService.selectSymCommCdListTotCnt(searchVO);
      		paginationInfo.setTotalRecordCount(totCnt);
      		ExriaUdtoMapUtil.addListToResponseMap(reqData, "paginationInfo", paginationInfo, mm);
      	
      		/*if(session.getAttribute("useSessionInfo") != null) {
      			mm.put("searchVO", reqData.getBeanToMap(searchVO));
      			session.setAttribute("useSessionInfo", null);
      		}*/
      		
      		ModelAndView mav = new ModelAndView("exriaView");
      		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
       
      		return mav; 
       } 
       
  
    
    @RequestMapping("/sym/symCommCd/saveSymCommCdEx.do")
    public ModelAndView saveSymCommCdEx(ExriaUDDTO uDto, 
    		@RequestParam("method") String method , HttpServletRequest request, SessionStatus status)
            throws Exception { 
            	 
        	RequestData reqData = uDto.getRequestData();
        	SymCommCdVO symCommCdVO = (SymCommCdVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.cmm.service.SymCommCdVO");
//          beanValidator.validate(employee, bindingResult);
        	
        	Map<String, String> message = new HashMap<String, String>();
    		Map<String, Object> mm = new HashMap<String, Object>();
    		Map<String, String> store = new HashMap<String, String>();
    		
    		HttpSession session = request.getSession();
        	LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
    		if (symCommCdVO.getCommCd() != null && symCommCdVO.getCommCd() == "") {
    			store.put("CommCd", "errors.CommCd");
    		} else {
    			if (method.equals("add")) {
    				SymCommCdVO resSymCommCdVo = symCommCdService.selectSymCommCd(symCommCdVO);
    				
    				if(resSymCommCdVo != null){
    		    		message.put("procMsg","중복된 코드가 존재합니다.");
    		    	}else{
    		    		symCommCdVO.setInptUsrId(loginVO.getUserId());
    		    		
    		    		symCommCdService.insertSymCommCd(symCommCdVO);
    		    		message.put("procMsg","");
    		    	}
    			} else if (method.equals("update")) {
    				symCommCdVO.setUpdtUsrId(loginVO.getUserId());
    				
    				symCommCdService.updateSymCommCd(symCommCdVO);
    				message.put("procMsg","");
    			}
    		}
    		
    		mm.put("message", message);
    		
    		//mm.put("validCheck", store);
    		ModelAndView mav = new ModelAndView("exriaView");
    		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
    		status.setComplete();
    		return mav;   
    		 
    } 

    @RequestMapping("/sym/symCommCd/selectSymCommCdEx.do")
    public ModelAndView selectSymCommCdEx(ExriaUDDTO uDto, HttpServletRequest request) throws Exception {
    	 
    	RequestData reqData = uDto.getRequestData(); 
    	SymCommCdVO reqSymCommCdVO = (SymCommCdVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.cmm.service.SymCommCdVO");
		
		Map<String, Object> mm = new HashMap<String, Object>();
		SymCommCdVO resSymCommCdVo = symCommCdService.selectSymCommCd(reqSymCommCdVO);
		
		//mm.put("resSymCommCdVO", resSymCommCdVo);
		ExriaUdtoMapUtil.addListToResponseMap(reqData, "resSymCommCdVO", resSymCommCdVo, mm);
		
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
		
		return mav;  
    }
 
    
    @RequestMapping("/sym/symCommCd/deleteSymCommCdEx.do")
    public ModelAndView deleteSymCommCdEx(
            ExriaUDDTO uDto, HttpServletRequest request, SessionStatus status)
            throws Exception { 
        	
    	RequestData reqData = uDto.getRequestData();
    	SymCommCdVO symCommCdVO = (SymCommCdVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.cmm.service.SymCommCdVO");
    	
    	symCommCdService.deleteSymCommCd(symCommCdVO);
    	status.setComplete();
    	
		Map<String, String> mm = new HashMap<String, String>();
		mm.put("message", messageSource.getMessage("I9012", null, Locale.getDefault()));
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);

		return mav;   
    }

}
