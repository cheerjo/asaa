package estam.app.signalux.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.signalux.service.SignalUxCfgService;
import estam.app.signalux.service.SignalUxCfgDefaultVO;
import estam.app.signalux.service.SignalUxCfgVO;
import estam.app.signalux.service.impl.SignalUxCfgDAO;

/**
 * @Class Name : SignalUxCfgServiceImpl.java
 * @Description : SignalUxCfg Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.08.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("signalUxCfgService")
public class SignalUxCfgServiceImpl extends AbstractServiceImpl implements
        SignalUxCfgService {

    @Resource(name="signalUxCfgDAO")
    private SignalUxCfgDAO signalUxCfgDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSignalUxCfgIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * TB_CODE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SignalUxCfgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSignalUxCfg(SignalUxCfgVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	signalUxCfgDAO.insertSignalUxCfg(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * TB_CODE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SignalUxCfgVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSignalUxCfg(SignalUxCfgVO vo) throws Exception {
        signalUxCfgDAO.updateSignalUxCfg(vo);
    }

    /**
	 * TB_CODE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SignalUxCfgVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSignalUxCfg(SignalUxCfgVO vo) throws Exception {
        signalUxCfgDAO.deleteSignalUxCfg(vo);
    }

    /**
	 * TB_CODE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SignalUxCfgVO
	 * @return 조회한 TB_CODE
	 * @exception Exception
	 */
    public SignalUxCfgVO selectSignalUxCfg(SignalUxCfgVO vo) throws Exception {
        SignalUxCfgVO resultVO = signalUxCfgDAO.selectSignalUxCfg(vo);
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
    public List selectSignalUxCfgList(SignalUxCfgDefaultVO searchVO) throws Exception {
        return signalUxCfgDAO.selectSignalUxCfgList(searchVO);
    }

    /**
	 * TB_CODE 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_CODE 총 갯수
	 * @exception
	 */
    public int selectSignalUxCfgListTotCnt(SignalUxCfgDefaultVO searchVO) {
		return signalUxCfgDAO.selectSignalUxCfgListTotCnt(searchVO);
	}
    
}
