package in.co.student.info.ctl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.student.info.dto.AssignmentDTO;
import in.co.student.info.dto.FeeDTO;
import in.co.student.info.dto.UserDTO;
import in.co.student.info.exception.DuplicateRecordException;
import in.co.student.info.form.AssignmentForm;
import in.co.student.info.form.FeeForm;
import in.co.student.info.service.AttendanceServiceInt;
import in.co.student.info.service.FeeServiceInt;
import in.co.student.info.service.SubjectServiceInt;
import in.co.student.info.service.UserServiceInt;

@Controller
@RequestMapping(value="/ctl/Fee")
public class FeeCtl extends BaseCtl {
	
	@Autowired
	FeeServiceInt service;
	
	@Autowired
	UserServiceInt userservice;

	@Autowired
	MessageSource messageSource;

	@ModelAttribute
	public void preload(Model model) {
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("January ", "January");
		map.put("February", "February");
		map.put("March ", "March");
		map.put("April ", "April");
		map.put("May", "May");
		map.put("June", "June");
		map.put("July", "July");
		map.put("August", "August");
		map.put("September", "September");
		map.put("October", "October");
		map.put("November", "November");
		map.put("December", "December");
		model.addAttribute("monthMap",map);
		UserDTO uDto=new UserDTO();
		uDto.setRoleId(2L);
		model.addAttribute("userList",userservice.search(uDto));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long Id, @ModelAttribute("form") FeeForm form,
			Model model) {
		if (form.getId() > 0) {
			form.populate(service.findByPK(form.getId()));
		}
		return "Fee";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Validated() FeeForm form, BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:Fee";
		}
		
		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:Fee/Search";
		}

		if (OP_SAVE.equalsIgnoreCase(operation)) {

			if (bindingResult.hasErrors()) {
				System.err.println("input Error");
				return "Fee";
			}

			FeeDTO dto = (FeeDTO) form.getDto();

			try {
				String msg = null;
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
				String msg = messageSource.getMessage("message.feeForm.duplicateRecordFound.name=Fee is already exist" , null, locale);
				model.addAttribute("error", msg);
			}
			return "Fee";
		}
		return null;
	}

	@RequestMapping(value = "/Search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(Locale locale, @ModelAttribute("form") FeeForm form,
			@RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Fee/Search";
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
					FeeDTO dto = new FeeDTO();
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

		List<FeeDTO> list = service.search((FeeDTO) form.getDto(), pageNo, pageSize);
		
		List<FeeDTO> totallist= service.search(null);
		
		
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

		return "FeeList";

	}

}
