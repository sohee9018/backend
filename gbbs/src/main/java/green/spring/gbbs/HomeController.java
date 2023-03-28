package green.spring.gbbs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	// "/"로 접속을 요청하면 index()메소드가 처리한다.
	// 클라이언트에서 주소로만 요청을 하면 GET 방식을 의미
	// GET 방식은 요청한 서버에게 데이터 주세요란 뜻
	@ResponseBody
	@GetMapping("/")
	public String index() {
		return "안녕하세요!";
	}
	
	// 클라이언트에서 http://localhost/hello라고 요청하면
	// 서버에서 sayHello()라는 메소드가 응답한다.(=처리한다)
	// 응답결과는 "만나서 반가워요" 어떻게 하면 될까요?
	
	@GetMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "만나서 반가워요!";
	}
	
	
}
