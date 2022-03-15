package com.qa.weightlifting.service;

import java.util.List;

import com.qa.weightlifting.domain.Weightlifting;

public interface WeightliftingInterface<T> {
	
	//abstract methods for each of the CRUD
	
	Weightlifting create(Weightlifting x);
	
	List<Weightlifting> read();
	
	Weightlifting update(T id, Weightlifting y);
	
	Weightlifting delete(T id);

}
