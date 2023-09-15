package com.example.sag.data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

	private int id;

	@NotEmpty(message = "give a trendy customer name")
	String custName;
	
	@Email(message ="Email address is not a valid one !!")
	String emailId;
	
	
	String address;
	
	String phoneNum;
	
	@PositiveOrZero
	@Max(message ="too big age", value = 100)
	@Min(message ="too small age", value = 18)
	int age;
}
