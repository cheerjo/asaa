package estam.app.fcty.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.fcty.service.FctyAddInfoService;
import estam.app.fcty.service.FctyAddInfoDefaultVO;
import estam.app.fcty.service.FctyAddInfoVO;
import estam.app.fcty.service.impl.FctyAddInfoDAO;

/**
 * @Class Name : FctyAddInfoServiceImpl.java
 * @Description : FctyAddInfo Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("fctyAddInfoService")
public class FctyAddInfoServiceImpl extends AbstractServiceImpl implements
        FctyAddInfoService {

    @Resource(name="fctyAddInfoDAO")
    private FctyAddInfoDAO fctyAddInfoDAO;
    
    /** ID Generation */
    //@Resource(name="{egovFctyAddInfoIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * FCTY_ADD_INFO을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyAddInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertFctyAddInfo(FctyAddInfoVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	fctyAddInfoDAO.insertFctyAddInfo(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * FCTY_ADD_INFO을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyAddInfoVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateFctyAddInfo(FctyAddInfoVO vo) throws Exception {
        fctyAddInfoDAO.updateFctyAddInfo(vo);
    }

    /**
	 * FCTY_ADD_INFO을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyAddInfoVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteFctyAddInfo(FctyAddInfoVO vo) throws Exception {
        fctyAddInfoDAO.deleteFctyAddInfo(vo);
    }

    /**
	 * FCTY_ADD_INFO을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyAddInfoVO
	 * @return 조회한 FCTY_ADD_INFO
	 * @exception Exception
	 */
    public FctyAddInfoVO selectFctyAddInfo(FctyAddInfoVO vo) throws Exception {
        FctyAddInfoVO resultVO = fctyAddInfoDAO.selectFctyAddInfo(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * FCTY_ADD_INFO 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_ADD_INFO 목록
	 * @exception Exception
	 */
    public List selectFctyAddInfoList(FctyAddInfoDefaultVO searchVO) throws Exception {
        return fctyAddInfoDAO.selectFctyAddInfoList(searchVO);
    }

    /**
	 * FCTY_ADD_INFO 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_ADD_INFO 총 갯수
	 * @exception
	 */
    public int selectFctyAddInfoListTotCnt(FctyAddInfoDefaultVO searchVO) {
		return fctyAddInfoDAO.selectFctyAddInfoListTotCnt(searchVO);
	}
    
}
