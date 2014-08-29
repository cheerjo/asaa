package estam.app.signalux.service;

import java.util.List;
import estam.app.signalux.service.SignalUxExecDefaultVO;
import estam.app.signalux.service.SignalUxExecVO;

/**
 * @Class Name : SignalUxExecService.java
 * @Description : SignalUxExec Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.08.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface SignalUxExecService {
	
	/**
	 * TB_CODE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SignalUxExecVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertSignalUxExec(SignalUxExecVO vo) throws Exception;
    
    /**
	 * TB_CODE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SignalUxExecVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSignalUxExec(SignalUxExecVO vo) throws Exception;
    
    /**
	 * TB_CODE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SignalUxExecVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSignalUxExec(SignalUxExecVO vo) throws Exception;
    
    /**
	 * TB_CODE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SignalUxExecVO
	 * @return 조회한 TB_CODE
	 * @exception Exception
	 */
    SignalUxExecVO selectSignalUxExec(SignalUxExecVO vo) throws Exception;
    
    /**
	 * TB_CODE 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_CODE 목록
	 * @exception Exception
	 */
    List selectSignalUxExecList(SignalUxExecDefaultVO searchVO) throws Exception;
    
    /**
	 * TB_CODE 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_CODE 총 갯수
	 * @exception
	 */
    int selectSignalUxExecListTotCnt(SignalUxExecDefaultVO searchVO);
    
}
