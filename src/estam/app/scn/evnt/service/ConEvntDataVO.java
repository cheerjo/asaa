package estam.app.scn.evnt.service;

/**
 * @Class Name : ConEvntDataVO.java
 * @Description : ConEvntData VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class ConEvntDataVO extends ConEvntDataDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** EHQK_REQ_ID */
    private java.lang.String ehqkReqId;
    
    /** EHQK_TRAN_GBCD */
    private java.lang.String ehqkTranGbcd;
    
    /** FCTY_CD */
    private java.lang.String fctyCd;
    
    private java.lang.String gvmtCd; 
    
    /** EHQK_FLSV */
    private java.lang.String ehqkFlsv;
    
    /** EHQK_FLNM */
    private java.lang.String ehqkFlnm;
    
    /** INPT_USR_ID */
    private java.lang.String inptUsrId;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** UPDT_USR_ID */
    private java.lang.String updtUsrId;
    
    /** UPDT_DT */
    private java.sql.Date updtDt; 
    
    
    /**
	 * @return the gvmtCd
	 */
	public java.lang.String getGvmtCd() {
		return gvmtCd;
	}

	/**
	 * @param gvmtCd the gvmtCd to set
	 */
	public void setGvmtCd(java.lang.String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}

	public java.lang.String getEhqkReqId() {
        return this.ehqkReqId;
    }
    
    public void setEhqkReqId(java.lang.String ehqkReqId) {
        this.ehqkReqId = ehqkReqId;
    }
    
    public java.lang.String getEhqkTranGbcd() {
        return this.ehqkTranGbcd;
    }
    
    public void setEhqkTranGbcd(java.lang.String ehqkTranGbcd) {
        this.ehqkTranGbcd = ehqkTranGbcd;
    }
    
    public java.lang.String getFctyCd() {
        return this.fctyCd;
    }
    
    public void setFctyCd(java.lang.String fctyCd) {
        this.fctyCd = fctyCd;
    }
    
    public java.lang.String getEhqkFlsv() {
        return this.ehqkFlsv;
    }
    
    public void setEhqkFlsv(java.lang.String ehqkFlsv) {
        this.ehqkFlsv = ehqkFlsv;
    }
    
    public java.lang.String getEhqkFlnm() {
        return this.ehqkFlnm;
    }
    
    public void setEhqkFlnm(java.lang.String ehqkFlnm) {
        this.ehqkFlnm = ehqkFlnm;
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
