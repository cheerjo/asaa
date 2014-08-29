package estam.app.iddl.service;

/**
 * @Class Name : IddlAassWvflVO.java
 * @Description : IddlAassWvfl VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class IddlAassWvflVO extends IddlAassWvflDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** FCTY_CD */
    private java.lang.String fctyCd;
    
    /** IDDL_AASS_NO */
    private java.math.BigDecimal iddlAassNo;
    
    /** IDDL_AASS_SCN_FLCD */
    private java.lang.String iddlAassScnFlcd;
    
    /** IDDL_AASS_SCN_FLSV */
    private java.lang.String iddlAassScnFlsv;
    
    /** IDDL_AASS_SCN_FLNM */
    private java.lang.String iddlAassScnFlnm;
    
    /** INPT_USR_ID */
    private java.lang.String inptUsrId;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** UPDT_USR_ID */
    private java.lang.String updtUsrId;
    
    /** UPDT_DT */
    private java.sql.Date updtDt;
    
    
    private java.lang.String gvmtCd;
    
    
    
    public java.lang.String getGvmtCd() {
		return gvmtCd;
	}

	public void setGvmtCd(java.lang.String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}

	public java.lang.String getFctyCd() {
        return this.fctyCd;
    }
    
    public void setFctyCd(java.lang.String fctyCd) {
        this.fctyCd = fctyCd;
    }
    
    public java.math.BigDecimal getIddlAassNo() {
        return this.iddlAassNo;
    }
    
    public void setIddlAassNo(java.math.BigDecimal iddlAassNo) {
        this.iddlAassNo = iddlAassNo;
    }
    
    public java.lang.String getIddlAassScnFlcd() {
        return this.iddlAassScnFlcd;
    }
    
    public void setIddlAassScnFlcd(java.lang.String iddlAassScnFlcd) {
        this.iddlAassScnFlcd = iddlAassScnFlcd;
    }
    
    public java.lang.String getIddlAassScnFlsv() {
        return this.iddlAassScnFlsv;
    }
    
    public void setIddlAassScnFlsv(java.lang.String iddlAassScnFlsv) {
        this.iddlAassScnFlsv = iddlAassScnFlsv;
    }
    
    public java.lang.String getIddlAassScnFlnm() {
        return this.iddlAassScnFlnm;
    }
    
    public void setIddlAassScnFlnm(java.lang.String iddlAassScnFlnm) {
        this.iddlAassScnFlnm = iddlAassScnFlnm;
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
