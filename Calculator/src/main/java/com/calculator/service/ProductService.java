package com.calculator.service;

import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import com.calculator.dao.ProductDao;
import com.calculator.request.AdditionRequest;
import com.calculator.request.DivisionRequest;
import com.calculator.request.FactorialRequest;
import com.calculator.request.MinMaxRequest;
import com.calculator.request.MultiplicationRequest;
import com.calculator.request.SquareRequest;
import com.calculator.request.SquareRootRequest;
import com.calculator.request.SubstractionRequest;
import com.calculator.responce.CalculatorResponce;
import com.calculator.responce.MinMaxResponce;
import com.calculator.responce.MinMaxTable;
import com.calculator.responce.ResponceEntity;
import com.calculator.responce.ResponceTable;

@Component
public class ProductService {

	public static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	
	
	@Autowired
	ProductDao productDao;
	
	/**
	 * @param requestEntity
	 * @return
	 */
	@Cacheable(value="calculatorCache",key="'addition:' + #requestEntity.number1 + ':' + #requestEntity.number2", unless = "#result == null")
	public ResponceEntity getAdditionOfTwoNumbers(AdditionRequest requestEntity) {
		LOGGER.error("Request for addition: " + requestEntity);
		ResponceTable responceTable= new ResponceTable();
		String flowName= "Addition";
		ResponceEntity responce = new ResponceEntity();
		//CalculatorResponce calResponce = new CalculatorResponce();
		try {
			int result = requestEntity.getNumber1() + requestEntity.getNumber2();
			
			//SetDetailsIn responceTable
			responceTable=prepareResponceToStoreInTable(flowName,requestEntity.getNumber1(),requestEntity.getNumber2(),result);
			responce = productDao.saveDataInDatabase(responceTable);

		} catch (Exception e) {
			System.out.println("exception in getAdditionOfTwoNumbers()");
		}

		LOGGER.error("Responce for addition: " + responce);

		return responce;
	}


	/**
	 * @param requestEntity
	 * @return
	 */
	@Cacheable(value="calculatorCache",key="'substraction:' + #requestEntity.number1 + ':' + #requestEntity.number2", unless = "#result == null")
	public ResponceEntity getSubstractionOfTwoNumbers(SubstractionRequest requestEntity) {
		ResponceEntity responce = new ResponceEntity();
		ResponceTable responceTable= new ResponceTable();
		//CalculatorResponce calResponce = new CalculatorResponce();
		String flowName= "Substraction";
		try {
			LOGGER.error("Request for substraction: " + requestEntity);
			int result = requestEntity.getNumber1() - requestEntity.getNumber2();
			
			//SetDetailsIn responceTable
			responceTable=prepareResponceToStoreInTable(flowName,requestEntity.getNumber1(),requestEntity.getNumber2(),result);
			responce=productDao.saveDataInDatabase(responceTable);

		} catch (Exception e) {
			System.out.println("exception in getSubstractionOfTwoNumbers()");
		}
		LOGGER.error("Responce for Substraction: " + responce);
		return responce;
	}


