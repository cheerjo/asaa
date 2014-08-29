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
public class MainScnErSensVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** 시각 */
    private java.lang.String currDateTime;
     
    /** 시설코드 */
    private  java.lang.String fctyCd;
    
    /** 시설명 */
    private java.lang.String fctyNm;
    
    /** 시설물종류명 */
    private java.lang.String fctyKndNm;
    
    /** 연락처 */
    private java.lang.String fctyUsrTel;
    
    /** 위도 */
    private java.lang.String fctyLat;
    
    /** 경도 */
    private java.lang.String fctyLon;
     
    /** 이상진동감지 개소 */
    private java.lang.String EvntErSensCnt;
     
    /** 전체 개소 */
    private java.lang.String fctyTotCnt;

	public java.lang.String getCurrDateTime() {
		return currDateTime;
	}

	public void setCurrDateTime(java.lang.String currDateTime) {
		this.currDateTime = currDateTime;
	}

	public  java.lang.String getFctyCd() {
		return fctyCd;
	}

	public void setFctyCd( java.lang.String fctyCd) {
		this.fctyCd = fctyCd;
	}

	public java.lang.String getFctyNm() {
		return fctyNm;
	}

	public void setFctyNm(java.lang.String fctyNm) {
		this.fctyNm = fctyNm;
	}

	public java.lang.String getFctyKndNm() {
		return fctyKndNm;
	}

	public void setFctyKndNm(java.lang.String fctyKndNm) {
		this.fctyKndNm = fctyKndNm;
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

	public java.lang.String getEvntErSensCnt() {
		return EvntErSensCnt;
	}

	public void setEvntErSensCnt(java.lang.String evntErSensCnt) {
		EvntErSensCnt = evntErSensCnt;
	}

	public java.lang.String getFctyTotCnt() {
		return fctyTotCnt;
	}

	public void setFctyTotCnt(java.lang.String fctyTotCnt) {
		this.fctyTotCnt = fctyTotCnt;
	}
     
    
    
    
}
