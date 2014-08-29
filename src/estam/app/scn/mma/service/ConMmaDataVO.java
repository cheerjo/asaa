package estam.app.scn.mma.service;

import org.joda.time.DateTime;

/**
 * @Class Name : ConMmaDataVO.java
 * @Description : ConMmaData VO class
 * @Modification Information
 *
 * @author ates
 * @since 2013.10.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class ConMmaDataVO extends ConMmaDataDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** MMA_GVMT_CD */
    private java.lang.String mmaGvmtCd;
    
    /** MMA_FCTY_LOC_VAL */
    private java.lang.String mmaFctyLocVal;
    
    /** MMA_MSRD_DT */
    private java.lang.String mmaMsrdDt;
    
    /** MMA_MSRD_SEQ */
    private java.math.BigDecimal mmaMsrdSeq;
    
    /** MMA_DATETIME */
    private DateTime mmaDatetime;
    
    /** MMA_CRC */
    private java.lang.String mmaCrc;
    
    /** MMA_QUTY_FLG */
    private java.lang.String mmaQutyFlg;
    
    /** MMA_DATA_TYPE */
    private java.lang.String mmaDataType;
    
    /** MMA_UD_WND_MIN_VAL */
    private java.math.BigDecimal mmaUdWndMinVal;
    
    /** MMA_UD_WND_MAX_VAL */
    private java.math.BigDecimal mmaUdWndMaxVal;
    
    /** MMA_UD_WND_AVG_VAL */
    private java.math.BigDecimal mmaUdWndAvgVal;
    
    /** MMA_NS_WND_MIN_VAL */
    private java.math.BigDecimal mmaNsWndMinVal;
    
    /** MMA_NS_WND_MAX_VAL */
    private java.math.BigDecimal mmaNsWndMaxVal;
    
    /** MMA_NS_WND_AVG_VAL */
    private java.math.BigDecimal mmaNsWndAvgVal;
    
    /** MMA_EW_WND_MIN_VAL */
    private java.math.BigDecimal mmaEwWndMinVal;
    
    /** MMA_EW_WND_MAX_VAL */
    private java.math.BigDecimal mmaEwWndMaxVal;
    
    /** MMA_EW_WND_AVG_VAL */
    private java.math.BigDecimal mmaEwWndAvgVal;
    
    /** MMA_UD_TRU_MIN_VAL */
    private java.math.BigDecimal mmaUdTruMinVal;
    
    /** MMA_UD_TRU_MAX_VAL */
    private java.math.BigDecimal mmaUdTruMaxVal;
    
    /** MMA_NS_TRU_MIN_VAL */
    private java.math.BigDecimal mmaNsTruMinVal;
    
    /** MMA_NS_TRU_MAX_VAL */
    private java.math.BigDecimal mmaNsTruMaxVal;
    
    /** MMA_EW_TRU_MIN_VAL */
    private java.math.BigDecimal mmaEwTruMinVal;
    
    /** MMA_EW_TRU_MAX_VAL */
    private java.math.BigDecimal mmaEwTruMaxVal;
    
    /** MMA_UD_MAX */
    private java.math.BigDecimal mmaUdMax;
    
    /** MMA_NS_MAX */
    private java.math.BigDecimal mmaNsMax;
    
    /** MMA_EW_MAX */
    private java.math.BigDecimal mmaEwMax;
    
    /** MMA_HRTL_PGA */
    private java.math.BigDecimal mmaHrtlPga;
    
    /** MMA_TOT_PGA */
    private java.math.BigDecimal mmaTotPga;
    
    /** MMA_32B_UD_SI */
    private java.math.BigDecimal mma32bUdSi;
    
    /** MMA_32B_NS_SI */
    private java.math.BigDecimal mma32bNsSi;
    
    /** MMA_32B_EW_SI */
    private java.math.BigDecimal mma32bEwSi;
    
    /** MMA_HRTL_SI */
    private java.math.BigDecimal mmaHrtlSi;
    
    /** MMA_CHCD_1ST */
    private java.lang.String mmaChcd1st;
    
    /** MMA_CHCD_2ST */
    private java.lang.String mmaChcd2st;
    
    /** MMA_CRRN */
    private java.lang.String mmaCrrn;
    
    /** MMA_LOC_CD */
    private java.lang.String mmaLocCd;
    
    /** MMA_DA_PORT */
    private java.lang.String mmaDaPort;
    
    /** INPT_USR_ID */
    private java.lang.String inptUsrId;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** UPDT_USR_ID */
    private java.lang.String updtUsrId;
    
    /** UPDT_DT */
    private java.sql.Date updtDt;
    
    public java.lang.String getMmaGvmtCd() {
        return this.mmaGvmtCd;
    }
    
    public void setMmaGvmtCd(java.lang.String mmaGvmtCd) {
        this.mmaGvmtCd = mmaGvmtCd;
    }
    
    public java.lang.String getMmaFctyLocVal() {
        return this.mmaFctyLocVal;
    }
    
    public void setMmaFctyLocVal(java.lang.String mmaFctyLocVal) {
        this.mmaFctyLocVal = mmaFctyLocVal;
    }
    
    public java.lang.String getMmaMsrdDt() {
        return this.mmaMsrdDt;
    }
    
    public void setMmaMsrdDt(java.lang.String mmaMsrdDt) {
        this.mmaMsrdDt = mmaMsrdDt;
    }
    
    public java.math.BigDecimal getMmaMsrdSeq() {
        return this.mmaMsrdSeq;
    }
    
    public void setMmaMsrdSeq(java.math.BigDecimal mmaMsrdSeq) {
        this.mmaMsrdSeq = mmaMsrdSeq;
    }
    
    public DateTime getMmaDatetime() {
        return this.mmaDatetime;
    }
    
    public void setMmaDatetime(DateTime dateTime) {
        this.mmaDatetime = dateTime;
    }
    
    public java.lang.String getMmaCrc() {
        return this.mmaCrc;
    }
    
    public void setMmaCrc(java.lang.String mmaCrc) {
        this.mmaCrc = mmaCrc;
    }
    
    public java.lang.String getMmaQutyFlg() {
        return this.mmaQutyFlg;
    }
    
    public void setMmaQutyFlg(java.lang.String mmaQutyFlg) {
        this.mmaQutyFlg = mmaQutyFlg;
    }
    
    public java.lang.String getMmaDataType() {
        return this.mmaDataType;
    }
    
    public void setMmaDataType(java.lang.String mmaDataType) {
        this.mmaDataType = mmaDataType;
    }
    
    public java.math.BigDecimal getMmaUdWndMinVal() {
        return this.mmaUdWndMinVal;
    }
    
    public void setMmaUdWndMinVal(java.math.BigDecimal mmaUdWndMinVal) {
        this.mmaUdWndMinVal = mmaUdWndMinVal;
    }
    
    public java.math.BigDecimal getMmaUdWndMaxVal() {
        return this.mmaUdWndMaxVal;
    }
    
    public void setMmaUdWndMaxVal(java.math.BigDecimal mmaUdWndMaxVal) {
        this.mmaUdWndMaxVal = mmaUdWndMaxVal;
    }
    
    public java.math.BigDecimal getMmaUdWndAvgVal() {
        return this.mmaUdWndAvgVal;
    }
    
    public void setMmaUdWndAvgVal(java.math.BigDecimal mmaUdWndAvgVal) {
        this.mmaUdWndAvgVal = mmaUdWndAvgVal;
    }
    
    public java.math.BigDecimal getMmaNsWndMinVal() {
        return this.mmaNsWndMinVal;
    }
    
    public void setMmaNsWndMinVal(java.math.BigDecimal mmaNsWndMinVal) {
        this.mmaNsWndMinVal = mmaNsWndMinVal;
    }
    
    public java.math.BigDecimal getMmaNsWndMaxVal() {
        return this.mmaNsWndMaxVal;
    }
    
    public void setMmaNsWndMaxVal(java.math.BigDecimal mmaNsWndMaxVal) {
        this.mmaNsWndMaxVal = mmaNsWndMaxVal;
    }
    
    public java.math.BigDecimal getMmaNsWndAvgVal() {
        return this.mmaNsWndAvgVal;
    }
    
    public void setMmaNsWndAvgVal(java.math.BigDecimal mmaNsWndAvgVal) {
        this.mmaNsWndAvgVal = mmaNsWndAvgVal;
    }
    
    public java.math.BigDecimal getMmaEwWndMinVal() {
        return this.mmaEwWndMinVal;
    }
    
    public void setMmaEwWndMinVal(java.math.BigDecimal mmaEwWndMinVal) {
        this.mmaEwWndMinVal = mmaEwWndMinVal;
    }
    
    public java.math.BigDecimal getMmaEwWndMaxVal() {
        return this.mmaEwWndMaxVal;
    }
    
    public void setMmaEwWndMaxVal(java.math.BigDecimal mmaEwWndMaxVal) {
        this.mmaEwWndMaxVal = mmaEwWndMaxVal;
    }
    
    public java.math.BigDecimal getMmaEwWndAvgVal() {
        return this.mmaEwWndAvgVal;
    }
    
    public void setMmaEwWndAvgVal(java.math.BigDecimal mmaEwWndAvgVal) {
        this.mmaEwWndAvgVal = mmaEwWndAvgVal;
    }
    
    public java.math.BigDecimal getMmaUdTruMinVal() {
        return this.mmaUdTruMinVal;
    }
    
    public void setMmaUdTruMinVal(java.math.BigDecimal mmaUdTruMinVal) {
        this.mmaUdTruMinVal = mmaUdTruMinVal;
    }
    
    public java.math.BigDecimal getMmaUdTruMaxVal() {
        return this.mmaUdTruMaxVal;
    }
    
    public void setMmaUdTruMaxVal(java.math.BigDecimal mmaUdTruMaxVal) {
        this.mmaUdTruMaxVal = mmaUdTruMaxVal;
    }
    
    public java.math.BigDecimal getMmaNsTruMinVal() {
        return this.mmaNsTruMinVal;
    }
    
    public void setMmaNsTruMinVal(java.math.BigDecimal mmaNsTruMinVal) {
        this.mmaNsTruMinVal = mmaNsTruMinVal;
    }
    
    public java.math.BigDecimal getMmaNsTruMaxVal() {
        return this.mmaNsTruMaxVal;
    }
    
    public void setMmaNsTruMaxVal(java.math.BigDecimal mmaNsTruMaxVal) {
        this.mmaNsTruMaxVal = mmaNsTruMaxVal;
    }
    
    public java.math.BigDecimal getMmaEwTruMinVal() {
        return this.mmaEwTruMinVal;
    }
    
    public void setMmaEwTruMinVal(java.math.BigDecimal mmaEwTruMinVal) {
        this.mmaEwTruMinVal = mmaEwTruMinVal;
    }
    
    public java.math.BigDecimal getMmaEwTruMaxVal() {
        return this.mmaEwTruMaxVal;
    }
    
    public void setMmaEwTruMaxVal(java.math.BigDecimal mmaEwTruMaxVal) {
        this.mmaEwTruMaxVal = mmaEwTruMaxVal;
    }
    
    public java.math.BigDecimal getMmaUdMax() {
        return this.mmaUdMax;
    }
    
    public void setMmaUdMax(java.math.BigDecimal mmaUdMax) {
        this.mmaUdMax = mmaUdMax;
    }
    
    public java.math.BigDecimal getMmaNsMax() {
        return this.mmaNsMax;
    }
    
    public void setMmaNsMax(java.math.BigDecimal mmaNsMax) {
        this.mmaNsMax = mmaNsMax;
    }
    
    public java.math.BigDecimal getMmaEwMax() {
        return this.mmaEwMax;
    }
    
    public void setMmaEwMax(java.math.BigDecimal mmaEwMax) {
        this.mmaEwMax = mmaEwMax;
    }
    
    public java.math.BigDecimal getMmaHrtlPga() {
        return this.mmaHrtlPga;
    }
    
    public void setMmaHrtlPga(java.math.BigDecimal mmaHrtlPga) {
        this.mmaHrtlPga = mmaHrtlPga;
    }
    
    public java.math.BigDecimal getMmaTotPga() {
        return this.mmaTotPga;
    }
    
    public void setMmaTotPga(java.math.BigDecimal mmaTotPga) {
        this.mmaTotPga = mmaTotPga;
    }
    
    public java.math.BigDecimal getMma32bUdSi() {
        return this.mma32bUdSi;
    }
    
    public void setMma32bUdSi(java.math.BigDecimal mma32bUdSi) {
        this.mma32bUdSi = mma32bUdSi;
    }
    
    public java.math.BigDecimal getMma32bNsSi() {
        return this.mma32bNsSi;
    }
    
    public void setMma32bNsSi(java.math.BigDecimal mma32bNsSi) {
        this.mma32bNsSi = mma32bNsSi;
    }
    
    public java.math.BigDecimal getMma32bEwSi() {
        return this.mma32bEwSi;
    }
    
    public void setMma32bEwSi(java.math.BigDecimal mma32bEwSi) {
        this.mma32bEwSi = mma32bEwSi;
    }
    
    public java.math.BigDecimal getMmaHrtlSi() {
        return this.mmaHrtlSi;
    }
    
    public void setMmaHrtlSi(java.math.BigDecimal mmaHrtlSi) {
        this.mmaHrtlSi = mmaHrtlSi;
    }
    
    public java.lang.String getMmaChcd1st() {
        return this.mmaChcd1st;
    }
    
    public void setMmaChcd1st(java.lang.String mmaChcd1st) {
        this.mmaChcd1st = mmaChcd1st;
    }
    
    public java.lang.String getMmaChcd2st() {
        return this.mmaChcd2st;
    }
    
    public void setMmaChcd2st(java.lang.String mmaChcd2st) {
        this.mmaChcd2st = mmaChcd2st;
    }
    
    public java.lang.String getMmaCrrn() {
        return this.mmaCrrn;
    }
    
    public void setMmaCrrn(java.lang.String mmaCrrn) {
        this.mmaCrrn = mmaCrrn;
    }
    
    public java.lang.String getMmaLocCd() {
        return this.mmaLocCd;
    }
    
    public void setMmaLocCd(java.lang.String mmaLocCd) {
        this.mmaLocCd = mmaLocCd;
    }
    
    public java.lang.String getMmaDaPort() {
        return this.mmaDaPort;
    }
    
    public void setMmaDaPort(java.lang.String mmaDaPort) {
        this.mmaDaPort = mmaDaPort;
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
