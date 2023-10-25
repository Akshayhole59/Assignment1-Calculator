package com.calculator.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;


import com.calculator.responce.ResponceEntity;

@Service
public class ProductService {

	public ResponceEntity getAdditionOfTwoNumbers(int number1, int number2) {
		ResponceEntity responce = new ResponceEntity();
		try {
			int result = number1+number2;
			String detail=number1+"+"+number2+"="+result;	
			responce.setResult(result);
			responce.setDetails(detail);
			
			
		}catch(Exception e) {
			System.out.println("exception in getAdditionOfTwoNumbers()");
		}
		return responce;
	}

	
	public ResponceEntity getSubstractionOfTwoNumbers(int number1, int number2) {
		ResponceEntity responce = new ResponceEntity();
		try {
			
			int result = number1-number2;
			String detail=number1+"-"+number2+"="+result;
			responce.setResult(result);
			responce.setDetails(detail);
			
		}catch(Exception e) {
			System.out.println("exception in getSubstractionOfTwoNumbers()");
		}
		return responce;
	}


	public ResponceEntity getDivisionOfTwoNumbers(int number1, int number2) {
		ResponceEntity responce = new ResponceEntity();
		try {
			
			int result = number1/number2;
			String detail=number1+"/"+number2+"="+result;
			responce.setResult(result);
			responce.setDetails(detail);
			
		}catch(Exception e) {
			System.out.println("exception in getDivisionOfTwoNumbers()");
		}
		return responce;
	}


	public ResponceEntity getMultiplicationOfTwoNumbers(int number1, int number2) {
		ResponceEntity responce = new ResponceEntity();
		try {
			
			int result = number1*number2;
			String detail=number1+"*"+number2+"="+result;
			responce.setResult(result);
			responce.setDetails(detail);
			
		}catch(Exception e) {
			System.out.println("exception in getMultiplicationOfTwoNumbers()");
		}
		return responce;
	}


	public ResponceEntity getSquareOfNumber(int number1) {
		ResponceEntity responce = new ResponceEntity();
		try {
			
			int result = number1*number1;
			String detail="Square of "+number1+"="+result;
			responce.setResult(result);
			responce.setDetails(detail);
			
		}catch(Exception e) {
			System.out.println("exception in getSquareRootOfNumber()");
		}
		return responce;
	}


	
	public ResponceEntity getSquareRootOfNumber(int number1) {
		ResponceEntity responce = new ResponceEntity();
		try {
			
			double result = Math.pow(number1,0.5);
			Integer intResult = (int) result;
			String detail="Squareroot of "+number1+"is"+intResult;
			responce.setResult(intResult);
			responce.setDetails(detail);
			
		}catch(Exception e) {
			System.out.println("exception in getSquareRootOfNumber()");
		}
		return responce;
	}


	public ResponceEntity getFactorialOfNumber(int number1) {
		ResponceEntity responce = new ResponceEntity();
		try {
			
			int result = 1, i;
	        for (i = 2; i <= number1; i++)
	        {
	        	result *= i;
	        }
	        String detail="Factorial of "+number1+"! is "+result;
	        responce.setResult(result);
	        responce.setDetails(detail);
			
		}catch(Exception e) {
			System.out.println("exception in getSquareRootOfNumber()");
		}
		return responce;
	}


	public ResponceEntity getMinMaxOfNumber(List<Integer> numbers) {
		ResponceEntity responce = new ResponceEntity();
		int minValue=0;
		int maxValue=0;
		try {
	
			
			if (numbers == null || numbers.size() == 0) { 
	          throw new Exception("arraylist is null");
	        }
			
			 minValue = Collections.min(numbers);
			 maxValue = Collections.max(numbers);
			 String detail="Min value is "+minValue+" & max Value is "+maxValue;
			 responce.setDetails(detail);

			
		}catch(Exception e) {
			System.out.println("exception in getSquareRootOfNumber()");
		}
		return responce;
	}


	public java.util.Map<String, String> getMinMaxOfNumbers(List<Integer> numbers) {
	
		int minValue=0;
		int maxValue=0;
		String detail = null;
		try {
	
			
			if (numbers == null || numbers.size() == 0) { 
	          throw new Exception("arraylist is null");
	        }
			 List<Integer> sortedlist = new ArrayList<>(numbers);
			 minValue = Collections.min(numbers);
			 maxValue = Collections.max(numbers);
			 detail="Min value is "+minValue+" & max Value is "+maxValue;
			
	
		}catch(Exception e) {
			System.out.println("exception in getSquareRootOfNumber()");
		}
		
		return  java.util.Map.of("details",detail);
	}

}
