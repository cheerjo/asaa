package estam.app.scn.mma.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.iddl.service.IddlAassInfoVO;
import estam.app.iddl.service.IddlAassRlstVO;
import estam.app.scn.mma.service.FctyMmaDefaultVO;
import estam.app.scn.mma.service.FctyMmaService;
import estam.app.scn.mma.service.FctyMmaVO;

/**
 * @Class Name : FctyMmaServiceImpl.java
 * @Description : FctyMma Business Implement class
 * @Modification Information
 *
 * @author ates
 * @since 2013.10.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("fctyMmaService")
public class FctyMmaServiceImpl extends AbstractServiceImpl implements
        FctyMmaService {

    @Resource(name="fctyMmaDAO")
    private FctyMmaDAO fctyMmaDAO;
    
    /** ID Generation */
    //@Resource(name="{egovFctyMmaIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * CON_MMA_DATA을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyMmaVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertFctyMma(FctyMmaVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	fctyMmaDAO.insertFctyMma(vo);
     
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * CON_MMA_DATA을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyMmaVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateFctyMma(FctyMmaVO vo) throws Exception {
        fctyMmaDAO.updateFctyMma(vo);
    }

    /**
	 * CON_MMA_DATA을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyMmaVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteFctyMma(FctyMmaVO vo) throws Exception {
        fctyMmaDAO.deleteFctyMma(vo);
    }

    /**
	 * CON_MMA_DATA을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyMmaVO
	 * @return 조회한 CON_MMA_DATA
	 * @exception Exception
	 */
    public FctyMmaVO selectFctyMma(FctyMmaVO vo) throws Exception {
        FctyMmaVO resultVO = fctyMmaDAO.selectFctyMma(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * CON_MMA_DATA 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CON_MMA_DATA 목록
	 * @exception Exception
	 */
    public List selectFctyMmaList(FctyMmaDefaultVO searchVO) throws Exception {
        return fctyMmaDAO.selectFctyMmaList(searchVO);
    }

    /**
	 * CON_MMA_DATA 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CON_MMA_DATA 총 갯수
	 * @exception
	 */
    public int selectFctyMmaListTotCnt(FctyMmaDefaultVO searchVO) {
		return fctyMmaDAO.selectFctyMmaListTotCnt(searchVO);
	}

	public List<IddlAassRlstVO> selectIddlAassInfo(IddlAassInfoVO iddlAassInfoVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateFctyIntensity(FctyMmaVO fctyMmaVo) {
		fctyMmaDAO.updateFctyIntensity(fctyMmaVo);
	}
	
	public void updateResetFctyIntensity() {
		fctyMmaDAO.updateResetFctyIntensity();
	}
    
}
