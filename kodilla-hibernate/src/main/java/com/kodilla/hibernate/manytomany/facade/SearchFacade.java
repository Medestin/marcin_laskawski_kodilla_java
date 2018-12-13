package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public SearchFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompaniesContaining(String characters) {
        if (characters != null) {
            return companyDao.retrieveCompaniesContainingCharacters(characters);
        } else {
            throw new NullPointerException("Null input!");
        }
    }

    public List<Employee> findEmployeesContaining(String characters){
        if(characters != null){
            return employeeDao.retrieveEmployessContainingCharacters(characters);
        } else {
            throw new NullPointerException("Null input!");
        }
    }
}
