package estam.app.scn.rpt.service;

import java.util.List;

import estam.app.scn.rpt.service.RptMgrHolcImgDefaultVO;
import estam.app.scn.rpt.service.RptMgrHolcImgVO;

/**
 * @Class Name : RptMgrHolcImgService.java
 * @Description : RptMgrHolcImg Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RptMgrHolcImgService {
	
	/**
	 * RPT_MGR_HOLC_IMG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptMgrHolcImgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRptMgrHolcImg(RptMgrHolcImgVO vo) throws Exception;
    
    /**
	 * RPT_MGR_HOLC_IMG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptMgrHolcImgVO
	 * @return void형
	 * @exception Exception
	 */
    void updateRptMgrHolcImg(RptMgrHolcImgVO vo) throws Exception;
    
    /**
	 * RPT_MGR_HOLC_IMG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptMgrHolcImgVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRptMgrHolcImg(RptMgrHolcImgVO vo) throws Exception;
    
    /**
	 * RPT_MGR_HOLC_IMG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptMgrHolcImgVO
	 * @return 조회한 RPT_MGR_HOLC_IMG
	 * @exception Exception
	 */
    RptMgrHolcImgVO selectRptMgrHolcImg(RptMgrHolcImgVO vo) throws Exception;
    
    /**
	 * RPT_MGR_HOLC_IMG 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR_HOLC_IMG 목록
	 * @exception Exception
	 */
    List selectRptMgrHolcImgList(RptMgrHolcImgDefaultVO searchVO) throws Exception;
    
    /**
	 * RPT_MGR_HOLC_IMG 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR_HOLC_IMG 총 갯수
	 * @exception
	 */
    int selectRptMgrHolcImgListTotCnt(RptMgrHolcImgDefaultVO searchVO);
    
}
