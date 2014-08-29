package estam.app.scn.rpt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.rpt.service.RptFrstItemIptnDefaultVO;
import estam.app.scn.rpt.service.RptFrstItemIptnVO;

/**
 * @Class Name : RptFrstItemIptnDAO.java
 * @Description : RptFrstItemIptn DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("rptFrstItemIptnDAO")
public class RptFrstItemIptnDAO extends EgovAbstractDAO {

	/**
	 * RPT_FRST_ITEM_IPTN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstItemIptnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptFrstItemIptn(RptFrstItemIptnVO vo) throws Exception {
        return (String)insert("rptFrstItemIptnDAO.insertRptFrstItemIptn_S", vo);
    }

    /**
	 * RPT_FRST_ITEM_IPTN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstItemIptnVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptFrstItemIptn(RptFrstItemIptnVO vo) throws Exception {
        update("rptFrstItemIptnDAO.updateRptFrstItemIptn_S", vo);
    }

    /**
	 * RPT_FRST_ITEM_IPTN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstItemIptnVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptFrstItemIptn(RptFrstItemIptnVO vo) throws Exception {
        delete("rptFrstItemIptnDAO.deleteRptFrstItemIptn_S", vo);
    }

    /**
	 * RPT_FRST_ITEM_IPTN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstItemIptnVO
	 * @return 조회한 RPT_FRST_ITEM_IPTN
	 * @exception Exception
	 */
    public RptFrstItemIptnVO selectRptFrstItemIptn(RptFrstItemIptnVO vo) throws Exception {
        return (RptFrstItemIptnVO) selectByPk("rptFrstItemIptnDAO.selectRptFrstItemIptn_S", vo);
    }

    /**
	 * RPT_FRST_ITEM_IPTN 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_FRST_ITEM_IPTN 목록
	 * @exception Exception
	 */
    public List selectRptFrstItemIptnList(RptFrstItemIptnDefaultVO searchVO) throws Exception {
        return list("rptFrstItemIptnDAO.selectRptFrstItemIptnList_D", searchVO);
    }

    /**
	 * RPT_FRST_ITEM_IPTN 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_FRST_ITEM_IPTN 총 갯수
	 * @exception
	 */
    public int selectRptFrstItemIptnListTotCnt(RptFrstItemIptnDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("rptFrstItemIptnDAO.selectRptFrstItemIptnListTotCnt_S", searchVO);
    }

}
