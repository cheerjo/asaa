package estam.app.popup.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.tomatosystem.adaptor.egovframework.uiadaptor.ExriaUDDTO;
import com.tomatosystem.adaptor.exria.AdaptorConstants;
import com.tomatosystem.adaptor.exria.RequestData;

import egovframework.com.utl.fcc.service.EgovStringUtil;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import estam.app.com.util.ExriaUdtoMapUtil;
import estam.app.popup.service.PopupDefaultVO;
import estam.app.popup.service.PopupService;
import estam.app.popup.service.SymCommCdVO;
import estam.app.popup.service.SymMenuVO;
import estam.app.popup.service.ZipCodeVO;


/**
 * @Class Name : PopupController.java
 * @Description : Popup Controller class
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
public class PopupController { 

    @Resource(name = "popupService")
    private PopupService popupService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    @Resource(name = "messageSource")
	protected MessageSource messageSource;
    
	@Resource(name = "beanValidator")
	private DefaultBeanValidator beanValidator;
	 
    
    /**
  	 * SYM_MENU 목록을 조회한다. (pageing)
  	 * @param searchVO - 조회할 정보가 담긴 SymMenuDefaultVO
  	 * @return "/symMenu/SymMenuList"
  	 * @exception Exception
  	 */
      @SuppressWarnings("unchecked")
	  @RequestMapping(value="/popup/popupSymMenuEx.do")
      public ModelAndView selectPopupSymMenuEx(ExriaUDDTO uDto, 
      		ModelMap model, HttpServletRequest request)
              throws Exception {
    	  
    		RequestData reqData = uDto.getRequestData();
        	HttpSession session = request.getSession();
    		//session.removeAttribute("empno");
    		session.removeAttribute("method");
    		PopupDefaultVO searchVO = new PopupDefaultVO();
    		
    		/** EgovPropertyService.sample */
        	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
        	searchVO.setPageSize(propertiesService.getInt("pageSize"));
     
        	/** pageing */
//        	PaginationInfo paginationInfo = new PaginationInfo();
//    		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
//    		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
//    		paginationInfo.setPageSize(searchVO.getPageSize());
//    		
//    		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
//    		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
//    		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
    		
    		 
    		if(session.getAttribute("useSessionInfo") != null) {
    			searchVO = (PopupDefaultVO)session.getAttribute("searchVO");
    			session.removeAttribute("searchVO");
    		}
    	 
//        	Map searchMap = PropertyUtils.describe(searchVO);
//    		PageVO pageVO = new PageVO(searchVO.getRecordCountPerPage(),
//    				symUserService.selectSymUserListTotCnt(searchVO),
//    				searchVO.getPageSize());
//    		searchVO.setRecordCountPerPage(pageVO.getCurrPage());
    		  
//    		@SuppressWarnings("rawtypes")
//			List symMenuList = new ArrayList(); 
    		Map<String, Object> mm = new HashMap<String, Object>();   
	       
    		List<SymMenuVO> symMenuMList = popupService.selectPopupSymMenu(searchVO);
    		
    		ExriaUdtoMapUtil.addListToResponseMap(reqData, "resSymMenuList", symMenuMList, mm);
    		
//    		for (Map<String,Object> map : symMenuMList) { 
//    			Map<String, Object> symMenuMap = new HashMap<String, Object>();
//    			for (Map.Entry<String,Object> entry: map.entrySet()) {
//    				
//    				String key = entry.getKey();
//    				Object value = entry.getValue();
//    				symMenuMap.put(key, value); 
//    			}   
//    			symMenuList.add(symMenuMap); 
//    		} 
//    		
//    		mm.put("resSymMenuList", symMenuList);  
    		
    		//int totCnt = popupService.selectSymMenuListTotCnt(searchVO);
    		//paginationInfo.setTotalRecordCount(totCnt);
    		//ExriaUdtoMapUtil.addListToResponseMap(reqData, "paginationInfo", paginationInfo, mm);
    	
    		if(session.getAttribute("useSessionInfo") != null) {
    			mm.put("searchVO", reqData.getBeanToMap(searchVO));
    			session.setAttribute("useSessionInfo", null);
    		}
    		
    		ModelAndView mav = new ModelAndView("exriaView");
    		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
     
    		return mav;
    		 
      }   
      
      
      /**
     	 * SYM_COMM_CD 목록을 조회한다. (pageing)
     	 * @param searchVO - 조회할 정보가 담긴 SymCommCdDefaultVO
     	 * @return "/symCommCd/SymCommCdList"
     	 * @exception Exception
     	 */
         @RequestMapping(value="/popup/popupSymCommCdEx.do")
         public ModelAndView selectPopupSymCommCdEx(ExriaUDDTO uDto, 
            		ModelMap model, HttpServletRequest request )
                 throws Exception {
         	
      	        RequestData reqData = uDto.getRequestData();
            	HttpSession session = request.getSession(); 
        		session.removeAttribute("method");
        		PopupDefaultVO searchVO =  (PopupDefaultVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.popup.service.PopupDefaultVO"); 
        		/** EgovPropertyService.sample */
            	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
            	searchVO.setPageSize(propertiesService.getInt("pageSize"));
         
            	/** pageing */
//            	PaginationInfo paginationInfo = new PaginationInfo();
//        		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
//        		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
//        		paginationInfo.setPageSize(searchVO.getPageSize());
        		
//        		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
//        		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
//        		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
        		
        		 
        		if(session.getAttribute("useSessionInfo") != null) {
        			searchVO = (PopupDefaultVO)session.getAttribute("searchVO");
        			session.removeAttribute("searchVO");
        		}
      
//            	Map searchMap = PropertyUtils.describe(searchVO);
//        		PageVO pageVO = new PageVO(searchVO.getRecordCountPerPage(),
//        				symUserService.selectSymUserListTotCnt(searchVO),
//        				searchVO.getPageSize());
//        		searchVO.setRecordCountPerPage(pageVO.getCurrPage());
        		  
        		//List symCommCdList = new ArrayList(); 
        		Map<String, Object> mm = new HashMap<String, Object>();   
               System.out.println("================ "+searchVO.getSearchKeyword()+" ================");
        		List<SymCommCdVO> symCommCdMList =  popupService.selectPopupSymCommCd(searchVO);
        		
        		ExriaUdtoMapUtil.addListToResponseMap(reqData, "resSymCommCdList", symCommCdMList, mm);
        		
//        		for (Map<String,Object> map : symCommCdMList) { 
//        			Map<String, Object> symCommCdMap = new HashMap<String, Object>();
//        			for (Map.Entry<String,Object> entry: map.entrySet()) {
//        				String key = entry.getKey();
//        				Object value = entry.getValue();
//        				symCommCdMap.put(key, value); 
//        			}   
//        			symCommCdList.add(symCommCdMap); 
//        		} 
//        		
//        		mm.put("resSymCommCdList", symCommCdList); 
        	 	
        		//int totCnt = popupService.selectSymCommCdListTotCnt(searchVO);
        		//paginationInfo.setTotalRecordCount(totCnt);
        		//ExriaUdtoMapUtil.addListToResponseMap(reqData, "paginationInfo", paginationInfo, mm);
        	
        		if(session.getAttribute("useSessionInfo") != null) {
        			mm.put("searchVO", reqData.getBeanToMap(searchVO));
        			session.setAttribute("useSessionInfo", null);
        		}
        		
        		ModelAndView mav = new ModelAndView("exriaView");
        		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
         
        		return mav; 
         } 
         
         /**
          * (구)우편번호 리스트를 조회한다.
          *
          * @param zipCodeVO
          * @param model the model
          * @return "/cmm/zipCode/zipCodeList"
          * @throws Exception the exception
          */
         @RequestMapping(value="/cmmnl/zipCodeList.do")
         public String zipCodeList(@ModelAttribute("zipCodeVO") ZipCodeVO zipCodeVO, 
         		ModelMap model, HttpServletRequest request)
                 throws Exception {
         	
         	String formNm       = "";
         	String zip1FormNm  = "";
         	String zip2FormNm  = "";
         	String addr1FormNm  = "";
         	
         	/* 부모창으로 넘겨줄 폼필드 값 */
         	if( !EgovStringUtil.isEmpty(request.getParameter("formNm")) ) {
         		formNm = request.getParameter("formNm");
         	}
         	if( !EgovStringUtil.isEmpty(request.getParameter("zip1FormNm")) ) {
         		zip1FormNm = request.getParameter("zip1FormNm");
         	}
         	if( !EgovStringUtil.isEmpty(request.getParameter("zip2FormNm")) ) {
         		zip2FormNm = request.getParameter("zip2FormNm");
         	}
         	if( !EgovStringUtil.isEmpty(request.getParameter("addr1FormNm")) ) {
         		addr1FormNm = request.getParameter("addr1FormNm");
         	}
         	
         	model.addAttribute("formNm", formNm);
         	model.addAttribute("zip1FormNm", zip1FormNm);
         	model.addAttribute("zip2FormNm", zip2FormNm);
         	model.addAttribute("addr1FormNm", addr1FormNm);
         	
         	/* 우편번호 조회결과 */
         	if( !EgovStringUtil.isEmpty(zipCodeVO.getDong()) ) {
     	    	List resultList = popupService.selectZipCodeList(zipCodeVO);
     	    	model.addAttribute("resultList", resultList);
         	}
         	
             return "/cmm/zipcode/zipCodeListPopup";
         }
         
         
         /**
          * (신)우편번호 리스트를 조회한다.
          *
          * @param zipCodeVO
          * @param model the model
          * @return "/cmm/zipCode/zipCodeListPopup"
          * @throws Exception the exception
          */
         @RequestMapping(value="/cmmnl/zipCodeDoroList.do")
         public String zipCodeDoroList(@ModelAttribute("zipCodeVO") ZipCodeVO zipCodeVO, 
         		ModelMap model, HttpServletRequest request)
                 throws Exception {
         	
         	String formNm       = "";
         	String zip1FormNm  = "";
         	String zip2FormNm  = "";
         	String addr1FormNm  = "";
         	
         	/* 부모창으로 넘겨줄 폼필드 값 */
         	if( !EgovStringUtil.isEmpty(request.getParameter("formNm")) ) {
         		formNm = request.getParameter("formNm");
         	}
         	if( !EgovStringUtil.isEmpty(request.getParameter("zip1FormNm")) ) {
         		zip1FormNm = request.getParameter("zip1FormNm");
         	}
         	if( !EgovStringUtil.isEmpty(request.getParameter("zip2FormNm")) ) {
         		zip2FormNm = request.getParameter("zip2FormNm");
         	}
         	if( !EgovStringUtil.isEmpty(request.getParameter("addr1FormNm")) ) {
         		addr1FormNm = request.getParameter("addr1FormNm");
         	}
         	
         	model.addAttribute("formNm", formNm);
         	model.addAttribute("zip1FormNm", zip1FormNm);
         	model.addAttribute("zip2FormNm", zip2FormNm);
         	model.addAttribute("addr1FormNm", addr1FormNm);
         	
         	
         	/* 시군구 콤보 */
         	//List sidoList = cmmCodeMgrService.selectCommonCodeList("SIDO");
         	//model.addAttribute("sidoList", sidoList);
         	
         	
         	/* 페이징 관련*/
         	zipCodeVO.setPageUnit(propertiesService.getInt("pageUnit"));
         	zipCodeVO.setPageSize(propertiesService.getInt("pageSize"));
         	
         	PaginationInfo paginationInfo = new PaginationInfo();
         	
         	paginationInfo.setCurrentPageNo(zipCodeVO.getPageIndex());
         	paginationInfo.setRecordCountPerPage(zipCodeVO.getPageUnit());
         	paginationInfo.setPageSize(zipCodeVO.getPageSize());

         	zipCodeVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
         	zipCodeVO.setLastIndex(paginationInfo.getLastRecordIndex());
         	zipCodeVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
         	
         	/* 우편번호 조회결과 */
         	if( !EgovStringUtil.isEmpty(zipCodeVO.getpSido()) ) {
     	    	/* (신)주소 리스트와 카운트 가져오기 */
     	    	Map<String, Object> map = popupService.selectZipCodeDoroInfs(zipCodeVO);  
     	    	int totCnt = Integer.parseInt((String)map.get("resultCnt"));
     	    	
     	    	/* 페이징 관련값 바인딩 */
     	    	paginationInfo.setTotalRecordCount(totCnt); //total count
     	    	model.addAttribute("paginationInfo", paginationInfo);
     	        
     	    	model.addAttribute("resultList", map.get("resultList"));
     	    	model.addAttribute("resultCnt", map.get("resultCnt"));
         	} else {
         		/* 페이징 관련값 바인딩 */
     	    	paginationInfo.setTotalRecordCount(0); //total count
     	    	model.addAttribute("paginationInfo", paginationInfo);
     	        
     	    	model.addAttribute("resultList", "");
     	    	model.addAttribute("resultCnt", 0);
         	}
         	
             return "/cmm/zipcode/zipCodeListPopup";
         }
}
