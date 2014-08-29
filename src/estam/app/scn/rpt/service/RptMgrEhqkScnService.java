package estam.app.scn.rpt.service;

import java.util.List;
import estam.app.scn.rpt.service.RptMgrEhqkScnDefaultVO;
import estam.app.scn.rpt.service.RptMgrEhqkScnVO;

/**
 * @Class Name : RptMgrEhqkScnService.java
 * @Description : RptMgrEhqkScn Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RptMgrEhqkScnService {
	
	/**
	 * RPT_MGR_EHQK_SCN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptMgrEhqkScnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRptMgrEhqkScn(RptMgrEhqkScnVO vo) throws Exception;
    
    /**
	 * RPT_MGR_EHQK_SCN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptMgrEhqkScnVO
	 * @return void형
	 * @exception Exception
	 */
    void updateRptMgrEhqkScn(RptMgrEhqkScnVO vo) throws Exception;
    
    /**
	 * RPT_MGR_EHQK_SCN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptMgrEhqkScnVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRptMgrEhqkScn(RptMgrEhqkScnVO vo) throws Exception;
    
    /**
	 * RPT_MGR_EHQK_SCN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptMgrEhqkScnVO
	 * @return 조회한 RPT_MGR_EHQK_SCN
	 * @exception Exception
	 */
    RptMgrEhqkScnVO selectRptMgrEhqkScn(RptMgrEhqkScnVO vo) throws Exception;
    
    /**
	 * RPT_MGR_EHQK_SCN 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR_EHQK_SCN 목록
	 * @exception Exception
	 */
    List selectRptMgrEhqkScnList(RptMgrEhqkScnDefaultVO searchVO) throws Exception;
    
    /**
	 * RPT_MGR_EHQK_SCN 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR_EHQK_SCN 총 갯수
	 * @exception
	 */
    int selectRptMgrEhqkScnListTotCnt(RptMgrEhqkScnDefaultVO searchVO);
    
}
