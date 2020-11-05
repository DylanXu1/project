package com.chains.project.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.chains.project.config.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xdx
 * @date 2020/8/13
 * @version 1.0
 */

@Controller
public class AlipayIumpSum {
    /**
     * 快捷支付调用支付宝支付接口
     * @param model，id，payables，
     * @return Object
     */
    @RequestMapping("alipaySum")
    public Object alipayIumpSum(Model model, String WIDout_trade_no, String WIDsubject, String WIDtotal_amount,String WIDbody,
                                HttpServletResponse response)
            throws Exception {
        //System.out.println("请求进来:"+WIDtotal_amount);
        String payables = WIDout_trade_no;
        // 订单名称，必填
        String subject = WIDsubject;
        // 付款金额，必填
        String total_fee = WIDtotal_amount;
        // 商品描述，可空
        String body = WIDbody;
        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                AlipayConfig.merchant_private_key, "json", AlipayConfig.charset,
                AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        // 商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = sdf.format(new Date());
        // 付款金额，必填
        String total_amount = total_fee.replace(",", "");
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
                + "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        // 请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        //System.out.println("这个是response值："+result);  //这个是返回的支付信息
        //EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
        AlipayConfig.logResult(result);// 记录支付日志
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        return null;
    }


    /**
     * p2p后台返回的操作
     * @param response，request
     * @throws Exception
     * @return void
     * @author java_rookies_gbj有梦想一起实现
     * @date 2017年11月30日
     */
    @RequestMapping("notify_url")
    public void Notify(HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("----------------------------notify_url------------------------");
        // 商户订单号
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "GBK");
        // 付款金额
        String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "GBK");
        // 支付宝交易号
        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "GBK");
        // 交易说明
        String cus = new String(request.getParameter("body").getBytes("ISO-8859-1"), "GBK");
        // 交易状态
        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "GBK");
        if (trade_status.equals("TRADE_SUCCESS")) {//支付成功商家操作
            //下面是我写的一个简单的插入操作，根据你的操作自行编写
            /*Map<Object, Object> map = new HashMap<Object, Object>();
            map.put("cuId", Integer.valueOf(cus));
            RepaymentPlan repaymentPlan = new RepaymentPlan();
            Integer id = Integer.valueOf(out_trade_no);
            double payablesCheck = Double.valueOf(total_amount);
            RepaymentPlan repayCheck = serviceMain.selectByPrimaryKey(id);
            double total = repayCheck.getPayables();
            if (Double.valueOf(total_amount) < repayCheck.getPayables()) {
                map.put("ubalance", total - Double.valueOf(total_amount));
                serviceMain.updateCusMoney(map);
            }
            repaymentPlan.setId(id);
            repaymentPlan.setActualPayment(total);
            repaymentPlan.setRepaymentStatus(1);
            int i = serviceMain.updateByPrimaryKeySelective(repaymentPlan);
            System.out.println("---------------------还款影响行数----------------------------" + i);*/
        }
    }


    /**
     * 同步通知的页面的Controller
     *
     * @throws InterruptedException
     * @author java_rookies_gbj有梦想一起实现
     */
    @RequestMapping("return_url")
    public String Return_url() throws InterruptedException {
        return "alipayexit";
    }



}
