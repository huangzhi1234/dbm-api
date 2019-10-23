package com.withlee.dbm.domain.common;

/**
 * @desc 版本更新PO
 * @author linjiazhi
 * @since 2015年8月25日
 */
public class Version implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String version;

	private double versionCompare;

	private String title;

	private String info;

	private String url;

	private String isforce;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public double getVersionCompare() {
		return versionCompare;
	}

	public void setVersionCompare(double versionCompare) {
		this.versionCompare = versionCompare;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the info
	 */
	public String getInfo() {
		return this.info;
	}

	/**
	 * @param info
	 *            the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the isforce
	 */
	public String getIsforce() {
		return this.isforce;
	}

	/**
	 * @param isforce
	 *            the isforce to set
	 */
	public void setIsforce(String isforce) {
		this.isforce = isforce;
	}

}