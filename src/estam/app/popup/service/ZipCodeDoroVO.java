/**
 * 
 *  project
 * 
 * Copyright(c) 2013
 * All rights reserved.
 *
 */
package estam.app.popup.service;

import egovframework.com.cmm.ComDefaultVO;

/**
 * The Class ZipCodeDoroVO.
 *
 * @Project     :  
 * @Date         : 2013. 09. 06
 * @작성자      :  개발팀
 * @변경이력 : 초기생성
 * @프로그램 설명 : (도로명주소)우편번호VO
 */
public class ZipCodeDoroVO extends ComDefaultVO {
	
	/** 법정동코드 */
	private String lawDongCd;	 

    /** 시도명 */
	private String sido;	     

    /** 시군구명 */
	private String sigungu;	     

    /** 법정읍면동명 */
	private String lawDong;	     

    /** 법정리명 */
	private String lawRi;	     

    /** 산구분(0:토지,1:산) */
	private String sanFlag;	     

    /** 지번본번 */
	private String addrMainNo;	 

    /** 지번부번 */
	private String addrSubNo;	 

    /** 도로명코드(시군구(5)+도로명번호(7)) */
	private String doroCd;	     

    /** 도로명 */
	private String doroNm;	     

    /** 지하구분(0:지상,1:지하,2:공중) */
	private String underFlag;	 
	
    /** 건물본번 */
	private String bldgMainNo;	 
	
    /** 건물부번 */
	private String bldgSubNo;	 
	
    /** 건축물대장 건물명 */
	private String bldgNm;	     
	
    /** 상세건물명 */
	private String bldgNmDetl;	 
	
    /** 건물관리번호 */
	private String bldgMngNo;	 
	
    /** 읍면동일련번호 */
	private String dongSn;	     

    /** 행정동코드 */
	private String admDongCd;	 

    /** 행정동명 */
	private String admDongNm;	 
	
    /** 우편번호 */
	private String zip;	         
	
    /** 우편일련번호 */
	private String zipSn;	     

    /** 다량배달처명 */
	private String dlvrNm;	     
	
    /** 이동사유코드 */
	private String chgCauseCd;	 
	
    /** 변경일자 */
	private String chgYmd;	     
	
    /** 변경전도로명주소 */
	private String chgBefore;	 
	
    /** 시군구용건물명 */
	private String bldgNmSigumgu;
	
    /** 분공동주택구분(0:비공동주택,1:공동주택) */
	private String aptFlag;
	
	/** 시군구명(검색용) */
	private String pSigungu;
	
	/** 법정읍면동명(검색용) */
	private String pLawDong;
	
	/** 도로명(검색용) */
	private String pDoroNm;
	
	/** 건축물대장 건물명(검색용) */
	private String pBldgNm;	  
	

	public String getLawDongCd() {
		return lawDongCd;
	}

	public void setLawDongCd(String lawDongCd) {
		this.lawDongCd = lawDongCd;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getLawDong() {
		return lawDong;
	}

	public void setLawDong(String lawDong) {
		this.lawDong = lawDong;
	}

	public String getLawRi() {
		return lawRi;
	}

	public void setLawRi(String lawRi) {
		this.lawRi = lawRi;
	}

	public String getSanFlag() {
		return sanFlag;
	}

	public void setSanFlag(String sanFlag) {
		this.sanFlag = sanFlag;
	}

	public String getAddrMainNo() {
		return addrMainNo;
	}

	public void setAddrMainNo(String addrMainNo) {
		this.addrMainNo = addrMainNo;
	}

	public String getAddrSubNo() {
		return addrSubNo;
	}

	public void setAddrSubNo(String addrSubNo) {
		this.addrSubNo = addrSubNo;
	}

	public String getDoroCd() {
		return doroCd;
	}

	public void setDoroCd(String doroCd) {
		this.doroCd = doroCd;
	}

	public String getDoroNm() {
		return doroNm;
	}

	public void setDoroNm(String doroNm) {
		this.doroNm = doroNm;
	}

	public String getUnderFlag() {
		return underFlag;
	}

	public void setUnderFlag(String underFlag) {
		this.underFlag = underFlag;
	}

	public String getBldgMainNo() {
		return bldgMainNo;
	}

	public void setBldgMainNo(String bldgMainNo) {
		this.bldgMainNo = bldgMainNo;
	}

	public String getBldgSubNo() {
		return bldgSubNo;
	}

	public void setBldgSubNo(String bldgSubNo) {
		this.bldgSubNo = bldgSubNo;
	}

	public String getBldgNm() {
		return bldgNm;
	}

	public void setBldgNm(String bldgNm) {
		this.bldgNm = bldgNm;
	}

	public String getBldgNmDetl() {
		return bldgNmDetl;
	}

	public void setBldgNmDetl(String bldgNmDetl) {
		this.bldgNmDetl = bldgNmDetl;
	}

	public String getBldgMngNo() {
		return bldgMngNo;
	}

	public void setBldgMngNo(String bldgMngNo) {
		this.bldgMngNo = bldgMngNo;
	}

	public String getDongSn() {
		return dongSn;
	}

	public void setDongSn(String dongSn) {
		this.dongSn = dongSn;
	}

	public String getAdmDongCd() {
		return admDongCd;
	}

	public void setAdmDongCd(String admDongCd) {
		this.admDongCd = admDongCd;
	}

	public String getAdmDongNm() {
		return admDongNm;
	}

	public void setAdmDongNm(String admDongNm) {
		this.admDongNm = admDongNm;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getZipSn() {
		return zipSn;
	}

	public void setZipSn(String zipSn) {
		this.zipSn = zipSn;
	}

	public String getDlvrNm() {
		return dlvrNm;
	}

	public void setDlvrNm(String dlvrNm) {
		this.dlvrNm = dlvrNm;
	}

	public String getChgCauseCd() {
		return chgCauseCd;
	}

	public void setChgCauseCd(String chgCauseCd) {
		this.chgCauseCd = chgCauseCd;
	}

	public String getChgYmd() {
		return chgYmd;
	}

	public void setChgYmd(String chgYmd) {
		this.chgYmd = chgYmd;
	}

	public String getChgBefore() {
		return chgBefore;
	}

	public void setChgBefore(String chgBefore) {
		this.chgBefore = chgBefore;
	}

	public String getBldgNmSigumgu() {
		return bldgNmSigumgu;
	}

	public void setBldgNmSigumgu(String bldgNmSigumgu) {
		this.bldgNmSigumgu = bldgNmSigumgu;
	}

	public String getAptFlag() {
		return aptFlag;
	}

	public void setAptFlag(String aptFlag) {
		this.aptFlag = aptFlag;
	}

	public String getpLawDong() {
		return pLawDong;
	}

	public void setpLawDong(String pLawDong) {
		this.pLawDong = pLawDong;
	}

	public String getpDoroNm() {
		return pDoroNm;
	}

	public void setpDoroNm(String pDoroNm) {
		this.pDoroNm = pDoroNm;
	}

	public String getpBldgNm() {
		return pBldgNm;
	}

	public void setpBldgNm(String pBldgNm) {
		this.pBldgNm = pBldgNm;
	}

	public String getpSigungu() {
		return pSigungu;
	}

	public void setpSigungu(String pSigungu) {
		this.pSigungu = pSigungu;
	}
	
}
