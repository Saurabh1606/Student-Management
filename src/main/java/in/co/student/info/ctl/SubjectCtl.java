package in.co.student.info.ctl;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

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

import in.co.student.info.dto.SubjectDTO;
import in.co.student.info.exception.DuplicateRecordException;
import in.co.student.info.form.SubjectForm;
import in.co.student.info.service.SubjectServiceInt;



/** SubjectCtl Implemenatation
 * @author Navigable Set
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/ctl/Subject")
public class SubjectCtl extends BaseCtl {

	@Autowired
	SubjectServiceInt service;


	@Autowired
	MessageSource messageSource;

	
	

	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long Id, @ModelAttribute("form") SubjectForm form,
			Model model) {
		if (form.getId() > 0) {
			form.populate(service.findByPK(form.getId()));
		}
		return "Subject";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Validated() SubjectForm form, BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:Subject";
		}
		
		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:Subject/Search";
		}

		if (OP_SAVE.equalsIgnoreCase(operation)) {

			if (bindingResult.hasErrors()) {
				System.err.println("input Error");
				return "Subject";
			}

			SubjectDTO dto = (SubjectDTO) form.getDto();

			try {
				String msg = null;
				if (form.getId() > 0) {
					service.update(dto);
					msg = messageSource.getMessage("message.success.update", null, locale);
				}

				if (form.getId() == 0) {
					
					System.out.println("Name ========="+dto.getName());
					System.out.println("Description="+dto.getDescription());
					service.add(dto);
					msg = messageSource.getMessage("message.success.add", null, locale);
				}

				model.addAttribute("success", msg);
			} catch (DuplicateRecordException e) {
				String msg = messageSource.getMessage("message.subjectForm.duplicateRecordFound.name" , null, locale);
				model.addAttribute("error", msg);
			}
			return "Subject";
		}
		return null;
	}

	@RequestMapping(value = "/Search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(Locale locale, @ModelAttribute("form") SubjectForm form,
			@RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Subject/Search";
		}

		System.out.println("========================== searchList ");
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
					SubjectDTO dto = new SubjectDTO();
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

		List<SubjectDTO> list = service.search((SubjectDTO) form.getDto(), pageNo, pageSize);
		
		List<SubjectDTO> totallist= service.search(null);
		
		
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

		return "SubjectList";

	}
}
