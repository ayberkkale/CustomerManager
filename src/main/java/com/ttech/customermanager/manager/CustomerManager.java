package com.ttech.customermanager.manager;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ttech.customermanager.customer.Customer;
import com.ttech.customermanager.storage.CustomerStorage;

@Service
public class CustomerManager {
	
	@Autowired
	CustomerStorage cs;
	
	public String  add(@Validated @RequestBody final Customer customer) {
		cs.add(customer);
		return "SUCCESS";
	}
	
	public String delete(@NotNull @RequestParam("customerid") final long customerID) {
		cs.delete(customerID);
		return "SUCCESS";
	}
	
	public Customer get(@NotNull @RequestParam("customerid") final long customerID) {
		return cs.get(customerID);
	}
	

}
