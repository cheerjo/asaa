package estam.app.iddl.service;

/**
 * @Class Name : IddlAassInfoVO.java
 * @Description : IddlAassInfo VO class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public class IddlAassInfoVO extends IddlAassInfoDefaultVO {
	private static final long serialVersionUID = 1L;

	/** FCTY_CD */
	private java.lang.String fctyCd;

	/** FCTY_NM */
	private java.lang.String fctyNm;

	/** IDDL_AASS_NO */
	private java.math.BigDecimal iddlAassNo;

	/** IDDL_AASS_DT */
	private java.lang.String iddlAassDt;

	/** EHQK_OTN */
	private java.lang.String ehqkOtn;

	/** WV_SCN_EXT_FLSV */
	private java.lang.String wvScnExtFlsv;

	/** WV_SCN_EXT_FLNM */
	private java.lang.String wvScnExtFlnm;

	/** WV_SCN_EXT_FLDT */
	private java.lang.String wvScnExtFldt;

	/** MONI_FREE_NRFY */
	private java.math.BigDecimal moniFreeNrfy;

	/** MONI_MJ_NRFY */
	private java.math.BigDecimal moniMjNrfy;

	/** MONI_SHOT_NRFY */
	private java.math.BigDecimal moniShotNrfy;

	/** EHQK_REQ_ID */
	private java.lang.String ehqkReqId;

	/** WV_SCN_RSLT_FLSV */
	private java.lang.String wvScnRsltFlsv;

	/** INPT_USR_ID */
	private java.lang.String inptUsrId;

	/** INPT_DT */
	private java.sql.Date inptDt;

	/** UPDT_USR_ID */
	private java.lang.String updtUsrId;

	/** UPDT_DT */
	private java.sql.Date updtDt;

	/** EHQK_TRAN_GBCD */
	private java.lang.String ehqkTranGbcd;

	/** 파일로 내려받기 */
	private java.lang.String seedFilePath;
	private java.lang.String seedDestPath;

	private java.lang.String sensorLocationFreeX;
	private java.lang.String sensorLocationFreeY;
	private java.lang.String sensorLocationFreeZ;
	private java.lang.String sensorLocationBotX;
	private java.lang.String sensorLocationBotY;
	private java.lang.String sensorLocationBotZ;
	private java.lang.String sensorLocationMidX;
	private java.lang.String sensorLocationMidY1;
	private java.lang.String sensorLocationMidY2;
	private java.lang.String sensorLocationTopX;
	private java.lang.String sensorLocationTopY1;
	private java.lang.String sensorLocationTopY2;

	private java.math.BigDecimal sensorFilteringFreeX;
	private java.math.BigDecimal sensorFilteringFreeY;
	private java.math.BigDecimal sensorFilteringFreeZ;
	private java.math.BigDecimal sensorFilteringBotX;
	private java.math.BigDecimal sensorFilteringBotY;
	private java.math.BigDecimal sensorFilteringBotZ;
	private java.math.BigDecimal sensorFilteringMidX;
	private java.math.BigDecimal sensorFilteringMidY1;
	private java.math.BigDecimal sensorFilteringMidY2;
	private java.math.BigDecimal sensorFilteringTopX;
	private java.math.BigDecimal sensorFilteringTopY1;
	private java.math.BigDecimal sensorFilteringTopY2;
	private java.math.BigDecimal analyOption_idrAmp;
	private java.math.BigDecimal analyOptionStrHeight;
	private java.math.BigDecimal analyOptionSeismicArea;
	private java.math.BigDecimal analyOptionStrType;

	private java.lang.String analyOptionStrName;

	private java.math.BigDecimal analyOptionStrFreqWindow;
	private java.math.BigDecimal analyOptionStrFreqWindow_move;
	private java.math.BigDecimal analyOptionLimitStateMean;
	private java.math.BigDecimal analyOptionLimitStateDev;
	private java.math.BigDecimal analyOptionFreqPrevX;
	private java.math.BigDecimal analyOptionFreqPrevY;
	private java.math.BigDecimal safeIdrRangeSmf;
	private java.math.BigDecimal safeIdrRangeSef;
	private java.math.BigDecimal safeIdrRangeRcf;
	private java.math.BigDecimal safeIdrRangeRcsw;
	private java.math.BigDecimal safeNatFreqRange;
	private java.math.BigDecimal safeStrFreeNatFreqRange;
	private java.math.BigDecimal safeOverAccRange;

	/** Oupput */
	private java.math.BigDecimal resultMaxIdrX;
	private java.math.BigDecimal resultMaxIdrY;
	private java.math.BigDecimal resultOverAccX;
	private java.math.BigDecimal resultOverAccY;
	private java.math.BigDecimal resultNatFreqMoveX;
	private java.math.BigDecimal resultNatFreqMoveY;
	private java.math.BigDecimal resultStrFreeNatFreqX;
	private java.math.BigDecimal resultStrFreeNatFreqY;
	private java.lang.String safeCheckMaxIdrX;
	private java.lang.String safeCheckMaxIdrY;
	private java.lang.String safeCheckNatFreqMoveX;
	private java.lang.String safeCheckNatFreqMoveY;
	private java.lang.String safeCheckStrFreeNatFreqX;
	private java.lang.String safeCheckStrFreeNatFreqY;
	private java.lang.String safeCheckOverAccX;
	private java.lang.String safeCheckOverAccY;
	private java.math.BigDecimal dataFreeMaxDispX;
	private java.math.BigDecimal dataFreeMaxDispY;
	private java.math.BigDecimal dataTopRelMaxSpeedX;
	private java.math.BigDecimal dataTopRelMaxSpeedY;
	private java.math.BigDecimal dataTopRelMaxDispX;
	private java.math.BigDecimal dataTopRelMaxDispY;
	private java.math.BigDecimal dataFreeAcc;
	private java.math.BigDecimal dataFreeVel;
	private java.math.BigDecimal dataFreeDisp;
	private java.math.BigDecimal dataStrBotAcc;
	private java.math.BigDecimal dataStrBotVel;
	private java.math.BigDecimal dataStrBotDisp;
	private java.math.BigDecimal dataStrMidAcc;
	private java.math.BigDecimal dataStrTopAcc;
	private java.math.BigDecimal dataStrFreq;
	private java.math.BigDecimal dataFreeFreq;
	private java.math.BigDecimal designAcc;

	private java.lang.String ehqkAreaCd;
	private java.lang.String fctyStrTycd;
	private java.lang.String fctyHt;

	private java.lang.String searchStartDt;
	private java.lang.String searchEndDt;

	public java.lang.String getEhqkAreaCd() {
		return ehqkAreaCd;
	}

	public void setEhqkAreaCd(java.lang.String ehqkAreaCd) {
		this.ehqkAreaCd = ehqkAreaCd;
	}

	public java.lang.String getFctyStrTycd() {
		return fctyStrTycd;
	}

	public void setFctyStrTycd(java.lang.String fctyStrTycd) {
		this.fctyStrTycd = fctyStrTycd;
	}

	public java.lang.String getFctyHt() {
		return fctyHt;
	}

	public void setFctyHt(java.lang.String fctyHt) {
		this.fctyHt = fctyHt;
	}

	public java.lang.String getFctyCd() {
		return fctyCd;
	}

	public void setFctyCd(java.lang.String fctyCd) {
		this.fctyCd = fctyCd;
	}

	public java.lang.String getFctyNm() {
		return fctyNm;
	}

	public void setFctyNm(java.lang.String fctyNm) {
		this.fctyNm = fctyNm;
	}

	public java.math.BigDecimal getIddlAassNo() {
		return iddlAassNo;
	}

	public void setIddlAassNo(java.math.BigDecimal iddlAassNo) {
		this.iddlAassNo = iddlAassNo;
	}

	public java.lang.String getIddlAassDt() {
		return iddlAassDt;
	}

	public void setIddlAassDt(java.lang.String iddlAassDt) {
		this.iddlAassDt = iddlAassDt;
	}

	public java.lang.String getEhqkOtn() {
		return ehqkOtn;
	}

	public void setEhqkOtn(java.lang.String ehqkOtn) {
		this.ehqkOtn = ehqkOtn;
	}

	public java.lang.String getWvScnExtFlsv() {
		return wvScnExtFlsv;
	}

	public void setWvScnExtFlsv(java.lang.String wvScnExtFlsv) {
		this.wvScnExtFlsv = wvScnExtFlsv;
	}

	public java.lang.String getWvScnExtFlnm() {
		return wvScnExtFlnm;
	}

	public void setWvScnExtFlnm(java.lang.String wvScnExtFlnm) {
		this.wvScnExtFlnm = wvScnExtFlnm;
	}

	public java.lang.String getWvScnExtFldt() {
		return wvScnExtFldt;
	}

	public void setWvScnExtFldt(java.lang.String wvScnExtFldt) {
		this.wvScnExtFldt = wvScnExtFldt;
	}

	public java.math.BigDecimal getMoniFreeNrfy() {
		return moniFreeNrfy;
	}

	public void setMoniFreeNrfy(java.math.BigDecimal moniFreeNrfy) {
		this.moniFreeNrfy = moniFreeNrfy;
	}

	public java.math.BigDecimal getMoniMjNrfy() {
		return moniMjNrfy;
	}

	public void setMoniMjNrfy(java.math.BigDecimal moniMjNrfy) {
		this.moniMjNrfy = moniMjNrfy;
	}

	public java.math.BigDecimal getMoniShotNrfy() {
		return moniShotNrfy;
	}

	public void setMoniShotNrfy(java.math.BigDecimal moniShotNrfy) {
		this.moniShotNrfy = moniShotNrfy;
	}

	public java.lang.String getEhqkReqId() {
		return ehqkReqId;
	}

	public void setEhqkReqId(java.lang.String ehqkReqId) {
		this.ehqkReqId = ehqkReqId;
	}

	public java.lang.String getWvScnRsltFlsv() {
		return wvScnRsltFlsv;
	}

	public void setWvScnRsltFlsv(java.lang.String wvScnRsltFlsv) {
		this.wvScnRsltFlsv = wvScnRsltFlsv;
	}

	public java.lang.String getInptUsrId() {
		return inptUsrId;
	}

	public void setInptUsrId(java.lang.String inptUsrId) {
		this.inptUsrId = inptUsrId;
	}

	public java.sql.Date getInptDt() {
		return inptDt;
	}

	public void setInptDt(java.sql.Date inptDt) {
		this.inptDt = inptDt;
	}

	public java.lang.String getUpdtUsrId() {
		return updtUsrId;
	}

	public void setUpdtUsrId(java.lang.String updtUsrId) {
		this.updtUsrId = updtUsrId;
	}

	public java.sql.Date getUpdtDt() {
		return updtDt;
	}

	public void setUpdtDt(java.sql.Date updtDt) {
		this.updtDt = updtDt;
	}

	public java.lang.String getEhqkTranGbcd() {
		return ehqkTranGbcd;
	}

	public void setEhqkTranGbcd(java.lang.String ehqkTranGbcd) {
		this.ehqkTranGbcd = ehqkTranGbcd;
	}

	public java.lang.String getSeedFilePath() {
		return seedFilePath;
	}

	public void setSeedFilePath(java.lang.String seedFilePath) {
		this.seedFilePath = seedFilePath;
	}

	public java.lang.String getSeedDestPath() {
		return seedDestPath;
	}

	public void setSeedDestPath(java.lang.String seedDestPath) {
		this.seedDestPath = seedDestPath;
	}

	public java.lang.String getSensorLocationFreeX() {
		return sensorLocationFreeX;
	}

	public void setSensorLocationFreeX(java.lang.String sensorLocationFreeX) {
		this.sensorLocationFreeX = sensorLocationFreeX;
	}

	public java.lang.String getSensorLocationFreeY() {
		return sensorLocationFreeY;
	}

	public void setSensorLocationFreeY(java.lang.String sensorLocationFreeY) {
		this.sensorLocationFreeY = sensorLocationFreeY;
	}

	public java.lang.String getSensorLocationFreeZ() {
		return sensorLocationFreeZ;
	}

	public void setSensorLocationFreeZ(java.lang.String sensorLocationFreeZ) {
		this.sensorLocationFreeZ = sensorLocationFreeZ;
	}

	public java.lang.String getSensorLocationBotX() {
		return sensorLocationBotX;
	}

	public void setSensorLocationBotX(java.lang.String sensorLocationBotX) {
		this.sensorLocationBotX = sensorLocationBotX;
	}

	public java.lang.String getSensorLocationBotY() {
		return sensorLocationBotY;
	}

	public void setSensorLocationBotY(java.lang.String sensorLocationBotY) {
		this.sensorLocationBotY = sensorLocationBotY;
	}

	public java.lang.String getSensorLocationBotZ() {
		return sensorLocationBotZ;
	}

	public void setSensorLocationBotZ(java.lang.String sensorLocationBotZ) {
		this.sensorLocationBotZ = sensorLocationBotZ;
	}

	public java.lang.String getSensorLocationMidX() {
		return sensorLocationMidX;
	}

	public void setSensorLocationMidX(java.lang.String sensorLocationMidX) {
		this.sensorLocationMidX = sensorLocationMidX;
	}

	public java.lang.String getSensorLocationMidY1() {
		return sensorLocationMidY1;
	}

	public void setSensorLocationMidY1(java.lang.String sensorLocationMidY1) {
		this.sensorLocationMidY1 = sensorLocationMidY1;
	}

	public java.lang.String getSensorLocationMidY2() {
		return sensorLocationMidY2;
	}

	public void setSensorLocationMidY2(java.lang.String sensorLocationMidY2) {
		this.sensorLocationMidY2 = sensorLocationMidY2;
	}

	public java.lang.String getSensorLocationTopX() {
		return sensorLocationTopX;
	}

	public void setSensorLocationTopX(java.lang.String sensorLocationTopX) {
		this.sensorLocationTopX = sensorLocationTopX;
	}

	public java.lang.String getSensorLocationTopY1() {
		return sensorLocationTopY1;
	}

	public void setSensorLocationTopY1(java.lang.String sensorLocationTopY1) {
		this.sensorLocationTopY1 = sensorLocationTopY1;
	}

	public java.lang.String getSensorLocationTopY2() {
		return sensorLocationTopY2;
	}

	public void setSensorLocationTopY2(java.lang.String sensorLocationTopY2) {
		this.sensorLocationTopY2 = sensorLocationTopY2;
	}

	public java.math.BigDecimal getSensorFilteringFreeX() {
		return sensorFilteringFreeX;
	}

	public void setSensorFilteringFreeX(java.math.BigDecimal sensorFilteringFreeX) {
		this.sensorFilteringFreeX = sensorFilteringFreeX;
	}

	public java.math.BigDecimal getSensorFilteringFreeY() {
		return sensorFilteringFreeY;
	}

	public void setSensorFilteringFreeY(java.math.BigDecimal sensorFilteringFreeY) {
		this.sensorFilteringFreeY = sensorFilteringFreeY;
	}

	public java.math.BigDecimal getSensorFilteringFreeZ() {
		return sensorFilteringFreeZ;
	}

	public void setSensorFilteringFreeZ(java.math.BigDecimal sensorFilteringFreeZ) {
		this.sensorFilteringFreeZ = sensorFilteringFreeZ;
	}

	public java.math.BigDecimal getSensorFilteringBotX() {
		return sensorFilteringBotX;
	}

	public void setSensorFilteringBotX(java.math.BigDecimal sensorFilteringBotX) {
		this.sensorFilteringBotX = sensorFilteringBotX;
	}

	public java.math.BigDecimal getSensorFilteringBotY() {
		return sensorFilteringBotY;
	}

	public void setSensorFilteringBotY(java.math.BigDecimal sensorFilteringBotY) {
		this.sensorFilteringBotY = sensorFilteringBotY;
	}

	public java.math.BigDecimal getSensorFilteringBotZ() {
		return sensorFilteringBotZ;
	}

	public void setSensorFilteringBotZ(java.math.BigDecimal sensorFilteringBotZ) {
		this.sensorFilteringBotZ = sensorFilteringBotZ;
	}

	public java.math.BigDecimal getSensorFilteringMidX() {
		return sensorFilteringMidX;
	}

	public void setSensorFilteringMidX(java.math.BigDecimal sensorFilteringMidX) {
		this.sensorFilteringMidX = sensorFilteringMidX;
	}

	public java.math.BigDecimal getSensorFilteringMidY1() {
		return sensorFilteringMidY1;
	}

	public void setSensorFilteringMidY1(java.math.BigDecimal sensorFilteringMidY1) {
		this.sensorFilteringMidY1 = sensorFilteringMidY1;
	}

	public java.math.BigDecimal getSensorFilteringMidY2() {
		return sensorFilteringMidY2;
	}

	public void setSensorFilteringMidY2(java.math.BigDecimal sensorFilteringMidY2) {
		this.sensorFilteringMidY2 = sensorFilteringMidY2;
	}

	public java.math.BigDecimal getSensorFilteringTopX() {
		return sensorFilteringTopX;
	}

	public void setSensorFilteringTopX(java.math.BigDecimal sensorFilteringTopX) {
		this.sensorFilteringTopX = sensorFilteringTopX;
	}

	public java.math.BigDecimal getSensorFilteringTopY1() {
		return sensorFilteringTopY1;
	}

	public void setSensorFilteringTopY1(java.math.BigDecimal sensorFilteringTopY1) {
		this.sensorFilteringTopY1 = sensorFilteringTopY1;
	}

	public java.math.BigDecimal getSensorFilteringTopY2() {
		return sensorFilteringTopY2;
	}

	public void setSensorFilteringTopY2(java.math.BigDecimal sensorFilteringTopY2) {
		this.sensorFilteringTopY2 = sensorFilteringTopY2;
	}

	public java.math.BigDecimal getAnalyOption_idrAmp() {
		return analyOption_idrAmp;
	}

	public void setAnalyOption_idrAmp(java.math.BigDecimal analyOption_idrAmp) {
		this.analyOption_idrAmp = analyOption_idrAmp;
	}

	public java.math.BigDecimal getAnalyOptionStrHeight() {
		return analyOptionStrHeight;
	}

	public void setAnalyOptionStrHeight(java.math.BigDecimal analyOptionStrHeight) {
		this.analyOptionStrHeight = analyOptionStrHeight;
	}

	public java.math.BigDecimal getAnalyOptionSeismicArea() {
		return analyOptionSeismicArea;
	}

	public void setAnalyOptionSeismicArea(java.math.BigDecimal analyOptionSeismicArea) {
		this.analyOptionSeismicArea = analyOptionSeismicArea;
	}

	public java.math.BigDecimal getAnalyOptionStrType() {
		return analyOptionStrType;
	}

	public void setAnalyOptionStrType(java.math.BigDecimal analyOptionStrType) {
		this.analyOptionStrType = analyOptionStrType;
	}

	public java.lang.String getAnalyOptionStrName() {
		return analyOptionStrName;
	}

	public void setAnalyOptionStrName(java.lang.String analyOptionStrName) {
		this.analyOptionStrName = analyOptionStrName;
	}

	public java.math.BigDecimal getAnalyOptionStrFreqWindow() {
		return analyOptionStrFreqWindow;
	}

	public void setAnalyOptionStrFreqWindow(java.math.BigDecimal analyOptionStrFreqWindow) {
		this.analyOptionStrFreqWindow = analyOptionStrFreqWindow;
	}

	public java.math.BigDecimal getAnalyOptionStrFreqWindow_move() {
		return analyOptionStrFreqWindow_move;
	}

	public void setAnalyOptionStrFreqWindow_move(java.math.BigDecimal analyOptionStrFreqWindow_move) {
		this.analyOptionStrFreqWindow_move = analyOptionStrFreqWindow_move;
	}

	public java.math.BigDecimal getAnalyOptionLimitStateMean() {
		return analyOptionLimitStateMean;
	}

	public void setAnalyOptionLimitStateMean(java.math.BigDecimal analyOptionLimitStateMean) {
		this.analyOptionLimitStateMean = analyOptionLimitStateMean;
	}

	public java.math.BigDecimal getAnalyOptionLimitStateDev() {
		return analyOptionLimitStateDev;
	}

	public void setAnalyOptionLimitStateDev(java.math.BigDecimal analyOptionLimitStateDev) {
		this.analyOptionLimitStateDev = analyOptionLimitStateDev;
	}

	public java.math.BigDecimal getAnalyOptionFreqPrevX() {
		return analyOptionFreqPrevX;
	}

	public void setAnalyOptionFreqPrevX(java.math.BigDecimal analyOptionFreqPrevX) {
		this.analyOptionFreqPrevX = analyOptionFreqPrevX;
	}

	public java.math.BigDecimal getAnalyOptionFreqPrevY() {
		return analyOptionFreqPrevY;
	}

	public void setAnalyOptionFreqPrevY(java.math.BigDecimal analyOptionFreqPrevY) {
		this.analyOptionFreqPrevY = analyOptionFreqPrevY;
	}

	public java.math.BigDecimal getSafeIdrRangeSmf() {
		return safeIdrRangeSmf;
	}

	public void setSafeIdrRangeSmf(java.math.BigDecimal safeIdrRangeSmf) {
		this.safeIdrRangeSmf = safeIdrRangeSmf;
	}

	public java.math.BigDecimal getSafeIdrRangeSef() {
		return safeIdrRangeSef;
	}

	public void setSafeIdrRangeSef(java.math.BigDecimal safeIdrRangeSef) {
		this.safeIdrRangeSef = safeIdrRangeSef;
	}

	public java.math.BigDecimal getSafeIdrRangeRcf() {
		return safeIdrRangeRcf;
	}

	public void setSafeIdrRangeRcf(java.math.BigDecimal safeIdrRangeRcf) {
		this.safeIdrRangeRcf = safeIdrRangeRcf;
	}

	public java.math.BigDecimal getSafeIdrRangeRcsw() {
		return safeIdrRangeRcsw;
	}

	public void setSafeIdrRangeRcsw(java.math.BigDecimal safeIdrRangeRcsw) {
		this.safeIdrRangeRcsw = safeIdrRangeRcsw;
	}

	public java.math.BigDecimal getSafeNatFreqRange() {
		return safeNatFreqRange;
	}

	public void setSafeNatFreqRange(java.math.BigDecimal safeNatFreqRange) {
		this.safeNatFreqRange = safeNatFreqRange;
	}

	public java.math.BigDecimal getSafeStrFreeNatFreqRange() {
		return safeStrFreeNatFreqRange;
	}

	public void setSafeStrFreeNatFreqRange(java.math.BigDecimal safeStrFreeNatFreqRange) {
		this.safeStrFreeNatFreqRange = safeStrFreeNatFreqRange;
	}

	public java.math.BigDecimal getSafeOverAccRange() {
		return safeOverAccRange;
	}

	public void setSafeOverAccRange(java.math.BigDecimal safeOverAccRange) {
		this.safeOverAccRange = safeOverAccRange;
	}

	public java.math.BigDecimal getResultMaxIdrX() {
		return resultMaxIdrX;
	}

	public void setResultMaxIdrX(java.math.BigDecimal resultMaxIdrX) {
		this.resultMaxIdrX = resultMaxIdrX;
	}

	public java.math.BigDecimal getResultMaxIdrY() {
		return resultMaxIdrY;
	}

	public void setResultMaxIdrY(java.math.BigDecimal resultMaxIdrY) {
		this.resultMaxIdrY = resultMaxIdrY;
	}

	public java.math.BigDecimal getResultOverAccX() {
		return resultOverAccX;
	}

	public void setResultOverAccX(java.math.BigDecimal resultOverAccX) {
		this.resultOverAccX = resultOverAccX;
	}

	public java.math.BigDecimal getResultOverAccY() {
		return resultOverAccY;
	}

	public void setResultOverAccY(java.math.BigDecimal resultOverAccY) {
		this.resultOverAccY = resultOverAccY;
	}

	public java.math.BigDecimal getResultNatFreqMoveX() {
		return resultNatFreqMoveX;
	}

	public void setResultNatFreqMoveX(java.math.BigDecimal resultNatFreqMoveX) {
		this.resultNatFreqMoveX = resultNatFreqMoveX;
	}

	public java.math.BigDecimal getResultNatFreqMoveY() {
		return resultNatFreqMoveY;
	}

	public void setResultNatFreqMoveY(java.math.BigDecimal resultNatFreqMoveY) {
		this.resultNatFreqMoveY = resultNatFreqMoveY;
	}

	public java.math.BigDecimal getResultStrFreeNatFreqX() {
		return resultStrFreeNatFreqX;
	}

	public void setResultStrFreeNatFreqX(java.math.BigDecimal resultStrFreeNatFreqX) {
		this.resultStrFreeNatFreqX = resultStrFreeNatFreqX;
	}

	public java.math.BigDecimal getResultStrFreeNatFreqY() {
		return resultStrFreeNatFreqY;
	}

	public void setResultStrFreeNatFreqY(java.math.BigDecimal resultStrFreeNatFreqY) {
		this.resultStrFreeNatFreqY = resultStrFreeNatFreqY;
	}

	public java.lang.String getSafeCheckMaxIdrX() {
		return safeCheckMaxIdrX;
	}

	public void setSafeCheckMaxIdrX(java.lang.String safeCheckMaxIdrX) {
		this.safeCheckMaxIdrX = safeCheckMaxIdrX;
	}

	public java.lang.String getSafeCheckMaxIdrY() {
		return safeCheckMaxIdrY;
	}

	public void setSafeCheckMaxIdrY(java.lang.String safeCheckMaxIdrY) {
		this.safeCheckMaxIdrY = safeCheckMaxIdrY;
	}

	public java.lang.String getSafeCheckNatFreqMoveX() {
		return safeCheckNatFreqMoveX;
	}

	public void setSafeCheckNatFreqMoveX(java.lang.String safeCheckNatFreqMoveX) {
		this.safeCheckNatFreqMoveX = safeCheckNatFreqMoveX;
	}

	public java.lang.String getSafeCheckNatFreqMoveY() {
		return safeCheckNatFreqMoveY;
	}

	public void setSafeCheckNatFreqMoveY(java.lang.String safeCheckNatFreqMoveY) {
		this.safeCheckNatFreqMoveY = safeCheckNatFreqMoveY;
	}

	public java.lang.String getSafeCheckStrFreeNatFreqX() {
		return safeCheckStrFreeNatFreqX;
	}

	public void setSafeCheckStrFreeNatFreqX(java.lang.String safeCheckStrFreeNatFreqX) {
		this.safeCheckStrFreeNatFreqX = safeCheckStrFreeNatFreqX;
	}

	public java.lang.String getSafeCheckStrFreeNatFreqY() {
		return safeCheckStrFreeNatFreqY;
	}

	public void setSafeCheckStrFreeNatFreqY(java.lang.String safeCheckStrFreeNatFreqY) {
		this.safeCheckStrFreeNatFreqY = safeCheckStrFreeNatFreqY;
	}

	public java.lang.String getSafeCheckOverAccX() {
		return safeCheckOverAccX;
	}

	public void setSafeCheckOverAccX(java.lang.String safeCheckOverAccX) {
		this.safeCheckOverAccX = safeCheckOverAccX;
	}

	public java.lang.String getSafeCheckOverAccY() {
		return safeCheckOverAccY;
	}

	public void setSafeCheckOverAccY(java.lang.String safeCheckOverAccY) {
		this.safeCheckOverAccY = safeCheckOverAccY;
	}

	public java.math.BigDecimal getDataFreeMaxDispX() {
		return dataFreeMaxDispX;
	}

	public void setDataFreeMaxDispX(java.math.BigDecimal dataFreeMaxDispX) {
		this.dataFreeMaxDispX = dataFreeMaxDispX;
	}

	public java.math.BigDecimal getDataFreeMaxDispY() {
		return dataFreeMaxDispY;
	}

	public void setDataFreeMaxDispY(java.math.BigDecimal dataFreeMaxDispY) {
		this.dataFreeMaxDispY = dataFreeMaxDispY;
	}

	public java.math.BigDecimal getDataTopRelMaxSpeedX() {
		return dataTopRelMaxSpeedX;
	}

	public void setDataTopRelMaxSpeedX(java.math.BigDecimal dataTopRelMaxSpeedX) {
		this.dataTopRelMaxSpeedX = dataTopRelMaxSpeedX;
	}

	public java.math.BigDecimal getDataTopRelMaxSpeedY() {
		return dataTopRelMaxSpeedY;
	}

	public void setDataTopRelMaxSpeedY(java.math.BigDecimal dataTopRelMaxSpeedY) {
		this.dataTopRelMaxSpeedY = dataTopRelMaxSpeedY;
	}

	public java.math.BigDecimal getDataTopRelMaxDispX() {
		return dataTopRelMaxDispX;
	}

	public void setDataTopRelMaxDispX(java.math.BigDecimal dataTopRelMaxDispX) {
		this.dataTopRelMaxDispX = dataTopRelMaxDispX;
	}

	public java.math.BigDecimal getDataTopRelMaxDispY() {
		return dataTopRelMaxDispY;
	}

	public void setDataTopRelMaxDispY(java.math.BigDecimal dataTopRelMaxDispY) {
		this.dataTopRelMaxDispY = dataTopRelMaxDispY;
	}

	public java.math.BigDecimal getDataFreeAcc() {
		return dataFreeAcc;
	}

	public void setDataFreeAcc(java.math.BigDecimal dataFreeAcc) {
		this.dataFreeAcc = dataFreeAcc;
	}

	public java.math.BigDecimal getDataFreeVel() {
		return dataFreeVel;
	}

	public void setDataFreeVel(java.math.BigDecimal dataFreeVel) {
		this.dataFreeVel = dataFreeVel;
	}

	public java.math.BigDecimal getDataFreeDisp() {
		return dataFreeDisp;
	}

	public void setDataFreeDisp(java.math.BigDecimal dataFreeDisp) {
		this.dataFreeDisp = dataFreeDisp;
	}

	public java.math.BigDecimal getDataStrBotAcc() {
		return dataStrBotAcc;
	}

	public void setDataStrBotAcc(java.math.BigDecimal dataStrBotAcc) {
		this.dataStrBotAcc = dataStrBotAcc;
	}

	public java.math.BigDecimal getDataStrBotVel() {
		return dataStrBotVel;
	}

	public void setDataStrBotVel(java.math.BigDecimal dataStrBotVel) {
		this.dataStrBotVel = dataStrBotVel;
	}

	public java.math.BigDecimal getDataStrBotDisp() {
		return dataStrBotDisp;
	}

	public void setDataStrBotDisp(java.math.BigDecimal dataStrBotDisp) {
		this.dataStrBotDisp = dataStrBotDisp;
	}

	public java.math.BigDecimal getDataStrMidAcc() {
		return dataStrMidAcc;
	}

	public void setDataStrMidAcc(java.math.BigDecimal dataStrMidAcc) {
		this.dataStrMidAcc = dataStrMidAcc;
	}

	public java.math.BigDecimal getDataStrTopAcc() {
		return dataStrTopAcc;
	}

	public void setDataStrTopAcc(java.math.BigDecimal dataStrTopAcc) {
		this.dataStrTopAcc = dataStrTopAcc;
	}

	public java.math.BigDecimal getDataStrFreq() {
		return dataStrFreq;
	}

	public void setDataStrFreq(java.math.BigDecimal dataStrFreq) {
		this.dataStrFreq = dataStrFreq;
	}

	public java.math.BigDecimal getDataFreeFreq() {
		return dataFreeFreq;
	}

	public void setDataFreeFreq(java.math.BigDecimal dataFreeFreq) {
		this.dataFreeFreq = dataFreeFreq;
	}

	public java.math.BigDecimal getDesignAcc() {
		return designAcc;
	}

	public void setDesignAcc(java.math.BigDecimal designAcc) {
		this.designAcc = designAcc;
	}

	public java.lang.String getSearchStartDt() {
		return searchStartDt;
	}

	public void setSearchStartDt(java.lang.String searchStartDt) {
		this.searchStartDt = searchStartDt;
	}

	public java.lang.String getSearchEndDt() {
		return searchEndDt;
	}

	public void setSearchEndDt(java.lang.String searchEndDt) {
		this.searchEndDt = searchEndDt;
	}

}
