package com.calculator.responce;

public class MinMaxResponce {
	
	private int minValue;
	
	private int maxValue;

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	@Override
	public String toString() {
		return "MinMaxResponce [minValue=" + minValue + ", maxValue=" + maxValue + "]";
	}

	public MinMaxResponce(int minValue, int maxValue) {
		super();
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	public MinMaxResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
