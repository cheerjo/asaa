package estam.app.spt.service;

import java.util.List;

import estam.app.fcty.service.FctyMgrVO;

/**
 * @Class Name : SptIptnRptService.java
 * @Description : SptIptnRpt Business class
 * @Modification Information
 *
 * @author kmg
 * @since 2014.01.20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface SptIptnRptService {
	
	/**
	 * 시설물 FCTY_MGR 을 조회한다.
	 * @param vo - 등록할 정보가 담긴 FctyMgrVO
	 * @return 조회목록 결과
	 * @exception Exception
	 */
    public List<FctyMgrVO> selectFctyMgrList(FctyMgrVO vo) throws Exception;
  
    
}
