package estam.app.popup.service; 

import java.util.List;
import java.util.Map;

/**
 * @Class Name : SymMenuService.java
 * @Description : SymMenu Business class
 * @Modification Information
 *
 * @author ATRES
 * @since 20130703
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface PopupService { 
	 
    /**
	 * SYM_MENU 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_MENU 목록
	 * @exception Exception
	 */
    List<SymMenuVO> selectPopupSymMenu(PopupDefaultVO searchVO) throws Exception; 
    
    /**
	 * SYM_COMM_CD 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_COMM_CD 목록
	 * @exception Exception
	 */
    List<SymCommCdVO> selectPopupSymCommCd(PopupDefaultVO searchVO) throws Exception;
    
    /**
     * (구)우편번호 리스트를 조회한다.
     *
     * @param vo
     * @return 목록
     * @throws Exception the exception
     */
    public List selectZipCodeList(ZipCodeVO vo) throws Exception; 
    
    /**
     * (신)우편번호 리스트를 조회한다.
     *
     * @param vo
     * @return 목록
     * @throws Exception the exception
     */
    public Map<String, Object> selectZipCodeDoroInfs(ZipCodeVO vo) throws Exception;    
    
}
