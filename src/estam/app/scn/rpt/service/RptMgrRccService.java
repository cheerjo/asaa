package estam.app.scn.rpt.service;

import java.util.List;

import estam.app.scn.rpt.service.RptMgrRccDefaultVO;
import estam.app.scn.rpt.service.RptMgrRccVO;

/**
 * @Class Name : RptMgrRccService.java
 * @Description : RptMgrRcc Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RptMgrRccService {
	
	/**
	 * RPT_MGR_RCC을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptMgrRccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRptMgrRcc(RptMgrRccVO vo) throws Exception;
    
    /**
	 * RPT_MGR_RCC을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptMgrRccVO
	 * @return void형
	 * @exception Exception
	 */
    void updateRptMgrRcc(RptMgrRccVO vo) throws Exception;
    
    /**
	 * RPT_MGR_RCC을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptMgrRccVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRptMgrRcc(RptMgrRccVO vo) throws Exception;
    
    /**
	 * RPT_MGR_RCC을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptMgrRccVO
	 * @return 조회한 RPT_MGR_RCC
	 * @exception Exception
	 */
    RptMgrRccVO selectRptMgrRcc(RptMgrRccVO vo) throws Exception;
    
    /**
	 * RPT_MGR_RCC 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR_RCC 목록
	 * @exception Exception
	 */
    List selectRptMgrRccList(RptMgrRccDefaultVO searchVO) throws Exception;
    
    /**
	 * RPT_MGR_RCC 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR_RCC 총 갯수
	 * @exception
	 */
    int selectRptMgrRccListTotCnt(RptMgrRccDefaultVO searchVO);
    
}
