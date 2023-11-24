package com.calculator.request;

public class FactorialRequest {
	public int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public FactorialRequest(int number) {
		super();
		this.number = number;
	}

	public FactorialRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FactorialRequest [number=" + number + "]";
	}
	
}
