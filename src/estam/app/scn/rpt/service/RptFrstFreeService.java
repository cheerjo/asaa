package estam.app.scn.rpt.service;

import java.util.List;

import estam.app.scn.rpt.service.RptFrstFreeDefaultVO;
import estam.app.scn.rpt.service.RptFrstFreeVO;

/**
 * @Class Name : RptFrstFreeService.java
 * @Description : RptFrstFree Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RptFrstFreeService {
	
	/**
	 * RPT_FRST_FREE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstFreeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRptFrstFree(RptFrstFreeVO vo) throws Exception;
    
    /**
	 * RPT_FRST_FREE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstFreeVO
	 * @return void형
	 * @exception Exception
	 */
    void updateRptFrstFree(RptFrstFreeVO vo) throws Exception;
    
    /**
	 * RPT_FRST_FREE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstFreeVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRptFrstFree(RptFrstFreeVO vo) throws Exception;
    
    /**
	 * RPT_FRST_FREE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstFreeVO
	 * @return 조회한 RPT_FRST_FREE
	 * @exception Exception
	 */
    RptFrstFreeVO selectRptFrstFree(RptFrstFreeVO vo) throws Exception;
    
    /**
	 * RPT_FRST_FREE 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_FREE 목록
	 * @exception Exception
	 */
    List selectRptFrstFreeList(RptFrstFreeDefaultVO searchVO) throws Exception;
    
    /**
	 * RPT_FRST_FREE 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_FREE 총 갯수
	 * @exception
	 */
    int selectRptFrstFreeListTotCnt(RptFrstFreeDefaultVO searchVO);
    
}
