
package com.withlee.dbm.controller.order;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.withlee.dbm.domain.order.InvoiceInfo;
import com.withlee.dbm.service.order.InvoiceService;
import com.withlee.dbm.util.response.CommonResponse;

/**
 * @desc 发票Controller
 * @author linjiazhi
 * @since 2015年7月17日
 */
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	private static Logger logger = LoggerFactory.getLogger(InvoiceController.class);

	@Autowired
	private InvoiceService invoiceService;

	/**
	 * 查询发票列表
	 */
	@RequestMapping(value = "/list/{userid}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getInvoiceList(@PathVariable Integer userid) throws Exception {
		try {

			return new CommonResponse(this.invoiceService.getInvoiceList(userid));
		} catch (Exception e) {
			logger.error("[getInvoiceList] - fail to getInvoiceList " + e.getMessage());
			return new CommonResponse("查询发票异常");
		}

	}

	/**
	 * 增加发票
	 */
	@RequestMapping(value = "/add/{userid}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public CommonResponse addInvoice(@PathVariable Integer userid, @RequestBody InvoiceInfo invoiceInfo) throws Exception {

		try {
			invoiceInfo.setUserId(userid);
			return new CommonResponse(this.invoiceService.addInvoice(invoiceInfo));
		} catch (Exception e) {
			logger.error("[addInvoice] - fail to addInvoice " + e.getMessage());
			return new CommonResponse("新增发票失败");
		}
	}

	/**
	 * 修改发票
	 */
	@RequestMapping(value = "/update/{userid}", method = RequestMethod.PUT)
	@ResponseBody
	public CommonResponse updateInvoice(@PathVariable Integer userid, @RequestBody InvoiceInfo invoiceInfo) throws IOException {
		try {
			invoiceInfo.setUserId(userid);
			return new CommonResponse(this.invoiceService.updateInvoice(invoiceInfo));
		} catch (Exception e) {
			logger.error("[updateInvoice] - fail to updateInvoice " + e.getMessage());
			return new CommonResponse("更新发票失败");
		}
	}

	/**
	 * 删除发票
	 */
	@RequestMapping(value = "/delete/{userid}/{invoiceid}", method = RequestMethod.DELETE)
	@ResponseBody
	public CommonResponse delInvoice(@PathVariable Integer userid, @PathVariable Integer invoiceid) throws IOException {

		try {
			return new CommonResponse(this.invoiceService.delInvoice(userid, invoiceid));
		} catch (Exception e) {
			logger.error("[delInvoice] - fail to delInvoice " + e.getMessage());
			return new CommonResponse("删除发票失败");
		}
	}

}
