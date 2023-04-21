package green.spring.first_jdbc;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
// 로그 기능을 사용하겠다
@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardDAO dao;
	
	// /board/list01로 요청하면 => 'list 기능 작성중...' 문자열로 리턴함
	// /board/list01 요청하면 /board 폴더 밑에 /list 앱이 실행
	// '밑에'라는 뜻은 ~/로 해석하면 됩니다.
	@RequestMapping("/board/list01")
	@ResponseBody
	public String list01(){
		return "list01기능 작성중...";
	}
	
	// /board/list02로 요청하면 => 템플릿 파일 board_list02 파일의 내용을 가져옴
	@RequestMapping("/board/list02")
	public String list02() {
		//템플릿폴더의 board_list02 파일을 가져와라
		log.info("board_list02 출력중...");
		return "board_list02";
	}
	
	// /board/list03으로 요청하면 리턴값을 void형으로 하게되면 
	// 템플릿 폴더에 요청 경로명으로 폴더를 만들고 요청앱 이름의 결과 파일을 만들어 리턴합니다.
	@RequestMapping("/board/list03")
	public void list03() {
		log.info("/board/list03 요청 ===> board_list03.html 응답");
	}
	
	// /board/list으로 요청을 게시판 목록을 보여준다.
	@RequestMapping("/board/list")
	public String list(Model model) throws Exception {
		// 데이터베이스 연결 -> 스프링에서는 JdbcTemplate가 담당
		// 질의할 쿼리 만들기 -> SQL 작성
		// 질의문 데이터베이스로 전송 -> JdbcTemplate을 사용한 query메소드 실행
		// 결과값 가져오기 -> 만약 레코드셋이 있다면 mapRow 객체 사용
		// 템플릿에 결과값 전달 -> model.addAttribute() 이용 뷰템플릿으로 전달
		// 템플릿이 화면에 보여줌 -> 템플릿이 루프를 돌며 화면에 결과값 출력
		
		List<Board> list= dao.list();
		model.addAttribute("list", list);
		return "/board/list";
	}
}
