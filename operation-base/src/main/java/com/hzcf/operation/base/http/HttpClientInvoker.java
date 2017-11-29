/**
 *
 */
package com.hzcf.operation.base.http;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 封装了一个 HttpClient 执行类
 * </pre>
 */
public class HttpClientInvoker {

    private static final Logger log = Logger.getLogger(HttpClientInvoker.class);

    private final static ResponseHandler<HttpInvokeResult> RESPONSE_HANDLER = new DefaultResponseHandler();

    private HttpClientProvider provider;
    private CloseableHttpClient httpClient;
    private String parserType;
    private String cookie_key;
    private String ip;
    private String userAgent;
    private String refer;

    private String url;
    private boolean invoked = true;

    public HttpInvokeResult invoke() {
        return invokeGet(this.url);
    }

    public HttpInvokeResult invokePost() {
        return invokePost(this.url,null);
    }

    public HttpInvokeResult invokePost(Map<String, Object> params) {
        return invokePost(this.url,params);
    }

    public HttpInvokeResult invokePostJSON(String json) {
        return invokePostJSON(this.url,json);
    }

    public HttpInvokeResult invokeGet(final String url) {
        // 执行 get 请求
        final HttpGet httpGet = new HttpGet(url);
        //设置连接超时时间
        int REQUEST_TIMEOUT = 20 * 1000;
        int SO_TIMEOUT = 20 * 1000;
        httpGet.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,REQUEST_TIMEOUT);
        httpGet.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);
        httpGet.getParams().setParameter(ClientPNames.HANDLE_REDIRECTS, Boolean.TRUE);// 手动处理自动转向.
        httpGet.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, Boolean.TRUE);
        httpGet.getParams().setParameter(ClientPNames.MAX_REDIRECTS, 10);
        httpGet.getParams().setParameter(HTTP.CHARSET_PARAM, HTTP.UTF_8);

        final Header[] headers = new Header[3];
        headers[0] = new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        headers[1] = new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        headers[2] = new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8");
        httpGet.setHeaders(headers);
        final HttpInvokeResult result = this.invoke(httpGet);
        return result;
    }


    public HttpInvokeResult invokeTenant(final String url,final String token,final String apikey) {
        // 执行 get 请求
        final HttpGet httpGet = new HttpGet(url);
        //设置连接超时时间
        int REQUEST_TIMEOUT = 30 * 1000;
        int SO_TIMEOUT = 30 * 1000;
        httpGet.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,REQUEST_TIMEOUT);
        httpGet.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);
        httpGet.getParams().setParameter(ClientPNames.HANDLE_REDIRECTS, Boolean.TRUE);// 手动处理自动转向.
        httpGet.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, Boolean.TRUE);
        httpGet.getParams().setParameter(ClientPNames.MAX_REDIRECTS, 10);
        httpGet.getParams().setParameter(HTTP.CHARSET_PARAM, HTTP.UTF_8);
       // final Header[] headers = new Header[1];
       // headers[0] = new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        //headers[1] = new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        //headers[2] = new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8");
        //headers[0] = new BasicHeader("Authorization","Token "+token);
        //headers[4] = new BasicHeader("Authorization","apikey "+apikey);
        httpGet.addHeader("Authorization","Token "+token);
        final HttpInvokeResult result = this.invoke(httpGet);
        return result;
    }


    public HttpInvokeResult invokePostJSON(final String url, String json) {
            // 执行 post 请求
            final HttpPost httpPost = new HttpPost(url);
//            httpPost.getParams().setParameter(ClientPNames.HANDLE_REDIRECTS, Boolean.TRUE);// 手动处理自动转向.
//            httpPost.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, Boolean.TRUE);
//            httpPost.getParams().setParameter(ClientPNames.MAX_REDIRECTS, 10);
            int REQUEST_TIMEOUT = 30 * 1000;
            int SO_TIMEOUT = 30 * 1000;
            httpPost.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,REQUEST_TIMEOUT);
            httpPost.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);
            StringEntity s = new StringEntity(json,"UTF-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            httpPost.setEntity(s);
            final HttpInvokeResult result = this.invoke(httpPost);
            return result;

    }


    public HttpInvokeResult invokePost(final String url, Map<String, Object> params) {
            // 执行 post 请求
            final HttpPost httpPost = new HttpPost(url);
            int REQUEST_TIMEOUT = 30 * 1000;
            int SO_TIMEOUT = 30 * 1000;
            httpPost.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,REQUEST_TIMEOUT);
            httpPost.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);
                httpPost.getParams().setParameter(ClientPNames.HANDLE_REDIRECTS, Boolean.TRUE);
            httpPost.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, Boolean.TRUE);
            httpPost.getParams().setParameter(ClientPNames.MAX_REDIRECTS, 10);
            httpPost.setHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded");
            //添加参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            if(params!=null)
            {
                for (String key : params.keySet()) {
                    nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
                }
            }
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            } catch (UnsupportedEncodingException e) {
                log.error("the encoding isn't supported ");
            }
            final HttpInvokeResult result = this.invoke(httpPost);
            return result;

    }



    private HttpInvokeResult invoke(final HttpRequestBase request) {
        final String url = request.getURI().toString();
        int statusCode = 500 ;
        if (log.isDebugEnabled()) {
            log.debug("invoke url:" + url);
        }
        HttpInvokeResult result;
        try {
            final HttpContext context = new BasicHttpContext();
            //context.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
            HttpClient httpClient = this.httpClient;
            result = httpClient.execute(request, RESPONSE_HANDLER, context);
            statusCode = result.getStatusCode();
            if (result.getException() != null) {
                log.error("http request error, status="+statusCode,result.getException());
                request.abort();
            }
            result.setUrl(request.getURI().toString());
            request.releaseConnection();
            return result;
        } catch (final Throwable e) {
            log.error("http request error, status="+statusCode);
            request.abort();
            result = new HttpInvokeResult();
            result.setUrl(url);
            result.setException(e);
            result.setReason(e.getMessage());
            return result;
        } finally {
            request.reset();
        }
    }

    void setProvider(HttpClientProvider provider) {
        this.provider = provider;
    }

    void setHttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    void setParserType(String parserType) {
        this.parserType = parserType;
    }

    public String getCookie_key() {
        return cookie_key;
    }

    public void setCookie_key(String cookie_key) {
        this.cookie_key = cookie_key;
    }

    void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    void setRefer(String refer) {
        this.refer = refer;
    }

    public String getParserType() {
        return parserType;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getRefer() {
        return refer;
    }

    public String getUrl() {
        return url;
    }

    void setUrl(String url) {
        this.url = url;
    }

    public boolean isInvoked() {
        return invoked;
    }

    void setInvoked(boolean invoked) {
        this.invoked = invoked;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    /**
     * <pre>
     * 判断当前invoker是否可用
     * </pre>
     *
     * @return
     */
    public boolean isUsable() {
        return this.httpClient != null;
    }

}
