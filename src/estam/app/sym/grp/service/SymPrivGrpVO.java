package estam.app.sym.grp.service;

import java.io.Serializable;

/**
 * @Class Name : SymPrivGrpVO.java
 * @Description : SymPrivGrp VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2013.07.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SymPrivGrpVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** PRIV_GRP_NO */
    private java.math.BigDecimal privGrpNo;
    
    /** PRIV_GRP_NM */
    private java.lang.String privGrpNm;
    
    /** PRIV_GRP_DESC */
    private java.lang.String privGrpDesc;
    
    /** INPT_USR_ID */
    private java.lang.String inptUsrId;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    public java.math.BigDecimal getPrivGrpNo() {
        return this.privGrpNo;
    }
    
    public void setPrivGrpNo(java.math.BigDecimal privGrpNo) {
        this.privGrpNo = privGrpNo;
    }
    
    public java.lang.String getPrivGrpNm() {
        return this.privGrpNm;
    }
    
    public void setPrivGrpNm(java.lang.String privGrpNm) {
        this.privGrpNm = privGrpNm;
    }
    
    public java.lang.String getPrivGrpDesc() {
        return this.privGrpDesc;
    }
    
    public void setPrivGrpDesc(java.lang.String privGrpDesc) {
        this.privGrpDesc = privGrpDesc;
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
    
}
