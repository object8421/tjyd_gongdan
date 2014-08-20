package com.chinaops.web.common.entity;

import org.dom4j.Element;
/**
 * Description: 
 * @version 2014-4-2 上午10:09:51 马宁涛 （ningtao.ma@china-ops.com） 创建
 */
public class Page {

    private int currentPage = 1;
    private int totalPage = 0;
    private int totalNumber = 0;
    private Object list;
    private int pageNo = 1;// 第几页
    private int pageSize = 20;// 页面大小

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
	return currentPage;
    }

    public void setCurrentPage(int currentPage2) {
	this.currentPage = currentPage2;
    }

    public int getTotalPage() {
	return totalPage;
    }

    public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
    }

    public int getTotalNumber() {
	return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
	this.totalNumber = totalNumber;
    }

    public Object getList() {
	return list;
    }

    public void setList(Object list) {
	this.list = list;
    }

    //添加分页显示
    public void addPage(Element rootElem, Page page) {
	int pre = 1;
	int next = page.getCurrentPage();

	if (page.getCurrentPage() > 1) {
	    pre = page.getCurrentPage() - 1;
	}
	if (page.getCurrentPage() < page.getTotalPage()) {
	    next = page.getCurrentPage() + 1;
	}

	Element objElementPageNumberList = rootElem.addElement("pagenumlist")
		.addAttribute("totalpage", page.getTotalPage() + "")
		.addAttribute("totalsize", page.getTotalNumber() + "")
		.addAttribute("currentpage", page.getCurrentPage() + "")
		.addAttribute("prepage", pre + "").addAttribute("nextpage",
			next + "");

	int showPageCount = 7;
	int startPage = 1;
	int endPage = 1;
	if (page.getTotalPage() <= showPageCount) {
	    startPage = 1;
	    endPage = page.getTotalPage();
	} else {
	    if (pageNo - (showPageCount / 2) < 1) {
		startPage = 1;
		endPage = showPageCount;
	    } else if (pageNo + (showPageCount / 2) > page.getTotalPage()) {
		startPage = pageNo - (showPageCount / 2);
		endPage = page.getTotalPage();
	    } else {
		startPage = pageNo - (showPageCount / 2);
		endPage = pageNo + (showPageCount / 2);
	    }
	}
	for (int i = startPage; i <= endPage; i++) {
	    if (pageNo == i) {
		objElementPageNumberList.addElement("pagenum").addAttribute(
			"page", i + "").addAttribute("iscurrentpage", "true");
	    } else {
		objElementPageNumberList.addElement("pagenum").addAttribute(
			"page", i + "").addAttribute("iscurrentpage", "false");
	    }
	}
    }
}
