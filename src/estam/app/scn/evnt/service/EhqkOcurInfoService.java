package estam.app.scn.evnt.service;

import java.util.List;

/**
 * @Class Name : EhqkOcurInfoService.java
 * @Description : EhqkOcurInfo Business class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public interface EhqkOcurInfoService {

	/**
	 * EHQK_OCUR_INFO을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 EhqkOcurInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertEhqkOcurInfo(EhqkOcurInfoVO vo) throws Exception;

	/**
	 * EHQK_OCUR_INFO을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 EhqkOcurInfoVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateEhqkOcurInfo(EhqkOcurInfoVO vo) throws Exception;

	/**
	 * EHQK_OCUR_INFO을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 EhqkOcurInfoVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteEhqkOcurInfo(EhqkOcurInfoVO vo) throws Exception;

	/**
	 * EHQK_OCUR_INFO을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 EhqkOcurInfoVO
	 * @return 조회한 EHQK_OCUR_INFO
	 * @exception Exception
	 */
	public EhqkOcurInfoVO selectEhqkOcurInfo(EhqkOcurInfoVO vo) throws Exception;

	/**
	 * EHQK_OCUR_INFO 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return EHQK_OCUR_INFO 목록
	 * @exception Exception
	 */
	public List selectEhqkOcurInfoList(EhqkOcurInfoDefaultVO searchVO) throws Exception;

	/**
	 * EHQK_OCUR_INFO 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return EHQK_OCUR_INFO 총 갯수
	 * @exception
	 */
	public int selectEhqkOcurInfoListTotCnt(EhqkOcurInfoDefaultVO searchVO);

	/**
	 * EHQK_OCUR_INFO 최신 지진번호를 조회한다.
	 * 
	 * @param
	 * 
	 * @return EHQK_OCUR_INFO 의 EHQK_REQ_ID 최신번호
	 * @exception
	 */
	public String selectMaxEhqkReqId() throws Exception;

}
