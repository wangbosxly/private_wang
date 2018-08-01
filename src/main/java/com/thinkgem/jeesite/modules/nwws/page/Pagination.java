package com.thinkgem.jeesite.modules.nwws.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表分页。包含list属性。
 */
@SuppressWarnings("serial")
public class Pagination extends SimplePage implements java.io.Serializable,
		Paginable {

	public Pagination() {
	}

	/**
	 * 检查页码 checkPageNo
	 * 
	 * @param pageNo
	 * @return if pageNo==null or pageNo<1 then return 1 else return pageNo
	 */
	public static int cpn(Integer pageNo) {
		return (pageNo == null || pageNo < 1) ? 1 : pageNo;
	}	
	
	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 */
	public Pagination(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
	}

	/**
	 * 构造器
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 * @param list
	 *            分页内容
	 */
	public Pagination(int pageNo, int pageSize, int totalCount, List<?> list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
	}

	/**
	 * 第一条数据位置
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (pageNo - 1) * pageSize;
	}

	/**
	 * 当前页的数据
	 */
	private List<?> list;

	/**
	 * 获得分页内容
	 * 
	 * @return
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * 设置分页内容
	 * 
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public void setList(List list) {
		this.list = list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setList(int pageNo, int pageSize, List list) {
		int min_pageNo = 1;
		if(pageNo <= min_pageNo){
			pageNo = min_pageNo;
		}
		int max_pageNo = (list.size()%pageSize==0)?(list.size()/pageSize):(list.size()/pageSize+1);
		if(pageNo >= max_pageNo){
			pageNo = max_pageNo;
		}
		List newList = new ArrayList();
		for(int i=0; i<pageSize; i++ ){
			int _index = (pageNo-1)*pageSize+i;
			if(_index < list.size()){
				newList.add(list.get(_index));
			}else{
				break;
			}
		}
		
		this.list = newList;
	}
}
