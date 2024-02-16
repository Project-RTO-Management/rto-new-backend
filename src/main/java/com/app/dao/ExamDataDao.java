package com.app.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.ExamData;

public interface ExamDataDao extends  JpaRepository<ExamData, Long>{

		 @Query(value="SELECT * FROM exam_data ORDER BY RAND() LIMIT 10", nativeQuery = true) 
		 Set<ExamData> findRandom10();
		 
	   

	
}
//
//@Query("select a.emp from Address a where a.city=:city")
//List<Employee> findEmployeesByCity(String city);

//Query query = entityManager.createQuery("SELECT e FROM ExamData e ORDER BY FUNCTION('RAND')");
//query.setMaxResults(10);
//return query.getResultList();
//