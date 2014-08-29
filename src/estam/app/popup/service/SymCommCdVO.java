package estam.app.popup.service;

import java.io.Serializable;

/**
 * @Class Name : SymCommCdVO.java
 * @Description : SymCommCd VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.07.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SymCommCdVO  implements Serializable  { 
    
    /** COMM_CD */
    private java.lang.String commCd;
    
    /** COMM_NM */
    private java.lang.String commNm;
    
    /** COMM_INFO */
    private java.lang.String commInfo;
    
    /** INPT_USR_ID */
    private java.lang.String inptUsrId;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** UPDT_USR_ID */
    private java.lang.String updtUsrId;
    
    /** UPDT_DT */
    private java.sql.Date updtDt;
    
    public java.lang.String getCommCd() {
        return this.commCd;
    }
    
    public void setCommCd(java.lang.String commCd) {
        this.commCd = commCd;
    }
    
    public java.lang.String getCommNm() {
        return this.commNm;
    }
    
    public void setCommNm(java.lang.String commNm) {
        this.commNm = commNm;
    }
    
    public java.lang.String getCommInfo() {
        return this.commInfo;
    }
    
    public void setCommInfo(java.lang.String commInfo) {
        this.commInfo = commInfo;
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
