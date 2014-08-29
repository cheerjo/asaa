package estam.app.scn.rpt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.rpt.service.RptMgrEhqkScnVO;
import estam.app.scn.rpt.service.RptMgrEhqkScnDefaultVO;

/**
 * @Class Name : RptMgrEhqkScnDAO.java
 * @Description : RptMgrEhqkScn DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("rptMgrEhqkScnDAO")
public class RptMgrEhqkScnDAO extends EgovAbstractDAO {

	/**
	 * RPT_MGR_EHQK_SCN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptMgrEhqkScnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptMgrEhqkScn(RptMgrEhqkScnVO vo) throws Exception {
        return (String)insert("rptMgrEhqkScnDAO.insertRptMgrEhqkScn_S", vo);
    }

    /**
	 * RPT_MGR_EHQK_SCN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptMgrEhqkScnVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptMgrEhqkScn(RptMgrEhqkScnVO vo) throws Exception {
        update("rptMgrEhqkScnDAO.updateRptMgrEhqkScn_S", vo);
    }

    /**
	 * RPT_MGR_EHQK_SCN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptMgrEhqkScnVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptMgrEhqkScn(RptMgrEhqkScnVO vo) throws Exception {
        delete("rptMgrEhqkScnDAO.deleteRptMgrEhqkScn_S", vo);
    }

    /**
	 * RPT_MGR_EHQK_SCN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptMgrEhqkScnVO
	 * @return 조회한 RPT_MGR_EHQK_SCN
	 * @exception Exception
	 */
    public RptMgrEhqkScnVO selectRptMgrEhqkScn(RptMgrEhqkScnVO vo) throws Exception {
        return (RptMgrEhqkScnVO) selectByPk("rptMgrEhqkScnDAO.selectRptMgrEhqkScn_S", vo);
    }

    /**
	 * RPT_MGR_EHQK_SCN 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_MGR_EHQK_SCN 목록
	 * @exception Exception
	 */
    public List selectRptMgrEhqkScnList(RptMgrEhqkScnDefaultVO searchVO) throws Exception {
        return list("rptMgrEhqkScnDAO.selectRptMgrEhqkScnList_D", searchVO);
    }

    /**
	 * RPT_MGR_EHQK_SCN 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_MGR_EHQK_SCN 총 갯수
	 * @exception
	 */
    public int selectRptMgrEhqkScnListTotCnt(RptMgrEhqkScnDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("rptMgrEhqkScnDAO.selectRptMgrEhqkScnListTotCnt_S", searchVO);
    }

}
