package estam.app.fcty.service;

import java.util.List;
import estam.app.fcty.service.FctyStatSensDefaultVO;
import estam.app.fcty.service.FctyStatSensVO;

/**
 * @Class Name : FctyStatSensService.java
 * @Description : FctyStatSens Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface FctyStatSensService {
	
	/**
	 * FCTY_STAT_SENS을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyStatSensVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertFctyStatSens(FctyStatSensVO vo) throws Exception;
    
    /**
	 * FCTY_STAT_SENS을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyStatSensVO
	 * @return void형
	 * @exception Exception
	 */
    void updateFctyStatSens(FctyStatSensVO vo) throws Exception;
    
    /**
	 * FCTY_STAT_SENS을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyStatSensVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteFctyStatSens(FctyStatSensVO vo) throws Exception;
    
    /**
	 * FCTY_STAT_SENS을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyStatSensVO
	 * @return 조회한 FCTY_STAT_SENS
	 * @exception Exception
	 */
    FctyStatSensVO selectFctyStatSens(FctyStatSensVO vo) throws Exception;
    
    /**
	 * FCTY_STAT_SENS 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_STAT_SENS 목록
	 * @exception Exception
	 */
    List selectFctyStatSensList(FctyStatSensDefaultVO searchVO) throws Exception;
    
    /**
	 * FCTY_STAT_SENS 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_STAT_SENS 총 갯수
	 * @exception
	 */
    int selectFctyStatSensListTotCnt(FctyStatSensDefaultVO searchVO);
    
}
