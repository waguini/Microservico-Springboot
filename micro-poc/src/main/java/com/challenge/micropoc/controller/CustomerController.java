package com.challenge.micropoc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.challenge.micropoc.dto.Customer;
import com.challenge.micropoc.repository.CustomerRepository;

@Controller
@RequestMapping(path="/customer") 
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	

	
	@PostMapping(path="/addcustomer")
	public @ResponseBody String saveCustomer(@RequestParam String documentId,
			@RequestParam String name,
			@RequestParam Integer age,
			@RequestParam Date registrationDate,
			@RequestParam Date lastUpdate,
			@RequestParam String zipcode,
			@RequestParam Integer number) {
		Customer customer = new Customer();
		
		customer.setDocumentId(documentId);
		customer.setName(name);
		customer.setAge(age);
		customer.setRegistrationDate(registrationDate);
		customer.setZipcode(zipcode);
		
		
		return "Customer added";
		
	}
	
	@GetMapping(path="/findall")
	public ResponseEntity<List<Customer>> findAllCustomers() {
		return new ResponseEntity<List<Customer>> (customerRepository.findallCustomers(), HttpStatus.OK);

		
	}
	
	
	
	@PostMapping(path="/findbyid")
	public ResponseEntity<Customer> findbyId(@RequestParam String documentId) {
		return new ResponseEntity<Customer> (customerRepository.findCustomerById(documentId), HttpStatus.OK);

	}
	
	
	@PostMapping(path = "/delete")
	public ResponseEntity<String> deleteCustomer(@RequestParam String documentId) {
		String deletado = "Customer deletado com sucesso";

		customerRepository.deleteCustomer(documentId);
		return new ResponseEntity<String>(deletado, HttpStatus.OK);
	}
}