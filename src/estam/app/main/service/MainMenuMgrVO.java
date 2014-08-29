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
public class MainMenuMgrVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** MENU_CD */
    private java.lang.String menuCd;
    
    
    /** DISPLAY_LVL */
    private java.math.BigDecimal displayLvl;
    
    /** UP_MENU_CD */
    private java.lang.String upMenuCd;
    
    /** SITE_GBCD */
    private java.lang.String siteGbcd;
    
    /** MENU_NM */
    private java.lang.String menuNm;
    
    /** MENU_DESC */
    private java.lang.String menuDesc;
    
    /** RE_MARK */
    private java.lang.String reMark;
    
    /** LINK_URL */
    private java.lang.String linkUrl;
    
    /** LINK_URL_IMG */
    private java.lang.String linkUrlImg; 

	/** DPLY_NO */
    private java.math.BigDecimal dplyNo;
    
    /** USE_YN */
    private java.lang.String useYn;
    
    /** INPT_USR_ID */
    private java.lang.String inptUsrId;
    
    /** UPDT_USR_ID */
    private java.lang.String updtUsrId;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** UPDT_DT */
    private java.sql.Date updtDt;
    
    /**PRIV_GRP_NO */
    private java.math.BigDecimal privGrpNo;
    
    public java.math.BigDecimal getPrivGrpNo() {
		return privGrpNo;
	}

	public void setPrivGrpNo(java.math.BigDecimal privGrpNo) {
		this.privGrpNo = privGrpNo;
	}

	public java.lang.String getMenuCd() {
        return this.menuCd;
    }
    
    public void setMenuCd(java.lang.String menuCd) {
        this.menuCd = menuCd;
    }
    
    
    public java.math.BigDecimal getDisplayLvl() {
		return displayLvl;
	}

	public void setDisplayLvl(java.math.BigDecimal displayLvl) {
		this.displayLvl = displayLvl;
	}

	public java.lang.String getUpMenuCd() {
        return this.upMenuCd;
    }
    
    public void setUpMenuCd(java.lang.String upMenuCd) {
        this.upMenuCd = upMenuCd;
    }
    
    public java.lang.String getSiteGbcd() {
        return this.siteGbcd;
    }
    
    public void setSiteGbcd(java.lang.String siteGbcd) {
        this.siteGbcd = siteGbcd;
    }
    
    public java.lang.String getMenuNm() {
        return this.menuNm;
    }
    
    public void setMenuNm(java.lang.String menuNm) {
        this.menuNm = menuNm;
    }
    
    public java.lang.String getMenuDesc() {
        return this.menuDesc;
    }
    
    public void setMenuDesc(java.lang.String menuDesc) {
        this.menuDesc = menuDesc;
    }
    
    public java.lang.String getReMark() {
        return this.reMark;
    }
    
    public void setReMark(java.lang.String reMark) {
        this.reMark = reMark;
    }
    
    public java.lang.String getLinkUrl() {
        return this.linkUrl;
    }
    
    public void setLinkUrl(java.lang.String linkUrl) {
        this.linkUrl = linkUrl;
    }
    
    public java.lang.String getLinkUrlImg() {
		return this.linkUrlImg;
	}

	public void setLinkUrlImg(java.lang.String linkUrlImg) {
		this.linkUrlImg = linkUrlImg;
	}
	
    public java.math.BigDecimal getDplyNo() {
        return this.dplyNo;
    }
    
    public void setDplyNo(java.math.BigDecimal dplyNo) {
        this.dplyNo = dplyNo;
    }
    
    public java.lang.String getUseYn() {
        return this.useYn;
    }
    
    public void setUseYn(java.lang.String useYn) {
        this.useYn = useYn;
    }
    
    public java.lang.String getInptUsrId() {
        return this.inptUsrId;
    }
    
    public void setInptUsrId(java.lang.String inptUsrId) {
        this.inptUsrId = inptUsrId;
    }
    
    public java.lang.String getUpdtUsrId() {
        return this.updtUsrId;
    }
    
    public void setUpdtUsrId(java.lang.String updtUsrId) {
        this.updtUsrId = updtUsrId;
    }
    
    public java.sql.Date getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.sql.Date inptDt) {
        this.inptDt = inptDt;
    }
    
    public java.sql.Date getUpdtDt() {
        return this.updtDt;
    }
    
    public void setUpdtDt(java.sql.Date updtDt) {
        this.updtDt = updtDt;
    }
    
}
