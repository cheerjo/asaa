package estam.app.main.service;

import java.io.Serializable;

/**
 * @Class Name : MainMapLocationVO.java
 * @Description : MainMapLocation  VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 20130703
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class MainMapLocationVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** typeid */
    private java.lang.String typeId; 
     
    /** 시설물코드 */
    private java.lang.String fctyCd; 
    
    /** 시설물명 */
    private java.lang.String fctyNm; 
    
    /** 경도 */
    private java.lang.String fctyLon;
   
    
    /** 위도 */
    private java.lang.String fctyLat;
    
    /** 표출이미지 링크 */
    private java.lang.String viewImgLink;
    
    /** 주소 */
    private java.lang.String fctyAddr;
    
    /** 안전상태값 */
    private java.lang.String sfState;

	public java.lang.String getTypeId() {
		return typeId;
	}

	public void setTypeId(java.lang.String typeId) {
		this.typeId = typeId;
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

	public java.lang.String getFctyLon() {
		return fctyLon;
	}

	public void setFctyLon(java.lang.String fctyLon) {
		this.fctyLon = fctyLon;
	}

	public java.lang.String getFctyLat() {
		return fctyLat;
	}

	public void setFctyLat(java.lang.String fctyLat) {
		this.fctyLat = fctyLat;
	}

	public java.lang.String getViewImgLink() {
		return viewImgLink;
	}

	public void setViewImgLink(java.lang.String viewImgLink) {
		this.viewImgLink = viewImgLink;
	}

	public java.lang.String getFctyAddr() {
		return fctyAddr;
	}

	public void setFctyAddr(java.lang.String fctyAddr) {
		this.fctyAddr = fctyAddr;
	}

	public java.lang.String getSfState() {
		return sfState;
	}

	public void setSfState(java.lang.String sfState) {
		this.sfState = sfState;
	} 
 
    
}
