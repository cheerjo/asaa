package estam.app.scn.rpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.scn.rpt.service.RptFrstFreeDefaultVO;
import estam.app.scn.rpt.service.RptFrstFreeService;
import estam.app.scn.rpt.service.RptFrstFreeVO;
import estam.app.scn.rpt.service.impl.RptFrstFreeDAO;

/**
 * @Class Name : RptFrstFreeServiceImpl.java
 * @Description : RptFrstFree Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("rptFrstFreeService")
public class RptFrstFreeServiceImpl extends AbstractServiceImpl implements
        RptFrstFreeService {

    @Resource(name="rptFrstFreeDAO")
    private RptFrstFreeDAO rptFrstFreeDAO;
    
    /** ID Generation */
    //@Resource(name="{egovRptFrstFreeIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * RPT_FRST_FREE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstFreeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptFrstFree(RptFrstFreeVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	rptFrstFreeDAO.insertRptFrstFree(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * RPT_FRST_FREE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstFreeVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptFrstFree(RptFrstFreeVO vo) throws Exception {
        rptFrstFreeDAO.updateRptFrstFree(vo);
    }

    /**
	 * RPT_FRST_FREE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstFreeVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptFrstFree(RptFrstFreeVO vo) throws Exception {
        rptFrstFreeDAO.deleteRptFrstFree(vo);
    }

    /**
	 * RPT_FRST_FREE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstFreeVO
	 * @return 조회한 RPT_FRST_FREE
	 * @exception Exception
	 */
    public RptFrstFreeVO selectRptFrstFree(RptFrstFreeVO vo) throws Exception {
        RptFrstFreeVO resultVO = rptFrstFreeDAO.selectRptFrstFree(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * RPT_FRST_FREE 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_FREE 목록
	 * @exception Exception
	 */
    public List selectRptFrstFreeList(RptFrstFreeDefaultVO searchVO) throws Exception {
        return rptFrstFreeDAO.selectRptFrstFreeList(searchVO);
    }

    /**
	 * RPT_FRST_FREE 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_FREE 총 갯수
	 * @exception
	 */
    public int selectRptFrstFreeListTotCnt(RptFrstFreeDefaultVO searchVO) {
		return rptFrstFreeDAO.selectRptFrstFreeListTotCnt(searchVO);
	}
    
}
