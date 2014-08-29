package estam.app.scn.rpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.scn.rpt.service.RptFrstItemIptnDefaultVO;
import estam.app.scn.rpt.service.RptFrstItemIptnService;
import estam.app.scn.rpt.service.RptFrstItemIptnVO;
import estam.app.scn.rpt.service.impl.RptFrstItemIptnDAO;

/**
 * @Class Name : RptFrstItemIptnServiceImpl.java
 * @Description : RptFrstItemIptn Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("rptFrstItemIptnService")
public class RptFrstItemIptnServiceImpl extends AbstractServiceImpl implements
        RptFrstItemIptnService {

    @Resource(name="rptFrstItemIptnDAO")
    private RptFrstItemIptnDAO rptFrstItemIptnDAO;
    
    /** ID Generation */
    //@Resource(name="{egovRptFrstItemIptnIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * RPT_FRST_ITEM_IPTN을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptFrstItemIptnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptFrstItemIptn(RptFrstItemIptnVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	rptFrstItemIptnDAO.insertRptFrstItemIptn(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * RPT_FRST_ITEM_IPTN을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptFrstItemIptnVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptFrstItemIptn(RptFrstItemIptnVO vo) throws Exception {
        rptFrstItemIptnDAO.updateRptFrstItemIptn(vo);
    }

    /**
	 * RPT_FRST_ITEM_IPTN을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptFrstItemIptnVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptFrstItemIptn(RptFrstItemIptnVO vo) throws Exception {
        rptFrstItemIptnDAO.deleteRptFrstItemIptn(vo);
    }

    /**
	 * RPT_FRST_ITEM_IPTN을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptFrstItemIptnVO
	 * @return 조회한 RPT_FRST_ITEM_IPTN
	 * @exception Exception
	 */
    public RptFrstItemIptnVO selectRptFrstItemIptn(RptFrstItemIptnVO vo) throws Exception {
        RptFrstItemIptnVO resultVO = rptFrstItemIptnDAO.selectRptFrstItemIptn(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * RPT_FRST_ITEM_IPTN 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_ITEM_IPTN 목록
	 * @exception Exception
	 */
    public List selectRptFrstItemIptnList(RptFrstItemIptnDefaultVO searchVO) throws Exception {
        return rptFrstItemIptnDAO.selectRptFrstItemIptnList(searchVO);
    }

    /**
	 * RPT_FRST_ITEM_IPTN 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_FRST_ITEM_IPTN 총 갯수
	 * @exception
	 */
    public int selectRptFrstItemIptnListTotCnt(RptFrstItemIptnDefaultVO searchVO) {
		return rptFrstItemIptnDAO.selectRptFrstItemIptnListTotCnt(searchVO);
	}
    
}
