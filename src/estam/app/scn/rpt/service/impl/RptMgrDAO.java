package estam.app.scn.rpt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.rpt.service.RptMgrDefaultVO;
import estam.app.scn.rpt.service.RptMgrVO;

/**
 * @Class Name : RptMgrDAO.java
 * @Description : RptMgr DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.1016
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("rptMgrDAO")
public class RptMgrDAO extends EgovAbstractDAO {

	/**
	 * RPT_MGR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptMgrVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptMgr(RptMgrVO vo) throws Exception {
        return (String)insert("rptMgrDAO.insertRptMgr_S", vo);
    }

    /**
	 * RPT_MGR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptMgrVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptMgr(RptMgrVO vo) throws Exception {
        update("rptMgrDAO.updateRptMgr_S", vo);
    }

    /**
	 * RPT_MGR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptMgrVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptMgr(RptMgrVO vo) throws Exception {
        delete("rptMgrDAO.deleteRptMgr_S", vo);
    }

    /**
	 * RPT_MGR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptMgrVO
	 * @return 조회한 RPT_MGR
	 * @exception Exception
	 */
    public RptMgrVO selectRptMgr(RptMgrVO vo) throws Exception {
        return (RptMgrVO) selectByPk("rptMgrDAO.selectRptMgr_S", vo);
    }

    /**
	 * RPT_MGR 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_MGR 목록
	 * @exception Exception
	 */
    public List selectRptMgrList(RptMgrDefaultVO searchVO) throws Exception {
        return list("rptMgrDAO.selectRptMgrList_D", searchVO);
    }

    /**
	 * RPT_MGR 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return RPT_MGR 총 갯수
	 * @exception
	 */
    public int selectRptMgrListTotCnt(RptMgrDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("rptMgrDAO.selectRptMgrListTotCnt_S", searchVO);
    }
    
    /**
   	 * 시설물 지진가속도계 통합정보
   	 * @param searchVO - 조회할 정보가 담긴 VO
   	 * @return RPT_MGR 목록
   	 * @exception Exception
   	 */
    public  List selectRptFctyMgrScnList(RptMgrDefaultVO searchVO) throws Exception {
    	 return list("rptMgrDAO.selectRptFctyMgrScnList_D", searchVO);
       }
       
    /**
   	 * 시설물 지진가속도기록계 통합정보
   	 * @param searchVO - 조회할 정보가 담긴 VO
   	 * @return RPT_MGR 목록
   	 * @exception Exception
   	 */
    public  List selectRptFctyMgrRccList(RptMgrDefaultVO searchVO) throws Exception {
    	 return list("rptMgrDAO.selectRptFctyMgrRccList_D", searchVO);
       }

}
