package estam.app.fcty.service;

import java.util.List;

import estam.app.fcty.service.FctyImgDefaultVO;
import estam.app.fcty.service.FctyImgVO;

/**
 * @Class Name : FctyImgService.java
 * @Description : FctyImg Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface FctyImgService {
	
	/**
	 * FCTY_IMG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyImgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertFctyImg(FctyImgVO vo) throws Exception;
    
    /**
	 * FCTY_IMG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyImgVO
	 * @return void형
	 * @exception Exception
	 */
    void updateFctyImg(FctyImgVO vo) throws Exception;
    
    /**
	 * FCTY_IMG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyImgVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteFctyImg(FctyImgVO vo) throws Exception;
    
    /**
	 * FCTY_IMG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyImgVO
	 * @return 조회한 FCTY_IMG
	 * @exception Exception
	 */
    FctyImgVO selectFctyImg(FctyImgVO vo) throws Exception;
    
    /**
	 * FCTY_IMG 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_IMG 목록
	 * @exception Exception
	 */
    List selectFctyImgList(FctyImgDefaultVO searchVO) throws Exception;
    
    /**
	 * FCTY_IMG 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_IMG 총 갯수
	 * @exception
	 */
    int selectFctyImgListTotCnt(FctyImgDefaultVO searchVO);
    
}
