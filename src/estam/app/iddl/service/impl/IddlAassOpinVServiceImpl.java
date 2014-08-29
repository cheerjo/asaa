package estam.app.iddl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.iddl.service.IddlAassOpinVService;
import estam.app.iddl.service.IddlAassOpinVDefaultVO;
import estam.app.iddl.service.IddlAassOpinVVO;
import estam.app.iddl.service.impl.IddlAassOpinVDAO;

/**
 * @Class Name : IddlAassOpinVServiceImpl.java
 * @Description : IddlAassOpinV Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("iddlAassOpinVService")
public class IddlAassOpinVServiceImpl extends AbstractServiceImpl implements
        IddlAassOpinVService {

    @Resource(name="iddlAassOpinVDAO")
    private IddlAassOpinVDAO iddlAassOpinVDAO;
    
    /** ID Generation */
    //@Resource(name="{egovIddlAassOpinVIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * IDDL_AASS_OPIN_V을 등록한다.
	 * @param vo - 등록할 정보가 담긴 IddlAassOpinVVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertIddlAassOpinV(IddlAassOpinVVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	iddlAassOpinVDAO.insertIddlAassOpinV(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * IDDL_AASS_OPIN_V을 수정한다.
	 * @param vo - 수정할 정보가 담긴 IddlAassOpinVVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateIddlAassOpinV(IddlAassOpinVVO vo) throws Exception {
        iddlAassOpinVDAO.updateIddlAassOpinV(vo);
    }

    /**
	 * IDDL_AASS_OPIN_V을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 IddlAassOpinVVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteIddlAassOpinV(IddlAassOpinVVO vo) throws Exception {
        iddlAassOpinVDAO.deleteIddlAassOpinV(vo);
    }

    /**
	 * IDDL_AASS_OPIN_V을 조회한다.
	 * @param vo - 조회할 정보가 담긴 IddlAassOpinVVO
	 * @return 조회한 IDDL_AASS_OPIN_V
	 * @exception Exception
	 */
    public IddlAassOpinVVO selectIddlAassOpinV(IddlAassOpinVVO vo) throws Exception {
        IddlAassOpinVVO resultVO = iddlAassOpinVDAO.selectIddlAassOpinV(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * IDDL_AASS_OPIN_V 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_OPIN_V 목록
	 * @exception Exception
	 */
    public List selectIddlAassOpinVList(IddlAassOpinVDefaultVO searchVO) throws Exception {
        return iddlAassOpinVDAO.selectIddlAassOpinVList(searchVO);
    }

    /**
	 * IDDL_AASS_OPIN_V 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_OPIN_V 총 갯수
	 * @exception
	 */
    public int selectIddlAassOpinVListTotCnt(IddlAassOpinVDefaultVO searchVO) {
		return iddlAassOpinVDAO.selectIddlAassOpinVListTotCnt(searchVO);
	}
    
}
