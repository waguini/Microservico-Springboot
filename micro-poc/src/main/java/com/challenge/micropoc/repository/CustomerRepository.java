package com.challenge.micropoc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.challenge.micropoc.dto.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{
	
    @Query(value = "SELECT *" +
            " FROM CUSTOMER C, ADDRESS A "
    		+ " WHERE C.ZIPCODE = A.ZIPCODE "
    		+ " AND C.ZIPCODE = :zipcode",
            nativeQuery = true)
    List<Customer> findByCustomersByZipCode(@Param("zipcode") String zipcode);
    
    
    @Query(value = "SELECT *" +
            " FROM CUSTOMER ",
            nativeQuery = true)
    public List<Customer> findallCustomers();
    
    @Query(value = "DELETE  FROM CUSTOMER WHERE DOCUMENT_ID = :documentId", 
            nativeQuery = true)
    public void deleteCustomer(@Param("documentId") String documentId);
    
    @Query(value = "SELECT * FROM CUSTOMER WHERE DOCUMENT_ID = :documentId",
            nativeQuery = true)
    public Customer findCustomerById(@Param("documentId") String documentId);
    
    
    @Query(value = "INSERT INTO CUSTOMER (DOCUMENT_ID,NAME,AGE,REGISTRATION_DATE,LAST_UPDATE,ZIPCODE,NUMBER) "
    		+ " VALUES "
    		+ " (:documentId,:name,:age,:registrationDate,:lastUpdate,:zipcode,:number) ",
            nativeQuery = true)
    public void insertCustomer(@Param("documentId") String documentId,
    							@Param("name") String name,
    							@Param("age")Integer age,
    							@Param("registrationDate") Date registrationDate,
    							@Param("lastUpdate")Date lastUpdate,
    							@Param("zipcode") String zipcode,
    							@Param("number") String number);

}
