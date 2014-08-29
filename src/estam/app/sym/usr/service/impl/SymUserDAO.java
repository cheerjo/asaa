package estam.app.sym.usr.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.sym.usr.service.SymPrivGrpCboVO;
import estam.app.sym.usr.service.SymUserDefaultVO;
import estam.app.sym.usr.service.SymUserVO;

/**
 * @Class Name : SymUserDAO.java
 * @Description : SymUser DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2013.07.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("symUserDAO")
public class SymUserDAO extends EgovAbstractDAO {

	/**
	 * SYM_USER을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymUserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSymUser(SymUserVO vo) throws Exception {
        return (String)insert("symUserDAO.insertSymUser_S", vo);
    }

    /**
	 * SYM_USER을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymUserVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSymUser(SymUserVO vo) throws Exception {
        update("symUserDAO.updateSymUser_S", vo);
    }

    /**
	 * SYM_USER을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymUserVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSymUser(SymUserVO vo) throws Exception {
        delete("symUserDAO.deleteSymUser_S", vo);
    }

    /**
	 * SYM_USER을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymUserVO
	 * @return 조회한 SYM_USER
	 * @exception Exception
	 */
    public SymUserVO selectSymUser(SymUserVO vo) throws Exception {
        return (SymUserVO) selectByPk("symUserDAO.selectSymUser_S", vo);
    }

    /**
	 * SYM_USER 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYM_USER 목록
	 * @exception Exception
	 */
   
    public List selectSymUserList(SymUserDefaultVO searchVO) throws Exception {
        return list("symUserDAO.selectSymUserList_D", searchVO);
    }

    /**
	 * SYM_USER 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYM_USER 총 갯수
	 * @exception
	 */
 
    public int selectSymUserListTotCnt(SymUserDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("symUserDAO.selectSymUserListTotCnt_S", searchVO);
    }
    
    /**
   	 * SYM_PRIV_GRP 목록 콤보처리을 위해  코드/명을 구해 온다.  
   	 * @return SYM_PRIV_GRP 목록 리스트
   	 * @exception Exception
   	 */
    @SuppressWarnings("unchecked")
    public List<SymPrivGrpCboVO> listSymPrivGrp() throws Exception {
        return list("symUserDAO.listSymPrivGrp_S",null);
    }

}
