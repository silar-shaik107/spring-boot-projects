package com.taskproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users",uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})//here duplicate emails should not be allowed to store
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name ="name",nullable = false)//if you want change the column name use @Column,otherwise no need.
	private String name;                   //nullable is to make the record should not be null(false)
	
	@Column(name="email",nullable = false)
	private String email;
	@Column(name = "password",nullable = false)
	private String password;

}
