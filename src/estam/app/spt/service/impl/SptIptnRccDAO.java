package estam.app.spt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.spt.service.SptIptnRccVO;
import estam.app.spt.service.SptIptnRccDefaultVO;

/**
 * @Class Name : SptIptnRccDAO.java
 * @Description : SptIptnRcc DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("sptIptnRccDAO")
public class SptIptnRccDAO extends EgovAbstractDAO {

	/**
	 * SPT_IPTN_RCC을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SptIptnRccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSptIptnRcc(SptIptnRccVO vo) throws Exception {
        return (String)insert("sptIptnRccDAO.insertSptIptnRcc_S", vo);
    }

    /**
	 * SPT_IPTN_RCC을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SptIptnRccVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSptIptnRcc(SptIptnRccVO vo) throws Exception {
        update("sptIptnRccDAO.updateSptIptnRcc_S", vo);
    }

    /**
	 * SPT_IPTN_RCC을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SptIptnRccVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSptIptnRcc(SptIptnRccVO vo) throws Exception {
        delete("sptIptnRccDAO.deleteSptIptnRcc_S", vo);
    }

    /**
	 * SPT_IPTN_RCC을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SptIptnRccVO
	 * @return 조회한 SPT_IPTN_RCC
	 * @exception Exception
	 */
    public SptIptnRccVO selectSptIptnRcc(SptIptnRccVO vo) throws Exception {
        return (SptIptnRccVO) selectByPk("sptIptnRccDAO.selectSptIptnRcc_S", vo);
    }

    /**
	 * SPT_IPTN_RCC 검색목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_RCC 목록
	 * @exception Exception
	 */
    public List selectSptIptnRccSearchList(SptIptnRccVO vo) throws Exception {
        return list("sptIptnRccDAO.selectSptIptnRccSearchList_S", vo);
    }
    
    /**
	 * SPT_IPTN_RCC 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_RCC 목록
	 * @exception Exception
	 */
    public List selectSptIptnRccList(SptIptnRccDefaultVO searchVO) throws Exception {
        return list("sptIptnRccDAO.selectSptIptnRccList_D", searchVO);
    }

    /**
	 * SPT_IPTN_RCC 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_RCC 총 갯수
	 * @exception
	 */
    public int selectSptIptnRccListTotCnt(SptIptnRccDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sptIptnRccDAO.selectSptIptnRccListTotCnt_S", searchVO);
    }

}
