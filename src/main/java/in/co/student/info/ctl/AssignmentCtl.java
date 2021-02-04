package in.co.student.info.ctl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.student.info.dto.AssignmentDTO;
import in.co.student.info.dto.SubjectDTO;
import in.co.student.info.exception.DuplicateRecordException;
import in.co.student.info.form.AssignmentForm;
import in.co.student.info.form.SubjectForm;
import in.co.student.info.service.AssignmentServiceInt;
import in.co.student.info.service.SubjectServiceInt;



@Controller
@RequestMapping(value = "/ctl/Assignment")
public class AssignmentCtl extends BaseCtl {

	@Autowired
	AssignmentServiceInt service;

	@Autowired
	SubjectServiceInt subjectservice;

	@Autowired
	MessageSource messageSource;

	@ModelAttribute
	public void preload(Model model) {
		model.addAttribute("subjectList", subjectservice.search(null));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long Id, @ModelAttribute("form") AssignmentForm form,
			Model model) {
		if (form.getId() > 0) {
			form.populate(service.findByPK(form.getId()));
		}
		return "Assignment";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Validated() AssignmentForm form, BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:Assignment";
		}
		
		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:Assignment/Search";
		}

		if (OP_SAVE.equalsIgnoreCase(operation)) {

			if (bindingResult.hasErrors()) {
				System.err.println("input Error");
				return "Assignment";
			}

			AssignmentDTO dto = (AssignmentDTO) form.getDto();

			try {
				String msg = null;
				System.out.println("Assignmnet Ctl ----------------"+form.getId());
				if (form.getId() > 0) {
					service.update(dto);
					msg = messageSource.getMessage("message.success.update", null, locale);
				}

				if (form.getId() == 0) {
					service.add(dto);
					msg = messageSource.getMessage("message.success.add", null, locale);
				}

				model.addAttribute("success", msg);
			} catch (DuplicateRecordException e) {
				String msg = messageSource.getMessage("message.assignmentForm.duplicateRecordFound.name" , null, locale);
				model.addAttribute("error", msg);
			}
			return "Assignment";
		}
		return null;
	}

	@RequestMapping(value = "/Search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(Locale locale, @ModelAttribute("form") AssignmentForm form,
			@RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Assignment/Search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equalsIgnoreCase(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equalsIgnoreCase(operation)) {
			pageNo--;
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equalsIgnoreCase(operation)) {

			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					AssignmentDTO dto = new AssignmentDTO();
					dto.setId(id);
					service.delete(dto);
				}

				Integer[] lengths = { form.getIds().length };
				String msg = messageSource.getMessage("message.success.delete", null, locale);
				model.addAttribute("success", msg);
			} else {
				String msg = messageSource.getMessage("message.unsuccess.selectatleastonerecords", null, locale);
				model.addAttribute("error", msg);
			}
		}

		List<AssignmentDTO> list = service.search((AssignmentDTO) form.getDto(), pageNo, pageSize);
		
		List<AssignmentDTO> totallist= service.search(null);
		
		
		model.addAttribute("list", list);
		


		

		if (list.size() == 0) {
			String msg = messageSource.getMessage("message.unsuccess.recoudNotFound", null, locale);
			model.addAttribute("error", msg);
		}

		int listsize = list.size();
		
		
		int total = totallist.size();
		int pageNoPageSize=pageNo*pageSize;
		

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		
		
		model.addAttribute("total", total);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("pagenosize", pageNoPageSize);

		return "AssignmentList";

	}
	
}
