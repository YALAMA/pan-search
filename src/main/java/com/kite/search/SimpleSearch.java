package com.kite.search;

import java.io.IOException;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.common.base.Throwables;
import com.kite.search.analysis.AnalysisHtml;
import com.kite.search.common.enums.ErrorEnum;
import com.kite.search.common.exceptions.PanException;
import com.kite.search.factory.AnalysisHtmlFactory;
import com.kite.search.model.Request;
import com.kite.search.model.Response;

/**
 * ��������������Դ��
 * @author hasee
 *
 */
@Slf4j
@Setter
public abstract class SimpleSearch implements Search{
	
	/**
	 * ����,����������������
	 */
	protected String urlEncoding = DEFAULT_ENCODING;
	
	/*
	 * Ĭ�ϱ���
	 */
	private static final String DEFAULT_ENCODING = "UTF-8";
	
	/**
	 *	urlǰ׺ 
	 */
	private String prefixUrl;

	/**
	 * ���ݸ�����url����string���͵Ľ��
	 * @param url 						��Ҫ���ؽ��������
	 * @return 							��Ӧ��ҳ��string���
	 */
	private String getUrlForString(String url) {
		return getUrlForString(url, DEFAULT_ENCODING);
	}

	/**
	 * ���ݸ�����url����string���͵Ľ��
	 * @param url 						��Ҫ���ؽ��������
	 * @param 							encoding ����
	 * @return 							��Ӧ��ҳ��string���
	 */
	private String getUrlForString(String url, String encoding) {
		log.info("call getUrlForString, url:{}, encoding:{}", url, encoding);
		// ����Ĭ�ϵ�httpClientʵ��.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// ����httppost
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response;
		try {
			response = httpclient.execute(get);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity, encoding);
		} catch (ClientProtocolException e) {
			log.warn("��֧�ֵ�Э��:{}", Throwables.getStackTraceAsString(e));
			throw new PanException(ErrorEnum.NOT_SUPPORT_PROTOCAL.getCode(),
					ErrorEnum.NOT_SUPPORT_PROTOCAL.getMsg());
		} catch (IOException e) {
			log.warn("io�쳣:{}", Throwables.getStackTraceAsString(e));
			throw new PanException(ErrorEnum.IO_EXCEPTION.getCode(),
					ErrorEnum.IO_EXCEPTION.getMsg());
		}
	}
	
	/**
	 * ���ݹؼ����������
	 * @param keyword		�ؼ���
	 * @return				���ݹؼ����������ķ��ؽ��
	 */
	public Response searchByKeyword(Request request) {
		if(StringUtils.isBlank(this.prefixUrl)) {
			log.warn("prefixUrl ����Ϊ��");
			throw new PanException(ErrorEnum.INVALID_PARAMETER.getCode(), ErrorEnum.INVALID_PARAMETER.getMsg()); 
		}
		String[] keywords = request.getKeyword().split(" ");
		StringBuffer sb = new StringBuffer();
		if(keywords == null || keywords.length == 0) {
			sb.append(request.getKeyword());
		} else {
			int index = keywords.length;
			for(String kw : keywords) {
				index--;
				if(StringUtils.isBlank(kw)) continue;
				if(index == 0)sb.append(kw);
				else sb.append(kw + "+");
			}
		}
		String url = this.prefixUrl + sb.toString() + "&first=" + getCurrnetSize(request);
		url= url.replaceAll(" ", "%20");
		String html = getUrlForString(url);
		AnalysisHtml analysisHtml = AnalysisHtmlFactory.getAnalysisHtml(request.getSearchType());
		return analysisHtml.parseHtml(html);
	}
	
	/**
	 * ������������õ�ǰ���ʵ�first����
	 * @param request
	 * @return
	 */
	private int getCurrnetSize(Request request) {
		if(request.getCurrentPage() == 1) return 1;
		return (request.getCurrentPage() - 1) * request.getPageSize() + 1; 
	}
}
