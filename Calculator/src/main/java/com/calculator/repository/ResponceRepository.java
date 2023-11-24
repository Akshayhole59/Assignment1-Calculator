package com.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.calculator.responce.ResponceTable;

public interface ResponceRepository extends JpaRepository<ResponceTable,Integer>{

}
