package estam.app.scn.mma.service;

import java.util.List;

import estam.app.iddl.service.IddlAassInfoVO;
import estam.app.iddl.service.IddlAassRlstVO;

/**
 * @Class Name : FctyMmaService.java
 * @Description : FctyMma Business class
 * @Modification Information
 *
 * @author ates
 * @since 2013.10.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface FctyMmaService {
	
	/**
	 * CON_MMA_DATA을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyMmaVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertFctyMma(FctyMmaVO vo) throws Exception;
    
    /**
	 * CON_MMA_DATA을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyMmaVO
	 * @return void형
	 * @exception Exception
	 */
    void updateFctyMma(FctyMmaVO vo) throws Exception;
    
    /**
	 * CON_MMA_DATA을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyMmaVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteFctyMma(FctyMmaVO vo) throws Exception;
    
    /**
	 * CON_MMA_DATA을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyMmaVO
	 * @return 조회한 CON_MMA_DATA
	 * @exception Exception
	 */
    FctyMmaVO selectFctyMma(FctyMmaVO vo) throws Exception;
    
    /**
	 * CON_MMA_DATA 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CON_MMA_DATA 목록
	 * @exception Exception
	 */
    List selectFctyMmaList(FctyMmaDefaultVO searchVO) throws Exception;
    
    /**
	 * CON_MMA_DATA 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CON_MMA_DATA 총 갯수
	 * @exception
	 */
    int selectFctyMmaListTotCnt(FctyMmaDefaultVO searchVO);

    /**
	 * IddlAassRlst 목록을 조회한다.
	 * @param IddlAassInfoVO - 조회할 정보가 담긴 VO
	 * @return IddlAassRlst 목록
	 * @exception Exception
	 */
	List<IddlAassRlstVO> selectIddlAassInfo(IddlAassInfoVO iddlAassInfoVO);

    /**
	 * CON_MMA_INTENSITY 를수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyMmaVO
	 * @return void형
	 * @exception Exception
	 */
	void updateFctyIntensity(FctyMmaVO fctyMmaVo);

	/**
	 * FCTY_INTENSITY PGA, MMA 값을 0으로 초기화한다.
	 * @param 
	 * @return void형
	 * @exception Exception
	 */
	void updateResetFctyIntensity();
    
}
