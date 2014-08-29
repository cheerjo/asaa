package estam.app.sym.usr.service;

import java.io.Serializable;

/**
 * @Class Name : SymUserVO.java
 * @Description : SymUser VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2013.07.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SymUserVO  implements Serializable  {
    private static final long serialVersionUID = 1L;
    
    /** PRIV_GRP_NO */
    private java.math.BigDecimal privGrpNo;
    
    /** USER_ID */
    private java.lang.String userId;
    
    /** ORG_YN */
    private java.lang.String orgYn;
    
    /** ORG_NM */
    private java.lang.String orgNm;
    
    /** USER_NM */
    private java.lang.String userNm;
    
    /** USR_PSWD */
    private java.lang.String usrPswd;
    
    /** USR_EMAIL */
    private java.lang.String usrEmail;
    
    /** TEL_NO */
    private java.lang.String telNo;
    
    /** MBL_NO */
    private java.lang.String mblNo;
    
    /** USE_OBJT */
    private java.lang.String useObjt;
    
    /** INPT_USR_ID */
    private java.lang.String inptUsrId;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** UPDT_USR_ID */
    private java.lang.String updtUsrId;
    
    /** UPDT_DT */
    private java.sql.Date updtDt;
    
    /** DEL_DT */
    private java.sql.Date delDt;
    
    public java.math.BigDecimal getPrivGrpNo() {
        return this.privGrpNo;
    }
    
    public void setPrivGrpNo(java.math.BigDecimal privGrpNo) {
        this.privGrpNo = privGrpNo;
    }
    
    public java.lang.String getUserId() {
        return this.userId;
    }
    
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }
    
    public java.lang.String getOrgYn() {
        return this.orgYn;
    }
    
    public void setOrgYn(java.lang.String orgYn) {
        this.orgYn = orgYn;
    }
    
    public java.lang.String getOrgNm() {
        return this.orgNm;
    }
    
    public void setOrgNm(java.lang.String orgNm) {
        this.orgNm = orgNm;
    }
    
    public java.lang.String getUserNm() {
        return this.userNm;
    }
    
    public void setUserNm(java.lang.String userNm) {
        this.userNm = userNm;
    }
    
    public java.lang.String getUsrPswd() {
        return this.usrPswd;
    }
    
    public void setUsrPswd(java.lang.String usrPswd) {
        this.usrPswd = usrPswd;
    }
    
    public java.lang.String getUsrEmail() {
        return this.usrEmail;
    }
    
    public void setUsrEmail(java.lang.String usrEmail) {
        this.usrEmail = usrEmail;
    }
    
    public java.lang.String getTelNo() {
        return this.telNo;
    }
    
    public void setTelNo(java.lang.String telNo) {
        this.telNo = telNo;
    }
    
    public java.lang.String getMblNo() {
        return this.mblNo;
    }
    
    public void setMblNo(java.lang.String mblNo) {
        this.mblNo = mblNo;
    }
    
    public java.lang.String getUseObjt() {
        return this.useObjt;
    }
    
    public void setUseObjt(java.lang.String useObjt) {
        this.useObjt = useObjt;
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
    
    public java.sql.Date getDelDt() {
        return this.delDt;
    }
    
    public void setDelDt(java.sql.Date delDt) {
        this.delDt = delDt;
    }
    
}
