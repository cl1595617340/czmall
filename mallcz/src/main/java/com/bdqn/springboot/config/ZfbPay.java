package com.bdqn.springboot.config;

import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
@Configuration
public class ZfbPay {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016093000630133";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDJzaMsgnEm/y7K1NUI0YFJ7hq8P43yok1dVsXN+6+JWrUUrVB0L+Fgk9kyh9LeE9z9Qt2EWJyiqI+8BNmDQMP8Qfchv1PmzSo52hwUCR/Kxjechezz9hL31eeRFE+NH3mV1Ou8E3SyCn59obhlTGs9yCgKea3hLmsc3R3xVkcLII8J/cYjtL3Y1VV5tYBTDpoGsoaCSZIdKRDknYWFELeUMUTLGHvfk4+3L1SJj4b+OXNe9hhjCr7Td2b4Z5HjxlrjKj8IZaPHwJKjOYt5n/elrgAejodDICfe5o+wQNa6/SHzBBafjXZEG6S7tJJE246jaFtaU0ceRs+cdwx6vu0XAgMBAAECggEAdGXZDW47p9ueeL2kFw8IfMUKxLP/wwiciQ7ozvOx/w7DzaZd9nY7kAIXUE8JcLCSUb5EmPaneiaxqSg+8bbklFbUHbIGyeRiy7WjZmcQ4FvObcjNsLWpoSvPAl5tuB+EeMi0I+ow8BSfewVRn5QhcyRE/C3M/kpQ2/gqMi6qkZ5yRK9BFoRfKL6qZog1HOiIcR3ENPB96mAyUnl6tFkFtr1T1vlqr/HhXHya+4fQRmbqVNrvX4B/sdCXrBnJUiefr+++Yv23yAcjRIKnSAICgXmAv1JtsWnSXgQIrm5EMj9P5fh3nmpsJZGEdb7VP419DRt6EtwKDVNJkB+1tu5LAQKBgQDyWNryvuPWnEu3+7dAK8oJ03f0xlsGKKL2pFZdpjCTlFKBI+G9R2+nXltPPQO2OXh9V9HZeT4KIsnut5gPswN95GUI1PstFueTUXwCJ4KKzWO0v8hdYAMpS//6Vr8DsR5ZyF4Edp6FzvQiN02EMJ8L/JiWUTtgLPTCGdSIRTQNlwKBgQDVLA6A7BU+rEZpoOS94Wg3lH9+4cqDIbptbIzEX38/sW0e+4OH/lZaOkWTWOS5QquD0/mZV0gYjyqSP1MH2xy4JK3HAFhenDaFWjhHdKGk7E8g2tdwjqi6m6lPQodvMp2jWbT+PI8pWFcnH4UxGlHWyyJ6h/VPTSvIgSSgikcMgQKBgQC1PHQJA266CUqq/cjOabD/ZjEYUdqyoWM11jJseKNtSofk4eOovKqoXO0mNff3p8UO38UkwQH/bILdTlmeq/5ZgJt6XmS1FKL8TfzSU5/Rk8YT3zTFd88FbDuziHnzFdsfw7Nj3R2x7dIvYHJNAFuBCFdIWtlvlE86dTy26CIEYwKBgH+RTOCj5xbJW53MlfZ3lLlmGWIh1uHgZkMjaZ3+lBTWpbmbxBu2/ZAjPQ2vbbjcB+3tBXpZPCDOVCiO0q5p1mbwNDpZn4iGrS3iTrmcNzuN2tCLhc+q35hEnO58nrXRsXpWrbRTI00Xu5gDCd7XpFAI4go3oHqjcOcdOYEFHv2BAoGBAJgAatm+5fAY3D8zBT8ZyIg3FmVhgIX7bmXSxrVwsfv7jngOyiqH/AXejyB7LJ5GLmtzPhPgPPS0yqKoRzeEKZZLeDmZ0STMpe1Pb5VCzOazlIPY04Y0lTT9MXvb5IFLBas+5CO/YcFuIPCSv31iVEMLkTIDSk/CYxbtumvLuYgF";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjsrX17rqYye8WTsSxpaxSyfwSEhPGueWTvzA+m2RF1bPXbadxrRSVssJjf30I3Xl4WSMWFXSAjZjunYEvBkI7zCa10e8gmGU2pdDGntQZ5LDegvf7qX8f/mV6HCxuR/T/8vskOO30p/CNr6db+QUMCYDm0t6PEprnAyMkTo4Ja5fGb+Ny9dQq70LT4bbMGTFaeaf3PN/9yvabJmwapnieTHUCbBCQYQ/ISUduf3+0RZh6sjyut7mfwU5s/UNlcmK0+pcGH84FZfIL7WEiT3VS0KBvO0EEPAenIATo2LgsyAMOwnIDkbqZ282jB3gTM59IwduUPGDZ60+gf/BcOb6YQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/#/pay";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/#/pay";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

