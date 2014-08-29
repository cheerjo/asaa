package estam.app.sym.mnu.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.sym.mnu.service.SymMenuVO;
import estam.app.sym.mnu.service.SymMenuDefaultVO;

/**
 * @Class Name : SymMenuDAO.java
 * @Description : SymMenu DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 20130703
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("symMenuDAO")
public class SymMenuDAO extends EgovAbstractDAO {

	/**
	 * SYM_MENU을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymMenuVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSymMenu(SymMenuVO vo) throws Exception {
        return (String)insert("symMenuDAO.insertSymMenu_S", vo);
    }

    /**
	 * SYM_MENU을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymMenuVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSymMenu(SymMenuVO vo) throws Exception {
        update("symMenuDAO.updateSymMenu_S", vo);
    }

    /**
	 * SYM_MENU을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymMenuVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSymMenu(SymMenuVO vo) throws Exception {
        delete("symMenuDAO.deleteSymMenu_S", vo);
    }

    /**
	 * SYM_MENU을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymMenuVO
	 * @return 조회한 SYM_MENU
	 * @exception Exception
	 */
    public SymMenuVO selectSymMenu(SymMenuVO vo) throws Exception {
        return (SymMenuVO) selectByPk("symMenuDAO.selectSymMenu_S", vo);
    }

    /**
	 * SYM_MENU 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYM_MENU 목록
	 * @exception Exception
	 */
    public List selectSymMenuList(SymMenuDefaultVO searchVO) throws Exception {
        return list("symMenuDAO.selectSymMenuList_D", searchVO);
    }

    /**
	 * SYM_MENU 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYM_MENU 총 갯수
	 * @exception
	 */
    public int selectSymMenuListTotCnt(SymMenuDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("symMenuDAO.selectSymMenuListTotCnt_S", searchVO);
    }

}
