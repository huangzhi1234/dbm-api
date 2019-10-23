
package com.withlee.dbm.controller.alipay;

import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.withlee.dbm.controller.alipay.util.Key;
import com.withlee.dbm.controller.alipay.util.Rsa;
import com.withlee.dbm.domain.order.vo.OrderPlaceVo;
import com.withlee.dbm.persistence.mapper.order.OrderMapper;
import com.withlee.dbm.service.order.OrderService;
import com.withlee.dbm.util.response.CommonResponse;

@RestController
@RequestMapping("/alipay")
public class AlipayController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderMapper orderMapper;
	
	  //为app组装支付宝支付参数
	  private String getOrderInfo(String order_sn,double price) {
		  	  
	        StringBuilder sb = new StringBuilder();
	        sb.append("partner=\"");
	        sb.append(Key.DEFAULT_PARTNER);
	        sb.append("\"&out_trade_no=\"");
	        sb.append(order_sn);
	        sb.append("\"&subject=\"");
	        sb.append("自我定制");
	        sb.append("\"&body=\"");
	        sb.append("自我定制");
	        sb.append("\"&total_fee=\"");
	        sb.append(price);
	        sb.append("\"&notify_url=\"http://www.camiul.com/alipay/notify_url.php");
	        sb.append("\"&service=\"mobile.securitypay.pay");
	        sb.append("\"&_input_charset=\"UTF-8");
	        sb.append("\"&return_url=\"");
	        sb.append(URLEncoder.encode("http://m.alipay.com"));
	        sb.append("\"&payment_type=\"1");
	        sb.append("\"&seller_id=\"");
	        sb.append(Key.DEFAULT_SELLER);
	        sb.append("\"&it_b_pay=\"1m");
	        sb.append("\"");

	        return new String(sb);
	    }
	  
	  public Object getSignInfo(String order_sn,double price){
		  String info=getOrderInfo(order_sn,price);
		  System.out.println("info="+info);
		  String sign = URLEncoder.encode(Rsa.sign(info, Key.PRIVATE));
	      return info+ "&sign=\"" + sign + "\"&" +"sign_type=\"RSA\"";
	 
	  }


	/**
	 * 获取支付宝报文
	 */
	@RequestMapping(value = "/getAlipayMessage", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getAlipayMessage(String out_trade_no) throws IOException {
		OrderPlaceVo orderPlaceVo=orderMapper.getOrderDetailByNum(out_trade_no);
		double fee=orderPlaceVo.getPrice();
		return new CommonResponse(this.getSignInfo(out_trade_no,fee));
	}

	/**
	 * 获取文件属性
	 */
	@RequestMapping(value = "/copyFile", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse copyFile(String key, String targetKey) throws IOException {
		boolean b = false;
	//	b = qiniuApi.copyFile(key, targetKey);
		if (b) {
			return new CommonResponse("操作成功");
		} else {
			return new CommonResponse("操作失败");
		}

	}

}
