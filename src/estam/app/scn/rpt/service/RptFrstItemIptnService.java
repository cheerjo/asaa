package estam.app.scn.rpt.service;

import java.util.List;

import estam.app.scn.rpt.service.RptFrstItemIptnDefaultVO;
import estam.app.scn.rpt.service.RptFrstItemIptnVO;

/**
 * @Class Name : RptFrstItemIptnService.java
 * @Description : RptFrstItemIptn Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RptFrstItemIptnService {
	
	/**
	 * RPT_FRST_ITEM_IPTN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstItemIptnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRptFrstItemIptn(RptFrstItemIptnVO vo) throws Exception;
    
    /**
	 * RPT_FRST_ITEM_IPTN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstItemIptnVO
	 * @return void형
	 * @exception Exception
	 */
    void updateRptFrstItemIptn(RptFrstItemIptnVO vo) throws Exception;
    
    /**
	 * RPT_FRST_ITEM_IPTN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstItemIptnVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRptFrstItemIptn(RptFrstItemIptnVO vo) throws Exception;
    
    /**
	 * RPT_FRST_ITEM_IPTN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstItemIptnVO
	 * @return 조회한 RPT_FRST_ITEM_IPTN
	 * @exception Exception
	 */
    RptFrstItemIptnVO selectRptFrstItemIptn(RptFrstItemIptnVO vo) throws Exception;
    
    /**
	 * RPT_FRST_ITEM_IPTN 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_ITEM_IPTN 목록
	 * @exception Exception
	 */
    List selectRptFrstItemIptnList(RptFrstItemIptnDefaultVO searchVO) throws Exception;
    
    /**
	 * RPT_FRST_ITEM_IPTN 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_ITEM_IPTN 총 갯수
	 * @exception
	 */
    int selectRptFrstItemIptnListTotCnt(RptFrstItemIptnDefaultVO searchVO);
    
}
