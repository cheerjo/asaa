package estam.app.scn.rpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.scn.rpt.service.RptMgrDefaultVO;
import estam.app.scn.rpt.service.RptMgrService;
import estam.app.scn.rpt.service.RptMgrVO;
import estam.app.scn.rpt.service.impl.RptMgrDAO;

/**
 * @Class Name : RptMgrServiceImpl.java
 * @Description : RptMgr Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.1016
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("rptMgrService")
public class RptMgrServiceImpl extends AbstractServiceImpl implements
        RptMgrService {

    @Resource(name="rptMgrDAO")
    private RptMgrDAO rptMgrDAO;
    
    /** ID Generation */
    //@Resource(name="{egovRptMgrIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * RPT_MGR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 RptMgrVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRptMgr(RptMgrVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	rptMgrDAO.insertRptMgr(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * RPT_MGR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 RptMgrVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRptMgr(RptMgrVO vo) throws Exception {
        rptMgrDAO.updateRptMgr(vo);
    }

    /**
	 * RPT_MGR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 RptMgrVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRptMgr(RptMgrVO vo) throws Exception {
        rptMgrDAO.deleteRptMgr(vo);
    }

    /**
	 * RPT_MGR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 RptMgrVO
	 * @return 조회한 RPT_MGR
	 * @exception Exception
	 */
    public RptMgrVO selectRptMgr(RptMgrVO vo) throws Exception {
        RptMgrVO resultVO = rptMgrDAO.selectRptMgr(vo);
        if (resultVO == null)
           throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * RPT_MGR 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR 목록
	 * @exception Exception
	 */
    public List selectRptMgrList(RptMgrDefaultVO searchVO) throws Exception {
        return rptMgrDAO.selectRptMgrList(searchVO);
    }

    /**
	 * RPT_MGR 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return RPT_MGR 총 갯수
	 * @exception
	 */
    public int selectRptMgrListTotCnt(RptMgrDefaultVO searchVO) {
		return rptMgrDAO.selectRptMgrListTotCnt(searchVO);
	}
    
    /**
   	 * 시설물 지진가속도계 통합정보
   	 * @param searchVO - 조회할 정보가 담긴 VO
   	 * @return RPT_MGR 목록
   	 * @exception Exception
   	 */
    public  List selectRptFctyMgrScnList(RptMgrDefaultVO searchVO) throws Exception {
    	   return rptMgrDAO.selectRptFctyMgrScnList(searchVO);
       }
       
    /**
   	 * 시설물 지진가속도기록계 통합정보
   	 * @param searchVO - 조회할 정보가 담긴 VO
   	 * @return RPT_MGR 목록
   	 * @exception Exception
   	 */
    public  List selectRptFctyMgrRccList(RptMgrDefaultVO searchVO) throws Exception {
    	   return rptMgrDAO.selectRptFctyMgrRccList(searchVO);
       }
    
    
    
}
