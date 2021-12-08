package com.companyportal.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView test(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/employeeform", method = RequestMethod.GET)
	public String add(Model model) {
		Employee employee = new Employee();

		model.addAttribute("employee", employee);
		return "employeeform";
		// return new ModelAndView("employeeform", "employee", employee);
	}

	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public String saveEmployeeData(@ModelAttribute Employee employee) {
		employeeService.saveOrUpdateEmployeeData(employee);

		return "redirect:/employeelist";
	}

	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	public ModelAndView display() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employeelist");
		mv.addObject("employeeList", employeeService.getEmployeesData());
		return mv;
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
	public String updateEmployeeData(@RequestParam("employeeId") int employeeId, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(employeeId));
		return "employeeform";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchEmployee(@RequestParam("employeeName") String employeeName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employeelist");
		mv.addObject("employeeList", employeeService.searchEmployeebyName(employeeName));
		System.out.println(employeeService.searchEmployeebyName(employeeName));
		return mv;
	}

	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("employeeId") int employeeId) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employeeService.deleteEmployee(employee);
		return "redirect:/employeelist";
	}

	// Spring Rest

	@GetMapping("/employees")
	@ResponseBody
	public List<Employee> getAllEmployees() {
		return employeeService.getEmployeesData();
	}

	@PostMapping("/employees")
	@ResponseBody
	public Employee saveEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdateEmployeeData(employee);
		return employee;
	}

	@DeleteMapping("/employees/{id}")
	@ResponseBody
	public String deleteEmployeeById(@PathVariable int id) {
		Employee employee = new Employee();
		employee.setEmployeeId(id);
		employeeService.deleteEmployee(employee);
		return "Employee Deleted Successfully";
	}

	@PutMapping("/employees/{id}")
	@ResponseBody
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		employee.setEmployeeId(id);
		employeeService.saveOrUpdateEmployeeData(employee);
		return employee;
	}

	@PostMapping("/employees/name")
	@ResponseBody
	public List<Employee> searchEmployeeRest(@RequestParam("employeeName") String employeeName) {
		return employeeService.searchEmployeebyName(employeeName);
	}

}
