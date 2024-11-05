package com.ra.service;

import com.ra.model.dto.customer.request.CustomerRequestDTO;
import com.ra.model.dto.customer.respone.CustomerResponseDTO;
import com.ra.model.entity.customer.Customer;
import com.ra.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository  customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public List<CustomerResponseDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> responseDTOS;
        responseDTOS= customers.stream().map(customer ->
            CustomerResponseDTO.builder()
                    .id(customer.getId())
                    .fullName(customer.getFullName())
                    .email(customer.getEmail())
                    .birthday(customer.getBirthday()).build()
        ).toList();
        return responseDTOS;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer = Customer.builder()
                .fullName(customerRequestDTO.getFullName())
                .email(customerRequestDTO.getEmail())
                .password(customerRequestDTO.getPassword())
                .birthday(customerRequestDTO.getBirthday())
                .build();
        Customer customerNew = customerRepository.save(customer);
        return CustomerResponseDTO.builder()
                .id(customerNew.getId())
                .fullName(customerNew.getFullName())
                .email(customerNew.getEmail())
                .birthday(customerNew.getBirthday()).build();
    }
}
