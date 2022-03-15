package com.qa.weightlifting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.weightlifting.domain.Weightlifting;

@Service
public class WeightliftingServiceList implements WeightliftingInterface<Integer> {
	// Store info in, alternative to db:
	private List<Weightlifting> weightlifting = new ArrayList<>();

	@Override
	public Weightlifting create(Weightlifting x) {
		x.setId((long) this.weightlifting.indexOf(x));// added this to update id variable with array index
		this.weightlifting.add(x);
		Weightlifting created = this.weightlifting.get(this.weightlifting.size() - 1);
		return created;
	}

	@Override
	public List<Weightlifting> read() {
		// TODO Auto-generated method stub
		return this.weightlifting;
	}

	public Weightlifting readOne(Integer id) {
		// TODO Auto-generated method stub
		return this.weightlifting.get(id);
	}

	@Override
	public Weightlifting update(Integer id, Weightlifting y) {
		// TODO Auto-generated method stub
		this.weightlifting.set(id, y);
		return this.weightlifting.get(id);
	}

	@Override
	public Weightlifting delete(Integer id) {
		// TODO Auto-generated method stub
		return this.weightlifting.remove((int)id);
	}

}
