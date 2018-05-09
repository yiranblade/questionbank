		package com.questionbank.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.questionbank.dto.DownloadRecord;
import com.questionbank.util.ResultInfo;

@RestController
public class DownloadController extends BaseController{

	@RequestMapping(value="/download",method=RequestMethod.POST)
	public ResultInfo download(@RequestParam("fileName")String fileName,@RequestParam("filePath") String filePath) 
			throws Exception {
				ResultInfo resultInfo=new ResultInfo();
			    //声明本次下载状态的记录对象
			    DownloadRecord downloadRecord = new DownloadRecord(fileName, filePath, request);
			    //设置响应头和客户端保存文件名
			    response.setCharacterEncoding("utf-8");
			    response.setContentType("multipart/form-data");
			    response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
			    //用于记录以完成的下载的数据量，单位是byte
			    long downloadedLength = 0l;
			    try {
			        //打开本地文件流
			        InputStream inputStream = new FileInputStream(filePath);
			        //激活下载操作
			        OutputStream os = response.getOutputStream();

			        //循环写入输出流
			        byte[] b = new byte[2048];
			        int length;
			        while ((length = inputStream.read(b)) > 0) {
			            os.write(b, 0, length);
			            downloadedLength += b.length;
			        }

			        // 这里主要关闭。
			        os.close();
			        inputStream.close();
			    } catch (Exception e){
			        downloadRecord.setStatus(DownloadRecord.STATUS_ERROR);
			        throw e;
			    }
			    downloadRecord.setStatus(DownloadRecord.STATUS_SUCCESS);
			    downloadRecord.setEndTime(new Timestamp(System.currentTimeMillis()));
			    downloadRecord.setLength(downloadedLength);
			    //存储记录
			    resultInfo.setCode(200);
			    resultInfo.setData(downloadRecord);
			    return resultInfo;
			}
}
