package entity;

import java.util.List;
	public class Pager {
		private int currentPage;            //����ʾҳ��
	    private int totalPage;            //��ҳ��
	    private int count;        //�ܼ�¼��
	    private int pageSize;     //ҳ��С
	    private List<?> list; 
	    
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public List<?> getList() {
			return list;
		}
		public void setList(List<?> list) {
			this.list = list;
		}
	  
	}

