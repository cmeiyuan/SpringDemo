package com.cmy.springdemo.repository;

import com.cmy.springdemo.dataobject.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {


}