	/**
	 * @param requestEntity
	 * @return
	 */
	@Cacheable(value="calculatorCache",key="'division:' + #requestEntity.number1 + ':' + #requestEntity.number2", unless = "#result == null")
	public ResponceEntity getDivisionOfTwoNumbers(DivisionRequest requestEntity) {
		ResponceEntity responce = new ResponceEntity();
		ResponceTable responceTable= new ResponceTable();
		CalculatorResponce calResponce = new CalculatorResponce();
		String flowName= "Division";
		try {
			LOGGER.error("Request for division: " + requestEntity);
			int result = requestEntity.getNumber1() / requestEntity.getNumber2();
			
			//SetDetailsIn responceTable
			responceTable=prepareResponceToStoreInTable(flowName,requestEntity.getNumber1(),requestEntity.getNumber2(),result);
			responce=productDao.saveDataInDatabase(responceTable);

		} catch (Exception e) {
			System.out.println("exception in getDivisionOfTwoNumbers()");
		}
		LOGGER.error("Responce for division: " + responce);
		return responce;
	}

	
	
	
	/**
	 * @param requestEntity
	 * @return
	 */
	@Cacheable(value="calculatorCache",key="'multiplication :' + #requestEntity.number1 + ':' + #requestEntity.number2", unless = "#result == null")
	public ResponceEntity getMultiplicationOfTwoNumbers(MultiplicationRequest requestEntity) {
		ResponceEntity responce = new ResponceEntity();
		ResponceTable responceTable= new ResponceTable();
		CalculatorResponce calResponce = new CalculatorResponce();
		String flowName= "Multiplication";
		try {
			LOGGER.error("Request for Multiplication: " + requestEntity);
			int result = requestEntity.getNumber1() * requestEntity.getNumber2();
			
			//SetDetailsIn responceTable
			responceTable=prepareResponceToStoreInTable(flowName,requestEntity.getNumber1(),requestEntity.getNumber2(),result);
			responce=productDao.saveDataInDatabase(responceTable);

		} catch (Exception e) {
			System.out.println("exception in getMultiplicationOfTwoNumbers()");
		}
		LOGGER.error("Responce for Multiplication : " + responce);
		return responce;
	}

	
	
	
	/**
	 * @param requestEntity
	 * @return
	 */
	@Cacheable(value="calculatorCache",key="'square:' + #requestEntity.number ", unless = "#result == null")
	public ResponceEntity getSquareOfNumber(SquareRequest requestEntity) {
		ResponceEntity responce = new ResponceEntity();
		ResponceTable responceTable= new ResponceTable();
		CalculatorResponce calResponce = new CalculatorResponce();
		String flowName= "SquareOfNumber";
		try {
			LOGGER.error("Request for square of number: " + requestEntity);
			int result = requestEntity.getNumber() * requestEntity.getNumber();
			
			
			//SetDetailsIn responceTable
			responceTable=prepareResponceToStoreInTable(flowName,requestEntity.getNumber(),0,result);
			responce=productDao.saveDataInDatabase(responceTable);

		} catch (Exception e) {
			System.out.println("exception in getSquareRootOfNumber()");
		}
		LOGGER.error("Responce for square of number : " + responce);
		return responce;
	}

	
	
	
	/**
	 * @param requestEntity
	 * @return
	 */
	@Cacheable(value="calculatorCache",key="'squareroot:' + #requestEntity.number ", unless = "#result == null")
	public ResponceEntity getSquareRootOfNumber(SquareRootRequest requestEntity) {
		ResponceEntity responce = new ResponceEntity();
		ResponceTable responceTable= new ResponceTable();
		CalculatorResponce calResponce = new CalculatorResponce();
		String flowName= "SquareRootOfNumber";
		try {
			LOGGER.error("Request for squareroot of number: " + requestEntity);
			double result = Math.pow(requestEntity.getNumber(), 0.5);
			Integer intResult = (int) result;
			
			//SetDetailsIn responceTable
			responceTable=prepareResponceToStoreInTable(flowName,requestEntity.getNumber(),0,intResult);
			responce=productDao.saveDataInDatabase(responceTable);

		} catch (Exception e) {
			System.out.println("exception in getSquareRootOfNumber()");
		}
		LOGGER.error("Responce for squareroot of number : " + responce);
		return responce;
	}

	
	
	
	/**
	 * @param requestEntity
	 * @return
	 */
	@Cacheable(value="calculatorCache",key="'Factorial:' + #requestEntity.number ", unless = "#result == null")
	public ResponceEntity getFactorialOfNumber(FactorialRequest requestEntity) {
		ResponceEntity responce = new ResponceEntity();
		ResponceTable responceTable= new ResponceTable();
		CalculatorResponce calResponce = new CalculatorResponce();
		String flowName= "Factorials";
		try {
			LOGGER.error("Request for factorial of number: " + requestEntity);
			int result = 1, i;
			for (i = 2; i <= requestEntity.getNumber(); i++) {
				result *= i;
			}
			
			//SetDetailsIn responceTable
			responceTable=prepareResponceToStoreInTable(flowName,requestEntity.getNumber(),0,result);
			responce=productDao.saveDataInDatabase(responceTable);

		} catch (Exception e) {
			System.out.println("exception in getSquareRootOfNumber()");
		}
		LOGGER.error("Responce for factorial of number : " + responce);
		return responce;
	}

	

	/**
	 * @param numbers
	 * @return
	 */
	public MinMaxResponce getMinMaxOfNumbers(MinMaxRequest minMaxRequest) {
		String detail = null;
		MinMaxResponce minmaxResponce = new MinMaxResponce();
		String flowName= "Min-Max";
		MinMaxTable minMaxTable = new MinMaxTable();
		//LOGGER.error("Request for minMax of number: " );
		try {

			if (minMaxRequest.getNumbers() == null || minMaxRequest.getNumbers().size() == 0) {
				throw new Exception("arraylist is null");
			}
		
			minmaxResponce.setMinValue(Collections.min(minMaxRequest.getNumbers()));
			minmaxResponce.setMaxValue(Collections.max(minMaxRequest.getNumbers()));
			
			minMaxTable=prepareRequestForMinMaxTable(flowName,minmaxResponce);
			productDao.saveDataInMinMaxTable(minMaxTable);

		} catch (Exception e) {
			System.out.println("exception in getSquareRootOfNumber()");
		}
		LOGGER.error("Responce for minMax of number : " + detail);
		return minmaxResponce;
	}
	
	
	private MinMaxTable prepareRequestForMinMaxTable(String flowName, MinMaxResponce minmaxResponce) {
		MinMaxTable minMaxTable = new MinMaxTable();
		minMaxTable.setMinNumber(minmaxResponce.getMinValue());
		minMaxTable.setMaxNumber(minmaxResponce.getMaxValue());
		return minMaxTable;
		
	}


	private ResponceTable prepareResponceToStoreInTable(String flowName, Integer number1, Integer number2, int result) {
		ResponceTable respons = new ResponceTable();
		
		respons.setFlowName(flowName);
		respons.setResult(result);
		respons.setNumber1(number1);
		respons.setNumber2(number2);
		 
		return respons;
	}






}
