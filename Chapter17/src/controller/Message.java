package controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;
import task.Scheduler;

@Controller
public class Message {
	
	private JavaMailSender mailSender;
	
	@Autowired
	public void setMailSender(JavaMailSender mailSender){
		this.mailSender=mailSender;
	}
	
	JSONObject object = null;
	@Autowired
	private RestTemplate restTemplate;

		
	@Autowired
	Scheduler scheduler;
	
	@RequestMapping("/index.htm")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/reg.htm",method=RequestMethod.GET)
	public String sendMail(){
		
		return "hello";
	}
	
	@RequestMapping(value="/mes.htm",method=RequestMethod.POST)
	public String sendMail(String id , String email , String message , String name) throws AddressException, MessagingException{
		MimeMessage mimemessage = mailSender.createMimeMessage();
		mimemessage.setSubject("회원가입을 축하합니다.", "utf-8");
		String htmlContent="<strong>[MimeMessage]</strong><br>" + message + "<br>";
		mimemessage.setText(htmlContent, "utf-8", "html");
		
		mimemessage.addRecipient(RecipientType.TO, new InternetAddress(email));
		mailSender.send(mimemessage);
		
		return "index";
	}
	
	@RequestMapping(value="/send.htm",method=RequestMethod.GET)
	public String fileupload(){
		return "send";
	}
	
	@RequestMapping(value="/send.htm",method=RequestMethod.POST)
	public String fileupload(String to , String subject , @RequestParam("filename") MultipartFile filename , String content){
		MimeMessage message = mailSender.createMimeMessage();
		try{
			System.out.println("파일네임 : " + filename);
			MimeMessageHelper messageHelper = 
					new MimeMessageHelper(message,true,"utf-8");
			messageHelper.setSubject(subject);
			String htmlContent = content;
			messageHelper.setText(htmlContent,true);
			messageHelper.setFrom("heyzenmate@gmail.com", "운영자");
			messageHelper.setTo(new InternetAddress(to,"utf-8"));
			
		    File newfile=new File(filename.getOriginalFilename());
		    filename.transferTo(newfile);

		    DataSource dataSource=new FileDataSource(newfile);
		    messageHelper.addAttachment(
		    		MimeUtility.encodeText(filename.getOriginalFilename(), "utf-8", "B")
		    								, dataSource);

		    mailSender.send(message);

		}catch(Exception e){
			System.out.println("fileupload error");
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@RequestMapping(value="/search.htm")
	public String search(){
		return "search";
	}
	

	@RequestMapping(value = "/hello.htm", method = RequestMethod.GET)
	public String home(Model model, String word)
			throws UnsupportedEncodingException, InterruptedException, ExecutionException {
		String targetUrl = "http://apis.daum.net/search/blog?"
				+ "apikey=66b7ba1d095c8d9d75271466d94708b5&q={word}&advance=y&output=json";
		String movieSearchUrl = "http://apis.daum.net/search/image?"
				+ "apikey=66b7ba1d095c8d9d75271466d94708b5&q={word}&advance=y&output=json&result=20";
		try {
			String body = restTemplate.getForObject(targetUrl, String.class, word);
			String fock =restTemplate.getForObject(movieSearchUrl, String.class, word);
			System.out.println(body);
			
			object = JSONObject.fromObject(body);
			object =JSONObject.fromObject(fock);
			model.addAttribute("body", object);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "home";
	}
	
	@RequestMapping(value="/login.htm", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value="login.htm",method=RequestMethod.POST)
	public String login(String id, String pw,HttpSession session,HttpServletRequest request){
		session.setAttribute("sid", id);
		
		scheduler.setSession(session);
		return "login";
	}
	@RequestMapping(value="sendsimple.htm", method=RequestMethod.POST)
	public String messageSender(){
		
		scheduler.setMailSender(mailSender);
		scheduler.Test2();
		
		return "login";
	}
	@RequestMapping(value="new.htm", method=RequestMethod.GET)
	public String rePage(){
		return "login";
	}
	@RequestMapping(value="send2.htm", method=RequestMethod.GET)
	public String send2(){
		return "send2";
	}
	@RequestMapping(value="send2.htm", method=RequestMethod.POST)
	public String fileupload2(String to , String subject , @RequestParam("filename") MultipartFile filename , String content){
		
		scheduler.setMailSender(mailSender);
		scheduler.setTo(to);
		scheduler.setSubject(subject);
		scheduler.setFilename(filename);
		scheduler.setContent(content);
		
		return "index";
	}
}
