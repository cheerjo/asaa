package estam.app.scn.rpt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.rpt.service.RptFrstFreeDefaultVO;
import estam.app.scn.rpt.service.RptFrstFreeVO;

/**
 * @Class Name : RptFrstFreeDAO.java
 * @Description : RptFrstFree DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("rptFrstFreeDAO")
public class RptFrstFreeDAO extends EgovAbstractDAO {

	/**
	 * RPT_FRST_FREE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstFreeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptFrstFree(RptFrstFreeVO vo) throws Exception {
        return (String)insert("rptFrstFreeDAO.insertRptFrstFree_S", vo);
    }

    /**
	 * RPT_FRST_FREE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstFreeVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptFrstFree(RptFrstFreeVO vo) throws Exception {
        update("rptFrstFreeDAO.updateRptFrstFree_S", vo);
    }

    /**
	 * RPT_FRST_FREE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstFreeVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptFrstFree(RptFrstFreeVO vo) throws Exception {
        delete("rptFrstFreeDAO.deleteRptFrstFree_S", vo);
    }

    /**
	 * RPT_FRST_FREE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstFreeVO
	 * @return 조회한 RPT_FRST_FREE
	 * @exception Exception
	 */
    public RptFrstFreeVO selectRptFrstFree(RptFrstFreeVO vo) throws Exception {
        return (RptFrstFreeVO) selectByPk("rptFrstFreeDAO.selectRptFrstFree_S", vo);
    }

    /**
	 * RPT_FRST_FREE 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_FRST_FREE 목록
	 * @exception Exception
	 */
    public List selectRptFrstFreeList(RptFrstFreeDefaultVO searchVO) throws Exception {
        return list("rptFrstFreeDAO.selectRptFrstFreeList_D", searchVO);
    }

    /**
	 * RPT_FRST_FREE 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_FRST_FREE 총 갯수
	 * @exception
	 */
    public int selectRptFrstFreeListTotCnt(RptFrstFreeDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("rptFrstFreeDAO.selectRptFrstFreeListTotCnt_S", searchVO);
    }

}
