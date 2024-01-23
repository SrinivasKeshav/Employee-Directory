package com.example.thymeleafdemo.service;

import com.example.thymeleafdemo.dao.EmployeeRepository;
import com.example.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return theEmployee;
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
