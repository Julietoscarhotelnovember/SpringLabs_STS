package task;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.multipart.MultipartFile;

public class Scheduler {
	HttpSession session;
	private MailSender mailSender2;
	private String to;
	private String subject;
	private MultipartFile filename;
	private String content;
	private JavaMailSender mailSender;
	
	@Autowired
	public void setMailSender(JavaMailSender mailSender){
		this.mailSender=mailSender;
	}
	public void setTo(String to) {
		this.to = to;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender2 = mailSender;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	@Scheduled(fixedDelay=5000, initialDelay = 5000)
	public void Test1(){
		System.out.println("initial-delay : 5초후 실행되는 메서드");
		System.out.println("session"+ session);
		System.out.println(session.getAttribute("sid"));
		session.invalidate();
		//System.out.println(session.getAttribute("min"));
		
	}

	private void Testing(HttpSession session) {
		this.session = session;
	}
	@Scheduled(cron="0 33 21 ? * MON-FRI")
	public void Test2(){
		System.out.println("fixed-rate : 10초 마다 실행되는 메서드");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[SimpleMailMessage]제목");
		message.setFrom("kosta129th@hanamil.net");
		message.setText("2016년 11월 09일 16시 10분에 자동으로 발신되는 메일입니다.");
		message.setTo("seedhw@gmail.com");
		System.out.println("mailSender"+mailSender);
		mailSender2.send(message);
	}
	@Scheduled(cron="0/10 * * * * MON-FRI")
	public void Test3(){
		System.out.println("fixed-delay : 3초마다 실행되는 메서드");
		MimeMessage message = mailSender.createMimeMessage();
		
		try{
			System.out.println("파일네임 : " + filename);
			MimeMessageHelper messageHelper = 
					new MimeMessageHelper(message,true,"utf-8");
			System.out.println("subject"+subject);
			System.out.println("content"+content);
			messageHelper.setSubject(subject);
			String htmlContent = content;
			messageHelper.setText(htmlContent,true);
			messageHelper.setFrom("heyzenmate@gmail.com", "운영자");
			messageHelper.setTo(new InternetAddress(to,"utf-8"));
			
		    //File newfile=new File(filename.getOriginalFilename());
		    //filename.transferTo(newfile);

		    //DataSource dataSource=new FileDataSource(newfile);
		    //messageHelper.addAttachment(
		    		//MimeUtility.encodeText(filename.getOriginalFilename(), "utf-8", "B")
		    								//, dataSource);

		    mailSender.send(message);

		}catch(Exception e){
			System.out.println("fileupload error");
			e.printStackTrace();
		}
		
	}

	public void Test4(){
		System.out.println("cron : 매일 오전 9~"
				+ "오후 9시에만 실행되는 메서드 ");
	}
	
}
