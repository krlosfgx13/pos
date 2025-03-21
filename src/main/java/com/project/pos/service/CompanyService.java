package com.project.pos.service;

import com.project.pos.model.Company;
import com.project.pos.serialization.CompanyCategoryDetail;

import java.util.List;

public interface CompanyService {
    Company getCompanyByName(String companyName);
    List<CompanyCategoryDetail> getCompaniesAndCategories();
}
