
package com.staff.service;

import com.staff.api.dao.IVacancyDao;

import com.staff.api.entity.Vacancy;

import com.staff.api.service.IVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("vacancyService")
public class VacancyService  extends CrudService<Vacancy> implements IVacancyService {

    IVacancyDao vacancyDao;

    @Autowired
    public void setVacancyDao(IVacancyDao vacancyDao) {
        this.dao = vacancyDao;
    }



}

