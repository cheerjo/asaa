package estam.app.iddl.service;

import java.util.List;
import estam.app.iddl.service.IddlAassOpinVDefaultVO;
import estam.app.iddl.service.IddlAassOpinVVO;

/**
 * @Class Name : IddlAassOpinVService.java
 * @Description : IddlAassOpinV Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface IddlAassOpinVService {
	
	/**
	 * IDDL_AASS_OPIN_V을 등록한다.
	 * @param vo - 등록할 정보가 담긴 IddlAassOpinVVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertIddlAassOpinV(IddlAassOpinVVO vo) throws Exception;
    
    /**
	 * IDDL_AASS_OPIN_V을 수정한다.
	 * @param vo - 수정할 정보가 담긴 IddlAassOpinVVO
	 * @return void형
	 * @exception Exception
	 */
    void updateIddlAassOpinV(IddlAassOpinVVO vo) throws Exception;
    
    /**
	 * IDDL_AASS_OPIN_V을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 IddlAassOpinVVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteIddlAassOpinV(IddlAassOpinVVO vo) throws Exception;
    
    /**
	 * IDDL_AASS_OPIN_V을 조회한다.
	 * @param vo - 조회할 정보가 담긴 IddlAassOpinVVO
	 * @return 조회한 IDDL_AASS_OPIN_V
	 * @exception Exception
	 */
    IddlAassOpinVVO selectIddlAassOpinV(IddlAassOpinVVO vo) throws Exception;
    
    /**
	 * IDDL_AASS_OPIN_V 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_OPIN_V 목록
	 * @exception Exception
	 */
    List selectIddlAassOpinVList(IddlAassOpinVDefaultVO searchVO) throws Exception;
    
    /**
	 * IDDL_AASS_OPIN_V 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_OPIN_V 총 갯수
	 * @exception
	 */
    int selectIddlAassOpinVListTotCnt(IddlAassOpinVDefaultVO searchVO);
    
}
