package estam.app.scn.rpt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.rpt.service.RptFrstEhqkScnDefaultVO;
import estam.app.scn.rpt.service.RptFrstEhqkScnVO;

/**
 * @Class Name : RptFrstEhqkScnDAO.java
 * @Description : RptFrstEhqkScn DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("rptFrstEhqkScnDAO")
public class RptFrstEhqkScnDAO extends EgovAbstractDAO {

	/**
	 * RPT_FRST_EHQK_SCN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstEhqkScnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptFrstEhqkScn(RptFrstEhqkScnVO vo) throws Exception {
        return (String)insert("rptFrstEhqkScnDAO.insertRptFrstEhqkScn_S", vo);
    }

    /**
	 * RPT_FRST_EHQK_SCN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstEhqkScnVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptFrstEhqkScn(RptFrstEhqkScnVO vo) throws Exception {
        update("rptFrstEhqkScnDAO.updateRptFrstEhqkScn_S", vo);
    }

    /**
	 * RPT_FRST_EHQK_SCN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstEhqkScnVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptFrstEhqkScn(RptFrstEhqkScnVO vo) throws Exception {
        delete("rptFrstEhqkScnDAO.deleteRptFrstEhqkScn_S", vo);
    }

    /**
	 * RPT_FRST_EHQK_SCN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstEhqkScnVO
	 * @return 조회한 RPT_FRST_EHQK_SCN
	 * @exception Exception
	 */
    public RptFrstEhqkScnVO selectRptFrstEhqkScn(RptFrstEhqkScnVO vo) throws Exception {
        return (RptFrstEhqkScnVO) selectByPk("rptFrstEhqkScnDAO.selectRptFrstEhqkScn_S", vo);
    }

    /**
	 * RPT_FRST_EHQK_SCN 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_FRST_EHQK_SCN 목록
	 * @exception Exception
	 */
    public List selectRptFrstEhqkScnList(RptFrstEhqkScnDefaultVO searchVO) throws Exception {
        return list("rptFrstEhqkScnDAO.selectRptFrstEhqkScnList_D", searchVO);
    }

    /**
	 * RPT_FRST_EHQK_SCN 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_FRST_EHQK_SCN 총 갯수
	 * @exception
	 */
    public int selectRptFrstEhqkScnListTotCnt(RptFrstEhqkScnDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("rptFrstEhqkScnDAO.selectRptFrstEhqkScnListTotCnt_S", searchVO);
    }

}
