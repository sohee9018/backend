package green.spring.green_bbs;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter     //롬복에서 멤버필드값 읽기 자동생성
@Setter     //롬복에서 멤버필드값 쓰기 자동생성
@ToString   //롬복에서 멤버필드의 값들을 문자열로 만들어 주는 기능
			//문제해결시 큰 도움이 됨
public class Member {
	//id
	private String userId;
	//비밀번호
	private String password;
	//이름
	private String userName;
	//이메일
	private String userEmail;
	//생일
	private LocalDate birthday;
	//주소
	private String address;
}
