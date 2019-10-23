
package com.withlee.dbm.domain.cupboard;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @desc 私人衣橱-自动回复
 * @table tbl_auto_repaly
 * @author linjiazhi
 * @since 2015年9月17日
 */
public class TblAutoRepaly implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Integer id;
	private String keywords;// 多个
	private String repalyContent;// 所发生的叫对方跑步.
	private int repalyType;// 0：能识别，1：不能识别，2：最终回复，
	private String comment;// 备注
	@JsonIgnore
	private Date createTime;
	@JsonIgnore
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getRepalyContent() {
		return repalyContent;
	}

	public void setRepalyContent(String repalyContent) {
		this.repalyContent = repalyContent;
	}

	public int getRepalyType() {
		return repalyType;
	}

	public void setRepalyType(int repalyType) {
		this.repalyType = repalyType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}