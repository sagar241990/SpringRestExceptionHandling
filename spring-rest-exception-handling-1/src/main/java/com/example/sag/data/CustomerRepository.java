package com.example.sag.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Optional<Customer>> findByCustName(String custId);

}
