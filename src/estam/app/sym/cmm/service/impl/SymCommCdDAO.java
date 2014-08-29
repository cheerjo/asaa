package estam.app.sym.cmm.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.sym.cmm.service.SymCommCdVO;
import estam.app.sym.cmm.service.SymCommCdDefaultVO;

/**
 * @Class Name : SymCommCdDAO.java
 * @Description : SymCommCd DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.07.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("symCommCdDAO")
public class SymCommCdDAO extends EgovAbstractDAO {

	/**
	 * SYM_COMM_CD을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymCommCdVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSymCommCd(SymCommCdVO vo) throws Exception {
        return (String)insert("symCommCdDAO.insertSymCommCd_S", vo);
    }

    /**
	 * SYM_COMM_CD을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymCommCdVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSymCommCd(SymCommCdVO vo) throws Exception {
        update("symCommCdDAO.updateSymCommCd_S", vo);
    }

    /**
	 * SYM_COMM_CD을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymCommCdVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSymCommCd(SymCommCdVO vo) throws Exception {
        delete("symCommCdDAO.deleteSymCommCd_S", vo);
    }

    /**
	 * SYM_COMM_CD을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymCommCdVO
	 * @return 조회한 SYM_COMM_CD
	 * @exception Exception
	 */
    public SymCommCdVO selectSymCommCd(SymCommCdVO vo) throws Exception {
        return (SymCommCdVO) selectByPk("symCommCdDAO.selectSymCommCd_S", vo);
    }

    /**
	 * SYM_COMM_CD 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYM_COMM_CD 목록
	 * @exception Exception
	 */
    public List selectSymCommCdList(SymCommCdDefaultVO searchVO) throws Exception {
        return list("symCommCdDAO.selectSymCommCdList_D", searchVO);
    }

    /**
	 * SYM_COMM_CD 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYM_COMM_CD 총 갯수
	 * @exception
	 */
    public int selectSymCommCdListTotCnt(SymCommCdDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("symCommCdDAO.selectSymCommCdListTotCnt_S", searchVO);
    }

}
