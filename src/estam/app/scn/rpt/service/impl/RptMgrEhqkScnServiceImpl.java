package estam.app.scn.rpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.scn.rpt.service.RptMgrEhqkScnService;
import estam.app.scn.rpt.service.RptMgrEhqkScnDefaultVO;
import estam.app.scn.rpt.service.RptMgrEhqkScnVO;
import estam.app.scn.rpt.service.impl.RptMgrEhqkScnDAO;

/**
 * @Class Name : RptMgrEhqkScnServiceImpl.java
 * @Description : RptMgrEhqkScn Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("rptMgrEhqkScnService")
public class RptMgrEhqkScnServiceImpl extends AbstractServiceImpl implements
        RptMgrEhqkScnService {

    @Resource(name="rptMgrEhqkScnDAO")
    private RptMgrEhqkScnDAO rptMgrEhqkScnDAO;
    
    /** ID Generation */
    //@Resource(name="{egovRptMgrEhqkScnIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * RPT_MGR_EHQK_SCN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptMgrEhqkScnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptMgrEhqkScn(RptMgrEhqkScnVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	rptMgrEhqkScnDAO.insertRptMgrEhqkScn(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * RPT_MGR_EHQK_SCN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptMgrEhqkScnVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptMgrEhqkScn(RptMgrEhqkScnVO vo) throws Exception {
        rptMgrEhqkScnDAO.updateRptMgrEhqkScn(vo);
    }

    /**
	 * RPT_MGR_EHQK_SCN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptMgrEhqkScnVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptMgrEhqkScn(RptMgrEhqkScnVO vo) throws Exception {
        rptMgrEhqkScnDAO.deleteRptMgrEhqkScn(vo);
    }

    /**
	 * RPT_MGR_EHQK_SCN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptMgrEhqkScnVO
	 * @return 조회한 RPT_MGR_EHQK_SCN
	 * @exception Exception
	 */
    public RptMgrEhqkScnVO selectRptMgrEhqkScn(RptMgrEhqkScnVO vo) throws Exception {
        RptMgrEhqkScnVO resultVO = rptMgrEhqkScnDAO.selectRptMgrEhqkScn(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * RPT_MGR_EHQK_SCN 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR_EHQK_SCN 목록
	 * @exception Exception
	 */
    public List selectRptMgrEhqkScnList(RptMgrEhqkScnDefaultVO searchVO) throws Exception {
        return rptMgrEhqkScnDAO.selectRptMgrEhqkScnList(searchVO);
    }

    /**
	 * RPT_MGR_EHQK_SCN 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR_EHQK_SCN 총 갯수
	 * @exception
	 */
    public int selectRptMgrEhqkScnListTotCnt(RptMgrEhqkScnDefaultVO searchVO) {
		return rptMgrEhqkScnDAO.selectRptMgrEhqkScnListTotCnt(searchVO);
	}
    
}
