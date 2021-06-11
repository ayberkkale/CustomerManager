package com.ttech.customermanager.rest;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttech.customermanager.customer.Customer;
import com.ttech.customermanager.manager.CustomerManager;


@RestController
@RequestMapping("api/v2/customer")
@Validated
public class CustomerRestController {
	
	@Autowired
	CustomerManager cm;
	
	@PutMapping("/add")
	public String add(@Validated @RequestBody final Customer customer)
	{
		return cm.add(customer);
	}
	
	
	@DeleteMapping("/delete")
	public String delete(@NotNull @RequestParam("customerid") final long customerID )
	{
		return cm.delete(customerID);
	}
	
	@GetMapping("/get")
	public Customer get(@NotNull @RequestParam("customerid") final long customerID )
	{
		return cm.get(customerID);
	}
}
