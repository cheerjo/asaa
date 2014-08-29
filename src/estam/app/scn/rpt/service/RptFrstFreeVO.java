package estam.app.scn.rpt.service;

/**
 * @Class Name : RptFrstFreeVO.java
 * @Description : RptFrstFree VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class RptFrstFreeVO extends RptFrstFreeDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** FRE_SCN_ID */
    private java.lang.String freScnId;
    
    /** IPT_DT */
    private java.lang.String iptDt;
    
    /** CON_DA_GBCD */
    private java.lang.String conDaGbcd;
    
    /** FCTY_CD */
    private java.lang.String fctyCd;
    
    /** GVMT_CD */
    private java.lang.String gvmtCd;
    
    /** FREE_QST1_YN */
    private java.lang.String freeQst1Yn;
    
    /** FREE_QST2_1YN */
    private java.lang.String freeQst21yn;
    
    /** FREE_QST2_2YN */
    private java.lang.String freeQst22yn;
    
    /** FREE_QST3_1YN */
    private java.lang.String freeQst31yn;
    
    /** FREE_QST3_2YN */
    private java.lang.String freeQst32yn;
    
    /** INPT_USR_ID */
    private java.lang.String inptUsrId;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** UPDT_USR_ID */
    private java.lang.String updtUsrId;
    
    /** UPDT_DT */
    private java.sql.Date updtDt;
    
    
    public java.lang.String getGvmtCd() {
		return gvmtCd;
	}

	public void setGvmtCd(java.lang.String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}

	public java.lang.String getFreScnId() {
        return this.freScnId;
    }
    
    public void setFreScnId(java.lang.String freScnId) {
        this.freScnId = freScnId;
    }
    
    public java.lang.String getIptDt() {
        return this.iptDt;
    }
    
    public void setIptDt(java.lang.String iptDt) {
        this.iptDt = iptDt;
    }
    
    public java.lang.String getConDaGbcd() {
        return this.conDaGbcd;
    }
    
    public void setConDaGbcd(java.lang.String conDaGbcd) {
        this.conDaGbcd = conDaGbcd;
    }
    
    public java.lang.String getFctyCd() {
        return this.fctyCd;
    }
    
    public void setFctyCd(java.lang.String fctyCd) {
        this.fctyCd = fctyCd;
    }
    
    public java.lang.String getFreeQst1Yn() {
        return this.freeQst1Yn;
    }
    
    public void setFreeQst1Yn(java.lang.String freeQst1Yn) {
        this.freeQst1Yn = freeQst1Yn;
    }
    
    public java.lang.String getFreeQst21yn() {
        return this.freeQst21yn;
    }
    
    public void setFreeQst21yn(java.lang.String freeQst21yn) {
        this.freeQst21yn = freeQst21yn;
    }
    
    public java.lang.String getFreeQst22yn() {
        return this.freeQst22yn;
    }
    
    public void setFreeQst22yn(java.lang.String freeQst22yn) {
        this.freeQst22yn = freeQst22yn;
    }
    
    public java.lang.String getFreeQst31yn() {
        return this.freeQst31yn;
    }
    
    public void setFreeQst31yn(java.lang.String freeQst31yn) {
        this.freeQst31yn = freeQst31yn;
    }
    
    public java.lang.String getFreeQst32yn() {
        return this.freeQst32yn;
    }
    
    public void setFreeQst32yn(java.lang.String freeQst32yn) {
        this.freeQst32yn = freeQst32yn;
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
