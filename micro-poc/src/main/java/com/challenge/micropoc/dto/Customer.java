package com.challenge.micropoc.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
	
	 @Id
	 @Column(name = "document_id")
	 private String documentId;
	 @Column(name = "name")
	 private String name;
	 @Column(name = "age")
	 private Integer age;
	 @Column(name = "registration_date")
	 private Date registrationDate;
	 @Column(name = "last_update")
	 private Date lastUpdate;
	 @Column(name = "zipcode")
	 private String zipcode;
	 @Column(name = "number")
	 private Integer number;
}

