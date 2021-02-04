package in.co.student.info.ctl;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

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
import in.co.student.info.dto.AttendanceDTO;
import in.co.student.info.dto.UserDTO;
import in.co.student.info.exception.DuplicateRecordException;
import in.co.student.info.form.AssignmentForm;
import in.co.student.info.form.AttendanceForm;
import in.co.student.info.service.AssignmentServiceInt;
import in.co.student.info.service.AttendanceServiceInt;
import in.co.student.info.service.SubjectServiceInt;
import in.co.student.info.service.UserServiceInt;

@Controller
@RequestMapping(value="/ctl/Attendance")
public class AttendanceCtl extends BaseCtl {

	@Autowired
	AttendanceServiceInt service;

	@Autowired
	SubjectServiceInt subjectservice;
	
	@Autowired
	UserServiceInt userservice;

	@Autowired
	MessageSource messageSource;

	@ModelAttribute
	public void preload(Model model) {
		model.addAttribute("subjectList", subjectservice.search(null));
		UserDTO uDto=new UserDTO();
		uDto.setRoleId(2L);
		model.addAttribute("userList",userservice.search(uDto));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long Id, @ModelAttribute("form") AttendanceForm form,
			Model model) {
		if (form.getId() > 0) {
			form.populate(service.findByPK(form.getId()));
		}
		return "Attendance";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Validated() AttendanceForm form, BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:Attendance";
		}
		
		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:Attendance/Search";
		}

		if (OP_SAVE.equalsIgnoreCase(operation)) {

			if (bindingResult.hasErrors()) {
				System.err.println("input Error");
				return "Attendance";
			}

			AttendanceDTO dto = (AttendanceDTO) form.getDto();

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
				String msg = messageSource.getMessage("message.attendanceForm.duplicateRecordFound.name" , null, locale);
				model.addAttribute("error", msg);
			}
			return "Attendance";
		}
		return null;
	}

	@RequestMapping(value = "/Search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(HttpSession session,Locale locale, @ModelAttribute("form") AttendanceForm form,
			@RequestParam(required = false) String operation, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Attendance/Search";
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
					AttendanceDTO dto = new AttendanceDTO();
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
		AttendanceDTO dto=(AttendanceDTO)form.getDto();
		UserDTO udto = (UserDTO) session.getAttribute("userLogin");
		if(udto.getRoleId()==2) {
			dto.setStudentId(udto.getId());
		}

		List<AttendanceDTO> list = service.search(dto, pageNo, pageSize);
		
		List<AttendanceDTO> totallist= service.search(dto);
		
		
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

		return "AttendanceList";

	}
}
