package org.taru.producttracing.vo;

import java.io.Serializable;

public class JsonResult implements Serializable{
	private String status;
	private String message;
	private Object data;
	
	public JsonResult(String status, String message, Object data){
		this.status=status;
		this.message=message;
		this.data=data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
