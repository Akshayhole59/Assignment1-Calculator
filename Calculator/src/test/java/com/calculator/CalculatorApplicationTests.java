package com.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.calculator.request.AdditionRequest;
import com.calculator.request.DivisionRequest;
import com.calculator.request.FactorialRequest;
import com.calculator.request.MinMaxRequest;
import com.calculator.request.MultiplicationRequest;
import com.calculator.request.SquareRequest;
import com.calculator.request.SquareRootRequest;
import com.calculator.request.SubstractionRequest;
import com.calculator.responce.MinMaxResponce;
import com.calculator.responce.ResponceEntity;
import com.calculator.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CalculatorApplicationTests {
	
	@Autowired
	ProductService productService;
	
	

	/*
	 * @Test void contextLoads() { }
	 */

	@Test
	public void doAdditionTest() {
		ResponceEntity expectedResult = new ResponceEntity(2, "1+1=2");
		AdditionRequest requestentity = new AdditionRequest();
		requestentity.setNumber1(1);
		requestentity.setNumber2(1);
		ResponceEntity actualResult = productService.getAdditionOfTwoNumbers(requestentity);
		String actual = actualResult.toString();
		String expected = expectedResult.toString();
		assertThat(actual).isEqualTo(expected);
	}
	 
    
    @Test
   	public void doSubstractionTest() {
       	ResponceEntity expectedResult=new ResponceEntity(1,"12-11=1");
       	SubstractionRequest requestentity=new SubstractionRequest();
    	requestentity.setNumber1(12);
    	requestentity.setNumber2(11);
   		ResponceEntity actualResult =  productService.getSubstractionOfTwoNumbers(requestentity);
   		String actual = actualResult.toString();
   		String expected = expectedResult.toString();
   		assertThat(actual).isEqualTo(expected);
   	}
    
    @Test
   	public void doMultiplicationTest() {
       	ResponceEntity expectedResult=new ResponceEntity(6,"2*3=6");
    	MultiplicationRequest requestentity=new MultiplicationRequest();
    	requestentity.setNumber1(2);
    	requestentity.setNumber2(3);
   		ResponceEntity actualResult =  productService.getMultiplicationOfTwoNumbers(requestentity);
   		String actual = actualResult.toString();
   		String expected = expectedResult.toString();
   		assertThat(actual).isEqualTo(expected);
   	}
    
    @Test
   	public void doDivisionTest() {
       	ResponceEntity expectedResult=new ResponceEntity(2,"6/3=2");
       	DivisionRequest requestentity=new DivisionRequest();
    	requestentity.setNumber1(6);
    	requestentity.setNumber2(3);
   		ResponceEntity actualResult =  productService.getDivisionOfTwoNumbers(requestentity);
   		String actual = actualResult.toString();
   		String expected = expectedResult.toString();
   		assertThat(actual).isEqualTo(expected);
   	}
    
    @Test
   	public void doSquareTest() {
       	ResponceEntity expectedResult=new ResponceEntity(25,"Square Of Number5=25");
       	SquareRequest requestentity=new SquareRequest();
    	requestentity.setNumber(5);
   		ResponceEntity actualResult =  productService.getSquareOfNumber(requestentity);
   		String actual = actualResult.toString();
   		String expected = expectedResult.toString();
   		assertThat(actual).isEqualTo(expected);
   	}
    
    @Test
   	public void doSquareRootTest() {
       	ResponceEntity expectedResult=new ResponceEntity(5,"SquareRoot Of Number 25=5");
    	SquareRootRequest requestentity=new SquareRootRequest();
    	requestentity.setNumber(25);
   		ResponceEntity actualResult =  productService.getSquareRootOfNumber(requestentity);
   		String actual = actualResult.toString();
   		String expected = expectedResult.toString();
   		assertThat(actual).isEqualTo(expected);
   	}
    
    @Test
   	public void doFactorialTest() {
       	ResponceEntity expectedResult=new ResponceEntity(120,"Factorials of 5! is 120");
       	FactorialRequest requestentity=new FactorialRequest();
    	requestentity.setNumber(5);
   		ResponceEntity actualResult =  productService.getFactorialOfNumber(requestentity);
   		String actual = actualResult.toString();
   		String expected = expectedResult.toString();
   		assertThat(actual).isEqualTo(expected);
   	}
    
    
    @Test
   	public void doMinMaxTest() {
    	int[] array = new int[]{10,5,-5,6,82,66,-91};
    	MinMaxRequest requestentity = new MinMaxRequest();
    	MinMaxResponce expectedResult = new MinMaxResponce(-91,82);
    	
    	ArrayList<Integer> list = IntStream.of(array)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    	requestentity.setNumbers(list);
		  MinMaxResponce actualResult = productService.getMinMaxOfNumbers(requestentity);
		
		  String actual = actualResult.toString();
	   		String expected = expectedResult.toString();
		  assertThat(actual).isEqualTo(expected);
	
   	}
    
    
}
