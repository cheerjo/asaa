package estam.app.scn.evnt.service;

import java.util.List;
import estam.app.scn.evnt.service.ConEvntDataDefaultVO;
import estam.app.scn.evnt.service.ConEvntDataVO;

/**
 * @Class Name : ConEvntDataService.java
 * @Description : ConEvntData Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface ConEvntDataService {
	
	/**
	 * CON_EVNT_DATA을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ConEvntDataVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertConEvntData(ConEvntDataVO vo) throws Exception;
    
    /**
	 * CON_EVNT_DATA을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ConEvntDataVO
	 * @return void형
	 * @exception Exception
	 */
    void updateConEvntData(ConEvntDataVO vo) throws Exception;
    
    /**
	 * CON_EVNT_DATA을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ConEvntDataVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteConEvntData(ConEvntDataVO vo) throws Exception;
    
    /**
	 * CON_EVNT_DATA을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ConEvntDataVO
	 * @return 조회한 CON_EVNT_DATA
	 * @exception Exception
	 */
    ConEvntDataVO selectConEvntData(ConEvntDataVO vo) throws Exception;
    
    /**
	 * CON_EVNT_DATA 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CON_EVNT_DATA 목록
	 * @exception Exception
	 */
    List selectConEvntDataList(ConEvntDataDefaultVO searchVO) throws Exception;
    
    /**
	 * CON_EVNT_DATA 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CON_EVNT_DATA 총 갯수
	 * @exception
	 */
    int selectConEvntDataListTotCnt(ConEvntDataDefaultVO searchVO);
    
}
