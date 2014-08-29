package estam.app.scn.rpt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.rpt.service.RptRglrIptnDefaultVO;
import estam.app.scn.rpt.service.RptRglrIptnVO;

/**
 * @Class Name : RptRglrIptnDAO.java
 * @Description : RptRglrIptn DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("rptRglrIptnDAO")
public class RptRglrIptnDAO extends EgovAbstractDAO {

	/**
	 * RPT_RGLR_IPTN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptRglrIptnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptRglrIptn(RptRglrIptnVO vo) throws Exception {
        return (String)insert("rptRglrIptnDAO.insertRptRglrIptn_S", vo);
    }

    /**
	 * RPT_RGLR_IPTN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptRglrIptnVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptRglrIptn(RptRglrIptnVO vo) throws Exception {
        update("rptRglrIptnDAO.updateRptRglrIptn_S", vo);
    }

    /**
	 * RPT_RGLR_IPTN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptRglrIptnVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptRglrIptn(RptRglrIptnVO vo) throws Exception {
        delete("rptRglrIptnDAO.deleteRptRglrIptn_S", vo);
    }

    /**
	 * RPT_RGLR_IPTN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptRglrIptnVO
	 * @return 조회한 RPT_RGLR_IPTN
	 * @exception Exception
	 */
    public RptRglrIptnVO selectRptRglrIptn(RptRglrIptnVO vo) throws Exception {
        return (RptRglrIptnVO) selectByPk("rptRglrIptnDAO.selectRptRglrIptn_S", vo);
    }

    /**
	 * RPT_RGLR_IPTN 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_RGLR_IPTN 목록
	 * @exception Exception
	 */
    public List selectRptRglrIptnList(RptRglrIptnVO vo) throws Exception {
        return list("rptRglrIptnDAO.selectRptRglrIptnList_D", vo);
    }

    /**
	 * RPT_RGLR_IPTN 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_RGLR_IPTN 총 갯수
	 * @exception
	 */
    public int selectRptRglrIptnListTotCnt(RptRglrIptnDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("rptRglrIptnDAO.selectRptRglrIptnListTotCnt_S", searchVO);
    }

}
