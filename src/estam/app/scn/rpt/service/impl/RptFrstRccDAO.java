package estam.app.scn.rpt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.rpt.service.RptFrstRccDefaultVO;
import estam.app.scn.rpt.service.RptFrstRccVO;

/**
 * @Class Name : RptFrstRccDAO.java
 * @Description : RptFrstRcc DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("rptFrstRccDAO")
public class RptFrstRccDAO extends EgovAbstractDAO {

	/**
	 * RPT_FRST_RCC을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstRccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptFrstRcc(RptFrstRccVO vo) throws Exception {
        return (String)insert("rptFrstRccDAO.insertRptFrstRcc_S", vo);
    }

    /**
	 * RPT_FRST_RCC을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstRccVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptFrstRcc(RptFrstRccVO vo) throws Exception {
        update("rptFrstRccDAO.updateRptFrstRcc_S", vo);
    }

    /**
	 * RPT_FRST_RCC을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstRccVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptFrstRcc(RptFrstRccVO vo) throws Exception {
        delete("rptFrstRccDAO.deleteRptFrstRcc_S", vo);
    }

    /**
	 * RPT_FRST_RCC을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstRccVO
	 * @return 조회한 RPT_FRST_RCC
	 * @exception Exception
	 */
    public RptFrstRccVO selectRptFrstRcc(RptFrstRccVO vo) throws Exception {
        return (RptFrstRccVO) selectByPk("rptFrstRccDAO.selectRptFrstRcc_S", vo);
    }

    /**
	 * RPT_FRST_RCC 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_FRST_RCC 목록
	 * @exception Exception
	 */
    public List selectRptFrstRccList(RptFrstRccDefaultVO searchVO) throws Exception {
        return list("rptFrstRccDAO.selectRptFrstRccList_D", searchVO);
    }

    /**
	 * RPT_FRST_RCC 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_FRST_RCC 총 갯수
	 * @exception
	 */
    public int selectRptFrstRccListTotCnt(RptFrstRccDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("rptFrstRccDAO.selectRptFrstRccListTotCnt_S", searchVO);
    }

}
