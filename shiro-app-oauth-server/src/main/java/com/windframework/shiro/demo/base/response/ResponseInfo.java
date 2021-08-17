package com.windframework.shiro.demo.base.response;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法执行后返回给页面的信息
 * @author Administrator
 *
 */
public class ResponseInfo {
	//失败内容
	public final static String FAIL = "FAIL";
	//成功内容
	public final static String SUCCESS = "SUCCESS";
	
	public ResponseInfo(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public ResponseInfo() {
		super();
	}

	/**
	 * 默认反馈信息
	 * @return
	 */
	public final static ResponseInfo success() {
		ResponseInfo responseInfo = new ResponseInfo();
		responseInfo.setStatus(SveResult.SUCCESS);
		responseInfo.setRecordMsg("请求提交成功");//反馈出库信息给用户
		return responseInfo;
	}
	
	/**
	 * 自定义反馈信息
	 * @param msg
	 * @return
	 */
	public final static ResponseInfo success(String msg) {
		ResponseInfo responseInfo = success();
		responseInfo.setRecordMsg(msg);//反馈出库信息给用户
		return responseInfo;
	}
	
	public final static ResponseInfo fail(String errorMsg) {
		ResponseInfo responseInfo = new ResponseInfo();
		responseInfo.setStatus(SveResult.FAIL);
		responseInfo.setErrorMsg(errorMsg);//反馈出库信息给用户
		return responseInfo;
	}
	
	private Integer code;
	
	private String msg;

	/**
	 * 状态 success
	 */
	private SveResult status;
	
	/**
	 * 信息记录
	 */
	private String recordMsg;
	
	/**
	 * 错误信息
	 */
	private String errorMsg;
	
	/**
	 * 提示信息
	 */
	private String tip;
	
	/**
	 * 总数
	 */
	private int totalCount;
	
	/**
	 * 成功数
	 */
	private int successCount;
	
	/**
	 * 出错数
	 */
	private int errorCount;
	
	/**
	 * 用于返回下一步需要用到的参数,比如:要查询某一订单的id
	 */
	private Map<String, Object> result = new HashMap<String, Object>();
	
	

	public SveResult getStatus() {
		return status;
	}
	
	public String getStatusMsg() {
		return status.getMsg();
	}

	public void setStatus(SveResult status) {
		this.status = status;
	}

	public String getRecordMsg() {
		return recordMsg;
	}

	public void setRecordMsg(String recordMsg) {
		this.recordMsg = recordMsg;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	public int getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	/**
	 * 该方法是批量上传时用于反馈给用户,让用户知道导入是否完全成功的
	 * @param successCount
	 * @param errorCount
	 */
	public void setTip(int successCount, int errorCount) {
		if(0 >= successCount) {
			this.tip = "导入全部失败!";
		} else if(successCount > 0 && errorCount > 0) {
			this.tip = "导入存在失败,请查看失败记录!";
		} else {
			this.tip = "导入成功!";
		}
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
