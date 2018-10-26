package com.staff.service;

import com.staff.api.dao.IInterviewDao;
import com.staff.api.entity.Interview;
import com.staff.api.service.IInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("interviewService")
public class InterviewService extends CrudService<Interview> implements IInterviewService {

    @Autowired
    public void setInterviewDao(IInterviewDao interviewDao) {
        this.dao = interviewDao;
    }

}