package estam.app.sym.grp.web;

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
import estam.app.sym.grp.service.SymPrivGrpDefaultVO;
import estam.app.sym.grp.service.SymPrivGrpService;
import estam.app.sym.grp.service.SymPrivGrpVO;
import estam.app.sym.mnu.service.SymMenuDefaultVO;
import estam.app.sym.mnu.service.SymMenuVO;
/**
 * @Class Name : SymPrivGrpController.java
 * @Description : SymPrivGrp Controller class
 * @Modification Information
 *
 * @author ATRES
 * @since 2013.07.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=SymPrivGrpVO.class)
public class SymPrivGrpController {

    @Resource(name = "symPrivGrpService")
    private SymPrivGrpService symPrivGrpService;
    
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
    @RequestMapping(value="/sym/symPrivGrp/SymPrivGrp.do")
    public String pgrBarFormView(@ModelAttribute("searchVO") SymPrivGrpDefaultVO searchVO,  
  		    ModelMap model)
           throws Exception { 
       
        return "/estam/sym/symPrivGrp/SymPrivGrp";
    }  
    
    /**
	 * SYM_PRIV_GRP 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SymPrivGrpDefaultVO
	 * @return "/symPrivGrp/SymPrivGrpList"
	 * @exception Exception
	 */
    @RequestMapping(value="/sym/symPrivGrp/SymPrivGrpList.do")
    public String selectSymPrivGrpList(@ModelAttribute("searchVO") SymPrivGrpDefaultVO searchVO, 
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
		
        List symPrivGrpList = symPrivGrpService.selectSymPrivGrpList(searchVO);
        model.addAttribute("resultList", symPrivGrpList);
        
        int totCnt = symPrivGrpService.selectSymPrivGrpListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/sym/symPrivGrp/SymPrivGrpList";
    } 
    
    /**
   	 * SYM_PRIV_GRP 목록을 조회한다. (pageing)
   	 * @param searchVO - 조회할 정보가 담긴 SymPrivGrpDefaultVO
   	 * @return "/symPrivGrp/SymPrivGrpList"
   	 * @exception Exception
   	 */
       @SuppressWarnings("unchecked")
       @RequestMapping(value="/sym/symPrivGrp/SymPrivGrpListEx.do")
       public ModelAndView selectSymPrivGrpListEx(ExriaUDDTO uDto, 
       		ModelMap model, HttpServletRequest request )
               throws Exception {
       	
    	RequestData reqData = uDto.getRequestData();
       	HttpSession session = request.getSession();
   		//session.removeAttribute("empno");
   		session.removeAttribute("method");
   		//SymPrivGrpDefaultVO searchVO = new SymPrivGrpDefaultVO();
   		
   		SymPrivGrpDefaultVO searchVO = (SymPrivGrpDefaultVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.grp.service.SymPrivGrpDefaultVO");
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
   			searchVO = (SymPrivGrpDefaultVO)session.getAttribute("searchVO");
   			session.removeAttribute("searchVO");
   		}*/
 
//       	Map searchMap = PropertyUtils.describe(searchVO);
//   		PageVO pageVO = new PageVO(searchVO.getRecordCountPerPage(),
//   				symUserService.selectSymUserListTotCnt(searchVO),
//   				searchVO.getPageSize());
//   		searchVO.setRecordCountPerPage(pageVO.getCurrPage());
   		  
   		List symPrivGrpList = new ArrayList(); 
   		Map<String, Object> mm = new HashMap<String, Object>();  
   	  
		List<Map<String,Object>> symPrivGrpMList =  symPrivGrpService.selectSymPrivGrpList(searchVO);
   		
		if(symPrivGrpMList.size() > 0){
	   		for (Map<String,Object> map : symPrivGrpMList) { 
	   			Map<String, Object> symPrivGrpMap = new HashMap<String, Object>();
	   			for (Map.Entry<String,Object> entry: map.entrySet()) {
	   				String key = entry.getKey();
	   				Object value = entry.getValue();
	   				symPrivGrpMap.put(key, value); 
	   			}   
	   			symPrivGrpList.add(symPrivGrpMap); 
	   		} 
	   		
	   		mm.put("resSymPrivGrpList", symPrivGrpList); 			
		}else{
			mm.put("resSymPrivGrpList", null);
		}

   	 	
   		int totCnt = symPrivGrpService.selectSymPrivGrpListTotCnt(searchVO);
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
    
   
    
    @RequestMapping("/sym/symPrivGrp/saveSymPrivGrpEx.do")
    public ModelAndView saveSymPrivGrpEx(ExriaUDDTO uDto, 
    		@RequestParam("method") String method , HttpServletRequest request, SessionStatus status)
            throws Exception {
    	 
    	RequestData reqData = uDto.getRequestData();
    	SymPrivGrpVO symPrivGrpVO = (SymPrivGrpVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.grp.service.SymPrivGrpVO");
//		beanValidator.validate(employee, bindingResult);
		
    	Map<String, String> message = new HashMap<String, String>();
		Map<String, Object> mm = new HashMap<String, Object>();
		Map<String, String> store = new HashMap<String, String>();

		HttpSession session = request.getSession();
    	LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");

		if (method.equals("add")) {
			
			SymPrivGrpVO resSymPrivGrpVo = symPrivGrpService.selectSymPrivGrp(symPrivGrpVO);
			if(resSymPrivGrpVo != null){
	    		message.put("procMsg","중복된 권한그룹코드가 존재합니다.");
	    	}else{
	    		symPrivGrpVO.setInptUsrId(loginVO.getUserId());
	    		
	    		symPrivGrpService.insertSymPrivGrp(symPrivGrpVO);
	    		message.put("procMsg","");
	    	}
			
		} else if (method.equals("update")) {
			 symPrivGrpService.updateSymPrivGrp(symPrivGrpVO);
			 message.put("procMsg","");
		}
		
		
		mm.put("message", message);
		
		//mm.put("validCheck", store);
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
		status.setComplete();
		return mav;   
    }
    
    

    @RequestMapping("/sym/symPrivGrp/selectSymPrivGrpEx.do")
    public ModelAndView selectSymPrivGrpEx(ExriaUDDTO uDto, HttpServletRequest request) throws Exception {
    	 
    	RequestData reqData = uDto.getRequestData(); 
    	SymPrivGrpVO symPrivGrpVO = (SymPrivGrpVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.grp.service.SymPrivGrpVO");
		
		Map<String, Object> mm = new HashMap<String, Object>();
		SymPrivGrpVO resSymPrivGrpVo = symPrivGrpService.selectSymPrivGrp(symPrivGrpVO);
	 
		ExriaUdtoMapUtil.addListToResponseMap(reqData, "resSymPrivGrpVO", resSymPrivGrpVo, mm);
		
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
		
		return mav;  
    } 
    
    @RequestMapping("/sym/symPrivGrp/deleteSymPrivGrpEx.do")
    public ModelAndView deleteSymPrivGrpEx(
            ExriaUDDTO uDto, HttpServletRequest request, SessionStatus status)
            throws Exception { 
    	 
    	RequestData reqData = uDto.getRequestData(); 
    	SymPrivGrpVO symPrivGrpVO = (SymPrivGrpVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.grp.service.SymPrivGrpVO");
		
    	symPrivGrpService.deleteSymPrivGrp(symPrivGrpVO);
    	status.setComplete();
    	
		Map<String, String> mm = new HashMap<String, String>();
		mm.put("message", messageSource.getMessage("I9012", null, Locale.getDefault()));
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);

		return mav;  
    	 
    }

}
