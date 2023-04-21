package green.spring.hello_jdbc;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Board {
	// 게시글 번호
	private int boardNo;
	
	// 글제목
	private String title;
	
	// 글내용
	private String content;
	
	// 글쓴이
	private String writer;
	
	// 글작성 날짜
	private LocalDateTime regDate;
}
