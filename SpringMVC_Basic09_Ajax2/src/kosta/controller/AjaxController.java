package kosta.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import kosta.vo.Employee;

@Controller
public class AjaxController {
	/*@Autowired
	private View jsonview;*/
	
	@RequestMapping(value="response.kosta", method=RequestMethod.POST)
	public @ResponseBody Employee add(HttpServletRequest request, HttpServletResponse response){
		System.out.println("response: ");
		Employee employee=new Employee();
		employee.setFirstname(request.getParameter("firstName"));
		employee.setLastname(request.getParameter("lastName"));
		employee.setEmail(request.getParameter("email"));
		
		return employee;
	}
}
