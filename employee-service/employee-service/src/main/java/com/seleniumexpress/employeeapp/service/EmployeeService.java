package com.seleniumexpress.employeeapp.service;

import com.seleniumexpress.employeeapp.entity.Employee;
import com.seleniumexpress.employeeapp.repo.EmployeeRepo;
import com.seleniumexpress.employeeapp.response.AddressResponse;
import com.seleniumexpress.employeeapp.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo EmployeeRepo;
    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
    private RestTemplate restTemplate;

//    @Value("${addressservice.base.url}") // if you use the addressbaseurl in the constructor it will be null, you need to add it to the constructor like this
//    private String adressbaseURL; // @Value("${addressservice.base.url}") String adressbaseURL

    public EmployeeService(@Value("${addressservice.base.url}") String adressbaseURL, RestTemplateBuilder builder){
        this.restTemplate = builder
                            .rootUri(adressbaseURL)
                            .build();
    }

    public EmployeeResponse getEmployeeById(int id){

        var employee = EmployeeRepo.findById(id).get();

        var employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        var addressResponse = restTemplate.getForObject("/address/{id}", AddressResponse.class, id);
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }
}
