package ncontrollers;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import Service.CustomerService;
import vo.Notice;
import dao.NoticeDao;

// 폴더 경로가 긴 경우
// /customer/notice.htm => notice.htm
// /customer/noticeDetail.htm
@Controller
@RequestMapping("/customer/")
public class CustomerController {

	@Autowired
	private SqlSession sqlsession;

	@Autowired
	private CustomerService customerservice;

	// 글목록보기
	@RequestMapping("notice.htm") // /customer/notice.htm
	public String notices(String pg, String f, String q, Model model) throws ClassNotFoundException, SQLException {

		List<Notice> list = customerservice.notices(pg, f, q);
		model.addAttribute("list", list);

		return "customer.notice";
	}

	// 글상세보기
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq, Model model) throws ClassNotFoundException, SQLException {

		Notice notice = customerservice.noticeDetail(seq, model);

		model.addAttribute("notice", notice);

		return "customer.noticeDetail";
	}

	// 글등록 화면 처리
	@RequestMapping(value = "noticeReg.htm", method = RequestMethod.GET)
	public String noticeReg() {
		System.out.println("글쓰기 매핑");

		return "customer.noticeReg";
	}

	// 글등록 처리(실제 글등록 처리)
	@RequestMapping(value = "noticeReg.htm", method = RequestMethod.POST)
	public String noticeReg(Notice n, HttpServletRequest request)
			throws IOException, ClassNotFoundException, SQLException {
		String str="redirect:notice.htm";
		try{
			str=customerservice.noticeReg(n, request);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return str;
	}

	// 글삭제하기
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
		customerservice.noticeDel(seq);
		return "redirect:notice.htm"; // 리스트 화면 (controller 타서 데이터 출력)
	}

	// 수정
	@RequestMapping(value = "noticeEdit.htm", method = RequestMethod.GET)
	public String noticeEdit(String seq, Model model) throws ClassNotFoundException, SQLException {

		Notice notice = customerservice.noticeDetail(seq, model);
		model.addAttribute("notice", notice);

		return "customer.noticeEdit";
	}

	// 게시판 실제 수정처리
	@RequestMapping(value = "noticeEdit.htm", method = RequestMethod.POST)
	public String noticeEdit(Notice n, HttpServletRequest request)
			throws ClassNotFoundException, SQLException, IOException {

		customerservice.noticeUpdate(n, request);
		return "redirect:noticeDetail.htm?seq=" + n.getSeq();

	}

	@RequestMapping("download.htm")
	public void download(String p, String f, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String fname = new String(f.getBytes("euc-kr"), "8859_1");
		System.out.println(fname);

		response.setHeader("Content-Disposition", "attachment;filename=" + fname + ";");
		// 파일명 전송
		// 파일 내용전송
		String fullpath = request.getServletContext().getRealPath("/customer/" + p + "/" + f);
		System.out.println(fullpath);
		FileInputStream fin = new FileInputStream(fullpath);
		// 출력 도구 얻기 :response.getOutputStream()
		ServletOutputStream sout = response.getOutputStream();
		byte[] buf = new byte[1024]; // 전체를 다읽지 않고 1204byte씩 읽어서
		int size = 0;
		while ((size = fin.read(buf, 0, buf.length)) != -1) // buffer 에 1024byte
		// 담고
		{ // 마지막 남아있는 byte 담고 그다음 없으면 탈출
			sout.write(buf, 0, size); // 1kbyte씩 출력
		}
		fin.close();
		sout.close();
	}

}
