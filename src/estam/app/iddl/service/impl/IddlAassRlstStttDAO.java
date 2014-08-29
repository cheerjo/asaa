package estam.app.iddl.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.iddl.service.IddlEhqkOcurInfoVO;
import estam.app.iddl.service.FctyListInspVO;
import estam.app.iddl.service.IddlAassRlstDefaultVO;
import estam.app.iddl.service.IddlAassRlstStatsVO;


/**
 * @Class Name : IddlAassRlstStttDAO.java
 * @Description : IddlAassRlstSttt DAO Class
 * @Modification Information
 *
 * @author arjoona
 * @since 2013.12.1
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("iddlAassRlstStttDAO")
public class IddlAassRlstStttDAO extends EgovAbstractDAO {
	
	/**
	 * 지진발생정보 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return  목록
	 * @exception Exception
	 */
    public List selectIddlEhqkOcurInfoList(IddlEhqkOcurInfoVO vo) throws Exception {
        return list("iddlAassRlstStttDAO.selectIddlEhqkOcurInfo", vo);
    }
    
    /**
	 * 지진발생정보 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return  목록
	 * @exception Exception
	 */
    public List selectIddlEhqkOcurInfoList2(IddlEhqkOcurInfoVO vo) throws Exception {
        return list("iddlAassRlstStttDAO.selectIddlEhqkOcurInfo2", vo);
    }
    
    /**
	 * 지진발생분석정보 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return  목록
	 * @exception Exception
	 */
    public List selectIddlEhqkOcurRptInfoList(IddlEhqkOcurInfoVO vo) {
    	return list("iddlAassRlstStttDAO.selectIddlEhqkOcurRptInfoList", vo);
	}
    
    /**
	 * 평가결과 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return  목록
	 * @exception Exception
	 */
    public List selectIddlAassRlstStatsList(IddlAassRlstStatsVO vo) throws Exception {
        try {
			return list("iddlAassRlstStttDAO.selectIddlAassRlstStats", vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    /**
	 * 점검필요 시설물 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return  목록
	 * @exception Exception
	 */
    public List selectFctyListInspList(FctyListInspVO vo) throws Exception {
        return list("iddlAassRlstStttDAO.selectFctyListInsp", vo);
    }

	
}
