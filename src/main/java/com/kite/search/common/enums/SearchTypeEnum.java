package com.kite.search.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SearchTypeEnum {
	
	BING("BING", "��Ӧ")
	
	;
	/**
	 * ����
	 */
	private String type;
	/**
	 * ����
	 */
	private String desc;
	
	/**
	 * �ж��Ƿ�you�������
	 * @param type
	 * @return
	 */
	public static boolean hasType(String type) {
		for(SearchTypeEnum temp : SearchTypeEnum.values()) {
			if(temp.getType().equals(type)) {
				return true;
			}
		}
		return false;
	}
}
