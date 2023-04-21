package green.spring.first_jdbc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	// /home이라는 주소로 요청을 하면 "안녕하세요 홈입니다." 출력 
	@RequestMapping("/home")
	@ResponseBody
	public String home(){
		// 문자열 응답으로 바꾸려면 @ResponseBody가 필요(=응답을 문자열 형식으로 바꾸세요)
		return "안녕하세요 홈입니다.";
	}
	
	// '/'요청하면 루트폴더의 내용을 보여주세요
	// 만약에 루트폴더에 앱이 있다면 앱이 실행
	// 없으면 폴더의 내용을 보여줍니다.
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "루트폴더에 오셨습니다.";
	}
}
