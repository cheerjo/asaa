package estam.app.scn.rpt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.rpt.service.RptStabRatgDefaultVO;
import estam.app.scn.rpt.service.RptStabRatgVO;

/**
 * @Class Name : RptStabRatgDAO.java
 * @Description : RptStabRatg DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("rptStabRatgDAO")
public class RptStabRatgDAO extends EgovAbstractDAO {

	/**
	 * RPT_STAB_RATG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptStabRatgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptStabRatg(RptStabRatgVO vo) throws Exception {
        return (String)insert("rptStabRatgDAO.insertRptStabRatg_S", vo);
    }

    /**
	 * RPT_STAB_RATG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptStabRatgVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptStabRatg(RptStabRatgVO vo) throws Exception {
        update("rptStabRatgDAO.updateRptStabRatg_S", vo);
    }

    /**
	 * RPT_STAB_RATG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptStabRatgVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptStabRatg(RptStabRatgVO vo) throws Exception {
        delete("rptStabRatgDAO.deleteRptStabRatg_S", vo);
    }

    /**
	 * RPT_STAB_RATG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptStabRatgVO
	 * @return 조회한 RPT_STAB_RATG
	 * @exception Exception
	 */
    public RptStabRatgVO selectRptStabRatg(RptStabRatgVO vo) throws Exception {
        return (RptStabRatgVO) selectByPk("rptStabRatgDAO.selectRptStabRatg_S", vo);
    }

    /**
	 * RPT_STAB_RATG 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_STAB_RATG 목록
	 * @exception Exception
	 */
    public List selectRptStabRatgList(RptStabRatgDefaultVO searchVO) throws Exception {
        return list("rptStabRatgDAO.selectRptStabRatgList_D", searchVO);
    }

    /**
	 * RPT_STAB_RATG 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_STAB_RATG 총 갯수
	 * @exception
	 */
    public int selectRptStabRatgListTotCnt(RptStabRatgDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("rptStabRatgDAO.selectRptStabRatgListTotCnt_S", searchVO);
    }

}
