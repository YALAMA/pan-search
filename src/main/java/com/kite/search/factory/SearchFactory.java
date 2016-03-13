package com.kite.search.factory;

import com.kite.search.BingSearch;
import com.kite.search.Search;
import com.kite.search.common.enums.ErrorEnum;
import com.kite.search.common.enums.SearchTypeEnum;
import com.kite.search.common.exceptoins.PanException;

/**
 * ��������
 * @author hasee
 *
 */
public class SearchFactory {

	/**
	 * ���ݸ��������ͷ��ض�Ӧ��������
	 * @param type			����������
	 * @return				������
	 */
	public static Search getSearch(String type) {
		if (SearchTypeEnum.BING.getType().equals(type)) {
			return new BingSearch();
		} else {
			throw new PanException(ErrorEnum.NOT_SUPPORT_SEARCH_TYPE.getCode(),
					ErrorEnum.NOT_SUPPORT_SEARCH_TYPE.getMsg());
		}
	}
}
