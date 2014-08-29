package estam.app.scn.rpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.scn.rpt.service.RptFrstEhqkScnDefaultVO;
import estam.app.scn.rpt.service.RptFrstEhqkScnService;
import estam.app.scn.rpt.service.RptFrstEhqkScnVO;
import estam.app.scn.rpt.service.impl.RptFrstEhqkScnDAO;

/**
 * @Class Name : RptFrstEhqkScnServiceImpl.java
 * @Description : RptFrstEhqkScn Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("rptFrstEhqkScnService")
public class RptFrstEhqkScnServiceImpl extends AbstractServiceImpl implements
        RptFrstEhqkScnService {

    @Resource(name="rptFrstEhqkScnDAO")
    private RptFrstEhqkScnDAO rptFrstEhqkScnDAO;
    
    /** ID Generation */
    //@Resource(name="{egovRptFrstEhqkScnIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * RPT_FRST_EHQK_SCN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstEhqkScnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptFrstEhqkScn(RptFrstEhqkScnVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	rptFrstEhqkScnDAO.insertRptFrstEhqkScn(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * RPT_FRST_EHQK_SCN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstEhqkScnVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptFrstEhqkScn(RptFrstEhqkScnVO vo) throws Exception {
        rptFrstEhqkScnDAO.updateRptFrstEhqkScn(vo);
    }

    /**
	 * RPT_FRST_EHQK_SCN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstEhqkScnVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptFrstEhqkScn(RptFrstEhqkScnVO vo) throws Exception {
        rptFrstEhqkScnDAO.deleteRptFrstEhqkScn(vo);
    }

    /**
	 * RPT_FRST_EHQK_SCN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstEhqkScnVO
	 * @return 조회한 RPT_FRST_EHQK_SCN
	 * @exception Exception
	 */
    public RptFrstEhqkScnVO selectRptFrstEhqkScn(RptFrstEhqkScnVO vo) throws Exception {
        RptFrstEhqkScnVO resultVO = rptFrstEhqkScnDAO.selectRptFrstEhqkScn(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * RPT_FRST_EHQK_SCN 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_EHQK_SCN 목록
	 * @exception Exception
	 */
    public List selectRptFrstEhqkScnList(RptFrstEhqkScnDefaultVO searchVO) throws Exception {
        return rptFrstEhqkScnDAO.selectRptFrstEhqkScnList(searchVO);
    }

    /**
	 * RPT_FRST_EHQK_SCN 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_EHQK_SCN 총 갯수
	 * @exception
	 */
    public int selectRptFrstEhqkScnListTotCnt(RptFrstEhqkScnDefaultVO searchVO) {
		return rptFrstEhqkScnDAO.selectRptFrstEhqkScnListTotCnt(searchVO);
	}
    
}
