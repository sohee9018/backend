package green.spring.hello_jdbc;

public class BoardDAO {
	//현재는 간편하게 하려고 예외처리 생략
//	public List<Board> list() throws Exception {
		//1. 스프링 JdbcTemplate 클래스를 이용함
		//jdbcTemplate에 질의할 쿼리는 등록 저장
		//jdbcTemplate.query(
		//-첫번째 인수 : "SELECT *..." 질의 쿼리 등록, 
		//-두번째 인수 : 질의한 컬럼 구조를 가지는 결과를 담은 레코드들의 집합(=배열 =리스트)
		//			  RowMapper<테이블 컬럼형식과 같은 Board 데이터형> {
		//				 한개의 레코드들이 질의 결과 수만큼 저장됩니다.
		//				 mapRow(질의 결과 집합 클래스, 행번호)
		//			  }
//		List<Board> results = jdbcTemplate.query(
//				"SELECT * FROM Board",
//				new RowMapper<Board>() {
//					@Override
//					punlic Board mapRow(ResultSet rs, int rowNum) throws Exception {
//						Board board = new Board();
//						
//						board.setBoardNo(rs.getInt("board_no"));
//						board.setTitle(rs.getInt("title"));
//						board.setContent(rs.getInt("content"));
//						board.setWriter(rs.getInt("writer"));
//						
//						Timestamp timestamp = rs.getTimestamp("reg_date");
//						board.setRegDate(timestamp.toLocalDateTime());
//						
//						return board;
//					}
//				);
//		return results;
//				
//	}
}

