package com.withlee.dbm.api.qiniu;

import java.util.ArrayList;
import java.util.List;

public class QiniuInfoPo implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String productID;//产品ID
	private List<FilePo> fileList =new ArrayList();
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public List<FilePo> getFileList() {
		return fileList;
	}
	public void setFileList(List<FilePo> fileList) {
		this.fileList = fileList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
