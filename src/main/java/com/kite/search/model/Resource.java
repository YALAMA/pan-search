package com.kite.search.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author hasee
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Resource {

	/**
	 * id:���ڲ�ʹ�ã����ڿ�����db�洢
	 */
	private String id;

	/**
	 * ����
	 */
	private String title;

	/**
	 * ��Դurl��ַ
	 */
	private String url;

	/**
	 * ��Դ����
	 */
	private String desc;

}
