package estam.app.sym.usr.service;

import java.io.Serializable;

/**
 * @Class Name : SymPrivGrpCboVO.java
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
public class SymPrivGrpCboVO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** PRIV_GRP_NO */
    private java.math.BigDecimal privGrpNo;
    
    /** PRIV_GRP_NM */
    private java.lang.String privGrpNm;
     
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
    
}
