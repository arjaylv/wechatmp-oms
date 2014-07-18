package com.sftxy.wechatmp.sdk.util;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

// TODO exception
public class RequestUtil {

    private final static int timeout = 20000;

    private static final String DEFAULT_CHARSET = "UTF-8";

    private static CloseableHttpClient client;

    private final static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();

    private static synchronized CloseableHttpClient getHttpClientInstance() {
        if (null == client) {
            // TODO
            X509TrustManager x509TrustMgr = new X509TrustManager() {

                public void checkClientTrusted(X509Certificate[] chain,
                        String authType) throws CertificateException {
                    // TODO Auto-generated method stub
                    
                }

                public void checkServerTrusted(X509Certificate[] chain,
                        String authType) throws CertificateException {
                    // TODO Auto-generated method stub
                    
                }

                public X509Certificate[] getAcceptedIssuers() {
                    // TODO Auto-generated method stub
                    return null;
                }
            };
            SSLContext sslContext = null;
            try {
                sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, new TrustManager[] { x509TrustMgr }, null);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
            SSLConnectionSocketFactory sslCSF = new SSLConnectionSocketFactory(sslContext,
                    SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            client = HttpClients.custom().setSSLSocketFactory(sslCSF).build();
        }
        return client;
    }

    public static String doGet(String url, Map<String, String> params) {
        client = getHttpClientInstance();
        URI uri = generateURLParams(url, params);
        HttpGet get = new HttpGet(uri);
        get.setConfig(requestConfig);
        String responseStr = null;
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = client.execute(get);
            responseStr = generateHttpResponse(httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseStr;
    }

    public static HttpResponse doGetResource(String url, Map<String, String> params) {
        client = getHttpClientInstance();
        URI uri = generateURLParams(url, params);
        HttpGet get = new HttpGet(uri);
        get.setConfig(requestConfig);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = client.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

    public static String doPost(String url, Map<String, String> params, String jsonStr) {
        client = getHttpClientInstance();
        URI uri = generateURLParams(url, params);
        HttpPost post = new HttpPost(uri);
        post.setConfig(requestConfig);
        String responseStr = null;
        CloseableHttpResponse httpResponse = null;
        try {
            HttpEntity entity = new StringEntity(jsonStr, DEFAULT_CHARSET);
            post.setEntity(entity);
            post.setHeader("Content-Type", "application/json");
            httpResponse = client.execute(post);
            responseStr = generateHttpResponse(httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseStr;
    }

    public static String uploadMaterial(String url, Map<String, String> params, String formDataName, String filePath) {
        client = getHttpClientInstance();
        URI uri = generateURLParams(url, params);
        HttpPost post = new HttpPost(uri);
        post.setConfig(requestConfig);
        ContentBody contentBody = new FileBody(new File(filePath));
        HttpEntity reqestEntity = MultipartEntityBuilder.create().addPart(formDataName, contentBody).build();
        post.setEntity(reqestEntity);
        String responseStr = null;
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = client.execute(post);
            responseStr = generateHttpResponse(httpResponse);
        } catch (IOException e) {
        }
        return responseStr;
    }

    private static URI generateURLParams(String url, Map<String, String> params) {
        URI uri = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (null != params) {
                for (Entry<String, String> entry : params.entrySet()) {
                    uriBuilder.addParameter(entry.getKey(), entry.getValue());
                }
            }
            uri = uriBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;
    }

    private static String generateHttpResponse(CloseableHttpResponse httpResponse) {
        String responseStr = null;
        try {
            HttpEntity entity = httpResponse.getEntity();
            responseStr = EntityUtils.toString(entity, DEFAULT_CHARSET);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseStr;
    }
}
