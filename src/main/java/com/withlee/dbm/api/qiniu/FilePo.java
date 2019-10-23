package com.withlee.dbm.api.qiniu;

public class FilePo {
	private String key1;//操作文件
	private String key2;//被操作文件
	private byte[] filebyte;//上传
	private String size;
	private String fileType;
	private String fileName;
	
	
	

	public byte[] getFilebyte() {
		return filebyte;
	}
	public void setFilebyte(byte[] filebyte) {
		this.filebyte = filebyte;
	}
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
	

}
