package com.calculator.responce;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("ResponceEntity")
public class ResponceEntity implements Serializable {

	private static final long serialVersionUID = -4439114469417994311L;

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
