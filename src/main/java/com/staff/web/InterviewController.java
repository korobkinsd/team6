//package com.staff.web;
//
//
//import java.util.List;
//import com.staff.api.entity.Interview;
//import com.staff.api.service.IInterviewService;
//import com.staff.dao.sort.Sort;
//import com.staff.dao.specification.EntitySpecification.InterviewSpecification;
//import com.staff.exception.ResourceNotFoundException;
//import com.staff.validator.InterviewFormValidator;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//
//
//@RestController
//public class InterviewController  {
//
//    private final Logger logger = LoggerFactory.getLogger(InterviewController.class);
//
//    @Autowired
//    InterviewFormValidator interviewFormValidator;
//
//    private IInterviewService interviewService;
//
//    @Autowired
//    public void setInterviewService(IInterviewService interviewService) {
//        this.interviewService = interviewService;
//    }
//
//
//    // list page
//    @RequestMapping(value = "/interviews", method = RequestMethod.GET)
//    public  List<Interview> showAllInterviews(Model model, @ModelAttribute("interviewForm")  Interview interview,
//                                @RequestParam(value = "columnName", defaultValue ="ID") String columnName,
//                                @RequestParam(value = "order", defaultValue = "ASC") String order,
//                                @RequestParam(value = "page", defaultValue = "1") int page,
//                                @RequestParam(value = "pagesize", defaultValue = "10") int pagesize) {
//
//        logger.debug("showAllInterviews()");
//
//           List<Interview> listInterview  = interviewService.FindWithPaging
//                (new InterviewSpecification()
//                        //.GetById(interview.getId().toString())
//                        .GetAnd().GetByIdVacancy(interview.getIdVacancy())
//                        .GetAnd().GetByIdCandidate(interview.getIdCandidate())
//                        //.GetAnd().GetByFactDateLike(interview.getFactDate().toString())
//                        //.GetAnd().GetByPlanDateLike(interview.getPlanDate().toString())
//                        ,
//                new Sort().setColumnName(columnName).setSortOrder(order), page, pagesize
//                );
//
//        return listInterview;
//    }
//
//    // save or update
//    @RequestMapping(value = "/interviews", method = RequestMethod.POST)
//    public Interview saveOrUpdateInterview( @Validated @RequestBody Interview interview,
//                                   BindingResult result, Model model) {
//
//        logger.debug("saveOrUpdateInterview() : {}", interview);
//
//        if (result.hasErrors()) {
//            throw new ResourceNotFoundException();
//        } else {
//            interviewService.saveOrUpdate(interview,new InterviewSpecification().GetById(interview.getForeignKeyInt()));
//            return interview;
//        }
//
//    }
//
//    // save or update interview
//    @RequestMapping(value = "/interviews/{id}", method = RequestMethod.POST)
//    public Interview UpdateInterview(@PathVariable("id") int id, @Validated @RequestBody Interview interview,
//                                 BindingResult result, Model model) {
//
//        logger.debug("saveOrUpdateVInterview() : {}", interview);
//
//        if (null ==  interviewService.Read(new InterviewSpecification().GetById(id) )) {
//            throw new ResourceNotFoundException();
//        }
//        if (result.hasErrors()) {
//            throw new ResourceNotFoundException();
//        } else {
//
//            interviewService.saveOrUpdate(interview,new InterviewSpecification().GetById(id));
//
//            return interview;
//
//        }
//
//    }
//
//    // show interview
//    @RequestMapping(value = "/interviews/{id}", method = RequestMethod.GET)
//    public Interview showInterview(@PathVariable("id") int id, Model model) {
//
//        logger.debug("showInterview() id: {}", id);
//
//        Interview interview = interviewService.Read(new InterviewSpecification().GetById(id) );
//        if (interview == null) {
//            throw new ResourceNotFoundException();
//        }
//        return interview;
//    }
//
//
//    // delete interview
//    @RequestMapping(value = "/interviews/{id}", method = RequestMethod.DELETE)
//    public void deleteInterview(@PathVariable("id") int id) {
//
//        logger.debug("deleteInterview() : {}", id);
//        Interview interview = interviewService.Read(new InterviewSpecification().GetById(id) );
//        if (interview == null) {
//            throw new ResourceNotFoundException();
//        }
//        interviewService.delete(new InterviewSpecification().GetById(id));
//    }
//
//
//
//}
