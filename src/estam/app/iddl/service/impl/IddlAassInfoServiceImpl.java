package estam.app.iddl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.iddl.service.IddlAassInfoDefaultVO;
import estam.app.iddl.service.IddlAassInfoService;
import estam.app.iddl.service.IddlAassInfoVO;
import estam.app.scn.evnt.service.ConEvntDataDefaultVO;
import estam.app.scn.evnt.service.EhqkOcurInfoVO;

/**
 * @Class Name : IddlAassInfoServiceImpl.java
 * @Description : IddlAassInfo Business Implement class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("iddlAassInfoService")
public class IddlAassInfoServiceImpl extends AbstractServiceImpl implements IddlAassInfoService {

	@Resource(name = "iddlAassInfoDAO")
	private IddlAassInfoDAO iddlAassInfoDAO;

	/** ID Generation */
	// @Resource(name="{egovIddlAassInfoIdGnrService}")
	// private EgovIdGnrService egovIdGnrService;

	/**
	 * EHQK_OCUR_INFO 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassInfoVO
	 * @return 조회한 IDDL_AASS_INFO
	 * @exception Exception
	 */
	public List<EhqkOcurInfoVO> selectEhqkOcurInfo(IddlAassInfoVO vo) throws Exception {
		List<EhqkOcurInfoVO> resultVO = iddlAassInfoDAO.selectEhqkOcurInfo(vo);

		return resultVO;
	}

	/**
	 * IDDL_AASS_INFO을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 IddlAassInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertIddlAassInfo(IddlAassInfoVO vo) throws Exception {
		log.debug(vo.toString());

		/** ID Generation Service */
		// TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
		// String id = egovIdGnrService.getNextStringId();
		// vo.setId(id);
		log.debug(vo.toString());

		iddlAassInfoDAO.insertIddlAassInfo(vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return null;
	}

	/**
	 * IDDL_AASS_INFO을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 IddlAassInfoVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateIddlAassInfo(IddlAassInfoVO vo) throws Exception {
		iddlAassInfoDAO.updateIddlAassInfo(vo);
	}

	/**
	 * IDDL_AASS_INFO을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 IddlAassInfoVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteIddlAassInfo(IddlAassInfoVO vo) throws Exception {
		iddlAassInfoDAO.deleteIddlAassInfo(vo);
	}

	/**
	 * IDDL_AASS_INFO을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassInfoVO
	 * @return 조회한 IDDL_AASS_INFO
	 * @exception Exception
	 */
	public IddlAassInfoVO selectIddlAassInfo(IddlAassInfoVO vo) throws Exception {
		IddlAassInfoVO resultVO = iddlAassInfoDAO.selectIddlAassInfo(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * IDDL_AASS_INFO 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_INFO 목록
	 * @exception Exception
	 */
	public List selectWvEvntList(IddlAassInfoDefaultVO searchVO) throws Exception {
		return iddlAassInfoDAO.selectWvEvntList(searchVO);
	}

	public List selectWvEvntList2(IddlAassInfoDefaultVO searchVO) throws Exception {
		return iddlAassInfoDAO.selectWvEvntList2(searchVO);
	}

	/**
	 * IDDL_AASS_INFO 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_INFO 목록
	 * @exception Exception
	 */
	public List selectIddlAassInfoList(IddlAassInfoDefaultVO searchVO) throws Exception {
		return iddlAassInfoDAO.selectIddlAassInfoList(searchVO);
	}

	/**
	 * IDDL_AASS_INFO 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_INFO 목록
	 * @exception Exception
	 */
	public List selectBarEventFrmInfo(IddlAassInfoDefaultVO searchVO) throws Exception {
		return iddlAassInfoDAO.selectBarEventFrmInfo(searchVO);
	}

	public List selectBarEventFrmInfo2(IddlAassInfoDefaultVO searchVO) throws Exception {
		return iddlAassInfoDAO.selectBarEventFrmInfo(searchVO);
	}

	/**
	 * IDDL_AASS_INFO 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_INFO 총 갯수
	 * @exception
	 */
	public int selectIddlAassInfoListTotCnt(IddlAassInfoDefaultVO searchVO) {
		return iddlAassInfoDAO.selectIddlAassInfoListTotCnt(searchVO);
	}

	public String selectIddlAassNo(ConEvntDataDefaultVO searchVO) throws Exception {
		return iddlAassInfoDAO.selectIddlAassNo(searchVO);
	}

}
