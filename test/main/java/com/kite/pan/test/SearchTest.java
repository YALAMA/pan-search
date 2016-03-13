package com.kite.pan.test;


import org.junit.Test;

import com.kite.search.BingSearch;
import com.kite.search.Search;
import com.kite.search.model.Request;
import com.kite.search.model.Response;


public class SearchTest {
	
	@Test
	public void testSearch() {
		Search search = new BingSearch();
		Request request = new Request();
		request.setKeyword("java");
		Response response = search.searchByKeyword(request);
		System.out.println("response:" + response);
		
	}
	
}	
