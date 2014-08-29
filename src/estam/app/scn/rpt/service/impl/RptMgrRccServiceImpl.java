package estam.app.scn.rpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.scn.rpt.service.RptMgrRccDefaultVO;
import estam.app.scn.rpt.service.RptMgrRccService;
import estam.app.scn.rpt.service.RptMgrRccVO;
import estam.app.scn.rpt.service.impl.RptMgrRccDAO;

/**
 * @Class Name : RptMgrRccServiceImpl.java
 * @Description : RptMgrRcc Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("rptMgrRccService")
public class RptMgrRccServiceImpl extends AbstractServiceImpl implements
        RptMgrRccService {

    @Resource(name="rptMgrRccDAO")
    private RptMgrRccDAO rptMgrRccDAO;
    
    /** ID Generation */
    //@Resource(name="{egovRptMgrRccIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * RPT_MGR_RCC을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptMgrRccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptMgrRcc(RptMgrRccVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	rptMgrRccDAO.insertRptMgrRcc(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * RPT_MGR_RCC을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptMgrRccVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptMgrRcc(RptMgrRccVO vo) throws Exception {
        rptMgrRccDAO.updateRptMgrRcc(vo);
    }

    /**
	 * RPT_MGR_RCC을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptMgrRccVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptMgrRcc(RptMgrRccVO vo) throws Exception {
        rptMgrRccDAO.deleteRptMgrRcc(vo);
    }

    /**
	 * RPT_MGR_RCC을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptMgrRccVO
	 * @return 조회한 RPT_MGR_RCC
	 * @exception Exception
	 */
    public RptMgrRccVO selectRptMgrRcc(RptMgrRccVO vo) throws Exception {
        RptMgrRccVO resultVO = rptMgrRccDAO.selectRptMgrRcc(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * RPT_MGR_RCC 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR_RCC 목록
	 * @exception Exception
	 */
    public List selectRptMgrRccList(RptMgrRccDefaultVO searchVO) throws Exception {
        return rptMgrRccDAO.selectRptMgrRccList(searchVO);
    }

    /**
	 * RPT_MGR_RCC 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR_RCC 총 갯수
	 * @exception
	 */
    public int selectRptMgrRccListTotCnt(RptMgrRccDefaultVO searchVO) {
		return rptMgrRccDAO.selectRptMgrRccListTotCnt(searchVO);
	}
    
}
