package estam.app.sym.mnu.web;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
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
import estam.app.sym.mnu.service.SymMenuDefaultVO;
import estam.app.sym.mnu.service.SymMenuService;
import estam.app.sym.mnu.service.SymMenuVO;
import estam.app.sym.usr.service.SymUserDefaultVO;


/**
 * @Class Name : SymMenuController.java
 * @Description : SymMenu Controller class
 * @Modification Information
 *
 * @author ATRES
 * @since 20130703
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=SymMenuVO.class)
public class SymMenuController {

    @Resource(name = "symMenuService")
    private SymMenuService symMenuService;
    
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
    @RequestMapping(value="/sym/symMenu/SymMenu.do")
    public String pgrBarFormView(@ModelAttribute("searchVO") SymMenuDefaultVO searchVO,  
  		    ModelMap model)
           throws Exception { 
       
        return "/estam/sym/symMenu/SymMenu";
    }  
    
    /**
	 * SYM_MENU 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SymMenuDefaultVO
	 * @return "/symMenu/SymMenuList"
	 * @exception Exception
	 */
    @RequestMapping(value="/sym/symMenu/SymMenuList.do")
    public String selectSymMenuList(@ModelAttribute("searchVO") SymMenuDefaultVO searchVO, 
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
		
        List symMenuList = symMenuService.selectSymMenuList(searchVO);
        model.addAttribute("resultList", symMenuList);
        
        int totCnt = symMenuService.selectSymMenuListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/sym/symMenu/SymMenuList";
    } 
    
    /**
  	 * SYM_MENU 목록을 조회한다. (pageing)
  	 * @param searchVO - 조회할 정보가 담긴 SymMenuDefaultVO
  	 * @return "/symMenu/SymMenuList"
  	 * @exception Exception
  	 */
      @SuppressWarnings("unchecked")
	  @RequestMapping(value="/sym/symMenu/SymMenuListEx.do")
      public ModelAndView selectSymMenuListEx(ExriaUDDTO uDto, 
      		ModelMap model, HttpServletRequest request)
              throws Exception {
    	  
    		RequestData reqData = uDto.getRequestData();
        	HttpSession session = request.getSession();
    		//session.removeAttribute("empno");
    		session.removeAttribute("method");
    		//SymMenuDefaultVO searchVO = new SymMenuDefaultVO();
    		SymMenuDefaultVO searchVO = (SymMenuDefaultVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.mnu.service.SymMenuDefaultVO");
    		
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
    			searchVO = (SymMenuDefaultVO)session.getAttribute("searchVO");
    			session.removeAttribute("searchVO");
    		}*/
    	 
//        	Map searchMap = PropertyUtils.describe(searchVO);
//    		PageVO pageVO = new PageVO(searchVO.getRecordCountPerPage(),
//    				symUserService.selectSymUserListTotCnt(searchVO),
//    				searchVO.getPageSize());
//    		searchVO.setRecordCountPerPage(pageVO.getCurrPage());
    		  
    		@SuppressWarnings("rawtypes")
			List symMenuList = new ArrayList(); 
    		Map<String, Object> mm = new HashMap<String, Object>();   
	       
    		List<Map<String,Object>> symMenuMList = symMenuService.selectSymMenuList(searchVO);
    		
    		if(symMenuMList.size() > 0){
        		for (Map<String,Object> map : symMenuMList) { 
        			Map<String, Object> symMenuMap = new HashMap<String, Object>();
        			for (Map.Entry<String,Object> entry: map.entrySet()) {
        				
        				String key = entry.getKey();
        				Object value = entry.getValue();
        				symMenuMap.put(key, value); 
        			}   
        			symMenuList.add(symMenuMap); 
        		} 
        		
        		mm.put("resSymMenuList", symMenuList);   			
    		}else{
    			mm.put("resSymMenuList", null);   
    		}
 
    		
    		int totCnt = symMenuService.selectSymMenuListTotCnt(searchVO);
    		paginationInfo.setTotalRecordCount(totCnt);
    		addListToResponseMap(reqData, "paginationInfo", paginationInfo, mm);
    	
    		/*if(session.getAttribute("useSessionInfo") != null) {
    			mm.put("searchVO", reqData.getBeanToMap(searchVO));
    			session.setAttribute("useSessionInfo", null);
    		}*/
    		
    		ModelAndView mav = new ModelAndView("exriaView");
    		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
     
    		return mav;
    		 
      }  
 
    
    @RequestMapping("/sym/symMenu/saveSymMenuEx.do")
    public ModelAndView saveSymMenuEx(ExriaUDDTO uDto, 
    		@RequestParam("method") String method , HttpServletRequest request, SessionStatus status)
            throws Exception {
    	
    	RequestData reqData = uDto.getRequestData();
    	SymMenuVO symMenuVO = (SymMenuVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.mnu.service.SymMenuVO");
//		beanValidator.validate(employee, bindingResult);
    	
    	Map<String, String> message = new HashMap<String, String>();
		Map<String, Object> mm = new HashMap<String, Object>();
		Map<String, String> store = new HashMap<String, String>();
		
		
		HttpSession session = request.getSession();
    	LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
    	
		if (symMenuVO.getMenuCd() != null && symMenuVO.getMenuCd() == "") {
			store.put("MenuCd", "errors.MenuCd");
		} else {
			if (method.equals("add")) {
				
				SymMenuVO resSymMenuVo = symMenuService.selectSymMenu(symMenuVO);
				
				if(resSymMenuVo != null){
		    		message.put("procMsg","중복된 메뉴코드가 존재합니다.");
		    	}else{
		    		symMenuVO.setInptUsrId(loginVO.getUserId());
    				symMenuService.insertSymMenu(symMenuVO);
    				message.put("procMsg","");
		    	}
				
			} else if (method.equals("update")) {
				symMenuVO.setUpdtUsrId(loginVO.getUserId());
				symMenuService.updateSymMenu(symMenuVO);
				
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
     

    @RequestMapping("/sym/symMenu/selectSymMenuEx.do")
    public  ModelAndView selectSymMenuEx(ExriaUDDTO uDto, HttpServletRequest request) throws Exception {
    	
    	RequestData reqData = uDto.getRequestData(); 
    	SymMenuVO symMenuVO = (SymMenuVO)getMapToBean(reqData, "estam.app.sym.mnu.service.SymMenuVO");
		
		Map<String, Object> mm = new HashMap<String, Object>();
		SymMenuVO resSymMenuVo = symMenuService.selectSymMenu(symMenuVO);
		
		addListToResponseMap(reqData, "resSymMenuVO", resSymMenuVo, mm);
		
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
		
		return mav; 
    }
 
    
    @RequestMapping("/sym/symMenu/deleteSymMenuEx.do")
    public ModelAndView deleteSymMenuEx(
    		ExriaUDDTO uDto, HttpServletRequest request, SessionStatus status)
            throws Exception {
    	
    	RequestData reqData = uDto.getRequestData(); 
    	SymMenuVO symMenuVO = (SymMenuVO)getMapToBean(reqData, "estam.app.sym.mnu.service.SymMenuVO");
    	
    	symMenuService.deleteSymMenu(symMenuVO);
    	status.setComplete();
    	
		Map<String, String> mm = new HashMap<String, String>();
		mm.put("message", messageSource.getMessage("I9012", null, Locale.getDefault()));
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);

		return mav;  
    }
    
    
    public static Object getMapToBean(RequestData reqData, String strClass) throws SecurityException, ClassNotFoundException {
		Method[] methods = Class.forName(strClass).getMethods();
		int size = methods.length;
		String strMethod;
		for(int i = 0; i < size; i++) {
			strMethod = methods[i].getName();
			if(strMethod.indexOf("get") == 0) {
				strMethod = strMethod.substring(3);
				strMethod = strMethod.substring(0, 1).toLowerCase() + strMethod.substring(1);
				if(reqData.getString(strMethod) != null && reqData.getString(strMethod).equals("")) {
					reqData.setObject(strMethod, null);
				} else if(methods[i].getReturnType() == Class.forName("java.util.Date")) {
					String vsDate = reqData.getString(strMethod);
					Calendar cal = Calendar.getInstance();
					cal.set(Integer.parseInt(vsDate.substring(0, 4)), Integer.parseInt(vsDate.substring(4, 6)) - 1,
							Integer.parseInt(vsDate.substring(6, 8)));
					reqData.setObject(strMethod, cal.getTime());
				}
			}
		}
		return reqData.getMapToBean(reqData.getRequestMap(), Class.forName(strClass));
	}
	
	public static Object getMapToBean(RequestData reqData, Map<String, Object> cudMap, String strClass) throws SecurityException, ClassNotFoundException {
		Method[] methods = Class.forName(strClass).getMethods();
		int size = methods.length;
		String strMethod;
		for(int i = 0; i < size; i++) {
			strMethod = methods[i].getName();
			if(strMethod.indexOf("get") == 0) {
				strMethod = strMethod.substring(3);
				strMethod = strMethod.substring(0, 1).toLowerCase() + strMethod.substring(1);
				if(cudMap.get(strMethod) != null && cudMap.get(strMethod).equals("")) {
					cudMap.put(strMethod, null);
				} else if(methods[i].getReturnType() == Class.forName("java.util.Date")) {
					String vsDate = (String)cudMap.get(strMethod);
					Calendar cal = Calendar.getInstance();
					cal.set(Integer.parseInt(vsDate.substring(0, 4)), Integer.parseInt(vsDate.substring(4, 6)) - 1,
							Integer.parseInt(vsDate.substring(6, 8)));
					cudMap.put(strMethod, cal.getTime());
				}
			}
		}
		return reqData.getMapToBean(cudMap, Class.forName(strClass));
	}
	
	public static void addListToResponseMap(RequestData reqData, String nodeName, Object beanList, Map containerMap) {
		List store = new ArrayList();
		Map uv = null;
		if(beanList instanceof List) {
			List list = (List)beanList;
			int size = list.size();
			try {
				for (int i = 0; i < size; i++) { 
					uv = reqData.getBeanToMap(list.get(i));
					store.add(uv);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			try {
				uv = reqData.getBeanToMap(beanList);
				store.add(uv);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		containerMap.put(nodeName, store);
	}
	
	private class MyException extends Exception { // exception의 정의

        public MyException (String message) {

                         super (message);

        }

        public MyException() {

                          this ("My Exception Error");

         }

	}

}
