package com.calculator.request;

public class SquareRootRequest {

	public int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "SquareRootRequest [number=" + number + "]";
	}

	public SquareRootRequest(int number) {
		super();
		this.number = number;
	}

	public SquareRootRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
