package com.kite.search.factory;

import com.kite.search.analysis.AnalysisBingHtml;
import com.kite.search.analysis.AnalysisHtml;
import com.kite.search.common.enums.ErrorEnum;
import com.kite.search.common.enums.SearchTypeEnum;
import com.kite.search.common.exceptoins.PanException;

/**
 * ����html������
 * @author hasee
 *
 */
public class AnalysisHtmlFactory {
	
	/**
	 * ���ݸ��µ��������ͷ��ض�Ӧ�Ľ���html��
	 * @param searchType			��������
	 * @return						��Ӧ�Ľ�����
	 */
	public static AnalysisHtml getAnalysisHtml(String searchType) {
		if(SearchTypeEnum.BING.getType().equals(searchType)) {
			return new AnalysisBingHtml();
		} else {
			throw new PanException(ErrorEnum.NOT_SUPPORT_SEARCH_TYPE.getCode(), ErrorEnum.NOT_SUPPORT_SEARCH_TYPE.getMsg());
		}
	}
}
