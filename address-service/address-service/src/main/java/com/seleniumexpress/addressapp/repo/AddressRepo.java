package com.seleniumexpress.addressapp.repo;

import com.seleniumexpress.addressapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepo extends JpaRepository<Address, Integer> {

    @Query(nativeQuery = true, value = "SELECT ea.id, ea.lane1, ea.lane2, ea.zip, ea.state FROM seleniumexpressnew.address ea JOIN seleniumexpressnew.employee e on e.id=ea.employee_id WHERE ea.employee_id=:employeeId")
    Address findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
