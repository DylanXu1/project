package com.chains.project.config;

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

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101000655701";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCnoW16u6oM2y8M+SLuV83U7+jqwkMRdIC/NP/5IpjrU7plCdIlh2zQGjXUSzjS332dOfuw6j3ros71TT94j6zPR7/RJ8pyty0MO5D++jwYetkFOI/12URZ0Mfr4teZgaqdXE3tKUgLFsGYERIvAGrBtXVFUsqGubTSuRNmJGvz0U55De4+X4ULWxAeaQ3wwarxifazy7R4rIQ0W81KLW3YcKeIs3VGWZaUeDoK60taqJpcwgd0rqOCAWqKEAvmXJvvG0wxZeKCZIjdjAkJgsM+uT9VOum7zp3j2lZLVoMysi2aOCjMweprYakIEFO4+JMkmLSdK77hMQzmGw3qtKInAgMBAAECggEAA/17tagx7Axrmktz4WiFpcPwL2ZgYlH7npGMZknEihV8IluRfQM0O9/j2CHSQHLBcrSmoRdyUeGWO5CTKjOBUY3LqxbfYsupbtkcInWiaJLEB7PI+Xkqf1jQ6XSE3UqQ3R4NXM/WvyzTfuMpI6VG5UWEfRnzaDGTdFCjfZLwXuVao6SRE5kNJyFwD01/tGNW72U5j6d1vZn0DI7UbcxhLTH/ad0TU6dHZog0j30w9prx/0bO4YFqN81yWO870GnqZpUlKSks+jqC1vTyFV/tssP+GEFMf5cuAWICBpksD7KXxvruHP3yjXLw5bSiOud069dFRRN1G6efuJ+1r5MtAQKBgQDoOP18wk+lZQns3jgPwAzSENHclCmaz1TgvKKAYV+ekPqI/idQvDzvE2MbBsk140JtFMDhIl6jG9FAn0lVM0y6IMtWe9mQMxP2WYVhnkjKJNR0j8ePbT4bLkLspNfYbcTnla+txyGjn+S8m/zE55w+z7lKEDDLTSlxzCQrsbfv0QKBgQC4y1p/5g0f8rEbQJeOSnaZaeH0kF5C11deIesGkgZt3zpJOwqic13LT0KP+AfA0qe4E1wJY1SkTUyxZzwWl92Ic81gU1wNfAjZKsoX8M3RRkCMXyZt2m7FkiSjUKL9VY7WK3k0JHenYt+oDKVKoIJuC/rNnJ1iADegT+In62OodwKBgQCSICJqGf9yLPUk5uRSDOBEYy8bZOQVNTfMvwZmUF+R8Nqlz3+/zuNs8T8gp5F/ZkTLTQ7d2/m/G2b+Cf1kLoaubKpm/kH1+h4qm0RSG/7jrG8/9aV2fCBjjCWysTvdRZ1suIU2jaJ+SsPtZx6UbMWlxKJsl2mM1D4rDHEKSadbsQKBgQCqwU14zYznLoy0z/S7SNdaX1qpcBWJ0g4rL1BLG/fQ4uqq7GGhRtUunqi0+82+QWk1UL5E9oIp6Dur2ebOQbo08jyee6id1TUf5sgjYyHr9OyESQ/rhmHBMo+kUUiqqrp38Gfo5KGkDFr6n+TElpivM2anQ8ax3d2IxwgFNx85dQKBgGFfwJdMnm9ToL3uHgmf04Cz6EbYaUfpPeGWutXcbo2wvy+ZqPPM2rN6+ITMV8yF7/9T2gFJtICZg29nyFq6cQAw68Od4PnCzD1s76OjxfGi8kZycY26hLXIeNO0gbgmvtubw8E7srNh1lPBaLhBo2phO1klVvT8zpju4NbCFoRg";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwB3WZjnGMplXYP/U4qX6TT1AQUPvUbJNOaCtnFDPMDr/qYF1yTgZoARIh8Mvt9lW2AeugeRw8ejKanFjA4F24h9OL1ydxpz9BB5MzW9BMoZbkwSmBn8ZnUYBwokz2/9RwzSvqpYgqppzIp/uncW1MPWMV2BgxlO26oyNxNHjCPezN1lHFktijjrgI1H62b4HosHruO8cueXSFp83j7v8kHmY6lbBHedjBctn32EJ6EC/kRQyYFXu2HwgmdKr4U8XKzZswQxoNEINfO8Bg3cRPolAgLa1arG0ikjGBjQD6Ppz58HNYDgXGr7RIJsMWwdO8awwCEOcKtpxNerTSeyRxwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/notify_url.html";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/return_url.html";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "D:/logs/";


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

