package estam.app.spt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.spt.service.SptIptnRsltFlService;
import estam.app.spt.service.SptIptnRsltFlDefaultVO;
import estam.app.spt.service.SptIptnRsltFlVO;
import estam.app.spt.service.impl.SptIptnRsltFlDAO;

/**
 * @Class Name : SptIptnRsltFlServiceImpl.java
 * @Description : SptIptnRsltFl Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("sptIptnRsltFlService")
public class SptIptnRsltFlServiceImpl extends AbstractServiceImpl implements
        SptIptnRsltFlService {

    @Resource(name="sptIptnRsltFlDAO")
    private SptIptnRsltFlDAO sptIptnRsltFlDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSptIptnRsltFlIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * SPT_IPTN_RSLT_FL을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SptIptnRsltFlVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSptIptnRsltFl(SptIptnRsltFlVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	sptIptnRsltFlDAO.insertSptIptnRsltFl(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * SPT_IPTN_RSLT_FL을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SptIptnRsltFlVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSptIptnRsltFl(SptIptnRsltFlVO vo) throws Exception {
        sptIptnRsltFlDAO.updateSptIptnRsltFl(vo);
    }

    /**
	 * SPT_IPTN_RSLT_FL을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SptIptnRsltFlVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSptIptnRsltFl(SptIptnRsltFlVO vo) throws Exception {
        sptIptnRsltFlDAO.deleteSptIptnRsltFl(vo);
    }

    /**
	 * SPT_IPTN_RSLT_FL을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SptIptnRsltFlVO
	 * @return 조회한 SPT_IPTN_RSLT_FL
	 * @exception Exception
	 */
    public SptIptnRsltFlVO selectSptIptnRsltFl(SptIptnRsltFlVO vo) throws Exception {
        SptIptnRsltFlVO resultVO = sptIptnRsltFlDAO.selectSptIptnRsltFl(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * SPT_IPTN_RSLT_FL 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_RSLT_FL 목록
	 * @exception Exception
	 */ 
    public List selectSptIptnRsltFlList(SptIptnRsltFlVO vo) throws Exception {
        return sptIptnRsltFlDAO.selectSptIptnRsltFlList(vo);
    }

    /**
	 * SPT_IPTN_RSLT_FL 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_RSLT_FL 총 갯수
	 * @exception
	 */
    public int selectSptIptnRsltFlListTotCnt(SptIptnRsltFlDefaultVO searchVO) {
		return sptIptnRsltFlDAO.selectSptIptnRsltFlListTotCnt(searchVO);
	}
    
}
