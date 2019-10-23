package com.withlee.dbm.domain.showapi;



public class Iquest_content implements java.io.Serializable {

	/**
	 * 题目查询
	 */

	private Integer id;
	private String title;    //题目
	private String questType;    //试卷类型
	private String techType;  //技术分类
	private String positionType;
	private String score;    //试题分数
	private String createtime;
	private String createuser;
	private String dicNum;
	
	
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
	public String getQuestType() {
		return questType;
	}
	public void setQuestType(String questType) {
		this.questType = questType;
	}
	public String getTechType() {
		return techType;
	}
	public void setTechType(String techType) {
		this.techType = techType;
	}
	public String getPositionType() {
		return positionType;
	}
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	public String getDicNum() {
		return dicNum;
	}
	public void setDicNum(String dicNum) {
		this.dicNum = dicNum;
	}
	
	
	
	

	

}