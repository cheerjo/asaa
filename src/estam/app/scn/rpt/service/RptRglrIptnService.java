package estam.app.scn.rpt.service;

import java.util.List;

import estam.app.scn.rpt.service.RptRglrIptnDefaultVO;
import estam.app.scn.rpt.service.RptRglrIptnVO;

/**
 * @Class Name : RptRglrIptnService.java
 * @Description : RptRglrIptn Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RptRglrIptnService {
	
	/**
	 * RPT_RGLR_IPTN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptRglrIptnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRptRglrIptn(RptRglrIptnVO vo) throws Exception;
    
    /**
	 * RPT_RGLR_IPTN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptRglrIptnVO
	 * @return void형
	 * @exception Exception
	 */
    void updateRptRglrIptn(RptRglrIptnVO vo) throws Exception;
    
    /**
	 * RPT_RGLR_IPTN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptRglrIptnVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRptRglrIptn(RptRglrIptnVO vo) throws Exception;
    
    /**
	 * RPT_RGLR_IPTN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptRglrIptnVO
	 * @return 조회한 RPT_RGLR_IPTN
	 * @exception Exception
	 */
    RptRglrIptnVO selectRptRglrIptn(RptRglrIptnVO vo) throws Exception;
    
    /**
	 * RPT_RGLR_IPTN 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_RGLR_IPTN 목록
	 * @exception Exception
	 */
    List selectRptRglrIptnList(RptRglrIptnVO vo) throws Exception;
    
  //  List selectRptMgrList(RptMgrDefaultVO searchVO) throws Exception;
    /**
	 * RPT_RGLR_IPTN 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_RGLR_IPTN 총 갯수
	 * @exception
	 */
    int selectRptRglrIptnListTotCnt(RptRglrIptnDefaultVO searchVO);
    
}
