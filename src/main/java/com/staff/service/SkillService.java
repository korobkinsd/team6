package com.staff.service;

import com.staff.api.dao.ISkillDao;
import com.staff.api.entity.Skill;
import com.staff.api.service.ISkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("skillService")
public class SkillService implements ISkillService {

    private ISkillDao SkillDao;

    @Override
    public Skill findById(Integer id) {
        return SkillDao.findById(id);
    }

    @Override
    public List<Skill> findAll() {
        return SkillDao.findAll();
    }


}
