package com.bdqn.springboot.config;

public class AlipayConfig {

    /**
     * 支付宝网关（固定）
     */
    public static final  String URL="https://openapi.alipay.com/gateway.do";

    /**
     * 授权url
     */
    public static final  String ALIPAY_URL = "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm";

    /**
     * 应用id
     */
    public static final  String APP_ID="2019042764364116";

    /**
     * 应用私钥
     */
    public static final  String APP_PRIVATE_KEY="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDF0Txj5iVc9ict/m1Ktu7JKRgWLJLnG6IWMmLhjojxzgZQxhUSBgPvCk28LYG8a/mZHch9BJwSBdvg9SExKoZ25iLqMNiS9fZ6o5E1+N/vYRbD8BFjvVmbhS8PtC2iD+MkW+8tvljdFMvGlcUn0FgXuf22iDGXJgALoT1GKuGNXgWepVT2sK1jJz0yVoBIQoRXY22t0JNN7uc1exDq54EClaGCdubzD8jm5XcQNWQqGL5hlk+04pOQWkLUdmt5QjhxyotnYrkJHUSc4RUSrbshU7xxF1dY9iQhxbFFRpuJORHRtsbdjQzaeQy7debvp/2znePH9cBwej65WOCG3A0DAgMBAAECggEAfVF2fpsYZHIUlBCw0Dpfv9Rmy/VlA0AASSuWdOpFW1p3qcgzJP3mlBLk+CekHugQca3qizjWXpyTlUn1wx37nWtiBxb2vPNROJRSs+x8gTvyniKCAbu8/sc67ynoFtkVvrz3IvWJelVoWuAazIQyqqVLU82oDOcn9DYriT41McaXhcPkKbqSdaFYNHBz35xODBZiS0LTeop/8z63N7Fbvh+IFUqTn/clDKJFULFGHV3dASahnYTA1etDN6FJO5Wlnif1Lt2uIYQ75IH48jK9rzGe6didCndXnqVN0dIzJZ6Q/StCwOOrYllrTbr/5owO2LtG/yrtshlF0Q3MHKzKkQKBgQDkDkYyYD/XFVCaeSOvDVDGFk66+Z2VGlTdnyiW4W10a+3eZJ901dbixUqrvLMEkY9ufDT6pV6hh/Z0XGM4ccTYMG0nASRzKpAq0Bo07Eg0EuGyySQFi956g+rwLnA/+3PPhXQOAtoV3vb/Kx0YNNk9yfri1x9/Tx9CjDqTSOH/lwKBgQDeDm7VjU+AqDViJ4djY4P3QBRNE/y9bOvFWxZkcPBN4JcTYWeQb2kJbUQDpyEB3mKM4kMwKY7uWouIgQyx7ri/Rkzb6oLO27AaRrqVfbJedbrxn9BzlYv3EvDvyJc2Odc5Ez+NoTRmVx4UYFlQv7D75AAQCEr4srgUcZA3sfdLdQKBgBnXTDj1EwbKEYIPa+2v8pEfgfhJxINaonciS7UdAgwJFsD2YeMZP+oeNOHU1ewUmk4IoPAtwNVI1LJGra99pLJielvLE1hBYGiZf/6zL1NHOG/LvtsqCCGVxQ9GE84MLgk7s/TKee+0fgRX3Eob4unPczA09Aq26nHd9d0uiv0tAoGAPCUeohsHWKq24uIgCqyOtu6VURdD0q7o4Wi9lPD+NanKYcZ1ParfgV0mGfMvvojUmqJCXo4zF55QwuVpYdxuD+jjsoE/cvYQKd3Udd8469rpir6lwFjWM1LfDaOASYC7Kctr4Fm0jq+0BwLdzkBNmLx1w+HrJJeLwoXL8Tnz6G0CgYEAhXxnPd+QAj5U84sjlwe0CnsFQx4HuKtMKCX+IqlahB4DpCXpxdcpoHfUr5YUHT5IL0ci1SgI47jLCm0KbksSu+SPcdxk78tF4ZKw0b/dEdYREl5q7kk+fpNht1CW8E7Q6iLuG3xyNRlbLetwN4d10tdVYFzMILa/k7fPwJ+FE7M=";

    /**
     * 参数返回格式
     */
    public static final  String FORMAT="json";

    /**
     * 编码集
     */
    public static final  String CHARSET="UTF-8";

    /**
     * 支付宝公钥
     */
    public static final  String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7XLl932rhBCp7hAx8KhYKiDvg1FUXsP8Rf1Opdk3QVrS6XTYTCQjPXfQrZBlayzwR1mDa8xDAy734sKrIwHOPTzBtkiU7mbuEXnuq+wcRJjKae4LTpMlqfahbTFa6D1ZhA7X+0dYaJjbeEZyq7ZOgpo/9r22KraOFcG5/rJ0h+dfB0CsdKnz+CxRJ3oNxLb1KmEWmwGE27W5f+tcf7TTYmCysy6mZkIChVrYmDlLsYG1PFrO90sSK83v1nM8h7bI12QtrK35mCW0D5IJzaq9VZyzoNwmMYa0uhQH2QQE8c3coy7+DLv0lytQueB5iLRZxKW7keGPnjTZRUo08UqYRQIDAQAB";

    /**
     * 商户生成签名字符串所使用的签名算法类型
     */
    public static final  String SIGN_TYPE="RSA2";

}