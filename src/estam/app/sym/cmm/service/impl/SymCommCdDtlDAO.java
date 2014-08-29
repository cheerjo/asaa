package estam.app.sym.cmm.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.sym.cmm.service.SymCommCdDtlVO;
import estam.app.sym.cmm.service.SymCommCdDtlDefaultVO;

/**
 * @Class Name : SymCommCdDtlDAO.java
 * @Description : SymCommCdDtl DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.07.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("symCommCdDtlDAO")
public class SymCommCdDtlDAO extends EgovAbstractDAO {

	/**
	 * SYM_COMM_CD_DTL을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymCommCdDtlVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSymCommCdDtl(SymCommCdDtlVO vo) throws Exception {
        return (String)insert("symCommCdDtlDAO.insertSymCommCdDtl_S", vo);
    }

    /**
	 * SYM_COMM_CD_DTL을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymCommCdDtlVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSymCommCdDtl(SymCommCdDtlVO vo) throws Exception {
        update("symCommCdDtlDAO.updateSymCommCdDtl_S", vo);
    }

    /**
	 * SYM_COMM_CD_DTL을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymCommCdDtlVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSymCommCdDtl(SymCommCdDtlVO vo) throws Exception {
        delete("symCommCdDtlDAO.deleteSymCommCdDtl_S", vo);
    }

    /**
	 * SYM_COMM_CD_DTL을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymCommCdDtlVO
	 * @return 조회한 SYM_COMM_CD_DTL
	 * @exception Exception
	 */
    public SymCommCdDtlVO selectSymCommCdDtl(SymCommCdDtlVO vo) throws Exception {
        return (SymCommCdDtlVO) selectByPk("symCommCdDtlDAO.selectSymCommCdDtl_S", vo);
    }

    /**
	 * SYM_COMM_CD_DTL 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYM_COMM_CD_DTL 목록
	 * @exception Exception
	 */
    public List selectSymCommCdDtlList(SymCommCdDtlDefaultVO searchVO) throws Exception {
        return list("symCommCdDtlDAO.selectSymCommCdDtlList_D", searchVO);
    }

    /**
	 * SYM_COMM_CD_DTL 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYM_COMM_CD_DTL 총 갯수
	 * @exception
	 */
    public int selectSymCommCdDtlListTotCnt(SymCommCdDtlDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("symCommCdDtlDAO.selectSymCommCdDtlListTotCnt_S", searchVO);
    }

}
