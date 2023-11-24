package com.calculator.request;

public class SquareRequest {
	
	public int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "SquareRequest [number=" + number + "]";
	}

	public SquareRequest(int number) {
		super();
		this.number = number;
	}

	public SquareRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
