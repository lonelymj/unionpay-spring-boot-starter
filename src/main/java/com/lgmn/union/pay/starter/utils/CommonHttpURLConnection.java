package com.lgmn.union.pay.starter.utils;

import org.apache.commons.io.IOUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommonHttpURLConnection {

    private final static int defaultConnectTimeOut = 60000;
    private final static int defaultSoTimeOut = 180000;
    private int connectTimeOut = defaultConnectTimeOut;
    private int soTimeOut = defaultSoTimeOut;

    /**
     * post Msg
     *
     * @param address
     * @param bytes
     * @return
     */
    public String postHttpMsg(String address, String msg) throws Exception {
        HttpURLConnection conn = openHttpConnection(address, "POST");
        return new String(sendHttpMsg(conn, msg.getBytes("gbk")), "gbk");
    }


    /**
     * 打开HTTP 连接，支持http 与https
     *
     * @param address
     * @param method
     * @return
     * @throws Exception
     */
    protected HttpURLConnection openHttpConnection(String address, String method) throws Exception {
        HttpURLConnection conn = null;
        try {
            //创建连接
            conn = createConnection(address);
            //连接超时
            conn.setConnectTimeout(connectTimeOut);
            //读超时
            conn.setReadTimeout(soTimeOut);
            conn.setRequestMethod(method);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
        } catch (Exception ex) {
            //String errMsg = "url【"+address+"】 connect error";
            throw ex;
        }
        return conn;
    }

    /**
     * 创建connection
     *
     * @param address
     * @return
     * @throws Exception
     */
    public HttpURLConnection createConnection(String address) throws Exception {
        HttpURLConnection conn = null;
        URL url = new URL(address);
        if (isHttps(address)) {
            HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
            httpsConn.setSSLSocketFactory(new BaseHttpSSLSocketFactory());
            httpsConn.setHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            conn = httpsConn;
        } else {
            conn = (HttpURLConnection) url.openConnection();
        }
        return conn;
    }

    /**
     * 判断是否为HTTPS
     *
     * @param address
     * @return
     */
    public boolean isHttps(String address) {
        if (address != null && (address.toUpperCase().indexOf("HTTPS") >= 0)) {
            return true;
        }
        return false;
    }


    /**
     * 发送报文
     *
     * @param conn
     * @param bytes
     * @return
     * @throws Exception
     */
    protected byte[] sendHttpMsg(HttpURLConnection conn, byte[] bytes) throws Exception {

        OutputStream output = null;
        InputStream input = null;
        try {
            // 发送请求.
            output = conn.getOutputStream();
            //output.write(bytes);
            IOUtils.write(bytes, output);
            output.flush();
            // 接收回应.
            input = conn.getInputStream();
            byte[] resp = IOUtils.toByteArray(input);
            return resp;
        } catch (Exception ex) {
            //String errMsg = "url【" +conn.getURL().getPath()+"】,sendHttpMsgError";
            throw ex;
        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(output);
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
    }

    public int getConnectTimeOut() {
        return connectTimeOut;
    }

    public void setConnectTimeOut(int connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
    }

    public int getSoTimeOut() {
        return soTimeOut;
    }

    public void setSoTimeOut(int soTimeOut) {
        this.soTimeOut = soTimeOut;
    }

    public static void main(String[] args) throws Exception {

        String url = "https://59.41.103.102/gzdsf/ProcessServlet";
        CommonHttpURLConnection conn = new CommonHttpURLConnection();
        String retMsg = conn.postHttpMsg(url, "");
        System.out.println(retMsg);
    }
}
