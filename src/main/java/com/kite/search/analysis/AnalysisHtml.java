package com.kite.search.analysis;


import com.kite.search.common.enums.ErrorEnum;
import com.kite.search.common.exceptoins.PanException;
import com.kite.search.model.Response;

/**
 * ����html
 * @author hasee
 *
 */
public abstract class AnalysisHtml {
	
	protected String decodeEncoding = DEFAULT_DECODE_ENCOING;

	private static final String DEFAULT_DECODE_ENCOING = "UTF-8";
	
	/**
	 * ����������html
	 * @param html				������html
	 * @param urlEncoing		���ص�url����
	 * @return					�����󷵻ض���
	 */
	public abstract Response parseHtml(String html, String urlEncoing);
	
	/**
	 * ����������html
	 * @param html				������html
	 * @return					�����󷵻ض���
	 */
	public Response parseHtml(String html) {
		return this.parseHtml(html, decodeEncoding);
	}
	
	/**
	 * ������ҳ��Ϊint
	 * @param str	���ƽ��Ϊ22,200 �����
	 * @return		22200 
	 */
	public Long parseTotalCount(String str) {
		char[] chArr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		if(chArr != null && chArr.length > 0) {
			for(int i = 0; i < chArr.length; i++) {
				if(chArr[i] >= '0' && chArr[i] <= '9') {
					sb.append(chArr[i]);
				}
			}
		} else {
			throw new PanException(ErrorEnum.INVALID_PARAMETER.getCode(), ErrorEnum.INVALID_PARAMETER.getMsg());
		}
		return Long.parseLong(sb.toString());
	}
	
	public static void main(String[] args) {
		System.out.println(Long.parseLong("911002240"));
	}
}
