package io.simpolor.testing.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Demo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long seq;

	String name;

	int age;

	String hobby;
}