package estam.app.fcty.service;

import java.util.List;

import estam.app.fcty.service.EhqkScnImgDefaultVO;
import estam.app.fcty.service.EhqkScnImgVO;

/**
 * @Class Name : EhqkScnImgService.java
 * @Description : EhqkScnImg Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface EhqkScnImgService {
	
	/**
	 * EHQK_SCN_IMG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 EhqkScnImgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertEhqkScnImg(EhqkScnImgVO vo) throws Exception;
    
    /**
	 * EHQK_SCN_IMG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 EhqkScnImgVO
	 * @return void형
	 * @exception Exception
	 */
    void updateEhqkScnImg(EhqkScnImgVO vo) throws Exception;
    
    /**
	 * EHQK_SCN_IMG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 EhqkScnImgVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteEhqkScnImg(EhqkScnImgVO vo) throws Exception;
    
    /**
	 * EHQK_SCN_IMG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 EhqkScnImgVO
	 * @return 조회한 EHQK_SCN_IMG
	 * @exception Exception
	 */
    EhqkScnImgVO selectEhqkScnImg(EhqkScnImgVO vo) throws Exception;
    
    /**
	 * EHQK_SCN_IMG 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EHQK_SCN_IMG 목록
	 * @exception Exception
	 */
    List selectEhqkScnImgList(EhqkScnImgDefaultVO searchVO) throws Exception;
    
    /**
	 * EHQK_SCN_IMG 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EHQK_SCN_IMG 총 갯수
	 * @exception
	 */
    int selectEhqkScnImgListTotCnt(EhqkScnImgDefaultVO searchVO);
    
}
