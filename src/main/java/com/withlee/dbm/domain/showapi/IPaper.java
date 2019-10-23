package com.withlee.dbm.domain.showapi;



public class IPaper implements java.io.Serializable {

	/**
	 * 试卷列表查询
	 */

	private Integer id;
	private String paperName;    //试卷名称
	private String paperType;    //试卷类型
	private String totalAccount;  //总题数
	private String toPurpose;    //用途
	private String totalScore;   //试卷总分
	private String createuser;   //创建人
	private String createtime;   //创建时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getPaperType() {
		return paperType;
	}
	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}
	public String getTotalAccount() {
		return totalAccount;
	}
	public void setTotalAccount(String totalAccount) {
		this.totalAccount = totalAccount;
	}
	public String getToPurpose() {
		return toPurpose;
	}
	public void setToPurpose(String toPurpose) {
		this.toPurpose = toPurpose;
	}
	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
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