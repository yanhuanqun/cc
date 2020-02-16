package com.parking.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_user")
@Data
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userId")
	private Integer userId;

	@Column(name = "username", unique = true, nullable = false, length = 64)
	private String username;

	@Column(name = "password", unique = true, nullable = false, length = 64)
	@ColumnTransformer(
			read = "AES_DECRYPT(UNHEX(password), 'key')",
			write = "HEX(AES_ENCRYPT(?, 'key'))"
	)
	private String password;

	@Column(name = "phone", unique = true, nullable = false, length = 11)
	private Long phone;

}
