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
    public static final  String APP_PRIVATE_KEY="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCGgLr/QokLIe1rYoTf5b9UtfXMi41iVwPn8O1Sf4vsHrDF1sInKGAgdYSMye7sg0UmjDHpRhn+sIRHpvgMAspLOVb5JjfDJQJYZbLPCIYvxiGOKrxodUzLeVOftpEAtwhTNFzrPyGdeDCyIpDUijA8sheD3YI3M88jyIm2zJKw/2qUI6gZaOIOiEtR9RqtEchrrl2TuIdpc9cb6iaqv1gq/nCyrTvhE3od+cXvI994PfVFvO1jzkcimlP28f1d/DCA58fveYzJhZEbyjcEkWkqEp3+UQ5FnNtk/QNf778PhkxMYMS3qdk9udPLE9KSO2SkM5AuPcSGt0eHJoPQkPuRAgMBAAECggEAP14Ou4wBPLlzPZBgwYtgJOzFLOTia15LfM7JQIDOzyN2bP7M4d3ny+MR27KXWd5Oieaq7RgVzyQibg9/9UirPd152E/lHY8mF7dyEpAViBR0YqJHuX7p+0Lh3vEIR6nzxh95V2uazrF9X69hRIEGUNImuf12B8Pk5xrnprOiuLgtg0XTDI9c5iGfEySEKZqecNwtt9ouwBequfOetV12j9UpTNuk03gVnmskW01TNkOyRCVXW6od7cx2t0BSCXPiWCl4cI7+pJykaAIODw7uSoL/a3r8ruobJLz6J129gyAlwAVQXH6W/Nw4AhaaWUHT3o+s6PToGRdYaMLDHTiQAQKBgQDIf9IIvyzMz1hoQNToln9+sW9Ukph/A3YqRfC0/CsWGI2z6eKQIy5dNelMHjlUJLxAczcyEMpSnzl1yffu3kgmQPHbnkAFTr1J7ZKmmRoXQeysvy6xIUZZSo1br/TBQY/8CqmPawGfCiB1eeii5tYoPpo4U7lmY8aBKIDqSt3g0QKBgQCrvCOJgpwM1/13X8NfcLDMoj8MBatnQ62ocdR+LU0FPKDiLXj4whDyqrP0tHrbbEG6EE/XxX0PaSAGtKEY/1bQrNe0c2OnwJm0wIUvoqTxlX2Uy6JQDyfT/z1rW4sebn/wzoIsoN8enOd/bgAicBhZraMQnC9j9PqDTzLqnFIewQKBgQCtYaNefvudzPwVg2LaEzMDeyrcBr0qsPKhUcP6rkoQHIGFgI60uEeiwTkS4twOgInubfPgLpbXZeuJiXMGtF/N/MFpemrAbDvST0hPGvxt+ktRgy48bJrqIkclb36HFEwP16STaiSHxHkXPanIHTg6qxAv/27HNSb2j/ETKlS+0QKBgHrXzlfLrJJnYfCk+JzpgB4wpIaV+6CXQb4vBn/nKaPoVXDUdCcEspjS0HznKMaSLoXIq0Q+CRIf8X+6b03xQAluybFTpOJXG9u2ps6HOhNxCm6IJye7X5L+jdGgnuf6xNvc7DK+NDuyosl9Ru1bX5+uW+lCv4dxskyBN3uoq/lBAoGAV6bY6LQ6XfbCFtxx1GZKLpcNQit92UUvbBD0xChhm3ZSqu7MvZ7CETwehJSy3NvqN3PjyyDwV8Uqq4AyQcbUL56hDcqiOwTWcu2mc+D1VgGW9xF8nxpUVJ7PvLwuvdNnoXsRnlp5lPjFcdJJ+nFzygNZi3dR0eusnkFVuq9lgzc=";
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