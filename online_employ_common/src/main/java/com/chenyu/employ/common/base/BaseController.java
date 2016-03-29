package com.chenyu.employ.common.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.chenyu.employ.common.error.ErrorType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseController {
	public static final Logger logger=LoggerFactory.getLogger(BaseController.class);
	
	protected final Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();

	protected String jsonSuccess() {
		return this.jsonSuccess(null);
	}

	protected <T> String jsonSuccess(T data) {
		return this.jsonSuccess(data, "ok");
	}

	protected <T> String jsonSuccess(T data, String message) {
		return this.renderJson(200, message, data);
	}

	protected <T> String jsonFailed(int code, String message) {
		return this.renderJson(code, message, null);
	}

	protected <T> String jsonFailed(ErrorType errorType) {
		return this.renderJson(errorType.getValue(), errorType.getTitle(), null);
	}

	private <T> String renderJson(int code, String message, T data) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		Map<String, Object> stateMap = new HashMap<String, Object>();
		stateMap.put("code", code);
		stateMap.put("msg", StringUtils.isBlank(message) ? "Ok" : message);
		jsonMap.put("state", stateMap);
		jsonMap.put("data", data);
		return gson.toJson(jsonMap);
	}

	/**
	 * form validation 组件数据验证格式
	 * 
	 * @return
	 */
	protected String validateSuccess() {
		return "{ \"valid\": true }";
	}

	/**
	 * form validation 组件数据验证格式
	 * 
	 * @return
	 */
	protected String validateFailed() {
		return "{ \"valid\": false }";
	}

	/**
	 * 设置表单日期属性转换器
	 * 
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
}
