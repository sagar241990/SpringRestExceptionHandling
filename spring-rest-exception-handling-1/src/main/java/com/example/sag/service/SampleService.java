package com.example.sag.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.sag.data.Customer;
import com.example.sag.data.CustomerDTO;

@Component
public interface SampleService {

	ResponseEntity<Customer> getCustData(String custId);
	ResponseEntity<?> createCust(CustomerDTO custDTO);
	Customer updateCust(CustomerDTO custDTO);
	void deleteCust(CustomerDTO custDto);
}

