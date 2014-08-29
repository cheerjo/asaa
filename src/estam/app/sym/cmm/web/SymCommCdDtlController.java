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
import estam.app.sym.cmm.service.SymCommCdDtlDefaultVO;
import estam.app.sym.cmm.service.SymCommCdDtlService;
import estam.app.sym.cmm.service.SymCommCdDtlVO;
import estam.app.sym.grp.service.SymPrivGrpDefaultVO;

/**
 * @Class Name : SymCommCdDtlController.java
 * @Description : SymCommCdDtl Controller class
 * @Modification Information
 *
 * @author atres
 * @since 2013.07.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=SymCommCdDtlVO.class)
public class SymCommCdDtlController {

    @Resource(name = "symCommCdDtlService")
    private SymCommCdDtlService symCommCdDtlService;
    
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
    @RequestMapping(value="/sym/symCommCdDtl/SymCommCdDtl.do")
    public String pgrBarFormView(@ModelAttribute("searchVO") SymCommCdDtlDefaultVO searchVO,  
  		    ModelMap model)
           throws Exception { 
       
        return "/estam/sym/symCommCdDtl/SymCommCdDtl";
    }  
    
    /**
	 * SYM_COMM_CD_DTL 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SymCommCdDtlDefaultVO
	 * @return "/symCommCdDtl/SymCommCdDtlList"
	 * @exception Exception
	 */
    @RequestMapping(value="/sym/symCommCdDtl/SymCommCdDtlList.do")
    public String selectSymCommCdDtlList(@ModelAttribute("searchVO") SymCommCdDtlDefaultVO searchVO, 
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
		
        List symCommCdDtlList = symCommCdDtlService.selectSymCommCdDtlList(searchVO);
        model.addAttribute("resultList", symCommCdDtlList);
        
        int totCnt = symCommCdDtlService.selectSymCommCdDtlListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/sym/symCommCdDtl/SymCommCdDtlList";
    } 
    
    /**
   	 * SYM_COMM_CD_DTL 목록을 조회한다. (pageing)
   	 * @param searchVO - 조회할 정보가 담긴 SymCommCdDtlDefaultVO
   	 * @return "/symCommCdDtl/SymCommCdDtlList"
   	 * @exception Exception
   	 */
       @RequestMapping(value="/sym/symCommCdDtl/SymCommCdDtlListEx.do")
       public ModelAndView selectSymCommCdDtlListEx(ExriaUDDTO uDto, 
         		ModelMap model, HttpServletRequest request)
               throws Exception {
       	
    	 	RequestData reqData = uDto.getRequestData();
        	HttpSession session = request.getSession();
    		//session.removeAttribute("empno");
    		session.removeAttribute("method");
    		//SymCommCdDtlDefaultVO searchVO = new SymCommCdDtlDefaultVO();
    		SymCommCdDtlDefaultVO searchVO =  (SymCommCdDtlDefaultVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.cmm.service.SymCommCdDtlDefaultVO");
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
    			searchVO = (SymCommCdDtlDefaultVO)session.getAttribute("searchVO");
    			session.removeAttribute("searchVO");
    		}*/
    	 
//        	Map searchMap = PropertyUtils.describe(searchVO);
//    		PageVO pageVO = new PageVO(searchVO.getRecordCountPerPage(),
//    				symUserService.selectSymUserListTotCnt(searchVO),
//    				searchVO.getPageSize());
//    		searchVO.setRecordCountPerPage(pageVO.getCurrPage());
    		@SuppressWarnings("rawtypes")
    		List symCommCdDtlList = new ArrayList(); 
    		Map<String, Object> mm = new HashMap<String, Object>();   
    	 
    		List<Map<String,Object>> symCommCdMList =  symCommCdDtlService.selectSymCommCdDtlList(searchVO);
    		
    		if(symCommCdMList.size() > 0){
        		for (Map<String,Object> map : symCommCdMList) { 
        			Map<String, Object> symUesrMap = new HashMap<String, Object>();
        			for (Map.Entry<String,Object> entry: map.entrySet()) {
        				String key = entry.getKey();
        				Object value = entry.getValue();
        				symUesrMap.put(key, value); 
        			}   
        			symCommCdDtlList.add(symUesrMap); 
        		} 
        	
        		mm.put("resSymCommCdDtlList", symCommCdDtlList);    			
    		}else{
    			mm.put("resSymCommCdDtlList", null); 
    		}


    		int totCnt = symCommCdDtlService.selectSymCommCdDtlListTotCnt(searchVO);
    		paginationInfo.setTotalRecordCount(totCnt);
    		ExriaUdtoMapUtil.addListToResponseMap(reqData, "paginationInfo", paginationInfo, mm);
    	
//    		if(session.getAttribute("useSessionInfo") != null) {
//    			mm.put("searchVO", reqData.getBeanToMap(searchVO));
//    			session.setAttribute("useSessionInfo", null);
//    		}
    		
    		ModelAndView mav = new ModelAndView("exriaView");
    		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
     
    		return mav;
    		 
       } 
    
    
    
    @RequestMapping("/sym/symCommCdDtl/saveSymCommCdDtlEx.do")
    public ModelAndView saveSymCommCdDtlEx(ExriaUDDTO uDto, 
    		@RequestParam("method") String method , HttpServletRequest request, SessionStatus status)
            throws Exception {
    	 
        	 
    	RequestData reqData = uDto.getRequestData();
    	SymCommCdDtlVO symCommCdDtlVO = (SymCommCdDtlVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.cmm.service.SymCommCdDtlVO");
//    		beanValidator.validate(employee, bindingResult);
    	
    	Map<String, String> message = new HashMap<String, String>();
		Map<String, Object> mm = new HashMap<String, Object>();
		Map<String, String> store = new HashMap<String, String>();
		
		HttpSession session = request.getSession();
    	LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
    	
		if (symCommCdDtlVO.getCommDtlCd() != null && symCommCdDtlVO.getCommDtlCd() == "") {
			store.put("CommDtlCd", "errors.CommDtlCd");
		} else {
			if (method.equals("add")) {
				SymCommCdDtlVO resSymCommCdDtlVo = symCommCdDtlService.selectSymCommCdDtl(symCommCdDtlVO);
				
				if(resSymCommCdDtlVo != null){
		    		message.put("procMsg","중복된 상세코드가 존재합니다.");
		    	}else{
		    		symCommCdDtlVO.setInptUsrId(loginVO.getUserId());
		    		
		    		symCommCdDtlService.insertSymCommCdDtl(symCommCdDtlVO);
		    		message.put("procMsg","");
		    	}
				 
			} else if (method.equals("update")) {
				symCommCdDtlVO.setUpdtUsrId(loginVO.getUserId());
				
				 symCommCdDtlService.updateSymCommCdDtl(symCommCdDtlVO);
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
     

    @RequestMapping("/sym/symCommCdDtl/selectSymCommCdDtlEx.do")
    public ModelAndView selectSymCommCdDtlEx(ExriaUDDTO uDto, HttpServletRequest request) throws Exception {
    	 
    	RequestData reqData = uDto.getRequestData(); 
    	SymCommCdDtlVO symCommCdDtlVO = (SymCommCdDtlVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.cmm.service.SymCommCdDtlVO");
		
		Map<String, Object> mm = new HashMap<String, Object>();
		SymCommCdDtlVO resSymCommCdDtlVo = symCommCdDtlService.selectSymCommCdDtl(symCommCdDtlVO);
		
		mm.put("resSymCommCdDtlVO", resSymCommCdDtlVo);
		ExriaUdtoMapUtil.addListToResponseMap(reqData, "resSymCommCdDtlVO", resSymCommCdDtlVo, mm);
		
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
		
		return mav;   
    }
 
    
    @RequestMapping("/sym/symCommCdDtl/deleteSymCommCdDtlEx.do")
    public ModelAndView deleteSymCommCdDtlEx(
    		ExriaUDDTO uDto, HttpServletRequest request, SessionStatus status)
            throws Exception {
    	  
    	RequestData reqData = uDto.getRequestData(); 
    	SymCommCdDtlVO symCommCdDtlVO = (SymCommCdDtlVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.cmm.service.SymCommCdDtlVO");
    	
    	symCommCdDtlService.deleteSymCommCdDtl(symCommCdDtlVO);
    	status.setComplete();
    	
		Map<String, String> mm = new HashMap<String, String>();
		mm.put("message", messageSource.getMessage("I9012", null, Locale.getDefault()));
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);

		return mav;  
    		 
    }

}
