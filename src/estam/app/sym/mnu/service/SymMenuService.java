package estam.app.sym.mnu.service;

import java.util.List;
import estam.app.sym.mnu.service.SymMenuDefaultVO;
import estam.app.sym.mnu.service.SymMenuVO;

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
public interface SymMenuService {
	
	/**
	 * SYM_MENU을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymMenuVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertSymMenu(SymMenuVO vo) throws Exception;
    
    /**
	 * SYM_MENU을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymMenuVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSymMenu(SymMenuVO vo) throws Exception;
    
    /**
	 * SYM_MENU을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymMenuVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSymMenu(SymMenuVO vo) throws Exception;
    
    /**
	 * SYM_MENU을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymMenuVO
	 * @return 조회한 SYM_MENU
	 * @exception Exception
	 */
    SymMenuVO selectSymMenu(SymMenuVO vo) throws Exception;
    
    /**
	 * SYM_MENU 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_MENU 목록
	 * @exception Exception
	 */
    List selectSymMenuList(SymMenuDefaultVO searchVO) throws Exception;
    
    /**
	 * SYM_MENU 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_MENU 총 갯수
	 * @exception
	 */
    int selectSymMenuListTotCnt(SymMenuDefaultVO searchVO);
    
}
