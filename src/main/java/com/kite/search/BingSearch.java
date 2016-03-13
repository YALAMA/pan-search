package com.kite.search;

import com.kite.search.model.Request;
import com.kite.search.model.Response;

/**
 * ʹ��bing��������
 * @author hasee
 *
 */
public class BingSearch extends SimpleSearch {

	/**
	 * Ĭ������ǰ׺
	 */
	String prefixUrl = "http://cn.bing.com/search?q=site:pan.baidu.com+";

	@Override
	public Response searchByKeyword(Request request) {
		super.setPrefixUrl(prefixUrl);
		return super.searchByKeyword(request);
	}

}
