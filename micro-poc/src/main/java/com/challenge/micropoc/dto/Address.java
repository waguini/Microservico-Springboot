package com.challenge.micropoc.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "zipcode")
	private String zipCode;
	@Column(name = "number")
	private Integer number;

}
