package com.rest.webservices.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import java.time.LocalDate;



@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String description;
	private LocalDate targetDate;
	private boolean done;


	public Todo( String description, LocalDate targetDate, boolean done) {

		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	public Todo() {
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}


	@Override
	public String toString() {
		return "Todo{" +
				"id=" + id +
				", description='" + description + '\'' +
				", targetDate=" + targetDate +
				", done=" + done +
				'}';
	}





}