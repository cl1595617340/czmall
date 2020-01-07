package com.bdqn.springboot.config;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;

import java.util.Map;

public class AlipaySubmit {

    /**
     * 获取AccessToken
     * @param sParaTemp
     * @return
     */
    public static  String buildRequest(Map sParaTemp){
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, "RSA2");
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setCode((String)sParaTemp.get("auth_code"));
        request.setGrantType("authorization_code");
        try {
            AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request);

            System.out.println(oauthTokenResponse.getAccessToken());
            return oauthTokenResponse.getAccessToken();
        } catch (AlipayApiException e) {
            //处理异常
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取用户信息
     * @param accessToken
     * @return
     */
    public static AlipayUserInfoShareResponse get(String accessToken){
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, "RSA2");
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();

        try {
            AlipayUserInfoShareResponse userinfoShareResponse = alipayClient.execute(request, accessToken);
            return  userinfoShareResponse;
        } catch (AlipayApiException e) {
            //处理异常
            e.printStackTrace();
        }
        return null;
    }

}