package com.ra.controller;

import com.ra.model.dto.customer.request.CustomerRequestDTO;
import com.ra.model.dto.customer.respone.CustomerResponseDTO;
import com.ra.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> findAll(){
        List<CustomerResponseDTO> responseDTOS = customerService.findAll();
        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> save(@Valid @RequestBody CustomerRequestDTO customerRequestDTO){
        CustomerResponseDTO customerResponseDTO = customerService.save(customerRequestDTO);
        return new ResponseEntity<>(customerResponseDTO,HttpStatus.CREATED);
    }
}
