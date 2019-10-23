
package com.withlee.dbm.domain.cupboard;

import java.util.Date;

/**
 * @desc 私人衣橱 - 足迹(服装搭配:tbl_clothing_match)
 * @author linjiazhi
 * @since 2015年9月5日
 */
public class TblClothingMatch implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer userId;

	private Date createTime;// 时间

	private Integer sceneId;// 场景ID

	private String matchKeyword;// 场景名称+一句话

	private String goodsId;// 商品ID

	private String goodsName;// 商品名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getSceneId() {
		return sceneId;
	}

	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}

	public String getMatchKeyword() {
		return matchKeyword;
	}

	public void setMatchKeyword(String matchKeyword) {
		this.matchKeyword = matchKeyword;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}