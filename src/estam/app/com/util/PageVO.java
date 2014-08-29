package estam.app.com.util;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import egovframework.rte.fdl.property.EgovPropertyService;

@Component
public class PageVO implements InitializingBean {

	private int totalItems;
	private int pageSize;
	private int pageUnit;
	private int currPage;
	private int totalPages;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

	public static int defaultPageSize;
	public static int defaultPageUnit;

	public void afterPropertiesSet() throws Exception {
		defaultPageSize = propertyService.getInt("pageSize");
		defaultPageUnit = propertyService.getInt("pageUnit");
	}

	public PageVO() {
	}

	public PageVO(int currPage, int totalItems) {
		this.totalItems = totalItems;
		this.pageSize = defaultPageSize;
		this.pageUnit = defaultPageUnit;
		this.totalPages = (totalItems - 1) / this.pageSize + 1;
		this.currPage = (currPage > this.totalPages) ? this.totalPages
				: currPage;
	}

	public PageVO(int currPage, int totalItems, int pageSize) {
		this.totalItems = totalItems;
		this.pageSize = pageSize;
		this.pageUnit = defaultPageUnit;
		this.totalPages = (totalItems - 1) / this.pageSize + 1;
		this.currPage = (currPage > this.totalPages) ? this.totalPages
				: currPage;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageUnit() {
		return pageUnit;
	}

	public int getCurrPage() {
		return currPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getFirstLinkedPage() {
		return (currPage - 1) / pageUnit * pageUnit + 1;
	}

	public int getLastLinkedPage() {
		int lastLinkedPage = getFirstLinkedPage() + pageUnit - 1;
		return (lastLinkedPage > totalPages) ? totalPages : lastLinkedPage;
	}

	public int getPrevLinkedPage() {
		return getFirstLinkedPage() - 1;
	}

	public int getNextLinkedPage() {
		int nextLinkedPage = getLastLinkedPage() + 1;
		return (nextLinkedPage > totalPages) ? 0 : nextLinkedPage;
	}
}
