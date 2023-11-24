package com.calculator;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.calculator.controller.TestController;
import com.calculator.dao.ProductDao;
import com.calculator.repository.ResponceRepository;
import com.calculator.responce.ResponceEntity;
import com.calculator.responce.ResponceTable;
import com.calculator.transformer.EntityTransformer;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(value=ProductDao.class)
@AutoConfigureMockMvc(addFilters = false)
public class CalculatorDaoTest {
	

	@InjectMocks
	ProductDao productDao;
	
	@Mock
	ResponceRepository responceRepo;
	
	@Mock
	EntityTransformer entityTransformer;
	

	@Test
	public void testSaveDataforAddition()
	{
		ResponceEntity expectedresponce=new ResponceEntity();
		expectedresponce.setResult(15);
		expectedresponce.setDetails("10+5=15");
		
		ResponceTable responce =prepareDataForCalculatorData(10, 5, "Addition", 15);
		when(responceRepo.save(any(ResponceTable.class))).thenReturn(responce);
		when(entityTransformer.transformToEntity(any(ResponceTable.class))).thenReturn(expectedresponce);
		ResponceEntity saveData = productDao.saveDataInDatabase(responce);
		verify(responceRepo).save(any(ResponceTable.class));
		verify(entityTransformer).transformToEntity(any(ResponceTable.class));
		assertNotNull(saveData);
	}
	
	
	private ResponceTable prepareDataForCalculatorData(int number1, int number2, String flowName, int result) {
        ResponceTable respons = new ResponceTable();
		
		respons.setFlowName(flowName);
		respons.setResult(result);
		respons.setNumber1(number1);
		respons.setNumber2(number2);
		 
		return respons;
	}



}
