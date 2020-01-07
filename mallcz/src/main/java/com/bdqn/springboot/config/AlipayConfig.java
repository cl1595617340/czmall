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
    public static final  String APP_ID="2021001106616517";

    /**
     * 应用私钥
     */
    public static final  String APP_PRIVATE_KEY="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCf0S5CaDaB9duQwez3xZeithqjg+29+5cpiiT3XasTbrl1YYowGB/dmwAtEZDam23M/ZH5LcID6JC2MwyFVON5hebD7/kvoufU/0HgDKCrCtnMlVu30/0kNTjdCbqIp3X8DvMT5G84z6cDqXzd8a7oHxh4Y2iSaau3GviN7NLR7nQtkyqtWycrbXFlf0/OM8OLPpdW01guIiA96MxhXWcaCiVM1VqK8QbANYbBWIS66+2ttQjW1AXiNEV/qgKlOWJF2PQWpp6vfmk9U47ivEw5A71b9w/VvWW/ia2rxBagTOh0jYoqUwzq40hX52ye2+R9hGUxcatYl4p9vTlQ7ftlAgMBAAECggEABSy2vLu3GBon09YToCorsL8Iucapyf79dADfFYtY4LYzFxPjb484aOp95PeuowVpVrvXICRVJd8/4EZi32ZSPzsQr8NzZBF4RDNHpMOD6EXfq3oikB8zERsQDkgkXAxgC5tIT5qT51kB5WJ1gpIywZ1QI4XEewkk4DblWWMTqGxs70GKMc3tlffV2x1SYoHOcHZdIwZzFVBCImoYD9q4tZjTuIC0mkaj+X8rx+Xt1M3HIkSOwqtRbkaeCg3RSuGexQKg5Lfz9ZNQGFgovfx1P1UNCvxwTyC3d7z3oAUZIdE1tLkAGEknnspSdUnhhlnTSLrZNr+wztEFaMtdFfeleQKBgQDlHLVSkGy5ueiB1MhVfXrQFI8JfeANBHFca0a0+FJgZlGcLJCscEH/IwgLLBQBCN2vVnTwW5z25Vd0LFVzMPKACr2CqFbHP9Jwyu2z0zlKf0iZawyu+aBGhp1fCQjAZNZVDq8kQwXMZl7Rl6cvvK4xwEhrNbklh7/rYbdEkdi2zwKBgQCykp50D2ef4kSI5+qsKSESEvCB22m/+MoqhxWbo5R9IgrlIqEy7p7VaSnzXwOka+PJEoWzuAI0rTvYPd+eFoyoAYNyeYzN14LARQGXubZAPiijF5VKeRCA4vlpyAsP6KmLM9aUExB12PkX+WTQhR9D7IJwBMfG5pQJDe+IAk/3iwKBgEBD+DyLlGPYWPaqB/Oq+dsKGUExVLpyB5ZD5RZ4HSs7KCMlgQNNjcWSPvxbRdUwdnZrSuvs1q+OjyRgFyvzi+IMoTHYJFdJeK74zQpG8mgKIgQeufUOwj1mHxh8QT8uScycDNagEi1OfcROxK+oPjhoVif0btWvKU9OHokWW/KTAoGATwrpSnQ7KSFNts/5J0V5Vve9L63AbHIigpqSrPbGVnFII06lzdajxdEr+Yb4JMKA7FLfjcKIb2qyz6/rmJ1gm0k4NuaotcCMJrEk2FUi3+Ljt/VLZtCZxoMxZWpfwyX4Th6e/6JEqfVlpQAGaOpUAYvh3NWw3FDZ+/wIJ8rmPKsCgYAzbBKePuZkCQRk6avTopSo/pHI0OC3CLBDnOznHBvhNzp8ZZHwDMASv8+tQAKRwe3V5Eh27747T3GENEHiHyt5UYPZHyyn2QXBYI3ommMMKeu9hAi+BwYslK/IJuVDniGy7OXaPOplBknttbmZWE7JzGsq/uE39asW/1TfFUdvPQ==";
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