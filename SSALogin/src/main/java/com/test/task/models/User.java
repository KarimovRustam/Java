package com.test.task.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"user\"")
@Getter
@Builder
@EqualsAndHashCode
public class User {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	private String login;
	private String password;
	private String role;
}
