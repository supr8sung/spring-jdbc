package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.respository.CustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CustomerRespository customerRespository;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllEmpoyee() {
        List<Customer> customers = customerRespository.findAll();
        customers.stream().map(Customer::toString).forEach(System.out::println);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


}
