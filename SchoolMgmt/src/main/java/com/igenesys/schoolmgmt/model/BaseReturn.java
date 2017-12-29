package com.igenesys.schoolmgmt.model;

import java.util.List;

public class BaseReturn {
	  private String message;
	  private int messageCode;
	  private List<Object> list;
	public BaseReturn(String message, int messageCode) {
		
		this.message = message;
		this.messageCode = messageCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(int messageCode) {
		this.messageCode = messageCode;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public BaseReturn(String message, int messageCode, List<Object> list) {
		
		this.message = message;
		this.messageCode = messageCode;
		this.list = list;
	}
	 public String toString()
	  {
	    return String.format("messageCode='%d', message='%s'", new Object[] {
	      Integer.valueOf(this.messageCode), this.message });
	  }  
	  

}
