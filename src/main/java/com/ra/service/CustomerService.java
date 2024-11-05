package com.ra.service;

import com.ra.model.dto.customer.request.CustomerRequestDTO;
import com.ra.model.dto.customer.respone.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDTO> findAll();
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
}
