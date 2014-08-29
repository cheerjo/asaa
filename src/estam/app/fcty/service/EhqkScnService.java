package estam.app.fcty.service;

import java.util.List;

/**
 * @Class Name : EhqkScnService.java
 * @Description : EhqkScn Business class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.23
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public interface EhqkScnService {

	/**
	 * EHQK_SCN을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 EhqkScnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertEhqkScn(EhqkScnVO vo) throws Exception;

	/**
	 * EHQK_SCN을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 EhqkScnVO List
	 * @return 등록 결과
	 * @exception Exception
	 */
	public void insertEhqkScnList(List<EhqkScnVO> esVoList) throws Exception;

	/**
	 * EHQK_SCN을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 EhqkScnVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateEhqkScn(EhqkScnVO vo) throws Exception;

	/**
	 * EHQK_SCN을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 EhqkScnVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteEhqkScn(EhqkScnVO vo) throws Exception;

	/**
	 * EHQK_SCN을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 EhqkScnVO
	 * @return 조회한 EHQK_SCN
	 * @exception Exception
	 */
	public EhqkScnVO selectEhqkScn(EhqkScnVO vo) throws Exception;

	/**
	 * EHQK_SCN을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 EhqkScnVO List
	 * @return 조회한 EHQK_SCN
	 * @exception Exception
	 */
	public List<EhqkScnVO> selectEhqkScnListByKey(EhqkScnVO ehqkScnVO) throws Exception;

	/**
	 * EHQK_SCN 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return EHQK_SCN 목록
	 * @exception Exception
	 */
	public List selectEhqkScnList(EhqkScnDefaultVO searchVO) throws Exception;

	/**
	 * EHQK_SCN 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return EHQK_SCN 총 갯수
	 * @exception
	 */
	public int selectEhqkScnListTotCnt(EhqkScnDefaultVO searchVO) throws Exception;

	/**
	 * EHQK_SCN 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return EHQK_SCN 목록
	 * @exception Exception
	 */
	public List<EhqkScnVO> selectEhqkScnListByCd(EhqkScnVO searchVO) throws Exception;

}
