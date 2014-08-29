package estam.app.scn.rpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.scn.rpt.service.RptRglrIptnDefaultVO;
import estam.app.scn.rpt.service.RptRglrIptnService;
import estam.app.scn.rpt.service.RptRglrIptnVO;
import estam.app.scn.rpt.service.impl.RptRglrIptnDAO;

/**
 * @Class Name : RptRglrIptnServiceImpl.java
 * @Description : RptRglrIptn Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("rptRglrIptnService")
public class RptRglrIptnServiceImpl extends AbstractServiceImpl implements
        RptRglrIptnService {

    @Resource(name="rptRglrIptnDAO")
    private RptRglrIptnDAO rptRglrIptnDAO;
    
    /** ID Generation */
    //@Resource(name="{egovRptRglrIptnIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * RPT_RGLR_IPTN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptRglrIptnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptRglrIptn(RptRglrIptnVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	rptRglrIptnDAO.insertRptRglrIptn(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * RPT_RGLR_IPTN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptRglrIptnVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptRglrIptn(RptRglrIptnVO vo) throws Exception {
        rptRglrIptnDAO.updateRptRglrIptn(vo);
    }

    /**
	 * RPT_RGLR_IPTN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptRglrIptnVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptRglrIptn(RptRglrIptnVO vo) throws Exception {
        rptRglrIptnDAO.deleteRptRglrIptn(vo);
    }

    /**
	 * RPT_RGLR_IPTN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptRglrIptnVO
	 * @return 조회한 RPT_RGLR_IPTN
	 * @exception Exception
	 */
    public RptRglrIptnVO selectRptRglrIptn(RptRglrIptnVO vo) throws Exception {
        RptRglrIptnVO resultVO = rptRglrIptnDAO.selectRptRglrIptn(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * RPT_RGLR_IPTN 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_RGLR_IPTN 목록
	 * @exception Exception
	 */
    public List selectRptRglrIptnList(RptRglrIptnVO vo) throws Exception {
        return rptRglrIptnDAO.selectRptRglrIptnList(vo);
    }

    /**
	 * RPT_RGLR_IPTN 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_RGLR_IPTN 총 갯수
	 * @exception
	 */
    public int selectRptRglrIptnListTotCnt(RptRglrIptnDefaultVO searchVO) {
		return rptRglrIptnDAO.selectRptRglrIptnListTotCnt(searchVO);
	}
    
}
