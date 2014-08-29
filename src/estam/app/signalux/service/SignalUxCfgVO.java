package estam.app.signalux.service;

/**
 * @Class Name : SignalUxCfgVO.java
 * @Description : SignalUxCfg VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.08.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SignalUxCfgVO extends SignalUxCfgDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** CD */
    private java.lang.String cd;
    
    /** CD_NM */
    private java.lang.String cdNm;
    
    /** CD_DESC */
    private java.lang.String cdDesc;
    
    /** USE_YN */
    private java.lang.String useYn;
    
    /** UDT_USER */
    private java.lang.String udtUser;
    
    /** UDT_DT */
    private java.sql.Date udtDt;
    
    /** GR_CD */
    private java.lang.String grCd;
    
    /** DISP_ORDER */
    private java.math.BigDecimal dispOrder;
    
    public java.lang.String getCd() {
        return this.cd;
    }
    
    public void setCd(java.lang.String cd) {
        this.cd = cd;
    }
    
    public java.lang.String getCdNm() {
        return this.cdNm;
    }
    
    public void setCdNm(java.lang.String cdNm) {
        this.cdNm = cdNm;
    }
    
    public java.lang.String getCdDesc() {
        return this.cdDesc;
    }
    
    public void setCdDesc(java.lang.String cdDesc) {
        this.cdDesc = cdDesc;
    }
    
    public java.lang.String getUseYn() {
        return this.useYn;
    }
    
    public void setUseYn(java.lang.String useYn) {
        this.useYn = useYn;
    }
    
    public java.lang.String getUdtUser() {
        return this.udtUser;
    }
    
    public void setUdtUser(java.lang.String udtUser) {
        this.udtUser = udtUser;
    }
    
    public java.sql.Date getUdtDt() {
        return this.udtDt;
    }
    
    public void setUdtDt(java.sql.Date udtDt) {
        this.udtDt = udtDt;
    }
    
    public java.lang.String getGrCd() {
        return this.grCd;
    }
    
    public void setGrCd(java.lang.String grCd) {
        this.grCd = grCd;
    }
    
    public java.math.BigDecimal getDispOrder() {
        return this.dispOrder;
    }
    
    public void setDispOrder(java.math.BigDecimal dispOrder) {
        this.dispOrder = dispOrder;
    }
    
}
