package estam.app.spt.service;

import java.util.List;
import estam.app.spt.service.SptIptnRsltFlDefaultVO;
import estam.app.spt.service.SptIptnRsltFlVO;

/**
 * @Class Name : SptIptnRsltFlService.java
 * @Description : SptIptnRsltFl Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface SptIptnRsltFlService {
	
	/**
	 * SPT_IPTN_RSLT_FL을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SptIptnRsltFlVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertSptIptnRsltFl(SptIptnRsltFlVO vo) throws Exception;
    
    /**
	 * SPT_IPTN_RSLT_FL을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SptIptnRsltFlVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSptIptnRsltFl(SptIptnRsltFlVO vo) throws Exception;
    
    /**
	 * SPT_IPTN_RSLT_FL을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SptIptnRsltFlVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSptIptnRsltFl(SptIptnRsltFlVO vo) throws Exception;
    
    /**
	 * SPT_IPTN_RSLT_FL을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SptIptnRsltFlVO
	 * @return 조회한 SPT_IPTN_RSLT_FL
	 * @exception Exception
	 */
    SptIptnRsltFlVO selectSptIptnRsltFl(SptIptnRsltFlVO vo) throws Exception;
    
    /**
	 * SPT_IPTN_RSLT_FL 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_RSLT_FL 목록
	 * @exception Exception
	 */
    List selectSptIptnRsltFlList(SptIptnRsltFlVO vo) throws Exception;
    
    /**
	 * SPT_IPTN_RSLT_FL 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_RSLT_FL 총 갯수
	 * @exception
	 */
    int selectSptIptnRsltFlListTotCnt(SptIptnRsltFlDefaultVO searchVO);
    
}
