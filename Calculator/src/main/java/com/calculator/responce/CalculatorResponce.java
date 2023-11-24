package com.calculator.responce;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculatorResponce implements Serializable {
	
	private static final long serialVersionUID = -4439114469417994311L;
	
	@JsonProperty
	private int id;
	
	@JsonProperty
	private int number1;
	
	@JsonProperty
	private int number2;
	
	
	@JsonProperty
	private String flowName;
	
	@JsonProperty
	private String responce;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getResponce() {
		return responce;
	}

	public void setResponce(String responce) {
		this.responce = responce;
	}

	@Override
	public String toString() {
		return "CalculatorResponce [id=" + id + ", number1=" + number1 + ", number2=" + number2 + ", flowName=" + flowName + ", responce=" + responce + "]";
	}

	public CalculatorResponce(int id, int number1, int number2, Timestamp creationOn, String flowName,
			String responce) {
		super();
		this.id = id;
		this.number1 = number1;
		this.number2 = number2;
		this.flowName = flowName;
		this.responce = responce;
	}

	public CalculatorResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
