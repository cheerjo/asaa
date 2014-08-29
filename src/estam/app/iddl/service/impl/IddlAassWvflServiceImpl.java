package estam.app.iddl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.iddl.service.IddlAassWvflService;
import estam.app.iddl.service.IddlAassWvflDefaultVO;
import estam.app.iddl.service.IddlAassWvflVO;
import estam.app.iddl.service.impl.IddlAassWvflDAO;

/**
 * @Class Name : IddlAassWvflServiceImpl.java
 * @Description : IddlAassWvfl Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("iddlAassWvflService")
public class IddlAassWvflServiceImpl extends AbstractServiceImpl implements
        IddlAassWvflService {

    @Resource(name="iddlAassWvflDAO")
    private IddlAassWvflDAO iddlAassWvflDAO;
    
    /** ID Generation */
    //@Resource(name="{egovIddlAassWvflIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * IDDL_AASS_WVFL을 등록한다.
	 * @param vo - 등록할 정보가 담긴 IddlAassWvflVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertIddlAassWvfl(IddlAassWvflVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	iddlAassWvflDAO.insertIddlAassWvfl(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * IDDL_AASS_WVFL을 수정한다.
	 * @param vo - 수정할 정보가 담긴 IddlAassWvflVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateIddlAassWvfl(IddlAassWvflVO vo) throws Exception {
        iddlAassWvflDAO.updateIddlAassWvfl(vo);
    }

    /**
	 * IDDL_AASS_WVFL을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 IddlAassWvflVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteIddlAassWvfl(IddlAassWvflVO vo) throws Exception {
        iddlAassWvflDAO.deleteIddlAassWvfl(vo);
    }

    /**
	 * IDDL_AASS_WVFL을 조회한다.
	 * @param vo - 조회할 정보가 담긴 IddlAassWvflVO
	 * @return 조회한 IDDL_AASS_WVFL
	 * @exception Exception
	 */
    public IddlAassWvflVO selectIddlAassWvfl(IddlAassWvflVO vo) throws Exception {
        IddlAassWvflVO resultVO = iddlAassWvflDAO.selectIddlAassWvfl(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * IDDL_AASS_WVFL 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_WVFL 목록
	 * @exception Exception
	 */
    public List selectIddlAassWvflList(IddlAassWvflDefaultVO searchVO) throws Exception {
        return iddlAassWvflDAO.selectIddlAassWvflList(searchVO);
    }

    /**
	 * IDDL_AASS_WVFL 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_WVFL 총 갯수
	 * @exception
	 */
    public int selectIddlAassWvflListTotCnt(IddlAassWvflDefaultVO searchVO) {
		return iddlAassWvflDAO.selectIddlAassWvflListTotCnt(searchVO);
	}
    
    /**
  	 * IDDL_AASS_WVFL 목록을 조회한다.
  	 * @param searchVO - 조회할 정보가 담긴 VO
  	 * @return IDDL_AASS_WVFL 목록
  	 * @exception Exception
  	 */
    public List selectWaveEventFrmInfo(IddlAassWvflDefaultVO searchVO) throws Exception {
    	  return iddlAassWvflDAO.selectWaveEventFrmInfo(searchVO);
     }
    
}
