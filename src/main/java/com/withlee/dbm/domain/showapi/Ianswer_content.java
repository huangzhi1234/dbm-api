package com.withlee.dbm.domain.showapi;



public class Ianswer_content implements java.io.Serializable {

	/**
	 * 答案查询
	 */

	private Integer id;
	private String questId;    //题目
	private String answer;    //答案
	private String rightAns;  //正确答案
	private String referSrc;  //参考资料地址
	private String questPars;    //答案解析
	private String createuser;
	private String createtime;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestId() {
		return questId;
	}
	public void setQuestId(String questId) {
		this.questId = questId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getRightAns() {
		return rightAns;
	}
	public void setRightAns(String rightAns) {
		this.rightAns = rightAns;
	}
	public String getReferSrc() {
		return referSrc;
	}
	public void setReferSrc(String referSrc) {
		this.referSrc = referSrc;
	}
	public String getQuestPars() {
		return questPars;
	}
	public void setQuestPars(String questPars) {
		this.questPars = questPars;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	
	
	
	
	
	

	

}