package com.calculator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.calculator.repository.MinMaxRepository;
import com.calculator.repository.ResponceRepository;
import com.calculator.responce.MinMaxTable;
import com.calculator.responce.ResponceEntity;
import com.calculator.responce.ResponceTable;
import com.calculator.transformer.EntityTransformer;

@Repository
public class ProductDao {
	
	@Autowired
	ResponceRepository responceRepo;
	
	@Autowired
	MinMaxRepository minMaxRepository;
	
	@Autowired
	EntityTransformer entityTransformer;
	
	public ResponceEntity saveDataInDatabase(ResponceTable responceTable) {
		ResponceTable responce = new ResponceTable();
		ResponceEntity calResponce = new ResponceEntity();
		try {
			responce = responceRepo.save(responceTable);	
			calResponce = entityTransformer.transformToEntity(responce);
		}catch(Exception e) {
			System.out.println("Exception in Dao call ---" +e);
		}
		return calResponce;
		
	}

	public void saveDataInMinMaxTable(MinMaxTable minMaxTable) {
		try {
			minMaxRepository.save(minMaxTable);	
		}catch(Exception e) {
			System.out.println("Exception in Dao call ---" +e);
		}
	}
	
	
	

}
