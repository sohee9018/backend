package green.spring.green_bbs;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreenBBSController {

	@RequestMapping("/greenBBS") //greenBBS로 요청하면
	@ResponseBody
	public String greenBBS() {
	return "GreenBBS 게시판";
	}
	
	@RequestMapping("/home")
	// 뷰에 데이터를 전달하려면 model을 넘겨주어야 합니다.
	// model은 동적 데이터를 담기 위한 변수 상자라고 볼 수 있으며
	// 스프링이 자동으로 준비해 줍니다.
	public String home(Model model) {
		//모델에 데이터를 담아라
		//msg라는 키변수에 hello world라는 문자열 데이터 저장
		model.addAttribute("msg", "Hello world!");
		//@ResponseBody가 없으므로 텍스트 문자열이 아니라
		//뷰를 나타내는 파일이다.
		return "home";
	}
	
	@RequestMapping("/hello")
	
	public String hello(Model model) {
		
		model.addAttribute("greeting", "<b>이미지 태그 사용 이미지 출력</b>");
		
		return "hello";
	}
	
	@RequestMapping("/member")
	public String manageMember(Model model) {
		// 1. Member 객체를 생성
		// 2. Member 객체에 데이터를 추가
		// 3. 모델에 Member객체 저장
		// 4. 이 모델을 타임리프 manage_member.html에 전달
		// 5. 이 모델의 객체 값을 타임리프 속성을 이용 출력
		Member member = new Member();
		
		member.setUserId("구름이");
		member.setPassword("3210");
		member.setUserEmail("구름이@구름.구름");
		member.setUserName("구름");
		
		LocalDate birthday = LocalDate.of(2000, 10, 5);
		member.setBirthday(birthday);
		
		model.addAttribute("member", member);
		
		return "manage_Member";
	}
	
	@RequestMapping("/member_address")
	public String memberAndAddress(Model model) {
		MemberNew member = new MemberNew();
		Address address = new Address();
		
		member.setUserId("gurmmi");
		member.setPassword("12345");
		
		address.setPostCode("08090");
		address.setLocation("Busan");
		
		member.setAddress(address);
		
		model.addAttribute("member", member);
		
		return "member_address";
	}
}
