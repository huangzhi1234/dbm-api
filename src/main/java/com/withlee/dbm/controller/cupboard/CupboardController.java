
package com.withlee.dbm.controller.cupboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.withlee.dbm.domain.cupboard.TblClothingMatch;
import com.withlee.dbm.domain.cupboard.TblScene;
import com.withlee.dbm.domain.cupboard.Vo.EcsGoodsVo;
import com.withlee.dbm.persistence.mapper.cupboard.CupboardMapper;
import com.withlee.dbm.persistence.mapper.order.OrderMapper;
import com.withlee.dbm.persistence.mapper.shop.ShopMapper;
import com.withlee.dbm.service.cupboard.CupboardService;
import com.withlee.dbm.util.CommonUtil;
import com.withlee.dbm.util.UserUtils;
import com.withlee.dbm.util.response.CommonResponse;

/**
 * @desc 私人衣橱Controller
 * @author linjiazhi
 * @since 2015年8月31日
 */
@RestController
@RequestMapping("/cupboard")
public class CupboardController {

	private static Logger logger = LoggerFactory.getLogger(CupboardController.class);

	@Autowired
	private CupboardService cupboardService;

	@Autowired
	private ShopMapper shopMapper;

	@Autowired
	private CupboardMapper cupboardMapper;

	@Autowired
	private OrderMapper orderMapper;

	/**
	 * @desc 场景查询
	 * @remark 查全部,给客户端显示
	 * @param null
	 */
	@RequestMapping(value = "/scene", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getScene() throws Exception {

		try {
			Integer sceneId = null;// 这个方法不需要参数
			return new CommonResponse(cupboardMapper.getScene(sceneId));
		} catch (Exception e) {
			logger.error("[getScene] - fail to getScene " + e.getMessage());
			return new CommonResponse("场景查询异常");
		}
	}

	/**
	 * @desc 商品查询(带goodsId查单个,不带goodsId查列表)
	 */
	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getProductListByScene(HttpServletRequest request, @RequestParam(value = "words", required = false) String words,
			@RequestParam(value = "goodsId", required = false) String goodsId) throws Exception {

		Integer userId = 43;// UserUtils.getUserId(request);
		// System.out.println(userId);
		try {
			/**
			 * 1.查词库
			 */
			// 参数不能为空
			if (StringUtils.isBlank(words)) {
				logger.error("[getProductListByScene] - params must not be null");
				return new CommonResponse("请输入关键字查询商品");
			}
			// 一句话找出到词库ID
			Integer sceneId = cupboardMapper.wordsFindSceneId(CommonUtil.addElement(words));
			// System.out.println("sceneId=" + sceneId);
			if (sceneId == null) {
				logger.error("[getProductListByScene] - scene is null");
				return new CommonResponse("没有找到相关场景");
			}

			// 2.词库查场景
			List<TblScene> scene = cupboardMapper.getScene(sceneId);
			if (scene == null) {
				logger.error("[getProductListByScene] - scene is null");
				return new CommonResponse("没有找到相关场景");
			}
			// List转单个对象
			TblScene tblScene = scene.get(0);

			// 结果返回:vos
			List<EcsGoodsVo> vos = new ArrayList<EcsGoodsVo>();

			// 超过3款商品只显示前3款
			List<EcsGoodsVo> resultList = new ArrayList();

			// 3.场景查用户商品
			List<EcsGoodsVo> userGoods = orderMapper.getOrderProductByUserId(userId, tblScene.getSceneName(), goodsId);

			for (EcsGoodsVo ecsGoodsVo : userGoods) {
				vos.add(ecsGoodsVo);
				continue;
			}
			// 如果goodsId为空,证明查单个,因此下面这段代码就不执行.
			if (StringUtils.isBlank(goodsId)) {

				// 4.场景查商品
				List<EcsGoodsVo> goods = shopMapper.getProductListByScene(userId, tblScene.getSceneName());

				if (goods == null || goods.size() == 0)
					return null;

				for (EcsGoodsVo ecsGoodsVo : goods) {
					vos.add(ecsGoodsVo);
				}
			}
			// 截取前3个
			for (int i = 0; i < vos.size(); i++) {
				if (i < 4)
					resultList.add(vos.get(i));
			}

			return new CommonResponse(resultList);
		} catch (Exception e) {
			logger.error("[getScene] - fail to getScene " + e.getMessage());
			return new CommonResponse("商品查询异常");
		}
	}

	/**
	 * 增加足迹-服装搭配
	 */
	@RequestMapping(value = "/spoor/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public CommonResponse addSpoor(HttpServletRequest request, @RequestBody TblClothingMatch tblClothingMatch) throws Exception {

		try {
			Integer userId = UserUtils.getUserId(request);
			tblClothingMatch.setUserId(userId);
			tblClothingMatch.setCreateTime(new Date());
			cupboardService.addSpoor(tblClothingMatch);
			return new CommonResponse();

		} catch (Exception e) {
			logger.error("[addSpoor] - fail to addSpoor " + e.getMessage());
			return new CommonResponse("增加足迹异常");
		}
	}

	/**
	 * 查足迹列表-服装搭配
	 */
	@RequestMapping(value = "/spoor/list", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getSpoor(HttpServletRequest request) throws Exception {

		try {
			Integer userId = UserUtils.getUserId(request);
			return new CommonResponse(cupboardMapper.getSpoor(userId));

		} catch (Exception e) {
			logger.error("[getSpoor] - fail to getSpoor " + e.getMessage());
			return new CommonResponse("查足迹异常");
		}
	}

	/**
	 * 删除足迹-服装搭配
	 */
	@RequestMapping(value = "/spoor/{spoorId}/del", method = RequestMethod.DELETE)
	@ResponseBody
	public CommonResponse delSpoor(@PathVariable Integer spoorId) throws Exception {

		try {
			cupboardService.delSpoor(spoorId);
			return new CommonResponse();

		} catch (Exception e) {
			logger.error("[getSpoor] - fail to getSpoor " + e.getMessage());
			return new CommonResponse("查足迹异常");
		}
	}

	/**
	 * 私人衣橱-查资讯
	 */
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getNewsInfo() throws Exception {

		try {
			return new CommonResponse(cupboardMapper.getNewsInfo());
		} catch (Exception e) {
			logger.error("[getNewsInfo] - fail to getNewsInfo " + e.getMessage());
			return new CommonResponse("查资讯异常");
		}
	}

	/**
	 * @desc 私人衣橱-引导语-个性化内容表
	 */
	@RequestMapping(value = "/lead", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getLead() throws Exception {
		try {
			return new CommonResponse(cupboardMapper.getLead());
		} catch (Exception e) {
			logger.error("[getNewsInfo] - fail to getNewsInfo " + e.getMessage());
			return new CommonResponse("查资讯异常");
		}
	}

	/**
	 * @desc 私人衣橱-自动回复
	 */
	@RequestMapping(value = "/antoAnswer", method = RequestMethod.GET)
	@ResponseBody
	public CommonResponse getAntoAnswer() throws Exception {
		try {
			return new CommonResponse(cupboardMapper.getLead());
		} catch (Exception e) {
			logger.error("[getNewsInfo] - fail to getNewsInfo " + e.getMessage());
			return new CommonResponse("查资讯异常");
		}
	}

}
