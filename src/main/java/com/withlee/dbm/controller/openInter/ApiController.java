
package com.withlee.dbm.controller.openInter;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.show.api.ShowApiRequest;
import com.withlee.dbm.api.qiniu.FilePo;
import com.withlee.dbm.api.qiniu.QiniuInfoPo;
import com.withlee.dbm.controller.common.showapi.Constants;
import com.withlee.dbm.controller.showapi.ShowApiComm;
import com.withlee.dbm.service.shop.ShopService;
import com.withlee.dbm.util.constant.PlatformConstant;
import com.withlee.dbm.util.response.CommonResponse;

@RestController
@RequestMapping("/openApi")
public class ApiController {

	@Autowired
	private ShopService shopService;
	
//	
//	
//	private QiniuApi qiniuApi = new QiniuApi();
//	/*
//	 * 测试:http://localhost:8001/openApi/qiNiuUpLoad/3 { "productID": "343553", "fileList": [{ "filePath": "E://huangzhi//与李信息//protet.jpg",
//	 * "size": 2, "fileType": "1", "fileName": "/product/p_1212/a_34343"}] }
//	 * 
//	 */
//
//	@RequestMapping(value = "/qiNiuUpLoad", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
//	@ResponseBody
//	public CommonResponse qiNiuUpLoad(@RequestBody QiniuInfoPo qiniuInfoPo) throws IOException {
//
//		System.out.println("进到后台方法....");
//		if (qiniuInfoPo == null) {
//			return new CommonResponse("请求参数为空");
//		}
//		boolean b = false;
//		String productID = qiniuInfoPo.getProductID();
//		List<FilePo> fileList = qiniuInfoPo.getFileList();
//		for (int i = 0; i < fileList.size(); i++) {
//			FilePo filePo = fileList.get(i);
//			String fileName = filePo.getFileName();// 七牛上面的路径
//			byte[] buf = filePo.getFilebyte();// 七牛上面的路径
//			String key1 = filePo.getKey1();
//			System.out.println("开始上传...fileName." + fileName);
//			b = qiniuApi.commonUpLoad(buf, key1);
//		}
//
//		System.out.println("七牛上传完成....");
//		if (b) {
//			return new CommonResponse("上传成功");
//		} else {
//			return new CommonResponse("上传失败");
//		}
//	}
//
//	/**
//	 * 覆盖上传
//	 */
//	@RequestMapping(value = "/coverUpLoad", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
//	@ResponseBody
//	public CommonResponse coverUpLoad(@RequestBody QiniuInfoPo qiniuInfoPo) throws IOException {
//		boolean b = false;
//		try {
//			List<FilePo> fileList = qiniuInfoPo.getFileList();
//			for (int i = 0; i < fileList.size(); i++) {
//				FilePo filePo = fileList.get(i);
//				String fileName = filePo.getFileName();// 七牛上面的路径
//				byte[] buf = filePo.getFilebyte();// 七牛上面的路径
//				String key1 = filePo.getKey1();// 上传文件的key
//				String key2 = filePo.getKey2();// 被覆盖文件的key
//				// File file = new File(filepath);
//				// byte[] buf = new byte[(int) file.length()];
//				System.out.println("开始上传...fileName." + fileName);
//				b = qiniuApi.coverUpLoad(buf, key1, key2);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new CommonResponse("系统错误");
//		}
//		return new CommonResponse("上传成功");
//
//	}
//
//	/**
//	 * 获取文件列表
//	 */
//	@RequestMapping(value = "/getFileList", method = RequestMethod.GET)
//	@ResponseBody
//	public CommonResponse getFileList() throws IOException {
//		boolean b = false;
//		List<FileInfo[]> list = qiniuApi.getAllFile();
//		return new CommonResponse(list);
//	}
//
//	/**
//	 * 获取文件属性
//	 */
//	@RequestMapping(value = "/getFileInfoByKey", method = RequestMethod.GET)
//	@ResponseBody
//	public CommonResponse getFileInfoByKey(String key) throws IOException {
//		boolean b = false;
//		FileInfo fileInfo = qiniuApi.getFileInfoByKey(key);
//		return new CommonResponse(fileInfo);
//	}
//
//	/**
//	 * 获取文件属性
//	 */
//	@RequestMapping(value = "/copyFile", method = RequestMethod.GET)
//	@ResponseBody
//	public CommonResponse copyFile(String key, String targetKey) throws IOException {
//		boolean b = false;
//		b = qiniuApi.copyFile(key, targetKey);
//		if (b) {
//			return new CommonResponse("操作成功");
//		} else {
//			return new CommonResponse("操作失败");
//		}
//
//	}
//
//	/**
//	 * 移动文件（同一bucket下无意义）
//	 */
//	@RequestMapping(value = "/moveFile", method = RequestMethod.GET)
//	@ResponseBody
//	public CommonResponse moveFile(String key1, String kye2) throws IOException {
//		boolean b = false;
//		b = qiniuApi.moveFile(key1, kye2);
//		if (b) {
//			return new CommonResponse("操作成功");
//		} else {
//			return new CommonResponse("操作失败");
//		}
//
//	}
//
//	/**
//	 * 修改文件key值(文件重命名)
//	 */
//	@RequestMapping(value = "/renameFile", method = RequestMethod.GET)
//	@ResponseBody
//	public CommonResponse renameFile(String key1, String kye2) throws IOException {
//		boolean b = false;
//		b = qiniuApi.renameFile(key1, kye2);
//		if (b) {
//			return new CommonResponse("操作成功");
//		} else {
//			return new CommonResponse("操作失败");
//		}
//
//	}
//
//	/**
//	 * 删除文件
//	 */
//	@RequestMapping(value = "/deleteFile", method = RequestMethod.GET)
//	@ResponseBody
//	public CommonResponse deleteFile(String key) throws IOException {
//		boolean b = false;
//		b = qiniuApi.deleteFile(key);
//		if (b) {
//			return new CommonResponse("操作成功");
//		} else {
//			return new CommonResponse("操作失败");
//		}
//
//	}
//
//	/**
//	 * @desc 查询物流信息
//	 * @desc logistics_mode: 物流公司拼音简称 logistics_num： 运单号
//	 */
//	@RequestMapping(value = "/getWuLiuInfo", method = RequestMethod.GET)
//	@ResponseBody
//	public static CommonResponse getWuLiuInfo(String logistics_mode, String logistics_num) throws IOException {
//     /*
//		String res = new ShowApiRequest(PlatformConstant.WULIU_API_URL, "3524", "0acee59bb34a44e28abe2a3797ea27f9")
//				.addTextPara("com", logistics_mode).addTextPara("nu", logistics_num).post();
//
//		return new CommonResponse(res);
//		*/
//		return null;
//
//	}
//	
//	/**
//	 * @desc 查询历史上的今天
//	 * @desc syear: 年  ymounth： 月  sday 日
//	 */
//	@RequestMapping(value = "/callHistoryToday", method = RequestMethod.GET)
//	@ResponseBody
//	public static CommonResponse callHistoryToday(String syear, String ymounth,String sday) throws IOException {
//		String date=ymounth+sday;
//		//String res=ShowApiComm.callShowApi().addTextPara("date",date).post();	
//		String res="";
//		
//		return new CommonResponse(res);	
//	}

}
