package com.calculator.responce;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/*@EntityScan*/
public class ResponceEntity {

	public int result;
	
	public String details;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ResponceEntity(int result, String details) {
		super();
		this.result = result;
		this.details = details;
	}

	

	public ResponceEntity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ResponceEntity [result=" + result + ", details=" + details + "]";
	}
	
	
}
