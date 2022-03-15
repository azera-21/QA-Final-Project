package com.qa.weightlifting.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // marking this class as a table for SQL
public class Weightlifting {
	// create table animals(
	// id int not null auto_increment,
	// breed varchar(255),
	// age int,
	// gender varchar(255),
	// primary key(id));

	// variables - columns in the table
	@Id // marks the field below as a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private Long id;

	private String name;
	private int total;
	private String bestLift;

	// constructors - 3 types
	// overloading - polymorphism

	// 1 - default constructor - empty one
	public Weightlifting() {
		super();
	}

	// 2 - constructor with id

	public Weightlifting(Long id, String name, int total, String bestLift) {
		super();
		this.id = id;
		this.name = name;
		this.total = total;
		this.bestLift = bestLift;
	}

	// 3 - constructor without id

	public Weightlifting(String name, int total, String bestLift) {
		super();
		this.name = name;
		this.total = total;
		this.bestLift = bestLift;
	}

	// getters & setters

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBreed(String name) {
		this.name = name;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getBestLift() {
		return bestLift;
	}

	public void setBestLift(String bestLift) {
		this.bestLift = bestLift;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(total, name, bestLift, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weightlifting other = (Weightlifting) obj;
		return total == other.total && Objects.equals(name, other.name) && Objects.equals(bestLift, other.bestLift)
				&& Objects.equals(id, other.id);
	}

}
