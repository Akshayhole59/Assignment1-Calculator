package com.calculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping("/v1")
public class TestController {
	
	public static final Logger LOGGER=LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	ProductService productService;
	
	
	//Addition of two numbers
	/**
	 * @param requestEntity
	 * @return
	 */
	@PostMapping("/addition")
	@ResponseBody
	public ResponceEntity addition(@RequestBody AdditionRequest requestEntity) {
		LOGGER.info("Addition Services call");
		return productService.getAdditionOfTwoNumbers(requestEntity);
	}
	
	
	//substraction of two numbers
	/**
	 * @param requestEntity
	 * @return
	 */
	@PostMapping("/subtraction")
	@ResponseBody
	public ResponceEntity substraction(@RequestBody SubstractionRequest requestEntity) {
		LOGGER.info("Substraction Services call");
		return productService.getSubstractionOfTwoNumbers(requestEntity);
	}
	
	
	//Division of two numbers
	/**
	 * @param requestEntity
	 * @return
	 */
	@PostMapping("/division")
	@ResponseBody
	public ResponceEntity division(@RequestBody DivisionRequest requestEntity) {	
		LOGGER.info("Division Services call");
		return productService.getDivisionOfTwoNumbers(requestEntity);
	}
	
	
	//multiplication of two numbers
	/**
	 * @param requestEntity
	 * @return
	 */
	@PostMapping("/multiplication")
	@ResponseBody
	public ResponceEntity multiplication(@RequestBody MultiplicationRequest requestEntity) {
		return productService.getMultiplicationOfTwoNumbers(requestEntity);
	}
	
	
	//Square of given numbers
	/**
	 * @param requestEntity
	 * @return
	 */
	@PostMapping("/square")
	@ResponseBody
	public ResponceEntity square(@RequestBody SquareRequest requestEntity) {
		return productService.getSquareOfNumber(requestEntity);
	}
	
	/*
	 * @PostMapping("/square/{number1}")
	 * 
	 * @ResponseBody public ResponceEntity square(@RequestBody RequestEntity
	 * requestEntity) { return productService.getSquareOfNumber(requestEntity); }
	 */
	
	//Squareroot of given numbers
	/**
	 * @param requestEntity
	 * @return
	 */
	@PostMapping("/squareroot")
	@ResponseBody
	public ResponceEntity squareroot(@RequestBody SquareRootRequest requestEntity) {	
		return productService.getSquareRootOfNumber(requestEntity);
	}

	/*
	 * @PostMapping("/squareroot/{number1}")
	 * 
	 * @ResponseBody public ResponceEntity squareroot(@RequestBody RequestEntity
	 * requestEntity) { return productService.getSquareRootOfNumber(requestEntity);
	 * }
	 */
	/**
	 * @param requestEntity
	 * @return
	 */
	@PostMapping("/factorial")
	@ResponseBody
	public ResponceEntity factorial(@RequestBody FactorialRequest requestEntity) {	
		return productService.getFactorialOfNumber(requestEntity);
	}
	
	/*
	 * @PostMapping("/factorial/{number1}")
	 * 
	 * @ResponseBody public ResponceEntity factorial(@RequestBody RequestEntity
	 * requestEntity) { return productService.getFactorialOfNumber(requestEntity); }
	 */
	
	/**
	 * @param numbers
	 * @return
	 */
	@GetMapping("/min-max")
	@ResponseBody
	public MinMaxResponce  findMinAndMax(@PathVariable MinMaxRequest minMaxRequest) {	
		return productService.getMinMaxOfNumbers(minMaxRequest);
	}
}
