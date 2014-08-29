package estam.app.com.rev.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.com.rev.ConObsMetaVO;
import estam.app.com.rev.service.ReportDataService;
import estam.app.fcty.service.EhqkScnService;
import estam.app.fcty.service.EhqkScnVO;
import estam.app.fcty.service.FctyMgrService;
import estam.app.fcty.service.FctyMgrUsrService;
import estam.app.fcty.service.FctyMgrUsrVO;
import estam.app.fcty.service.FctyMgrVO;
import estam.app.fcty.service.RccService;
import estam.app.fcty.service.RccVO;
import estam.app.scn.rpt.service.RptMgrEhqkScnService;
import estam.app.scn.rpt.service.RptMgrEhqkScnVO;
import estam.app.scn.rpt.service.RptMgrRccService;
import estam.app.scn.rpt.service.RptMgrRccVO;
import estam.app.scn.rpt.service.RptMgrService;
import estam.app.scn.rpt.service.RptMgrVO;

/**
 * @Class Name : ReportData02ServiceImpl.java
 * @Description :
 * @Modification Information
 * 
 * @author kmg
 * @since 2014.02.14
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("reportData02Service")
public class ReportData02ServiceImpl extends AbstractServiceImpl implements ReportDataService {

	@Resource(name = "rptMgrService")
	private RptMgrService rptMgrService;

	@Resource(name = "fctyMgrService")
	private FctyMgrService fctyMgrService;

	@Resource(name = "fctyMgrUsrService")
	private FctyMgrUsrService fctyMgrUsrService;

	@Resource(name = "rptMgrEhqkScnService")
	private RptMgrEhqkScnService rptMgrEhqkScnService;

	@Resource(name = "rptMgrRccService")
	private RptMgrRccService rptMgrRccService;

	@Resource(name = "ehqkScnService")
	private EhqkScnService ehqkScnService;

	@Resource(name = "rccService")
	private RccService rccService;

	/**
	 * 관리대장, 시설물 관리 및 시설물 기록계/가속도계 정보 - 정보가 있으면 update 없으면 insert 필요
	 */
	public void loadReport(List<String[]> strList, ConObsMetaVO conObsMetaVO) throws Exception {

		RptMgrVO rptMgrVO = new RptMgrVO();
		RptMgrEhqkScnVO rptMgrEhqkScnVO = new RptMgrEhqkScnVO();
		RptMgrRccVO rptMgrRccVO = new RptMgrRccVO();
		FctyMgrVO fctyMgrVO = new FctyMgrVO();
		FctyMgrUsrVO fctyMgrUsrVO = new FctyMgrUsrVO();
		EhqkScnVO ehqkScnVO = new EhqkScnVO();
		RccVO rccVO = new RccVO();

		List<EhqkScnVO> ehqkScnVOList = new ArrayList<EhqkScnVO>();
		List<RptMgrEhqkScnVO> rmesvList = new ArrayList<RptMgrEhqkScnVO>();
		List<RptMgrRccVO> rptMgrRccVOList = new ArrayList<RptMgrRccVO>();
		List<RccVO> rccVOList = new ArrayList<RccVO>();

		// 연계데이터 구분코드
		rptMgrVO.setConDaGbcd(conObsMetaVO.getConDaGbcd());
		rptMgrEhqkScnVO.setConDaGbcd(conObsMetaVO.getConDaGbcd());
		rptMgrRccVO.setConDaGbcd(conObsMetaVO.getConDaGbcd());

		for (String[] arr : strList) {

			// 점검일자
			if (StringUtils.equals(arr[0], "rpt_date")) {

				arr[1] = StringUtils.remove(arr[1], "-");
				rptMgrVO.setIptDt(arr[1]);
				rptMgrEhqkScnVO.setIptDt(arr[1]);
				rptMgrRccVO.setIptDt(arr[1]);

				// 기관코드
			} else if (StringUtils.equals(arr[0], "net")) {

				rptMgrVO.setGvmtCd(arr[1]);
				rptMgrEhqkScnVO.setGvmtCd(arr[1]);
				rptMgrRccVO.setGvmtCd(arr[1]);

				fctyMgrVO.setGvmtCd(arr[1]);
				fctyMgrUsrVO.setGvmtCd(arr[1]);
				ehqkScnVO.setGvmtCd(arr[1]);
				rccVO.setGvmtCd(arr[1]);

				// 계측소코드
			} else if (StringUtils.equals(arr[0], "obs_id")) {

				rptMgrVO.setFctyCd(arr[1]);
				rptMgrEhqkScnVO.setFctyCd(arr[1]);
				rptMgrRccVO.setFctyCd(arr[1]);

				fctyMgrVO.setFctyCd(arr[1]);
				fctyMgrUsrVO.setFctyCd(arr[1]);
				ehqkScnVO.setFctyCd(arr[1]);
				rccVO.setFctyCd(arr[1]);

				// 계측소명
			} else if (StringUtils.equals(arr[0], "obs_name")) {

				rptMgrVO.setObsName(arr[1]);
				fctyMgrVO.setFctyNm(arr[1]);

				// 계측시작일자
			} else if (StringUtils.equals(arr[0], "opendate")) {

				arr[1] = StringUtils.remove(arr[1], "-");
				rptMgrVO.setOpenDate(arr[1]);
				fctyMgrVO.setFctyEsmtStdt(arr[1]);

				// 계측종료일자
			} else if (StringUtils.equals(arr[0], "offdate")) {

				arr[1] = StringUtils.remove(arr[1], "-");
				rptMgrVO.setOffDate(arr[1]);
				fctyMgrVO.setFctyEsmtEddt(arr[1]);

				// 시설물행정구역코드
			} else if (StringUtils.equals(arr[0], "area")) {

				rptMgrVO.setFctyAreaCd(arr[1]);
				fctyMgrVO.setFctyAreaCd(arr[1]);

				// 시설물 위치
			} else if (StringUtils.equals(arr[0], "address")) {

				rptMgrVO.setFctyAddr(arr[1]);
				fctyMgrVO.setFctyEdAddr(arr[1]);

				// 시설물 종류
			} else if (StringUtils.equals(arr[0], "obs_kind")) {

				rptMgrVO.setFctyKndCd(arr[1]);
				fctyMgrVO.setFctyKndCd(arr[1]);

				// 계측기 위치(서술형)
			} else if (StringUtils.equals(arr[0], "position")) {

				rptMgrVO.setMechPotn(arr[1]);

				// 경도
			} else if (StringUtils.equals(arr[0], "lon")) {

				rptMgrVO.setFctyLon(arr[1]);
				fctyMgrVO.setFctyLon(arr[1]);

				// 위도
			} else if (StringUtils.equals(arr[0], "lat")) {

				rptMgrVO.setFctyLat(arr[1]);
				fctyMgrVO.setFctyLat(arr[1]);

				// 표고
			} else if (StringUtils.equals(arr[0], "altitude")) {

				rptMgrVO.setFctyAttc(arr[1]);
				fctyMgrVO.setFctyAttc(arr[1]);

				// 지상 높이(m)
			} else if (StringUtils.equals(arr[0], "ground_ht")) {

				rptMgrVO.setFctyGrndHt(arr[1]);
				fctyMgrVO.setFctyGrndHt(new BigDecimal(StringUtils.defaultIfEmpty(arr[1], "0")));

				// 지하 높이(m)
			} else if (StringUtils.equals(arr[0], "uground_ht")) {

				rptMgrVO.setFctyUgrdHt(arr[1]);
				fctyMgrVO.setFctyUgrdHt(new BigDecimal(StringUtils.defaultIfEmpty(arr[1], "0")));

				// 기초 형식
			} else if (StringUtils.equals(arr[0], "base")) {

				rptMgrVO.setFctyBasc(arr[1]);
				fctyMgrVO.setFctyBasc(arr[1]);

				// 구조물형식
			} else if (StringUtils.equals(arr[0], "str_cd")) {

				rptMgrVO.setStrcFrmCd(arr[1]);
				fctyMgrVO.setFctyGrndCd(arr[1]);

				// 설계기준
			} else if (StringUtils.equals(arr[0], "seis_cd")) {

				rptMgrVO.setSeisCd(arr[1]);
				fctyMgrVO.setSeisCd(arr[1]);

				// 지반분류
			} else if (StringUtils.equals(arr[0], "ground")) {

				rptMgrVO.setFctyGrndCd(arr[1]);

				// 주상도 여부
			} else if (StringUtils.equals(arr[0], "hole")) {

				rptMgrVO.setFctyHolcYn(arr[1]);
				fctyMgrVO.setFctyHolcYn(arr[1]);

				// 전단파속도 주상도 또는 시추주상도 이미지명
			} else if (StringUtils.equals(arr[0], "hole_map")) {

				// 설치 업체명
			} else if (StringUtils.equals(arr[0], "charge")) {

				rptMgrVO.setFctyChgeNm(arr[1]);
				fctyMgrUsrVO.setIstlDept(arr[1]);

				// 설치업체 연락처
			} else if (StringUtils.equals(arr[0], "contact")) {

				rptMgrVO.setFctyCottTel(arr[1]);
				fctyMgrUsrVO.setIstlUsrTel(arr[1]);

				// 지진가속도계 개수
			} else if (StringUtils.equals(arr[0], "sen_count")) {

				rptMgrVO.setEhqkScnCnt(new BigDecimal(arr[1]));

				// 기록계 개수
			} else if (StringUtils.equals(arr[0], "rec_count")) {

				rptMgrVO.setRccCnt(new BigDecimal(arr[1]));

			}

		}

		/** 지진가속도계 **/
		for (int i = 1; i <= rptMgrVO.getEhqkScnCnt().intValue(); i++) {

			RptMgrEhqkScnVO rmesVo = new RptMgrEhqkScnVO();
			rmesVo.setIptDt(rptMgrEhqkScnVO.getIptDt());
			rmesVo.setGvmtCd(rptMgrEhqkScnVO.getGvmtCd());
			rmesVo.setFctyCd(rptMgrEhqkScnVO.getFctyCd());
			rmesVo.setConDaGbcd(rptMgrEhqkScnVO.getConDaGbcd());

			EhqkScnVO esVO = new EhqkScnVO();
			esVO.setGvmtCd(ehqkScnVO.getGvmtCd());
			esVO.setFctyCd(ehqkScnVO.getFctyCd());

			for (String[] arr : strList) {

				// 지진가속도계 고유번호
				if (StringUtils.equals(arr[0], "sen(" + i + ")_id")) {

					rmesVo.setEhqkScnId(arr[1]);
					esVO.setEhqkScnId(arr[1]);

					// 제작사
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_company")) {

					rmesVo.setEhqkScnCmpy(arr[1]);
					esVO.setEhqkScnCmpy(arr[1]);

					// 모델명
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_model")) {

					rmesVo.setEhqkScnMdl(arr[1]);
					esVO.setEhqkScnMdl(arr[1]);

					// 일련번호
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_serial_no")) {

					rmesVo.setEhqkScnSrlNo(arr[1]);
					esVO.setEhqkScnNo(arr[1]);

					// 가속도계분류
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_kind")) {

					rmesVo.setEhqkScnKndCd(arr[1]);
					esVO.setEhqkScnKndCd(arr[1]);

					// 계측용도구분
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_gubun")) {

					rmesVo.setEhqkScnGbnCd(arr[1]);
					esVO.setEhqkScnMeasCd(arr[1]);

					// 설치 층수 및 위치
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_position")) {

					rmesVo.setEhqkScnPstn(arr[1]);
					esVO.setEhqkScnPstn(arr[1]);

					// 계측 채널 성분(ZNE)
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_channel")) {

					rmesVo.setEhqkScnChlVal(arr[1]);
					esVO.setEhqkScnChlVal(arr[1]);

					// 경도
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_lon")) {

					rmesVo.setEhqkScnLon(arr[1]);
					esVO.setEhqkScnLon(arr[1]);

					// 위도
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_lat")) {

					rmesVo.setEhqkScnLat(arr[1]);
					esVO.setEhqkScnLat(arr[1]);

					// 지진가속도계 상하성분 Acceleration Response
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_z_response")) {

					rmesVo.setEhqkScnZRes(arr[1]);
					esVO.setEhqkScnZRes(arr[1]);

					// 지진가속도계 남북성분 Acceleration Response
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_n_response")) {

					rmesVo.setEhqkScnNRes(arr[1]);
					esVO.setEhqkScnNRes(arr[1]);

					// 지진가속도계 동서성분 Acceleration Response
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_e_response")) {

					rmesVo.setEhqkScnERes(arr[1]);
					esVO.setEhqkScnERes(arr[1]);

					// 기록계 상하성분 Sensitivity
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_z_sensitivity")) {

					rmesVo.setRccZSeni(arr[1]);
					esVO.setEhqkScnZSen(arr[1]);
					// rccVO.setRccZSeni(arr[1]);

					// 기록계 남북성분 Sensitivity
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_n_sensitivity")) {

					rmesVo.setRccNSeni(arr[1]);
					esVO.setEhqkScnNSen(arr[1]);
					// rccVO.setRccNSeni(arr[1]);

					// 기록계 동서성분 Sensitivity
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_e_sensitivity")) {

					rmesVo.setRccESeni(arr[1]);
					esVO.setEhqkScnESen(arr[1]);
					// rccVO.setRccESeni(arr[1]);

					// 기록계 고유번호
				} else if (StringUtils.equals(arr[0], "sen(" + i + ")_rec_id")) {

					rmesVo.setConRccId(arr[1]);
					esVO.setRccId(arr[1]);
				}
			}

			rmesvList.add(rmesVo);
			ehqkScnVOList.add(esVO);
		}

		/** 기록계 **/
		for (int i = 1; i <= rptMgrVO.getRccCnt().intValue(); i++) {

			RptMgrRccVO rmrVo = new RptMgrRccVO();
			rmrVo.setIptDt(rptMgrRccVO.getIptDt());
			rmrVo.setGvmtCd(rptMgrRccVO.getGvmtCd());
			rmrVo.setFctyCd(rptMgrRccVO.getFctyCd());
			rmrVo.setConDaGbcd(rptMgrRccVO.getConDaGbcd());

			RccVO rVo = new RccVO();
			rVo.setGvmtCd(rccVO.getGvmtCd());
			rVo.setFctyCd(rccVO.getFctyCd());

			for (String[] arr : strList) {

				// 기록계 고유번호
				if (StringUtils.equals(arr[0], "rec(" + i + ")_id")) {

					rmrVo.setRccId(arr[1]);
					rVo.setRccId(arr[1]);

					// 기록계 제작사
				} else if (StringUtils.equals(arr[0], "rec(" + i + ")_company")) {

					rmrVo.setRccCmpy(arr[1]);
					rVo.setRccCmpy(arr[1]);

					// 기록계 모델명
				} else if (StringUtils.equals(arr[0], "rec(" + i + ")_model")) {

					rmrVo.setRccMdl(arr[1]);
					rVo.setRccMdl(arr[1]);

					// 기록계 일련번호
				} else if (StringUtils.equals(arr[0], "rec(" + i + ")_serial_no")) {

					rmrVo.setRccSrlNo(arr[1]);
					rVo.setRccSrlNo(arr[1]);

					// 기록계 품질 보증기간
				} else if (StringUtils.equals(arr[0], "rec(" + i + ")_warranty")) {

					arr[1] = StringUtils.remove(arr[1], "-");
					rmrVo.setRccWrry(arr[1]);
					rVo.setRccWrry(arr[1]);

					// 기록저장방식
				} else if (StringUtils.equals(arr[0], "rec(" + i + ")_wformat")) {

					rmrVo.setRccWfmt(arr[1]);
					rVo.setRccWfmt(arr[1]);

					// 전송방식
				} else if (StringUtils.equals(arr[0], "rec(" + i + ")_protocol")) {

					rmrVo.setRccPotl(arr[1]);
					rVo.setRccPotl(arr[1]);
				}
			}
			rptMgrRccVOList.add(rmrVo);
			rccVOList.add(rVo);
		}

		// 시설물
		fctyMgrService.insertFctyMgr(fctyMgrVO);

		// 시설물 관리정보
		fctyMgrUsrService.insertFctyMgrUsr(fctyMgrUsrVO);

		// 기록계
		for (RccVO vo : rccVOList) {

			rccService.insertRcc(vo);
		}
		// 지진가속도계
		for (EhqkScnVO vo : ehqkScnVOList) {

			ehqkScnService.insertEhqkScn(vo);
		}
		// 보고서 관리대장
		rptMgrService.insertRptMgr(rptMgrVO);

		// 보고서 가속도계
		for (RptMgrEhqkScnVO vo : rmesvList) {

			rptMgrEhqkScnService.insertRptMgrEhqkScn(vo);
		}
		// 보고서 기록계
		for (RptMgrRccVO vo : rptMgrRccVOList) {

			rptMgrRccService.insertRptMgrRcc(vo);
		}
	}
}
