
package com.bridgelabz.employeepayrollapp.repositories;

import com.bridgelabz.employeepayrollapp.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Repository used to store data in a Database
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}