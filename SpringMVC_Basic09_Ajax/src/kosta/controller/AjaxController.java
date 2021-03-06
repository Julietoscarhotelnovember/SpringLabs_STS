package kosta.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kosta.vo.Employee;
import kosta.vo.TestVO;

@Controller
public class AjaxController {
	@Autowired
	private View jsonview;
	
	@RequestMapping(value="json.kosta")
	public View jsonkosta(String command, String name, String[] arr, ModelMap map){
		System.out.println("command: "+command);
		System.out.println("arr: "+arr);
		System.out.println(Arrays.toString(arr));
		
		ArrayList<String> list=new ArrayList<>();
		list.add("치맥");
		list.add("돈까스");
		list.add("피치");
		
		map.addAttribute("menu", list);
		
		return jsonview; //private View jsonview 타입으로 리턴	
	}
		
	@RequestMapping(value="json2.kosta")
	public View jsonkosta(String command, String name, ModelMap map){
		System.out.println("command: "+command);
		
		ArrayList<TestVO> list=new ArrayList<>();
		
		TestVO vo=new TestVO();
		vo.setBeer("라고");
		vo.setFood("골뱅");
		list.add(vo);
		
		TestVO vo2=new TestVO();
		vo2.setBeer("카스");
		vo2.setFood("치킨");
		list.add(vo2);
		
		map.addAttribute("menu", list);
		
		return jsonview; //private View jsonview 타입으로 리턴	
	}
	
	@RequestMapping(value="json3.kosta")
	public View add(HttpServletRequest request, HttpServletResponse response, ModelMap map){
		Employee employee=new Employee();
		employee.setFirstname("kg");
		employee.setLastname("lim");
		employee.setEmail("i7027@naver.com");
		
		ArrayList<Employee> list=new ArrayList<>();
		list.add(employee);
		
		Employee employee2=new Employee();
		employee2.setFirstname("h");
		employee2.setLastname("hong");
		employee2.setEmail("hong@naver.com");
		list.add(employee2);
		
		map.addAttribute("data", list);
		return jsonview;
	}
}
