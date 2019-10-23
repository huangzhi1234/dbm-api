
package com.withlee.dbm.domain.cupboard;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.withlee.dbm.util.UrlSerializer;

/**
 * @desc 资讯信息表tbl_new_info
 * @author linjiazhi
 * @since 2015年9月5日
 */
public class TblNewInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Integer id;

	private String title;
	@JsonSerialize(using = UrlSerializer.class)
	private String newImgs;

	private String content;

	@JsonIgnore
	private String createOper;

	private Date createTime;

	private Integer viewCount;// 浏览量

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNewImgs() {
		return newImgs;
	}

	public void setNewImgs(String newImgs) {
		this.newImgs = newImgs;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateOper() {
		return createOper;
	}

	public void setCreateOper(String createOper) {
		this.createOper = createOper;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}