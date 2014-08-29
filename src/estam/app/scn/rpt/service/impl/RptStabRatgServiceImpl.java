package estam.app.scn.rpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.scn.rpt.service.RptStabRatgDefaultVO;
import estam.app.scn.rpt.service.RptStabRatgService;
import estam.app.scn.rpt.service.RptStabRatgVO;
import estam.app.scn.rpt.service.impl.RptStabRatgDAO;

/**
 * @Class Name : RptStabRatgServiceImpl.java
 * @Description : RptStabRatg Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("rptStabRatgService")
public class RptStabRatgServiceImpl extends AbstractServiceImpl implements
        RptStabRatgService {

    @Resource(name="rptStabRatgDAO")
    private RptStabRatgDAO rptStabRatgDAO;
    
    /** ID Generation */
    //@Resource(name="{egovRptStabRatgIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * RPT_STAB_RATG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptStabRatgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptStabRatg(RptStabRatgVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	rptStabRatgDAO.insertRptStabRatg(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * RPT_STAB_RATG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptStabRatgVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptStabRatg(RptStabRatgVO vo) throws Exception {
        rptStabRatgDAO.updateRptStabRatg(vo);
    }

    /**
	 * RPT_STAB_RATG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptStabRatgVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptStabRatg(RptStabRatgVO vo) throws Exception {
        rptStabRatgDAO.deleteRptStabRatg(vo);
    }

    /**
	 * RPT_STAB_RATG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptStabRatgVO
	 * @return 조회한 RPT_STAB_RATG
	 * @exception Exception
	 */
    public RptStabRatgVO selectRptStabRatg(RptStabRatgVO vo) throws Exception {
        RptStabRatgVO resultVO = rptStabRatgDAO.selectRptStabRatg(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * RPT_STAB_RATG 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_STAB_RATG 목록
	 * @exception Exception
	 */
    public List selectRptStabRatgList(RptStabRatgDefaultVO searchVO) throws Exception {
        return rptStabRatgDAO.selectRptStabRatgList(searchVO);
    }

    /**
	 * RPT_STAB_RATG 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_STAB_RATG 총 갯수
	 * @exception
	 */
    public int selectRptStabRatgListTotCnt(RptStabRatgDefaultVO searchVO) {
		return rptStabRatgDAO.selectRptStabRatgListTotCnt(searchVO);
	}
    
}
