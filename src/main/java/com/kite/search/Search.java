package com.kite.search;

import com.kite.search.model.Request;
import com.kite.search.model.Response;

/**
 * ����������
 * @author hasee
 *
 */
public interface Search {
	
	/**
	 * ���ݹؼ����������
	 * @param keyword		�ؼ���
	 * @return				���ݹؼ����������ķ��ؽ��
	 */
	Response searchByKeyword(Request request);
}
