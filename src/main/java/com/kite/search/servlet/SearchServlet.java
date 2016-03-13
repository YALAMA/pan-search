package com.kite.search.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;

import com.kite.search.common.enums.SearchTypeEnum;
import com.kite.search.factory.SearchFactory;
import com.kite.search.model.Request;
import com.kite.search.model.Response;

@WebServlet("/search")
@Slf4j
public class SearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7561329883405055381L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");  
		log.info("call doPost");
		String keyword = req.getParameter("keyword");
		String searchType = req.getParameter("searchType");
		String currentPageStr = req.getParameter("currentPage");
		if(StringUtils.isBlank(keyword)) {
			req.setAttribute("msg", "请输入要搜索的关键字");
			req.getRequestDispatcher("search.jsp").forward(req, resp);
		}
		if(!SearchTypeEnum.hasType(searchType)) {
			req.setAttribute("msg", "搜索类型不存在");
			req.getRequestDispatcher("search.jsp").forward(req, resp);
		}
		int currentPage = 1;
		if(currentPageStr != null) {
			try {
				currentPage = Integer.parseInt(currentPageStr);
			} catch (Exception e) {
			}
		}
		Request request = new Request();
		request.setKeyword(keyword);
		request.setSearchType(searchType);
		request.setCurrentPage(currentPage);
		log.info("call parameter:{}", request);
		Response response = SearchFactory.getSearch(searchType).searchByKeyword(request);
		log.info("response:{}", response);
		req.setAttribute("result", response);
		req.setAttribute("keyword", keyword);
		req.setAttribute("currentPage", currentPage);
		req.getRequestDispatcher("search.jsp").forward(req, resp);
	}

	
}
