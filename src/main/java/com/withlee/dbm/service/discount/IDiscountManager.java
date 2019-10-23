package com.withlee.dbm.service.discount;

import com.withlee.dbm.domain.discount.TblEventCoupon;
import com.withlee.dbm.domain.discount.TblEventInfo;
import com.withlee.dbm.domain.discount.vo.CouponVo;

import java.util.Collection;
import java.util.List;

/**
 * Created by zilongye on 15/9/7.
 */
public interface IDiscountManager {

    Collection<CouponVo> mapper(List<TblEventInfo> tblEventInfos, List<TblEventCoupon> tblEventCoupons);
}
