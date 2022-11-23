package com.challenge.micropoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.challenge.micropoc.dto.AddressCustomer;

public interface AddressCustomerRepository extends JpaRepository<AddressCustomer, String> {
	
    @Query(value = "INSERT INTO ADDRESS_CUSTOMER (ZIPCODE,NUMBER) VALUES (:zipCode,:documentId)", 
            nativeQuery = true)
    public void insertAddresCustomer(@Param("zipCode") String zipCode,@Param("documentId") String documentId );

}
