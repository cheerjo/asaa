package estam.app.scn.rpt.service;

import java.util.List;

import estam.app.scn.rpt.service.RptStabRatgDefaultVO;
import estam.app.scn.rpt.service.RptStabRatgVO;

/**
 * @Class Name : RptStabRatgService.java
 * @Description : RptStabRatg Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface RptStabRatgService {
	
	/**
	 * RPT_STAB_RATG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptStabRatgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertRptStabRatg(RptStabRatgVO vo) throws Exception;
    
    /**
	 * RPT_STAB_RATG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptStabRatgVO
	 * @return void형
	 * @exception Exception
	 */
    void updateRptStabRatg(RptStabRatgVO vo) throws Exception;
    
    /**
	 * RPT_STAB_RATG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptStabRatgVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteRptStabRatg(RptStabRatgVO vo) throws Exception;
    
    /**
	 * RPT_STAB_RATG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptStabRatgVO
	 * @return 조회한 RPT_STAB_RATG
	 * @exception Exception
	 */
    RptStabRatgVO selectRptStabRatg(RptStabRatgVO vo) throws Exception;
    
    /**
	 * RPT_STAB_RATG 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_STAB_RATG 목록
	 * @exception Exception
	 */
    List selectRptStabRatgList(RptStabRatgDefaultVO searchVO) throws Exception;
    
    /**
	 * RPT_STAB_RATG 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_STAB_RATG 총 갯수
	 * @exception
	 */
    int selectRptStabRatgListTotCnt(RptStabRatgDefaultVO searchVO);
    
}
