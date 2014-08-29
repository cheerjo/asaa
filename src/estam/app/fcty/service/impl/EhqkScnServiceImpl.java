package estam.app.fcty.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.fcty.service.EhqkScnDefaultVO;
import estam.app.fcty.service.EhqkScnService;
import estam.app.fcty.service.EhqkScnVO;

/**
 * @Class Name : EhqkScnServiceImpl.java
 * @Description : EhqkScn Business Implement class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.23
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("ehqkScnService")
public class EhqkScnServiceImpl extends AbstractServiceImpl implements EhqkScnService {

	@Resource(name = "ehqkScnDAO")
	private EhqkScnDAO ehqkScnDAO;

	/** ID Generation */
	// @Resource(name="{egovEhqkScnIdGnrService}")
	// private EgovIdGnrService egovIdGnrService;

	/**
	 * EHQK_SCN을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 EhqkScnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertEhqkScn(EhqkScnVO vo) throws Exception {
		log.debug(vo.toString());

		/** ID Generation Service */
		// TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
		// String id = egovIdGnrService.getNextStringId();
		// vo.setId(id);
		log.debug(vo.toString());

		ehqkScnDAO.insertEhqkScn(vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return null;
	}

	/**
	 * EHQK_SCN을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 EhqkScnVO List
	 * @return 등록 결과
	 * @exception Exception
	 */
	public void insertEhqkScnList(List<EhqkScnVO> esVoList) throws Exception {

		for (EhqkScnVO vo : esVoList) {

			ehqkScnDAO.insertEhqkScn(vo);
		}
	}

	/**
	 * EHQK_SCN을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 EhqkScnVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateEhqkScn(EhqkScnVO vo) throws Exception {
		ehqkScnDAO.updateEhqkScn(vo);
	}

	/**
	 * EHQK_SCN을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 EhqkScnVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteEhqkScn(EhqkScnVO vo) throws Exception {
		ehqkScnDAO.deleteEhqkScn(vo);
	}

	/**
	 * EHQK_SCN을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 EhqkScnVO
	 * @return 조회한 EHQK_SCN
	 * @exception Exception
	 */
	public EhqkScnVO selectEhqkScn(EhqkScnVO vo) throws Exception {
		EhqkScnVO resultVO = ehqkScnDAO.selectEhqkScn(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * EHQK_SCN 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return EHQK_SCN 목록
	 * @exception Exception
	 */
	public List selectEhqkScnList(EhqkScnDefaultVO searchVO) throws Exception {
		return ehqkScnDAO.selectEhqkScnList(searchVO);
	}

	/**
	 * EHQK_SCN 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return EHQK_SCN 총 갯수
	 * @exception
	 */
	public int selectEhqkScnListTotCnt(EhqkScnDefaultVO searchVO) {
		return ehqkScnDAO.selectEhqkScnListTotCnt(searchVO);
	}

	/**
	 * EHQK_SCN 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO List
	 * @return EHQK_SCN 목록
	 * @exception Exception
	 */
	public List<EhqkScnVO> selectEhqkScnListByKey(EhqkScnVO searchVO) throws Exception {
		return ehqkScnDAO.selectEhqkScnListByKey(searchVO);
	}

	/**
	 * EHQK_SCN 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO List
	 * @return EHQK_SCN 목록
	 * @exception Exception
	 */
	public List<EhqkScnVO> selectEhqkScnListByCd(EhqkScnVO searchVO) throws Exception {
		return ehqkScnDAO.selectEhqkScnListByCd(searchVO);
	}

}
