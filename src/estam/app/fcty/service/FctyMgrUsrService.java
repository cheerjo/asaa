package estam.app.fcty.service;

import java.util.List;
import estam.app.fcty.service.FctyMgrUsrDefaultVO;
import estam.app.fcty.service.FctyMgrUsrVO;

/**
 * @Class Name : FctyMgrUsrService.java
 * @Description : FctyMgrUsr Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface FctyMgrUsrService {
	
	/**
	 * FCTY_MGR_USR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyMgrUsrVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertFctyMgrUsr(FctyMgrUsrVO vo) throws Exception;
    
    /**
	 * FCTY_MGR_USR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyMgrUsrVO
	 * @return void형
	 * @exception Exception
	 */
    void updateFctyMgrUsr(FctyMgrUsrVO vo) throws Exception;
    
    /**
	 * FCTY_MGR_USR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyMgrUsrVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteFctyMgrUsr(FctyMgrUsrVO vo) throws Exception;
    
    /**
	 * FCTY_MGR_USR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyMgrUsrVO
	 * @return 조회한 FCTY_MGR_USR
	 * @exception Exception
	 */
    FctyMgrUsrVO selectFctyMgrUsr(FctyMgrUsrVO vo) throws Exception;
    
    /**
	 * FCTY_MGR_USR 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_MGR_USR 목록
	 * @exception Exception
	 */
    List selectFctyMgrUsrList(FctyMgrUsrDefaultVO searchVO) throws Exception;
    
    /**
	 * FCTY_MGR_USR 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_MGR_USR 총 갯수
	 * @exception
	 */
    int selectFctyMgrUsrListTotCnt(FctyMgrUsrDefaultVO searchVO);
    
}
