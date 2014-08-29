package estam.app.signalux.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.signalux.service.SignalUxExecService;
import estam.app.signalux.service.SignalUxExecDefaultVO;
import estam.app.signalux.service.SignalUxExecVO;
import estam.app.signalux.service.impl.SignalUxExecDAO;

/**
 * @Class Name : SignalUxExecServiceImpl.java
 * @Description : SignalUxExec Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.08.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("signalUxExecService")
public class SignalUxExecServiceImpl extends AbstractServiceImpl implements
        SignalUxExecService {

    @Resource(name="signalUxExecDAO")
    private SignalUxExecDAO signalUxExecDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSignalUxExecIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * TB_CODE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SignalUxExecVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSignalUxExec(SignalUxExecVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	signalUxExecDAO.insertSignalUxExec(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * TB_CODE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SignalUxExecVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSignalUxExec(SignalUxExecVO vo) throws Exception {
        signalUxExecDAO.updateSignalUxExec(vo);
    }

    /**
	 * TB_CODE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SignalUxExecVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSignalUxExec(SignalUxExecVO vo) throws Exception {
        signalUxExecDAO.deleteSignalUxExec(vo);
    }

    /**
	 * TB_CODE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SignalUxExecVO
	 * @return 조회한 TB_CODE
	 * @exception Exception
	 */
    public SignalUxExecVO selectSignalUxExec(SignalUxExecVO vo) throws Exception {
        SignalUxExecVO resultVO = signalUxExecDAO.selectSignalUxExec(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * TB_CODE 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_CODE 목록
	 * @exception Exception
	 */
    public List selectSignalUxExecList(SignalUxExecDefaultVO searchVO) throws Exception {
        return signalUxExecDAO.selectSignalUxExecList(searchVO);
    }

    /**
	 * TB_CODE 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_CODE 총 갯수
	 * @exception
	 */
    public int selectSignalUxExecListTotCnt(SignalUxExecDefaultVO searchVO) {
		return signalUxExecDAO.selectSignalUxExecListTotCnt(searchVO);
	}
    
}
