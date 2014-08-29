package estam.app.fcty.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.fcty.service.FctyMgrUsrService;
import estam.app.fcty.service.FctyMgrUsrDefaultVO;
import estam.app.fcty.service.FctyMgrUsrVO;
import estam.app.fcty.service.impl.FctyMgrUsrDAO;

/**
 * @Class Name : FctyMgrUsrServiceImpl.java
 * @Description : FctyMgrUsr Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("fctyMgrUsrService")
public class FctyMgrUsrServiceImpl extends AbstractServiceImpl implements
        FctyMgrUsrService {

    @Resource(name="fctyMgrUsrDAO")
    private FctyMgrUsrDAO fctyMgrUsrDAO;
    
    /** ID Generation */
    //@Resource(name="{egovFctyMgrUsrIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * FCTY_MGR_USR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyMgrUsrVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertFctyMgrUsr(FctyMgrUsrVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	fctyMgrUsrDAO.insertFctyMgrUsr(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * FCTY_MGR_USR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyMgrUsrVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateFctyMgrUsr(FctyMgrUsrVO vo) throws Exception {
        fctyMgrUsrDAO.updateFctyMgrUsr(vo);
    }

    /**
	 * FCTY_MGR_USR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyMgrUsrVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteFctyMgrUsr(FctyMgrUsrVO vo) throws Exception {
        fctyMgrUsrDAO.deleteFctyMgrUsr(vo);
    }

    /**
	 * FCTY_MGR_USR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyMgrUsrVO
	 * @return 조회한 FCTY_MGR_USR
	 * @exception Exception
	 */
    public FctyMgrUsrVO selectFctyMgrUsr(FctyMgrUsrVO vo) throws Exception {
        FctyMgrUsrVO resultVO = fctyMgrUsrDAO.selectFctyMgrUsr(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * FCTY_MGR_USR 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_MGR_USR 목록
	 * @exception Exception
	 */
    public List selectFctyMgrUsrList(FctyMgrUsrDefaultVO searchVO) throws Exception {
        return fctyMgrUsrDAO.selectFctyMgrUsrList(searchVO);
    }

    /**
	 * FCTY_MGR_USR 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_MGR_USR 총 갯수
	 * @exception
	 */
    public int selectFctyMgrUsrListTotCnt(FctyMgrUsrDefaultVO searchVO) {
		return fctyMgrUsrDAO.selectFctyMgrUsrListTotCnt(searchVO);
	}
    
}
