package estam.app.fcty.service;

/**
 * @Class Name : FctyStatSensVO.java
 * @Description : FctyStatSens VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class FctyStatSensVO extends FctyStatSensDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** FCTY_CD */
    private java.lang.String fctyCd;
    
    /** GVMT_CD */
    private java.lang.String gvmtCd;
    
    /** FCTY_STAT_SENS_GBCD */
    private java.lang.String fctyStatSensGbcd;
    
    /** FCTY_STAT_SENS_TM */
    private java.lang.String fctyStatSensTm;
    
    /** FCTY_STAT_SENS_PGA */
    private java.math.BigDecimal fctyStatSensPga;
     
    
    /** 시설명 */
    private java.lang.String fctyNm;
    
    /** 연락처 */
    private java.lang.String fctyUsrTel;
    
    /** 위도 */
    private java.lang.String fctyLat;
    
    /** 경도 */
    private java.lang.String fctyLon;
    
    /** FCTY_KND_CD */
    private java.lang.String fctyKndCd;
    /** FCTY_KND_NM */
    private java.lang.String fctyKndNm;
    
    
    
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

	/**
	 * @return the fctyUsrTel
	 */
	public java.lang.String getFctyUsrTel() {
		return fctyUsrTel;
	}

	/**
	 * @param fctyUsrTel the fctyUsrTel to set
	 */
	public void setFctyUsrTel(java.lang.String fctyUsrTel) {
		this.fctyUsrTel = fctyUsrTel;
	}

	/**
	 * @return the fctyLat
	 */
	public java.lang.String getFctyLat() {
		return fctyLat;
	}

	/**
	 * @param fctyLat the fctyLat to set
	 */
	public void setFctyLat(java.lang.String fctyLat) {
		this.fctyLat = fctyLat;
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

	public java.lang.String getFctyCd() {
        return this.fctyCd;
    }
    
    public void setFctyCd(java.lang.String fctyCd) {
        this.fctyCd = fctyCd;
    }
    
    public java.lang.String getFctyStatSensGbcd() {
        return this.fctyStatSensGbcd;
    }
    
    public void setFctyStatSensGbcd(java.lang.String fctyStatSensGbcd) {
        this.fctyStatSensGbcd = fctyStatSensGbcd;
    }
    
    public java.lang.String getFctyStatSensTm() {
        return this.fctyStatSensTm;
    }
    
    public void setFctyStatSensTm(java.lang.String fctyStatSensTm) {
        this.fctyStatSensTm = fctyStatSensTm;
    }
    
    public java.math.BigDecimal getFctyStatSensPga() {
        return this.fctyStatSensPga;
    }
    
    public void setFctyStatSensPga(java.math.BigDecimal fctyStatSensPga) {
        this.fctyStatSensPga = fctyStatSensPga;
    }
    
}
