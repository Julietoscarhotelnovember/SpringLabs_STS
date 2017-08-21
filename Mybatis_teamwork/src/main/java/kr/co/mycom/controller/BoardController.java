package kr.co.mycom.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mycom.model.EmpDAO;
import kr.co.mycom.model.EmpDTO;

@Controller
public class BoardController {

	@Autowired
	private SqlSession sqlsession;

	// 요청 Url 맞는 method 구현 하고 처리
	@RequestMapping("/writeform.htm")
	public String writeForm() {
		return "home.writeform";

	}

	@RequestMapping("/write.htm")
	public String write(EmpDTO dto) {
		// 핵심
		// sqlsession.insert(arg0);
		EmpDAO empDao = sqlsession.getMapper(EmpDAO.class);
		// mapper xml 파일과 DAO interface 동기화
		// 인터페이스가 가지는 자원은 실행 : mapper 가 실행
		// 전제 : 1. namespace , 2. id=method
		empDao.insertEmp(dto);
		return "redirect:/list.htm";
	}

	@RequestMapping("/list.htm")
	public String list(Model model) {

		// start , end
		HashMap map = new HashMap();
		EmpDAO empDao = sqlsession.getMapper(EmpDAO.class);
		List<EmpDTO> list = empDao.getEmpList(map);

		// request.setAttribute("list",list) 같은 원리
		model.addAttribute("list", list);
		return "home.list";

	}

	@RequestMapping("/read.htm")
	public String read(int num, Model model) {

		EmpDAO empDao = sqlsession.getMapper(EmpDAO.class);

		// 상세조회
		EmpDTO dto = empDao.getEmp(num);
		// model 필요한 것 담고
		model.addAttribute("b", dto);
		return "home.read"; // read.jsp
	}

	@RequestMapping("/updateform.htm")
	public String updateForm(int num, Model model) {

		// 기존 화면 내용 출력
		// getBoard()
		EmpDAO empDao = sqlsession.getMapper(EmpDAO.class);
		EmpDTO dto = empDao.getEmp(num);
		// model 담기
		model.addAttribute("b", dto);
		return "home.updateform"; // updateform.jsp
	}

	@RequestMapping("/update.htm")
	public String update(EmpDTO dto) {
		EmpDAO empDao = sqlsession.getMapper(EmpDAO.class);
		System.out.println(dto.toString());
		int result = empDao.updateEmp(dto);
		System.out.println(result);
		// 결과 받기
		String view = "";
		if (result == 0) {
			view = "fail"; // fail.jsp
		} else {
			view = "redirect:list.htm"; // fail.jsp
		}

		// 실패 : fail.jsp
		// 성공 : 원하는 페이지
		return view;
	}

	@RequestMapping("/delete.htm")
	public String delete(int num) {
		EmpDAO empDao = sqlsession.getMapper(EmpDAO.class);
		EmpDTO dto = empDao.getEmp(num);
		int result = empDao.deleteEmp(dto);

		String view = "";

		if (result == 0) {
			view = "fail"; // fail.jsp
		} else {
			view="redirect:list.htm";
		}

		return view;
	}
	
	@RequestMapping("/search.htm")
	public String search(String searchbox, String select, Model model) {
		EmpDAO empDao = sqlsession.getMapper(EmpDAO.class);
		
		HashMap map = new HashMap();
		map.put("searchbox", searchbox);
		map.put("select", select);
		List<EmpDTO> list = empDao.getSearchList(map);
		model.addAttribute("list", list);
		return "home.list";
	}

}
