
package com.withlee.dbm.service.order;

import java.util.List;

import com.withlee.dbm.domain.order.InvoiceInfo;

/**
 * @desc 发票Service
 * @author linjiazhi
 * @since 2015年7月17日
 */
public interface InvoiceService {

	public List<InvoiceInfo> getInvoiceList(Integer userid);

	public boolean addInvoice(InvoiceInfo invoiceInfo);

	public boolean updateInvoice(InvoiceInfo invoiceInfo);

	public boolean delInvoice(Integer userid, Integer invoiceid);

}
