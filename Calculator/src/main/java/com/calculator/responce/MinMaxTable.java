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
public class MinMaxTable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int id;
	
	@Column(name="MinNumber")
	public int MinNumber;
	
	@Column(name="MaxNumber")
	public int MaxNumber;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;


	public int getMinNumber() {
		return MinNumber;
	}


	public void setMinNumber(int minNumber) {
		MinNumber = minNumber;
	}


	public int getMaxNumber() {
		return MaxNumber;
	}


	public void setMaxNumber(int maxNumber) {
		MaxNumber = maxNumber;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	@Override
	public String toString() {
		return "MinMaxTable [id=" + id + ", MinNumber=" + MinNumber + ", MaxNumber=" + MaxNumber + ", createDate="
				+ createDate + "]";
	}


	public MinMaxTable(int minNumber, int maxNumber, Date createDate) {
		super();
		MinNumber = minNumber;
		MaxNumber = maxNumber;
		this.createDate = createDate;
	}


	public MinMaxTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
