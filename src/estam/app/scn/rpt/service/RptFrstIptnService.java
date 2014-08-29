package estam.app.scn.rpt.service;

import java.util.List;

import estam.app.scn.rpt.service.RptFrstIptnDefaultVO;
import estam.app.scn.rpt.service.RptFrstIptnVO;

/**
 * @Class Name : RptFrstIptnService.java
 * @Description : RptFrstIptn Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RptFrstIptnService {
	
	/**
	 * RPT_FRST_IPTN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstIptnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRptFrstIptn(RptFrstIptnVO vo) throws Exception;
    
    /**
	 * RPT_FRST_IPTN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstIptnVO
	 * @return void형
	 * @exception Exception
	 */
    void updateRptFrstIptn(RptFrstIptnVO vo) throws Exception;
    
    /**
	 * RPT_FRST_IPTN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstIptnVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRptFrstIptn(RptFrstIptnVO vo) throws Exception;
    
    /**
	 * RPT_FRST_IPTN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstIptnVO
	 * @return 조회한 RPT_FRST_IPTN
	 * @exception Exception
	 */
    RptFrstIptnVO selectRptFrstIptn(RptFrstIptnVO vo) throws Exception;
    
    /**
	 * RPT_FRST_IPTN 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_IPTN 목록
	 * @exception Exception
	 */
    List selectRptFrstIptnList(RptFrstIptnDefaultVO searchVO) throws Exception;
    
    /**
	 * RPT_FRST_IPTN 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_IPTN 총 갯수
	 * @exception
	 */
    int selectRptFrstIptnListTotCnt(RptFrstIptnDefaultVO searchVO);
    
}
