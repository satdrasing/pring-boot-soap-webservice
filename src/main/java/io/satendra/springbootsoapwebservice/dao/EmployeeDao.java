package io.satendra.springbootsoapwebservice.dao;

import io.satendra.springbootsoapwebservice.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EmployeeDao extends CrudRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findAll();
}
