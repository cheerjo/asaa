package estam.app.sym.cmm.service;

import java.util.List;
import estam.app.sym.cmm.service.SymCommCdDefaultVO;
import estam.app.sym.cmm.service.SymCommCdVO;

/**
 * @Class Name : SymCommCdService.java
 * @Description : SymCommCd Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.07.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface SymCommCdService {
	
	/**
	 * SYM_COMM_CD을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymCommCdVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertSymCommCd(SymCommCdVO vo) throws Exception;
    
    /**
	 * SYM_COMM_CD을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymCommCdVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSymCommCd(SymCommCdVO vo) throws Exception;
    
    /**
	 * SYM_COMM_CD을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymCommCdVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSymCommCd(SymCommCdVO vo) throws Exception;
    
    /**
	 * SYM_COMM_CD을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymCommCdVO
	 * @return 조회한 SYM_COMM_CD
	 * @exception Exception
	 */
    SymCommCdVO selectSymCommCd(SymCommCdVO vo) throws Exception;
    
    /**
	 * SYM_COMM_CD 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_COMM_CD 목록
	 * @exception Exception
	 */
    List selectSymCommCdList(SymCommCdDefaultVO searchVO) throws Exception;
    
    /**
	 * SYM_COMM_CD 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_COMM_CD 총 갯수
	 * @exception
	 */
    int selectSymCommCdListTotCnt(SymCommCdDefaultVO searchVO);
    
}