package estam.app.popup.service.impl;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.popup.service.PopupDefaultVO;
import estam.app.popup.service.PopupService;
import estam.app.popup.service.SymCommCdVO;
import estam.app.popup.service.SymMenuVO;
import estam.app.popup.service.ZipCodeVO;

/**
 * @Class Name : SymMenuServiceImpl.java
 * @Description : SymMenu Business Implement class
 * @Modification Information
 *
 * @author ATRES
 * @since 20130703
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */ 
@Service("popupService")
public class PopupServiceImpl extends AbstractServiceImpl implements PopupService {

    @Resource(name="popupDAO")
    private PopupDAO popupDAO;
     
    
    /** ID Generation */
    //@Resource(name="{egovSymMenuIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
 
    /**
	 * SYM_MENU 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_MENU 목록
	 * @exception Exception
	 */
    public List<SymMenuVO> selectPopupSymMenu(PopupDefaultVO searchVO) throws Exception {
        return popupDAO.selectPopupSymMenu(searchVO);
    }
    

    /**
	 * SYM_COMM_CD 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_COMM_CD 목록
	 * @exception Exception
	 */
    public List<SymCommCdVO> selectPopupSymCommCd(PopupDefaultVO searchVO) throws Exception {
        return popupDAO.selectPopupSymCommCd(searchVO);
    }
    
    
    /**
     * (구)우편번호 리스트를 조회한다.
     *
     * @param vo
     * @return 목록
     * @throws Exception the exception
     */
    public List selectZipCodeList(ZipCodeVO vo) throws Exception {
        return popupDAO.zipCodeList(vo);
    }
    
    /**
     * (신)우편번호 리스트를 조회한다.
     *
     * @param vo
     * @return 목록
     * @throws Exception the exception
     */
    public Map<String, Object> selectZipCodeDoroInfs(ZipCodeVO vo) throws Exception {
        
    	/* (신)우편번호 페이지 리스트 */
    	List<ZipCodeVO> result = popupDAO.selectZipCodeDoroPageList(vo);
    	
    	/* (신)우편번호 페이지 리스트 카운트 */
    	int cnt = popupDAO.selectZipCodeDoroPageListCnt(vo); 
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("resultList", result);
    	map.put("resultCnt", Integer.toString(cnt));
    	
    	return map;
    }

 
    
}
