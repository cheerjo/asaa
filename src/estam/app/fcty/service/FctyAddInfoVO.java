package estam.app.fcty.service;

/**
 * @Class Name : FctyAddInfoVO.java
 * @Description : FctyAddInfo VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class FctyAddInfoVO extends FctyAddInfoDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** FCTY_CD */
    private java.lang.String fctyCd;
    
    /** GVMT_CD */
    private java.lang.String gvmtCd;
    
    /** fctyNm */
    private java.lang.String fctyNm;
    
    
    /** FCTY_STBL_DT */
    private java.lang.String fctyStblDt;
    
    /** FCTY_CTAT_DT */
    private java.lang.String fctyCtatDt;
    
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
    private java.math.BigDecimal fctyRofHt;
    
    /** FCTY_DSGN_CTRA_CD */
    private java.lang.String fctyDsgnCtraCd;
    
    /** FCTY_HT */
    private java.math.BigDecimal fctyHt;
    
    /** FCTY_USR_DEPT */
    private java.lang.String fctyUsrDept;
    
    /** FCTY_USR_NM */
    private java.lang.String fctyUsrNm;
    
    /** FACTY_USR_TEL */
    private java.lang.String factyUsrTel;
    
    /** FCTY_USR_EMAIL */
    private java.lang.String fctyUsrEmail;
    
    /** INPT_USR_ID */
    private java.lang.String inptUsrId;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** UPDT_USR_ID */
    private java.lang.String updtUsrId;
    
    /** UPDT_DT */
    private java.sql.Date updtDt;
    
    private java.lang.String fctyKndCd;
    
    
    public java.lang.String getFctyKndCd() {
		return fctyKndCd;
	}

	public void setFctyKndCd(java.lang.String fctyKndCd) {
		this.fctyKndCd = fctyKndCd;
	}

	/**
	 * @return the fctyNm
	 */
	public java.lang.String getFctyNm() {
		return fctyNm;
	}

	/**
	 * @param fctyNm the fctyNm to set
	 */
	public void setFctyNm(java.lang.String fctyNm) {
		this.fctyNm = fctyNm;
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
    
    public java.lang.String getFctyStblDt() {
        return this.fctyStblDt;
    }
    
    public void setFctyStblDt(java.lang.String fctyStblDt) {
        this.fctyStblDt = fctyStblDt;
    }
    
    public java.lang.String getFctyCtatDt() {
        return this.fctyCtatDt;
    }
    
    public void setFctyCtatDt(java.lang.String fctyCtatDt) {
        this.fctyCtatDt = fctyCtatDt;
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
    
    public java.math.BigDecimal getFctyRofHt() {
        return this.fctyRofHt;
    }
    
    public void setFctyRofHt(java.math.BigDecimal fctyRofHt) {
        this.fctyRofHt = fctyRofHt;
    }
    
    public java.lang.String getFctyDsgnCtraCd() {
        return this.fctyDsgnCtraCd;
    }
    
    public void setFctyDsgnCtraCd(java.lang.String fctyDsgnCtraCd) {
        this.fctyDsgnCtraCd = fctyDsgnCtraCd;
    }
    
    public java.math.BigDecimal getFctyHt() {
        return this.fctyHt;
    }
    
    public void setFctyHt(java.math.BigDecimal fctyHt) {
        this.fctyHt = fctyHt;
    }
    
    public java.lang.String getFctyUsrDept() {
        return this.fctyUsrDept;
    }
    
    public void setFctyUsrDept(java.lang.String fctyUsrDept) {
        this.fctyUsrDept = fctyUsrDept;
    }
    
    public java.lang.String getFctyUsrNm() {
        return this.fctyUsrNm;
    }
    
    public void setFctyUsrNm(java.lang.String fctyUsrNm) {
        this.fctyUsrNm = fctyUsrNm;
    }
    
    public java.lang.String getFactyUsrTel() {
        return this.factyUsrTel;
    }
    
    public void setFactyUsrTel(java.lang.String factyUsrTel) {
        this.factyUsrTel = factyUsrTel;
    }
    
    public java.lang.String getFctyUsrEmail() {
        return this.fctyUsrEmail;
    }
    
    public void setFctyUsrEmail(java.lang.String fctyUsrEmail) {
        this.fctyUsrEmail = fctyUsrEmail;
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
    
}
