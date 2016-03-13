package com.kite.search.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorEnum {

	NOT_SUPPORT_PROTOCAL("NOT_SUPPORT_PROTOCAL", "��֧�ֵ�Э��"),
	
	
	IO_EXCEPTION("IO_EXCEPTION", "io�쳣"),
	
	
	INVALID_PARAMETER("INVALID_PARAMETER", "û����֤�Ĳ���"),
	
	NOT_SUPPORT_SEARCH_TYPE("NOT_SUPPORT_SEARCH_TYPE", "��֧�ֵ���������")
	
	;
	/**
	 * ������
	 */
	private String code;
	/**
	 * ������Ϣ
	 */
	private String msg;
}
