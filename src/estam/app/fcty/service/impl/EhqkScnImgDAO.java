package estam.app.fcty.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.fcty.service.EhqkScnImgDefaultVO;
import estam.app.fcty.service.EhqkScnImgVO;

/**
 * @Class Name : EhqkScnImgDAO.java
 * @Description : EhqkScnImg DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("ehqkScnImgDAO")
public class EhqkScnImgDAO extends EgovAbstractDAO {

	/**
	 * EHQK_SCN_IMG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 EhqkScnImgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertEhqkScnImg(EhqkScnImgVO vo) throws Exception {
        return (String)insert("ehqkScnImgDAO.insertEhqkScnImg_S", vo);
    }

    /**
	 * EHQK_SCN_IMG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 EhqkScnImgVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateEhqkScnImg(EhqkScnImgVO vo) throws Exception {
        update("ehqkScnImgDAO.updateEhqkScnImg_S", vo);
    }

    /**
	 * EHQK_SCN_IMG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 EhqkScnImgVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteEhqkScnImg(EhqkScnImgVO vo) throws Exception {
        delete("ehqkScnImgDAO.deleteEhqkScnImg_S", vo);
    }

    /**
	 * EHQK_SCN_IMG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 EhqkScnImgVO
	 * @return 조회한 EHQK_SCN_IMG
	 * @exception Exception
	 */
    public EhqkScnImgVO selectEhqkScnImg(EhqkScnImgVO vo) throws Exception {
        return (EhqkScnImgVO) selectByPk("ehqkScnImgDAO.selectEhqkScnImg_S", vo);
    }

    /**
	 * EHQK_SCN_IMG 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return EHQK_SCN_IMG 목록
	 * @exception Exception
	 */
    public List selectEhqkScnImgList(EhqkScnImgDefaultVO searchVO) throws Exception {
        return list("ehqkScnImgDAO.selectEhqkScnImgList_D", searchVO);
    }

    /**
	 * EHQK_SCN_IMG 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return EHQK_SCN_IMG 총 갯수
	 * @exception
	 */
    public int selectEhqkScnImgListTotCnt(EhqkScnImgDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ehqkScnImgDAO.selectEhqkScnImgListTotCnt_S", searchVO);
    }

}
