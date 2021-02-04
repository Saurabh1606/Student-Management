package in.co.student.info.ctl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import in.co.student.info.dto.MarksheetDTO;
import in.co.student.info.dto.UserDTO;
import in.co.student.info.exception.DuplicateRecordException;
import in.co.student.info.form.GetMarksheetform;
import in.co.student.info.form.MarksheetForm;
import in.co.student.info.service.MarksheetServiceInt;
import in.co.student.info.service.UserServiceInt;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * MarksheetCtl Implementation
 * @author Navigable Set
 * @Version 1.0
 */

@Controller
@RequestMapping(value = "/ctl/Marksheet")
public class MarksheetCtl extends BaseCtl {

	@Autowired
	MarksheetServiceInt marksheetservice;

	@Autowired
	UserServiceInt studentservice;

	@Autowired
	MessageSource messageSource;

	@ModelAttribute
	public void preload(Model model) {
		
		UserDTO uDto=new UserDTO();
		uDto.setRoleId(2);
		List list = studentservice.search(uDto);

		model.addAttribute("userList", list);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") MarksheetForm form,
			Model model) {

		if (form.getId() > 0) {
			form.populate(marksheetservice.findByPK(id));
		}

		return "Marksheet";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Valid MarksheetForm form, BindingResult bindingResult, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Marksheet/";
		}

		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Marksheet/Search";
		}

		if (bindingResult.hasErrors()) {
			System.err.println("input error");
			return "Marksheet";
		}

		if (OP_SAVE.equalsIgnoreCase(operation)) {

			MarksheetDTO dto = (MarksheetDTO) form.getDto();
			try {
				String msg = null;

				if (form.getId() > 0) {
					marksheetservice.update(dto);
					msg = messageSource.getMessage("message.success.update", null, locale);
				}
				if (form.getId() == 0) {
					System.out.println("in marksheet **************  form.getId()" + form.getId());
					marksheetservice.add(dto);
					msg = messageSource.getMessage("message.success.add", null, locale);
				}
				model.addAttribute("success", msg);
			} catch (DuplicateRecordException e) {
				String msg = messageSource.getMessage("message.markSheetForm.duplicateRecordFound.rollNo.student", null,
						locale);
				model.addAttribute("error", msg);
			}
			return "Marksheet";
		}
		return null;

	}

	/**
	 * Displays User List
	 * 
	 * @param form
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/Search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(Locale locale, @ModelAttribute("form") MarksheetForm form,
			@RequestParam(required = false) String operation, RedirectAttributes redirectAttributes, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Marksheet/Search";
		}

		if (OP_NEW.equalsIgnoreCase(operation)) {
			return "redirect:Marksheet";
		}
		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {

			if (form.getIds() != null) {

				for (long id : form.getIds()) {
					MarksheetDTO dto = new MarksheetDTO();
					dto.setId(id);
					marksheetservice.delete(dto);
				}
				String msg = messageSource.getMessage("message.success.delete", null, locale);
				model.addAttribute("success", msg);

				// redirectAttributes.addFlashAttribute("success", msg);
				return "MarksheetList";

			} else {

				System.out.println("select at least one records");
				String msg = messageSource.getMessage("message.unsuccess.selectatleastonerecords", null, locale);
				model.addAttribute("error", msg);
			}

		}

		List<MarksheetDTO> list = marksheetservice.search((MarksheetDTO) form.getDto(), pageNo, pageSize);

		List<MarksheetDTO> totallist = marksheetservice.search(null);

		model.addAttribute("list", list);

		/*
		 * Set<Long> studentIds = new HashSet<Long>(); for (MarksheetDTO
		 * marksheetDTO : list) { studentIds.add(marksheetDTO.getStudentId()); }
		 * 
		 * model.addAttribute("studentMap",
		 * studentservice.getMapDTO(studentIds));
		 */
		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			String msg = messageSource.getMessage("message.unsuccess.recoudNotFound", null, locale);
			model.addAttribute("error", msg);
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);

		return "MarksheetList";
	}

	@RequestMapping(path = "/MeritList", method = RequestMethod.GET)
	public String getMeriList(Model model) {
		model.addAttribute("meritList", marksheetservice.getMeritList(1, 10));
		return "MarksheetMeritList";
	}

	@RequestMapping(path = "/getMarksheet", method = RequestMethod.GET)
	public String getMarksheet(@ModelAttribute("form") GetMarksheetform form, Model model) {
		return "GetMarksheet";
	}

	@RequestMapping(path = "/getMarksheet", method = RequestMethod.POST)
	public String getMarksheet(Locale locale, @ModelAttribute("form") @Valid GetMarksheetform form,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "GetMarksheet";
		}

		

		MarksheetDTO dto = marksheetservice.getMarkshet(form.getRollNo());
		if (dto == null) {
			String msg = messageSource.getMessage("message.unsuccess.recoudNotFound", null, locale);
			model.addAttribute("error", msg);
		} else {
			System.out.println(dto.getName());
			model.addAttribute("marksheet", dto);
		}

		return "GetMarksheet";

	}

	@Autowired
	ComboPooledDataSource dataSourse;

	@RequestMapping(path = "/print", method = RequestMethod.GET)
	public void marksheetmeritJasper(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		try {

			// "C:/Users/MANOJ/JaspersoftWorkspace/MyReports/Marksheet.jrxml"

			String path = request.getServletContext().getRealPath("/report/Marksheet.jrxml");

			System.out.println("path :" + path + "");

			
			JasperReport jasperReport = JasperCompileManager
					.compileReport("C:/Users/MANOJ/JaspersoftWorkspace/MyReports/Marksheet.jrxml"); 
			
			
			Map<String, Object> map = new HashMap<String, Object>();

			if (session.getAttribute("userLogin") != null) {
				UserDTO userDto = (UserDTO) session.getAttribute("userLogin");

				
				if(userDto!=null){
				map.put("user", userDto.getFirstName() + " " + userDto.getLastName());
				}
			}

			Connection conn = null;

			conn = dataSourse.getConnection();

		
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn); 
			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint); 
			response.setContentType("application/pdf");

			response.getOutputStream().write(pdf);

			response.getOutputStream().flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
