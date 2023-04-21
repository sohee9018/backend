package green.spring.hello_jdbc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	//요청주소 '/'을 루트페이지 또는 시작페이지, 기본페이지
	//인덱스페이지라고 한다. 이름은 index로 시작 확장자는 .html .jsp 확장자가 없을 수도 있음
	public String index() {
		return "/board/list";
	}
	
	//게시판 리스트를 보여달라는 요청
	@RequestMapping(value="/board/list")
	//public String list(Model model){
	//	...
	//	return "board_list"
	//} 밑에와 같은 것
	// 테블릿의 이름을 요청처리 메소드와 같은 이름으로 할 경우
	// 결과값 void 뷰템플릿 이름 지정하지 않음
	public void list(Model model) throws Exception{
//		List<Board> boardlist = boardService.list();
//		model.addAttribute("list", boardlist);
	}
}
