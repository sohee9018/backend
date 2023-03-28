package green.spring.green_bbs;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. /book으로 요청하면 책정보를 응답 출력하세요
// <요구사항>
// 책 개체를 만드세요
// 책 제목 : 점프투스프링부트
// 책 저자 : 박응용
// 책 출판사 : 위키독스
// 책 출간일 : 2022년 3월 25일
// 책 가격 : 25000원
// 위의 정보를 활용하여 책객체를 만드세요

// 출력 :
// 책제목 | 점프투스프링부트
// -------------------
// 저자  | 박응용
// -------------------
// 출간일 | 2022년 3월 25일

@Controller
public class BookController {

	@RequestMapping("/book")
	public String publicBook(Model model) {
		Book book = new Book();
		
		book.setIsbn("1234");
		book.setTitle("점프투스프링부트");
		book.setAuthor("박응용");
		book.setPublisher("위키독스");
		book.setPrice(15000);
		
		LocalDate publishedDate = LocalDate.of(2022, 3, 25);
		book.setPublishedDate(publishedDate);
		
		model.addAttribute("book", book);
		
		return "public_Book";
	
	}
	
}