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
public class FctyMmaVO extends ConMmaDataDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /**  GVMT_CD */
    private java.lang.String gvmtCd;
    
    /** fctyCd */
    private java.lang.String fctyCd; 
    
    /** MMA_MSRD_DT */
    private java.lang.String fctyKndCd; 
    
    /** MMA_CRC */
    private java.lang.String fctyKndNm;
    
    /** MMA_QUTY_FLG */
    private java.lang.String fctyNm;
    
    /** MMA_DATA_TYPE */
    private java.lang.String fctyLon;
    
    /** MMA_UD_WND_MIN_VAL */
    private java.math.BigDecimal fctyLat;
    
    /** MMA_UD_WND_MAX_VAL */
    private java.math.BigDecimal fctyMma;
    
    /** MMA_UD_WND_AVG_VAL */
    private java.math.BigDecimal fctyPga;

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

	/**
	 * @return the fctyCd
	 */
	public java.lang.String getFctyCd() {
		return fctyCd;
	}

	/**
	 * @param fctyCd the fctyCd to set
	 */
	public void setFctyCd(java.lang.String fctyCd) {
		this.fctyCd = fctyCd;
	}

	/**
	 * @return the fctyKndCd
	 */
	public java.lang.String getFctyKndCd() {
		return fctyKndCd;
	}

	/**
	 * @param fctyKndCd the fctyKndCd to set
	 */
	public void setFctyKndCd(java.lang.String fctyKndCd) {
		this.fctyKndCd = fctyKndCd;
	}

	/**
	 * @return the fctyKndNm
	 */
	public java.lang.String getFctyKndNm() {
		return fctyKndNm;
	}

	/**
	 * @param fctyKndNm the fctyKndNm to set
	 */
	public void setFctyKndNm(java.lang.String fctyKndNm) {
		this.fctyKndNm = fctyKndNm;
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

	/**
	 * @return the fctyLon
	 */
	public java.lang.String getFctyLon() {
		return fctyLon;
	}

	/**
	 * @param fctyLon the fctyLon to set
	 */
	public void setFctyLon(java.lang.String fctyLon) {
		this.fctyLon = fctyLon;
	}

	/**
	 * @return the fctyLat
	 */
	public java.math.BigDecimal getFctyLat() {
		return fctyLat;
	}

	/**
	 * @param fctyLat the fctyLat to set
	 */
	public void setFctyLat(java.math.BigDecimal fctyLat) {
		this.fctyLat = fctyLat;
	}

	/**
	 * @return the fctyMma
	 */
	public java.math.BigDecimal getFctyMma() {
		return fctyMma;
	}

	/**
	 * @param fctyMma the fctyMma to set
	 */
	public void setFctyMma(java.math.BigDecimal fctyMma) {
		this.fctyMma = fctyMma;
	}

	/**
	 * @return the fctyPga
	 */
	public java.math.BigDecimal getFctyPga() {
		return fctyPga;
	}

	/**
	 * @param fctyPga the fctyPga to set
	 */
	public void setFctyPga(java.math.BigDecimal fctyPga) {
		this.fctyPga = fctyPga;
	}
     
    
}
