
package com.withlee.dbm.domain.cupboard;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @desc 私人衣橱-引导语-个性化内容表
 * @table tbl_fash_content
 * @author linjiazhi
 * @since 2015年9月17日
 */
public class TblFashContent implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Integer id;

	private String keywords;// 语句包含的关键词 单个

	private String content;// 语句内容（与咨询的关键词有关联）

	@JsonIgnore
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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