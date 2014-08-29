package estam.app.scn.mma.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.com.rev.BarRevTpPgaVO;
import estam.app.scn.mma.service.ConMmaDataService;
import estam.app.scn.mma.service.ConMmaDataDefaultVO;
import estam.app.scn.mma.service.ConMmaDataVO;
import estam.app.scn.mma.service.impl.ConMmaDataDAO;

/**
 * @Class Name : ConMmaDataServiceImpl.java
 * @Description : ConMmaData Business Implement class
 * @Modification Information
 *
 * @author ates
 * @since 2013.10.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("conMmaDataService")
public class ConMmaDataServiceImpl extends AbstractServiceImpl implements
        ConMmaDataService {

    @Resource(name="conMmaDataDAO")
    private ConMmaDataDAO conMmaDataDAO;
    
    /** ID Generation */
    //@Resource(name="{egovConMmaDataIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * CON_MMA_DATA을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ConMmaDataVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertConMmaData(ConMmaDataVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	conMmaDataDAO.insertConMmaData(vo);
     
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * CON_MMA_DATA을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ConMmaDataVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateConMmaData(ConMmaDataVO vo) throws Exception {
        conMmaDataDAO.updateConMmaData(vo);
    }

    /**
	 * CON_MMA_DATA을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ConMmaDataVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteConMmaData(ConMmaDataVO vo) throws Exception {
        conMmaDataDAO.deleteConMmaData(vo);
    }

    /**
	 * CON_MMA_DATA을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ConMmaDataVO
	 * @return 조회한 CON_MMA_DATA
	 * @exception Exception
	 */
    public ConMmaDataVO selectConMmaData(ConMmaDataVO vo) throws Exception {
        ConMmaDataVO resultVO = conMmaDataDAO.selectConMmaData(vo);
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
    public List selectConMmaDataList(ConMmaDataDefaultVO searchVO) throws Exception {
        return conMmaDataDAO.selectConMmaDataList(searchVO);
    }

    /**
	 * CON_MMA_DATA 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CON_MMA_DATA 총 갯수
	 * @exception
	 */
    public int selectConMmaDataListTotCnt(ConMmaDataDefaultVO searchVO) {
		return conMmaDataDAO.selectConMmaDataListTotCnt(searchVO);
	}
    
    
    public BarRevTpPgaVO selectBarRevPgaData(ConMmaDataDefaultVO searchVO) {
		return conMmaDataDAO.selectBarRevPgaData(searchVO);
	}
     
}
