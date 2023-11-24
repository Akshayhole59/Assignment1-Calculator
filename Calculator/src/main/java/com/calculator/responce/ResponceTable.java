package com.calculator.responce;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table
public class ResponceTable {
	

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int id;
	
	@Column(name="Number_1")
	public int number1;
	
	@Column(name="Number_2")
	public int number2;
	
	@Column(name="Flow_Name")
	public String flowName;
	
	/*
	 * @Column(name="Responce") public String responce;
	 * 
	 */
	@Column(name = "Result")
	public int result;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}


	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
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

	@Override
	public String toString() {
		return "ResponceTable [id=" + id + ", number1=" + number1 + ", number2=" + number2 + ", flowName=" + flowName
				+ ", result=" + result + ", createDate=" + createDate + "]";
	}

	public ResponceTable(int id, int number1, int number2, String flowName, int result, Date createDate) {
		super();
		this.id = id;
		this.number1 = number1;
		this.number2 = number2;
		this.flowName = flowName;
		this.result = result;
		this.createDate = createDate;
	}


	public ResponceTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	

}
