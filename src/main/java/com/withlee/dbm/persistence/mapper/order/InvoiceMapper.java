
package com.withlee.dbm.persistence.mapper.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.withlee.dbm.domain.order.InvoiceInfo;

/**
 * @desc 收货地址Impl
 * @author linjiazhi
 * @since 2015年7月17日
 */
public interface InvoiceMapper {

	public List<InvoiceInfo> getInvoiceList(Integer user_id);

	public void addInvoice(InvoiceInfo invoiceInfo);

	public void updateInvoice(InvoiceInfo invoiceInfo);

	public void delInvoice(@Param("userid") Integer userid, @Param("invoiceid") Integer invoiceid);

	public InvoiceInfo getInvoice(@Param("userid") Integer userid, @Param("invoiceid") Integer invoiceid);

}
