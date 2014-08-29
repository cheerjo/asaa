package estam.app.sym.usr.service;

import java.util.List;

import estam.app.sym.grp.service.SymPrivGrpVO;

/**
 * @Class Name : SymUserService.java
 * @Description : SymUser Business class
 * @Modification Information
 *
 * @author ATRES
 * @since 2013.07.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface SymUserService {
	
	/**
	 * SYM_USER을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymUserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertSymUser(SymUserVO vo) throws Exception;
    
    /**
	 * SYM_USER을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymUserVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSymUser(SymUserVO vo) throws Exception;
    
    /**
	 * SYM_USER을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymUserVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSymUser(SymUserVO vo) throws Exception;
    
    /**
	 * SYM_USER을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymUserVO
	 * @return 조회한 SYM_USER
	 * @exception Exception
	 */
    SymUserVO selectSymUser(SymUserVO vo) throws Exception;
    
    /**
//	 * SYM_USER 목록을 조회한다.pagepagepagepagepage
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_USER 목록
	 * @exception Exception
	 */
    List selectSymUserList(SymUserDefaultVO searchVO) throws Exception;
    
    /**
	 * SYM_USER 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_USER 총 갯수
	 * @exception
	 */
    int selectSymUserListTotCnt(SymUserDefaultVO searchVO);
    
    
    /**
   	 * SYM_PRIV_MENU 목록 콤보처리을 위해  코드/명을 구해 온다. 
   	 * @return SYM_PRIV_MENU 리스트
   	 * @exception Exception
   	 */
    List<SymPrivGrpCboVO> listSymPrivGrp() throws Exception;;
 
    
}
