package com.windframework.shiro.demo.controller.finance;

import java.io.File;
import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.windframework.shiro.demo.base.response.ResponseInfo;
import com.windframework.shiro.demo.util.ExcelReadUtil;

@Controller
public class FinanceSalaryController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping(value = "/finance/salary")
	public String page() {
		return "finance/finance_salary";
	}

	@PostMapping(value = "/finance/salary/calcBatchUpload")
	@ResponseBody
	public ResponseEntity<String> calcBatchUpload(@RequestParam(value = "filePath") String filePath, HttpServletRequest request,
			HttpServletResponse response) {
		Workbook workbook = null;
		InputStream fileInputStream = null;
		Map<String, String> stateMap = new HashMap<String, String>();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		filePath = filePath == null ? "" : filePath;
		String ctxPath = request.getSession().getServletContext().getRealPath("/") + filePath;	//获取全路径
		Calendar cn = Calendar.getInstance();
		String userName = request.getSession(true).getAttribute("userName").toString();
		
		System.out.println(ctxPath);
		try {
			ResponseInfo responseInfo = new ResponseInfo();
			fileInputStream = ExcelReadUtil.createReadableExcelFile(ctxPath, responseInfo);
			//如果文件不存在
			if (null == fileInputStream) {
				stateMap.put("STATE", "error");
				stateMap.put("errorMsg", "文件不存在");
				return new ResponseEntity<String>(JSONObject.toJSONString(stateMap), responseHeaders, HttpStatus.CREATED);
			}
			if (ctxPath.endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(fileInputStream);
			} else if (ctxPath.endsWith(".xls")) {
				workbook = new HSSFWorkbook(fileInputStream);
			} else {
				stateMap.put("STATE", "error");
				stateMap.put("errorMsg", "请上传.xls或.xlsx类型的文件。");
				return new ResponseEntity<String>(JSONObject.toJSONString(stateMap), responseHeaders, HttpStatus.CREATED);
			}
			// 列名和列index对应表
			Map<String, Integer> indexMap = ExcelReadUtil.getTitleMap();
			responseHeaders.add("Content-Type", "text/html; charset=utf-8");
			filePath = filePath == null ? "" : filePath;
			//如果格式不正确
			if (!ExcelReadUtil.excelFormatValid2007(ctxPath, responseInfo)) {
				stateMap.put("STATE", "error");
				stateMap.put("errorMsg", "表头数据错误，请重新下载模板，正确填写数据后再上传。");
				return new ResponseEntity<String>(JSONObject.toJSONString(stateMap), responseHeaders, HttpStatus.CREATED);
			}
			int successCount = 0;
			int errorCount = 0;
			// 使用第一张工作表
			Sheet sheet = workbook.getSheetAt(0);
			//创建一个可写入的excel文件对象
			File file = new File(ctxPath);
			if (!file.exists()) {
				stateMap.put("STATE", "error");
				stateMap.put("errorMsg", "传输失败，请重试。如果问题再次发生请联系管理员。");
				return new ResponseEntity<String>(JSONObject.toJSONString(stateMap).toString(), responseHeaders, HttpStatus.CREATED);
			}
			Set<String> orderSkuSet = new HashSet<String>();
		} catch (Exception e) {
			logger.error("导入出错", e);
		}
		return null;
	}
}
