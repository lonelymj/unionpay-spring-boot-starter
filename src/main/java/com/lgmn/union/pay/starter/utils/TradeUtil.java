package com.lgmn.union.pay.starter.utils;

import java.io.InputStream;
import java.util.Properties;

import com.gnete.security.crypt.Crypt;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class TradeUtil {

    public static final String configPath = "config.properties";
    private static Log log = LogFactory.getLog(TradeUtil.class);
    public static Properties properties;

    public static Properties loadProperties() throws Exception {
        return loadProperties(configPath);
    }

    // 获取配置文件信息
    public static Properties loadProperties(String configPath) throws Exception {
        if (properties == null) {
            Properties prop = new Properties();
            InputStream is = TradeUtil.class.getClassLoader().getResourceAsStream(configPath);
            prop.load(is);
            properties = prop;
        }
        return properties;
    }


    /**
     * 签名并返回签名发送文件信息
     *
     * @param
     * @param strData
     * @return
     * @throws Exception
     */
    public static String signTradeMsg(String strData) throws Exception {
        String pathPfx = getPfxPath();
        String pfxPassword = properties.getProperty("pfxPassword");
        //签名
        Crypt crypt = new Crypt();
        String plainData = strData.replaceAll("<SIGNED_MSG></SIGNED_MSG>", "");
        String signMsg = crypt.sign(plainData, pathPfx, pfxPassword);
        String sendMsg = strData.replace("<SIGNED_MSG></SIGNED_MSG>",
                "<SIGNED_MSG>" + signMsg + "</SIGNED_MSG>");
        return sendMsg;
    }


    /**
     * 验签
     *
     * @param tradeMsg
     * @return
     * @throws Exception
     */
    public static boolean verifyTradeMsg(String tradeMsg) throws Exception {
        //签名(代收付系统JDK环境使用GBK编码，商户使用签名包时需传送GBK编码集)
        Crypt crypt = new Crypt("gbk");
        String pathCer = getCerPath();
        int iStart = tradeMsg.indexOf("<SIGNED_MSG>");
        if (iStart != -1) {
            int end = tradeMsg.indexOf("</SIGNED_MSG>");
            String signedMsg = tradeMsg.substring(iStart + 12, end);
            log.info(signedMsg);
            String strMsg = tradeMsg.substring(0, iStart) + tradeMsg.substring(end + 13);
            //调用签名包验签接口(原文,签名,公钥路径)
            if (crypt.verify(strMsg, signedMsg, pathCer)) {
                log.info("verify ok");
                return true;
            } else {
                log.error("verify error");
                return false;
            }
        }
        return true;
    }

    public static String getUrl() {
        return properties.getProperty("cpsUrl");
    }

    /**
     * 获取银联公钥
     *
     * @return
     */
    public static String getCerPath() {
        return properties.getProperty("pathCer");
    }

    /**
     * 获取商户私钥
     *
     * @return
     */
    public static String getPfxPath() {
        return properties.getProperty("pathPfx");
    }
}
