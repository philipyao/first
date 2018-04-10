package com.philip.tools;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClient {
	CloseableHttpClient httpclient;
	public String HelloWorld() {
		httpclient = HttpClients.createDefault();
		System.out.print("hello world");
		return "hello world";
	}
}
