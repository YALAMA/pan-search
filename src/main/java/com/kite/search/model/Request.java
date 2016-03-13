package com.kite.search.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import com.kite.search.common.enums.SearchTypeEnum;

/**
 * �����������
 * 
 * @author hasee
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Request implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6571381055211146546L;

	/**
	 * ��������,Ĭ��Ϊbing
	 */
	private String searchType = SearchTypeEnum.BING.getType();

	/**
	 * �����ؼ���
	 */
	private String keyword;

	/**
	 * ��ǰҳ��
	 */
	private int currentPage = 1;
	
	/**
	 * ÿҳ����
	 */
	private int pageSize = 10;
}
