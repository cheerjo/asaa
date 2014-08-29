package estam.app.scn.rpt.service;

import java.util.List;

import estam.app.scn.rpt.service.RptMgrDefaultVO;
import estam.app.scn.rpt.service.RptMgrVO;

/**
 * @Class Name : RptMgrService.java
 * @Description : RptMgr Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.1016
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RptMgrService {
	
	/**
	 * RPT_MGR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptMgrVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRptMgr(RptMgrVO vo) throws Exception;
    
    /**
	 * RPT_MGR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptMgrVO
	 * @return void형
	 * @exception Exception
	 */
    void updateRptMgr(RptMgrVO vo) throws Exception;
    
    /**
	 * RPT_MGR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptMgrVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRptMgr(RptMgrVO vo) throws Exception;
    
    /**
	 * RPT_MGR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptMgrVO
	 * @return 조회한 RPT_MGR
	 * @exception Exception
	 */
    RptMgrVO selectRptMgr(RptMgrVO vo) throws Exception;
    
    /**
	 * RPT_MGR 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR 목록
	 * @exception Exception
	 */
    List selectRptMgrList(RptMgrDefaultVO searchVO) throws Exception;
    
    /**
	 * RPT_MGR 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR 총 갯수
	 * @exception
	 */
    int selectRptMgrListTotCnt(RptMgrDefaultVO searchVO);
    
    
    /**
   	 * 시설물 지진가속도계 통합정보
   	 * @param searchVO - 조회할 정보가 담긴 VO
   	 * @return RPT_MGR 목록
   	 * @exception Exception
   	 */
       List selectRptFctyMgrScnList(RptMgrDefaultVO searchVO) throws Exception;
       
    /**
   	 * 시설물 지진가속도기록계 통합정보
   	 * @param searchVO - 조회할 정보가 담긴 VO
   	 * @return RPT_MGR 목록
   	 * @exception Exception
   	 */
       List selectRptFctyMgrRccList(RptMgrDefaultVO searchVO) throws Exception;
    
    
    
}
