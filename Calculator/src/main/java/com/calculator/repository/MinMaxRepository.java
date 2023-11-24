package com.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculator.responce.MinMaxTable;

public interface MinMaxRepository  extends JpaRepository<MinMaxTable,Integer> {

	

}
