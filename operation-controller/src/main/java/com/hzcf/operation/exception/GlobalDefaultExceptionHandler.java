package com.hzcf.operation.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzcf.operation.base.exception.CustomException;
import com.hzcf.operation.base.result.ResponseCode;
import com.hzcf.operation.base.result.Result;


/**
 * Create by hanlin on 2017年12月4日
 **/
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result<String> defaultErrorHandler(HttpServletRequest req, Exception e) {
		Result<String> ret =  new Result<String>();
        ResponseCode code = ResponseCode.RESULT_SYSTEM_ERROR;
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
        	//404
        	code = ResponseCode.RESOURCE_NOT_FOUND;
        }else if (e instanceof org.springframework.http.converter.HttpMessageNotReadableException) {
        	//400
        	code = ResponseCode.ERROR_PARAM;
        }
    	CustomException customException = new CustomException(e,code,e.getMessage());
    	ret.setCode(code.code());
        ret.setCodeText(code.text());
        ret.setData(customException.getMessage());
        ret.setMessage(code.text());
        return ret;
	}
	@ExceptionHandler(value = CustomException.class)
	@ResponseBody
	public Result<String> defaultErrorHandler(HttpServletRequest req, CustomException e) {
		Result<String> ret =  new Result<String>();
        ret.setCode(e.getCode().code());
        ret.setCodeText(e.getCode().text());
        ret.setData(e.getMessage());
        ret.setMessage(e.getLocalizedMessage());
        return ret;
	}
}
