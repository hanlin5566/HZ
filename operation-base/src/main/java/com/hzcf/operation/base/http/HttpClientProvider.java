package com.hzcf.operation.base.http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpClientProvider {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public HttpClientInvoker provideSSL(final String parserType, final String url) {

        return this.provide(parserType, url);
    }

    public HttpClientInvoker provide(final String parserType, final String url) {

        final CloseableHttpClient httpClient = PoolingHttpClientHolder.createHttpClient();

        final HttpClientInvoker invoker = new HttpClientInvoker();
        invoker.setProvider(this);
        invoker.setHttpClient(httpClient);
        invoker.setParserType(parserType);
        invoker.setUrl(url);
        return invoker;
    }

}
