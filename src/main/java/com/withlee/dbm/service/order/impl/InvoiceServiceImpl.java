
package com.withlee.dbm.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.withlee.dbm.domain.order.InvoiceInfo;
import com.withlee.dbm.persistence.mapper.order.InvoiceMapper;
import com.withlee.dbm.service.order.InvoiceService;

/**
 * @desc 发票ServiceImpl
 * @author linjiazhi
 * @since 2015年7月17日
 */
@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceMapper invoiceMapper;

	/*
	 * 获取地址列表
	 */
	@Override
	public List<InvoiceInfo> getInvoiceList(Integer userid) {
		return this.invoiceMapper.getInvoiceList(userid);
	}

	/*
	 * 新增地址
	 */
	@Override
	public boolean addInvoice(InvoiceInfo invoiceInfo) {
		this.invoiceMapper.addInvoice(invoiceInfo);
		return true;
	}

	/*
	 * 修改地址
	 */
	@Override
	public boolean updateInvoice(InvoiceInfo invoiceInfo) {
		this.invoiceMapper.updateInvoice(invoiceInfo);
		return true;
	}

	@Override
	public boolean delInvoice(Integer userid, Integer invoiceid) {
		this.invoiceMapper.delInvoice(userid, invoiceid);
		return true;
	}

}
