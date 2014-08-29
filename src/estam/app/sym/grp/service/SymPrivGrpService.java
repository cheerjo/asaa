package estam.app.sym.grp.service;

import java.util.List;
import java.util.Map;

import estam.app.sym.grp.service.SymPrivGrpDefaultVO;
import estam.app.sym.grp.service.SymPrivGrpVO;
import estam.app.sym.mnu.service.SymMenuDefaultVO;

/**
 * @Class Name : SymPrivGrpService.java
 * @Description : SymPrivGrp Business class
 * @Modification Information
 *
 * @author ATRES
 * @since 2013.07.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface SymPrivGrpService {
	
	/**
	 * SYM_PRIV_GRP을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymPrivGrpVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertSymPrivGrp(SymPrivGrpVO vo) throws Exception;
    
    /**
	 * SYM_PRIV_GRP을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymPrivGrpVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSymPrivGrp(SymPrivGrpVO vo) throws Exception;
    
    /**
	 * SYM_PRIV_GRP을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymPrivGrpVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSymPrivGrp(SymPrivGrpVO vo) throws Exception;
    
    /**
	 * SYM_PRIV_GRP을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymPrivGrpVO
	 * @return 조회한 SYM_PRIV_GRP
	 * @exception Exception
	 */
    SymPrivGrpVO selectSymPrivGrp(SymPrivGrpVO vo) throws Exception;
    
    /**
	 * SYM_PRIV_GRP 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_PRIV_GRP 목록
	 * @exception Exception
	 */
    List selectSymPrivGrpList(SymPrivGrpDefaultVO searchVO) throws Exception;
     
    
    /**
	 * SYM_PRIV_GRP 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_PRIV_GRP 총 갯수
	 * @exception
	 */
    int selectSymPrivGrpListTotCnt(SymPrivGrpDefaultVO searchVO);
    
    
    /**
   	 * SYM_PRIV_GRP 목록을 조회한다.
   	 * @param searchVO - 조회할 정보가 담긴 VO
   	 * @return SYM_PRIV_GRP 목록
   	 * @exception Exception
   	 */
       List<SymPrivGrpVO> ListSymPrivGrp() throws Exception;

    
}
