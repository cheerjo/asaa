package estam.app.scn.evnt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.scn.evnt.service.ConEvntDataService;
import estam.app.scn.evnt.service.ConEvntDataDefaultVO;
import estam.app.scn.evnt.service.ConEvntDataVO;
import estam.app.scn.evnt.service.impl.ConEvntDataDAO;

/**
 * @Class Name : ConEvntDataServiceImpl.java
 * @Description : ConEvntData Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("conEvntDataService")
public class ConEvntDataServiceImpl extends AbstractServiceImpl implements
        ConEvntDataService {

    @Resource(name="conEvntDataDAO")
    private ConEvntDataDAO conEvntDataDAO;
    
    /** ID Generation */
    //@Resource(name="{egovConEvntDataIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * CON_EVNT_DATA을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ConEvntDataVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertConEvntData(ConEvntDataVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	conEvntDataDAO.insertConEvntData(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * CON_EVNT_DATA을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ConEvntDataVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateConEvntData(ConEvntDataVO vo) throws Exception {
        conEvntDataDAO.updateConEvntData(vo);
    }

    /**
	 * CON_EVNT_DATA을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ConEvntDataVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteConEvntData(ConEvntDataVO vo) throws Exception {
        conEvntDataDAO.deleteConEvntData(vo);
    }

    /**
	 * CON_EVNT_DATA을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ConEvntDataVO
	 * @return 조회한 CON_EVNT_DATA
	 * @exception Exception
	 */
    public ConEvntDataVO selectConEvntData(ConEvntDataVO vo) throws Exception {
        ConEvntDataVO resultVO = conEvntDataDAO.selectConEvntData(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * CON_EVNT_DATA 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CON_EVNT_DATA 목록
	 * @exception Exception
	 */
    public List selectConEvntDataList(ConEvntDataDefaultVO searchVO) throws Exception {
        return conEvntDataDAO.selectConEvntDataList(searchVO);
    }

    /**
	 * CON_EVNT_DATA 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CON_EVNT_DATA 총 갯수
	 * @exception
	 */
    public int selectConEvntDataListTotCnt(ConEvntDataDefaultVO searchVO) {
		return conEvntDataDAO.selectConEvntDataListTotCnt(searchVO);
	}
    
}
