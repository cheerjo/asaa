package estam.app.scn.mma.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.mma.service.FctyMmaDefaultVO;
import estam.app.scn.mma.service.FctyMmaVO;

/**
 * @Class Name : FctyMmaDAO.java
 * @Description : FctyMma DAO Class
 * @Modification Information
 * 
 * @author ates
 * @since 2013.10.23
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Repository("fctyMmaDAO")
public class FctyMmaDAO extends EgovAbstractDAO {

	/**
	 * CON_MMA_DATA을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 FctyMmaVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertFctyMma(FctyMmaVO vo) throws Exception {

		return (String) insert("fctyMmaDAO.insertFctyMma_S", vo);
	}

	/**
	 * CON_MMA_DATA을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 FctyMmaVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateFctyMma(FctyMmaVO vo) throws Exception {
		update("fctyMmaDAO.updateFctyMma_S", vo);
	}

	/**
	 * CON_MMA_DATA을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 FctyMmaVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteFctyMma(FctyMmaVO vo) throws Exception {
		delete("fctyMmaDAO.deleteFctyMma_S", vo);
	}

	/**
	 * CON_MMA_DATA을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 FctyMmaVO
	 * @return 조회한 CON_MMA_DATA
	 * @exception Exception
	 */
	public FctyMmaVO selectFctyMma(FctyMmaVO vo) throws Exception {
		return (FctyMmaVO) selectByPk("fctyMmaDAO.selectFctyMma_S", vo);
	}

	/**
	 * CON_MMA_DATA 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return CON_MMA_DATA 목록
	 * @exception Exception
	 */
	public List selectFctyMmaList(FctyMmaDefaultVO searchVO) throws Exception {
		return list("fctyMmaDAO.selectFctyMmaList_D", searchVO);
	}

	/**
	 * CON_MMA_DATA 총 갯수를 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return CON_MMA_DATA 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectFctyMmaListTotCnt(FctyMmaDefaultVO searchVO) {
		return (Integer) getSqlMapClientTemplate().queryForObject("fctyMmaDAO.selectFctyMmaListTotCnt_S", searchVO);
	}

	public void updateFctyIntensity(FctyMmaVO fctyMmaVo) {
		update("fctyMmaDAO.updateFctyIntensity_S", fctyMmaVo);
	}

	public void updateResetFctyIntensity() {
		update("fctyMmaDAO.updateResetFctyIntensity", null);
	}

}
