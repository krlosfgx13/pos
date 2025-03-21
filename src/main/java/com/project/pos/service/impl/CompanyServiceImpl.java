package com.project.pos.service.impl;

import com.project.pos.model.Company;
import com.project.pos.model.CompanyCategory;
import com.project.pos.repository.CompanyCategoryRepository;
import com.project.pos.repository.CompanyRepository;
import com.project.pos.serialization.CompanyCategoryDetail;
import com.project.pos.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final JdbcTemplate jdbcTemplate;
    private final CompanyCategoryRepository companyCategoryRepository;

    @Override
    public Company getCompanyByName(String companyName) {
        return companyRepository.findByName(companyName);
    }

    @Override
    public List<CompanyCategoryDetail> getCompaniesAndCategories() {
        List<CompanyCategoryDetail> companiesByCategory = new ArrayList<>();
        List<CompanyCategory> categories = companyCategoryRepository.findAll();

//        example with map
//        if (!categories.isEmpty()) {
//            categories.stream()
//                    .map(category -> {
//                        List<Company> companies = companyRepository.findByCompanyByCategoryId(category.getId());
//                        return new CompanyByCategory(category.getId(), category.getName(), companies);
//                    })
//                    .forEach(companiesByCategory::add);
//        }

        if(!categories.isEmpty()){
         for(CompanyCategory category : categories){
             CompanyCategoryDetail companyCategoryDetail = new CompanyCategoryDetail();
             List<Company> companies = companyRepository.findByCompanyByCategoryId(category.getId());
             companyCategoryDetail.setCompanyCategoryId(category.getId());
             companyCategoryDetail.setCompanyCategoryName(category.getName());
             companyCategoryDetail.setListOfCompanies(companies);
             companiesByCategory.add(companyCategoryDetail);
         }
        }
        return companiesByCategory;
    }

//    @Override
//    public List<Company> getCompaniesAndCategories() {
//        String selectStatement = "select c.company_id, c.company_name, cc.company_category_name \n" +
//                "from company c \n" +
//                "join company_category cc on c.company_category_id = cc.company_category_id";
//
//        return jdbcTemplate.query(selectStatement, new BeanPropertyRowMapper<>(Object.class));
//    }
}
