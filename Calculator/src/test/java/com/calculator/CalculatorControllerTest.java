package com.calculator;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.calculator.controller.TestController;
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
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=TestController.class)
@AutoConfigureMockMvc(addFilters = false)
public class CalculatorControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	ProductService productService;
	
	@Autowired
	private ObjectMapper objMapper;
	
	
	@Test
	public void testAddition() throws Exception {
		try {
			ResponceEntity expectedResult = new ResponceEntity(23, "12+11=23");
			AdditionRequest requestentity = new AdditionRequest();
			requestentity.setNumber1(12);
			requestentity.setNumber2(11);
			String json = objMapper.writeValueAsString(expectedResult);

			when(productService.getAdditionOfTwoNumbers(requestentity)).thenReturn(expectedResult);

			mockmvc.perform(post("/v1/addition").contentType(MediaType.APPLICATION_JSON).content(json)
					.characterEncoding("utf-8")).andExpect(status().isOk()).andReturn();

		} catch (Exception e) {
			e.printStackTrace();
		}

	  }
	 
	
	 @Test
	   	public void testSubstraction() throws Exception{
		 try {
	       	ResponceEntity expectedResult=new ResponceEntity(1,"12-11=1");
	       	SubstractionRequest requestentity=new SubstractionRequest();
	    	requestentity.setNumber1(12);
	    	requestentity.setNumber2(11);
	   		
	   		String json = objMapper.writeValueAsString(expectedResult);
			when(productService.getSubstractionOfTwoNumbers(requestentity)).thenReturn(expectedResult);
			mockmvc.perform(post("/v1/subtraction").contentType(MediaType.APPLICATION_JSON).content(json)
					.characterEncoding("utf-8")).andExpect(status().isOk()).andReturn();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	   	}
	    
	    @Test
	   	public void testMultiplication() throws Exception {
	    	try {
	       	ResponceEntity expectedResult=new ResponceEntity(6,"2*3=6");
	    	MultiplicationRequest requestentity=new MultiplicationRequest();
	    	requestentity.setNumber1(2);
	    	requestentity.setNumber2(3);
	    	
	    	String json = objMapper.writeValueAsString(expectedResult);
			when(productService.getMultiplicationOfTwoNumbers(requestentity)).thenReturn(expectedResult);
			mockmvc.perform(post("/v1/multiplication").contentType(MediaType.APPLICATION_JSON).content(json)
					.characterEncoding("utf-8")).andExpect(status().isOk()).andReturn();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	   	}
	    
	    @Test
	   	public void testDivision() throws Exception{
	    	try {
	       	ResponceEntity expectedResult=new ResponceEntity(2,"6/3=2");
	       	DivisionRequest requestentity=new DivisionRequest();
	    	requestentity.setNumber1(6);
	    	requestentity.setNumber2(3);
	   		
	    	String json = objMapper.writeValueAsString(expectedResult);
			when(productService.getDivisionOfTwoNumbers(requestentity)).thenReturn(expectedResult);
			mockmvc.perform(post("/v1/division").contentType(MediaType.APPLICATION_JSON).content(json)
					.characterEncoding("utf-8")).andExpect(status().isOk()).andReturn();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	   	}
	    
	    @Test
	   	public void testSquare() {
	    	try {
	       	ResponceEntity expectedResult=new ResponceEntity(25,"Square of 5=25");
	       	SquareRequest requestentity=new SquareRequest();
	    	requestentity.setNumber(5);
	    	
	    	String json = objMapper.writeValueAsString(expectedResult);
			when(productService.getSquareOfNumber(requestentity)).thenReturn(expectedResult);
			mockmvc.perform(post("/v1/square").contentType(MediaType.APPLICATION_JSON).content(json)
					.characterEncoding("utf-8")).andExpect(status().isOk()).andReturn();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	   	}
	    
	    @Test
	   	public void testSquareRoot() {
	    	try {
	       	ResponceEntity expectedResult=new ResponceEntity(5,"Squareroot of 25is5");
	    	SquareRootRequest requestentity=new SquareRootRequest();
	    	requestentity.setNumber(25);
	    	
	    	String json = objMapper.writeValueAsString(expectedResult);
			when(productService.getSquareRootOfNumber(requestentity)).thenReturn(expectedResult);
			mockmvc.perform(post("/v1/squareroot").contentType(MediaType.APPLICATION_JSON).content(json)
					.characterEncoding("utf-8")).andExpect(status().isOk()).andReturn();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	   	}
	    
	    @Test
	   	public void testFactorial() {
	    	try {
	       	ResponceEntity expectedResult=new ResponceEntity(120,"Factorial of 5! is 120");
	       	FactorialRequest requestentity=new FactorialRequest();
	    	requestentity.setNumber(5);

	    	String json = objMapper.writeValueAsString(expectedResult);
			when(productService.getFactorialOfNumber(requestentity)).thenReturn(expectedResult);
			mockmvc.perform(post("/v1/factorial").contentType(MediaType.APPLICATION_JSON).content(json)
					.characterEncoding("utf-8")).andExpect(status().isOk()).andReturn();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	   	}
	    
	    @Test
	   	public void doMinMaxTest() {
	    	try {
	    	int[] array = new int[]{10,5,-5,6,82,66,-91};
	    	MinMaxRequest requestentity = new MinMaxRequest();
	    	MinMaxResponce expectedResult = new MinMaxResponce(-91,82);
	    	
	    	ArrayList<Integer> list = IntStream.of(array)
	                .boxed()
	                .collect(Collectors.toCollection(ArrayList::new));
	    	requestentity.setNumbers(list);
			
			
			  String json = objMapper.writeValueAsString(expectedResult);
				when(productService.getMinMaxOfNumbers(requestentity)).thenReturn(expectedResult);
				mockmvc.perform(post("/v1/factorial").contentType(MediaType.APPLICATION_JSON).content(json)
						.characterEncoding("utf-8")).andExpect(status().isOk()).andReturn();
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		
	   	}


}
