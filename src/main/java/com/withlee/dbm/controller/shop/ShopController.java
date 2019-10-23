
package com.withlee.dbm.controller.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.withlee.dbm.domain.shop.EcsGoods;
import com.withlee.dbm.domain.shop.EcsGoodsAttr;
import com.withlee.dbm.domain.shop.TblDetailInfo;
import com.withlee.dbm.domain.shop.Vo.GoodsDetailVo;
import com.withlee.dbm.domain.shop.Vo.ProDetailVo;
import com.withlee.dbm.domain.shop.Vo.ProLevelOneAttr;
import com.withlee.dbm.persistence.mapper.shop.ShopMapper;
import com.withlee.dbm.service.shop.ShopService;
import com.withlee.dbm.util.response.CommonResponse;
import com.withlee.dbm.util.response.PageResponse;

/**
 * @desc 商品信息接口
 * @author 林嘉智
 * @since 2015年7月18日
 * @since 2015年8月5日 (重构)
 */
@RestController
@RequestMapping("/product")
public class ShopController {

	private static Logger logger = LoggerFactory.getLogger(ShopController.class);

	@Autowired
	private ShopService shopService;

	@Autowired
	private ShopMapper shopMapper;

	/**
	 * 查询首页图片
	 */
	@RequestMapping(value = "/home/pic", method = RequestMethod.GET)
	public CommonResponse getHomePic() throws IOException {
		try {

			ModelMap m = new ModelMap();
			m.put("url", "http://www.camiul.com" + this.shopService.getHomePic());
			return new CommonResponse(m);

		} catch (Exception e) {
			logger.error("[getHomePic] - fail to getHomePic " + e.getMessage());
			return new CommonResponse("查询首页图片失败");

		}
	}

