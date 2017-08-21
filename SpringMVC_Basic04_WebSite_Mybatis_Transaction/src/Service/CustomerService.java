package Service;


import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

@Service
public class CustomerService {

	@Autowired
	private SqlSession sqlsession;

	// 글목록보기
	@RequestMapping("notice.htm")
	public List<Notice> notices(String pg, String f, String q) throws ClassNotFoundException, SQLException {

		int page = 1;
		String field = "TITLE";
		String query = "%%";

		if (pg != null && pg.equals("")) {
			page = Integer.parseInt(pg);
		}
		if (f != null && f.equals("")) {
			field = f;
		}
		if (q != null && q.equals("")) {
			query = q;
		}

		NoticeDao noticeDao = sqlsession.getMapper(NoticeDao.class);
		List<Notice> list = noticeDao.getNotices(page, field, query);

		return list;
	}

	// 글상세보기
	@RequestMapping("noticeDetail.htm")
	public Notice noticeDetail(String seq, Model model) throws ClassNotFoundException, SQLException {

		NoticeDao noticeDao = sqlsession.getMapper(NoticeDao.class);

		Notice notice = noticeDao.getNotice(seq);
		model.addAttribute("notice", notice);

		return notice;

	}

	// 등록
	@Transactional
	public String noticeReg(Notice n, HttpServletRequest request)
			throws ClassNotFoundException, SQLException, IOException {
		List<CommonsMultipartFile> files = n.getFiles();
		List<String> filenames = new ArrayList<String>(); // 파일명만 추출

		if (files != null && files.size() > 0) { // 업로드한 파일이 하나라도 있다면

			for (CommonsMultipartFile multipartfile : files) {

				String fname = multipartfile.getOriginalFilename(); // 파일명 얻기
				String path = request.getServletContext().getRealPath("/customer/upload");
				String fullpath = path + "\\" + fname;

				System.out.println(fname + " / " + path + " / " + fullpath);

				if (!fname.equals("")) {
					// 서버에 파일 쓰기 작업
					FileOutputStream fs = new FileOutputStream(fullpath);
					fs.write(multipartfile.getBytes());
					fs.close();
				}
				filenames.add(fname); // 실 DB Insert 작업시 .. 파일명
			}

		}

		// DB저장작업
		// DB 저장할 파일 명
		n.setFileSrc(filenames.get(0)); // 파일명 1
		n.setFileSrc2(filenames.get(1)); // 파일명 2

		// 실DB저장
		// mybatis적용
		NoticeDao noticeDao = sqlsession.getMapper(NoticeDao.class);
		
		try{
		//트랜잭션시작
		noticeDao.insert(n);
		noticeDao.insertOfMemberPoint("kglim");
		//트랜잭션끝
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
		
		return "redirect:notice.htm";
	}

	// 삭제
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
		NoticeDao noticeDao = sqlsession.getMapper(NoticeDao.class);
		noticeDao.delete(seq);
		return null;
	}

	// 수정
	public void noticeUpdate(Notice n, HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		List<CommonsMultipartFile> files = n.getFiles();
		List<String> filenames = new ArrayList<String>(); // 파일명만 추출

		if (files != null && files.size() > 0) { // 업로드한 파일이 하나라도 있다면

			for (CommonsMultipartFile multipartfile : files) {

				String fname = multipartfile.getOriginalFilename(); // 파일명 얻기
				String path = request.getServletContext().getRealPath("/customer/upload");
				String fullpath = path + "\\" + fname;

				System.out.println(fname + " / " + path + " / " + fullpath);

				if (!fname.equals("")) {
					// 서버에 파일 쓰기 작업
					FileOutputStream fs = new FileOutputStream(fullpath);
					fs.write(multipartfile.getBytes());
					fs.close();
				}
				filenames.add(fname); // 실 DB Insert 작업시 .. 파일명
			}

		}

		n.setFileSrc(filenames.get(0)); // 파일명 1
		n.setFileSrc2(filenames.get(1)); // 파일명 2;

		// mybatis적용
		NoticeDao noticeDao = sqlsession.getMapper(NoticeDao.class);
		noticeDao.update(n);
	}
}
