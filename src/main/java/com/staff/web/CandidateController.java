//package com.staff.web;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.staff.api.dao.ICandidateDao;
//import com.staff.api.entity.Candidate;
//import com.staff.api.entity.CandidateFilter;
//import com.staff.api.specification.ISpecification;
//import com.staff.dao.specification.EntitySpecification.CandidateSpecification;
//import com.staff.api.service.ICandidateService;
//import com.staff.exception.ResourceNotFoundException;
//import com.staff.validator.CandidateFormValidator;
//import javax.validation.Valid;
//import com.staff.dao.sort.Sort;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.BindException;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.util.List;
//
//@RestController
//@RequestMapping("/candidates")
//public class CandidateController extends BaseController {
//
//	private final Logger logger = LoggerFactory.getLogger(CandidateController.class);
//
//	@Autowired
//	CandidateFormValidator candidateFormValidator;
//
//	@Autowired
//	private ICandidateDao candidateDao;
//
//	@InitBinder({"candidateForm"})
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(candidateFormValidator);
//	}
//
//	private ICandidateService candidateService;
//
//	@Autowired
//	public void setUserService(ICandidateService candidateService) {
//		this.candidateService = candidateService;
//	}
//
//	// list of candidates
//    // http://localhost:8080/candidates?filter={"salaryFrom": "100", "salaryTo": "1000"}&columnName=NAME&order=DESC&page=1
//	@RequestMapping(method = RequestMethod.GET)
//	public @ResponseBody List<Candidate> showAllCandidates(
//                                      @RequestParam(value = "filter") String filter
//                                    , @RequestParam(value = "columnName", defaultValue = "ID") String columnName
//                                    , @RequestParam(value = "order", defaultValue = "ASC") String order
//                                    , @RequestParam(value = "page", defaultValue = "1") int page
//                                    , @RequestParam(value = "pagesize", defaultValue = "3") int pagesize) throws IOException {
//
//		ObjectMapper mapper = new ObjectMapper();
//		CandidateFilter candidateFilter = mapper.readValue(filter, CandidateFilter.class);
//
//		ISpecification<Candidate> spec = new CandidateSpecification().GetByNameLike(candidateFilter.getName())
//                                        .GetAnd().GetBySurnameLike(candidateFilter.getSurname());
//                                        //.GetAnd().GetBySalary( candidateFilter.getSalaryFrom(), candidateFilter.getSalaryTo() )
//										//.GetAnd().GetByBirthday( candidateFilter.getBirthdayFromAsString(), candidateFilter.getBirthdayToAsString() );
//
//        List<Candidate> listCandidates = candidateService.FindWithPaging( spec, new Sort().setColumnName(columnName).setSortOrder(order), page, pagesize);
//		//int total = candidateService.Count(spec);
//        logger.debug("showAllCandidates() done");
//		return listCandidates;
//	}
//
//	// show candidate read only
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public @ResponseBody Candidate showCandidate(@PathVariable("id") Integer id) {
//		logger.debug("showCandidate() id: {}", id);
//		Candidate candidate = candidateService.Read(new CandidateSpecification().GetById(id.toString()));
//		if (candidate != null){
//			return candidate;
//		} else {
//			throw new ResourceNotFoundException();
//		}
//	}
//
//	@ResponseStatus(HttpStatus.CREATED)
//	@RequestMapping(method = RequestMethod.PUT)
//	public @ResponseBody Candidate saveCandidate(@Valid @RequestBody Candidate candidate,
//									   BindingResult result) throws BindException {
//
//		logger.debug("saveCandidate() : {}", candidate);
//		if (result.hasErrors()) {
//			throw new BindException(result);
//		} else {
//			candidateService.saveOrUpdate(candidate, new CandidateSpecification().GetById(candidate.getForeignKey()));
//			return candidate;
//		}
//	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void updateCandidate(@PathVariable("id") Integer id, @Valid @RequestBody Candidate candidate,
//						   BindingResult result) throws BindException{
//
//		logger.debug("updateCandidate() : {}", candidate);
//		if (result.hasErrors()) {
//			throw new BindException(result);
//		} else {
//
//			Candidate updCandidate = candidateDao.Read(new CandidateSpecification().GetById(id.toString()));
//			if (updCandidate== null) {
//				throw new ResourceNotFoundException();
//			} else {
//				updCandidate.setName(candidate.getName());
//				updCandidate.setBirthday(candidate.getBirthdayAsString());
//				updCandidate.setSalary(candidate.getSalary());
//				updCandidate.setSurname(candidate.getSurname());
//				candidateDao.update(updCandidate);
//			}
//		}
//	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void deleteCandidate(@PathVariable("id") Integer id) {
//
//		logger.debug("deleteCandidate() : {}", id);
//		Candidate candidate = candidateDao.Read(new CandidateSpecification().GetById(id.toString()));
//		if (candidate != null){
//			candidateDao.delete(new CandidateSpecification().GetById(id.toString()));
//		} else {
//			throw new ResourceNotFoundException();
//		}
//	}
//}