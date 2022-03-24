package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bins1")
public class Bins 
{
	@Id
	
	private double id;
	private double bar_code;
	private double weight_capacity;
	private double width;
	private double length;
	private double height;
	
	public Bins() {
		
	}
	public Bins(double id, double bar_code, double weight_capacity, double width, double length, double height) {
		super();
		this.id = id;
		this.bar_code = bar_code;
		this.weight_capacity = weight_capacity;
		this.width = width;
		this.length = length;
		this.height = height;
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public double getBar_code() {
		return bar_code;
	}

	public void setBar_code(double bar_code) {
		this.bar_code = bar_code;
	}

	public double getWeight_capacity() {
		return weight_capacity;
	}

	public void setWeight_capacity(double weight_capacity) {
		this.weight_capacity = weight_capacity;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
