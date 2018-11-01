package com.staff.web;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.staff.api.entity.Interview;
import com.staff.api.service.IInterviewService;
import com.staff.dao.sort.Sort;
import com.staff.dao.specification.EntitySpecification.InterviewSpecification;
import com.staff.validator.InterviewFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class InterviewController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(InterviewController.class);

    @Autowired
    InterviewFormValidator interviewFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(interviewFormValidator);
    }

    private IInterviewService interviewService;

    @Autowired
    public void setInterviewService(IInterviewService interviewService) {
        this.interviewService = interviewService;
    }


    // list page
    @RequestMapping(value = "/interviews", method = RequestMethod.GET)
    public String showAllInterviews(Model model, @ModelAttribute("interviewForm")  Interview interview,
                               @RequestParam(value = "columnName", defaultValue ="ID") String columnName,
                               @RequestParam(value = "order", defaultValue = "ASC") String order,
                               @RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "pagesize", defaultValue = "10") int pagesize) {

        logger.debug("showAllInterviews()");

        List<Interview> Interviews = interviewService.FindWithPaging
                (new InterviewSpecification()
                        .GetById(interview.getId())
                        .GetAnd().GetByIdVacancy(interview.getIdVacancy())
                        .GetAnd().GetByIdCandidate(interview.getIdCandidate())
                        //.GetAnd().GetByFactDateLike(interview.getFactDate().toString())
                        //.GetAnd().GetByPlanDateLike(interview.getPlanDate().toString())
                        ,
                new Sort().setColumnName(columnName).setSortOrder(order), page, pagesize
                );

        int interviewCount = interviewService.Count(new InterviewSpecification());
        int pageCount = interviewCount/pagesize +1;

        model.addAttribute("interviews", Interviews);
        model.addAttribute("interviewForm", interview);
        model.addAttribute("columnName", columnName);
        model.addAttribute("currentOrder", order);
        model.addAttribute("order", order.toUpperCase().equals("ASC") ? "DESC" : "ASC");
        model.addAttribute("pageNumber", page);
        model.addAttribute("pageCount", pageCount);
        return "interviews/list";

    }

    // save or update
    @RequestMapping(value = "/interviews", method = RequestMethod.POST)
    public String saveOrUpdateInterview(@ModelAttribute("interviewForm") @Validated Interview interview,
                                   BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

        logger.debug("saveOrUpdateInterview() : {}", interview);

        if (result.hasErrors()) {
            return "interviews/interviewForm";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(interview.isNew()){
                redirectAttributes.addFlashAttribute("msg", "Interview added successfully!");
            }else{
                redirectAttributes.addFlashAttribute("msg", "Interview updated successfully!");
            }

            interviewService.saveOrUpdate(interview, new InterviewSpecification().GetById(interview.getForeignKeyInt()));

            //interviewService.saveOrUpdate(interview);

            // POST/REDIRECT/GET
            return "redirect:/interviews"; //+ interview.getId();

            // POST/FORWARD/GET
            // return "user/list";

        }

    }

    // show add interview form
    @RequestMapping(value = "/interviews/add", method = RequestMethod.GET)
    public String showAddInterviewForm(Model model) {

        logger.debug("showAddInterviewForm()");

        Interview interview = new Interview();

        // set default value
        //interview.setIdCandidate(100);
        //interview.setIdVacancy(201);

        model.addAttribute("interviewForm", interview);

        return "interviews/interviewform";
    }

    // show update form
    @RequestMapping(value = "/interviews/{id}/update", method = RequestMethod.GET)
    public String showUpdateInterviewForm(@PathVariable("id") int id, Model model) {
        logger.debug("showUpdateInterviewForm() : {}", id);

        //Interview interview = interviewService.Find();
        //model.addAttribute("interviewForm", interview);

        Interview interview = interviewService.Read(new InterviewSpecification().GetById(id));
        List<Interview> listOfInterviewsobj =interviewService.Find(new InterviewSpecification());
        model.addAttribute("listOfInterviews", listOfInterviewsobj);
        model.addAttribute("interviewForm", interview);

        return "interviews/interviewForm";
    }

    // delete interview
    @RequestMapping(value = "/interviews/{id}/delete", method = RequestMethod.POST)
    public String deleteInterview(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        logger.debug("deleteInterview() : {}", id);

        //interviewService.delete(id);
        //redirectAttributes.addFlashAttribute("css", "success");
        //redirectAttributes.addFlashAttribute("msg", "Interview is deleted!");
        interviewService.delete(new InterviewSpecification().GetById(id));

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Vacancy is deleted!");

        return "redirect:/interviews";
    }

    // show
    @RequestMapping(value = "/interviews/{id}", method = RequestMethod.GET)
    public String showInterview(@PathVariable("id") int id, Model model) {

        logger.debug("showInterview() id: {}", id);

        //Interview interview = interviewService.findById(id);
        Interview interview = interviewService.Read(new InterviewSpecification().GetById(id) );

        if (interview == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Interview not found");
        }

        model.addAttribute("interview", interview);
        return "interviews/show";

    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex) {

        logger.debug("handleEmptyData()");
        logger.error("Request: {}, error ", req.getRequestURL(), ex);

        ModelAndView model = new ModelAndView();
        model.setViewName("interviews/show");
        model.addObject("msg", "interview not found");

        return model;

    }

}
