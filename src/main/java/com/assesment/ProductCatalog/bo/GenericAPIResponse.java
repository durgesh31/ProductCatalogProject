package com.assesment.ProductCatalog.bo;

public class GenericAPIResponse {
	
	private String status;
	
	private String message;

	public GenericAPIResponse(String status,String message) {
		this.status= status;
		this.message= message;
	}

	public GenericAPIResponse() {
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
	
	

}
