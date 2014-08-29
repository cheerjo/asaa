package estam.app.fcty.service;

/**
 * @Class Name : FctyImgVO.java
 * @Description : FctyImg VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class FctyImgVO extends FctyImgDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** FCTY_CD */
    private java.lang.String fctyCd;
    
    /** FCTY_NM */
    private java.lang.String fctyNm;
    
    /** FCTY_IMG_SEQ */
    private java.math.BigDecimal fctyImgSeq;
    
    /** FCTY_IMG_FLSV */
    private java.lang.String fctyImgFlsv;
    
    /** FCTY_IMG_FLNM */
    private java.lang.String fctyImgFlnm;
    
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
    
    public java.math.BigDecimal getFctyImgSeq() {
        return this.fctyImgSeq;
    }
    
    public void setFctyImgSeq(java.math.BigDecimal fctyImgSeq) {
        this.fctyImgSeq = fctyImgSeq;
    }
    
    public java.lang.String getFctyImgFlsv() {
        return this.fctyImgFlsv;
    }
    
    public void setFctyImgFlsv(java.lang.String fctyImgFlsv) {
        this.fctyImgFlsv = fctyImgFlsv;
    }
    
    public java.lang.String getFctyImgFlnm() {
        return this.fctyImgFlnm;
    }
    
    public void setFctyImgFlnm(java.lang.String fctyImgFlnm) {
        this.fctyImgFlnm = fctyImgFlnm;
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
