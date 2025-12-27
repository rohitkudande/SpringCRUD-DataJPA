package com.cs.demo.cntro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.demo.model.Stud;
import com.cs.demo.repo.StudRepo;

@RestController
public class StudCnt{
	@Autowired
	private StudRepo repo;
	
	//select
	@GetMapping("/stud")
	public List<Stud> getAll(){
		return repo.findAll();
	}
	
	//insert
	@PostMapping("/saveStud")
	public Stud saveStud(@RequestBody Stud stud) {
		return repo.save(stud);
	}
	
	//update
	@PutMapping("/updateStud/{id}")
	public Stud updateStud(@PathVariable("id") int id,@RequestBody Stud stud) {
		stud.setId(id);
		return repo.save(stud);
	}
	
	//delete
	@DeleteMapping("/deleteStud/{id}")
	public String deleteStud(@PathVariable("id") int id) {
		repo.deleteById(id);
		return "Delete Successfully..";
	}
	
}
