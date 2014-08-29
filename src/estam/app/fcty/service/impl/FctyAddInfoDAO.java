package estam.app.fcty.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.fcty.service.FctyAddInfoVO;
import estam.app.fcty.service.FctyAddInfoDefaultVO;

/**
 * @Class Name : FctyAddInfoDAO.java
 * @Description : FctyAddInfo DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("fctyAddInfoDAO")
public class FctyAddInfoDAO extends EgovAbstractDAO {

	/**
	 * FCTY_ADD_INFO을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyAddInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertFctyAddInfo(FctyAddInfoVO vo) throws Exception {
        return (String)insert("fctyAddInfoDAO.insertFctyAddInfo_S", vo);
    }

    /**
	 * FCTY_ADD_INFO을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyAddInfoVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateFctyAddInfo(FctyAddInfoVO vo) throws Exception {
        update("fctyAddInfoDAO.updateFctyAddInfo_S", vo);
    }

    /**
	 * FCTY_ADD_INFO을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyAddInfoVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteFctyAddInfo(FctyAddInfoVO vo) throws Exception {
        delete("fctyAddInfoDAO.deleteFctyAddInfo_S", vo);
    }

    /**
	 * FCTY_ADD_INFO을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyAddInfoVO
	 * @return 조회한 FCTY_ADD_INFO
	 * @exception Exception
	 */
    public FctyAddInfoVO selectFctyAddInfo(FctyAddInfoVO vo) throws Exception {
        return (FctyAddInfoVO) selectByPk("fctyAddInfoDAO.selectFctyAddInfo_S", vo);
    }

    /**
	 * FCTY_ADD_INFO 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return FCTY_ADD_INFO 목록
	 * @exception Exception
	 */
    public List selectFctyAddInfoList(FctyAddInfoDefaultVO searchVO) throws Exception {
        return list("fctyAddInfoDAO.selectFctyAddInfoList_D", searchVO);
    }

    /**
	 * FCTY_ADD_INFO 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return FCTY_ADD_INFO 총 갯수
	 * @exception
	 */
    public int selectFctyAddInfoListTotCnt(FctyAddInfoDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("fctyAddInfoDAO.selectFctyAddInfoListTotCnt_S", searchVO);
    }

}
