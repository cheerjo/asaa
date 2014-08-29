package estam.app.fcty.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.fcty.service.FctyStatSensService;
import estam.app.fcty.service.FctyStatSensDefaultVO;
import estam.app.fcty.service.FctyStatSensVO;
import estam.app.fcty.service.impl.FctyStatSensDAO;

/**
 * @Class Name : FctyStatSensServiceImpl.java
 * @Description : FctyStatSens Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("fctyStatSensService")
public class FctyStatSensServiceImpl extends AbstractServiceImpl implements
        FctyStatSensService {

    @Resource(name="fctyStatSensDAO")
    private FctyStatSensDAO fctyStatSensDAO;
    
    /** ID Generation */
    //@Resource(name="{egovFctyStatSensIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * FCTY_STAT_SENS을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyStatSensVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertFctyStatSens(FctyStatSensVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	fctyStatSensDAO.insertFctyStatSens(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * FCTY_STAT_SENS을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyStatSensVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateFctyStatSens(FctyStatSensVO vo) throws Exception {
        fctyStatSensDAO.updateFctyStatSens(vo);
    }

    /**
	 * FCTY_STAT_SENS을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyStatSensVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteFctyStatSens(FctyStatSensVO vo) throws Exception {
        fctyStatSensDAO.deleteFctyStatSens(vo);
    }

    /**
	 * FCTY_STAT_SENS을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyStatSensVO
	 * @return 조회한 FCTY_STAT_SENS
	 * @exception Exception
	 */
    public FctyStatSensVO selectFctyStatSens(FctyStatSensVO vo) throws Exception {
        FctyStatSensVO resultVO = fctyStatSensDAO.selectFctyStatSens(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * FCTY_STAT_SENS 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_STAT_SENS 목록
	 * @exception Exception
	 */
    public List selectFctyStatSensList(FctyStatSensDefaultVO searchVO) throws Exception {
        return fctyStatSensDAO.selectFctyStatSensList(searchVO);
    }

    /**
	 * FCTY_STAT_SENS 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_STAT_SENS 총 갯수
	 * @exception
	 */
    public int selectFctyStatSensListTotCnt(FctyStatSensDefaultVO searchVO) {
		return fctyStatSensDAO.selectFctyStatSensListTotCnt(searchVO);
	}
    
}
