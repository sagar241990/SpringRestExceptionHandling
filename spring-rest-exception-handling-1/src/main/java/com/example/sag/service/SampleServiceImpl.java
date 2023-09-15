package com.example.sag.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.sag.data.Customer;
import com.example.sag.data.CustomerDTO;
import com.example.sag.data.CustomerRepository;
import com.example.sag.exceptions.CustException;
import com.example.sag.exceptions.ResourceNotFoundException;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	CustomerRepository custRepo;

	public Customer convertToCustomer(CustomerDTO custDTO) {
		Customer cus = new Customer();
		cus.setAddress(custDTO.getAddress());
		cus.setAge(custDTO.getAge());
		cus.setCustName(custDTO.getCustName());
		cus.setEmailId(custDTO.getEmailId());
		cus.setId(custDTO.getId());
		cus.setPhoneNum(custDTO.getPhoneNum());
		return cus;
	}

	public CustomerDTO convertToCustomerDTO(Customer custo) {
		CustomerDTO cus = new CustomerDTO();
		cus.setAddress(custo.getAddress());
		cus.setAge(custo.getAge());
		cus.setCustName(custo.getCustName());
		cus.setEmailId(custo.getEmailId());
		cus.setId(custo.getId());
		cus.setPhoneNum(custo.getPhoneNum());
		return cus;
	}

	@Override
	public ResponseEntity<Customer> getCustData(String custId) throws CustException, ResourceNotFoundException {
		ResponseEntity<Customer> resp = new ResponseEntity<>(HttpStatus.OK);
		//List<Optional<Customer>> custOptList = custRepo.findByCustName(custId).stream().findFirst().orElseThrow(() -> new ResourceNotFoundException("Unable to find this customer... of Name ==> "+ custID));
		Optional<Customer> cust = custRepo.findByCustName(custId)
														.stream().findFirst()
														.orElseThrow(
																() -> new ResourceNotFoundException
																	("Unable to find this customer... of Name ==> "+ custId));

		if (StringUtils.isNotBlank(custId)) {
			return new ResponseEntity<Customer>(cust.get(), HttpStatus.OK);
		} else if (custId.equals("saha")) {
			throw new CustException("------ On No its SAha ----------");
		} else {
			throw new ResourceNotFoundException();
		}
	}

	@Override
	public ResponseEntity<?> createCust(CustomerDTO custDTO) {
		Customer customer = convertToCustomer(custDTO);
		Customer savedCustomer = custRepo.save(customer);
		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}

	@Override
	public Customer updateCust(CustomerDTO custDTO) throws ResourceNotFoundException {

		Customer cus = custRepo.findById(custDTO.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Unable to fin this customer with ID :" + custDTO.getId()));
		cus.setAddress(custDTO.getAddress());
		cus.setAge(custDTO.getAge());
		cus.setCustName(custDTO.getCustName());
		cus.setEmailId(custDTO.getEmailId());
		cus.setPhoneNum(custDTO.getPhoneNum());
		
		Customer cust = custRepo.save(cus);
		return cust;
	}

	@Override
	public void deleteCust(CustomerDTO custDTO) {

		Customer cus = custRepo.findById(custDTO.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Unable to fin this customer with ID :" + custDTO.getId()));
		custRepo.delete(cus);
	}
	
	

}
