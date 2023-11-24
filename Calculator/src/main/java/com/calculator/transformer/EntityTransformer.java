package com.calculator.transformer;


import org.springframework.stereotype.Component;

import com.calculator.responce.ResponceEntity;
import com.calculator.responce.ResponceTable;






@Component
public class EntityTransformer {

	public ResponceEntity transformToEntity(ResponceTable responce) {
		ResponceEntity calculatorResponse=new ResponceEntity();
		calculatorResponse.setResult(responce.getResult());
		calculatorResponse.setDetails(getDetailsResponse(responce));
		return calculatorResponse; 
	}

	private String getDetailsResponse(ResponceTable responce) {
		if(responce.getFlowName().equals("Addition"))
			return responce.getNumber1()+ "+"+responce.getNumber2()+"="+responce.getResult();
		if(responce.getFlowName().equals("Substraction"))
			return responce.getNumber1()+ "-"+responce.getNumber2()+"="+responce.getResult();
		if(responce.getFlowName().equals("Division"))
			return responce.getNumber1()+ "/"+responce.getNumber2()+"="+responce.getResult();
		if(responce.getFlowName().equals("Multiplication"))
			return responce.getNumber1()+ "*"+responce.getNumber2()+"="+responce.getResult();
		if(responce.getFlowName().equals("Factorials"))
			return "Factorials of " +responce.getNumber1()+ "!"+" is "+responce.getResult();
		if(responce.getFlowName().equals("SquareOfNumber"))
			return "Square Of Number"+responce.getNumber1()+"="+responce.getResult();
		if(responce.getFlowName().equals("SquareRootOfNumber"))
			return  "SquareRoot Of Number "+responce.getNumber1()+"="+responce.getResult();
		return null;
	
	}

	
	
}
