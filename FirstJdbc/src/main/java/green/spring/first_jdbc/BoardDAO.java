package green.spring.first_jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

// 데이터베이스와 연결하여 데이터 처리기능을 구현하는 클래스
// DAO(= Date Access Object)
// 또는 저장소(Repository)라고 부릅니다.
// 저장소 클래스는 반드시 @Repository 애너테이션을 붙이고 시작합니다.

@RequiredArgsConstructor
// jdbcTemplate 객체를 생성하는데 필요한 인수들을 사용하여 자동으로 생성하시오.
// 스프링이 필요할 때 자동으로 만들어 준다. => 스프링에 의존하여 필요한 값을 대입한다.(=주입한다.)
// 의존성 주입(Dependency Injection = DI)

@Repository
public class BoardDAO {
	// 데이터베이스 연결 : 스프링에서는 jdbcTemplate가 담당
	private final JdbcTemplate jdbcTemplate;
	
	// 질의할 쿼리 만들기 : SQL작성
	// 질의문 데이터베이스로 전송 : jdbcTemplate을 사용한 query 메소드 실행
	// 결과값 가져오기 : 만약 레코드셋이 있다면 mapRow 객체 사용
	// 현재 리스트함수는 다음 질의문 사용 =
	// SELECT board_no, title, content, writer, reg_date
	// FROM board
	// WHERE board_no > 0
	// ORDER BY board_no desc, reg_date DESC
	// 데이터베이스로 보내면 위 질의문의 결과(=레코드셋)를 우리에게 보내준다.
	// 레코드셋은 레코드의 배열(=리스트) 결과
	// 데이터베이스는 항상 에러 염두 둘 것
	public List<Board> list() throws Exception{
		String listSql = "SELECT" +
				"board_no, title, content, writer, reg_date " + 
				"FROM board " +
				"WHERE board_no > 0 " +
				"ORDER BY board_no desc, reg_date DESC";
		List<Board> results = jdbcTemplate.query(
				listSql,
		        // RowMapper라는 레코드를 만들어주는 객체가 온다.
				new RowMapper<Board>() {
					
					@Override
					public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
						Board board = new Board();
						
						board.setBoardNo(rs.getInt("board_no"));
						board.setTitle(rs.getString("title"));
						board.setContent(rs.getString("content"));
						board.setWriter(rs.getString("writer"));
						
						Timestamp timestamp = rs.getTimestamp("reg_date");
						board.setRegDate(timestamp.toLocalDateTime());
						
						return board;
					}
				});
		
		return results;
	}
}
