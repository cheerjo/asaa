package estam.app.fcty.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.fcty.service.FctyImgDefaultVO;
import estam.app.fcty.service.FctyImgService;
import estam.app.fcty.service.FctyImgVO;
import estam.app.fcty.service.impl.FctyImgDAO;

/**
 * @Class Name : FctyImgServiceImpl.java
 * @Description : FctyImg Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("fctyImgService")
public class FctyImgServiceImpl extends AbstractServiceImpl implements
        FctyImgService {

    @Resource(name="fctyImgDAO")
    private FctyImgDAO fctyImgDAO;
    
    /** ID Generation */
    //@Resource(name="{egovFctyImgIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * FCTY_IMG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyImgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertFctyImg(FctyImgVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	fctyImgDAO.insertFctyImg(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * FCTY_IMG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyImgVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateFctyImg(FctyImgVO vo) throws Exception {
        fctyImgDAO.updateFctyImg(vo);
    }

    /**
	 * FCTY_IMG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyImgVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteFctyImg(FctyImgVO vo) throws Exception {
        fctyImgDAO.deleteFctyImg(vo);
    }

    /**
	 * FCTY_IMG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyImgVO
	 * @return 조회한 FCTY_IMG
	 * @exception Exception
	 */
    public FctyImgVO selectFctyImg(FctyImgVO vo) throws Exception {
        FctyImgVO resultVO = fctyImgDAO.selectFctyImg(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * FCTY_IMG 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_IMG 목록
	 * @exception Exception
	 */
    public List selectFctyImgList(FctyImgDefaultVO searchVO) throws Exception {
        return fctyImgDAO.selectFctyImgList(searchVO);
    }

    /**
	 * FCTY_IMG 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_IMG 총 갯수
	 * @exception
	 */
    public int selectFctyImgListTotCnt(FctyImgDefaultVO searchVO) {
		return fctyImgDAO.selectFctyImgListTotCnt(searchVO);
	}
    
}
