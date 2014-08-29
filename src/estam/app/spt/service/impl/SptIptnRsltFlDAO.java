package estam.app.spt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.spt.service.SptIptnRsltFlVO;
import estam.app.spt.service.SptIptnRsltFlDefaultVO;

/**
 * @Class Name : SptIptnRsltFlDAO.java
 * @Description : SptIptnRsltFl DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("sptIptnRsltFlDAO")
public class SptIptnRsltFlDAO extends EgovAbstractDAO {

	/**
	 * SPT_IPTN_RSLT_FL을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SptIptnRsltFlVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSptIptnRsltFl(SptIptnRsltFlVO vo) throws Exception {
        return (String)insert("sptIptnRsltFlDAO.insertSptIptnRsltFl_S", vo);
    }

    /**
	 * SPT_IPTN_RSLT_FL을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SptIptnRsltFlVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSptIptnRsltFl(SptIptnRsltFlVO vo) throws Exception {
        update("sptIptnRsltFlDAO.updateSptIptnRsltFl_S", vo);
    }

    /**
	 * SPT_IPTN_RSLT_FL을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SptIptnRsltFlVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSptIptnRsltFl(SptIptnRsltFlVO vo) throws Exception {
        delete("sptIptnRsltFlDAO.deleteSptIptnRsltFl_S", vo);
    }

    /**
	 * SPT_IPTN_RSLT_FL을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SptIptnRsltFlVO
	 * @return 조회한 SPT_IPTN_RSLT_FL
	 * @exception Exception
	 */
    public SptIptnRsltFlVO selectSptIptnRsltFl(SptIptnRsltFlVO vo) throws Exception {
        return (SptIptnRsltFlVO) selectByPk("sptIptnRsltFlDAO.selectSptIptnRsltFl_S", vo);
    }

    /**
	 * SPT_IPTN_RSLT_FL 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_RSLT_FL 목록
	 * @exception Exception
	 */
    public List selectSptIptnRsltFlList(SptIptnRsltFlVO vo) throws Exception {
        return list("sptIptnRsltFlDAO.selectSptIptnRsltFlList_D", vo);
    }

    /**
	 * SPT_IPTN_RSLT_FL 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_RSLT_FL 총 갯수
	 * @exception
	 */
    public int selectSptIptnRsltFlListTotCnt(SptIptnRsltFlDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sptIptnRsltFlDAO.selectSptIptnRsltFlListTotCnt_S", searchVO);
    }

}