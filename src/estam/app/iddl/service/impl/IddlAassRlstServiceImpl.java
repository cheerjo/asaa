package estam.app.iddl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.iddl.service.IddlAassInfoVO;
import estam.app.iddl.service.IddlAassRlstDefaultVO;
import estam.app.iddl.service.IddlAassRlstService;
import estam.app.iddl.service.IddlAassRlstVO;
import estam.app.iddl.service.IddlSubAassRlstVO;

/**
 * @Class Name : IddlAassRlstServiceImpl.java
 * @Description : IddlAassRlst Business Implement class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("iddlAassRlstService")
public class IddlAassRlstServiceImpl extends AbstractServiceImpl implements IddlAassRlstService {

	@Resource(name = "iddlAassRlstDAO")
	private IddlAassRlstDAO iddlAassRlstDAO;

	/** ID Generation */
	// @Resource(name="{egovIddlAassRlstIdGnrService}")
	// private EgovIdGnrService egovIdGnrService;

	/**
	 * IDDL_AASS_RLST을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 IddlAassRlstVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertIddlAassRlst(IddlAassRlstVO vo) throws Exception {
		log.debug(vo.toString());

		/** ID Generation Service */
		// TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
		// String id = egovIdGnrService.getNextStringId();
		// vo.setId(id);
		log.debug(vo.toString());

		iddlAassRlstDAO.insertIddlAassRlst(vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return null;
	}

	/**
	 * IDDL_AASS_RLST을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 IddlAassRlstVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateIddlAassRlst(IddlAassRlstVO vo) throws Exception {
		iddlAassRlstDAO.updateIddlAassRlst(vo);
	}

	/**
	 * IDDL_AASS_RLST을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 IddlAassRlstVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteIddlAassRlst(IddlAassRlstVO vo) throws Exception {
		iddlAassRlstDAO.deleteIddlAassRlst(vo);
	}

	/**
	 * IDDL_AASS_RLST을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public IddlAassRlstVO selectIddlAassRlst(IddlAassRlstVO vo) throws Exception {
		IddlAassRlstVO resultVO = iddlAassRlstDAO.selectIddlAassRlst(vo);
		// if (resultVO == null)
		// throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * IDDL_AASS_RLST을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public IddlAassRlstVO selectIddlAassRlstRpt(IddlAassRlstVO vo) throws Exception {
		IddlAassRlstVO resultVO = iddlAassRlstDAO.selectIddlAassRlst(vo);
		// if (resultVO == null)
		// throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * IDDL_AASS_RLST 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_RLST 목록
	 * @exception Exception
	 */
	public List selectIddlAassRlstList(IddlAassRlstDefaultVO searchVO) throws Exception {
		return iddlAassRlstDAO.selectIddlAassRlstList(searchVO);
	}

	/**
	 * IDDL_AASS_RLST 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_RLST 총 갯수
	 * @exception
	 */
	public int selectIddlAassRlstListTotCnt(IddlAassRlstDefaultVO searchVO) {
		return iddlAassRlstDAO.selectIddlAassRlstListTotCnt(searchVO);
	}

	public int selectFctyChkListTotCnt(IddlAassRlstDefaultVO searchVO) {
		return iddlAassRlstDAO.selectFctyChkListTotCnt(searchVO);
	}

	/**
	 * 지진안정성분석결과 목록을 조회한다.
	 * 
	 * @return 지진안정성분석결과 목록
	 * @exception Exception
	 */
	public List selectEhqkOtnInfo(IddlAassRlstDefaultVO iddlAassRlstDfVo) throws Exception {
		return iddlAassRlstDAO.selectEhqkOtnInfo(iddlAassRlstDfVo);
	}

	/**
	 * 점검필요 시설물 목록을 조회한다.
	 * 
	 * @return 점검필요 시설물 목록
	 * @exception Exception
	 */
	public List selectIptnInfo(IddlAassRlstDefaultVO iddlAassRlstDfVo) throws Exception {
		return iddlAassRlstDAO.selectIptnInfo(iddlAassRlstDfVo);
	}

	/**
	 * 분석결과 요약 조회한다.
	 * 
	 * @return 분석결과 요약
	 * @exception Exception
	 */
	public List selectSfResultInfo() throws Exception {
		return iddlAassRlstDAO.selectSfResultInfo();
	}

	/**
	 * 안전평가 결과를 조회
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public IddlAassRlstVO selectSFIddlAassRlst(IddlAassRlstVO vo) throws Exception {
		IddlAassRlstVO resultVO = iddlAassRlstDAO.selectSFIddlAassRlst(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * 평가보조자료을 조회
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public IddlSubAassRlstVO selectSubIddlAassRlst(IddlSubAassRlstVO vo) throws Exception {
		IddlSubAassRlstVO resultVO = iddlAassRlstDAO.selectSubIddlAassRlst(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	public List<IddlAassRlstVO> selectIddlAassInfoList(IddlAassInfoVO iddlAassInfoVO) throws Exception {
		return iddlAassRlstDAO.selectIddlAassInfoList(iddlAassInfoVO);
	}

	public List selectIddlAassRlstListByFctyStrTycd(IddlAassRlstVO searchVO) throws Exception {
		return iddlAassRlstDAO.selectIddlAassRlstListByFctyStrTycd(searchVO);
	}

	public List selectIddlAassRlstList() throws Exception {
		return iddlAassRlstDAO.selectIddlAassRlstList();
	}

	public List selectIddlAassRlstList(IddlAassInfoVO searchVO) throws Exception {
		return iddlAassRlstDAO.selectIddlAassRlstList(searchVO);
	}

}
