package io.simpolor.testing.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Demo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long seq;

	String name;

	int age;
}