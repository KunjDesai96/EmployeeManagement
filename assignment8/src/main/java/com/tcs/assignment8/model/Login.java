package com.tcs.assignment8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
	@Id
	@Column(length =20 )
	@Size(max=20, min =3 ,message = "user name is not valid")
	private String userName;
	@Size(max=20, min =3 ,message = "password is not valid")
	private String password;

}
