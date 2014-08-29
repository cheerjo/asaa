package estam.app.main.service;

import java.io.Serializable;

/**
 * @Class Name : SymMenuVO.java
 * @Description : SymMenu VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 20130703
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class MainEventSensVO implements Serializable {
    private static final long serialVersionUID = 1L;
    

	/** 시각 */
    private java.lang.String currDateTime;
     
    /** 시설코드 */
    private  java.lang.String fctyCd; 
    
    /** 시설명 */
    private java.lang.String fctyNm;
    
    /** 연락처 */
    private java.lang.String fctyUsrTel;
    
    /** 위도 */
    private java.lang.String fctyLat;
    
    /** 경도 */
    private java.lang.String fctyLon;
     
    /** 계측PGA */
    private java.math.BigDecimal EvntSensPga;
     
    /** 이상진동감지 개소 */
    private java.lang.String EvntSensCnt;
     
    /** 전체 개소 */
    private java.lang.String fctyTotCnt;
    
    
    
    public java.lang.String getCurrDateTime() {
		return currDateTime;
	}

	public void setCurrDateTime(java.lang.String currDateTime) {
		this.currDateTime = currDateTime;
	}

	public java.lang.String getFctyCd() {
		return fctyCd;
	}

	public void setFctyCd(java.lang.String fctyCd) {
		this.fctyCd = fctyCd;
	}

	public java.lang.String getFctyNm() {
		return fctyNm;
	}

	public void setFctyNm(java.lang.String fctyNm) {
		this.fctyNm = fctyNm;
	}

	public java.lang.String getFctyUsrTel() {
		return fctyUsrTel;
	}

	public void setFctyUsrTel(java.lang.String fctyUsrTel) {
		this.fctyUsrTel = fctyUsrTel;
	}

	public java.lang.String getFctyLat() {
		return fctyLat;
	}

	public void setFctyLat(java.lang.String fctyLat) {
		this.fctyLat = fctyLat;
	}

	public java.lang.String getFctyLon() {
		return fctyLon;
	}

	public void setFctyLon(java.lang.String fctyLon) {
		this.fctyLon = fctyLon;
	}

	public java.math.BigDecimal getEvntSensPga() {
		return EvntSensPga;
	}

	public void setEvntSensPga(java.math.BigDecimal evntSensPga) {
		EvntSensPga = evntSensPga;
	}

	public java.lang.String getEvntSensCnt() {
		return EvntSensCnt;
	}

	public void setEvntSensCnt(java.lang.String evntSensCnt) {
		EvntSensCnt = evntSensCnt;
	}

	public java.lang.String getFctyTotCnt() {
		return fctyTotCnt;
	}

	public void setFctyTotCnt(java.lang.String fctyTotCnt) {
		this.fctyTotCnt = fctyTotCnt;
	}

    
}
