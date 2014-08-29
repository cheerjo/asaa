package estam.app.iddl.service;

import java.util.List;

/**
 * @Class Name : IddlAassRlstService.java
 * @Description : IddlAassRlst Business class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public interface IddlAassRlstService {

	/**
	 * IDDL_AASS_RLST을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 IddlAassRlstVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertIddlAassRlst(IddlAassRlstVO vo) throws Exception;

	/**
	 * IDDL_AASS_RLST을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 IddlAassRlstVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateIddlAassRlst(IddlAassRlstVO vo) throws Exception;

	/**
	 * IDDL_AASS_RLST을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 IddlAassRlstVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteIddlAassRlst(IddlAassRlstVO vo) throws Exception;

	/**
	 * IDDL_AASS_RLST을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public IddlAassRlstVO selectIddlAassRlst(IddlAassRlstVO vo) throws Exception;

	/**
	 * IDDL_AASS_RLST을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public IddlAassRlstVO selectIddlAassRlstRpt(IddlAassRlstVO vo) throws Exception;

	/**
	 * IDDL_AASS_RLST 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_RLST 목록
	 * @exception Exception
	 */
	public List selectIddlAassRlstList(IddlAassRlstDefaultVO searchVO) throws Exception;

	/**
	 * IDDL_AASS_RLST 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_RLST 총 갯수
	 * @exception
	 */
	public int selectIddlAassRlstListTotCnt(IddlAassRlstDefaultVO searchVO);

	// 점검필요 목록 갯수
	public int selectFctyChkListTotCnt(IddlAassRlstDefaultVO searchVO);

	/**
	 * 지진안정성분석결과 목록을 조회한다.
	 * 
	 * @return 지진안정성분석결과 목록
	 * @exception Exception
	 */
	public List selectEhqkOtnInfo(IddlAassRlstDefaultVO iddlAassRlstDfVo) throws Exception;

	/**
	 * 점검필요 시설물 목록을 조회한다.
	 * 
	 * @return 점검필요 시설물 목록
	 * @exception Exception
	 */
	public List selectIptnInfo(IddlAassRlstDefaultVO iddlAassRlstDfVo) throws Exception;

	/**
	 * 분석결과 요약 조회한다.
	 * 
	 * @return 분석결과 요약
	 * @exception Exception
	 */
	public List selectSfResultInfo() throws Exception;

	/**
	 * 안전평가 결과를 조회
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public IddlAassRlstVO selectSFIddlAassRlst(IddlAassRlstVO vo) throws Exception;

	/**
	 * 평가보조자료을 조회
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public IddlSubAassRlstVO selectSubIddlAassRlst(IddlSubAassRlstVO vo) throws Exception;

	/**
	 * 개별분석자료 조회
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassInfoVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public List<IddlAassRlstVO> selectIddlAassInfoList(IddlAassInfoVO iddlAassInfoVO) throws Exception;

	/**
	 * 분석결과 상관관계 높이-진동수 관계 조회
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public List selectIddlAassRlstListByFctyStrTycd(IddlAassRlstVO searchVO) throws Exception;

	/**
	 * 개별분석결과 정보 조회
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public List selectIddlAassRlstList() throws Exception;

	/**
	 * 개별분석결과 정보 조회
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassInfoVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public List selectIddlAassRlstList(IddlAassInfoVO searchVO) throws Exception;

}
