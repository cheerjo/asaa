package estam.app.iddl.service;

import java.util.List;

/**
 * @Class Name : IddlAassRlstStttService.java
 * @Description : IddlAassRlst Business class
 * @Modification Information
 *
 * @author arjoona
 * @since 2013.12.1
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

public interface IddlAassRlstStttService {
	
	/**
	 * 지진발생정보 목록을 조회한다.
	 * @param VO - 조회할 정보가 담긴 VO
	 * @return 지진발생정보 목록
	 * @exception Exception
	 */
    List selectIddlEhqkOcurInfoList(IddlEhqkOcurInfoVO vo) throws Exception;
    
    /**
	 * 지진발생정보 목록을 조회한다.
	 * @param VO - 조회할 정보가 담긴 VO
	 * @return 지진발생정보 목록
	 * @exception Exception
	 */
    List selectIddlEhqkOcurInfoList2(IddlEhqkOcurInfoVO vo) throws Exception;
    
    /**
	 * 지진발생분석정보 목록을 조회한다.
	 * @param VO - 조회할 정보가 담긴 VO
	 * @return 지진발생분석정보 목록
	 * @exception Exception
	 */
    List selectIddlEhqkOcurRptInfoList(IddlEhqkOcurInfoVO vo) throws Exception;
    
    
    /**
	 * 점검필요 시설물 목록을 조회한다.
	 * @param VO - 조회할 정보가 담긴 VO
	 * @return 점검필요 시설물 목록
	 * @exception Exception
	 */
    List selectFctyListInspList(FctyListInspVO vo) throws Exception;
    
    /**
	 * 점검통계정보를 조회한다.
	 * @param VO - 조회할 정보가 담긴 VO
	 * @return 점검통계정보
	 * @exception Exception
	 */
    List selectIddlAassRlstStatsList(IddlAassRlstStatsVO vo) throws Exception;
}
