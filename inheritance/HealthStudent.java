package com.ssafy.hw02;

public class HealthStudent {
	private String name;
	private String measureDate;
	private double weight;
	private double height;

	public HealthStudent() {
		// TODO Auto-generated constructor stub
	}

	public HealthStudent(String name, String measureDate, double weight, double height) {
		super();
		this.name = name;
		this.measureDate = measureDate;
		this.weight = weight;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeasureDate() {
		return measureDate;
	}

	public void setMeasureDate(String measureDate) {
		this.measureDate = measureDate;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
//		return "HealthStudent [name=" + name + ", measureDate=" + measureDate + ", weight=" + weight + ", height="
//				+ height + "]";
		return  name + "\t" + measureDate + '\t' + weight + '\t' + height;
	}

}
