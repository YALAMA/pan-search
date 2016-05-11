package com.kite.search.analysis;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.kite.search.common.enums.ErrorEnum;
import com.kite.search.common.exceptions.PanException;
import com.kite.search.model.Resource;
import com.kite.search.model.Response;

/**
 * ����bing��html
 * 
 * @author hasee
 *
 */
@Slf4j
public class AnalysisBingHtml extends AnalysisHtml {

	@Override
	public Response parseHtml(String html, String urlEncoing) {
		Response response = new Response();
		List<Resource> resList = new ArrayList<>();
		Document doc = Jsoup.parse(html);
		Element contentEle = doc.getElementById("b_results");
		// id:b_results-->>a[href] �������
		// <li class="b_pag"><span class="sb_count">22,200 �����</span></li>
		// <li class="b_pag"> <nav aria-label="navigation" role="navigation">

		// ��õ�ǰҳ��
		Elements currentPageEles = contentEle.select("a.sb_pagS");
		if (currentPageEles == null || currentPageEles.size() == 0) {
			return response;
		}
		// ���õ�ǰҳ
		response.setCurrentPage((Integer.parseInt(currentPageEles.get(0).text()
				.trim())));

		// ��ò�ѯ���������
		Elements countEles = contentEle.select("span.sb_count");
		if (countEles == null || countEles.size() == 0) {
			return response;
		}

		// ���ò�ѯ����������
		String countString = countEles.get(0).text().trim();
		// 22,200 �����
		response.setTotalSize(super.parseTotalCount(countString));

		// ��ý������
		Elements dttaEles = contentEle.select(".b_algo a[href]");
		Elements descEles = contentEle.select("div.b_caption");
		if (dttaEles == null || dttaEles.size() == 0) {
			return response;
		}
		// ���ý������
		Resource resource = null;
		int index = 0;
		for (Element e : dttaEles) {
			String url = e.attr("href");
			String title = e.text();
			String desc = descEles.get(index).toString();
			try {
				url = URLDecoder.decode(url, urlEncoing);
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			resource = new Resource(null, title, url, desc);
			resList.add(resource);
			index++;
		}
		response.setResults(resList);
		return response;
	}

	public static void main(String[] args) {
		String string = "22,200 �����";
		char[] chArr = string.toCharArray();
		StringBuffer sb = new StringBuffer();
		if (chArr != null && chArr.length > 0) {
			for (int i = 0; i < chArr.length; i++) {
				if (chArr[i] >= '0' && chArr[i] <= '9') {
					sb.append(chArr[i]);
				}
			}
		} else {
			throw new PanException(ErrorEnum.INVALID_PARAMETER.getCode(),
					ErrorEnum.INVALID_PARAMETER.getMsg());
		}
		System.out.print(sb.toString());

	}

}
