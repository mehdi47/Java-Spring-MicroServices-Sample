package com.seleniumexpress.addressapp.service;

import com.seleniumexpress.addressapp.repo.AddressRepo;
import com.seleniumexpress.addressapp.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressRepo addressRepo;

    public AddressResponse getAddressByEmployeeId(int employeeId){

        var address = addressRepo.findAddressByEmployeeId(employeeId);

        var addressResponse = modelMapper.map(address, AddressResponse.class);

        return addressResponse;
    }

}
