package estam.app.scn.rpt.service;

import java.util.List;

import estam.app.scn.rpt.service.RptFrstRccDefaultVO;
import estam.app.scn.rpt.service.RptFrstRccVO;

/**
 * @Class Name : RptFrstRccService.java
 * @Description : RptFrstRcc Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RptFrstRccService {
	
	/**
	 * RPT_FRST_RCC을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstRccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRptFrstRcc(RptFrstRccVO vo) throws Exception;
    
    /**
	 * RPT_FRST_RCC을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstRccVO
	 * @return void형
	 * @exception Exception
	 */
    void updateRptFrstRcc(RptFrstRccVO vo) throws Exception;
    
    /**
	 * RPT_FRST_RCC을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstRccVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRptFrstRcc(RptFrstRccVO vo) throws Exception;
    
    /**
	 * RPT_FRST_RCC을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstRccVO
	 * @return 조회한 RPT_FRST_RCC
	 * @exception Exception
	 */
    RptFrstRccVO selectRptFrstRcc(RptFrstRccVO vo) throws Exception;
    
    /**
	 * RPT_FRST_RCC 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_RCC 목록
	 * @exception Exception
	 */
    List selectRptFrstRccList(RptFrstRccDefaultVO searchVO) throws Exception;
    
    /**
	 * RPT_FRST_RCC 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_RCC 총 갯수
	 * @exception
	 */
    int selectRptFrstRccListTotCnt(RptFrstRccDefaultVO searchVO);
    
}
