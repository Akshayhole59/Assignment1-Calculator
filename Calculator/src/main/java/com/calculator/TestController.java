package com.calculator;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calculator.responce.ResponceEntity;
import com.calculator.service.ProductService;

@Controller
@RequestMapping("/v1")
public class TestController {
	
	
	@Autowired
	ProductService productService;
	
	
	//Addition of two numbers
	@GetMapping("/addition")
	@ResponseBody
	public ResponceEntity addition(@RequestParam("number1") int number1,@RequestParam("number2") int number2) {
		return productService.getAdditionOfTwoNumbers(number1,number2);
	}
	
	
	//substraction of two numbers
	@GetMapping("/subtraction")
	@ResponseBody
	public ResponceEntity substraction(@RequestParam("number1") int number1,@RequestParam("number2") int number2) {
		return productService.getSubstractionOfTwoNumbers(number1,number2);
	}
	
	
	//Division of two numbers
	@GetMapping("/division")
	@ResponseBody
	public ResponceEntity division(@RequestParam("number1") int number1,@RequestParam("number2") int number2) {		
		return productService.getDivisionOfTwoNumbers(number1,number2);
	}
	
	
	//multiplication of two numbers
	@GetMapping("/multiplication")
	@ResponseBody
	public ResponceEntity multiplication(@RequestParam("number1") int number1,@RequestParam("number2") int number2) {
		return productService.getMultiplicationOfTwoNumbers(number1,number2);
	}
	
	
	//Square of given numbers
	@GetMapping("/square/{number1}")
	@ResponseBody
	public ResponceEntity square(@PathVariable("number1") int number1) {
		return productService.getSquareOfNumber(number1);
	}
	
	
	//Squareroot of given numbers
	@GetMapping("/squareroot/{number1}")
	@ResponseBody
	public ResponceEntity squareroot(@PathVariable("number1") int number1) {	
		return productService.getSquareRootOfNumber(number1);
	}

	@GetMapping("/factorial/{number1}")
	@ResponseBody
	public ResponceEntity factorial(@PathVariable("number1") int number1) {	
		return productService.getFactorialOfNumber(number1);
	}
	
	
	@GetMapping("/min-max")
	@ResponseBody
	public Map<String,String>  findMinAndMax(@PathVariable List<Integer> numbers) {	
		return productService.getMinMaxOfNumbers(numbers);
	}
}
