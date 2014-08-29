package estam.app.spt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.fcty.service.FctyMgrVO;
import estam.app.fcty.service.impl.FctyMgrDAO;
import estam.app.spt.service.SptIptnRptService;

/**
 * @Class Name : SptIptnRptServiceImpl.java
 * @Description : SptIptnRpt Business Implement class
 * @Modification Information
 * 
 * @author kmg
 * @since 2014.01.20
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("sptIptnRptService")
public class SptIptnRptServiceImpl extends AbstractServiceImpl implements SptIptnRptService {

	@Resource(name = "fctyMgrDAO")
	private FctyMgrDAO fctyMgrDAO;
	
	/**
	 * SPT_IPTN_SCN을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 SptIptnScnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public List<FctyMgrVO> selectFctyMgrList(FctyMgrVO vo) throws Exception {
		return fctyMgrDAO.selectFctyMgrListBySearch(vo);
	}

}
