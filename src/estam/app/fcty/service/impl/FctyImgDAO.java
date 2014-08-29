package estam.app.fcty.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.fcty.service.FctyImgDefaultVO;
import estam.app.fcty.service.FctyImgVO;

/**
 * @Class Name : FctyImgDAO.java
 * @Description : FctyImg DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("fctyImgDAO")
public class FctyImgDAO extends EgovAbstractDAO {

	/**
	 * FCTY_IMG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyImgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertFctyImg(FctyImgVO vo) throws Exception {
        return (String)insert("fctyImgDAO.insertFctyImg_S", vo);
    }

    /**
	 * FCTY_IMG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyImgVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateFctyImg(FctyImgVO vo) throws Exception {
        update("fctyImgDAO.updateFctyImg_S", vo);
    }

    /**
	 * FCTY_IMG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyImgVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteFctyImg(FctyImgVO vo) throws Exception {
        delete("fctyImgDAO.deleteFctyImg_S", vo);
    }

    /**
	 * FCTY_IMG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyImgVO
	 * @return 조회한 FCTY_IMG
	 * @exception Exception
	 */
    public FctyImgVO selectFctyImg(FctyImgVO vo) throws Exception {
        return (FctyImgVO) selectByPk("fctyImgDAO.selectFctyImg_S", vo);
    }

    /**
	 * FCTY_IMG 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return FCTY_IMG 목록
	 * @exception Exception
	 */
    public List selectFctyImgList(FctyImgDefaultVO searchVO) throws Exception {
        return list("fctyImgDAO.selectFctyImgList_D", searchVO);
    }

    /**
	 * FCTY_IMG 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return FCTY_IMG 총 갯수
	 * @exception
	 */
    public int selectFctyImgListTotCnt(FctyImgDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("fctyImgDAO.selectFctyImgListTotCnt_S", searchVO);
    }

}
