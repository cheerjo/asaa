package estam.app.fcty.service;

import java.util.List;

import estam.app.main.service.FctyMgrInfoVO;

/**
 * @Class Name : FctyMgrService.java
 * @Description : FctyMgr Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface FctyMgrService {
	
	/**
	 * FCTY_MGR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyMgrVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertFctyMgr(FctyMgrVO vo) throws Exception;
    
    /**
	 * FCTY_MGR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyMgrVO
	 * @return void형
	 * @exception Exception
	 */
    void updateFctyMgr(FctyMgrVO vo) throws Exception;
    
    /**
	 * FCTY_MGR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyMgrVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteFctyMgr(FctyMgrVO vo) throws Exception;
    
    /**
	 * FCTY_MGR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyMgrVO
	 * @return 조회한 FCTY_MGR
	 * @exception Exception
	 */
    FctyMgrVO selectFctyMgr(FctyMgrVO vo) throws Exception;
    
    /**
	 * FCTY_MGR 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_MGR 목록
	 * @exception Exception
	 */
    List selectFctyMgrList(FctyMgrDefaultVO searchVO) throws Exception;
    
    /**
	 * FCTY_MGR 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_MGR 총 갯수
	 * @exception
	 */
    int selectFctyMgrListTotCnt(FctyMgrDefaultVO searchVO);
     
    /**
   	 * PGA 목록을 조회한다. 
   	 * @return PGA 목록
   	 * @exception Exception
   	 */
       List selectFctyPga() throws Exception;
       
     /**
   	 * 진도(MMI) 목록을 조회한다. 
   	 * @return 진도(MMI) 목록
   	 * @exception Exception
   	 */
       List selectFctyMmi() throws Exception;
     
     /**
   	 * 계측소 목록을 조회한다. 
   	 * @return 계측소 목록
   	 * @exception Exception
   	 */
       List selectFctyGvmt() throws Exception;
        
       /**
   	 * 지반분류 목록을 조회한다. 
   	 * @return 지반분류 목록
   	 * @exception Exception
   	 */
       List selectFctyGrnd() throws Exception;
       
     /**
   	 * 이상진동감지 목록을 조회한다. 
   	 * @return 이상진동감지 목록
   	 * @exception Exception
   	 */
       List selectFctyEvnt() throws Exception;
     
       /**
      	 * 시설물 종류에 따른 시설물갯수 및 기타정보  목록을 조회한다. 
      	 * @return 시설물 종류에 따른 시설물갯수 및 기타정보  목록
      	 * @exception Exception
      	 */
      List listFctyTypeInfo() throws Exception;  
      
      /**
    	 * 계측소을 총 수를 구한다.
    	 * @return  
    	 * @exception Exception
    	 */
      int  selectFctyTotCnt() throws Exception;  
      
      /**
    	 * 시설물 정보를  조회한다. 
    	 * @return 시설물 정보를  조회
    	 * @exception Exception
    	 */
      FctyMgrInfoVO selectFctyMgrInfo(FctyMgrInfoVO vFctyMgrInfoVo) throws Exception;  
      
}
