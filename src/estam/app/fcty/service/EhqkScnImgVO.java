package estam.app.fcty.service;

/**
 * @Class Name : EhqkScnImgVO.java
 * @Description : EhqkScnImg VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class EhqkScnImgVO extends EhqkScnImgDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** FCTY_CD */
    private java.lang.String fctyCd;
    
    /** EHQK_SCN_ID */
    private java.lang.String ehqkScnId;
    
    /** EHQK_SCN_IMG_SEQ */
    private java.math.BigDecimal ehqkScnImgSeq;
    
    /** EHQK_SCN_IMG_FLSV */
    private java.lang.String ehqkScnImgFlsv;
    
    /** EHQK_SCN_IMG_FLNM */
    private java.lang.String ehqkScnImgFlnm;
    
    /** INPT_USR_ID */
    private java.lang.String inptUsrId;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** UPDT_USR_ID */
    private java.lang.String updtUsrId;
    
    /** UPDT_DT */
    private java.sql.Date updtDt;
    
    public java.lang.String getFctyCd() {
        return this.fctyCd;
    }
    
    public void setFctyCd(java.lang.String fctyCd) {
        this.fctyCd = fctyCd;
    }
    
    public java.lang.String getEhqkScnId() {
        return this.ehqkScnId;
    }
    
    public void setEhqkScnId(java.lang.String ehqkScnId) {
        this.ehqkScnId = ehqkScnId;
    }
    
    public java.math.BigDecimal getEhqkScnImgSeq() {
        return this.ehqkScnImgSeq;
    }
    
    public void setEhqkScnImgSeq(java.math.BigDecimal ehqkScnImgSeq) {
        this.ehqkScnImgSeq = ehqkScnImgSeq;
    }
    
    public java.lang.String getEhqkScnImgFlsv() {
        return this.ehqkScnImgFlsv;
    }
    
    public void setEhqkScnImgFlsv(java.lang.String ehqkScnImgFlsv) {
        this.ehqkScnImgFlsv = ehqkScnImgFlsv;
    }
    
    public java.lang.String getEhqkScnImgFlnm() {
        return this.ehqkScnImgFlnm;
    }
    
    public void setEhqkScnImgFlnm(java.lang.String ehqkScnImgFlnm) {
        this.ehqkScnImgFlnm = ehqkScnImgFlnm;
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
