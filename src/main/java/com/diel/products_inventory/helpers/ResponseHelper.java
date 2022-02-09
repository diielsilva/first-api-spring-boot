package com.diel.products_inventory.helpers;

import java.util.List;

public class ResponseHelper {
	private Integer status;
	private String message;
	private List<?> result;

	public ResponseHelper(Integer status, String message, List<?> result) {
		super();
		this.status = status;
		this.message = message;
		this.result = result;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<?> result) {
		this.result = result;
	}

}
