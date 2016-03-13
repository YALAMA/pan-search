package com.kite.search.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ��Ӧ�����
 * 
 * @author hasee
 *
 */
@Getter
@Setter
@ToString
public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4025749323070224006L;

	private boolean success = false;

	/**
	 * ��ǰҳ
	 */
	private long currentPage;

	/**
	 * ������ҳ
	 */
	private long totalPage;

	/**
	 * ��������
	 */
	private long totalSize;

	/**
	 * ��ʼҳ��
	 */
	private long startPage;

	/**
	 * ����ҳ��
	 */
	private long endPage;

	/**
	 * ��ҳ��������ģ��
	 */
	private List<Resource> results;

	private int pageSize = 10;

	/**
	 * ������������ͬʱ������ҳ��
	 * 
	 * @param totalSize
	 */
	public void setTotalSize(long totalSize) {
		// ����Ϊ��ȷ
		this.success = true;
		this.totalSize = totalSize;
		if (totalSize % pageSize == 0) {
			this.totalPage = totalSize / pageSize;
		} else {
			this.totalPage = totalSize / pageSize + 1;
		}
		//currentPage:10 10 - 5 > 1  5
		//12 -    
		this.startPage = currentPage - (pageSize / 2) > 1 ? currentPage - (pageSize / 2) : 1;
		this.endPage = startPage + pageSize - 1 < totalPage ? startPage + pageSize - 1 : totalPage;
	}   
}
