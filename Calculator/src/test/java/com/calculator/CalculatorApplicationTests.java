package com.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    	ResponceEntity expectedResult=new ResponceEntity(23,"12+11=23");
		ResponceEntity actualResult =  productService.getAdditionOfTwoNumbers(12, 11);
		String actual = actualResult.toString();
		String expected = expectedResult.toString();
		assertThat(actual).isEqualTo(expected);
	}
    
    @Test
   	public void doSubstractionTest() {
       	ResponceEntity expectedResult=new ResponceEntity(1,"12-11=1");
   		ResponceEntity actualResult =  productService.getSubstractionOfTwoNumbers(12, 11);
   		String actual = actualResult.toString();
   		String expected = expectedResult.toString();
   		assertThat(actual).isEqualTo(expected);
   	}
    
    @Test
   	public void doMultiplicationTest() {
       	ResponceEntity expectedResult=new ResponceEntity(6,"2*3=6");
   		ResponceEntity actualResult =  productService.getMultiplicationOfTwoNumbers(2, 3);
   		String actual = actualResult.toString();
   		String expected = expectedResult.toString();
   		assertThat(actual).isEqualTo(expected);
   	}
    
    @Test
   	public void doDivisionTest() {
       	ResponceEntity expectedResult=new ResponceEntity(2,"6/3=2");
   		ResponceEntity actualResult =  productService.getDivisionOfTwoNumbers(6, 3);
   		String actual = actualResult.toString();
   		String expected = expectedResult.toString();
   		assertThat(actual).isEqualTo(expected);
   	}
    
    @Test
   	public void doSquareTest() {
       	ResponceEntity expectedResult=new ResponceEntity(25,"Square of 5=25");
   		ResponceEntity actualResult =  productService.getSquareOfNumber(5);
   		String actual = actualResult.toString();
   		String expected = expectedResult.toString();
   		assertThat(actual).isEqualTo(expected);
   	}
    
    @Test
   	public void doSquareRootTest() {
       	ResponceEntity expectedResult=new ResponceEntity(5,"Squareroot of 25is5");
   		ResponceEntity actualResult =  productService.getSquareRootOfNumber(25);
   		String actual = actualResult.toString();
   		String expected = expectedResult.toString();
   		assertThat(actual).isEqualTo(expected);
   	}
    
    @Test
   	public void doFactorialTest() {
       	ResponceEntity expectedResult=new ResponceEntity(120,"Factorial of 5! is 120");
   		ResponceEntity actualResult =  productService.getFactorialOfNumber(5);
   		String actual = actualResult.toString();
   		String expected = expectedResult.toString();
   		assertThat(actual).isEqualTo(expected);
   	}
    
    
    @Test
   	public void doMinMaxTest() {
    	int[] array = new int[]{10,5,-5,6,82,66,-91};
    	ArrayList<Integer> list = IntStream.of(array)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
		  Map<String,String> actualResult = productService.getMinMaxOfNumbers(list);
		  Map<String,String>  expected = new HashMap<>();  
		  expected.put("details", "Min value is -91 & max Value is 82");
		  Map<String,String> map = new HashMap<>();
		  assertThat(actualResult).isEqualTo(expected);
	
   	}
    
    
}
