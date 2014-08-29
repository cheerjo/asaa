package estam.app.sym.usr.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import estam.app.com.util.ExriaUdtoMapUtil;
import estam.app.sym.usr.service.SymPrivGrpCboVO;
import estam.app.sym.usr.service.SymUserDefaultVO;
import estam.app.sym.usr.service.SymUserService;
import estam.app.sym.usr.service.SymUserVO; 
import egovframework.let.utl.sim.service.EgovFileScrty;

/**
 * @Class Name : SymUserController.java
 * @Description : SymUser Controller class
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
@SessionAttributes(types=SymUserVO.class) 
public class SymUserController {

	private Log log = LogFactory.getLog(this.getClass()); 
	
    @Resource(name = "symUserService")
    private SymUserService symUserService;
    
   
    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
    
    //공통코드조회
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    @Resource(name = "messageSource")
	protected MessageSource messageSource;
    
	@Resource(name = "beanValidator")
	private DefaultBeanValidator beanValidator;
 
	   /**
     * 사용자관리에서 사용되는  권한그룹 맵핑을 위한 값을 가지고 온다.
     * @return 
     * @throws Exception
     */ 
    @ModelAttribute("privGrpList")
	public List<SymPrivGrpCboVO> listSymPrivGrp() throws Exception {
    	
		return symUserService.listSymPrivGrp();
	}
     
    
    /**
     * 
     * @param searchVO
     * @param flag
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/sym/symUser/SymUser.do")
    public String pgrBarFormView(@ModelAttribute("searchVO") SymUserDefaultVO searchVO,  
  		    ModelMap model)
           throws Exception { 
       
        return "/estam/sym/symUser/SymUser";
    }  
    
    /**
     * 콤보박스 
     * @param uDto
     * @param searchVO
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/sym/symUser/selectComboListEx.do")
    public ModelAndView selectComboListEx(ExriaUDDTO uDto, ModelMap model, HttpServletRequest request)
            throws Exception {
    	 
    	RequestData reqData = uDto.getRequestData();
    	HttpSession session = request.getSession();
    	
		session.removeAttribute("method");

 		List<SymPrivGrpCboVO> privGrpList = new ArrayList<SymPrivGrpCboVO>();
 		privGrpList = listSymPrivGrp();
		
 		//TODO 차후 적용 공통코드 조회
//		ComDefaultCodeVO vo = new ComDefaultCodeVO();
//		vo.setCommCd("COM022");
//		List code = cmmUseService.selectCmmCodeDetail(vo);
//		model.addAttribute("pwhtCdList", code);

		Map<String, Object> mm = new HashMap<String, Object>(); 

		if(privGrpList != null) {
			//searchVO.setSearchDept(null);
			ExriaUdtoMapUtil.addListToResponseMap(reqData, "privGrpList", privGrpList, mm); 
			ExriaUdtoMapUtil.addListToResponseMap(reqData, "grxPrivGrpList", privGrpList, mm);
		}
  
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
 
		return mav;
    } 
    
      
    /**
     * 조회 조건에 따른 화면 출력 
     * @param uDto
     * @param searchVO
     * @param model
     * @param request
     * @return@ModelAttribute("searchVO") SymUserDefaultVO searchVO,
     * @throws Exception
     */
    
    @SuppressWarnings({ "rawtypes", "unchecked"})
	@RequestMapping(value="/sym/symUser/SymUserListEx.do")
    public ModelAndView selectSymUserListEx(ExriaUDDTO uDto, 
    		ModelMap model, HttpServletRequest request)
            throws Exception {
    	 
    	RequestData reqData = uDto.getRequestData();
    	HttpSession session = request.getSession();
		//session.removeAttribute("empno");
		session.removeAttribute("method");
		SymUserDefaultVO searchVO = (SymUserDefaultVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.usr.service.SymUserDefaultVO");
		
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
			searchVO = (SymUserDefaultVO)session.getAttribute("searchVO");
			session.removeAttribute("searchVO");
		}*/
	//	if(!reqData.getString("searchDept").equals("")) searchVO.setSearchDept(new Integer(reqData.getString("searchDept")));
		List<SymPrivGrpCboVO> privGrpList = null;
		//if(reqData.getString("searchDept") != null && reqData.getString("searchDept").equals("-1")) {
		privGrpList = listSymPrivGrp();
			//searchVO.setSearchDept(null);
	//	}
		
//    	Map searchMap = PropertyUtils.describe(searchVO);
//		PageVO pageVO = new PageVO(searchVO.getRecordCountPerPage(),
//				symUserService.selectSymUserListTotCnt(searchVO),
//				searchVO.getPageSize());
//		searchVO.setRecordCountPerPage(pageVO.getCurrPage());
		  
		List symUserList = new ArrayList();

		Map<String, Object> mm = new HashMap<String, Object>();   
	 
		List<Map<String,Object>> symUserMList = symUserService.selectSymUserList(searchVO);
		
		if(symUserMList.size() > 0){
			for (Map<String,Object> map : symUserMList) { 
				Map<String, Object> symUesrMap = new HashMap<String, Object>();
				for (Map.Entry<String,Object> entry: map.entrySet()) {
					String key = entry.getKey();
					Object value = entry.getValue();
					symUesrMap.put(key, value); 
				}   
				symUserList.add(symUesrMap); 
			} 
			mm.put("resSymUserList", symUserList); 
		}else{
			mm.put("resSymUserList", null); 
		}
	 
		if(privGrpList != null) {
			//searchVO.setSearchDept(null);
			ExriaUdtoMapUtil.addListToResponseMap(reqData, "privGrpList", privGrpList, mm);
			ExriaUdtoMapUtil.addListToResponseMap(reqData, "grxPrivGrpList", privGrpList, mm);
		}
		
		int totCnt = symUserService.selectSymUserListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		ExriaUdtoMapUtil.addListToResponseMap(reqData, "paginationInfo", paginationInfo, mm);
	
		mm.put("searchVO", reqData.getBeanToMap(searchVO));
		
		/*if(session.getAttribute("useSessionInfo") != null) {
			
			session.setAttribute("useSessionInfo", null);
		}*/
		
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
 
		return mav;
    } 
  
    //save  
    @RequestMapping("/sym/symUser/saveSymUserEx.do")
    public ModelAndView saveSymUserEx(ExriaUDDTO uDto, 
    		@RequestParam("method") String method , HttpServletRequest request ,SessionStatus status)
            throws Exception { 
    	
    	RequestData reqData = uDto.getRequestData();
    	SymUserVO symUserVO = (SymUserVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.usr.service.SymUserVO");
//		beanValidator.validate(employee, bindingResult);
    	
    	Map<String, String> message = new HashMap<String, String>();

		Map<String, Object> mm = new HashMap<String, Object>();
		Map<String, String> store = new HashMap<String, String>();
        String userPassword = "";
		HttpSession session = request.getSession();
    	LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
    	
    	
		if (symUserVO.getUserId() != null && symUserVO.getUserId() == "") {
			store.put("UserId", "errors.UserId");
		} else {
			if (method.equals("add")) { 
		    	
				SymUserVO resSymUserVo = symUserService.selectSymUser(symUserVO);
				
				userPassword = symUserVO.getUsrPswd();
		    	symUserVO.setUsrPswd(EgovFileScrty.encryptPassword(userPassword));
		    	
				
				if(resSymUserVo != null){
		    		message.put("procMsg","중복된 회원ID가 존재합니다.");
		    	}else{
		    		symUserVO.setInptUsrId(loginVO.getUserId());
					
					symUserService.insertSymUser(symUserVO);
					message.put("procMsg","");
		    	}
				
			} else if (method.equals("update")) {
				symUserVO.setUpdtUsrId(loginVO.getUserId());
				
				SymUserVO resSymUserVo = symUserService.selectSymUser(symUserVO);
				
				if (!resSymUserVo.getUsrPswd().equals(symUserVO.getUsrPswd())) {
					userPassword = symUserVO.getUsrPswd();
			    	symUserVO.setUsrPswd(EgovFileScrty.encryptPassword(userPassword));
				}
				symUserService.updateSymUser(symUserVO);
				
				message.put("procMsg","");
			}
		}

		mm.put("message", message);
		
		//ExriaUdtoMapUtil.addListToResponseMap(reqData, "message", message, mm);

		
		//mm.put("validCheck", store);
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
		status.setComplete();
		return mav;  
    } 
    
    //상세뷰
    @RequestMapping("/sym/symUser/selectSymUserEx.do")
    public ModelAndView selectSymUserEx(ExriaUDDTO uDto, HttpServletRequest request) throws Exception {
    	
		RequestData reqData = uDto.getRequestData();
	 
		SymUserVO symUserVO = (SymUserVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.usr.service.SymUserVO");
		
		Map<String, Object> mm = new HashMap<String, Object>();
		SymUserVO resSymUserVo = symUserService.selectSymUser(symUserVO);
		 
	    	
		ExriaUdtoMapUtil.addListToResponseMap(reqData, "resSymUserVO", resSymUserVo, mm);
		
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);
		
		return mav;
    }
    
    //삭제
    @RequestMapping("/sym/symUser/deleteSymUserEx.do")
    public ModelAndView deleteSymUserEx(ExriaUDDTO uDto, SessionStatus status)
            throws Exception {
    	 
    	RequestData reqData = uDto.getRequestData();
		
		SymUserVO symUserVO = (SymUserVO)ExriaUdtoMapUtil.getMapToBean(reqData, "estam.app.sym.usr.service.SymUserVO");
		
    	symUserService.deleteSymUser(symUserVO);
    	status.setComplete();
    	
		Map<String, String> mm = new HashMap<String, String>();
		//mm.put("message", messageSource.getMessage("I9012", null, Locale.getDefault()));
		ModelAndView mav = new ModelAndView("exriaView");
		mav.addObject(AdaptorConstants.MODEL_DOCUMENT, mm);

		return mav; 
    }
     
	
}
