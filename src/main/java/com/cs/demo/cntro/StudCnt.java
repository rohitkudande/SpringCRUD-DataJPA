package com.cs.demo.cntro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import jakarta.validation.Valid;

@RestController
public class StudCnt{
	@Autowired
	private StudRepo repo;
	
	//select
	@GetMapping("/stud")
	public List<Stud> getAll(){
		return repo.findAll();
	}
	
	@GetMapping("/cstud")
	public Map<String, List<Stud>> getAlls(){
		List<Stud> list = repo.findAll();
		Map<String, List<Stud>> response = new HashMap<>();
		response.put("students", list);
		return response;
	}
	
	//find by id
	@GetMapping("/findById/{id}")
	public Optional<Stud> findById(@PathVariable("id") int id){
		return repo.findById(id);
	}
	
	//custom methods
	@GetMapping("/cnt")
	public Map<String, Object> getSummary(){
		long total = repo.getTotalStud();
		Map<String, Object> result = new HashMap<>();
		result.put("total", total);
		return result;
	}
	
	
	@GetMapping("/mx")
	public Map<String, Object> getMx(){
		long total = repo.getMaxStud();
		Map<String, Object> result = new HashMap<>();
		result.put("max", total);
		return result;
	}
	
	
	
	//insert
	@PostMapping("/saveStud")
	public Stud saveStud(@Valid @RequestBody Stud stud) {
		return repo.save(stud);
	}
	
	//update
	@PutMapping("/updateStud/{id}")
	public Stud updateStud(@PathVariable("id") int id,@Valid @RequestBody Stud stud) {
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
