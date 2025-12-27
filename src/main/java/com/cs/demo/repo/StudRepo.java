package com.cs.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.demo.model.Stud;

public interface StudRepo extends JpaRepository<Stud,Integer>{

}
