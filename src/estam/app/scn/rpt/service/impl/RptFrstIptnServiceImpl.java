package estam.app.scn.rpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.scn.rpt.service.RptFrstIptnDefaultVO;
import estam.app.scn.rpt.service.RptFrstIptnService;
import estam.app.scn.rpt.service.RptFrstIptnVO;
import estam.app.scn.rpt.service.impl.RptFrstIptnDAO;

/**
 * @Class Name : RptFrstIptnServiceImpl.java
 * @Description : RptFrstIptn Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("rptFrstIptnService")
public class RptFrstIptnServiceImpl extends AbstractServiceImpl implements
        RptFrstIptnService {

    @Resource(name="rptFrstIptnDAO")
    private RptFrstIptnDAO rptFrstIptnDAO;
    
    /** ID Generation */
    //@Resource(name="{egovRptFrstIptnIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * RPT_FRST_IPTN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstIptnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptFrstIptn(RptFrstIptnVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	rptFrstIptnDAO.insertRptFrstIptn(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * RPT_FRST_IPTN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstIptnVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptFrstIptn(RptFrstIptnVO vo) throws Exception {
        rptFrstIptnDAO.updateRptFrstIptn(vo);
    }

    /**
	 * RPT_FRST_IPTN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstIptnVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptFrstIptn(RptFrstIptnVO vo) throws Exception {
        rptFrstIptnDAO.deleteRptFrstIptn(vo);
    }

    /**
	 * RPT_FRST_IPTN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstIptnVO
	 * @return 조회한 RPT_FRST_IPTN
	 * @exception Exception
	 */
    public RptFrstIptnVO selectRptFrstIptn(RptFrstIptnVO vo) throws Exception {
        RptFrstIptnVO resultVO = rptFrstIptnDAO.selectRptFrstIptn(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * RPT_FRST_IPTN 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_IPTN 목록
	 * @exception Exception
	 */
    public List selectRptFrstIptnList(RptFrstIptnDefaultVO searchVO) throws Exception {
        return rptFrstIptnDAO.selectRptFrstIptnList(searchVO);
    }

    /**
	 * RPT_FRST_IPTN 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_IPTN 총 갯수
	 * @exception
	 */
    public int selectRptFrstIptnListTotCnt(RptFrstIptnDefaultVO searchVO) {
		return rptFrstIptnDAO.selectRptFrstIptnListTotCnt(searchVO);
	}
    
}
