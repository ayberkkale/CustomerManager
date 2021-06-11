package com.ttech.customermanager.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.ttech.customermanager.customer.Customer;


@Service
public class CustomerStorage {
	
	private Map<Long,Customer> customerMap = new ConcurrentHashMap<>();
	
	
	public void add(Customer customer) {
		customerMap.put(customer.getCustomerID(),customer);
	}

	public void delete(Long customerID) {
		customerMap.remove(customerID);
	}
	
	public Customer get(Long customerID) {
		return customerMap.get(customerID);	
	}
	
}