	/**
	 * 查询商品类型接口
	 */
	@RequestMapping(value = "/type", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getProductType() throws IOException {
		try {
			return new CommonResponse(this.shopService.getProductType());
		} catch (Exception e) {
			logger.error("[getProductType] - fail to getProductType " + e.getMessage());
			return new CommonResponse("查询商品类型失败");

		}
	}

	/**
	 * 查询产品列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getProductList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "20") int limit, EcsGoods ecsGoods,
			@RequestParam(value = "gender", required = false) String gender) throws IOException {
		try {
			ecsGoods.setIs_male_dress(gender);
			// 用于物理分页
			ecsGoods.setPage((page - 1) * limit);
			ecsGoods.setLimit(limit);

			int total = shopMapper.countProductList(ecsGoods);
			PageResponse pageResponse = new PageResponse(shopService.getProductList(ecsGoods));
			// 用于返回给客户端
			pageResponse.setPage(page);
			pageResponse.setLimit(limit);
			pageResponse.setTotalPage(total);
			return new CommonResponse(pageResponse);
		} catch (Exception e) {
			logger.error("[getProductList] - fail to getProductList " + e.getMessage());
			return new CommonResponse("查询产品列表失败");
		}
	}

	/**
	 * @desc 获取产品详情(实际上是查商品属性)
	 */
	@RequestMapping(value = "/info/{productid}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getProductDetail(@PathVariable int productid) throws IOException {

		List<ProDetailVo> allAttr = new ArrayList();// 存储属性

		// 1. 获取商品一级属性:[3199,3200,3201,3202,3203]
		List<ProLevelOneAttr> oneLevel = shopService.getProLevelOneAttr(productid);

		ProLevelOneAttr proLevelOneAttr = new ProLevelOneAttr();

		// 2. 获取商品所有属性
		List<EcsGoodsAttr> goodsAttrlist = shopService.getGoodsAttrlist(productid);

		EcsGoodsAttr ecsGoodsAttr = new EcsGoodsAttr();

		for (int i = 0; i < oneLevel.size(); i++) {
			proLevelOneAttr = oneLevel.get(i);
			ProDetailVo proDetailVo = new ProDetailVo();
			proDetailVo.setAttrId(proLevelOneAttr.getAttrId());
			proDetailVo.setAttrName(proLevelOneAttr.getAttrName());
			// 3. 存储子属性项
			List<EcsGoodsAttr> arrtivalueList = new ArrayList();
			for (int m = 0; m < goodsAttrlist.size(); m++) {
				// 拿list元素赋值到单个对象
				ecsGoodsAttr = goodsAttrlist.get(m);
				// 全部属性的list存到对象里面
				if (!StringUtils.isEmpty(proDetailVo.getAttrId()) && proDetailVo.getAttrId().equals(ecsGoodsAttr.getAttrId())) {
					arrtivalueList.add(ecsGoodsAttr);
				}
				proDetailVo.setAttrivalue(arrtivalueList);
			}
			allAttr.add(proDetailVo);
		}
		GoodsDetailVo goodsDetailVo = new GoodsDetailVo();
		goodsDetailVo.setSpec(allAttr);
		goodsDetailVo.setInfo(shopMapper.getSingleGoodsInfo(productid));
		goodsDetailVo.setShowingPic(shopMapper.getGoodsPic(productid));
		return new CommonResponse(goodsDetailVo);
	}

	/**
	 * @desc 获取产品详情(旧实现)
	 */
	// @RequestMapping(value = "/info/{productid}", method = RequestMethod.GET)
	@ResponseBody
	public List<ProDetailVo> getProductDetail2(@PathVariable Integer productid) throws IOException {
		// 取出全部多表数据,做逻辑查询.
		List<TblDetailInfo> list = null;// this.shopService.getProductDetail(productid)

		// 找出级别为0的数据可以获得属性名称（面料，版型）
		List attriArr = new ArrayList();// 存储属性

		// 循环list元素
		for (int i = 0; i < list.size(); i++) {

			TblDetailInfo tblDetailInfo = list.get(i);
			Integer attri = null;// 属性ID
			ProDetailVo proDetailVo = new ProDetailVo();// null;
			boolean flag = false;
			// 如果是父节点就给个true
			if ("0".equals(tblDetailInfo.getAttriLevel())) {// 找到一个属性项(级别为0)
				flag = true;// 找到一个父级属性项
				// proDetailVo = new ProDetailVo();

				// proDetailVo.setAttriId(tblDetailInfo.getAttriId());
				// proDetailVo.setAttriName(tblDetailInfo.getAttriName());

				attri = tblDetailInfo.getAttriId();
			}
			if (flag) {// 找到了父级属性项之后才去找子属性
				// 找出该属性项的子项
				List<TblDetailInfo> arrtivalueList = new ArrayList();// 存储子属性项
				for (int m = 0; m < list.size(); m++) {
					TblDetailInfo tblDetailInfo1 = list.get(m);
					// 如果父ID等于上面的属性ID，就证明是父子关系
					if (tblDetailInfo1.getAttriOperId() != null && tblDetailInfo1.getAttriOperId() == attri) {
						arrtivalueList.add(tblDetailInfo1);
					}
				}
				// proDetailVo.setAttrivalue(arrtivalueList);
				attriArr.add(proDetailVo); // 只有成功的找打一个父属性和他对应的子属性项才添加到list中
				flag = false;
			}

		}
		return attriArr;
	}

	/**
	 * @desc 商品结果查询获取图片URL(2d/3d)
	 */
	@RequestMapping(value = "/result/{goods_id}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getProductResult(@PathVariable int goods_id,
			@RequestParam(value = "specZheng", required = false) String specZheng,
			@RequestParam(value = "specFan", required = false) String specFan) throws IOException {

		try {
			// 获取子龙URL
			// JSONObject json = (JSONObject)
			// HttpUtils.doAsyncGet("http://192.168.0.116:8080/mgr/goods/image/design?goods_id=1&front_spec_desc=1_4_9&back_spec_desc=2_4_9",
			// buildParams(goods_id, spec_desc));
			// return new CommonResponse(json);
			ModelMap m = new ModelMap();

			// 正式环境2d
			// m.put("spec2d", "http://m.camiul.com/images/camiul/cache/" + goods_id + "/" + goods_id + "_" + spec2d + ".png");
			// 测试环境2d
			m.put("specZheng", "http://www.camiul.com/images/camiul/cache/" + goods_id + "/" + goods_id + "_" + specZheng + ".png");
			m.put("specFan", "http://www.camiul.com/images/camiul/cache/" + goods_id + "/" + goods_id + "_" + specFan + ".png");
			// 获取3D Url
			if (!StringUtils.isEmpty(specZheng)) {
				int idx = specZheng.indexOf("_");
				specZheng = specZheng.substring(idx + 1, specZheng.length());
			}

			// 测试代码
			// m.put("spec3d", "http://www.camiul.com/ver/testzip.zip");
			// 生产代码,3D需要判断
			if (shopMapper.get3dUrl(goods_id, specZheng) == null) {
				m.put("spec3d", "");
			} else {
				m.put("spec3d", "http://www.camiul.com/" + shopMapper.get3dUrl(goods_id, specZheng));
			}

			return new CommonResponse(m);
		} catch (Exception e) {
			logger.error("[getProductResult] - fail to getProductResult " + e.getMessage());
			return new CommonResponse("商品结果查询失败");

		}
	}

	/**
	 * HTTP所需参数
	 */
	// private Map<String, String> buildParams(String goods_id, String spec_desc) {
	// Map<String, String> params = new HashMap<String, String>();
	//
	// params.put("goods_id", goods_id);
	// params.put("spec_desc", spec_desc);
	// return params;
	// }
}
