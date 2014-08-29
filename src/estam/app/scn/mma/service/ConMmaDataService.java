package estam.app.scn.mma.service;

import java.util.List;

import estam.app.com.rev.BarRevTpPgaVO;

/**
 * @Class Name : ConMmaDataService.java
 * @Description : ConMmaData Business class
 * @Modification Information
 *
 * @author ates
 * @since 2013.10.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface ConMmaDataService {
	
	/**
	 * CON_MMA_DATA을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ConMmaDataVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertConMmaData(ConMmaDataVO vo) throws Exception;
    
    /**
	 * CON_MMA_DATA을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ConMmaDataVO
	 * @return void형
	 * @exception Exception
	 */
    void updateConMmaData(ConMmaDataVO vo) throws Exception;
    
    /**
	 * CON_MMA_DATA을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ConMmaDataVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteConMmaData(ConMmaDataVO vo) throws Exception;
    
    /**
	 * CON_MMA_DATA을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ConMmaDataVO
	 * @return 조회한 CON_MMA_DATA
	 * @exception Exception
	 */
    ConMmaDataVO selectConMmaData(ConMmaDataVO vo) throws Exception;
    
    /**
	 * CON_MMA_DATA 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CON_MMA_DATA 목록
	 * @exception Exception
	 */
    List selectConMmaDataList(ConMmaDataDefaultVO searchVO) throws Exception;
    
    /**
	 * CON_MMA_DATA 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CON_MMA_DATA 총 갯수
	 * @exception
	 */
    int selectConMmaDataListTotCnt(ConMmaDataDefaultVO searchVO);
    
    //지진정보 가져오기 부분 처리 
    BarRevTpPgaVO selectBarRevPgaData(ConMmaDataDefaultVO searchVO) throws Exception;
    
}
