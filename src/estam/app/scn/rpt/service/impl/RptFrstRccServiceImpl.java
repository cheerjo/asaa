package estam.app.scn.rpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.scn.rpt.service.RptFrstRccDefaultVO;
import estam.app.scn.rpt.service.RptFrstRccService;
import estam.app.scn.rpt.service.RptFrstRccVO;
import estam.app.scn.rpt.service.impl.RptFrstRccDAO;

/**
 * @Class Name : RptFrstRccServiceImpl.java
 * @Description : RptFrstRcc Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("rptFrstRccService")
public class RptFrstRccServiceImpl extends AbstractServiceImpl implements
        RptFrstRccService {

    @Resource(name="rptFrstRccDAO")
    private RptFrstRccDAO rptFrstRccDAO;
    
    /** ID Generation */
    //@Resource(name="{egovRptFrstRccIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * RPT_FRST_RCC을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstRccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptFrstRcc(RptFrstRccVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	rptFrstRccDAO.insertRptFrstRcc(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * RPT_FRST_RCC을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstRccVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptFrstRcc(RptFrstRccVO vo) throws Exception {
        rptFrstRccDAO.updateRptFrstRcc(vo);
    }

    /**
	 * RPT_FRST_RCC을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstRccVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptFrstRcc(RptFrstRccVO vo) throws Exception {
        rptFrstRccDAO.deleteRptFrstRcc(vo);
    }

    /**
	 * RPT_FRST_RCC을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstRccVO
	 * @return 조회한 RPT_FRST_RCC
	 * @exception Exception
	 */
    public RptFrstRccVO selectRptFrstRcc(RptFrstRccVO vo) throws Exception {
        RptFrstRccVO resultVO = rptFrstRccDAO.selectRptFrstRcc(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * RPT_FRST_RCC 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_RCC 목록
	 * @exception Exception
	 */
    public List selectRptFrstRccList(RptFrstRccDefaultVO searchVO) throws Exception {
        return rptFrstRccDAO.selectRptFrstRccList(searchVO);
    }

    /**
	 * RPT_FRST_RCC 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_RCC 총 갯수
	 * @exception
	 */
    public int selectRptFrstRccListTotCnt(RptFrstRccDefaultVO searchVO) {
		return rptFrstRccDAO.selectRptFrstRccListTotCnt(searchVO);
	}
    
}
