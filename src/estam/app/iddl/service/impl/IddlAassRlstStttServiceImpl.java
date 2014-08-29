package estam.app.iddl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.iddl.service.IddlAassRlstStttService;

import estam.app.iddl.service.IddlAassRlstDefaultVO;
import estam.app.iddl.service.IddlEhqkOcurInfoVO;
import estam.app.iddl.service.FctyListInspVO;
import estam.app.iddl.service.IddlAassRlstStatsVO;

import estam.app.iddl.service.impl.IddlAassRlstStttDAO;

/**
 * @Class Name : IddlAassRlstStttServiceImpl.java
 * @Description : IddlAassRlst Stats Business Implement class
 * @Modification Information
 *
 * @author arjoonas
 * @since 2013.12.1
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("iddlAassRlstStttService")
public class IddlAassRlstStttServiceImpl  extends AbstractServiceImpl implements
IddlAassRlstStttService {
	
	@Resource(name="iddlAassRlstStttDAO")
    private IddlAassRlstStttDAO iddlAassRlstStttDAO;

	/**
   	 * 지진발생정보 목록을 조회한다. 
   	 * @return 지진발생정보 목록
   	 * @exception Exception
   	 */
	public List selectIddlEhqkOcurInfoList(IddlEhqkOcurInfoVO vo) throws Exception {
		// TODO Auto-generated method stub
		return iddlAassRlstStttDAO.selectIddlEhqkOcurInfoList(vo);
	}
	
	/**
   	 * 지진발생정보 목록을 조회한다. 
   	 * @return 지진발생정보 목록
   	 * @exception Exception
   	 */
	public List selectIddlEhqkOcurInfoList2(IddlEhqkOcurInfoVO vo) throws Exception {
		// TODO Auto-generated method stub
		return iddlAassRlstStttDAO.selectIddlEhqkOcurInfoList2(vo);
	}
	
	/**
   	 * 지진발생분석정보 목록을 조회한다.
   	 * @return 지진발생분석정보 목록
   	 * @exception Exception
   	 */
	public List selectIddlEhqkOcurRptInfoList(IddlEhqkOcurInfoVO vo) throws Exception {
		// TODO Auto-generated method stub
		return iddlAassRlstStttDAO.selectIddlEhqkOcurRptInfoList(vo);
	}

	/**
   	 * 점검필요 시설물 목록을 조회한다. 
   	 * @return 점검필요 시설물 목록
   	 * @exception Exception
   	 */
	public List selectFctyListInspList(FctyListInspVO vo) throws Exception {
		// TODO Auto-generated method stub
		return iddlAassRlstStttDAO.selectFctyListInspList(vo);
	}

	/**
   	 * 평가결과정보를 조회한다. 
   	 * @return 평가결과 정보
   	 * @exception Exception
   	 */
	public List selectIddlAassRlstStatsList(IddlAassRlstStatsVO vo)
			throws Exception {
		// TODO Auto-generated method stub
		return iddlAassRlstStttDAO.selectIddlAassRlstStatsList(vo);
	}

	

}
