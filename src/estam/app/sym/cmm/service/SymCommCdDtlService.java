package estam.app.sym.cmm.service;

import java.util.List;
import estam.app.sym.cmm.service.SymCommCdDtlDefaultVO;
import estam.app.sym.cmm.service.SymCommCdDtlVO;

/**
 * @Class Name : SymCommCdDtlService.java
 * @Description : SymCommCdDtl Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.07.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface SymCommCdDtlService {
	
	/**
	 * SYM_COMM_CD_DTL을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymCommCdDtlVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertSymCommCdDtl(SymCommCdDtlVO vo) throws Exception;
    
    /**
	 * SYM_COMM_CD_DTL을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymCommCdDtlVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSymCommCdDtl(SymCommCdDtlVO vo) throws Exception;
    
    /**
	 * SYM_COMM_CD_DTL을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymCommCdDtlVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSymCommCdDtl(SymCommCdDtlVO vo) throws Exception;
    
    /**
	 * SYM_COMM_CD_DTL을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymCommCdDtlVO
	 * @return 조회한 SYM_COMM_CD_DTL
	 * @exception Exception
	 */
    SymCommCdDtlVO selectSymCommCdDtl(SymCommCdDtlVO vo) throws Exception;
    
    /**
	 * SYM_COMM_CD_DTL 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_COMM_CD_DTL 목록
	 * @exception Exception
	 */
    List selectSymCommCdDtlList(SymCommCdDtlDefaultVO searchVO) throws Exception;
    
    /**
	 * SYM_COMM_CD_DTL 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_COMM_CD_DTL 총 갯수
	 * @exception
	 */
    int selectSymCommCdDtlListTotCnt(SymCommCdDtlDefaultVO searchVO);
    
}
