package estam.app.scn.rpt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.rpt.service.RptMgrHolcImgDefaultVO;
import estam.app.scn.rpt.service.RptMgrHolcImgVO;

/**
 * @Class Name : RptMgrHolcImgDAO.java
 * @Description : RptMgrHolcImg DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("rptMgrHolcImgDAO")
public class RptMgrHolcImgDAO extends EgovAbstractDAO {

	/**
	 * RPT_MGR_HOLC_IMG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptMgrHolcImgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptMgrHolcImg(RptMgrHolcImgVO vo) throws Exception {
        return (String)insert("rptMgrHolcImgDAO.insertRptMgrHolcImg_S", vo);
    }

    /**
	 * RPT_MGR_HOLC_IMG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptMgrHolcImgVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptMgrHolcImg(RptMgrHolcImgVO vo) throws Exception {
        update("rptMgrHolcImgDAO.updateRptMgrHolcImg_S", vo);
    }

    /**
	 * RPT_MGR_HOLC_IMG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptMgrHolcImgVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptMgrHolcImg(RptMgrHolcImgVO vo) throws Exception {
        delete("rptMgrHolcImgDAO.deleteRptMgrHolcImg_S", vo);
    }

    /**
	 * RPT_MGR_HOLC_IMG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptMgrHolcImgVO
	 * @return 조회한 RPT_MGR_HOLC_IMG
	 * @exception Exception
	 */
    public RptMgrHolcImgVO selectRptMgrHolcImg(RptMgrHolcImgVO vo) throws Exception {
        return (RptMgrHolcImgVO) selectByPk("rptMgrHolcImgDAO.selectRptMgrHolcImg_S", vo);
    }

    /**
	 * RPT_MGR_HOLC_IMG 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_MGR_HOLC_IMG 목록
	 * @exception Exception
	 */
    public List selectRptMgrHolcImgList(RptMgrHolcImgDefaultVO searchVO) throws Exception {
        return list("rptMgrHolcImgDAO.selectRptMgrHolcImgList_D", searchVO);
    }

    /**
	 * RPT_MGR_HOLC_IMG 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_MGR_HOLC_IMG 총 갯수
	 * @exception
	 */
    public int selectRptMgrHolcImgListTotCnt(RptMgrHolcImgDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("rptMgrHolcImgDAO.selectRptMgrHolcImgListTotCnt_S", searchVO);
    }

}
