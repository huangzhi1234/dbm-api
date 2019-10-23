
package com.withlee.dbm.domain.cupboard;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.withlee.dbm.util.UrlSerializer;

/**
 * @desc 场景表tbl_scene
 * @author linjiazhi
 * @since 2015年8月31日
 */
public class TblScene implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer sceneId;

	private String sceneName;

	private Integer sceneOrder;

	private String sceneDisc;
	@JsonSerialize(using = UrlSerializer.class)
	private String sceneImgUrl;

	public Integer getSceneId() {
		return sceneId;
	}

	public void setSceneId(Integer sceneId) {
		this.sceneId = sceneId;
	}

	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}

	public Integer getSceneOrder() {
		return sceneOrder;
	}

	public void setSceneOrder(Integer sceneOrder) {
		this.sceneOrder = sceneOrder;
	}

	public String getSceneDisc() {
		return sceneDisc;
	}

	public void setSceneDisc(String sceneDisc) {
		this.sceneDisc = sceneDisc;
	}

	public String getSceneImgUrl() {
		return sceneImgUrl;
	}

	public void setSceneImgUrl(String sceneImgUrl) {
		this.sceneImgUrl = sceneImgUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}