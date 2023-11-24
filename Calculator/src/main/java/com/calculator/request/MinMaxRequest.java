package com.calculator.request;

import java.util.List;



public class MinMaxRequest {
	
	public List<Integer> numbers;

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return "MinMaxRequest [numbers=" + numbers + "]";
	}

	public MinMaxRequest(List<Integer> numbers) {
		super();
		this.numbers = numbers;
	}

	public MinMaxRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
