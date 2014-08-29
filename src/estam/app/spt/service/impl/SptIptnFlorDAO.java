package estam.app.spt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.spt.service.SptIptnFlorVO;
import estam.app.spt.service.SptIptnFlorDefaultVO;

/**
 * @Class Name : SptIptnFlorDAO.java
 * @Description : SptIptnFlor DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("sptIptnFlorDAO")
public class SptIptnFlorDAO extends EgovAbstractDAO {

	/**
	 * SPT_IPTN_FLOR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SptIptnFlorVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSptIptnFlor(SptIptnFlorVO vo) throws Exception {
        return (String)insert("sptIptnFlorDAO.insertSptIptnFlor_S", vo);
    }

    /**
	 * SPT_IPTN_FLOR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SptIptnFlorVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSptIptnFlor(SptIptnFlorVO vo) throws Exception {
        update("sptIptnFlorDAO.updateSptIptnFlor_S", vo);
    }

    /**
	 * SPT_IPTN_FLOR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SptIptnFlorVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSptIptnFlor(SptIptnFlorVO vo) throws Exception {
        delete("sptIptnFlorDAO.deleteSptIptnFlor_S", vo);
    }

    /**
	 * SPT_IPTN_FLOR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SptIptnFlorVO
	 * @return 조회한 SPT_IPTN_FLOR
	 * @exception Exception
	 */
    public SptIptnFlorVO selectSptIptnFlor(SptIptnFlorVO vo) throws Exception {
        return (SptIptnFlorVO) selectByPk("sptIptnFlorDAO.selectSptIptnFlor_S", vo);
    }

    /**
	 * SPT_IPTN_FLOR 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_FLOR 목록
	 * @exception Exception
	 */
    public List selectSptIptnFlorList(SptIptnFlorDefaultVO searchVO) throws Exception {
        return list("sptIptnFlorDAO.selectSptIptnFlorList_D", searchVO);
    }

    /**
	 * SPT_IPTN_FLOR 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_FLOR 총 갯수
	 * @exception
	 */
    public int selectSptIptnFlorListTotCnt(SptIptnFlorDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sptIptnFlorDAO.selectSptIptnFlorListTotCnt_S", searchVO);
    }

}
