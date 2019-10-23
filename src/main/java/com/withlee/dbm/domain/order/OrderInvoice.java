package com.withlee.dbm.domain.order;

import java.util.Date;

/**
 * 
 * @desc 订单发票表
 * @table tbl_order_invoice
 * @author linjiazhi
 * @since 2015年7月22日
 *
 */
public class OrderInvoice implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer orderInvoiceId;

	private Integer orderId;

	private Date createInvoiceTime;

	private Integer userId;

	private String invoiceContent;

	private String invoiceType;

	private String comment;

	public Integer getOrderInvoiceId() {
		return orderInvoiceId;
	}

	public void setOrderInvoiceId(Integer orderInvoiceId) {
		this.orderInvoiceId = orderInvoiceId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getCreateInvoiceTime() {
		return createInvoiceTime;
	}

	public void setCreateInvoiceTime(Date createInvoiceTime) {
		this.createInvoiceTime = createInvoiceTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getInvoiceContent() {
		return invoiceContent;
	}

	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
