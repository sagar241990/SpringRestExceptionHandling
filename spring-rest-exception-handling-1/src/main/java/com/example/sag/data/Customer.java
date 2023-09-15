package com.example.sag.data;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUST_SAG_TBL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	
	String custName;
	String emailId;
	String address;
	String phoneNum;
	int age;

	public Customer(String custName, String custId) {
		super();
		this.custName = custName;
	}

}
