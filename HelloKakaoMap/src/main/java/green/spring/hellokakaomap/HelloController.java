package green.spring.hellokakaomap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	// 웹브라우저가 '/kakaoMap'이라고 요청을 하면
	// 이 요청과 연결된 메소드를 하나 만들자
	@GetMapping("/")
	public String kakaoMap() {
		
		// kakaoMap.html을 view로 사용 
		return "kakaoMap";
	}
}
