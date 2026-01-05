package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cs.demo.model.Stud;

public interface StudRepo extends JpaRepository<Stud,Integer>{
	
	//custom queries
	@Query(value = "SELECT COUNT(*) FROM stud",nativeQuery = true)
	Long getTotalStud();
	@Query(value = "SELECT MAX(id) FROM stud",nativeQuery = true)
	Long getMaxStud();
	
}
