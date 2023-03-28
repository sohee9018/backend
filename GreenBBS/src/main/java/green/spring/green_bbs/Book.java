package green.spring.green_bbs;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {

	//책 고유식별번호
	private String isbn;
	
	//책이름
	private String title;
	
	//책저자
	private String author;
	
	//출판사
	private String publisher;
	
	//책정가
	private int price;
	
	//책 출간날짜
	private LocalDate publishedDate;
}
