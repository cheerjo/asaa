package estam.app.iddl.service;

import java.util.List;
import estam.app.iddl.service.IddlAassWvflDefaultVO;
import estam.app.iddl.service.IddlAassWvflVO;

/**
 * @Class Name : IddlAassWvflService.java
 * @Description : IddlAassWvfl Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface IddlAassWvflService {
	
	/**
	 * IDDL_AASS_WVFL을 등록한다.
	 * @param vo - 등록할 정보가 담긴 IddlAassWvflVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertIddlAassWvfl(IddlAassWvflVO vo) throws Exception;
    
    /**
	 * IDDL_AASS_WVFL을 수정한다.
	 * @param vo - 수정할 정보가 담긴 IddlAassWvflVO
	 * @return void형
	 * @exception Exception
	 */
    void updateIddlAassWvfl(IddlAassWvflVO vo) throws Exception;
    
    /**
	 * IDDL_AASS_WVFL을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 IddlAassWvflVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteIddlAassWvfl(IddlAassWvflVO vo) throws Exception;
    
    /**
	 * IDDL_AASS_WVFL을 조회한다.
	 * @param vo - 조회할 정보가 담긴 IddlAassWvflVO
	 * @return 조회한 IDDL_AASS_WVFL
	 * @exception Exception
	 */
    IddlAassWvflVO selectIddlAassWvfl(IddlAassWvflVO vo) throws Exception;
    
    /**
	 * IDDL_AASS_WVFL 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_WVFL 목록
	 * @exception Exception
	 */
    List selectIddlAassWvflList(IddlAassWvflDefaultVO searchVO) throws Exception;
    
    /**
	 * IDDL_AASS_WVFL 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_WVFL 총 갯수
	 * @exception
	 */
    int selectIddlAassWvflListTotCnt(IddlAassWvflDefaultVO searchVO);
    
    /**
  	 * IDDL_AASS_WVFL 목록을 조회한다.
  	 * @param searchVO - 조회할 정보가 담긴 VO
  	 * @return IDDL_AASS_WVFL 목록
  	 * @exception Exception
  	 */
     List selectWaveEventFrmInfo(IddlAassWvflDefaultVO searchVO) throws Exception;
    
}
