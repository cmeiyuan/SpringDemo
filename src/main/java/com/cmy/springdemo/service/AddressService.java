package com.cmy.springdemo.service;

import com.cmy.springdemo.dataobject.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressService {

    Address save(Address address);

    void delete(Integer id);

    Page<Address> findAll(Pageable pageable);
}
