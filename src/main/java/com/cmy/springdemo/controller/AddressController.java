package com.cmy.springdemo.controller;

import com.cmy.springdemo.dataobject.Address;
import com.cmy.springdemo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping("/add")
    public Address add(@RequestParam("name") String name ,
                       @RequestParam("phone") String phone ,
                       @RequestParam("address") String address){
        Address address1 = new Address();
        address1.setName(name);
        address1.setPhone(phone);
        address1.setAddress(address);
        return addressService.save(address1);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("id") Integer id){
    addressService.delete(id);
    }

    @RequestMapping("/update")
    public Address update(@RequestParam("id")  Integer id ,
                          @RequestParam("name") String name,
                          @RequestParam("phone") String phone,
                          @RequestParam("address") String address){
        Address address1 = new Address();
        address1.setId(id);
        address1.setName(name);
        address1.setPhone(phone);
        address1.setAddress(address);
        return addressService.save(address1);
    }

    public List<Address> query(@RequestParam(value = "page" , defaultValue = "0") int page,
                      @RequestParam(value = "size" , defaultValue = "10") int size){
        Pageable pageable = new PageRequest(page,size);
        Page<Address> addressPage = addressService.findAll(pageable);
        return addressPage.getContent();
    }
}
