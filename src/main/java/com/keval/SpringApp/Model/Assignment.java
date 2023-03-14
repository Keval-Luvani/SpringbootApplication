package com.keval.SpringApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Assignment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String title;
	private String description;
	private int score;
	private String dueDate;
	@ManyToOne
	@JoinColumn(name="assignedBy")
	private Teacher teacher;
	
	public Assignment() {
	}

	public Assignment(int id, String title, String description, int score, String duedate, Teacher teacher) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.score = score;
		this.dueDate = duedate;
		this.teacher = teacher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDuedate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
