package com.geekbang.study;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {

    public static String getString(String url) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);

            System.out.println("Executing request " + httpget.getURI());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                response = httpclient.execute(httpget);
                System.out.println(response.getStatusLine());
                HttpEntity entity1 = response.getEntity();
                return EntityUtils.toString(entity1, "UTF-8");
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
