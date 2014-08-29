package estam.app.sym.mgp.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.tomatosystem.adaptor.egovframework.uiadaptor.ExriaUDDTO;
import com.tomatosystem.adaptor.exria.AdaptorConstants;
import com.tomatosystem.adaptor.exria.RequestData;

import egovframework.com.cmm.LoginVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import estam.app.com.util.ExriaUdtoMapUtil;
import estam.app.sym.grp.service.SymPrivGrpService;
import estam.app.sym.grp.service.SymPrivGrpVO;
import estam.app.sym.mgp.service.SymPrivMenuDefaultVO;
import estam.app.sym.mgp.service.SymPrivMenuService;
import estam.app.sym.mgp.service.SymPrivMenuVO;
import estam.app.sym.mnu.service.SymMenuService;
import estam.app.sym.mnu.service.SymMenuVO;

/**
 * @Class Name : SymPrivMenuController.java
 * @Description : SymPrivMenu Controller class
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
@SessionAttributes(types=SymPrivMenuVO.class)
public class SymPrivMenuController {

    @Resource(name = "symPrivMenuService")
    private SymPrivMenuService symPrivMenuService;
    
    //메뉴처리  
    @Resource(name = "symMenuService")
    private SymMenuService symMenuService;
    
    //권한그룹
    @Resource(name = "symPrivGrpService")
    private SymPrivGrpService symPrivGrpService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	

    /**
     * 
     * @param searchVO
     * @param flag
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/sym/symPrivMenu/SymPrivMenu.do")
    public String pgrBarFormView(@ModelAttribute("searchVO") SymPrivMenuDefaultVO searchVO,  
  		    ModelMap model)
           throws Exception { 
       
        return "/estam/sym/symPrivMenu/SymPrivMenu";
    }  
    
    /**
	 * SYM_PRIV_MENU 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SymPrivMenuDefaultVO
	 * @return "/symPrivMenu/SymPrivMenuList"
	 * @exception Exception
	 */
    @RequestMapping(value="/sym/symPrivMenu/SymPrivMenuList.do")
    public String selectSymPrivMenuList(@ModelAttribute("searchVO") SymPrivMenuDefaultVO searchVO, 
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
		
        List symPrivMenuList = symPrivMenuService.selectSymPrivMenuList(searchVO);
        model.addAttribute("resultList", symPrivMenuList);
        
        int totCnt = symPrivMenuService.selectSymPrivMenuListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/sym/symPrivMenu/SymPrivMenuList";
    } 
    
    /**
  	 * SYM_PRIV_MENU 목록을 조회한다. (pageing)
  	 * @param searchVO - 조회할 정보가 담긴 SymPrivMenuDefaultVO
  	 * @return "/symPrivMenu/SymPrivMenuList"
  	 * @exception Exception
  	 */
      @RequestMapping(value="/sym/symPrivMenu/SymPrivMenuListEx.do")
      public String selectSymPrivMenuListEx(@ModelAttribute("searchVO") SymPrivMenuDefaultVO searchVO, 
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
  		
          List symPrivMenuList = symPrivMenuService.selectSymPrivMenuList(searchVO);
          model.addAttribute("resultList", symPrivMenuList);
          
          int totCnt = symPrivMenuService.selectSymPrivMenuListTotCnt(searchVO);
  		paginationInfo.setTotalRecordCount(totCnt);
          model.addAttribute("paginationInfo", paginationInfo);
          
          return "/sym/symPrivMenu/SymPrivMenuList";
      } 
      
      /**
     	 * SYM_PRIV_GRP 목록을 조회한다.  
     	 * @param searchVO - 조회할 정보가 담긴 SymPrivGrpDefaultVO
     	 * @return "/symPrivGrp/SymPrivGrpList"
     	 * @exception Exception
     	 */
         @SuppressWarnings("unchecked")
         @RequestMapping(value="/sym/symPrivMenu/SymPrivGrpListEx.do")
         public ModelAndView selectSymPrivGrpListEx(ExriaUDDTO uDto, 
         		ModelMap model, HttpServletRequest request )
                 throws Exception {
         	
      	    RequestData reqData = uDto.getRequestData();
         	HttpSession session = request.getSession();
     		//session.removeAttribute("empno");
     		//session.removeAttribute("method");
     		//SymPrivGrpDefaultVO searchVO = new SymPrivGrpDefaultVO();
     		/** EgovPropertyService.sample */
         	//searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
         	//searchVO.setPageSize(propertiesService.getInt("pageSize"));
      
         	/** pageing */
         	//PaginationInfo paginationInfo = new PaginationInfo();
     		//paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
     		//paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
     		//paginationInfo.setPageSize(searchVO.getPageSize());
     		
     		//searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
     		//searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
     		//searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
     		
     		 
     		//if(session.getAttribute("useSessionInfo") != null) {
     		//	searchVO = (SymPrivGrpDefaultVO)session.getAttribute("searchVO");
     	    //	session.removeAttribute("searchVO");
     		//}
   
//         	Map searchMap = PropertyUtils.describe(searchVO);
//     		PageVO pageVO = new PageVO(searchVO.getRecordCountPerPage(),
//     				symUserService.selectSymUserListTotCnt(searchVO),
//     				searchVO.getPageSize());
//     		searchVO.setRecordCountPerPage(pageVO.getCurrPage());
         	
         	Map<String, Object> mm = new HashMap<String, Object>();   
         	List<Map<String, Object>>  tlistSymPrivGrp =  symPrivMenuService.ListSymPrivGrpExria();
         	
         	List listSymPrivGrp = new ArrayList(); 
         	
         	if(tlistSymPrivGrp.size() > 0){
    			for (Map<String,Object> map : tlistSymPrivGrp) { 
    				Map<String, Object> symUesrMap = new HashMap<String, Object>();
    				for (Map.Entry<String,Object> entry: map.entrySet()) {
    					String key = entry.getKey();
    					Object value = entry.getValue();
    					symUesrMap.put(key, value); 
    				}   
    				listSymPrivGrp.add(symUesrMap); 
    			} 
    			mm.put("resSymPrivGrpList", listSymPrivGrp); 
    		}else{
    			mm.put("resSymPrivGrpList", null); 
    		}
     	 	
     		//int totCnt = symPrivGrpService.selectSymPrivGrpListTotCnt(searchVO);
     		//paginationInfo.setTotalRecordCount(totCnt);
     		//ExriaUdtoMapUtil.addListToResponseMap(reqData, "paginationInfo", paginationInfo, mm);
     	
     		//if(session.getAttribute("useSessionInfo") != null) {
     		//	mm.put("searchVO", reqData.getBeanToMap(searchVO));
     		//	session.setAttribute("useSessionInfo", null);
     		//}
     		
     		ModelAndView mav = new ModelAndView("exriaView");
     		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
      
     		return mav;
         } 
    
    
         /**
      	 * 선택된 권한 그룹에 대한 메뉴 목록을 조회한다.  
      	 * @param searchVO - 조회할 정보가 담긴 SymPrivGrpDefaultVO
      	 * @return "/symPrivGrp/SymPrivGrpList"
      	 * @exception Exception
      	 */
          @SuppressWarnings("unchecked")
          @RequestMapping(value="/sym/symPrivMenu/SymPrivMenuListExria.do")
          public ModelAndView SymPrivMenuListExria(ExriaUDDTO uDto, 
          		ModelMap model, HttpServletRequest request )
                  throws Exception {
          	
       	    RequestData reqData = uDto.getRequestData();
          	HttpSession session = request.getSession();
          	
          	SymPrivMenuVO searchVO = (SymPrivMenuVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.mgp.service.SymPrivMenuVO");
          	Map<String, Object> mm = new HashMap<String, Object>(); 
 
          	List<Map<String,Object>>  tlistSymPrivMenu =  symPrivMenuService.selectSymPrivMenuExria(searchVO);
          	
          	List listSymPrivMenu = new ArrayList(); 
         	
         	if(tlistSymPrivMenu.size() > 0){
    			for (Map<String,Object> map : tlistSymPrivMenu) { 
    				Map<String, Object> symUesrMap = new HashMap<String, Object>();
    				for (Map.Entry<String,Object> entry: map.entrySet()) {
    					String key = entry.getKey();
    					Object value = entry.getValue();
    					symUesrMap.put(key, value); 
    				}   
    				listSymPrivMenu.add(symUesrMap); 
    			} 
    			mm.put("resSymPrivMenuList", listSymPrivMenu); 
    		}else{
    			mm.put("resSymPrivGrpList", null); 
    		}
         	
          	List<Map<String,Object>>  tlistSymNonPrivMenu =  symPrivMenuService.selectSymNonPrivMenuExria(searchVO);
	
          	List listSymNonPrivMenu = new ArrayList(); 
         	
         	if(tlistSymNonPrivMenu.size() > 0){
    			for (Map<String,Object> map : tlistSymNonPrivMenu) { 
    				Map<String, Object> symUesrMap = new HashMap<String, Object>();
    				for (Map.Entry<String,Object> entry: map.entrySet()) {
    					String key = entry.getKey();
    					Object value = entry.getValue();
    					symUesrMap.put(key, value); 
    				}   
    				listSymNonPrivMenu.add(symUesrMap); 
    			} 
    			mm.put("resSymPrivNonMenuList", listSymNonPrivMenu); 
    		}else{
    			mm.put("resSymPrivNonMenuList", null); 
    		}
         	
      		ModelAndView mav = new ModelAndView("exriaView");
      		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
       
      		return mav;
          } 
          
  /**
	 * 선택된 권한 그룹에 대한 메뉴 목록을 조회한다.  
	 * @param searchVO - 조회할 정보가 담긴 SymPrivGrpDefaultVO
	 * @return "/symPrivGrp/SymPrivGrpList"
	 * @exception Exception
	 */
    @SuppressWarnings("unchecked")
    @RequestMapping(value="/sym/symPrivMenu/savePrivMenuListExria.do")
    public ModelAndView savePrivMenuListExria(ExriaUDDTO uDto, 
    		@RequestParam("method") String method , ModelMap model, HttpServletRequest request )
            throws Exception {
    	
 	    RequestData reqData = uDto.getRequestData();
    	HttpSession session = request.getSession();
    	
    	//SymPrivMenuVO searchVO = (SymPrivMenuVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.mgp.service.SymPrivMenuVO");
    	SymPrivMenuVO vo = (SymPrivMenuVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.mgp.service.SymPrivMenuVO");
    	
        Map<String, Object> mm = new HashMap<String, Object>(); 

    	LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
    	
        if (method.equals("insert")) {
        	
        	vo.setInptUsrId(loginVO.getUserId());
        	symPrivMenuService.savePrivMenuExria(vo);
	
		} else if (method.equals("delete")) {
			
			symPrivMenuService.deletePrivMenuExria(vo);
			
		}
        

		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
 
		return mav;
    }       
     
          
    @RequestMapping("/sym/symPrivMenu/addSymPrivMenuView.do")
    public String addSymPrivMenuView(
            @ModelAttribute("searchVO") SymPrivMenuDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("symPrivMenuVO", new SymPrivMenuVO());
        return "/sym/symPrivMenu/SymPrivMenuRegister";
    }
    
    @RequestMapping("/sym/symPrivMenu/addSymPrivMenu.do")
    public String addSymPrivMenu(
            SymPrivMenuVO symPrivMenuVO,
            @ModelAttribute("searchVO") SymPrivMenuDefaultVO searchVO, SessionStatus status)
            throws Exception {
        symPrivMenuService.insertSymPrivMenu(symPrivMenuVO);
        status.setComplete();
        return "forward:/sym/symPrivMenu/SymPrivMenuList.do";
    }
    
    @RequestMapping("/sym/symPrivMenu/updateSymPrivMenuView.do")
    public String updateSymPrivMenuView(
            @RequestParam("menuCd") java.lang.String menuCd ,
            @RequestParam("privGrpNo") java.math.BigDecimal privGrpNo ,
            @ModelAttribute("searchVO") SymPrivMenuDefaultVO searchVO, Model model)
            throws Exception {
        SymPrivMenuVO symPrivMenuVO = new SymPrivMenuVO();
        symPrivMenuVO.setMenuCd(menuCd);
        symPrivMenuVO.setPrivGrpNo(privGrpNo);
        // 변수명은 CoC 에 따라 symPrivMenuVO
        model.addAttribute(selectSymPrivMenu(symPrivMenuVO, searchVO));
        return "/sym/symPrivMenu/SymPrivMenuRegister";
    }

    @RequestMapping("/sym/symPrivMenu/selectSymPrivMenu.do")
    public @ModelAttribute("symPrivMenuVO")
    SymPrivMenuVO selectSymPrivMenu(
            SymPrivMenuVO symPrivMenuVO,
            @ModelAttribute("searchVO") SymPrivMenuDefaultVO searchVO) throws Exception {
        return symPrivMenuService.selectSymPrivMenu(symPrivMenuVO);
    }

    @RequestMapping("/sym/symPrivMenu/updateSymPrivMenu.do")
    public String updateSymPrivMenu(
            SymPrivMenuVO symPrivMenuVO,
            @ModelAttribute("searchVO") SymPrivMenuDefaultVO searchVO, SessionStatus status)
            throws Exception {
        symPrivMenuService.updateSymPrivMenu(symPrivMenuVO);
        status.setComplete();
        return "forward:/sym/symPrivMenu/SymPrivMenuList.do";
    }
    
    @RequestMapping("/sym/symPrivMenu/deleteSymPrivMenu.do")
    public String deleteSymPrivMenu(
            SymPrivMenuVO symPrivMenuVO,
            @ModelAttribute("searchVO") SymPrivMenuDefaultVO searchVO, SessionStatus status)
            throws Exception {
        symPrivMenuService.deleteSymPrivMenu(symPrivMenuVO);
        status.setComplete();
        return "forward:/sym/symPrivMenu/SymPrivMenuList.do";
    }

}
