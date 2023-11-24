package com.calculator.request;

public class MultiplicationRequest {
	public Integer number1;

	public Integer number2;

	public Integer getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public Integer getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	@Override
	public String toString() {
		return "MultiplicationRequest [number1=" + number1 + ", number2=" + number2 + "]";
	}

	public MultiplicationRequest(Integer number1, Integer number2) {
		super();
		this.number1 = number1;
		this.number2 = number2;
	}

	public MultiplicationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
