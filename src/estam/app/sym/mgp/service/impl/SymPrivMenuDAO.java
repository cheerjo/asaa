package estam.app.sym.mgp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.sym.grp.service.SymPrivGrpDefaultVO;
import estam.app.sym.grp.service.SymPrivGrpVO;
import estam.app.sym.mgp.service.SymPrivMenuVO;
import estam.app.sym.mgp.service.SymPrivMenuDefaultVO;

/**
 * @Class Name : SymPrivMenuDAO.java
 * @Description : SymPrivMenu DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2013.07.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("symPrivMenuDAO")
public class SymPrivMenuDAO extends EgovAbstractDAO {

	/**
	 * SYM_PRIV_MENU을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymPrivMenuVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSymPrivMenu(SymPrivMenuVO vo) throws Exception {
        return (String)insert("symPrivMenuDAO.insertSymPrivMenu_S", vo);
    }

    /**
	 * SYM_PRIV_MENU을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymPrivMenuVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSymPrivMenu(SymPrivMenuVO vo) throws Exception {
        update("symPrivMenuDAO.updateSymPrivMenu_S", vo);
    }

    /**
	 * SYM_PRIV_MENU을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymPrivMenuVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSymPrivMenu(SymPrivMenuVO vo) throws Exception {
        delete("symPrivMenuDAO.deleteSymPrivMenu_S", vo);
    }

    /**
	 * SYM_PRIV_MENU을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymPrivMenuVO
	 * @return 조회한 SYM_PRIV_MENU
	 * @exception Exception
	 */
    public SymPrivMenuVO selectSymPrivMenu(SymPrivMenuVO vo) throws Exception {
        return (SymPrivMenuVO) selectByPk("symPrivMenuDAO.selectSymPrivMenu_S", vo);
    }

    /**
	 * SYM_PRIV_MENU 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYM_PRIV_MENU 목록
	 * @exception Exception
	 */
    public List selectSymPrivMenuList(SymPrivMenuDefaultVO searchVO) throws Exception {
        return list("symPrivMenuDAO.selectSymPrivMenuList_D", searchVO);
    }
     

    /**
	 * SYM_PRIV_MENU 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYM_PRIV_MENU 총 갯수
	 * @exception
	 */
    public int selectSymPrivMenuListTotCnt(SymPrivMenuDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("symPrivMenuDAO.selectSymPrivMenuListTotCnt_S", searchVO);
    }
    
    
    /**
  	 * SYM_PRIV_GRP 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return SYM_PRIV_GRP 목록
  	 * @exception Exception
  	 */
    @SuppressWarnings("unchecked")
      public List selectSymPrivMenuExria(SymPrivMenuVO searchVO) throws Exception {
          return list("symPrivMenuDAO.selectSymPrivMenuExria", searchVO);
      } 
    
    /**
  	 * SYM_PRIV_GRP 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return SYM_PRIV_GRP 목록
  	 * @exception Exception
  	 */
    @SuppressWarnings("unchecked")
      public List selectSymNonPrivMenuExria(SymPrivMenuVO searchVO) throws Exception {
          return list("symPrivMenuDAO.selectSymNonPrivMenuExria", searchVO);
      } 
    
	/**
	 * SYM_PRIV_MENU을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymPrivMenuVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void savePrivMenuExria(SymPrivMenuVO vo) throws Exception {
        insert("symPrivMenuDAO.savePrivMenuExria", vo);
    }
    
	/**
	 * SYM_PRIV_MENU을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymPrivMenuVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void deletePrivMenuExria(SymPrivMenuVO vo) throws Exception {
        insert("symPrivMenuDAO.deletePrivMenuExria", vo);
    }   
    
    public List<Map<String, Object>> ListSymPrivGrpExria() throws Exception {
    	return list("symPrivMenuDAO.ListSymPrivGrpExria", null);
    }    

}
