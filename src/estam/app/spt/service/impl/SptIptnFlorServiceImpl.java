package estam.app.spt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.spt.service.SptIptnFlorService;
import estam.app.spt.service.SptIptnFlorDefaultVO;
import estam.app.spt.service.SptIptnFlorVO;
import estam.app.spt.service.impl.SptIptnFlorDAO;

/**
 * @Class Name : SptIptnFlorServiceImpl.java
 * @Description : SptIptnFlor Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("sptIptnFlorService")
public class SptIptnFlorServiceImpl extends AbstractServiceImpl implements
        SptIptnFlorService {

    @Resource(name="sptIptnFlorDAO")
    private SptIptnFlorDAO sptIptnFlorDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSptIptnFlorIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * SPT_IPTN_FLOR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SptIptnFlorVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSptIptnFlor(SptIptnFlorVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	sptIptnFlorDAO.insertSptIptnFlor(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * SPT_IPTN_FLOR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SptIptnFlorVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSptIptnFlor(SptIptnFlorVO vo) throws Exception {
        sptIptnFlorDAO.updateSptIptnFlor(vo);
    }

    /**
	 * SPT_IPTN_FLOR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SptIptnFlorVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSptIptnFlor(SptIptnFlorVO vo) throws Exception {
        sptIptnFlorDAO.deleteSptIptnFlor(vo);
    }

    /**
	 * SPT_IPTN_FLOR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SptIptnFlorVO
	 * @return 조회한 SPT_IPTN_FLOR
	 * @exception Exception
	 */
    public SptIptnFlorVO selectSptIptnFlor(SptIptnFlorVO vo) throws Exception {
        SptIptnFlorVO resultVO = sptIptnFlorDAO.selectSptIptnFlor(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * SPT_IPTN_FLOR 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_FLOR 목록
	 * @exception Exception
	 */
    public List selectSptIptnFlorList(SptIptnFlorDefaultVO searchVO) throws Exception {
        return sptIptnFlorDAO.selectSptIptnFlorList(searchVO);
    }

    /**
	 * SPT_IPTN_FLOR 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_FLOR 총 갯수
	 * @exception
	 */
    public int selectSptIptnFlorListTotCnt(SptIptnFlorDefaultVO searchVO) {
		return sptIptnFlorDAO.selectSptIptnFlorListTotCnt(searchVO);
	}
    
}
