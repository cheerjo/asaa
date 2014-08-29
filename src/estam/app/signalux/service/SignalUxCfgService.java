package estam.app.signalux.service;

import java.util.List;
import estam.app.signalux.service.SignalUxCfgDefaultVO;
import estam.app.signalux.service.SignalUxCfgVO;

/**
 * @Class Name : SignalUxCfgService.java
 * @Description : SignalUxCfg Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.08.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface SignalUxCfgService {
	
	/**
	 * TB_CODE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SignalUxCfgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertSignalUxCfg(SignalUxCfgVO vo) throws Exception;
    
    /**
	 * TB_CODE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SignalUxCfgVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSignalUxCfg(SignalUxCfgVO vo) throws Exception;
    
    /**
	 * TB_CODE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SignalUxCfgVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSignalUxCfg(SignalUxCfgVO vo) throws Exception;
    
    /**
	 * TB_CODE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SignalUxCfgVO
	 * @return 조회한 TB_CODE
	 * @exception Exception
	 */
    SignalUxCfgVO selectSignalUxCfg(SignalUxCfgVO vo) throws Exception;
    
    /**
	 * TB_CODE 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_CODE 목록
	 * @exception Exception
	 */
    List selectSignalUxCfgList(SignalUxCfgDefaultVO searchVO) throws Exception;
    
    /**
	 * TB_CODE 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_CODE 총 갯수
	 * @exception
	 */
    int selectSignalUxCfgListTotCnt(SignalUxCfgDefaultVO searchVO);
    
}
