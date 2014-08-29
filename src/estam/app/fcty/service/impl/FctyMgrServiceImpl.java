package estam.app.fcty.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.fcty.service.FctyMgrDefaultVO;
import estam.app.fcty.service.FctyMgrService;
import estam.app.fcty.service.FctyMgrVO;
import estam.app.fcty.service.impl.FctyMgrDAO;
import estam.app.main.service.FctyMgrInfoVO;

/**
 * @Class Name : FctyMgrServiceImpl.java
 * @Description : FctyMgr Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("fctyMgrService")
public class FctyMgrServiceImpl extends AbstractServiceImpl implements
        FctyMgrService {

    @Resource(name="fctyMgrDAO")
    private FctyMgrDAO fctyMgrDAO;
    
    /** ID Generation */
    //@Resource(name="{egovFctyMgrIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * FCTY_MGR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyMgrVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertFctyMgr(FctyMgrVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	fctyMgrDAO.insertFctyMgr(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * FCTY_MGR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyMgrVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateFctyMgr(FctyMgrVO vo) throws Exception {
        fctyMgrDAO.updateFctyMgr(vo);
    }

    /**
	 * FCTY_MGR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyMgrVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteFctyMgr(FctyMgrVO vo) throws Exception {
        fctyMgrDAO.deleteFctyMgr(vo);
    }

    /**
	 * FCTY_MGR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyMgrVO
	 * @return 조회한 FCTY_MGR
	 * @exception Exception
	 */
    public FctyMgrVO selectFctyMgr(FctyMgrVO vo) throws Exception {
        FctyMgrVO resultVO = fctyMgrDAO.selectFctyMgr(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * FCTY_MGR 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_MGR 목록
	 * @exception Exception
	 */
    public List selectFctyMgrList(FctyMgrDefaultVO searchVO) throws Exception {
        return fctyMgrDAO.selectFctyMgrList(searchVO);
    }

    /**
	 * FCTY_MGR 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_MGR 총 갯수
	 * @exception
	 */
    public int selectFctyMgrListTotCnt(FctyMgrDefaultVO searchVO) {
		return fctyMgrDAO.selectFctyMgrListTotCnt(searchVO);
	}
    
    /**
   	 * PGA 목록을 조회한다. 
   	 * @return PGA 목록
   	 * @exception Exception
   	 */
    public  List selectFctyPga() throws Exception {
    	   return fctyMgrDAO.selectFctyPga();
       }
       
     /**
   	 * 진도(MMI) 목록을 조회한다. 
   	 * @return 진도(MMI) 목록
   	 * @exception Exception
   	 */
    public   List selectFctyMmi() throws Exception {
    	   return fctyMgrDAO.selectFctyMmi();
       }
     
     /**
   	 * 계측소 목록을 조회한다. 
   	 * @return 계측소 목록
   	 * @exception Exception
   	 */
    public   List selectFctyGvmt() throws Exception {
    	   return fctyMgrDAO.selectFctyGvmt();
       }
       
       /**
   	 * 지반분류 목록을 조회한다. 
   	 * @return 지반분류 목록
   	 * @exception Exception
   	 */
    public   List selectFctyGrnd() throws Exception {
    	   return fctyMgrDAO.selectFctyGrnd();
       }
       
     /**
   	 * 이상진동감지 목록을 조회한다. 
   	 * @return 이상진동감지 목록
   	 * @exception Exception
   	 */
    public   List selectFctyEvnt() throws Exception {
    	   return fctyMgrDAO.selectFctyEvnt();
       }
    
    /**
  	 * 시설물 종류에 따른 시설물갯수 및 기타정보  목록을 조회한다. 
  	 * @return 시설물 종류에 따른 시설물갯수 및 기타정보  목록
  	 * @exception Exception
  	 */
    public List listFctyTypeInfo() throws Exception{
 	   return fctyMgrDAO.listFctyTypeInfo();
    }     
    /**
	 * 계측소을 총 수를 구한다.
	 * @return  
	 * @exception Exception
	 */
    public int  selectFctyTotCnt() throws Exception {
       return fctyMgrDAO.selectFctyTotCnt();
    } 
    /**
	 * 시설물 정보를  조회한다. 
	 * @return 시설물 정보를  조회
	 * @exception Exception
	 */
    public FctyMgrInfoVO selectFctyMgrInfo(FctyMgrInfoVO vFctyMgrInfoVo) throws Exception {
    	 return fctyMgrDAO.selectFctyMgrInfo(vFctyMgrInfoVo);
    } 
}
