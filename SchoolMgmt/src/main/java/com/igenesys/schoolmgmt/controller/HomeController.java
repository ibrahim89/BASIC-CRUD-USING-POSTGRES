package com.igenesys.schoolmgmt.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.igenesys.schoolmgmt.dao.EmployeeDAO;
import com.igenesys.schoolmgmt.model.BaseReturn;
import com.igenesys.schoolmgmt.model.Employee;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	EmployeeDAO empdao;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public @ResponseBody BaseReturn getEmployee(){
		logger.error("getEmployees Called");
		return empdao.getEmployee();
	}
	@RequestMapping(value = "/insertEmployee", method = RequestMethod.POST)
	public @ResponseBody BaseReturn insertEmployee(@RequestBody Employee employee){
		logger.error("insertEmployees Called");
		return empdao.insertEmployee(employee);
	}
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public @ResponseBody BaseReturn updateEmployee(@RequestBody Employee employee){
		logger.error("updateEmployees Called");
		return empdao.updateEmployee(employee);
	}
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
	public @ResponseBody BaseReturn deleteEmployee(@RequestBody Employee employee){
	logger.error("deleteEmployeee called");
	return empdao.deleteEmployee(employee);
	}
	public String getTestGitHubMethod() {
		return "Github is working file!!!!!!!!!!!!!";
	}
	
}
