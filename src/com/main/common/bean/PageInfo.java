package com.main.common.bean;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.Page;
import com.main.common.util.CookieUtils;

@SuppressWarnings({"rawtypes", "unchecked"})
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //��ǰҳ
    private int pageNum;
    //ÿҳ������
    private int pageSize;
    //��ǰҳ������
    private int size;
    //����startRow��endRow�����ã�����˵��������÷�
    //������ҳ����"��ʾstartRow��endRow ��size������"

    //��ǰҳ���һ��Ԫ�������ݿ��е��к�
    private int startRow;
    //��ǰҳ�����һ��Ԫ�������ݿ��е��к�
    private int endRow;
    //�ܼ�¼��
    private long total;
    //��ҳ��
    private int pages;
    //�����
    private List<T> list;

    //��һҳ
    private int firstPage;
    //ǰһҳ
    private int prePage;
    //��һҳ
    private int nextPage;
    //���һҳ
    private int lastPage;

    //�Ƿ�Ϊ��һҳ
    private boolean isFirstPage = false;
    //�Ƿ�Ϊ���һҳ
    private boolean isLastPage = false;
    //�Ƿ���ǰһҳ
    private boolean hasPreviousPage = false;
    //�Ƿ�����һҳ
    private boolean hasNextPage = false;
    //����ҳ����
    private int navigatePages;
    //���е���ҳ��
    private int[] navigatepageNums;

    /**
     * ��װPage����
     *
     * @param list
     */
    public PageInfo(List<T> list) {
        this(list, 8);
    }
    
    /**
	 * ���췽��
	 * @param request ���� repage ����������סҳ��
	 * @param response �������� Cookie����סҳ��
	 */
	public PageInfo(HttpServletRequest request, HttpServletResponse response){
		this(request, response, -2);
	}
	
	
	/**
	 * ���췽��
	 * @param request ���� repage ����������סҳ��
	 * @param response �������� Cookie����סҳ��
	 * @param defaultPageSize Ĭ�Ϸ�ҳ��С��������� -1 ��Ϊ����ҳ��������������
	 */
	public PageInfo(HttpServletRequest request, HttpServletResponse response, int defaultPageSize){
		// ����ҳ�����������repage����������סҳ�룩
		String no = request.getParameter("pageNo");
		if (StringUtils.isNumeric(no)){
			CookieUtils.setCookie(response, "pageNo", no);
			this.setPageNum(Integer.parseInt(no));
		}else if (request.getParameter("repage")!=null){
			no = CookieUtils.getCookie(request, "pageNo");
			if (StringUtils.isNumeric(no)){
				this.setPageNum(Integer.parseInt(no));
			}
		}
		// ����ҳ���С����������repage����������סҳ���С��
		String size = request.getParameter("pageSize");
		if (StringUtils.isNumeric(size)){
			CookieUtils.setCookie(response, "pageSize", size);
			this.setPageSize(Integer.parseInt(size));
		}else if (request.getParameter("repage")!=null){
			no = CookieUtils.getCookie(request, "pageSize");
			if (StringUtils.isNumeric(size)){
				this.setPageSize(Integer.parseInt(size));
			}
		}else if (defaultPageSize != -2){
			this.pageSize = defaultPageSize;
		}
	}
    /**
     * ��װPage����
     *
     * @param list          page���
     * @param navigatePages ҳ������
     */
    public PageInfo(List<T> list, int navigatePages) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.total = page.getTotal();
            this.pages = page.getPages();
            this.list = page;
            this.size = page.size();
            //���ڽ����>startRow�ģ�����ʵ�ʵ���Ҫ+1
            if (this.size == 0) {
                this.startRow = 0;
                this.endRow = 0;
            } else {
                this.startRow = page.getStartRow() + 1;
                //����ʵ�ʵ�endRow�����һҳ��ʱ�����⣩
                this.endRow = this.startRow - 1 + this.size;
            }
            this.navigatePages = navigatePages;
            //���㵼��ҳ
            calcNavigatepageNums();
            //����ǰ��ҳ����һҳ�����һҳ
            calcPage();
            //�ж�ҳ��߽�
            judgePageBoudary();
        }
    }

    /**
     * ���㵼��ҳ
     */
    private void calcNavigatepageNums() {
        //����ҳ��С�ڻ���ڵ���ҳ����ʱ
        if (pages <= navigatePages) {
            navigatepageNums = new int[pages];
            for (int i = 0; i < pages; i++) {
                navigatepageNums[i] = i + 1;
            }
        } else { //����ҳ�����ڵ���ҳ����ʱ
            navigatepageNums = new int[navigatePages];
            int startNum = pageNum - navigatePages / 2;
            int endNum = pageNum + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                //(��ǰnavigatePagesҳ
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
                //���navigatePagesҳ
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatepageNums[i] = endNum--;
                }
            } else {
                //�����м�ҳ
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            }
        }
    }

    /**
     * ����ǰ��ҳ����һҳ�����һҳ
     */
    private void calcPage() {
        if (navigatepageNums != null && navigatepageNums.length > 0) {
            firstPage = navigatepageNums[0];
            lastPage = navigatepageNums[navigatepageNums.length - 1];
            if (pageNum > 1) {
                prePage = pageNum - 1;
            }
            if (pageNum < pages) {
                nextPage = pageNum + 1;
            }
        }
    }

    /**
     * �ж�ҳ��߽�
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages;
        hasPreviousPage = pageNum > 1;
        hasNextPage = pageNum < pages;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getSize() {
        return size;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public long getTotal() {
        return total;
    }

    public int getPages() {
        return pages;
    }

    public List<T> getList() {
        return list;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }
    
    public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getNavigatePages() {
        return navigatePages;
    }

    public int[] getNavigatepageNums() {
        return navigatepageNums;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", size=").append(size);
        sb.append(", startRow=").append(startRow);
        sb.append(", endRow=").append(endRow);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(list);
        sb.append(", firstPage=").append(firstPage);
        sb.append(", prePage=").append(prePage);
        sb.append(", nextPage=").append(nextPage);
        sb.append(", lastPage=").append(lastPage);
        sb.append(", isFirstPage=").append(isFirstPage);
        sb.append(", isLastPage=").append(isLastPage);
        sb.append(", hasPreviousPage=").append(hasPreviousPage);
        sb.append(", hasNextPage=").append(hasNextPage);
        sb.append(", navigatePages=").append(navigatePages);
        sb.append(", navigatepageNums=");
        if (navigatepageNums == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < navigatepageNums.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(navigatepageNums[i]);
            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }
}
