package estam.app.scn.rpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.scn.rpt.service.RptMgrHolcImgDefaultVO;
import estam.app.scn.rpt.service.RptMgrHolcImgService;
import estam.app.scn.rpt.service.RptMgrHolcImgVO;
import estam.app.scn.rpt.service.impl.RptMgrHolcImgDAO;

/**
 * @Class Name : RptMgrHolcImgServiceImpl.java
 * @Description : RptMgrHolcImg Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("rptMgrHolcImgService")
public class RptMgrHolcImgServiceImpl extends AbstractServiceImpl implements
        RptMgrHolcImgService {

    @Resource(name="rptMgrHolcImgDAO")
    private RptMgrHolcImgDAO rptMgrHolcImgDAO;
    
    /** ID Generation */
    //@Resource(name="{egovRptMgrHolcImgIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * RPT_MGR_HOLC_IMG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptMgrHolcImgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptMgrHolcImg(RptMgrHolcImgVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	rptMgrHolcImgDAO.insertRptMgrHolcImg(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * RPT_MGR_HOLC_IMG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptMgrHolcImgVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptMgrHolcImg(RptMgrHolcImgVO vo) throws Exception {
        rptMgrHolcImgDAO.updateRptMgrHolcImg(vo);
    }

    /**
	 * RPT_MGR_HOLC_IMG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptMgrHolcImgVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptMgrHolcImg(RptMgrHolcImgVO vo) throws Exception {
        rptMgrHolcImgDAO.deleteRptMgrHolcImg(vo);
    }

    /**
	 * RPT_MGR_HOLC_IMG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptMgrHolcImgVO
	 * @return 조회한 RPT_MGR_HOLC_IMG
	 * @exception Exception
	 */
    public RptMgrHolcImgVO selectRptMgrHolcImg(RptMgrHolcImgVO vo) throws Exception {
        RptMgrHolcImgVO resultVO = rptMgrHolcImgDAO.selectRptMgrHolcImg(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * RPT_MGR_HOLC_IMG 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR_HOLC_IMG 목록
	 * @exception Exception
	 */
    public List selectRptMgrHolcImgList(RptMgrHolcImgDefaultVO searchVO) throws Exception {
        return rptMgrHolcImgDAO.selectRptMgrHolcImgList(searchVO);
    }

    /**
	 * RPT_MGR_HOLC_IMG 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR_HOLC_IMG 총 갯수
	 * @exception
	 */
    public int selectRptMgrHolcImgListTotCnt(RptMgrHolcImgDefaultVO searchVO) {
		return rptMgrHolcImgDAO.selectRptMgrHolcImgListTotCnt(searchVO);
	}
    
}
