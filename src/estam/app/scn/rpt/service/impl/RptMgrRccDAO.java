package estam.app.scn.rpt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.rpt.service.RptMgrRccDefaultVO;
import estam.app.scn.rpt.service.RptMgrRccVO;

/**
 * @Class Name : RptMgrRccDAO.java
 * @Description : RptMgrRcc DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("rptMgrRccDAO")
public class RptMgrRccDAO extends EgovAbstractDAO {

	/**
	 * RPT_MGR_RCC을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptMgrRccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptMgrRcc(RptMgrRccVO vo) throws Exception {
        return (String)insert("rptMgrRccDAO.insertRptMgrRcc_S", vo);
    }

    /**
	 * RPT_MGR_RCC을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptMgrRccVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptMgrRcc(RptMgrRccVO vo) throws Exception {
        update("rptMgrRccDAO.updateRptMgrRcc_S", vo);
    }

    /**
	 * RPT_MGR_RCC을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptMgrRccVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptMgrRcc(RptMgrRccVO vo) throws Exception {
        delete("rptMgrRccDAO.deleteRptMgrRcc_S", vo);
    }

    /**
	 * RPT_MGR_RCC을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptMgrRccVO
	 * @return 조회한 RPT_MGR_RCC
	 * @exception Exception
	 */
    public RptMgrRccVO selectRptMgrRcc(RptMgrRccVO vo) throws Exception {
        return (RptMgrRccVO) selectByPk("rptMgrRccDAO.selectRptMgrRcc_S", vo);
    }

    /**
	 * RPT_MGR_RCC 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_MGR_RCC 목록
	 * @exception Exception
	 */
    public List selectRptMgrRccList(RptMgrRccDefaultVO searchVO) throws Exception {
        return list("rptMgrRccDAO.selectRptMgrRccList_D", searchVO);
    }

    /**
	 * RPT_MGR_RCC 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_MGR_RCC 총 갯수
	 * @exception
	 */
    public int selectRptMgrRccListTotCnt(RptMgrRccDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("rptMgrRccDAO.selectRptMgrRccListTotCnt_S", searchVO);
    }

}
