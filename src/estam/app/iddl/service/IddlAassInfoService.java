package estam.app.iddl.service;

import java.util.List;

import estam.app.scn.evnt.service.ConEvntDataDefaultVO;
import estam.app.scn.evnt.service.EhqkOcurInfoVO;

/**
 * @Class Name : IddlAassInfoService.java
 * @Description : IddlAassInfo Business class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public interface IddlAassInfoService {

	/**
	 * EHQK_OCUR_INFO을 조회한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 IddlAassInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public List<EhqkOcurInfoVO> selectEhqkOcurInfo(IddlAassInfoVO vo) throws Exception;

	/**
	 * IDDL_AASS_INFO
	 * 
	 * @return
	 */
	public List selectBarEventFrmInfo(IddlAassInfoDefaultVO searchVO) throws Exception;

	public List selectBarEventFrmInfo2(IddlAassInfoDefaultVO searchVO) throws Exception;

	public List selectWvEvntList(IddlAassInfoDefaultVO searchVO) throws Exception;

	public List selectWvEvntList2(IddlAassInfoDefaultVO searchVO) throws Exception;

	/**
	 * IDDL_AASS_INFO을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 IddlAassInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertIddlAassInfo(IddlAassInfoVO vo) throws Exception;

	/**
	 * IDDL_AASS_INFO을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 IddlAassInfoVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateIddlAassInfo(IddlAassInfoVO vo) throws Exception;

	/**
	 * IDDL_AASS_INFO을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 IddlAassInfoVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteIddlAassInfo(IddlAassInfoVO vo) throws Exception;

	/**
	 * IDDL_AASS_INFO을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassInfoVO
	 * @return 조회한 IDDL_AASS_INFO
	 * @exception Exception
	 */
	public IddlAassInfoVO selectIddlAassInfo(IddlAassInfoVO vo) throws Exception;

	/**
	 * IDDL_AASS_INFO 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_INFO 목록
	 * @exception Exception
	 */
	public List selectIddlAassInfoList(IddlAassInfoDefaultVO searchVO) throws Exception;

	/**
	 * IDDL_AASS_INFO 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_INFO 총 갯수
	 * @exception
	 */
	public int selectIddlAassInfoListTotCnt(IddlAassInfoDefaultVO searchVO);

	public String selectIddlAassNo(ConEvntDataDefaultVO searchVO) throws Exception;

}
