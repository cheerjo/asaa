package estam.app.spt.service;

import java.util.List;
import estam.app.spt.service.SptIptnFlorDefaultVO;
import estam.app.spt.service.SptIptnFlorVO;

/**
 * @Class Name : SptIptnFlorService.java
 * @Description : SptIptnFlor Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface SptIptnFlorService {
	
	/**
	 * SPT_IPTN_FLOR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SptIptnFlorVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertSptIptnFlor(SptIptnFlorVO vo) throws Exception;
    
    /**
	 * SPT_IPTN_FLOR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SptIptnFlorVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSptIptnFlor(SptIptnFlorVO vo) throws Exception;
    
    /**
	 * SPT_IPTN_FLOR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SptIptnFlorVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSptIptnFlor(SptIptnFlorVO vo) throws Exception;
    
    /**
	 * SPT_IPTN_FLOR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SptIptnFlorVO
	 * @return 조회한 SPT_IPTN_FLOR
	 * @exception Exception
	 */
    SptIptnFlorVO selectSptIptnFlor(SptIptnFlorVO vo) throws Exception;
    
    /**
	 * SPT_IPTN_FLOR 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_FLOR 목록
	 * @exception Exception
	 */
    List selectSptIptnFlorList(SptIptnFlorDefaultVO searchVO) throws Exception;
    
    /**
	 * SPT_IPTN_FLOR 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_FLOR 총 갯수
	 * @exception
	 */
    int selectSptIptnFlorListTotCnt(SptIptnFlorDefaultVO searchVO);
    
}
