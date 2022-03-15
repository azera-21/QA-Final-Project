package com.qa.weightlifting.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.weightlifting.domain.Weightlifting;
import com.qa.weightlifting.repo.WeightliftingRepo;
import com.qa.weightlifting.service.WeightliftingServiceDB;

@SpringBootTest
@ActiveProfiles("test")
public class WeightliftingServiceDBTest {

	// data
	private Weightlifting input;
	private Weightlifting returned;

	@Autowired // the class we are testing
	private WeightliftingServiceDB serv;

	@MockBean // this is the class we are dependent on so have to mock
	private WeightliftingRepo rep;

	@BeforeEach
	void setUp() {
//		System.out.println("before");
		input = new Weightlifting("Reptile", 10, "Male");
		returned = new Weightlifting(1L, "Reptile", 10, "Male");
	}

	@Test
	void testCreate() {
//		System.out.println("test 1");
		// GIVEN
		// input/data

		// WHEN
		Mockito.when(this.rep.save(input)).thenReturn(returned);
		// THEN
		assertThat(this.serv.create(input)).isEqualTo(returned);

		// Verification
		Mockito.verify(this.rep, Mockito.times(1)).save(input);
	}

	@Test
	void testRead() {
//		System.out.println("test 2");
		// GIVEN
		List<Weightlifting> readList = new ArrayList<>();
		readList.add(input);
		// WHEN
		Mockito.when(this.rep.findAll()).thenReturn(readList);
		// THEN
		assertThat(this.serv.read()).isEqualTo(readList);
		// VERIFY
		Mockito.verify(this.rep, Mockito.times(1)).findAll();
	}

	
	
	@Test
	void testReadOne() {
		// GIVEN
		Long id = 1L;// method input
		// variables setup in method
		Optional<Weightlifting> optAnim = Optional.of(returned);
		// WHEN a certain method is called, return ....
		Mockito.when(this.rep.findById(id)).thenReturn(optAnim);
		// THEN check what was returned is equal to what was expected
		assertThat(this.serv.readOne(id)).isEqualTo(returned);
		// VERIFY
		Mockito.verify(this.rep, Mockito.times(1)).findById(id);
	}
	

	@Test
	void testUpdate() {
		// GIVEN - id, object
		Long id = 1L;
		// NEW ANIMAL OBJECT FOR INPUT TO UPDATE METHOD
		Weightlifting toUpdate = new Weightlifting("Mammal", 8, "F");
		// METHOD USES AN OPTIONAL VERSION OF THE ANIMAL OBJECT
		Optional<Weightlifting> opt = Optional.of(returned);
		// UPDATED VERSION:
		Weightlifting updated = new Weightlifting(id, toUpdate.getBestLift(), toUpdate.getTotal(), toUpdate.getBestLift());
		// WHEN
		Mockito.when(this.rep.findById(id)).thenReturn(opt);
		Mockito.when(this.rep.save(updated)).thenReturn(updated);
		// THEN
		assertThat(this.serv.update(id, toUpdate)).isEqualTo(updated);
		// VERIFY
		Mockito.verify(this.rep, Mockito.times(1)).findById(id);
		Mockito.verify(this.rep, Mockito.times(1)).save(updated);
	}

	@Test
	void testDelete() {
		// GIVEN
		Long id = 1L;//user input
		// Optional Chocolate
		Optional<Weightlifting> optChoco = Optional.of(returned);
		// WHEN
		Mockito.when(this.rep.findById(id)).thenReturn(optChoco);
		// THEN
		assertThat(this.serv.delete(id)).isEqualTo(returned);
		// VERIFY
		Mockito.verify(this.rep, Mockito.times(1)).deleteById(id);
		Mockito.verify(this.rep, Mockito.times(1)).findById(id);
	}

	@Test
	void testRemove() {
		// GIVEN
		Long id = 1L;
		// WHEN
		Mockito.when(this.rep.existsById(id)).thenReturn(false);
		// THEN
		assertThat(this.serv.remove(id)).isTrue();
		// VERIFY
		Mockito.verify(this.rep, Mockito.times(1)).deleteById(id);
		Mockito.verify(this.rep, Mockito.times(1)).existsById(id);
	}

	@AfterEach
	void clear() {
//		System.out.println("after");
	}

}
