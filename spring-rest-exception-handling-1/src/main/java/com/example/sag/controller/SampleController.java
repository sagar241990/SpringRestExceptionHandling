package com.example.sag.controller;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sag.data.Customer;
import com.example.sag.data.CustomerDTO;
import com.example.sag.data.CustomerRepository;
import com.example.sag.service.SampleService;

@RestController
@RequestMapping("/customers")
public class SampleController {

	private SampleService sampleService;

	@Autowired
	private CustomerRepository repository;

//	@PostConstruct
//	public void initDB() {
//		List<Customer> customers = IntStream.rangeClosed(1, 200).mapToObj(i -> new Customer(
//				i,
//				"custoName" + new Random().nextInt(100), 
//				"cc" + new Random().nextInt(50000) + "@gmail.com",
//				"addr" + new Random().nextInt(500) + "add2",
//				"MobNum"+ new Random().nextInt(10000) ,
//				new Random().nextInt(30)
//				))
//				.collect(Collectors.toList());
//		repository.saveAll(customers);
//	}

	public SampleController() {
		super();
	}

	@Autowired
	public SampleController(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@GetMapping("/{custId}")
	public ResponseEntity<Customer> displayName(@PathVariable String custId) {
		return sampleService.getCustData(custId);

	}

	
	@PostMapping("/create")
	public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerDTO custDTO){
		
		return sampleService.createCust(custDTO);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDTO custDTO){
		Customer cust = sampleService.updateCust(custDTO);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteCustomer(@RequestBody CustomerDTO custDto){
		sampleService.deleteCust(custDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
//	@ExceptionHandler(CustomExceptionForSample.class)
//	public ResponseEntity<ErrorResponse> handleCustomException(){
//		ErrorResponse errR = new ErrorResponse("Not Sagar", "1234");
//		//ResponseEntity<ErrorResponse> errResp = new ResponseEntity<ErrorResponse>(errR,HttpStatus.METHOD_FAILURE);
//		return ResponseEntity.ok(errR);
//	}

}
