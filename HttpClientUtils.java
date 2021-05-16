package com.geekbang.study02;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {

    public static CloseableHttpClient httpclient = HttpClients.createDefault();

    public final static void main(String[] args) throws Exception {
        String url = "http://localhost:8801/";
        String result = HttpClientUtils.getString(url);
        System.out.println("result:" + result);

    }

    private static String getString(String url) throws Exception {
        try {
            HttpGet httpget = new HttpGet(url);

            System.out.println("Executing request " + httpget.getURI());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                response = httpclient.execute(httpget);
                System.out.println(response.getStatusLine());
                HttpEntity entity1 = response.getEntity();
                httpget.abort();
                return EntityUtils.toString(entity1, "UTF-8");
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
