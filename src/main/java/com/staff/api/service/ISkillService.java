package com.staff.api.service;

import com.staff.api.entity.Skill;

import java.util.List;

public interface ISkillService {

    Skill findById(Integer id);

    List<Skill> findAll();
}
