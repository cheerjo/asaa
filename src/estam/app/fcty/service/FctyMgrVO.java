package estam.app.fcty.service;

/**
 * @Class Name : FctyMgrVO.java
 * @Description : FctyMgr VO class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public class FctyMgrVO extends FctyMgrDefaultVO {
	private static final long serialVersionUID = 1L;

	/** FCTY_CD */
	private java.lang.String fctyCd;

	/** GVMT_CD */
	private java.lang.String gvmtCd;

	/** FCTY_NM */
	private java.lang.String fctyNm;

	/** FCTY_ESMT_STDT */
	private java.lang.String fctyEsmtStdt;

	/** FCTY_ESMT_EDDT */
	private java.lang.String fctyEsmtEddt;

	/** FCTY_AREA_CD */
	private java.lang.String fctyAreaCd;

	/** FCTY_ST_ADDR */
	private java.lang.String fctyStAddr;

	/** FCTY_ED_ADDR */
	private java.lang.String fctyEdAddr;

	/** FCTY_KND_CD */
	private java.lang.String fctyKndCd;

	/** FCTY_KND_NM */
	private java.lang.String fctyKndNm;

	/** FCTY_LON */
	private java.lang.String fctyLon;

	/** FCTY_LAT */
	private java.lang.String fctyLat;

	/** FCTY_ATTC */
	private java.lang.String fctyAttc;

	/** FCTY_GRND_HT */
	private java.math.BigDecimal fctyGrndHt;

	/** FCTY_UGRD_HT */
	private java.math.BigDecimal fctyUgrdHt;

	/** FCTY_BASC */
	private java.lang.String fctyBasc;

	/** FCTY_GRND_CD */
	private java.lang.String fctyGrndCd;

	/** FCTY_HOLC_YN */
	private java.lang.String fctyHolcYn;

	/** INPT_USR_ID */
	private java.lang.String inptUsrId;

	/** INPT_DT */
	private java.sql.Date inptDt;

	/** UPDT_USR_ID */
	private java.lang.String updtUsrId;

	/** UPDT_DT */
	private java.sql.Date updtDt;

	/** SEIS_CD */
	private java.lang.String seisCd;

	/** FCTY_CPLN_DT */
	private java.lang.String fctyCplnDt;

	/** FCTY_GBN_CD */
	private java.lang.String fctyGbnCd;

	/** EHQK_AREA_CD */
	private java.lang.String ehqkAreaCd;

	/** FCTY_STR_TYCD */
	private java.lang.String fctyStrTycd;

	/** FCTY_LVCS_CD */
	private java.lang.String fctyLvcsCd;

	/** FCTY_BOT_AREA */
	private java.lang.String fctyBotArea;

	/** FCTY_FLOR_SCL */
	private java.lang.String fctyFlorScl;

	/** FCTY_ROF_HT */
	private java.lang.String fctyRofHt;

	/** FCTY_DSGN_CTRS_CD */
	private java.lang.String fctyDsgnCtraCd;

	/** FCTY_DSGN_IMG */
	private java.lang.String fctyDsgnImg;

	private java.lang.String fctyAreaNm;

	private java.lang.String fcfutyAreaNm;

	private java.lang.String FctyUseYn;

	public java.lang.String getFctyUseYn() {
		return FctyUseYn;
	}

	public void setFctyUseYn(java.lang.String fctyUseYn) {
		FctyUseYn = fctyUseYn;
	}

	/**
	 * @return the fcfutyAreaNm
	 */
	public java.lang.String getFcfutyAreaNm() {
		return fcfutyAreaNm;
	}

	/**
	 * @param fcfutyAreaNm
	 *            the fcfutyAreaNm to set
	 */
	public void setFcfutyAreaNm(java.lang.String fcfutyAreaNm) {
		this.fcfutyAreaNm = fcfutyAreaNm;
	}

	public java.lang.String getFctyAreaNm() {
		return fctyAreaNm;
	}

	public void setFctyAreaNm(java.lang.String fctyAreaNm) {
		this.fctyAreaNm = fctyAreaNm;
	}

	public java.lang.String getFctyCd() {
		return this.fctyCd;
	}

	public void setFctyCd(java.lang.String fctyCd) {
		this.fctyCd = fctyCd;
	}

	public java.lang.String getGvmtCd() {
		return this.gvmtCd;
	}

	public void setGvmtCd(java.lang.String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}

	public java.lang.String getFctyNm() {
		return this.fctyNm;
	}

	public void setFctyNm(java.lang.String fctyNm) {
		this.fctyNm = fctyNm;
	}

	public java.lang.String getFctyEsmtStdt() {
		return this.fctyEsmtStdt;
	}

	public void setFctyEsmtStdt(java.lang.String fctyEsmtStdt) {
		this.fctyEsmtStdt = fctyEsmtStdt;
	}

	public java.lang.String getFctyEsmtEddt() {
		return this.fctyEsmtEddt;
	}

	public void setFctyEsmtEddt(java.lang.String fctyEsmtEddt) {
		this.fctyEsmtEddt = fctyEsmtEddt;
	}

	public java.lang.String getFctyAreaCd() {
		return this.fctyAreaCd;
	}

	public void setFctyAreaCd(java.lang.String fctyAreaCd) {
		this.fctyAreaCd = fctyAreaCd;
	}

	public java.lang.String getFctyStAddr() {
		return this.fctyStAddr;
	}

	public void setFctyStAddr(java.lang.String fctyStAddr) {
		this.fctyStAddr = fctyStAddr;
	}

	public java.lang.String getFctyEdAddr() {
		return this.fctyEdAddr;
	}

	public void setFctyEdAddr(java.lang.String fctyEdAddr) {
		this.fctyEdAddr = fctyEdAddr;
	}

	public java.lang.String getFctyKndCd() {
		return this.fctyKndCd;
	}

	public void setFctyKndCd(java.lang.String fctyKndCd) {
		this.fctyKndCd = fctyKndCd;
	}

	public java.lang.String getFctyKndNm() {
		return fctyKndNm;
	}

	public void setFctyKndNm(java.lang.String fctyKndNm) {
		this.fctyKndNm = fctyKndNm;
	}

	public java.lang.String getFctyLon() {
		return this.fctyLon;
	}

	public void setFctyLon(java.lang.String fctyLon) {
		this.fctyLon = fctyLon;
	}

	public java.lang.String getFctyLat() {
		return this.fctyLat;
	}

	public void setFctyLat(java.lang.String fctyLat) {
		this.fctyLat = fctyLat;
	}

	public java.lang.String getFctyAttc() {
		return this.fctyAttc;
	}

	public void setFctyAttc(java.lang.String fctyAttc) {
		this.fctyAttc = fctyAttc;
	}

	public java.math.BigDecimal getFctyGrndHt() {
		return this.fctyGrndHt;
	}

	public void setFctyGrndHt(java.math.BigDecimal fctyGrndHt) {
		this.fctyGrndHt = fctyGrndHt;
	}

	public java.math.BigDecimal getFctyUgrdHt() {
		return this.fctyUgrdHt;
	}

	public void setFctyUgrdHt(java.math.BigDecimal fctyUgrdHt) {
		this.fctyUgrdHt = fctyUgrdHt;
	}

	public java.lang.String getFctyBasc() {
		return this.fctyBasc;
	}

	public void setFctyBasc(java.lang.String fctyBasc) {
		this.fctyBasc = fctyBasc;
	}

	public java.lang.String getFctyGrndCd() {
		return this.fctyGrndCd;
	}

	public void setFctyGrndCd(java.lang.String fctyGrndCd) {
		this.fctyGrndCd = fctyGrndCd;
	}

	public java.lang.String getFctyHolcYn() {
		return this.fctyHolcYn;
	}

	public void setFctyHolcYn(java.lang.String fctyHolcYn) {
		this.fctyHolcYn = fctyHolcYn;
	}

	public java.lang.String getInptUsrId() {
		return this.inptUsrId;
	}

	public void setInptUsrId(java.lang.String inptUsrId) {
		this.inptUsrId = inptUsrId;
	}

	public java.sql.Date getInptDt() {
		return this.inptDt;
	}

	public void setInptDt(java.sql.Date inptDt) {
		this.inptDt = inptDt;
	}

	public java.lang.String getUpdtUsrId() {
		return this.updtUsrId;
	}

	public void setUpdtUsrId(java.lang.String updtUsrId) {
		this.updtUsrId = updtUsrId;
	}

	public java.sql.Date getUpdtDt() {
		return this.updtDt;
	}

	public void setUpdtDt(java.sql.Date updtDt) {
		this.updtDt = updtDt;
	}

	public java.lang.String getSeisCd() {
		return this.seisCd;
	}

	public void setSeisCd(java.lang.String seisCd) {
		this.seisCd = seisCd;
	}

	public java.lang.String getFctyCplnDt() {
		return this.fctyCplnDt;
	}

	public void setFctyCplnDt(java.lang.String fctyCplnDt) {
		this.fctyCplnDt = fctyCplnDt;
	}

	public java.lang.String getFctyGbnCd() {
		return this.fctyGbnCd;
	}

	public void setFctyGbnCd(java.lang.String fctyGbnCd) {
		this.fctyGbnCd = fctyGbnCd;
	}

	public java.lang.String getEhqkAreaCd() {
		return this.ehqkAreaCd;
	}

	public void setEhqkAreaCd(java.lang.String ehqkAreaCd) {
		this.ehqkAreaCd = ehqkAreaCd;
	}

	public java.lang.String getFctyStrTycd() {
		return this.fctyStrTycd;
	}

	public void setFctyStrTycd(java.lang.String fctyStrTycd) {
		this.fctyStrTycd = fctyStrTycd;
	}

	public java.lang.String getFctyLvcsCd() {
		return this.fctyLvcsCd;
	}

	public void setFctyLvcsCd(java.lang.String fctyLvcsCd) {
		this.fctyLvcsCd = fctyLvcsCd;
	}

	public java.lang.String getFctyBotArea() {
		return this.fctyBotArea;
	}

	public void setFctyBotArea(java.lang.String fctyBotArea) {
		this.fctyBotArea = fctyBotArea;
	}

	public java.lang.String getFctyFlorScl() {
		return this.fctyFlorScl;
	}

	public void setFctyFlorScl(java.lang.String fctyFlorScl) {
		this.fctyFlorScl = fctyFlorScl;
	}

	public java.lang.String getFctyRofHt() {
		return this.fctyRofHt;
	}

	public void setFctyRofHt(java.lang.String fctyRofHt) {
		this.fctyRofHt = fctyRofHt;
	}

	public java.lang.String getFctyDsgnCtraCd() {
		return this.fctyDsgnCtraCd;
	}

	public void setFctyDsgnCtraCd(java.lang.String fctyDsgnCtraCd) {
		this.fctyDsgnCtraCd = fctyDsgnCtraCd;
	}

	public java.lang.String getFctyDsgnImg() {
		return this.fctyDsgnImg;
	}

	public void setFctyDsgnImg(java.lang.String fctyDsgnImg) {
		this.fctyDsgnImg = fctyDsgnImg;
	}
}
