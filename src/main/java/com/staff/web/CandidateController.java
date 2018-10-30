package com.staff.web;

import com.staff.api.entity.Candidate;
import com.staff.api.enums.Sort.SortCandidateFields;
import com.staff.api.specification.ISpecification;
import com.staff.dao.specification.EntityRepository.CandidateSpecification;
import com.staff.api.service.ICandidateService;
import com.staff.validator.CandidateFormValidator;
import javax.servlet.http.HttpServletRequest;
import com.staff.api.enums.Sort.SortOrder;
import com.staff.api.enums.Sort.SortUserFields;
import com.staff.dao.sort.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.List;
import java.util.Locale;


@Controller
public class CandidateController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(CandidateController.class);

	@Autowired
	CandidateFormValidator candidateFormValidator;

	@Autowired
	private MessageSource messageSource;

	@InitBinder({"candidateForm"})
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(candidateFormValidator);
	}

	private ICandidateService candidateService;

	@Autowired
	public void setUserService(ICandidateService candidateService) {
		this.candidateService = candidateService;
	}

	// list page
	@RequestMapping(value = "/candidates", method = RequestMethod.GET)
	public String showAllCandidates(  Model model
                                    , @ModelAttribute("candidatesFilter") Candidate candidate
                                    , @RequestParam(value = "columnName", defaultValue = "ID") String columnName
                                    , @RequestParam(value = "order", defaultValue = "ASC") String order
                                    , @RequestParam(value = "page", defaultValue = "1") int page
                                    , @RequestParam(value = "pagesize", defaultValue = "3") int pagesize) {


		ISpecification<Candidate> spec = new CandidateSpecification().GetByNameLike(candidate.getName())
                                        .GetAnd().GetBySurnameLike(candidate.getSurname());
                                        //.GetAnd().GetBySalary(candidate.getSalary());
        List<Candidate> listCandidates = candidateService.FindWithPaging( spec, new Sort().setColumnName(columnName).setSortOrder(order), page, pagesize);
		int total = candidateService.Count(spec);
		model.addAttribute("candidates", listCandidates);
        model.addAttribute("candidatesFilter", candidate);
        //model.addAttribute("filterName", filterName);
        //model.addAttribute("filterSurname", filterSurname);
        //model.addAttribute("filterSalaryFrom", filterSalaryFrom);
        //model.addAttribute("filterSalaryTo", filterSalaryTo);
        //model.addAttribute("filterBirthday", filterBirthday);
        //model.addAttribute("filterCandidateState", filterCandidateState);
        model.addAttribute("columnName",columnName);
        model.addAttribute("currentOrder",order);
        model.addAttribute("order",order.toUpperCase().equals("ASC") ? "DESC" : "ASC");
		model.addAttribute("currentOrder",order.toUpperCase() );
		model.addAttribute("pageCount", Math.ceil ( (double)total/pagesize));
		model.addAttribute("pageNumber",page);
        model.addAttribute("listCandidateState", Candidate.CandidateState.values());
        logger.debug("showAllCandidates() done");
		return "candidates/list";
	}

	// save or update candidate
	@RequestMapping(value = "/candidates", method = RequestMethod.POST)
	public String saveOrUpdateCandidate(@ModelAttribute("candidateForm") @Validated Candidate candidate,
										@ModelAttribute("birthdayAsString") String bd,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes, HttpServletRequest request) {
		logger.debug("saveOrUpdateCandidate() : {}", candidate);
		if (result.hasErrors()) {
			return "candidates/editform";
		} else {
			redirectAttributes.addFlashAttribute("css", "success");
			LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
			Locale locale = localeResolver.resolveLocale(request);
			if (locale == null) {locale = Locale.getDefault();}
			if(candidate.isNew()){
				redirectAttributes.addFlashAttribute("msg", messageSource.getMessage("messages.candidates.added" , null, locale ));
			}else{
				redirectAttributes.addFlashAttribute("msg", messageSource.getMessage("messages.candidates.updated" , null, locale ));
			}
			candidate.setBirthday(bd);
			candidateService.saveOrUpdate(candidate, new CandidateSpecification().GetById(candidate.getForeignKey()));
			return "redirect:/candidates";   ///" + candidate.getId();
		}
	}

	// show add-form
	@RequestMapping(value = "/candidates/add", method = RequestMethod.GET)
	public String showAddForm(Model model) {
		logger.debug("showAddForm()");
		Candidate candidate = new Candidate();
		candidate.setName("Name");
		candidate.setSurname("Surname");
		candidate.setCandidateState(Candidate.CandidateState.ACTIVE);
		model.addAttribute("candidateForm", candidate);
		model.addAttribute("listCandidateState", Candidate.CandidateState.values());
		return "candidates/editform";
	}

	// show update-form
	@RequestMapping(value = "/candidates/{id}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.debug("showUpdateForm() : {}", id);
		Candidate candidate = candidateService.Read(new CandidateSpecification().GetById(id.toString()));
		model.addAttribute("candidateForm", candidate);
		model.addAttribute( "birthdayAsString", candidate.getBirthdayAsString());
		model.addAttribute("listCandidateState", Candidate.CandidateState.values());
		return "candidates/editform";
	}

	// delete user
	@RequestMapping(value = "/candidates/{id}/delete", method = RequestMethod.POST)
	public String deleteCandidate(@PathVariable("id") Integer id, final RedirectAttributes redirectAttributes, HttpServletRequest request) {
		logger.debug("deleteCandidate() : {}", id);
		candidateService.delete(new CandidateSpecification().GetById(id.toString()));
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		Locale locale = localeResolver.resolveLocale(request);
		if (locale == null) {locale = Locale.getDefault();}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", messageSource.getMessage("messages.candidates.deleted" , null, locale ));
		return "redirect:/candidates";
	}

	// show candidate read only
	@RequestMapping(value = "/candidates/{id}", method = RequestMethod.GET)
	public String showCandidate(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {
		logger.debug("showCandidate() id: {}", id);
		Locale l = Locale.getDefault();
		Candidate candidate = candidateService.Read(new CandidateSpecification().GetById(id.toString()));
		if (candidate == null) {
			LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
			Locale locale = localeResolver.resolveLocale(request);
			if (locale == null) {locale = Locale.getDefault();}
			model.addAttribute("css", "danger");
			model.addAttribute("msg", messageSource.getMessage("messages.candidates.not_found" , null, locale ));
		}
		model.addAttribute("candidate", candidate);
		return "candidates/show";
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ModelAndView handleEmptyData(HttpServletRequest request, Exception ex) {
		logger.debug("handleEmptyData()");
		logger.error("Request: {}, error ", request.getRequestURL(), ex);
		ModelAndView model = new ModelAndView();
		model.setViewName("candidates/show");
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		Locale locale = localeResolver.resolveLocale(request);
		if (locale == null) {locale = Locale.getDefault();}
		model.addObject("msg", messageSource.getMessage("messages.candidates.not_found" , null, locale ));
		return model;
	}
}