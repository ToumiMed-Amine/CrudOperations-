package com.springboot.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollNo ;
	@Column(name = "student_name")
	private String nom ;
	@Column(name = "student_percentage")
	private float percentage ;
	@Column(name = "student_branche")
	private String Branche ;
		
	public Student() {
		super();
	}
		
	public Student(String nom, float percentage, String branche) {
		super();
		this.nom = nom;
		this.percentage = percentage;
		Branche = branche;
	}



	public Student(int rollNo, String nom, float percentage, String branche) {
		super();
		this.rollNo = rollNo;
		this.nom = nom;
		this.percentage = percentage;
		Branche = branche;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public float getPercentage() {
		return percentage;
	}
	
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	
	public String getBranche() {
		return Branche;
	}
	
	public void setBranche(String branche) {
		Branche = branche;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", nom=" + nom + ", percentage=" + percentage + ", Branche=" + Branche
				+ "]";
	}
		
}
