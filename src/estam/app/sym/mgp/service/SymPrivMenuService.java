package estam.app.sym.mgp.service;

import java.util.List;
import java.util.Map;

import estam.app.sym.grp.service.SymPrivGrpDefaultVO;
import estam.app.sym.grp.service.SymPrivGrpVO;
import estam.app.sym.mgp.service.SymPrivMenuDefaultVO;
import estam.app.sym.mgp.service.SymPrivMenuVO;

/**
 * @Class Name : SymPrivMenuService.java
 * @Description : SymPrivMenu Business class
 * @Modification Information
 *
 * @author ATRES
 * @since 2013.07.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface SymPrivMenuService {
	
	/**
	 * SYM_PRIV_MENU을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymPrivMenuVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertSymPrivMenu(SymPrivMenuVO vo) throws Exception;
    
    /**
	 * SYM_PRIV_MENU을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymPrivMenuVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSymPrivMenu(SymPrivMenuVO vo) throws Exception;
    
    /**
	 * SYM_PRIV_MENU을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymPrivMenuVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSymPrivMenu(SymPrivMenuVO vo) throws Exception;
    
    /**
	 * SYM_PRIV_MENU을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymPrivMenuVO
	 * @return 조회한 SYM_PRIV_MENU
	 * @exception Exception
	 */
    SymPrivMenuVO selectSymPrivMenu(SymPrivMenuVO vo) throws Exception;
    
    /**
	 * SYM_PRIV_MENU 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_PRIV_MENU 목록
	 * @exception Exception
	 */
    List selectSymPrivMenuList(SymPrivMenuDefaultVO searchVO) throws Exception;
  
       
    /**
	 * SYM_PRIV_MENU 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_PRIV_MENU 총 갯수
	 * @exception
	 */
    int selectSymPrivMenuListTotCnt(SymPrivMenuDefaultVO searchVO);
    
    
    /**
   	 * SYM_PRIV_GRP 목록을 조회한다.
   	 * @param searchVO - 조회할 정보가 담긴 VO
   	 * @return SYM_PRIV_GRP 목록
   	 * @exception Exception
   	 */
    List selectSymPrivMenuExria(SymPrivMenuVO searchVO) throws Exception;
    
    /**
  	 * SYM_PRIV_GRP 목록을 조회한다.
  	 * @param searchVO - 조회할 정보가 담긴 VO
  	 * @return SYM_PRIV_GRP 목록
  	 * @exception Exception
  	 */
   List selectSymNonPrivMenuExria(SymPrivMenuVO searchVO) throws Exception;
   
   /**
	 * SYM_PRIV_MENU을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymPrivMenuVO
	 * @return void형
	 * @exception Exception
	 */
   void savePrivMenuExria(SymPrivMenuVO vo) throws Exception;
   
   /**
	 * SYM_PRIV_MENU을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymPrivMenuVO
	 * @return void형
	 * @exception Exception
	 */
   void deletePrivMenuExria(SymPrivMenuVO vo) throws Exception;
   
   List<Map<String, Object>> ListSymPrivGrpExria() throws Exception;

   
}
