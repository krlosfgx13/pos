package com.project.pos.controller;

import com.project.pos.model.Company;
import com.project.pos.repository.CompanyRepository;
import com.project.pos.serialization.CompanyCategoryDetail;
import com.project.pos.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/pos")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyRepository companyRepository;

    @GetMapping("/companies/category")
    public List<Company> getCompaniesByCategory(){
        //return companyRepository.findAll();
        //return companyService.getCompaniesAndCategories();
        return null;
    }

    @GetMapping("/companies")
    public List<CompanyCategoryDetail> getCompanies(){
        try{
            return companyService.getCompaniesAndCategories();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
        //return companyService.getCompaniesAndCategories();
    }

}
