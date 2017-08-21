package ncontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("/joinus/")
public class CheckController {
	
	@Autowired
	private View jsonview;
	
	@RequestMapping(value="json.htm")
	public View jsonkosta(String userid, ModelMap map){
		String check="";
		if(userid.equals("kglim")){
			check="yes man";
		} else if(userid.equals("admin")){
			check="sorry man";
		}
			
		map.addAttribute("check", check);
		
		return jsonview; //private View jsonview 타입으로 리턴	
	}
}
