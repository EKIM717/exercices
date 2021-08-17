package com.windframework.shiro.demo.controller.main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/main")
public class CommonUploadController {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

	@RequestMapping(value = "uploadFile")
	@ResponseBody
//	public ResponseEntity<String> upLoadFile(MultipartHttpServletRequest multipartRequest, @RequestPart("upload-file")MultipartFile[] multipartFileArray) {
	public ResponseEntity<String> upLoadFile(MultipartHttpServletRequest multipartRequest) {
		Map<String, Object> stateMap = null;
		stateMap = new HashMap<String, Object>();
		List<String> filePathList = new ArrayList<>();
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			MultiValueMap<String, MultipartFile> multipartFiles = multipartRequest.getMultiFileMap();
			List<MultipartFile> multipartFileArray = multipartFiles.get("upload-file");
			String fileToUploadId = multipartRequest.getParameter("fileToUploadId");// 前台上传控件name
			if (null == fileToUploadId || "".equals(fileToUploadId)) {
				fileToUploadId = "fileToUpload";
			}
			for (MultipartFile file : multipartFileArray) {


				String realFileName = "";
				String fileDir = multipartRequest.getParameter("fileDir");

				fileDir = fileDir == null ? "temp" : fileDir;

				responseHeaders.add("Content-Type", "text/html; charset=utf-8");
//				MultipartFile file = multipartRequest.getFile(fileToUploadId); // 根据前台的name名称得到上传的文件
				realFileName = file.getOriginalFilename().trim(); // 相同名字
				realFileName = realFileName.replace(" ", ""); // 去除空格
				String ext = realFileName.trim().substring(realFileName.lastIndexOf("."));
				String fn = realFileName.trim().substring(0, realFileName.lastIndexOf("."));
				if (file == null || file.getSize() == 0) {
					stateMap.put("STATE", "empty");
					return new ResponseEntity<String>(JSONObject.toJSONString(stateMap).toString(), responseHeaders,
							HttpStatus.CREATED);
				}

				realFileName = fn + "_" + sdf.format(new Date()) + ext;
				// 取得服务器真实路径
				String ctxPath = multipartRequest.getSession().getServletContext().getRealPath("/") + "\\uploadFile\\"
						+ fileDir + "\\"; // 获取全路径
				// 创建文件
				File dirPath = new File(ctxPath);
				if (!dirPath.exists()) {
					dirPath.mkdirs();
				}

				File uploadFile = new File(ctxPath + realFileName);
				try {
					FileCopyUtils.copy(file.getBytes(), uploadFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
				filePathList.add("//uploadFile//" + fileDir + "//" + realFileName);
				stateMap.put("FILEPATH", filePathList);
				stateMap.put("STATE", "success");
			}
			return new ResponseEntity<String>(JSONObject.toJSONString(stateMap).toString(), responseHeaders,
					HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			stateMap.put("STATE", "error");
			return new ResponseEntity<String>(JSONObject.toJSONString(stateMap).toString(), responseHeaders,
					HttpStatus.CREATED);
		}
	}

	public String getExtName(String fileDir) {
		if (null == fileDir || "".equals(fileDir)) {
			return "";
		}
		String prefix = fileDir.substring(fileDir.lastIndexOf(".") + 1);
		return prefix;
	}

}
