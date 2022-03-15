package com.qa.weightlifting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.weightlifting.domain.Weightlifting;
import com.qa.weightlifting.repo.WeightliftingRepo;

@Service
public class WeightliftingServiceDB implements WeightliftingInterface<Long> {

	private WeightliftingRepo repo; //inject dependency
	
	public WeightliftingServiceDB(WeightliftingRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Weightlifting create(Weightlifting x) {
		// TODO Auto-generated method stub
		return this.repo.save(x);
	}

	@Override
	public List<Weightlifting> read() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}
	
	
	public Weightlifting readOne(Long id) {
		// TODO Auto-generated method stub
		Optional<Weightlifting> optRead = this.repo.findById(id);
		return optRead.orElse(null);
	}

	@Override
	public Weightlifting update(Long id, Weightlifting y) {
		// TODO Auto-generated method stub
		Optional<Weightlifting> optAni =  this.repo.findById(id);
		Weightlifting found = optAni.get();
		found.setTotal(y.getTotal());
		found.setBestLift(y.getBestLift());
		found.setBestLift(y.getBestLift());
		return this.repo.save(found);
	}

	//return object deleted to confirm info
	@Override
	public Weightlifting delete(Long id) {
		Optional<Weightlifting> toDelete = this.repo.findById(id);
		this.repo.deleteById(id);
		return toDelete.orElse(null);
	}

	//boolean to return true or false if it deleted
	public boolean remove(Long id) {//id = 1
		this.repo.deleteById(id);//id = 1 - gone
		return !this.repo.existsById(id);//false - true
	}
	
	
}
