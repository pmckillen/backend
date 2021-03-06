package com.ceme.crm.controller;

import com.ceme.crm.customExceptions.CustomerNotFoundException;
import com.ceme.crm.entity.CustomerModel;
import com.ceme.crm.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin // allows requests from all domains
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<CustomerModel>(customerService.getCustomerById(id), HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<CustomerModel>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<CustomerModel>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CustomerModel> addCustomer(@RequestBody CustomerModel newCustomer) {
        try {
            CustomerModel addedCustomer = customerService.addCustomer(newCustomer);
            return new ResponseEntity<CustomerModel>(addedCustomer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<CustomerModel>(HttpStatus.BAD_REQUEST);
        }

    }
}