package com.qa.weightlifting.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.weightlifting.domain.Weightlifting;
import com.qa.weightlifting.service.WeightliftingServiceDB;

@RestController
public class WeightliftingController {
	
	private WeightliftingServiceDB service;//CDI - context & dependency injection
	
	public WeightliftingController(WeightliftingServiceDB service) {
		super();
		this.service = service;
	}
	
	// CRUD

	// CREATE

	@PostMapping("/create")
	public ResponseEntity<Weightlifting> createWeightlifting(@RequestBody Weightlifting a) {
		return new ResponseEntity<Weightlifting>(this.service.create(a), HttpStatus.CREATED);
	}

	// READ
	@GetMapping("readAll")
	public List<Weightlifting> readWeightlifting() {
		return this.service.read();
	}

	// READ BY ID
	@GetMapping("/readById/{id}")
	public Weightlifting getById(@PathVariable Long id) {
		return this.service.readOne(id);
	}

	// UPDATE
	@PutMapping("/update/{id}")
	public Weightlifting update(@PathVariable Long id, @RequestBody Weightlifting updated) {
		return this.service.update(id, updated);
	}

	// DELETE
	@DeleteMapping("/delete/{id}")
	public Weightlifting delete(@PathVariable Long id) {
		return this.service.delete(id);
	}
	
//	@DeleteMapping("/remove")
//	public boolean remove(@PathParam("id") Long id) {
//		return this.service.remove(id);
//	}

}
