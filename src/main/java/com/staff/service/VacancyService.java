package com.staff.service;

import com.staff.api.dao.IUserDao;
import com.staff.api.dao.IVacancyDao;

import com.staff.api.entity.User;
import com.staff.api.entity.Vacancy;

import com.staff.api.service.IVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("vacancyService")
public class VacancyService  extends CrudService<Vacancy> implements IVacancyService {

    IVacancyDao vacancyDao;

    @Autowired
    public void setVacancyDao(IVacancyDao vacancyDao) {
        this.dao = vacancyDao;
    }



}
