package estam.app.scn.rpt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.rpt.service.RptFrstIptnDefaultVO;
import estam.app.scn.rpt.service.RptFrstIptnVO;

/**
 * @Class Name : RptFrstIptnDAO.java
 * @Description : RptFrstIptn DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("rptFrstIptnDAO")
public class RptFrstIptnDAO extends EgovAbstractDAO {

	/**
	 * RPT_FRST_IPTN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstIptnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptFrstIptn(RptFrstIptnVO vo) throws Exception {
        return (String)insert("rptFrstIptnDAO.insertRptFrstIptn_S", vo);
    }

    /**
	 * RPT_FRST_IPTN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstIptnVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptFrstIptn(RptFrstIptnVO vo) throws Exception {
        update("rptFrstIptnDAO.updateRptFrstIptn_S", vo);
    }

    /**
	 * RPT_FRST_IPTN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstIptnVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptFrstIptn(RptFrstIptnVO vo) throws Exception {
        delete("rptFrstIptnDAO.deleteRptFrstIptn_S", vo);
    }

    /**
	 * RPT_FRST_IPTN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstIptnVO
	 * @return 조회한 RPT_FRST_IPTN
	 * @exception Exception
	 */
    public RptFrstIptnVO selectRptFrstIptn(RptFrstIptnVO vo) throws Exception {
        return (RptFrstIptnVO) selectByPk("rptFrstIptnDAO.selectRptFrstIptn_S", vo);
    }

    /**
	 * RPT_FRST_IPTN 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_FRST_IPTN 목록
	 * @exception Exception
	 */
    public List selectRptFrstIptnList(RptFrstIptnDefaultVO searchVO) throws Exception {
        return list("rptFrstIptnDAO.selectRptFrstIptnList_D", searchVO);
    }

    /**
	 * RPT_FRST_IPTN 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_FRST_IPTN 총 갯수
	 * @exception
	 */
    public int selectRptFrstIptnListTotCnt(RptFrstIptnDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("rptFrstIptnDAO.selectRptFrstIptnListTotCnt_S", searchVO);
    }

}
