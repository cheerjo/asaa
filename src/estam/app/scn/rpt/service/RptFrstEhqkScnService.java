package estam.app.scn.rpt.service;

import java.util.List;

import estam.app.scn.rpt.service.RptFrstEhqkScnDefaultVO;
import estam.app.scn.rpt.service.RptFrstEhqkScnVO;

/**
 * @Class Name : RptFrstEhqkScnService.java
 * @Description : RptFrstEhqkScn Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RptFrstEhqkScnService {
	
	/**
	 * RPT_FRST_EHQK_SCN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstEhqkScnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRptFrstEhqkScn(RptFrstEhqkScnVO vo) throws Exception;
    
    /**
	 * RPT_FRST_EHQK_SCN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstEhqkScnVO
	 * @return void형
	 * @exception Exception
	 */
    void updateRptFrstEhqkScn(RptFrstEhqkScnVO vo) throws Exception;
    
    /**
	 * RPT_FRST_EHQK_SCN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstEhqkScnVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRptFrstEhqkScn(RptFrstEhqkScnVO vo) throws Exception;
    
    /**
	 * RPT_FRST_EHQK_SCN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstEhqkScnVO
	 * @return 조회한 RPT_FRST_EHQK_SCN
	 * @exception Exception
	 */
    RptFrstEhqkScnVO selectRptFrstEhqkScn(RptFrstEhqkScnVO vo) throws Exception;
    
    /**
	 * RPT_FRST_EHQK_SCN 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_EHQK_SCN 목록
	 * @exception Exception
	 */
    List selectRptFrstEhqkScnList(RptFrstEhqkScnDefaultVO searchVO) throws Exception;
    
    /**
	 * RPT_FRST_EHQK_SCN 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_EHQK_SCN 총 갯수
	 * @exception
	 */
    int selectRptFrstEhqkScnListTotCnt(RptFrstEhqkScnDefaultVO searchVO);
    
}
