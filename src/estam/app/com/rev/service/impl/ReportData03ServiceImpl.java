package estam.app.com.rev.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.com.rev.ConObsMetaVO;
import estam.app.com.rev.service.ReportDataService;
import estam.app.scn.rpt.service.RptFrstEhqkScnService;
import estam.app.scn.rpt.service.RptFrstEhqkScnVO;
import estam.app.scn.rpt.service.RptFrstFreeService;
import estam.app.scn.rpt.service.RptFrstFreeVO;
import estam.app.scn.rpt.service.RptFrstIptnService;
import estam.app.scn.rpt.service.RptFrstIptnVO;
import estam.app.scn.rpt.service.RptFrstItemIptnService;
import estam.app.scn.rpt.service.RptFrstItemIptnVO;
import estam.app.scn.rpt.service.RptFrstRccService;
import estam.app.scn.rpt.service.RptFrstRccVO;

/**
 * @Class Name : ReportData03ServiceImpl.java
 * @Description :
 * @Modification Information
 * 
 * @author kmg
 * @since 2014.02.18
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("reportData03Service")
public class ReportData03ServiceImpl extends AbstractServiceImpl implements ReportDataService {

	@Resource(name = "rptFrstIptnService")
	private RptFrstIptnService rptFrstIptnService;

	@Resource(name = "rptFrstFreeService")
	private RptFrstFreeService rptFrstFreeService;

	@Resource(name = "rptFrstEhqkScnService")
	private RptFrstEhqkScnService rptFrstEhqkScnService;

	@Resource(name = "rptFrstRccService")
	private RptFrstRccService rptFrstRccService;

	@Resource(name = "rptFrstItemIptnService")
	private RptFrstItemIptnService rptFrstItemIptnService;

	/**
	 * 초기점검보고서
	 */
	public void loadReport(List<String[]> strList, ConObsMetaVO conObsMetaVO) throws Exception {

		RptFrstIptnVO rptFrstIptnVO = new RptFrstIptnVO();
		RptFrstFreeVO rptFrstFreeVO = new RptFrstFreeVO();
		RptFrstEhqkScnVO rptFrstEhqkScnVO = new RptFrstEhqkScnVO();
		RptFrstRccVO rptFrstRccVO = new RptFrstRccVO();
		RptFrstItemIptnVO rptFrstItemIptnVO = new RptFrstItemIptnVO();

		List<RptFrstEhqkScnVO> rptFrstEhqkScnList = new ArrayList<RptFrstEhqkScnVO>();
		List<RptFrstRccVO> rptFrstRccList = new ArrayList<RptFrstRccVO>();

		// 연계데이터 구분코드
		rptFrstIptnVO.setConDaGbcd(conObsMetaVO.getConDaGbcd());
		rptFrstFreeVO.setConDaGbcd(conObsMetaVO.getConDaGbcd());
		rptFrstItemIptnVO.setConDaGbcd(conObsMetaVO.getConDaGbcd());
		rptFrstEhqkScnVO.setConDaGbcd(conObsMetaVO.getConDaGbcd());
		rptFrstRccVO.setConDaGbcd(conObsMetaVO.getConDaGbcd());

		for (String[] arr : strList) {

			// 점검일자
			if (StringUtils.equals(arr[0], "rpt_date")) {

				arr[1] = StringUtils.remove(arr[1], "-");
				rptFrstIptnVO.setIptDt(arr[1]);
				rptFrstFreeVO.setIptDt(arr[1]);
				rptFrstEhqkScnVO.setIptDt(arr[1]);
				rptFrstRccVO.setIptDt(arr[1]);
				rptFrstItemIptnVO.setIptDt(arr[1]);

				// 기관코드
			} else if (StringUtils.equals(arr[0], "net")) {

				rptFrstIptnVO.setGvmtCd(arr[1]);
				rptFrstFreeVO.setGvmtCd(arr[1]);
				rptFrstEhqkScnVO.setGvmtCd(arr[1]);
				rptFrstRccVO.setGvmtCd(arr[1]);
				rptFrstItemIptnVO.setGvmtCd(arr[1]);

				// 시설물코드
			} else if (StringUtils.equals(arr[0], "obs_id")) {

				rptFrstIptnVO.setFctyCd(arr[1]);
				rptFrstFreeVO.setFctyCd(arr[1]);
				rptFrstEhqkScnVO.setFctyCd(arr[1]);
				rptFrstRccVO.setFctyCd(arr[1]);
				rptFrstItemIptnVO.setFctyCd(arr[1]);

				// 자유장 가속도계 고유번호
			} else if (StringUtils.equals(arr[0], "f_sen_id")) {

				rptFrstFreeVO.setFreScnId(arr[1]);

				// 자유장_가속도계성분적합여부
			} else if (StringUtils.equals(arr[0], "f_q1")) {

				rptFrstFreeVO.setFreeQst1Yn(arr[1]);

				// 자유장_주파수영역1적합여부
			} else if (StringUtils.equals(arr[0], "f_q2_1")) {

				rptFrstFreeVO.setFreeQst21yn(arr[1]);

				// 자유장_주파수영역2적합여부
			} else if (StringUtils.equals(arr[0], "f_q2_2")) {

				rptFrstFreeVO.setFreeQst22yn(arr[1]);

				// 자유장_동적범위기존설치적합여부
			} else if (StringUtils.equals(arr[0], "f_q3_1")) {

				rptFrstFreeVO.setFreeQst31yn(arr[1]);

				// 자유장_동적범위신규설치적합여부
			} else if (StringUtils.equals(arr[0], "f_q3_2")) {

				rptFrstFreeVO.setFreeQst32yn(arr[1]);

				// 지진가속도계계측센서개수
			} else if (StringUtils.equals(arr[0], "s_sen_count")) {

				rptFrstIptnVO.setEhqkScnCnt(arr[1]);

				// 지진기록계개수
			} else if (StringUtils.equals(arr[0], "r_rec_count")) {

				rptFrstIptnVO.setRccCnt(arr[1]);

				// 지진가속도계설치위치_항목1적합여부
			} else if (StringUtils.equals(arr[0], "r_q9_1")) {

				rptFrstItemIptnVO.setItemQst91yn(arr[1]);

				// 지진가속도계설치위치_항목2적합여부
			} else if (StringUtils.equals(arr[0], "r_q9_2")) {

				rptFrstItemIptnVO.setItemQst92yn(arr[1]);

				// 지진가속도계설치위치_항목3적합여부
			} else if (StringUtils.equals(arr[0], "r_q9_3")) {

				rptFrstItemIptnVO.setItemQst93yn(arr[1]);

				// 지진가속도계설치위치_항목4적합여부
			} else if (StringUtils.equals(arr[0], "r_q9_4")) {

				rptFrstItemIptnVO.setItemQst94yn(arr[1]);

				// 지진가속도계설치위치_항목5적합여부
			} else if (StringUtils.equals(arr[0], "r_q9_5")) {

				rptFrstItemIptnVO.setItemQst95yn(arr[1]);

				// 지진가속도계설치위치_항목6적합여부
			} else if (StringUtils.equals(arr[0], "r_q9_6")) {

				rptFrstItemIptnVO.setItemQst96yn(arr[1]);

				// 지진가속도계설치위치_항목7적합여부
			} else if (StringUtils.equals(arr[0], "r_q9_7")) {

				rptFrstItemIptnVO.setItemQst97yn(arr[1]);

				// 설치상태_항목1적합여부
			} else if (StringUtils.equals(arr[0], "r_q10_1")) {

				rptFrstItemIptnVO.setItemQst101yn(arr[1]);

				// 설치상태_항목2적합여부
			} else if (StringUtils.equals(arr[0], "r_q10_2")) {

				rptFrstItemIptnVO.setItemQst102yn(arr[1]);

				// 설치상태_항목3적합여부
			} else if (StringUtils.equals(arr[0], "r_q10_3")) {

				rptFrstItemIptnVO.setItemQst103yn(arr[1]);

				// 설치상태_항목4적합여부
			} else if (StringUtils.equals(arr[0], "r_q10_4")) {

				rptFrstItemIptnVO.setItemQst104yn(arr[1]);

				// 전원부_항목1적합여부
			} else if (StringUtils.equals(arr[0], "r_q11_1")) {

				rptFrstItemIptnVO.setItemQst111yn(arr[1]);

				// 전원부_항목2적합여부
			} else if (StringUtils.equals(arr[0], "r_q11_2")) {

				rptFrstItemIptnVO.setItemQst112yn(arr[1]);

				// 전원부_항목3적합여부
			} else if (StringUtils.equals(arr[0], "r_q11_3")) {

				rptFrstItemIptnVO.setItemQst113yn(arr[1]);

				// 전원부_항목4적합여부
			} else if (StringUtils.equals(arr[0], "r_q11_4")) {

				rptFrstItemIptnVO.setItemQst114yn(arr[1]);

				// 계측데이터_항목1적합여부
			} else if (StringUtils.equals(arr[0], "r_q12_1")) {

				rptFrstItemIptnVO.setItemQst121yn(arr[1]);

				// 계측데이터_항목2적합여부
			} else if (StringUtils.equals(arr[0], "r_q12_2")) {

				rptFrstItemIptnVO.setItemQst122yn(arr[1]);

				// 초기점검결과내용
			} else if (StringUtils.equals(arr[0], "bigo")) {

				rptFrstIptnVO.setFrstIptnRsltCtnt(arr[1]);

				// 초기점검처리결과내용
			} else if (StringUtils.equals(arr[0], "result")) {

				rptFrstIptnVO.setFrstIptnRsltCtnt(arr[1]);

				// 초기점검담당부서
			} else if (StringUtils.equals(arr[0], "user_dept")) {

				rptFrstIptnVO.setFrstIptnUsrDept(arr[1]);

				// 초기점검직책
			} else if (StringUtils.equals(arr[0], "user_duty")) {

				rptFrstIptnVO.setFrstIptnUsrDuty(arr[1]);

				// 초기점검담당자성명
			} else if (StringUtils.equals(arr[0], "user_name")) {

				rptFrstIptnVO.setFrstIptnUsrNm(arr[1]);

				// 초기점검담당자연락처
			} else if (StringUtils.equals(arr[0], "user_tel")) {

				rptFrstIptnVO.setFrstIptnUsrTel(arr[1]);
			}

		}

		/** 시설물 지진가속도계 **/
		for (int i = 1; i <= Integer.parseInt(rptFrstIptnVO.getEhqkScnCnt()); i++) {

			RptFrstEhqkScnVO rfesVo = new RptFrstEhqkScnVO();
			rfesVo.setIptDt(rptFrstEhqkScnVO.getIptDt());
			rfesVo.setGvmtCd(rptFrstEhqkScnVO.getGvmtCd());
			rfesVo.setFctyCd(rptFrstEhqkScnVO.getFctyCd());
			rfesVo.setConDaGbcd(rptFrstEhqkScnVO.getConDaGbcd());

			for (String[] arr : strList) {

				// 지진 가속도계 고유번호
				if (StringUtils.equals(arr[0], "s(" + i + ")_sen_id")) {

					rfesVo.setEhqkScnId(arr[1]);

					// 가속도계성분수평1성분적합여부
				} else if (StringUtils.equals(arr[0], "s(" + i + ")_q1_1")) {

					rfesVo.setScnQst11yn(arr[1]);

					// 가속도계성분수평2성분적합여부
				} else if (StringUtils.equals(arr[0], "s(" + i + ")_q1_2")) {

					rfesVo.setScnQst12yn(arr[1]);

					// 가속도계성분연직1수평2적합여부
				} else if (StringUtils.equals(arr[0], "s(" + i + ")_q1_3")) {

					rfesVo.setScnQst13yn(arr[1]);

					// 가속도계주파수영역1적합여부
				} else if (StringUtils.equals(arr[0], "s(" + i + ")_q2_1")) {

					rfesVo.setScnQst21yn(arr[1]);

					// 가속도계주파수영역2적합여부
				} else if (StringUtils.equals(arr[0], "s(" + i + ")_q2_2")) {

					rfesVo.setScnQst22yn(arr[1]);

					// 가속도계_동적범위기존설치적합여부
				} else if (StringUtils.equals(arr[0], "s(" + i + ")_q3_1")) {

					rfesVo.setScnQst31yn(arr[1]);

					// 가속도계_동적범위신규설치적합여부
				} else if (StringUtils.equals(arr[0], "s(" + i + ")_q3_2")) {

					rfesVo.setScnQst32yn(arr[1]);
				}

			}
			rptFrstEhqkScnList.add(rfesVo);

		}

		/** 기록계 **/
		for (int i = 1; i <= Integer.parseInt(rptFrstIptnVO.getRccCnt()); i++) {

			RptFrstRccVO rfrVo = new RptFrstRccVO();
			rfrVo.setIptDt(rptFrstRccVO.getIptDt());
			rfrVo.setGvmtCd(rptFrstRccVO.getGvmtCd());
			rfrVo.setFctyCd(rptFrstRccVO.getFctyCd());
			rfrVo.setConDaGbcd(rptFrstRccVO.getConDaGbcd());

			for (String[] arr : strList) {

				// 지진계록계 고유번호
				if (StringUtils.equals(arr[0], "r(" + i + ")_rec_id")) {

					rfrVo.setEhqkRccId(arr[1]);

					// 기록계_동적범위기존설치적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q1_1")) {

					rfrVo.setRccQst11yn(arr[1]);

					// 기록계_동적범위신규설치적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q1_2")) {

					rfrVo.setRccQst12yn(arr[1]);

					// 기록계_자유장_채널수적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q2_1")) {

					rfrVo.setRccQst21yn(arr[1]);

					// 기록계_시설물_채널수적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q2_2")) {

					rfrVo.setRccQst22yn(arr[1]);

					// 기록계_트리거방법적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q3_1")) {

					rfrVo.setRccQst31yn(arr[1]);

					// 기록계_트리거변경기능적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q3_2")) {

					rfrVo.setRccQst32yn(arr[1]);

					// 기록계_자료취득횟수100적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q4_1")) {

					rfrVo.setRccQst41yn(arr[1]);

					// 기록계_자료취득횟수20적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q4_2")) {

					rfrVo.setRccQst42yn(arr[1]);

					// 기록계_자료취득횟수MMA적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q4_3")) {

					rfrVo.setRccQst43yn(arr[1]);

					// 기록계_기록형식100적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q5_1")) {

					rfrVo.setRccQst51yn(arr[1]);

					// 기록계_기록형식20적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q5_2")) {

					rfrVo.setRccQst52yn(arr[1]);

					// 기록계_기록형식MMA적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q5_3")) {

					rfrVo.setRccQst53yn(arr[1]);

					// 기록계_자료기록전30적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q6_1")) {

					rfrVo.setRccQst61yn(arr[1]);

					// 기록계_자료기록후60적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q6_2")) {

					rfrVo.setRccQst62yn(arr[1]);

					// 기록계_최대시각오차적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q7")) {

					rfrVo.setRccQst7Yn(arr[1]);

					// 기록계_자료전속방법적합여부
				} else if (StringUtils.equals(arr[0], "r(" + i + ")_q8")) {

					rfrVo.setRccQst8Yn(arr[1]);

				}

			}
			rptFrstRccList.add(rfrVo);
		}

		// 보고서_초기점검
		rptFrstIptnService.insertRptFrstIptn(rptFrstIptnVO);

		// 보고서_초기_자유장
		rptFrstFreeService.insertRptFrstFree(rptFrstFreeVO);

		// 보고서_초기_항목점검
		rptFrstItemIptnService.insertRptFrstItemIptn(rptFrstItemIptnVO);

		// 보고서_초기_가속도계
		for (RptFrstEhqkScnVO vo : rptFrstEhqkScnList) {

			rptFrstEhqkScnService.insertRptFrstEhqkScn(vo);
		}
		// 보고서_초기_기록계
		for (RptFrstRccVO vo : rptFrstRccList) {

			rptFrstRccService.insertRptFrstRcc(vo);

		}

	}

}
